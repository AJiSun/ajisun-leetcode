package org.ajisun.coding.leetcode;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Copyright (c) 2021. ajisun. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.leetcode
 * @Date: 2021/4/22
 * @author: ajisun
 * @Email: sunj.guang@foxmail.com
 */
public class EmployeeSyncTest {

    public static void main(String[] args) {


        String url= "http://localhost:8700/hippius/v1/sync/employee/batchOperateV2";



        JSONArray jsonArray = new JSONArray();
        for (int i=83821;i<=93820;i++){

            JSONArray positionList = new JSONArray();
            JSONObject position1 = new JSONObject();
            position1.put("positionCode","FIN1000");
            position1.put("primaryPositionFlag","1");
            positionList.add(position1);
            JSONObject position2 = new JSONObject();
            position2.put("positionCode","HR1001");
            position2.put("primaryPositionFlag","0");

            positionList.add(position2);
            JSONArray propertyList = new JSONArray();
            JSONObject property = new JSONObject();
            property.put("propertyKey","baseAddr");
            property.put("infoName","上海");
            propertyList.add(property);

            JSONObject data = new JSONObject();
            data.put("name",i);
            data.put("nameEn",i);

            data.put("employeeNum","hips"+i);


            data.put("mobile","131629"+i);

            data.put("email",i+"@qq.com");

            data.put("gender","0");
            data.put("status","ON");
            data.put("ldapFlag","0");
            data.put("imageUrl","http://www.baidu.com");
            data.put("enabledFlag","1");
            data.put("list", positionList);
            data.put("propertyInfoDTOS",propertyList);

            jsonArray.add(data);
        }


        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/ajisun/Desktop/employeeData.txt"));
            bw.write(jsonArray.toString());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("start-time:"+System.currentTimeMillis());
        Long startTime =System.currentTimeMillis();
        String result = doPost(url,jsonArray.toString());
        System.out.println("end-time:"+ System.currentTimeMillis());
        System.out.println("all-time:"+ (System.currentTimeMillis()-startTime));


    }


    public static String doPost(String httpUrl, String param) {

        HttpURLConnection connection = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        String result = null;
        try {
            URL url = new URL(httpUrl);
            // 通过远程url连接对象打开连接
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接请求方式
            connection.setRequestMethod("POST");
            // 设置连接主机服务器超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取主机服务器返回数据超时时间：60000毫秒
            connection.setReadTimeout(60000);

            // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
            connection.setDoOutput(true);
            // 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
            connection.setDoInput(true);
            // 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式。
            connection.setRequestProperty("Content-Type", "application/json");
            // 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
            connection.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
            // 通过连接对象获取一个输出流
            os = connection.getOutputStream();
            // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的
            os.write(param.getBytes());
            // 通过连接对象获取一个输入流，向远程读取
            if (connection.getResponseCode() == 200) {

                is = connection.getInputStream();
                // 对输入流对象进行包装:charset根据工作项目组的要求来设置
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                StringBuffer sbf = new StringBuffer();
                String temp = null;
                // 循环遍历一行一行读取数据
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 断开与远程地址url的连接
            connection.disconnect();
        }
        return result;
    }


}
