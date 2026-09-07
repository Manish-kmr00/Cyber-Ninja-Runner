package com.ogury.ad.internal;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f7314a;
    public final z b;
    public final k9 c;
    public final d8 d;

    public h4(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        b0 b0Var = new b0(context);
        z zVar = new z(context);
        k9 k9Var = new k9();
        d8 d8Var = new d8(context, i7.TRACKERS);
        this.f7314a = b0Var;
        this.b = zVar;
        this.c = k9Var;
        this.d = d8Var;
    }
}
