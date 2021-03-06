package com.example.securityService.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.securityService.entity.UserRole;
import com.example.securityService.mapper.UserRoleMapper;
import com.example.securityService.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
