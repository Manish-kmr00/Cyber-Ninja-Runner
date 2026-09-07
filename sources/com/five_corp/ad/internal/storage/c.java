package com.five_corp.ad.internal.storage;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f1527a;

    public c(a aVar) {
        this.f1527a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        a aVar = this.f1527a;
        aVar.f1525a.a(aVar.b, new byte[0]);
    }
}
