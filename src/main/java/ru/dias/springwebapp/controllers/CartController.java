package ru.dias.springwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dias.springwebapp.utils.ShoppingCart;

@Controller
@RequestMapping("/cart")
public class CartController {
    private ShoppingCart cart;

    @Autowired
    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    // показать корзину, если придет корневой запрос
    @GetMapping("")
    public String showCart(Model model) {
        model.addAttribute("products", cart.getProducts());
        return "cart";
    }

    // добавление в корзину
    @GetMapping("/add/{id}")
    public String addProductToCart(Model model, @PathVariable("id") Long id) {
        cart.addProductById(id);
        // возвращаем пользователя на главную страницу магазина
        return "redirect:/shop";
    }
}
