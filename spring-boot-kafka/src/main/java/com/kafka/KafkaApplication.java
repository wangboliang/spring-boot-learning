package com.kafka;

import com.kafka.model.Message;
import com.kafka.producer.Sender;
import com.kafka.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;
import java.util.UUID;

@Slf4j
@SpringBootApplication
public class KafkaApplication {

  private static Sender sender;

  @Autowired
  public void setSender(Sender sender) {
    this.sender = sender;
  }

//  public static void main(String[] args) {
//    SpringApplication.run(SpringKafkaApplication.class, args);
//  }

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new SpringApplicationBuilder(KafkaApplication.class)
            .web(false)
            .run(args);

    Message m = new Message();
    m.setId(System.currentTimeMillis());
    m.setMsg(UUID.randomUUID().toString());
    m.setSendTime(new Date());
    log.info("sending data='{}'", JsonUtil.objectToJson(m));
    sender.send(JsonUtil.objectToJson(m));
  }
}
