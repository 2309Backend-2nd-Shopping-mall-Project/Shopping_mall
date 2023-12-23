package com.github.shopping_mall.shopping_mall_project.repository.Item;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "ITEM")
@EqualsAndHashCode(of = "itemId")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemId;

    @Column(name = "email")
    private String email;

    @Column(name = "category_id")
    private int categoryId;

    private int unitPrice;

    private Timestamp startDate;

    private Timestamp endDate;
}
