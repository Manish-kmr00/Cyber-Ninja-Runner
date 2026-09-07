package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class rt0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final st0 f10138a;

    public rt0(Context context, wm2 sdkEnvironmentModule, bt instreamAd) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(instreamAd, "instreamAd");
        this.f10138a = new st0(context, sdkEnvironmentModule, instreamAd);
    }

    public final qt0<T> a(lt0<T> manualAdBreakFactory, String str) {
        Intrinsics.checkNotNullParameter(manualAdBreakFactory, "manualAdBreakFactory");
        ArrayList arrayListA = this.f10138a.a(str);
        ArrayDeque arrayDeque = new ArrayDeque();
        Iterator it = arrayListA.iterator();
        while (it.hasNext()) {
            arrayDeque.add(manualAdBreakFactory.a((mt0) it.next()));
        }
        return new qt0<>(arrayDeque);
    }
}
