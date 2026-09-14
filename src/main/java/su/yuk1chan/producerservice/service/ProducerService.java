package su.yuk1chan.producerservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import su.yuk1chan.producerservice.dto.PagedResponse;
import su.yuk1chan.producerservice.dto.ProducerDTO;
import su.yuk1chan.producerservice.dto.ProducerPatchDTO;
import su.yuk1chan.producerservice.entity.Producer;
import su.yuk1chan.producerservice.enums.ProducerSort;
import su.yuk1chan.producerservice.enums.Status;
import su.yuk1chan.producerservice.exceptions.NotFoundException;
import su.yuk1chan.producerservice.mapper.ProducerMapper;
import su.yuk1chan.producerservice.repository.ProducerRepository;
import su.yuk1chan.producerservice.repository.specification.ProducerSpecification;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProducerService {
    private final ProducerRepository producerRepository;
    private final ProducerMapper producerMapper;

    public Producer addProducer(ProducerDTO producerDTO) {
        Producer producers = Producer.builder()
                .firstName(producerDTO.getFirstName())
                .lastName(producerDTO.getLastName())
                .company(producerDTO.getCompany())
                .email(producerDTO.getEmail())
                .phoneNumber(producerDTO.getPhoneNumber())
                .status(producerDTO.getStatus())
                .build();

        return producerRepository.save(producers);
    }

    public void deleteProducer(Long id) {
        producerRepository.deleteById(id);
    }

    public PagedResponse<ProducerDTO> getProducers(
            Integer page,
            Integer size,
            String firstName,
            List<String> firstNames,
            String lastName,
            List<String> lastNames,
            String company,
            List<String> companies,
            String phoneNumber,
            List<String> phoneNumbers,
            String email,
            List<String> emails,
            Status status,
            String sort
    ) {
        Specification<Producer> producersSpecification = Specification.where(
                ProducerSpecification.firstNameFilter(firstName)
                        .and(ProducerSpecification.firstNamesFilter(firstNames))
                        .and(ProducerSpecification.lastNameFilter(lastName))
                        .and(ProducerSpecification.lastNamesFilter(lastNames))
                        .and(ProducerSpecification.companyFilter(company))
                        .and(ProducerSpecification.companiesFilter(companies))
                        .and(ProducerSpecification.phoneNumberFilter(phoneNumber))
                        .and(ProducerSpecification.phoneNumbersFilter(phoneNumbers))
                        .and(ProducerSpecification.emailFilter(email))
                        .and(ProducerSpecification.emailsFilter(emails))
                        .and(ProducerSpecification.statusFilter(status))
        );

        ProducerSort producerSort = ProducerSort.of(sort);
        Sort sorted = Sort.by(
                producerSort.getDirection(),
                producerSort.getEntityValue()
        );

        Page<Producer> producers = producerRepository.findAll(producersSpecification,
                PageRequest.of(page, size, sorted)
        );

        return PagedResponse.from(producers
                .map(producerMapper::producersToProducersDto)
        );
    }

    public Producer fullUpdateProducer(Long id, ProducerDTO updatedProducer) {
        Producer foundProducer = producerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Не найден поставщик " + id));

        producerMapper.fullUpdateProducer(updatedProducer, foundProducer);

        return producerRepository.save(foundProducer);
    }

    public Producer partUpdateProducer(Long id, ProducerPatchDTO patchedProducer) {
        Producer foundProducer = producerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Не найден поставщик " + id));

        producerMapper.patchProducerUpdate(patchedProducer, foundProducer);

        return producerRepository.save(foundProducer);
    }
}
