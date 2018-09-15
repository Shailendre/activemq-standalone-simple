package info.lazycompiler.standaloneactivemqsimple.consumer;

import info.lazycompiler.standaloneactivemqsimple.model.Person;
import info.lazycompiler.standaloneactivemqsimple.model.PersonAddress;
import info.lazycompiler.standaloneactivemqsimple.service.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
@Slf4j
public class PersonConsumer {

    @Autowired
    private ProducerService producerService;

    @Autowired
    @Qualifier("address-queue")
    private Queue addressQ;



    @JmsListener(destination = "person-topic")
    public void consumeMessage(Person person) {

        log.info("Person object received, {}", person);

        // not required
        if (person != null){

            log.info("Publishing to PersonAddress topic.");
            producerService.sendObject(convertToPersonAddress(person), addressQ);
        }

    }



    private PersonAddress convertToPersonAddress(Person person){

        return new PersonAddress(person.getAddress());

    }




}
