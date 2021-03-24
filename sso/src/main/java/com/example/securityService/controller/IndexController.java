package com.example.securityService.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.common.exceptionhandler.BaseException;
import com.example.common.utils.R;
import com.example.securityService.entity.User;
import com.example.securityService.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/acl/index")
//@CrossOrigin
public class IndexController {

    @Autowired
    private IndexService indexService;

    /**
     * 根据token获取用户信息
     */
    @GetMapping("info")
    public R info(){
        //获取当前登录用户用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, Object> userInfo = indexService.getUserInfo(username);
        return R.ok().data(userInfo);
    }

    /**
     * 获取菜单
     * @return
     */
    @GetMapping("menu")
    public R getMenu(){
        //获取当前登录用户用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if("".equals(username)){
            throw new BaseException(500,"token已过期");
        }
        List<JSONObject> permissionList = indexService.getMenu(username);
        return R.ok().data("permissionList", permissionList);
    }

    @PostMapping("logout")
    public R logout(){
        return R.ok();
    }


    @PostMapping("register")
    public R register(@RequestBody User user){
        return R.ok();
    }

    @GetMapping("session/lose")
    public R sessionLose(){
        return R.ok().data("失败","session已失效，请重新认证");
    }

}
