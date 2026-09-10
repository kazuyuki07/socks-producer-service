package su.yuk1chan.producerservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import su.yuk1chan.producerservice.dto.ProducersDTO;
import su.yuk1chan.producerservice.service.ProducerService;

@RestController
@RequestMapping("/api/producer_service")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addProducer(@Valid ProducersDTO producersDTO) {
        // ...
    }

    @DeleteMapping("/{producerId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteProducer(@PathVariable Long producerId) {
        // ...
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ProducersDTO getProducers() {
        // ...
    }
}
