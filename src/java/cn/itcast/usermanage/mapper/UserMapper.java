package cn.itcast.usermanage.mapper;

import cn.itcast.username.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by cyk on 2018/1/28.
 */
public interface UserMapper {
    public User queryUserById(Long id);
    public List<User> queryUsersByPage(@Param("start")Integer start, @Param("pageSize")Integer pageSize);
    public List<User> queryUserAll();
    public int addUser(User user);
    public int deleteUser(@Param("ids")Long[] ids);


}
