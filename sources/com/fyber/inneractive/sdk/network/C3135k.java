package com.fyber.inneractive.sdk.network;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.internal.partials.DTExchangeNetworkBridge;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.network.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3135k extends AbstractC3133i implements InterfaceC3132h {
    @Override // com.fyber.inneractive.sdk.network.InterfaceC3132h
    public final C3136l a(U u, String str, String str2) throws C3126b, q0, t0 {
        C3136l c3136lA;
        IAlog.a("%s hurl network stack is in use", "HttpExecutorImpl");
        URL url = new URL(u.p());
        ArrayList arrayList = new ArrayList();
        arrayList.add(u.p());
        Pair pairA = a(u, arrayList, url, str, str2);
        HttpURLConnection httpURLConnection = (HttpURLConnection) pairA.second;
        List list = (List) pairA.first;
        if (httpURLConnection == null) {
            try {
                if (list.size() <= 0) {
                    throw new q0();
                }
            } catch (SocketTimeoutException e) {
                throw new t0(e);
            } catch (IOException e2) {
                IAlog.a("failed reading network response", e2, new Object[0]);
                throw new q0(e2);
            }
        }
        FilterInputStream filterInputStreamA = null;
        if (httpURLConnection == null) {
            c3136lA = AbstractC3133i.a(null, 200, "", null, null);
        } else {
            try {
                filterInputStreamA = AbstractC3133i.a(DTExchangeNetworkBridge.urlConnectionGetInputStream(httpURLConnection), TextUtils.equals("gzip", httpURLConnection.getContentEncoding()));
            } catch (Exception unused) {
            }
            c3136lA = AbstractC3133i.a(filterInputStreamA, DTExchangeNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection), httpURLConnection.getResponseMessage(), httpURLConnection.getHeaderFields(), httpURLConnection.getHeaderField(HttpHeaders.LAST_MODIFIED));
        }
        C3134j c3134j = new C3134j(httpURLConnection, c3136lA.f1924a, (FilterInputStream) c3136lA.c, c3136lA.d, c3136lA.e);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c3134j.f.add((String) it.next());
        }
        return c3134j;
    }

    public static Pair a(U u, ArrayList arrayList, URL url, String str, String str2) throws C3126b {
        String headerField;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            u.getClass();
            if (u instanceof h0) {
                httpURLConnection.setInstanceFollowRedirects(false);
            }
            l0 l0VarN = u.n();
            httpURLConnection.setConnectTimeout(l0VarN.f1925a);
            httpURLConnection.setReadTimeout(l0VarN.b);
            a(httpURLConnection, "User-Agent", str);
            a(httpURLConnection, HttpHeaders.IF_MODIFIED_SINCE, str2);
            a(httpURLConnection, HttpHeaders.ACCEPT_ENCODING, "gzip");
            Map mapJ = u.j();
            if (mapJ != null) {
                for (String str3 : mapJ.keySet()) {
                    a(httpURLConnection, str3, (String) mapJ.get(str3));
                }
            }
            u.c(System.currentTimeMillis());
            if (u.k() != M.POST && u.k() != M.PUT) {
                httpURLConnection.connect();
            } else {
                a(httpURLConnection, u);
            }
            int iHttpUrlConnectionGetResponseCode = DTExchangeNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
            u.a(System.currentTimeMillis());
            IAlog.a("%s (%s) response code - %d", u.toString(), url, Integer.valueOf(iHttpUrlConnectionGetResponseCode));
            if ((u instanceof h0) && (((iHttpUrlConnectionGetResponseCode > 300 && iHttpUrlConnectionGetResponseCode < 304) || iHttpUrlConnectionGetResponseCode == 307 || iHttpUrlConnectionGetResponseCode == 308) && (headerField = httpURLConnection.getHeaderField("Location")) != null)) {
                if (!headerField.startsWith("http") && !headerField.contains("://") && arrayList.size() > 0) {
                    Uri uri = Uri.parse((String) arrayList.get(arrayList.size() - 1));
                    headerField = String.format(headerField.startsWith(RemoteSettings.FORWARD_SLASH_STRING) ? "%s://%s%s" : "%s://%s/%s", uri.getScheme(), uri.getHost(), headerField);
                }
                arrayList.add(headerField);
                if (arrayList.size() <= 20) {
                    if (headerField.startsWith("http")) {
                        return a(u, arrayList, new URL(headerField), str, str2);
                    }
                    return Pair.create(arrayList, null);
                }
                throw new C3126b("Url chain too big for us");
            }
            return new Pair(arrayList, httpURLConnection);
        } catch (Exception e) {
            u.a(System.currentTimeMillis());
            IAlog.a("failed executing network request", e, new Object[0]);
            throw new C3126b(e);
        }
    }

    public static void a(HttpURLConnection httpURLConnection, U u) throws IOException {
        httpURLConnection.setRequestMethod(u.k().key);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        byte[] bArrD = u.d();
        httpURLConnection.setRequestProperty("Content-Length", "" + (bArrD != null ? bArrD.length : 0));
        httpURLConnection.setRequestProperty("Content-Type", u.l());
        httpURLConnection.connect();
        OutputStream outputStreamUrlConnectionGetOutputStream = DTExchangeNetworkBridge.urlConnectionGetOutputStream(httpURLConnection);
        outputStreamUrlConnectionGetOutputStream.write(bArrD);
        try {
            outputStreamUrlConnectionGetOutputStream.close();
        } catch (Throwable unused) {
        }
    }

    public static void a(HttpURLConnection httpURLConnection, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        IAlog.d("%s %s : %s", "REQUEST_HEADER", str, str2);
        httpURLConnection.addRequestProperty(str, str2);
    }
}
