package cn.itcast.consumer.client;

import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public String getUserById(Long id) {
        return "feign的熔断机制，谢谢服务器异常";
    }
}
