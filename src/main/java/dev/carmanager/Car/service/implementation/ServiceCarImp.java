package dev.carmanager.apirest.service.implementation;

import dev.carmanager.apirest.model.Car;
import dev.carmanager.apirest.repository.CarRepository;
import dev.carmanager.apirest.service.ServiceCar;
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

        try {
            carRepository.save(car);
            return true;
        } catch (Exception e) {
            return false;
        }


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

