package com.chartboost.sdk.impl;

import android.content.Context;

/* JADX INFO: loaded from: classes13.dex */
public class rc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1129a;

    public String a() {
        return "1.5.3-Chartboost";
    }

    public final void b(Context context) {
        ld.a(context, "Application Context cannot be null");
    }

    public void c() {
        ld.a();
        bc.a().d();
    }

    public void a(Context context) {
        b(context);
        if (b()) {
            return;
        }
        a(true);
        pd.c().a(context);
        lc.g().a(context);
        ec.a(context);
        vc.a(context);
        ed.a(context);
        md.b().a(context);
        bc.a().a(context);
        qd.b().a(context);
    }

    public boolean b() {
        return this.f1129a;
    }

    public void a(boolean z) {
        this.f1129a = z;
    }
}
