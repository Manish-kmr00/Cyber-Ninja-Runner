package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b30 implements z00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f8472a;

    public b30(o8<?> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.f8472a = adResponse;
    }

    @Override // com.yandex.mobile.ads.impl.z00
    public final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Intrinsics.areEqual(d10.DIV_KIT.a(), this.f8472a.w());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b30) && Intrinsics.areEqual(this.f8472a, ((b30) obj).f8472a);
    }

    public final int hashCode() {
        return this.f8472a.hashCode();
    }

    public final String toString() {
        return "DivKitDesignConstraint(adResponse=" + this.f8472a + ")";
    }
}
