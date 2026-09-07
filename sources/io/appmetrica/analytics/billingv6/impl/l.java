package io.appmetrica.analytics.billingv6.impl;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PurchaseHistoryRecord;
import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class l extends SafeRunnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f10951a;
    public final /* synthetic */ BillingResult b;
    public final /* synthetic */ List c;

    public l(p pVar, BillingResult billingResult, List list) {
        this.f10951a = pVar;
        this.b = billingResult;
        this.c = list;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        p pVar = this.f10951a;
        BillingResult billingResult = this.b;
        List<PurchaseHistoryRecord> list = this.c;
        pVar.getClass();
        if (billingResult.getResponseCode() == 0 && list != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (PurchaseHistoryRecord purchaseHistoryRecord : list) {
                for (String str : purchaseHistoryRecord.getProducts()) {
                    String str2 = pVar.d;
                    BillingInfo billingInfo = new BillingInfo(Intrinsics.areEqual(str2, "inapp") ? ProductType.INAPP : Intrinsics.areEqual(str2, "subs") ? ProductType.SUBS : ProductType.UNKNOWN, str, purchaseHistoryRecord.getPurchaseToken(), purchaseHistoryRecord.getPurchaseTime(), 0L);
                    linkedHashMap.put(billingInfo.productId, billingInfo);
                }
            }
            Map<String, BillingInfo> billingInfoToUpdate = pVar.c.getUpdatePolicy().getBillingInfoToUpdate(pVar.f10955a, linkedHashMap, pVar.c.getBillingInfoManager());
            if (billingInfoToUpdate.isEmpty()) {
                t.a(linkedHashMap, billingInfoToUpdate, pVar.d, pVar.c.getBillingInfoManager());
            } else {
                List list2 = CollectionsKt.toList(billingInfoToUpdate.keySet());
                m mVar = new m(linkedHashMap, billingInfoToUpdate, pVar);
                String str3 = pVar.d;
                BillingClient billingClient = pVar.b;
                UtilsProvider utilsProvider = pVar.c;
                g gVar = pVar.e;
                k kVar = new k(str3, billingClient, utilsProvider, mVar, list, gVar);
                gVar.c.add(kVar);
                pVar.c.getUiExecutor().execute(new o(pVar, list2, kVar));
            }
        }
        p pVar2 = this.f10951a;
        pVar2.e.a(pVar2);
    }
}
