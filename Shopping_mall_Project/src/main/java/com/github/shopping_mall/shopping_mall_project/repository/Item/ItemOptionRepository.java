package com.github.shopping_mall.shopping_mall_project.repository.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOptionRepository extends JpaRepository<ItemOptionEntity, ItemOption> {

}
