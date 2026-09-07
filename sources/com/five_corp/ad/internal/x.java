package com.five_corp.ad.internal;

import android.os.Handler;
import android.os.Looper;
import com.five_corp.ad.FiveAdErrorCode;
import com.five_corp.ad.FiveAdLoadListener;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f1592a = new Handler(Looper.getMainLooper());
    public final y b;
    public final B c;
    public final com.five_corp.ad.internal.soundstate.c d;
    public final com.five_corp.ad.internal.hub.a e;

    public x(y yVar, B b, com.five_corp.ad.internal.soundstate.c cVar, com.five_corp.ad.internal.hub.a aVar) {
        this.b = yVar;
        this.c = b;
        this.d = cVar;
        this.e = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v4, types: [com.five_corp.ad.FiveAdInterface, java.lang.Object] */
    public final void a(com.five_corp.ad.internal.context.l lVar) {
        this.c.a(new com.five_corp.ad.internal.beacon.a(lVar, 5, this.d.a(), 0L, 0.0d));
        List<com.five_corp.ad.internal.ad.beacon.d> list = lVar.b.x;
        if (list != null) {
            for (com.five_corp.ad.internal.ad.beacon.d dVar : list) {
                if (dVar.f1269a == com.five_corp.ad.internal.ad.beacon.e.LOADED) {
                    B b = this.c;
                    b.d.a(new com.five_corp.ad.internal.bgtask.k(dVar.b, b.b));
                }
            }
        }
        y yVar = this.b;
        FiveAdLoadListener fiveAdLoadListener = (FiveAdLoadListener) yVar.b.get();
        if (fiveAdLoadListener != 0) {
            fiveAdLoadListener.onFiveAdLoad(yVar.f1593a);
        }
    }

    public final void b(final com.five_corp.ad.internal.context.l lVar) {
        this.f1592a.post(new Runnable() { // from class: com.five_corp.ad.internal.x$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(lVar);
            }
        });
    }

    public final void b(final com.five_corp.ad.internal.context.i iVar, final com.five_corp.ad.internal.context.h hVar, final o oVar) {
        this.f1592a.post(new Runnable() { // from class: com.five_corp.ad.internal.x$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(iVar, hVar, oVar);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v5, types: [com.five_corp.ad.FiveAdInterface, java.lang.Object] */
    public final void a(com.five_corp.ad.internal.context.i iVar, com.five_corp.ad.internal.context.h hVar, o oVar) {
        com.five_corp.ad.internal.hub.a aVar = this.e;
        com.five_corp.ad.internal.beacon.b bVar = new com.five_corp.ad.internal.beacon.b(null, iVar, hVar, oVar, this.d.a(), 0L, null, null);
        Iterator it = aVar.b.a().iterator();
        while (it.hasNext()) {
            B b = (B) ((com.five_corp.ad.internal.hub.b) it.next());
            if (!b.f.contains(Integer.valueOf(bVar.d.f1517a.f1518a))) {
                b.c.a(new com.five_corp.ad.internal.bgtask.f(bVar, b.f1262a, b.b));
            }
        }
        y yVar = this.b;
        FiveAdErrorCode fiveAdErrorCodeA = oVar.a();
        FiveAdLoadListener fiveAdLoadListener = (FiveAdLoadListener) yVar.b.get();
        if (fiveAdLoadListener != 0) {
            fiveAdLoadListener.onFiveAdLoadError(yVar.f1593a, fiveAdErrorCodeA);
        }
    }
}
