package com.yandex.mobile.ads.impl;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class sd1 extends pg<String, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kr1 f10198a;

    public sd1(kr1 reviewCountFormatter) {
        Intrinsics.checkNotNullParameter(reviewCountFormatter, "reviewCountFormatter");
        this.f10198a = reviewCountFormatter;
    }

    @Override // com.yandex.mobile.ads.impl.pg
    public final ig a(Object obj, String name) throws IOException {
        String value = (String) obj;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual("review_count", name)) {
            try {
                value = this.f10198a.a(value);
            } catch (p61 unused) {
            }
        }
        return pg.a(name, "string", value);
    }
}
