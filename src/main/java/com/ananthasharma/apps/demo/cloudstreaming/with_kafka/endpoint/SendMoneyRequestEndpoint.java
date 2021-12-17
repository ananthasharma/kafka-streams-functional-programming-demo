package com.ananthasharma.apps.demo.cloudstreaming.with_kafka.endpoint;

import com.ananthasharma.apps.demo.cloudstreaming.with_kafka.util.Constants;
import com.ananthasharma.apps.demo.cloudstreaming.with_kafka.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilderFactory;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SendMoneyRequestEndpoint {
    // marking this final would cause @RequiredArgsConstructor to create a constructor with this in the param and cause DI from spring
    private final StreamBridge streamBridge;

    // marking this final would cause @RequiredArgsConstructor to create a constructor with this in the param and cause DI from spring
    private final MessageBuilderFactory messageBuilderFactory;

    @Value("${kafka.config.source-topic-name}")
    private String topic;

    @GetMapping("/api/send")
    public ResponseEntity<String> sendMessage() {
        var message = Util.produceRandomMessage();
        log.info("sending message, {}", message);

        String refid = UUID.randomUUID().toString();
        var msg = messageBuilderFactory
                .withPayload(message)
                .setHeader(Constants.INTERNAL_MESSSAGE_ID, refid)
                .build();
        streamBridge.send(topic, msg, MimeType.valueOf("application/**avsc"));
        return ResponseEntity.ok("All Good!!!");
    }
}
