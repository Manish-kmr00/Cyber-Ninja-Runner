package com.yandex.div.core.view2.divs.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.billingclient.api.BillingClient;
import com.yandex.div.R;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Releasable;
import com.yandex.div.core.view2.backbutton.BackHandlingRecyclerView;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.core.view2.divs.gallery.DivGridLayoutManager;
import com.yandex.div.core.view2.divs.gallery.PagerSnapStartHelper;
import com.yandex.div.core.widget.DivViewWrapper;
import com.yandex.div.internal.widget.OnInterceptTouchEventListener;
import com.yandex.div.internal.widget.OnInterceptTouchEventListenerHost;
import com.yandex.div2.DivBorder;
import com.yandex.div2.DivGallery;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivRecyclerView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000 p2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001pB%\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0013\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010@H\u0096\u0001J\b\u0010F\u001a\u00020\u0019H\u0012J\t\u0010G\u001a\u00020DH\u0096\u0001J\u0010\u0010H\u001a\u00020D2\u0006\u0010I\u001a\u00020JH\u0014J\u0010\u0010K\u001a\u00020D2\u0006\u0010I\u001a\u00020JH\u0016J\u0018\u0010L\u001a\u00020\u00192\u0006\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\nH\u0016J\u000b\u0010O\u001a\u0004\u0018\u00010PH\u0096\u0001J\u0012\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010S\u001a\u00020\nH\u0016J\t\u0010T\u001a\u00020DH\u0096\u0001J\u0019\u0010U\u001a\u00020D2\u0006\u0010V\u001a\u00020\n2\u0006\u0010W\u001a\u00020\nH\u0096\u0001J\u0010\u0010X\u001a\u00020\u00192\u0006\u0010Y\u001a\u00020ZH\u0016J\u0010\u0010[\u001a\u00020D2\u0006\u0010\\\u001a\u00020\nH\u0016J\u0018\u0010]\u001a\u00020D2\u0006\u0010^\u001a\u00020\n2\u0006\u0010_\u001a\u00020\nH\u0016J(\u0010`\u001a\u00020D2\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\n2\u0006\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020\nH\u0014J\u0012\u0010e\u001a\u00020\u00192\b\u0010f\u001a\u0004\u0018\u00010ZH\u0017J\b\u0010g\u001a\u00020DH\u0016J\t\u0010h\u001a\u00020DH\u0096\u0001J#\u0010i\u001a\u00020D2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010j\u001a\u0004\u0018\u00010k2\u0006\u0010l\u001a\u00020RH\u0096\u0001J\u0011\u0010m\u001a\u00020D2\u0006\u0010l\u001a\u00020RH\u0096\u0001J\u0011\u0010n\u001a\u00020D2\u0006\u0010l\u001a\u00020RH\u0096\u0001J\f\u0010o\u001a\u00020\n*\u000201H\u0012R\u000e\u0010\f\u001a\u00020\nX\u0092\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u000f¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u00020\u0019X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u00020\u0019X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001aR\u0018\u0010\u001e\u001a\u00020\u0019X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u000e\u0010!\u001a\u00020\u0019X\u0092\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020\nX\u0092\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\nX\u0092\u000e¢\u0006\u0002\n\u0000R$\u00102\u001a\u0002012\u0006\u00100\u001a\u000201@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u000208X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020\nX\u0092\u000e¢\u0006\u0002\n\u0000R\u0018\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?X\u0096\u0005¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006q"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivRecyclerView;", "Lcom/yandex/div/core/view2/backbutton/BackHandlingRecyclerView;", "Lcom/yandex/div/core/view2/divs/widgets/DivHolderView;", "Lcom/yandex/div2/DivGallery;", "Lcom/yandex/div/internal/widget/OnInterceptTouchEventListenerHost;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "beforeScrollFocusPosition", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "getBindingContext", "()Lcom/yandex/div/core/view2/BindingContext;", "setBindingContext", "(Lcom/yandex/div/core/view2/BindingContext;)V", "div", "getDiv", "()Lcom/yandex/div2/DivGallery;", "setDiv", "(Lcom/yandex/div2/DivGallery;)V", "isDrawing", "", "()Z", "setDrawing", "(Z)V", "isTransient", "needClipping", "getNeedClipping", "setNeedClipping", "needFling", "onInterceptTouchEventListener", "Lcom/yandex/div/internal/widget/OnInterceptTouchEventListener;", "getOnInterceptTouchEventListener", "()Lcom/yandex/div/internal/widget/OnInterceptTouchEventListener;", "setOnInterceptTouchEventListener", "(Lcom/yandex/div/internal/widget/OnInterceptTouchEventListener;)V", "pagerSnapStartHelper", "Lcom/yandex/div/core/view2/divs/gallery/PagerSnapStartHelper;", "getPagerSnapStartHelper", "()Lcom/yandex/div/core/view2/divs/gallery/PagerSnapStartHelper;", "setPagerSnapStartHelper", "(Lcom/yandex/div/core/view2/divs/gallery/PagerSnapStartHelper;)V", "pointTouchX", "pointTouchY", "value", "", "scrollInterceptionAngle", "getScrollInterceptionAngle", "()F", "setScrollInterceptionAngle", "(F)V", "scrollMode", "Lcom/yandex/div2/DivGallery$ScrollMode;", "getScrollMode", "()Lcom/yandex/div2/DivGallery$ScrollMode;", "setScrollMode", "(Lcom/yandex/div2/DivGallery$ScrollMode;)V", "scrollPointerId", BillingClient.FeatureType.SUBSCRIPTIONS, "", "Lcom/yandex/div/core/Disposable;", "getSubscriptions", "()Ljava/util/List;", "addSubscription", "", "subscription", "canScroll", "closeAllSubscription", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "draw", "fling", "velocityX", "velocityY", "getDivBorderDrawer", "Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer;", "getItemView", "Landroid/view/View;", "index", "invalidateBorder", "onBoundsChanged", "width", "height", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onScrollStateChanged", "state", "onScrolled", "dx", "dy", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "e", "release", "releaseBorderDrawer", "setBorder", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "view", "transitionFinished", "transitionStarted", "toTouchPoint", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class DivRecyclerView extends BackHandlingRecyclerView implements DivHolderView<DivGallery>, OnInterceptTouchEventListenerHost {
    public static final float NOT_INTERCEPT = 0.0f;
    private static final double RIGHT_ANGLE = 90.0d;
    private final /* synthetic */ DivHolderViewMixin<DivGallery> $$delegate_0;
    private int beforeScrollFocusPosition;
    private boolean needFling;
    private OnInterceptTouchEventListener onInterceptTouchEventListener;
    private PagerSnapStartHelper pagerSnapStartHelper;
    private int pointTouchX;
    private int pointTouchY;
    private float scrollInterceptionAngle;
    private DivGallery.ScrollMode scrollMode;
    private int scrollPointerId;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivRecyclerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivRecyclerView(Context context, AttributeSet attributeSet) {
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
    public DivGallery getDiv() {
        return (DivGallery) this.$$delegate_0.getDiv();
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
    public void setDiv(DivGallery divGallery) {
        this.$$delegate_0.setDiv(divGallery);
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

    public /* synthetic */ DivRecyclerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(new ContextThemeWrapper(context, R.style.Div_Gallery), attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.$$delegate_0 = new DivHolderViewMixin<>();
        this.scrollPointerId = -1;
        this.scrollMode = DivGallery.ScrollMode.DEFAULT;
        this.beforeScrollFocusPosition = -1;
    }

    public float getScrollInterceptionAngle() {
        return this.scrollInterceptionAngle;
    }

    public void setScrollInterceptionAngle(float f) {
        this.scrollInterceptionAngle = f != 0.0f ? Math.abs(f) % 90 : 0.0f;
    }

    @Override // com.yandex.div.internal.widget.OnInterceptTouchEventListenerHost
    public OnInterceptTouchEventListener getOnInterceptTouchEventListener() {
        return this.onInterceptTouchEventListener;
    }

    @Override // com.yandex.div.internal.widget.OnInterceptTouchEventListenerHost
    public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener onInterceptTouchEventListener) {
        this.onInterceptTouchEventListener = onInterceptTouchEventListener;
    }

    public DivGallery.ScrollMode getScrollMode() {
        return this.scrollMode;
    }

    public void setScrollMode(DivGallery.ScrollMode scrollMode) {
        Intrinsics.checkNotNullParameter(scrollMode, "<set-?>");
        this.scrollMode = scrollMode;
    }

    public PagerSnapStartHelper getPagerSnapStartHelper() {
        return this.pagerSnapStartHelper;
    }

    public void setPagerSnapStartHelper(PagerSnapStartHelper pagerSnapStartHelper) {
        this.pagerSnapStartHelper = pagerSnapStartHelper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int velocityX, int velocityY) {
        boolean zFling = super.fling(velocityX, velocityY);
        if (getScrollMode() == DivGallery.ScrollMode.PAGING) {
            this.needFling = !zFling;
        }
        return zFling;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int state) {
        if (state == 2) {
            View focusedChild = getFocusedChild();
            if (focusedChild == null) {
                this.beforeScrollFocusPosition = -1;
                return;
            }
            this.beforeScrollFocusPosition = getChildAdapterPosition(focusedChild);
        }
        super.onScrollStateChanged(state);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0040  */
    /* JADX WARN: Code duplicated, block: B:27:0x0043  */
    /* JADX WARN: Code duplicated, block: B:30:0x0048  */
    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int dx, int dy) {
        int orientation;
        int i;
        int i2;
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
        View view;
        DivViewWrapper divViewWrapper;
        View child;
        if (this.beforeScrollFocusPosition == -1) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            orientation = ((LinearLayoutManager) layoutManager).getOrientation();
        } else {
            orientation = layoutManager instanceof DivGridLayoutManager ? ((DivGridLayoutManager) layoutManager).getOrientation() : 0;
        }
        if (orientation == 1 && dy > 0) {
            i = this.beforeScrollFocusPosition;
        } else if ((orientation != 1 || dy > 0) && dx > 0) {
            i = this.beforeScrollFocusPosition;
        } else {
            int i3 = this.beforeScrollFocusPosition;
            i2 = i3 - 1;
            viewHolderFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(i2);
            if (viewHolderFindViewHolderForAdapterPosition != null) {
                view = viewHolderFindViewHolderForAdapterPosition.itemView;
            } else {
                view = null;
            }
            divViewWrapper = view instanceof DivViewWrapper ? (DivViewWrapper) view : null;
            if (divViewWrapper != null && (child = divViewWrapper.getChild()) != null) {
                child.requestFocus();
            }
            super.onScrolled(dx, dy);
        }
        i2 = i + 1;
        viewHolderFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(i2);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            view = viewHolderFindViewHolderForAdapterPosition.itemView;
        } else {
            view = null;
        }
        if (view instanceof DivViewWrapper) {
        }
        if (divViewWrapper != null) {
            child.requestFocus();
        }
        super.onScrolled(dx, dy);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        int iFindPointerIndex;
        Intrinsics.checkNotNullParameter(event, "event");
        OnInterceptTouchEventListener onInterceptTouchEventListener = getOnInterceptTouchEventListener();
        if (onInterceptTouchEventListener != null ? onInterceptTouchEventListener.onInterceptTouchEvent(this, event) : false) {
            return true;
        }
        if (getScrollInterceptionAngle() == 0.0f) {
            return super.onInterceptTouchEvent(event);
        }
        int actionMasked = event.getActionMasked();
        int actionIndex = event.getActionIndex();
        if (actionMasked == 0) {
            this.scrollPointerId = event.getPointerId(0);
            this.pointTouchX = toTouchPoint(event.getX());
            this.pointTouchY = toTouchPoint(event.getY());
            return super.onInterceptTouchEvent(event);
        }
        if (actionMasked != 2) {
            if (actionMasked == 5) {
                this.scrollPointerId = event.getPointerId(actionIndex);
                this.pointTouchX = toTouchPoint(event.getX(actionIndex));
                this.pointTouchY = toTouchPoint(event.getY(actionIndex));
                return super.onInterceptTouchEvent(event);
            }
            return super.onInterceptTouchEvent(event);
        }
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null || (iFindPointerIndex = event.findPointerIndex(this.scrollPointerId)) < 0) {
            return false;
        }
        int touchPoint = toTouchPoint(event.getX(iFindPointerIndex));
        int touchPoint2 = toTouchPoint(event.getY(iFindPointerIndex));
        if (getScrollState() == 1) {
            return super.onInterceptTouchEvent(event);
        }
        int iAbs = Math.abs(touchPoint - this.pointTouchX);
        int iAbs2 = Math.abs(touchPoint2 - this.pointTouchY);
        if (iAbs == 0 && iAbs2 == 0) {
            return false;
        }
        double dAtan = iAbs != 0 ? (Math.atan(((double) iAbs2) / ((double) iAbs)) * ((double) 180)) / 3.141592653589793d : RIGHT_ANGLE;
        return (layoutManager.canScrollHorizontally() && dAtan <= ((double) getScrollInterceptionAngle())) || (layoutManager.canScrollVertically() && dAtan > ((double) getScrollInterceptionAngle()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent e) {
        RecyclerView.LayoutManager layoutManager;
        PagerSnapStartHelper pagerSnapStartHelper;
        View viewFindSnapView;
        int i;
        if (getScrollMode() == DivGallery.ScrollMode.PAGING) {
            this.needFling = true;
        }
        boolean z = super.onTouchEvent(e) && canScroll();
        if (e == null || e.getActionMasked() != 1 || getScrollMode() != DivGallery.ScrollMode.PAGING || !this.needFling || (layoutManager = getLayoutManager()) == null || (pagerSnapStartHelper = getPagerSnapStartHelper()) == null || (viewFindSnapView = pagerSnapStartHelper.findSnapView(layoutManager)) == null) {
            return z;
        }
        int[] iArrCalculateDistanceToFinalSnap = pagerSnapStartHelper.calculateDistanceToFinalSnap(layoutManager, viewFindSnapView);
        if (iArrCalculateDistanceToFinalSnap.length >= 2 && ((i = iArrCalculateDistanceToFinalSnap[0]) != 0 || iArrCalculateDistanceToFinalSnap[1] != 0)) {
            smoothScrollBy(i, iArrCalculateDistanceToFinalSnap[1]);
        }
        return z;
    }

    private boolean canScroll() {
        return canScrollHorizontally(-1) || canScrollHorizontally(1) || canScrollVertically(-1) || canScrollVertically(1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        onBoundsChanged(w, h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void draw(Canvas canvas) {
        Unit unit;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        DivRecyclerView divRecyclerView = this;
        divRecyclerView.setDrawing(true);
        DivBorderDrawer divBorderDrawer = divRecyclerView.getDivBorderDrawer();
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
        divRecyclerView.setDrawing(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Unit unit;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        BaseDivViewExtensionsKt.drawChildrenShadows(this, canvas);
        DivRecyclerView divRecyclerView = this;
        if (!divRecyclerView.isDrawing()) {
            DivBorderDrawer divBorderDrawer = divRecyclerView.getDivBorderDrawer();
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

    @Override // com.yandex.div.internal.core.ExpressionSubscriber, com.yandex.div.core.view2.Releasable
    public void release() {
        super.release();
        releaseBorderDrawer();
        Object adapter = getAdapter();
        if (adapter instanceof Releasable) {
            ((Releasable) adapter).release();
        }
    }

    public View getItemView(int index) {
        View childAt = getChildAt(index);
        ViewGroup viewGroup = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
        if (viewGroup == null) {
            return null;
        }
        return viewGroup.getChildAt(0);
    }

    private int toTouchPoint(float f) {
        return (int) Math.ceil(f);
    }
}
