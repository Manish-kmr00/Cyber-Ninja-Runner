package io.appmetrica.analytics.billingv6.impl;

import com.android.billingclient.api.QueryPurchasesParams;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* JADX INFO: loaded from: classes11.dex */
public final class j extends SafeRunnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f10949a;
    public final /* synthetic */ r b;

    public j(k kVar, r rVar) {
        this.f10949a = kVar;
        this.b = rVar;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        if (this.f10949a.b.isReady()) {
            this.f10949a.b.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType(this.f10949a.f10950a).build(), this.b);
        } else {
            this.f10949a.c.getWorkerExecutor().execute(new i(this.f10949a, this.b));
        }
    }
}
