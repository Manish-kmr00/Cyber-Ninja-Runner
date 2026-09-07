package com.moloco.sdk.acm;

import android.content.Context;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/moloco/sdk/acm/InitConfig;", "", RemoteConfigConstants.RequestFieldKey.APP_ID, "", "postAnalyticsUrl", "context", "Landroid/content/Context;", "requestPeriodSeconds", "", "clientOptions", "", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;JLjava/util/Map;)V", "getAppId", "()Ljava/lang/String;", "getClientOptions", "()Ljava/util/Map;", "getContext", "()Landroid/content/Context;", "getPostAnalyticsUrl", "getRequestPeriodSeconds", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "moloco-android-client-metrics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class InitConfig {
    private final String appId;
    private final Map<String, String> clientOptions;
    private final Context context;
    private final String postAnalyticsUrl;
    private final long requestPeriodSeconds;

    public InitConfig(String appId, String postAnalyticsUrl, Context context, long j, Map<String, String> clientOptions) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(postAnalyticsUrl, "postAnalyticsUrl");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(clientOptions, "clientOptions");
        this.appId = appId;
        this.postAnalyticsUrl = postAnalyticsUrl;
        this.context = context;
        this.requestPeriodSeconds = j;
        this.clientOptions = clientOptions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InitConfig copy$default(InitConfig initConfig, String str, String str2, Context context, long j, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = initConfig.appId;
        }
        if ((i & 2) != 0) {
            str2 = initConfig.postAnalyticsUrl;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            context = initConfig.context;
        }
        Context context2 = context;
        if ((i & 8) != 0) {
            j = initConfig.requestPeriodSeconds;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            map = initConfig.clientOptions;
        }
        return initConfig.copy(str, str3, context2, j2, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPostAnalyticsUrl() {
        return this.postAnalyticsUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getRequestPeriodSeconds() {
        return this.requestPeriodSeconds;
    }

    public final Map<String, String> component5() {
        return this.clientOptions;
    }

    public final InitConfig copy(String appId, String postAnalyticsUrl, Context context, long requestPeriodSeconds, Map<String, String> clientOptions) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(postAnalyticsUrl, "postAnalyticsUrl");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(clientOptions, "clientOptions");
        return new InitConfig(appId, postAnalyticsUrl, context, requestPeriodSeconds, clientOptions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InitConfig)) {
            return false;
        }
        InitConfig initConfig = (InitConfig) other;
        return Intrinsics.areEqual(this.appId, initConfig.appId) && Intrinsics.areEqual(this.postAnalyticsUrl, initConfig.postAnalyticsUrl) && Intrinsics.areEqual(this.context, initConfig.context) && this.requestPeriodSeconds == initConfig.requestPeriodSeconds && Intrinsics.areEqual(this.clientOptions, initConfig.clientOptions);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final Map<String, String> getClientOptions() {
        return this.clientOptions;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getPostAnalyticsUrl() {
        return this.postAnalyticsUrl;
    }

    public final long getRequestPeriodSeconds() {
        return this.requestPeriodSeconds;
    }

    public int hashCode() {
        return (((((((this.appId.hashCode() * 31) + this.postAnalyticsUrl.hashCode()) * 31) + this.context.hashCode()) * 31) + Long.hashCode(this.requestPeriodSeconds)) * 31) + this.clientOptions.hashCode();
    }

    public String toString() {
        return "InitConfig(appId=" + this.appId + ", postAnalyticsUrl=" + this.postAnalyticsUrl + ", context=" + this.context + ", requestPeriodSeconds=" + this.requestPeriodSeconds + ", clientOptions=" + this.clientOptions + ')';
    }

    public /* synthetic */ InitConfig(String str, String str2, Context context, long j, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, context, (i & 8) != 0 ? 600L : j, map);
    }
}
