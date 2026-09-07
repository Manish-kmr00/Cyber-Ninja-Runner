package com.five_corp.ad.internal.movie;

import android.os.SystemClock;
import com.five_corp.ad.internal.movie.partialcache.u1;

/* JADX INFO: loaded from: classes5.dex */
public final class r implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f1508a;

    public r(x xVar) {
        this.f1508a = xVar;
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.u1
    public final void a(Object obj) {
        x xVar = this.f1508a;
        int i = xVar.o;
        if (i != 12) {
            if (i == 5) {
                xVar.o = 6;
                xVar.f.b();
                x xVar2 = this.f1508a;
                xVar2.f1513a.post(new RunnableC2983e(xVar2));
                return;
            }
            return;
        }
        xVar.o = 11;
        com.five_corp.ad.internal.ad.m mVar = xVar.d;
        if (mVar != null && mVar.f1306a != null && xVar.q == null) {
            xVar.q = new Object();
            xVar.p = xVar.d.f1306a.longValue() + SystemClock.uptimeMillis();
            if (xVar.q != null) {
                if (SystemClock.uptimeMillis() > xVar.p) {
                    xVar.a(new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.B0, null, null, null));
                } else {
                    xVar.n.postAtTime(new v(xVar), xVar.q, SystemClock.uptimeMillis() + 500);
                }
            }
        }
        x xVar3 = this.f1508a;
        xVar3.f1513a.post(new RunnableC2983e(xVar3));
    }
}
