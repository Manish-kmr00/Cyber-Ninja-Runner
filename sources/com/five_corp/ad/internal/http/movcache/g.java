package com.five_corp.ad.internal.http.movcache;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f1403a;
    public final /* synthetic */ h b;

    public g(h hVar, Object obj) {
        this.b = hVar;
        this.f1403a = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1403a.equals(this.b.i)) {
            h.a(this.b);
        }
    }
}
