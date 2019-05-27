package com.shaozj.sdk.qy.client;

import java.util.Map;

public interface IWxClient {
    
    <T> T post(String endurls, Map<String, Object> params, Class<T> clz);
    
    <T> T post(String endurls, String body, Class<T> clz);
    
    <T> T get(String endurls, Map<String, Object> params, Class<T> clz);
    
    <T> T get(String endurls, Class<T> clz);
}
