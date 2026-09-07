package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.network.C3126b;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.flow.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3107l implements IAConfigManager.OnConfigurationReadyAndValidListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveAdRequest f1804a;
    public final /* synthetic */ C3108m b;

    public C3107l(C3108m c3108m, InneractiveAdRequest inneractiveAdRequest) {
        this.b = c3108m;
        this.f1804a = inneractiveAdRequest;
    }

    @Override // com.fyber.inneractive.sdk.config.IAConfigManager.OnConfigurationReadyAndValidListener
    public final void onConfigurationReadyAndValid(IAConfigManager iAConfigManager, boolean z, Exception exc) {
        IAConfigManager.removeListener(this);
        if (z) {
            this.b.c(this.f1804a);
            return;
        }
        InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(exc instanceof C3126b ? InneractiveErrorCode.CONNECTION_ERROR : InneractiveErrorCode.SDK_NOT_INITIALIZED_OR_CONFIG_ERROR, EnumC3104i.NO_APP_CONFIG_AVAILABLE, exc);
        C3108m c3108m = this.b;
        c3108m.a(this.f1804a, c3108m.c(), inneractiveInfrastructureError);
    }
}
