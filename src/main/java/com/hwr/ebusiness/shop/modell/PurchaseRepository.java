package com.hwr.ebusiness.shop.modell;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


//Repository für Anfragen auf Entität Purchase
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

    List<Purchase> findAll();
    Optional<Purchase> findById(Long id);

}