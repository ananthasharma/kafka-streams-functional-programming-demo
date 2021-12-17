package com.ananthasharma.apps.demo.cloudstreaming.with_kafka.stream_functions;

import com.ananthasharma.apps.demo.cloudstreaming.with_kafka.util.Constants;
import com.ananthasharma.demo.schema.io.SendMoneyRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Slf4j
@Component
public class MessageProcessorFunction extends AbstractProcessorFunction {

    @Bean
    public Function<Message<SendMoneyRequest>, Message<SendMoneyRequest>> processMessage(){
        return message -> {
            var reqId = message.getHeaders().getOrDefault(Constants.INTERNAL_MESSSAGE_ID,"NO_VALUE_FOUND");
            log.info("Got money transfer request with Id {}", reqId);
            var msg = message.getPayload();
            /**
             * invoke business logic here...
             */
            return message;
        };
    }
}
