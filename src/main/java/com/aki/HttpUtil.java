package com.aki;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * http 请求工具类
 * @author shenz
 *
 */
public class HttpUtil {
	private static Log log = LogFactory.getLog(HttpUtil.class);

	public static boolean isNullStr(String s) {
		return s == null || s.trim().length() <= 0;
	}
	
	/**
	 * 执行一个HTTP GET请求，返回请求响应的HTML
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param queryString
	 *            请求的查询参数,可以为null
	 * @return 返回请求响应的HTML
	 */
	public static String doGet(String url, String queryString,int timeout) {
		String response = null;
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(url);
		if(timeout>0){
			client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout);   
			client.getHttpConnectionManager().getParams().setSoTimeout(timeout);
		}
		try {
			if (!isNullStr(queryString))
				method.setQueryString(URIUtil.encodeQuery(queryString));
			client.executeMethod(method);
			if (method.getStatusCode() == HttpStatus.SC_OK)
				response = method.getResponseBodyAsString();
		} catch (URIException e) {
			log.error("执行HTTP Get请求时，编码查询字符串“" + queryString + "”发生异常！", e);
		} catch (IOException e) {
			log.error("执行HTTP Get请求" + url + "时，发生异常！", e);
		} finally {
			method.releaseConnection();
		}
		return response;
	}

	/**
	 * 执行一个HTTP POST请求，返回请求响应的HTML
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param params
	 *            请求的查询参数,可以为null
	 * @return 返回请求响应的HTML
	 */
	public static String doPost(String url, Map<String, String> params,int timeout) {
		String response = null;
		HttpClient client = new HttpClient();
		HttpMethod method = new PostMethod(url);
		if(timeout>0){
			client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout);   
			client.getHttpConnectionManager().getParams().setSoTimeout(timeout);
		}
		// 设置Http Post数据
		if (params != null) {
			HttpMethodParams p = new HttpMethodParams();
			for (Map.Entry<String, String> entry : params.entrySet()) {
				p.setParameter(entry.getKey(), entry.getValue());
			}
			method.setParams(p);
		}
		try {
			client.executeMethod(method);
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				response = method.getResponseBodyAsString();
			}
			System.out.println(method.getStatusCode());
		} catch (IOException e) {
			log.error("执行HTTP Post请求" + url + "时，发生异常！", e);
		} finally {
			method.releaseConnection();
		}

		return response;
	}
	
	
	/**
	 * 执行一个HTTP POST请求，返回请求响应的HTML
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param data
	 *            请求的查询参数,可以为null
	 * @return 返回请求响应的HTML
	 */
	public static String doPostJson(String url, String data,int timeout) {
		System.out.println("====================【http请求日志记录】==========================");
		System.out.println("[请求地址]："+url);
		System.out.println("[请求数据]："+data);
		System.out.println("[超时时间]："+timeout);
		long startTime = System.currentTimeMillis();
		String response = null;
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(url);
		if(timeout>0){
			client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout);   
			client.getHttpConnectionManager().getParams().setSoTimeout(timeout);
		}
	    
		try {
			// 设置Http Post数据
			RequestEntity requestEntity = new StringRequestEntity(data,"application/json","UTF-8");
		    method.setRequestEntity(requestEntity);
		    
			client.executeMethod(method);
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				response = method.getResponseBodyAsString();
			}
			System.out.println("[执行时间]："+(System.currentTimeMillis()-startTime)+"(ms)");
			System.out.println("[返回状态]："+method.getStatusCode());
			System.out.println("[返回数据]："+response);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[异常信息]："+e.getMessage());
		} finally {
			method.releaseConnection();
		}

		return response;
	}
}
