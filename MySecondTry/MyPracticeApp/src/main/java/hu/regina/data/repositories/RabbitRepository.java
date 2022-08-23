package hu.regina.data.repositories;

import hu.regina.data.entities.RabbitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RabbitRepository extends JpaRepository<RabbitEntity,Integer> {
}
