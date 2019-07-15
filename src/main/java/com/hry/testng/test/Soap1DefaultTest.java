package com.hry.testng.test;

import com.hry.anno.SKey;
import com.hry.po.HryTest;
import com.hry.testng.base.Base;
import com.hry.util.HryHttpClientUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.hry.util.AssertUtil.supperAssert;
@SKey("Soap1")
public class Soap1DefaultTest extends Base{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy", "testingId"})
    public Soap1DefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @Test(testName = "/XR100173", dataProvider = "provider", description = "soap接口测试1")
    public void XR100173(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

}
