package com.five_corp.ad.internal.system;

import android.content.Context;
import android.net.ConnectivityManager;
import java.util.Iterator;

/* JADX INFO: loaded from: classes12.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1546a;
    public final ConnectivityManager b;
    public final com.five_corp.ad.internal.logger.a c;
    public final com.five_corp.ad.internal.hub.a d;

    public h(Context context, com.five_corp.ad.internal.logger.a aVar, com.five_corp.ad.internal.hub.a aVar2) {
        this.f1546a = context;
        this.b = (ConnectivityManager) context.getSystemService("connectivity");
        this.c = aVar;
        this.d = aVar2;
    }

    public final void a() {
        Iterator it = this.d.c.a().iterator();
        while (it.hasNext()) {
            com.five_corp.ad.j jVar = (com.five_corp.ad.j) ((com.five_corp.ad.internal.hub.d) it.next());
            jVar.n.a();
            jVar.o.a();
            com.five_corp.ad.internal.http.auxcache.i iVar = jVar.x;
            iVar.f1388a.post(new com.five_corp.ad.internal.http.auxcache.d(iVar));
            com.five_corp.ad.internal.http.movcache.h hVar = jVar.y;
            hVar.f1404a.post(new com.five_corp.ad.internal.http.movcache.d(hVar));
        }
    }

    public final void b() {
        this.b.registerDefaultNetworkCallback(new f(this));
    }
}
