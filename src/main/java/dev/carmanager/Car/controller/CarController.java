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

    @GetMapping("/Car/{id}")
    public ResponseEntity getCarById(@PathVariable("id") Long id) {

        return new ResponseEntity(serviceCar.getCarById(id), HttpStatus.OK);

    }

    @GetMapping("/AllCars")
    public ResponseEntity getAllCars() {

        return new ResponseEntity(serviceCar.getAllCars(), HttpStatus.OK);

    }

    @PutMapping("/updateCar/{id}")
    public ResponseEntity updateCar(@PathVariable("id") Long id, @RequestBody Car car) {

        return new ResponseEntity(serviceCar.updateCar(id, car), HttpStatus.OK);

    }


}
