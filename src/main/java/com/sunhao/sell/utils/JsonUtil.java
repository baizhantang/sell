package com.sunhao.sell.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @author sunhao
 * @create 2018-06-03  下午6:29
 */
public class JsonUtil {
    public static String toJson(Object object) {
        return JSONObject.toJSONString(object);
    }
}
