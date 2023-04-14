package com.api.automation.apidemoproject;

import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SoapTest {

    private ReadEnvironment element = ReadEnvironment.getInstance();
    public ArrayList<String> tokendata;
    public String accesstoken;
    public String isAccesstoken;
    public String userId;
    public Calculator req;




    public SoapTest() {
        req=new Calculator();
    }

    @Test(testName = "Sample POST call", description = "Sample PUT call", timeOut = 190000, enabled = true, groups = {
            "smoke", "soap" })
    public void numberConversion() {
        //String text = RandomStringUtils.randomAlphabetic(10).toUpperCase();
        ArrayList<String> response=req.numberConversions(500);
        String httpcode=response.get(0);
        Reporter.log("Http code is   "+httpcode,true);
        Assert.assertEquals(httpcode,"200");
        Reporter.log("response payload is   "+response.get(1),true);


    }

    @Test(testName = "Sample POST call", description = "Sample  call", timeOut = 190000, enabled = true, groups = {
            "smoke", "soap" })
    public void calculator_Multiplication() {
        //String text = RandomStringUtils.randomAlphabetic(10).toUpperCase();
        ArrayList<String> response=req.multiplication(500,200);
        String httpcode=response.get(0);
        Reporter.log("Http code is   "+httpcode,true);
        Assert.assertEquals(httpcode,"200");
        Reporter.log("response payload is   "+response.get(1),true);


    }
}
