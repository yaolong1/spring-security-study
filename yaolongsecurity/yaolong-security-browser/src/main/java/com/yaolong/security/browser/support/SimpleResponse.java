package com.yaolong.security.browser.support;

/**
 * @author yaoLong
 * @date 2019/10/12  20:12
 *
 */

public class SimpleResponse {

    private Object conten;

    public SimpleResponse(Object conten) {
        this.conten = conten;
    }

    public void setConten(Object conten) {
        this.conten = conten;
    }

    public Object getConten() {
        return conten;
    }
}
