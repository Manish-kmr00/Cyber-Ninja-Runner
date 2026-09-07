package com.yandex.div.core.view2.divs.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import androidx.compose.material.OutlinedTextFieldKt;
import com.android.billingclient.api.BillingClient;
import com.yandex.div.R;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.util.text.DivTextRangesBackgroundHelper;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.widget.AdaptiveMaxLines;
import com.yandex.div.internal.util.UiThreadHandler;
import com.yandex.div.internal.widget.TextViewWithAccessibleSpans;
import com.yandex.div2.DivBorder;
import com.yandex.div2.DivText;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivLineHeightTextView.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B%\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010/H\u0096\u0001J\t\u0010;\u001a\u000209H\u0096\u0001J\u0010\u0010<\u001a\u0002092\u0006\u0010=\u001a\u00020>H\u0014J\u0010\u0010?\u001a\u0002092\u0006\u0010=\u001a\u00020>H\u0016J\u000b\u0010@\u001a\u0004\u0018\u00010AH\u0096\u0001J\t\u0010B\u001a\u000209H\u0096\u0001J\u0019\u0010C\u001a\u0002092\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\nH\u0096\u0001J\u0010\u0010F\u001a\u0002092\u0006\u0010=\u001a\u00020>H\u0014J(\u0010G\u001a\u0002092\u0006\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020\n2\u0006\u0010K\u001a\u00020\nH\u0014J\t\u0010L\u001a\u000209H\u0096\u0001J\t\u0010M\u001a\u000209H\u0096\u0001J#\u0010N\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010Q\u001a\u00020RH\u0096\u0001J\b\u0010S\u001a\u000209H\u0016J\b\u0010T\u001a\u000209H\u0016J\u0011\u0010U\u001a\u0002092\u0006\u0010Q\u001a\u00020RH\u0096\u0001J\u0011\u0010V\u001a\u0002092\u0006\u0010Q\u001a\u00020RH\u0096\u0001R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0092\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0096\u000f¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u0004\u0018\u00010\u0003X\u0096\u000f¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010%\u001a\u00020\u0019X\u0096\u000f¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0012\u0010)\u001a\u00020\u0019X\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010&R\u0018\u0010*\u001a\u00020\u0019X\u0096\u000f¢\u0006\f\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R\u0018\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0096\u0005¢\u0006\u0006\u001a\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006W"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivLineHeightTextView;", "Lcom/yandex/div/internal/widget/TextViewWithAccessibleSpans;", "Lcom/yandex/div/core/view2/divs/widgets/DivHolderView;", "Lcom/yandex/div2/DivText;", "Lcom/yandex/div/core/view2/divs/widgets/DivAnimator;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adaptiveMaxLines", "Lcom/yandex/div/core/widget/AdaptiveMaxLines;", "getAdaptiveMaxLines$div_release", "()Lcom/yandex/div/core/widget/AdaptiveMaxLines;", "setAdaptiveMaxLines$div_release", "(Lcom/yandex/div/core/widget/AdaptiveMaxLines;)V", "animationStartDelay", "", "getAnimationStartDelay$div_release", "()J", "setAnimationStartDelay$div_release", "(J)V", "animationStarted", "", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "getBindingContext", "()Lcom/yandex/div/core/view2/BindingContext;", "setBindingContext", "(Lcom/yandex/div/core/view2/BindingContext;)V", "div", "getDiv", "()Lcom/yandex/div2/DivText;", "setDiv", "(Lcom/yandex/div2/DivText;)V", "isDrawing", "()Z", "setDrawing", "(Z)V", "isTransient", "needClipping", "getNeedClipping", "setNeedClipping", BillingClient.FeatureType.SUBSCRIPTIONS, "", "Lcom/yandex/div/core/Disposable;", "getSubscriptions", "()Ljava/util/List;", "textRoundedBgHelper", "Lcom/yandex/div/core/util/text/DivTextRangesBackgroundHelper;", "getTextRoundedBgHelper$div_release", "()Lcom/yandex/div/core/util/text/DivTextRangesBackgroundHelper;", "setTextRoundedBgHelper$div_release", "(Lcom/yandex/div/core/util/text/DivTextRangesBackgroundHelper;)V", "addSubscription", "", "subscription", "closeAllSubscription", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "draw", "getDivBorderDrawer", "Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer;", "invalidateBorder", "onBoundsChanged", "width", "height", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "release", "releaseBorderDrawer", "setBorder", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "view", "Landroid/view/View;", "startDivAnimation", "stopDivAnimation", "transitionFinished", "transitionStarted", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class DivLineHeightTextView extends TextViewWithAccessibleSpans implements DivHolderView<DivText>, DivAnimator {
    private final /* synthetic */ DivHolderViewMixin<DivText> $$delegate_0;
    private AdaptiveMaxLines adaptiveMaxLines;
    private long animationStartDelay;
    private boolean animationStarted;
    private DivTextRangesBackgroundHelper textRoundedBgHelper;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivLineHeightTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivLineHeightTextView(Context context, AttributeSet attributeSet) {
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
    public DivText getDiv() {
        return (DivText) this.$$delegate_0.getDiv();
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
    public void setDiv(DivText divText) {
        this.$$delegate_0.setDiv(divText);
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

    public /* synthetic */ DivLineHeightTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.divTextStyle : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivLineHeightTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.$$delegate_0 = new DivHolderViewMixin<>();
    }

    /* JADX INFO: renamed from: getAdaptiveMaxLines$div_release, reason: from getter */
    public AdaptiveMaxLines getAdaptiveMaxLines() {
        return this.adaptiveMaxLines;
    }

    public void setAdaptiveMaxLines$div_release(AdaptiveMaxLines adaptiveMaxLines) {
        this.adaptiveMaxLines = adaptiveMaxLines;
    }

    /* JADX INFO: renamed from: getTextRoundedBgHelper$div_release, reason: from getter */
    public DivTextRangesBackgroundHelper getTextRoundedBgHelper() {
        return this.textRoundedBgHelper;
    }

    public void setTextRoundedBgHelper$div_release(DivTextRangesBackgroundHelper divTextRangesBackgroundHelper) {
        this.textRoundedBgHelper = divTextRangesBackgroundHelper;
    }

    /* JADX INFO: renamed from: getAnimationStartDelay$div_release, reason: from getter */
    public long getAnimationStartDelay() {
        return this.animationStartDelay;
    }

    public void setAnimationStartDelay$div_release(long j) {
        this.animationStartDelay = j;
    }

    @Override // com.yandex.div.internal.widget.EllipsizedTextView, android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        onBoundsChanged(w, h);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Unit unit;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        DivLineHeightTextView divLineHeightTextView = this;
        divLineHeightTextView.setDrawing(true);
        DivBorderDrawer divBorderDrawer = divLineHeightTextView.getDivBorderDrawer();
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
        divLineHeightTextView.setDrawing(false);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Unit unit;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        DivLineHeightTextView divLineHeightTextView = this;
        if (!divLineHeightTextView.isDrawing()) {
            DivBorderDrawer divBorderDrawer = divLineHeightTextView.getDivBorderDrawer();
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

    @Override // com.yandex.div.core.view2.divs.widgets.DivAnimator
    public void startDivAnimation() {
        super.startDivAnimation();
        this.animationStarted = true;
        UiThreadHandler.get().postDelayed(new Runnable() { // from class: com.yandex.div.core.view2.divs.widgets.DivLineHeightTextView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DivLineHeightTextView.startDivAnimation$lambda$2(this.f$0);
            }
        }, getAnimationStartDelay());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startDivAnimation$lambda$2(DivLineHeightTextView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.animationStarted) {
            this$0.setSelected(true);
        }
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivAnimator
    public void stopDivAnimation() {
        super.stopDivAnimation();
        this.animationStarted = false;
        setSelected(false);
    }

    @Override // com.yandex.div.internal.widget.TextViewWithAccessibleSpans, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        DivTextRangesBackgroundHelper textRoundedBgHelper;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if ((getText() instanceof Spanned) && getLayout() != null && (textRoundedBgHelper = getTextRoundedBgHelper()) != null && textRoundedBgHelper.hasBackgroundSpan$div_release()) {
            float totalPaddingLeft = getTotalPaddingLeft();
            float totalPaddingTop = getTotalPaddingTop();
            int iSave = canvas.save();
            canvas.translate(totalPaddingLeft, totalPaddingTop);
            try {
                DivTextRangesBackgroundHelper textRoundedBgHelper2 = getTextRoundedBgHelper();
                if (textRoundedBgHelper2 != null) {
                    CharSequence text = getText();
                    Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spanned");
                    Layout layout = getLayout();
                    Intrinsics.checkNotNullExpressionValue(layout, "layout");
                    textRoundedBgHelper2.draw(canvas, (Spanned) text, layout);
                }
                canvas.restoreToCount(iSave);
            } catch (Throwable th) {
                canvas.restoreToCount(iSave);
                throw th;
            }
        }
        super.onDraw(canvas);
    }
}
