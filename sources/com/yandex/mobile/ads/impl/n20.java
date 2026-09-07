package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.div.core.DivConfiguration;
import com.yandex.div.core.view2.Div2View;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class n20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l20 f9691a;
    private final k30 b;

    public n20(l20 actionHandler, k30 divViewCreator) {
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        Intrinsics.checkNotNullParameter(divViewCreator, "divViewCreator");
        this.f9691a = actionHandler;
        this.b = divViewCreator;
    }

    public final Div2View a(Context context, k20 action) {
        String lowerCase;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(action, "action");
        DivConfiguration divConfigurationBuild = new DivConfiguration.Builder(new g20(context)).actionHandler(this.f9691a).typefaceProvider(new j30(context)).build();
        Intrinsics.checkNotNullExpressionValue(divConfigurationBuild, "build(...)");
        this.b.getClass();
        Div2View div2ViewA = k30.a(context, divConfigurationBuild, null);
        div2ViewA.setData(action.c().b(), action.c().c());
        gf1 gf1VarA = hs.a(context);
        if (gf1VarA == gf1.e) {
            lowerCase = "PORTRAIT".toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = gf1VarA.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        }
        div2ViewA.setVariable("orientation", lowerCase);
        return div2ViewA;
    }
}
