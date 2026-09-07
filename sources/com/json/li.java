package com.json;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b%\u0010&J'\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u0005\u001a\u00020\u0007HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\t\u0010\u000b\u001a\u00020\u0007HÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\n\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013R$\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u0005\u0010\u001aR\"\u0010\u001f\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u0016\u0010\u001d\"\u0004\b\u0005\u0010\u001eR$\u0010\"\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b \u0010\u0013\"\u0004\b\b\u0010!R$\u0010$\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0011\u001a\u0004\b#\u0010\u0013\"\u0004\b\u0005\u0010!¨\u0006'"}, d2 = {"Lcom/ironsource/li;", "", "T", "Lcom/ironsource/lm;", "mapper", "a", "(Lcom/ironsource/lm;)Ljava/lang/Object;", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "appKey", "userId", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "h", "Lcom/ironsource/v0;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/v0;", "e", "()Lcom/ironsource/v0;", "(Lcom/ironsource/v0;)V", "applicationConfig", "Z", "()Z", "(Z)V", "adapterDebug", "g", "(Ljava/lang/String;)V", JsonStorageKeyNames.SESSION_ID_KEY, InneractiveMediationDefs.GENDER_FEMALE, "pluginType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class li {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String appKey;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String userId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private v0 applicationConfig;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private boolean adapterDebug;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private String sessionId;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private String pluginType;

    public li(String appKey, String userId) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.appKey = appKey;
        this.userId = userId;
    }

    public static /* synthetic */ li a(li liVar, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = liVar.appKey;
        }
        if ((i & 2) != 0) {
            str2 = liVar.userId;
        }
        return liVar.a(str, str2);
    }

    public final li a(String appKey, String userId) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(userId, "userId");
        return new li(appKey, userId);
    }

    public final <T> T a(lm<li, T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return mapper.a(this);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getAppKey() {
        return this.appKey;
    }

    public final void a(v0 v0Var) {
        this.applicationConfig = v0Var;
    }

    public final void a(String str) {
        this.pluginType = str;
    }

    public final void a(boolean z) {
        this.adapterDebug = z;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public final void b(String str) {
        this.sessionId = str;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final boolean getAdapterDebug() {
        return this.adapterDebug;
    }

    public final String d() {
        return this.appKey;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final v0 getApplicationConfig() {
        return this.applicationConfig;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof li)) {
            return false;
        }
        li liVar = (li) other;
        return Intrinsics.areEqual(this.appKey, liVar.appKey) && Intrinsics.areEqual(this.userId, liVar.userId);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getPluginType() {
        return this.pluginType;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public final String h() {
        return this.userId;
    }

    public int hashCode() {
        return (this.appKey.hashCode() * 31) + this.userId.hashCode();
    }

    public String toString() {
        return "InitConfig(appKey=" + this.appKey + ", userId=" + this.userId + ')';
    }
}
