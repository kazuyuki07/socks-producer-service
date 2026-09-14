package su.yuk1chan.producerservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import su.yuk1chan.producerservice.enums.Status;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ProducerPatchDTO {
    private String firstName;
    private String lastName;
    private String company;

    @Pattern(
            regexp = "^\\+\\d{11,15}$",
            message = "Некоректный номер телефона. Номер должен быть в формате +7XXXXXXXXXX"
    )
    private String phoneNumber;

    @Email(message = "Email-адрес некорректен")
    private String email;
    private Status status;
}
