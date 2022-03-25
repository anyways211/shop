package com.hwr.ebusiness.shop.modell;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


//Repository für Anfragen auf Entität Purchase
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

    List<Purchase> findAll();

}