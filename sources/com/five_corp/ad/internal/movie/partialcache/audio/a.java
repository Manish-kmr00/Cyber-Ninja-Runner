package com.five_corp.ad.internal.movie.partialcache.audio;

import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f1465a;
    public final /* synthetic */ c b;

    public a(c cVar, b bVar) {
        this.b = cVar;
        this.f1465a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f1465a.a(this.b.b);
        } catch (Throwable th) {
            this.b.c.a(new o(p.z0, null, th, null));
        }
    }
}
