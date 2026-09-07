package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.b0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class s implements j<r> {
    public static final a d = new a(null);
    public static final String e = "NISignalProvider";
    public final b0 b;
    public r c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public s(b0 networkInfoService) {
        Intrinsics.checkNotNullParameter(networkInfoService, "networkInfoService");
        this.b = networkInfoService;
        this.c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        r rVarE = e();
        boolean z = !Intrinsics.areEqual(rVarE, this.c);
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, e, "[CBT] NIS needsRefresh: " + z + ", with nis: " + rVarE + ", cached: " + this.c, false, 4, null);
        return z;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public String c() {
        return e;
    }

    public final r e() {
        try {
            r rVar = new r(this.b.d(), this.b.b(), Boolean.valueOf(this.b.a()), this.b.c());
            MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, e, "[CBT] NIS providing " + rVar, false, 4, null);
            return rVar;
        } catch (Exception e2) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, e, "[CBT] NIS Error", e2, false, 8, null);
            return new r(null, null, null, null, 15, null);
        }
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public r d() {
        return this.c;
    }
}
