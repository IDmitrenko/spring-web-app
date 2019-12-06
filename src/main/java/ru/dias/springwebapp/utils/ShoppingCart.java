package ru.dias.springwebapp.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ru.dias.springwebapp.entities.OrderItem;
import ru.dias.springwebapp.entities.Product;
import ru.dias.springwebapp.services.ProductService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
// Корзина должна быть создана внутри сеессии и быть привязана к этой сессии
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {
    private List<OrderItem> items;

    // подшиваем ссылку
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    // Указываем, что после создания корзины List должен сформироваться
    @PostConstruct
    public void init() {
        items = new ArrayList<>();
    }

    // Возможность добавлять товары в корзину по id
    public void addProductById(Long id) {
        Product product = productService.getProductById(id);
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        items.add(orderItem);
    }

}
