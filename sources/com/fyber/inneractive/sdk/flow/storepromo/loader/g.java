package com.fyber.inneractive.sdk.flow.storepromo.loader;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.model.vast.v;
import com.fyber.inneractive.sdk.network.L;
import com.fyber.inneractive.sdk.network.U;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f1817a;
    public CountDownLatch b;
    public final com.fyber.inneractive.sdk.flow.storepromo.b c;
    public final com.fyber.inneractive.sdk.flow.storepromo.model.c d;
    public final int f;
    public final ArrayList e = new ArrayList();
    public int g = 0;
    public boolean h = false;
    public boolean i = false;

    public g(v vVar, com.fyber.inneractive.sdk.flow.storepromo.b bVar) {
        this.f1817a = vVar;
        this.f = vVar.f.size();
        this.c = bVar;
        this.d = new com.fyber.inneractive.sdk.flow.storepromo.model.c(vVar);
    }

    public final void a(com.fyber.inneractive.sdk.flow.storepromo.events.a aVar, boolean z, String str, String str2) {
        f fVar;
        this.b.countDown();
        if (this.i) {
            return;
        }
        if (z) {
            this.i = true;
            this.h = true;
            a();
            if (TextUtils.isEmpty(str)) {
                str = "Something went wrong during promo's resources download";
            }
            com.fyber.inneractive.sdk.flow.storepromo.b bVar = this.c;
            if (bVar != null) {
                if (aVar == null) {
                    aVar = com.fyber.inneractive.sdk.flow.storepromo.events.a.DOWNLOAD_RESOURCE_ERROR;
                }
                bVar.a(aVar.name(), str, str2);
                return;
            }
            return;
        }
        if (this.b.getCount() != 0 || this.h) {
            return;
        }
        this.i = true;
        Collections.sort(this.d.f1826a);
        this.e.clear();
        com.fyber.inneractive.sdk.flow.storepromo.b bVar2 = this.c;
        if (bVar2 != null) {
            com.fyber.inneractive.sdk.flow.storepromo.model.c cVar = this.d;
            IAlog.a("StorePromoManager : onPromoLoadSucceed", new Object[0]);
            com.fyber.inneractive.sdk.flow.storepromo.controller.b bVar3 = new com.fyber.inneractive.sdk.flow.storepromo.controller.b(cVar, bVar2, bVar2, bVar2, bVar2.b, bVar2.c);
            bVar2.d = bVar3;
            bVar2.g = cVar.i;
            com.fyber.inneractive.sdk.flow.storepromo.controller.c cVar2 = bVar3.c;
            if (cVar2 == null || (fVar = cVar2.d) == null) {
                return;
            }
            r.f2374a.execute(new e(fVar, new d(fVar)));
        }
    }

    public final void a() {
        for (U u : this.e) {
            L l = IAConfigManager.O.s;
            String str = u.g;
            l.getClass();
            u.f1914a = true;
        }
        this.e.clear();
    }
}
