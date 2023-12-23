package com.github.shopping_mall.shopping_mall_project.web.controller.cart;

import com.github.shopping_mall.shopping_mall_project.repository.Item.ItemEntity;
import com.github.shopping_mall.shopping_mall_project.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
@Slf4j
public class CartController {
    private final CartService cartService;


}
