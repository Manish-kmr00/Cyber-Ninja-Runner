package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.Mediation;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010(\u001a\u00020#\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00102\u001a\u00020-\u0012\u0006\u00108\u001a\u000203\u0012\b\u0010>\u001a\u0004\u0018\u000109\u0012\u0006\u0010B\u001a\u00020?¢\u0006\u0004\bC\u0010DJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0017\u00102\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00108\u001a\u0002038\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0019\u0010>\u001a\u0004\u0018\u0001098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006E"}, d2 = {"Lcom/chartboost/sdk/impl/e9;", "Lcom/chartboost/sdk/impl/d9;", "Lcom/chartboost/sdk/impl/f9;", "a", "()Lcom/chartboost/sdk/impl/f9;", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/chartboost/sdk/impl/w1;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/w1;", "getIdentity", "()Lcom/chartboost/sdk/impl/w1;", "identity", "Lcom/chartboost/sdk/impl/h2;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/h2;", "getReachability", "()Lcom/chartboost/sdk/impl/h2;", "reachability", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/chartboost/sdk/impl/o9;", "d", "Ljava/util/concurrent/atomic/AtomicReference;", "getSdkConfig", "()Ljava/util/concurrent/atomic/AtomicReference;", "sdkConfig", "Landroid/content/SharedPreferences;", "e", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "sharedPreferences", "Lcom/chartboost/sdk/impl/ba;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/chartboost/sdk/impl/ba;", "getTimeSource", "()Lcom/chartboost/sdk/impl/ba;", "timeSource", "Lcom/chartboost/sdk/impl/s2;", "g", "Lcom/chartboost/sdk/impl/s2;", "carrierBuilder", "Lcom/chartboost/sdk/impl/s9;", "h", "Lcom/chartboost/sdk/impl/s9;", "getSession", "()Lcom/chartboost/sdk/impl/s9;", "session", "Lcom/chartboost/sdk/impl/l8;", "i", "Lcom/chartboost/sdk/impl/l8;", "getPrivacyApi", "()Lcom/chartboost/sdk/impl/l8;", "privacyApi", "Lcom/chartboost/sdk/Mediation;", "j", "Lcom/chartboost/sdk/Mediation;", "getMediation", "()Lcom/chartboost/sdk/Mediation;", "mediation", "Lcom/chartboost/sdk/impl/x3;", CampaignEx.JSON_KEY_AD_K, "Lcom/chartboost/sdk/impl/x3;", "deviceBodyFieldsFactory", "<init>", "(Landroid/content/Context;Lcom/chartboost/sdk/impl/w1;Lcom/chartboost/sdk/impl/h2;Ljava/util/concurrent/atomic/AtomicReference;Landroid/content/SharedPreferences;Lcom/chartboost/sdk/impl/ba;Lcom/chartboost/sdk/impl/s2;Lcom/chartboost/sdk/impl/s9;Lcom/chartboost/sdk/impl/l8;Lcom/chartboost/sdk/Mediation;Lcom/chartboost/sdk/impl/x3;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class e9 implements d9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final w1 identity;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final h2 reachability;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final AtomicReference<o9> sdkConfig;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final SharedPreferences sharedPreferences;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final ba timeSource;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final s2 carrierBuilder;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final s9 session;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final l8 privacyApi;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final Mediation mediation;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final x3 deviceBodyFieldsFactory;

    public e9(Context context, w1 identity, h2 reachability, AtomicReference<o9> sdkConfig, SharedPreferences sharedPreferences, ba timeSource, s2 carrierBuilder, s9 session, l8 privacyApi, Mediation mediation, x3 deviceBodyFieldsFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(identity, "identity");
        Intrinsics.checkNotNullParameter(reachability, "reachability");
        Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(carrierBuilder, "carrierBuilder");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(privacyApi, "privacyApi");
        Intrinsics.checkNotNullParameter(deviceBodyFieldsFactory, "deviceBodyFieldsFactory");
        this.context = context;
        this.identity = identity;
        this.reachability = reachability;
        this.sdkConfig = sdkConfig;
        this.sharedPreferences = sharedPreferences;
        this.timeSource = timeSource;
        this.carrierBuilder = carrierBuilder;
        this.session = session;
        this.privacyApi = privacyApi;
        this.mediation = mediation;
        this.deviceBodyFieldsFactory = deviceBodyFieldsFactory;
    }

    @Override // com.chartboost.sdk.impl.d9
    public f9 a() {
        y2 y2Var = y2.b;
        String strB = y2Var.b();
        String strC = y2Var.c();
        r5 r5VarH = this.identity.h();
        v8 reachabilityBodyFields = b5.toReachabilityBodyFields(this.reachability);
        r2 r2VarA = this.carrierBuilder.a(this.context);
        t9 t9VarH = this.session.h();
        ca bodyFields = b5.toBodyFields(this.timeSource);
        m8 m8VarG = this.privacyApi.g();
        n3 n3VarK = this.sdkConfig.get().k();
        w3 w3VarA = this.deviceBodyFieldsFactory.a();
        Mediation mediation = this.mediation;
        return new f9(strB, strC, r5VarH, reachabilityBodyFields, r2VarA, t9VarH, bodyFields, m8VarG, n3VarK, w3VarA, mediation != null ? mediation.toMediationBodyFields() : null);
    }
}
