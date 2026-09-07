package com.fyber.inneractive.sdk.flow.storepromo;

import android.text.TextUtils;
import android.view.View;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.storepromo.loader.f;
import com.fyber.inneractive.sdk.flow.storepromo.loader.g;
import com.fyber.inneractive.sdk.flow.storepromo.ui.c;
import com.fyber.inneractive.sdk.model.vast.v;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements com.fyber.inneractive.sdk.flow.storepromo.loader.b, com.fyber.inneractive.sdk.flow.storepromo.controller.listener.a {
    public static final Object k = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f1808a;
    public final e b;
    public final InneractiveAdRequest c;
    public com.fyber.inneractive.sdk.flow.storepromo.controller.b d;
    public com.fyber.inneractive.sdk.flow.storepromo.loader.b e;
    public final String f;
    public int g = 0;
    public final CopyOnWriteArrayList h = new CopyOnWriteArrayList();
    public boolean i = false;
    public a j = new a();

    public b(v vVar, e eVar, InneractiveAdRequest inneractiveAdRequest) {
        this.f1808a = new g(vVar, this);
        this.f = vVar.c;
        this.b = eVar;
        this.c = inneractiveAdRequest;
    }

    public final void a() {
        com.fyber.inneractive.sdk.flow.storepromo.controller.b bVar = this.d;
        if (bVar != null) {
            c cVar = bVar.d;
            if (cVar != null) {
                cVar.a();
                if (cVar.b != null) {
                    cVar.f1831a = null;
                    cVar.b = null;
                }
                com.fyber.inneractive.sdk.flow.storepromo.ui.b bVar2 = cVar.e;
                if (bVar2 != null) {
                    try {
                        AbstractC3251o.f2370a.unregisterReceiver(bVar2);
                    } catch (Exception unused) {
                    }
                    cVar.e = null;
                }
                cVar.f = null;
                bVar.d = null;
            }
            com.fyber.inneractive.sdk.flow.storepromo.controller.c cVar2 = bVar.c;
            if (cVar2 != null) {
                f fVar = cVar2.d;
                if (fVar != null) {
                    com.fyber.inneractive.sdk.flow.storepromo.controller.webview.a aVar = fVar.f1816a;
                    if (aVar != null) {
                        aVar.destroy();
                        fVar.f1816a = null;
                    }
                    fVar.e = null;
                    fVar.d = null;
                    fVar.c = null;
                    fVar.f = null;
                    fVar.b = null;
                }
                com.fyber.inneractive.sdk.flow.storepromo.controller.webview.a aVar2 = cVar2.b;
                if (aVar2 != null) {
                    aVar2.destroy();
                    cVar2.b = null;
                }
                cVar2.f = null;
                cVar2.g = null;
                cVar2.c = null;
                cVar2.d = null;
                bVar.c = null;
            }
            bVar.e = null;
            bVar.f = null;
            bVar.h = null;
            this.d = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.loader.b
    public final void a(h0 h0Var) {
        c cVar;
        View view;
        this.i = true;
        com.fyber.inneractive.sdk.flow.storepromo.loader.b bVar = this.e;
        if (bVar != null) {
            bVar.a(h0Var);
        }
        com.fyber.inneractive.sdk.flow.storepromo.controller.b bVar2 = this.d;
        com.fyber.inneractive.sdk.flow.storepromo.observer.b bVar3 = new com.fyber.inneractive.sdk.flow.storepromo.observer.b((bVar2 == null || (cVar = bVar2.d) == null || cVar.b == null || (view = cVar.f1831a) == null || view.getParent() == null || cVar.b.getVisibility() != 0) ? false : true, this.i);
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            ((com.fyber.inneractive.sdk.flow.storepromo.observer.a) it.next()).a(bVar3);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.controller.listener.a
    public final void a(com.fyber.inneractive.sdk.network.events.b bVar, String str, String str2) {
        a(bVar.name(), str, str2);
    }

    public final void a(String str, String str2, String str3) {
        IAlog.b("StorePromoManager: reportStorePromoError: %s, msg: %s", str, str2);
        if (this.j != null) {
            InneractiveAdRequest inneractiveAdRequest = this.c;
            e eVar = this.b;
            HashMap map = new HashMap(1);
            if (!TextUtils.isEmpty(str2)) {
                map.put("error", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                map.put("failedURL", str3);
            }
            com.fyber.inneractive.sdk.network.events.a.a(EnumC3143t.ERROR_STORE_PROMO_FAILURE, str, (String) null, inneractiveAdRequest, eVar, map, (Boolean) null);
            this.j = null;
        }
    }
}
