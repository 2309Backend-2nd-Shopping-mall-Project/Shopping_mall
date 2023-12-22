package com.github.shopping_mall.shopping_mall_project.repository.users;


import com.github.shopping_mall.shopping_mall_project.repository.user_roles.UserRoles;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(of = "userId")
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "login_failure_cnt", nullable = false, columnDefinition = "int DEFAULT 0")
    private Integer loginFailureCnt;

    @Column(name = "is_locked", nullable = false, columnDefinition = "CHAR(1) DEFAULT 'N'")
    private String isLocked;

    @Column(name = "remaining_lock_time", nullable = false)
    private Integer remainingLockTime;

    @Column(name = "sell_role", nullable = false, columnDefinition = "CHAR(1) DEFAULT 'N'")
    private String sellRole;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "user")
    private Collection<UserRoles> userRoles;

}
