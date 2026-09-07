package com.yandex.div.core.view2.animations;

import android.animation.Animator;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.yandex.div.core.actions.DivActionTypedUtilsKt;
import com.yandex.div.core.animation.DivVariableAnimatorBuilder;
import com.yandex.div.core.dagger.DivViewScope;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.divs.widgets.DivHolderView;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivActionAnimatorStart;
import com.yandex.div2.DivAnimator;
import com.yandex.div2.DivBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivAnimatorController.kt */
/* JADX INFO: loaded from: classes6.dex */
@DivViewScope
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\"\u0010\f\u001a\u0004\u0018\u00010\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J&\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/yandex/div/core/view2/animations/DivAnimatorController;", "", "divView", "Lcom/yandex/div/core/view2/Div2View;", "(Lcom/yandex/div/core/view2/Div2View;)V", "handler", "Landroid/os/Handler;", "runningAnimators", "", "Lkotlin/Pair;", "", "Landroid/animation/Animator;", "findAnimator", "Lcom/yandex/div2/DivAnimator;", "view", "Landroid/view/View;", "animatorId", "animators", "", "onDetachedFromWindow", "", "startAnimator", "scopeId", "targetView", "action", "Lcom/yandex/div2/DivActionAnimatorStart;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "stopAnimator", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivAnimatorController {
    private final Div2View divView;
    private final Handler handler;
    private final Map<Pair<String, String>, Animator> runningAnimators;

    @Inject
    public DivAnimatorController(Div2View divView) {
        Intrinsics.checkNotNullParameter(divView, "divView");
        this.divView = divView;
        this.runningAnimators = new LinkedHashMap();
        this.handler = new Handler(Looper.getMainLooper());
    }

    public final void startAnimator(String scopeId, View targetView, DivActionAnimatorStart action, ExpressionResolver resolver) {
        Animator animatorRemove;
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        String str = action.animatorId;
        DivAnimator divAnimatorFindAnimator = findAnimator(targetView, str);
        if (divAnimatorFindAnimator == null) {
            return;
        }
        final Pair<String, String> pair = TuplesKt.to(scopeId, str);
        if (this.runningAnimators.containsKey(pair) && (animatorRemove = this.runningAnimators.remove(pair)) != null) {
            animatorRemove.cancel();
        }
        Animator animatorBuild = DivVariableAnimatorBuilder.INSTANCE.build(this.divView, divAnimatorFindAnimator, action, resolver);
        if (animatorBuild == null) {
            return;
        }
        animatorBuild.addListener(new Animator.AnimatorListener() { // from class: com.yandex.div.core.view2.animations.DivAnimatorController$startAnimator$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                this.this$0.runningAnimators.remove(pair);
            }
        });
        animatorBuild.addListener(new Animator.AnimatorListener() { // from class: com.yandex.div.core.view2.animations.DivAnimatorController$startAnimator$$inlined$doOnCancel$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.this$0.runningAnimators.remove(pair);
            }
        });
        this.runningAnimators.put(pair, animatorBuild);
        animatorBuild.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final DivAnimator findAnimator(View view, String animatorId) {
        if (view instanceof DivHolderView) {
            DivBase div = ((DivHolderView) view).getDiv();
            DivAnimator divAnimatorFindAnimator = findAnimator(div != null ? div.getAnimators() : null, animatorId);
            if (divAnimatorFindAnimator != null) {
                return divAnimatorFindAnimator;
            }
            Object parent = view.getParent();
            View view2 = parent instanceof View ? (View) parent : null;
            if (view2 != null) {
                return findAnimator(view2, animatorId);
            }
            return null;
        }
        if (view instanceof Div2View) {
            DivActionTypedUtilsKt.logWarning(this.divView, new RuntimeException("Unable to find animator with id '" + animatorId + '\''));
            return null;
        }
        Object parent2 = view.getParent();
        View view3 = parent2 instanceof View ? (View) parent2 : null;
        if (view3 != null) {
            return findAnimator(view3, animatorId);
        }
        return null;
    }

    private final DivAnimator findAnimator(List<? extends DivAnimator> animators, String animatorId) {
        if (animators == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : animators) {
            if (Intrinsics.areEqual(((DivAnimator) obj).value().getId(), animatorId)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty() && arrayList2.size() <= 1) {
            return (DivAnimator) CollectionsKt.first((List) arrayList2);
        }
        return null;
    }

    public final void stopAnimator(String scopeId, String animatorId) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Intrinsics.checkNotNullParameter(animatorId, "animatorId");
        Animator animatorRemove = this.runningAnimators.remove(TuplesKt.to(scopeId, animatorId));
        if (animatorRemove == null) {
            return;
        }
        animatorRemove.cancel();
    }

    public final void onDetachedFromWindow() {
        Iterator it = new ArrayList(this.runningAnimators.values()).iterator();
        while (it.hasNext()) {
            ((Animator) it.next()).cancel();
        }
        this.runningAnimators.clear();
    }
}
