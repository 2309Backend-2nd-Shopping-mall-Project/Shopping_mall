package com.github.shopping_mall.shopping_mall_project.service;

import com.github.shopping_mall.shopping_mall_project.repository.Cart.CartEntity;
import com.github.shopping_mall.shopping_mall_project.repository.Cart.CartItemEntity;
import com.github.shopping_mall.shopping_mall_project.repository.Cart.CartItemRepository;
import com.github.shopping_mall.shopping_mall_project.repository.Cart.CartRepository;
import com.github.shopping_mall.shopping_mall_project.repository.Item.ItemEntity;
import com.github.shopping_mall.shopping_mall_project.repository.Item.ItemRepository;
import com.github.shopping_mall.shopping_mall_project.web.dto.cart.CartItemDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CartService {
    private final ItemRepository itemRepository;
//    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderService orderService;

//    // 장바구니 생성
//    public void createCart(String email){
//        CartEntity cart = CartEntity.createCart(email);
//        cartRepository.save(cart);
//    }
//
//    // 장바구니에 물품 추가
//    public void addCart(String email, ItemEntity item, int count){
//        CartEntity cart = cartRepository.findByEmail(email);
//
//        // cart가 비어있다면 생성
//        if(cart == null){
//            cart = CartEntity.createCart(email);
//            cartRepository.save(cart);
//        }
//
//        // cart_item 생성
//        CartItemEntity cartItem = cartItemRepository.findByCartIdAndItemId(cart.getCartId(), item.getItemId());
//
//        // cart_item 비어있으면 새로 생성
//        if(cartItem == null) {
//            cartItem = CartItemEntity.createCartItem(cart, item, count);
//            cartItemRepository.save(cartItem);
//            cartItem.setQuantity(cartItem.getQuantity() + 1);
//        }else {
//            cartItem.addCount(count);
//        }
//    }
//
//    // 장바구니 조회
//    public List<CartItemEntity> userCartView(CartEntity cart){
//        List<CartItemEntity> cartItems = cartItemRepository.findAll();
//        List<CartItemEntity> userItems = new ArrayList<>();
//
//        for(CartItemEntity cartItem : cartItems){
//            if (cartItem.getCartId() == cart.getCartId()){
//                userItems.add(cartItem);
//            }
//        }
//        return userItems;
//    }
//
//    // 장바구니 아이템 삭제
//    public void cartItemDelete(int cartItemId){
//        cartItemRepository.deleteById(cartItemId);
//    }

//    public int addCart(CartItemDto cartItemDto, String email){
//        ItemEntity item = itemRepository.findById(cartItemDto.getItemId()).orElseThrow(EntityNotFoundException::new);
//        // UserEntity user = userRepository.findbyEmail(user.getEmail());
//
//        CartEntity cart = cartRepository.findByEmail(user.getEmail());
//
//        if(cart == null){
//            cart = CartEntity.createCart(user);
//            cartRepository.save(cart);
//        }
//
//        CartItemEntity savedCartItem = cartItemRepository.findByCartIdAndItemId(cart.getCartId(), item.getItemId());
//
//        if(savedCartItem != null){
//            savedCartItem.addCount(cartItemDto.getCount());
//            return savedCartItem.getItemId();
//        }else {
//            CartItemEntity cartItem = CartItemEntity.createCartItem(cart, item, cartItemDto.getCount());
//            cartItemRepository.save(cartItem);
//            return cartItem.getCartId();
//        }
//    }



}
