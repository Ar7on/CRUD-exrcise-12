package it.develhope.CRUDexrcise12.repositories;

import it.develhope.CRUDexrcise12.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
}
