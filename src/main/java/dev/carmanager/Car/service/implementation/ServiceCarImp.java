package dev.carmanager.Car.service.implementation;

import dev.carmanager.Car.model.Car;
import dev.carmanager.Car.repository.CarRepository;
import dev.carmanager.Car.service.ServiceCar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServiceCarImp implements ServiceCar {

    private final CarRepository carRepository;


    public ServiceCarImp(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public boolean addCar(Car car) {

        if (carRepository.existsById(car.getId())) {
            throw new RuntimeException("Id Car Already Exists");
        }
        if (car.getBrand() == null || car.getBrand().isEmpty()) {
            throw new RuntimeException("Brand Car is Empty or Null");
        }
        if (car.getModel() == null || car.getModel().isEmpty()) {
            throw new RuntimeException("Model Car is Empty or Null");
        }
        if (car.getYear() == null || car.getYear() < 1900 || car.getYear() > 2025) {
            throw new RuntimeException("Year Car is Empty or Null or Invalid");
        }
        if (car.getColor() == null || car.getColor().isEmpty()) {
            throw new RuntimeException("Color Car is Empty or Null");
        }

        try {
            carRepository.save(car);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Car invalid");

        }
    }

    @Override
    public Car addCarWithSpecificId(Car car) {
        return null;
    }


    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getCarById(Long id) {

        carRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro"));
        return carRepository.findById(id).get();

    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}

