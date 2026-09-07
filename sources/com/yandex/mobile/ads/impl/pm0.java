package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class pm0 implements wp1<ci2>, vl0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f9939a;
    private final vl0 b;
    private final p40 c;
    private final Context d;

    public interface a {
        void a(bt btVar);

        void a(String str);
    }

    @Override // com.yandex.mobile.ads.impl.wp1
    public final void a(kb2 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f9939a.a(error.a());
    }

    public /* synthetic */ pm0(Context context, uu1 uu1Var, xb2 xb2Var, rm0 rm0Var) {
        this(context, uu1Var, xb2Var, rm0Var, new vl0(uu1Var, xb2Var), new p40());
    }

    public pm0(Context context, uu1 sdkEnvironmentModule, xb2 videoAdLoader, rm0 instreamAdLoadListener, vl0 adBreaksLoadingManager, p40 duplicatedInstreamAdBreaksFilter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(videoAdLoader, "videoAdLoader");
        Intrinsics.checkNotNullParameter(instreamAdLoadListener, "instreamAdLoadListener");
        Intrinsics.checkNotNullParameter(adBreaksLoadingManager, "adBreaksLoadingManager");
        Intrinsics.checkNotNullParameter(duplicatedInstreamAdBreaksFilter, "duplicatedInstreamAdBreaksFilter");
        this.f9939a = instreamAdLoadListener;
        this.b = adBreaksLoadingManager;
        this.c = duplicatedInstreamAdBreaksFilter;
        this.d = context.getApplicationContext();
    }

    @Override // com.yandex.mobile.ads.impl.vl0.a
    public final void a(ArrayList adBreaks) {
        Intrinsics.checkNotNullParameter(adBreaks, "adBreaks");
        this.c.getClass();
        ArrayList arrayListA = p40.a(adBreaks);
        if (!arrayListA.isEmpty()) {
            this.f9939a.a(new bt(arrayListA));
        } else {
            this.f9939a.a("Received response with no ad breaks");
        }
    }

    @Override // com.yandex.mobile.ads.impl.wp1
    public final void a(ci2 ci2Var) {
        ci2 vmap = ci2Var;
        Intrinsics.checkNotNullParameter(vmap, "vmap");
        List<p2> listA = vmap.a();
        ArrayList arrayList = new ArrayList();
        for (p2 p2Var : listA) {
            if (p2Var.d().contains("linear")) {
                arrayList.add(p2Var);
            }
        }
        if (!arrayList.isEmpty()) {
            vl0 vl0Var = this.b;
            Context context = this.d;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            vl0Var.a(context, arrayList, this);
            return;
        }
        this.f9939a.a("Received response with no ad breaks");
    }
}
