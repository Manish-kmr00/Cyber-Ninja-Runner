package io.appmetrica.analytics.billinginterface.internal.update;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoManager;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public interface UpdatePolicy {
    Map<String, BillingInfo> getBillingInfoToUpdate(BillingConfig billingConfig, Map<String, BillingInfo> map, BillingInfoManager billingInfoManager);
}
