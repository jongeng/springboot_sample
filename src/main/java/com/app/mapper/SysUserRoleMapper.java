package com.app.mapper;

import com.app.entity.SysRole;
import com.app.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface SysUserRoleMapper {
    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    List<SysUserRole> selectByUserId(Integer id);

}