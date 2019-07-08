/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - hry_auto
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hry_auto` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hry_auto`;

/*Table structure for table `qrtz_blob_triggers` */

DROP TABLE IF EXISTS `qrtz_blob_triggers`;

CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(190) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `qrtz_calendars` */

DROP TABLE IF EXISTS `qrtz_calendars`;

CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(190) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `qrtz_cron_triggers` */

DROP TABLE IF EXISTS `qrtz_cron_triggers`;

CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(190) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `qrtz_fired_triggers` */

DROP TABLE IF EXISTS `qrtz_fired_triggers`;

CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(190) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  `INSTANCE_NAME` varchar(190) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(190) DEFAULT NULL,
  `JOB_GROUP` varchar(190) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `qrtz_job_details` */

DROP TABLE IF EXISTS `qrtz_job_details`;

CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(190) NOT NULL,
  `JOB_GROUP` varchar(190) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `qrtz_locks` */

DROP TABLE IF EXISTS `qrtz_locks`;

CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `qrtz_paused_trigger_grps` */

DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;

CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `qrtz_scheduler_state` */

DROP TABLE IF EXISTS `qrtz_scheduler_state`;

CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(190) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `qrtz_simple_triggers` */

DROP TABLE IF EXISTS `qrtz_simple_triggers`;

CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(190) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `qrtz_simprop_triggers` */

DROP TABLE IF EXISTS `qrtz_simprop_triggers`;

CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(190) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `qrtz_triggers` */

DROP TABLE IF EXISTS `qrtz_triggers`;

CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(190) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  `JOB_NAME` varchar(190) NOT NULL,
  `JOB_GROUP` varchar(190) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(190) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tcase` */

DROP TABLE IF EXISTS `tcase`;

CREATE TABLE `tcase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `caseName` varchar(50) NOT NULL COMMENT '用例名称',
  `remark` varchar(300) DEFAULT NULL COMMENT '用例描述',
  `serviceId` int(11) NOT NULL COMMENT '服务id,tservice.id',
  `iId` int(11) NOT NULL COMMENT '接口ID,i.id',
  `envId` int(11) NOT NULL DEFAULT '0' COMMENT '环境ID,env.id,如果不填写,默认0-可在任意环境运行',
  `testClass` varchar(50) DEFAULT NULL COMMENT '此case所属测试类,现阶段仅在做定制时根据测试类过滤case时使用',
  `requestHeader` varchar(1024) DEFAULT NULL COMMENT '请求headers',
  `requestParam` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `assertType` int(11) DEFAULT '1' COMMENT '断言类型:1-equal,2-contain,3-关键key:value值匹配(格式必须是JSON),4-match(匹配正则)',
  `expected` varchar(5000) DEFAULT NULL COMMENT '期望结果(后续需要改进,支持不同类型结果,支持关键字断言,如正则,if,contains,true等等)',
  `cAfter` varchar(500) DEFAULT NULL COMMENT 'case after,用例执行的后置处理',
  `status` int(11) DEFAULT '1' COMMENT '用例状态,-1-删除,1-正常',
  `author` varchar(50) DEFAULT NULL COMMENT '用例设计人,user.realname',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE` (`id`,`caseName`,`iId`,`envId`,`status`,`author`,`serviceId`,`testClass`,`assertType`,`updateTime`)
) ENGINE=InnoDB AUTO_INCREMENT=10016 DEFAULT CHARSET=utf8 COMMENT='测试用例表';

/*Table structure for table `tclass` */

DROP TABLE IF EXISTS `tclass`;

CREATE TABLE `tclass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `packageName` varchar(100) NOT NULL DEFAULT 'com.haier.testng.test' COMMENT '测试类所在包名,默认值com.haier.testng.test,一般情况下不允许编辑',
  `className` varchar(100) NOT NULL COMMENT '测试类名,如Pgw ,PgwTest,PgwTestDefault',
  `sId` int(11) NOT NULL COMMENT 'service.id,此测试类隶属于哪个服务',
  `sKey` varchar(200) NOT NULL COMMENT 'service.servicekey',
  `author` varchar(50) DEFAULT NULL COMMENT '创建人',
  `remark` varchar(200) NOT NULL COMMENT '测试类描述信息,必填',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态:-1-删除,1-正常(默认)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Unique` (`id`,`className`,`sId`,`sKey`,`author`,`remark`,`status`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='测试类表,描述测试类';

/*Table structure for table `tcustom` */

DROP TABLE IF EXISTS `tcustom`;

CREATE TABLE `tcustom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customName` varchar(50) NOT NULL COMMENT '名称(最好能够标记出你的这个定制的意义)',
  `userId` int(11) NOT NULL COMMENT '定制人ID',
  `userName` varchar(20) DEFAULT NULL COMMENT '定制人',
  `envId` int(11) NOT NULL COMMENT '环境ID',
  `envKey` varchar(50) DEFAULT NULL COMMENT 'envKey',
  `strategy` varchar(200) DEFAULT NULL COMMENT '运行策略',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态:1-正常(默认),-1-删除',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `intersect` int(11) NOT NULL DEFAULT '0' COMMENT '测试类是否交叉执行,0-顺序(默认),即测试类one by one执行,1-交叉(同优先级的测试类,按测试方法优先级执行,期间可能会跳跃不同测试类执行)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE` (`id`,`customName`,`userId`,`envId`,`strategy`,`status`,`updateTime`,`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=utf8;

/*Table structure for table `tcustomdetail` */

DROP TABLE IF EXISTS `tcustomdetail`;

CREATE TABLE `tcustomdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `priority` int(11) DEFAULT '0' COMMENT '测试优先级,默认0,数字越大,定制测试时越优先执行',
  `customId` int(11) NOT NULL COMMENT 'tcustom.id',
  `clientLevel` int(11) NOT NULL COMMENT '定制级别:1-服务,2-接口,3-用例',
  `clientId` int(11) NOT NULL COMMENT '被定制的服务/接口/用例的id',
  `parentClientId` int(11) NOT NULL DEFAULT '0' COMMENT '父id,定制记录为接口时(clientLevel=2),此字段填写接口对应的服务id,定制记录为用例时,此字段填写用例对应的接口id',
  `hasChild` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有下一级定制',
  `clientName` varchar(200) NOT NULL COMMENT '被定制的服务/接口/用例的serviceKey/iUri/caseName',
  `className` varchar(200) DEFAULT NULL COMMENT '定制为服务时(clientLevel=1),必填',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态 1-正常,-1-删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`id`,`customId`,`clientLevel`,`clientId`,`clientName`,`status`,`parentClientId`,`priority`)
) ENGINE=InnoDB AUTO_INCREMENT=12373 DEFAULT CHARSET=utf8;

/*Table structure for table `temp` */

DROP TABLE IF EXISTS `temp`;

