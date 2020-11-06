package com.hry.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


/**
 * @author lish
 * @date 2020/11/5 9:22
 * @description:钉钉机器人配置获取
 * @since 1.8
 */
@Configuration
public class DingProperty {

    @Value("${ding.dingUrl}")
    private String dingUrl;

    @Value("${ding.content}")
    private String content;

    @Value("${ding.isAtAll}")
    private Boolean isAtAll;

    @Value("${ding.mobileList}")
    private String mobileList;

    public String getDingUrl() {
        return dingUrl;
    }

    public void setDingUrl(String dingUrl) {
        this.dingUrl = dingUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getAtAll() {
        return isAtAll;
    }

    public void setAtAll(Boolean atAll) {
        isAtAll = atAll;
    }

    public String getMobileList() {
        return mobileList;
    }

    public void setMobileList(String mobileList) {
        this.mobileList = mobileList;
    }
}
