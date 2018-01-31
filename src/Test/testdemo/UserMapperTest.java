package testdemo;

import cn.itcast.usermanage.mapper.UserMapper;
import cn.itcast.usermanage.service.UserService;
import cn.itcast.username.pojo.EasyUIResult;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cyk on 2018/1/28.
 */

public class UserMapperTest {
    public UserMapper userMapper;

    @Before
    public void setUp() throws Exception{
        ApplicationContext context= new ClassPathXmlApplicationContext("spring/applicationContext.xml",
        "spring/applicationContext-mybatis.xml");
        this.userMapper=context.getBean(UserMapper.class);
    }




}
