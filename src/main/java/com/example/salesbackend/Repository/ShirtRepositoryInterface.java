package com.example.salesbackend.Repository;

import com.example.salesbackend.Model.Shirt;

import java.util.List;

public interface ShirtRepositoryInterface {
    void addShirt(Shirt shirt);
    void updateShirt(Shirt shirt);
    void deleteShirt(long id);
    Shirt getShirtById(long id);
    List<Shirt> getAllShirts();
}