CREATE TABLE `temp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `testingId` varchar(50) NOT NULL COMMENT '某次测试活动id,唯一',
  `serviceKey` varchar(50) NOT NULL COMMENT '测试服务',
  `iUri` varchar(200) DEFAULT NULL COMMENT '接口地址',
  `tempKey` varchar(100) NOT NULL COMMENT '临时key',
  `tempValue` varchar(500) DEFAULT NULL COMMENT '临时value',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态:1-正常,-1-删除',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `unique` (`id`,`testingId`,`tempKey`,`status`,`updateTime`)
) ENGINE=InnoDB AUTO_INCREMENT=27896 DEFAULT CHARSET=utf8;

/*Table structure for table `tenv` */

DROP TABLE IF EXISTS `tenv`;

CREATE TABLE `tenv` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `envKey` varchar(50) NOT NULL COMMENT '环境唯一标识,如cs1,cs2',
  `remark` varchar(100) DEFAULT NULL COMMENT '描述说明',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`id`,`envKey`,`remark`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='基础环境信息表';

/*Table structure for table `ti` */

DROP TABLE IF EXISTS `ti`;

CREATE TABLE `ti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serviceId` int(11) NOT NULL COMMENT '服务ID,service.id',
  `iUri` varchar(200) NOT NULL COMMENT '接口地址,如:/tenderFacade/checkReleaseQueueBidValiad',
  `soapAction` varchar(255) DEFAULT NULL COMMENT 'soap接口的方法',
  `remark` varchar(200) NOT NULL COMMENT '接口描述',
  `iRequestMethod` int(11) DEFAULT '1' COMMENT '请求方式:1-post,2-get',
  `iContentType` int(11) DEFAULT '1' COMMENT 'ContentType:1-application/json,2-application/x-www-form-urlencoded',
  `iHeaderSample` varchar(1024) DEFAULT NULL COMMENT '请求header示例',
  `iParamType` int(11) DEFAULT '1' COMMENT '请求参数类型:1-json,2-map,3-text',
  `iParamSample` varchar(5000) DEFAULT NULL COMMENT '请求参数示例',
  `iResponseType` int(11) DEFAULT '1' COMMENT '返回值类型:1-json,2-map,3-text',
  `iDev` varchar(50) DEFAULT NULL COMMENT '接口开发人员,user.realname',
  `caseCount` int(11) NOT NULL DEFAULT '0' COMMENT '接口有效用例数量',
  `iStatus` int(11) NOT NULL DEFAULT '1' COMMENT '接口状态:-1-删除,1-正常,-2-废弃',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE` (`serviceId`,`iUri`,`id`,`iStatus`,`remark`,`iDev`,`caseCount`)
) ENGINE=InnoDB AUTO_INCREMENT=1813 DEFAULT CHARSET=utf8 COMMENT='接口表,记录接口信息';

/*Table structure for table `treport` */

DROP TABLE IF EXISTS `treport`;

CREATE TABLE `treport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reportPath` varchar(200) NOT NULL COMMENT '测试报告存放位置 如C:/report/',
  `reportName` varchar(200) NOT NULL COMMENT '测试报告名称 如 report_1_20181111_100510_333.html',
  `reportType` int(11) DEFAULT '2' COMMENT '测试报告类型,1-单用例测试,2-定制测试',
  `isScheduler` int(11) NOT NULL DEFAULT '0' COMMENT '是否为调度器触发运行,1-是,0-不是(默认)',
  `userId` int(11) NOT NULL COMMENT '运行此次测试的人员的id',
  `userName` varchar(50) DEFAULT NULL COMMENT '运行此次测试的人员的realname',
  `customId` int(11) NOT NULL COMMENT '此次运行对应的定制ID',
  `customName` varchar(200) DEFAULT NULL COMMENT '定制名称',
  `envId` int(11) DEFAULT NULL COMMENT '测试环境id',
  `envKey` varchar(50) DEFAULT NULL COMMENT 'envkey',
  `serviceIds` varchar(200) DEFAULT NULL COMMENT '服务IDs,存储格式为JSONArray, 如:1,2,3',
  `serviceNames` varchar(500) DEFAULT NULL COMMENT '服务key s,存储格式为JSONArray,如 aaa,bbb,ccc',
  `testTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '测试时间',
  `status` int(11) NOT NULL DEFAULT '5' COMMENT '测试报告状态 5-报告生成中(默认),10-报告生成完成,-1-删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE` (`id`,`reportPath`,`userId`,`customId`,`reportName`,`reportType`,`userName`,`envId`,`envKey`,`testTime`,`status`)
) ENGINE=InnoDB AUTO_INCREMENT=22923 DEFAULT CHARSET=utf8;

/*Table structure for table `tservice` */

DROP TABLE IF EXISTS `tservice`;

