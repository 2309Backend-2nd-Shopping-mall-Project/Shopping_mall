package com.github.shopping_mall.shopping_mall_project.repository.Test;

import com.github.shopping_mall.shopping_mall_project.repository.Test.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TestJpaRepository extends JpaRepository<TestEntity, Integer> {

    List<TestEntity> findAll();
}
