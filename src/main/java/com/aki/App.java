package com.aki;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static final String APPKEY =  "3af2d054eb0a4122e298acae4dbf5cee";
    public static final String url = "http://web.juhe.cn:8080/finance/stock/hs";//请求接口地址
    public static final String url2 = "https://94376a7d-de79-4984-9c2c-118c1ff7056b.mock.pstmn.io/huashengServer";//请求接口地址

    public static void main(String[] args) {
        Map params = new HashMap();//请求参数
        params.put("gid","sh601009");//
        params.put("key",APPKEY);//

        String s = HttpUtil.doPost(url, params, 1000);
        System.out.println(s);
        System.out.println("Hello World!");
    }
}
