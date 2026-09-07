package com.yandex.div.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.material.OutlinedTextFieldKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.divs.widgets.DivBorderDrawer;
import com.yandex.div.core.view2.divs.widgets.DivBorderSupports;
import com.yandex.div.internal.widget.FrameContainerLayout;
import com.yandex.div.internal.widget.TransientView;
import com.yandex.div.internal.widget.TransientViewMixin;
import com.yandex.div2.DivBorder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivViewWrapper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ$\u0010\u0019\u001a\u00020\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\"\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\fH\u0016J\u0011\u0010&\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\fH\u0096\u0001J\u0011\u0010'\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\fH\u0096\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0010X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014¨\u0006("}, d2 = {"Lcom/yandex/div/core/widget/DivViewWrapper;", "Lcom/yandex/div/internal/widget/FrameContainerLayout;", "Lcom/yandex/div/core/view2/divs/widgets/DivBorderSupports;", "Lcom/yandex/div/internal/widget/TransientView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "child", "Landroid/view/View;", "getChild", "()Landroid/view/View;", "value", "", "isDrawing", "()Z", "setDrawing", "(Z)V", "isTransient", "needClipping", "getNeedClipping", "setNeedClipping", "addView", "", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "getDivBorderDrawer", "Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer;", "setBorder", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "view", "transitionFinished", "transitionStarted", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class DivViewWrapper extends FrameContainerLayout implements DivBorderSupports, TransientView {
    private final /* synthetic */ TransientViewMixin $$delegate_0;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivViewWrapper(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivViewWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.yandex.div.internal.widget.TransientView
    public boolean isTransient() {
        return this.$$delegate_0.isTransient();
    }

    @Override // com.yandex.div.internal.widget.TransientView
    public void transitionFinished(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.$$delegate_0.transitionFinished(view);
    }

    @Override // com.yandex.div.internal.widget.TransientView
    public void transitionStarted(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.$$delegate_0.transitionStarted(view);
    }

    public /* synthetic */ DivViewWrapper(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivViewWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.$$delegate_0 = new TransientViewMixin();
        com.yandex.div.core.util.ViewsKt.makeFocusable(this);
        setImportantForAccessibility(2);
    }

    public final View getChild() {
        if (getChildCount() == 0) {
            return null;
        }
        return getChildAt(0);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (getChildCount() != 0) {
            throw new IllegalArgumentException("ViewWrapper can host only one child view".toString());
        }
        super.addView(child, 0, params);
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public boolean isDrawing() {
        KeyEvent.Callback child = getChild();
        DivBorderSupports divBorderSupports = child instanceof DivBorderSupports ? (DivBorderSupports) child : null;
        return divBorderSupports != null && divBorderSupports.isDrawing();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void setDrawing(boolean z) {
        KeyEvent.Callback child = getChild();
        DivBorderSupports divBorderSupports = child instanceof DivBorderSupports ? (DivBorderSupports) child : null;
        if (divBorderSupports == null) {
            return;
        }
        divBorderSupports.setDrawing(z);
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public boolean getNeedClipping() {
        KeyEvent.Callback child = getChild();
        DivBorderSupports divBorderSupports = child instanceof DivBorderSupports ? (DivBorderSupports) child : null;
        if (divBorderSupports != null) {
            return divBorderSupports.getNeedClipping();
        }
        return true;
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void setNeedClipping(boolean z) {
        KeyEvent.Callback child = getChild();
        DivBorderSupports divBorderSupports = child instanceof DivBorderSupports ? (DivBorderSupports) child : null;
        if (divBorderSupports == null) {
            return;
        }
        divBorderSupports.setNeedClipping(z);
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public DivBorderDrawer getDivBorderDrawer() {
        KeyEvent.Callback child = getChild();
        DivBorderSupports divBorderSupports = child instanceof DivBorderSupports ? (DivBorderSupports) child : null;
        if (divBorderSupports != null) {
            return divBorderSupports.getDivBorderDrawer();
        }
        return null;
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void setBorder(BindingContext bindingContext, DivBorder border, View view) {
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(view, "view");
        KeyEvent.Callback child = getChild();
        DivBorderSupports divBorderSupports = child instanceof DivBorderSupports ? (DivBorderSupports) child : null;
        if (divBorderSupports != null) {
            divBorderSupports.setBorder(bindingContext, border, view);
        }
    }
}
