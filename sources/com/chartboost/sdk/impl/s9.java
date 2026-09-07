package com.chartboost.sdk.impl;

import android.content.SharedPreferences;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0013¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0005\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0005\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\tR\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0014R(\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010 \u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001b\u0010\u0011R\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001fR\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001fR\u0014\u0010%\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010$¨\u0006("}, d2 = {"Lcom/chartboost/sdk/impl/s9;", "", "Lcom/chartboost/sdk/impl/u;", "type", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/chartboost/sdk/impl/u;)I", "", "a", "()V", "(Lcom/chartboost/sdk/impl/u;)V", "Lcom/chartboost/sdk/impl/t9;", "h", "()Lcom/chartboost/sdk/impl/t9;", "", "()Ljava/lang/String;", InneractiveMediationDefs.GENDER_FEMALE, "()I", "g", "Landroid/content/SharedPreferences;", "Landroid/content/SharedPreferences;", "mPrefs", "<set-?>", "Ljava/lang/String;", "e", JsonStorageKeyNames.SESSION_ID_KEY, "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "J", "mSessionStartTime", "d", "I", "sessionCounter", "mSessionInterstitialImpressionCounter", "mSessionRewardedImpressionCounter", "mSessionBannerImpressionCounter", "()J", "sessionDuration", "<init>", "(Landroid/content/SharedPreferences;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class s9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final SharedPreferences mPrefs;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public String sessionId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public long mSessionStartTime;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public int sessionCounter;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public int mSessionInterstitialImpressionCounter;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public int mSessionRewardedImpressionCounter;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public int mSessionBannerImpressionCounter;

    public s9(SharedPreferences mPrefs) {
        Intrinsics.checkNotNullParameter(mPrefs, "mPrefs");
        this.mPrefs = mPrefs;
        this.sessionCounter = f();
    }

    public final long d() {
        return System.currentTimeMillis() - this.mSessionStartTime;
    }

    public final t9 h() {
        return new t9(this.sessionId, d(), this.sessionCounter, b(u.a.g), b(u.c.g), b(u.b.g));
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getSessionCounter() {
        return this.sessionCounter;
    }

    public final int b(u type) {
        if (Intrinsics.areEqual(type, u.b.g)) {
            return this.mSessionInterstitialImpressionCounter;
        }
        if (Intrinsics.areEqual(type, u.c.g)) {
            return this.mSessionRewardedImpressionCounter;
        }
        if (Intrinsics.areEqual(type, u.a.g)) {
            return this.mSessionBannerImpressionCounter;
        }
        return 0;
    }

    public final String b() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        return s1.a(string);
    }

    public final void a() {
        this.sessionId = b();
        this.mSessionStartTime = System.currentTimeMillis();
        this.mSessionInterstitialImpressionCounter = 0;
        this.mSessionRewardedImpressionCounter = 0;
        this.mSessionBannerImpressionCounter = 0;
        this.sessionCounter++;
        g();
    }

    public final void a(u type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, u.b.g)) {
            this.mSessionInterstitialImpressionCounter++;
        } else if (Intrinsics.areEqual(type, u.c.g)) {
            this.mSessionRewardedImpressionCounter++;
        } else if (Intrinsics.areEqual(type, u.a.g)) {
            this.mSessionBannerImpressionCounter++;
        }
    }

    public final int f() {
        return this.mPrefs.getInt("session_key", 0);
    }

    public final void g() {
        SharedPreferences.Editor editorPutInt;
        SharedPreferences.Editor editorEdit = this.mPrefs.edit();
        if (editorEdit == null || (editorPutInt = editorEdit.putInt("session_key", this.sessionCounter)) == null) {
            return;
        }
        editorPutInt.apply();
    }
}
