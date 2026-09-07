package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.A6;
import io.appmetrica.analytics.impl.Bn;
import io.appmetrica.analytics.impl.C4009b6;
import io.appmetrica.analytics.impl.C4512vb;
import io.appmetrica.analytics.impl.Lb;

/* JADX INFO: loaded from: classes11.dex */
public final class CounterAttribute {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A6 f11963a;

    CounterAttribute(String str, C4512vb c4512vb, Lb lb) {
        this.f11963a = new A6(str, c4512vb, lb);
    }

    public UserProfileUpdate<? extends Bn> withDelta(double d) {
        return new UserProfileUpdate<>(new C4009b6(this.f11963a.c, d));
    }
}
