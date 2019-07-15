package com.hry.testng.test;

import com.hry.anno.SKey;
import com.hry.po.HryTest;
import com.hry.testng.base.Base;
import com.hry.util.HryHttpClientUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.hry.util.AssertUtil.supperAssert;
@SKey("YT")
public class YTDefaultTest extends Base{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy", "testingId"})
    public YTDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @Test(testName = "/sitco/S100010", dataProvider = "provider", description = "风险问卷内容查询")
    public void sitco_S100010(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100040", dataProvider = "provider", description = "开通交易渠道")
    public void sitco_S100040(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100108", dataProvider = "provider", description = "基金类产品份额查询")
    public void sitco_S100108(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100110", dataProvider = "provider", description = "查询转让申请")
    public void sitco_S100110(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100111", dataProvider = "provider", description = "查询转让信息")
    public void sitco_S100111(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100119", dataProvider = "provider", description = "接收短信内容并发送")
    public void sitco_S100119(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100185", dataProvider = "provider", description = "产品列表")
    public void sitco_S100185(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100186", dataProvider = "provider", description = "产品详情查询")
    public void sitco_S100186(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100188", dataProvider = "provider", description = "按产品类型分类统计各类资产")
    public void sitco_S100188(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100411", dataProvider = "provider", description = "发送邮件服务")
    public void sitco_S100411(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100415", dataProvider = "provider", description = "认购预约")
    public void sitco_S100415(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100417", dataProvider = "provider", description = "开通交易渠道（含抢夺手机号）")
    public void sitco_S100417(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100420", dataProvider = "provider", description = "读取crm预约接口")
    public void sitco_S100420(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100437", dataProvider = "provider", description = "交易查询整合")
    public void sitco_S100437(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100451", dataProvider = "provider", description = "客户视频查询待视频客户信息")
    public void sitco_S100451(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100601", dataProvider = "provider", description = "客户经理线上订单查询")
    public void sitco_S100601(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100602", dataProvider = "provider", description = "客户经理确认交易查询")
    public void sitco_S100602(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100603", dataProvider = "provider", description = "客户经理产品购买情况查询")
    public void sitco_S100603(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100604", dataProvider = "provider", description = "客户经理预约数量查询")
    public void sitco_S100604(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100605", dataProvider = "provider", description = "查询未完成线上订单数量")
    public void sitco_S100605(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100608", dataProvider = "provider", description = "基础信息-线上交易信息查询")
    public void sitco_S100608(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100609", dataProvider = "provider", description = "待维系客户列表查询")
    public void sitco_S100609(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100610", dataProvider = "provider", description = "待维系客户数量查询")
    public void sitco_S100610(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100611", dataProvider = "provider", description = "开户在途客户列表查询")
    public void sitco_S100611(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100612", dataProvider = "provider", description = "开户在途客户数量查询")
    public void sitco_S100612(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100613", dataProvider = "provider", description = "获取客户经理头像信息")
    public void sitco_S100613(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100011", dataProvider = "provider", description = "风险测评答案提交")
    public void sitco_S100011(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100107", dataProvider = "provider", description = "非基金类产品持仓查询")
    public void sitco_S100107(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100167", dataProvider = "provider", description = "查询信睿理财账号")
    public void sitco_S100167(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/sitco/S100181", dataProvider = "provider", description = "交易订单查询")
    public void sitco_S100181(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

}
