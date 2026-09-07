package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.yandex.div.core.DivCustomContainerViewAdapter;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivCustom;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class x10 implements DivCustomContainerViewAdapter {
    @Override // com.yandex.div.core.DivCustomContainerViewAdapter
    public final void bindView(View view, DivCustom div, Div2View divView, ExpressionResolver expressionResolver, DivStatePath path) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        Intrinsics.checkNotNullParameter(path, "path");
    }

    @Override // com.yandex.div.core.DivCustomContainerViewAdapter
    public final View createView(DivCustom div, Div2View divView, ExpressionResolver expressionResolver, DivStatePath path) {
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        Intrinsics.checkNotNullParameter(path, "path");
        Context context = divView.getContext();
        ed1.a aVar = ed1.c;
        Intrinsics.checkNotNull(context);
        h82 h82VarC = aVar.a(context).c();
        JSONObject jSONObject = div.customProps;
        Object obj = jSONObject != null ? jSONObject.get("on_image_url") : null;
        String str = obj instanceof String ? (String) obj : null;
        JSONObject jSONObject2 = div.customProps;
        Object obj2 = jSONObject2 != null ? jSONObject2.get("off_image_url") : null;
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        k52 k52Var = new k52(context);
        if (str != null) {
            k52Var.setCheckedIcon(new BitmapDrawable(context.getResources(), h82VarC.a(str)));
        }
        if (str2 != null) {
            k52Var.setUncheckedIcon(new BitmapDrawable(context.getResources(), h82VarC.a(str2)));
        }
        return k52Var;
    }

    @Override // com.yandex.div.core.DivCustomContainerViewAdapter
    public final boolean isCustomTypeSupported(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return Intrinsics.areEqual("mute_button", type);
    }

    @Override // com.yandex.div.core.DivCustomContainerViewAdapter
    public final void release(View view, DivCustom div) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
    }
}
