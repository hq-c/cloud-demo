package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;
/*@EnableEurekaClient不推荐使用，因为spring中不只支持eureka一种注册中心服务，若写死，以后就只能使用eureka*/
/*spring还支持Zookeeper、Eureka、Consul这些注册中心，使用@EnableDiscoveryClient注解兼容性更好*/
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("cn.itcast.user.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }
}
