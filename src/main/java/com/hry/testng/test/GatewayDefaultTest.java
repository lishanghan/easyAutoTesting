package com.hry.testng.test;

import com.hry.anno.SKey;
import com.hry.po.HryTest;
import com.hry.testng.base.Base;
import com.hry.util.HryHttpClientUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.hry.util.AssertUtil.supperAssert;
@SKey("Gateway")
public class GatewayDefaultTest extends Base{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy", "testingId"})
    public GatewayDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @Test(testName = "/apis/main/schedule/add", dataProvider = "provider", description = "新增日程")
    public void apis_main_schedule_add(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/user/unsecretlogin", dataProvider = "provider", description = "登陆")
    public void user_unsecretlogin(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

}
