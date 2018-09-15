package info.lazycompiler.standaloneactivemqsimple.consumer;

import info.lazycompiler.standaloneactivemqsimple.model.PersonAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PersonAddressConsumer {

    @JmsListener(destination = "address-topic")
    public void consumeMessage(PersonAddress personAddress){

        log.info("PersonAddress received, {}", personAddress);

    }



}
