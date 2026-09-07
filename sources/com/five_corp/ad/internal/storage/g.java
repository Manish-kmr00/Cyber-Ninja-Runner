package com.five_corp.ad.internal.storage;

/* JADX INFO: loaded from: classes6.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1531a;
    public final /* synthetic */ i b;

    public g(i iVar, int i) {
        this.b = iVar;
        this.f1531a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.b, this.f1531a);
    }
}
