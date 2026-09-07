package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class Za {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3258a;
    public final Class b;

    public Za(String fieldName, Class<?> originClass) {
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(originClass, "originClass");
        this.f3258a = fieldName;
        this.b = originClass;
    }

    public final Za a(String fieldName, Class<?> originClass) {
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(originClass, "originClass");
        return new Za(fieldName, originClass);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Za)) {
            return false;
        }
        Za za = (Za) obj;
        return Intrinsics.areEqual(this.f3258a, za.f3258a) && Intrinsics.areEqual(this.b, za.b);
    }

    public int hashCode() {
        return this.b.hashCode() + (this.f3258a.hashCode() * 31);
    }

    public String toString() {
        return "RuleKey(fieldName=" + this.f3258a + ", originClass=" + this.b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Za a(Za za, String str, Class cls, int i, Object obj) {
        if ((i & 1) != 0) {
            str = za.f3258a;
        }
        if ((i & 2) != 0) {
            cls = za.b;
        }
        return za.a(str, cls);
    }
}
