package com.yandex.div.core.state;

import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.yandex.div.core.animation.SpringInterpolator;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.animations.SceneRootWatcher;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivStateChangeListener.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B!\b\u0007\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div/core/state/DefaultDivStateChangeListener;", "Lcom/yandex/div/core/state/DivStateChangeListener;", "rootView", "Landroid/view/ViewGroup;", "interpolator", "Landroid/view/animation/Interpolator;", "(Landroid/view/ViewGroup;Landroid/view/animation/Interpolator;)V", "rootViewProvider", "Ljavax/inject/Provider;", "(Ljavax/inject/Provider;Landroid/view/animation/Interpolator;)V", "onDivAnimatedStateChanged", "", "divView", "Lcom/yandex/div/core/view2/Div2View;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DefaultDivStateChangeListener implements DivStateChangeListener {
    private final Interpolator interpolator;
    private final Provider<ViewGroup> rootViewProvider;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultDivStateChangeListener(ViewGroup rootView) {
        this(rootView, (Interpolator) null, 2, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        Intrinsics.checkNotNullParameter(rootView, "rootView");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultDivStateChangeListener(Provider<ViewGroup> rootViewProvider) {
        this((Provider) rootViewProvider, (Interpolator) null, 2, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        Intrinsics.checkNotNullParameter(rootViewProvider, "rootViewProvider");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewGroup _init_$lambda$0(ViewGroup rootView) {
        Intrinsics.checkNotNullParameter(rootView, "$rootView");
        return rootView;
    }

    public DefaultDivStateChangeListener(Provider<ViewGroup> rootViewProvider, Interpolator interpolator) {
        Intrinsics.checkNotNullParameter(rootViewProvider, "rootViewProvider");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        this.rootViewProvider = rootViewProvider;
        this.interpolator = interpolator;
    }

    public /* synthetic */ DefaultDivStateChangeListener(Provider provider, SpringInterpolator springInterpolator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((Provider<ViewGroup>) provider, (i & 2) != 0 ? new SpringInterpolator() : springInterpolator);
    }

    public /* synthetic */ DefaultDivStateChangeListener(ViewGroup viewGroup, SpringInterpolator springInterpolator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, (i & 2) != 0 ? new SpringInterpolator() : springInterpolator);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultDivStateChangeListener(final ViewGroup rootView, Interpolator interpolator) {
        this((Provider<ViewGroup>) new Provider() { // from class: com.yandex.div.core.state.DefaultDivStateChangeListener$$ExternalSyntheticLambda0
            @Override // javax.inject.Provider
            public final Object get() {
                return DefaultDivStateChangeListener._init_$lambda$0(rootView);
            }
        }, interpolator);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
    }

    @Override // com.yandex.div.core.state.DivStateChangeListener
    public void onDivAnimatedStateChanged(Div2View divView) {
        Intrinsics.checkNotNullParameter(divView, "divView");
        ViewGroup viewGroup = this.rootViewProvider.get();
        if (viewGroup == null) {
            return;
        }
        Transition interpolator = new DivStateTransition(divView, false, 2, null).setInterpolator(this.interpolator);
        Intrinsics.checkNotNullExpressionValue(interpolator, "DivStateTransition(divVi…nterpolator(interpolator)");
        TransitionManager.endTransitions(viewGroup);
        SceneRootWatcher.INSTANCE.watchFor(viewGroup, interpolator);
        TransitionManager.beginDelayedTransition(viewGroup, interpolator);
    }
}
