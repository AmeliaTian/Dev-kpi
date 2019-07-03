package com.boot.repository;

import java.util.List;

public class DeptTree {

    private String deptId;//部门id
    private String deptName;//部门名称
    private String deptDes;//部门描述
    private String zbydzt;//部门指标签订状态
    private String khzt;//部门考核状态
    private List<Au01UserVO> childrenList;//当前部门下的子部门集合

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptDes() { return deptDes; }

    public void setDeptDes(String deptDes) { this.deptDes = deptDes; }

    public String getZbydzt() {return zbydzt; }

    public void setZbydzt(String zbydzt) {this.zbydzt = zbydzt; }

    public String getKhzt() {return khzt; }

    public void setKhzt(String khzt) {this.khzt = khzt;}

    public List<Au01UserVO> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Au01UserVO> childrenList) {
        this.childrenList = childrenList;
    }
}
