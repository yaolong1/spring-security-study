package com.yaolong.web.asyns;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author yaoLong
 * @date 2019/10/8  16:12
 */
@Component
public class MockQueue {

    private String placeOrder;
    private String completeOrder;

    private Logger logger = LoggerFactory.getLogger(getClass());
    public void setPlaceOrder(String placeOrder){
        new Thread(() -> {
            logger.info("接到下单请求, " + placeOrder);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.completeOrder = placeOrder;
            logger.info("下单请求处理完毕," + placeOrder);
        }).start();

    }

    public String getPlaceOrder() {
        return placeOrder;
    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
