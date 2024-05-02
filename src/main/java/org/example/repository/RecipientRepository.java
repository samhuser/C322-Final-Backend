package org.example.repository;

import org.example.model.Recipient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends CrudRepository<Recipient, String> {
    Recipient findById(int recipientId);
}
