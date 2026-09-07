package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.div.core.DivConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class yz1 {
    public static DivConfiguration a(Context context, xz1 divExtensionHandler, s20 clickHandler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(divExtensionHandler, "divExtensionHandler");
        Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
        g20 g20Var = new g20(context);
        DivConfiguration divConfigurationBuild = new DivConfiguration.Builder(g20Var).divCustomContainerViewAdapter(new u10(new w10(), new a20(), new z10(), new v10(), new b20(), new x10())).typefaceProvider(new j30(context)).extension(divExtensionHandler).extension(new t20(clickHandler)).build();
        Intrinsics.checkNotNullExpressionValue(divConfigurationBuild, "build(...)");
        return divConfigurationBuild;
    }
}
