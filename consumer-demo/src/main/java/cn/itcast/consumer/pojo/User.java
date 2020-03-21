package cn.itcast.consumer.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable{
    private Long id;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 姓名
    private String name;
    private String note;
}
