package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.common.AdError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class al2 implements AdError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8417a;

    public al2(String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.f8417a = description;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof al2) && Intrinsics.areEqual(this.f8417a, ((al2) obj).f8417a);
    }

    public final int hashCode() {
        return this.f8417a.hashCode();
    }

    public final String toString() {
        return "YandexAdError(description=" + this.f8417a + ")";
    }

    @Override // com.yandex.mobile.ads.common.AdError
    public final String getDescription() {
        return this.f8417a;
    }
}
