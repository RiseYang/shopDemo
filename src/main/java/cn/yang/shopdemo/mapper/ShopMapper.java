package cn.yang.shopdemo.mapper;

import cn.yang.shopdemo.entity.Shop;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShopMapper {

    //@Select("SELECT * FROM shop")
    List<Shop> findAll();

    //@Select("SELECT * FROM shop WHERE id = #{id}")
    Shop findById(Integer id);

    //@Insert("INSERT INTO shop(water, na) VALUES(#{water}, #{na})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Shop shop);

    //@Update("UPDATE shop SET water = #{water}, na = #{na} WHERE id = #{id}")
    void update(Shop shop);

    //@Delete("DELETE FROM shop WHERE id = #{id}")
    void delete(Integer id);
}
