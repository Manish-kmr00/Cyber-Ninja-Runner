package com.monetization.ads.mediation.banner;

import android.content.Context;
import com.yandex.mobile.ads.impl.ux0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements ux0<MediatedBannerAdapter, MediatedBannerAdapter.MediatedBannerAdapterListener> {
    @Override // com.yandex.mobile.ads.impl.ux0
    public final void a(com.monetization.ads.mediation.base.a aVar) {
        MediatedBannerAdapter mediatedAdapter = (MediatedBannerAdapter) aVar;
        Intrinsics.checkNotNullParameter(mediatedAdapter, "mediatedAdapter");
        mediatedAdapter.onInvalidate();
    }

    @Override // com.yandex.mobile.ads.impl.ux0
    public final void a(Context context, com.monetization.ads.mediation.base.a aVar, Object obj, Map localExtras, Map serverExtras) {
        MediatedBannerAdapter mediatedAdapter = (MediatedBannerAdapter) aVar;
        MediatedBannerAdapter.MediatedBannerAdapterListener mediatedAdapterListener = (MediatedBannerAdapter.MediatedBannerAdapterListener) obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediatedAdapter, "mediatedAdapter");
        Intrinsics.checkNotNullParameter(mediatedAdapterListener, "mediatedAdapterListener");
        Intrinsics.checkNotNullParameter(localExtras, "localExtras");
        Intrinsics.checkNotNullParameter(serverExtras, "serverExtras");
        mediatedAdapter.loadBanner(context, mediatedAdapterListener, localExtras, serverExtras);
    }
}
