package com.github.shopping_mall.shopping_mall_project.repository.Order;

import com.github.shopping_mall.shopping_mall_project.repository.Item.Item;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@ToString
@Table(name = "ORDER_DETAIL")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private int orderDetailId; // 주문 상세 ID

    @Column(name = "order_id")
    private int orderId; // 주문ID

    @Column(name = "item_id")
    private int itemId; // 상품 ID

    @Column(name = "option_id")
    private int optionId; // 옵션 ID

    @Column(name = "item_cnt")
    private int itemCnt; // 주문 상품 개수

    @Column(name = "item_price")
    private int itemPrice; // 주문 상품 가격

    @Enumerated(EnumType.STRING)
    @Column(name = "order_detail_status")
    private OrderStatus orderStatus; // 주문처리 상태

    @Column(name = "create_date")
    private Timestamp createDate; // 생성일

    public static OrderDetail createOrderItem(Item item, int itemCnt){
        OrderDetail orderItem = new OrderDetail();
        orderItem.setItemId(item.getItemId());
        orderItem.setItemCnt(itemCnt);
        orderItem.setItemPrice(item.getUnitPrice());
        return orderItem;
    }

    public int getTotalPrice(){
        return itemPrice * itemCnt;
    }


}
