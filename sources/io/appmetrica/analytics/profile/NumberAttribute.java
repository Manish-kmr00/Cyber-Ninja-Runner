package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.A6;
import io.appmetrica.analytics.impl.Bk;
import io.appmetrica.analytics.impl.Bn;
import io.appmetrica.analytics.impl.C4419ri;
import io.appmetrica.analytics.impl.C4512vb;
import io.appmetrica.analytics.impl.D4;
import io.appmetrica.analytics.impl.J4;
import io.appmetrica.analytics.impl.Lb;
import io.appmetrica.analytics.impl.Xd;

/* JADX INFO: loaded from: classes5.dex */
public final class NumberAttribute {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A6 f11966a;

    NumberAttribute(String str, C4512vb c4512vb, Lb lb) {
        this.f11966a = new A6(str, c4512vb, lb);
    }

    public UserProfileUpdate<? extends Bn> withValue(double d) {
        return new UserProfileUpdate<>(new Xd(this.f11966a.c, d, new C4512vb(), new J4(new Lb(new D4(100)))));
    }

    public UserProfileUpdate<? extends Bn> withValueIfUndefined(double d) {
        return new UserProfileUpdate<>(new Xd(this.f11966a.c, d, new C4512vb(), new Bk(new Lb(new D4(100)))));
    }

    public UserProfileUpdate<? extends Bn> withValueReset() {
        return new UserProfileUpdate<>(new C4419ri(1, this.f11966a.c, new C4512vb(), new Lb(new D4(100))));
    }
}
