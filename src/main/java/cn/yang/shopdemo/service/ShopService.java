package cn.yang.shopdemo.service;

import cn.yang.shopdemo.entity.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> findAll();
    Shop findById(Integer id);
    void insert(Shop shop);
    void update(Shop shop);
    void delete(Integer id);
}
