package com.chartboost.sdk.impl;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0006\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/chartboost/sdk/impl/va;", "", "", "url", "Lcom/chartboost/sdk/impl/b3;", "clickPreference", "a", "(Ljava/lang/String;Lcom/chartboost/sdk/impl/b3;)Lcom/chartboost/sdk/impl/va;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/b3;", "()Lcom/chartboost/sdk/impl/b3;", "<init>", "(Ljava/lang/String;Lcom/chartboost/sdk/impl/b3;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class va {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String url;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final b3 clickPreference;

    public va(String url, b3 clickPreference) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(clickPreference, "clickPreference");
        this.url = url;
        this.clickPreference = clickPreference;
    }

    public final va a(String url, b3 clickPreference) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(clickPreference, "clickPreference");
        return new va(url, clickPreference);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof va)) {
            return false;
        }
        va vaVar = (va) other;
        return Intrinsics.areEqual(this.url, vaVar.url) && this.clickPreference == vaVar.clickPreference;
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + this.clickPreference.hashCode();
    }

    public String toString() {
        return "UrlArgs(url=" + this.url + ", clickPreference=" + this.clickPreference + ')';
    }

    public static /* synthetic */ va a(va vaVar, String str, b3 b3Var, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vaVar.url;
        }
        if ((i & 2) != 0) {
            b3Var = vaVar.clickPreference;
        }
        return vaVar.a(str, b3Var);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final b3 getClickPreference() {
        return this.clickPreference;
    }
}
