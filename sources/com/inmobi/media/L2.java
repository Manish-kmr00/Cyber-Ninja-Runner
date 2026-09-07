package com.inmobi.media;

import android.content.Context;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.SignalsConfig;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class L2 implements InterfaceC3564t2 {
    @Override // com.inmobi.media.InterfaceC3564t2
    public final void a(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        synchronized (this) {
            M2 m2 = M2.f3131a;
            Intrinsics.checkNotNullExpressionValue("M2", "<get-TAG>(...)");
            M2.d = (SignalsConfig) config;
            SignalsConfig signalsConfig = M2.d;
            M2.f = G3.a(signalsConfig != null ? signalsConfig.getKA() : null);
            Context contextD = C3517pb.d();
            if (contextD != null) {
                Intrinsics.checkNotNull("M2");
                ConcurrentHashMap concurrentHashMap = K5.b;
                K5 k5A = J5.a(contextD, "c_data_store");
                Context contextD2 = C3517pb.d();
                int vak = 1;
                if (contextD2 != null) {
                    K5 k5A2 = J5.a(contextD2, "c_data_store");
                    Intrinsics.checkNotNullParameter("akv", "key");
                    vak = k5A2.f3112a.getInt("akv", 1);
                }
                SignalsConfig signalsConfig2 = M2.d;
                if (signalsConfig2 == null || signalsConfig2.getVAK() != vak) {
                    Intrinsics.checkNotNull("M2");
                    SignalsConfig signalsConfig3 = M2.d;
                    if (signalsConfig3 != null) {
                        vak = signalsConfig3.getVAK();
                    }
                    k5A.a("akv", vak);
                    m2.d();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
