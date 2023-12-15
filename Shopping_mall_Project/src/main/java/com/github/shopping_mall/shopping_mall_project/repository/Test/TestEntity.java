package com.github.shopping_mall.shopping_mall_project.repository.Test;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@ToString
@Entity
@Table(name="test")
public class TestEntity {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Integer id;

    @Column(name="name",length = 50,nullable = false,unique = true)
    private String name;


}
