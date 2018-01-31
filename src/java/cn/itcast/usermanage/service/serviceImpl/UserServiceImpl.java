package cn.itcast.usermanage.service.serviceImpl;

import cn.itcast.usermanage.mapper.UserMapper;
import cn.itcast.usermanage.service.UserService;
import cn.itcast.username.pojo.EasyUIResult;
import cn.itcast.username.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cyk on 2018/1/28.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public EasyUIResult queryEasyUIResult(Integer pageNum, Integer pageSize) {
//        List<User> list=this.userMapper.queryUsersByPage((pageNum-1)*pageSize,pageSize);
//        EasyUIResult easyUIResult = new EasyUIResult();
//        easyUIResult.setRows(list);
//        easyUIResult.setTotal(5l);
//        return easyUIResult;
        PageHelper.startPage(pageNum,pageSize);
        List<User> list=this.userMapper.queryUserAll();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        EasyUIResult easyUIResult = new EasyUIResult();
        easyUIResult.setRows(pageInfo.getList());
         easyUIResult.setTotal(pageInfo.getTotal());
         return easyUIResult;
    }

    @Override
    public boolean addUser(User user) {
        int i = this.userMapper.addUser(user);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteUser(Long[] ids) {
        int i = this.userMapper.deleteUser(ids);
        if(i>0){
            return true;
        }
        return false;
    }



}
