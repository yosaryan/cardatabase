package com.packt.cardatabase.domain.cars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car, Long> {
    //Fetch cars by brand
    List<Car> findByBrand(@Param("brand") String brand);

    //Fetch cars by color
    List<Car> findByColor(@Param("color") String color);
}
