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
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenu();
    }
}
