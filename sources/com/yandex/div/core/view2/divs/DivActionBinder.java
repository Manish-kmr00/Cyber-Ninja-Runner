package com.yandex.div.core.view2.divs;

import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yandex.div.core.Div2Logger;
import com.yandex.div.core.DivActionHandler;
import com.yandex.div.core.DivViewFacade;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.dagger.ExperimentFlag;
import com.yandex.div.core.experiments.Experiment;
import com.yandex.div.core.view2.AccessibilityDelegateWrapper;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivGestureListener;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.util.CollectionsKt;
import com.yandex.div.internal.widget.menu.OverflowMenuWrapper;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAccessibility;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivAnimation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: DivActionBinder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0011\u0018\u00002\u00020\u0001:\u0002OPB=\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\t\u0012\b\b\u0001\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u008c\u0001\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0012J6\u0010\"\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\u0010 \u001a\u0004\u0018\u00010!H\u0012J\u009a\u0001\u0010#\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J.\u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0012J4\u0010'\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0012J.\u0010*\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010+\u001a\u00020\tH\u0012J6\u0010,\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\n\u001a\u00020\tH\u0012J \u0010-\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tH\u0012JH\u0010/\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\t\u0018\u0001002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0012JE\u00102\u001a\u00020\t2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00172\u0006\u00108\u001a\u0002092\n\b\u0002\u0010:\u001a\u0004\u0018\u0001092\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0003H\u0010¢\u0006\u0002\b<JE\u0010=\u001a\u00020\t2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00172\u0006\u00108\u001a\u0002092\n\b\u0002\u0010:\u001a\u0004\u0018\u0001092\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0003H\u0011¢\u0006\u0002\b>JM\u0010?\u001a\u00020\u00112\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0006\u00108\u001a\u0002092\u0016\b\u0002\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eH\u0010¢\u0006\u0002\bAJ5\u0010B\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\b\u0002\u0010C\u001a\u000209H\u0010¢\u0006\u0002\bDJ+\u0010E\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0010¢\u0006\u0002\bFJ5\u0010G\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u00172\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u00110\u000eH\u0092\bJM\u0010J\u001a\u00020\u0011*\u00020\u000f2:\u0010K\u001a\u001e\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\t\u0018\u0001000L\"\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\t\u0018\u000100H\u0013¢\u0006\u0002\u0010MJ\f\u0010N\u001a\u000209*\u000209H\u0012R\u000e\u0010\u000b\u001a\u00020\tX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000eX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivActionBinder;", "", "actionHandler", "Lcom/yandex/div/core/DivActionHandler;", "logger", "Lcom/yandex/div/core/Div2Logger;", "divActionBeaconSender", "Lcom/yandex/div/core/view2/divs/DivActionBeaconSender;", "longtapActionsPassToChild", "", "shouldIgnoreActionMenuItems", "accessibilityEnabled", "(Lcom/yandex/div/core/DivActionHandler;Lcom/yandex/div/core/Div2Logger;Lcom/yandex/div/core/view2/divs/DivActionBeaconSender;ZZZ)V", "passToParentLongClickListener", "Lkotlin/Function1;", "Landroid/view/View;", "applyDivActions", "", "context", "Lcom/yandex/div/core/view2/BindingContext;", TypedValues.AttributesType.S_TARGET, "actions", "", "Lcom/yandex/div2/DivAction;", "longTapActions", "doubleTapActions", "hoverStartActions", "hoverEndActions", "pressStartActions", "pressEndActions", "actionAnimation", "Lcom/yandex/div2/DivAnimation;", "accessibility", "Lcom/yandex/div2/DivAccessibility;", "bindAccessibilityDelegate", "bindDivActions", "bindDoubleTapActions", "divGestureListener", "Lcom/yandex/div/core/view2/DivGestureListener;", "bindHoverActions", "startActions", "endActions", "bindLongTapActions", "noClickAction", "bindTapActions", "clearLongClickListener", "passLongTapsToChildren", "createPressTouchListener", "Lkotlin/Function2;", "Landroid/view/MotionEvent;", "handleAction", "divView", "Lcom/yandex/div/core/DivViewFacade;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "action", "reason", "", "actionUid", "viewActionHandler", "handleAction$div_release", "handleActionWithoutEnableCheck", "handleActionWithoutEnableCheck$div_release", "handleActions", "onEachEnabledAction", "handleActions$div_release", "handleBulkActions", "actionLogType", "handleBulkActions$div_release", "handleTapClick", "handleTapClick$div_release", "prepareMenu", "onPrepared", "Lcom/yandex/div/internal/widget/menu/OverflowMenuWrapper;", "attachTouchListeners", "listeners", "", "(Landroid/view/View;[Lkotlin/jvm/functions/Function2;)V", "toDivActionReason", "LogType", "MenuWrapperListener", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public class DivActionBinder {
    private final boolean accessibilityEnabled;
    private final DivActionHandler actionHandler;
    private final DivActionBeaconSender divActionBeaconSender;
    private final Div2Logger logger;
    private final boolean longtapActionsPassToChild;
    private final Function1<View, Boolean> passToParentLongClickListener;
    private final boolean shouldIgnoreActionMenuItems;

    @Inject
    public DivActionBinder(DivActionHandler actionHandler, Div2Logger logger, DivActionBeaconSender divActionBeaconSender, @ExperimentFlag(experiment = Experiment.LONGTAP_ACTIONS_PASS_TO_CHILD_ENABLED) boolean z, @ExperimentFlag(experiment = Experiment.IGNORE_ACTION_MENU_ITEMS_ENABLED) boolean z2, @ExperimentFlag(experiment = Experiment.ACCESSIBILITY_ENABLED) boolean z3) {
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(divActionBeaconSender, "divActionBeaconSender");
        this.actionHandler = actionHandler;
        this.logger = logger;
        this.divActionBeaconSender = divActionBeaconSender;
        this.longtapActionsPassToChild = z;
        this.shouldIgnoreActionMenuItems = z2;
        this.accessibilityEnabled = z3;
        this.passToParentLongClickListener = new Function1<View, Boolean>() { // from class: com.yandex.div.core.view2.divs.DivActionBinder$passToParentLongClickListener$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                boolean zPerformLongClick = false;
                do {
                    ViewParent parent = view.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup == null) {
                        break;
                    }
                    view = viewGroup;
                    if (view.getParent() == null) {
                        break;
                    }
                    zPerformLongClick = view.performLongClick();
                } while (!zPerformLongClick);
                return Boolean.valueOf(zPerformLongClick);
            }
        };
    }

    public void bindDivActions(final BindingContext context, final View target, final List<DivAction> actions, final List<DivAction> longTapActions, final List<DivAction> doubleTapActions, final List<DivAction> hoverStartActions, final List<DivAction> hoverEndActions, final List<DivAction> pressStartActions, final List<DivAction> pressEndActions, final DivAnimation actionAnimation, final DivAccessibility accessibility) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(actionAnimation, "actionAnimation");
        final ExpressionResolver expressionResolver = context.getExpressionResolver();
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.yandex.div.core.view2.divs.DivActionBinder$bindDivActions$onApply$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List listOnlyEnabled = DivActionBinderKt.onlyEnabled(actions, expressionResolver);
                List listOnlyEnabled2 = DivActionBinderKt.onlyEnabled(doubleTapActions, expressionResolver);
                this.applyDivActions(context, target, listOnlyEnabled, DivActionBinderKt.onlyEnabled(longTapActions, expressionResolver), listOnlyEnabled2, DivActionBinderKt.onlyEnabled(hoverStartActions, expressionResolver), DivActionBinderKt.onlyEnabled(hoverEndActions, expressionResolver), DivActionBinderKt.onlyEnabled(pressStartActions, expressionResolver), DivActionBinderKt.onlyEnabled(pressEndActions, expressionResolver), actionAnimation, accessibility);
            }
        };
        DivActionBinderKt.observe(target, actions, expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivActionBinder$bindDivActions$1$1
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
                function0.invoke();
            }
        });
        DivActionBinderKt.observe(target, longTapActions, expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivActionBinder$bindDivActions$1$2
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
                function0.invoke();
            }
        });
        DivActionBinderKt.observe(target, doubleTapActions, expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivActionBinder$bindDivActions$1$3
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
                function0.invoke();
            }
        });
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyDivActions(BindingContext context, View target, List<DivAction> actions, List<DivAction> longTapActions, List<DivAction> doubleTapActions, List<DivAction> hoverStartActions, List<DivAction> hoverEndActions, List<DivAction> pressStartActions, List<DivAction> pressEndActions, DivAnimation actionAnimation, DivAccessibility accessibility) {
        boolean zIsClickable = target.isClickable();
        boolean zIsLongClickable = target.isLongClickable();
        DivGestureListener divGestureListener = new DivGestureListener(!longTapActions.isEmpty() || DivActionBinderKt.parentIsLongClickable(target));
        bindLongTapActions(context, target, longTapActions, actions.isEmpty());
        bindDoubleTapActions(context, target, divGestureListener, doubleTapActions);
        bindTapActions(context, target, divGestureListener, actions, this.shouldIgnoreActionMenuItems);
        Function2<View, MotionEvent, Boolean> function2CreateAnimatedTouchListener = BaseDivViewExtensionsKt.createAnimatedTouchListener(target, context, !CollectionsKt.allIsNullOrEmpty(actions, longTapActions, doubleTapActions) ? actionAnimation : null, divGestureListener);
        Function2<View, MotionEvent, Boolean> function2CreatePressTouchListener = createPressTouchListener(context, target, pressStartActions, pressEndActions);
        bindHoverActions(context, target, hoverStartActions, hoverEndActions);
        attachTouchListeners(target, function2CreateAnimatedTouchListener, function2CreatePressTouchListener);
        if (this.accessibilityEnabled) {
            if (DivAccessibility.Mode.MERGE == context.getDivView().getPropagatedAccessibilityMode$div_release(target) && context.getDivView().isDescendantAccessibilityMode$div_release(target)) {
                target.setClickable(zIsClickable);
                target.setLongClickable(zIsLongClickable);
            }
            bindAccessibilityDelegate(target, actions, longTapActions, accessibility);
        }
    }

    private void bindAccessibilityDelegate(final View target, final List<DivAction> actions, final List<DivAction> longTapActions, final DivAccessibility accessibility) {
        AccessibilityDelegateWrapper accessibilityDelegateWrapper;
        AccessibilityDelegateCompat accessibilityDelegate = ViewCompat.getAccessibilityDelegate(target);
        Function2<View, AccessibilityNodeInfoCompat, Unit> function2 = new Function2<View, AccessibilityNodeInfoCompat, Unit>() { // from class: com.yandex.div.core.view2.divs.DivActionBinder$bindAccessibilityDelegate$action$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                invoke2(view, accessibilityNodeInfoCompat);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                if (!actions.isEmpty() && accessibilityNodeInfoCompat != null) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
                }
                if (!longTapActions.isEmpty() && accessibilityNodeInfoCompat != null) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_LONG_CLICK);
                }
                if (target instanceof ImageView) {
                    DivAccessibility divAccessibility = accessibility;
                    if ((divAccessibility != null ? divAccessibility.type : null) == DivAccessibility.Type.AUTO || accessibility == null) {
                        if (longTapActions.isEmpty() && actions.isEmpty()) {
                            DivAccessibility divAccessibility2 = accessibility;
                            if ((divAccessibility2 != null ? divAccessibility2.description : null) == null) {
                                if (accessibilityNodeInfoCompat == null) {
                                    return;
                                }
                                accessibilityNodeInfoCompat.setClassName("");
                                return;
                            }
                        }
                        if (accessibilityNodeInfoCompat == null) {
                            return;
                        }
                        accessibilityNodeInfoCompat.setClassName("android.widget.ImageView");
                    }
                }
            }
        };
        if (accessibilityDelegate instanceof AccessibilityDelegateWrapper) {
            accessibilityDelegateWrapper = (AccessibilityDelegateWrapper) accessibilityDelegate;
            accessibilityDelegateWrapper.setActionsAccessibilityNodeInfo(function2);
        } else {
            accessibilityDelegateWrapper = new AccessibilityDelegateWrapper(accessibilityDelegate, null, function2, 2, null);
        }
        ViewCompat.setAccessibilityDelegate(target, accessibilityDelegateWrapper);
    }

    private void bindTapActions(final BindingContext context, final View target, DivGestureListener divGestureListener, final List<DivAction> actions, boolean shouldIgnoreActionMenuItems) {
        Object obj = null;
        if (actions.isEmpty()) {
            divGestureListener.setOnSingleTapListener(null);
            target.setOnClickListener(null);
            target.setClickable(false);
            return;
        }
        for (Object obj2 : actions) {
            List<DivAction.MenuItem> list = ((DivAction) obj2).menuItems;
            if (list != null && !list.isEmpty() && !shouldIgnoreActionMenuItems) {
                obj = obj2;
                break;
            }
        }
        final DivAction divAction = (DivAction) obj;
        if (divAction == null) {
            bindTapActions$setTapListener(divGestureListener, target, new View.OnClickListener() { // from class: com.yandex.div.core.view2.divs.DivActionBinder$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DivActionBinder.bindTapActions$lambda$5(context, this, target, actions, view);
                }
            });
            return;
        }
        List<DivAction.MenuItem> list2 = divAction.menuItems;
        if (list2 == null) {
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("Unable to bind empty menu action: " + divAction.logId);
                return;
            }
            return;
        }
        final OverflowMenuWrapper overflowMenuWrapperOverflowGravity = new OverflowMenuWrapper(target.getContext(), target, context.getDivView()).listener(new MenuWrapperListener(this, context, list2)).overflowGravity(53);
        Intrinsics.checkNotNullExpressionValue(overflowMenuWrapperOverflowGravity, "OverflowMenuWrapper(\n   …ity.RIGHT or Gravity.TOP)");
        Div2View divView = context.getDivView();
        divView.clearSubscriptions();
        divView.subscribe(new DivActionBinder$prepareMenu$2$1(overflowMenuWrapperOverflowGravity));
        bindTapActions$setTapListener(divGestureListener, target, new View.OnClickListener() { // from class: com.yandex.div.core.view2.divs.DivActionBinder$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DivActionBinder.bindTapActions$lambda$4$lambda$3(context, this, target, divAction, overflowMenuWrapperOverflowGravity, view);
            }
        });
    }

    private static final void bindTapActions$setTapListener(DivGestureListener divGestureListener, final View view, final View.OnClickListener onClickListener) {
        if (divGestureListener.getOnDoubleTapListener() != null) {
            divGestureListener.setOnSingleTapListener(new Function0<Unit>() { // from class: com.yandex.div.core.view2.divs.DivActionBinder$bindTapActions$setTapListener$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    onClickListener.onClick(view);
                }
            });
        } else {
            view.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindTapActions$lambda$4$lambda$3(BindingContext context, DivActionBinder this$0, View target, DivAction divAction, OverflowMenuWrapper overflowMenuWrapper, View it) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(target, "$target");
        Intrinsics.checkNotNullParameter(overflowMenuWrapper, "$overflowMenuWrapper");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        BaseDivViewExtensionsKt.clearFocusOnClick(it, context.getDivView().getInputFocusTracker());
        it.requestFocus();
        this$0.logger.logClick(context.getDivView(), context.getExpressionResolver(), target, divAction);
        this$0.divActionBeaconSender.sendTapActionBeacon(divAction, context.getExpressionResolver());
        overflowMenuWrapper.getOnMenuClickListener().onClick(target);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindTapActions$lambda$5(BindingContext context, DivActionBinder this$0, View target, List actions, View it) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(target, "$target");
        Intrinsics.checkNotNullParameter(actions, "$actions");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        BaseDivViewExtensionsKt.clearFocusOnClick(it, context.getDivView().getInputFocusTracker());
        it.requestFocus();
        handleBulkActions$div_release$default(this$0, context, target, actions, null, 8, null);
    }

    private void bindLongTapActions(final BindingContext context, final View target, final List<DivAction> actions, boolean noClickAction) {
        Object next;
        if (actions.isEmpty()) {
            clearLongClickListener(target, this.longtapActionsPassToChild, noClickAction);
            return;
        }
        Iterator<T> it = actions.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            List<DivAction.MenuItem> list = ((DivAction) next).menuItems;
            if (list != null && !list.isEmpty() && !this.shouldIgnoreActionMenuItems) {
                break;
            }
        }
        final DivAction divAction = (DivAction) next;
        if (divAction == null) {
            target.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.yandex.div.core.view2.divs.DivActionBinder$$ExternalSyntheticLambda5
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return DivActionBinder.bindLongTapActions$lambda$10(this.f$0, context, target, actions, view);
                }
            });
        } else {
            List<DivAction.MenuItem> list2 = divAction.menuItems;
            if (list2 == null) {
                KAssert kAssert = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unable to bind empty menu action: " + divAction.logId);
                }
            } else {
                final OverflowMenuWrapper overflowMenuWrapperOverflowGravity = new OverflowMenuWrapper(target.getContext(), target, context.getDivView()).listener(new MenuWrapperListener(this, context, list2)).overflowGravity(53);
                Intrinsics.checkNotNullExpressionValue(overflowMenuWrapperOverflowGravity, "OverflowMenuWrapper(\n   …ity.RIGHT or Gravity.TOP)");
                Div2View divView = context.getDivView();
                divView.clearSubscriptions();
                divView.subscribe(new DivActionBinder$prepareMenu$2$1(overflowMenuWrapperOverflowGravity));
                target.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.yandex.div.core.view2.divs.DivActionBinder$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        return DivActionBinder.bindLongTapActions$lambda$9$lambda$8(this.f$0, divAction, context, overflowMenuWrapperOverflowGravity, target, actions, view);
                    }
                });
            }
        }
        if (this.longtapActionsPassToChild) {
            DivActionBinderKt.setPenetratingLongClickable$default(target, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindLongTapActions$lambda$9$lambda$8(DivActionBinder this$0, DivAction divAction, BindingContext context, OverflowMenuWrapper overflowMenuWrapper, View target, List actions, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(overflowMenuWrapper, "$overflowMenuWrapper");
        Intrinsics.checkNotNullParameter(target, "$target");
        Intrinsics.checkNotNullParameter(actions, "$actions");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        this$0.divActionBeaconSender.sendTapActionBeacon(divAction, context.getExpressionResolver());
        overflowMenuWrapper.getOnMenuClickListener().onClick(target);
        Iterator it = actions.iterator();
        while (it.hasNext()) {
            this$0.logger.logLongClick(context.getDivView(), context.getExpressionResolver(), target, (DivAction) it.next(), string);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindLongTapActions$lambda$10(DivActionBinder this$0, BindingContext context, View target, List actions, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(target, "$target");
        Intrinsics.checkNotNullParameter(actions, "$actions");
        this$0.handleBulkActions$div_release(context, target, actions, "long_click");
        return true;
    }

    private void clearLongClickListener(View target, boolean passLongTapsToChildren, boolean noClickAction) {
        if (passLongTapsToChildren && !noClickAction) {
            if (DivActionBinderKt.parentIsLongClickable(target)) {
                final Function1<View, Boolean> function1 = this.passToParentLongClickListener;
                target.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.yandex.div.core.view2.divs.DivActionBinder$$ExternalSyntheticLambda6
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        return DivActionBinder.clearLongClickListener$lambda$11(function1, view);
                    }
                });
                DivActionBinderKt.setPenetratingLongClickable$default(target, null, 1, null);
                return;
            } else {
                target.setOnLongClickListener(null);
                target.setLongClickable(false);
                DivActionBinderKt.setPenetratingLongClickable(target, null);
                return;
            }
        }
        target.setOnLongClickListener(null);
        target.setLongClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean clearLongClickListener$lambda$11(Function1 tmp0, View view) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(view)).booleanValue();
    }

    private void bindDoubleTapActions(final BindingContext context, final View target, DivGestureListener divGestureListener, final List<DivAction> actions) {
        Object obj = null;
        if (actions.isEmpty()) {
            divGestureListener.setOnDoubleTapListener(null);
            return;
        }
        for (Object obj2 : actions) {
            List<DivAction.MenuItem> list = ((DivAction) obj2).menuItems;
            if (list != null && !list.isEmpty() && !this.shouldIgnoreActionMenuItems) {
                obj = obj2;
                break;
            }
        }
        final DivAction divAction = (DivAction) obj;
        if (divAction == null) {
            divGestureListener.setOnDoubleTapListener(new Function0<Unit>() { // from class: com.yandex.div.core.view2.divs.DivActionBinder.bindDoubleTapActions.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DivActionBinder.this.handleBulkActions$div_release(context, target, actions, "double_click");
                }
            });
            return;
        }
        List<DivAction.MenuItem> list2 = divAction.menuItems;
        if (list2 == null) {
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("Unable to bind empty menu action: " + divAction.logId);
                return;
            }
            return;
        }
        final OverflowMenuWrapper overflowMenuWrapperOverflowGravity = new OverflowMenuWrapper(target.getContext(), target, context.getDivView()).listener(new MenuWrapperListener(this, context, list2)).overflowGravity(53);
        Intrinsics.checkNotNullExpressionValue(overflowMenuWrapperOverflowGravity, "OverflowMenuWrapper(\n   …ity.RIGHT or Gravity.TOP)");
        Div2View divView = context.getDivView();
        divView.clearSubscriptions();
        divView.subscribe(new DivActionBinder$prepareMenu$2$1(overflowMenuWrapperOverflowGravity));
        divGestureListener.setOnDoubleTapListener(new Function0<Unit>() { // from class: com.yandex.div.core.view2.divs.DivActionBinder$bindDoubleTapActions$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.logger.logDoubleClick(context.getDivView(), context.getExpressionResolver(), target, divAction);
                this.this$0.divActionBeaconSender.sendTapActionBeacon(divAction, context.getExpressionResolver());
                overflowMenuWrapperOverflowGravity.getOnMenuClickListener().onClick(target);
            }
        });
    }

    private void bindHoverActions(final BindingContext context, final View target, final List<DivAction> startActions, final List<DivAction> endActions) {
        if (!startActions.isEmpty() || !endActions.isEmpty()) {
            target.setOnHoverListener(new View.OnHoverListener() { // from class: com.yandex.div.core.view2.divs.DivActionBinder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnHoverListener
                public final boolean onHover(View view, MotionEvent motionEvent) {
                    return DivActionBinder.bindHoverActions$lambda$14(this.f$0, context, target, startActions, endActions, view, motionEvent);
                }
            });
        } else {
            target.setOnHoverListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindHoverActions$lambda$14(DivActionBinder this$0, BindingContext context, View target, List startActions, List endActions, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(target, "$target");
        Intrinsics.checkNotNullParameter(startActions, "$startActions");
        Intrinsics.checkNotNullParameter(endActions, "$endActions");
        int action = motionEvent.getAction();
        if (action == 9) {
            this$0.handleBulkActions$div_release(context, target, startActions, "hover");
            return false;
        }
        if (action != 10) {
            return false;
        }
        this$0.handleBulkActions$div_release(context, target, endActions, "unhover");
        return false;
    }

    private Function2<View, MotionEvent, Boolean> createPressTouchListener(final BindingContext context, final View target, final List<DivAction> pressStartActions, final List<DivAction> pressEndActions) {
        if (pressStartActions.isEmpty() && pressEndActions.isEmpty()) {
            return null;
        }
        return new Function2<View, MotionEvent, Boolean>() { // from class: com.yandex.div.core.view2.divs.DivActionBinder.createPressTouchListener.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(View view, MotionEvent event) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(event, "event");
                int action = event.getAction();
                boolean z = true;
                if (action == 0) {
                    DivActionBinder.this.handleBulkActions$div_release(context, target, pressStartActions, "press");
                } else if (action == 1 || action == 3) {
                    DivActionBinder.this.handleBulkActions$div_release(context, target, pressEndActions, "release");
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        };
    }

    private void attachTouchListeners(View view, Function2<? super View, ? super MotionEvent, Boolean>... function2Arr) {
        final List listFilterNotNull = ArraysKt.filterNotNull(function2Arr);
        if (!listFilterNotNull.isEmpty()) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.yandex.div.core.view2.divs.DivActionBinder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return DivActionBinder.attachTouchListeners$lambda$16(listFilterNotNull, view2, motionEvent);
                }
            });
        } else {
            view.setOnTouchListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean attachTouchListeners$lambda$16(List nnListeners, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(nnListeners, "$nnListeners");
        Iterator it = nnListeners.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                Function2 function2 = (Function2) it.next();
                Intrinsics.checkNotNullExpressionValue(view, "view");
                Intrinsics.checkNotNullExpressionValue(motionEvent, "motionEvent");
                if (((Boolean) function2.invoke(view, motionEvent)).booleanValue() || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    public static /* synthetic */ void handleBulkActions$div_release$default(DivActionBinder divActionBinder, BindingContext bindingContext, View view, List list, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleBulkActions");
        }
        if ((i & 8) != 0) {
            str = "click";
        }
        divActionBinder.handleBulkActions$div_release(bindingContext, view, list, str);
    }

    public void handleBulkActions$div_release(BindingContext context, final View target, final List<DivAction> actions, final String actionLogType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(actionLogType, "actionLogType");
        final Div2View divView = context.getDivView();
        final ExpressionResolver expressionResolver = context.getExpressionResolver();
        divView.bulkActions$div_release(new Function0<Unit>() { // from class: com.yandex.div.core.view2.divs.DivActionBinder$handleBulkActions$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code duplicated, block: B:48:0x0121  */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
                List<DivAction> listOnlyEnabled = DivActionBinderKt.onlyEnabled(actions, expressionResolver);
                String str = actionLogType;
                DivActionBinder divActionBinder = this;
                Div2View div2View = divView;
                ExpressionResolver expressionResolver2 = expressionResolver;
                View view = target;
                for (DivAction divAction : listOnlyEnabled) {
                    switch (str) {
                        case "long_click":
                            divActionBinder.logger.logLongClick(div2View, expressionResolver2, view, divAction, string);
                            break;
                        case "unhover":
                            divActionBinder.logger.logHoverChanged(div2View, expressionResolver2, view, divAction, false);
                            break;
                        case "blur":
                            divActionBinder.logger.logFocusChanged(div2View, expressionResolver2, view, divAction, false);
                            break;
                        case "click":
                            divActionBinder.logger.logClick(div2View, expressionResolver2, view, divAction, string);
                            break;
                        case "enter":
                            divActionBinder.logger.logImeEnter(div2View, expressionResolver2, view, divAction);
                            break;
                        case "focus":
                            divActionBinder.logger.logFocusChanged(div2View, expressionResolver2, view, divAction, true);
                            break;
                        case "hover":
                            divActionBinder.logger.logHoverChanged(div2View, expressionResolver2, view, divAction, true);
                            break;
                        case "press":
                            divActionBinder.logger.logPressChanged(div2View, expressionResolver2, view, divAction, true);
                            break;
                        case "release":
                            divActionBinder.logger.logPressChanged(div2View, expressionResolver2, view, divAction, false);
                            break;
                        case "double_click":
                            divActionBinder.logger.logDoubleClick(div2View, expressionResolver2, view, divAction, string);
                            break;
                        default:
                            Assert.fail("Please, add new logType");
                            break;
                    }
                    divActionBinder.divActionBeaconSender.sendTapActionBeacon(divAction, expressionResolver2);
                    DivActionBinder.handleActionWithoutEnableCheck$div_release$default(divActionBinder, div2View, expressionResolver2, divAction, divActionBinder.toDivActionReason(str), string, null, 32, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:34:0x0061 A[ORIG_RETURN, RETURN] */
    public String toDivActionReason(String str) {
        switch (str) {
            case "long_click":
                return "long_click";
            case "unhover":
                return "unhover";
            case "blur":
                return "blur";
            case "click":
                return "click";
            case "enter":
                return "enter";
            case "focus":
                return "focus";
            case "hover":
                return "hover";
            case "press":
                return "press";
            case "release":
                return "release";
            case "double_click":
                return "double_click";
            default:
                return "external";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleActions$div_release$default(DivActionBinder divActionBinder, DivViewFacade divViewFacade, ExpressionResolver expressionResolver, List list, String str, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleActions");
        }
        if ((i & 16) != 0) {
            function1 = null;
        }
        divActionBinder.handleActions$div_release(divViewFacade, expressionResolver, list, str, function1);
    }

    public void handleActions$div_release(DivViewFacade divView, ExpressionResolver resolver, List<DivAction> actions, String reason, Function1<? super DivAction, Unit> onEachEnabledAction) {
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (actions == null) {
            return;
        }
        for (DivAction divAction : DivActionBinderKt.onlyEnabled(actions, resolver)) {
            handleActionWithoutEnableCheck$div_release$default(this, divView, resolver, divAction, reason, null, null, 48, null);
            if (onEachEnabledAction != null) {
                onEachEnabledAction.invoke(divAction);
            }
        }
    }

    public static /* synthetic */ boolean handleAction$div_release$default(DivActionBinder divActionBinder, DivViewFacade divViewFacade, ExpressionResolver expressionResolver, DivAction divAction, String str, String str2, DivActionHandler divActionHandler, int i, Object obj) {
        DivActionHandler actionHandler;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleAction");
        }
        String str3 = (i & 16) != 0 ? null : str2;
        if ((i & 32) != 0) {
            Div2View div2View = divViewFacade instanceof Div2View ? (Div2View) divViewFacade : null;
            actionHandler = div2View != null ? div2View.getActionHandler() : null;
        } else {
            actionHandler = divActionHandler;
        }
        return divActionBinder.handleAction$div_release(divViewFacade, expressionResolver, divAction, str, str3, actionHandler);
    }

    public boolean handleAction$div_release(DivViewFacade divView, ExpressionResolver resolver, DivAction action, String reason, String actionUid, DivActionHandler viewActionHandler) {
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (action.isEnabled.evaluate(resolver).booleanValue()) {
            return handleActionWithoutEnableCheck$div_release(divView, resolver, action, reason, actionUid, viewActionHandler);
        }
        return false;
    }

    public static /* synthetic */ boolean handleActionWithoutEnableCheck$div_release$default(DivActionBinder divActionBinder, DivViewFacade divViewFacade, ExpressionResolver expressionResolver, DivAction divAction, String str, String str2, DivActionHandler divActionHandler, int i, Object obj) {
        DivActionHandler actionHandler;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleActionWithoutEnableCheck");
        }
        String str3 = (i & 16) != 0 ? null : str2;
        if ((i & 32) != 0) {
            Div2View div2View = divViewFacade instanceof Div2View ? (Div2View) divViewFacade : null;
            actionHandler = div2View != null ? div2View.getActionHandler() : null;
        } else {
            actionHandler = divActionHandler;
        }
        return divActionBinder.handleActionWithoutEnableCheck$div_release(divViewFacade, expressionResolver, divAction, str, str3, actionHandler);
    }

    public boolean handleActionWithoutEnableCheck$div_release(DivViewFacade divView, ExpressionResolver resolver, DivAction action, String reason, String actionUid, DivActionHandler viewActionHandler) {
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (this.actionHandler.getUseActionUid() && actionUid != null) {
            if (viewActionHandler == null || !viewActionHandler.handleActionWithReason(action, divView, resolver, actionUid, reason)) {
                return this.actionHandler.handleActionWithReason(action, divView, resolver, actionUid, reason);
            }
            return true;
        }
        if (viewActionHandler == null || !viewActionHandler.handleActionWithReason(action, divView, resolver, reason)) {
            return this.actionHandler.handleActionWithReason(action, divView, resolver, reason);
        }
        return true;
    }

    public void handleTapClick$div_release(BindingContext context, View target, List<DivAction> actions) {
        Object next;
        List<DivAction.MenuItem> list;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(actions, "actions");
        ExpressionResolver expressionResolver = context.getExpressionResolver();
        List listOnlyEnabled = DivActionBinderKt.onlyEnabled(actions, expressionResolver);
        Iterator it = listOnlyEnabled.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                list = ((DivAction) next).menuItems;
            }
        } while (list == null || list.isEmpty());
        DivAction divAction = (DivAction) next;
        if (divAction == null) {
            handleBulkActions$div_release$default(this, context, target, listOnlyEnabled, null, 8, null);
            return;
        }
        List<DivAction.MenuItem> list2 = divAction.menuItems;
        if (list2 == null) {
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("Unable to bind empty menu action: " + divAction.logId);
                return;
            }
            return;
        }
        OverflowMenuWrapper overflowMenuWrapperOverflowGravity = new OverflowMenuWrapper(target.getContext(), target, context.getDivView()).listener(new MenuWrapperListener(this, context, list2)).overflowGravity(53);
        Intrinsics.checkNotNullExpressionValue(overflowMenuWrapperOverflowGravity, "OverflowMenuWrapper(\n   …ity.RIGHT or Gravity.TOP)");
        Div2View divView = context.getDivView();
        divView.clearSubscriptions();
        divView.subscribe(new DivActionBinder$prepareMenu$2$1(overflowMenuWrapperOverflowGravity));
        this.logger.logClick(context.getDivView(), expressionResolver, target, divAction);
        this.divActionBeaconSender.sendTapActionBeacon(divAction, expressionResolver);
        overflowMenuWrapperOverflowGravity.getOnMenuClickListener().onClick(target);
    }

    private void prepareMenu(View target, BindingContext context, DivAction action, Function1<? super OverflowMenuWrapper, Unit> onPrepared) {
        List<DivAction.MenuItem> list = action.menuItems;
        if (list == null) {
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("Unable to bind empty menu action: " + action.logId);
                return;
            }
            return;
        }
        OverflowMenuWrapper overflowMenuWrapperOverflowGravity = new OverflowMenuWrapper(target.getContext(), target, context.getDivView()).listener(new MenuWrapperListener(this, context, list)).overflowGravity(53);
        Intrinsics.checkNotNullExpressionValue(overflowMenuWrapperOverflowGravity, "OverflowMenuWrapper(\n   …ity.RIGHT or Gravity.TOP)");
        Div2View divView = context.getDivView();
        divView.clearSubscriptions();
        divView.subscribe(new DivActionBinder$prepareMenu$2$1(overflowMenuWrapperOverflowGravity));
        onPrepared.invoke(overflowMenuWrapperOverflowGravity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DivActionBinder.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivActionBinder$MenuWrapperListener;", "Lcom/yandex/div/internal/widget/menu/OverflowMenuWrapper$Listener$Simple;", "context", "Lcom/yandex/div/core/view2/BindingContext;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/yandex/div2/DivAction$MenuItem;", "(Lcom/yandex/div/core/view2/divs/DivActionBinder;Lcom/yandex/div/core/view2/BindingContext;Ljava/util/List;)V", "onMenuCreated", "", "popupMenu", "Landroidx/appcompat/widget/PopupMenu;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class MenuWrapperListener extends OverflowMenuWrapper.Listener.Simple {
        private final BindingContext context;
        private final List<DivAction.MenuItem> items;
        final /* synthetic */ DivActionBinder this$0;

        public MenuWrapperListener(DivActionBinder divActionBinder, BindingContext context, List<DivAction.MenuItem> items) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(items, "items");
            this.this$0 = divActionBinder;
            this.context = context;
            this.items = items;
        }

        @Override // com.yandex.div.internal.widget.menu.OverflowMenuWrapper.Listener.Simple, com.yandex.div.internal.widget.menu.OverflowMenuWrapper.Listener
        public void onMenuCreated(PopupMenu popupMenu) {
            Intrinsics.checkNotNullParameter(popupMenu, "popupMenu");
            final Div2View divView = this.context.getDivView();
            final ExpressionResolver expressionResolver = this.context.getExpressionResolver();
            Menu menu = popupMenu.getMenu();
            Intrinsics.checkNotNullExpressionValue(menu, "popupMenu.menu");
            for (final DivAction.MenuItem menuItem : this.items) {
                final int size = menu.size();
                MenuItem menuItemAdd = menu.add(menuItem.text.evaluate(expressionResolver));
                final DivActionBinder divActionBinder = this.this$0;
                menuItemAdd.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: com.yandex.div.core.view2.divs.DivActionBinder$MenuWrapperListener$$ExternalSyntheticLambda0
                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public final boolean onMenuItemClick(MenuItem menuItem2) {
                        return DivActionBinder.MenuWrapperListener.onMenuCreated$lambda$0(divView, menuItem, expressionResolver, divActionBinder, size, menuItem2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onMenuCreated$lambda$0(final Div2View divView, final DivAction.MenuItem itemData, final ExpressionResolver expressionResolver, final DivActionBinder this$0, final int i, MenuItem it) {
            Intrinsics.checkNotNullParameter(divView, "$divView");
            Intrinsics.checkNotNullParameter(itemData, "$itemData");
            Intrinsics.checkNotNullParameter(expressionResolver, "$expressionResolver");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "it");
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            divView.bulkActions$div_release(new Function0<Unit>() { // from class: com.yandex.div.core.view2.divs.DivActionBinder$MenuWrapperListener$onMenuCreated$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    List<DivAction> list = itemData.actions;
                    List<DivAction> list2 = list;
                    List<DivAction> listListOf = null;
                    if (list2 == null || list2.isEmpty()) {
                        list = null;
                    }
                    if (list == null) {
                        DivAction divAction = itemData.action;
                        if (divAction != null) {
                            listListOf = kotlin.collections.CollectionsKt.listOf(divAction);
                        }
                    } else {
                        listListOf = list;
                    }
                    List<DivAction> list3 = listListOf;
                    if (list3 != null && !list3.isEmpty()) {
                        List<DivAction> listOnlyEnabled = DivActionBinderKt.onlyEnabled(listListOf, expressionResolver);
                        DivActionBinder divActionBinder = this$0;
                        Div2View div2View = divView;
                        ExpressionResolver expressionResolver2 = expressionResolver;
                        int i2 = i;
                        DivAction.MenuItem menuItem = itemData;
                        for (DivAction divAction2 : listOnlyEnabled) {
                            divActionBinder.logger.logPopupMenuItemClick(div2View, expressionResolver2, i2, menuItem.text.evaluate(expressionResolver2), divAction2);
                            divActionBinder.divActionBeaconSender.sendTapActionBeacon(divAction2, expressionResolver2);
                            DivActionBinder.handleActionWithoutEnableCheck$div_release$default(divActionBinder, div2View, expressionResolver2, divAction2, DivActionHandler.DivActionReason.MENU, null, null, 48, null);
                        }
                        booleanRef.element = true;
                        return;
                    }
                    KAssert kAssert = KAssert.INSTANCE;
                    if (Assert.isEnabled()) {
                        Assert.fail("Menu item does not have any action");
                    }
                }
            });
            return booleanRef.element;
        }
    }

    /* JADX INFO: compiled from: DivActionBinder.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0081\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivActionBinder$LogType;", "", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface LogType {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String LOG_BLUR = "blur";
        public static final String LOG_CLICK = "click";
        public static final String LOG_DOUBLE_CLICK = "double_click";
        public static final String LOG_ENTER = "enter";
        public static final String LOG_FOCUS = "focus";
        public static final String LOG_HOVER = "hover";
        public static final String LOG_LONG_CLICK = "long_click";
        public static final String LOG_PRESS = "press";
        public static final String LOG_RELEASE = "release";
        public static final String LOG_UNHOVER = "unhover";

        /* JADX INFO: compiled from: DivActionBinder.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivActionBinder$LogType$Companion;", "", "()V", "LOG_BLUR", "", "LOG_CLICK", "LOG_DOUBLE_CLICK", "LOG_ENTER", "LOG_FOCUS", "LOG_HOVER", "LOG_LONG_CLICK", "LOG_PRESS", "LOG_RELEASE", "LOG_UNHOVER", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String LOG_BLUR = "blur";
            public static final String LOG_CLICK = "click";
            public static final String LOG_DOUBLE_CLICK = "double_click";
            public static final String LOG_ENTER = "enter";
            public static final String LOG_FOCUS = "focus";
            public static final String LOG_HOVER = "hover";
            public static final String LOG_LONG_CLICK = "long_click";
            public static final String LOG_PRESS = "press";
            public static final String LOG_RELEASE = "release";
            public static final String LOG_UNHOVER = "unhover";

            private Companion() {
            }
        }
    }
}
