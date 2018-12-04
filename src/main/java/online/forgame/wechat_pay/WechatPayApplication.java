package online.forgame.wechat_pay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "online.forgame.wechat_pay.mapper")
public class WechatPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatPayApplication.class, args);
    }
}
