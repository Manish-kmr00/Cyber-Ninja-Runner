package com.chartboost.sdk.impl;

import android.view.View;

/* JADX INFO: loaded from: classes12.dex */
public abstract class p {
    public static p a(q qVar, r rVar) {
        ld.a();
        ld.a(qVar, "AdSessionConfiguration is null");
        ld.a(rVar, "AdSessionContext is null");
        return new zb(qVar, rVar);
    }

    public abstract void a();

    public abstract void a(View view);

    public abstract void a(View view, h5 h5Var, String str);

    public abstract void b();
}
