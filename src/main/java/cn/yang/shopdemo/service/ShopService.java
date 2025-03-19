package cn.yang.shopdemo.service;

import cn.yang.shopdemo.entity.Shop;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface ShopService {
    List<Shop> findAll();
    Shop findById(Integer id);
    void insert(Shop shop);
    void update(Shop shop);
    void delete(Integer id);


    void save(MultipartFile file);

    void downloadExcel(HttpServletResponse response);
}
