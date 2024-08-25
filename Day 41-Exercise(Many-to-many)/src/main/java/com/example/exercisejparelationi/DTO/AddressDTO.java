package com.example.exercisejparelationi.DTO;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_id;
    @NotEmpty(message = "area can not be null")
    private String area;
    @NotEmpty(message = "Street can not be null")
    private String street;
    @Positive(message = "enter valid number for buildingNumber")
    private Integer buildingNumber;
}
