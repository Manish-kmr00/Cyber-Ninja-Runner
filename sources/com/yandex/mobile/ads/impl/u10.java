package com.yandex.mobile.ads.impl;

import android.view.View;
import com.yandex.div.core.DivCustomContainerViewAdapter;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivCustom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class u10 implements DivCustomContainerViewAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DivCustomContainerViewAdapter[] f10347a;

    public u10(DivCustomContainerViewAdapter... divCustomViewAdapters) {
        Intrinsics.checkNotNullParameter(divCustomViewAdapters, "divCustomViewAdapters");
        this.f10347a = divCustomViewAdapters;
    }

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
        DivCustomContainerViewAdapter divCustomContainerViewAdapter;
        View viewCreateView;
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        Intrinsics.checkNotNullParameter(path, "path");
        DivCustomContainerViewAdapter[] divCustomContainerViewAdapterArr = this.f10347a;
        int length = divCustomContainerViewAdapterArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                divCustomContainerViewAdapter = null;
                break;
            }
            divCustomContainerViewAdapter = divCustomContainerViewAdapterArr[i];
            if (divCustomContainerViewAdapter.isCustomTypeSupported(div.customType)) {
                break;
            }
            i++;
        }
        return (divCustomContainerViewAdapter == null || (viewCreateView = divCustomContainerViewAdapter.createView(div, divView, expressionResolver, path)) == null) ? new View(divView.getContext()) : viewCreateView;
    }

    @Override // com.yandex.div.core.DivCustomContainerViewAdapter
    public final boolean isCustomTypeSupported(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        for (DivCustomContainerViewAdapter divCustomContainerViewAdapter : this.f10347a) {
            if (divCustomContainerViewAdapter.isCustomTypeSupported(type)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.yandex.div.core.DivCustomContainerViewAdapter
    public final void release(View view, DivCustom div) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
    }
}
