package com.five_corp.ad.internal.http.movcache;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f1402a;
    public final /* synthetic */ h b;

    public f(h hVar, m mVar) {
        this.b = hVar;
        this.f1402a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.h.remove(this.f1402a);
        this.b.c();
    }
}
