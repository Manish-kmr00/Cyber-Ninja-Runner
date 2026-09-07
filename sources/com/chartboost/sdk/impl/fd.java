package com.chartboost.sdk.impl;

import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public class fd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hc f1020a;
    public final String b;
    public final h5 c;
    public final String d;

    public fd(View view, h5 h5Var, String str) {
        this.f1020a = new hc(view);
        this.b = view.getClass().getCanonicalName();
        this.c = h5Var;
        this.d = str;
    }

    public String a() {
        return this.d;
    }

    public h5 b() {
        return this.c;
    }

    public hc c() {
        return this.f1020a;
    }

    public String d() {
        return this.b;
    }
}
