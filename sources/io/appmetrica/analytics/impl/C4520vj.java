package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.vj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4520vj implements Xa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11818a;
    public final /* synthetic */ byte[] b;

    public C4520vj(String str, byte[] bArr) {
        this.f11818a = str;
        this.b = bArr;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.setSessionExtra(this.f11818a, this.b);
    }
}
