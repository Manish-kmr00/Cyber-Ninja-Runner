package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class ca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8582a;

    public final String a() {
        return this.f8582a;
    }

    public final void a(String str) {
        if (str != null && !StringsKt.isBlank(str)) {
            String str2 = this.f8582a;
            if (str2 != null && !Intrinsics.areEqual(str2, str)) {
                dp0.c("Ad Unit Id can't be set twice.", new Object[0]);
                return;
            } else {
                this.f8582a = str;
                return;
            }
        }
        dp0.c("Ad Unit Id can't be null or empty.", new Object[0]);
    }
}
