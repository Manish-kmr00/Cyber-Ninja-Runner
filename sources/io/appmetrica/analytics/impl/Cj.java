package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes13.dex */
public final class Cj implements Xa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11093a;

    public Cj(String str) {
        this.f11093a = str;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.reportEvent(this.f11093a);
    }
}
