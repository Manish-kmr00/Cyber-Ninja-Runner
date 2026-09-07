package com.yandex.div.core.view2;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.HandlerCompat;
import androidx.core.view.ViewGroupKt;
import com.yandex.div.DivDataTag;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.util.SynchronizedWeakHashMap;
import com.yandex.div.core.util.ViewsKt;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.core.view2.divs.DivSightExtensionsKt;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.KLog;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.logging.Severity;
import com.yandex.div2.Div;
import com.yandex.div2.DivDisappearAction;
import com.yandex.div2.DivSightAction;
import com.yandex.div2.DivVisibilityAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivVisibilityActionTracker.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0011\u0018\u0000 B2\u00020\u0001:\u0001BB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\t2\u0006\u0010!\u001a\u00020\"H\u0012J\"\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0)H\u0016J2\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u0010 \u001a\u0004\u0018\u00010\t2\u0006\u0010!\u001a\u00020\"2\u0006\u0010/\u001a\u000200H\u0012J6\u00101\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010 \u001a\u00020\t2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\"032\u0006\u00104\u001a\u000205H\u0012J\"\u00106\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u00010\u000eH\u0016J \u00108\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020\t2\u0006\u0010'\u001a\u00020\u000eH\u0016J>\u00109\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\u000e2\u001a\u0010:\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00130;H\u0012J6\u0010<\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010 \u001a\u00020\t2\u0006\u0010'\u001a\u00020\u000e2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\"03H\u0012J:\u0010>\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u0010 \u001a\u0004\u0018\u00010\t2\u0006\u0010'\u001a\u00020\u000e2\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020\"03H\u0017J \u0010?\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\t2\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010/\u001a\u000200H\u0012J\u0016\u0010@\u001a\u00020\u001d2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\t03H\u0017R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bX\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\rX\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\bX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0092\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00130\bX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\bX\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/yandex/div/core/view2/DivVisibilityActionTracker;", "", "viewVisibilityCalculator", "Lcom/yandex/div/core/view2/ViewVisibilityCalculator;", "visibilityActionDispatcher", "Lcom/yandex/div/core/view2/DivVisibilityActionDispatcher;", "(Lcom/yandex/div/core/view2/ViewVisibilityCalculator;Lcom/yandex/div/core/view2/DivVisibilityActionDispatcher;)V", "appearedForDisappearActions", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "", "Lcom/yandex/div2/DivDisappearAction;", "divWithWaitingDisappearActions", "Lcom/yandex/div/core/util/SynchronizedWeakHashMap;", "Lcom/yandex/div2/Div;", "enqueuedVisibilityActions", "handler", "Landroid/os/Handler;", "hasPostedUpdateVisibilityTask", "", "isEnabledObserver", "Lcom/yandex/div/core/view2/SightActionIsEnabledObserver;", "previousVisibilityIsFull", "trackedTokens", "Lcom/yandex/div/core/view2/DivVisibilityTokenHolder;", "updateVisibilityTask", "Ljava/lang/Runnable;", "visibleActions", "cancelTracking", "", "compositeLogId", "Lcom/yandex/div/core/view2/CompositeLogId;", "view", "action", "Lcom/yandex/div2/DivSightAction;", "cancelTrackingViewsHierarchy", "context", "Lcom/yandex/div/core/view2/BindingContext;", "root", "div", "getDivWithWaitingDisappearActions", "", "shouldTrackVisibilityAction", "scope", "Lcom/yandex/div/core/view2/Div2View;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "visibilityPercentage", "", "startTracking", "actions", "", "delayMs", "", "startTrackingViewsHierarchy", "rootDiv", "trackDetachedView", "trackViewsHierarchy", "trackAction", "Lkotlin/Function2;", "trackVisibilityActions", "visibilityActions", "trackVisibilityActionsOf", "updateVisibility", "updateVisibleViews", "viewList", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public class DivVisibilityActionTracker {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "DivVisibilityActionTracker";
    private final WeakHashMap<View, Set<DivDisappearAction>> appearedForDisappearActions;
    private final SynchronizedWeakHashMap<View, Div> divWithWaitingDisappearActions;
    private final WeakHashMap<View, Div> enqueuedVisibilityActions;
    private final Handler handler;
    private boolean hasPostedUpdateVisibilityTask;
    private final SightActionIsEnabledObserver isEnabledObserver;
    private final WeakHashMap<View, Boolean> previousVisibilityIsFull;
    private final DivVisibilityTokenHolder trackedTokens;
    private final Runnable updateVisibilityTask;
    private final ViewVisibilityCalculator viewVisibilityCalculator;
    private final DivVisibilityActionDispatcher visibilityActionDispatcher;
    private final WeakHashMap<View, Div> visibleActions;

    @Inject
    public DivVisibilityActionTracker(ViewVisibilityCalculator viewVisibilityCalculator, DivVisibilityActionDispatcher visibilityActionDispatcher) {
        Intrinsics.checkNotNullParameter(viewVisibilityCalculator, "viewVisibilityCalculator");
        Intrinsics.checkNotNullParameter(visibilityActionDispatcher, "visibilityActionDispatcher");
        this.viewVisibilityCalculator = viewVisibilityCalculator;
        this.visibilityActionDispatcher = visibilityActionDispatcher;
        this.handler = new Handler(Looper.getMainLooper());
        this.trackedTokens = new DivVisibilityTokenHolder();
        this.isEnabledObserver = new SightActionIsEnabledObserver(new Function5<Div2View, ExpressionResolver, View, Div, DivSightAction, Unit>() { // from class: com.yandex.div.core.view2.DivVisibilityActionTracker$isEnabledObserver$1
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(Div2View div2View, ExpressionResolver expressionResolver, View view, Div div, DivSightAction divSightAction) {
                invoke2(div2View, expressionResolver, view, div, divSightAction);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Div2View scope, ExpressionResolver resolver, View view, Div div, DivSightAction action) {
                Intrinsics.checkNotNullParameter(scope, "scope");
                Intrinsics.checkNotNullParameter(resolver, "resolver");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(div, "div");
                Intrinsics.checkNotNullParameter(action, "action");
                this.this$0.trackVisibilityActions(scope, resolver, view, div, CollectionsKt.listOf(action));
            }
        }, new Function5<Div2View, ExpressionResolver, View, Div, DivSightAction, Unit>() { // from class: com.yandex.div.core.view2.DivVisibilityActionTracker$isEnabledObserver$2
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(Div2View div2View, ExpressionResolver expressionResolver, View view, Div div, DivSightAction divSightAction) {
                invoke2(div2View, expressionResolver, view, div, divSightAction);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Div2View scope, ExpressionResolver resolver, View view, Div div, DivSightAction action) {
                Intrinsics.checkNotNullParameter(scope, "scope");
                Intrinsics.checkNotNullParameter(resolver, "resolver");
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 2>");
                Intrinsics.checkNotNullParameter(div, "div");
                Intrinsics.checkNotNullParameter(action, "action");
                this.this$0.shouldTrackVisibilityAction(scope, resolver, null, action, 0);
            }
        });
        this.visibleActions = new WeakHashMap<>();
        this.enqueuedVisibilityActions = new WeakHashMap<>();
        this.previousVisibilityIsFull = new WeakHashMap<>();
        this.divWithWaitingDisappearActions = new SynchronizedWeakHashMap<>();
        this.appearedForDisappearActions = new WeakHashMap<>();
        this.updateVisibilityTask = new Runnable() { // from class: com.yandex.div.core.view2.DivVisibilityActionTracker$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DivVisibilityActionTracker.updateVisibilityTask$lambda$0(this.f$0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateVisibilityTask$lambda$0(DivVisibilityActionTracker this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.visibilityActionDispatcher.dispatchVisibleViewsChanged(this$0.visibleActions);
        this$0.hasPostedUpdateVisibilityTask = false;
    }

    public Map<View, Div> getDivWithWaitingDisappearActions() {
        return this.divWithWaitingDisappearActions.createMap();
    }

    public void updateVisibleViews(List<? extends View> viewList) {
        Intrinsics.checkNotNullParameter(viewList, "viewList");
        Iterator<Map.Entry<View, Div>> it = this.visibleActions.entrySet().iterator();
        while (it.hasNext()) {
            if (!viewList.contains(it.next().getKey())) {
                it.remove();
            }
        }
        if (this.hasPostedUpdateVisibilityTask) {
            return;
        }
        this.hasPostedUpdateVisibilityTask = true;
        this.handler.post(this.updateVisibilityTask);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackVisibilityActionsOf$default(DivVisibilityActionTracker divVisibilityActionTracker, Div2View div2View, ExpressionResolver expressionResolver, View view, Div div, List list, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackVisibilityActionsOf");
        }
        if ((i & 16) != 0) {
            list = BaseDivViewExtensionsKt.getAllSightActions(div.value());
        }
        divVisibilityActionTracker.trackVisibilityActionsOf(div2View, expressionResolver, view, div, list);
    }

    public void trackVisibilityActionsOf(final Div2View scope, final ExpressionResolver resolver, final View view, final Div div, final List<? extends DivSightAction> visibilityActions) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(visibilityActions, "visibilityActions");
        if (visibilityActions.isEmpty()) {
            return;
        }
        final DivDataTag dataTag = scope.getDataTag();
        if (view != null) {
            if (this.enqueuedVisibilityActions.containsKey(view)) {
                return;
            }
            if (!ViewsKt.isHierarchyLaidOut(view) || view.isLayoutRequested()) {
                View viewFarthestLayoutCaller = ViewsKt.farthestLayoutCaller(view);
                if (viewFarthestLayoutCaller != null) {
                    viewFarthestLayoutCaller.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yandex.div.core.view2.DivVisibilityActionTracker$trackVisibilityActionsOf$$inlined$doOnHierarchyLayout$1
                        @Override // android.view.View.OnLayoutChangeListener
                        public void onLayoutChange(View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                            Intrinsics.checkNotNullParameter(view2, "view");
                            view2.removeOnLayoutChangeListener(this);
                            if (Intrinsics.areEqual(scope.getDataTag(), dataTag)) {
                                this.isEnabledObserver.observe(view, scope, resolver, div, visibilityActions);
                                DivVisibilityActionTracker divVisibilityActionTracker = this;
                                Div2View div2View = scope;
                                ExpressionResolver expressionResolver = resolver;
                                View view3 = view;
                                Div div2 = div;
                                List list = visibilityActions;
                                ArrayList arrayList = new ArrayList();
                                for (Object obj : list) {
                                    if (((DivSightAction) obj).isEnabled().evaluate(resolver).booleanValue()) {
                                        arrayList.add(obj);
                                    }
                                }
                                divVisibilityActionTracker.trackVisibilityActions(div2View, expressionResolver, view3, div2, arrayList);
                            }
                            this.enqueuedVisibilityActions.remove(view);
                        }
                    });
                    Unit unit = Unit.INSTANCE;
                }
                this.enqueuedVisibilityActions.put(view, div);
                return;
            }
            if (Intrinsics.areEqual(scope.getDataTag(), dataTag)) {
                this.isEnabledObserver.observe(view, scope, resolver, div, visibilityActions);
                ArrayList arrayList = new ArrayList();
                for (Object obj : visibilityActions) {
                    if (((DivSightAction) obj).isEnabled().evaluate(resolver).booleanValue()) {
                        arrayList.add(obj);
                    }
                }
                trackVisibilityActions(scope, resolver, view, div, arrayList);
            }
            this.enqueuedVisibilityActions.remove(view);
            return;
        }
        List<? extends DivSightAction> list = visibilityActions;
        this.isEnabledObserver.cancelObserving(list);
        Iterator<? extends DivSightAction> it = list.iterator();
        while (it.hasNext()) {
            shouldTrackVisibilityAction(scope, resolver, null, it.next(), 0);
        }
    }

    public void trackDetachedView(BindingContext context, View view, Div div) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        List<DivDisappearAction> disappearActions = div.value().getDisappearActions();
        if (disappearActions == null) {
            return;
        }
        Div2View divView = context.getDivView();
        ExpressionResolver expressionResolver = context.getExpressionResolver();
        ArrayList arrayList = new ArrayList();
        for (Object obj : disappearActions) {
            if (((DivDisappearAction) obj).isEnabled().evaluate(context.getExpressionResolver()).booleanValue()) {
                arrayList.add(obj);
            }
        }
        trackVisibilityActions(divView, expressionResolver, view, div, arrayList);
    }

    public void startTrackingViewsHierarchy(final BindingContext context, View root, Div rootDiv) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(root, "root");
        trackViewsHierarchy(context, root, rootDiv, new Function2<View, Div, Boolean>() { // from class: com.yandex.div.core.view2.DivVisibilityActionTracker.startTrackingViewsHierarchy.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(View currentView, Div div) {
                Intrinsics.checkNotNullParameter(currentView, "currentView");
                boolean zIsViewFullyVisible = DivVisibilityActionTracker.this.viewVisibilityCalculator.isViewFullyVisible(currentView);
                boolean z = true;
                if (zIsViewFullyVisible && Intrinsics.areEqual(DivVisibilityActionTracker.this.previousVisibilityIsFull.get(currentView), (Object) true)) {
                    z = false;
                } else {
                    DivVisibilityActionTracker.this.previousVisibilityIsFull.put(currentView, Boolean.valueOf(zIsViewFullyVisible));
                    if (div != null) {
                        DivVisibilityActionTracker divVisibilityActionTracker = DivVisibilityActionTracker.this;
                        BindingContext bindingContext = context;
                        DivVisibilityActionTracker.trackVisibilityActionsOf$default(divVisibilityActionTracker, bindingContext.getDivView(), bindingContext.getExpressionResolver(), currentView, div, null, 16, null);
                    }
                }
                return Boolean.valueOf(z);
            }
        });
    }

    public void cancelTrackingViewsHierarchy(final BindingContext context, View root, Div div) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(root, "root");
        trackViewsHierarchy(context, root, div, new Function2<View, Div, Boolean>() { // from class: com.yandex.div.core.view2.DivVisibilityActionTracker.cancelTrackingViewsHierarchy.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(View currentView, Div div2) {
                Intrinsics.checkNotNullParameter(currentView, "currentView");
                DivVisibilityActionTracker.this.previousVisibilityIsFull.remove(currentView);
                if (div2 != null) {
                    DivVisibilityActionTracker divVisibilityActionTracker = DivVisibilityActionTracker.this;
                    BindingContext bindingContext = context;
                    DivVisibilityActionTracker.trackVisibilityActionsOf$default(divVisibilityActionTracker, bindingContext.getDivView(), bindingContext.getExpressionResolver(), null, div2, null, 16, null);
                }
                return true;
            }
        });
    }

    private void trackViewsHierarchy(BindingContext context, View view, Div div, Function2<? super View, ? super Div, Boolean> trackAction) {
        if (trackAction.invoke(view, div).booleanValue() && (view instanceof ViewGroup)) {
            for (View view2 : ViewGroupKt.getChildren((ViewGroup) view)) {
                trackViewsHierarchy(context, view2, context.getDivView().takeBindingDiv$div_release(view2), trackAction);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackVisibilityActions(Div2View scope, ExpressionResolver resolver, View view, Div div, List<? extends DivSightAction> visibilityActions) {
        DivVisibilityActionTracker divVisibilityActionTracker = this;
        Assert.assertMainThread();
        int iCalculateVisibilityPercentage = divVisibilityActionTracker.viewVisibilityCalculator.calculateVisibilityPercentage(view);
        divVisibilityActionTracker.updateVisibility(view, div, iCalculateVisibilityPercentage);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : visibilityActions) {
            Long lValueOf = Long.valueOf(DivSightExtensionsKt.getDuration((DivSightAction) obj).evaluate(resolver).longValue());
            Object obj2 = linkedHashMap.get(lValueOf);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(lValueOf, obj2);
            }
            ((List) obj2).add(obj);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            long jLongValue = ((Number) entry.getKey()).longValue();
            List list = (List) entry.getValue();
            List list2 = list;
            ArrayList<DivDisappearAction> arrayList = new ArrayList();
            for (Object obj3 : list2) {
                if (obj3 instanceof DivDisappearAction) {
                    arrayList.add(obj3);
                }
            }
            boolean z = false;
            for (DivDisappearAction divDisappearAction : arrayList) {
                boolean z2 = z;
                z = true;
                boolean z3 = ((long) iCalculateVisibilityPercentage) > divDisappearAction.visibilityPercentage.evaluate(resolver).longValue();
                if (!z2 && !z3) {
                    z = false;
                }
                if (z3) {
                    WeakHashMap<View, Set<DivDisappearAction>> weakHashMap = divVisibilityActionTracker.appearedForDisappearActions;
                    LinkedHashSet linkedHashSet = weakHashMap.get(view);
                    if (linkedHashSet == null) {
                        linkedHashSet = new LinkedHashSet();
                        weakHashMap.put(view, linkedHashSet);
                    }
                    linkedHashSet.add(divDisappearAction);
                }
            }
            if (z) {
                divVisibilityActionTracker.divWithWaitingDisappearActions.put(view, div);
            }
            ArrayList arrayList2 = new ArrayList(list.size());
            for (Object obj4 : list2) {
                if (shouldTrackVisibilityAction(scope, resolver, view, (DivSightAction) obj4, iCalculateVisibilityPercentage)) {
                    arrayList2.add(obj4);
                }
            }
            ArrayList arrayList3 = arrayList2;
            if (!arrayList3.isEmpty()) {
                startTracking(scope, resolver, view, arrayList3, jLongValue);
            }
            divVisibilityActionTracker = this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:6:0x001a  */
    public boolean shouldTrackVisibilityAction(Div2View scope, ExpressionResolver resolver, View view, DivSightAction action, int visibilityPercentage) {
        boolean z;
        if (!(action instanceof DivVisibilityAction)) {
            if (action instanceof DivDisappearAction) {
                Set<DivDisappearAction> set = this.appearedForDisappearActions.get(view);
                if ((set != null ? set.contains(action) : false) && visibilityPercentage <= ((DivDisappearAction) action).visibilityPercentage.evaluate(resolver).longValue()) {
                    z = true;
                }
            } else {
                KAssert kAssert = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Trying to check visibility for class without known visibility range");
                }
            }
            z = false;
        } else if (visibilityPercentage >= ((DivVisibilityAction) action).visibilityPercentage.evaluate(resolver).longValue()) {
            z = true;
        } else {
            z = false;
        }
        CompositeLogId logId = this.trackedTokens.getLogId(CompositeLogIdKt.compositeLogIdOf(scope, action.getLogId().evaluate(resolver)));
        if (view != null && logId == null && z) {
            return true;
        }
        if ((view == null || logId != null || z) && (view == null || logId == null || !z)) {
            if (view != null && logId != null && !z) {
                cancelTracking(logId, view, action);
            } else if (view == null && logId != null) {
                cancelTracking(logId, null, action);
            }
        }
        return false;
    }

    private void startTracking(final Div2View scope, final ExpressionResolver resolver, final View view, final List<? extends DivSightAction> actions, long delayMs) {
        HashMap map = new HashMap(actions.size(), 1.0f);
        for (DivSightAction divSightAction : actions) {
            CompositeLogId compositeLogIdCompositeLogIdOf = CompositeLogIdKt.compositeLogIdOf(scope, divSightAction.getLogId().evaluate(resolver));
            KLog kLog = KLog.INSTANCE;
            if (kLog.isAtLeast(Severity.INFO)) {
                kLog.print(4, TAG, "startTracking: id=" + compositeLogIdCompositeLogIdOf);
            }
            Pair pair = TuplesKt.to(compositeLogIdCompositeLogIdOf, divSightAction);
            map.put(pair.getFirst(), pair.getSecond());
        }
        final Map<CompositeLogId, DivSightAction> logIds = Collections.synchronizedMap(map);
        DivVisibilityTokenHolder divVisibilityTokenHolder = this.trackedTokens;
        Intrinsics.checkNotNullExpressionValue(logIds, "logIds");
        divVisibilityTokenHolder.add(logIds);
        final String logId = scope.getLogId();
        HandlerCompat.postDelayed(this.handler, new Runnable() { // from class: com.yandex.div.core.view2.DivVisibilityActionTracker$startTracking$$inlined$postDelayed$1
            @Override // java.lang.Runnable
            public final void run() {
                KLog kLog2 = KLog.INSTANCE;
                if (kLog2.isAtLeast(Severity.INFO)) {
                    kLog2.print(4, DivVisibilityActionTracker.TAG, "dispatchActions: id=" + CollectionsKt.joinToString$default(logIds.keySet(), null, null, null, 0, null, null, 63, null));
                }
                Set waitingActions = (Set) this.this$0.appearedForDisappearActions.get(view);
                if (waitingActions != null) {
                    List list = actions;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        if (obj instanceof DivDisappearAction) {
                            arrayList.add(obj);
                        }
                    }
                    Intrinsics.checkNotNullExpressionValue(waitingActions, "waitingActions");
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        waitingActions.remove((DivDisappearAction) it.next());
                    }
                    if (waitingActions.isEmpty()) {
                        this.this$0.appearedForDisappearActions.remove(view);
                        this.this$0.divWithWaitingDisappearActions.remove(view);
                    }
                }
                if (Intrinsics.areEqual(scope.getLogId(), logId)) {
                    this.this$0.visibilityActionDispatcher.dispatchActions(scope, resolver, view, (DivSightAction[]) logIds.values().toArray(new DivSightAction[0]));
                }
            }
        }, logIds, delayMs);
    }

    private void cancelTracking(CompositeLogId compositeLogId, View view, DivSightAction action) {
        KLog kLog = KLog.INSTANCE;
        if (kLog.isAtLeast(Severity.INFO)) {
            kLog.print(4, TAG, "cancelTracking: id=" + compositeLogId);
        }
        this.trackedTokens.remove(compositeLogId, new Function1<Map<CompositeLogId, ? extends DivSightAction>, Unit>() { // from class: com.yandex.div.core.view2.DivVisibilityActionTracker.cancelTracking.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<CompositeLogId, ? extends DivSightAction> map) {
                invoke2(map);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<CompositeLogId, ? extends DivSightAction> emptyToken) {
                Intrinsics.checkNotNullParameter(emptyToken, "emptyToken");
                DivVisibilityActionTracker.this.handler.removeCallbacksAndMessages(emptyToken);
            }
        });
        Set<DivDisappearAction> set = this.appearedForDisappearActions.get(view);
        if (!(action instanceof DivDisappearAction) || view == null || set == null) {
            return;
        }
        set.remove(action);
        if (set.isEmpty()) {
            this.appearedForDisappearActions.remove(view);
            this.divWithWaitingDisappearActions.remove(view);
        }
    }

    private void updateVisibility(View view, Div div, int visibilityPercentage) {
        if (visibilityPercentage > 0) {
            this.visibleActions.put(view, div);
        } else {
            this.visibleActions.remove(view);
        }
        if (this.hasPostedUpdateVisibilityTask) {
            return;
        }
        this.hasPostedUpdateVisibilityTask = true;
        this.handler.post(this.updateVisibilityTask);
    }

    /* JADX INFO: compiled from: DivVisibilityActionTracker.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/core/view2/DivVisibilityActionTracker$Companion;", "", "()V", "TAG", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
