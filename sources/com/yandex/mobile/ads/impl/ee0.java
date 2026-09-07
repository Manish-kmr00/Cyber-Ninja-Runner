package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ee0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f8790a;

    public ee0(Object fusedLocationProviderObject) {
        Intrinsics.checkNotNullParameter(fusedLocationProviderObject, "fusedLocationProviderObject");
        this.f8790a = fusedLocationProviderObject;
    }

    public final ys0 a() {
        Object objA = co1.a.a(this.f8790a, "getLastLocation", new Object[0]);
        if (objA != null) {
            return new ys0(objA);
        }
        return null;
    }
}
