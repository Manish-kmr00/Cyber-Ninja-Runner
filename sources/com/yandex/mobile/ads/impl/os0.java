package com.yandex.mobile.ads.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class os0 {
    public static final void a(ls0 ls0Var, String key, List<String> list) {
        Intrinsics.checkNotNullParameter(ls0Var, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        String strJoinToString$default = null;
        if (list != null) {
            List<String> list2 = !list.isEmpty() ? list : null;
            if (list2 != null) {
                strJoinToString$default = CollectionsKt.joinToString$default(list2, StringUtils.COMMA, null, null, 0, null, null, 62, null);
            }
        }
        ls0Var.a(key, strJoinToString$default);
    }
}
