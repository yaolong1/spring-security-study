package com.yaolong.web.asyns;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;


/**
 * @author yaoLong
 * @date 2019/10/8  14:39
 */
@RestController
public class AsyncController {

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/order")
    public DeferredResult<String> order(){

        logger.info("主线程开始");

        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);

        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber, result);


        logger.info("主线程返回");
//        Callable<String> result = new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                logger.info("副线程开始");
//                Thread.sleep(1000);
//                logger.info("副线程返回");
//                return "success";
//            }
//        };

        return result;
    }


}
