package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.A6;
import io.appmetrica.analytics.impl.Bk;
import io.appmetrica.analytics.impl.Bn;
import io.appmetrica.analytics.impl.C4404r3;
import io.appmetrica.analytics.impl.C4419ri;
import io.appmetrica.analytics.impl.InterfaceC4304n2;
import io.appmetrica.analytics.impl.J4;
import io.appmetrica.analytics.impl.Pn;

/* JADX INFO: loaded from: classes12.dex */
public class BooleanAttribute {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A6 f11962a;

    BooleanAttribute(String str, Pn pn, InterfaceC4304n2 interfaceC4304n2) {
        this.f11962a = new A6(str, pn, interfaceC4304n2);
    }

    public UserProfileUpdate<? extends Bn> withValue(boolean z) {
        A6 a6 = this.f11962a;
        return new UserProfileUpdate<>(new C4404r3(a6.c, z, a6.f11054a, new J4(a6.b)));
    }

    public UserProfileUpdate<? extends Bn> withValueIfUndefined(boolean z) {
        A6 a6 = this.f11962a;
        return new UserProfileUpdate<>(new C4404r3(a6.c, z, a6.f11054a, new Bk(a6.b)));
    }

    public UserProfileUpdate<? extends Bn> withValueReset() {
        A6 a6 = this.f11962a;
        return new UserProfileUpdate<>(new C4419ri(3, a6.c, a6.f11054a, a6.b));
    }
}
