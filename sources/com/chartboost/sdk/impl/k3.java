package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.internal.Networking.EndpointRepository;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b#\u0010$J\u001f\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0007\u0010\rJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0007\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/chartboost/sdk/impl/k3;", "Lcom/chartboost/sdk/impl/i2$a;", "Lcom/chartboost/sdk/impl/l3;", "callback", "Lcom/chartboost/sdk/impl/j3;", "params", "", "a", "(Lcom/chartboost/sdk/impl/l3;Lcom/chartboost/sdk/impl/j3;)V", "Lcom/chartboost/sdk/impl/i2;", "request", "Lorg/json/JSONObject;", "response", "(Lcom/chartboost/sdk/impl/i2;Lorg/json/JSONObject;)V", "Lcom/chartboost/sdk/internal/Model/CBError;", "error", "(Lcom/chartboost/sdk/impl/i2;Lcom/chartboost/sdk/internal/Model/CBError;)V", "(Lcom/chartboost/sdk/impl/i2;Lcom/chartboost/sdk/impl/j3;)V", "Lcom/chartboost/sdk/impl/g2;", "Lcom/chartboost/sdk/impl/g2;", "networkService", "Lcom/chartboost/sdk/impl/d9;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/d9;", "requestBodyBuilder", "Lcom/chartboost/sdk/impl/l4;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/l4;", "eventTracker", "Lcom/chartboost/sdk/internal/Networking/EndpointRepository;", "d", "Lcom/chartboost/sdk/internal/Networking/EndpointRepository;", "endpointRepository", "e", "Lcom/chartboost/sdk/impl/l3;", "<init>", "(Lcom/chartboost/sdk/impl/g2;Lcom/chartboost/sdk/impl/d9;Lcom/chartboost/sdk/impl/l4;Lcom/chartboost/sdk/internal/Networking/EndpointRepository;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class k3 implements i2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final g2 networkService;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final d9 requestBodyBuilder;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final l4 eventTracker;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final EndpointRepository endpointRepository;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public l3 callback;

    public k3(g2 networkService, d9 requestBodyBuilder, l4 eventTracker, EndpointRepository endpointRepository) {
        Intrinsics.checkNotNullParameter(networkService, "networkService");
        Intrinsics.checkNotNullParameter(requestBodyBuilder, "requestBodyBuilder");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(endpointRepository, "endpointRepository");
        this.networkService = networkService;
        this.requestBodyBuilder = requestBodyBuilder;
        this.eventTracker = eventTracker;
        this.endpointRepository = endpointRepository;
    }

    public final void a(i2 request, j3 params) {
        request.a("location", params.getLocation());
        request.a("reward", Integer.valueOf(params.getCom.ironsource.mediationsdk.utils.IronSourceConstants.EVENTS_REWARD_AMOUNT java.lang.String()));
        request.a("currency-name", params.getRewardCurrency());
        request.a(CreativeInfo.c, params.getAdId());
        request.a("force_close", Boolean.FALSE);
        request.a("cgn", params.getCgn());
        if (params.getVideoPostion() == null || params.getVideoDuration() == null) {
            return;
        }
        float f = 1000;
        request.a("total_time", Float.valueOf(params.getVideoDuration().floatValue() / f));
        request.a("playback_time", Float.valueOf(params.getVideoPostion().floatValue() / f));
        b7.a("TotalDuration: " + params.getVideoDuration() + " PlaybackTime: " + params.getVideoPostion(), (Throwable) null, 2, (Object) null);
    }

    public final void a(l3 callback, j3 params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.callback = callback;
        URL endPointUrl = this.endpointRepository.getEndPointUrl(EndpointRepository.EndPoint.VIDEO_COMPLETE);
        String strA = com.chartboost.sdk.internal.Networking.b.a(endPointUrl);
        String path = endPointUrl.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "url.path");
        i2 i2Var = new i2(strA, path, this.requestBodyBuilder.a(), k8.NORMAL, this, this.eventTracker);
        a(i2Var, params);
        this.networkService.a(i2Var);
    }

    @Override // com.chartboost.sdk.impl.i2.a
    public void a(i2 request, CBError error) {
        String message;
        if (error == null || (message = error.getMessage()) == null) {
            message = "Click failure";
        }
        l3 l3Var = this.callback;
        if (l3Var != null) {
            l3Var.a(message);
        }
    }

    @Override // com.chartboost.sdk.impl.i2.a
    public void a(i2 request, JSONObject response) {
        JSONObject jSONObjectA = z1.a(response, "response");
        l3 l3Var = this.callback;
        if (l3Var != null) {
            l3Var.a(jSONObjectA);
        }
    }
}
