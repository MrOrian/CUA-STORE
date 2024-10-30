package com.example.salesbackend.Repository;

import com.example.salesbackend.Model.Pants;

import java.util.List;

public interface PantsRepositoryInterface {
    void addPants(Pants pants);
    void updatePants(Pants pants);
    void deletePants(long id);
    Pants getPantsById(long id);
    List<Pants> getAllPants();
}
