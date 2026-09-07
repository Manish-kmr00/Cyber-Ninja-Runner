package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.RemoteException;
import io.appmetrica.analytics.internal.IAppMetricaService;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ui, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4494ui extends AbstractCallableC4369ph {
    public final C4367pf e;

    public C4494ui(C4178i0 c4178i0, Ck ck, C4367pf c4367pf) {
        super(c4178i0, ck);
        this.e = c4367pf;
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC4369ph
    public final void a(IAppMetricaService iAppMetricaService) throws RemoteException {
        Bundle bundle = new Bundle();
        C4367pf c4367pf = this.e;
        synchronized (c4367pf) {
            bundle.putParcelable("PROCESS_CFG_OBJ", c4367pf);
        }
        iAppMetricaService.resumeUserSession(bundle);
    }
}
