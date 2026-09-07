package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.mediation.nativeads.MediatedNativeAdapter;
import com.monetization.ads.mediation.nativeads.MediatedNativeAdapterListener;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class py0 implements ux0<MediatedNativeAdapter, MediatedNativeAdapterListener> {
    @Override // com.yandex.mobile.ads.impl.ux0
    public final void a(com.monetization.ads.mediation.base.a aVar) {
        MediatedNativeAdapter mediatedAdapter = (MediatedNativeAdapter) aVar;
        Intrinsics.checkNotNullParameter(mediatedAdapter, "mediatedAdapter");
    }

    @Override // com.yandex.mobile.ads.impl.ux0
    public final void a(Context context, com.monetization.ads.mediation.base.a aVar, Object obj, Map localExtras, Map serverExtras) {
        MediatedNativeAdapter mediatedAdapter = (MediatedNativeAdapter) aVar;
        MediatedNativeAdapterListener mediatedAdapterListener = (MediatedNativeAdapterListener) obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediatedAdapter, "mediatedAdapter");
        Intrinsics.checkNotNullParameter(mediatedAdapterListener, "mediatedAdapterListener");
        Intrinsics.checkNotNullParameter(localExtras, "localExtras");
        Intrinsics.checkNotNullParameter(serverExtras, "serverExtras");
        mediatedAdapter.loadAd(context, mediatedAdapterListener, localExtras, serverExtras);
    }
}
