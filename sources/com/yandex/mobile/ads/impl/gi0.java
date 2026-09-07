package com.yandex.mobile.ads.impl;

import com.android.volley.toolbox.HttpClientStack;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes13.dex */
public final class gi0 extends mk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f9005a;
    private final SSLSocketFactory b;

    public interface b extends m82 {
    }

    private static void a(HttpURLConnection httpURLConnection, np1 np1Var, byte[] bArr) throws IOException {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    static ArrayList a(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new hf0((String) entry.getKey(), (String) it.next()));
                }
            }
        }
        return arrayList;
    }

    public gi0(b bVar, SSLSocketFactory sSLSocketFactory) {
        this.f9005a = bVar;
        this.b = sSLSocketFactory;
    }

    @Override // com.yandex.mobile.ads.impl.mk
    public final zh0 a(np1<?> np1Var, Map<String, String> map) throws Throwable {
        SSLSocketFactory sSLSocketFactory;
        String strL = np1Var.l();
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.putAll(np1Var.e());
        b bVar = this.f9005a;
        if (bVar != null) {
            String strA = bVar.a(strL);
            if (strA == null) {
                throw new IOException("URL blocked by rewriter: " + strL);
            }
            strL = strA;
        }
        URL url = new URL(strL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        int iJ = np1Var.j();
        httpURLConnection.setConnectTimeout(iJ);
        httpURLConnection.setReadTimeout(iJ);
        boolean z = false;
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.b) != null) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        try {
            for (String str : map2.keySet()) {
                httpURLConnection.setRequestProperty(str, (String) map2.get(str));
            }
            a(np1Var, httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != -1) {
                if (np1Var.f() != 4 && ((100 > responseCode || responseCode >= 200) && responseCode != 204 && responseCode != 304)) {
                    try {
                        return new zh0(responseCode, a(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new a(httpURLConnection));
                    } catch (Throwable th) {
                        th = th;
                        z = true;
                        if (!z) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                zh0 zh0Var = new zh0(responseCode, a(httpURLConnection.getHeaderFields()), -1, null);
                httpURLConnection.disconnect();
                return zh0Var;
            }
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        } catch (Throwable th2) {
            th = th2;
        }
    }

    static class a extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HttpURLConnection f9006a;

        a(HttpURLConnection httpURLConnection) {
            super(gi0.a(httpURLConnection));
            this.f9006a = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            super.close();
            this.f9006a.disconnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream a(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    static void a(np1 np1Var, HttpURLConnection httpURLConnection) throws zh, IOException {
        switch (np1Var.f()) {
            case -1:
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                byte[] bArrB = np1Var.b();
                if (bArrB != null) {
                    a(httpURLConnection, np1Var, bArrB);
                    return;
                }
                return;
            case 2:
                httpURLConnection.setRequestMethod(com.safedk.android.a.g.f);
                byte[] bArrB2 = np1Var.b();
                if (bArrB2 != null) {
                    a(httpURLConnection, np1Var, bArrB2);
                    return;
                }
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod(HttpClientStack.HttpPatch.METHOD_NAME);
                byte[] bArrB3 = np1Var.b();
                if (bArrB3 != null) {
                    a(httpURLConnection, np1Var, bArrB3);
                    return;
                }
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }
}
