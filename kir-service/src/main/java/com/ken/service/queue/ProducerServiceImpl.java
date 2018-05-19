package com.ken.service.queue;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Queue;
import javax.jms.Topic;

// 注册为 Dubbo 服务
@Service(version = "1.0.0")
public class ProducerServiceImpl implements ProducerService {


    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;


    @Override
    public void producerMessage(String content) {
        this.jmsMessagingTemplate.convertAndSend(this.queue,content);
    }

}
