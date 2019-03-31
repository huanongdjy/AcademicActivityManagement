package com.org.graduactionproject.service.impl;

import com.org.graduactionproject.dao.MenuMapper;
import com.org.graduactionproject.domain.Menu;
import com.org.graduactionproject.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {
    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> getMenus() {
        return menuMapper.getMenus();
    }

    @Override
    public Integer updateMenu(Integer menu_id, String title, String access) {
        return menuMapper.updateMenu(menu_id, title, access);
    }

    @Override
    public List<Menu> searchMenuByTile(String title) {
        return menuMapper.searchMenuByTitle(title);
    }

    @Override
    public List<Menu> getchilMenus() {
        return menuMapper.getchilMenus();
    }


}
