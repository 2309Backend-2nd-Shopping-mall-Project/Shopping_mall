package com.github.shopping_mall.shopping_mall_project.web.controller;

import com.github.shopping_mall.shopping_mall_project.service.testService;
import com.github.shopping_mall.shopping_mall_project.web.dto.Test;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j

public class TestController {
private final testService testService;

  @GetMapping("/tests")
    public List<Test> findAllItem(){
      List<Test> tests= testService.findAllTest();
      return tests;
  }


}
