package com.hwr.ebusiness.shop.modell;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//Repository zum händeln von Anfragen auf Entität Produkt
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    void deleteById(Long id);
}
