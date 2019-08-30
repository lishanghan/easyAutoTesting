package com.hry.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.builder.HCB;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpMethods;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.hry.config.SpringContextHolder;
import com.hry.config.ZdyProperty;
import com.hry.enums.*;
import com.hry.exception.HryException;
import com.hry.po.HryTest;
import com.hry.testng.base.Base;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.SetCookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.testng.Reporter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description: 封装httpClientUtil
 * @Author: luqiwei
 * @Date: 2018/5/19 11:03
 */
@Slf4j
public class HryHttpClientUtil {
    private static Boolean debugFlag;

    private static HCB hcb;

    private static String gatewayCookie;

    static {
        ZdyProperty bean = SpringContextHolder.getBean(ZdyProperty.class);
        debugFlag = bean.getDebug();
        try {
            hcb = HCB.custom()
                    .pool(100, 10)
                    .timeout(30 * 1000, false);//30秒超时设置,阻止自动重定向
        } catch (HttpProcessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 最底层的封装方法
     *
     * @return
     */
    public static String send(String url, Integer requestMethodType, Integer contentType, Integer requestParamType, String param, Header[] headers, CookieStore cookieStore) {
        //请求方式,现在仅支持Post/Get
        HttpMethods methodType;
        if (RequestMethodTypeEnum.getValue(requestMethodType) != null) {
            if (requestMethodType.equals(RequestMethodTypeEnum.POST.getId())) {
                methodType = HttpMethods.POST;
            } else {
                methodType = HttpMethods.GET;
            }
        } else {//缺省时,请求方式为GET
            methodType = HttpMethods.GET;
        }


        //请求Header
        Header contentTypeHeader;
        if (ContentTypeEnum.getValue(contentType) != null) {
            contentTypeHeader = new BasicHeader("Content-Type", ContentTypeEnum.getValue(contentType));
        } else {//如果不指明ContentType类型,默认按照浏览器请求处理
            contentTypeHeader = new BasicHeader("Content-Type", ContentTypeEnum.X_WWW_FORM_URLENCODED.getValue());
        }

        Header[] requestHeaders = headers;
        if (HttpMethods.POST.equals(methodType)) {//如果是Post请求,则标识Content-Type,如果是Get请求,则不需要标识ContentType
            requestHeaders = ArrayUtils.add(headers, contentTypeHeader);
        } else if (HttpMethods.GET.equals(methodType)) {
            /**
             * 如果是get请求,并且param符合json格式,则将把param拼接到url后面
             */
            JSONObject p = JSONUtil.str2JSONObj(param);
            String urlParam = null;
            if (p != null) {
                for (String s : p.keySet()) {
                    String pValue = p.getString(s);
                    if (StringUtils.isNotBlank(pValue)) {
                        urlParam += "&" + s + "=" + pValue;
                    }
                }
            }
            if (urlParam != null) {
                if (url.contains("?")) {
                    url += urlParam;
                } else {
                    url += "?" + urlParam.substring(1);
                }
            }
        }

        //HryCookie
        //HttpClientContext context = null;
        HttpClientContext context = new HttpClientContext();
        if (cookieStore != null) {
            //context = new HttpClientContext();
            context.setCookieStore(cookieStore);
        }

        HttpClient client = hcb.build();

       /* log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.info("hcb对象:" + hcb.hashCode());
        log.info("client对象:" + client.hashCode());
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");*/
        HttpConfig config = HttpConfig
                .custom()
                .url(url)
                .encoding("utf-8")
                .method(methodType)
                .headers(requestHeaders, true)
                .client(client);

        if (context != null) {
            config.context(context);
        }

        //设置请求参数
        if (StringUtils.isNotBlank(param) && requestParamType != null) {
            if (requestParamType.equals(RequestParamTypeEnum.JSON.getId())) {
                config.json(param);
            } else if (requestParamType.equals(RequestParamTypeEnum.MAP.getId())) {
                Map map = JSON.parseObject(param, Feature.OrderedField).toJavaObject(Map.class);
                config.map(map);
            }
        }

        //发送请求
        String responseEntity = null;
        long startTime = System.currentTimeMillis();
        try {
            responseEntity = HttpClientUtil.send(config);

            Header[] resHeaders = config.headers();
            for (Header h : resHeaders) {

                if (url.contains("/user/unsecretlogin") && h.getName().equalsIgnoreCase("Set-Cookie")) {
                    HeaderElement[] elements = h.getElements();
                    String name = elements[0].getName();
                    String value = elements[0].getValue();
                    Map<String,String> map = new HashMap<String,String>();
                    map.put("Cookie",name+"="+value);
                    gatewayCookie = JSONObject.toJSONString(map);

                }

                //如果返回Headers中存在 location,则认为是重定向,将location的值返回
                if (h.getName().equalsIgnoreCase("location")) {
                    if (StringUtils.isBlank(responseEntity)) {
                         responseEntity = h.getValue();
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("location", responseEntity);
                        responseEntity = jsonObject.toJSONString();
                    }
                    break;
                }
            }

        } catch (HttpProcessException e) {
            log.error("", e);
            responseEntity = e.getMessage();
        }
        long endTime = System.currentTimeMillis();

        //打印日志

        Reporter.log("实际请求参数:" + param);
        log.info("实际请求参数:" + param);
        log.info("请求Url:" + config.url());
        Reporter.log("请求Url:" + config.url());
        log.info("请求方式:" + config.method().getName());
        Reporter.log("请求方式:" + config.method().getName());

        if (headers != null && headers.length > 0) {
            log.info("请求Headers:");
            Reporter.log("请求Headers:");
            for (Header h : headers) {
                log.info("  " + h.getName() + ":" + h.getValue());
                Reporter.log("  " + h.getName() + ":" + h.getValue());
            }
        }
        log.info("请求耗时(s):" + (endTime - startTime) / 1000d);
        Reporter.log("请求耗时(s):" + (endTime - startTime) / 1000d);
        log.info("响应实体:" + responseEntity);

        return responseEntity;
    }


    public static <T extends Base> String send(HryTest test, T entity) {
        String responseBody="";
        if (debugFlag) {
            log.info(test.getTservice().getServicekey() + "(" + test.getTservice().getId() + ")");
            log.info(test.getTi().getIuri() + "(" + test.getTi().getId() + ")");
            log.info(test.getTcase().getCasename() + "(" + test.getTcase().getId() + ")");
            log.info("------------------------------------------------------");
            return "";
        }

        //是否虚拟接口标记,如果为虚拟接口,将只执行
        Boolean virtualInterfaceFlag = false;
        if (test.getTi().getIuri().matches(RegexEnum.VIRTUAL_INTERFACE.getRegex())) {
            virtualInterfaceFlag = true;
        }

        /**
         * 接口测试开始
         */
        log.info("");
        log.info("+++++++++++++++++++++++++++++++++++++");
        log.info("开始测试接口:" + test.getTi().getIuri());
        log.info("接口所属服务:" + test.getTservice().getServicekey());
        log.info("使用测试用例:" + test.getTcase().getId());

        /**
         * 前置处理
         */
        log.info("---1.前置处理-开始");
        String param = ReplaceUtil.replaceBefore(test.getTcase().getRequestparam(), test.getTservicedetail().getDbinfo(), entity);
        log.info("---1.前置处理-结束");
        log.info("---2.发送请求-开始");
        //如果是虚拟接口,则只进行前置处理,不会发送http请求和后置处理
        if (virtualInterfaceFlag) {
            Reporter.log("实际请求参数:" + param);
            return "虚拟接口前置处理成功";
        }

        //判断contentType
        Integer contentTypeId = test.getTi().getIcontenttype();
        String contentType = ContentTypeEnum.getValue(contentTypeId);
        if(contentType.equals("application/json")){

            /**
             * josn数据格式
             * 发送http请求
             */
            String url = HttpTypeEnum.getValue(test.getTservice().getHttptype()) + "://" + test.getTservicedetail().getHostinfo() + test.getTi().getIuri();
            //处理请求headers
            Map<String, String> requestHeaderMap = getHeadersFromCase(test);
            Map<String, String> entityHeaderMap = getHeadersFromEntity(entity);
            Header[] requestHeaders = mergeHeaders(requestHeaderMap, entityHeaderMap);

            responseBody = send(
                    url,
                    test.getTi().getIrequestmethod(),
                    test.getTi().getIcontenttype(),
                    test.getTi().getIparamtype(),
                    param,
                    requestHeaders,
                    entity == null ? null : entity.cookieStore
            );
            // 发送soap xml格式数据
        }else if(contentType.equals("text/xml")){
            String url = HttpTypeEnum.getValue(test.getTservice().getHttptype()) + "://" + test.getTservicedetail().getHostinfo() + test.getTi().getIuri();
            String soapAction = test.getTi().getSoapAction();
            String xml = param;
            responseBody = soapXmlSend(url,xml,soapAction);

        }

        log.info("---2.发送请求-结束");

        /**
         * 后置处理
         */

        log.info("---3.后置处理-开始");
        ReplaceUtil.replaceAfter(test.getTcase().getCafter(), responseBody, test.getTservicedetail().getDbinfo(), entity);
        log.info("---3.后置处理-结束");
        return responseBody;

    }

    public static Header[] mergeHeaders(Map<String, String> requestHeaderMap, Map<String, String> entityHeaderMap) {
        //合并header,如果requestHeader中的值为null,则尝试从entityHeader中取相应的值
        Map<String, String> finalHeaderMap = new HashMap<>();
        if (requestHeaderMap != null) {
            if (entityHeaderMap != null) {
                for (String requestHeaderKey : requestHeaderMap.keySet()) {
                    if (requestHeaderMap.get(requestHeaderKey) == null && entityHeaderMap.get(requestHeaderKey) != null) {//requestHeaderValue为null时,才尝试从Entity中取值
                        finalHeaderMap.put(requestHeaderKey, entityHeaderMap.get(requestHeaderKey));
                        continue;
                    }
                    //如果requestHeaderValue不为null,或者虽然为null,但是在entity中也找不到同名的非null value,则保留原Header
                    finalHeaderMap.put(requestHeaderKey, requestHeaderMap.get(requestHeaderKey));
                }
            } else {
                finalHeaderMap = requestHeaderMap;
            }
        }
        //合并用例中的Header和测试类中的Header
        Header[] requestHeaders = null;
        for (Map.Entry<String, String> entry : finalHeaderMap.entrySet()) {
            requestHeaders = ArrayUtils.add(requestHeaders, new BasicHeader(entry.getKey(), entry.getValue()));
        }
        return requestHeaders;
    }

    public static <T extends Base> Map<String, String> getHeadersFromEntity(T entity) {
        //获取测试对象中的Header和Cookie
        Map<String, String> entityHeaderMap = null;
        if (entity != null) {
            Header[] entityHeaders = entity.headers;
            if (entityHeaders != null && entityHeaders.length > 0) {
                entityHeaderMap = Arrays.stream(entityHeaders).collect(Collectors.toMap(Header::getName, Header::getValue));
            }
        }
        return entityHeaderMap;
    }

    public static Map<String, String> getHeadersFromCase(HryTest test) {
        Map<String, String> requestHeaderMap = null;
        String serviceKey = test.getTservice().getServicekey();
        String iUri = test.getTi().getIuri();
        if(serviceKey.equalsIgnoreCase("Gateway") && iUri.equalsIgnoreCase("/user/unsecretlogin") == false){
            System.out.println("进来了！");
            JSONObject headerJSON = JSONUtil.str2JSONObj(gatewayCookie);
            if (headerJSON != null && headerJSON.size() > 0) {
                requestHeaderMap = headerJSON.toJavaObject(Map.class);
            }

        }else{
            String headerStr = test.getTcase().getRequestheader();
            if (StringUtils.isNotBlank(headerStr)) {
                JSONObject headerJSON = JSONUtil.str2JSONObj(headerStr);
                if (headerJSON != null && headerJSON.size() > 0) {
                    requestHeaderMap = headerJSON.toJavaObject(Map.class);
                }
            }
        }

        return requestHeaderMap;
    }

    public static <T> String send(String url, Integer requestMethod, T param) throws HttpProcessException {

        HttpConfig httpConfig;
        if (Objects.isNull(param)) {//参数为null,则不带参发送请求
            httpConfig = HttpConfig.custom().url(url).encoding("utf-8");
        } else if (param instanceof JSONObject) {//参数为json类型,发起json请求

            Header header = new BasicHeader("Content-Type", "application/json;charset=utf-8");
            Header[] headers = {header};
            JSONObject jsonObject = (JSONObject) param;

            httpConfig = HttpConfig.custom().url(url).encoding("utf-8").json(JSONObject.toJSONString(jsonObject));
            httpConfig.headers(headers);

        } else if (param instanceof Map) {//参数为map类型
            Map map = (Map) param;
            httpConfig = HttpConfig.custom().url(url).encoding("utf-8").map(map);
        } else {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "http请求无法发送,暂时只支持Json格式的参数");
        }
        if (requestMethod == RequestMethodTypeEnum.GET.getId()) {
            return HttpClientUtil.get(httpConfig);
        } else {
            return HttpClientUtil.post(httpConfig);
        }
    }

    public static String send(String url, Integer requestMethodType, Integer contentType, Integer requestParamType, String param) {
        return send(url, requestMethodType, contentType, requestParamType, param, null, null);
    }

    public static String get(String url) {
        return send(url, RequestMethodTypeEnum.GET.getId(), null, null, null);
    }


    /**
     * 使用SOAP1.1发送消息
     *
     * @param postUrl 请求URL
     * @param soapXml 请求参数
     * @param soapAction 请求方法
     * @return
     */
    public static String soapXmlSend(String postUrl, String soapXml, String soapAction) {
        int socketTimeout = 30000;// 请求超时时间
        int connectTimeout = 30000;// 传输超时时间
        String retStr = "";
        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost(postUrl);
        // 设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(socketTimeout)
                .setConnectTimeout(connectTimeout).build();
        httpPost.setConfig(requestConfig);
        try {
            httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");
            httpPost.setHeader("SOAPAction", soapAction);
            StringEntity data = new StringEntity(soapXml,
                    Charset.forName("UTF-8"));
            httpPost.setEntity(data);
            long startTime = System.currentTimeMillis();
            CloseableHttpResponse response = closeableHttpClient
                    .execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            long endTime = System.currentTimeMillis();

            if (httpEntity != null) {
                // 转化响应实体为String
                retStr = EntityUtils.toString(httpEntity, "UTF-8");

            }

            //打印日志
            log.info("实际请求参数:" + soapXml);
            if(soapXml.contains("<") || soapXml.contains(">")){
                soapXml = soapXml.replaceAll("<","＜").replaceAll(">","＞");
            }
            Reporter.log("实际请求参数:" + soapXml);
            log.info("请求Url:" + postUrl);
            Reporter.log("请求Url:" + postUrl);
            log.info("请求方式:" + "");
            Reporter.log("请求方式:" + "");
            log.info("请求耗时(s):" + (endTime - startTime) / 1000d);
            Reporter.log("请求耗时(s):" + (endTime - startTime) / 1000d);
            log.info("响应实体:" + retStr);
            // 释放资源
            closeableHttpClient.close();
        } catch (Exception e) {
            log.info(""+e);
        }
        return retStr;
    }







}
