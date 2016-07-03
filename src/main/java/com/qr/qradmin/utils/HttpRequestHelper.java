package com.qr.qradmin.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.Map;

public class HttpRequestHelper {

    public static final int DEFAULT_TIMEOUT = 20000;

    public static String httpRequest(String url, Map<String, String> params, int timeout, boolean secure) throws IOException {
        StringBuilder paramsString = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            paramsString.append(first ? "?" : "&");
            first = false;
            paramsString.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        //AFBRBS-3422
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create().useSystemProperties();
        if (!secure) {
            httpClientBuilder.setHostnameVerifier(new AllowAllHostnameVerifier());
        }

        HttpClient httpClient = httpClientBuilder.build();
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(timeout).setSocketTimeout(timeout).build();

        HttpGet httpget = new HttpGet(url + paramsString);
        httpget.setConfig(requestConfig);
        HttpResponse response = httpClient.execute(httpget);
        return getResponseAsString(response);
    }

    public static String httpRequest(String url, Map<String, String> params) throws IOException {
        return httpRequest(url, params, DEFAULT_TIMEOUT, true);
    }

    private static String getResponseAsString(HttpResponse response) throws IOException {
        String result = "";
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream instream = entity.getContent();
            StringBuffer b = new StringBuffer();
            InputStreamReader r = new InputStreamReader(instream, "UTF-8");
            int c;
            while ((c = r.read()) != -1) {
                b.append((char) c);
            }
            result = b.toString();
        }
        return result;
    }
}
