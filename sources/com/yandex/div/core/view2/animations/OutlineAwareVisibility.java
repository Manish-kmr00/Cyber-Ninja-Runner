package com.yandex.div.core.view2.animations;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import com.yandex.div.internal.widget.TransientView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OutlineAwareVisibility.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\nH\u0016J6\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/yandex/div/core/view2/animations/OutlineAwareVisibility;", "Landroidx/transition/Visibility;", "()V", "onAppear", "Landroid/animation/Animator;", "sceneRoot", "Landroid/view/ViewGroup;", "startValues", "Landroidx/transition/TransitionValues;", "startVisibility", "", "endValues", "endVisibility", "onDisappear", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class OutlineAwareVisibility extends Visibility {
    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup sceneRoot, TransitionValues startValues, int startVisibility, final TransitionValues endValues, int endVisibility) {
        Intrinsics.checkNotNullParameter(sceneRoot, "sceneRoot");
        View view = endValues != null ? endValues.view : null;
        final TransientView transientView = view instanceof TransientView ? (TransientView) view : null;
        if (transientView != null) {
            View view2 = endValues.view;
            Intrinsics.checkNotNullExpressionValue(view2, "endValues.view");
            transientView.transitionStarted(view2);
        }
        final OutlineAwareVisibility outlineAwareVisibility = this;
        outlineAwareVisibility.addListener(new TransitionListenerAdapter() { // from class: com.yandex.div.core.view2.animations.OutlineAwareVisibility$onAppear$$inlined$doOnEnd$1
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
                TransientView transientView2 = transientView;
                if (transientView2 != null) {
                    View view3 = endValues.view;
                    Intrinsics.checkNotNullExpressionValue(view3, "endValues.view");
                    transientView2.transitionFinished(view3);
                }
                outlineAwareVisibility.removeListener(this);
            }
        });
        return super.onAppear(sceneRoot, startValues, startVisibility, endValues, endVisibility);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup sceneRoot, final TransitionValues startValues, int startVisibility, TransitionValues endValues, int endVisibility) {
        Intrinsics.checkNotNullParameter(sceneRoot, "sceneRoot");
        View view = startValues != null ? startValues.view : null;
        final TransientView transientView = view instanceof TransientView ? (TransientView) view : null;
        if (transientView != null) {
            View view2 = startValues.view;
            Intrinsics.checkNotNullExpressionValue(view2, "startValues.view");
            transientView.transitionStarted(view2);
        }
        final OutlineAwareVisibility outlineAwareVisibility = this;
        outlineAwareVisibility.addListener(new TransitionListenerAdapter() { // from class: com.yandex.div.core.view2.animations.OutlineAwareVisibility$onDisappear$$inlined$doOnEnd$1
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
                TransientView transientView2 = transientView;
                if (transientView2 != null) {
                    View view3 = startValues.view;
                    Intrinsics.checkNotNullExpressionValue(view3, "startValues.view");
                    transientView2.transitionFinished(view3);
                }
                outlineAwareVisibility.removeListener(this);
            }
        });
        return super.onDisappear(sceneRoot, startValues, startVisibility, endValues, endVisibility);
    }
}
