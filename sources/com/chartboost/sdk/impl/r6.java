package com.chartboost.sdk.impl;

import com.chartboost.sdk.Mediation;
import com.smaato.sdk.video.vast.model.Ad;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012BA\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0012¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/chartboost/sdk/impl/r6;", "Lcom/chartboost/sdk/impl/ka;", "", "n", "()Z", "Lcom/chartboost/sdk/impl/ma;", "name", "", "message", Ad.AD_TYPE, "location", "Lcom/chartboost/sdk/Mediation;", "mediation", "Lcom/chartboost/sdk/impl/da;", "trackAd", "<init>", "(Lcom/chartboost/sdk/impl/ma;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/Mediation;Lcom/chartboost/sdk/impl/da;)V", "m", "a", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public class r6 extends ka {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r6(ma name, String message, String adType, String location, Mediation mediation, da trackAd) {
        super(name, message, adType, location, mediation, ka.b.INFO, trackAd, false, false, 0L, 0.0f, ka.a.LOW, 1920, null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(trackAd, "trackAd");
        if (n()) {
            a(ka.a.HIGH);
            a(true);
        }
    }

    public /* synthetic */ r6(ma maVar, String str, String str2, String str3, Mediation mediation, da daVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(maVar, str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? null : mediation, (i & 32) != 0 ? new da(null, null, null, null, null, null, null, null, 255, null) : daVar);
    }

    public final boolean n() {
        ma name = getName();
        return name == ma.a.FINISH_SUCCESS || name == ma.a.FINISH_FAILURE || name == ma.i.FINISH_SUCCESS || name == ma.i.FINISH_FAILURE;
    }
}
