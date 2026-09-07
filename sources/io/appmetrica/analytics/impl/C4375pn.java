package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.pn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4375pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4412rb f11728a;

    public C4375pn() {
        this(new C4412rb());
    }

    public final C4319nh a(C4325nn c4325nn, C4568xh c4568xh) {
        String str;
        C4076dn c4076dn = c4325nn.f11690a;
        String str2 = c4076dn == null ? "" : (String) WrapUtils.getOrDefault(c4076dn.f11522a, "");
        byte[] bArrFromModel = this.f11728a.fromModel(c4325nn);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(c4568xh.b.getApiKey());
        Set set = C9.f11086a;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        C4082e4 c4082e4 = new C4082e4(bArrFromModel, str2, 5891, orCreatePublicLogger);
        c4082e4.c = c4568xh.d();
        HashMap map = c4082e4.q;
        C4367pf c4367pf = new C4367pf(c4568xh.f11474a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(c4568xh.b);
        synchronized (c4568xh) {
            str = c4568xh.f;
        }
        return new C4319nh(c4082e4, true, 1, map, new C4568xh(c4367pf, counterConfiguration, str));
    }

    public C4375pn(C4412rb c4412rb) {
        this.f11728a = c4412rb;
    }
}
