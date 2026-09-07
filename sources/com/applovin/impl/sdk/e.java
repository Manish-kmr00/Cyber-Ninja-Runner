package com.applovin.impl.sdk;

import com.amazon.aps.shared.util.APSSharedUtil;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.u;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f644a;
    private final o b;
    private final Map d = new HashMap();
    private final Map e = new HashMap();
    private final Object c = new Object();

    e(k kVar) {
        this.f644a = kVar;
        this.b = kVar.O();
        for (u uVar : u.a()) {
            this.d.put(uVar, new q());
            this.e.put(uVar, new q());
        }
    }

    private q c(u uVar) {
        synchronized (this.c) {
            q qVarB = b(uVar);
            if (qVarB.b() > 0) {
                return qVarB;
            }
            return d(uVar);
        }
    }

    private q d(u uVar) {
        q qVar;
        synchronized (this.c) {
            qVar = (q) this.d.get(uVar);
            if (qVar == null) {
                qVar = new q();
                this.d.put(uVar, qVar);
            }
        }
        return qVar;
    }

    void a(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.c) {
            d(appLovinAdImpl.getAdZone()).a(appLovinAdImpl);
            if (o.a()) {
                this.b.a("AdPreloadManager", "Ad enqueued: " + appLovinAdImpl);
            }
        }
    }

    public void b(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.c) {
            c(appLovinAdImpl.getAdZone()).b(appLovinAdImpl);
        }
    }

    public AppLovinAdImpl e(u uVar) {
        com.applovin.impl.sdk.ad.c cVar;
        synchronized (this.c) {
            q qVarD = d(uVar);
            if (qVarD.b() > 0) {
                b(uVar).a(qVarD.a());
                cVar = new com.applovin.impl.sdk.ad.c(uVar, this.f644a);
            } else {
                cVar = null;
            }
        }
        if (cVar != null) {
            if (o.a()) {
                this.b.a("AdPreloadManager", "Retrieved ad of zone " + uVar + APSSharedUtil.TRUNCATE_SEPARATOR);
            }
        } else if (o.a()) {
            this.b.a("AdPreloadManager", "Unable to retrieve ad of zone " + uVar + APSSharedUtil.TRUNCATE_SEPARATOR);
        }
        return cVar;
    }

    public AppLovinAdBase f(u uVar) {
        AppLovinAdImpl appLovinAdImplD;
        synchronized (this.c) {
            appLovinAdImplD = c(uVar).d();
        }
        return appLovinAdImplD;
    }

    private q b(u uVar) {
        q qVar;
        synchronized (this.c) {
            qVar = (q) this.e.get(uVar);
            if (qVar == null) {
                qVar = new q();
                this.e.put(uVar, qVar);
            }
        }
        return qVar;
    }

    public AppLovinAdImpl a(u uVar) {
        AppLovinAdImpl appLovinAdImplA;
        synchronized (this.c) {
            appLovinAdImplA = c(uVar).a();
        }
        return appLovinAdImplA;
    }
}
