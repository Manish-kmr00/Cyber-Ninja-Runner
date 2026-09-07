package com.yandex.mobile.ads.impl;

import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public abstract class b9 {
    public static mn2 a(c9 c9Var, d9 d9Var) {
        if (ue1.a()) {
            return new mn2(c9Var, d9Var);
        }
        throw new IllegalStateException("Method called before OM SDK activation");
    }

    public abstract void a();

    public abstract void a(View view);

    public abstract void a(View view, rc0 rc0Var, String str);

    public abstract void b();
}
