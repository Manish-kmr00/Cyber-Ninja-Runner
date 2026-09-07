package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;

/* JADX INFO: loaded from: classes4.dex */
public final class Fh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserProfile f11142a;
    public final /* synthetic */ Yh b;

    public Fh(Yh yh, UserProfile userProfile) {
        this.b = yh;
        this.f11142a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.b;
        Yh.a(yh.f11439a, yh.d, yh.e).reportUserProfile(this.f11142a);
    }
}
