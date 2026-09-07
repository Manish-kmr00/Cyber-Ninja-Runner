package com.pubmatic.sdk.openwrap.core.signal;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/pubmatic/sdk/openwrap/core/signal/POBSignalGeneratorFactory;", "", "()V", "getSignalGenerator", "Lcom/pubmatic/sdk/openwrap/core/signal/POBSignalGeneration;", "biddingHost", "Lcom/pubmatic/sdk/openwrap/core/signal/POBBiddingHost;", "openwrapcore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class POBSignalGeneratorFactory {
    public static final POBSignalGeneratorFactory INSTANCE = new POBSignalGeneratorFactory();

    private POBSignalGeneratorFactory() {
    }

    @JvmStatic
    public static final POBSignalGeneration getSignalGenerator(POBBiddingHost biddingHost) {
        Intrinsics.checkNotNullParameter(biddingHost, "biddingHost");
        return new POBALMAXSignalGenerator();
    }
}
