package com.fyber.inneractive.sdk.cache.session;

import com.fyber.inneractive.sdk.util.AbstractC3251o;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.fyber.inneractive.sdk.cache.session.enums.a f1646a;
    public final /* synthetic */ com.fyber.inneractive.sdk.cache.session.enums.c b;
    public final /* synthetic */ e c;

    public d(e eVar, com.fyber.inneractive.sdk.cache.session.enums.a aVar, com.fyber.inneractive.sdk.cache.session.enums.c cVar) {
        this.c = eVar;
        this.f1646a = aVar;
        this.b = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.c.c) {
            com.fyber.inneractive.sdk.cache.session.enums.a aVar = this.f1646a;
            if (aVar != com.fyber.inneractive.sdk.cache.session.enums.a.NEW_SESSION) {
                g gVar = (g) this.c.f1647a.f1651a.get(this.b);
                if (gVar != null) {
                    int i = f.f1649a[aVar.ordinal()];
                    if (i == 1) {
                        gVar.b++;
                    } else if (i == 2) {
                        gVar.c++;
                    } else if (i == 3) {
                        gVar.f1650a++;
                    }
                }
            } else {
                this.c.f1647a = new i();
            }
            try {
                AbstractC3251o.a(AbstractC3251o.f2370a, e.a(this.c).toString().getBytes("UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
            this.c.getClass();
        }
    }
}
