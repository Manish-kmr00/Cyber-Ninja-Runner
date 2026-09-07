package com.chartboost.sdk.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/chartboost/sdk/impl/ua;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", com.ironsource.b9.h.v0, "<init>", "(Ljava/lang/String;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class ua {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String actionName;

    public ua(String actionName) {
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        this.actionName = actionName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ua) && Intrinsics.areEqual(this.actionName, ((ua) other).actionName);
    }

    public int hashCode() {
        return this.actionName.hashCode();
    }

    public String toString() {
        return "UrlActionResult(actionName=" + this.actionName + ')';
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getActionName() {
        return this.actionName;
    }
}
