package com.boot.repository.common;

import com.boot.module.general.service.CustomNativeSqlService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomHqlDAOTest {

    @Autowired
    private CustomNativeSqlService customhqlService;

    @Test
    public void queryByListParams() throws Exception {
        String hql = "from Am02FormMetaItemPO u where formId = :formId and metaSeq=:metaSeq2";
        Map<String, Object> params = new HashMap<>();
        params.put("formId", "11");
        params.put("metaSeq2", 160);

        System.out.println(new Gson().toJson(customhqlService.queryByHqlMapParams(hql, params, 0, 20)));

        System.out.println(new Gson().toJson(customhqlService.queryByHqlMapParams("select count(*) as a from Am02FormMetaItemPO", null, 0, 20)));

    }

    @Test
    public void queryByMapParams() throws Exception {
    }

    @Test
    public void executeSql() throws Exception {
    }

}