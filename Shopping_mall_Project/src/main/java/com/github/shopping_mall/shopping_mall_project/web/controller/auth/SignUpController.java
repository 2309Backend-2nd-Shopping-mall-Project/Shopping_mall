package com.github.shopping_mall.shopping_mall_project.web.controller.auth;


import com.github.shopping_mall.shopping_mall_project.service.auth.AuthService;
import com.github.shopping_mall.shopping_mall_project.web.dto.auth.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/sign")
public class SignUpController {

    private final AuthService authService;

    @PostMapping(value = "/register")
    public String register(@RequestBody SignUp signUpRequest) {
        return authService.signUp(signUpRequest);
    }



}
