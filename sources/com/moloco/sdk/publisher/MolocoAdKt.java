package com.moloco.sdk.publisher;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"createAdInfo", "Lcom/moloco/sdk/publisher/MolocoAd;", "adUnitId", "", "revenue", "", "(Ljava/lang/String;Ljava/lang/Float;)Lcom/moloco/sdk/publisher/MolocoAd;", "moloco-sdk_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MolocoAdKt {
    public static final MolocoAd createAdInfo(String adUnitId, Float f) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        return new MolocoAd("Moloco", adUnitId, f);
    }

    public static /* synthetic */ MolocoAd createAdInfo$default(String str, Float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = null;
        }
        return createAdInfo(str, f);
    }
}
