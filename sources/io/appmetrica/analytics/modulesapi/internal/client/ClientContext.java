package io.appmetrica.analytics.modulesapi.internal.client;

import android.content.Context;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext;
import io.appmetrica.analytics.modulesapi.internal.common.InternalClientModuleFacade;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/appmetrica/analytics/modulesapi/internal/client/ClientContext;", "", "clientStorageProvider", "Lio/appmetrica/analytics/modulesapi/internal/client/ClientStorageProvider;", "getClientStorageProvider", "()Lio/appmetrica/analytics/modulesapi/internal/client/ClientStorageProvider;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "internalClientModuleFacade", "Lio/appmetrica/analytics/modulesapi/internal/common/InternalClientModuleFacade;", "getInternalClientModuleFacade", "()Lio/appmetrica/analytics/modulesapi/internal/common/InternalClientModuleFacade;", "moduleAdRevenueContext", "Lio/appmetrica/analytics/modulesapi/internal/client/adrevenue/ModuleAdRevenueContext;", "getModuleAdRevenueContext", "()Lio/appmetrica/analytics/modulesapi/internal/client/adrevenue/ModuleAdRevenueContext;", "modules-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ClientContext {
    ClientStorageProvider getClientStorageProvider();

    Context getContext();

    InternalClientModuleFacade getInternalClientModuleFacade();

    ModuleAdRevenueContext getModuleAdRevenueContext();
}
