package org.example.controllers;

import org.example.model.*;
import org.example.repository.AddressRepository;
import org.example.repository.InventoryFileRepository;
import org.example.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin
@RequestMapping("/flowers")
public class InventoryController {

    @Autowired
    InventoryRepository inventoryRepository;
    InventoryFileRepository inventoryFileRepository;

    public InventoryController(InventoryRepository inventoryRepository, InventoryFileRepository inventoryFileRepository) {
        this.inventoryRepository = inventoryRepository;
        this.inventoryFileRepository = inventoryFileRepository;
    }

    @PostMapping
    public Flower addFlower(@RequestBody Flower flower){
        try {
            return inventoryRepository.save(flower);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    @GetMapping
    public List<Flower> getAll(){
        try {
            return inventoryRepository.findAll();
        } catch (Exception e){
            throw new RuntimeException();
        }
    }
    @GetMapping("/{id}")
    public Flower getFlower(@PathVariable int id){
        try{
            return inventoryRepository.findById(id);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
    @GetMapping("/filter")
    public List<Flower> filter(@RequestParam (required = false) String occasion,
                               @RequestParam (required = false) String color,
                               @RequestParam (required = false) String type){

        Color colorType = (color == null) ? Color.ANY : Color.valueOf(color);
        Type typeO = (type == null) ? Type.ANY : Type.valueOf(type);
        Occasion occasion1 = (occasion == null) ? Occasion.ANY : Occasion.valueOf(occasion);

        List<Flower> flowers = inventoryRepository.findAll();

        return flowers.stream()
                .filter(flower ->
                        (colorType == Color.ANY || flower.getColor() == colorType) &&
                                (occasion1 == Occasion.ANY || flower.getOccasion() == occasion1) &&
                                (typeO == Type.ANY || flower.getType() == typeO))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<?> getImage(@PathVariable int id) {
        try {
            byte[] image = inventoryFileRepository.getImage(id);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .contentType(MediaType.IMAGE_PNG)
                    .body(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/{id}/image")
    public boolean updateImage(@PathVariable int id,
                               @RequestParam MultipartFile file) {
        try {
            return inventoryFileRepository.updateImage(id, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
