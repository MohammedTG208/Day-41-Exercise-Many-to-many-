package com.example.exercisejparelationi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private Integer id;

    @NotEmpty(message = "area can not be null")
    @Column(columnDefinition = "varchar(20) not null")
    private String area;
    @NotEmpty(message = "Street can not be null")
    @Column(columnDefinition = "varchar(25) not null")
    private String street;
    @Positive(message = "enter valid number for buildingNumber")
    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
