package com.gmy.service;

import com.gmy.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface SysRoleService extends IService<SysRole> {

    List<SysRole> listRolesByUserId(Long id);
}
