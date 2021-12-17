package com.ananthasharma.apps.demo.cloudstreaming.with_kafka.stream_functions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public abstract class AbstractProcessorFunction implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
       log.info("bean initialized {}", this.getClass().getName());
    }
}
