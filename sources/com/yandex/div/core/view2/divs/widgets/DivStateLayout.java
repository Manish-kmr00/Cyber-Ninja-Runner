package com.yandex.div.core.view2.divs.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.core.math.MathUtils;
import androidx.core.view.GestureDetectorCompat;
import com.android.billingclient.api.BillingClient;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.internal.widget.FrameContainerLayout;
import com.yandex.div2.Div;
import com.yandex.div2.DivBorder;
import com.yandex.div2.DivState;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivStateLayout.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001fB%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010E\u001a\u00020:2\b\u0010F\u001a\u0004\u0018\u000103H\u0096\u0001J\u0010\u0010G\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020\tH\u0016J\t\u0010I\u001a\u00020:H\u0096\u0001J\u0010\u0010J\u001a\u00020:2\u0006\u0010K\u001a\u00020LH\u0014J\u0010\u0010M\u001a\u00020:2\u0006\u0010K\u001a\u00020LH\u0016J\u000b\u0010N\u001a\u0004\u0018\u00010OH\u0096\u0001J\t\u0010P\u001a\u00020:H\u0096\u0001J\u0019\u0010Q\u001a\u00020:2\u0006\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020\tH\u0096\u0001J\u0010\u0010T\u001a\u00020\u001f2\u0006\u0010U\u001a\u00020VH\u0016J(\u0010W\u001a\u00020:2\u0006\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\t2\u0006\u0010[\u001a\u00020\tH\u0014J\u0010\u0010\\\u001a\u00020\u001f2\u0006\u0010U\u001a\u00020VH\u0017J\t\u0010]\u001a\u00020:H\u0096\u0001J\t\u0010^\u001a\u00020:H\u0096\u0001J#\u0010_\u001a\u00020:2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010`\u001a\u0004\u0018\u00010a2\u0006\u0010b\u001a\u00020cH\u0096\u0001J\u0011\u0010d\u001a\u00020:2\u0006\u0010b\u001a\u00020cH\u0096\u0001J\u0011\u0010e\u001a\u00020:2\u0006\u0010b\u001a\u00020cH\u0096\u0001R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001e\u001a\u00020\u001fX\u0096\u000f¢\u0006\f\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u0012\u0010#\u001a\u00020\u001fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010 R\u0018\u0010$\u001a\u00020\u001fX\u0096\u000f¢\u0006\f\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0013\u0010-\u001a\u0004\u0018\u00010.8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0018\u00101\u001a\b\u0012\u0004\u0012\u00020302X\u0096\u0005¢\u0006\u0006\u001a\u0004\b4\u00105R\u0012\u00106\u001a\u000607R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u00108\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R(\u0010?\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020:\u0018\u00010@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006g"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivStateLayout;", "Lcom/yandex/div/internal/widget/FrameContainerLayout;", "Lcom/yandex/div/core/view2/divs/widgets/DivHolderView;", "Lcom/yandex/div2/DivState;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activeStateDiv", "Lcom/yandex/div2/Div;", "getActiveStateDiv$div_release", "()Lcom/yandex/div2/Div;", "setActiveStateDiv$div_release", "(Lcom/yandex/div2/Div;)V", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "getBindingContext", "()Lcom/yandex/div/core/view2/BindingContext;", "setBindingContext", "(Lcom/yandex/div/core/view2/BindingContext;)V", "div", "getDiv", "()Lcom/yandex/div2/DivState;", "setDiv", "(Lcom/yandex/div2/DivState;)V", "gestureDetector", "Landroidx/core/view/GestureDetectorCompat;", "isDrawing", "", "()Z", "setDrawing", "(Z)V", "isTransient", "needClipping", "getNeedClipping", "setNeedClipping", "path", "Lcom/yandex/div/core/state/DivStatePath;", "getPath", "()Lcom/yandex/div/core/state/DivStatePath;", "setPath", "(Lcom/yandex/div/core/state/DivStatePath;)V", "stateId", "", "getStateId", "()Ljava/lang/String;", BillingClient.FeatureType.SUBSCRIPTIONS, "", "Lcom/yandex/div/core/Disposable;", "getSubscriptions", "()Ljava/util/List;", "swipeListener", "Lcom/yandex/div/core/view2/divs/widgets/DivStateLayout$SwipeListener;", "swipeOutCallback", "Lkotlin/Function0;", "", "getSwipeOutCallback", "()Lkotlin/jvm/functions/Function0;", "setSwipeOutCallback", "(Lkotlin/jvm/functions/Function0;)V", "valueUpdater", "Lkotlin/Function1;", "getValueUpdater", "()Lkotlin/jvm/functions/Function1;", "setValueUpdater", "(Lkotlin/jvm/functions/Function1;)V", "addSubscription", "subscription", "canScrollHorizontally", "direction", "closeAllSubscription", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "draw", "getDivBorderDrawer", "Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer;", "invalidateBorder", "onBoundsChanged", "width", "height", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "release", "releaseBorderDrawer", "setBorder", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "view", "Landroid/view/View;", "transitionFinished", "transitionStarted", "SwipeListener", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivStateLayout extends FrameContainerLayout implements DivHolderView<DivState> {
    private final /* synthetic */ DivHolderViewMixin<DivState> $$delegate_0;
    private Div activeStateDiv;
    private final GestureDetectorCompat gestureDetector;
    private DivStatePath path;
    private final SwipeListener swipeListener;
    private Function0<Unit> swipeOutCallback;
    private Function1<? super String, Unit> valueUpdater;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivStateLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivStateLayout(Context context, AttributeSet attributeSet) {
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
    public DivState getDiv() {
        return (DivState) this.$$delegate_0.getDiv();
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
    public void setDiv(DivState divState) {
        this.$$delegate_0.setDiv(divState);
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

    public /* synthetic */ DivStateLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivStateLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.$$delegate_0 = new DivHolderViewMixin<>();
        SwipeListener swipeListener = new SwipeListener();
        this.swipeListener = swipeListener;
        this.gestureDetector = new GestureDetectorCompat(context, swipeListener, new Handler(Looper.getMainLooper()));
    }

    public final DivStatePath getPath() {
        return this.path;
    }

    public final void setPath(DivStatePath divStatePath) {
        this.path = divStatePath;
    }

    public final String getStateId() {
        DivStatePath divStatePath = this.path;
        if (divStatePath != null) {
            return divStatePath.getLastStateId();
        }
        return null;
    }

    public final Function0<Unit> getSwipeOutCallback() {
        return this.swipeOutCallback;
    }

    public final void setSwipeOutCallback(Function0<Unit> function0) {
        this.swipeOutCallback = function0;
    }

    /* JADX INFO: renamed from: getActiveStateDiv$div_release, reason: from getter */
    public final Div getActiveStateDiv() {
        return this.activeStateDiv;
    }

    public final void setActiveStateDiv$div_release(Div div) {
        this.activeStateDiv = div;
    }

    public final Function1<String, Unit> getValueUpdater() {
        return this.valueUpdater;
    }

    public final void setValueUpdater(Function1<? super String, Unit> function1) {
        this.valueUpdater = function1;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.swipeOutCallback == null) {
            requestDisallowInterceptTouchEvent(false);
            return false;
        }
        this.gestureDetector.onTouchEvent(event);
        requestDisallowInterceptTouchEvent(this.swipeListener.getInScroll());
        if (this.swipeListener.getInScroll()) {
            return true;
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.swipeOutCallback == null) {
            requestDisallowInterceptTouchEvent(false);
            return super.onTouchEvent(event);
        }
        if (event.getAction() == 1 || event.getAction() == 3) {
            this.swipeListener.finishSwipe();
        }
        if (this.gestureDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int direction) {
        if (super.canScrollHorizontally(direction)) {
            return true;
        }
        if (getChildCount() < 1 || this.swipeOutCallback == null) {
            return super.canScrollHorizontally(direction);
        }
        View childAt = getChildAt(0);
        if (direction < 0) {
            if (childAt.getTranslationX() <= childAt.getWidth()) {
                return true;
            }
        } else if ((-childAt.getTranslationX()) <= childAt.getWidth()) {
            return true;
        }
        return false;
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
        DivStateLayout divStateLayout = this;
        divStateLayout.setDrawing(true);
        DivBorderDrawer divBorderDrawer = divStateLayout.getDivBorderDrawer();
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
        divStateLayout.setDrawing(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Unit unit;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        BaseDivViewExtensionsKt.drawChildrenShadows(this, canvas);
        DivStateLayout divStateLayout = this;
        if (!divStateLayout.isDrawing()) {
            DivBorderDrawer divBorderDrawer = divStateLayout.getDivBorderDrawer();
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

    /* JADX INFO: compiled from: DivStateLayout.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J*\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivStateLayout$SwipeListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "(Lcom/yandex/div/core/view2/divs/widgets/DivStateLayout;)V", "inScroll", "", "getInScroll", "()Z", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "canScroll", "v", VastAttributes.HORIZONTAL_POSITION, "", VastAttributes.VERTICAL_POSITION, "dir", "", "finishSwipe", "", "onDown", "e", "Landroid/view/MotionEvent;", "onScroll", "e1", "e2", "distanceX", "distanceY", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class SwipeListener extends GestureDetector.SimpleOnGestureListener {
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            return true;
        }

        public SwipeListener() {
        }

        private final View getView() {
            if (DivStateLayout.this.getChildCount() > 0) {
                return DivStateLayout.this.getChildAt(0);
            }
            return null;
        }

        public final boolean getInScroll() {
            View view = getView();
            return !((view != null ? view.getTranslationX() : 0.0f) == 0.0f);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Intrinsics.checkNotNullParameter(e2, "e2");
            View view = getView();
            if (view == null || e1 == null) {
                return false;
            }
            int iSignum = (int) Math.signum(distanceX);
            if (view.getTranslationX() == 0.0f && Math.abs(distanceX) > 2 * Math.abs(distanceY) && canScroll(view, e1.getX(), e1.getY(), iSignum)) {
                return false;
            }
            view.setTranslationX(MathUtils.clamp(view.getTranslationX() - distanceX, -view.getWidth(), view.getWidth()));
            return !(view.getTranslationX() == 0.0f);
        }

        public final void finishSwipe() {
            float fAbs;
            AnimatorListenerAdapter animatorListenerAdapter;
            float fSignum;
            View view = getView();
            if (view == null) {
                return;
            }
            if (Math.abs(view.getTranslationX()) > view.getWidth() / 2) {
                fAbs = (Math.abs(view.getWidth() - view.getTranslationX()) * 300.0f) / view.getWidth();
                fSignum = Math.signum(view.getTranslationX()) * view.getWidth();
                final DivStateLayout divStateLayout = DivStateLayout.this;
                animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.yandex.div.core.view2.divs.widgets.DivStateLayout$SwipeListener$finishSwipe$1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        Function0<Unit> swipeOutCallback = divStateLayout.getSwipeOutCallback();
                        if (swipeOutCallback != null) {
                            swipeOutCallback.invoke();
                        }
                    }
                };
            } else {
                fAbs = (Math.abs(view.getTranslationX()) * 300.0f) / view.getWidth();
                animatorListenerAdapter = null;
                fSignum = 0.0f;
            }
            view.animate().cancel();
            view.animate().setDuration((long) MathUtils.clamp(fAbs, 0.0f, 300.0f)).translationX(fSignum).setListener(animatorListenerAdapter).start();
        }

        private final boolean canScroll(View v, float x, float y, int dir) {
            if (v instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) v;
                for (int childCount = viewGroup.getChildCount() - 1; -1 < childCount; childCount--) {
                    View child = viewGroup.getChildAt(childCount);
                    if (x >= child.getLeft() && x < child.getRight() && y >= child.getTop() && y < child.getBottom()) {
                        Intrinsics.checkNotNullExpressionValue(child, "child");
                        if (canScroll(child, x - child.getLeft(), y - child.getTop(), dir)) {
                            return true;
                        }
                    }
                }
            }
            return v.canScrollHorizontally(dir);
        }
    }
}
