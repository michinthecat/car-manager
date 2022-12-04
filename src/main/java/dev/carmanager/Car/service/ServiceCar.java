package dev.carmanager.apirest.service;

import dev.carmanager.apirest.model.Car;

import java.util.List;

public interface ServiceCar {

    boolean addCar(Car car);

    Car createCar(Car car);

    Car getCarById(Long id);

    List<Car> getAllCars();




}
