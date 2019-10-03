package ru.dias.springwebapp.repositories;

import org.springframework.stereotype.Component;
import ru.dias.springwebapp.entities.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Milk", 90));
        products.add(new Product(2L, "Cheese", 590));
        products.add(new Product(3L, "Ball", 390));

    }

    public void deleteById(Long id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                products.remove(i);
                return;
            }
        }
    }
}
