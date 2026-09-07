package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k7 extends y3 {
    public final String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k7(String name, String str) {
        super(name);
        Intrinsics.checkNotNullParameter(name, "name");
        this.b = str;
    }
}
