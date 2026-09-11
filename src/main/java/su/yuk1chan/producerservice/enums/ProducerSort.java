package su.yuk1chan.producerservice.enums;


import lombok.Getter;
import org.springframework.data.domain.Sort;

import java.util.stream.Stream;

@Getter
public enum ProducerSort {
    FIRST_NAME_ASC("first_name", "firstName"),
    FIRST_NAME_DESC("-first_name", "firstName"),
    LAST_NAME_ASC("last_name", "lastName"),
    LAST_NAME_DESC("-last_name", "lastName"),
    COMPANY_ASC("company", "company"),
    COMPANY_DESC("-company", "company"),
    STATUS_ASC("status", "status"),
    STATUS_DESC("-status", "status");

    private final String requestValue;
    private final String entityValue;
    private final Sort.Direction direction;

    ProducerSort(String requestValue, String entityValue) {
        this.requestValue = requestValue;
        this.entityValue = entityValue;
        this.direction = requestValue.startsWith("-") ? Sort.Direction.DESC : Sort.Direction.ASC;
    }

    public static ProducerSort of(String requestValue) {
        return Stream.of(ProducerSort.values())
                .filter(e -> e.requestValue.equals(requestValue))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Вид сортировки не найден"));
    }
}
