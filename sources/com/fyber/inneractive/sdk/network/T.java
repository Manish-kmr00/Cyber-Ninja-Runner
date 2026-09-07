package com.fyber.inneractive.sdk.network;

/* JADX INFO: loaded from: classes6.dex */
public final class T implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f1913a;
    public final /* synthetic */ Exception b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ U d;

    public T(U u, Object obj, Exception exc, boolean z) {
        this.d = u;
        this.f1913a = obj;
        this.b = exc;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.b.a(this.f1913a, this.b, this.c);
    }
}
