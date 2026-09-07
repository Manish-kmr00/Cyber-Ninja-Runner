package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class l61 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f61 f9483a;
    private final Handler b;
    private final i5 c;
    private st d;
    private yt e;
    private hu f;

    public l61(Context context, o3 adConfiguration, g5 adLoadingPhasesManager, f61 nativeAdLoadingFinishedListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(nativeAdLoadingFinishedListener, "nativeAdLoadingFinishedListener");
        this.f9483a = nativeAdLoadingFinishedListener;
        this.b = new Handler(Looper.getMainLooper());
        this.c = new i5(context, adConfiguration, adLoadingPhasesManager);
    }

    public final void b(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        a(error);
    }

    public final void a() {
        this.b.removeCallbacksAndMessages(null);
    }

    private final void a(final w3 w3Var) {
        this.c.a(w3Var.c());
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.l61$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                l61.a(this.f$0, w3Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(l61 this$0, w3 error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        st stVar = this$0.d;
        if (stVar != null) {
            stVar.a(error);
        }
        yt ytVar = this$0.e;
        if (ytVar != null) {
            ytVar.a(error);
        }
        hu huVar = this$0.f;
        if (huVar != null) {
            huVar.a(error);
        }
        this$0.f9483a.a();
    }

    public final void a(final m61 nativeAd) {
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        a4.a(qs.g.a());
        this.c.a();
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.l61$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                l61.a(this.f$0, nativeAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(l61 this$0, m61 nativeAd) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(nativeAd, "$nativeAd");
        st stVar = this$0.d;
        if (stVar != null) {
            if (nativeAd instanceof p91) {
                stVar.b(nativeAd);
            } else {
                stVar.a(nativeAd);
            }
        }
        this$0.f9483a.a();
    }

    public final void a(final ArrayList nativeAds) {
        Intrinsics.checkNotNullParameter(nativeAds, "nativeAds");
        a4.a(qs.g.a());
        this.c.a();
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.l61$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                l61.a(this.f$0, nativeAds);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(l61 this$0, List nativeAds) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(nativeAds, "$nativeAds");
        yt ytVar = this$0.e;
        if (ytVar != null) {
            ytVar.onAdsLoaded(nativeAds);
        }
        this$0.f9483a.a();
    }

    public final void a(final g81 sliderAd) {
        Intrinsics.checkNotNullParameter(sliderAd, "sliderAd");
        a4.a(qs.g.a());
        this.c.a();
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.l61$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                l61.a(this.f$0, sliderAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(l61 this$0, uz1 sliderAd) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sliderAd, "$sliderAd");
        hu huVar = this$0.f;
        if (huVar != null) {
            huVar.a(sliderAd);
        }
        this$0.f9483a.a();
    }

    public final void a(o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        this.c.a(new y7(adConfiguration));
    }

    public final void a(st stVar) {
        this.d = stVar;
        this.c.a(stVar, this.e, this.f);
    }

    public final void a(yt ytVar) {
        this.e = ytVar;
        this.c.a(this.d, ytVar, this.f);
    }

    public final void a(z61 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.c.a(reportParameterManager);
    }

    public final void a(hu huVar) {
        this.f = huVar;
        this.c.a(this.d, this.e, huVar);
    }
}
