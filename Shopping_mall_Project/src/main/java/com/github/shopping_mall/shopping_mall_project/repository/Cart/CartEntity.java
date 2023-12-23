package com.github.shopping_mall.shopping_mall_project.repository.Cart;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@ToString
@Table(name = "SHOPPING_CART")
@EqualsAndHashCode(of = "cartId")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cartId; // 장바구니 아이디

    @Column(name = "email")
    private String email; // 유저이메일

    private int count; // 카트에 담긴 물품갯수

    @OneToMany(fetch = FetchType.EAGER)
    private List<CartItemEntity> cartItemEntities = new ArrayList<>();

    public static CartEntity createCart(String email){
        CartEntity cart = new CartEntity();
        cart.setEmail(email);
        cart.count = 0;
        return cart;
    }
}
