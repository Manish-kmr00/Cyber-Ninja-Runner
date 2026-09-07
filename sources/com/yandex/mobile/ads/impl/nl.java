package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class nl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f9738a;
    private final gt b;
    private final ju c;
    private final Context d;

    public nl(Context context, uu1 sdkEnvironmentModule, g60 adPlayer, tw1 videoPlayer, Context applicationContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adPlayer, "adPlayer");
        Intrinsics.checkNotNullParameter(videoPlayer, "videoPlayer");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.f9738a = sdkEnvironmentModule;
        this.b = adPlayer;
        this.c = videoPlayer;
        this.d = applicationContext;
    }

    public final ll a(ViewGroup adViewGroup, List<pb2> friendlyOverlays, bt instreamAd) {
        Intrinsics.checkNotNullParameter(adViewGroup, "adViewGroup");
        Intrinsics.checkNotNullParameter(friendlyOverlays, "friendlyOverlays");
        Intrinsics.checkNotNullParameter(instreamAd, "instreamAd");
        ct ctVar = new ct(this.d, this.f9738a, instreamAd, this.b, this.c);
        return new ll(adViewGroup, friendlyOverlays, ctVar, new WeakReference(adViewGroup), new ql0(ctVar), null);
    }
}
