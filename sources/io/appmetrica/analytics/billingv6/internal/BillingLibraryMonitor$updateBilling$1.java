package io.appmetrica.analytics.billingv6.internal;

import com.android.billingclient.api.BillingClient;
import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoManager;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender;
import io.appmetrica.analytics.billinginterface.internal.update.UpdatePolicy;
import io.appmetrica.analytics.billingv6.impl.d;
import io.appmetrica.analytics.billingv6.impl.g;
import io.appmetrica.analytics.billingv6.impl.s;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import java.util.concurrent.Executor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"io/appmetrica/analytics/billingv6/internal/BillingLibraryMonitor$updateBilling$1", "Lio/appmetrica/analytics/coreutils/internal/executors/SafeRunnable;", "", "runSafety", "billing-v6_release"}, k = 1, mv = {1, 6, 0})
public final class BillingLibraryMonitor$updateBilling$1 extends SafeRunnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BillingLibraryMonitor f10960a;
    final /* synthetic */ BillingConfig b;

    BillingLibraryMonitor$updateBilling$1(BillingLibraryMonitor billingLibraryMonitor, BillingConfig billingConfig) {
        this.f10960a = billingLibraryMonitor;
        this.b = billingConfig;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [io.appmetrica.analytics.billingv6.internal.BillingLibraryMonitor$updateBilling$1$runSafety$1] */
    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public void runSafety() {
        BillingClient billingClientBuild = BillingClient.newBuilder(this.f10960a.f10959a).setListener(new s()).enablePendingPurchases().build();
        BillingConfig billingConfig = this.b;
        final BillingLibraryMonitor billingLibraryMonitor = this.f10960a;
        ?? r3 = new UtilsProvider() { // from class: io.appmetrica.analytics.billingv6.internal.BillingLibraryMonitor$updateBilling$1$runSafety$1
            @Override // io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider
            public BillingInfoManager getBillingInfoManager() {
                return billingLibraryMonitor.e;
            }

            @Override // io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider
            public BillingInfoSender getBillingInfoSender() {
                return billingLibraryMonitor.d;
            }

            @Override // io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider
            public Executor getUiExecutor() {
                return billingLibraryMonitor.c;
            }

            @Override // io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider
            public UpdatePolicy getUpdatePolicy() {
                return billingLibraryMonitor.f;
            }

            @Override // io.appmetrica.analytics.billinginterface.internal.library.UtilsProvider
            public Executor getWorkerExecutor() {
                return billingLibraryMonitor.b;
            }
        };
        billingClientBuild.startConnection(new d(billingConfig, billingClientBuild, r3, new g(billingClientBuild, r3)));
    }
}
