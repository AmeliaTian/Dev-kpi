package com.boot.repository;

import java.util.List;

public class MenuTree {
    private String menuId;//id
    private String menuName;//名称
    private List<Au05MenuPO> childrenList;//子集合

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
       return  menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<Au05MenuPO> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Au05MenuPO> childrenList) {
        this.childrenList = childrenList;
    }
}
