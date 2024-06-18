package com.leejie.listener;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author leejie
 * @Date 2024/6/5 17:16
 * @Description TODO
 **/
@Slf4j
@Component
@RocketMQMessageListener(topic = "test-01-topic", consumerGroup = "${rocketmq.consumer.group}", messageModel = MessageModel.CLUSTERING)
public class RocketMQConsumerListener implements RocketMQListener<Message> {

    @Override
    public void onMessage(Message s) {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer();
        //最大重试次数
        consumer.setMaxReconsumeTimes(3);
        //重试间隔时间
        consumer.setSuspendCurrentQueueTimeMillis(10000);

        log.info("接收到消息：{}, 时间：{}, msgId: {}", new String(s.getBody()), DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"),
                s.getKeys());
    }

}
