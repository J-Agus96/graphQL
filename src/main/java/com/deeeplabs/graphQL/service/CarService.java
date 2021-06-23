package com.deeeplabs.graphQL.service;

import com.deeeplabs.graphQL.domain.Car;
import com.deeeplabs.graphQL.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Car save (CarDto carDto);

    Car update (String id, CarDto carDto);

    boolean delete (String id);

    Optional<Car> getCarById (String id);

    List<Car> findCarList();

}
