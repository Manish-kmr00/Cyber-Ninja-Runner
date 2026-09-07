package com.five_corp.ad;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public final class k extends FiveAd {
    public static final String b = k.class.toString();
    public static final Object c = new Object();
    public static k d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f1596a;

    public k(j jVar) {
        this.f1596a = jVar;
    }

    public static void initialize(Context context, FiveAdConfig fiveAdConfig) {
        if (fiveAdConfig.appId == null) {
            String str = b;
            if (Log.isLoggable(str, 6)) {
                Log.e(str, "FiveAdConfig.appId must be a non-null value. We will raise an error if detect invalid fiveAdConfigs as soon.");
                return;
            } else {
                System.err.println("FiveAdConfig.appId must be a non-null value. We will raise an error if detect invalid fiveAdConfigs as soon.");
                return;
            }
        }
        synchronized (c) {
            k kVar = d;
            if (kVar == null) {
                j jVar = new j(context, fiveAdConfig, new com.five_corp.ad.internal.hub.a());
                com.five_corp.ad.internal.util.g gVarA = jVar.a();
                if (!gVarA.f1560a) {
                    jVar.d.a(gVarA.b);
                }
                d = new k(jVar);
            } else if (!kVar.f1596a.h.equals(fiveAdConfig)) {
                throw new IllegalArgumentException("config should be same as previous one.");
            }
        }
        if (d.f1596a.d.a()) {
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                try {
                    if (Activity.class.isAssignableFrom(Class.forName(stackTraceElement.getClassName()))) {
                        d.f1596a.r.a(1);
                    }
                } catch (Throwable unused) {
                }
            }
            com.five_corp.ad.internal.media_config.a aVar = d.f1596a.i.b().b;
            if (!(aVar == null ? true : aVar.b.isEmpty())) {
                return;
            }
            d.f1596a.r.a(1);
        }
    }

    public static boolean isInitialized() {
        boolean z;
        synchronized (c) {
            z = d != null;
        }
        return z;
    }

    public void a(String str) {
    }

    public void b() {
        this.f1596a.B.set(true);
    }

    @Override // com.five_corp.ad.FiveAd
    public final void enableSound(boolean z) {
        com.five_corp.ad.internal.soundstate.e eVar = this.f1596a.p;
        synchronized (eVar.f1524a) {
            eVar.b = new com.five_corp.ad.internal.soundstate.d(z ? 2 : 3, eVar.b.b);
        }
    }

    @Override // com.five_corp.ad.FiveAd
    public final boolean isSoundEnabled() {
        com.five_corp.ad.internal.soundstate.d dVarA = this.f1596a.p.a();
        return com.five_corp.ad.internal.soundstate.f.a(com.five_corp.ad.internal.soundstate.g.a(dVarA.f1523a, dVarA.b));
    }

    @Override // com.five_corp.ad.FiveAd
    public final void setMediaUserAttributes(List list) {
    }

    public static k a() {
        k kVar;
        synchronized (c) {
            kVar = d;
            if (kVar == null) {
                throw new IllegalStateException("call initialize() first.");
            }
        }
        return kVar;
    }
}
