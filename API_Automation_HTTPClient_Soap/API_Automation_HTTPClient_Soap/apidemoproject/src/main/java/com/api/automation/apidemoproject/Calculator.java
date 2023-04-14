package com.api.automation.apidemoproject;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupDir;
import org.testng.Reporter;

import java.util.ArrayList;

public class Calculator {

    private ReadEnvironment element = ReadEnvironment.getInstance();
    HttpClient client = HttpClientBuilder.create().build();

    public ST getPayLoadTemplate1(String payLoadFileName) {
        String s = System.getProperty("user.dir") + "/src/test/resources/payloads";
        System.out.println("path is  " + s);
        STGroup group = new STGroupDir(s, '$', '$');
        ST wsTemplate = group.getInstanceOf(payLoadFileName);
        System.out.println("wsTemplate.toString();" + wsTemplate.toString());
        return wsTemplate;

    }
    public ArrayList<String> numberConversions(int randomNumber) {

        ST payloadTemplate = getPayLoadTemplate1("NumberConversion");

        payloadTemplate.add("amount", randomNumber);

//        Reporter.log("  payloadTemplate.getAttribute;" + payloadTemplate.getAttribute("name").toString(), true);
        Reporter.log("payload" + payloadTemplate.render(), true);


        ArrayList<String> array = new ArrayList<String>();
        try {
            HttpPost request = new HttpPost(element.getElement("numberConversion") );
            request.setHeader("Content-Type", element.getElement("Content-Type"));
            //request.setHeader("Accept",
                  //  "application/xml, application/xml, text/json, text/x-json, text/javascript, text/xml");

            HttpResponse response = null;
            request.setEntity(new StringEntity(payloadTemplate.render().trim(), "utf-8"));
            response = client.execute(request);

            Reporter.log("Response Code : " + response.getStatusLine().getStatusCode(), true);
            array.add(Integer.toString(response.getStatusLine().getStatusCode()));
            String getresponse = null;

            getresponse = EntityUtils.toString(response.getEntity(), "UTF-8");

            Reporter.log("recent services " + getresponse, true);
            array.add(getresponse);
            request.releaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public ArrayList<String> multiplication(int num1,int num2) {

        ST payloadTemplate = getPayLoadTemplate1("Calculator");

        payloadTemplate.add("amount1", num1);
        payloadTemplate.add("amount2", num2);

//        Reporter.log("  payloadTemplate.getAttribute;" + payloadTemplate.getAttribute("name").toString(), true);
        Reporter.log("payload" + payloadTemplate.render(), true);


        ArrayList<String> array = new ArrayList<String>();
        try {
            HttpPost request = new HttpPost(element.getElement("calculator") );
            request.setHeader("Content-Type", element.getElement("Content-Type"));

            HttpResponse response = null;
            request.setEntity(new StringEntity(payloadTemplate.render().trim(), "utf-8"));
            response = client.execute(request);

            Reporter.log("Response Code : " + response.getStatusLine().getStatusCode(), true);
            array.add(Integer.toString(response.getStatusLine().getStatusCode()));
            String getresponse = null;

            getresponse = EntityUtils.toString(response.getEntity(), "UTF-8");

            Reporter.log("recent services " + getresponse, true);
            array.add(getresponse);
            request.releaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }
}
