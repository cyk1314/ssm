package cn.itcast.usermanage.service;

import cn.itcast.username.pojo.EasyUIResult;
import cn.itcast.username.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by cyk on 2018/1/28.
 */
public interface UserService {
    EasyUIResult queryEasyUIResult(Integer pageNum,Integer pageSize);
    public boolean addUser(User user);

   public Boolean deleteUser(Long[] ids);

}
