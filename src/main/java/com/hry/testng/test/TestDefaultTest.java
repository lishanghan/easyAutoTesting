package com.hry.testng.test;

import com.hry.anno.SKey;
import com.hry.testng.base.Base;
import org.testng.annotations.Parameters;

import static com.hry.util.AssertUtil.supperAssert;
@SKey("Test")
public class TestDefaultTest extends Base{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy", "testingId"})
    public TestDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

}
