package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.z9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public class C3655z9 extends fd {
    public final AdConfig.ViewabilityConfig n;
    public final int o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3655z9(Zc visibilityChecker, AdConfig.ViewabilityConfig viewabilityConfig, byte b, L4 l4) {
        super(visibilityChecker, b, l4);
        Intrinsics.checkNotNullParameter(visibilityChecker, "visibilityChecker");
        this.n = viewabilityConfig;
        this.o = 100;
    }

    @Override // com.inmobi.media.fd
    public int c() {
        AdConfig.ViewabilityConfig viewabilityConfig = this.n;
        return viewabilityConfig != null ? viewabilityConfig.getVisibilityThrottleMillis() : this.o;
    }

    @Override // com.inmobi.media.fd
    public final void d() {
        g();
    }
}
