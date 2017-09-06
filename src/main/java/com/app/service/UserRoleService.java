package com.app.service;

import com.app.entity.SysRole;
import com.app.entity.SysUserRole;

import java.util.List;

/**
 * Created by ${jon} on 2017/8/10.
 */
public interface UserRoleService {

    public List<SysUserRole> findById(Integer id);

}
