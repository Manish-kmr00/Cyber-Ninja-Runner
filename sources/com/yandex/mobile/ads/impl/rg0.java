package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class rg0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v9 f10104a;

    public final void a(String url, o8 adResponse, u1 handler) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(handler, "handler");
        List<String> listT = adResponse.t();
        if (listT != null) {
            Iterator<T> it = listT.iterator();
            while (it.hasNext()) {
                this.f10104a.a((String) it.next(), s62.d);
            }
        }
        this.f10104a.a(url, adResponse, handler);
    }

    public /* synthetic */ rg0(Context context, o3 o3Var) {
        this(context, o3Var, new v9(context, o3Var));
    }

    public rg0(Context context, o3 adConfiguration, v9 adTracker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adTracker, "adTracker");
        this.f10104a = adTracker;
    }
}
