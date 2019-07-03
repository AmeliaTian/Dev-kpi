package com.boot.repository;

import java.util.List;

public class ZbEntity {
    private String khnf;
    private String zblx;
    private Iterable<Jx03YqdzbInfoVO> jx03YqdzbInfoPOList;
   /* private List<Jx01ZbkInfoVO> jx01ZbkInfoVOS;*/
    public String getKhnf() {
        return khnf;
    }

    public void setKhnf(String khnf) {
        this.khnf = khnf;
    }

    public String getZblx() {
        return zblx;
    }

    public void setZblx(String zblx) {
        this.zblx = zblx;
    }

    public Iterable<Jx03YqdzbInfoVO> getJx03YqdzbInfoPOList() {
        return jx03YqdzbInfoPOList;
    }

    public void setJx03YqdzbInfoPOList(Iterable<Jx03YqdzbInfoVO> jx03YqdzbInfoPOList) {
        this.jx03YqdzbInfoPOList = jx03YqdzbInfoPOList;
    }

   /* public List<Jx01ZbkInfoVO> getJx01ZbkInfoVOS() {
        return jx01ZbkInfoVOS;
    }

    public void setJx01ZbkInfoVOS(List<Jx01ZbkInfoVO> jx01ZbkInfoVOS) {
        this.jx01ZbkInfoVOS = jx01ZbkInfoVOS;
    }
*/}
