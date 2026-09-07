package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.internal.Model.CBError;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0013\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u0013\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u001f\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u0013\u0010\u001fJ\u0017\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u000eH\u0016¢\u0006\u0004\b#\u0010\u0010J\u000f\u0010$\u001a\u00020\u000eH\u0016¢\u0006\u0004\b$\u0010\u0010J\u0017\u0010&\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010\"J\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b\u001c\u0010)J\u0017\u0010\f\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020'H\u0016¢\u0006\u0004\b\f\u0010)J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020'H\u0016¢\u0006\u0004\b\u0013\u0010)J\u0017\u0010&\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020'H\u0016¢\u0006\u0004\b&\u0010)J\u001f\u0010\u0013\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010.J\u000f\u0010/\u001a\u00020\u000eH\u0016¢\u0006\u0004\b/\u0010\u0010J\u000f\u00100\u001a\u00020\u000eH\u0016¢\u0006\u0004\b0\u0010\u0010J\u000f\u00101\u001a\u00020\u000eH\u0016¢\u0006\u0004\b1\u0010\u0010J\u000f\u00102\u001a\u00020\u000eH\u0016¢\u0006\u0004\b2\u0010\u0010J\u000f\u00103\u001a\u00020\u000eH\u0016¢\u0006\u0004\b3\u0010\u0010J\u000f\u00104\u001a\u00020\u000eH\u0016¢\u0006\u0004\b4\u0010\u0010J\u000f\u0010\f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\f\u0010\u0010J'\u0010\u0013\u001a\u00020\u000e2\f\u00107\u001a\b\u0012\u0004\u0012\u000206052\b\u00109\u001a\u0004\u0018\u000108H\u0016¢\u0006\u0004\b\u0013\u0010:¨\u0006;"}, d2 = {"Lcom/chartboost/sdk/impl/i6;", "", "", "l", "()Ljava/lang/String;", "i", "w", "C", "n", VastAttributes.HORIZONTAL_POSITION, "error", "Lcom/chartboost/sdk/internal/Model/CBError$b;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "(Ljava/lang/String;)Lcom/chartboost/sdk/internal/Model/CBError$b;", "", "D", "()V", "Lcom/chartboost/sdk/impl/db;", "vastVideoEvent", "a", "(Lcom/chartboost/sdk/impl/db;)V", "Lcom/chartboost/sdk/impl/h8;", "playerState", "(Lcom/chartboost/sdk/impl/h8;)V", "o", "", POBConstants.KEY_POSITION, "(F)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "videoDuration", "currentInSec", "(FF)V", "msg", "e", "(Ljava/lang/String;)V", "g", "j", "event", "d", "Lcom/chartboost/sdk/impl/m2;", "cbUrl", "(Lcom/chartboost/sdk/impl/m2;)V", "url", "", "allowOrientationChange", "forceOrientation", "(ZLjava/lang/String;)V", ApsMetricsDataMap.APSMETRICS_FIELD_URL, "z", CampaignEx.JSON_KEY_AD_K, "m", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, InneractiveMediationDefs.GENDER_FEMALE, "", "Lcom/chartboost/sdk/impl/fb;", "verificationScriptResourceList", "", UnifiedMediationParams.KEY_SKIP_OFFSET, "(Ljava/util/List;Ljava/lang/Integer;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public interface i6 {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a {
        public static CBError.b a(i6 i6Var, String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return CBError.b.INTERNAL;
        }
    }

    String C();

    void D();

    void a(float pos);

    void a(float videoDuration, float currentInSec);

    void a(db vastVideoEvent);

    void a(h8 playerState);

    void a(m2 url);

    void a(List<fb> verificationScriptResourceList, Integer skipOffset);

    void a(boolean allowOrientationChange, String forceOrientation);

    void b(float pos);

    void b(m2 cbUrl);

    CBError.b c(String error);

    void c();

    void c(m2 url);

    void d(m2 url);

    void d(String event);

    void e(String msg);

    void f();

    void g();

    String i();

    void j();

    void k();

    String l();

    void m();

    String n();

    void o();

    void t();

    void u();

    String w();

    String x();

    void z();
}
