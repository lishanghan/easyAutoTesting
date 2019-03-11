package com.hry.service;

import com.github.pagehelper.PageInfo;
import com.hry.po.Ti;
import com.hry.po.TiCustom;
import com.hry.vo.TiWithCaseVO;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/9 16:09
 */
public interface TiService {
    Integer insertOne(Ti ti);

    Integer updateOne(Ti ti);

    Integer deleteOne(Integer id);//需谨慎操作,删除ti表的记录,将会连带删除tcase表的记录

    Integer invalidInterface(Integer id);

    Integer deleteByCondition(Ti ti);

    Ti selectOne(Integer id);

    PageInfo<TiCustom> selectByCondition(TiCustom tiCustom, Integer pageNum, Integer pageSize);

    List<Ti> selectByCondition(Ti ti);

    List<Ti> selectByServiceId(Integer serviceId);

    List<Ti> selectByCondition(Ti ti,Boolean hasCase);

    List<Ti> selectAllStatusByCondition(Ti ti);

    List<TiWithCaseVO> selectTiWithCaseVO(Ti ti);
}
