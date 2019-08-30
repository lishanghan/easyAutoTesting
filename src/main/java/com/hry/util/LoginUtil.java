package com.hry.util;

import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.builder.HCB;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpMethods;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.hry.anno.SKey;
import com.hry.config.SpringContextHolder;
import com.hry.config.ZdyProperty;
import com.hry.enums.ContentTypeEnum;
import com.hry.po.*;
import com.hry.service.TcaseService;
import com.hry.service.TiService;
import com.hry.testng.base.Base;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.cookie.SetCookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;
import org.testng.Reporter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/9/3 16:20
 */
@Slf4j
public class LoginUtil {
    private static UnionLoginConfig unionLoginConfig = SpringContextHolder.getBean(UnionLoginConfig.class);

    public static <T extends Base> void loginInit(T entity) {
        String sKey = entity.getClass().getAnnotation(SKey.class).value();
        if ("Zhuanle".equalsIgnoreCase(sKey)) {
            zhuanleLogin(entity, "/sign-in");
            return;
        }
        if ("Xindaiyy".equalsIgnoreCase(sKey)) {
            unionLogin(entity, "cbp");
            return;
        }
        /*if ("Gateway".equalsIgnoreCase(sKey)){
            gatewayLogin(entity,"/user/unsecretlogin");
        }*/
    }



    /**
     * gateway 登陆
     * */
   /* public static <T extends Base> void gatewayLogin(T entity, String iUri) {


        Tservicedetail tservicedetail = entity.tservicedetail;
        TiService tiService = SpringContextHolder.getBean(TiService.class);
        Ti tiCondition = new Ti();
        tiCondition.setServiceid(tservicedetail.getServiceid());
        tiCondition.setIuri(iUri);
        List<Ti> tis = tiService.selectByCondition(tiCondition);

        //判断不是登陆接口才执行
        Ti ti = null;
        for (Ti i : tis) {
            System.out.println("对比结果=" + i.getIuri().equals(iUri));
            if (i.getIuri().equals(iUri) == true) {
                System.out.println("接口地址=" + i.getIuri());

                String url = "http://192.168.52.26:8000/mmp/user/unsecretlogin";
                HttpMethods methodType = HttpMethods.POST;
                Header header = new BasicHeader("Content-Type", "application/json");
                Header[] requestHeaders = null;
                requestHeaders = ArrayUtils.add(requestHeaders, header);
                String param = "{\n" +
                        "  \"brokerCode\": \"18836\",\n" +
                        "  \"deviceId\": \"1123123123132132\",\n" +
                        "  \"fullName\": \"刘杰\",\n" +
                        "  \"password\": \"1234.com\",\n" +
                        "  \"username\": \"Liujie\"\n" +
                        "}";

                HCB hcb = null;
                try {
                    hcb = HCB.custom()
                            .pool(100, 10)
                            .timeout(30 * 1000, false);//30秒超时设置,阻止自动重定向
                    HttpClient client = hcb.build();
                    HttpConfig config = HttpConfig
                            .custom()
                            .url(url)
                            .encoding("utf-8")
                            .method(methodType)
                            .headers(requestHeaders)
                            .client(client);
                    config.json(param);
                    String responseEntity =HttpClientUtil.send(config);
                    Header[] resHeaders = config.headers();
                    for (Header h : resHeaders) {
                        System.out.println("进来了！");
                        System.out.println("Set-Coolie:" + h);

                    *//*if (h.getName().equals("Set-Cookie")) {
                        System.out.println("进来了！");
                        System.out.println("Set-Coolie:" + h);
                        HeaderElement[] elements = h.getElements();
                        String name = elements[0].getName();
                        String value = elements[0].getValue();
                        System.out.println("response-cookie的name:" + name + ",value:" + value);
                        SetCookie cookie = new BasicClientCookie(name, value);
                        *//**//*cookie.setDomain(domain);
                        cookie.setPath("/");*//**//*

                        CookieStore cookieStor = new BasicCookieStore();
                        cookieStor.addCookie(cookie);

                        System.out.println("cookieStore:" + cookieStor);
                        entity.cookieStore = cookieStor;
                    }*//*


                    }
                } catch (HttpProcessException e) {
                    e.printStackTrace();
                }

            }



        }
    }*/

