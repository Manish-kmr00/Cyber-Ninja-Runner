package com.five_corp.ad.internal.movie.partialcache.video;

import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f1500a;
    public final /* synthetic */ c b;

    public a(c cVar, b bVar) {
        this.b = cVar;
        this.f1500a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f1500a.a(this.b.b);
        } catch (Throwable th) {
            this.b.c.a(new o(p.y0, null, th, null));
        }
    }
}
