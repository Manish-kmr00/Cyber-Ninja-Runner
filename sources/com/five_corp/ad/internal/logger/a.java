package com.five_corp.ad.internal.logger;

import android.util.Log;
import com.five_corp.ad.internal.B;
import com.five_corp.ad.internal.bgtask.j;
import java.util.Iterator;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.hub.a f1421a;

    public a(com.five_corp.ad.internal.hub.a aVar) {
        this.f1421a = aVar;
    }

    public final void a(String str, int i) {
        com.five_corp.ad.internal.hub.a aVar = this.f1421a;
        b bVar = new b(str, i);
        Iterator it = aVar.b.a().iterator();
        while (it.hasNext()) {
            B b = (B) ((com.five_corp.ad.internal.hub.b) it.next());
            b.c.a(new j(bVar, b.f1262a, b.b));
        }
    }

    public final void a(Throwable th) {
        a(th + " - " + Log.getStackTraceString(th), 6);
    }
}
