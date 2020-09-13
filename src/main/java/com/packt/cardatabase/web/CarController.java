package com.packt.cardatabase.web;

import com.packt.cardatabase.domain.cars.Car;
import com.packt.cardatabase.domain.cars.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarRepository repository;

    @RequestMapping("/cars")
    public Iterable<Car> getCars() {

        return repository.findAll();

    }
}
