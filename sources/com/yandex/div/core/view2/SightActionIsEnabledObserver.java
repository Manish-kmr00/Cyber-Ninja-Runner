package com.yandex.div.core.view2;

import android.view.View;
import com.android.billingclient.api.BillingClient;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.internal.core.ExpressionSubscriber;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivSightAction;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SightActionIsEnabledObserver.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0001&B]\u0012*\u0010\u0002\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0003\u0012*\u0010\n\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u0014\u0010\u0014\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0017JS\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u001eH\u0082\bJ6\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00072\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u001aJ\f\u0010%\u001a\u00020\t*\u00020\u0006H\u0002R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\rX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\n\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0002\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/yandex/div/core/view2/SightActionIsEnabledObserver;", "", "onEnable", "Lkotlin/Function5;", "Lcom/yandex/div/core/view2/Div2View;", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "Landroid/view/View;", "Lcom/yandex/div2/Div;", "Lcom/yandex/div2/DivSightAction;", "", "onDisable", "(Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function5;)V", "boundedActions", "Ljava/util/WeakHashMap;", "", "hasSubscription", BillingClient.FeatureType.SUBSCRIPTIONS, "Ljava/util/HashMap;", "Lcom/yandex/div/core/view2/SightActionIsEnabledObserver$Subscription;", "Lkotlin/collections/HashMap;", "cancelObserving", "action", "actions", "", "leftJoin", "new", "", "old", "", "onDelete", "Lkotlin/Function1;", "onAdd", "observe", "view", "div2View", "resolver", "div", "addSubscriptionIfNeeded", "Subscription", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SightActionIsEnabledObserver {
    private final WeakHashMap<View, Set<DivSightAction>> boundedActions;
    private final WeakHashMap<View, Unit> hasSubscription;
    private final Function5<Div2View, ExpressionResolver, View, Div, DivSightAction, Unit> onDisable;
    private final Function5<Div2View, ExpressionResolver, View, Div, DivSightAction, Unit> onEnable;
    private final HashMap<DivSightAction, Subscription> subscriptions;

    /* JADX WARN: Multi-variable type inference failed */
    public SightActionIsEnabledObserver(Function5<? super Div2View, ? super ExpressionResolver, ? super View, ? super Div, ? super DivSightAction, Unit> onEnable, Function5<? super Div2View, ? super ExpressionResolver, ? super View, ? super Div, ? super DivSightAction, Unit> onDisable) {
        Intrinsics.checkNotNullParameter(onEnable, "onEnable");
        Intrinsics.checkNotNullParameter(onDisable, "onDisable");
        this.onEnable = onEnable;
        this.onDisable = onDisable;
        this.boundedActions = new WeakHashMap<>();
        this.subscriptions = new HashMap<>();
        this.hasSubscription = new WeakHashMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void observe$default(SightActionIsEnabledObserver sightActionIsEnabledObserver, View view, Div2View div2View, ExpressionResolver expressionResolver, Div div, List list, int i, Object obj) {
        if ((i & 16) != 0) {
            list = BaseDivViewExtensionsKt.getAllSightActions(div.value());
        }
        sightActionIsEnabledObserver.observe(view, div2View, expressionResolver, div, list);
    }

    public final void observe(final View view, final Div2View div2View, final ExpressionResolver resolver, final Div div, List<? extends DivSightAction> actions) {
        Subscription subscriptionRemove;
        SightActionIsEnabledObserver sightActionIsEnabledObserver = this;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div2View, "div2View");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(actions, "actions");
        addSubscriptionIfNeeded(view);
        WeakHashMap<View, Set<DivSightAction>> weakHashMap = sightActionIsEnabledObserver.boundedActions;
        WeakHashMap<View, Set<DivSightAction>> weakHashMap2 = weakHashMap;
        Set<DivSightAction> setEmptySet = weakHashMap.get(view);
        if (setEmptySet == null) {
            setEmptySet = SetsKt.emptySet();
        }
        Set setIntersect = CollectionsKt.intersect(actions, setEmptySet);
        Set<DivSightAction> mutableSet = CollectionsKt.toMutableSet(setIntersect);
        for (DivSightAction divSightAction : setEmptySet) {
            if (!setIntersect.contains(divSightAction) && (subscriptionRemove = sightActionIsEnabledObserver.subscriptions.remove(divSightAction)) != null) {
                subscriptionRemove.close();
            }
        }
        for (final DivSightAction divSightAction2 : actions) {
            if (!setIntersect.contains(divSightAction2)) {
                mutableSet.add(divSightAction2);
                sightActionIsEnabledObserver.cancelObserving(divSightAction2);
                sightActionIsEnabledObserver.subscriptions.put(divSightAction2, new Subscription(divSightAction2.isEnabled().observe(resolver, new Function1<Boolean, Unit>() { // from class: com.yandex.div.core.view2.SightActionIsEnabledObserver$observe$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z) {
                        if (z) {
                            this.this$0.onEnable.invoke(div2View, resolver, view, div, divSightAction2);
                        } else {
                            this.this$0.onDisable.invoke(div2View, resolver, view, div, divSightAction2);
                        }
                    }
                }), view));
            }
            sightActionIsEnabledObserver = this;
        }
        weakHashMap2.put(view, mutableSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void addSubscriptionIfNeeded(final View view) {
        if (this.hasSubscription.containsKey(view) || !(view instanceof ExpressionSubscriber)) {
            return;
        }
        ((ExpressionSubscriber) view).addSubscription(new Disposable() { // from class: com.yandex.div.core.view2.SightActionIsEnabledObserver$$ExternalSyntheticLambda0
            @Override // com.yandex.div.core.Disposable, java.lang.AutoCloseable, java.io.Closeable
            public final void close() {
                SightActionIsEnabledObserver.addSubscriptionIfNeeded$lambda$2(this.f$0, view);
            }
        });
        this.hasSubscription.put(view, Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addSubscriptionIfNeeded$lambda$2(SightActionIsEnabledObserver this$0, View this_addSubscriptionIfNeeded) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_addSubscriptionIfNeeded, "$this_addSubscriptionIfNeeded");
        Set<DivSightAction> setRemove = this$0.boundedActions.remove(this_addSubscriptionIfNeeded);
        if (setRemove == null) {
            setRemove = SetsKt.emptySet();
        }
        this$0.cancelObserving(setRemove);
    }

    private final Set<DivSightAction> leftJoin(List<? extends DivSightAction> list, Set<? extends DivSightAction> old, Function1<? super DivSightAction, Unit> onDelete, Function1<? super DivSightAction, Unit> onAdd) {
        Set setIntersect = CollectionsKt.intersect(list, old);
        Set<DivSightAction> mutableSet = CollectionsKt.toMutableSet(setIntersect);
        for (DivSightAction divSightAction : old) {
            if (!setIntersect.contains(divSightAction)) {
                onDelete.invoke(divSightAction);
            }
        }
        for (DivSightAction divSightAction2 : list) {
            if (!setIntersect.contains(divSightAction2)) {
                mutableSet.add(divSightAction2);
                onAdd.invoke(divSightAction2);
            }
        }
        return mutableSet;
    }

    private final void cancelObserving(DivSightAction action) {
        Set<DivSightAction> set;
        Subscription subscriptionRemove = this.subscriptions.remove(action);
        if (subscriptionRemove == null) {
            return;
        }
        subscriptionRemove.close();
        View view = subscriptionRemove.getOwner().get();
        if (view == null || (set = this.boundedActions.get(view)) == null) {
            return;
        }
        set.remove(action);
    }

    /* JADX INFO: compiled from: SightActionIsEnabledObserver.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\u0004\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00050\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/yandex/div/core/view2/SightActionIsEnabledObserver$Subscription;", "", "disposable", "Lcom/yandex/div/core/Disposable;", "owner", "Landroid/view/View;", "(Lcom/yandex/div/core/Disposable;Landroid/view/View;)V", "getDisposable", "()Lcom/yandex/div/core/Disposable;", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getOwner", "()Ljava/lang/ref/WeakReference;", "close", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Subscription {
        private final Disposable disposable;
        private final WeakReference<View> owner;

        public Subscription(Disposable disposable, View owner) {
            Intrinsics.checkNotNullParameter(disposable, "disposable");
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.disposable = disposable;
            this.owner = new WeakReference<>(owner);
        }

        public final Disposable getDisposable() {
            return this.disposable;
        }

        public final WeakReference<View> getOwner() {
            return this.owner;
        }

        public final void close() {
            this.disposable.close();
        }
    }

    public final void cancelObserving(Iterable<? extends DivSightAction> actions) {
        Intrinsics.checkNotNullParameter(actions, "actions");
        Iterator<? extends DivSightAction> it = actions.iterator();
        while (it.hasNext()) {
            cancelObserving(it.next());
        }
    }
}
