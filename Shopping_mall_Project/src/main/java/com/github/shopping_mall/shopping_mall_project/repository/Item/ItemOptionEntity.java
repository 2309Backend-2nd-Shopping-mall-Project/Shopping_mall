package com.github.shopping_mall.shopping_mall_project.repository.Item;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "ITEM_OPTION")
@EqualsAndHashCode(of = "itemId")
public class ItemOptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private int optionId;

    private int itemId;

    private String optionContent;

    private String additionalPrice;
}
