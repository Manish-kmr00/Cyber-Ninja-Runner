package com.inmobi.media;

import com.safedk.android.internal.partials.InMobiNetworkBridge;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public abstract class O8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3157a = 0;

    static {
        Intrinsics.checkNotNullExpressionValue("O8", "getSimpleName(...)");
    }

    /* JADX WARN: Code duplicated, block: B:81:0x0193  */
    /* JADX WARN: Code duplicated, block: B:84:0x019a  */
    /* JADX WARN: Code duplicated, block: B:88:0x01a1  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.net.HttpURLConnection] */
    public static Va a(Pa request, Function2 function2) {
        HttpURLConnection httpURLConnectionA;
        Va va;
        boolean z;
        Va response;
        boolean z2;
        I3 i3A;
        int i;
        Oa oa;
        Intrinsics.checkNotNullParameter(request, "request");
        String msg = "REQUEST START, Attempt:" + (request.m + 1) + ", Time:" + System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(request, "<this>");
        Intrinsics.checkNotNullParameter(msg, "msg");
        request.toString();
        boolean z3 = W8.f3228a;
        I3 i3A2 = W8.a(false);
        ?? r5 = 0;
        try {
            if (i3A2 != null) {
                response = new Va();
                response.f3220a = new P8(i3A2, "Network not reachable currently. Please try again.");
            } else {
                try {
                    httpURLConnectionA = a(request, Q8.a(request.f3170a, request.d));
                    try {
                        httpURLConnectionA.setInstanceFollowRedirects(request.g);
                        if (request.b == Ma.POST) {
                            a(request.e, httpURLConnectionA, Q8.a(request));
                        }
                        response = a(request, httpURLConnectionA);
                        W8.a(httpURLConnectionA);
                        z2 = false;
                    } catch (IOException e) {
                        e = e;
                        va = new Va();
                        va.f3220a = new P8(I3.f, e.getLocalizedMessage());
                        boolean z4 = W8.f3228a;
                        W8.a(httpURLConnectionA);
                        z = true;
                        response = va;
                        z2 = z;
                    } catch (Error e2) {
                        e = e2;
                        va = new Va();
                        va.f3220a = new P8(I3.e, e.getLocalizedMessage());
                        boolean z5 = W8.f3228a;
                        W8.a(httpURLConnectionA);
                        z = false;
                        response = va;
                        z2 = z;
                    } catch (SocketTimeoutException e3) {
                        e = e3;
                        va = new Va();
                        va.f3220a = new P8(I3.z, e.getLocalizedMessage());
                        boolean z6 = W8.f3228a;
                        W8.a(httpURLConnectionA);
                        z = false;
                        response = va;
                        z2 = z;
                    } catch (Exception e4) {
                        e = e4;
                        va = new Va();
                        va.f3220a = new P8(I3.e, e.getLocalizedMessage());
                        boolean z7 = W8.f3228a;
                        W8.a(httpURLConnectionA);
                        z = false;
                        response = va;
                        z2 = z;
                    } catch (OutOfMemoryError e5) {
                        e = e5;
                        va = new Va();
                        va.f3220a = new P8(I3.g, e.getLocalizedMessage());
                        boolean z8 = W8.f3228a;
                        W8.a(httpURLConnectionA);
                        z = false;
                        response = va;
                        z2 = z;
                    }
                } catch (SocketTimeoutException e6) {
                    e = e6;
                    httpURLConnectionA = null;
                } catch (IOException e7) {
                    e = e7;
                    httpURLConnectionA = null;
                } catch (Exception e8) {
                    e = e8;
                    httpURLConnectionA = null;
                } catch (OutOfMemoryError e9) {
                    e = e9;
                    httpURLConnectionA = null;
                } catch (Error e10) {
                    e = e10;
                    httpURLConnectionA = null;
                } catch (Throwable th) {
                    th = th;
                    boolean z9 = W8.f3228a;
                    W8.a((HttpURLConnection) r5);
                    throw th;
                }
                if (z2) {
                    try {
                        boolean z10 = W8.f3228a;
                        if (W8.f3228a && (i3A = W8.a(true)) != null) {
                            response.f3220a = new P8(i3A, "Network request failed because of internet. Please try again");
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            Intrinsics.checkNotNullParameter(request, "<this>");
            Intrinsics.checkNotNullParameter("RESPONSE RECEIVED", "msg");
            Intrinsics.checkNotNullParameter(response, "response");
            request.toString();
            response.toString();
            Integer num = response.d;
            if (num != null && num.intValue() == 200) {
                return response;
            }
            Integer num2 = response.d;
            if ((num2 != null && num2.intValue() == 401) || (num2 != null && num2.intValue() == 403)) {
                i = request.m;
                oa = request.h;
                if (oa == null || i >= oa.f3159a) {
                    return response;
                }
                if (function2 != null) {
                    function2.invoke(request, Long.valueOf((long) (Math.pow(1.0d, i) * ((double) oa.b))));
                }
                request.m++;
                response.f3220a = new P8(I3.m, "Retry Attempted");
            } else {
                IntRange intRange = new IntRange(500, CommonGatewayClient.CODE_599);
                if (num2 != null && intRange.contains(num2.intValue())) {
                    i = request.m;
                    oa = request.h;
                    if (oa == null) {
                        if (function2 != null) {
                            function2.invoke(request, Long.valueOf((long) (Math.pow(1.0d, i) * ((double) oa.b))));
                        }
                        request.m++;
                        response.f3220a = new P8(I3.m, "Retry Attempted");
                    }
                    return response;
                }
                P8 p8 = response.f3220a;
                if ((p8 != null ? p8.f3168a : null) == I3.z) {
                    i = request.m;
                    oa = request.h;
                    if (oa == null) {
                        if (function2 != null) {
                            function2.invoke(request, Long.valueOf((long) (Math.pow(1.0d, i) * ((double) oa.b))));
                        }
                        request.m++;
                        response.f3220a = new P8(I3.m, "Retry Attempted");
                    }
                    return response;
                }
                List listListOf = CollectionsKt.listOf((Object[]) new I3[]{I3.f, I3.x, I3.y, I3.v});
                P8 p9 = response.f3220a;
                if (CollectionsKt.contains(listListOf, p9 != null ? p9.f3168a : null)) {
                    i = request.m;
                    oa = request.h;
                    if (oa == null) {
                        if (function2 != null) {
                            function2.invoke(request, Long.valueOf((long) (Math.pow(1.0d, i) * ((double) oa.b))));
                        }
                        request.m++;
                        response.f3220a = new P8(I3.m, "Retry Attempted");
                    }
                    return response;
                }
            }
            return response;
        } catch (Throwable th2) {
            th = th2;
            r5 = i3A2;
        }
    }

    public static HttpURLConnection a(Pa pa, String str) throws IOException {
        URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setConnectTimeout(pa.i);
        httpURLConnection.setReadTimeout(pa.j);
        httpURLConnection.setUseCaches(false);
        HashMap map = pa.c;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        httpURLConnection.setRequestMethod(pa.b.name());
        if (Ma.GET != pa.b) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
        }
        return httpURLConnection;
    }

    public static void a(String str, HttpURLConnection httpURLConnection, boolean z) {
        OutputStream bufferedOutputStream;
        OutputStream outputStream = null;
        try {
            if (z) {
                bufferedOutputStream = new GZIPOutputStream(InMobiNetworkBridge.urlConnectionGetOutputStream(httpURLConnection), 4096);
            } else {
                bufferedOutputStream = new BufferedOutputStream(InMobiNetworkBridge.urlConnectionGetOutputStream(httpURLConnection));
            }
            outputStream = bufferedOutputStream;
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
            outputStream.flush();
            W8.a(outputStream);
        } catch (Throwable th) {
            W8.a(outputStream);
            throw th;
        }
    }

    public static Va a(Pa pa, HttpURLConnection httpURLConnection) throws IOException {
        I3 i3;
        String string;
        Va va = new Va();
        int iHttpUrlConnectionGetResponseCode = InMobiNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
        va.d = Integer.valueOf(iHttpUrlConnectionGetResponseCode);
        va.b = httpURLConnection.getHeaderFields();
        va.e = httpURLConnection.getContentLength();
        if (pa.k) {
            return va;
        }
        if (iHttpUrlConnectionGetResponseCode == 200) {
            InputStream inputStreamUrlConnectionGetInputStream = InMobiNetworkBridge.urlConnectionGetInputStream(httpURLConnection);
            Intrinsics.checkNotNullExpressionValue(inputStreamUrlConnectionGetInputStream, "getInputStream(...)");
            a(va, inputStreamUrlConnectionGetInputStream);
        } else {
            I3.b.getClass();
            if (400 <= iHttpUrlConnectionGetResponseCode && 500 > iHttpUrlConnectionGetResponseCode) {
                i3 = I3.i;
            } else if (200 < iHttpUrlConnectionGetResponseCode && 300 > iHttpUrlConnectionGetResponseCode) {
                i3 = I3.k;
            } else {
                i3 = (I3) I3.c.get(iHttpUrlConnectionGetResponseCode);
                if (i3 == null) {
                    i3 = I3.e;
                }
            }
            if (i3 == I3.i) {
                InputStream errorStream = httpURLConnection.getErrorStream();
                Intrinsics.checkNotNullExpressionValue(errorStream, "getErrorStream(...)");
                a(va, errorStream);
                try {
                    JSONObject jSONObject = new JSONObject(Q8.a(va.c));
                    string = jSONObject.has("errorMessage") ? jSONObject.getString("errorMessage") : null;
                } catch (JSONException unused) {
                }
                va.f3220a = new P8(i3, string);
            } else {
                va.f3220a = new P8(i3, "HTTP:" + iHttpUrlConnectionGetResponseCode);
            }
        }
        return va;
    }

    public static void a(Va va, InputStream inputStream) {
        boolean z = W8.f3228a;
        byte[] bArrA = W8.a(inputStream);
        W8.a((Closeable) inputStream);
        if (bArrA != null) {
            if (!(bArrA.length == 0)) {
                Intrinsics.checkNotNullParameter(va, "<this>");
                Map map = va.b;
                List list = map != null ? (List) map.get("Content-Encoding") : null;
                if (Intrinsics.areEqual(list != null ? (String) list.get(0) : null, "gzip") && (bArrA = W8.a(bArrA)) == null) {
                    va.f3220a = new P8(I3.h, "Failed to uncompress gzip response");
                }
                if (bArrA != null) {
                    va.c = bArrA;
                }
            }
        }
    }
}
