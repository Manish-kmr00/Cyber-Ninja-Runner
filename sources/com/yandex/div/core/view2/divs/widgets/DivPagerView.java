package com.yandex.div.core.view2.divs.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.viewpager2.widget.ViewPager2;
import com.android.billingclient.api.BillingClient;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yandex.div.R;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.core.view2.divs.pager.PagerSelectedActionsDispatcher;
import com.yandex.div.core.widget.ViewPager2Wrapper;
import com.yandex.div.internal.widget.OnInterceptTouchEventListener;
import com.yandex.div.internal.widget.OnInterceptTouchEventListenerHost;
import com.yandex.div2.DivBorder;
import com.yandex.div2.DivPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivPagerView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000¥\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\r\b\u0010\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0003\u007f\u0080\u0001B%\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u0019H\u0016J\u0013\u0010Y\u001a\u00020W2\b\u0010Z\u001a\u0004\u0018\u00010SH\u0096\u0001J\b\u0010[\u001a\u00020WH\u0016J\t\u0010\\\u001a\u00020WH\u0096\u0001J\u0010\u0010]\u001a\u00020W2\u0006\u0010^\u001a\u00020_H\u0014J\u0010\u0010`\u001a\u00020W2\u0006\u0010^\u001a\u00020_H\u0016J\b\u0010a\u001a\u00020WH\u0016J\u000b\u0010b\u001a\u0004\u0018\u00010cH\u0096\u0001J\u0017\u0010d\u001a\u0004\u0018\u00010\n2\u0006\u0010e\u001a\u00020fH\u0012¢\u0006\u0002\u0010gJ\u0012\u0010h\u001a\u0004\u0018\u00010f2\u0006\u0010i\u001a\u00020\nH\u0016J\t\u0010j\u001a\u00020WH\u0096\u0001J\u0019\u0010k\u001a\u00020W2\u0006\u0010l\u001a\u00020\n2\u0006\u0010m\u001a\u00020\nH\u0096\u0001J\u0010\u0010n\u001a\u00020*2\u0006\u0010o\u001a\u00020pH\u0016J(\u0010q\u001a\u00020W2\u0006\u0010r\u001a\u00020\n2\u0006\u0010s\u001a\u00020\n2\u0006\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020\nH\u0014J\t\u0010v\u001a\u00020WH\u0096\u0001J\t\u0010w\u001a\u00020WH\u0096\u0001J\u0010\u0010x\u001a\u00020W2\u0006\u0010X\u001a\u00020\u0019H\u0016J#\u0010y\u001a\u00020W2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010z\u001a\u0004\u0018\u00010{2\u0006\u0010|\u001a\u00020fH\u0096\u0001J\u0011\u0010}\u001a\u00020W2\u0006\u0010|\u001a\u00020fH\u0096\u0001J\u0011\u0010~\u001a\u00020W2\u0006\u0010|\u001a\u00020fH\u0096\u0001R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8RX\u0092\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019@PX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001f@PX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R(\u0010%\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019@PX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190)X\u0092\u0004¢\u0006\u0002\n\u0000R$\u0010+\u001a\u00020*2\u0006\u0010\u0018\u001a\u00020*8P@PX\u0090\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n8P@PX\u0090\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u0004\u0018\u00010\u0003X\u0096\u000f¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0018\u0010:\u001a\u00020*X\u0096\u000f¢\u0006\f\u001a\u0004\b:\u0010-\"\u0004\b;\u0010/R\u0012\u0010<\u001a\u00020*X\u0096\u0005¢\u0006\u0006\u001a\u0004\b<\u0010-R\u0018\u0010=\u001a\u00020*X\u0096\u000f¢\u0006\f\u001a\u0004\b>\u0010-\"\u0004\b?\u0010/R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR(\u0010M\u001a\u0004\u0018\u00010L2\b\u0010\u0018\u001a\u0004\u0018\u00010L@PX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0018\u0010R\u001a\b\u0012\u0004\u0012\u00020S0)X\u0096\u0005¢\u0006\u0006\u001a\u0004\bT\u0010U¨\u0006\u0081\u0001"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivPagerView;", "Lcom/yandex/div/core/widget/ViewPager2Wrapper;", "Lcom/yandex/div/core/view2/divs/widgets/DivHolderView;", "Lcom/yandex/div2/DivPager;", "Lcom/yandex/div/internal/widget/OnInterceptTouchEventListenerHost;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "accessibilityDelegate", "com/yandex/div/core/view2/divs/widgets/DivPagerView$accessibilityDelegate$2$1", "getAccessibilityDelegate", "()Lcom/yandex/div/core/view2/divs/widgets/DivPagerView$accessibilityDelegate$2$1;", "accessibilityDelegate$delegate", "Lkotlin/Lazy;", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "getBindingContext", "()Lcom/yandex/div/core/view2/BindingContext;", "setBindingContext", "(Lcom/yandex/div/core/view2/BindingContext;)V", "value", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "changePageCallbackForLogger", "getChangePageCallbackForLogger$div_release", "()Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "setChangePageCallbackForLogger$div_release", "(Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;)V", "Lcom/yandex/div/core/view2/divs/widgets/DivPagerView$OffScreenPagesUpdateCallback;", "changePageCallbackForOffScreenPages", "getChangePageCallbackForOffScreenPages$div_release", "()Lcom/yandex/div/core/view2/divs/widgets/DivPagerView$OffScreenPagesUpdateCallback;", "setChangePageCallbackForOffScreenPages$div_release", "(Lcom/yandex/div/core/view2/divs/widgets/DivPagerView$OffScreenPagesUpdateCallback;)V", "changePageCallbackForState", "getChangePageCallbackForState$div_release", "setChangePageCallbackForState$div_release", "changePageCallbacksForIndicators", "", "", "clipToPage", "getClipToPage$div_release", "()Z", "setClipToPage$div_release", "(Z)V", "currentItem", "getCurrentItem$div_release", "()I", "setCurrentItem$div_release", "(I)V", "div", "getDiv", "()Lcom/yandex/div2/DivPager;", "setDiv", "(Lcom/yandex/div2/DivPager;)V", "isDrawing", "setDrawing", "isTransient", "needClipping", "getNeedClipping", "setNeedClipping", "onInterceptTouchEventListener", "Lcom/yandex/div/internal/widget/OnInterceptTouchEventListener;", "getOnInterceptTouchEventListener", "()Lcom/yandex/div/internal/widget/OnInterceptTouchEventListener;", "setOnInterceptTouchEventListener", "(Lcom/yandex/div/internal/widget/OnInterceptTouchEventListener;)V", "pagerOnItemsCountChange", "Lcom/yandex/div/core/view2/divs/widgets/DivPagerView$OnItemsUpdatedCallback;", "getPagerOnItemsCountChange$div_release", "()Lcom/yandex/div/core/view2/divs/widgets/DivPagerView$OnItemsUpdatedCallback;", "setPagerOnItemsCountChange$div_release", "(Lcom/yandex/div/core/view2/divs/widgets/DivPagerView$OnItemsUpdatedCallback;)V", "Lcom/yandex/div/core/view2/divs/pager/PagerSelectedActionsDispatcher;", "pagerSelectedActionsDispatcher", "getPagerSelectedActionsDispatcher$div_release", "()Lcom/yandex/div/core/view2/divs/pager/PagerSelectedActionsDispatcher;", "setPagerSelectedActionsDispatcher$div_release", "(Lcom/yandex/div/core/view2/divs/pager/PagerSelectedActionsDispatcher;)V", BillingClient.FeatureType.SUBSCRIPTIONS, "Lcom/yandex/div/core/Disposable;", "getSubscriptions", "()Ljava/util/List;", "addChangePageCallbackForIndicators", "", "callback", "addSubscription", "subscription", "clearChangePageCallbackForIndicators", "closeAllSubscription", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "draw", "enableAccessibility", "getDivBorderDrawer", "Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer;", "getFocusedChildPos", "child", "Landroid/view/View;", "(Landroid/view/View;)Ljava/lang/Integer;", "getPageView", "index", "invalidateBorder", "onBoundsChanged", "width", "height", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onSizeChanged", "w", "h", "oldw", "oldh", "release", "releaseBorderDrawer", "removeChangePageCallbackForIndicators", "setBorder", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivBorder;", "view", "transitionFinished", "transitionStarted", "OffScreenPagesUpdateCallback", "OnItemsUpdatedCallback", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class DivPagerView extends ViewPager2Wrapper implements DivHolderView<DivPager>, OnInterceptTouchEventListenerHost {
    private final /* synthetic */ DivHolderViewMixin<DivPager> $$delegate_0;

    /* JADX INFO: renamed from: accessibilityDelegate$delegate, reason: from kotlin metadata */
    private final Lazy accessibilityDelegate;
    private ViewPager2.OnPageChangeCallback changePageCallbackForLogger;
    private OffScreenPagesUpdateCallback changePageCallbackForOffScreenPages;
    private ViewPager2.OnPageChangeCallback changePageCallbackForState;
    private final List<ViewPager2.OnPageChangeCallback> changePageCallbacksForIndicators;
    private OnInterceptTouchEventListener onInterceptTouchEventListener;
    private OnItemsUpdatedCallback pagerOnItemsCountChange;
    private PagerSelectedActionsDispatcher pagerSelectedActionsDispatcher;

    /* JADX INFO: compiled from: DivPagerView.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b \u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003JR\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivPagerView$OffScreenPagesUpdateCallback;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "Landroid/view/View$OnLayoutChangeListener;", "()V", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class OffScreenPagesUpdateCallback extends ViewPager2.OnPageChangeCallback implements View.OnLayoutChangeListener {
        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        }
    }

    /* JADX INFO: compiled from: DivPagerView.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivPagerView$OnItemsUpdatedCallback;", "", "onItemsUpdated", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface OnItemsUpdatedCallback {
        void onItemsUpdated();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivPagerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivPagerView(Context context, AttributeSet attributeSet) {
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
    public DivPager getDiv() {
        return (DivPager) this.$$delegate_0.getDiv();
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
    public void setDiv(DivPager divPager) {
        this.$$delegate_0.setDiv(divPager);
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

    public /* synthetic */ DivPagerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivPagerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.$$delegate_0 = new DivHolderViewMixin<>();
        this.changePageCallbacksForIndicators = new ArrayList();
        this.accessibilityDelegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<DivPagerView$accessibilityDelegate$2.AnonymousClass1>() { // from class: com.yandex.div.core.view2.divs.widgets.DivPagerView$accessibilityDelegate$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r1v1, types: [com.yandex.div.core.view2.divs.widgets.DivPagerView$accessibilityDelegate$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                RecyclerView recyclerView = this.this$0.getRecyclerView();
                if (recyclerView == null) {
                    return null;
                }
                recyclerView.setDescendantFocusability(262144);
                return new RecyclerViewAccessibilityDelegate(this.this$0) { // from class: com.yandex.div.core.view2.divs.widgets.DivPagerView$accessibilityDelegate$2.1
                    final /* synthetic */ DivPagerView this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(this.$recycler);
                        this.this$0 = divPagerView;
                    }

                    @Override // androidx.core.view.AccessibilityDelegateCompat
                    public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
                        Integer focusedChildPos;
                        Intrinsics.checkNotNullParameter(host, "host");
                        Intrinsics.checkNotNullParameter(child, "child");
                        Intrinsics.checkNotNullParameter(event, "event");
                        if (event.getEventType() == 32768 && (focusedChildPos = this.this$0.getFocusedChildPos(child)) != null) {
                            DivPagerView divPagerView = this.this$0;
                            RecyclerView recyclerView2 = this.$recycler;
                            int iIntValue = focusedChildPos.intValue();
                            if (divPagerView.getCurrentItem$div_release() != iIntValue) {
                                recyclerView2.performAccessibilityAction(iIntValue > divPagerView.getCurrentItem$div_release() ? 4096 : 8192, null);
                            }
                        }
                        return super.onRequestSendAccessibilityEvent(host, child, event);
                    }
                };
            }
        });
    }

    /* JADX INFO: renamed from: getChangePageCallbackForState$div_release, reason: from getter */
    public ViewPager2.OnPageChangeCallback getChangePageCallbackForState() {
        return this.changePageCallbackForState;
    }

    public void setChangePageCallbackForState$div_release(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback2 = this.changePageCallbackForState;
        if (onPageChangeCallback2 != null) {
            getViewPager().unregisterOnPageChangeCallback(onPageChangeCallback2);
        }
        if (onPageChangeCallback != null) {
            getViewPager().registerOnPageChangeCallback(onPageChangeCallback);
        }
        this.changePageCallbackForState = onPageChangeCallback;
    }

    /* JADX INFO: renamed from: getChangePageCallbackForLogger$div_release, reason: from getter */
    public ViewPager2.OnPageChangeCallback getChangePageCallbackForLogger() {
        return this.changePageCallbackForLogger;
    }

    public void setChangePageCallbackForLogger$div_release(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback2 = this.changePageCallbackForLogger;
        if (onPageChangeCallback2 != null) {
            getViewPager().unregisterOnPageChangeCallback(onPageChangeCallback2);
        }
        if (onPageChangeCallback != null) {
            getViewPager().registerOnPageChangeCallback(onPageChangeCallback);
        }
        this.changePageCallbackForLogger = onPageChangeCallback;
    }

    /* JADX INFO: renamed from: getChangePageCallbackForOffScreenPages$div_release, reason: from getter */
    public OffScreenPagesUpdateCallback getChangePageCallbackForOffScreenPages() {
        return this.changePageCallbackForOffScreenPages;
    }

    public void setChangePageCallbackForOffScreenPages$div_release(OffScreenPagesUpdateCallback offScreenPagesUpdateCallback) {
        OffScreenPagesUpdateCallback offScreenPagesUpdateCallback2 = this.changePageCallbackForOffScreenPages;
        if (offScreenPagesUpdateCallback2 != null) {
            getViewPager().unregisterOnPageChangeCallback(offScreenPagesUpdateCallback2);
            RecyclerView recyclerView = getRecyclerView();
            if (recyclerView != null) {
                recyclerView.removeOnLayoutChangeListener(offScreenPagesUpdateCallback2);
            }
        }
        if (offScreenPagesUpdateCallback != null) {
            getViewPager().registerOnPageChangeCallback(offScreenPagesUpdateCallback);
            RecyclerView recyclerView2 = getRecyclerView();
            if (recyclerView2 != null) {
                recyclerView2.addOnLayoutChangeListener(offScreenPagesUpdateCallback);
            }
        }
        this.changePageCallbackForOffScreenPages = offScreenPagesUpdateCallback;
    }

    /* JADX INFO: renamed from: getPagerSelectedActionsDispatcher$div_release, reason: from getter */
    public PagerSelectedActionsDispatcher getPagerSelectedActionsDispatcher() {
        return this.pagerSelectedActionsDispatcher;
    }

    public void setPagerSelectedActionsDispatcher$div_release(PagerSelectedActionsDispatcher pagerSelectedActionsDispatcher) {
        PagerSelectedActionsDispatcher pagerSelectedActionsDispatcher2 = this.pagerSelectedActionsDispatcher;
        if (pagerSelectedActionsDispatcher2 != null) {
            pagerSelectedActionsDispatcher2.detach(getViewPager());
        }
        if (pagerSelectedActionsDispatcher != null) {
            pagerSelectedActionsDispatcher.attach(getViewPager());
        }
        this.pagerSelectedActionsDispatcher = pagerSelectedActionsDispatcher;
    }

    /* JADX INFO: renamed from: getPagerOnItemsCountChange$div_release, reason: from getter */
    public OnItemsUpdatedCallback getPagerOnItemsCountChange() {
        return this.pagerOnItemsCountChange;
    }

    public void setPagerOnItemsCountChange$div_release(OnItemsUpdatedCallback onItemsUpdatedCallback) {
        this.pagerOnItemsCountChange = onItemsUpdatedCallback;
    }

    public boolean getClipToPage$div_release() {
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            return recyclerView.getClipChildren();
        }
        return false;
    }

    public void setClipToPage$div_release(boolean z) {
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView == null) {
            return;
        }
        recyclerView.setClipChildren(z);
    }

    @Override // com.yandex.div.internal.widget.OnInterceptTouchEventListenerHost
    public OnInterceptTouchEventListener getOnInterceptTouchEventListener() {
        return this.onInterceptTouchEventListener;
    }

    @Override // com.yandex.div.internal.widget.OnInterceptTouchEventListenerHost
    public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener onInterceptTouchEventListener) {
        this.onInterceptTouchEventListener = onInterceptTouchEventListener;
    }

    public int getCurrentItem$div_release() {
        return getViewPager().getCurrentItem();
    }

    public void setCurrentItem$div_release(int i) {
        getViewPager().setCurrentItem(i, false);
    }

    private DivPagerView$accessibilityDelegate$2.AnonymousClass1 getAccessibilityDelegate() {
        return (DivPagerView$accessibilityDelegate$2.AnonymousClass1) this.accessibilityDelegate.getValue();
    }

    public void enableAccessibility() {
        RecyclerView recyclerView;
        DivPagerView$accessibilityDelegate$2.AnonymousClass1 accessibilityDelegate = getAccessibilityDelegate();
        if (accessibilityDelegate == null || (recyclerView = getRecyclerView()) == null) {
            return;
        }
        recyclerView.setAccessibilityDelegateCompat(accessibilityDelegate);
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
        DivPagerView divPagerView = this;
        divPagerView.setDrawing(true);
        DivBorderDrawer divBorderDrawer = divPagerView.getDivBorderDrawer();
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
        divPagerView.setDrawing(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Unit unit;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        BaseDivViewExtensionsKt.drawChildrenShadows(this, canvas);
        DivPagerView divPagerView = this;
        if (!divPagerView.isDrawing()) {
            DivBorderDrawer divBorderDrawer = divPagerView.getDivBorderDrawer();
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

    public void addChangePageCallbackForIndicators(ViewPager2.OnPageChangeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.changePageCallbacksForIndicators.add(callback);
        getViewPager().registerOnPageChangeCallback(callback);
    }

    public void removeChangePageCallbackForIndicators(ViewPager2.OnPageChangeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.changePageCallbacksForIndicators.remove(callback);
        getViewPager().unregisterOnPageChangeCallback(callback);
    }

    public void clearChangePageCallbackForIndicators() {
        Iterator<T> it = this.changePageCallbacksForIndicators.iterator();
        while (it.hasNext()) {
            getViewPager().unregisterOnPageChangeCallback((ViewPager2.OnPageChangeCallback) it.next());
        }
        this.changePageCallbacksForIndicators.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        OnInterceptTouchEventListener onInterceptTouchEventListener = getOnInterceptTouchEventListener();
        return (onInterceptTouchEventListener != null ? onInterceptTouchEventListener.onInterceptTouchEvent(this, event) : false) || super.onInterceptTouchEvent(event);
    }

    public View getPageView(int index) {
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView == null) {
            return null;
        }
        View childAt = recyclerView.getChildAt(index);
        ViewGroup viewGroup = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
        if (viewGroup == null) {
            return null;
        }
        return viewGroup.getChildAt(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer getFocusedChildPos(View child) {
        while (!Intrinsics.areEqual(child, this)) {
            Object tag = child.getTag(R.id.div_pager_item_clip_id);
            Integer num = tag instanceof Integer ? (Integer) tag : null;
            if (num != null) {
                return Integer.valueOf(num.intValue());
            }
            Object parent = child.getParent();
            child = parent instanceof View ? (View) parent : null;
            if (child == null) {
                break;
            }
        }
        return null;
    }
}
