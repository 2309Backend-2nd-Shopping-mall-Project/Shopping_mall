package com.github.shopping_mall.shopping_mall_project.service.auth;

import com.github.shopping_mall.shopping_mall_project.repository.user_roles.Roles;
import com.github.shopping_mall.shopping_mall_project.repository.user_roles.RolesRepository;
import com.github.shopping_mall.shopping_mall_project.repository.user_roles.UserRoles;
import com.github.shopping_mall.shopping_mall_project.repository.user_roles.UserRolesRepository;
import com.github.shopping_mall.shopping_mall_project.repository.users.User;
import com.github.shopping_mall.shopping_mall_project.repository.users.UserRepository;
import com.github.shopping_mall.shopping_mall_project.service.exceptions.NotFoundException;
import com.github.shopping_mall.shopping_mall_project.service.exceptions.RecordExistsException;
import com.github.shopping_mall.shopping_mall_project.service.exceptions.ValidationException;
import com.github.shopping_mall.shopping_mall_project.service.mapper.UserMapper;
import com.github.shopping_mall.shopping_mall_project.web.dto.auth.SignUp;
import com.github.shopping_mall.shopping_mall_project.web.dto.auth.SignUpResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UserRolesRepository userRolesRepository;
    private final RolesRepository rolesRepository;
    private PasswordEncoder passwordEncoder;

    public String signUp(SignUp signUpRequest) {
        String email = signUpRequest.getEmail();
        String password = signUpRequest.getPassword();
        String name = signUpRequest.getName();
        String nickname = signUpRequest.getNickname();
        String phoneNumber = signUpRequest.getPhoneNumber();
        String gender = signUpRequest.getGender();
        String address = signUpRequest.getAddress();

        if(!email.matches(".+@.+\\..+")){
            throw new ValidationException("이메일을 양식을 지켜주세요.");
        } else if (!phoneNumber.matches("010\\d{8}")) {
            throw new ValidationException("핸드폰 번호를 정활히 기입해주세요.");
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())){
            throw new RecordExistsException("해당 이메일로 가입한 게정이 존재합니다.");
        }else if(!password.matches("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]+$")
                ||!(password.length()>=8&&password.length()<=20)
        ){
            throw new ValidationException("비밀번호는 8자 이상 20자 이하 숫자와 영문자 조합 이어야 합니다.");
        }

        signUpRequest.setPassword(passwordEncoder.encode(password));

        Roles roles = rolesRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new NotFoundException("ROLE_USER를 찾을 수 없습니다."));

        User user = UserMapper.INSTANCE.signUpRequestToUserEntity(signUpRequest);
        userRepository.save(user);

        userRolesRepository.save(UserRoles.builder()
                .user(user)
                .roles(roles)
                .build());

        SignUpResponse signUpResponse = UserMapper.INSTANCE.userEntityToSignUpResponse(user);

        return signUpResponse.getName()+"님 환영합니다!";

    }
}
