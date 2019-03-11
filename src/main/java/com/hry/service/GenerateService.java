package com.hry.service;

import com.hry.po.Tcase;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/11/12 15:46
 */
public interface GenerateService {
    String generateBase(Tcase tcase);
    String generateBase(Integer caseId);
}
