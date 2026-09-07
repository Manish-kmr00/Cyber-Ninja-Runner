package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class F0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3064a = "F0";
    public String b;
    public Boolean c;

    public F0() {
        Intrinsics.checkNotNull("F0");
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.f3064a;
    }

    public final Boolean c() {
        return this.c;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void a(boolean z) {
        Intrinsics.checkNotNull(this.f3064a);
        this.c = Boolean.valueOf(z);
    }
}
