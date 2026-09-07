package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.RemoteException;
import io.appmetrica.analytics.internal.IAppMetricaService;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.kn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4250kn extends AbstractCallableC4369ph {
    public final int e;
    public final Bundle f;

    public C4250kn(C4178i0 c4178i0, Ck ck, int i, Bundle bundle) {
        super(c4178i0, ck);
        this.e = i;
        this.f = bundle;
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC4369ph
    public final void a(IAppMetricaService iAppMetricaService) throws RemoteException {
        iAppMetricaService.reportData(this.e, this.f);
    }
}
