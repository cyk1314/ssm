package cn.itcast.usermanage.controller;

import cn.itcast.usermanage.service.UserService;
import cn.itcast.username.pojo.EasyUIResult;
import cn.itcast.username.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cyk on 2018/1/27.
 */
@RequestMapping("user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value="users")
    public String toUsers(){

        return "users";
    }

    @RequestMapping("list")
    @ResponseBody
    public EasyUIResult queryUsersByPage(@RequestParam("page")Integer pageNum, @RequestParam("rows")Integer pageSize){
        return this.userService.queryEasyUIResult(pageNum, pageSize);
    }
    @RequestMapping(value="/page/{pageName}")
    public String toUserAdd(@PathVariable("pageName")String pageName){
    return pageName;
    }
    @RequestMapping(value="save")
    @ResponseBody
    public Map<String,Object> addUser(User user) {
        HashMap<String, Object> map = new HashMap<>();
        Boolean rs = this.userService.addUser(user);
        try {
            if (rs) {
                map.put("status", "200");
            } else {
                map.put("status", "500");
            }
        } catch (Exception e) {
            map.put("status", "500");
            e.printStackTrace();
        }
        return map;
    }
    @RequestMapping("delete")
    @ResponseBody
    public HashMap<String, Object> deleteUser(@RequestParam("ids") Long[] ids){
        HashMap<String, Object> map = new HashMap<>();
        Boolean rs = this.userService.deleteUser(ids);
        try {
            if (rs) {
                map.put("status", "200");
            } else {
                map.put("status", "500");
            }
        } catch (Exception e) {
            map.put("status", "500");
            e.printStackTrace();
        }
        return map;
    }
    @RequestMapping(value="export/excel")
    public String exportExcel(@RequestParam("page")Integer pageNum,@RequestParam("rows")Integer pageSize,Model model){
        EasyUIResult easyUIResult = this.userService.queryEasyUIResult(pageNum,pageSize);
         model.addAttribute("userList", easyUIResult.getRows());
         return "userExcelView";
    }
}
