package com.yandex.div.core.view2.divs.widgets;

import android.view.View;
import androidx.compose.material.OutlinedTextFieldKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div2.DivBorder;
import kotlin.Metadata;

/* JADX INFO: compiled from: DivBorderSupports.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\"\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\u0004\"\u0004\b\t\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivBorderSupports;", "", "isDrawing", "", "()Z", "setDrawing", "(Z)V", "needClipping", "getNeedClipping", "setNeedClipping", "getDivBorderDrawer", "Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer;", "invalidateBorder", "", "onBoundsChanged", "width", "", "height", "releaseBorderDrawer", "setBorder", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "view", "Landroid/view/View;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivBorderSupports {
    DivBorderDrawer getDivBorderDrawer();

    boolean getNeedClipping();

    boolean isDrawing();

    void setBorder(BindingContext bindingContext, DivBorder border, View view);

    void setDrawing(boolean z);

    void setNeedClipping(boolean z);

    default void onBoundsChanged(int width, int height) {
        DivBorderDrawer divBorderDrawer = getDivBorderDrawer();
        if (divBorderDrawer != null) {
            divBorderDrawer.onBoundsChanged(width, height);
        }
    }

    default void releaseBorderDrawer() {
        DivBorderDrawer divBorderDrawer = getDivBorderDrawer();
        if (divBorderDrawer != null) {
            divBorderDrawer.release();
        }
    }

    default void invalidateBorder() {
        DivBorderDrawer divBorderDrawer = getDivBorderDrawer();
        if (divBorderDrawer != null) {
            divBorderDrawer.invalidateBorder();
        }
    }
}
