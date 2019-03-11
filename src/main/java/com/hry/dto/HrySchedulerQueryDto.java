package com.hry.dto;

import com.hry.po.HryScheduler;
import lombok.Data;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/12/24 15:34
 */
@Data
public class HrySchedulerQueryDto {
    private HryScheduler hryScheduler;
    private Integer pageNum;
    private Integer pageSize;
}
