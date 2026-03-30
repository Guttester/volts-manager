package com.guttester.volts_manager.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.guttester.volts_manager.Model.Product;
import com.guttester.volts_manager.Service.SProduct;

@RestController
@RequestMapping(value = "/products")
public class CProduct {

   @Autowired
   private SProduct serviceProduct;

   @GetMapping
   public ResponseEntity<List<Product>> findAll() {
      List<Product> list = serviceProduct.findAll();
      return ResponseEntity.ok().body(list);
   }

   @GetMapping(value = "/{id}")
   public ResponseEntity<Product> findById(@PathVariable UUID id) {
      Optional<Product> obj = serviceProduct.findById(id);
      // Se achar retorna 200 OK, se não achar 404 Not Found
      return obj.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
   }

   @PostMapping
   public ResponseEntity<Product> save(@RequestBody Product obj) {
      obj = serviceProduct.save(obj);
      return ResponseEntity.ok().body(obj);
   }

   @DeleteMapping(value = "/{id}")
   public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
      serviceProduct.deleteById(id);
      return ResponseEntity.noContent().build();
   }
}