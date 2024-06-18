package com.leejie.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQReplyListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author leejie
 * @Date 2024/6/6 11:21
 * @Description TODO
 **/
@Slf4j
@Component
@RocketMQMessageListener(topic = "test-05-topic", consumerGroup = "${rocketmq.consumer.group}", replyTimeout = 1000)
public class RocketMQConsumerReplyListener implements RocketMQReplyListener<MessageExt, String> {

    @Override
    public String onMessage(MessageExt message) {
        // 处理接收到的消息
        String receivedMsg = new String(message.getBody());
        log.info("consumerTime:{} Received message: {}, msgId: {}", new Date(), receivedMsg, message.getMsgId());
        return "Reply to: " + receivedMsg;
    }



}
