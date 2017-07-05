package com.company.kafka;

import com.company.kafka.model.Message;
import com.company.kafka.producer.Sender;
import com.company.kafka.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class SpringKafkaApplication {

  static Logger logger = LoggerFactory.getLogger(SpringKafkaApplication.class);
  private static Sender sender;

  @Autowired
  public void setSender(Sender sender) {
    this.sender = sender;
  }

//  public static void main(String[] args) {
//    SpringApplication.run(SpringKafkaApplication.class, args);
//  }

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringKafkaApplication.class)
            .web(false)
            .run(args);

    Message m = new Message();
    m.setId(System.currentTimeMillis());
    m.setMsg(UUID.randomUUID().toString());
    m.setSendTime(new Date());
    logger.info("sending data='{}'",JsonUtil.objectToJson(m));
    sender.send(JsonUtil.objectToJson(m));
  }
}
