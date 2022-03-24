package com.hwr.ebusiness.shop.modell;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();

    void deleteById(Long id);
}
