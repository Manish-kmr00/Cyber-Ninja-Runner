package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.mediation.rewarded.MediatedRewardedAdapter;
import com.monetization.ads.mediation.rewarded.MediatedRewardedAdapterListener;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class xy0 implements ux0<MediatedRewardedAdapter, MediatedRewardedAdapterListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediatedRewardedAdapter f10687a;

    public final MediatedRewardedAdapter a() {
        return this.f10687a;
    }

    @Override // com.yandex.mobile.ads.impl.ux0
    public final void a(com.monetization.ads.mediation.base.a aVar) {
        MediatedRewardedAdapter mediatedAdapter = (MediatedRewardedAdapter) aVar;
        Intrinsics.checkNotNullParameter(mediatedAdapter, "mediatedAdapter");
        mediatedAdapter.onInvalidate();
    }

    @Override // com.yandex.mobile.ads.impl.ux0
    public final void a(Context context, com.monetization.ads.mediation.base.a aVar, Object obj, Map localExtras, Map serverExtras) {
        MediatedRewardedAdapter mediatedAdapter = (MediatedRewardedAdapter) aVar;
        MediatedRewardedAdapterListener mediatedAdapterListener = (MediatedRewardedAdapterListener) obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediatedAdapter, "mediatedAdapter");
        Intrinsics.checkNotNullParameter(mediatedAdapterListener, "mediatedAdapterListener");
        Intrinsics.checkNotNullParameter(localExtras, "localExtras");
        Intrinsics.checkNotNullParameter(serverExtras, "serverExtras");
        this.f10687a = mediatedAdapter;
        mediatedAdapter.loadRewardedAd(context, mediatedAdapterListener, localExtras, serverExtras);
    }
}
