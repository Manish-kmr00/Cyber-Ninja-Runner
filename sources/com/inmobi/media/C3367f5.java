package com.inmobi.media;

import com.inmobi.commons.core.configs.CrashConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.f5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3367f5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3443kb f3311a;
    public final C3443kb b;
    public final C3443kb c;
    public final C3443kb d;

    public C3367f5(CrashConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.f3311a = new C3443kb(config.getCrashConfig().getSamplingPercent());
        this.b = new C3443kb(config.getCatchConfig().getSamplingPercent());
        this.c = new C3443kb(config.getAnr().getWatchdog().getSamplingPercent());
        this.d = new C3443kb(config.getAnr().getAppExitReason().getSamplingPercent());
    }
}
