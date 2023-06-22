package com.rentapp.api.mapper;

import com.rentapp.api.dto.CarDto;
import com.rentapp.domain.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarMapper {

    public Car toEntity(CarDto carDto) {
        return Car.builder()
                .id(carDto.getId())
                .brand(carDto.getBrand())
                .model(carDto.getModel())
                .productionYear(carDto.getProductionYear())
                .build();
    }

    public CarDto toDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .productionYear(car.getProductionYear())
                .build();
    }

    public List<CarDto> toDto(List<Car> allCars) {
        return allCars.stream()
                .map(car -> toDto(car))
                .collect(Collectors.toList());
    }



}
