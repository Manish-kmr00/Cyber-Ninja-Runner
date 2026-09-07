package com.yandex.mobile.ads.impl;

import com.facebook.share.internal.ShareConstants;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class v41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10448a;
    private final String b;
    private final t71 c;

    public v41(String assetName, String clickActionType, t71 t71Var) {
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(clickActionType, "clickActionType");
        this.f10448a = assetName;
        this.b = clickActionType;
        this.c = t71Var;
    }

    public final Map<String, Object> a() {
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        mapCreateMapBuilder.put("asset_name", this.f10448a);
        mapCreateMapBuilder.put(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, this.b);
        t71 t71Var = this.c;
        if (t71Var != null) {
            mapCreateMapBuilder.putAll(t71Var.a().b());
        }
        return MapsKt.build(mapCreateMapBuilder);
    }
}
