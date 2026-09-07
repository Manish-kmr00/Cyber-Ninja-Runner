package io.appmetrica.analytics.billingv6.impl;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetailsResponseListener;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes11.dex */
public final class k implements ProductDetailsResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10950a;
    public final BillingClient b;
    public final UtilsProvider c;
    public final Function0 d;
    public final List e;
    public final g f;

    public k(String str, BillingClient billingClient, UtilsProvider utilsProvider, m mVar, List list, g gVar) {
        this.f10950a = str;
        this.b = billingClient;
        this.c = utilsProvider;
        this.d = mVar;
        this.e = list;
        this.f = gVar;
    }

    @Override // com.android.billingclient.api.ProductDetailsResponseListener
    public final void onProductDetailsResponse(BillingResult billingResult, List list) {
        this.c.getWorkerExecutor().execute(new h(this, billingResult, list));
    }
}
