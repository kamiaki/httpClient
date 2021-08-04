package com.aki;

import com.google.gson.Gson;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static final String appid = "wx501e543f56ab0199";
    public static final String secret = "7d06e8448e66b9644dce65657a8d21b8";

    // 获取token
    public static final String url_getToken = "https://api.weixin.qq.com/cgi-bin/token";

    public static final String url_userList = "https://api.weixin.qq.com/cgi-bin/user/get";
    public static final String url_userInfo = "https://api.weixin.qq.com/cgi-bin/user/info";
    public static final String url_sendMsg = "https://api.weixin.qq.com/cgi-bin/message/custom/send";

    public static String getAccessToken() {
        String query = "grant_type=client_credential" + "&appid=" + appid + "&secret=" + secret;
        String token = HttpUtil.doGet(url_getToken, query, 10 * 1000);
        Map<String, String> map = new Gson().fromJson(token, Map.class);
        String access_token = map.get("access_token");
        return access_token;
    }

    public static UserList getUserList(String accessToken) {
        String query = "access_token=" + accessToken;
        String userListStr = HttpUtil.doGet(url_userList, query, 10 * 1000);
        UserList userList = new Gson().fromJson(userListStr, UserList.class);
        return userList;
    }

    @SneakyThrows
    public static User getUser(String accessToken, String openid) {
        String queryX = "access_token=" + accessToken + "&openid=" + openid;
        String userInfo = HttpUtil.doGet(url_userInfo, queryX, 10 * 1000);
        String message = new String(userInfo.getBytes("ISO-8859-1"), "UTF-8");
        User user = new Gson().fromJson(message, User.class);
        return user;
    }

    public static String sendMsg(String accessToken, String openid, String msg) {
        // oVxDHw4gpAc8GILAZ2wxl7Tpvs3E 王小秋
        Gson gson = new Gson();
        Map map = new HashMap();
        map.put("touser", openid);
        map.put("msgtype", "text");
        Map text = new HashMap();
        text.put("content", msg);
        map.put("text", text);
        String json = gson.toJson(map);
        String returnStr = HttpUtil.doPostJson(url_sendMsg + "?access_token=" + accessToken, json, 10 * 1000);
        return returnStr;
    }

    @SneakyThrows
    public static void main(String[] args) {
        String accessToken = getAccessToken();
        UserList userList = getUserList(accessToken);
        UserList.DataBean data = userList.getData();
        List<String> openids = data.getOpenid();
        for (String openid : openids) {
            User user = getUser(accessToken, openid);
            if ("floyd".equals(user.getNickname())) System.out.println(user);
        }
        String reStr = sendMsg(accessToken, "oVxDHw4gpAc8GILAZ2wxl7Tpvs3E", "你好!");
        System.out.println(reStr);
    }
}
