package com.yaolong.security.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yaoLong
 * @date 2019/10/12  20:23
 */
@ConfigurationProperties(prefix ="yaolong.security" )
public class SecurityProperties {
    private BrowserProperties browserProperties = new BrowserProperties();

    public void setBrowserProperties(BrowserProperties browserProperties) {
        this.browserProperties = browserProperties;
    }

    public BrowserProperties getBrowserProperties() {
        return browserProperties;
    }
}
