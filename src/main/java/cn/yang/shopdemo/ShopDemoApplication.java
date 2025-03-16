package cn.yang.shopdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ShopDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopDemoApplication.class, args);
    }

}
