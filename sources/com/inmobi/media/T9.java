package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class T9 extends V9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3204a;
    public final String b;

    public T9(String message, int i) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.f3204a = i;
        this.b = message;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof T9)) {
            return false;
        }
        T9 t9 = (T9) obj;
        return this.f3204a == t9.f3204a && Intrinsics.areEqual(this.b, t9.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Integer.hashCode(this.f3204a) * 31);
    }

    public final String toString() {
        return "Failure(statusCode=" + this.f3204a + ", message=" + this.b + ')';
    }
}
