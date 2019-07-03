package com.boot.module.form.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Am01FormMetaCtlTest {

    @Autowired
    private MockMvc mvc;

    private String url = "/form/am01FormMeta";

    @Test
    public void countAm01FormMeta() throws Exception {
        mvc.perform(MockMvcRequestBuilders.head(url))
                .andExpect(MockMvcResultMatchers.status().isOk());
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON)).andReturn();
        //访问返回状态
        int status = mvcResult.getResponse().getStatus();

        //接口返回结果
        String content = mvcResult.getResponse().getContentAsString();
        //打印结果和状态
        System.out.println(status);
        System.out.println(content);
        //预期结果
        String expectedResult = "{\"msgState\":\"SUCCESS\",\"msgDes\":null,\"msgContent\":[]}";

        Assert.assertTrue(status == 200);
        Assert.assertTrue(expectedResult.equals(content));
    }

    @Test
    public void queryAm01FormMeta() throws Exception {
    }

    @Test
    public void saveAm01FormMeta() throws Exception {
    }

    @Test
    public void updateAm01FormMeta() throws Exception {
    }

    @Test
    public void patchAm01FormMeta() throws Exception {
    }

    @Test
    public void removeAm01FormMeta() throws Exception {
    }

}