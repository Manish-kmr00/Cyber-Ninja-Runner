package com.yandex.div.core.view2;

import android.view.View;
import com.yandex.div.core.state.DivStatePath;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivViewBinder.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004J%\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bJ-\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/view2/DivViewBinder;", "TData", "TView", "Landroid/view/View;", "", "bindView", "", "context", "Lcom/yandex/div/core/view2/BindingContext;", "view", "div", "(Lcom/yandex/div/core/view2/BindingContext;Landroid/view/View;Ljava/lang/Object;)V", "path", "Lcom/yandex/div/core/state/DivStatePath;", "(Lcom/yandex/div/core/view2/BindingContext;Landroid/view/View;Ljava/lang/Object;Lcom/yandex/div/core/state/DivStatePath;)V", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivViewBinder<TData, TView extends View> {
    default void bindView(BindingContext context, TView view, TData div) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
    }

    default void bindView(BindingContext context, TView view, TData div, DivStatePath path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(path, "path");
        bindView(context, view, div);
    }
}
