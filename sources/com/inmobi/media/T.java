package com.inmobi.media;

/* JADX INFO: loaded from: classes8.dex */
public final class T implements D9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Z f3196a;
    public final /* synthetic */ boolean b;

    public T(Z z, boolean z2) {
        this.f3196a = z;
        this.b = z2;
    }

    @Override // com.inmobi.media.D9
    public final void a(Object obj) {
        ((Boolean) obj).getClass();
        this.f3196a.a("result pushed to queue");
        if (this.b) {
            Z z = this.f3196a;
            z.a("session end - cleanup");
            z.g = null;
            z.f.clear();
            z.c.set(false);
            z.d.set(false);
        }
    }

    @Override // com.inmobi.media.D9
    public final void onError(Exception exc) {
        this.f3196a.a(exc, "error in pushing to queue");
    }
}
