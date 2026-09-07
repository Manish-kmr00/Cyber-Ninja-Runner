package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class es {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qp f8824a;

    public es(qp closeButtonControllerProvider) {
        Intrinsics.checkNotNullParameter(closeButtonControllerProvider, "closeButtonControllerProvider");
        this.f8824a = closeButtonControllerProvider;
    }

    public final ds a(FrameLayout closeButton, o8 adResponse, aw debugEventsReporter, boolean z, boolean z2) {
        pp izVar;
        Intrinsics.checkNotNullParameter(closeButton, "closeButton");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(debugEventsReporter, "debugEventsReporter");
        this.f8824a.getClass();
        Intrinsics.checkNotNullParameter(closeButton, "closeButton");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(debugEventsReporter, "debugEventsReporter");
        Long lU = adResponse.u();
        if (z && lU == null) {
            izVar = new f21(closeButton, new r82(), new Handler(Looper.getMainLooper()));
        } else {
            izVar = new iz(closeButton, new vh2(), debugEventsReporter, lU != null ? lU.longValue() : 0L, new yp());
        }
        return z2 ? new yc0(izVar) : new nb0(izVar);
    }
}
