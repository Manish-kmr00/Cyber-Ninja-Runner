package com.moloco.sdk.internal.error;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6089a;

    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final String a() {
        return this.f6089a;
    }

    public final String b() {
        return this.f6089a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && Intrinsics.areEqual(this.f6089a, ((a) obj).f6089a);
    }

    public int hashCode() {
        String str = this.f6089a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "ErrorMetadata(mtid=" + this.f6089a + ')';
    }

    public a(String str) {
        this.f6089a = str;
    }

    public final a a(String str) {
        return new a(str);
    }

    public /* synthetic */ a(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public static /* synthetic */ a a(a aVar, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aVar.f6089a;
        }
        return aVar.a(str);
    }
}
