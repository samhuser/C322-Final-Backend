package org.example.repository;

import org.example.model.Color;
import org.example.model.Flower;
import org.example.model.Type;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InventoryRepository extends CrudRepository<Flower, String> {
    Flower findByName(String name);
    List<Flower> findByType(Type type);
    Flower findById(int id);
    List<Flower> findByColor(Color color);

    List<Flower> findAll();
}
