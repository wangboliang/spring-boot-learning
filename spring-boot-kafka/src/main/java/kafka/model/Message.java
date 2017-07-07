package kafka.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Message {

    private Long id;
    private String msg;
    private Date sendTime;

}
