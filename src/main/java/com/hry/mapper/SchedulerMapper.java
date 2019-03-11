package com.hry.mapper;

import com.hry.po.HryJob;
import com.hry.po.HryScheduler;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/12/24 14:06
 */
public interface SchedulerMapper {
    List<HryScheduler> selectAll(HryScheduler hryScheduler);

    List<HryScheduler> selectHryJob(HryJob hryJob);
}
