package com.moloco.sdk.internal.services.bidtoken.providers;

import android.app.ActivityManager;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class q implements j<p> {
    public static final a d = new a(null);
    public static final String e = "MemorySignalProvider";
    public final ActivityManager b;
    public p c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public q(ActivityManager activityManager) {
        Intrinsics.checkNotNullParameter(activityManager, "activityManager");
        this.b = activityManager;
        this.c = e();
    }

    public final boolean a(p pVar, p pVar2) {
        return (Intrinsics.areEqual(pVar.d(), pVar2.d()) && Intrinsics.areEqual(pVar.e(), pVar2.e()) && Intrinsics.areEqual(pVar.f(), pVar2.f())) ? false : true;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        p pVarE = e();
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.debugBuildLog$default(molocoLogger, e, "[CBT] cached lm: " + this.c.d() + ", t: " + this.c.e() + ", tm: " + this.c.f(), false, 4, null);
        MolocoLogger.debugBuildLog$default(molocoLogger, e, "[CBT] current lm: " + pVarE.d() + ", t: " + pVarE.e() + ", tm: " + pVarE.f(), false, 4, null);
        boolean zA = a(pVarE, this.c);
        MolocoLogger.debugBuildLog$default(molocoLogger, e, "[CBT] m needsRefresh: " + zA, false, 4, null);
        return zA;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public String c() {
        return e;
    }

    public final p e() {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            this.b.getMemoryInfo(memoryInfo);
            return new p(Boolean.valueOf(memoryInfo.lowMemory), Long.valueOf(memoryInfo.threshold), Long.valueOf(memoryInfo.totalMem));
        } catch (Exception e2) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, e, "[CBT] MI Error", e2, false, 8, null);
            return new p(null, null, null, 7, null);
        }
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public p d() {
        p pVar = this.c;
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, e, "[CBT] lm: " + pVar.d() + ", t: " + pVar.e() + ", tm: " + pVar.f(), false, 4, null);
        return pVar;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, e, "[CBT] Updating m state", false, 4, null);
        this.c = e();
    }
}
