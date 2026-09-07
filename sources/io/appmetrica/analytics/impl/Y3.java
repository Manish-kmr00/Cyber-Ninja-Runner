package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;

/* JADX INFO: loaded from: classes7.dex */
public final class Y3 extends SimpleThreadSafeToggle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Oe f11429a;

    public Y3(Oe oe) {
        super(oe.e(), "[ClientApiTrackingStatusToggle]");
        this.f11429a = oe;
    }

    public final void a(boolean z) {
        updateState(z);
        this.f11429a.f(z);
    }
}
