package com.hry.service;

import com.hry.po.AutoRateStatistic;
import com.hry.po.RealtimeStatistic;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/9 13:21
 */
public interface StatisticService {
    /*List<RealtimeStatistic> statisticCurrentOld();*/

    List<RealtimeStatistic> statisticCurrent();

    List<AutoRateStatistic> statisticCustomRate();
}
