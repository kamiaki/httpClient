package com.aki;

import com.google.gson.Gson;

import java.util.Map;

/**
 * Hello world!
 */
public class App {
    //    public static final String url = "http://web.juhe.cn:8080/finance/stock/hs";//请求接口地址
    // 获取token
    public static final String url0 = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx501e543f56ab0199&secret=ff9b90cae6a47ab31a11386da59c8092";

    public static final String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=44_LR3gMJJjOsednOXJJchsIbkDBp6o9v5PaJHnFlZKUMFrKouDpFIecE4405YImBqJp4NUwg2o7QDlADBCN8c2XUlCbPv4KVVns-IcIQY9fMGSAW17PPutWThMvMPxuNcH7-iJiWEB8vBtEF10IWJeAIASGT&next_openid=";//请求接口地址
    public static final String url2 = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=44_LR3gMJJjOsednOXJJchsIbkDBp6o9v5PaJHnFlZKUMFrKouDpFIecE4405YImBqJp4NUwg2o7QDlADBCN8c2XUlCbPv4KVVns-IcIQY9fMGSAW17PPutWThMvMPxuNcH7-iJiWEB8vBtEF10IWJeAIASGT&openid=";
    public static final String url3 = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=44_LR3gMJJjOsednOXJJchsIbkDBp6o9v5PaJHnFlZKUMFrKouDpFIecE4405YImBqJp4NUwg2o7QDlADBCN8c2XUlCbPv4KVVns-IcIQY9fMGSAW17PPutWThMvMPxuNcH7-iJiWEB8vBtEF10IWJeAIASGT";

//    public static void main(String[] args) {
//        String s = HttpUtil.doGet(url, null, 10 * 1000);
//        System.out.println(s);
//        UserList userList = new Gson().fromJson(s, UserList.class);
//        UserList.DataBean data = userList.getData();
//        List<String> openid = data.getOpenid();
//        System.out.println(openid);
//
//        openid.forEach(x -> {
//            String ss = HttpUtil.doGet(url2 + x, null, 10 * 1000);
//            String message = null;
//            try {
//                message =  new String(ss.getBytes("ISO-8859-1"), "UTF-8");;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            User user = new Gson().fromJson(message, User.class);
//            System.out.println(user);
//        });
//    }

    // oVxDHw4gpAc8GILAZ2wxl7Tpvs3E 王小秋
    //oVxDHw2KKN1FKYV22nuHAnnmVx70

    public static void main(String[] args) {
        String json = "{\"touser\":\"oVxDHw4gpAc8GILAZ2wxl7Tpvs3E\",\"msgtype\":\"text\",\"text\":{\"content\":\"aaa\"}}";
        Map map = new Gson().fromJson(json, Map.class);
        String s = HttpUtil.doPostJson(url3, json, 10 * 1000);
        System.out.println(s);
    }
}
