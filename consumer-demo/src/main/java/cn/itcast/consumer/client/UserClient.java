package cn.itcast.consumer.client;

import cn.itcast.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/*请求服务名-0422*/
@FeignClient(value = "user-server",fallback = UserClientFallback.class)
public interface UserClient {
    /*请求方式，请求路径，返回数据类型，请求参数*/
    @GetMapping("user/{id}")
    String getUserById(@PathVariable("id") Long id);
    @RequestMapping(value = "/save",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    String saveUser(User user);

}
