package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class di2 extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public di2() {
        super("Empty version attribute");
        Intrinsics.checkNotNullParameter("Empty version attribute", "message");
    }
}
