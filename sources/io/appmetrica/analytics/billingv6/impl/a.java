package io.appmetrica.analytics.billingv6.impl;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends SafeRunnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f10940a;
    public final /* synthetic */ BillingResult b;

    public a(d dVar, BillingResult billingResult) {
        this.f10940a = dVar;
        this.b = billingResult;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        d dVar = this.f10940a;
        BillingResult billingResult = this.b;
        dVar.getClass();
        if (billingResult.getResponseCode() != 0) {
            return;
        }
        for (String str : CollectionsKt.listOf((Object[]) new String[]{"inapp", "subs"})) {
            BillingConfig billingConfig = dVar.f10943a;
            BillingClient billingClient = dVar.b;
            UtilsProvider utilsProvider = dVar.c;
            g gVar = dVar.d;
            p pVar = new p(billingConfig, billingClient, utilsProvider, str, gVar);
            gVar.c.add(pVar);
            dVar.c.getUiExecutor().execute(new c(dVar, str, pVar));
        }
    }
}
