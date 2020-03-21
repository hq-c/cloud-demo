package cn.itcast.consumer.web;

import cn.itcast.consumer.client.UserClient;
import cn.itcast.consumer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.utils.FallbackMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.hystrix.HystrixProperties;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 第一种实现ribbon负载均衡的使用*/


@RestController
@RequestMapping("consumer")
@DefaultProperties(defaultFallback = "queryByIdFallback")
public class ConsumerController {
/*    @Autowired
    private LoadBalancerClient client;
    @Autowired
    private RestTemplate restTemplate;*/

    @Autowired
    private UserClient userClient;
    @GetMapping("{id}")
    /*设置单独返回fallback方法：服务熔断后，返回的方法fallbackMethod=“”；返回的值类型必须和正常返回的一致*/
//    @HystrixCommand(fallbackMethod = "queryByIdFallback")
    /*设置超时时长2s*/
/*    @HystrixCommand(commandProperties={
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })*/
    @HystrixCommand(commandProperties={
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String getUserById(@PathVariable("id") Long id){
 /*       if (id % 2 == 0){
            throw new RuntimeException("?????");
        }
//        根据服务id获取实例
        ServiceInstance instance = client.choose("user-server");
//        从服务中取出ip和端口
        String url = "http://"+instance.getHost()+":"+instance.getPort()+"/user/"+id;
//        String url = "http://localhost:8081/user/"+id;
        User user =  restTemplate.getForObject(url,User.class);
        user.setNote(String.valueOf(instance.getPort()));
        return user.toString();*/

    return userClient.getUserById(id);
    }

    public String queryByIdFallback(Long id){
        return "不好意思，服务器太拥挤了";
    }
/*通用fallback方法不能传递参数*/
    public String queryByIdFallback(){
        return "不好意思，服务器太拥挤了";
    }
}

