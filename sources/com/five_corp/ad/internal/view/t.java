package com.five_corp.ad.internal.view;

import android.view.View;

/* JADX INFO: loaded from: classes10.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f1582a;
    public final /* synthetic */ B b;

    public t(B b, View view) {
        this.b = b;
        this.f1582a = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.c.addView(this.f1582a);
    }
}
