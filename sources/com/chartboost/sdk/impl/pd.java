package com.chartboost.sdk.impl;

import android.content.Context;
import android.os.Handler;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public class pd implements zc.a, sc {
    public static pd f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f1110a = 0.0f;
    public final hd b;
    public final kc c;
    public dd d;
    public tc e;

    public pd(hd hdVar, kc kcVar) {
        this.b = hdVar;
        this.c = kcVar;
    }

    public static pd c() {
        if (f == null) {
            f = new pd(new hd(), new kc());
        }
        return f;
    }

    public final tc a() {
        if (this.e == null) {
            this.e = tc.c();
        }
        return this.e;
    }

    public float b() {
        return this.f1110a;
    }

    public void d() {
        lc.g().a(this);
        lc.g().e();
        ra.h().i();
        this.d.c();
    }

    public void e() {
        ra.h().k();
        lc.g().f();
        this.d.d();
    }

    @Override // com.chartboost.sdk.impl.sc
    public void a(float f2) {
        this.f1110a = f2;
        Iterator<zb> it = a().a().iterator();
        while (it.hasNext()) {
            it.next().f().a(f2);
        }
    }

    public void a(Context context) {
        this.d = this.b.a(new Handler(), context, this.c.a(), this);
    }

    @Override // com.chartboost.sdk.impl.zc.a
    public void a(boolean z) {
        if (z) {
            ra.h().i();
        } else {
            ra.h().g();
        }
    }
}
