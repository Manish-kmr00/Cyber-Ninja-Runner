package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public abstract class yj<T> implements ch1.b, qo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10743a;
    private final o8<T> b;
    private final ch1 c;

    @Override // com.yandex.mobile.ads.impl.qo
    public final synchronized boolean a() {
        return false;
    }

    public abstract void b();

    public /* synthetic */ yj(Context context, o8 o8Var) {
        this(context, o8Var, ch1.h.a(context));
    }

    protected yj(Context context, o8<T> adResponse, ch1 phoneStateTracker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(phoneStateTracker, "phoneStateTracker");
        this.f10743a = context;
        this.b = adResponse;
        this.c = phoneStateTracker;
    }

    public final Context e() {
        return this.f10743a;
    }

    public final o8<T> d() {
        return this.b;
    }

    protected final boolean f() {
        return !this.c.b();
    }

    public void c() {
        b();
        String str = "onDestroy(), clazz = " + getClass();
        op0.d(new Object[0]);
    }

    public final void g() {
        String str = "registerPhoneStateTracker(), clazz = " + getClass();
        op0.d(new Object[0]);
        this.c.a(this);
    }

    public final void h() {
        String str = "unregisterPhoneStateTracker(), clazz = " + getClass();
        op0.d(new Object[0]);
        this.c.b(this);
    }
}
