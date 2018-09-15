package info.lazycompiler.standaloneactivemqsimple.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

@Service
@Slf4j
public class ProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    public <T> void sendObject(T object, Destination topic) {
        try {
            jmsTemplate.convertAndSend(topic, object);
            log.info("Object sent, {}", object);
        }catch (JmsException e){
            log.error("Could not send the object.\n {}", e.getMessage());
        }
    }


}
