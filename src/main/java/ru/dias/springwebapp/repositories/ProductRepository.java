package ru.dias.springwebapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dias.springwebapp.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // указываем, что мы так хотим искать по полю
    Product findOneByTitle(String title);
// указываем, что я хочу получить лист продуктов по цене ограниченной рамками
//    List<Product> findAllByPriceBetweenAndTitle(int min, int max, String title);
// criteria API в Spring Data позволит собрать по кусочкам сложные запросы без написания SQL или HQL
}
