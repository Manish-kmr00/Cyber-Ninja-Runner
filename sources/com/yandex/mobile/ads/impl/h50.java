package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w22 f9063a = new w22();

    public final String a(Context context, String rawQuery) {
        String strA;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rawQuery, "rawQuery");
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        return (cu1VarA == null || !cu1VarA.b0() || (strA = this.f9063a.a(context, rawQuery)) == null) ? rawQuery : strA;
    }
}
