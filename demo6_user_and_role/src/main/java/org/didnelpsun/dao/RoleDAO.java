package org.didnelpsun.dao;

import org.didnelpsun.entity.Role;

import java.util.List;

public interface RoleDAO {
    // 查询所有角色
    List<Role> selectAllRoles();
    // 查询所有角色与对应用户
    List<Role> selectAllRoleUsers();
}
