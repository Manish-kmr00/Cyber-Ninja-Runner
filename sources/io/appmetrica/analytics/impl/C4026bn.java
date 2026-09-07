package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ValidationException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.bn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
public class C4026bn implements Pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pn f11484a;

    public C4026bn(Pn pn) {
        this.f11484a = pn;
    }

    @Override // io.appmetrica.analytics.impl.Pn
    public final Nn a(Object obj) {
        Nn nnA = this.f11484a.a(obj);
        if (nnA.f11273a) {
            return nnA;
        }
        throw new ValidationException(nnA.b);
    }

    public final Pn a() {
        return this.f11484a;
    }
}
