package com.github.shopping_mall.shopping_mall_project.repository.Order;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId; // 주문번호

    @Column(name = "user_id")
    private Integer userId; // 유저 아이디

    @Column(name = "zipcode")
    private String zipCode; // 주문우편번호

    @Column(name = "address")
    private String address; // 주문 주소

    @Column(name = "address_detail")
    private String addressDetail; // 주문 상세주소

    @Column(name = "req_upon_delivery")
    private String reqUponDelivery; // 배송시 요청사항

    @Column(name = "receiver_name")
    private String receiverName; // 수령자 이름

    @Column(name = "receiver_phone")
    private String receiverPhone; // 수령자 전화번호
}
