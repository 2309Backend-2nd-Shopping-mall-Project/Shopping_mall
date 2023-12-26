package com.github.shopping_mall.shopping_mall_project.service.security;

import com.github.shopping_mall.shopping_mall_project.repository.userDetails.CustomUserDetails;
import com.github.shopping_mall.shopping_mall_project.repository.user_roles.Roles;
import com.github.shopping_mall.shopping_mall_project.repository.user_roles.UserRoles;
import com.github.shopping_mall.shopping_mall_project.repository.users.User;
import com.github.shopping_mall.shopping_mall_project.repository.users.UserRepository;
import com.github.shopping_mall.shopping_mall_project.service.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Primary
@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmailFetchJoin(email).orElseThrow(() -> new NotFoundException("email에 해당하는 유저가 없습니다."));

        CustomUserDetails customUserDetails = CustomUserDetails.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getUserRoles().stream().map(UserRoles::getRoles).map(Roles::getName).collect(Collectors.toList()))
                .build();

        return customUserDetails;
    }
}
