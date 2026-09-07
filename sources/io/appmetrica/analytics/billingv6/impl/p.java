package io.appmetrica.analytics.billingv6.impl;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PurchaseHistoryResponseListener;
import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class p implements PurchaseHistoryResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BillingConfig f10955a;
    public final BillingClient b;
    public final UtilsProvider c;
    public final String d;
    public final g e;

    public p(BillingConfig billingConfig, BillingClient billingClient, UtilsProvider utilsProvider, String str, g gVar) {
        this.f10955a = billingConfig;
        this.b = billingClient;
        this.c = utilsProvider;
        this.d = str;
        this.e = gVar;
    }

    @Override // com.android.billingclient.api.PurchaseHistoryResponseListener
    public final void onPurchaseHistoryResponse(BillingResult billingResult, List list) {
        this.c.getWorkerExecutor().execute(new l(this, billingResult, list));
    }
}
