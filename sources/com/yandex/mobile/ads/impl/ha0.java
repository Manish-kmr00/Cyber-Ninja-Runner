package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ha0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9077a;

    public ha0(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f9077a = value;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ha0) && Intrinsics.areEqual(this.f9077a, ((ha0) obj).f9077a);
    }

    public final int hashCode() {
        return this.f9077a.hashCode();
    }

    public final String toString() {
        return "FeedSessionData(value=" + this.f9077a + ")";
    }

    public final String a() {
        return this.f9077a;
    }
}
