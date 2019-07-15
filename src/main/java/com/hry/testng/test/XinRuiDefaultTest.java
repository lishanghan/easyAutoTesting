package com.hry.testng.test;

import com.hry.anno.SKey;
import com.hry.po.HryTest;
import com.hry.testng.base.Base;
import com.hry.util.HryHttpClientUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.hry.util.AssertUtil.supperAssert;
@SKey("XinRui")
public class XinRuiDefaultTest extends Base{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy", "testingId"})
    public XinRuiDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @Test(testName = "/xrms/xrapi/xr100004/4/23", dataProvider = "provider", description = "申请单信息记录查询接口")
    public void xrms_xrapi_xr100004_4_23(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/xrms/xrapi/xr100004/1/23", dataProvider = "provider", description = "新增申请单信息记录")
    public void xrms_xrapi_xr100004_1_23(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

}
