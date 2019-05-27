package com.shaozj.sdk.qy.client;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.shaozj.sdk.qy.utils.HttpUtil;

public class HttpClient implements IWxClient {

    @Override
    public <T> T post(String endurls, Map<String, Object> params, Class<T> clz) {
        String resp = HttpUtil.post(endurls, params);
        return JSON.parseObject(resp, clz);
    }

    @Override
    public <T> T get(String endurls, Map<String, Object> params, Class<T> clz) {
        String resp = HttpUtil.get(endurls, params);
        return JSON.parseObject(resp, clz);
    }

    @Override
    public <T> T get(String endurls, Class<T> clz) {
        String resp = HttpUtil.get(endurls);
        return JSON.parseObject(resp, clz);
    }

    @Override
    public <T> T post(String endurls, String body, Class<T> clz) {
        return null;
    }
}
