package su.yuk1chan.producerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import su.yuk1chan.producerservice.entity.Producers;

public interface ProducersRepository extends JpaRepository<Producers, Long> {
}
