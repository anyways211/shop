package com.hwr.ebusiness.shop.controller;

import com.hwr.ebusiness.shop.modell.Purchase;
import com.hwr.ebusiness.shop.modell.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PurchaseController {

    @Autowired
    PurchaseRepository purchaseRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/purchases")
    public ResponseEntity<List<Purchase>> ShowAllCustomers(){
        List<Purchase> purchases = purchaseRepository.findAll();
        return new ResponseEntity<>(purchases, HttpStatus.OK);
    }
    @GetMapping("/purchase/{id}")
    @ResponseBody
    public ResponseEntity<Purchase> ShowOneCustomers(@PathVariable Long id) {
        Optional<Purchase> purchase = purchaseRepository.findById(id);
        if (purchase.isPresent()){
            return new ResponseEntity<>(purchase.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
