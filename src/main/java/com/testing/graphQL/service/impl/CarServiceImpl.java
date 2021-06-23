package com.testing.graphQL.service.impl;

import com.testing.graphQL.domain.Car;
import com.testing.graphQL.dto.CarDto;
import com.testing.graphQL.repository.CarRepository;
import com.testing.graphQL.service.CarService;
import io.leangen.graphql.annotations.*;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@GraphQLApi
@ComponentScan
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    @GraphQLMutation(name = "saveCar")
    public Car save(@GraphQLArgument(name = "car") CarDto carDto) {

        Car car = new Car();
        car.setCode(carDto.getCode());
        car.setName(carDto.getName());
        car.setTypeCar(carDto.getTypeCar());
        car.setCylinderCapacity(carDto.getCylinderCapacity());
        car.setTypeTransmission(carDto.getTypeTransmission());
        car.setColor(carDto.getColor());
        car.setPrice(carDto.getPrice());
        car.setCreatedAt(OffsetDateTime.now());

        return carRepository.save(car);
    }

    @Override
    @GraphQLMutation(name = "updateCar")
    public Car update(@GraphQLArgument(name = "id") String id, @GraphQLArgument(name = "car") CarDto carDto) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("No Car Found with Id " +id));
        car.setName(carDto.getName());
        car.setTypeCar(carDto.getTypeCar());
        car.setCylinderCapacity(carDto.getCylinderCapacity());
        car.setTypeTransmission(carDto.getTypeTransmission());
        car.setColor(carDto.getColor());
        car.setPrice(carDto.getPrice());
        car.setUpdatedAt(OffsetDateTime.now());

        return carRepository.save(car);
    }

    @Override
    @GraphQLMutation(name = "deleteCar")
    public boolean delete(@GraphQLArgument(name = "id") String id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("No Car Found with Id " +id));
        car.setDeleteFlag(true);
        car.setUpdatedAt(OffsetDateTime.now());
        carRepository.delete(car);
        return true;
    }

    @Override
    @GraphQLQuery(name = "car")
    public Optional<Car> getCarById(@GraphQLArgument(name = "id") String id) {
        return carRepository.findById(id);
    }

    @Override
    @GraphQLQuery(name = "cars")
    public List<Car> findCarList() {
        return carRepository.findAll();
    }
}
