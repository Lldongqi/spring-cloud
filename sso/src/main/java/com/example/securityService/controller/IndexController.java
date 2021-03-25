package com.example.securityService.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.common.exceptionhandler.BaseException;
import com.example.common.utils.R;
import com.example.security.DefaultPasswordEncoder;
import com.example.securityService.entity.User;
import com.example.securityService.request.RegisterForm;
import com.example.securityService.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/admin/acl/index")
//@CrossOrigin
public class IndexController {

    @Autowired
    private IndexService indexService;
    @Autowired
    private PasswordEncoder passwordEncoder;
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
        List<JSONObject> permissionList = indexService.getMenu(username);
        return R.ok().data("permissionList", permissionList);
    }

    @PostMapping("logout")
    public R logout(){
        return R.ok();
    }


    @PostMapping("register")
    public R register(@Validated @RequestBody RegisterForm registerForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
          log.error("参数错误");
          return R.error().data("失败","参数错误");
        }
        User usr = new User();
        usr.setNickName(registerForm.getName());
        usr.setUsername(registerForm.getName());
        usr.setPassword(passwordEncoder.encode(registerForm.getPassword()));
        Boolean isTrue = indexService.register(usr);
        if(isTrue){
            return R.ok().data("成功","注册成功");
        }
        return R.error().data("失败","注册失败");
    }

    @GetMapping("session/lose")
    public R sessionLose(){
        return R.ok().data("失败","session已失效，请重新认证");
    }

}
