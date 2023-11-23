package com.gmy.service;

import com.gmy.common.vo.SysMenuVo;
import com.gmy.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface SysMenuService extends IService<SysMenu> {

    List<SysMenuVo> getCurrentUserNav();

    List<SysMenu> tree();

}
