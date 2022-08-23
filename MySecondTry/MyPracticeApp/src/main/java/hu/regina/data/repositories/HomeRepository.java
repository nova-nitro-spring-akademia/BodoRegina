package hu.regina.data.repositories;

import hu.regina.data.entities.HomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<HomeEntity,Integer> {
}
