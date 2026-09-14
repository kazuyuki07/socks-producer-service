package su.yuk1chan.producerservice.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import su.yuk1chan.producerservice.dto.ProducerDTO;
import su.yuk1chan.producerservice.dto.ProducerPatchDTO;
import su.yuk1chan.producerservice.entity.Producer;

@Mapper(componentModel = "spring")
public interface ProducerMapper {
    ProducerDTO producersToProducersDto(Producer producers);
    void fullUpdateProducer(ProducerDTO producerDTO, @MappingTarget Producer producer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patchProducerUpdate(ProducerPatchDTO producerPatchDTO, @MappingTarget Producer producer);
}
