package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.smaato.sdk.video.vast.model.Ad;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\nR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/chartboost/sdk/impl/a6;", "Lcom/chartboost/sdk/impl/z5;", "", "location", "", "videoPosition", "videoDuration", "", "a", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;)V", "()V", "Lcom/chartboost/sdk/impl/v;", "Lcom/chartboost/sdk/impl/v;", "adUnit", "Lcom/chartboost/sdk/impl/u;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/u;", Ad.AD_TYPE, "Lcom/chartboost/sdk/impl/k3;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/k3;", "completeRequest", "Lcom/chartboost/sdk/impl/j0;", "d", "Lcom/chartboost/sdk/impl/j0;", "adUnitRendererImpressionCallback", "<init>", "(Lcom/chartboost/sdk/impl/v;Lcom/chartboost/sdk/impl/u;Lcom/chartboost/sdk/impl/k3;Lcom/chartboost/sdk/impl/j0;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class a6 implements z5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final v adUnit;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final u adType;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final k3 completeRequest;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final j0 adUnitRendererImpressionCallback;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\t¨\u0006\n"}, d2 = {"com/chartboost/sdk/impl/a6$a", "Lcom/chartboost/sdk/impl/l3;", "Lorg/json/JSONObject;", "completeJson", "", "a", "(Lorg/json/JSONObject;)V", "", "errorMsg", "(Ljava/lang/String;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final class a implements l3 {
        @Override // com.chartboost.sdk.impl.l3
        public void a(JSONObject completeJson) {
            b7.b("onCompleteRequestSuccess " + completeJson, null, 2, null);
        }

        @Override // com.chartboost.sdk.impl.l3
        public void a(String errorMsg) {
            b7.b("onCompleteRequestFailure " + errorMsg, null, 2, null);
        }
    }

    public a6(v adUnit, u adType, k3 completeRequest, j0 adUnitRendererImpressionCallback) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(completeRequest, "completeRequest");
        Intrinsics.checkNotNullParameter(adUnitRendererImpressionCallback, "adUnitRendererImpressionCallback");
        this.adUnit = adUnit;
        this.adType = adType;
        this.completeRequest = completeRequest;
        this.adUnitRendererImpressionCallback = adUnitRendererImpressionCallback;
    }

    @Override // com.chartboost.sdk.impl.z5
    public void a() {
        u uVar = this.adType;
        if (uVar == u.b.g) {
            b7.b("didCompleteInterstitial delegate used to be sent here", null, 2, null);
        } else if (uVar == u.c.g) {
            this.adUnitRendererImpressionCallback.a(this.adUnit.getImpressionId(), this.adUnit.getCom.ironsource.mediationsdk.utils.IronSourceConstants.EVENTS_REWARD_AMOUNT java.lang.String());
        }
    }

    @Override // com.chartboost.sdk.impl.z5
    public void a(String location, Float videoPosition, Float videoDuration) {
        Intrinsics.checkNotNullParameter(location, "location");
        this.completeRequest.a(new a(), new j3(location, this.adUnit.getAdId(), this.adUnit.getCgn(), this.adUnit.getCom.ironsource.mediationsdk.utils.IronSourceConstants.EVENTS_REWARD_AMOUNT java.lang.String(), this.adUnit.getRewardCurrency(), videoPosition, videoDuration));
    }
}
