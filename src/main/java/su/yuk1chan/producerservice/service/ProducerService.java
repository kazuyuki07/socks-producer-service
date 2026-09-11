package su.yuk1chan.producerservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import su.yuk1chan.producerservice.dto.PagedResponse;
import su.yuk1chan.producerservice.dto.ProducersDTO;
import su.yuk1chan.producerservice.entity.Producer;
import su.yuk1chan.producerservice.enums.ProducerSort;
import su.yuk1chan.producerservice.enums.Status;
import su.yuk1chan.producerservice.mapper.ProducerMapper;
import su.yuk1chan.producerservice.repository.ProducersRepository;
import su.yuk1chan.producerservice.repository.specification.ProducerSpecification;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProducerService {
    private final ProducersRepository producersRepository;
    private final ProducerMapper producerMapper;

    public Producer addProducer(ProducersDTO producersDTO) {
        Producer producers = Producer.builder()
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

    public PagedResponse<ProducersDTO> getProducers(
            Integer page,
            Integer size,
            List<String> firstName,
            List<String> lastName,
            List<String> company,
            List<String> phoneNumber,
            List<String> email,
            Status status,
            String sort
    ) {
        Specification<Producer> producersSpecification = Specification.where(
                ProducerSpecification.firstNameFilter(firstName)
                        .and(ProducerSpecification.lastNameFilter(lastName))
                        .and(ProducerSpecification.companyFilter(company))
                        .and(ProducerSpecification.phoneNumberFilter(phoneNumber))
                        .and(ProducerSpecification.emailFilter(email))
                        .and(ProducerSpecification.statusFilter(status))
        );

        ProducerSort producerSort = ProducerSort.of(sort);
        Sort sorted = Sort.by(
                producerSort.getDirection(),
                producerSort.getEntityValue()
        );

        Page<Producer> producers = producersRepository.findAll(producersSpecification,
                PageRequest.of(page, size, sorted)
        );

        return PagedResponse.from(producers
                .map(producerMapper::producersToProducersDto)
        );
    }

    public void partUpdateProducer() {
        // ...
    }

    public void fullUpdateProducer() {
        // ...
    }
}
