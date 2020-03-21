package cn.itcast.user.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Data
/*配置实体类对应表名*/
@Table(name = "user")
public class User {
    // 主键
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 姓名
    private String name;

    // 备注，数据库中不存在映射字段，可用 @Transient注解
    @Transient
    private String note;
}
