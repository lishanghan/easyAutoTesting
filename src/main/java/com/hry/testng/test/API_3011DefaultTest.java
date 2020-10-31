package com.hry.testng.test;

import com.hry.anno.SKey;
import com.hry.po.HryTest;
import com.hry.testng.base.Base;
import com.hry.util.HryHttpClientUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.hry.util.AssertUtil.supperAssert;
@SKey("API_3011")
public class API_3011DefaultTest extends Base{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy", "testingId"})
    public API_3011DefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @Test(testName = "/user/login", dataProvider = "provider", description = "登录接口")
    public void user_login(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test,this);
    }

    @Test(testName = "/user/getSubList", dataProvider = "provider", description = "获取游戏小号列表")
    public void user_getSubList(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test,this);
    }

    @Test(testName = "/test", dataProvider = "provider", description = "测试不用理会")
    public void test(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test,this);
    }

    @Test(testName = "/user/register", dataProvider = "provider", description = "注册接口")
    public void user_register(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test, this);
    }

}
