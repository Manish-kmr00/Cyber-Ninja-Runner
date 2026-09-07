package com.inmobi.media;

import android.util.Log;
import com.inmobi.adquality.models.AdQualityResult;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
public final class L extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ N f3120a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(N n) {
        super(0);
        this.f3120a = n;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        N n = this.f3120a;
        n.getClass();
        Intrinsics.checkNotNullParameter("AdQualityBeaconExecutor", "tag");
        Intrinsics.checkNotNullParameter("beacon handler execute", "message");
        Log.i("AdQualityBeaconExecutor", "beacon handler execute");
        n.b.set(true);
        ScheduledExecutorService scheduledExecutorService = P.f3162a;
        Lazy lazy = AbstractC3415ib.f3341a;
        int iA = D1.a((D1) lazy.getValue());
        Q q = (Q) lazy.getValue();
        q.getClass();
        Log.i("AdQualityDao", "peek");
        List<AdQualityResult> listA = D1.a(q, null, null, null, null, null, Integer.valueOf(iA), 31);
        if (listA.isEmpty()) {
            listA = CollectionsKt.emptyList();
        }
        for (AdQualityResult adQualityResult : listA) {
            if (adQualityResult != null) {
                AdConfig adConfig = n.f3140a;
                G5 g5 = new G5(adQualityResult, new C3545rc(adConfig.getIncludeIds()), adConfig.getAdQuality());
                M onBeaconHit = new M(n, adQualityResult);
                Intrinsics.checkNotNullParameter(onBeaconHit, "onBeaconHit");
                Intrinsics.checkNotNullParameter("JsonBeaconRequest", "tag");
                Intrinsics.checkNotNullParameter("hitBeacon", "message");
                Log.i("JsonBeaconRequest", "hitBeacon");
                g5.f();
                Oa retryPolicy = new Oa(g5.z.getMaxRetries(), g5.z.getRetryInterval());
                Intrinsics.checkNotNullParameter(retryPolicy, "retryPolicy");
                g5.w = retryPolicy;
                g5.a(new F5(onBeaconHit));
            }
        }
        n.c.set(true);
        return Unit.INSTANCE;
    }
}
