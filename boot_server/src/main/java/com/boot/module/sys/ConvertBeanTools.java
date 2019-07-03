package com.boot.module.sys;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author h3dwy
 * @Description
 * @CreateDate 创建时间：2018-08-03 17:28
 * @ModifiedBy
 * @ModifiedDate
 */
@Slf4j
public class ConvertBeanTools {

    public static <PO, VO> VO convertToVO(PO po) {
        return convertToVO(po, null);
    }

    public static <PO, VO> Iterable<VO> convertGroupToVO(Iterable<PO> poList) {
        return convertGroupToVO(poList, null);
    }

    public static <PO, VO> PO convertToPO(VO vo, boolean patch) {
        return convertToPO(vo, null, patch);
    }

    public static <PO, VO> Iterable<PO> convertGroupToPO(Iterable<VO> voList, boolean patch) {
        return convertGroupToPO(voList, null, patch);
    }

    /**
     * 用于从DO转换为VO，默认全参数复制，如果需要隐藏一些字段，则在对应Entity中覆写
     *
     * @param po
     * @return
     */
    public static <PO, VO> VO convertToVO(PO po, Class<VO> voClass) {
        if (null == po) {
            return null;
        }
        try {
            String voClassName = null == voClass ? ObjectNameTools.poNameToVoName(po.getClass().getName()) : voClass.getName();
            VO vo = (VO) Class.forName(voClassName).newInstance();
            ObjectBeanTools.copyPropertiesIgnoreNull(po, vo);
            return vo;
        } catch (InstantiationException e) {
            log.error("", e);
        } catch (IllegalAccessException e) {
            log.error("", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <PO, VO> Iterable<VO> convertGroupToVO(Iterable<PO> poList, Class<VO> voClass) {
        if (null == poList) {
            return null;
        }
        List<VO> voList = new ArrayList<>();
        for (PO aPoList : poList) {
            voList.add(convertToVO(aPoList, voClass));
        }
        return voList;
    }

    /**
     * @param vo
     * @param patch 是否是增量修改，patch为true，则只把不为null的参数copy到目标中，若为false，则不论是否为null均copy到目标
     * @return
     */
    public static <PO, VO> PO convertToPO(VO vo, Class<PO> poClass, boolean patch) {
        if (null == vo) {
            return null;
        }

        try {
            String poClassName;
            if (null == poClass) {
                poClassName = ObjectNameTools.voNameToPoName(vo.getClass().getName());
            } else {
                poClassName = poClass.getName();
            }

            PO po = (PO) Class.forName(poClassName).newInstance();
            if (patch) {
                ObjectBeanTools.copyPropertiesIgnoreNull(vo, po);
            } else {
                ObjectBeanTools.copyPropertiesNotIgnoreNull(vo, po);
            }
            return po;
        } catch (InstantiationException e) {
            log.error("", e);
        } catch (IllegalAccessException e) {
            log.error("", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param voList
     * @param patch
     * @return
     */
    public static <PO, VO> Iterable<PO> convertGroupToPO(Iterable<VO> voList, Class<PO> poClass, boolean patch) {
        if (null == voList) {
            return null;
        }
        List<PO> poList = new ArrayList<>();
        for (VO str : voList) {
            poList.add(convertToPO(str, poClass, patch));
        }
        return poList;
    }
}
