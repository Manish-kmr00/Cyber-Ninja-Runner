package com.yandex.div.core.view2.animations;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Scene;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SceneRootWatcher.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/yandex/div/core/view2/animations/SceneRootWatcher;", "", "()V", "watchFor", "", "sceneRoot", "Landroid/view/ViewGroup;", "transition", "Landroidx/transition/Transition;", "scene", "Landroidx/transition/Scene;", "OnDetachListener", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SceneRootWatcher {
    public static final SceneRootWatcher INSTANCE = new SceneRootWatcher();

    private SceneRootWatcher() {
    }

    public final void watchFor(Scene scene, Transition transition) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(transition, "transition");
        ViewGroup sceneRoot = scene.getSceneRoot();
        Intrinsics.checkNotNullExpressionValue(sceneRoot, "scene.sceneRoot");
        watchFor(sceneRoot, transition);
    }

    public final void watchFor(final ViewGroup sceneRoot, final Transition transition) {
        Intrinsics.checkNotNullParameter(sceneRoot, "sceneRoot");
        Intrinsics.checkNotNullParameter(transition, "transition");
        final OnDetachListener onDetachListener = new OnDetachListener(sceneRoot);
        sceneRoot.addOnAttachStateChangeListener(onDetachListener);
        transition.addListener(new TransitionListenerAdapter() { // from class: com.yandex.div.core.view2.animations.SceneRootWatcher$watchFor$$inlined$doOnEnd$1
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition2) {
                Intrinsics.checkNotNullParameter(transition2, "transition");
                sceneRoot.removeOnAttachStateChangeListener(onDetachListener);
                transition.removeListener(this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SceneRootWatcher.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/yandex/div/core/view2/animations/SceneRootWatcher$OnDetachListener;", "Landroid/view/View$OnAttachStateChangeListener;", "sceneRoot", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "onViewAttachedToWindow", "", "view", "Landroid/view/View;", "onViewDetachedFromWindow", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static final class OnDetachListener implements View.OnAttachStateChangeListener {
        private final ViewGroup sceneRoot;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public OnDetachListener(ViewGroup sceneRoot) {
            Intrinsics.checkNotNullParameter(sceneRoot, "sceneRoot");
            this.sceneRoot = sceneRoot;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.sceneRoot.removeOnAttachStateChangeListener(this);
            TransitionManager.endTransitions(this.sceneRoot);
        }
    }
}
