package cn.itcast.user.service;

import cn.itcast.user.mapper.UserMapper;
import cn.itcast.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User quaryById(Long id){
 /*       try {
            Thread.sleep(1500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return userMapper.selectByPrimaryKey(id);
    }
    @Transactional
    public void insertUser(User user){
        userMapper.insert(user);
    }
}
