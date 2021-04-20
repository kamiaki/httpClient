package com.aki;

import lombok.Data;

import java.util.List;

@Data
public class User {

    /**
     * subscribe : 1
     * openid : oVxDHwy_N6eAvhvrBm59NPF__Rks
     * nickname : 沙文歌
     * sex : 1
     * language : zh_CN
     * city :
     * province :
     * country : 日本
     * headimgurl : http://thirdwx.qlogo.cn/mmopen/YJRxdVcMCa7JIHceyaHzZnoYM9SCa9xg2r6YueHgJvOYicAZ3w8wbWftVpUJX2UEvnAkvdLJhFR9ubhLNSfV3AUK6jxyIzpNs/132
     * subscribe_time : 1604052959
     * remark :
     * groupid : 0
     * tagid_list : []
     * subscribe_scene : ADD_SCENE_SEARCH
     * qr_scene : 0
     * qr_scene_str :
     */

    private int subscribe;
    private String openid;
    private String nickname;
    private int sex;
    private String language;
    private String city;
    private String province;
    private String country;
    private String headimgurl;
    private int subscribe_time;
    private String remark;
    private int groupid;
    private String subscribe_scene;
    private int qr_scene;
    private String qr_scene_str;
    private List<?> tagid_list;
}
