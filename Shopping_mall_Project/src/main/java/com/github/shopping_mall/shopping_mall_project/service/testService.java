package com.github.shopping_mall.shopping_mall_project.service;

import com.github.shopping_mall.shopping_mall_project.repository.Test.TestEntity;
import com.github.shopping_mall.shopping_mall_project.repository.Test.TestJpaRepository;
import com.github.shopping_mall.shopping_mall_project.service.exceptions.NotFoundException;
import com.github.shopping_mall.shopping_mall_project.service.mapper.TestMapper;
import com.github.shopping_mall.shopping_mall_project.web.dto.Test;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class testService {
    private final TestJpaRepository testJpaRepository;

    public List<Test> findAllTest() {
        List<TestEntity> testEntities= testJpaRepository.findAll();
        if (testEntities.isEmpty()) throw  new NotFoundException("아무 것도 찾을 수 없다");

        return  testEntities.stream().map(TestMapper.INSTANCE::testEntityToTest).collect(Collectors.toList());

    }
}
