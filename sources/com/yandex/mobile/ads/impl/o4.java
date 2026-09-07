package com.yandex.mobile.ads.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
public final class o4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r4 f9778a;
    private final p4 b;

    public final String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a(context, this.f9778a.c());
    }

    public final String b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a(context, this.f9778a.d());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o4() {
        this(r4.a.a(), new p4());
        int i = r4.e;
    }

    public o4(r4 adIdStorage, p4 adIdHeaderSizeProvider) {
        Intrinsics.checkNotNullParameter(adIdStorage, "adIdStorage");
        Intrinsics.checkNotNullParameter(adIdHeaderSizeProvider, "adIdHeaderSizeProvider");
        this.f9778a = adIdStorage;
        this.b = adIdHeaderSizeProvider;
    }

    private final String a(Context context, List<String> list) {
        this.b.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        return CollectionsKt.joinToString$default(list.subList(list.size() - RangesKt.coerceAtMost((cu1VarA == null || cu1VarA.e() == 0) ? 5 : cu1VarA.e(), list.size()), list.size()), StringUtils.COMMA, null, null, 0, null, null, 62, null);
    }
}
