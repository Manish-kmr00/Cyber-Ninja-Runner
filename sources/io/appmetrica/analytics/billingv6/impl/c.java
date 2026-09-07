package io.appmetrica.analytics.billingv6.impl;

import com.android.billingclient.api.QueryPurchaseHistoryParams;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* JADX INFO: loaded from: classes11.dex */
public final class c extends SafeRunnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f10942a;
    public final /* synthetic */ String b;
    public final /* synthetic */ p c;

    public c(d dVar, String str, p pVar) {
        this.f10942a = dVar;
        this.b = str;
        this.c = pVar;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        if (this.f10942a.b.isReady()) {
            this.f10942a.b.queryPurchaseHistoryAsync(QueryPurchaseHistoryParams.newBuilder().setProductType(this.b).build(), this.c);
        } else {
            this.f10942a.c.getWorkerExecutor().execute(new b(this.f10942a, this.c));
        }
    }
}
