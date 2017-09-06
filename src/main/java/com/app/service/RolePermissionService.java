package com.app.service;

import com.app.entity.SysPermission;
import com.app.entity.SysRolePermission;

import java.util.List;

/**
 * Created by ${jon} on 2017/8/10.
 */
public interface RolePermissionService {

    public List<SysRolePermission> findById(Integer id);

}
