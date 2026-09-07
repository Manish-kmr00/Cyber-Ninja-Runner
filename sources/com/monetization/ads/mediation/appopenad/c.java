package com.monetization.ads.mediation.appopenad;

import android.content.Context;
import com.yandex.mobile.ads.impl.ux0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements ux0<MediatedAppOpenAdAdapter, MediatedAppOpenAdAdapter.MediatedAppOpenAdAdapterListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediatedAppOpenAdAdapter f7219a;

    @Override // com.yandex.mobile.ads.impl.ux0
    public final void a(com.monetization.ads.mediation.base.a aVar) {
        MediatedAppOpenAdAdapter mediatedAdapter = (MediatedAppOpenAdAdapter) aVar;
        Intrinsics.checkNotNullParameter(mediatedAdapter, "mediatedAdapter");
        mediatedAdapter.onInvalidate();
    }

    @Override // com.yandex.mobile.ads.impl.ux0
    public final void a(Context context, com.monetization.ads.mediation.base.a aVar, Object obj, Map localExtras, Map serverExtras) {
        MediatedAppOpenAdAdapter mediatedAdapter = (MediatedAppOpenAdAdapter) aVar;
        MediatedAppOpenAdAdapter.MediatedAppOpenAdAdapterListener mediatedAdapterListener = (MediatedAppOpenAdAdapter.MediatedAppOpenAdAdapterListener) obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediatedAdapter, "mediatedAdapter");
        Intrinsics.checkNotNullParameter(mediatedAdapterListener, "mediatedAdapterListener");
        Intrinsics.checkNotNullParameter(localExtras, "localExtras");
        Intrinsics.checkNotNullParameter(serverExtras, "serverExtras");
        this.f7219a = mediatedAdapter;
        mediatedAdapter.loadAppOpenAd(context, mediatedAdapterListener, localExtras, serverExtras);
    }

    public final MediatedAppOpenAdAdapter a() {
        return this.f7219a;
    }
}
