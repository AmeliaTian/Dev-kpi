package com.boot.utils;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author h3dwy
 * @Description
 * @CreateDate 创建时间：2018-11-23 10:17
 * @ModifiedBy
 * @ModifiedDate
 */

public class Test {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        // if(null==map.get("p")){
        //     map.put("p",new ArrayList<>());
        // }
        // map.get("p").add("aa");
        // map.get("p").add("bb");

        map.putIfAbsent("p", new ArrayList<>());

        System.out.println(new Gson().toJson(map));
    }
}
