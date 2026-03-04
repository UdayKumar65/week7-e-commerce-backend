package service;

import java.util.List;

import controller.Product;
import model.dto.ProductDTO;

public interface ProductService {

    Product createProduct(ProductDTO productDTO);

    Product updateProduct(Long productId, ProductDTO productDTO);

    Product getProductById(Long productId);

    List<Product> getAllProducts();

    void deleteProduct(Long productId);
}