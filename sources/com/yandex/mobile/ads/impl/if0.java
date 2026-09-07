package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes9.dex */
public final class if0 {
    public static final ByteString d;
    public static final ByteString e;
    public static final ByteString f;
    public static final ByteString g;
    public static final ByteString h;
    public static final ByteString i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteString f9210a;
    public final ByteString b;
    public final int c;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        d = companion.encodeUtf8(":");
        e = companion.encodeUtf8(":status");
        f = companion.encodeUtf8(":method");
        g = companion.encodeUtf8(":path");
        h = companion.encodeUtf8(":scheme");
        i = companion.encodeUtf8(":authority");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public if0(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        ByteString.Companion companion = ByteString.INSTANCE;
        this(companion.encodeUtf8(name), companion.encodeUtf8(value));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof if0)) {
            return false;
        }
        if0 if0Var = (if0) obj;
        return Intrinsics.areEqual(this.f9210a, if0Var.f9210a) && Intrinsics.areEqual(this.b, if0Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f9210a.hashCode() * 31);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public if0(ByteString name, String value) {
        this(name, ByteString.INSTANCE.encodeUtf8(value));
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    public final String toString() {
        return this.f9210a.utf8() + ": " + this.b.utf8();
    }

    public if0(ByteString name, ByteString value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f9210a = name;
        this.b = value;
        this.c = value.size() + name.size() + 32;
    }
}
