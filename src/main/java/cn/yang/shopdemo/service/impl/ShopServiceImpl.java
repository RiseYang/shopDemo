package cn.yang.shopdemo.service.impl;

import cn.yang.shopdemo.entity.Shop;
import cn.yang.shopdemo.mapper.ShopMapper;
import cn.yang.shopdemo.service.ShopService;
import cn.yang.shopdemo.utils.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
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

    @Override
    public void save(MultipartFile file) {
        try {
            List<Shop> shops = ExcelUtil.parseExcel(file.getInputStream());
            shops.forEach(shopMapper::insert);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store excel data: " + e.getMessage());
        }
    }

    @Override
    public void downloadExcel(HttpServletResponse response) {
        List<Shop> shops = shopMapper.findAll();
        ExcelUtil.exportExcel(shops, response);
    }


}
