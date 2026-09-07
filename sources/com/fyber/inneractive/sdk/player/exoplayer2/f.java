package com.fyber.inneractive.sdk.player.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.fyber.inneractive.sdk.player.controller.B;
import com.fyber.inneractive.sdk.player.controller.C3155f;
import com.fyber.inneractive.sdk.player.exoplayer2.source.z;
import com.fyber.inneractive.sdk.util.AbstractC3255t;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public final class f extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f2100a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, Looper looper) {
        super(looper);
        this.f2100a = gVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        g gVar = this.f2100a;
        gVar.getClass();
        switch (message.what) {
            case 0:
                gVar.l--;
                return;
            case 1:
                gVar.j = message.arg1;
                Iterator it = gVar.e.iterator();
                while (it.hasNext()) {
                    ((B) it.next()).a(gVar.j, gVar.i);
                }
                return;
            case 2:
                Iterator it2 = gVar.e.iterator();
                while (it2.hasNext()) {
                    ((B) it2.next()).getClass();
                }
                return;
            case 3:
                if (gVar.l == 0) {
                    com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j jVar = (com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j) message.obj;
                    gVar.h = true;
                    z zVar = jVar.f2144a;
                    gVar.o = jVar.b;
                    com.fyber.inneractive.sdk.player.exoplayer2.trackselection.i iVar = gVar.f2101a;
                    Object obj = jVar.c;
                    ((com.fyber.inneractive.sdk.player.exoplayer2.trackselection.g) iVar).getClass();
                    Iterator it3 = gVar.e.iterator();
                    while (it3.hasNext()) {
                        ((B) it3.next()).getClass();
                    }
                    return;
                }
                return;
            case 4:
                int i = gVar.k - 1;
                gVar.k = i;
                if (i == 0) {
                    gVar.q = (i) message.obj;
                    if (message.arg1 != 0) {
                        Iterator it4 = gVar.e.iterator();
                        while (it4.hasNext()) {
                            ((B) it4.next()).getClass();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (gVar.k == 0) {
                    gVar.q = (i) message.obj;
                    Iterator it5 = gVar.e.iterator();
                    while (it5.hasNext()) {
                        ((B) it5.next()).getClass();
                    }
                    return;
                }
                return;
            case 6:
                k kVar = (k) message.obj;
                gVar.k -= kVar.d;
                if (gVar.l == 0) {
                    gVar.m = kVar.f2105a;
                    gVar.n = kVar.b;
                    gVar.q = kVar.c;
                    Iterator it6 = gVar.e.iterator();
                    while (it6.hasNext()) {
                        ((B) it6.next()).getClass();
                    }
                    return;
                }
                return;
            case 7:
                s sVar = (s) message.obj;
                if (gVar.p.equals(sVar)) {
                    return;
                }
                gVar.p = sVar;
                Iterator it7 = gVar.e.iterator();
                while (it7.hasNext()) {
                    ((B) it7.next()).getClass();
                }
                return;
            case 8:
                d dVar = (d) message.obj;
                for (B b : gVar.e) {
                    C3155f c3155f = (C3155f) b.f1949a.get();
                    if (c3155f != null && (dVar.getCause() instanceof com.fyber.inneractive.sdk.player.exoplayer2.audio.n) && (b.b || (c3155f.D && c3155f.A))) {
                        c3155f.v = true;
                        g gVar2 = c3155f.s;
                        if (gVar2 != null) {
                            gVar2.d.d();
                            gVar2.c.removeCallbacksAndMessages(null);
                            c3155f.s = null;
                        }
                        c3155f.a(false);
                        c3155f.a(c3155f.C);
                        c3155f.i.post(new com.fyber.inneractive.sdk.player.controller.k(c3155f, false));
                    } else if (c3155f == null || !c3155f.A || b.b || !com.fyber.inneractive.sdk.player.cache.m.f.c || !AbstractC3255t.a() || c3155f.E >= c3155f.p) {
                        com.fyber.inneractive.sdk.player.mediaplayer.o oVar = new com.fyber.inneractive.sdk.player.mediaplayer.o(dVar, dVar.getCause() == null ? "empty" : dVar.getCause().getMessage());
                        IAlog.a("%sonPlayerError called with %s for sendErrorState", b.a(), oVar);
                        C3155f c3155f2 = (C3155f) AbstractC3256u.a(b.f1949a);
                        if (c3155f2 != null) {
                            c3155f2.a(com.fyber.inneractive.sdk.player.enums.b.Error);
                            IAlog.a("%sonPlayerError called with: %s for onPlayerError", IAlog.a(c3155f2), oVar);
                            c3155f2.i.post(new com.fyber.inneractive.sdk.player.controller.j(c3155f2, oVar));
                            c3155f2.k();
                        }
                    } else {
                        g gVar3 = c3155f.s;
                        if (gVar3 != null) {
                            gVar3.d.d();
                            gVar3.c.removeCallbacksAndMessages(null);
                            c3155f.s = null;
                        }
                        c3155f.a(true);
                        c3155f.a(c3155f.C);
                        c3155f.E++;
                        c3155f.i.post(new com.fyber.inneractive.sdk.player.controller.k(c3155f, true));
                    }
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
