package com.github.shopping_mall.shopping_mall_project.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT up FROM User up JOIN fetch up.userRoles upr JOIN fetch upr.roles WHERE up.email = :email ")
    Optional<User> findByEmailFetchJoin(String email);

    boolean existsByEmail(String email);

    Optional<User> findByUserId(Integer userId);

    Optional<User> findByNickname(String nickname);

}
