package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class Tg extends Gg {
    public final C4266le b;
    public final ProtobufStateStorage c;
    public final I2 d;
    public final C4130g2 e;
    public final B2 f;

    public Tg(C4282m5 c4282m5, C4266le c4266le) {
        this(c4282m5, c4266le, C4448sm.a(X1.class).a(c4282m5.getContext()), new I2(c4282m5.getContext()), new C4130g2(), new B2(c4282m5.getContext()));
    }

    @Override // io.appmetrica.analytics.impl.Gg
    public final boolean a(C3984a6 c3984a6) {
        C4282m5 c4282m5 = this.f11164a;
        c4282m5.b.toString();
        if (!c4282m5.t.c() || !c4282m5.w()) {
            return false;
        }
        X1 x1 = (X1) this.c.read();
        List list = x1.f11411a;
        H2 h2 = x1.b;
        I2 i2 = this.d;
        i2.getClass();
        X1 x2 = null;
        H2 h2A = AndroidUtils.isApiAchieved(28) ? E2.a(i2.f11186a, i2.b) : null;
        List list2 = x1.c;
        List list3 = (List) SystemServiceUtils.accessSystemServiceSafelyOrDefault(this.f.f11068a, "getting available providers", "location manager", Collections.emptyList(), new A2());
        C4266le c4266le = this.b;
        Context context = this.f11164a.f11664a;
        c4266le.getClass();
        ArrayList arrayListA = new Fi(context, new SafePackageManager()).a();
        if (CollectionUtils.areCollectionsEqual(arrayListA, list)) {
            arrayListA = null;
        }
        if (arrayListA != null || !In.a(h2, h2A) || !CollectionUtils.areCollectionsEqual(list2, list3)) {
            if (arrayListA != null) {
                list = arrayListA;
            }
            x2 = new X1(list, h2A, list3);
        }
        if (x2 != null) {
            C4386q9 c4386q9 = c4282m5.n;
            C3984a6 c3984a6A = C3984a6.a(c3984a6, x2.f11411a, x2.b, this.e, x2.c);
            c4386q9.a(c3984a6A, C4521vk.a(c4386q9.c.b(c3984a6A), c3984a6A.i));
            long jCurrentTimeSeconds = c4386q9.j.currentTimeSeconds();
            c4386q9.l = jCurrentTimeSeconds;
            c4386q9.f11734a.a(jCurrentTimeSeconds).b();
            this.c.save(x2);
            return false;
        }
        if (!c4282m5.z()) {
            return false;
        }
        C4386q9 c4386q10 = c4282m5.n;
        C3984a6 c3984a6A2 = C3984a6.a(c3984a6, x1.f11411a, x1.b, this.e, x1.c);
        c4386q10.a(c3984a6A2, C4521vk.a(c4386q10.c.b(c3984a6A2), c3984a6A2.i));
        long jCurrentTimeSeconds2 = c4386q10.j.currentTimeSeconds();
        c4386q10.l = jCurrentTimeSeconds2;
        c4386q10.f11734a.a(jCurrentTimeSeconds2).b();
        return false;
    }

    public Tg(C4282m5 c4282m5, C4266le c4266le, ProtobufStateStorage protobufStateStorage, I2 i2, C4130g2 c4130g2, B2 b2) {
        super(c4282m5);
        this.b = c4266le;
        this.c = protobufStateStorage;
        this.d = i2;
        this.e = c4130g2;
        this.f = b2;
    }
}
