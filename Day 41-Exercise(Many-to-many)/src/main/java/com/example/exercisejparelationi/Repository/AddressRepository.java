package com.example.exercisejparelationi.Repository;

import com.example.exercisejparelationi.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findAddressById(Integer id);
}
