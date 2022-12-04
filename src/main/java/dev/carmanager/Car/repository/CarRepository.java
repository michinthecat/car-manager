package dev.carmanager.apirest.repository;

import dev.carmanager.apirest.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {




}
