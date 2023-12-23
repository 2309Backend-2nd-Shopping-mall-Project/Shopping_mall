package com.github.shopping_mall.shopping_mall_project.repository.Order;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "ORDER")
@EqualsAndHashCode(of = "orderId")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId; // 주문번호

    @Column(name = "email")
    private String email; // 유저 이메일

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
