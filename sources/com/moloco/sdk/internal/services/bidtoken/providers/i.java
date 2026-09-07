package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i implements j<h> {
    public static final a d = new a(null);
    public static final String e = "BInfoSignalProvider";
    public final com.moloco.sdk.internal.services.q b;
    public h c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public i(com.moloco.sdk.internal.services.q batteryInfoService) {
        Intrinsics.checkNotNullParameter(batteryInfoService, "batteryInfoService");
        this.b = batteryInfoService;
        this.c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        boolean z = !Intrinsics.areEqual(this.c, e());
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, e, "[CBT][BIS]: needsRefresh: " + z, false, 4, null);
        return z;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public String c() {
        return e;
    }

    public final h e() {
        try {
            h hVar = new h(Integer.valueOf(this.b.b()), Integer.valueOf(this.b.a()), Boolean.valueOf(this.b.c()));
            MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, e, "[CBT][BIS]: blev: " + hVar.e() + ", bst: " + hVar.d() + ", psm: " + hVar.f(), false, 4, null);
            return hVar;
        } catch (Exception e2) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, e, "[CBT][BIS]: Error", e2, false, 8, null);
            return new h(null, null, null, 7, null);
        }
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public h d() {
        return this.c;
    }
}
