package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.qa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4387qa implements InterfaceC3990ac {
    @Override // io.appmetrica.analytics.impl.InterfaceC3990ac
    public final C4112f9 a(C4384q7 c4384q7) {
        C4112f9 c4112f9 = null;
        if ((c4384q7 != null ? c4384q7.b : null) != null && c4384q7.c != null) {
            c4112f9 = new C4112f9();
            c4112f9.b = c4384q7.b.doubleValue();
            c4112f9.f11547a = c4384q7.c.doubleValue();
            Integer num = c4384q7.d;
            if (num != null) {
                c4112f9.g = num.intValue();
            }
            Integer num2 = c4384q7.e;
            if (num2 != null) {
                c4112f9.e = num2.intValue();
            }
            Integer num3 = c4384q7.f;
            if (num3 != null) {
                c4112f9.d = num3.intValue();
            }
            Integer num4 = c4384q7.g;
            if (num4 != null) {
                c4112f9.f = num4.intValue();
            }
            Long l = c4384q7.h;
            if (l != null) {
                c4112f9.c = TimeUnit.MILLISECONDS.toSeconds(l.longValue());
            }
            String str = c4384q7.i;
            if (str != null) {
                if (Intrinsics.areEqual(str, "gps")) {
                    c4112f9.h = 1;
                } else if (Intrinsics.areEqual(str, "network")) {
                    c4112f9.h = 2;
                }
            }
            String str2 = c4384q7.j;
            if (str2 != null) {
                c4112f9.i = str2;
            }
        }
        return c4112f9;
    }
}
