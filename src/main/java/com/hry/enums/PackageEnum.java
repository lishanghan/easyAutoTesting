package com.hry.enums;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/8/6 11:20
 */
public enum PackageEnum {
    TEST("com.hry.testng.test"),
    BASE("com.hry.testng.base")
    ;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    PackageEnum(String packageName) {

        this.packageName = packageName;
    }

    private String packageName;
}
