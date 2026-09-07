package com.fyber.inneractive.sdk.web;

import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.safedk.android.internal.partials.DTExchangeNetworkBridge;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class c0 {
    public static final byte[] b = new byte[0];
    public static final c0 c = new c0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f2403a = new a0();

    public static d0 a(HttpURLConnection httpURLConnection, ByteBuffer byteBuffer) throws IOException {
        InputStream inputStreamUrlConnectionGetInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        String str;
        String strTrim;
        httpURLConnection.connect();
        for (int i = 0; i < 20; i++) {
            int iHttpUrlConnectionGetResponseCode = DTExchangeNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
            if (iHttpUrlConnectionGetResponseCode < 300 || iHttpUrlConnectionGetResponseCode >= 400) {
                try {
                    inputStreamUrlConnectionGetInputStream = DTExchangeNetworkBridge.urlConnectionGetInputStream(httpURLConnection);
                    try {
                        byte[] bArrArray = byteBuffer.array();
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                int i2 = inputStreamUrlConnectionGetInputStream.read(bArrArray);
                                if (i2 == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArrArray, 0, i2);
                            } catch (Throwable unused) {
                            }
                        }
                    } catch (Throwable unused2) {
                        byteArrayOutputStream = null;
                    }
                } catch (Throwable unused3) {
                    inputStreamUrlConnectionGetInputStream = null;
                }
                AbstractC3256u.b(inputStreamUrlConnectionGetInputStream);
                DTExchangeNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                String contentType = httpURLConnection.getContentType();
                if (TextUtils.isEmpty(contentType)) {
                    str = "";
                    strTrim = str;
                } else {
                    String[] strArrSplit = contentType.split(";");
                    String strTrim2 = strArrSplit.length > 0 ? strArrSplit[0].trim() : "";
                    if (strArrSplit.length > 1) {
                        strTrim = strArrSplit[1].trim();
                        str = strTrim2;
                    } else {
                        str = strTrim2;
                        strTrim = "";
                    }
                }
                HashMap map = new HashMap();
                Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                if (headerFields != null) {
                    for (String str2 : headerFields.keySet()) {
                        List<String> list = headerFields.get(str2);
                        if (list != null && list.size() > 0) {
                            map.put(str2, list.get(0));
                        }
                    }
                }
                String responseMessage = httpURLConnection.getResponseMessage();
                if (TextUtils.isEmpty(responseMessage)) {
                    return null;
                }
                return new d0(byteArrayOutputStream == null ? b : byteArrayOutputStream.toByteArray(), map, str, strTrim, iHttpUrlConnectionGetResponseCode, responseMessage);
            }
            String headerField = httpURLConnection.getHeaderField("Location");
            if (TextUtils.isEmpty(headerField)) {
                return null;
            }
            DTExchangeNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
            httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
            httpURLConnection.connect();
        }
        return null;
    }

    public static void a(WebResourceRequest webResourceRequest, HttpURLConnection httpURLConnection) {
        if (webResourceRequest.getRequestHeaders() == null || webResourceRequest.getRequestHeaders().size() <= 0) {
            return;
        }
        for (String str : webResourceRequest.getRequestHeaders().keySet()) {
            if (str != null && webResourceRequest.getRequestHeaders().get(str) != null) {
                httpURLConnection.setRequestProperty(str, webResourceRequest.getRequestHeaders().get(str));
            }
        }
    }
}
