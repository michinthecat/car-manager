package dev.carmanager.Car.controller;

import dev.carmanager.Car.model.Car;
import dev.carmanager.Car.service.ServiceCar;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final ServiceCar serviceCar;


    public CarController(ServiceCar serviceCar) {
        this.serviceCar = serviceCar;
    }


    @PostMapping("/addCar")
    public ResponseEntity addCar(@RequestBody Car car) {

        return ResponseEntity.status(HttpStatus.CREATED).body(serviceCar.addCar(car));
    }


    @PostMapping("/addCarEntity")
    public boolean addCarEntity(@RequestBody Car car) {

        return serviceCar.addCar(car);

    }

    @PostMapping("/createCar")
    public ResponseEntity createCar(@RequestBody Car car) {

        return new ResponseEntity(serviceCar.createCar(car), HttpStatus.CREATED);

    }


    @GetMapping("/getCarById/{id}")
    public ResponseEntity getCarById(@PathVariable("id") Long id) {

        return new ResponseEntity(serviceCar.getCarById(id), HttpStatus.OK);

    }

    @GetMapping("/getAllCars")
    public ResponseEntity getAllCars() {

        return new ResponseEntity(serviceCar.getAllCars(), HttpStatus.OK);

    }


}
