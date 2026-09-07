package io.appmetrica.analytics.billinginterface.internal.library;

import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoManager;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender;
import io.appmetrica.analytics.billinginterface.internal.update.UpdatePolicy;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes8.dex */
public interface UtilsProvider {
    BillingInfoManager getBillingInfoManager();

    BillingInfoSender getBillingInfoSender();

    Executor getUiExecutor();

    UpdatePolicy getUpdatePolicy();

    Executor getWorkerExecutor();
}
