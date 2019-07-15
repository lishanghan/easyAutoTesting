package com.hry.testng.test;

import com.hry.anno.SKey;
import com.hry.po.HryTest;
import com.hry.testng.base.Base;
import com.hry.util.HryHttpClientUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.hry.util.AssertUtil.supperAssert;
@SKey("Local")
public class LocalDefaultTest extends Base{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy", "testingId"})
    public LocalDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @Test(testName = "/html/geth1", dataProvider = "provider", description = "重定向接口")
    public void html_geth1(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

}
