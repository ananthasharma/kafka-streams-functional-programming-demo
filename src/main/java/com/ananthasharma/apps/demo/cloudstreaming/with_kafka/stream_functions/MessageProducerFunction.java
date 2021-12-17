package com.ananthasharma.apps.demo.cloudstreaming.with_kafka.stream_functions;

import com.ananthasharma.apps.demo.cloudstreaming.with_kafka.util.Constants;
import com.ananthasharma.apps.demo.cloudstreaming.with_kafka.util.Util;
import com.ananthasharma.demo.schema.io.SendMoneyRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilderFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Supplier;

@Component
@Slf4j
public class MessageProducerFunction extends AbstractProcessorFunction {
    @Autowired
    private MessageBuilderFactory messageBuilderFactory;

    @Value("${"+ Constants.PROP_SEND_DUMMY_MESSAGE+":false}")
    private Boolean sendDummyMessage;

    @Override
    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
        log.info("sendDummyMessages is set to {}", sendDummyMessage);
    }

    /**
     * set property send.dummy-messages to false
     * in cases where we want to use the rest API only and not just keep sending dummy messages over and over
     *
     * otherwise, set send.dummy-messages to true or ignore setting it altogether
     *
     * @return
     */
    @Bean
    @ConditionalOnProperty(name=Constants.PROP_SEND_DUMMY_MESSAGE, havingValue = "true")
    public Supplier<Message<SendMoneyRequest>> produceMessage(){
        return () -> {
            log.info("producing message");
            String reqId = UUID.randomUUID().toString();
            var msg = messageBuilderFactory
                    .withPayload(Util.produceRandomMessage())
                    .setHeader(Constants.INTERNAL_MESSSAGE_ID, reqId).build();
            return msg;
        };
    }

}
