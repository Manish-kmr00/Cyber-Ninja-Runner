package com.yandex.mobile.ads.impl;

import android.os.SystemClock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class r80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final et0 f10082a;

    public r80(et0 mainThreadHandler) {
        Intrinsics.checkNotNullParameter(mainThreadHandler, "mainThreadHandler");
        this.f10082a = mainThreadHandler;
    }

    public final void a(final Function0<Unit> successCallback) {
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f10082a.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.r80$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                r80.a(jElapsedRealtime, successCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(long j, Function0 successCallback) {
        Intrinsics.checkNotNullParameter(successCallback, "$successCallback");
        if (SystemClock.elapsedRealtime() - j <= 5000) {
            successCallback.invoke();
        }
    }
}
