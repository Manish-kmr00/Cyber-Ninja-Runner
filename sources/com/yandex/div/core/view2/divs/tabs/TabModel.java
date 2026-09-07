package com.yandex.div.core.view2.divs.tabs;

import android.view.View;
import com.yandex.div2.Div;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivTabsAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/yandex/div/core/view2/divs/tabs/TabModel;", "", "index", "", "div", "Lcom/yandex/div2/Div;", "view", "Landroid/view/View;", "(ILcom/yandex/div2/Div;Landroid/view/View;)V", "getDiv", "()Lcom/yandex/div2/Div;", "getIndex", "()I", "getView", "()Landroid/view/View;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class TabModel {
    private final Div div;
    private final int index;
    private final View view;

    public TabModel(int i, Div div, View view) {
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(view, "view");
        this.index = i;
        this.div = div;
        this.view = view;
    }

    public final int getIndex() {
        return this.index;
    }

    public final Div getDiv() {
        return this.div;
    }

    public final View getView() {
        return this.view;
    }
}
