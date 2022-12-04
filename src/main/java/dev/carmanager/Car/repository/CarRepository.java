package dev.carmanager.Car.repository;

import dev.carmanager.Car.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {




}
