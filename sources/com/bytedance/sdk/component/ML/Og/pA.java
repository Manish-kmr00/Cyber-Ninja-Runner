package com.bytedance.sdk.component.ML.Og;

import android.util.Log;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class pA implements com.bytedance.sdk.component.ML.ZZv<ZZv> {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    @Override // com.bytedance.sdk.component.ML.ZZv
    /* JADX INFO: renamed from: Og, reason: merged with bridge method [inline-methods] */
    public ZZv<byte[]> pA(com.bytedance.sdk.component.ML.ML ml) throws Throwable {
        InputStream inputStreamUrlConnectionGetInputStream;
        byte[] byteArray;
        ?? byteArrayOutputStream;
        String message;
        ?? r6;
        InputStream inputStream = null;
        Map<String, String> mapPA = null;
        int i = 0;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(ml.pA()).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.connect();
                inputStreamUrlConnectionGetInputStream = PangleNetworkBridge.urlConnectionGetInputStream(httpURLConnection);
                try {
                    byte[] bArr = new byte[1024];
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        while (true) {
                            try {
                                int i2 = inputStreamUrlConnectionGetInputStream.read(bArr);
                                if (i2 == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, i2);
                            } catch (MalformedURLException e) {
                                e = e;
                                byteArray = null;
                            } catch (IOException e2) {
                                e = e2;
                                byteArray = null;
                            }
                            Log.w("InternalHttpClient", "MalformedURLException:" + e.getMessage());
                            message = e.getMessage();
                            r6 = byteArrayOutputStream;
                            com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(inputStreamUrlConnectionGetInputStream);
                            com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(r6);
                            return new ZZv<>(i, byteArray, message, mapPA);
                        }
                        mapPA = ml.Og() ? pA(httpURLConnection) : null;
                        com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(inputStreamUrlConnectionGetInputStream);
                        com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(byteArrayOutputStream);
                        message = "success";
                    } catch (MalformedURLException e3) {
                        e = e3;
                        Log.w("InternalHttpClient", "MalformedURLException:" + e.getMessage());
                        message = e.getMessage();
                        r6 = byteArrayOutputStream;
                        com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(inputStreamUrlConnectionGetInputStream);
                        com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(r6);
                    } catch (IOException e4) {
                        e = e4;
                        Log.w("InternalHttpClient", "IOException:" + e.getMessage());
                        message = e.getMessage();
                        r6 = byteArrayOutputStream;
                        com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(inputStreamUrlConnectionGetInputStream);
                        com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(r6);
                    }
                    i = 200;
                    byteArray = byteArrayOutputStream.toByteArray();
                } catch (MalformedURLException e5) {
                    e = e5;
                    byteArray = null;
                    byteArrayOutputStream = byteArray;
                } catch (IOException e6) {
                    e = e6;
                    byteArray = null;
                    byteArrayOutputStream = byteArray;
                    Log.w("InternalHttpClient", "IOException:" + e.getMessage());
                    message = e.getMessage();
                    r6 = byteArrayOutputStream;
                    com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(inputStreamUrlConnectionGetInputStream);
                    com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(r6);
                    return new ZZv<>(i, byteArray, message, mapPA);
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStreamUrlConnectionGetInputStream;
                    com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(inputStream);
                    com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(0);
                    throw th;
                }
            } catch (MalformedURLException e7) {
                e = e7;
                inputStreamUrlConnectionGetInputStream = null;
                byteArray = null;
            } catch (IOException e8) {
                e = e8;
                inputStreamUrlConnectionGetInputStream = null;
                byteArray = null;
            } catch (Throwable th2) {
                th = th2;
                com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(inputStream);
                com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(0);
                throw th;
            }
            return new ZZv<>(i, byteArray, message, mapPA);
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private Map<String, String> pA(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list != null && list.size() > 0) {
                map.put(str, list.get(0));
            }
        }
        return map;
    }
}
