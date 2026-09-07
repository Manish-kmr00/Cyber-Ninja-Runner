package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.fj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4122fj implements Xa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11554a;
    public final /* synthetic */ Throwable b;

    public C4122fj(String str, Throwable th) {
        this.f11554a = str;
        this.b = th;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.reportError(this.f11554a, this.b);
    }
}
