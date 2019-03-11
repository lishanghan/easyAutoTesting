package com.hry.service;

import com.hry.po.Tenv;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/9 9:22
 */
public interface TenvService {
    List<Tenv> selectAll();

    Tenv selectOne(Integer tenvId);

    Integer updateOne(Tenv tenv);

    Integer insertOne(Tenv tenv);

    Integer deleteOne(Integer tenvId);
}
