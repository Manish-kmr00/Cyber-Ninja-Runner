package com.fyber.inneractive.sdk.network;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.internal.partials.DTExchangeNetworkBridge;
import java.io.FilterInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes13.dex */
public final class p0 extends AbstractC3133i implements InterfaceC3132h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OkHttpClient f1929a = new OkHttpClient().newBuilder().build();

    public static HashMap b(Response response) {
        HashMap map = new HashMap();
        if (response != null) {
            Headers headers = response.headers();
            for (int i = 0; i < headers.size(); i++) {
                String strName = headers.name(i);
                map.put(strName, Collections.singletonList(headers.get(strName)));
            }
        }
        return map;
    }

    @Override // com.fyber.inneractive.sdk.network.InterfaceC3132h
    public final C3136l a(U u, String str, String str2) throws Exception {
        IAlog.a("%s okhttp network stack is in use", "OkHttpExecutorImpl");
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(u.p());
            Pair pairA = a(u.p(), u, arrayList, str, str2);
            Object obj = pairA.second;
            String strMessage = obj != null ? ((Response) obj).message() : "";
            FilterInputStream filterInputStreamA = a((Response) pairA.second);
            Object obj2 = pairA.second;
            int iCode = obj2 == null ? -1 : ((Response) obj2).code();
            HashMap mapB = b((Response) pairA.second);
            Response response = (Response) pairA.second;
            o0 o0Var = new o0(AbstractC3133i.a(filterInputStreamA, iCode, strMessage, mapB, response != null ? response.headers().get(HttpHeaders.LAST_MODIFIED) : null), (Response) pairA.second);
            Iterator it = ((List) pairA.first).iterator();
            while (it.hasNext()) {
                o0Var.f.add((String) it.next());
            }
            return o0Var;
        } catch (C3126b e) {
            IAlog.b("%s cannot connect exception: %s", "OkHttpExecutorImpl", e.getMessage());
            throw e;
        } catch (Exception e2) {
            IAlog.b("%s exception: %s", "OkHttpExecutorImpl", e2.getMessage());
            throw e2;
        }
    }

    public final Pair a(String str, U u, ArrayList arrayList, String str2, String str3) throws Exception {
        String strHeader;
        l0 l0VarN = u.n();
        Request.Builder builder = new Request.Builder();
        a(builder, HttpHeaders.ACCEPT_ENCODING, "gzip");
        a(builder, "User-Agent", str2);
        a(builder, HttpHeaders.IF_MODIFIED_SINCE, str3);
        Map mapJ = u.j();
        if (mapJ != null) {
            for (String str4 : mapJ.keySet()) {
                a(builder, str4, (String) mapJ.get(str4));
            }
        }
        builder.url(str);
        if (u.k() == M.POST || u.k() == M.PUT) {
            byte[] bArrD = u.d();
            if (bArrD != null) {
                builder.post(RequestBody.create(bArrD, MediaType.parse(u.l())));
            } else {
                throw new Exception("Could not create ok http request. post payload is null");
            }
        }
        Request requestBuild = builder.build();
        boolean z = !(u instanceof h0);
        OkHttpClient.Builder builderFollowSslRedirects = this.f1929a.newBuilder().followRedirects(z).followSslRedirects(z);
        long j = l0VarN.f1925a;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient okHttpClientBuild = builderFollowSslRedirects.connectTimeout(j, timeUnit).readTimeout(l0VarN.b, timeUnit).build();
        u.c(System.currentTimeMillis());
        IAlog.a("OkHttpExecutorImpl: start connection timestamp: %s", u.g);
        try {
            try {
                Response responseOkhttp3CallExecute = DTExchangeNetworkBridge.okhttp3CallExecute(okHttpClientBuild.newCall(requestBuild));
                if ((u instanceof h0) && (((responseOkhttp3CallExecute.code() > 300 && responseOkhttp3CallExecute.code() < 304) || responseOkhttp3CallExecute.code() == 307 || responseOkhttp3CallExecute.code() == 308) && (strHeader = responseOkhttp3CallExecute.header("Location", "")) != null)) {
                    if (!strHeader.startsWith("http") && !strHeader.contains("://") && arrayList.size() > 0) {
                        Uri uri = Uri.parse((String) arrayList.get(arrayList.size() - 1));
                        strHeader = String.format(strHeader.startsWith(RemoteSettings.FORWARD_SLASH_STRING) ? "%s://%s%s" : "%s://%s/%s", uri.getScheme(), uri.getHost(), strHeader);
                    }
                    String str5 = strHeader;
                    arrayList.add(str5);
                    if (arrayList.size() <= 5) {
                        Pair pairA = a(str5, u, arrayList, str2, str3);
                        u.a(System.currentTimeMillis());
                        IAlog.a("OkHttpExecutorImpl: end connection timestamp: %s", u.g);
                        return pairA;
                    }
                    throw new C3126b("Url chain too big for us");
                }
                Pair pair = new Pair(arrayList, responseOkhttp3CallExecute);
                u.a(System.currentTimeMillis());
                IAlog.a("OkHttpExecutorImpl: end connection timestamp: %s", u.g);
                return pair;
            } catch (Exception e) {
                throw new C3126b(e);
            }
        } catch (Throwable th) {
            u.a(System.currentTimeMillis());
            IAlog.a("OkHttpExecutorImpl: end connection timestamp: %s", u.g);
            throw th;
        }
    }

    public static FilterInputStream a(Response response) {
        if (response == null) {
            return null;
        }
        try {
            if (DTExchangeNetworkBridge.okhttp3Response_body(response) == null) {
                return null;
            }
            return AbstractC3133i.a(DTExchangeNetworkBridge.okhttp3Response_body(response).byteStream(), TextUtils.equals("gzip", response.headers().get("content-encoding")));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Request.Builder builder, String str, String str2) {
        IAlog.d("%s %s : %s", "REQUEST_HEADER", str, str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.addHeader(str, str2);
    }
}
