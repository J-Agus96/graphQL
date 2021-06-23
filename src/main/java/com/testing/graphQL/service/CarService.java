package com.testing.graphQL.service;

import com.testing.graphQL.domain.Car;
import com.testing.graphQL.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Car save (CarDto carDto);

    Car update (String id, CarDto carDto);

    boolean delete (String id);

    Optional<Car> getCarById (String id);

    List<Car> findCarList();

}
