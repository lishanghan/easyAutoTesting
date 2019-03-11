package com.hry.service;

import com.hry.po.Tservice;
import java.util.Map;


public interface AutocodeService {
/*    Map<String, String> generateBaseClass();

    Map<String, String> generateDefaultTestClass();*/

    Map<String, String> generateTestClass();

    Map<String,String> generateOneTestClass(Integer tserviceId);

}
