package com.yandex.div.core.view2.divs;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.json.b9;
import com.yandex.div.R;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.actions.DivActionTypedUtilsKt;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.tooltip.DivTooltipController;
import com.yandex.div.core.util.DivDataExtensionsKt;
import com.yandex.div.core.util.ExpressionSubscribersKt;
import com.yandex.div.core.util.ReleasablesKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivAccessibilityBinder;
import com.yandex.div.core.view2.DivTransitionBuilder;
import com.yandex.div.core.view2.DivViewIdProvider;
import com.yandex.div.core.view2.animations.DivTransitionHandler;
import com.yandex.div.core.view2.animations.DivTransitionsKt;
import com.yandex.div.core.view2.divs.widgets.DivHolderView;
import com.yandex.div.core.view2.divs.widgets.DivPagerView;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.core.ExpressionSubscriber;
import com.yandex.div.internal.core.VariableMutationHandler;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.json.expressions.ExpressionsKt;
import com.yandex.div2.DivAccessibility;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivAlignmentHorizontal;
import com.yandex.div2.DivAlignmentVertical;
import com.yandex.div2.DivBackground;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivData;
import com.yandex.div2.DivFocus;
import com.yandex.div2.DivLayoutProvider;
import com.yandex.div2.DivSize;
import com.yandex.div2.DivTooltip;
import com.yandex.div2.DivTransitionTrigger;
import com.yandex.div2.DivVisibility;
import com.yandex.div2.DivWrapContentSize;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DivBaseBinder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJC\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0000¢\u0006\u0002\b\u001fJ'\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010$H\u0000¢\u0006\u0002\b%J7\u0010&\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b)J(\u0010*\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019JR\u0010-\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010$2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u0002042\u0006\u00107\u001a\u0002042\u0006\u0010'\u001a\u00020(H\u0002J \u00108\u001a\u00020\u0013*\u00020\u00172\b\u00109\u001a\u0004\u0018\u00010$2\b\u0010:\u001a\u0004\u0018\u00010$H\u0002J&\u0010;\u001a\u00020\u0013*\u00020\u00172\u0006\u0010!\u001a\u00020\"2\u0006\u0010<\u001a\u00020\u00192\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\u0016\u0010?\u001a\u00020\u0013*\u00020\u00172\b\u0010@\u001a\u0004\u0018\u00010$H\u0002J\u0014\u0010A\u001a\u00020\u0013*\u00020\u00172\u0006\u0010,\u001a\u00020\u0019H\u0002J,\u0010B\u001a\u00020\u0013*\u00020\u00172\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010C\u001a\u00020DH\u0002J6\u0010E\u001a\u00020\u0013*\u00020\u00172\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J.\u0010F\u001a\u00020\u0013*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J,\u0010G\u001a\u00020\u0013*\u00020\u00172\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J.\u0010H\u001a\u00020\u0013*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J&\u0010I\u001a\u00020\u0013*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020(H\u0002J.\u0010J\u001a\u00020\u0013*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J.\u0010K\u001a\u00020\u0013*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J:\u0010\u0012\u001a\u00020\u0013*\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u001c\u0010L\u001a\u00020\u0013*\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J4\u0010M\u001a\u00020\u0013*\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010O2\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010OH\u0002J.\u0010R\u001a\u00020\u0013*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J&\u0010 \u001a\u00020\u0013*\u00020\u00172\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J.\u0010&\u001a\u00020\u0013*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J.\u0010S\u001a\u00020\u0013*\u00020\u00172\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020(H\u0002J.\u0010T\u001a\u00020\u0013*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J6\u0010U\u001a\u00020\u0013*\u00020\u00172\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002JU\u0010V\u001a\u00020\u0013*\u00020\u00172\u000e\u0010W\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010X2\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010X2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001c2\u0016\b\u0004\u0010Z\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010$\u0012\u0004\u0012\u00020\u00130[H\u0082\bJ.\u0010\\\u001a\u00020\u0013*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J.\u0010]\u001a\u00020\u0013*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J6\u0010^\u001a\u00020\u0013*\u00020\u00172\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J.\u0010_\u001a\u00020\u0013*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\f\u0010`\u001a\u00020\u0013*\u00020\u0017H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\f*\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006a"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivBaseBinder;", "", "divBackgroundBinder", "Lcom/yandex/div/core/view2/divs/DivBackgroundBinder;", "tooltipController", "Lcom/yandex/div/core/tooltip/DivTooltipController;", "divFocusBinder", "Lcom/yandex/div/core/view2/divs/DivFocusBinder;", "divAccessibilityBinder", "Lcom/yandex/div/core/view2/DivAccessibilityBinder;", "(Lcom/yandex/div/core/view2/divs/DivBackgroundBinder;Lcom/yandex/div/core/tooltip/DivTooltipController;Lcom/yandex/div/core/view2/divs/DivFocusBinder;Lcom/yandex/div/core/view2/DivAccessibilityBinder;)V", SDKConstants.PARAM_CONTEXT_MAX_SIZE, "Lcom/yandex/div2/DivWrapContentSize$ConstraintSize;", "Lcom/yandex/div2/DivSize;", "getMaxSize", "(Lcom/yandex/div2/DivSize;)Lcom/yandex/div2/DivWrapContentSize$ConstraintSize;", SDKConstants.PARAM_CONTEXT_MIN_SIZE, "getMinSize", "bindBackground", "", "context", "Lcom/yandex/div/core/view2/BindingContext;", TypedValues.AttributesType.S_TARGET, "Landroid/view/View;", "newDiv", "Lcom/yandex/div2/DivBase;", "oldDiv", "subscriber", "Lcom/yandex/div/internal/core/ExpressionSubscriber;", "additionalLayer", "Landroid/graphics/drawable/Drawable;", "bindBackground$div_release", "bindId", "divView", "Lcom/yandex/div/core/view2/Div2View;", "id", "", "bindId$div_release", "bindLayoutParams", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "bindLayoutParams$div_release", "bindView", "view", "div", "updateSizeVariable", "metrics", "Landroid/util/DisplayMetrics;", "variableName", "variablesHolder", "Lcom/yandex/div/core/view2/divs/DivLayoutProviderVariablesHolder;", "start", "", "end", "oldStart", "oldEnd", "applyAccessibilityDescriptionAndHint", "contentDescription", ViewHierarchyConstants.HINT_KEY, "applyAccessibilityMode", "base", b9.a.t, "Lcom/yandex/div2/DivAccessibility$Mode;", "applyAccessibilityStateDescription", "stateDescription", "applyFocusableState", "applyVisibility", "firstApply", "", "bindAccessibility", "bindAccessibilityDescriptionAndHint", "bindAccessibilityMode", "bindAccessibilityStateDescription", "bindAccessibilityType", "bindAlignment", "bindAlpha", "bindBorder", "bindFocusActions", "onFocus", "", "Lcom/yandex/div2/DivAction;", "onBlur", "bindHeight", "bindLayoutProvider", "bindMargins", "bindNextFocus", "bindNextFocusId", "newFocusId", "Lcom/yandex/div/json/expressions/Expression;", "oldFocusId", "applyNextFocusId", "Lkotlin/Function1;", "bindPaddings", "bindTransform", "bindVisibility", "bindWidth", "clearLayoutProviderVariables", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class DivBaseBinder {
    private final DivAccessibilityBinder divAccessibilityBinder;
    private final DivBackgroundBinder divBackgroundBinder;
    private final DivFocusBinder divFocusBinder;
    private final DivTooltipController tooltipController;

    /* JADX INFO: compiled from: DivBaseBinder.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DivVisibility.values().length];
            try {
                iArr[DivVisibility.VISIBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DivVisibility.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DivVisibility.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public DivBaseBinder(DivBackgroundBinder divBackgroundBinder, DivTooltipController tooltipController, DivFocusBinder divFocusBinder, DivAccessibilityBinder divAccessibilityBinder) {
        Intrinsics.checkNotNullParameter(divBackgroundBinder, "divBackgroundBinder");
        Intrinsics.checkNotNullParameter(tooltipController, "tooltipController");
        Intrinsics.checkNotNullParameter(divFocusBinder, "divFocusBinder");
        Intrinsics.checkNotNullParameter(divAccessibilityBinder, "divAccessibilityBinder");
        this.divBackgroundBinder = divBackgroundBinder;
        this.tooltipController = tooltipController;
        this.divFocusBinder = divFocusBinder;
        this.divAccessibilityBinder = divAccessibilityBinder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void bindView(BindingContext context, View view, DivBase div, DivBase oldDiv) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        ExpressionResolver expressionResolver = context.getExpressionResolver();
        DivHolderView divHolderView = (DivHolderView) view;
        divHolderView.closeAllSubscription();
        divHolderView.setDiv(div);
        divHolderView.setBindingContext(context);
        Div2View divView = context.getDivView();
        ExpressionSubscriber expressionSubscriber = ReleasablesKt.getExpressionSubscriber(view);
        if (Build.VERSION.SDK_INT >= 26) {
            view.setDefaultFocusHighlightEnabled(false);
        }
        bindId(view, divView, div, oldDiv);
        bindLayoutParams(view, div, oldDiv, expressionResolver, expressionSubscriber);
        bindLayoutProvider(view, divView, div, oldDiv, expressionResolver);
        bindAccessibility(view, divView, div, oldDiv, expressionResolver, expressionSubscriber);
        bindAlpha(view, div, oldDiv, expressionResolver, expressionSubscriber);
        bindBackground$default(this, view, context, div, oldDiv, expressionSubscriber, null, 16, null);
        bindBorder(view, context, div);
        bindPaddings(view, div, oldDiv, expressionResolver, expressionSubscriber);
        bindNextFocus(view, divView, div, oldDiv, expressionResolver, expressionSubscriber);
        DivFocus focus = div.getFocus();
        List<DivAction> list = focus != null ? focus.onFocus : null;
        DivFocus focus2 = div.getFocus();
        bindFocusActions(view, context, list, focus2 != null ? focus2.onBlur : null);
        bindVisibility(view, divView, div, oldDiv, expressionResolver, expressionSubscriber);
        bindTransform(view, div, oldDiv, expressionResolver, expressionSubscriber);
        List<DivTooltip> tooltips = div.getTooltips();
        if (tooltips != null) {
            this.tooltipController.mapTooltip(view, tooltips);
        }
        if (this.divAccessibilityBinder.getEnabled()) {
            return;
        }
        applyFocusableState(view, div);
    }

    public final void bindId$div_release(Div2View divView, View target, String id) {
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(target, "target");
        BaseDivViewExtensionsKt.applyId(target, id, id == null ? -1 : divView.getViewComponent().getViewIdProvider().getViewId(id));
    }

    private final void bindId(View view, Div2View div2View, DivBase divBase, DivBase divBase2) {
        if (Intrinsics.areEqual(divBase.getId(), divBase2 != null ? divBase2.getId() : null)) {
            return;
        }
        BaseDivViewExtensionsKt.applyId(view, divBase.getId(), div2View.getViewComponent().getViewIdProvider().getViewId(divBase.getId()));
    }

    public final void bindLayoutParams$div_release(View target, DivBase newDiv, DivBase oldDiv, ExpressionResolver resolver, ExpressionSubscriber subscriber) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(newDiv, "newDiv");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        bindLayoutParams(target, newDiv, oldDiv, resolver, subscriber);
    }

    private final void bindLayoutParams(View view, DivBase divBase, DivBase divBase2, ExpressionResolver expressionResolver, ExpressionSubscriber expressionSubscriber) {
        if (view.getLayoutParams() == null) {
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("LayoutParams should be initialized before view binding");
            }
            view.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        }
        bindWidth(view, divBase, divBase2, expressionResolver, expressionSubscriber);
        bindHeight(view, divBase, divBase2, expressionResolver, expressionSubscriber);
        bindMargins(view, divBase, divBase2, expressionResolver, expressionSubscriber);
        bindAlignment(view, divBase, divBase2, expressionResolver, expressionSubscriber);
    }

    private final void bindWidth(final View view, final DivBase divBase, DivBase divBase2, final ExpressionResolver expressionResolver, ExpressionSubscriber expressionSubscriber) {
        if (DivDataExtensionsKt.equalsToConstant(divBase.getWidth(), divBase2 != null ? divBase2.getWidth() : null)) {
            return;
        }
        BaseDivViewExtensionsKt.applyWidth(view, divBase, expressionResolver);
        BaseDivViewExtensionsKt.applyHorizontalWeightValue(view, BaseDivViewExtensionsKt.getWeight(divBase.getWidth(), expressionResolver));
        BaseDivViewExtensionsKt.applyMinWidth(view, getMinSize(divBase.getWidth()), expressionResolver);
        BaseDivViewExtensionsKt.applyMaxWidth(view, getMaxSize(divBase.getWidth()), expressionResolver);
        if (DivDataExtensionsKt.isConstant(divBase.getWidth())) {
            return;
        }
        ExpressionSubscribersKt.observeSize(expressionSubscriber, divBase.getWidth(), expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivBaseBinder.bindWidth.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                BaseDivViewExtensionsKt.applyWidth(view, divBase, expressionResolver);
                BaseDivViewExtensionsKt.applyHorizontalWeightValue(view, BaseDivViewExtensionsKt.getWeight(divBase.getWidth(), expressionResolver));
                BaseDivViewExtensionsKt.applyMinWidth(view, this.getMinSize(divBase.getWidth()), expressionResolver);
                BaseDivViewExtensionsKt.applyMaxWidth(view, this.getMaxSize(divBase.getWidth()), expressionResolver);
            }
        });
    }

    private final void bindHeight(final View view, final DivBase divBase, DivBase divBase2, final ExpressionResolver expressionResolver, ExpressionSubscriber expressionSubscriber) {
        if (DivDataExtensionsKt.equalsToConstant(divBase.getHeight(), divBase2 != null ? divBase2.getHeight() : null)) {
            return;
        }
        BaseDivViewExtensionsKt.applyHeight(view, divBase, expressionResolver);
        BaseDivViewExtensionsKt.applyVerticalWeightValue(view, BaseDivViewExtensionsKt.getWeight(divBase.getHeight(), expressionResolver));
        BaseDivViewExtensionsKt.applyMinHeight(view, getMinSize(divBase.getHeight()), expressionResolver);
        BaseDivViewExtensionsKt.applyMaxHeight(view, getMaxSize(divBase.getHeight()), expressionResolver);
        if (DivDataExtensionsKt.isConstant(divBase.getHeight())) {
            return;
        }
        ExpressionSubscribersKt.observeSize(expressionSubscriber, divBase.getHeight(), expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivBaseBinder.bindHeight.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                BaseDivViewExtensionsKt.applyHeight(view, divBase, expressionResolver);
                BaseDivViewExtensionsKt.applyVerticalWeightValue(view, BaseDivViewExtensionsKt.getWeight(divBase.getHeight(), expressionResolver));
                BaseDivViewExtensionsKt.applyMinHeight(view, this.getMinSize(divBase.getHeight()), expressionResolver);
                BaseDivViewExtensionsKt.applyMaxHeight(view, this.getMaxSize(divBase.getHeight()), expressionResolver);
            }
        });
    }

    private final void bindMargins(final View view, final DivBase divBase, DivBase divBase2, final ExpressionResolver expressionResolver, ExpressionSubscriber expressionSubscriber) {
        if (DivDataExtensionsKt.equalsToConstant(divBase.getMargins(), divBase2 != null ? divBase2.getMargins() : null)) {
            return;
        }
        BaseDivViewExtensionsKt.applyMargins(view, divBase.getMargins(), expressionResolver);
        if (DivDataExtensionsKt.isConstant(divBase.getMargins())) {
            return;
        }
        ExpressionSubscribersKt.observeEdgeInsets(expressionSubscriber, divBase.getMargins(), expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivBaseBinder.bindMargins.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                BaseDivViewExtensionsKt.applyMargins(view, divBase.getMargins(), expressionResolver);
            }
        });
    }

    private final void bindAlignment(final View view, final DivBase divBase, DivBase divBase2, final ExpressionResolver expressionResolver, ExpressionSubscriber expressionSubscriber) {
        if (ExpressionsKt.equalsToConstant(divBase.getAlignmentHorizontal(), divBase2 != null ? divBase2.getAlignmentHorizontal() : null)) {
            if (ExpressionsKt.equalsToConstant(divBase.getAlignmentVertical(), divBase2 != null ? divBase2.getAlignmentVertical() : null)) {
                return;
            }
        }
        Expression<DivAlignmentHorizontal> alignmentHorizontal = divBase.getAlignmentHorizontal();
        DivAlignmentHorizontal divAlignmentHorizontalEvaluate = alignmentHorizontal != null ? alignmentHorizontal.evaluate(expressionResolver) : null;
        Expression<DivAlignmentVertical> alignmentVertical = divBase.getAlignmentVertical();
        BaseDivViewExtensionsKt.applyAlignment(view, divAlignmentHorizontalEvaluate, alignmentVertical != null ? alignmentVertical.evaluate(expressionResolver) : null);
        if (ExpressionsKt.isConstantOrNull(divBase.getAlignmentHorizontal()) && ExpressionsKt.isConstantOrNull(divBase.getAlignmentVertical())) {
            return;
        }
        Function1<? super DivAlignmentHorizontal, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivBaseBinder$bindAlignment$callback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "<anonymous parameter 0>");
                View view2 = view;
                Expression<DivAlignmentHorizontal> alignmentHorizontal2 = divBase.getAlignmentHorizontal();
                DivAlignmentHorizontal divAlignmentHorizontalEvaluate2 = alignmentHorizontal2 != null ? alignmentHorizontal2.evaluate(expressionResolver) : null;
                Expression<DivAlignmentVertical> alignmentVertical2 = divBase.getAlignmentVertical();
                BaseDivViewExtensionsKt.applyAlignment(view2, divAlignmentHorizontalEvaluate2, alignmentVertical2 != null ? alignmentVertical2.evaluate(expressionResolver) : null);
            }
        };
        Expression<DivAlignmentHorizontal> alignmentHorizontal2 = divBase.getAlignmentHorizontal();
        expressionSubscriber.addSubscription(alignmentHorizontal2 != null ? alignmentHorizontal2.observe(expressionResolver, function1) : null);
        Expression<DivAlignmentVertical> alignmentVertical2 = divBase.getAlignmentVertical();
        expressionSubscriber.addSubscription(alignmentVertical2 != null ? alignmentVertical2.observe(expressionResolver, function1) : null);
    }

    private final void bindLayoutProvider(final View view, final Div2View div2View, DivBase divBase, DivBase divBase2, final ExpressionResolver expressionResolver) {
        DivLayoutProvider layoutProvider;
        String str;
        DivLayoutProvider layoutProvider2;
        DivLayoutProvider layoutProvider3;
        DivData divData = div2View.getDivData();
        if (divData == null || (layoutProvider = divBase.getLayoutProvider()) == null) {
            return;
        }
        if (StringsKt.equals$default(layoutProvider.widthVariableName, (divBase2 == null || (layoutProvider3 = divBase2.getLayoutProvider()) == null) ? null : layoutProvider3.widthVariableName, false, 2, null)) {
            if (StringsKt.equals$default(layoutProvider.heightVariableName, (divBase2 == null || (layoutProvider2 = divBase2.getLayoutProvider()) == null) ? null : layoutProvider2.heightVariableName, false, 2, null)) {
                return;
            }
        }
        if ((divBase2 != null ? divBase2.getLayoutProvider() : null) != null) {
            clearLayoutProviderVariables(view);
        }
        final String str2 = layoutProvider.widthVariableName;
        final String str3 = layoutProvider.heightVariableName;
        String str4 = str2;
        if ((str4 == null || str4.length() == 0) && ((str = str3) == null || str.length() == 0)) {
            DivActionTypedUtilsKt.logError(div2View, new Throwable("Neither width_variable_name nor height_variable_name found."));
            return;
        }
        DivLayoutProviderVariablesHolder divLayoutProviderVariablesHolder = div2View.getVariablesHolders$div_release().get(divData);
        if (divLayoutProviderVariablesHolder == null) {
            divLayoutProviderVariablesHolder = new DivLayoutProviderVariablesHolder();
            divLayoutProviderVariablesHolder.observeDivData(divData, expressionResolver);
            div2View.getVariablesHolders$div_release().put(divData, divLayoutProviderVariablesHolder);
        }
        final DivLayoutProviderVariablesHolder divLayoutProviderVariablesHolder2 = divLayoutProviderVariablesHolder;
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.yandex.div.core.view2.divs.DivBaseBinder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                DivBaseBinder.bindLayoutProvider$lambda$5(view, this, div2View, str2, divLayoutProviderVariablesHolder2, expressionResolver, str3, view2, i, i2, i3, i4, i5, i6, i7, i8);
            }
        };
        if (view.getWidth() > 0 || view.getHeight() > 0) {
            onLayoutChangeListener.onLayoutChange(view, view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), 0, 0, 0, 0);
        }
        view.addOnLayoutChangeListener(onLayoutChangeListener);
        view.setTag(R.id.div_layout_provider_listener_id, onLayoutChangeListener);
        if (div2View.getClearVariablesListener() != null) {
            return;
        }
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.yandex.div.core.view2.divs.DivBaseBinder$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return DivBaseBinder.bindLayoutProvider$lambda$8(divLayoutProviderVariablesHolder2, div2View);
            }
        };
        div2View.setClearVariablesListener$div_release(onPreDrawListener);
        div2View.getViewTreeObserver().addOnPreDrawListener(onPreDrawListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindLayoutProvider$lambda$5(View this_bindLayoutProvider, DivBaseBinder this$0, Div2View divView, String str, DivLayoutProviderVariablesHolder variablesHolder, ExpressionResolver resolver, String str2, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(this_bindLayoutProvider, "$this_bindLayoutProvider");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(divView, "$divView");
        Intrinsics.checkNotNullParameter(variablesHolder, "$variablesHolder");
        Intrinsics.checkNotNullParameter(resolver, "$resolver");
        DisplayMetrics metrics = this_bindLayoutProvider.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
        this$0.updateSizeVariable(divView, metrics, str, variablesHolder, i, i3, i5, i7, resolver);
        this$0.updateSizeVariable(divView, metrics, str2, variablesHolder, i2, i4, i6, i8, resolver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindLayoutProvider$lambda$8(DivLayoutProviderVariablesHolder variablesHolder, Div2View divView) {
        Intrinsics.checkNotNullParameter(variablesHolder, "$variablesHolder");
        Intrinsics.checkNotNullParameter(divView, "$divView");
        variablesHolder.clear();
        for (Map.Entry<ExpressionResolver, Map<String, Integer>> entry : divView.getLayoutSizes$div_release().entrySet()) {
            ExpressionResolver key = entry.getKey();
            for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
                VariableMutationHandler.INSTANCE.setVariable(divView, entry2.getKey(), String.valueOf(entry2.getValue().intValue()), key);
            }
        }
        divView.getLayoutSizes$div_release().clear();
        return true;
    }

    private final void updateSizeVariable(Div2View divView, DisplayMetrics metrics, String variableName, DivLayoutProviderVariablesHolder variablesHolder, int start, int end, int oldStart, int oldEnd, ExpressionResolver resolver) {
        int i;
        String str = variableName;
        if (str == null || str.length() == 0 || (i = end - start) == oldEnd - oldStart) {
            return;
        }
        if (variablesHolder.contains(variableName)) {
            DivActionTypedUtilsKt.logError(divView, new Throwable("Size subscriber affects original view size. Relayout was prevented."));
            return;
        }
        Map<ExpressionResolver, Map<String, Integer>> layoutSizes$div_release = divView.getLayoutSizes$div_release();
        LinkedHashMap linkedHashMap = layoutSizes$div_release.get(resolver);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap();
            layoutSizes$div_release.put(resolver, linkedHashMap);
        }
        linkedHashMap.put(variableName, Integer.valueOf(BaseDivViewExtensionsKt.pxToDp(Integer.valueOf(i), metrics)));
    }

    private final void clearLayoutProviderVariables(View view) {
        Object tag = view.getTag(R.id.div_layout_provider_listener_id);
        view.removeOnLayoutChangeListener(tag instanceof View.OnLayoutChangeListener ? (View.OnLayoutChangeListener) tag : null);
    }

    private final void bindPaddings(final View view, final DivBase divBase, DivBase divBase2, final ExpressionResolver expressionResolver, ExpressionSubscriber expressionSubscriber) {
        if (view instanceof DivPagerView) {
            return;
        }
        if (DivDataExtensionsKt.equalsToConstant(divBase.getPaddings(), divBase2 != null ? divBase2.getPaddings() : null)) {
            return;
        }
        BaseDivViewExtensionsKt.applyPaddings(view, divBase.getPaddings(), expressionResolver);
        if (DivDataExtensionsKt.isConstant(divBase.getPaddings())) {
            return;
        }
        ExpressionSubscribersKt.observeEdgeInsets(expressionSubscriber, divBase.getPaddings(), expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivBaseBinder.bindPaddings.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                BaseDivViewExtensionsKt.applyPaddings(view, divBase.getPaddings(), expressionResolver);
            }
        });
    }

    private final void bindAccessibility(View view, Div2View div2View, DivBase divBase, DivBase divBase2, ExpressionResolver expressionResolver, ExpressionSubscriber expressionSubscriber) {
        if (divBase.getAccessibility() == null) {
            if ((divBase2 != null ? divBase2.getAccessibility() : null) == null) {
                applyAccessibilityMode(view, div2View, divBase, null);
                this.divAccessibilityBinder.bindType(view, divBase, DivAccessibility.Type.AUTO, expressionResolver);
                return;
            }
        }
        bindAccessibilityType(view, divBase, divBase2, expressionResolver);
        bindAccessibilityDescriptionAndHint(view, divBase, divBase2, expressionResolver, expressionSubscriber);
        bindAccessibilityMode(view, div2View, divBase, expressionResolver, expressionSubscriber);
        bindAccessibilityStateDescription(view, divBase, divBase2, expressionResolver, expressionSubscriber);
    }

    private final void bindAccessibilityType(View view, DivBase divBase, DivBase divBase2, ExpressionResolver expressionResolver) {
        DivAccessibility.Type type;
        if (divBase2 != null) {
            DivAccessibility accessibility = divBase.getAccessibility();
            DivAccessibility.Type type2 = accessibility != null ? accessibility.type : null;
            DivAccessibility accessibility2 = divBase2.getAccessibility();
            if (type2 == (accessibility2 != null ? accessibility2.type : null)) {
                return;
            }
        }
        DivAccessibilityBinder divAccessibilityBinder = this.divAccessibilityBinder;
        DivAccessibility accessibility3 = divBase.getAccessibility();
        if (accessibility3 == null || (type = accessibility3.type) == null) {
            type = DivAccessibility.Type.AUTO;
        }
        divAccessibilityBinder.bindType(view, divBase, type, expressionResolver);
    }

    private final void bindAccessibilityDescriptionAndHint(final View view, final DivBase divBase, DivBase divBase2, final ExpressionResolver expressionResolver, ExpressionSubscriber expressionSubscriber) {
        Expression<String> expression;
        Expression<String> expression2;
        Expression<String> expression3;
        Expression<String> expression4;
        DivAccessibility accessibility;
        DivAccessibility accessibility2;
        DivAccessibility accessibility3 = divBase.getAccessibility();
        Disposable disposableObserve = null;
        if (ExpressionsKt.equalsToConstant(accessibility3 != null ? accessibility3.description : null, (divBase2 == null || (accessibility2 = divBase2.getAccessibility()) == null) ? null : accessibility2.description)) {
            DivAccessibility accessibility4 = divBase.getAccessibility();
            if (ExpressionsKt.equalsToConstant(accessibility4 != null ? accessibility4.hint : null, (divBase2 == null || (accessibility = divBase2.getAccessibility()) == null) ? null : accessibility.hint)) {
                return;
            }
        }
        DivAccessibility accessibility5 = divBase.getAccessibility();
        String strEvaluate = (accessibility5 == null || (expression4 = accessibility5.description) == null) ? null : expression4.evaluate(expressionResolver);
        DivAccessibility accessibility6 = divBase.getAccessibility();
        applyAccessibilityDescriptionAndHint(view, strEvaluate, (accessibility6 == null || (expression3 = accessibility6.hint) == null) ? null : expression3.evaluate(expressionResolver));
        DivAccessibility accessibility7 = divBase.getAccessibility();
        if (ExpressionsKt.isConstantOrNull(accessibility7 != null ? accessibility7.description : null)) {
            DivAccessibility accessibility8 = divBase.getAccessibility();
            if (ExpressionsKt.isConstantOrNull(accessibility8 != null ? accessibility8.hint : null)) {
                return;
            }
        }
        Function1<? super String, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivBaseBinder$bindAccessibilityDescriptionAndHint$callback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                Expression<String> expression5;
                Expression<String> expression6;
                Intrinsics.checkNotNullParameter(obj, "<anonymous parameter 0>");
                DivBaseBinder divBaseBinder = this.this$0;
                View view2 = view;
                DivAccessibility accessibility9 = divBase.getAccessibility();
                String strEvaluate2 = null;
                String strEvaluate3 = (accessibility9 == null || (expression6 = accessibility9.description) == null) ? null : expression6.evaluate(expressionResolver);
                DivAccessibility accessibility10 = divBase.getAccessibility();
                if (accessibility10 != null && (expression5 = accessibility10.hint) != null) {
                    strEvaluate2 = expression5.evaluate(expressionResolver);
                }
                divBaseBinder.applyAccessibilityDescriptionAndHint(view2, strEvaluate3, strEvaluate2);
            }
        };
        DivAccessibility accessibility9 = divBase.getAccessibility();
        expressionSubscriber.addSubscription((accessibility9 == null || (expression2 = accessibility9.description) == null) ? null : expression2.observe(expressionResolver, function1));
        DivAccessibility accessibility10 = divBase.getAccessibility();
        if (accessibility10 != null && (expression = accessibility10.hint) != null) {
            disposableObserve = expression.observe(expressionResolver, function1);
        }
        expressionSubscriber.addSubscription(disposableObserve);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyAccessibilityDescriptionAndHint(View view, String str, String str2) {
        String str3;
        if (str == null) {
            str3 = str2;
        } else if (str2 == null) {
            str3 = str;
        } else {
            str3 = str + '\n' + str2;
        }
        view.setContentDescription(str3);
    }

    private final void bindAccessibilityMode(final View view, final Div2View div2View, final DivBase divBase, final ExpressionResolver expressionResolver, ExpressionSubscriber expressionSubscriber) {
        Expression<DivAccessibility.Mode> expression;
        Expression<DivAccessibility.Mode> expression2;
        DivAccessibility accessibility = divBase.getAccessibility();
        Disposable disposableObserve = null;
        applyAccessibilityMode(view, div2View, divBase, (accessibility == null || (expression2 = accessibility.mode) == null) ? null : expression2.evaluate(expressionResolver));
        DivAccessibility accessibility2 = divBase.getAccessibility();
        if (ExpressionsKt.isConstantOrNull(accessibility2 != null ? accessibility2.mode : null)) {
            return;
        }
        DivAccessibility accessibility3 = divBase.getAccessibility();
        if (accessibility3 != null && (expression = accessibility3.mode) != null) {
            disposableObserve = expression.observe(expressionResolver, new Function1<DivAccessibility.Mode, Unit>() { // from class: com.yandex.div.core.view2.divs.DivBaseBinder.bindAccessibilityMode.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DivAccessibility.Mode mode) {
                    invoke2(mode);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DivAccessibility.Mode mode) {
                    DivAccessibility.Type type;
                    Intrinsics.checkNotNullParameter(mode, "mode");
                    DivBaseBinder.this.applyAccessibilityMode(view, div2View, divBase, mode);
                    DivAccessibility accessibility4 = divBase.getAccessibility();
                    if (accessibility4 == null || (type = accessibility4.type) == null) {
                        type = DivAccessibility.Type.AUTO;
                    }
                    if (type == DivAccessibility.Type.AUTO) {
                        DivBaseBinder.this.divAccessibilityBinder.bindType(view, divBase, type, expressionResolver);
                    }
                }
            });
        }
        expressionSubscriber.addSubscription(disposableObserve);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyAccessibilityMode(View view, Div2View div2View, DivBase divBase, DivAccessibility.Mode mode) {
        this.divAccessibilityBinder.bindAccessibilityMode(view, div2View, mode, divBase);
    }

    private final void bindAccessibilityStateDescription(final View view, DivBase divBase, DivBase divBase2, ExpressionResolver expressionResolver, ExpressionSubscriber expressionSubscriber) {
        Expression<String> expression;
        Expression<String> expression2;
        DivAccessibility accessibility;
        DivAccessibility accessibility2 = divBase.getAccessibility();
        Disposable disposableObserve = null;
        if (ExpressionsKt.equalsToConstant(accessibility2 != null ? accessibility2.stateDescription : null, (divBase2 == null || (accessibility = divBase2.getAccessibility()) == null) ? null : accessibility.stateDescription)) {
            return;
        }
        DivAccessibility accessibility3 = divBase.getAccessibility();
        applyAccessibilityStateDescription(view, (accessibility3 == null || (expression2 = accessibility3.stateDescription) == null) ? null : expression2.evaluate(expressionResolver));
        DivAccessibility accessibility4 = divBase.getAccessibility();
        if (ExpressionsKt.isConstantOrNull(accessibility4 != null ? accessibility4.stateDescription : null)) {
            return;
        }
        DivAccessibility accessibility5 = divBase.getAccessibility();
        if (accessibility5 != null && (expression = accessibility5.stateDescription) != null) {
            disposableObserve = expression.observe(expressionResolver, new Function1<String, Unit>() { // from class: com.yandex.div.core.view2.divs.DivBaseBinder.bindAccessibilityStateDescription.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String stateDescription) {
                    Intrinsics.checkNotNullParameter(stateDescription, "stateDescription");
                    DivBaseBinder.this.applyAccessibilityStateDescription(view, stateDescription);
                }
            });
        }
        expressionSubscriber.addSubscription(disposableObserve);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyAccessibilityStateDescription(View view, String str) {
        ViewCompat.setStateDescription(view, str);
    }

    private final void bindAlpha(final View view, DivBase divBase, DivBase divBase2, ExpressionResolver expressionResolver, ExpressionSubscriber expressionSubscriber) {
        if (ExpressionsKt.equalsToConstant(divBase.getAlpha(), divBase2 != null ? divBase2.getAlpha() : null)) {
            return;
        }
        BaseDivViewExtensionsKt.applyAlpha(view, divBase.getAlpha().evaluate(expressionResolver).doubleValue());
        if (ExpressionsKt.isConstant(divBase.getAlpha())) {
            return;
        }
        expressionSubscriber.addSubscription(divBase.getAlpha().observe(expressionResolver, new Function1<Double, Unit>() { // from class: com.yandex.div.core.view2.divs.DivBaseBinder.bindAlpha.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Double d) {
                invoke(d.doubleValue());
                return Unit.INSTANCE;
            }

            public final void invoke(double d) {
                BaseDivViewExtensionsKt.applyAlpha(view, d);
            }
        }));
    }

    private final void bindBorder(View view, BindingContext bindingContext, DivBase divBase) {
        DivFocusBinder divFocusBinder = this.divFocusBinder;
        DivFocus focus = divBase.getFocus();
        divFocusBinder.bindDivBorder(view, bindingContext, focus != null ? focus.border : null, divBase.getBorder());
    }

    public static /* synthetic */ void bindBackground$div_release$default(DivBaseBinder divBaseBinder, BindingContext bindingContext, View view, DivBase divBase, DivBase divBase2, ExpressionSubscriber expressionSubscriber, Drawable drawable, int i, Object obj) {
        if ((i & 32) != 0) {
            drawable = null;
        }
        divBaseBinder.bindBackground$div_release(bindingContext, view, divBase, divBase2, expressionSubscriber, drawable);
    }

    public final void bindBackground$div_release(BindingContext context, View target, DivBase newDiv, DivBase oldDiv, ExpressionSubscriber subscriber, Drawable additionalLayer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(newDiv, "newDiv");
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        bindBackground(target, context, newDiv, oldDiv, subscriber, additionalLayer);
        bindPaddings(target, newDiv, oldDiv, context.getExpressionResolver(), subscriber);
    }

    static /* synthetic */ void bindBackground$default(DivBaseBinder divBaseBinder, View view, BindingContext bindingContext, DivBase divBase, DivBase divBase2, ExpressionSubscriber expressionSubscriber, Drawable drawable, int i, Object obj) {
        if ((i & 16) != 0) {
            drawable = null;
        }
        divBaseBinder.bindBackground(view, bindingContext, divBase, divBase2, expressionSubscriber, drawable);
    }

    private final void bindBackground(View view, BindingContext bindingContext, DivBase divBase, DivBase divBase2, ExpressionSubscriber expressionSubscriber, Drawable drawable) {
        DivFocus focus;
        DivBackgroundBinder divBackgroundBinder = this.divBackgroundBinder;
        List<DivBackground> background = divBase.getBackground();
        List<DivBackground> background2 = divBase2 != null ? divBase2.getBackground() : null;
        DivFocus focus2 = divBase.getFocus();
        divBackgroundBinder.bindBackground(bindingContext, view, background, background2, focus2 != null ? focus2.background : null, (divBase2 == null || (focus = divBase2.getFocus()) == null) ? null : focus.background, expressionSubscriber, drawable);
    }

    private final void bindNextFocus(final View view, Div2View div2View, DivBase divBase, DivBase divBase2, ExpressionResolver expressionResolver, ExpressionSubscriber expressionSubscriber) {
        DivFocus focus;
        DivFocus.NextFocusIds nextFocusIds;
        DivFocus.NextFocusIds nextFocusIds2;
        DivFocus focus2;
        DivFocus.NextFocusIds nextFocusIds3;
        DivFocus.NextFocusIds nextFocusIds4;
        DivFocus focus3;
        DivFocus.NextFocusIds nextFocusIds5;
        DivFocus.NextFocusIds nextFocusIds6;
        DivFocus focus4;
        DivFocus.NextFocusIds nextFocusIds7;
        DivFocus.NextFocusIds nextFocusIds8;
        DivFocus focus5;
        DivFocus.NextFocusIds nextFocusIds9;
        DivFocus.NextFocusIds nextFocusIds10;
        final DivViewIdProvider viewIdProvider = div2View.getViewComponent().getViewIdProvider();
        DivFocus focus6 = divBase.getFocus();
        Expression<String> expression = (focus6 == null || (nextFocusIds10 = focus6.nextFocusIds) == null) ? null : nextFocusIds10.forward;
        if (!ExpressionsKt.equalsToConstant(expression, (divBase2 == null || (focus5 = divBase2.getFocus()) == null || (nextFocusIds9 = focus5.nextFocusIds) == null) ? null : nextFocusIds9.forward)) {
            String strEvaluate = expression != null ? expression.evaluate(expressionResolver) : null;
            view.setNextFocusForwardId(viewIdProvider.getViewId(strEvaluate));
            view.setAccessibilityTraversalBefore(viewIdProvider.getViewId(strEvaluate));
            if (!ExpressionsKt.isConstantOrNull(expression)) {
                expressionSubscriber.addSubscription(expression != null ? expression.observe(expressionResolver, new Function1<String, Unit>() { // from class: com.yandex.div.core.view2.divs.DivBaseBinder$bindNextFocus$$inlined$bindNextFocusId$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String id) {
                        Intrinsics.checkNotNullParameter(id, "id");
                        view.setNextFocusForwardId(viewIdProvider.getViewId(id));
                        view.setAccessibilityTraversalBefore(viewIdProvider.getViewId(id));
                    }
                }) : null);
            }
        }
        DivFocus focus7 = divBase.getFocus();
        Expression<String> expression2 = (focus7 == null || (nextFocusIds8 = focus7.nextFocusIds) == null) ? null : nextFocusIds8.left;
        if (!ExpressionsKt.equalsToConstant(expression2, (divBase2 == null || (focus4 = divBase2.getFocus()) == null || (nextFocusIds7 = focus4.nextFocusIds) == null) ? null : nextFocusIds7.left)) {
            view.setNextFocusLeftId(viewIdProvider.getViewId(expression2 != null ? expression2.evaluate(expressionResolver) : null));
            if (!ExpressionsKt.isConstantOrNull(expression2)) {
                expressionSubscriber.addSubscription(expression2 != null ? expression2.observe(expressionResolver, new Function1<String, Unit>() { // from class: com.yandex.div.core.view2.divs.DivBaseBinder$bindNextFocus$$inlined$bindNextFocusId$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String id) {
                        Intrinsics.checkNotNullParameter(id, "id");
                        view.setNextFocusLeftId(viewIdProvider.getViewId(id));
                    }
                }) : null);
            }
        }
        DivFocus focus8 = divBase.getFocus();
        Expression<String> expression3 = (focus8 == null || (nextFocusIds6 = focus8.nextFocusIds) == null) ? null : nextFocusIds6.right;
        if (!ExpressionsKt.equalsToConstant(expression3, (divBase2 == null || (focus3 = divBase2.getFocus()) == null || (nextFocusIds5 = focus3.nextFocusIds) == null) ? null : nextFocusIds5.right)) {
            view.setNextFocusRightId(viewIdProvider.getViewId(expression3 != null ? expression3.evaluate(expressionResolver) : null));
            if (!ExpressionsKt.isConstantOrNull(expression3)) {
                expressionSubscriber.addSubscription(expression3 != null ? expression3.observe(expressionResolver, new Function1<String, Unit>() { // from class: com.yandex.div.core.view2.divs.DivBaseBinder$bindNextFocus$$inlined$bindNextFocusId$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String id) {
                        Intrinsics.checkNotNullParameter(id, "id");
                        view.setNextFocusRightId(viewIdProvider.getViewId(id));
                    }
                }) : null);
            }
        }
        DivFocus focus9 = divBase.getFocus();
        Expression<String> expression4 = (focus9 == null || (nextFocusIds4 = focus9.nextFocusIds) == null) ? null : nextFocusIds4.up;
        if (!ExpressionsKt.equalsToConstant(expression4, (divBase2 == null || (focus2 = divBase2.getFocus()) == null || (nextFocusIds3 = focus2.nextFocusIds) == null) ? null : nextFocusIds3.up)) {
            view.setNextFocusUpId(viewIdProvider.getViewId(expression4 != null ? expression4.evaluate(expressionResolver) : null));
            if (!ExpressionsKt.isConstantOrNull(expression4)) {
                expressionSubscriber.addSubscription(expression4 != null ? expression4.observe(expressionResolver, new Function1<String, Unit>() { // from class: com.yandex.div.core.view2.divs.DivBaseBinder$bindNextFocus$$inlined$bindNextFocusId$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String id) {
                        Intrinsics.checkNotNullParameter(id, "id");
                        view.setNextFocusUpId(viewIdProvider.getViewId(id));
                    }
                }) : null);
            }
        }
        DivFocus focus10 = divBase.getFocus();
        Expression<String> expression5 = (focus10 == null || (nextFocusIds2 = focus10.nextFocusIds) == null) ? null : nextFocusIds2.down;
        if (ExpressionsKt.equalsToConstant(expression5, (divBase2 == null || (focus = divBase2.getFocus()) == null || (nextFocusIds = focus.nextFocusIds) == null) ? null : nextFocusIds.down)) {
            return;
        }
        view.setNextFocusDownId(viewIdProvider.getViewId(expression5 != null ? expression5.evaluate(expressionResolver) : null));
        if (ExpressionsKt.isConstantOrNull(expression5)) {
            return;
        }
        expressionSubscriber.addSubscription(expression5 != null ? expression5.observe(expressionResolver, new Function1<String, Unit>() { // from class: com.yandex.div.core.view2.divs.DivBaseBinder$bindNextFocus$$inlined$bindNextFocusId$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                view.setNextFocusDownId(viewIdProvider.getViewId(id));
            }
        }) : null);
    }

    private final void bindNextFocusId(View view, Expression<String> expression, Expression<String> expression2, ExpressionResolver expressionResolver, ExpressionSubscriber expressionSubscriber, final Function1<? super String, Unit> function1) {
        if (ExpressionsKt.equalsToConstant(expression, expression2)) {
            return;
        }
        function1.invoke(expression != null ? expression.evaluate(expressionResolver) : null);
        if (ExpressionsKt.isConstantOrNull(expression)) {
            return;
        }
        expressionSubscriber.addSubscription(expression != null ? expression.observe(expressionResolver, new Function1<String, Unit>() { // from class: com.yandex.div.core.view2.divs.DivBaseBinder.bindNextFocusId.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                function1.invoke(id);
            }
        }) : null);
    }

    private final void bindFocusActions(View view, BindingContext bindingContext, List<DivAction> list, List<DivAction> list2) {
        this.divFocusBinder.bindDivFocusActions(view, bindingContext, list, list2);
    }

    private final void bindVisibility(final View view, final Div2View div2View, final DivBase divBase, DivBase divBase2, final ExpressionResolver expressionResolver, ExpressionSubscriber expressionSubscriber) {
        if (ExpressionsKt.equalsToConstant(divBase.getVisibility(), divBase2 != null ? divBase2.getVisibility() : null)) {
            return;
        }
        applyVisibility(view, div2View, divBase, expressionResolver, divBase2 == null);
        if (ExpressionsKt.isConstant(divBase.getVisibility())) {
            return;
        }
        expressionSubscriber.addSubscription(divBase.getVisibility().observe(expressionResolver, new Function1<DivVisibility, Unit>() { // from class: com.yandex.div.core.view2.divs.DivBaseBinder.bindVisibility.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DivVisibility divVisibility) {
                invoke2(divVisibility);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DivVisibility it) {
                Intrinsics.checkNotNullParameter(it, "it");
                DivBaseBinder.this.applyVisibility(view, div2View, divBase, expressionResolver, false);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:36:0x0081  */
    public final void applyVisibility(View view, Div2View div2View, DivBase divBase, ExpressionResolver expressionResolver, boolean z) {
        int i;
        Transition transitionCreateAndroidTransition;
        DivTransitionHandler divTransitionHandler = div2View.getDivTransitionHandler();
        int i2 = WhenMappings.$EnumSwitchMapping$0[divBase.getVisibility().evaluate(expressionResolver).ordinal()];
        if (i2 == 1) {
            i = 0;
        } else if (i2 == 2) {
            i = 4;
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i = 8;
        }
        if (i != 0) {
            view.clearAnimation();
        }
        int visibility = view.getVisibility();
        List<DivTransitionTrigger> transitionTriggers = divBase.getTransitionTriggers();
        Transition transition = null;
        if (transitionTriggers == null || DivTransitionsKt.allowsTransitionsOnVisibilityChange(transitionTriggers)) {
            DivTransitionHandler.ChangeType.Visibility lastChange = divTransitionHandler.getLastChange(view);
            if (lastChange != null) {
                visibility = lastChange.getNew();
            }
            DivTransitionBuilder transitionBuilder = div2View.getViewComponent().getTransitionBuilder();
            if ((visibility == 4 || visibility == 8) && i == 0) {
                transitionCreateAndroidTransition = transitionBuilder.createAndroidTransition(divBase.getTransitionIn(), 1, expressionResolver);
            } else {
                if ((i == 4 || i == 8) && visibility == 0 && !z) {
                    transitionCreateAndroidTransition = transitionBuilder.createAndroidTransition(divBase.getTransitionOut(), 2, expressionResolver);
                } else if (lastChange != null) {
                    TransitionManager.endTransitions(div2View);
                }
                if (transition != null) {
                    transition.addTarget(view);
                }
            }
            transition = transitionCreateAndroidTransition;
            if (transition != null) {
                transition.addTarget(view);
            }
        }
        if (transition != null) {
            divTransitionHandler.putTransition(transition, view, new DivTransitionHandler.ChangeType.Visibility(i));
        } else {
            view.setVisibility(i);
        }
        div2View.trackChildrenVisibility();
    }

    private final void bindTransform(final View view, final DivBase divBase, DivBase divBase2, final ExpressionResolver expressionResolver, ExpressionSubscriber expressionSubscriber) {
        if (DivDataExtensionsKt.equalsToConstant(divBase.getTransform(), divBase2 != null ? divBase2.getTransform() : null)) {
            return;
        }
        BaseDivViewExtensionsKt.applyTransform(view, divBase.getTransform(), expressionResolver);
        if (DivDataExtensionsKt.isConstant(divBase.getTransform())) {
            return;
        }
        ExpressionSubscribersKt.observeTransform(expressionSubscriber, divBase.getTransform(), expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivBaseBinder.bindTransform.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                BaseDivViewExtensionsKt.applyTransform(view, divBase.getTransform(), expressionResolver);
            }
        });
    }

    private final void applyFocusableState(View view, DivBase divBase) {
        view.setFocusable(divBase.getFocus() != null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DivWrapContentSize.ConstraintSize getMinSize(DivSize divSize) {
        DivWrapContentSize value;
        DivSize.WrapContent wrapContent = divSize instanceof DivSize.WrapContent ? (DivSize.WrapContent) divSize : null;
        if (wrapContent == null || (value = wrapContent.getValue()) == null) {
            return null;
        }
        return value.minSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DivWrapContentSize.ConstraintSize getMaxSize(DivSize divSize) {
        DivWrapContentSize value;
        DivSize.WrapContent wrapContent = divSize instanceof DivSize.WrapContent ? (DivSize.WrapContent) divSize : null;
        if (wrapContent == null || (value = wrapContent.getValue()) == null) {
            return null;
        }
        return value.maxSize;
    }
}
