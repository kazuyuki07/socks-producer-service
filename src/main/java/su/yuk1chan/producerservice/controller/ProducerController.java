package su.yuk1chan.producerservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import su.yuk1chan.producerservice.dto.PagedResponse;
import su.yuk1chan.producerservice.dto.ProducerDTO;
import su.yuk1chan.producerservice.dto.ProducerPatchDTO;
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
    public ProducerDTO addProducer(@RequestBody ProducerDTO producerDTO) {
        Producer producer = producerService.addProducer(producerDTO);
        return new ProducerDTO(
                producer.getFirstName(),
                producer.getLastName(),
                producer.getCompany(),
                producer.getPhoneNumber(),
                producer.getEmail(),
                producer.getStatus()
        );
    }

    @DeleteMapping("/{producerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProducer(@PathVariable Long producerId) {
        producerService.deleteProducer(producerId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PagedResponse<ProducerDTO> getProducers(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "company") String sort,
            @RequestParam(required = false, name = "first_name") String firstName,
            @RequestParam(required = false, name = "first_names") List<String> firstNames,
            @RequestParam(required = false, name = "last_name") String lastName,
            @RequestParam(required = false, name = "last_names") List<String> lastNames,
            @RequestParam(required = false) String company,
            @RequestParam(required = false, name = "companies") List<String> companies,
            @RequestParam(required = false, name = "phone_number") String phoneNumber,
            @RequestParam(required = false, name = "phone_numbers") List<String> phoneNumbers,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) List<String> emails,
            @RequestParam(required = false) Status status
    ) {
        return producerService.getProducers(
                page,
                size,
                firstName,
                firstNames,
                lastName,
                lastNames,
                company,
                companies,
                phoneNumber,
                phoneNumbers,
                email,
                emails,
                status,
                sort
        );
    }

    @PutMapping("/{producerId}")
    @ResponseStatus(HttpStatus.OK)
    public ProducerDTO fullUpdateProducer(
            @PathVariable Long producerId,
            @RequestBody ProducerDTO updatedProducer) {
        Producer updateProducerResult = producerService.fullUpdateProducer(producerId, updatedProducer);

        return new ProducerDTO(
                updateProducerResult.getFirstName(),
                updateProducerResult.getLastName(),
                updateProducerResult.getCompany(),
                updateProducerResult.getPhoneNumber(),
                updateProducerResult.getEmail(),
                updateProducerResult.getStatus()
        );
    }

    @PatchMapping("/{producerId}")
    @ResponseStatus(HttpStatus.OK)
    public ProducerDTO partUpdateProducer(
            @PathVariable Long producerId,
            @RequestBody ProducerPatchDTO patchedProducer) {
        Producer updateProducerResult = producerService.partUpdateProducer(producerId, patchedProducer);

        return new ProducerDTO(
                updateProducerResult.getFirstName(),
                updateProducerResult.getLastName(),
                updateProducerResult.getCompany(),
                updateProducerResult.getPhoneNumber(),
                updateProducerResult.getEmail(),
                updateProducerResult.getStatus()
        );
    }
}
