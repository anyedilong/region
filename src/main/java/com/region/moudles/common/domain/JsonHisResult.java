package com.region.moudles.common.domain;

import java.util.ArrayList;

public class JsonHisResult {


    private int retCode;
    private String retMsg;
    private ArrayList<String> faillist;


    public JsonHisResult( int retCode, String retMsg,ArrayList<String> faillist){
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.faillist=faillist;
    }



    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }


    public ArrayList<String> getFaillist() {
        return faillist;
    }

    public void setFaillist(ArrayList<String> faillist) {
        this.faillist = faillist;
    }
}
