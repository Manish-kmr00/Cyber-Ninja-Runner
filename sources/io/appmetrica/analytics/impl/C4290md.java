package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.md, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4290md extends SafeRunnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4315nd f11671a;
    public final /* synthetic */ String b;
    public final /* synthetic */ byte[] c;

    public C4290md(C4315nd c4315nd, String str, byte[] bArr) {
        this.f11671a = c4315nd;
        this.b = str;
        this.c = bArr;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C4315nd.a(this.f11671a).setSessionExtra(this.b, this.c);
    }
}
