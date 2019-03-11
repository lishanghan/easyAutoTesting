package com.hry.controller;

import com.hry.po.Tservice;
import com.hry.response.Result;
import com.hry.service.AutocodeService;
import com.hry.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/autocode")
public class AutocodeController {
    @Autowired
    AutocodeService autocodeService;

/*    @PostMapping("/generate")
    public Result generate() {
        return ResultUtil.success(autocodeService.generate());
    }*/

    /**
     * 自动生成测试基类  ,测试基类只有普通方法,没有逻辑,
     * 测试基类地址:com.hry.testng.base
     */
/*
    @PostMapping("/generateBaseClass")
    public Result generateBaseClass() {
        return ResultUtil.success(autocodeService.generateBaseClass());
    }
*/

    /**
     * 自动生成一个默认的测试类,此测试类将继承于测试基类,独立实现单一接口的测试,接口与接口之间并无联系
     * 测试类地址:com.hry.testng.test
     */
/*
    @PostMapping("/generateDefaultClass")
    public Result generateDefaultClass() {
        return ResultUtil.success(autocodeService.generateDefaultTestClass());
    }
*/
    @PostMapping("/generateTestClass")
    public Result generateTestClass() {
        return ResultUtil.success(autocodeService.generateTestClass());
    }

    /**
     * 根据serviceid 生成单个测试类
     *
     * */
    @PostMapping("/generateOneTestClass")
    public Result generateOneTestClass(Integer id) {
        return ResultUtil.success(autocodeService.generateOneTestClass(id));
    }



}


