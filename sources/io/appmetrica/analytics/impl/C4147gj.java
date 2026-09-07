package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.gj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4147gj implements Xa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11572a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;

    public C4147gj(String str, String str2, Throwable th) {
        this.f11572a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.reportError(this.f11572a, this.b, this.c);
    }
}
