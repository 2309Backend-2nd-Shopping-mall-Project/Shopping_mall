package com.github.shopping_mall.shopping_mall_project.repository.Cart;

import com.github.shopping_mall.shopping_mall_project.repository.Item.Item;
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
@Table(name = "SHOPPING_CART_ITEM")
public class CartItem {
    @Id
    @Column(name = "cart_item_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemId; // 장바구니에 들어있는 상품 ID

    @Column(name = "cart_id")
    private Integer cartId; // 장바구니 ID

    @Column(name = "item_id")
    private Integer itemId; // 아이템 ID

    @Column(name = "option_id")
    private Integer optionId; // 옵션 ID

    @Column(name = "quantity")
    private Integer quantity; // 수량

    public static CartItem createCartItem(Cart cart, Item item, int quantity){
        CartItem cartItem = new CartItem();
        cartItem.setCartId(cart.getCartId());
        cartItem.setItemId(item.getItemId());
        cartItem.setQuantity(cartItem.quantity);

        return cartItem;
    }

    public void addCount(int quantity){
        this.quantity += quantity;
    }
}
