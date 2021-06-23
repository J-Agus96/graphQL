package com.deeeplabs.graphQL.domain;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @GraphQLQuery(name = "id")
    private String id;

    @GraphQLQuery(name = "code")
    private String code;

    @GraphQLQuery(name = "name")
    private String name;

    @GraphQLQuery(name = "color")
    private String color;

    @GraphQLQuery(name = "type_car")
    private String typeCar;

    @GraphQLQuery(name = "type_transmission")
    private String typeTransmission;

    @GraphQLQuery(name = "cylinder_capacity")
    private int cylinderCapacity;

    @GraphQLQuery(name = "price")
    private BigDecimal price;

    @GraphQLQuery(name = "delete_flag")
    private boolean deleteFlag;

    @GraphQLQuery(name = "created_at")
    private OffsetDateTime createdAt;

    @GraphQLQuery(name = "updated_at")
    private OffsetDateTime updatedAt;


}
