package com.hry.testng.test;

import com.hry.anno.SKey;
import com.hry.po.HryTest;
import com.hry.testng.base.Base;
import com.hry.util.HryHttpClientUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.hry.util.AssertUtil.supperAssert;
@SKey("Mmp")
public class MmpDefaultTest extends Base{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy", "testingId"})
    public MmpDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @Test(testName = "/business/appoint/add", dataProvider = "provider", description = "产品预约 创建预约 ✔✔✔")
    public void business_appoint_add(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/business/appoint/cancel", dataProvider = "provider", description = "取消预约 ✔✔✔")
    public void business_appoint_cancel(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/business/appoint/update", dataProvider = "provider", description = "修改预约 ✔✔✔")
    public void business_appoint_update(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/business/appoints", dataProvider = "provider", description = "查询客户经理下客户的预约列表 ✔✔✔")
    public void business_appoints(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/business/order", dataProvider = "provider", description = "二期功能，包括机构客户订单查询")
    public void business_order(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/business/preAppoint", dataProvider = "provider", description = "主页-线上交易跟踪/预约意向列表查询")
    public void business_preAppoint(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/business/preAppoint/cancel", dataProvider = "provider", description = "主页-线上交易跟踪/预约意向取消")
    public void business_preAppoint_cancel(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/business/preAppoint/finish", dataProvider = "provider", description = "主页-线上交易跟踪/预约意向完成")
    public void business_preAppoint_finish(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/business/trade", dataProvider = "provider", description = "客户确认交易查询 ✔✔✔")
    public void business_trade(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/account/document", dataProvider = "provider", description = "证件照片上传查询")
    public void customer_account_document(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/accountingCustomer", dataProvider = "provider", description = "开户在途客户列表")
    public void customer_accountingCustomer(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/add", dataProvider = "provider", description = "创建客户 ✔✔✔")
    public void customer_add(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/addWithRelation", dataProvider = "provider", description = "新增客户和客户关系 ✔✔✔")
    public void customer_addWithRelation(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/advancedInfo", dataProvider = "provider", description = "查询客户高级信息 dataId=客户ID ✔✔✔")
    public void customer_advancedInfo(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/advancedInfo/modify", dataProvider = "provider", description = "修改客户高级信息 ✔✔✔")
    public void customer_advancedInfo_modify(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/appoints", dataProvider = "provider", description = "查询客户的预约列表 ✔✔✔")
    public void customer_appoints(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/assets", dataProvider = "provider", description = "查询客户资产汇总信息 ✔✔✔")
    public void customer_assets(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/contactingCustomer", dataProvider = "provider", description = "待维系客户")
    public void customer_contactingCustomer(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/detail", dataProvider = "provider", description = "查询客户详细信息 dataId=客户编号 ✔✔✔")
    public void customer_detail(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/expiredAssets", dataProvider = "provider", description = "查询客户到期资产 ✔✔✔")
    public void customer_expiredAssets(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/fund/info", dataProvider = "provider", description = "查询客户资产详情")
    public void customer_fund_info(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/getCrmAccountId", dataProvider = "provider", description = "根据理财账号获取CRM的客户ID（accountId） ✔✔✔")
    public void customer_getCrmAccountId(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/label/modify", dataProvider = "provider", description = "修改客户标签 ✔✔✔")
    public void customer_label_modify(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/listCrm", dataProvider = "provider", description = "通过接口查询CRM系统客户经理名下客户列表，支持筛选 ✔✔✔")
    public void customer_listCrm(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/relation/add", dataProvider = "provider", description = "新增客户关系 ✔✔✔")
    public void customer_relation_add(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/totalAssets", dataProvider = "provider", description = "查询客户总资产")
    public void customer_totalAssets(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/unencryptdetail", dataProvider = "provider", description = "查询客户详细信息 dataId=客户编号 ✔✔✔")
    public void customer_unencryptdetail(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/video/list", dataProvider = "provider", description = "查询客户视频请求记录")
    public void customer_video_list(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/fund/appoints", dataProvider = "provider", description = "获取产品明细-预约列表")
    public void fund_appoints(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/fund/customerList", dataProvider = "provider", description = "获取产品明细-购买客户")
    public void fund_customerList(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/fund/detail", dataProvider = "provider", description = "获取产品基本信息（不包括标题信息），已对接")
    public void fund_detail(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/fund/fundAmount", dataProvider = "provider", description = "查询产品剩余小额合同号、剩余金额")
    public void fund_fundAmount(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/fund/fundBaseInfo", dataProvider = "provider", description = "获取产品基础信息,整合接口")
    public void fund_fundBaseInfo(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/fund/list/crm", dataProvider = "provider", description = "获取CRM产品列表,已对接")
    public void fund_list_crm(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/fund/onsale/list", dataProvider = "provider", description = "获取在售产品列表，已对接")
    public void fund_onsale_list(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/fund/recommend", dataProvider = "provider", description = "获取产品明细-一键荐客")
    public void fund_recommend(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/mainPage/count", dataProvider = "provider", description = "主页-线上交易跟踪/待跟进客户-统计接口")
    public void mainPage_count(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/mainPage/device", dataProvider = "provider", description = "记录设备ID，返回MD5")
    public void mainPage_device(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/mainPage/dict", dataProvider = "provider", description = "数据字典查询接口")
    public void mainPage_dict(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/mainPage/image", dataProvider = "provider", description = "主页-用户头像")
    public void mainPage_image(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/mainPage/version", dataProvider = "provider", description = "主页-版本信息")
    public void mainPage_version(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/riskTest/commit", dataProvider = "provider", description = "提交风险评测答案")
    public void riskTest_commit(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/riskTest/quesition", dataProvider = "provider", description = "获取风险评测试题")
    public void riskTest_quesition(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/riskTest/sendSms", dataProvider = "provider", description = "发送短连接")
    public void riskTest_sendSms(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/activity/active", dataProvider = "provider", description = "激活日程 ✔✔✔")
    public void schedule_activity_active(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/activity/delete", dataProvider = "provider", description = "取消日程（删除）")
    public void schedule_activity_delete(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/activity/delete/batch", dataProvider = "provider", description = "取消日程（删除）")
    public void schedule_activity_delete_batch(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/activity/finish", dataProvider = "provider", description = "完成日程 ✔✔✔")
    public void schedule_activity_finish(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/activity/finish/batch", dataProvider = "provider", description = "完成日程 ✔✔✔")
    public void schedule_activity_finish_batch(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/activity/update", dataProvider = "provider", description = "更新日程")
    public void schedule_activity_update(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/add", dataProvider = "provider", description = "新增待办事项：日程 ✔✔✔")
    public void schedule_add(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/count", dataProvider = "provider", description = "菜单-待办事项提醒数")
    public void schedule_count(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/list", dataProvider = "provider", description = "待办事项列表 ✔✔✔")
    public void schedule_list(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/listDate", dataProvider = "provider", description = "主页-月历视图-月历上有代办事项的日期")
    public void schedule_listDate(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/remind/finish", dataProvider = "provider", description = "完成提醒 ✔✔✔")
    public void schedule_remind_finish(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/remind/finish/batch", dataProvider = "provider", description = "完成提醒 ✔✔✔")
    public void schedule_remind_finish_batch(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/v2/customer/city/list", dataProvider = "provider", description = "城市列表，二期新增接口")
    public void v2_customer_city_list(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/v2/customer/demand/delete", dataProvider = "provider", description = "删除投资需求")
    public void v2_customer_demand_delete(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/v2/customer/demand/insert", dataProvider = "provider", description = "新增投资需求")
    public void v2_customer_demand_insert(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/v2/customer/demand/query", dataProvider = "provider", description = "新增投资需求")
    public void v2_customer_demand_query(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/v2/customer/demand/update", dataProvider = "provider", description = "更新投资需求")
    public void v2_customer_demand_update(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/v2/customer/description", dataProvider = "provider", description = "查询客户详细信息，二期新增接口")
    public void v2_customer_description(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/v2/customer/experience/update", dataProvider = "provider", description = "更新过往投资经验")
    public void v2_customer_experience_update(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/v2/customer/importantDay/delete", dataProvider = "provider", description = "删除纪念日")
    public void v2_customer_importantDay_delete(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/v2/customer/importantDay/insert", dataProvider = "provider", description = "新增纪念日")
    public void v2_customer_importantDay_insert(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/v2/customer/importantDay/query", dataProvider = "provider", description = "查询纪念日")
    public void v2_customer_importantDay_query(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/v2/customer/importantDay/query/first", dataProvider = "provider", description = "查询最近的纪念日")
    public void v2_customer_importantDay_query_first(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/v2/customer/importantDay/update", dataProvider = "provider", description = "更新纪念日")
    public void v2_customer_importantDay_update(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/v2/customer/interest/update", dataProvider = "provider", description = "更新兴趣")
    public void v2_customer_interest_update(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/v2/customer/outline/update", dataProvider = "provider", description = "更新消费/投资概要")
    public void v2_customer_outline_update(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/v2/customer/relation/delete", dataProvider = "provider", description = "删除客户关系 ✔✔✔")
    public void v2_customer_relation_delete(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/v2/customer/relation/query", dataProvider = "provider", description = "删除客户关系 ✔✔✔")
    public void v2_customer_relation_query(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/v2/customer/relation/update", dataProvider = "provider", description = "更新客户关系 ✔✔✔")
    public void v2_customer_relation_update(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/v2/customer/social/update", dataProvider = "provider", description = "更新社会属性")
    public void v2_customer_social_update(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/v2/customer/summary/update", dataProvider = "provider", description = "更新摘要")
    public void v2_customer_summary_update(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/v2/customer/update", dataProvider = "provider", description = "更新客户基础信息，二期新增接口")
    public void v2_customer_update(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/virtual/sql", dataProvider = "provider", description = "虚拟接口执行sql语句")
    public void virtual_sql(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

}
