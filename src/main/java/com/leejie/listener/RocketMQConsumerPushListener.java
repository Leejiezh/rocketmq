package com.leejie.listener;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;

/**
 * @Author leejie
 * @Date 2024/6/7 18:25
 * @Description TODO
 **/
public class RocketMQConsumerPushListener implements RocketMQPushConsumerLifecycleListener {
    @Override
    public void prepareStart(DefaultMQPushConsumer consumer) {

    }
}
