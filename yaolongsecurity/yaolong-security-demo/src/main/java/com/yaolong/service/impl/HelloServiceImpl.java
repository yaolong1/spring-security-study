package com.yaolong.service.impl;

import com.yaolong.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author yaoLong
 * @date 2019/10/6  13:45
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void getInfo(String s) {
        System.out.println(s);
    }
}
