package org.example.controllers;


import org.example.model.Address;
import org.example.repository.AddressRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AddressController {

    AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @PostMapping("/address")
    public int addAddress(@RequestBody Address address){
        try{
            Address saved = addressRepository.save(address);
            return saved.getId();
        } catch (Exception e){
            throw new RuntimeException();
        }
    }
    @GetMapping("/address/{id}")
    public Address getAddress(@PathVariable Integer id){
        try {
            return addressRepository.findById(id);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

}
