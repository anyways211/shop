package com.hwr.ebusiness.shop.controller;

import com.hwr.ebusiness.shop.modell.Purchase;
import com.hwr.ebusiness.shop.modell.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//händelt Abfragen unter /purchase
@RestController
public class PurchaseController {

    @Autowired
    PurchaseRepository purchaseRepository;
    //alle Einkäufe anzeigen
    @RequestMapping(method = RequestMethod.GET, path = "/purchases")
    public ResponseEntity<List<Purchase>> ShowAllPurchases(){
        //alle einkäufe auflisten
        List<Purchase> purchases = purchaseRepository.findAll();
        //Liste ausgeben
        return new ResponseEntity<>(purchases, HttpStatus.OK);
    }
    //einen einkauf nach id anzeigen
    @GetMapping("/purchase/{id}")
    @ResponseBody
    public ResponseEntity<Purchase> ShowOnePurchase(@PathVariable Long id) {
        //suchen
        Optional<Purchase> purchase = purchaseRepository.findById(id);
        if (purchase.isPresent()){
            //wenn gefunden, ausgeben
            return new ResponseEntity<>(purchase.get(), HttpStatus.OK);
        }
        else {
            //wenn nicht gefunden, fehler
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
