package info.lazycompiler.standaloneactivemqsimple.producer;

import info.lazycompiler.standaloneactivemqsimple.model.Person;
import info.lazycompiler.standaloneactivemqsimple.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequestMapping("/producer")
public class Producer {

    @Autowired
    private ProducerService producerService;

    @Autowired
    @Qualifier("person-queue")
    private Queue personQ;



    @RequestMapping(value = "/person", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void publishPerson(@RequestBody Person person) { ;
        producerService.sendObject(person, personQ);

    }

}
