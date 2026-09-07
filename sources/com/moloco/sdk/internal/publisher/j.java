package com.moloco.sdk.internal.publisher;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6197a;
    public final Float b;

    public j(String burl, Float f) {
        Intrinsics.checkNotNullParameter(burl, "burl");
        this.f6197a = burl;
        this.b = f;
    }

    public final String a() {
        return this.f6197a;
    }

    public final Float b() {
        return this.b;
    }
}
