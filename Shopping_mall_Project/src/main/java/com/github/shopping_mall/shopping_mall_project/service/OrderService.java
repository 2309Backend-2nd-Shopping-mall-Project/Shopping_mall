package com.github.shopping_mall.shopping_mall_project.service;

import com.github.shopping_mall.shopping_mall_project.repository.Item.ItemRepository;
import com.github.shopping_mall.shopping_mall_project.repository.Order.OrderDetailRepository;
import com.github.shopping_mall.shopping_mall_project.repository.Order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ItemRepository itemRepository;
//    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;




}
