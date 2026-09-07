package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements j<f> {
    public static final a d = new a(null);
    public static final String e = "AudSignalProvider";
    public final com.moloco.sdk.internal.services.n b;
    public f c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public g(com.moloco.sdk.internal.services.n audioService) {
        Intrinsics.checkNotNullParameter(audioService, "audioService");
        this.b = audioService;
        this.c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.c = e();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        f fVarE = e();
        boolean z = !Intrinsics.areEqual(fVarE, this.c);
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, e, "[CBT] needsRefresh: " + z + ", with current: " + fVarE + ", cached: " + this.c, false, 4, null);
        return z;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public String c() {
        return e;
    }

    public final f e() {
        try {
            return new f(this.b.a(), Integer.valueOf(this.b.b()));
        } catch (Exception e2) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, e, "[CBT] AS Error", e2, false, 8, null);
            return new f(null, null, 3, null);
        }
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public f d() {
        return this.c;
    }
}
