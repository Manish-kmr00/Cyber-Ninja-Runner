package com.yandex.div.core.view2.divs.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import androidx.compose.material.OutlinedTextFieldKt;
import com.android.billingclient.api.BillingClient;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.internal.widget.SwitchView;
import com.yandex.div2.DivBorder;
import com.yandex.div2.DivSwitch;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivSwitchView.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u001dH\u0096\u0001J\t\u0010#\u001a\u00020!H\u0096\u0001J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0014J\u0010\u0010'\u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0016J\u000b\u0010(\u001a\u0004\u0018\u00010)H\u0096\u0001J\t\u0010*\u001a\u00020!H\u0096\u0001J\u0019\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0096\u0001J(\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020-2\u0006\u00103\u001a\u00020-H\u0014J\t\u00104\u001a\u00020!H\u0096\u0001J\t\u00105\u001a\u00020!H\u0096\u0001J#\u00106\u001a\u00020!2\u0006\u0010\u0007\u001a\u00020\b2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:H\u0096\u0001J\u0011\u0010;\u001a\u00020!2\u0006\u00109\u001a\u00020:H\u0096\u0001J\u0011\u0010<\u001a\u00020!2\u0006\u00109\u001a\u00020:H\u0096\u0001R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u000f¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0096\u000f¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u00020\u0013X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0013X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\u0018\u001a\u00020\u0013X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006="}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivSwitchView;", "Lcom/yandex/div/internal/widget/SwitchView;", "Lcom/yandex/div/core/view2/divs/widgets/DivHolderView;", "Lcom/yandex/div2/DivSwitch;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "getBindingContext", "()Lcom/yandex/div/core/view2/BindingContext;", "setBindingContext", "(Lcom/yandex/div/core/view2/BindingContext;)V", "div", "getDiv", "()Lcom/yandex/div2/DivSwitch;", "setDiv", "(Lcom/yandex/div2/DivSwitch;)V", "isDrawing", "", "()Z", "setDrawing", "(Z)V", "isTransient", "needClipping", "getNeedClipping", "setNeedClipping", BillingClient.FeatureType.SUBSCRIPTIONS, "", "Lcom/yandex/div/core/Disposable;", "getSubscriptions", "()Ljava/util/List;", "addSubscription", "", "subscription", "closeAllSubscription", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "draw", "getDivBorderDrawer", "Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer;", "invalidateBorder", "onBoundsChanged", "width", "", "height", "onSizeChanged", "w", "h", "oldw", "oldh", "release", "releaseBorderDrawer", "setBorder", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "view", "Landroid/view/View;", "transitionFinished", "transitionStarted", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class DivSwitchView extends SwitchView implements DivHolderView<DivSwitch> {
    private final /* synthetic */ DivHolderViewMixin<DivSwitch> $$delegate_0;

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
    public DivSwitch getDiv() {
        return (DivSwitch) this.$$delegate_0.getDiv();
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
    public void setDiv(DivSwitch divSwitch) {
        this.$$delegate_0.setDiv(divSwitch);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivSwitchView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.$$delegate_0 = new DivHolderViewMixin<>();
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
        DivSwitchView divSwitchView = this;
        divSwitchView.setDrawing(true);
        DivBorderDrawer divBorderDrawer = divSwitchView.getDivBorderDrawer();
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
        divSwitchView.setDrawing(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Unit unit;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        DivSwitchView divSwitchView = this;
        if (!divSwitchView.isDrawing()) {
            DivBorderDrawer divBorderDrawer = divSwitchView.getDivBorderDrawer();
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
}
