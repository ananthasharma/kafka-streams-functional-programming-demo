package com.ananthasharma.apps.demo.cloudstreaming.with_kafka.util;

import com.ananthasharma.demo.schema.io.SendMoneyRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;


@Slf4j
public class Util {

    /**
     * generate a dummy message
     * @return
     */
    public static SendMoneyRequest produceRandomMessage(){
        var rand = new Random();
        var amount = rand.nextDouble() * rand.nextInt(5000);  // this makes for a decent size number
        var msg = SendMoneyRequest.newBuilder()
                .setAmount(amount)
                .setCurrency("USD")
                .setDestWallet(rand.nextLong())
                .setSourceWallet(rand.nextLong())
                .build();
        return msg;
    }
}
