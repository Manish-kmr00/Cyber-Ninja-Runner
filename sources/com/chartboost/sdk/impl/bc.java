package com.chartboost.sdk.impl;

import android.content.Context;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class bc implements zc.a {
    public static bc f = new bc(new zc());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public id f979a = new id();
    public Date b;
    public boolean c;
    public zc d;
    public boolean e;

    public bc(zc zcVar) {
        this.d = zcVar;
    }

    public static bc a() {
        return f;
    }

    public Date b() {
        Date date = this.b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public final void c() {
        if (!this.c || this.b == null) {
            return;
        }
        Iterator<zb> it = tc.c().a().iterator();
        while (it.hasNext()) {
            it.next().f().a(b());
        }
    }

    public void d() {
        Date dateA = this.f979a.a();
        Date date = this.b;
        if (date == null || dateA.after(date)) {
            this.b = dateA;
            c();
        }
    }

    public void a(Context context) {
        if (this.c) {
            return;
        }
        this.d.a(context);
        this.d.a(this);
        this.d.e();
        this.e = this.d.c();
        this.c = true;
    }

    @Override // com.chartboost.sdk.impl.zc.a
    public void a(boolean z) {
        if (!this.e && z) {
            d();
        }
        this.e = z;
    }
}
