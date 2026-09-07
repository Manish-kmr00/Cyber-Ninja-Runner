package com.five_corp.ad.internal.http.connection;

import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;
import com.five_corp.ad.internal.util.f;
import com.five_corp.ad.internal.util.g;
import com.safedk.android.internal.partials.LINENetworkBridge;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HttpURLConnection f1395a;
    public InputStream b = null;

    public a(HttpURLConnection httpURLConnection) {
        this.f1395a = httpURLConnection;
    }

    public final g a() {
        try {
            this.f1395a.connect();
            return new g(true, null);
        } catch (SocketTimeoutException e) {
            return new g(false, new o(p.Y1, null, e, null));
        } catch (IOException e2) {
            return new g(false, new o(p.X1, null, e2, null));
        } catch (Exception e3) {
            return new g(false, new o(p.f2, null, e3, null));
        }
    }

    public final f b() {
        try {
            return new f(true, null, Integer.valueOf(LINENetworkBridge.httpUrlConnectionGetResponseCode(this.f1395a)));
        } catch (IOException e) {
            return new f(false, new o(p.Z1, null, e, null), null);
        }
    }

    public final f a(byte[] bArr) {
        if (this.b == null) {
            try {
                this.b = a(this.f1395a);
            } catch (SocketTimeoutException e) {
                return new f(false, new o(p.c2, null, e, null), null);
            } catch (IOException e2) {
                return new f(false, new o(p.a2, null, e2, null), null);
            } catch (Exception e3) {
                return new f(false, new o(p.b2, null, e3, null), null);
            }
        }
        try {
            return new f(true, null, Integer.valueOf(this.b.read(bArr)));
        } catch (IOException e4) {
            return new f(false, new o(p.d2, null, e4, null), null);
        } catch (Exception e5) {
            return new f(false, new o(p.e2, null, e5, null), null);
        }
    }

    public static InputStream a(HttpURLConnection httpURLConnection) {
        String contentEncoding = httpURLConnection.getContentEncoding();
        return (contentEncoding == null || !contentEncoding.contains("gzip")) ? LINENetworkBridge.urlConnectionGetInputStream(httpURLConnection) : new GZIPInputStream(LINENetworkBridge.urlConnectionGetInputStream(httpURLConnection));
    }
}
