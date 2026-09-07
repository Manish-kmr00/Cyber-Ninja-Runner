package com.inmobi.media;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class Y8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f3245a;

    public Y8(Map requestParams) {
        Intrinsics.checkNotNullParameter(requestParams, "requestParams");
        this.f3245a = requestParams;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Y8) && Intrinsics.areEqual(this.f3245a, ((Y8) obj).f3245a);
    }

    public final int hashCode() {
        return this.f3245a.hashCode();
    }

    public final String toString() {
        return "NovatiqAdData(requestParams=" + this.f3245a + ')';
    }
}