    /**
     * zhuanle 登录
     */
    public static <T extends Base> void zhuanleLogin(T entity, String iUri) {
        Tservice tservice = entity.tservice;
        Tservicedetail tservicedetail = entity.tservicedetail;
        TiService tiService = SpringContextHolder.getBean(TiService.class);
        TcaseService tcaseService = SpringContextHolder.getBean(TcaseService.class);

        Ti tiCondition = new Ti();
        tiCondition.setServiceid(tservicedetail.getServiceid());
        tiCondition.setIuri(iUri);
        List<Ti> tis = tiService.selectByCondition(tiCondition);

        //找到登录接口
        Ti ti = null;
        for (Ti i : tis) {
            if (i.getIuri().equals(iUri)) {
                ti = i;
                break;
            }
        }

        if (ti == null) {
            log.error("zhuanle登录失败,未找到登录接口");
            return;
        }

        Tcase tcaseCondition = new Tcase();
        tcaseCondition.setEnvid(tservicedetail.getEnvid());
        tcaseCondition.setIid(ti.getId());
        List<Tcase> tcases = tcaseService.selectByCondition(tcaseCondition);

        if (tcases.size() == 0) {
            log.error("未找到Case,查询条件iid=" + tcaseCondition.getIid() + ",envId=" + tcaseCondition.getEnvid());
            return;
        }

        //找到相应环境的登录case
        Tcase tcase = null;
        for (Tcase c : tcases) {
            if (c.getEnvid().equals(tservicedetail.getEnvid())) {
                tcase = c;
                break;
            }
        }
        if (tcase == null) {
            log.error("");
            return;
        }

        HryTest test = new HryTest();
        test.setTservice(tservice);
        test.setTservicedetail(tservicedetail);
        test.setTi(ti);
        test.setTcase(tcase);
        String zhuanleLoginRes = HryHttpClientUtil.send(test, null);

        //将返回结果转换为JSON对象
        JSONObject jsonObject = JSONUtil.str2JSONObj(zhuanleLoginRes);

        if (jsonObject != null) {
            try {
                String auth = jsonObject.getJSONObject("body").getString("auth");
                Header header = new BasicHeader("X-KJT-Auth", auth);
                entity.headers = ArrayUtils.add(entity.headers, header);
            } catch (Exception e) {
                Reporter.log(e.getMessage());
                log.error("登录返回结果中寻找auth发生异常");
            }
        } else {
            log.error("zhuanle登录失败,环境=" + tservicedetail.getEnvid());
            Reporter.log("zhuanle登录失败,环境=" + tservicedetail.getEnvid());
        }
    }

    /**
     * 联合登录 ,如果未传入sysCode,默认登录cbp-信贷系统
     */
    public static <T extends Base> void unionLogin(T entity, String sysCode) {
        Reporter.log(unionLoginConfig.toString());
        Tservicedetail tservicedetail = entity.tservicedetail;
        List<LoginInfoDetail> loginInfoDetails = unionLoginConfig.getLoginInfoDetails();
        //根据环境确定使用哪个登录配置信息
        LoginInfoDetail lid = null;
        for (LoginInfoDetail loginInfoDetail : loginInfoDetails) {
            if (tservicedetail.getEnvid().equals(loginInfoDetail.getEnvId())) {
                lid = loginInfoDetail;
                break;
            }
        }
        if (lid == null) {
            return;
        }

        Header headerContentType = new BasicHeader("Content-Type", "application/x-www-form-urlencoded");
        Header headerCookie = new BasicHeader("Cookie", "__login_name=supper2; __login_expied=7; __login_sys=" + (sysCode == null ? "cbp" : sysCode));
        String requestId = UUID.randomUUID().toString().replaceAll("-", "");

        Map<String, Object> map = new HashMap<>();
        map.put("loginName", lid.getUsername());
        map.put("password", lid.getPassword());
        map.put("dynamicCode", "");
        map.put("requestId", requestId);
        map.put("sysCode", sysCode == null ? "cbp" : sysCode);
        Header[] headers = new Header[]{headerContentType, headerCookie};
        HttpConfig config = HttpConfig.custom().url(lid.getUrl()).headers(headers, true).map(map).encoding("utf-8");

        try {
            HttpClientUtil.post(config);
        } catch (HttpProcessException e) {
            log.error("Xindaiyy请求登录接口异常:", e);
        }

        String hostinfo = tservicedetail.getHostinfo();
        String domain;

        if (hostinfo.contains(":")) {
            domain = hostinfo.substring(0, hostinfo.indexOf(":"));
        } /*else if (hostinfo.contains("/")) {
            domain = hostinfo.substring(0, hostinfo.indexOf("/"));
        }*/ else {
            domain = hostinfo;
        }
        CookieStore cookieStore = null;
        Header[] resHeaders = config.headers();
        for (Header header : resHeaders) {
            if (header.getName().equals("Set-Cookie")) {
                HeaderElement[] elements = header.getElements();
                String name = elements[0].getName();
                String value = elements[0].getValue();
                SetCookie cookie = new BasicClientCookie(name, value);
                cookie.setDomain(domain);
                cookie.setPath("/");
                cookieStore = new BasicCookieStore();
                cookieStore.addCookie(cookie);
                break;
            }
        }

        if (cookieStore == null) {
            log.error("联合登录失败");
            return;
        }
        log.info("cbp联合登录成功!");
        //设置登录cookie到测试类中,后续测试类执行测试时将会优先检查cookie
        entity.cookieStore = cookieStore;
    }
}
