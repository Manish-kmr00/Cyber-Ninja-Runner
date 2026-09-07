package com.five_corp.ad.internal.http.client;

import android.os.Handler;
import android.os.HandlerThread;
import com.five_corp.ad.internal.ad.s;
import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;
import com.five_corp.ad.internal.util.f;
import com.google.common.net.HttpHeaders;
import java.io.InputStream;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f1393a;
    public final Object b;
    public HandlerThread c;
    public final Handler d;
    public final com.five_corp.ad.internal.http.connection.b e;
    public com.five_corp.ad.internal.http.connection.a f;

    public a(s sVar, b bVar, com.five_corp.ad.internal.http.connection.b bVar2) {
        this.f1393a = sVar;
        this.b = bVar;
        this.e = bVar2;
        HandlerThread handlerThread = new HandlerThread("HttpDownloadClient for " + sVar.f1310a);
        this.c = handlerThread;
        handlerThread.start();
        this.d = new Handler(this.c.getLooper());
    }

    public final void a() {
        this.d.postAtFrontOfQueue(new Runnable() { // from class: com.five_corp.ad.internal.http.client.a$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b();
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.five_corp.ad.internal.http.client.b, java.lang.Object] */
    public final void b() {
        this.b.a();
        e();
    }

    public final void c() {
        this.d.post(new Runnable() { // from class: com.five_corp.ad.internal.http.client.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d();
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.five_corp.ad.internal.http.client.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.five_corp.ad.internal.http.client.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.five_corp.ad.internal.http.client.b, java.lang.Object] */
    public final void d() {
        byte[] bArr = new byte[8192];
        f fVarA = this.f.a(bArr);
        if (!fVarA.f1560a) {
            this.b.c(fVarA.b);
            e();
            return;
        }
        int iIntValue = ((Integer) fVarA.c).intValue();
        if (iIntValue < 0) {
            this.b.c();
            e();
        } else {
            this.b.a(iIntValue, bArr);
            c();
        }
    }

    public final void e() {
        com.five_corp.ad.internal.http.connection.a aVar = this.f;
        if (aVar != null) {
            InputStream inputStream = aVar.b;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
                aVar.b = null;
            }
            InputStream errorStream = aVar.f1395a.getErrorStream();
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception unused2) {
                }
            }
            aVar.f1395a = null;
            this.f = null;
        }
        HandlerThread handlerThread = this.c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.c = null;
        }
    }

    public final void f() {
        this.d.post(new Runnable() { // from class: com.five_corp.ad.internal.http.client.a$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.g();
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.five_corp.ad.internal.http.client.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.five_corp.ad.internal.http.client.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.five_corp.ad.internal.http.client.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v14, types: [com.five_corp.ad.internal.http.client.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v19, types: [com.five_corp.ad.internal.http.client.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v21, types: [com.five_corp.ad.internal.http.client.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.five_corp.ad.internal.http.client.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.five_corp.ad.internal.http.client.b, java.lang.Object] */
    public final void g() {
        o oVar;
        o oVar2;
        f fVarB = this.f.b();
        if (!fVarB.f1560a) {
            this.b.c(fVarB.b);
            e();
            return;
        }
        int iIntValue = ((Integer) fVarB.c).intValue();
        if (iIntValue == 206) {
            String headerField = this.f.f1395a.getHeaderField(HttpHeaders.CONTENT_RANGE);
            Pattern pattern = c.f1394a;
            int iA = c.a(headerField, pattern, 1);
            if (iA < 0) {
                oVar2 = new o(p.o2, null, null, null);
            } else {
                int iA2 = c.a(headerField, pattern, 2);
                if (iA2 < 0) {
                    oVar2 = new o(p.p2, null, null, null);
                } else {
                    int iA3 = c.a(headerField, c.b, 1);
                    if (iA3 >= 0) {
                        this.b.a(iA, iA2, iA3);
                        c();
                        return;
                    }
                    oVar2 = new o(p.q2, null, null, null);
                }
            }
            this.b.c(oVar2);
            e();
            return;
        }
        if (iIntValue == 416) {
            int iA4 = c.a(this.f.f1395a.getHeaderField(HttpHeaders.CONTENT_RANGE), c.b, 1);
            if (iA4 < 0) {
                this.b.c(new o(p.n2, null, null, null));
                e();
                return;
            } else {
                this.b.a(iA4);
                this.b.c();
                e();
                return;
            }
        }
        int i = iIntValue / 100;
        if (i == 2) {
            this.b.d();
            c();
            return;
        }
        if (i == 3) {
            oVar = new o(p.r2, null, null, null);
        } else if (i == 4) {
            oVar = new o(p.s2, null, null, null);
        } else {
            oVar = i == 5 ? new o(p.t2, null, null, null) : new o(p.u2, null, null, null);
        }
        this.b.c(oVar);
        e();
    }

    /* JADX WARN: Type inference failed for: r11v3, types: [com.five_corp.ad.internal.http.client.b, java.lang.Object] */
    public final void a(int i, int i2) throws Throwable {
        String str;
        Pattern pattern = c.f1394a;
        if (i <= 0 || i2 != 0) {
            str = i2 > 0 ? String.format("bytes=%d-%d", Integer.valueOf(i), Integer.valueOf((i + i2) - 1)) : null;
        } else {
            str = String.format("bytes=%d-", Integer.valueOf(i));
        }
        f fVarA = this.e.a(this.f1393a.f1310a, "GET", null, str, null, null, 60000, 60000);
        if (fVarA.f1560a) {
            com.five_corp.ad.internal.http.connection.a aVar = (com.five_corp.ad.internal.http.connection.a) fVarA.c;
            this.f = aVar;
            fVarA = aVar.a();
            if (fVarA.f1560a) {
                f();
                return;
            }
        }
        this.b.c(fVarA.b);
        e();
    }

    public final void b(final int i, final int i2) {
        this.d.post(new Runnable() { // from class: com.five_corp.ad.internal.http.client.a$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.a(i, i2);
            }
        });
    }
}
