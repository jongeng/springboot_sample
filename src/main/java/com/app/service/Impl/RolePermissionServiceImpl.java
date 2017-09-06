package com.app.service.Impl;

import com.app.entity.SysRolePermission;
import com.app.mapper.SysPermissionMapper;
import com.app.mapper.SysRolePermissionMapper;
import com.app.service.RolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ${jon} on 2017/8/10.
 */
@Service
public class RolePermissionServiceImpl  implements RolePermissionService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public List<SysRolePermission> findById(Integer id) {
        return sysRolePermissionMapper.selectById(id);
    }
}
