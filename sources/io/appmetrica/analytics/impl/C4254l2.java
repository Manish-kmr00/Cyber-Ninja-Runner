package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.HashSet;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.l2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4254l2 extends Gg {
    public final Un b;
    public final Kj c;

    public C4254l2(C4282m5 c4282m5) {
        this(c4282m5, c4282m5.t(), Kj.c());
    }

    @Override // io.appmetrica.analytics.impl.Gg
    public final boolean a(C3984a6 c3984a6) {
        C4282m5 c4282m5 = this.f11164a;
        if (!this.b.c() && !this.b.d()) {
            if (((C4045ch) c4282m5.k.a()).e) {
                this.c.b();
            }
            Q8 q8 = this.f11164a.l;
            if (q8.c == null) {
                q8.a();
            }
            S8 s8 = q8.c;
            s8.getClass();
            s8.b = new HashSet();
            s8.d = 0;
            S8 s9 = q8.c;
            s9.f11346a = true;
            V8 v8 = q8.b;
            IBinaryDataHelper iBinaryDataHelper = v8.c;
            U8 u8 = v8.b;
            v8.f11390a.getClass();
            A9 a9A = T8.a(s9);
            u8.getClass();
            iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a9A));
        }
        return false;
    }

    public C4254l2(C4282m5 c4282m5, Un un, Kj kj) {
        super(c4282m5);
        this.b = un;
        this.c = kj;
    }
}
