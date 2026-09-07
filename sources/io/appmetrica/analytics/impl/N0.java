package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;

/* JADX INFO: loaded from: classes5.dex */
public final class N0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserProfile f11262a;
    public final /* synthetic */ C4278m1 b;

    public N0(C4278m1 c4278m1, UserProfile userProfile) {
        this.b = c4278m1;
        this.f11262a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4278m1.a(this.b).reportUserProfile(this.f11262a);
    }
}
