package su.yuk1chan.producerservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import su.yuk1chan.producerservice.enums.Status;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ProducerDTO {
    @NotBlank(message = "Имя не может быть пустой")
    private String firstName;

    @NotBlank(message = "Фамилия не может быть пустой")
    private String lastName;

    @NotBlank(message = "Название компании не может быть пустым")
    private String company;

    @NotBlank(message = "Номер телефона не может быть пустым")
    @Pattern(
            regexp = "^\\+\\d{11,15}$",
            message = "Некоректный номер телефона. Номер должен быть в формате +7XXXXXXXXXX"
    )
    private String phoneNumber;

    @Email(message = "Email-адрес некорректен")
    @NotBlank(message = "Почта не может быть пустой")
    private String email;

    @NotNull(message = "Статус не может быть пустым")
    private Status status;
}
