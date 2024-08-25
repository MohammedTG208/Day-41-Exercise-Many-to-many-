package com.example.exercisejparelationi.Service;

import com.example.exercisejparelationi.API.APIException;
import com.example.exercisejparelationi.DTO.AddressDTO;
import com.example.exercisejparelationi.Model.Address;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Repository.AddressRepository;
import com.example.exercisejparelationi.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;
    public List<Address> getAllAddress(){
        if (addressRepository.findAll().isEmpty()) {
            throw new APIException("No address found in DB");
        }else {
            return addressRepository.findAll();
        }
    }

    public void addNewAddressToTeacher(AddressDTO addressDTO){
        Teacher teacher=teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if(teacher==null){
            throw new APIException("Teacher not found");
        }else {
            Address address=new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
            addressRepository.save(address);
        }
    }

    public void updateAddressForTeacher(AddressDTO addressDTO){
        Address updateAddress=addressRepository.findAddressById(addressDTO.getTeacher_id());
        if(updateAddress==null){
            throw new APIException("Teacher not found");
        }else {
            updateAddress.setArea(addressDTO.getArea());
            updateAddress.setStreet(addressDTO.getStreet());
            updateAddress.setBuildingNumber(addressDTO.getBuildingNumber());
            addressRepository.save(updateAddress);
        }
    }

    public void deleteAddressForTeacher(Integer id){
        Address deleteAddress=addressRepository.findAddressById(id);
        if(deleteAddress==null){
            throw new APIException("Teacher not found");
        }else {
            addressRepository.deleteById(deleteAddress.getId());
        }
    }
}
