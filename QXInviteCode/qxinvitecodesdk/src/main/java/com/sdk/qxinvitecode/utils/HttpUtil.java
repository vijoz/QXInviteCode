package com.sdk.qxinvitecode.utils;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.ResponseStream;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.sdk.qxinvitecode.interfaces.OnCallBack;
import com.sdk.qxinvitecode.interfaces.OnUploadCallBack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/**
 * 网络请求工具类
 *
 * @author vijoz
 */
public class HttpUtil {

    public static final String TAG = "XUtil";
    private static HttpUtils http = new HttpUtils();

    public static void get(String url, final OnCallBack onCallBack) {
        http.configCurrentHttpCacheExpiry(0);
        LogUtil.w(url);
        http.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
            @Override
            public void onLoading(long total, long current, boolean isUploading) {
            }


            @Override
            public void onStart() {
            }

            @Override
            public void onFailure(HttpException error, String msg) {
//				LogUtil.v(StringEscapeUtils.unescapeJava(msg));
                onCallBack.onFiled(msg);
            }

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
//				LogUtil.v(StringEscapeUtils.unescapeJava(responseInfo.result));
                onCallBack.onSuccess(responseInfo.result);
            }
        });
    }

    public static void post(String url, Map<String, String> map, final OnCallBack onCallBack) {
        if (null == map) {
            throw new RuntimeException("map canot null");
        }
        LogUtil.w(url);
        RequestParams params = new RequestParams();

        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();

        while (entries.hasNext()) {

            Map.Entry<String, String> entry = entries.next();

            params.addBodyParameter(entry.getKey(), entry.getValue());
        }

        http.send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {

            @Override
            public void onLoading(long total, long current, boolean isUploading) {
            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFailure(HttpException error, String msg) {
//				LogUtil.v(StringEscapeUtils.unescapeJava(msg));
                onCallBack.onFiled(msg);
            }

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
//				LogUtil.v(StringEscapeUtils.unescapeJava(responseInfo.result));
                onCallBack.onSuccess(responseInfo.result);
            }
        });
    }

    public static void put(String url, Map<String, String> map, final OnCallBack onCallBack) {
        if (null == map) {
            throw new RuntimeException("map canot null");
        }
        LogUtil.w(url);
        RequestParams params = new RequestParams();

        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();

        while (entries.hasNext()) {

            Map.Entry<String, String> entry = entries.next();

            params.addBodyParameter(entry.getKey(), entry.getValue());
        }

        http.send(HttpRequest.HttpMethod.PUT, url, params, new RequestCallBack<String>() {

            @Override
            public void onLoading(long total, long current, boolean isUploading) {
            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFailure(HttpException error, String msg) {
//				LogUtil.v(StringEscapeUtils.unescapeJava(msg));
                onCallBack.onFiled(msg);
            }

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
//				LogUtil.v(StringEscapeUtils.unescapeJava(responseInfo.result));
                onCallBack.onSuccess(responseInfo.result);
            }
        });
    }

    public static void upload(String url, RequestParams params, final OnUploadCallBack onCallBack) {
        LogUtil.w(url);
        http.send(HttpRequest.HttpMethod.POST, url, params, new RequestCallBack<String>() {

            @Override
            public void onLoading(long total, long current, boolean isUploading) {
                onCallBack.onLoading(total, current, isUploading);
            }

            @Override
            public void onStart() {
                onCallBack.onStart();
            }

            @Override
            public void onFailure(HttpException error, String msg) {
//				LogUtil.v(StringEscapeUtils.unescapeJava(msg));
                onCallBack.onFiled(msg);
            }

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
//				LogUtil.v(StringEscapeUtils.unescapeJava(responseInfo.result));
                onCallBack.onSuccess(responseInfo.result);
            }
        });
    }

    /**
     * 发出post请求
     *
     * @param data      string
     * @param serverUrl 请求的url
     * @return
     * @throws IOException
     */
    public static String postMsg(String data, String serverUrl)
            throws IOException {
        LogUtil.w(serverUrl);
        LogUtil.w("" + data);
        String callback = "";
        URL url = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        HttpURLConnection httpUrlConnection = null;
        url = new URL(serverUrl);
        httpUrlConnection = (HttpURLConnection) url.openConnection();
        httpUrlConnection.setRequestMethod("POST");
        httpUrlConnection.setDoInput(true);
        httpUrlConnection.setDoOutput(true);
        httpUrlConnection.setUseCaches(false);
        httpUrlConnection.setRequestProperty("Charset", "UTF-8");
        httpUrlConnection.setConnectTimeout(15 * 1000);
        httpUrlConnection.setReadTimeout(15 * 1000);
        if (data != null) {
            outputStream = httpUrlConnection.getOutputStream();
            outputStream.write(data.getBytes());
        }

        inputStream = httpUrlConnection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                inputStream, "utf-8"));
        StringBuilder buffer = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        callback = buffer.toString();
        if (outputStream != null) {
            outputStream.close();
            outputStream = null;
        }

        if (inputStream != null) {
            inputStream.close();
            inputStream = null;
        }
        if (httpUrlConnection != null) {
            httpUrlConnection.disconnect();
            httpUrlConnection = null;
        }
        LogUtil.v(callback + "");
        return callback;
    }

    //-------------------以上的代码 是 异步请求的， 以下的代码是同步请求的-------------------------

    /**
     * Get同步请求 必须在异步块儿中执行
     *
     * @param url
     * @param userkey
     * @param str
     * @param sign
     * @return
     */
    public static String xutilsGetSync(String url, String userkey, String str, String sign) {
        RequestParams params = new RequestParams();
        params.addQueryStringParameter("userkey", userkey);
        params.addQueryStringParameter("str", str);
        params.addQueryStringParameter("sign", sign);
        HttpUtils http = new HttpUtils();
        http.configCurrentHttpCacheExpiry(1000 * 10); //设置超时时间
        try {
            ResponseStream responseStream = http.sendSync(HttpRequest.HttpMethod.GET,
                    url,
                    params);
            //int statusCode = responseStream.getStatusCode();
            //Header[] headers = responseStream.getBaseResponse().getAllHeaders();
            return responseStream.readString();
        } catch (Exception e) {
            LogUtil.e(e.getMessage(), e);
        }
        return null;
    }

    /**
     * Post同步请求 必须在异步块儿中执行
     *
     * @param url
     * @param userkey
     * @param str
     * @param sign
     * @return
     */
    public static String xutilsPostSync(String url, String userkey, String str, String sign) {
        RequestParams params = new RequestParams();
        params.addQueryStringParameter("userkey", userkey);
        params.addQueryStringParameter("str", str);
        params.addQueryStringParameter("sign", sign);
        HttpUtils http = new HttpUtils();
        http.configCurrentHttpCacheExpiry(1000 * 10); //设置超时时间
        try {
            ResponseStream responseStream = http.sendSync(HttpRequest.HttpMethod.POST,
                    url,
                    params);
            //int statusCode = responseStream.getStatusCode();
            //Header[] headers = responseStream.getBaseResponse().getAllHeaders();
            return responseStream.readString();
        } catch (Exception e) {
            LogUtil.e(e.getMessage(), e);
        }
        return null;
    }

}
