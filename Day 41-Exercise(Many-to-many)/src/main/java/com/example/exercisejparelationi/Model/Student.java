package com.example.exercisejparelationi.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Student {
//    ID , name , age , major ( all should not be empty )

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name can not be null")
    @Size(max = 20,message = "max length for name 20")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @Positive(message = "enter valid age value")
    @Column(columnDefinition = "int not null check(age>0)")
    private int age;
    @NotEmpty(message = "major can not be null")
    @Size(max = 30,message = "max length for major 30")
    private String major;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
