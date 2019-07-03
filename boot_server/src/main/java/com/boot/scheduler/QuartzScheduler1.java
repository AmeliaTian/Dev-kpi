package com.boot.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author h3dwy
 * @Description
 * @CreateDate 创建时间：2018-06-14 13:15
 * @ModifiedBy
 * @ModifiedDate
 */

@Slf4j
@Component
public class QuartzScheduler1 {

    /**
     * 定时刷新用户角色
     */
    @Scheduled(cron = "0 0/5 * * * ?")
    public void testScheduler() {
        log.info("scheduler start:---------");
    }
}
