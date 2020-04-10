package com.stu.mail.mq.consumer;

import com.rabbitmq.client.Channel;
import com.stu.mail.exception.ServiceException;
import com.stu.mail.mq.BaseConsumer;
import com.stu.mail.mq.MessageHelper;
import com.stu.mail.util.MailUtil;
import com.stu.mail.pojo.Mail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MailConsumer implements BaseConsumer {

    @Autowired
    private MailUtil mailUtil;

    public void consume(Message message, Channel channel) {
        Mail mail = MessageHelper.msgToObj(message, Mail.class);
        log.info("收到消息: {}", mail.toString());

        boolean success = mailUtil.send(mail);
        if (!success) {
            throw new ServiceException("send mail error");
        }
    }

}
