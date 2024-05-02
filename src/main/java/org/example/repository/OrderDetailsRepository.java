package org.example.repository;

import org.example.model.OrderDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetails, String> {
    OrderDetails findById(int orderId);
}
