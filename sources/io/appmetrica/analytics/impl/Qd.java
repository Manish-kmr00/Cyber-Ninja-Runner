package io.appmetrica.analytics.impl;

import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final class Qd implements Pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11312a;

    public Qd(String str) {
        this.f11312a = str;
    }

    @Override // io.appmetrica.analytics.impl.Pn
    public final Nn a(Collection<Object> collection) {
        return In.a((Collection) collection) ? new Nn(this, false, this.f11312a + " is null or empty.") : new Nn(this, true, "");
    }
}
