package com.hry.testng.test;

import com.hry.anno.SKey;
import com.hry.po.HryTest;
import com.hry.testng.base.Base;
import com.hry.util.HryHttpClientUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.hry.util.AssertUtil.supperAssert;
@SKey("Crm")
public class CrmDefaultTest extends Base{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy", "testingId"})
    public CrmDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @Test(testName = "/api/Account/CreateAccount", dataProvider = "provider", description = "客户-创建客户-基本信息 缺少字段 家庭年收入")
    public void api_Account_CreateAccount(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/api/Account/StAccount", dataProvider = "provider", description = "客户列表搜索不确定字段 线上交易开通状态 、身份认证缺少字段最近联系时间")
    public void api_Account_StAccount(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/api/Account/StAccountDetails", dataProvider = "provider", description = "客户-个人信息不确定字段 是否事实客户、证件照片状态、是否信睿账户、风险评测有效期 缺少字段 年龄")
    public void api_Account_StAccountDetails(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/api/Account/StAdvancedAccountDetails", dataProvider = "provider", description = "客户-获取客户高级信息缺少字段 家庭年收入、职业")
    public void api_Account_StAdvancedAccountDetails(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/api/Account/StSelectAccount", dataProvider = "provider", description = "待办事项-新建待办事项-客户选择")
    public void api_Account_StSelectAccount(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/api/Account/UpdateAccount", dataProvider = "provider", description = "客户-更新客户-基本信息缺少字段 家庭年收入")
    public void api_Account_UpdateAccount(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/api/Account/UpdateAdvancedAccount", dataProvider = "provider", description = "客户-更新客户高级信息 缺少字段 家庭年收入、职位")
    public void api_Account_UpdateAdvancedAccount(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/api/AccountEquity/StAccountEquity", dataProvider = "provider", description = "产品-产品详情-购买客户 暂缺字段 购买时间")
    public void api_AccountEquity_StAccountEquity(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/api/DataDictionary/StDataDictionary", dataProvider = "provider", description = "数据字典")
    public void api_DataDictionary_StDataDictionary(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/api/Product/StProduct", dataProvider = "provider", description = "产品-产品列表搜索不确定字段 期限 缺少字段 预期收益率")
    public void api_Product_StProduct(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/api/Product/StProductDetails", dataProvider = "provider", description = "产品-产品详情-基本信息")
    public void api_Product_StProductDetails(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/api/Remind/CreateRemind", dataProvider = "provider", description = "创建客户事件提醒")
    public void api_Remind_CreateRemind(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/api/Subscribe/StAccountCreateSubscribe", dataProvider = "provider", description = "客户-预约信息-新建预约 缺少字段 预约渠道、剩余最小合同、剩余额度")
    public void api_Subscribe_StAccountCreateSubscribe(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/api/Subscribe/StAccountSubscribeDetails", dataProvider = "provider", description = "客户-预约记录")
    public void api_Subscribe_StAccountSubscribeDetails(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/api/Subscribe/StAccountUpdateSubscribe", dataProvider = "provider", description = "客户-预约信息-更新预约/撤销预约 缺少字段 预约渠道、剩余最小合同、剩余额度")
    public void api_Subscribe_StAccountUpdateSubscribe(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/api/Subscribe/StProductSubscribeDetails", dataProvider = "provider", description = "产品-产品详情-预约记录")
    public void api_Subscribe_StProductSubscribeDetails(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/api/Subscribe/StSubscribe", dataProvider = "provider", description = "产品-预约列表 不确定字段 期限 = 截止日 ？ 、预约渠道 =  预约类型？、预约代码 = 预约编号？ 客户代码 = ? 客户Id？")
    public void api_Subscribe_StSubscribe(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/api/Task/StAccountCreateTask", dataProvider = "provider", description = "客户-事件提醒创建（待办事项） 缺少字段 客户代码、是否需要提醒、提醒时间")
    public void api_Task_StAccountCreateTask(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/api/Task/StAccountTask", dataProvider = "provider", description = "客户-事件提醒（待办事项）")
    public void api_Task_StAccountTask(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/api/Task/StAccountUpdateTask", dataProvider = "provider", description = "客户-事件提醒更新（待办事项）缺少字段 客户代码、是否需要提醒、提醒时间")
    public void api_Task_StAccountUpdateTask(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/api/User/Login", dataProvider = "provider", description = "用户登录")
    public void api_User_Login(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

}
