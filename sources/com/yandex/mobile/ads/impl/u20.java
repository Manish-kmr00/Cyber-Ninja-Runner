package com.yandex.mobile.ads.impl;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class u20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f10353a;

    public u20(Uri url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.f10353a = url;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof u20) && Intrinsics.areEqual(this.f10353a, ((u20) obj).f10353a);
    }

    public final int hashCode() {
        return this.f10353a.hashCode();
    }

    public final String toString() {
        return "DivKitClickExtensionData(url=" + this.f10353a + ")";
    }

    public final Uri a() {
        return this.f10353a;
    }
}
