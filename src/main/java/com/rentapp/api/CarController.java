package com.rentapp.api;

import com.rentapp.api.dto.CarDto;
import com.rentapp.api.mapper.CarMapper;
import com.rentapp.domain.Car;
import com.rentapp.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService; 
    private final CarMapper carMapper;

    @GetMapping
    public List<CarDto> getAllCars() {
        List<Car> allCars = carService.getAllCars();
        return carMapper.toDto(allCars);
    }

    @GetMapping(path = "/search")
    public List<CarDto> getCarsByBrand(@RequestParam String brand) {
        List<Car> cars = carService.getCarsByBrand(brand);
        return carMapper.toDto(cars);
    }

    @GetMapping("/{id}")
    public CarDto getCar(@PathVariable Long id) {
        Car car = carService.get(id);
        return carMapper.toDto(car);
    }

    @PostMapping
    public CarDto create(@RequestBody CarDto carDto){
        Car car = carMapper.toEntity(carDto);
        Car savedCar = carService.create(car);
        return carMapper.toDto(savedCar);
    }

    @PutMapping
    public CarDto update(@RequestBody CarDto carDto){
        Car car = carMapper.toEntity(carDto);
        Car savedCar = carService.update(car);
        return carMapper.toDto(savedCar);
    }
}
