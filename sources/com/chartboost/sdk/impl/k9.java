package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u0014J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0015\u001a\u00020\u00028\u0006X\u0087D¢\u0006\u0012\n\u0004\b\u0007\u0010\u0011\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0005\u0010\u0012R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\f\u0010\u0011\u0012\u0004\b\u0016\u0010\u0014\u001a\u0004\b\t\u0010\u0012R\"\u0010\u001d\u001a\u0004\u0018\u00010\u00188GX\u0087\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u0007\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/chartboost/sdk/impl/k9;", "", "", "id", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/lang/String;)V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, CreativeInfo.f, "a", "", "Z", "d", "()Z", "setSandboxMode", "(Z)V", "isSandboxMode", "Ljava/lang/String;", "()Ljava/lang/String;", "getHeader$annotations", "()V", "header", "getCustomHeader$annotations", "customHeader", "Ljavax/net/ssl/X509TrustManager;", "e", "Ljavax/net/ssl/X509TrustManager;", "()Ljavax/net/ssl/X509TrustManager;", "getTrustManager$annotations", "trustManager", "<init>", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class k9 {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static boolean isSandboxMode;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static final String customHeader = null;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static final X509TrustManager trustManager = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k9 f1061a = new k9();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final String header = "";

    @JvmStatic
    public static final void a(String log) {
    }

    @JvmStatic
    public static final void b(String id) {
    }

    @JvmStatic
    public static final void c(String id) {
    }

    public final boolean d() {
        return isSandboxMode;
    }

    public static final String a() {
        return customHeader;
    }

    public static final String b() {
        return header;
    }

    public static final X509TrustManager c() {
        return trustManager;
    }
}
