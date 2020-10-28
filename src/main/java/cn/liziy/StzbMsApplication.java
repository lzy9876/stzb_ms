package cn.liziy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = ("cn.liziy.dao"))
public class StzbMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StzbMsApplication.class, args);
    }

}
