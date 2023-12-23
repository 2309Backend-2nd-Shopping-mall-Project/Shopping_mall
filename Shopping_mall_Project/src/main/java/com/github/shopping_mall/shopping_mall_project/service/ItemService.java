package com.github.shopping_mall.shopping_mall_project.service;

import com.github.shopping_mall.shopping_mall_project.repository.Item.ItemEntity;
import com.github.shopping_mall.shopping_mall_project.repository.Item.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // 쇼핑몰 전체 물품조회
    public List<ItemEntity> itemList(){
        return itemRepository.findAll();
    }

    // 쇼핑몰 상세 물품 조회
    public ItemEntity itemDetailView(int itemId){
        return itemRepository.findById(itemId).get();
    }
}
