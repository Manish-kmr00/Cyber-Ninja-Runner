package io.appmetrica.analytics.impl;

import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;

/* JADX INFO: loaded from: classes7.dex */
public final class Vf implements InstallReferrerStateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC4169hg f11392a;
    public final /* synthetic */ Xf b;

    public Vf(Xf xf, InterfaceC4169hg interfaceC4169hg) {
        this.b = xf;
        this.f11392a = interfaceC4169hg;
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerServiceDisconnected() {
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerSetupFinished(int i) {
        if (i == 0) {
            try {
                ReferrerDetails installReferrer = this.b.f11418a.getInstallReferrer();
                this.b.b.execute(new Uf(this, new C4044cg(installReferrer.getInstallReferrer(), installReferrer.getReferrerClickTimestampSeconds(), installReferrer.getInstallBeginTimestampSeconds(), EnumC4019bg.c)));
            } catch (Throwable th) {
                this.b.b.execute(new Wf(this.f11392a, th));
            }
        } else {
            this.b.b.execute(new Wf(this.f11392a, new IllegalStateException("Referrer check failed with error " + i)));
        }
        try {
            this.b.f11418a.endConnection();
        } catch (Throwable unused) {
        }
    }
}
