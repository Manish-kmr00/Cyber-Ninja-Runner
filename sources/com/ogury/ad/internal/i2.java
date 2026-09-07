package com.ogury.ad.internal;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7319a;
    public final c5 b;

    public i2(Context context, c5 mraidViewCommands) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mraidViewCommands, "mraidViewCommands");
        this.f7319a = context;
        this.b = mraidViewCommands;
    }

    public final j2 a(d5 mraidWebView) {
        Intrinsics.checkNotNullParameter(mraidWebView, "mraidWebView");
        Context context = this.f7319a;
        n4 mraidCommandExecutor = mraidWebView.getMraidCommandExecutor();
        c5 c5Var = this.b;
        v4 v4Var = v4.f7421a;
        j2 j2Var = new j2(context, mraidCommandExecutor, c5Var, u7.i.a(this.f7319a), new b0(this.f7319a), new z(this.f7319a));
        j2Var.k = null;
        return j2Var;
    }
}
