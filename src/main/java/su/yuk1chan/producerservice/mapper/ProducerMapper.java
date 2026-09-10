package su.yuk1chan.producerservice.mapper;

import org.mapstruct.Mapper;
import su.yuk1chan.producerservice.dto.ProducersDTO;
import su.yuk1chan.producerservice.entity.Producers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProducerMapper {
    ProducersDTO producersToProducersDto(Producers producers);
    List<ProducersDTO> listProducersToListProducersDTO(List<Producers> producersList);
}
