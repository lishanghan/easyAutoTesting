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

    @Test(testName = "/business/appoint/add", dataProvider = "provider", description = "产品预约 创建预约")
    public void business_appoint_add(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/business/appoint/cancel", dataProvider = "provider", description = "取消预约")
    public void business_appoint_cancel(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/business/appoint/finish", dataProvider = "provider", description = "完成预约")
    public void business_appoint_finish(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/business/appoint/update", dataProvider = "provider", description = "修改预约")
    public void business_appoint_update(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/business/appoints", dataProvider = "provider", description = "查询客户经理下客户的预约列表")
    public void business_appoints(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/business/order", dataProvider = "provider", description = "客户订单查询")
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

    @Test(testName = "/business/trade", dataProvider = "provider", description = "客户确认交易查询")
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

    @Test(testName = "/customer/add", dataProvider = "provider", description = "创建客户")
    public void customer_add(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/addWithRelation", dataProvider = "provider", description = "新增客户和关系")
    public void customer_addWithRelation(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/advancedInfo", dataProvider = "provider", description = "查询客户高级信息")
    public void customer_advancedInfo(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/advancedInfo/modify", dataProvider = "provider", description = "修改客户高级信息")
    public void customer_advancedInfo_modify(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/appoints", dataProvider = "provider", description = "查询客户的预约列表")
    public void customer_appoints(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/assets", dataProvider = "provider", description = "查询客户资产汇总信息")
    public void customer_assets(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/contactingCustomer", dataProvider = "provider", description = "待维系客户")
    public void customer_contactingCustomer(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/detail", dataProvider = "provider", description = "查询客户详细信息-非json格式参数")
    public void customer_detail(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/expiredAssets", dataProvider = "provider", description = "查询客户到期资产")
    public void customer_expiredAssets(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/fund/disclosureFile", dataProvider = "provider", description = "信息披露文件下载")
    public void customer_fund_disclosureFile(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/fund/info", dataProvider = "provider", description = "查询客户资产详情")
    public void customer_fund_info(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/getCrmAccountId", dataProvider = "provider", description = "根据理财账号获取CRM的客户ID（accountId）")
    public void customer_getCrmAccountId(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/label/modify", dataProvider = "provider", description = "修改客户标签")
    public void customer_label_modify(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/listCrm", dataProvider = "provider", description = "通过接口查询CRM系统客户经理名下客户列表，支持筛选")
    public void customer_listCrm(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/listTotalCrm", dataProvider = "provider", description = "通过接口查询CRM系统所有客户列表")
    public void customer_listTotalCrm(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/online/open", dataProvider = "provider", description = "开通线上交易，暂不开发")
    public void customer_online_open(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/relation/add", dataProvider = "provider", description = "新增客户关系")
    public void customer_relation_add(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/searchCrm", dataProvider = "provider", description = "根据客户姓名搜索CRM系统客户，支持筛选")
    public void customer_searchCrm(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/totalAssets", dataProvider = "provider", description = "查询客户总资产")
    public void customer_totalAssets(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/unencryptdetail", dataProvider = "provider", description = "查询客户详细信息 dataId=客户编号")
    public void customer_unencryptdetail(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/video/list", dataProvider = "provider", description = "查询客户视频请求记录")
    public void customer_video_list(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/device/list", dataProvider = "provider", description = "查询白名单设备列表")
    public void device_list(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/device/update", dataProvider = "provider", description = "查询白名单设备列表")
    public void device_update(HryTest test) {
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

    @Test(testName = "/fund/detail", dataProvider = "provider", description = "获取产品信息")
    public void fund_detail(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/fund/fundAmount", dataProvider = "provider", description = "查询产品剩余小额合同号、剩余金额")
    public void fund_fundAmount(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/fund/list/crm", dataProvider = "provider", description = "查询CRM产品列表")
    public void fund_list_crm(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/fund/onsale/list", dataProvider = "provider", description = "查询在售产品列表")
    public void fund_onsale_list(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/mainPage/count", dataProvider = "provider", description = "主页-线上交易跟踪/待跟进客户-统计接口")
    public void mainPage_count(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/mainPage/device", dataProvider = "provider", description = "记录设备ID，返回MD5-非json参数")
    public void mainPage_device(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/mainPage/dict", dataProvider = "provider", description = "数据字典查询接口")
    public void mainPage_dict(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/mainPage/dict2", dataProvider = "provider", description = "数据字典查询接口2")
    public void mainPage_dict2(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/mainPage/image", dataProvider = "provider", description = "主页-用户头像")
    public void mainPage_image(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/mainPage/label/add", dataProvider = "provider", description = "新增自定义客户标签")
    public void mainPage_label_add(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/mainPage/label/delete", dataProvider = "provider", description = "删除自定义客户标签")
    public void mainPage_label_delete(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/mainPage/labels", dataProvider = "provider", description = "查询自定义客户标签")
    public void mainPage_labels(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/mainPage/notice", dataProvider = "provider", description = "主页-通知列表-暂不开发")
    public void mainPage_notice(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/mainPage/user/online", dataProvider = "provider", description = "查询在线用户")
    public void mainPage_user_online(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/mainPage/version", dataProvider = "provider", description = "主页版本信息-非json参数")
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

    @Test(testName = "/schedule/activity/active", dataProvider = "provider", description = "激活日程")
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

    @Test(testName = "/schedule/activity/finish", dataProvider = "provider", description = "完成日程")
    public void schedule_activity_finish(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/activity/finish/batch", dataProvider = "provider", description = "完成日程")
    public void schedule_activity_finish_batch(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/activity/update", dataProvider = "provider", description = "更新日程")
    public void schedule_activity_update(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/add", dataProvider = "provider", description = "新增待办事项：日程")
    public void schedule_add(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/count", dataProvider = "provider", description = "菜单-待办事项提醒数")
    public void schedule_count(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/detail", dataProvider = "provider", description = "待办事项明细")
    public void schedule_detail(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/list", dataProvider = "provider", description = "待办事项列表")
    public void schedule_list(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/listDate", dataProvider = "provider", description = "主页-月历视图-月历上有待办事项的日期")
    public void schedule_listDate(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/remind/active", dataProvider = "provider", description = "激活提醒")
    public void schedule_remind_active(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/remind/finish", dataProvider = "provider", description = "完成提醒")
    public void schedule_remind_finish(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/remind/finish/batch", dataProvider = "provider", description = "完成提醒")
    public void schedule_remind_finish_batch(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

}
