package com.github.shopping_mall.shopping_mall_project.repository.Cart;

import com.github.shopping_mall.shopping_mall_project.repository.Item.ItemEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Builder
@ToString
@Table(name = "SHOPPING_CART_ITEM")
@EqualsAndHashCode(of = "cartItemId")
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private int cartItemId; // 장바구니에 들어있는 상품 ID

    @Column(name = "cart_id")
    private int cartId; // 장바구니 ID

    @Column(name = "item_id")
    private int itemId; // 아이템 ID

    @Column(name = "option_id")
    private int optionId; // 옵션 ID

    private int quantity; // 수량

    public static CartItemEntity createCartItem(CartEntity cart, ItemEntity item, int quantity){
        CartItemEntity cartItem = new CartItemEntity();
        cartItem.setCartId(cart.getCartId());
        cartItem.setItemId(item.getItemId());
        cartItem.setQuantity(quantity);

        return cartItem;
    }

    public void addCount(int quantity){
        this.quantity += quantity;
    }
}
