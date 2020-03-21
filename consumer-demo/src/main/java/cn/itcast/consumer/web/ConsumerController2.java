/*
package cn.itcast.consumer.web;

import cn.itcast.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;



*/
/**
 * 第二种ribbon负载均衡的使用：
 * 启动类中
 *  @Bean
 * @LoadBalanced
 * public RestTemplate restTemplate(){
 *return new RestTemplate();
 *}
 *上增加注解@LoadBalanced；
 * 根据服务ID获取url
 *//*

@RestController
@RequestMapping("consumer2")
public class ConsumerController2 {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("{id}")
    public User getUserById(@PathVariable("id") Long id){
//        “user-server”服务ID
        String url = "http://user-server/user/"+id;
        User user =  this.restTemplate.getForObject(url,User.class);
        return user;
    }
}

*/
