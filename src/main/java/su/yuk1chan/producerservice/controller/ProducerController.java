package su.yuk1chan.producerservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import su.yuk1chan.producerservice.dto.PagedResponse;
import su.yuk1chan.producerservice.dto.ProducersDTO;
import su.yuk1chan.producerservice.entity.Producer;
import su.yuk1chan.producerservice.enums.Status;
import su.yuk1chan.producerservice.service.ProducerService;

import java.util.List;

@RestController
@RequestMapping("/api/producer_service")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProducersDTO addProducer(@Valid @RequestBody ProducersDTO producersDTO) {
        Producer producer = producerService.addProducer(producersDTO);
        return new ProducersDTO(
                producer.getFirstName(),
                producer.getLastName(),
                producer.getCompany(),
                producer.getPhoneNumber(),
                producer.getEmail(),
                producer.getStatus()
        );
    }

    @DeleteMapping("/{producerId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteProducer(@PathVariable Long producerId) {
        producerService.deleteProducer(producerId);
        return "Поставщик удален";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PagedResponse<ProducersDTO> getProducers(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "company") String sort,
            @RequestParam(required = false, name = "first_name") List<String> firstName,
            @RequestParam(required = false, name = "last_name") List<String> lastName,
            @RequestParam(required = false) List<String> company,
            @RequestParam(required = false, name = "phone_number") List<String> phoneNumber,
            @RequestParam(required = false) List<String> email,
            @RequestParam(required = false) Status status
    ) {
        return producerService.getProducers(page, size, firstName, lastName, company, phoneNumber, email, status, sort);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void fullUpdateProducer() {
        // ...
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void partUpdateProducer() {
        // ...
    }
}
