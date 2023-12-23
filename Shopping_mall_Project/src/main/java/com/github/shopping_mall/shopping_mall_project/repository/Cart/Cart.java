package com.github.shopping_mall.shopping_mall_project.repository.Cart;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SHOPPING_CART")
public class Cart {
    @Id
    @Column(name = "cart_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId; // 장바구니 아이디

    private Integer userId; // 유저 아이디

//    private int count; // 카트에 담긴 물품갯수

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<CartItemEntity> cartItemEntities = new ArrayList<>();

    public static Cart createCart(Integer userId){
        Cart cart = new Cart();
        cart.setCartId(userId);
//        cart.count = 0;
        return cart;
    }

}
