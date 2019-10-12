package com.yaolong.security.properties;

/**
 * @author yaoLong
 * @date 2019/10/12  20:23
 */
public class BrowserProperties {

    private String loginPage = "/imooc-signIn.html";

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public String getLoginPage() {
        return loginPage;
    }
}
