package com.yandex.div.core.view2;

import android.graphics.Rect;
import android.view.View;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewVisibilityCalculator.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/yandex/div/core/view2/ViewVisibilityCalculator;", "", "()V", "visibleRect", "Landroid/graphics/Rect;", "calculateVisibilityPercentage", "", "view", "Landroid/view/View;", "isViewFullyVisible", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class ViewVisibilityCalculator {
    private final Rect visibleRect = new Rect();

    @Inject
    public ViewVisibilityCalculator() {
    }

    public int calculateVisibilityPercentage(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!view.isShown() || !view.getGlobalVisibleRect(this.visibleRect)) {
            return 0;
        }
        return ((this.visibleRect.width() * this.visibleRect.height()) * 100) / (view.getWidth() * view.getHeight());
    }

    public boolean isViewFullyVisible(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return view.isShown() && view.getGlobalVisibleRect(this.visibleRect) && view.getWidth() == this.visibleRect.width() && view.getHeight() == this.visibleRect.height();
    }
}
