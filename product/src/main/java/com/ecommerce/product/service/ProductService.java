package com.ecommerce.product.service;

import com.ecommerce.product.entity.Product;
import com.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        product.setCreateAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    public Product updateProduct(String id, Product productDetails) {
        Optional<Product> productOpt = productRepository.findById(id);

        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            product.setName(productDetails.getName());
            product.setDescription(productDetails.getDescription());
            product.setQuantity(productDetails.getQuantity());
            product.setVote(productDetails.getVote());
            product.setComment(productDetails.getComment());
            product.setUpdateAt(LocalDateTime.now());

            return productRepository.save(product);
        } else {
            return null;
        }
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}