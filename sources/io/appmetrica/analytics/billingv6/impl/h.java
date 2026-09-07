package io.appmetrica.analytics.billingv6.impl;

import com.android.billingclient.api.BillingResult;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes11.dex */
public final class h extends SafeRunnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f10947a;
    public final /* synthetic */ BillingResult b;
    public final /* synthetic */ List c;

    public h(k kVar, BillingResult billingResult, List list) {
        this.f10947a = kVar;
        this.b = billingResult;
        this.c = list;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        k kVar = this.f10947a;
        BillingResult billingResult = this.b;
        List list = this.c;
        kVar.getClass();
        if (billingResult.getResponseCode() == 0 && !list.isEmpty()) {
            UtilsProvider utilsProvider = kVar.c;
            Function0 function0 = kVar.d;
            List list2 = kVar.e;
            g gVar = kVar.f;
            r rVar = new r(utilsProvider, function0, list2, list, gVar);
            gVar.c.add(rVar);
            kVar.c.getUiExecutor().execute(new j(kVar, rVar));
        }
        k kVar2 = this.f10947a;
        kVar2.f.a(kVar2);
    }
}
