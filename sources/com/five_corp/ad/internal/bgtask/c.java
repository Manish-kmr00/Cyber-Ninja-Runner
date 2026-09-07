package com.five_corp.ad.internal.bgtask;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f1329a;

    public c(e eVar) {
        this.f1329a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e.a(this.f1329a, false);
    }
}
