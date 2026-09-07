package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.A6;
import io.appmetrica.analytics.impl.Bk;
import io.appmetrica.analytics.impl.Bn;
import io.appmetrica.analytics.impl.C4419ri;
import io.appmetrica.analytics.impl.C4598ym;
import io.appmetrica.analytics.impl.C4623zm;
import io.appmetrica.analytics.impl.InterfaceC4200in;
import io.appmetrica.analytics.impl.InterfaceC4304n2;
import io.appmetrica.analytics.impl.J4;
import io.appmetrica.analytics.impl.Pn;

/* JADX INFO: loaded from: classes11.dex */
public class StringAttribute {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC4200in f11967a;
    private final A6 b;

    StringAttribute(String str, C4598ym c4598ym, Pn pn, InterfaceC4304n2 interfaceC4304n2) {
        this.b = new A6(str, pn, interfaceC4304n2);
        this.f11967a = c4598ym;
    }

    public UserProfileUpdate<? extends Bn> withValue(String str) {
        A6 a6 = this.b;
        return new UserProfileUpdate<>(new C4623zm(a6.c, str, this.f11967a, a6.f11054a, new J4(a6.b)));
    }

    public UserProfileUpdate<? extends Bn> withValueIfUndefined(String str) {
        A6 a6 = this.b;
        return new UserProfileUpdate<>(new C4623zm(a6.c, str, this.f11967a, a6.f11054a, new Bk(a6.b)));
    }

    public UserProfileUpdate<? extends Bn> withValueReset() {
        A6 a6 = this.b;
        return new UserProfileUpdate<>(new C4419ri(0, a6.c, a6.f11054a, a6.b));
    }
}
