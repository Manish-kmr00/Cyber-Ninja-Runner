package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class gy0 extends hy0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gy0(o3 adConfiguration) {
        super(adConfiguration);
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
    }

    @Override // com.yandex.mobile.ads.impl.hy0, com.yandex.mobile.ads.impl.b80
    public final Map<String, Object> a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Map<String, Object> mutableMap = MapsKt.toMutableMap(super.a(context));
        zy1 zy1VarR = a().r();
        if (zy1VarR != null) {
            mutableMap.put("width", Integer.valueOf(zy1VarR.c(context)));
            mutableMap.put("height", Integer.valueOf(zy1VarR.a(context)));
        }
        return mutableMap;
    }
}
