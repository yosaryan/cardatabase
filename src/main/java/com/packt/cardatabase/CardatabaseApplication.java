package com.packt.cardatabase;


import com.packt.cardatabase.domain.UserRepository;
import com.packt.cardatabase.domain.cars.CarRepository;
import com.packt.cardatabase.domain.users.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CardatabaseApplication {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UserRepository userRepository;

//    @SpringBootApplication
//    public class Application extends SpringBootServletInitializer {
//        @Override
//        protected SpringApplicationBuilder configure
//                (SpringApplicationBuilder application) {
//            return application.sources(Application.class);
//        }
//    }

    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
    }


    @Bean
    CommandLineRunner runner() {
        return args -> {
            // Add owner objects and save these to db
//            Owner owner1 = new Owner("John", "Johnson");
//            Owner owner2 = new Owner("Mary", "Robinson");
//            ownerRepository.save(owner1);
//            ownerRepository.save(owner2);

            // Add car object with link to owners and save these to db.
//            carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1));
//            carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
//            carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2));

//            userRepository.save(new User("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "USER"));
//            userRepository.save(new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN"));

        };
    }

}
