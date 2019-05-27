package com.shaozj.sdk.qy.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shaozj.sdk.qy.exception.WxHttpException;


/**
 * 
 * 文件描述: HTTP请求工具类<br>
 * 版权所有: Copyright (c) 2019年5月21日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月21日 上午11:09:35<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public class HttpUtil {

	private static int DEFAULT_TIME_OUT = 5000;// 超时时间 单位毫秒

	protected static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	
	/**
	 * 
	 * 方法描述: post 请求<br>
	 * 完成时间: 2019年5月21日 上午11:15:55<br>
	 * 作者: szj<br>
	 *
	 * @param endurls
	 * @param map
	 * @return
	 */
	public static String post(String endurls, Map<String, Object> map) {
        return post(endurls, map, null, null, DEFAULT_TIME_OUT);
    }
	
	/**
	 * 
	 * 方法描述: post 请求<br>
	 * 完成时间: 2019年5月21日 上午11:13:39<br>
	 * 作者: szj<br>
	 *
	 * @param endurls 请求url
	 * @param map 消息内容
	 * @param body  消息体
	 * @param headers 消息头
	 * @param timeOut 超时时间
	 * @return
	 */
	public static String post(String endurls, Map<String, Object> map, String body, Map<String, String> headers, int timeOut) {
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(timeOut)
					.setConnectTimeout(timeOut).setSocketTimeout(timeOut).build();
			HttpPost request = new HttpPost(endurls);
			request.setConfig(requestConfig);
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry.getValue() != null && !"".equals(entry.getValue())) {
                        nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
                    }
                }
            }
			if (headers != null) {// 处理header
				Iterator<String> it = headers.keySet().iterator();
				while (it.hasNext()) {
					String key = it.next();
					String value = headers.get(key);
					request.addHeader(key, value);
				}
			}
			if (nvps != null) {
                request.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            }
			if (body != null) {
                request.setEntity(new StringEntity(body, "UTF-8"));
            }
			CloseableHttpResponse response = client.execute(request);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
                    return EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
                }
			} finally {
				response.close();
				client.close();
				response = null;
				client = null;
			}
		} catch (Exception e) {
			logger.error("Post请求失败 请求地址 " + endurls, e);
			throw new WxHttpException("http请求失败", e);
		}
		return null;
	}

	/**
	 * 
	 * 方法描述: get请求<br>
	 * 完成时间: 2019年5月21日 上午11:20:46<br>
	 * 作者: szj<br>
	 *
	 * @param endurls
	 * @param map
	 * @param headers
	 * @return
	 */
	public static String get(String endurls, Map<String, Object> map, Map<String, String> headers) {
		return get(endurls, map, headers, DEFAULT_TIME_OUT);
	}

	/**
	 * 
	 * 方法描述: get 请求<br>
	 * 完成时间: 2019年5月21日 上午11:20:03<br>
	 * 作者: szj<br>
	 *
	 * @param endurls 请求url
	 * @param map 参数内容
	 * @return
	 */
	public static String get(String endurls, Map<String, Object> map) {
		return get(endurls, map, null, DEFAULT_TIME_OUT);
	}

	/**
	 * 
	 * 方法描述: get 请求<br>
	 * 完成时间: 2019年5月21日 上午11:19:48<br>
	 * 作者: szj<br>
	 *
	 * @param endurls
	 * @return
	 */
	public static String get(String endurls) {
		return get(endurls, null, null, DEFAULT_TIME_OUT);
	}

	/**
	 * 
	 * 方法描述: GET 请求<br>
	 * 完成时间: 2019年5月21日 上午11:22:33<br>
	 * 作者: szj<br>
	 *
	 * @param endurls 请求url
	 * @param timeOut 超时时间
	 * @return
	 */
	public static String get(String endurls, int timeOut) {
		return get(endurls, null, null, timeOut);
	}
	
	/**
     * 
     * 方法描述: get 请求<br>
     * 完成时间: 2019年5月21日 上午11:17:18<br>
     * 作者: szj<br>
     *
     * @param endurls 请求地址
     * @param map 请求消息
     * @param headers 请求头 
     * @param timeOut 超时时间
     * @return
     */
    public static String get(String endurls, Map<String, Object> map, Map<String, String> headers, int timeOut) {
        String result = null;
        try {
            HttpClient client = new HttpClient();
            client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");// 指定传送字符集为UTF-8格式
            client.getHttpConnectionManager().getParams().setConnectionTimeout(timeOut);// 设置连接超时时间为10秒（连接初始化时
            int stat = 0;
            if (map != null) {
                endurls += "?";
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry.getValue() != null && !"".equals(entry.getValue())) {
                        stat++;
                        if (stat == 1) {
                            endurls = endurls + entry.getKey() + "=" + entry.getValue();
                        } else {
                            endurls = endurls + "&" + entry.getKey() + "=" + entry.getValue();
                        }
                    }
                }
            }
            HttpMethod method = new GetMethod(endurls);
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    method.addRequestHeader(header.getKey(), header.getValue());
                }
            }
            int statusCode = client.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                logger.error("GET请求失败 请求地址 " + endurls + " 返回状态" + statusCode);
                throw new WxHttpException("HTTP请求失败, 错误码： " + statusCode);
            }
            InputStream inputStream = method.getResponseBodyAsStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            StringBuffer stringBuffer = new StringBuffer();
            String str = "";
            while ((str = br.readLine()) != null) {
                stringBuffer.append(str);
            }
            inputStream.close();
            result = stringBuffer.toString();// 输出反馈结果
            method.releaseConnection(); // 释放链接
            client.getHttpConnectionManager().closeIdleConnections(1);
        } catch (Exception e) {
            logger.error("GET请求失败 请求地址 " + endurls, e);
            throw new WxHttpException("http请求失败", e);
        }
        return result;
    }
}
