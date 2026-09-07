package com.monetization.ads.mediation.interstitial;

import android.content.Context;
import com.yandex.mobile.ads.impl.ux0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements ux0<MediatedInterstitialAdapter, MediatedInterstitialAdapter.MediatedInterstitialAdapterListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediatedInterstitialAdapter f7232a;

    @Override // com.yandex.mobile.ads.impl.ux0
    public final void a(com.monetization.ads.mediation.base.a aVar) {
        MediatedInterstitialAdapter mediatedAdapter = (MediatedInterstitialAdapter) aVar;
        Intrinsics.checkNotNullParameter(mediatedAdapter, "mediatedAdapter");
        mediatedAdapter.onInvalidate();
    }

    @Override // com.yandex.mobile.ads.impl.ux0
    public final void a(Context context, com.monetization.ads.mediation.base.a aVar, Object obj, Map localExtras, Map serverExtras) {
        MediatedInterstitialAdapter mediatedAdapter = (MediatedInterstitialAdapter) aVar;
        MediatedInterstitialAdapter.MediatedInterstitialAdapterListener mediatedAdapterListener = (MediatedInterstitialAdapter.MediatedInterstitialAdapterListener) obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediatedAdapter, "mediatedAdapter");
        Intrinsics.checkNotNullParameter(mediatedAdapterListener, "mediatedAdapterListener");
        Intrinsics.checkNotNullParameter(localExtras, "localExtras");
        Intrinsics.checkNotNullParameter(serverExtras, "serverExtras");
        this.f7232a = mediatedAdapter;
        mediatedAdapter.loadInterstitial(context, mediatedAdapterListener, localExtras, serverExtras);
    }

    public final MediatedInterstitialAdapter a() {
        return this.f7232a;
    }
}
