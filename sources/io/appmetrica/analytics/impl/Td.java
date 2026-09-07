package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes3.dex */
public final class Td implements Pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11364a;

    public Td(String str) {
        this.f11364a = str;
    }

    @Override // io.appmetrica.analytics.impl.Pn
    public final Nn a(Object obj) {
        return obj == null ? new Nn(this, false, this.f11364a + " is null.") : new Nn(this, true, "");
    }

    public final String a() {
        return this.f11364a;
    }
}
