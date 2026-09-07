package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.j2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4204j2 {
    public static final boolean a(Throwable th) {
        return true;
    }

    public final Ma a(Context context, AppMetricaConfig appMetricaConfig, InterfaceC3989ab interfaceC3989ab) {
        return new C4468th(new C4239kc(interfaceC3989ab, appMetricaConfig), new InterfaceC4432s6() { // from class: io.appmetrica.analytics.impl.j2$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.InterfaceC4432s6
            public final boolean a(Throwable th) {
                return C4204j2.a(th);
            }
        }, appMetricaConfig.crashTransformer, new T9(context));
    }
}
