package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.j4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3422j4 extends C3655z9 {
    public final int p;

    /* JADX WARN: Illegal instructions before constructor call */
    public C3422j4(AdConfig.ViewabilityConfig viewabilityConfig, byte b, L4 l4) {
        C3338d4 visibilityChecker = C3380g4.k;
        Intrinsics.checkNotNullParameter(visibilityChecker, "visibilityChecker");
        super(visibilityChecker, viewabilityConfig, b, l4);
        this.p = 1000;
    }

    @Override // com.inmobi.media.C3655z9, com.inmobi.media.fd
    public final int c() {
        AdConfig.ViewabilityConfig viewabilityConfig = this.n;
        return viewabilityConfig != null ? viewabilityConfig.getWebVisibilityThrottleMillis() : this.p;
    }
}
