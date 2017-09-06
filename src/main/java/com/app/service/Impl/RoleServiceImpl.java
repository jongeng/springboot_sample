package com.app.service.Impl;

import com.app.entity.SysRole;
import com.app.mapper.SysRoleMapper;
import com.app.mapper.UserMapper;
import com.app.service.RoleService;
import org.apache.catalina.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ${jon} on 2017/8/10.
 */

@Service
public class RoleServiceImpl  implements RoleService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SysRoleMapper roleMapper;

    @Override
    public SysRole findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
