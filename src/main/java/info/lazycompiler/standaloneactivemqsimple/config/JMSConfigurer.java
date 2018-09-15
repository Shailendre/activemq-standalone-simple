package info.lazycompiler.standaloneactivemqsimple.config;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

/**
 * Intention is to create 2 topic.
 * Through 1 topic: person-topic, we shall be sending person details.
 * PersonConsumer consumes and publishes only address to 2nd topic: address-topic
 * Finally 2nd consumer consumes (logs the address of the person)
 */

@Configuration
@EnableJms
public class JMSConfigurer {

    @Value("${local-active-mq-broker}")
    private String brokerUrl;


    @Bean(name = "person-queue")
    public Queue personNameQ() {
        return new ActiveMQQueue("person-topic");
    }

    @Bean(name = "address-queue")
    public Queue addressQ() {
        return new ActiveMQQueue("address-topic");
    }

    @Bean
    public ActiveMQConnectionFactory mqConnectionFactory() {
        ActiveMQConnectionFactory mqConnectionFactory = new ActiveMQConnectionFactory(brokerUrl);
        mqConnectionFactory.setTrustAllPackages(true);
        return mqConnectionFactory;
    }

    @Bean
    public JmsTemplate template() {
        return new JmsTemplate(mqConnectionFactory());
    }


}
