package su.yuk1chan.producerservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import su.yuk1chan.producerservice.dto.PagedResponse;
import su.yuk1chan.producerservice.dto.ProducersDTO;
import su.yuk1chan.producerservice.entity.Producers;
import su.yuk1chan.producerservice.repository.ProducersRepository;

@Service
@RequiredArgsConstructor
public class ProducerService {
    private final ProducersRepository producersRepository;

    public Producers addProducer(ProducersDTO producersDTO) {
        Producers producers = Producers.builder()
                .firstName(producersDTO.getFirstName())
                .lastName(producersDTO.getLastName())
                .company(producersDTO.getCompany())
                .email(producersDTO.getEmail())
                .phoneNumber(producersDTO.getPhoneNumber())
                .status(producersDTO.getStatus())
                .build();

        return producersRepository.save(producers);
    }

    public void deleteProducer(Long id) {
        producersRepository.deleteById(id);
    }

    public PagedResponse<ProducersDTO> getProducers() {
        // ...
    }
}
