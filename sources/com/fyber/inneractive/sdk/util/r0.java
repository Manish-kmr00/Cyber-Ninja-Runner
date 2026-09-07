package com.fyber.inneractive.sdk.util;

/* JADX INFO: loaded from: classes5.dex */
public final class r0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2375a;
    public final /* synthetic */ u0 b;

    public r0(u0 u0Var, String str) {
        this.b = u0Var;
        this.f2375a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.c.getSharedPreferences("fyber.ua", 0).edit().putString("ua", this.f2375a).apply();
    }
}
