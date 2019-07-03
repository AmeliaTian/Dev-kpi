package com.boot.module.auth.service.impl;

import com.boot.repository.Au01UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Au01UserServiceTest {

    @Autowired
    private Au01UserServiceImpl au01UserService;

    @Test
    public void patchEntity() throws Exception {
        List<Au01UserVO> au01UserVOS = new ArrayList<>();
        Au01UserVO vo1 = new Au01UserVO();
        vo1.setId("1");
        vo1.setPassword("ONEP2");
        vo1.setAccountEnabled("T");
        au01UserVOS.add(vo1);

        Au01UserVO vo2 = new Au01UserVO();
        vo2.setId("111");
        vo2.setPassword("ONEP2");
        vo2.setAccountEnabled("T");
        au01UserVOS.add(vo2);

        au01UserService.saveEntity(au01UserVOS);
    }
}