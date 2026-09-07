package io.appmetrica.analytics.impl;

import android.content.Intent;

/* JADX INFO: loaded from: classes4.dex */
public final class H1 implements O1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I1 f11170a;

    public H1(I1 i1) {
        this.f11170a = i1;
    }

    @Override // io.appmetrica.analytics.impl.O1
    public final void a(Intent intent) {
        this.f11170a.getClass();
        C4486ua.E.u().a(AbstractC4288mb.e(intent.getStringExtra("screen_size")));
    }
}
