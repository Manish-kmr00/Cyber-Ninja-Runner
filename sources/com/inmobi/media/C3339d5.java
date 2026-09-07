package com.inmobi.media;

import android.content.Context;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.CrashConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.d5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3339d5 implements InterfaceC3564t2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3339d5 f3292a = new C3339d5();
    public static final C3379g3 b;
    public static final M5 c;

    static {
        Lazy lazy = LazyKt.lazy(C3325c5.f3282a);
        c = new M5((CrashConfig) lazy.getValue());
        Context contextD = C3517pb.d();
        if (contextD != null) {
            b = new C3379g3(contextD, (CrashConfig) lazy.getValue(), C3517pb.f());
        }
    }

    @Override // com.inmobi.media.InterfaceC3564t2
    public final void a(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (config instanceof CrashConfig) {
            M5 m5 = c;
            CrashConfig crashConfig = (CrashConfig) config;
            m5.getClass();
            Intrinsics.checkNotNullParameter(crashConfig, "crashConfig");
            m5.f3134a = crashConfig;
            C3367f5 c3367f5 = m5.c;
            c3367f5.getClass();
            Intrinsics.checkNotNullParameter(crashConfig, "config");
            c3367f5.f3311a.f3361a = crashConfig.getCrashConfig().getSamplingPercent();
            c3367f5.b.f3361a = crashConfig.getCatchConfig().getSamplingPercent();
            c3367f5.c.f3361a = crashConfig.getAnr().getWatchdog().getSamplingPercent();
            c3367f5.d.f3361a = crashConfig.getAnr().getAppExitReason().getSamplingPercent();
            M3 m3 = m5.b;
            if (m3 != null) {
                J3 eventConfig = crashConfig.getEventConfig();
                Intrinsics.checkNotNullParameter(eventConfig, "eventConfig");
                m3.i = eventConfig;
            }
            C3379g3 c3379g3 = b;
            if (c3379g3 != null) {
                Intrinsics.checkNotNullParameter(crashConfig, "crashConfig");
                c3379g3.f3323a = crashConfig;
            }
        }
    }
}
