package com.github.shopping_mall.shopping_mall_project.repository.Item;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "ITEM")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "unit_price")
    private Integer unitPrice;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;
}
