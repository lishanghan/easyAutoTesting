package com.hry.po;

import lombok.Data;

@Data
public class TservicedetailCustom extends Tservicedetail {
    private String servicekey;
    private String servicename;
    private String seditor;
    private String envkey;
    private String envremark;
}
