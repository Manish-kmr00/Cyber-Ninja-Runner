package com.ogury.ad.internal;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t7 f7350a;
    public final m1 b;
    public final b0 c;
    public final z d;
    public final k9 e;
    public final e2 f;
    public final d8 g;
    public final g6 h;

    public m(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        t7 t7Var = t7.f7405a;
        m1 m1Var = new m1(context);
        b0 b0Var = new b0(context);
        z zVar = new z(context);
        k9 k9Var = new k9();
        e2 e2Var = e2.f7288a;
        d8 d8Var = new d8(context, i7.AD_SYNC);
        this.f7350a = t7Var;
        this.b = m1Var;
        this.c = b0Var;
        this.d = zVar;
        this.e = k9Var;
        this.f = e2Var;
        this.g = d8Var;
        this.h = g6.f7306a;
    }
}
