package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class q01 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9969a;
    private final z2 b;
    private final gm0 c;
    private final vm0 d;
    private final zm0 e;
    private final io0 f;
    private final LinkedHashMap g;

    public q01(Context context, z2 adBreakStatusController, gm0 instreamAdPlayerController, vm0 instreamAdUiElementsManager, zm0 instreamAdViewsHolderManager, io0 adCreativePlaybackEventListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adBreakStatusController, "adBreakStatusController");
        Intrinsics.checkNotNullParameter(instreamAdPlayerController, "instreamAdPlayerController");
        Intrinsics.checkNotNullParameter(instreamAdUiElementsManager, "instreamAdUiElementsManager");
        Intrinsics.checkNotNullParameter(instreamAdViewsHolderManager, "instreamAdViewsHolderManager");
        Intrinsics.checkNotNullParameter(adCreativePlaybackEventListener, "adCreativePlaybackEventListener");
        this.f9969a = context;
        this.b = adBreakStatusController;
        this.c = instreamAdPlayerController;
        this.d = instreamAdUiElementsManager;
        this.e = instreamAdViewsHolderManager;
        this.f = adCreativePlaybackEventListener;
        this.g = new LinkedHashMap();
    }

    public final u2 a(dt adBreak) {
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        LinkedHashMap linkedHashMap = this.g;
        Object obj = linkedHashMap.get(adBreak);
        Object obj2 = obj;
        if (obj == null) {
            Context applicationContext = this.f9969a.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            u2 u2Var = new u2(applicationContext, adBreak, this.c, this.d, this.e, this.b);
            u2Var.a(this.f);
            linkedHashMap.put(adBreak, u2Var);
            obj2 = u2Var;
        }
        return (u2) obj2;
    }
}
