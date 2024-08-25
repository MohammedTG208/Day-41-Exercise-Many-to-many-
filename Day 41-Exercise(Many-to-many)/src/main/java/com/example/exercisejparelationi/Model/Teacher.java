package com.example.exercisejparelationi.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name can not be empty")
    @Size(max = 20,message = "max size is 20  for name")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @Positive(message = "enter valid age")
    @Column(columnDefinition = "int not null")
    private int age;
    @Email(message = "enter valid email")
    @Size(max = 25,message = "max size is 20  for name")
    @Column(columnDefinition = "varchar(25) not null unique")
    private String email;
    @Positive(message = "enter valid salary")
    @Column(columnDefinition = "DECIMAL(10,1) not null")
    private double salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private List<Course> courses;
}
