package com.rentapp.service;

import com.rentapp.domain.entity.Car;
import com.rentapp.exception.ElementNotFoundException;
import com.rentapp.exception.InvalidRequestException;
import com.rentapp.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public Car create(Car car) {
        if (car.getId() != null) {
            throw new InvalidRequestException();
        }
        return carRepository.save(car);
    }

    public Car update(Car car) {
        if (car.getId() == null) {
            throw new InvalidRequestException();
        }
        return carRepository.save(car);
    }

    public void delete(Car car) {
        carRepository.delete(car);
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public List<Car> getCarsByBrand(String brand){
        return carRepository.findByBrand(brand);
    }

    public Car get(Long id){
        return carRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException());
    }



}
