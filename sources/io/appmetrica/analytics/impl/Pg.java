package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;

/* JADX INFO: loaded from: classes.dex */
public final class Pg extends Gg {
    public final Q8 b;

    public Pg(C4282m5 c4282m5) {
        this(c4282m5, c4282m5.i());
    }

    @Override // io.appmetrica.analytics.impl.Gg
    public final boolean a(C3984a6 c3984a6) {
        EnumC4237ka enumC4237ka;
        if (!TextUtils.isEmpty(c3984a6.getName())) {
            Q8 q8 = this.b;
            String name = c3984a6.getName();
            if (q8.c == null) {
                q8.a();
            }
            int iHashCode = name.hashCode();
            if (q8.c.b.contains(Integer.valueOf(iHashCode))) {
                enumC4237ka = EnumC4237ka.NON_FIRST_OCCURENCE;
            } else {
                S8 s8 = q8.c;
                EnumC4237ka enumC4237ka2 = s8.f11346a ? EnumC4237ka.FIRST_OCCURRENCE : EnumC4237ka.UNKNOWN;
                if (s8.d < 1000) {
                    s8.b.add(Integer.valueOf(iHashCode));
                    s8.d++;
                } else {
                    s8.f11346a = false;
                }
                V8 v8 = q8.b;
                S8 s9 = q8.c;
                IBinaryDataHelper iBinaryDataHelper = v8.c;
                U8 u8 = v8.b;
                v8.f11390a.getClass();
                A9 a9A = T8.a(s9);
                u8.getClass();
                iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a9A));
                enumC4237ka = enumC4237ka2;
            }
            c3984a6.k = enumC4237ka;
        }
        return false;
    }

    public Pg(C4282m5 c4282m5, Q8 q8) {
        super(c4282m5);
        this.b = q8;
    }
}
