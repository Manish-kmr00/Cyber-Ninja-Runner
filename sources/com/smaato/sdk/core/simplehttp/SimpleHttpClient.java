package com.smaato.sdk.core.simplehttp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.network.HttpClient;
import com.smaato.sdk.core.network.Request;
import com.smaato.sdk.core.network.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public class SimpleHttpClient {
    private final HttpClient httpClient;
    private final Logger logger;

    public SimpleHttpClient(HttpClient httpClient, Logger logger) {
        this.logger = logger;
        this.httpClient = httpClient;
    }

    public void fireAndTrackSuccess(List<String> list, List<String> list2, List<Exception> list3) {
        for (String str : list) {
            try {
                readBody(doNetworkRequest(str, null));
            } catch (Exception e) {
                this.logger.error(LogDomain.CORE, "Http request failed for url: " + str, new Object[0]);
                list2.add(str);
                if (list3 != null) {
                    list3.add(e);
                }
            }
        }
    }

    public void fireAndForget(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            readString(it.next(), null);
        }
    }

    public String readString(String str, Map<String, List<String>> map) {
        try {
            return readStringOrThrowNetworkException(str, map);
        } catch (Exception unused) {
            this.logger.error(LogDomain.CORE, "Http request failed for url: " + str, new Object[0]);
            return null;
        }
    }

    public String readStringOrThrowNetworkException(String str, Map<String, List<String>> map) throws IOException {
        return readBody(doNetworkRequest(str, map));
    }

    public Bitmap readBitmap(String str) throws IOException {
        InputStream inputStreamDoNetworkRequest = doNetworkRequest(str, null);
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamDoNetworkRequest);
            if (inputStreamDoNetworkRequest != null) {
                inputStreamDoNetworkRequest.close();
            }
            return bitmapDecodeStream;
        } catch (Throwable th) {
            if (inputStreamDoNetworkRequest != null) {
                try {
                    inputStreamDoNetworkRequest.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void sendDataAndForget(String str, String str2) {
        try {
            Response responseExecute = this.httpClient.newCall(Request.post(str, str2.getBytes())).execute();
            if (responseExecute.responseCode() == 200) {
                this.logger.debug(LogDomain.CORE, "Sent data, URL = " + str, new Object[0]);
            } else {
                this.logger.error(LogDomain.CORE, "Sending data to %s failed, response code %d", str, Integer.valueOf(responseExecute.responseCode()));
            }
        } catch (Exception e) {
            this.logger.error(LogDomain.CORE, e, "Sending data to %s failed", str);
        }
    }

    public InputStream doNetworkRequest(String str, Map<String, List<String>> map) throws IOException {
        Response responseExecute = this.httpClient.newCall(Request.get(str)).execute();
        if (map != null) {
            map.putAll(responseExecute.headers().headers());
        }
        return responseExecute.body().source();
    }

    private String readBody(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                } else {
                    String string = sb.toString();
                    bufferedReader.close();
                    return string;
                }
            }
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
