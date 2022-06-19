package com.ebaykorea.schema.registry.tester.producer.controller;


import com.ebaykorea.schema.registry.tester.producer.avro.MemberBackward;
import com.ebaykorea.schema.registry.tester.producer.avro.MemberForward;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

  private final KafkaTemplate<Object,Object> kafkaTemplate;

  @Autowired
  public SampleController(
      KafkaTemplate<Object, Object> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @GetMapping("/test/schema-registry/produce")
  public String produce(){
    return "TEST";
  }

  @PostMapping("/test/schema-registry/produce/memberForward")
  public String sendSchemaRegistry(@RequestBody MemberForward memberForward){

    memberForward.setName(new Random(100).toString());

    System.out.println("user.getName() = " + memberForward.getName());

    kafkaTemplate.send("jaeshim-member-forward",memberForward);

    return "sended";
  }

  @PostMapping("/test/schema-registry/produce/memberBackward")
  public String sendSchemaRegistry(@RequestBody MemberBackward memberBackward){

    memberBackward.setName(new Random(100).toString());

    System.out.println("user.toString() = " + memberBackward.toString());

    kafkaTemplate.send("jaeshim-member-backward",memberBackward);

    return "sended";
  }
}
