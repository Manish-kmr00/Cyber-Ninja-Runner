package com.five_corp.ad.internal.bgtask;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f1330a;

    public d(e eVar) {
        this.f1330a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e.a(this.f1330a, true);
    }
}
