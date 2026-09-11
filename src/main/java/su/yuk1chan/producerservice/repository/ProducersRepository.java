package su.yuk1chan.producerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import su.yuk1chan.producerservice.entity.Producer;

public interface ProducersRepository extends JpaRepository<Producer, Long>, JpaSpecificationExecutor<Producer> {
}
