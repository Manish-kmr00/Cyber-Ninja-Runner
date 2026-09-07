package io.appmetrica.analytics.impl;

import android.content.Context;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.q5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4382q5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4108f5 f11731a;
    public final C4135g7 b;

    public C4382q5(Context context, C4108f5 c4108f5) {
        this(c4108f5, C4135g7.a(context));
    }

    public final Le a() {
        return new Le(this.b.b(this.f11731a));
    }

    public C4382q5(C4108f5 c4108f5, C4135g7 c4135g7) {
        this.f11731a = c4108f5;
        this.b = c4135g7;
    }
}
