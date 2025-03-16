package cn.yang.shopdemo.service.impl;

import cn.yang.shopdemo.entity.Shop;
import cn.yang.shopdemo.mapper.ShopMapper;
import cn.yang.shopdemo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public List<Shop> findAll() {
        return shopMapper.findAll();
    }

    @Override
    public Shop findById(Integer id) {
        return shopMapper.findById(id);
    }

    @Override
    public void insert(Shop shop) {
        shopMapper.insert(shop);
    }

    @Override
    public void update(Shop shop) {
        shopMapper.update(shop);
    }

    @Override
    public void delete(Integer id) {
        shopMapper.delete(id);
    }
}
