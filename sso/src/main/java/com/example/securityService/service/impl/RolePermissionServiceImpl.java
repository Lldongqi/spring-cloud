package com.example.securityService.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.securityService.entity.RolePermission;
import com.example.securityService.mapper.RolePermissionMapper;
import com.example.securityService.service.RolePermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色权限 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {

}
