package com.rentapp.service;

import com.rentapp.domain.entity.Car;
import com.rentapp.exception.ElementNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarServiceTest {

    @Autowired
    CarService carService;

    @Test
    void shouldPersistCarEntity() {
        //given
        Car car = Car.builder()
                .brand("Toyota")
                .model("Yaris")
                .productionYear(2010)
                .pricePerDay(new BigDecimal("23.65"))
                .build();

        //when
        carService.create(car);

        //then
        assertNotNull(car.getId());
        //clean up
        carService.delete(car);
    }

    @Test
    void shouldFindAllCars() {
        //given data.sql
        //when
        List<Car> allCars = carService.getAllCars();
        //then
        assertEquals(allCars.size(), 4);
    }

    @Test
    void shouldFindAllCarsByBrand() {
        //given
        String brand = "Toyota";
        //when
        List<Car> result = carService.getCarsByBrand(brand);
        //then
        assertEquals(result.size(), 3);
    }

    @Test
    void shouldFindById() {
        //given
        Long id = 1L;
        //when
        Car result = carService.get(id);
        //then
        assertNotNull(result);
    }

    @Test
    void shouldThrowExceptionWhenNoElementFound() {
        //given
        Long id = 9999L;
        //when & then
        assertThrows(ElementNotFoundException.class, () -> {
            carService.get(id);
        });
    }


}