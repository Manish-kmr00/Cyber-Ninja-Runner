package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class dj0 implements vg<uj0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v22 f8699a;

    @Override // com.yandex.mobile.ads.impl.vg
    public final boolean a(uj0 value) {
        Intrinsics.checkNotNullParameter(value, "value");
        String value2 = value.f();
        if (value2 != null) {
            this.f8699a.getClass();
            Intrinsics.checkNotNullParameter(value2, "value");
            if (value2.length() > 0 && !Intrinsics.areEqual("null", value2)) {
                return true;
            }
        }
        return false;
    }

    public /* synthetic */ dj0() {
        this(new v22());
    }

    public dj0(v22 stringAssetValueValidator) {
        Intrinsics.checkNotNullParameter(stringAssetValueValidator, "stringAssetValueValidator");
        this.f8699a = stringAssetValueValidator;
    }
}
