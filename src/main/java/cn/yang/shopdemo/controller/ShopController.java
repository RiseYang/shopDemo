package cn.yang.shopdemo.controller;

import cn.yang.shopdemo.entity.Shop;
import cn.yang.shopdemo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // 使用 @Controller 而不是 @RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping
    public String list(Model model) {
        List<Shop> shops = shopService.findAll();
        model.addAttribute("shops", shops);
        return "shop/list"; // 返回视图名称 "shop/list"
    }

    @GetMapping("/add")
    public String addForm() {
        return "shop/add"; // 返回视图名称 "shop/add"
    }

    @PostMapping("/add")
    public String add(Shop shop) {
        shopService.insert(shop);
        return "redirect:/shop"; // 重定向到列表页面
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        Shop shop = shopService.findById(id);
        model.addAttribute("shop", shop);
        return "shop/edit"; // 返回视图名称 "shop/edit"
    }

    @PostMapping("/edit")
    public String edit(Shop shop) {
        shopService.update(shop);
        return "redirect:/shop"; // 重定向到列表页面
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        shopService.delete(id);
        return "redirect:/shop"; // 重定向到列表页面
    }
}