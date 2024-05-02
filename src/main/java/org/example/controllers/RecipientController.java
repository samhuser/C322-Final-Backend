package org.example.controllers;

import org.example.model.Recipient;
import org.example.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class RecipientController {

    @Autowired
    RecipientRepository recipientRepository;

    public RecipientController(RecipientRepository recipientRepository){
        this.recipientRepository = recipientRepository;
    }

    @PostMapping("/recipient")
    public int addRecipient(@RequestBody Recipient recipient){
        try{
            Recipient saved = recipientRepository.save(recipient);
            return saved.getId();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @GetMapping("/recipient/{id}")
    public Recipient getRecipient(@PathVariable int id){
        try {
            return recipientRepository.findById(id);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }


}
