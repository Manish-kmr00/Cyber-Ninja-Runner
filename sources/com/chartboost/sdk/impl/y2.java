package com.chartboost.sdk.impl;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b7\u00108J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0096\u0001¢\u0006\u0004\b\u0005\u0010\nR\u0014\u0010\r\u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0005\u0010\fR\u0014\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\t\u001a\u00020\u00078\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\u001d8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u0010\u001fR\u0014\u00106\u001a\u0002038\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/chartboost/sdk/impl/y2;", "", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;)V", "", RemoteConfigConstants.RequestFieldKey.APP_ID, "appSignature", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/chartboost/sdk/impl/w0;", "()Lcom/chartboost/sdk/impl/w0;", "androidComponent", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Ljava/lang/String;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/z0;", "d", "()Lcom/chartboost/sdk/impl/z0;", "applicationComponent", "Lcom/chartboost/sdk/impl/q4;", "e", "()Lcom/chartboost/sdk/impl/q4;", "executorComponent", "Lcom/chartboost/sdk/impl/b6;", InneractiveMediationDefs.GENDER_FEMALE, "()Lcom/chartboost/sdk/impl/b6;", "impressionComponent", "", "g", "()Z", "initialized", "Lcom/chartboost/sdk/impl/q7;", "h", "()Lcom/chartboost/sdk/impl/q7;", "openMeasurementComponent", "Lcom/chartboost/sdk/impl/n8;", "i", "()Lcom/chartboost/sdk/impl/n8;", "privacyComponent", "Lcom/chartboost/sdk/impl/x8;", "j", "()Lcom/chartboost/sdk/impl/x8;", "renderComponent", "Lcom/chartboost/sdk/impl/n9;", CampaignEx.JSON_KEY_AD_K, "()Lcom/chartboost/sdk/impl/n9;", "sdkComponent", "l", com.ironsource.b9.h.d0, "Lcom/chartboost/sdk/impl/ea;", "m", "()Lcom/chartboost/sdk/impl/ea;", "trackerComponent", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class y2 {
    public static final y2 b = new y2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u3 f1199a = new u3();

    public w0 a() {
        return this.f1199a.a();
    }

    public String b() {
        return this.f1199a.b();
    }

    public String c() {
        return this.f1199a.c();
    }

    public z0 d() {
        return this.f1199a.e();
    }

    public q4 e() {
        return this.f1199a.f();
    }

    public b6 f() {
        return this.f1199a.g();
    }

    public boolean g() {
        return this.f1199a.h();
    }

    public q7 h() {
        return this.f1199a.i();
    }

    public n8 i() {
        return this.f1199a.j();
    }

    public x8 j() {
        return this.f1199a.k();
    }

    public n9 k() {
        return this.f1199a.l();
    }

    public boolean l() {
        return this.f1199a.m();
    }

    public ea m() {
        return this.f1199a.n();
    }

    public void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f1199a.a(context);
    }

    public void a(String appId, String appSignature) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appSignature, "appSignature");
        this.f1199a.a(appId, appSignature);
    }
}
