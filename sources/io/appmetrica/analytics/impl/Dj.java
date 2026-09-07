package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes13.dex */
public final class Dj implements Xa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11109a;
    public final /* synthetic */ String b;

    public Dj(String str, String str2) {
        this.f11109a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.reportEvent(this.f11109a, this.b);
    }
}
