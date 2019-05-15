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

    @Test(testName = "/business/appoint/finish", dataProvider = "provider", description = "完成预约")
    public void business_appoint_finish(HryTest test) {
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

    @Test(testName = "/business/order", dataProvider = "provider", description = "客户订单查询 ✔✔✔")
    public void business_order(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/business/preAppoint", dataProvider = "provider", description = "主页-线上交易跟踪/预约意向列表查询")
    public void business_preAppoint(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/business/trade", dataProvider = "provider", description = "客户确认交易查询 ✔✔✔")
    public void business_trade(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/business/uploadVideo", dataProvider = "provider", description = "视频上传，更新订单状态")
    public void business_uploadVideo(HryTest test) {
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

    @Test(testName = "/customer/addWithRelation", dataProvider = "provider", description = "新增客户和关系 ✔✔✔")
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

    @Test(testName = "/customer/detail", dataProvider = "provider", description = "查询客户详细信息 dataId=客户编号 ✔✔✔")
    public void customer_detail(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/idInfo/upload", dataProvider = "provider", description = "客户证件上传 ✔✔✔")
    public void customer_idInfo_upload(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/label", dataProvider = "provider", description = "查询自定义客户标签")
    public void customer_label(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/label/modify", dataProvider = "provider", description = "修改客户标签 ✔✔✔")
    public void customer_label_modify(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/list", dataProvider = "provider", description = "查询MM系统保存的客户经理名下客户列表 ✔✔✔")
    public void customer_list(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/listCrm", dataProvider = "provider", description = "通过接口查询CRM系统客户经理名下客户列表，支持筛选 ✔✔✔")
    public void customer_listCrm(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/online/open", dataProvider = "provider", description = "开通线上交易，暂不开发")
    public void customer_online_open(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/onlineInfo", dataProvider = "provider", description = "查询客户线上信息")
    public void customer_onlineInfo(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/relation", dataProvider = "provider", description = "查询客户关系信息 ✔✔✔")
    public void customer_relation(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/relation/add", dataProvider = "provider", description = "新增客户关系 ✔✔✔")
    public void customer_relation_add(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/customer/relation/update", dataProvider = "provider", description = "更新客户关系 ✔✔✔")
    public void customer_relation_update(HryTest test) {
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

    @Test(testName = "/fund/fundInfo", dataProvider = "provider", description = "获取产品标题信息,已对接")
    public void fund_fundInfo(HryTest test) {
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

    @Test(testName = "/index/count", dataProvider = "provider", description = "主页-线上交易跟踪/待跟进客户-统计接口")
    public void index_count(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/index/dict", dataProvider = "provider", description = "数据字典查询接口")
    public void index_dict(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/index/dict2", dataProvider = "provider", description = "数据字典查询接口2")
    public void index_dict2(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/index/image", dataProvider = "provider", description = "主页-用户头像")
    public void index_image(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/index/locked", dataProvider = "provider", description = "查询锁定用户列表, 返回登录用户名列表")
    public void index_locked(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/index/notice", dataProvider = "provider", description = "主页-通知列表-暂不开发")
    public void index_notice(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/index/unlock", dataProvider = "provider", description = "查询锁定用户列表, 返回登录用户名列表")
    public void index_unlock(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/index/version", dataProvider = "provider", description = "主页-版本信息")
    public void index_version(HryTest test) {
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

    @Test(testName = "/riskTest/sendSms", dataProvider = "provider", description = "发送短连接,")
    public void riskTest_sendSms(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/add", dataProvider = "provider", description = "新增待办事项")
    public void schedule_add(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/cancel", dataProvider = "provider", description = "取消待办事项")
    public void schedule_cancel(HryTest test) {
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

    @Test(testName = "/schedule/finish", dataProvider = "provider", description = "完成待办事项")
    public void schedule_finish(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/list", dataProvider = "provider", description = "待办事项列表")
    public void schedule_list(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/listCrm", dataProvider = "provider", description = "待办事项列表")
    public void schedule_listCrm(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/schedule/listDate", dataProvider = "provider", description = "主页-月历视图-月历上有代办事项的日期")
    public void schedule_listDate(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

}