CREATE TABLE `tservice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serviceKey` varchar(50) NOT NULL COMMENT '服务标识,唯一',
  `serviceName` varchar(50) DEFAULT NULL COMMENT '服务描述,默认取swagger中的description',
  `httpType` int(6) DEFAULT '1' COMMENT '1-http,2-https',
  `isDel` int(6) DEFAULT '0' COMMENT '是否删除,1-是,0-否(默认0)',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `editor` varchar(50) DEFAULT NULL COMMENT '服务负责人-开发人员',
  `className` varchar(50) DEFAULT NULL COMMENT '默认测试类,根据serviceKey自动生成',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE` (`id`,`serviceKey`,`serviceName`,`isDel`,`editor`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='服务信息表';

/*Table structure for table `tservicedetail` */

DROP TABLE IF EXISTS `tservicedetail`;

CREATE TABLE `tservicedetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serviceId` int(11) NOT NULL COMMENT '服务ID,service.id',
  `envId` int(11) NOT NULL COMMENT '环境ID , env.id',
  `hostInfo` varchar(50) NOT NULL COMMENT '此服务此环境对应的host信息',
  `dbInfo` varchar(500) DEFAULT NULL COMMENT '此服务此环境对应的db信息,json格式{"driver":"com.mysql.jdbc.Driver","url":"jdbc:mysql://10.251.12.106:3306/pgw","username":"dev","password","dev"}',
  `swaggerUrl` varchar(200) DEFAULT NULL COMMENT '此服务此环境对应的swaggerUrl,如测试2懒猫:http://10.252.12.168:7029/swagger.json',
  `clazz` varchar(100) DEFAULT NULL COMMENT '此服务此环境对应的测试工厂类',
  `status` int(11) DEFAULT '1' COMMENT '状态:-1-删除,1-正常(默认)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE` (`id`,`serviceId`,`envId`,`swaggerUrl`,`status`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='环境详情';

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `groupId` int(11) DEFAULT '-1' COMMENT '用户组:-1-未分组,1-超级管理员,11-测试组-SH,12-开发组-SH,13-产品及UED-SH,14-项目经理-SH,15-运维-SH,16-其它_SH,21-测试组-HZ,22-开发组-HZ,23-产品及UED-HZ,24-项目经理-HZ,25-运维-HZ,26-其它-HZ,9999-BOSS',
  `identity` varchar(50) NOT NULL COMMENT '用户唯一标识,暂定使用邮箱',
  `password` varchar(100) NOT NULL DEFAULT 'e10adc3949ba59abbe56e057f20f883e' COMMENT '用户密码,默认123456',
  `realname` varchar(20) NOT NULL COMMENT '真实姓名',
  `status` int(11) DEFAULT '1' COMMENT '用户状态:1-正常(默认状态),-1-删除',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`id`,`groupId`,`identity`,`password`,`realname`,`status`,`remark`)
) ENGINE=InnoDB AUTO_INCREMENT=194 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`groupId`,`identity`,`password`,`realname`,`status`,`remark`) values (1,1,'admin@legain.com','e10adc3949ba59abbe56e057f20f883e','admin',1,NULL)

/*Table structure for table `user_hz_backup` */

DROP TABLE IF EXISTS `user_hz_backup`;

CREATE TABLE `user_hz_backup` (
  `realname` varchar(255) DEFAULT NULL,
  `detp` varchar(255) DEFAULT NULL,
  `identity` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `user_sh_backup` */

DROP TABLE IF EXISTS `user_sh_backup`;

CREATE TABLE `user_sh_backup` (
  `jszx` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `dept` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `workinfo` */

DROP TABLE IF EXISTS `workinfo`;

CREATE TABLE `workinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `realName` varchar(20) NOT NULL COMMENT '报告人姓名',
  `content` varchar(5000) NOT NULL COMMENT '工作内容',
  `workDate` date NOT NULL COMMENT '上报日期',
  `updateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '数据状态：1=正常，0=已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/* Trigger structure for table `tcase` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `statisCaseOnInsert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `statisCaseOnInsert` AFTER INSERT ON `tcase` FOR EACH ROW BEGIN

DECLARE ccount INT;

set ccount=(select count(id) from tcase where tcase.`iId`=new.`iId` and tcase.`status`>0);

update ti set ti.`caseCount`=ccount where ti.`id`=new.`iId`;

END */$$


DELIMITER ;

/* Trigger structure for table `tcase` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `statisCaseOnUpdate` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `statisCaseOnUpdate` AFTER UPDATE ON `tcase` FOR EACH ROW BEGIN

DECLARE ccount INT;

set ccount=(select count(id) from tcase where tcase.`iId`=new.`iId` and tcase.`status`>0);

update ti set ti.`caseCount`=ccount where ti.`id`=new.`iId`;

END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
