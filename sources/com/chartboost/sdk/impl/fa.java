package com.chartboost.sdk.impl;

import com.chartboost.sdk.Mediation;
import com.smaato.sdk.video.vast.model.Ad;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a7\u0010\u0001\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/chartboost/sdk/impl/m4;", "a", "()Lcom/chartboost/sdk/impl/m4;", "", Ad.AD_TYPE, "location", "Lcom/chartboost/sdk/Mediation;", "mediation", "eventTracker", "Lcom/chartboost/sdk/impl/f3;", "(Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/Mediation;Lcom/chartboost/sdk/impl/m4;)Lcom/chartboost/sdk/impl/f3;", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class fa {
    public static final f3 a(String adType, String location, Mediation mediation, m4 eventTracker) {
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        return new g3(adType, location, mediation, eventTracker);
    }

    public static final m4 a() {
        return y2.b.m().a();
    }
}
