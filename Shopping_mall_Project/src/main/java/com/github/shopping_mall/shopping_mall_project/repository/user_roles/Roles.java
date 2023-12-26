package com.github.shopping_mall.shopping_mall_project.repository.user_roles;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roles_id")
    private Integer rolesId;

    @Column(name = "name", nullable = false)
    private String name;
}
