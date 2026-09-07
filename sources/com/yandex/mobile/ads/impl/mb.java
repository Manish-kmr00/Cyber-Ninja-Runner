package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.monetization.ads.fullscreen.template.view.ExtendedViewContainer;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class mb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9619a;
    private final bc b;
    private final ac c;
    private final qb d;

    public /* synthetic */ mb(Activity activity, bc bcVar) {
        this(activity, bcVar, new ac(), new qb(activity, false, 14));
    }

    public final ViewGroup a() {
        View viewInflate = LayoutInflater.from(this.f9619a).inflate(R.layout.monetization_ads_internal_adtune_container, (ViewGroup) null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup adTuneContainer = (ViewGroup) viewInflate;
        this.c.getClass();
        Intrinsics.checkNotNullParameter(adTuneContainer, "adTuneContainer");
        ExtendedViewContainer extendedViewContainer = (ExtendedViewContainer) adTuneContainer.findViewById(R.id.adtune_content_container);
        if (extendedViewContainer != null) {
            extendedViewContainer.setMeasureSpecProvider(this.d);
        }
        this.c.getClass();
        Intrinsics.checkNotNullParameter(adTuneContainer, "adTuneContainer");
        ViewGroup viewGroup = (ViewGroup) adTuneContainer.findViewById(R.id.adtune_webview_container);
        if (viewGroup != null) {
            viewGroup.addView(this.b);
        }
        return adTuneContainer;
    }

    public mb(Activity context, bc adtuneWebView, ac adtuneViewProvider, qb adtuneMeasureSpecProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adtuneWebView, "adtuneWebView");
        Intrinsics.checkNotNullParameter(adtuneViewProvider, "adtuneViewProvider");
        Intrinsics.checkNotNullParameter(adtuneMeasureSpecProvider, "adtuneMeasureSpecProvider");
        this.f9619a = context;
        this.b = adtuneWebView;
        this.c = adtuneViewProvider;
        this.d = adtuneMeasureSpecProvider;
    }
}
