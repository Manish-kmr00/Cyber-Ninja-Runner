package com.five_corp.ad.internal.cache;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes13.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f1340a;
    public final Handler b = new Handler(Looper.getMainLooper());

    public f(q qVar) {
        this.f1340a = qVar;
    }

    public final b a(Context context, com.five_corp.ad.internal.ad.s sVar) {
        b bVar = new b(context, this, sVar);
        bVar.f1337a.a(bVar.b, new a(bVar));
        return bVar;
    }

    public final void a(com.five_corp.ad.internal.ad.s sVar, e eVar) {
        com.five_corp.ad.internal.util.f fVar;
        o oVar = (o) this.f1340a.f1349a.get(sVar);
        if (oVar == null) {
            this.b.post(new c(eVar));
            return;
        }
        String str = sVar.f1310a;
        Handler handler = this.b;
        synchronized (oVar.f1347a) {
            if (oVar.f) {
                fVar = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.W5, null, null, null), null);
            } else {
                if (oVar.h == null) {
                    oVar.h = new i(oVar, str, handler);
                }
                fVar = new com.five_corp.ad.internal.util.f(true, null, oVar.h);
            }
        }
        if (fVar.f1560a) {
            ((i) fVar.c).a(eVar);
        } else {
            this.b.post(new d(eVar, fVar));
        }
    }
}
