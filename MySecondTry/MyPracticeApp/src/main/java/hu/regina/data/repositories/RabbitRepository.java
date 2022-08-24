package hu.regina.data.repositories;

import hu.regina.data.entities.RabbitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface RabbitRepository extends JpaRepository<RabbitEntity,Integer> {

}
