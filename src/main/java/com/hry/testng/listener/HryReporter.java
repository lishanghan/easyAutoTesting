package com.hry.testng.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.TestAttribute;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.testng.*;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.*;
import com.hry.util.FileUtil;
import com.hry.util.SpringContextUtil;
import java.io.IOException;


/**
 * @description:
 * @params:
 * @return:
 * @author: lish
 * @date: 2018-07-10
 */
@Slf4j
public class HryReporter implements IReporter {
    private String reportPath;//测试报告存入于服务器的位置 如:C:/testngReport/(windows环境下的存放地址)
    private String fileName;//测试报告访问的地址 如: report_u53_c14_20180723_151134.html   访问时前面加域名即可
    private String customName;//测试报告中的报告名称,一般传定制名称



    public HryReporter(String reportPath, String fileName) {
        this(reportPath, fileName, null);
    }

    public HryReporter(String reportPath, String fileName, String customName) {
        this.reportPath = reportPath;
        //兼容直接传treport.reportName的情况   /test-output/r_uid53_sid15_iid1377_20181022_165804.html
        //update 2018-10-24 by luqiwei
        this.fileName = fileName.contains("/") ? fileName.substring(fileName.lastIndexOf("/") + 1) : fileName;
        this.customName = customName;
    }

    private ExtentReports extent;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        init();
        boolean createSuiteNode = false;
        if (suites.size() > 1) {
            createSuiteNode = true;
        }
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
            //如果suite里面没有任何用例，直接跳过，不在报告里生成
            if (result.size() == 0) {
                continue;
            }
            //统计suite下的成功、失败、跳过的总用例数
            int suiteFailSize = 0;
            int suitePassSize = 0;
            int suiteSkipSize = 0;
            ExtentTest suiteTest = null;
            //存在多个suite的情况下，在报告中将同一个一个suite的测试结果归为一类，创建一级节点。
            if (createSuiteNode) {
                suiteTest = extent.createTest(suite.getName()).assignCategory(suite.getName());
            }
            boolean createSuiteResultNode = false;
            if (result.size() > 1) {
                createSuiteResultNode = true;
            }
            for (ISuiteResult r : result.values()) {
                ExtentTest resultNode;
                ITestContext context = r.getTestContext();
                if (createSuiteResultNode) {
                    //没有创建suite的情况下，将在SuiteResult的创建为一级节点，否则创建为suite的一个子节点。
                    if (null == suiteTest) {
                        resultNode = extent.createTest(r.getTestContext().getName());
                    } else {
                        resultNode = suiteTest.createNode(r.getTestContext().getName());
                    }
                } else {
                    resultNode = suiteTest;
                }
                if (resultNode != null) {
                    resultNode.getModel().setName(suite.getName() + " : " + r.getTestContext().getName());
                    if (resultNode.getModel().hasCategory()) {
                        resultNode.assignCategory(r.getTestContext().getName());
                    } else {
                        resultNode.assignCategory(suite.getName(), r.getTestContext().getName());
                    }
                    resultNode.getModel().setStartTime(r.getTestContext().getStartDate());
                    resultNode.getModel().setEndTime(r.getTestContext().getEndDate());
                    //统计SuiteResult下的数据
                    int passSize = r.getTestContext().getPassedTests().size();
                    int failSize = r.getTestContext().getFailedTests().size();
                    int skipSize = r.getTestContext().getSkippedTests().size();
                    suitePassSize += passSize;
                    suiteFailSize += failSize;
                    suiteSkipSize += skipSize;
                    if (failSize > 0) {
                        resultNode.getModel().setStatus(Status.FAIL);
                    }
                    resultNode.getModel().setDescription(String.format("Pass: %s ; Fail: %s ; Skip: %s ;", passSize, failSize, skipSize));
                }
                buildTestNodes(resultNode, context.getFailedTests(), Status.FAIL);
                buildTestNodes(resultNode, context.getSkippedTests(), Status.SKIP);
                buildTestNodes(resultNode, context.getPassedTests(), Status.PASS);
            }
            if (suiteTest != null) {
                suiteTest.getModel().setDescription(String.format("Pass: %s ; Fail: %s ; Skip: %s ;", suitePassSize, suiteFailSize, suiteSkipSize));
                if (suiteFailSize > 0) {
                    suiteTest.getModel().setStatus(Status.FAIL);
                }
            }

        }

        extent.flush();
    }

    private void init() {
        URL url = this.getClass().getProtectionDomain().getCodeSource().getLocation();
        String path = null;
        try {
            path = java.net.URLDecoder.decode(url.getPath(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //获取运行环境
        String active = SpringContextUtil.getActiveProfile();
        log.info("当前运行环境为："+active);

        //文件夹不存在的话进行创建
        File reportDir = new File(reportPath);
        if (!reportDir.exists() && !reportDir.isDirectory()) {
            reportDir.mkdir();
            String bPath = "";
            log.info("当前路径："+path );
            if(active.equals("dev")){
                path = path.replace("/","\\").substring(1);
                bPath = path + "static\\static\\hry-auto";
                try {
                    FileUtil.copy(bPath,reportPath);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(active.equals("prod")){
                bPath = "static/static/hry-auto";
                FileUtil.loadRecourseFromJarByFolder(bPath,reportPath,HryReporter.class);
            }

            log.info("源文件路径="+path+bPath);
            log.info("目标路径："+reportPath);

        }

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath + fileName);
        // 设置静态文件的DNS
        //怎么样解决cdn.rawgit.com访问不了的情况
        htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
        htmlReporter.config().setDocumentTitle("很容易自动化测试报告");
        if (StringUtils.isNotBlank(customName)) {
            htmlReporter.config().setReportName(customName);
        } else {
            htmlReporter.config().setReportName("未指定定制名称");
        }
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setCSS(".node.level-1  ul{ display:none;} .node.level-1.active ul{display:block;}");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);
    }

    @SuppressWarnings("Convert2Lambda")
    private void buildTestNodes(ExtentTest extenttest, IResultMap tests, Status status) {
        //存在父节点时，获取父节点的标签
        String[] categories = new String[0];
        if (extenttest != null) {
            List<TestAttribute> categoryList = extenttest.getModel().getCategoryContext().getAll();
            categories = new String[categoryList.size()];
            for (int index = 0; index < categoryList.size(); index++) {
                categories[index] = categoryList.get(index).getName();
            }
        }

        ExtentTest test;

        if (tests.size() > 0) {
            //调整用例排序，按时间排序
            Set<ITestResult> treeSet = new TreeSet<>(new Comparator<ITestResult>() {
                public int compare(ITestResult o1, ITestResult o2) {
                    return o1.getStartMillis() < o2.getStartMillis() ? -1 : 1;
                }
            });
            treeSet.addAll(tests.getAllResults());
            for (ITestResult result : treeSet) {
                Object[] parameters = result.getParameters();
                String name;


                String desc = "";
                String testName = "";
                try {

                    //testName = result.getMethod().getMethod().getAnnotation(Test.class).testName();//此方法已经过期 ,不再使用
                    testName = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName();
                    desc = result.getMethod().getDescription();
                } catch (RuntimeException e) {

                }

/*                log.debug("测试方法上的@Test注解的testName=" + testName);
                log.debug("测试方法上的@Test注解的description=" + desc);
                log.debug("result.getMethod().getMethodName()=" + result.getMethod().getMethodName());
                log.debug("result.getMethod().getDescription()=" + result.getMethod().getDescription());*/

                name = testName + "(" + desc + ")";
                if ("".equals(desc) && "".equals(testName)) {
                    name = result.getMethod().getMethodName();

                }

                if (extenttest == null) {
                    test = extent.createTest(name);
                } else {
                    //作为子节点进行创建时，设置同父节点的标签一致，便于报告检索。
                    test = extenttest.createNode(name).assignCategory(categories);
                }


                /**
                 * 参数现在直接使用Reporter.log打印
                 */

                /*                *//**
                 * 如果有参数,测试报告中将参数展示出来
                 *//*
                String p = "";
                if (parameters != null && parameters.length > 0) {
                    for (Object param : parameters) {
                        p += param.toString();
                    }
                }*/


 /*               //如果有参数，则使用参数的toString组合代替报告中的name
                for (Object param : parameters) {
                    name += param.toString();
                }
                if (name.length() > 0) {
                    if (name.length() > 50) {
                        name = name.substring(0, 49) + "...";
                    }
                } else {
                    name = result.getMethod().getMethodName();
                }
                if (extenttest == null) {
                    test = extent.createTest(name);
                } else {
                    //作为子节点进行创建时，设置同父节点的标签一致，便于报告检索。
                    test = extenttest.createNode(name).assignCategory(categories);
                }*/
                //test.getModel().setDescription(description.toString());
                //test = extent.createTest(result.getMethod().getMethodName());
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);

                List<String> outputList = Reporter.getOutput(result);
                for (String output : outputList) {
                    //将用例的log输出报告中
                    test.debug(output);
                }
                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                } else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }

                test.getModel().setStartTime(getTime(result.getStartMillis()));
                test.getModel().setEndTime(getTime(result.getEndMillis()));
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}