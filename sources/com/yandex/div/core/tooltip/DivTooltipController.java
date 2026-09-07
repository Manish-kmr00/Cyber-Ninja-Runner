package com.yandex.div.core.tooltip;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.core.view.ViewGroupKt;
import com.yandex.div.R;
import com.yandex.div.core.DivPreloader;
import com.yandex.div.core.DivTooltipRestrictor;
import com.yandex.div.core.actions.DivActionTypedUtilsKt;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.util.AccessibilityStateProvider;
import com.yandex.div.core.util.SafePopupWindow;
import com.yandex.div.core.util.ViewsKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivVisibilityActionTracker;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.core.view2.errors.ErrorCollectors;
import com.yandex.div.internal.Assert;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivSize;
import com.yandex.div2.DivTooltip;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivTooltipController.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¥\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001*\b\u0011\u0018\u00002\u00020\u0001B7\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB\u0088\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012O\u0010\u000f\u001aK\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0010j\u0002`\u0019¢\u0006\u0002\u0010\u001aJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J \u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'H\u0012J\b\u0010(\u001a\u00020\"H\u0016J\u001f\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020'H\u0012¢\u0006\u0002\u0010.J\u0012\u0010/\u001a\u0004\u0018\u00010\u00112\u0006\u00100\u001a\u00020\u001fH\u0016J\u0018\u00101\u001a\u00020\"2\u0006\u00100\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'H\u0016J \u00102\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u00112\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020,\u0018\u000103H\u0016J(\u00104\u001a\u00020\"2\u0006\u0010+\u001a\u00020,2\u0006\u00105\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$2\u0006\u00106\u001a\u000207H\u0012J\"\u00104\u001a\u00020\"2\u0006\u00108\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u00106\u001a\u000207H\u0016J \u00109\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0011H\u0012J\u0018\u0010=\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010:\u001a\u00020;H\u0012J(\u0010>\u001a\u00020\"2\u0006\u00105\u001a\u00020\u00112\u0006\u0010+\u001a\u00020,2\u0006\u0010#\u001a\u00020$2\u0006\u00106\u001a\u000207H\u0012R\u000e\u0010\n\u001a\u00020\u000bX\u0092\u0004¢\u0006\u0002\n\u0000RW\u0010\u000f\u001aK\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0010j\u0002`\u0019X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eX\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/yandex/div/core/tooltip/DivTooltipController;", "", "tooltipRestrictor", "Lcom/yandex/div/core/DivTooltipRestrictor;", "divVisibilityActionTracker", "Lcom/yandex/div/core/view2/DivVisibilityActionTracker;", "divPreloader", "Lcom/yandex/div/core/DivPreloader;", "divTooltipViewBuilder", "Lcom/yandex/div/core/tooltip/DivTooltipViewBuilder;", "accessibilityStateProvider", "Lcom/yandex/div/core/util/AccessibilityStateProvider;", "errorCollectors", "Lcom/yandex/div/core/view2/errors/ErrorCollectors;", "(Lcom/yandex/div/core/DivTooltipRestrictor;Lcom/yandex/div/core/view2/DivVisibilityActionTracker;Lcom/yandex/div/core/DivPreloader;Lcom/yandex/div/core/tooltip/DivTooltipViewBuilder;Lcom/yandex/div/core/util/AccessibilityStateProvider;Lcom/yandex/div/core/view2/errors/ErrorCollectors;)V", "createPopup", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "contentView", "", "width", "height", "Lcom/yandex/div/core/util/SafePopupWindow;", "Lcom/yandex/div/core/tooltip/CreatePopupCall;", "(Lcom/yandex/div/core/DivTooltipRestrictor;Lcom/yandex/div/core/view2/DivVisibilityActionTracker;Lcom/yandex/div/core/DivPreloader;Lcom/yandex/div/core/view2/errors/ErrorCollectors;Lcom/yandex/div/core/tooltip/DivTooltipViewBuilder;Lcom/yandex/div/core/util/AccessibilityStateProvider;Lkotlin/jvm/functions/Function3;)V", "mainThreadHandler", "Landroid/os/Handler;", "tooltips", "", "", "Lcom/yandex/div/core/tooltip/TooltipData;", "cancelTooltips", "", "context", "Lcom/yandex/div/core/view2/BindingContext;", "view", "div2View", "Lcom/yandex/div/core/view2/Div2View;", "clear", "createOnBackPressCallback", "com/yandex/div/core/tooltip/DivTooltipController$createOnBackPressCallback$1", "divTooltip", "Lcom/yandex/div2/DivTooltip;", "divView", "(Lcom/yandex/div2/DivTooltip;Lcom/yandex/div/core/view2/Div2View;)Lcom/yandex/div/core/tooltip/DivTooltipController$createOnBackPressCallback$1;", "findViewWithTag", "id", "hideTooltip", "mapTooltip", "", "showTooltip", LinkHeader.Parameters.Anchor, "multiple", "", "tooltipId", "startVisibilityTracking", "div", "Lcom/yandex/div2/Div;", "tooltipView", "stopVisibilityTracking", "tryShowTooltip", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public class DivTooltipController {
    private final AccessibilityStateProvider accessibilityStateProvider;
    private final Function3<View, Integer, Integer, SafePopupWindow> createPopup;
    private final DivPreloader divPreloader;
    private final DivTooltipViewBuilder divTooltipViewBuilder;
    private final DivVisibilityActionTracker divVisibilityActionTracker;
    private final ErrorCollectors errorCollectors;
    private final Handler mainThreadHandler;
    private final DivTooltipRestrictor tooltipRestrictor;
    private final Map<String, TooltipData> tooltips;

    /* JADX WARN: Multi-variable type inference failed */
    public DivTooltipController(DivTooltipRestrictor tooltipRestrictor, DivVisibilityActionTracker divVisibilityActionTracker, DivPreloader divPreloader, ErrorCollectors errorCollectors, DivTooltipViewBuilder divTooltipViewBuilder, AccessibilityStateProvider accessibilityStateProvider, Function3<? super View, ? super Integer, ? super Integer, ? extends SafePopupWindow> createPopup) {
        Intrinsics.checkNotNullParameter(tooltipRestrictor, "tooltipRestrictor");
        Intrinsics.checkNotNullParameter(divVisibilityActionTracker, "divVisibilityActionTracker");
        Intrinsics.checkNotNullParameter(divPreloader, "divPreloader");
        Intrinsics.checkNotNullParameter(errorCollectors, "errorCollectors");
        Intrinsics.checkNotNullParameter(divTooltipViewBuilder, "divTooltipViewBuilder");
        Intrinsics.checkNotNullParameter(accessibilityStateProvider, "accessibilityStateProvider");
        Intrinsics.checkNotNullParameter(createPopup, "createPopup");
        this.tooltipRestrictor = tooltipRestrictor;
        this.divVisibilityActionTracker = divVisibilityActionTracker;
        this.divPreloader = divPreloader;
        this.errorCollectors = errorCollectors;
        this.divTooltipViewBuilder = divTooltipViewBuilder;
        this.accessibilityStateProvider = accessibilityStateProvider;
        this.createPopup = createPopup;
        this.tooltips = new LinkedHashMap();
        this.mainThreadHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Inject
    public DivTooltipController(DivTooltipRestrictor tooltipRestrictor, DivVisibilityActionTracker divVisibilityActionTracker, DivPreloader divPreloader, DivTooltipViewBuilder divTooltipViewBuilder, AccessibilityStateProvider accessibilityStateProvider, ErrorCollectors errorCollectors) {
        this(tooltipRestrictor, divVisibilityActionTracker, divPreloader, errorCollectors, divTooltipViewBuilder, accessibilityStateProvider, new Function3<View, Integer, Integer, SafePopupWindow>() { // from class: com.yandex.div.core.tooltip.DivTooltipController.1
            public final SafePopupWindow invoke(View c, int i, int i2) {
                Intrinsics.checkNotNullParameter(c, "c");
                return new DivTooltipWindow(c, i, i2, false, 8, null);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SafePopupWindow invoke(View view, Integer num, Integer num2) {
                return invoke(view, num.intValue(), num2.intValue());
            }
        });
        Intrinsics.checkNotNullParameter(tooltipRestrictor, "tooltipRestrictor");
        Intrinsics.checkNotNullParameter(divVisibilityActionTracker, "divVisibilityActionTracker");
        Intrinsics.checkNotNullParameter(divPreloader, "divPreloader");
        Intrinsics.checkNotNullParameter(divTooltipViewBuilder, "divTooltipViewBuilder");
        Intrinsics.checkNotNullParameter(accessibilityStateProvider, "accessibilityStateProvider");
        Intrinsics.checkNotNullParameter(errorCollectors, "errorCollectors");
    }

    public static /* synthetic */ void showTooltip$default(DivTooltipController divTooltipController, String str, BindingContext bindingContext, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showTooltip");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        divTooltipController.showTooltip(str, bindingContext, z);
    }

    public void showTooltip(String tooltipId, BindingContext context, boolean multiple) {
        Unit unit;
        Intrinsics.checkNotNullParameter(tooltipId, "tooltipId");
        Intrinsics.checkNotNullParameter(context, "context");
        Pair pairFindChildWithTooltip = DivTooltipControllerKt.findChildWithTooltip(tooltipId, context.getDivView());
        if (pairFindChildWithTooltip != null) {
            showTooltip((DivTooltip) pairFindChildWithTooltip.component1(), (View) pairFindChildWithTooltip.component2(), context, multiple);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            DivActionTypedUtilsKt.logError(context.getDivView(), new IllegalStateException("Unable to find view for tooltip '" + tooltipId + '\''));
        }
    }

    private void showTooltip(final DivTooltip divTooltip, final View anchor, final BindingContext context, final boolean multiple) {
        if (this.tooltips.containsKey(divTooltip.id)) {
            return;
        }
        if (ViewsKt.isActuallyLaidOut(anchor) && !anchor.isLayoutRequested()) {
            tryShowTooltip(anchor, divTooltip, context, multiple);
        } else {
            anchor.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yandex.div.core.tooltip.DivTooltipController$showTooltip$$inlined$doOnActualLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    view.removeOnLayoutChangeListener(this);
                    this.this$0.tryShowTooltip(anchor, divTooltip, context, multiple);
                }
            });
        }
        if (ViewsKt.isActuallyLaidOut(anchor) || anchor.isLayoutRequested()) {
            return;
        }
        anchor.requestLayout();
    }

    public void hideTooltip(String id, Div2View div2View) {
        SafePopupWindow popupWindow;
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(div2View, "div2View");
        TooltipData tooltipData = this.tooltips.get(id);
        if (tooltipData == null || (popupWindow = tooltipData.getPopupWindow()) == null) {
            return;
        }
        popupWindow.dismiss();
    }

    public void cancelTooltips(BindingContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        cancelTooltips(context, context.getDivView(), context.getDivView());
    }

    private void cancelTooltips(BindingContext context, View view, Div2View div2View) {
        Object tag = view.getTag(R.id.div_tooltips_tag);
        List<DivTooltip> list = tag instanceof List ? (List) tag : null;
        if (list != null) {
            for (DivTooltip divTooltip : list) {
                ArrayList arrayList = new ArrayList();
                TooltipData tooltipData = this.tooltips.get(divTooltip.id);
                if (tooltipData != null) {
                    tooltipData.setDismissed(true);
                    if (tooltipData.getPopupWindow().isShowing()) {
                        DivTooltipAnimationKt.clearAnimation(tooltipData.getPopupWindow());
                        tooltipData.getPopupWindow().dismiss();
                    } else {
                        arrayList.add(divTooltip.id);
                        stopVisibilityTracking(context, divTooltip.div);
                    }
                    DivPreloader.Ticket ticket = tooltipData.getTicket();
                    if (ticket != null) {
                        ticket.cancel();
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.tooltips.remove((String) it.next());
                }
            }
        }
        if (view instanceof ViewGroup) {
            Iterator<View> it2 = ViewGroupKt.getChildren((ViewGroup) view).iterator();
            while (it2.hasNext()) {
                cancelTooltips(context, it2.next(), div2View);
            }
        }
    }

    public void mapTooltip(View view, List<DivTooltip> tooltips) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTag(R.id.div_tooltips_tag, tooltips);
    }

    public void clear() {
        for (Map.Entry<String, TooltipData> entry : this.tooltips.entrySet()) {
            entry.getValue().getPopupWindow().dismiss();
            DivPreloader.Ticket ticket = entry.getValue().getTicket();
            if (ticket != null) {
                ticket.cancel();
            }
        }
        this.tooltips.clear();
        this.mainThreadHandler.removeCallbacksAndMessages(null);
    }

    public View findViewWithTag(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Set<Map.Entry<String, TooltipData>> setEntrySet = this.tooltips.entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            View contentView = ((TooltipData) ((Map.Entry) it.next()).getValue()).getPopupWindow().getContentView();
            if (contentView != null) {
                arrayList.add(contentView);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            View viewFindViewWithTag = ((View) it2.next()).findViewWithTag(id);
            if (viewFindViewWithTag != null) {
                Intrinsics.checkNotNullExpressionValue(viewFindViewWithTag, "findViewWithTag<View>(id)");
                return viewFindViewWithTag;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryShowTooltip(final View anchor, final DivTooltip divTooltip, final BindingContext context, final boolean multiple) {
        final Div2View divView = context.getDivView();
        if (this.tooltipRestrictor.canShowTooltip(divView, anchor, divTooltip, multiple)) {
            final ExpressionResolver expressionResolver = context.getExpressionResolver();
            final Div div = divTooltip.div;
            DisplayMetrics displayMetrics = anchor.getResources().getDisplayMetrics();
            DivSize width = divTooltip.div.value().getWidth();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "displayMetrics");
            int layoutParamsSize$default = BaseDivViewExtensionsKt.toLayoutParamsSize$default(width, displayMetrics, expressionResolver, null, 4, null);
            int layoutParamsSize$default2 = BaseDivViewExtensionsKt.toLayoutParamsSize$default(divTooltip.div.value().getHeight(), displayMetrics, expressionResolver, null, 4, null);
            final DivTooltipContainer divTooltipContainerBuildTooltipView = this.divTooltipViewBuilder.buildTooltipView(context, div, layoutParamsSize$default, layoutParamsSize$default2);
            final View tooltipView = divTooltipContainerBuildTooltipView.getTooltipView();
            if (tooltipView == null) {
                return;
            }
            final SafePopupWindow safePopupWindowInvoke = this.createPopup.invoke(divTooltipContainerBuildTooltipView, Integer.valueOf(layoutParamsSize$default), Integer.valueOf(layoutParamsSize$default2));
            safePopupWindowInvoke.setTouchable(true);
            safePopupWindowInvoke.setOutsideTouchable(DivTooltipControllerKt.shouldDismissByOutsideTouch(divTooltip, expressionResolver));
            if (Build.VERSION.SDK_INT < 29) {
                safePopupWindowInvoke.setFocusable(DivTooltipControllerKt.isModal(divTooltip));
            } else {
                safePopupWindowInvoke.setFocusable(true);
                safePopupWindowInvoke.setTouchModal(DivTooltipControllerKt.isModal(divTooltip));
            }
            SafePopupWindow safePopupWindow = safePopupWindowInvoke;
            safePopupWindowInvoke.setTouchInterceptor(new PopupWindowTouchListener(safePopupWindow, tooltipView, DivTooltipControllerKt.isModal(divTooltip), DivTooltipControllerKt.shouldDismissByOutsideTouch(divTooltip, expressionResolver)));
            DivTooltipAnimationKt.setupAnimation(safePopupWindow, divTooltip, expressionResolver);
            final TooltipData tooltipData = new TooltipData(safePopupWindowInvoke, div, null, createOnBackPressCallback(divTooltip, divView), false, 16, null);
            safePopupWindowInvoke.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.yandex.div.core.tooltip.DivTooltipController$$ExternalSyntheticLambda0
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    DivTooltipController.tryShowTooltip$lambda$14(this.f$0, divTooltip, context, divTooltipContainerBuildTooltipView, divView, anchor, safePopupWindowInvoke, tooltipData);
                }
            });
            this.tooltips.put(divTooltip.id, tooltipData);
            DivPreloader.Ticket ticketPreload = this.divPreloader.preload(div, expressionResolver, new DivPreloader.Callback() { // from class: com.yandex.div.core.tooltip.DivTooltipController$$ExternalSyntheticLambda1
                @Override // com.yandex.div.core.DivPreloader.Callback
                public final void finish(boolean z) {
                    DivTooltipController.tryShowTooltip$lambda$17(tooltipData, anchor, this, divView, divTooltip, multiple, divTooltipContainerBuildTooltipView, safePopupWindowInvoke, tooltipView, expressionResolver, context, div, z);
                }
            });
            TooltipData tooltipData2 = this.tooltips.get(divTooltip.id);
            if (tooltipData2 == null) {
                return;
            }
            tooltipData2.setTicket(ticketPreload);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryShowTooltip$lambda$14(DivTooltipController this$0, DivTooltip divTooltip, BindingContext context, DivTooltipContainer tooltipContainer, Div2View div2View, View anchor, SafePopupWindow popup, TooltipData tooltipData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(divTooltip, "$divTooltip");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(tooltipContainer, "$tooltipContainer");
        Intrinsics.checkNotNullParameter(div2View, "$div2View");
        Intrinsics.checkNotNullParameter(anchor, "$anchor");
        Intrinsics.checkNotNullParameter(popup, "$popup");
        Intrinsics.checkNotNullParameter(tooltipData, "$tooltipData");
        this$0.tooltips.remove(divTooltip.id);
        this$0.stopVisibilityTracking(context, divTooltip.div);
        Div div = this$0.divVisibilityActionTracker.getDivWithWaitingDisappearActions().get(tooltipContainer);
        if (div != null) {
            this$0.divVisibilityActionTracker.trackDetachedView(context, tooltipContainer, div);
        }
        DivTooltipRestrictor.DivTooltipShownCallback tooltipShownCallback = this$0.tooltipRestrictor.getTooltipShownCallback();
        if (tooltipShownCallback != null) {
            tooltipShownCallback.onDivTooltipDismissed(div2View, anchor, divTooltip);
        }
        DivTooltipControllerKt.removeBackPressedCallback(popup, tooltipData, this$0.accessibilityStateProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryShowTooltip$lambda$17(TooltipData tooltipData, final View anchor, final DivTooltipController this$0, final Div2View div2View, final DivTooltip divTooltip, boolean z, final DivTooltipContainer tooltipContainer, final SafePopupWindow popup, final View tooltipView, final ExpressionResolver resolver, final BindingContext context, final Div div, boolean z2) {
        Intrinsics.checkNotNullParameter(tooltipData, "$tooltipData");
        Intrinsics.checkNotNullParameter(anchor, "$anchor");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(div2View, "$div2View");
        Intrinsics.checkNotNullParameter(divTooltip, "$divTooltip");
        Intrinsics.checkNotNullParameter(tooltipContainer, "$tooltipContainer");
        Intrinsics.checkNotNullParameter(popup, "$popup");
        Intrinsics.checkNotNullParameter(tooltipView, "$tooltipView");
        Intrinsics.checkNotNullParameter(resolver, "$resolver");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(div, "$div");
        if (z2 || tooltipData.getDismissed() || !anchor.isAttachedToWindow() || !this$0.tooltipRestrictor.canShowTooltip(div2View, anchor, divTooltip, z)) {
            return;
        }
        DivTooltipContainer divTooltipContainer = tooltipContainer;
        if (ViewsKt.isActuallyLaidOut(divTooltipContainer) && !divTooltipContainer.isLayoutRequested()) {
            Rect windowFrame = DivTooltipControllerKt.getWindowFrame(div2View);
            Point pointCalcPopupLocation = DivTooltipControllerKt.calcPopupLocation(tooltipView, anchor, divTooltip, resolver);
            int iMin = Math.min(tooltipView.getWidth(), windowFrame.width());
            int iMin2 = Math.min(tooltipView.getHeight(), windowFrame.height());
            if (iMin < tooltipView.getWidth()) {
                this$0.errorCollectors.getOrCreate(div2View.getDataTag(), div2View.getDivData()).logWarning(new Throwable("Tooltip width > screen size, width was changed"));
            }
            if (iMin2 < tooltipView.getHeight()) {
                this$0.errorCollectors.getOrCreate(div2View.getDataTag(), div2View.getDivData()).logWarning(new Throwable("Tooltip height > screen size, height was changed"));
            }
            popup.update(pointCalcPopupLocation.x, pointCalcPopupLocation.y, iMin, iMin2);
            this$0.startVisibilityTracking(context, div, divTooltipContainer);
            DivTooltipRestrictor.DivTooltipShownCallback tooltipShownCallback = this$0.tooltipRestrictor.getTooltipShownCallback();
            if (tooltipShownCallback != null) {
                tooltipShownCallback.onDivTooltipShown(div2View, anchor, divTooltip);
            }
        } else {
            divTooltipContainer.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yandex.div.core.tooltip.DivTooltipController$tryShowTooltip$lambda$17$$inlined$doOnActualLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    view.removeOnLayoutChangeListener(this);
                    Rect windowFrame2 = DivTooltipControllerKt.getWindowFrame(div2View);
                    Point pointCalcPopupLocation2 = DivTooltipControllerKt.calcPopupLocation(tooltipView, anchor, divTooltip, resolver);
                    int iMin3 = Math.min(tooltipView.getWidth(), windowFrame2.width());
                    int iMin4 = Math.min(tooltipView.getHeight(), windowFrame2.height());
                    if (iMin3 < tooltipView.getWidth()) {
                        this$0.errorCollectors.getOrCreate(div2View.getDataTag(), div2View.getDivData()).logWarning(new Throwable("Tooltip width > screen size, width was changed"));
                    }
                    if (iMin4 < tooltipView.getHeight()) {
                        this$0.errorCollectors.getOrCreate(div2View.getDataTag(), div2View.getDivData()).logWarning(new Throwable("Tooltip height > screen size, height was changed"));
                    }
                    popup.update(pointCalcPopupLocation2.x, pointCalcPopupLocation2.y, iMin3, iMin4);
                    this$0.startVisibilityTracking(context, div, tooltipContainer);
                    DivTooltipRestrictor.DivTooltipShownCallback tooltipShownCallback2 = this$0.tooltipRestrictor.getTooltipShownCallback();
                    if (tooltipShownCallback2 != null) {
                        tooltipShownCallback2.onDivTooltipShown(div2View, anchor, divTooltip);
                    }
                }
            });
        }
        popup.showAtLocation(anchor, 0, 0, 0);
        BaseDivViewExtensionsKt.sendAccessibilityEventUnchecked(32, tooltipView, this$0.accessibilityStateProvider);
        if (divTooltip.duration.evaluate(resolver).longValue() != 0) {
            this$0.mainThreadHandler.postDelayed(new Runnable() { // from class: com.yandex.div.core.tooltip.DivTooltipController$tryShowTooltip$lambda$17$$inlined$postDelayed$default$1
                @Override // java.lang.Runnable
                public final void run() {
                    this.this$0.hideTooltip(divTooltip.id, div2View);
                }
            }, divTooltip.duration.evaluate(resolver).longValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.yandex.div.core.tooltip.DivTooltipController$createOnBackPressCallback$1] */
    private C38651 createOnBackPressCallback(final DivTooltip divTooltip, final Div2View divView) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        AccessibilityStateProvider accessibilityStateProvider = this.accessibilityStateProvider;
        Context context = divView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "divView.getContext()");
        if (!accessibilityStateProvider.isAccessibilityEnabled(context)) {
            return null;
        }
        ?? r0 = new OnBackPressedCallback() { // from class: com.yandex.div.core.tooltip.DivTooltipController.createOnBackPressCallback.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                DivTooltipController.this.hideTooltip(divTooltip.id, divView);
            }
        };
        OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = ViewTreeOnBackPressedDispatcherOwner.get(divView);
        if (onBackPressedDispatcherOwner != null && (onBackPressedDispatcher = onBackPressedDispatcherOwner.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.addCallback((OnBackPressedCallback) r0);
            if (onBackPressedDispatcher != null) {
                return r0;
            }
        }
        DivActionTypedUtilsKt.logError(divView, new AssertionError("Can't find onBackPressedDispatcher to set on back press listener on tooltip."));
        Assert.fail("Can't find onBackPressedDispatcher to set on back press listener on tooltip.");
        Unit unit = Unit.INSTANCE;
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startVisibilityTracking(BindingContext context, Div div, View tooltipView) {
        stopVisibilityTracking(context, div);
        DivVisibilityActionTracker.trackVisibilityActionsOf$default(this.divVisibilityActionTracker, context.getDivView(), context.getExpressionResolver(), tooltipView, div, null, 16, null);
    }

    private void stopVisibilityTracking(BindingContext context, Div div) {
        DivVisibilityActionTracker.trackVisibilityActionsOf$default(this.divVisibilityActionTracker, context.getDivView(), context.getExpressionResolver(), null, div, null, 16, null);
    }
}
