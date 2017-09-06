package com.app.mapper;

import com.app.entity.SysRolePermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysRolePermissionMapper {
    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    List<SysRolePermission> selectById(Integer id);
}