package com.boot.utils;

import com.google.gson.Gson;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author h3dwy
 * @Description
 * @CreateDate 创建时间：2018-08-13 18:23
 * @ModifiedBy
 * @ModifiedDate
 */

@Data
public class TreeUtilsTest {
    private String id;
    private String name;
    private String pid;
    private List<TreeUtilsTest> testTrees;

    public static void main(String[] args) {
        TreeUtilsTest testTree = new TreeUtilsTest();
        testTree.setId("1001");
        testTree.setName("潍坊市");
        testTree.setPid("1000");
        TreeUtilsTest testTree1 = new TreeUtilsTest();
        testTree1.setId("1002");
        testTree1.setName("青岛市");
        testTree1.setPid("1000");
        TreeUtilsTest testTree2 = new TreeUtilsTest();
        testTree2.setId("1001001");
        testTree2.setName("高新区");
        testTree2.setPid("1001");
        TreeUtilsTest testTree3 = new TreeUtilsTest();
        testTree3.setId("1002001");
        testTree3.setName("四方区");
        testTree3.setPid("1002");
        TreeUtilsTest testTree5 = new TreeUtilsTest();
        testTree5.setId("1001001001");
        testTree5.setName("清池街办");
        testTree5.setPid("1001001");

        TreeUtilsTest testTree4 = new TreeUtilsTest();
        testTree4.setId("1000");
        testTree4.setName("山东省");
        testTree4.setPid("0");


        List<TreeUtilsTest> testTreeList = new ArrayList<>();

        testTreeList.add(testTree);
        testTreeList.add(testTree1);
        testTreeList.add(testTree2);
        testTreeList.add(testTree3);
        testTreeList.add(testTree4);
        testTreeList.add(testTree5);

        TreeUtils.createTree(testTreeList, testTree4, "id", "pid", "testTrees");
        System.out.println(new Gson().toJson(testTree4));
    }
}
