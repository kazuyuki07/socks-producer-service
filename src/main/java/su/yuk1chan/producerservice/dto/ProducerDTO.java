package su.yuk1chan.producerservice.dto;

import lombok.*;
import su.yuk1chan.producerservice.enums.Status;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ProducerDTO {
    private String firstName;
    private String lastName;
    private String company;
    private String phoneNumber;
    private String email;
    private Status status;
}
