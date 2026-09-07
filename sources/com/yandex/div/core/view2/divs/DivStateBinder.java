package com.yandex.div.core.view2.divs;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import androidx.core.view.ViewGroupKt;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.yandex.div.core.Div2Logger;
import com.yandex.div.core.DivActionHandler;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.downloader.DivPatchCache;
import com.yandex.div.core.downloader.DivPatchManager;
import com.yandex.div.core.expression.ExpressionsRuntime;
import com.yandex.div.core.expression.local.DivRuntimeVisitor;
import com.yandex.div.core.expression.local.RuntimeStore;
import com.yandex.div.core.expression.variables.TwoWayStringVariableBinder;
import com.yandex.div.core.expression.variables.VariableController;
import com.yandex.div.core.state.DivPathUtils;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.state.TemporaryDivStateCache;
import com.yandex.div.core.util.DivTreeWalk;
import com.yandex.div.core.util.DivTreeWalkKt;
import com.yandex.div.core.util.DivUtilKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivBinder;
import com.yandex.div.core.view2.DivTransitionBuilder;
import com.yandex.div.core.view2.DivViewCreator;
import com.yandex.div.core.view2.DivVisibilityActionTracker;
import com.yandex.div.core.view2.animations.DivComparator;
import com.yandex.div.core.view2.animations.DivTransitionsKt;
import com.yandex.div.core.view2.animations.SceneRootWatcher;
import com.yandex.div.core.view2.divs.widgets.DivStateLayout;
import com.yandex.div.core.view2.divs.widgets.ReleaseUtils;
import com.yandex.div.core.view2.errors.ErrorCollectors;
import com.yandex.div.core.view2.reuse.ReusableTokenList;
import com.yandex.div.core.view2.state.DivStateTransitionHolder;
import com.yandex.div.data.Variable;
import com.yandex.div.internal.KLog;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.internal.widget.DivLayoutParams;
import com.yandex.div.json.ParsingExceptionKt;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.logging.Severity;
import com.yandex.div.state.DivStateCache;
import com.yandex.div2.Div;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivAlignmentHorizontal;
import com.yandex.div2.DivAlignmentVertical;
import com.yandex.div2.DivAnimation;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivContentAlignmentHorizontal;
import com.yandex.div2.DivContentAlignmentVertical;
import com.yandex.div2.DivState;
import com.yandex.div2.DivTransitionTrigger;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: DivStateBinder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u0000 K2\u00020\u0001:\u0001KB}\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ&\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u001a\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020+H\u0002J@\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010\"\u001a\u00020#2\u0006\u0010/\u001a\u00020'2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000104H\u0002J8\u00106\u001a\u0004\u0018\u00010.2\u0006\u0010\"\u001a\u00020#2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001012\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000104H\u0002J<\u00107\u001a\u0004\u0018\u00010.2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001012\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020=H\u0002J\"\u0010?\u001a\u00020!2\b\u00105\u001a\u0004\u0018\u0001042\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020=H\u0002J&\u0010C\u001a\u00020!*\u00020%2\u0006\u0010D\u001a\u00020'2\b\u0010E\u001a\u0004\u0018\u00010'2\u0006\u0010B\u001a\u00020=H\u0002J\f\u0010F\u001a\u00020!*\u000204H\u0002J&\u0010G\u001a\u00020!*\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010E\u001a\u0004\u0018\u00010'2\u0006\u0010B\u001a\u00020=H\u0002J.\u0010H\u001a\u00020!*\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010I\u001a\u00020#2\u0006\u0010(\u001a\u00020)2\b\u0010J\u001a\u0004\u0018\u00010+H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivStateBinder;", "", "baseBinder", "Lcom/yandex/div/core/view2/divs/DivBaseBinder;", "viewCreator", "Lcom/yandex/div/core/view2/DivViewCreator;", "viewBinder", "Ljavax/inject/Provider;", "Lcom/yandex/div/core/view2/DivBinder;", "divStateCache", "Lcom/yandex/div/state/DivStateCache;", "temporaryStateCache", "Lcom/yandex/div/core/state/TemporaryDivStateCache;", "divActionBinder", "Lcom/yandex/div/core/view2/divs/DivActionBinder;", "divActionBeaconSender", "Lcom/yandex/div/core/view2/divs/DivActionBeaconSender;", "divPatchManager", "Lcom/yandex/div/core/downloader/DivPatchManager;", "divPatchCache", "Lcom/yandex/div/core/downloader/DivPatchCache;", "div2Logger", "Lcom/yandex/div/core/Div2Logger;", "divVisibilityActionTracker", "Lcom/yandex/div/core/view2/DivVisibilityActionTracker;", "errorCollectors", "Lcom/yandex/div/core/view2/errors/ErrorCollectors;", "variableBinder", "Lcom/yandex/div/core/expression/variables/TwoWayStringVariableBinder;", "runtimeVisitor", "Lcom/yandex/div/core/expression/local/DivRuntimeVisitor;", "(Lcom/yandex/div/core/view2/divs/DivBaseBinder;Lcom/yandex/div/core/view2/DivViewCreator;Ljavax/inject/Provider;Lcom/yandex/div/state/DivStateCache;Lcom/yandex/div/core/state/TemporaryDivStateCache;Lcom/yandex/div/core/view2/divs/DivActionBinder;Lcom/yandex/div/core/view2/divs/DivActionBeaconSender;Lcom/yandex/div/core/downloader/DivPatchManager;Lcom/yandex/div/core/downloader/DivPatchCache;Lcom/yandex/div/core/Div2Logger;Lcom/yandex/div/core/view2/DivVisibilityActionTracker;Lcom/yandex/div/core/view2/errors/ErrorCollectors;Lcom/yandex/div/core/expression/variables/TwoWayStringVariableBinder;Lcom/yandex/div/core/expression/local/DivRuntimeVisitor;)V", "bindView", "", "context", "Lcom/yandex/div/core/view2/BindingContext;", "layout", "Lcom/yandex/div/core/view2/divs/widgets/DivStateLayout;", "div", "Lcom/yandex/div2/DivState;", "divStatePath", "Lcom/yandex/div/core/state/DivStatePath;", "getValueFromVariable", "", "variableName", "replaceViewsAnimated", "Landroidx/transition/Transition;", "divState", "incomingState", "Lcom/yandex/div2/DivState$State;", "outgoingState", "incoming", "Landroid/view/View;", "outgoing", "setupAnimation", "setupTransitions", "transitionBuilder", "Lcom/yandex/div/core/view2/DivTransitionBuilder;", "transitionHolder", "Lcom/yandex/div/core/view2/state/DivStateTransitionHolder;", "incomingResolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "outgoingResolver", "untrackRecursively", "divView", "Lcom/yandex/div/core/view2/Div2View;", "resolver", "bindClipChildren", "newDiv", "oldDiv", "createLayoutParams", "fixAlignment", "observeStateIdVariable", "bindingContext", "currentStateId", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class DivStateBinder {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "DivStateBinder";
    private final DivBaseBinder baseBinder;
    private final Div2Logger div2Logger;
    private final DivActionBeaconSender divActionBeaconSender;
    private final DivActionBinder divActionBinder;
    private final DivPatchCache divPatchCache;
    private final DivPatchManager divPatchManager;
    private final DivStateCache divStateCache;
    private final DivVisibilityActionTracker divVisibilityActionTracker;
    private final ErrorCollectors errorCollectors;
    private final DivRuntimeVisitor runtimeVisitor;
    private final TemporaryDivStateCache temporaryStateCache;
    private final TwoWayStringVariableBinder variableBinder;
    private final Provider<DivBinder> viewBinder;
    private final DivViewCreator viewCreator;

    @Inject
    public DivStateBinder(DivBaseBinder baseBinder, DivViewCreator viewCreator, Provider<DivBinder> viewBinder, DivStateCache divStateCache, TemporaryDivStateCache temporaryStateCache, DivActionBinder divActionBinder, DivActionBeaconSender divActionBeaconSender, DivPatchManager divPatchManager, DivPatchCache divPatchCache, Div2Logger div2Logger, DivVisibilityActionTracker divVisibilityActionTracker, ErrorCollectors errorCollectors, TwoWayStringVariableBinder variableBinder, DivRuntimeVisitor runtimeVisitor) {
        Intrinsics.checkNotNullParameter(baseBinder, "baseBinder");
        Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
        Intrinsics.checkNotNullParameter(viewBinder, "viewBinder");
        Intrinsics.checkNotNullParameter(divStateCache, "divStateCache");
        Intrinsics.checkNotNullParameter(temporaryStateCache, "temporaryStateCache");
        Intrinsics.checkNotNullParameter(divActionBinder, "divActionBinder");
        Intrinsics.checkNotNullParameter(divActionBeaconSender, "divActionBeaconSender");
        Intrinsics.checkNotNullParameter(divPatchManager, "divPatchManager");
        Intrinsics.checkNotNullParameter(divPatchCache, "divPatchCache");
        Intrinsics.checkNotNullParameter(div2Logger, "div2Logger");
        Intrinsics.checkNotNullParameter(divVisibilityActionTracker, "divVisibilityActionTracker");
        Intrinsics.checkNotNullParameter(errorCollectors, "errorCollectors");
        Intrinsics.checkNotNullParameter(variableBinder, "variableBinder");
        Intrinsics.checkNotNullParameter(runtimeVisitor, "runtimeVisitor");
        this.baseBinder = baseBinder;
        this.viewCreator = viewCreator;
        this.viewBinder = viewBinder;
        this.divStateCache = divStateCache;
        this.temporaryStateCache = temporaryStateCache;
        this.divActionBinder = divActionBinder;
        this.divActionBeaconSender = divActionBeaconSender;
        this.divPatchManager = divPatchManager;
        this.divPatchCache = divPatchCache;
        this.div2Logger = div2Logger;
        this.divVisibilityActionTracker = divVisibilityActionTracker;
        this.errorCollectors = errorCollectors;
        this.variableBinder = variableBinder;
        this.runtimeVisitor = runtimeVisitor;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0266  */
    /* JADX WARN: Code duplicated, block: B:141:0x0320  */
    /* JADX WARN: Code duplicated, block: B:86:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:87:0x01ef A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:88:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:91:0x0201  */
    /* JADX WARN: Code duplicated, block: B:93:0x020e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void bindView(BindingContext context, final DivStateLayout layout, DivState div, final DivStatePath divStatePath) {
        Object next;
        Object next2;
        Div div2;
        DivState.State state;
        DivState.State state2;
        View view;
        Div2View div2View;
        ExpressionResolver expressionResolver;
        DivStatePath divStatePath2;
        ExpressionResolver expressionResolver2;
        View view2;
        View view3;
        boolean z;
        DivState.State state3;
        String str;
        Div2View div2View2;
        View view4;
        DivBase divBaseValue;
        String id;
        View view5;
        ReusableTokenList currentRebindReusableList$div_release;
        String str2;
        Function1<String, Unit> valueUpdater;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(divStatePath, "divStatePath");
        DivState div3 = layout.getDiv();
        Div activeStateDiv = layout.getActiveStateDiv();
        BindingContext bindingContext = layout.getBindingContext();
        ExpressionResolver expressionResolver3 = bindingContext != null ? bindingContext.getExpressionResolver() : null;
        final Div2View divView = context.getDivView();
        this.baseBinder.bindView(context, layout, div, div3);
        ExpressionResolver expressionResolver4 = context.getExpressionResolver();
        fixAlignment(layout, div, div3, expressionResolver4);
        String id2 = divView.getDivTag().getId();
        Intrinsics.checkNotNullExpressionValue(id2, "divView.divTag.id");
        String id$div_release = DivPathUtils.INSTANCE.getId$div_release(div, new Function0<Unit>() { // from class: com.yandex.div.core.view2.divs.DivStateBinder$bindView$id$1
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
                this.this$0.errorCollectors.getOrCreate(divView.getDataTag(), divView.getDivData()).logError(ParsingExceptionKt.missingValue("id", divStatePath.toString()));
            }
        });
        String str3 = divStatePath + '/' + id$div_release;
        String state4 = this.temporaryStateCache.getState(id2, str3);
        if (state4 == null) {
            state4 = this.divStateCache.getState(id2, str3);
        }
        String str4 = state4;
        if (str4 != null && (valueUpdater = layout.getValueUpdater()) != null) {
            valueUpdater.invoke(str4);
        }
        observeStateIdVariable(layout, div, context, divStatePath, str4);
        String valueFromVariable = (str4 != null || (str2 = div.stateIdVariable) == null) ? str4 : getValueFromVariable(context, str2);
        Iterator<T> it = div.states.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((DivState.State) next).stateId, layout.getStateId()));
        DivState.State defaultState = (DivState.State) next;
        if (defaultState == null) {
            defaultState = DivUtilKt.getDefaultState(div, expressionResolver4);
        }
        DivState.State state5 = defaultState;
        Iterator<T> it2 = div.states.iterator();
        do {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
        } while (!Intrinsics.areEqual(((DivState.State) next2).stateId, valueFromVariable));
        DivState.State defaultState2 = (DivState.State) next2;
        if (defaultState2 == null) {
            defaultState2 = DivUtilKt.getDefaultState(div, expressionResolver4);
        }
        DivState.State state6 = defaultState2;
        if (state5 == null || state6 == null) {
            return;
        }
        DivStatePath divStatePathAppend = divStatePath.append(id$div_release, state6.stateId);
        Div div4 = state6.div;
        DivBase divBaseValue2 = div4 != null ? div4.value() : null;
        View childAt = layout.getChildCount() > 0 ? layout.getChildAt(0) : null;
        View uniqueViewForDiv = (div4 == null || (currentRebindReusableList$div_release = divView.getCurrentRebindReusableList$div_release()) == null) ? null : currentRebindReusableList$div_release.getUniqueViewForDiv(div4);
        View view6 = childAt;
        if (Intrinsics.areEqual(layout.getStateId(), state6.stateId)) {
            div2 = div4;
            state = state6;
            state2 = state5;
            view = view6;
            if (divBaseValue2 != null) {
                if (view == null || expressionResolver3 == null) {
                    div2View = divView;
                    expressionResolver = expressionResolver3;
                    divStatePath2 = divStatePathAppend;
                    view2 = null;
                } else {
                    div2View = divView;
                    expressionResolver = expressionResolver3;
                    divStatePath2 = divStatePathAppend;
                    view2 = null;
                    z = DivComparator.areDivsReplaceable$default(DivComparator.INSTANCE, activeStateDiv, div2, expressionResolver, expressionResolver4, null, 16, null);
                    if (z) {
                        uniqueViewForDiv = view;
                    } else {
                        if (uniqueViewForDiv == null) {
                            expressionResolver2 = expressionResolver4;
                            uniqueViewForDiv = this.viewCreator.create(div2, expressionResolver2);
                            createLayoutParams(uniqueViewForDiv);
                        }
                        if (!z) {
                            ReleaseUtils.INSTANCE.releaseAndRemoveChildren$div_release(layout, div2View);
                            layout.addView(uniqueViewForDiv);
                        }
                        if (uniqueViewForDiv != null) {
                            this.viewBinder.get().bind(context, uniqueViewForDiv, div2, divStatePath2);
                        }
                        view3 = uniqueViewForDiv;
                    }
                    expressionResolver2 = expressionResolver4;
                    if (!z) {
                        ReleaseUtils.INSTANCE.releaseAndRemoveChildren$div_release(layout, div2View);
                        layout.addView(uniqueViewForDiv);
                    }
                    if (uniqueViewForDiv != null) {
                        this.viewBinder.get().bind(context, uniqueViewForDiv, div2, divStatePath2);
                    }
                    view3 = uniqueViewForDiv;
                }
                if (z) {
                    uniqueViewForDiv = view;
                } else {
                    if (uniqueViewForDiv == null) {
                        expressionResolver2 = expressionResolver4;
                        uniqueViewForDiv = this.viewCreator.create(div2, expressionResolver2);
                        createLayoutParams(uniqueViewForDiv);
                    }
                    if (!z) {
                        ReleaseUtils.INSTANCE.releaseAndRemoveChildren$div_release(layout, div2View);
                        layout.addView(uniqueViewForDiv);
                    }
                    if (uniqueViewForDiv != null) {
                        this.viewBinder.get().bind(context, uniqueViewForDiv, div2, divStatePath2);
                    }
                    view3 = uniqueViewForDiv;
                }
                expressionResolver2 = expressionResolver4;
                if (!z) {
                    ReleaseUtils.INSTANCE.releaseAndRemoveChildren$div_release(layout, div2View);
                    layout.addView(uniqueViewForDiv);
                }
                if (uniqueViewForDiv != null) {
                    this.viewBinder.get().bind(context, uniqueViewForDiv, div2, divStatePath2);
                }
                view3 = uniqueViewForDiv;
            } else {
                div2View = divView;
                expressionResolver = expressionResolver3;
                divStatePath2 = divStatePathAppend;
                expressionResolver2 = expressionResolver4;
                view2 = null;
                ReleaseUtils.INSTANCE.releaseAndRemoveChildren$div_release(layout, div2View);
                view3 = null;
            }
        } else {
            if (div4 != null) {
                if (uniqueViewForDiv == null) {
                    uniqueViewForDiv = this.viewCreator.create(div4, expressionResolver4);
                    createLayoutParams(uniqueViewForDiv);
                }
                view5 = uniqueViewForDiv;
            } else {
                view5 = null;
            }
            View view7 = view5;
            div2 = div4;
            state = state6;
            state2 = state5;
            Transition transitionReplaceViewsAnimated = replaceViewsAnimated(context, div, state6, state5, view7, view6);
            if (transitionReplaceViewsAnimated != null) {
                DivStateLayout divStateLayout = layout;
                TransitionManager.endTransitions(divStateLayout);
                SceneRootWatcher.INSTANCE.watchFor(divStateLayout, transitionReplaceViewsAnimated);
                TransitionManager.beginDelayedTransition(divStateLayout, transitionReplaceViewsAnimated);
            }
            DivStateLayout divStateLayout2 = layout;
            ReleaseUtils.INSTANCE.releaseAndRemoveChildren$div_release(divStateLayout2, divView);
            if (view7 != null) {
                layout.addView(view7);
                if (div2 != null) {
                    this.viewBinder.get().bind(context, view7, div2, divStatePathAppend);
                }
            }
            view = view6;
            if (view != null) {
                divView.getDivTransitionHandler().runTransitions(divStateLayout2, false);
            }
            view3 = view7;
            div2View = divView;
            expressionResolver = expressionResolver3;
            divStatePath2 = divStatePathAppend;
            expressionResolver2 = expressionResolver4;
            view2 = null;
        }
        if (view != null) {
            view.startAnimation(new AnimationSet(false));
            DivState.State state7 = state;
            if (Intrinsics.areEqual(div3, div) && Intrinsics.areEqual(state7, state2)) {
                state3 = state7;
            } else {
                div2View.unbindViewFromDiv$div_release(view);
                if (activeStateDiv == null || expressionResolver == null) {
                    state3 = state7;
                } else {
                    state3 = state7;
                    DivVisibilityActionTracker.trackVisibilityActionsOf$default(this.divVisibilityActionTracker, div2View, expressionResolver, null, activeStateDiv, null, 16, null);
                    untrackRecursively(view, div2View, expressionResolver);
                }
            }
        } else {
            state3 = state;
        }
        if (view3 != null && divBaseValue2 != null && (divBaseValue2.getVisibilityAction() != null || divBaseValue2.getVisibilityActions() != null)) {
            div2View.bindViewToDiv$div_release(view3, div2);
            final View view8 = view3;
            final Div2View div2View3 = div2View;
            final ExpressionResolver expressionResolver5 = expressionResolver2;
            final Div div5 = div2;
            view8.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yandex.div.core.view2.divs.DivStateBinder$bindView$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view9, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    view9.removeOnLayoutChangeListener(this);
                    DivVisibilityActionTracker.trackVisibilityActionsOf$default(this.this$0.divVisibilityActionTracker, div2View3, expressionResolver5, view8, div5, null, 16, null);
                }
            });
        }
        Div activeStateDiv2 = layout.getActiveStateDiv();
        if (activeStateDiv2 == null || (divBaseValue = activeStateDiv2.value()) == null) {
            str = view2;
        } else {
            id = divBaseValue.getId();
        }
        if (str == 0) {
            str = id;
            div2View2 = div2View;
        } else {
            List<View> listBuildViewsForId = this.divPatchManager.buildViewsForId(context, str);
            if (listBuildViewsForId == null) {
                str = id;
                str = id;
                view4 = view2;
            } else if (listBuildViewsForId.size() > 1) {
                KLog kLog = KLog.INSTANCE;
                if (kLog.isAtLeast(Severity.ERROR)) {
                    str = id;
                    kLog.print(6, TAG, "Unable to patch state because there is more than 1 div in the patch");
                }
                str = id;
                str = id;
                view4 = view2;
            } else {
                str = id;
                view4 = (View) CollectionsKt.firstOrNull((List) listBuildViewsForId);
            }
            List<Div> patchDivListById = this.divPatchCache.getPatchDivListById(div2View.getDataTag(), str);
            Div div6 = patchDivListById != null ? (Div) CollectionsKt.firstOrNull((List) patchDivListById) : view2;
            if (view4 == null || div6 == null) {
                str = id;
                div2View2 = div2View;
            } else {
                div2View2 = div2View;
                ReleaseUtils.INSTANCE.releaseAndRemoveChildren$div_release(layout, div2View2);
                layout.addView(view4);
                if (BaseDivViewExtensionsKt.getHasSightActions(div6.value())) {
                    div2View2.bindViewToDiv$div_release(view4, div6);
                }
                this.viewBinder.get().bind(context, view4, div6, divStatePath2);
            }
        }
        final List<DivAction> list = state3.swipeOutActions;
        if (list != null) {
            final Div2View div2View4 = div2View2;
            final ExpressionResolver expressionResolver6 = expressionResolver2;
            layout.setSwipeOutCallback(new Function0<Unit>() { // from class: com.yandex.div.core.view2.divs.DivStateBinder.bindView.6
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
                    Div2View div2View5 = div2View4;
                    final DivStateBinder divStateBinder = this;
                    final Div2View div2View6 = div2View4;
                    final ExpressionResolver expressionResolver7 = expressionResolver6;
                    final List<DivAction> list2 = list;
                    final DivStateLayout divStateLayout3 = layout;
                    div2View5.bulkActions$div_release(new Function0<Unit>() { // from class: com.yandex.div.core.view2.divs.DivStateBinder.bindView.6.1
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
                            DivActionBinder divActionBinder = divStateBinder.divActionBinder;
                            Div2View div2View7 = div2View6;
                            ExpressionResolver expressionResolver8 = expressionResolver7;
                            List<DivAction> list3 = list2;
                            final DivStateBinder divStateBinder2 = divStateBinder;
                            final Div2View div2View8 = div2View6;
                            final ExpressionResolver expressionResolver9 = expressionResolver7;
                            final DivStateLayout divStateLayout4 = divStateLayout3;
                            divActionBinder.handleActions$div_release(div2View7, expressionResolver8, list3, DivActionHandler.DivActionReason.STATE_SWIPE_OUT, new Function1<DivAction, Unit>() { // from class: com.yandex.div.core.view2.divs.DivStateBinder.bindView.6.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(DivAction divAction) {
                                    invoke2(divAction);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(DivAction it3) {
                                    Intrinsics.checkNotNullParameter(it3, "it");
                                    divStateBinder2.div2Logger.logSwipedAway(div2View8, expressionResolver9, divStateLayout4, it3);
                                    divStateBinder2.divActionBeaconSender.sendSwipeOutActionBeacon(it3, expressionResolver9);
                                }
                            });
                        }
                    });
                }
            });
        } else {
            layout.setSwipeOutCallback(view2);
        }
        layout.setActiveStateDiv$div_release(div2);
        layout.setPath(divStatePath2);
        bindClipChildren(layout, div, div3, expressionResolver2);
        if (view != null) {
            this.runtimeVisitor.createAndAttachRuntimesToState(div2View2, div, divStatePath, context.getExpressionResolver());
        }
    }

    private final void fixAlignment(DivStateLayout divStateLayout, DivState divState, DivState divState2, ExpressionResolver expressionResolver) {
        DivAlignmentHorizontal alignmentHorizontal;
        DivAlignmentVertical divAlignmentVerticalEvaluate;
        Expression<DivAlignmentHorizontal> alignmentHorizontal2 = divState.getAlignmentHorizontal();
        Expression<DivAlignmentVertical> alignmentVertical = divState.getAlignmentVertical();
        DivAlignmentVertical alignmentVertical2 = null;
        if (Intrinsics.areEqual(alignmentHorizontal2, divState2 != null ? divState2.getAlignmentHorizontal() : null)) {
            if (Intrinsics.areEqual(alignmentVertical, divState2 != null ? divState2.getAlignmentVertical() : null)) {
                return;
            }
        }
        if (alignmentHorizontal2 == null || (alignmentHorizontal = alignmentHorizontal2.evaluate(expressionResolver)) == null) {
            DivContentAlignmentHorizontal divContentAlignmentHorizontalExtractParentContentAlignmentHorizontal = BaseDivViewExtensionsKt.extractParentContentAlignmentHorizontal(divStateLayout, expressionResolver);
            alignmentHorizontal = divContentAlignmentHorizontalExtractParentContentAlignmentHorizontal != null ? BaseDivViewExtensionsKt.toAlignmentHorizontal(divContentAlignmentHorizontalExtractParentContentAlignmentHorizontal) : null;
        }
        if (alignmentVertical == null || (divAlignmentVerticalEvaluate = alignmentVertical.evaluate(expressionResolver)) == null) {
            DivContentAlignmentVertical divContentAlignmentVerticalExtractParentContentAlignmentVertical = BaseDivViewExtensionsKt.extractParentContentAlignmentVertical(divStateLayout, expressionResolver);
            if (divContentAlignmentVerticalExtractParentContentAlignmentVertical != null) {
                alignmentVertical2 = BaseDivViewExtensionsKt.toAlignmentVertical(divContentAlignmentVerticalExtractParentContentAlignmentVertical);
            }
        } else {
            alignmentVertical2 = divAlignmentVerticalEvaluate;
        }
        BaseDivViewExtensionsKt.applyAlignment(divStateLayout, alignmentHorizontal, alignmentVertical2);
    }

    private final String getValueFromVariable(BindingContext context, String variableName) {
        VariableController variableController;
        Object value;
        ExpressionsRuntime runtimeWithOrNull$div_release;
        RuntimeStore runtimeStore = context.getRuntimeStore();
        if (runtimeStore == null || (runtimeWithOrNull$div_release = runtimeStore.getRuntimeWithOrNull$div_release(context.getExpressionResolver())) == null || (variableController = runtimeWithOrNull$div_release.getVariableController()) == null) {
            ExpressionsRuntime expressionsRuntime = context.getDivView().getExpressionsRuntime();
            if (expressionsRuntime == null) {
                return null;
            }
            variableController = expressionsRuntime.getVariableController();
        }
        Variable mutableVariable = variableController.getMutableVariable(variableName);
        if (mutableVariable == null || (value = mutableVariable.getValue()) == null) {
            return null;
        }
        return value.toString();
    }

    private final void observeStateIdVariable(final DivStateLayout divStateLayout, final DivState divState, final BindingContext bindingContext, final DivStatePath divStatePath, final String str) {
        String str2 = divState.stateIdVariable;
        if (str2 == null) {
            return;
        }
        divStateLayout.addSubscription(this.variableBinder.bindVariable(bindingContext, str2, new TwoWayStringVariableBinder.Callbacks() { // from class: com.yandex.div.core.view2.divs.DivStateBinder$observeStateIdVariable$subscription$1
            @Override // com.yandex.div.core.expression.variables.TwoWayVariableBinder.Callbacks
            public void onVariableChanged(String value) {
                if (value == null || Intrinsics.areEqual(value, str)) {
                    return;
                }
                bindingContext.getDivView().switchToState(divStatePath.append(DivPathUtils.getId$div_release$default(DivPathUtils.INSTANCE, divState, null, 1, null), value), true);
            }

            @Override // com.yandex.div.core.expression.variables.TwoWayVariableBinder.Callbacks
            public void setViewStateChangeListener(Function1<? super String, Unit> valueUpdater) {
                Intrinsics.checkNotNullParameter(valueUpdater, "valueUpdater");
                divStateLayout.setValueUpdater(valueUpdater);
            }
        }, divStatePath));
    }

    private final void bindClipChildren(DivStateLayout divStateLayout, DivState divState, DivState divState2, ExpressionResolver expressionResolver) {
        BaseDivViewExtensionsKt.bindClipChildren(divStateLayout, divState.clipToBounds, divState2 != null ? divState2.clipToBounds : null, expressionResolver);
    }

    private final void untrackRecursively(View outgoing, Div2View divView, ExpressionResolver resolver) {
        if (outgoing instanceof ViewGroup) {
            for (View view : ViewGroupKt.getChildren((ViewGroup) outgoing)) {
                Div divUnbindViewFromDiv$div_release = divView.unbindViewFromDiv$div_release(view);
                if (divUnbindViewFromDiv$div_release != null) {
                    DivVisibilityActionTracker.trackVisibilityActionsOf$default(this.divVisibilityActionTracker, divView, resolver, null, divUnbindViewFromDiv$div_release, null, 16, null);
                }
                untrackRecursively(view, divView, resolver);
            }
        }
    }

    private final Transition replaceViewsAnimated(BindingContext context, DivState divState, DivState.State incomingState, DivState.State outgoingState, View incoming, View outgoing) {
        BindingContext bindingContext;
        ExpressionResolver expressionResolver;
        Div div;
        Div div2;
        if (outgoing == null || (bindingContext = BaseDivViewExtensionsKt.getBindingContext(outgoing)) == null || (expressionResolver = bindingContext.getExpressionResolver()) == null) {
            return setupAnimation(context, incomingState, outgoingState, incoming, outgoing);
        }
        ExpressionResolver expressionResolver2 = context.getExpressionResolver();
        if (DivTransitionsKt.allowsTransitionsOnStateChange(divState, expressionResolver2) && ((outgoingState != null && (div2 = outgoingState.div) != null && DivUtilKt.containsStateInnerTransitions(div2, expressionResolver)) || ((div = incomingState.div) != null && DivUtilKt.containsStateInnerTransitions(div, expressionResolver2)))) {
            return setupTransitions(context.getDivView().getViewComponent().getTransitionBuilder(), context.getDivView().getViewComponent().getStateTransitionHolder(), incomingState, outgoingState, expressionResolver2, expressionResolver);
        }
        return setupAnimation(context, incomingState, outgoingState, incoming, outgoing);
    }

    private final void createLayoutParams(View view) {
        view.setLayoutParams(new DivLayoutParams(-1, -2));
    }

    private final Transition setupTransitions(DivTransitionBuilder transitionBuilder, DivStateTransitionHolder transitionHolder, DivState.State incomingState, DivState.State outgoingState, ExpressionResolver incomingResolver, ExpressionResolver outgoingResolver) {
        DivTreeWalk divTreeWalkWalk;
        DivTreeWalk divTreeWalkOnEnter;
        Div div;
        DivTreeWalk divTreeWalkWalk2;
        DivTreeWalk divTreeWalkOnEnter2;
        Sequence<DivItemBuilderResult> sequenceFilter = null;
        if (Intrinsics.areEqual(incomingState, outgoingState)) {
            return null;
        }
        Sequence<DivItemBuilderResult> sequenceFilter2 = (outgoingState == null || (div = outgoingState.div) == null || (divTreeWalkWalk2 = DivTreeWalkKt.walk(div, outgoingResolver)) == null || (divTreeWalkOnEnter2 = divTreeWalkWalk2.onEnter(new Function1<Div, Boolean>() { // from class: com.yandex.div.core.view2.divs.DivStateBinder$setupTransitions$transition$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Div div2) {
                Intrinsics.checkNotNullParameter(div2, "div");
                return Boolean.valueOf(!(div2 instanceof Div.State));
            }
        })) == null) ? null : SequencesKt.filter(divTreeWalkOnEnter2, new Function1<DivItemBuilderResult, Boolean>() { // from class: com.yandex.div.core.view2.divs.DivStateBinder$setupTransitions$transition$2
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(DivItemBuilderResult item) {
                Intrinsics.checkNotNullParameter(item, "item");
                List<DivTransitionTrigger> transitionTriggers = item.getDiv().value().getTransitionTriggers();
                return Boolean.valueOf(transitionTriggers != null ? DivTransitionsKt.allowsTransitionsOnStateChange(transitionTriggers) : true);
            }
        });
        Div div2 = incomingState.div;
        if (div2 != null && (divTreeWalkWalk = DivTreeWalkKt.walk(div2, incomingResolver)) != null && (divTreeWalkOnEnter = divTreeWalkWalk.onEnter(new Function1<Div, Boolean>() { // from class: com.yandex.div.core.view2.divs.DivStateBinder$setupTransitions$transition$3
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Div div3) {
                Intrinsics.checkNotNullParameter(div3, "div");
                return Boolean.valueOf(!(div3 instanceof Div.State));
            }
        })) != null) {
            sequenceFilter = SequencesKt.filter(divTreeWalkOnEnter, new Function1<DivItemBuilderResult, Boolean>() { // from class: com.yandex.div.core.view2.divs.DivStateBinder$setupTransitions$transition$4
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(DivItemBuilderResult item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    List<DivTransitionTrigger> transitionTriggers = item.getDiv().value().getTransitionTriggers();
                    return Boolean.valueOf(transitionTriggers != null ? DivTransitionsKt.allowsTransitionsOnStateChange(transitionTriggers) : true);
                }
            });
        }
        TransitionSet transitionSetBuildTransitions = transitionBuilder.buildTransitions(sequenceFilter2, sequenceFilter, outgoingResolver, incomingResolver);
        transitionHolder.append(transitionSetBuildTransitions);
        return transitionSetBuildTransitions;
    }

    private final Transition setupAnimation(BindingContext context, DivState.State incomingState, DivState.State outgoingState, View incoming, View outgoing) {
        List<DivAnimation> listEmptyList;
        BindingContext bindingContext;
        List<DivAnimation> listEmptyList2;
        ExpressionResolver expressionResolver = context.getExpressionResolver();
        DivAnimation divAnimation = incomingState.animationIn;
        ExpressionResolver expressionResolver2 = null;
        DivAnimation divAnimation2 = outgoingState != null ? outgoingState.animationOut : null;
        if (divAnimation == null && divAnimation2 == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (divAnimation != null && incoming != null) {
            if (divAnimation.name.evaluate(expressionResolver) != DivAnimation.Name.SET) {
                listEmptyList2 = CollectionsKt.listOf(divAnimation);
            } else {
                listEmptyList2 = divAnimation.items;
                if (listEmptyList2 == null) {
                    listEmptyList2 = CollectionsKt.emptyList();
                }
            }
            for (DivAnimation divAnimation3 : listEmptyList2) {
                Transition transition = DivStateBinderKt.toTransition(divAnimation3, true, expressionResolver);
                if (transition != null) {
                    transitionSet.addTransition(transition.addTarget(incoming).setDuration(divAnimation3.duration.evaluate(expressionResolver).longValue()).setStartDelay(divAnimation3.startDelay.evaluate(expressionResolver).longValue()).setInterpolator(DivUtilKt.getAndroidInterpolator(divAnimation3.interpolator.evaluate(expressionResolver))));
                }
            }
        }
        if (outgoing != null && (bindingContext = BaseDivViewExtensionsKt.getBindingContext(outgoing)) != null) {
            expressionResolver2 = bindingContext.getExpressionResolver();
        }
        if (divAnimation2 != null && expressionResolver2 != null) {
            if (divAnimation2.name.evaluate(expressionResolver2) != DivAnimation.Name.SET) {
                listEmptyList = CollectionsKt.listOf(divAnimation2);
            } else {
                listEmptyList = divAnimation2.items;
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
            }
            for (DivAnimation divAnimation4 : listEmptyList) {
                Transition transition2 = DivStateBinderKt.toTransition(divAnimation4, false, expressionResolver2);
                if (transition2 != null) {
                    transitionSet.addTransition(transition2.addTarget(outgoing).setDuration(divAnimation4.duration.evaluate(expressionResolver2).longValue()).setStartDelay(divAnimation4.startDelay.evaluate(expressionResolver2).longValue()).setInterpolator(DivUtilKt.getAndroidInterpolator(divAnimation4.interpolator.evaluate(expressionResolver2))));
                }
            }
        }
        if (outgoing != null) {
            outgoing.clearAnimation();
        }
        return transitionSet;
    }

    /* JADX INFO: compiled from: DivStateBinder.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivStateBinder$Companion;", "", "()V", "TAG", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
