package ru.dias.springwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dias.springwebapp.entities.Order;
import ru.dias.springwebapp.entities.User;
import ru.dias.springwebapp.services.OrderService;
import ru.dias.springwebapp.services.UserService;
import ru.dias.springwebapp.utils.ShoppingCart;

import java.security.Principal;
import java.util.ArrayList;

@Controller
@RequestMapping("/cart")
public class CartController {
    private ShoppingCart cart;
    private OrderService orderService;
    private UserService userService;

    @Autowired
    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // показать корзину, если придет корневой запрос
    @GetMapping("")
    public String showCart(Model model) {
        model.addAttribute("items", cart.getItems());
        return "cart";
    }

    // добавление в корзину
    @GetMapping("/add/{id}")
    public String addProductToCart(Model model, @PathVariable("id") Long id) {
        cart.addProductById(id);
        // возвращаем пользователя на главную страницу магазина
        return "redirect:/shop";
    }

    // сохранение заказа
    @GetMapping("/create_order")
    public String createOrder(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        orderService.createOrderFromItems(user, cart.getItems());
        // возвращаем пользователя на главную страницу магазина
        return "redirect:/shop";
    }
}
