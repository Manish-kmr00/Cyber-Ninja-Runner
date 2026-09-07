package com.facebook.ads.redexgen.core;

import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9D, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C9D {
    public static C9D A00 = new C9D();

    public static C9D A00() {
        return A00;
    }

    public final C2668jW A01(AnonymousClass85 anonymousClass85, boolean z) {
        return new C2668jW(anonymousClass85, z, new C13967j());
    }

    public final Map<String, String> A02(AnonymousClass85 anonymousClass85) {
        try {
            return A01(anonymousClass85, false).A05();
        } catch (Throwable th) {
            anonymousClass85.A08().A48(th);
            return AnonymousClass95.A01(anonymousClass85);
        }
    }
}
