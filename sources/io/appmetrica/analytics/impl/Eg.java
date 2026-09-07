package io.appmetrica.analytics.impl;

import android.os.RemoteException;
import io.appmetrica.analytics.internal.IAppMetricaService;

/* JADX INFO: loaded from: classes5.dex */
public class Eg extends AbstractCallableC4369ph {
    public final C4319nh e;

    public Eg(C4178i0 c4178i0, Ck ck, C4319nh c4319nh) {
        super(c4178i0, ck);
        this.e = c4319nh;
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC4369ph
    public final void a(Throwable th) {
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC4369ph
    public final void a(IAppMetricaService iAppMetricaService) throws RemoteException {
        C4319nh c4319nh = this.e;
        iAppMetricaService.reportData(c4319nh.c, c4319nh.f11686a.d(c4319nh.e.c()));
    }
}
