package com.packt.cardatabase.web;

import com.packt.cardatabase.domain.cars.Car;
import com.packt.cardatabase.domain.cars.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarRepository repository;

    @RequestMapping("/cars")
    public Iterable<Car> getCars() {
        return repository.findAll();
    }

    @GetMapping("/cars/brand/{brand}")
    public ResponseEntity<List<Car>> findByBrand(@PathVariable("brand") String brand) {
        List<Car> list = repository.findByBrand(brand);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(list);
    }


}
