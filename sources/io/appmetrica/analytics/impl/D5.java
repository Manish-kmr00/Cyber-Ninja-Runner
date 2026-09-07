package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class D5 implements Wc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11101a;

    public D5(String str) {
        this.f11101a = str;
    }

    public final D5 a(String str) {
        return new D5(str);
    }

    public final String b() {
        return this.f11101a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof D5) && Intrinsics.areEqual(this.f11101a, ((D5) obj).f11101a);
    }

    public final int hashCode() {
        return this.f11101a.hashCode();
    }

    public final String toString() {
        return "ConstantModuleEntryPointProvider(className=" + this.f11101a + ')';
    }

    public static D5 a(D5 d5, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = d5.f11101a;
        }
        d5.getClass();
        return new D5(str);
    }

    @Override // io.appmetrica.analytics.impl.Wc
    public final String a() {
        return this.f11101a;
    }
}
