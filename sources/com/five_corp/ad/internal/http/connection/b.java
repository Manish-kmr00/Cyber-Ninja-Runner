package com.five_corp.ad.internal.http.connection;

import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;
import com.five_corp.ad.internal.util.f;
import com.google.common.net.HttpHeaders;
import com.safedk.android.internal.partials.LINENetworkBridge;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends c {
    /* JADX WARN: Code duplicated, block: B:34:0x006c A[Catch: NullPointerException -> 0x007b, SecurityException -> 0x008b, IllegalArgumentException -> 0x009b, IllegalStateException -> 0x00ab, IOException -> 0x00bb, ProtocolException -> 0x00cb, MalformedURLException -> 0x00db, TryCatch #5 {IllegalArgumentException -> 0x009b, IllegalStateException -> 0x00ab, SecurityException -> 0x008b, MalformedURLException -> 0x00db, ProtocolException -> 0x00cb, IOException -> 0x00bb, NullPointerException -> 0x007b, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x0015, B:9:0x0023, B:11:0x002a, B:13:0x0031, B:16:0x0039, B:19:0x0049, B:34:0x006c, B:35:0x006f, B:31:0x0066), top: B:64:0x0002 }] */
    public final f a(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) throws Throwable {
        OutputStream outputStreamUrlConnectionGetOutputStream;
        try {
            HttpURLConnection httpURLConnectionA = a(str);
            if (httpURLConnectionA == null) {
                return new f(false, new o(p.m2, null, null, null), null);
            }
            httpURLConnectionA.setUseCaches(false);
            httpURLConnectionA.setConnectTimeout(i);
            httpURLConnectionA.setReadTimeout(i2);
            httpURLConnectionA.setRequestMethod(str2);
            if (str4 != null) {
                httpURLConnectionA.setRequestProperty("Range", str4);
            }
            if (str5 != null) {
                httpURLConnectionA.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, str5);
            }
            if (str6 != null) {
                httpURLConnectionA.setRequestProperty("Content-Type", str6);
            }
            if (str3 != null) {
                httpURLConnectionA.setDoOutput(true);
                try {
                    outputStreamUrlConnectionGetOutputStream = LINENetworkBridge.urlConnectionGetOutputStream(httpURLConnectionA);
                    try {
                        try {
                            outputStreamUrlConnectionGetOutputStream.write(str3.getBytes(StandardCharsets.UTF_8));
                            outputStreamUrlConnectionGetOutputStream.close();
                        } catch (Throwable th) {
                            th = th;
                            if (outputStreamUrlConnectionGetOutputStream != null) {
                                outputStreamUrlConnectionGetOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (IOException e) {
                        e = e;
                        f fVar = new f(false, new o(p.i2, "URL connection output stream io exception", e, null), null);
                        if (outputStreamUrlConnectionGetOutputStream != null) {
                            outputStreamUrlConnectionGetOutputStream.close();
                        }
                        return fVar;
                    }
                } catch (IOException e2) {
                    e = e2;
                    outputStreamUrlConnectionGetOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    outputStreamUrlConnectionGetOutputStream = null;
                    if (outputStreamUrlConnectionGetOutputStream != null) {
                        outputStreamUrlConnectionGetOutputStream.close();
                    }
                    throw th;
                }
            }
            return new f(true, null, new a(httpURLConnectionA));
        } catch (IllegalArgumentException e3) {
            return new f(false, new o(p.h2, "illegal timeout parameter", e3, null), null);
        } catch (IllegalStateException e4) {
            return new f(false, new o(p.g2, "illegal state exception on create url connection", e4, null), null);
        } catch (SecurityException e5) {
            return new f(false, new o(p.k2, "security exception on create url connection", e5, null), null);
        } catch (MalformedURLException e6) {
            return new f(false, new o(p.V1, "malformed URL: " + str, e6, null), null);
        } catch (ProtocolException e7) {
            return new f(false, new o(p.j2, "protocol exception on create url connection", e7, null), null);
        } catch (IOException e8) {
            return new f(false, new o(p.W1, "fail to open url connection", e8, null), null);
        } catch (NullPointerException e9) {
            return new f(false, new o(p.l2, "null pointer exception on create url connection", e9, null), null);
        }
    }

    public static HttpURLConnection a(String str) {
        return (HttpURLConnection) new URL(str).openConnection();
    }
}
