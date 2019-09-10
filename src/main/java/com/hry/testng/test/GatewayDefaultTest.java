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

    @Test(testName = "/apis/main/business/appoint/add", dataProvider = "provider", description = "产品预约 创建预约")
    public void apis_main_business_appoint_add(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/business/appoint/cancel", dataProvider = "provider", description = "取消预约")
    public void apis_main_business_appoint_cancel(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/business/appoint/update", dataProvider = "provider", description = "修改预约")
    public void apis_main_business_appoint_update(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/business/appoints", dataProvider = "provider", description = "查询客户经理下客户的预约列表")
    public void apis_main_business_appoints(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/business/order", dataProvider = "provider", description = "客户订单查询")
    public void apis_main_business_order(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/business/preAppoint", dataProvider = "provider", description = "主页-线上交易跟踪/预约意向列表查询")
    public void apis_main_business_preAppoint(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/business/preAppoint/cancel", dataProvider = "provider", description = "主页-线上交易跟踪/预约意向取消")
    public void apis_main_business_preAppoint_cancel(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/business/preAppoint/finish", dataProvider = "provider", description = "主页-线上交易跟踪/预约意向完成")
    public void apis_main_business_preAppoint_finish(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/business/trade", dataProvider = "provider", description = "客户确认交易查询")
    public void apis_main_business_trade(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/customer/account/document", dataProvider = "provider", description = "证件照片上传查询")
    public void apis_main_customer_account_document(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/customer/accountingCustomer", dataProvider = "provider", description = "开户在途客户列表")
    public void apis_main_customer_accountingCustomer(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/customer/add", dataProvider = "provider", description = "创建客户")
    public void apis_main_customer_add(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/customer/addWithRelation", dataProvider = "provider", description = "新增客户和关系")
    public void apis_main_customer_addWithRelation(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/customer/advancedInfo", dataProvider = "provider", description = "查询客户高级信息")
    public void apis_main_customer_advancedInfo(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/customer/advancedInfo/modify", dataProvider = "provider", description = "修改客户高级信息")
    public void apis_main_customer_advancedInfo_modify(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/customer/appoints", dataProvider = "provider", description = "查询客户的预约列表")
    public void apis_main_customer_appoints(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/customer/assets", dataProvider = "provider", description = "查询客户资产汇总信息")
    public void apis_main_customer_assets(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/customer/contactingCustomer", dataProvider = "provider", description = "待维系客户")
    public void apis_main_customer_contactingCustomer(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/customer/detail", dataProvider = "provider", description = "查询客户详细信息-非json格式参数")
    public void apis_main_customer_detail(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/customer/expiredAssets", dataProvider = "provider", description = "查询客户到期资产")
    public void apis_main_customer_expiredAssets(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/customer/fund/info", dataProvider = "provider", description = "查询客户资产详情")
    public void apis_main_customer_fund_info(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/customer/getCrmAccountId", dataProvider = "provider", description = "根据理财账号获取CRM的客户ID（accountId）")
    public void apis_main_customer_getCrmAccountId(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/customer/label/modify", dataProvider = "provider", description = "修改客户标签")
    public void apis_main_customer_label_modify(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/customer/listCrm", dataProvider = "provider", description = "通过接口查询CRM系统客户经理名下客户列表，支持筛选")
    public void apis_main_customer_listCrm(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/customer/relation/add", dataProvider = "provider", description = "新增客户关系")
    public void apis_main_customer_relation_add(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/customer/totalAssets", dataProvider = "provider", description = "查询客户总资产")
    public void apis_main_customer_totalAssets(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/customer/unencryptdetail", dataProvider = "provider", description = "查询客户详细信息 dataId=客户编号")
    public void apis_main_customer_unencryptdetail(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/customer/video/list", dataProvider = "provider", description = "查询客户视频请求记录")
    public void apis_main_customer_video_list(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/fund/appoints", dataProvider = "provider", description = "获取产品明细-预约列表")
    public void apis_main_fund_appoints(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/fund/customerList", dataProvider = "provider", description = "获取产品明细-购买客户")
    public void apis_main_fund_customerList(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/fund/detail", dataProvider = "provider", description = "获取产品信息")
    public void apis_main_fund_detail(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/fund/fundAmount", dataProvider = "provider", description = "查询产品剩余小额合同号、剩余金额")
    public void apis_main_fund_fundAmount(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/fund/list/crm", dataProvider = "provider", description = "查询CRM产品列表")
    public void apis_main_fund_list_crm(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/fund/onsale/list", dataProvider = "provider", description = "查询在售产品列表")
    public void apis_main_fund_onsale_list(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/mainPage/count", dataProvider = "provider", description = "主页-线上交易跟踪/待跟进客户-统计接口")
    public void apis_main_mainPage_count(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/mainPage/device", dataProvider = "provider", description = "记录设备ID，返回MD5-非json响应格式")
    public void apis_main_mainPage_device(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/mainPage/dict", dataProvider = "provider", description = "数据字典查询接口")
    public void apis_main_mainPage_dict(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/mainPage/image", dataProvider = "provider", description = "主页-用户头像")
    public void apis_main_mainPage_image(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/mainPage/version", dataProvider = "provider", description = "主页版本信息-非json参数")
    public void apis_main_mainPage_version(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/riskTest/commit", dataProvider = "provider", description = "提交风险评测答案")
    public void apis_main_riskTest_commit(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/riskTest/quesition", dataProvider = "provider", description = "获取风险评测试题")
    public void apis_main_riskTest_quesition(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/riskTest/sendSms", dataProvider = "provider", description = "发送风险测评短连接")
    public void apis_main_riskTest_sendSms(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/schedule/activity/active", dataProvider = "provider", description = "激活日程")
    public void apis_main_schedule_activity_active(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/schedule/activity/delete", dataProvider = "provider", description = "取消日程（删除）")
    public void apis_main_schedule_activity_delete(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/schedule/activity/delete/batch", dataProvider = "provider", description = "取消日程（删除）")
    public void apis_main_schedule_activity_delete_batch(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/schedule/activity/finish", dataProvider = "provider", description = "完成日程")
    public void apis_main_schedule_activity_finish(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/schedule/activity/finish/batch", dataProvider = "provider", description = "完成日程")
    public void apis_main_schedule_activity_finish_batch(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/schedule/activity/update", dataProvider = "provider", description = "更新日程")
    public void apis_main_schedule_activity_update(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/schedule/add", dataProvider = "provider", description = "新增日程")
    public void apis_main_schedule_add(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/schedule/count", dataProvider = "provider", description = "菜单-待办事项提醒数")
    public void apis_main_schedule_count(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/schedule/list", dataProvider = "provider", description = "待办事项列表")
    public void apis_main_schedule_list(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/schedule/listDate", dataProvider = "provider", description = "主页-月历视图-月历上有待办事项的日期")
    public void apis_main_schedule_listDate(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/schedule/remind/finish", dataProvider = "provider", description = "完成提醒")
    public void apis_main_schedule_remind_finish(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/apis/main/schedule/remind/finish/batch", dataProvider = "provider", description = "完成提醒")
    public void apis_main_schedule_remind_finish_batch(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/user/unsecretlogin", dataProvider = "provider", description = "用户登录非加密")
    public void user_unsecretlogin(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

}
