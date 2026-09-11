package su.yuk1chan.producerservice.mapper;

import org.mapstruct.Mapper;
import su.yuk1chan.producerservice.dto.ProducersDTO;
import su.yuk1chan.producerservice.entity.Producer;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProducerMapper {
    ProducersDTO producersToProducersDto(Producer producers);
    List<ProducersDTO> listProducersToListProducersDTO(List<Producer> producersList);
}
