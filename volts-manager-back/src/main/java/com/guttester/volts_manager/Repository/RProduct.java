package com.guttester.volts_manager.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guttester.volts_manager.Model.Product;

public interface RProduct extends JpaRepository<Product, UUID> {

}
