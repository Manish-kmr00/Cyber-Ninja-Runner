package io.appmetrica.analytics.billingv6.impl;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PurchasesResponseListener;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes11.dex */
public final class r implements PurchasesResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UtilsProvider f10957a;
    public final Function0 b;
    public final List c;
    public final List d;
    public final g e;

    public r(UtilsProvider utilsProvider, Function0 function0, List list, List list2, g gVar) {
        this.f10957a = utilsProvider;
        this.b = function0;
        this.c = list;
        this.d = list2;
        this.e = gVar;
    }

    @Override // com.android.billingclient.api.PurchasesResponseListener
    public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
        this.f10957a.getWorkerExecutor().execute(new q(this, billingResult, list));
    }
}
