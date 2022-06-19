package com.ebaykorea.schema.registry.tester.consumer;

import com.ebaykorea.schema.registry.tester.producer.avro.MemberBackward;
import com.ebaykorea.schema.registry.tester.producer.avro.MemberForward;
import java.lang.reflect.Member;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MemberProcessor {
//  @KafkaListener(topics = "jaeshim-member-forward")
//  public void memberForwardProcess(ConsumerRecord<String, MemberForward> record) {
//    System.out.println("forward record = " + record.value());
//
//  }

  @KafkaListener(topics = "jaeshim-member-backward")
  public void memberBackwardProcess(ConsumerRecord<String, MemberBackward> record) {
    System.out.println("backward record = " + record.value());

  }
}
