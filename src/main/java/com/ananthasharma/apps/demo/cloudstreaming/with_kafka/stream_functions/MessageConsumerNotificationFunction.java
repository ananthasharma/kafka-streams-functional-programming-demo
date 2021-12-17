package com.ananthasharma.apps.demo.cloudstreaming.with_kafka.stream_functions;

import com.ananthasharma.apps.demo.cloudstreaming.with_kafka.util.Constants;
import com.ananthasharma.demo.schema.io.SendMoneyRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
public class MessageConsumerNotificationFunction extends AbstractProcessorFunction {
    @Bean
    public Consumer<Message<SendMoneyRequest>> consumeMessageAndNotify() {
        return (message) -> {
            var reqId = message.getHeaders().getOrDefault(Constants.INTERNAL_MESSSAGE_ID,"NO_VALUE_FOUND");
            log.info("Got money transfer request with Id {}", reqId);
            /**
             * notify sender and reciever that a transaction has happened
             */
        };
    }

}
