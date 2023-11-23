package com.gmy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gmy.entity.SysRole;
import com.gmy.mapper.SysRoleMapper;
import com.gmy.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public List<SysRole> listRolesByUserId(Long id) {
        return this.list(new LambdaQueryWrapper<SysRole>()
                .inSql(SysRole::getId,"select role_id from sys_user_role where user_id = " + id));
    }
}
