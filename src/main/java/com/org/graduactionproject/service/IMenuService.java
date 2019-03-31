package com.org.graduactionproject.service;

import com.org.graduactionproject.domain.Menu;

import java.util.List;

public interface IMenuService {
    List<Menu> getMenus();
    Integer updateMenu(Integer menu_id, String title, String access);
    List<Menu> searchMenuByTile(String title);
    List<Menu> getchilMenus();
}
