package com.five_corp.ad.internal.storage;

/* JADX INFO: loaded from: classes6.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1530a;
    public final /* synthetic */ i b;

    public f(i iVar, int i) {
        this.b = iVar;
        this.f1530a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.b, this.f1530a);
    }
}
