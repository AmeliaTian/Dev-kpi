package com.boot.repository;

import com.boot.repository.Au01UserVO;

import java.util.List;

public class KhdxTree {

    private String deptId;//部门id
    private String deptName;//部门名称
    private String deptDes;//部门描述
    private List<Jx12KhztrwInfoVO> jx12KhztrwInfoVOS;

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

    public List<Jx12KhztrwInfoVO> getJx12KhztrwInfoVOS() {
        return jx12KhztrwInfoVOS;
    }

    public void setJx12KhztrwInfoVOS(List<Jx12KhztrwInfoVO> jx12KhztrwInfoVOS) {
        this.jx12KhztrwInfoVOS = jx12KhztrwInfoVOS;
    }
}
