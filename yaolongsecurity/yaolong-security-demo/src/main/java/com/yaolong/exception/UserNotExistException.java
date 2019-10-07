package com.yaolong.exception;

/**
 * @author yaoLong
 * @date 2019/10/6  15:15
 * 自定义异常
 */
public class UserNotExistException extends RuntimeException {

    private String id;

    public UserNotExistException(String id){

        super("users not exist");

        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
