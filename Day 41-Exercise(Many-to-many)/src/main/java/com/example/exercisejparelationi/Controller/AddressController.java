package com.example.exercisejparelationi.Controller;

import com.example.exercisejparelationi.DTO.AddressDTO;
import com.example.exercisejparelationi.Model.Address;
import com.example.exercisejparelationi.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAllAddress(){
        return ResponseEntity.ok(addressService.getAllAddress());
    }

    @PostMapping("/add")
    public ResponseEntity addAddress(@Valid @RequestBody AddressDTO addressDTO){
        addressService.addNewAddressToTeacher(addressDTO);
        return ResponseEntity.ok().body("address added successfully");
    }

    @PutMapping("/update")
    public ResponseEntity updateAddress(@Valid @RequestBody AddressDTO addressDTO){
        addressService.updateAddressForTeacher(addressDTO);
        return ResponseEntity.ok().body("address updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        addressService.deleteAddressForTeacher(id);
        return ResponseEntity.ok().body("address deleted successfully");
    }
}
