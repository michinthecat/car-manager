package dev.carmanager.Car.service;

import dev.carmanager.Car.model.Car;

import java.util.List;

public interface ServiceCar {

    boolean addCar(Car car);

    boolean updateCar(Long id, Car car);

    Car addCarWithSpecificId(Car car);

    Car getCarById(Long id);

    List<Car> getAllCars();


}
