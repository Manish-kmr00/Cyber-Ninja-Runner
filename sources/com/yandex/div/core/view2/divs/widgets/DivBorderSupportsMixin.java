package com.yandex.div.core.view2.divs.widgets;

import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.material.OutlinedTextFieldKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div2.DivBorder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivBorderSupportsMixin.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivBorderSupportsMixin;", "Lcom/yandex/div/core/view2/divs/widgets/DivBorderSupports;", "()V", "borderDrawer", "Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer;", "isDrawing", "", "()Z", "setDrawing", "(Z)V", "value", "needClipping", "getNeedClipping", "setNeedClipping", "getDivBorderDrawer", "setBorder", "", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "view", "Landroid/view/View;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivBorderSupportsMixin implements DivBorderSupports {
    private DivBorderDrawer borderDrawer;
    private boolean isDrawing;
    private boolean needClipping = true;

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    /* JADX INFO: renamed from: isDrawing, reason: from getter */
    public boolean getIsDrawing() {
        return this.isDrawing;
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void setDrawing(boolean z) {
        this.isDrawing = z;
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public boolean getNeedClipping() {
        return this.needClipping;
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void setNeedClipping(boolean z) {
        DivBorderDrawer divBorderDrawer = this.borderDrawer;
        if (divBorderDrawer != null) {
            divBorderDrawer.setNeedClipping(z);
        }
        this.needClipping = z;
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    /* JADX INFO: renamed from: getDivBorderDrawer, reason: from getter */
    public DivBorderDrawer getBorderDrawer() {
        return this.borderDrawer;
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void setBorder(BindingContext bindingContext, DivBorder border, View view) {
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.borderDrawer == null && border != null) {
            this.borderDrawer = new DivBorderDrawer(bindingContext.getDivView(), view);
        }
        DivBorderDrawer divBorderDrawer = this.borderDrawer;
        if (divBorderDrawer != null) {
            divBorderDrawer.setBorder(border, bindingContext.getExpressionResolver());
        }
        DivBorderDrawer divBorderDrawer2 = this.borderDrawer;
        if (divBorderDrawer2 != null) {
            divBorderDrawer2.setNeedClipping(getNeedClipping());
        }
        if (border == null) {
            view.setElevation(0.0f);
            view.setClipToOutline(false);
            view.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
            releaseBorderDrawer();
            this.borderDrawer = null;
        }
        view.invalidate();
    }
}
