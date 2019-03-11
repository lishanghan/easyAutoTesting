package com.hry.vo;

import com.hry.po.Tcustom;
import com.hry.po.Tcustomdetail;
import lombok.Data;

import java.util.List;

/**
 * @Description: Tcustom视图对象
 * @Author: luqiwei
 * @Date: 2018/7/12 9:14
 */
@Data
public class CustomVO extends Tcustom {
    private List<Tcustomdetail> tcustomdetails;
}
