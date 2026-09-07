package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10372a;

    public ub(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f10372a = context;
    }

    public final void a(String str) {
        if (str != null) {
            vb vbVar = new vb(this.f10372a);
            Context context = this.f10372a;
            new sb(new tb(vbVar, context, new rb(context, vbVar), new ob()).a(), vbVar).a(str);
        }
    }
}
