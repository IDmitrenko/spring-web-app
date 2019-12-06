package ru.dias.springwebapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dias.springwebapp.entities.Order;
import ru.dias.springwebapp.entities.OrderItem;
import ru.dias.springwebapp.entities.User;
import ru.dias.springwebapp.repositories.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrderFromItems(User user, List<OrderItem> items) {
        Order order = new Order();
        order.setItems(new ArrayList<>());
        order.setUser(user);
        // перекидываем из корзины в заказ
        items.stream().forEach(item -> {
            order.getItems().add(item);
            item.setOrder(order);
        });
        // очищаем корзину
        items.clear();
        // сохраняем заказ в базе
        return orderRepository.save(order);
    }
}
