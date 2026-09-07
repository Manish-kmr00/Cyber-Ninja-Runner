package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import com.yandex.div.core.extension.DivExtensionHandler;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivBase;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class t20 implements DivExtensionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s20 f10259a;
    private final v20 b;

    @Override // com.yandex.div.core.extension.DivExtensionHandler
    public final void bindView(Div2View divView, ExpressionResolver expressionResolver, View view, DivBase div) {
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        Context context = view.getContext();
        u20 u20VarA = this.b.a(div);
        if (u20VarA != null) {
            a aVar = new a(this.f10259a, u20VarA);
            Intrinsics.checkNotNull(context);
            so soVar = new so(context, aVar);
            view.setOnTouchListener(soVar);
            view.setOnClickListener(soVar);
        }
    }

    @Override // com.yandex.div.core.extension.DivExtensionHandler
    public final boolean matches(DivBase div) {
        Intrinsics.checkNotNullParameter(div, "div");
        return this.b.a(div) != null;
    }

    @Override // com.yandex.div.core.extension.DivExtensionHandler
    public final void unbindView(Div2View divView, ExpressionResolver expressionResolver, View view, DivBase div) {
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        view.setOnTouchListener(null);
        view.setOnClickListener(null);
    }

    public /* synthetic */ t20(s20 s20Var) {
        this(s20Var, new v20(0));
    }

    public t20(s20 clickHandler, v20 clickExtensionParser) {
        Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
        Intrinsics.checkNotNullParameter(clickExtensionParser, "clickExtensionParser");
        this.f10259a = clickHandler;
        this.b = clickExtensionParser;
    }

    private static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final s20 f10260a;
        private final u20 b;

        public a(s20 clickHandler, u20 clickData) {
            Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
            Intrinsics.checkNotNullParameter(clickData, "clickData");
            this.f10260a = clickHandler;
            this.b = clickData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (view != null) {
                this.f10260a.a(this.b.a(), view);
            }
        }
    }
}
