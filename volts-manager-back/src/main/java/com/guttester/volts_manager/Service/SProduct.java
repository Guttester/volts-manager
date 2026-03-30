package com.guttester.volts_manager.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guttester.volts_manager.Model.Product;
import com.guttester.volts_manager.Repository.RProduct;

@Service
public class SProduct {

   @Autowired
   private RProduct repositoryProduct;

   public List<Product> findAll() {
      return repositoryProduct.findAll();
   }

   public Optional<Product> findById(UUID id) {
      return repositoryProduct.findById(id);
   }

   public Product save(Product obj) {
      return repositoryProduct.save(obj);
   }

   public void deleteById(UUID id) {
      repositoryProduct.deleteById(id);
   }
}