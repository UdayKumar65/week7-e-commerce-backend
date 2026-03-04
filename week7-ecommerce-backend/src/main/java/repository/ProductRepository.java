package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}