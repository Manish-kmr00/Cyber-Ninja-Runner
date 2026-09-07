package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.f0;
import com.moloco.sdk.internal.services.y;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class o implements j<n> {
    public static final a e = new a(null);
    public static final String f = "DSignalProvider";
    public final y b;
    public final f0 c;
    public n d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public o(y deviceInfoService, f0 screenInfoService) {
        Intrinsics.checkNotNullParameter(deviceInfoService, "deviceInfoService");
        Intrinsics.checkNotNullParameter(screenInfoService, "screenInfoService");
        this.b = deviceInfoService;
        this.c = screenInfoService;
        this.d = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.d = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        n nVarE = e();
        boolean z = !Intrinsics.areEqual(nVarE, this.d);
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, f, "[CBT] DSP needsRefresh: " + z + ", with current: " + nVarE + ", cached: " + this.d, false, 4, null);
        return z;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public String c() {
        return f;
    }

    public final n e() {
        try {
            return new n(this.c.b(), this.b.c(), this.b.d());
        } catch (Exception e2) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, f, "[CBT] DSP Error", e2, false, 8, null);
            return new n(null, null, null, 7, null);
        }
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public n d() {
        return this.d;
    }
}
