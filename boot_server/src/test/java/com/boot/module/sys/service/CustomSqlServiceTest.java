package com.boot.module.sys.service;

import com.boot.module.general.service.CustomNativeSqlService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomSqlServiceTest {

    @Autowired
    private CustomNativeSqlService customSqlService;


    @Test
    public void queryBySqlMapParams() throws Exception {
        //%要有空格
        String sql = "SELECT * FROM am01_form_meta where form_name like '%' :flg '%'";
        Map<String, Object> parm = new HashMap<>();
        parm.put("flg", "A");
        List<Map<String, Object>> ret = customSqlService.queryBySqlMapParams(sql, parm);
        System.out.println(new Gson().toJson(ret));

        String sql2 = "SELECT * FROM am01_form_meta where form_name in (:names)";
        Map<String, Object> parm2 = new HashMap<>();
        //不能是数组
        parm2.put("names", Arrays.asList("AT02_数据字典表", "AT01_对象存储表"));
        List<Map<String, Object>> ret2 = customSqlService.queryBySqlMapParams(sql2, parm2);
        System.out.println(new Gson().toJson(ret2));
    }

    @Test
    public void queryByHqlMapParams() throws Exception {
    }

    @Test
    public void executeSql() throws Exception {
    }

    @Test
    public void executeSqlBatch() throws Exception {
    }

}