package com.pubmatic.sdk.openwrap.core.signal;

import com.pubmatic.sdk.common.POBAdFormat;
import com.pubmatic.sdk.openwrap.core.POBImpression;
import com.pubmatic.sdk.openwrap.core.POBRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/pubmatic/sdk/openwrap/core/signal/POBALMAXRequestFactory;", "", "()V", "getRequest", "Lcom/pubmatic/sdk/openwrap/core/POBRequest;", "placementType", "Lcom/pubmatic/sdk/common/POBAdFormat;", "impression", "Lcom/pubmatic/sdk/openwrap/core/POBImpression;", "openwrapcore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class POBALMAXRequestFactory {
    public static final POBALMAXRequestFactory INSTANCE = new POBALMAXRequestFactory();

    private POBALMAXRequestFactory() {
    }

    @JvmStatic
    public static final POBRequest getRequest(POBAdFormat placementType, POBImpression impression) {
        Intrinsics.checkNotNullParameter(placementType, "placementType");
        Intrinsics.checkNotNullParameter(impression, "impression");
        return POBRequest.createInstance("NA", 0, placementType, impression);
    }
}
