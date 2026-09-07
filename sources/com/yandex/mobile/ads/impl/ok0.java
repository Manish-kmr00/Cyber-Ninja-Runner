package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class ok0 {
    public static nk0 a(Context context, nk0.a impressionListener, qk0 impressionReporter, s4 adIdStorageManager, mk0 eventsObservable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(impressionListener, "impressionListener");
        Intrinsics.checkNotNullParameter(impressionReporter, "impressionReporter");
        Intrinsics.checkNotNullParameter(adIdStorageManager, "adIdStorageManager");
        Intrinsics.checkNotNullParameter(eventsObservable, "eventsObservable");
        nk0 nk0Var = new nk0(context, impressionListener, impressionReporter, adIdStorageManager, new pk0(impressionReporter));
        eventsObservable.b(nk0Var);
        eventsObservable.a(nk0Var);
        eventsObservable.c(nk0Var);
        eventsObservable.a((n11) nk0Var);
        return nk0Var;
    }
}
