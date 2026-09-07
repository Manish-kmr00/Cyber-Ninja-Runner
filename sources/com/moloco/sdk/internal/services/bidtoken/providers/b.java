package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements j<com.moloco.sdk.internal.services.bidtoken.providers.a> {
    public static final a d = new a(null);
    public static final String e = "AcSignalProvider";
    public final com.moloco.sdk.internal.services.a b;
    public com.moloco.sdk.internal.services.bidtoken.providers.a c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public b(com.moloco.sdk.internal.services.a accessibilityInfoService) {
        Intrinsics.checkNotNullParameter(accessibilityInfoService, "accessibilityInfoService");
        this.b = accessibilityInfoService;
        this.c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        com.moloco.sdk.internal.services.bidtoken.providers.a aVarE = e();
        boolean z = !Intrinsics.areEqual(aVarE, this.c);
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, e, "[CBT] needsRefresh: " + z + ", with current: " + aVarE + ", cached: " + this.c, false, 4, null);
        return z;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public String c() {
        return e;
    }

    public final com.moloco.sdk.internal.services.bidtoken.providers.a e() {
        try {
            return new com.moloco.sdk.internal.services.bidtoken.providers.a(Boolean.valueOf(this.b.c()), Boolean.valueOf(this.b.b()), Boolean.valueOf(this.b.a()), Float.valueOf(this.b.getFontScale()));
        } catch (Exception e2) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, e, "[CBT] ACS Error", e2, false, 8, null);
            return new com.moloco.sdk.internal.services.bidtoken.providers.a(null, null, null, null, 15, null);
        }
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public com.moloco.sdk.internal.services.bidtoken.providers.a d() {
        return this.c;
    }
}
