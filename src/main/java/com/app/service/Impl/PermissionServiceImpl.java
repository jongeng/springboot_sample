package com.app.service.Impl;

import com.app.entity.SysPermission;
import com.app.mapper.SysPermissionMapper;
import com.app.mapper.SysRoleMapper;
import com.app.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ${jon} on 2017/8/10.
 */
@Service
public class PermissionServiceImpl implements PermissionService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SysPermissionMapper sysPermissionMapper;


    @Override
    public SysPermission findById(Integer id) {
        return sysPermissionMapper.selectByPrimaryKey(id);
    }
}
