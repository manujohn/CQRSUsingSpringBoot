package com.example.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.event.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {

}
