package com.packt.cardatabase.web;

import com.packt.cardatabase.domain.cars.Car;
import com.packt.cardatabase.domain.cars.CarRepository;
import com.packt.cardatabase.domain.users.Owner;
import com.packt.cardatabase.domain.users.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @RequestMapping("/cars")
    public Iterable<Car> getCars() {
        return carRepository.findAll();
    }

    @GetMapping("/cars/brand/{brand}")
    public ResponseEntity<List<Car>> findByBrand(@PathVariable("brand") String brand) {
        List<Car> list = carRepository.findByBrand(brand);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(list);
    }


    @PostMapping("/cars/owner/{ownerId}")
    public ResponseEntity<Void> findByColor(@PathVariable("ownerId") Long ownerId, @RequestBody Car request) {

        Optional<Owner> ownerOptional = ownerRepository.findById(ownerId);
        if (ownerOptional.isPresent()) {
            Owner owner = ownerOptional.get();

            carRepository.save(new Car(request.getBrand(), request.getModel(), request.getColor(), request.getRegisterNumber(), request.getYear(), request.getPrice(), owner));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
