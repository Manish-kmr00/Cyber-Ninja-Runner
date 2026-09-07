package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes2.dex */
public final class Oh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11283a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ Yh c;

    public Oh(Yh yh, String str, byte[] bArr) {
        this.c = yh;
        this.f11283a = str;
        this.b = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.c;
        Yh.a(yh.f11439a, yh.d, yh.e).setSessionExtra(this.f11283a, this.b);
    }
}
