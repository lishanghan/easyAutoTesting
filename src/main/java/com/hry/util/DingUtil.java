package com.hry.util;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hry.config.DingProperty;
import com.hry.config.ZdyProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author lish
 * @date 2020/11/5 15:50
 * @description:TODO
 * @since 1.8
 */
@Slf4j
public class DingUtil {
    @Autowired
    DingProperty dingProperty;

    /**
     * 使用钉钉机器人给指定钉钉群发送定制测试报告
     *
     *@param  reportURL:测试报告地址
     * */
    public void sendDingReprot(String reportURL){


        try {
            //钉钉机器人地址（配置机器人的webhook）
            // https://oapi.dingtalk.com/robot/send?access_token=91778ffe7bae70f49321eb63e59d1cea1a4670a71249cae5c8314ff86af48c8a
            //String dingUrl = "https://oapi.dingtalk.com/robot/send?access_token=91778ffe7bae70f49321eb63e59d1cea1a4670a71249cae5c8314ff86af48c8a";
            String dingUrl = dingProperty.getDingUrl();
            log.info("dingURL="+dingUrl);

            //是否通知所有人
            //boolean isAtAll = false;//dingProperty.getAtAll();
            boolean isAtAll = dingProperty.getAtAll();
            log.info("isAtAll = "+isAtAll);

            //String mobile = dingProperty.getMobileList();
            //通知@具体人的手机号码列表
            List<String> mobileList = Lists.newArrayList();
            mobileList.add("15201891817");
            //List<String> mobileList = Lists.newArrayList(Arrays.asList(mobile.split(",")));
            //mobileList = Arrays.asList(mobile.split(","));

            //钉钉机器人消息内容
            //String content = "接口自动化测试报告地址：" +reportURL;
            String content = dingProperty.getContent() + "：" +reportURL;
            //组装请求内容
            String reqStr = buildReqStr(content, isAtAll, mobileList);

            //推送消息（http请求）
            String result = HttpUtil.post(dingUrl, reqStr);

            log.info("钉钉发送测试报告结果：" + result);

        }catch (Exception e){
            e.printStackTrace();

        }




    }

    /**
     * 组装请求报文
     * @param content
     * @return
     */
    public  String buildReqStr(String content, boolean isAtAll, List<String> mobileList) {
        //消息内容
        Map<String, String> contentMap = Maps.newHashMap();
        contentMap.put("content", content);

        //通知人
        Map<String, Object> atMap = Maps.newHashMap();
        //1.是否通知所有人
        atMap.put("isAtAll", isAtAll);
        //2.通知具体人的手机号码列表
        atMap.put("atMobiles", mobileList);

        Map<String, Object> reqMap = Maps.newHashMap();
        reqMap.put("msgtype", "text");
        reqMap.put("text", contentMap);
        reqMap.put("at", atMap);

        return JSON.toJSONString(reqMap);
    }



}
