package com.smaato.sdk.core.network.interceptors;

import com.smaato.sdk.core.kpi.KpiDBHelper;
import com.smaato.sdk.core.network.Request;

/* JADX INFO: loaded from: classes3.dex */
public class SomaKpiDataInterceptor extends KpiDataInterceptor {
    public SomaKpiDataInterceptor(KpiDBHelper kpiDBHelper) {
        this.kpiDBHelper = kpiDBHelper;
    }

    @Override // com.smaato.sdk.core.network.interceptors.KpiDataInterceptor
    protected String getAdSpaceId(Request request) {
        return request.uri().getQueryParameter("adspace");
    }
}
