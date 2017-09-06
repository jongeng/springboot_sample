package com.app.service.Impl;

import com.app.entity.SysUserRole;
import com.app.mapper.SysUserRoleMapper;
import com.app.service.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ${jon} on 2017/8/10.
 */
@Service
public class UserRoleServiceImpl implements UserRoleService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;


    @Override
    public List<SysUserRole> findById(Integer id) {
        return sysUserRoleMapper.selectByUserId(id);
    }
}
