package ru.dias.springwebapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dias.springwebapp.entities.Product;
import ru.dias.springwebapp.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getProducts();
    }

    public Product getProductById(Long id) {
        return productRepository.getProducts().get(id.intValue() - 1);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
