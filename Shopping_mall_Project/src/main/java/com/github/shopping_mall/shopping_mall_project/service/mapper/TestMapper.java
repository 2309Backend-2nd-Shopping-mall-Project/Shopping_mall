package com.github.shopping_mall.shopping_mall_project.service.mapper;

import com.github.shopping_mall.shopping_mall_project.repository.Test.TestEntity;
import com.github.shopping_mall.shopping_mall_project.web.dto.Test;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TestMapper {


    TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);



    Test testEntityToTest(TestEntity testEntity);



}
