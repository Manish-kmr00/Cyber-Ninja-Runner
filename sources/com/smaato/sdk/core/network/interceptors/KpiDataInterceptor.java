package com.smaato.sdk.core.network.interceptors;

import android.net.Uri;
import com.smaato.sdk.core.kpi.KpiDBHelper;
import com.smaato.sdk.core.kpi.KpiData;
import com.smaato.sdk.core.network.Interceptor;
import com.smaato.sdk.core.network.Request;
import com.smaato.sdk.core.network.Response;

/* JADX INFO: loaded from: classes3.dex */
public abstract class KpiDataInterceptor implements Interceptor {
    protected KpiDBHelper kpiDBHelper;

    protected abstract String getAdSpaceId(Request request);

    @Override // com.smaato.sdk.core.network.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        Request request = chain.request();
        Uri.Builder builderBuildUpon = request.uri().buildUpon();
        String adSpaceId = getAdSpaceId(request);
        if (adSpaceId == null) {
            throw new IllegalArgumentException("adspace id is null");
        }
        fillKpiData(builderBuildUpon, adSpaceId);
        this.kpiDBHelper.incrementAdRequestCount(adSpaceId);
        try {
            Response responseProceed = chain.proceed(request.buildUpon().uri(builderBuildUpon.build()).build());
            this.kpiDBHelper.updateFillAndFillRate(adSpaceId, responseProceed.responseCode() == 200);
            return responseProceed;
        } catch (Exception e) {
            this.kpiDBHelper.updateFillAndFillRate(adSpaceId, false);
            throw e;
        }
    }

    private void fillKpiData(Uri.Builder builder, String str) {
        KpiData kpiValuesForAdSpace = this.kpiDBHelper.getKpiValuesForAdSpace(str);
        if (kpiValuesForAdSpace != null) {
            builder.appendQueryParameter("asfr", kpiValuesForAdSpace.getRollingFillRatePerAdSpace());
            builder.appendQueryParameter("appfr", kpiValuesForAdSpace.getTotalFillRate());
            builder.appendQueryParameter("totalreq", kpiValuesForAdSpace.getTotalAdRequests());
            builder.appendQueryParameter("session_depth", kpiValuesForAdSpace.getSessionDepthPerAdSpace());
        }
    }
}
