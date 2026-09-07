package com.yandex.div.core.view2.divs.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.core.view.ViewGroupKt;
import com.android.billingclient.api.BillingClient;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.internal.widget.FrameContainerLayout;
import com.yandex.div2.DivBorder;
import com.yandex.div2.DivCustom;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivCustomWrapper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010%H\u0096\u0001J\t\u0010+\u001a\u00020)H\u0096\u0001J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020.H\u0014J\u0010\u0010/\u001a\u00020)2\u0006\u0010-\u001a\u00020.H\u0016J\b\u00100\u001a\u00020\tH\u0016J\u000b\u00101\u001a\u0004\u0018\u000102H\u0096\u0001J\t\u00103\u001a\u00020)H\u0096\u0001J\u0019\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\tH\u0096\u0001J(\u00107\u001a\u00020)2\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\tH\u0014J\t\u0010<\u001a\u00020)H\u0096\u0001J\t\u0010=\u001a\u00020)H\u0096\u0001J#\u0010>\u001a\u00020)2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010B\u001a\u00020)2\u0006\u0010A\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010C\u001a\u00020)2\u0006\u0010A\u001a\u00020\u0012H\u0096\u0001R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u000f¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u00020\u001bX\u0096\u000f¢\u0006\f\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u00020\u001bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001cR\u0018\u0010 \u001a\u00020\u001bX\u0096\u000f¢\u0006\f\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u0018\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006D"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivCustomWrapper;", "Lcom/yandex/div/internal/widget/FrameContainerLayout;", "Lcom/yandex/div/core/view2/divs/widgets/DivHolderView;", "Lcom/yandex/div2/DivCustom;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "getBindingContext", "()Lcom/yandex/div/core/view2/BindingContext;", "setBindingContext", "(Lcom/yandex/div/core/view2/BindingContext;)V", "customView", "Landroid/view/View;", "getCustomView", "()Landroid/view/View;", "div", "getDiv", "()Lcom/yandex/div2/DivCustom;", "setDiv", "(Lcom/yandex/div2/DivCustom;)V", "isDrawing", "", "()Z", "setDrawing", "(Z)V", "isTransient", "needClipping", "getNeedClipping", "setNeedClipping", BillingClient.FeatureType.SUBSCRIPTIONS, "", "Lcom/yandex/div/core/Disposable;", "getSubscriptions", "()Ljava/util/List;", "addSubscription", "", "subscription", "closeAllSubscription", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "draw", "getBaseline", "getDivBorderDrawer", "Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer;", "invalidateBorder", "onBoundsChanged", "width", "height", "onSizeChanged", "w", "h", "oldw", "oldh", "release", "releaseBorderDrawer", "setBorder", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "view", "transitionFinished", "transitionStarted", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivCustomWrapper extends FrameContainerLayout implements DivHolderView<DivCustom> {
    private final /* synthetic */ DivHolderViewMixin<DivCustom> $$delegate_0;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivCustomWrapper(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivCustomWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.yandex.div.internal.core.ExpressionSubscriber
    public void addSubscription(Disposable subscription) {
        this.$$delegate_0.addSubscription(subscription);
    }

    @Override // com.yandex.div.internal.core.ExpressionSubscriber
    public void closeAllSubscription() {
        this.$$delegate_0.closeAllSubscription();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivHolderView
    public BindingContext getBindingContext() {
        return this.$$delegate_0.getBindingContext();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivHolderView
    public DivCustom getDiv() {
        return (DivCustom) this.$$delegate_0.getDiv();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public DivBorderDrawer getDivBorderDrawer() {
        return this.$$delegate_0.getDivBorderDrawer();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public boolean getNeedClipping() {
        return this.$$delegate_0.getNeedClipping();
    }

    @Override // com.yandex.div.internal.core.ExpressionSubscriber
    public List<Disposable> getSubscriptions() {
        return this.$$delegate_0.getSubscriptions();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void invalidateBorder() {
        this.$$delegate_0.invalidateBorder();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public boolean isDrawing() {
        return this.$$delegate_0.isDrawing();
    }

    @Override // com.yandex.div.internal.widget.TransientView
    public boolean isTransient() {
        return this.$$delegate_0.isTransient();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void onBoundsChanged(int width, int height) {
        this.$$delegate_0.onBoundsChanged(width, height);
    }

    @Override // com.yandex.div.internal.core.ExpressionSubscriber, com.yandex.div.core.view2.Releasable
    public void release() {
        this.$$delegate_0.release();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void releaseBorderDrawer() {
        this.$$delegate_0.releaseBorderDrawer();
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivHolderView
    public void setBindingContext(BindingContext bindingContext) {
        this.$$delegate_0.setBindingContext(bindingContext);
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void setBorder(BindingContext bindingContext, DivBorder border, View view) {
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(view, "view");
        this.$$delegate_0.setBorder(bindingContext, border, view);
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivHolderView
    public void setDiv(DivCustom divCustom) {
        this.$$delegate_0.setDiv(divCustom);
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void setDrawing(boolean z) {
        this.$$delegate_0.setDrawing(z);
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivBorderSupports
    public void setNeedClipping(boolean z) {
        this.$$delegate_0.setNeedClipping(z);
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

    public /* synthetic */ DivCustomWrapper(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivCustomWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.$$delegate_0 = new DivHolderViewMixin<>();
    }

    public final View getCustomView() {
        DivCustomWrapper divCustomWrapper = this;
        if (divCustomWrapper.getChildCount() != 0) {
            return ViewGroupKt.get(divCustomWrapper, 0);
        }
        return null;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        onBoundsChanged(w, h);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Unit unit;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        DivCustomWrapper divCustomWrapper = this;
        divCustomWrapper.setDrawing(true);
        DivBorderDrawer divBorderDrawer = divCustomWrapper.getDivBorderDrawer();
        if (divBorderDrawer != null) {
            if (divBorderDrawer != null) {
                int iSave = canvas.save();
                try {
                    divBorderDrawer.clipCorners(canvas);
                    super.draw(canvas);
                    divBorderDrawer.drawBorder(canvas);
                    canvas.restoreToCount(iSave);
                } catch (Throwable th) {
                    canvas.restoreToCount(iSave);
                    throw th;
                }
            } else {
                super.draw(canvas);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.draw(canvas);
        }
        divCustomWrapper.setDrawing(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Unit unit;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        BaseDivViewExtensionsKt.drawChildrenShadows(this, canvas);
        DivCustomWrapper divCustomWrapper = this;
        if (!divCustomWrapper.isDrawing()) {
            DivBorderDrawer divBorderDrawer = divCustomWrapper.getDivBorderDrawer();
            if (divBorderDrawer != null) {
                if (divBorderDrawer != null) {
                    int iSave = canvas.save();
                    try {
                        divBorderDrawer.clipCorners(canvas);
                        super.dispatchDraw(canvas);
                        divBorderDrawer.drawBorder(canvas);
                        canvas.restoreToCount(iSave);
                    } catch (Throwable th) {
                        canvas.restoreToCount(iSave);
                        throw th;
                    }
                } else {
                    super.dispatchDraw(canvas);
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        View customView = getCustomView();
        if (customView != null) {
            int baseline = customView.getBaseline();
            ViewGroup.LayoutParams layoutParams = customView.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            return baseline + (marginLayoutParams != null ? marginLayoutParams.topMargin : 0) + getPaddingTop();
        }
        return super.getBaseline();
    }
}
