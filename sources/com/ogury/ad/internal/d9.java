package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d9 extends Throwable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f7284a;
    public final b9 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d9(Throwable original, b9 id) {
        super(original.getMessage(), original);
        Intrinsics.checkNotNullParameter(original, "original");
        Intrinsics.checkNotNullParameter(id, "id");
        this.f7284a = original;
        this.b = id;
    }

    public final b9 a() {
        return this.b;
    }

    public final Throwable b() {
        return this.f7284a;
    }
}
