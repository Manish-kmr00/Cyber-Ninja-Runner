package com.yandex.div.core.util;

import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yandex.div.core.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Views.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a5\u0010\u0005\u001a\u00020\u0006*\u00020\u00022#\b\u0004\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00060\bH\u0086\bø\u0001\u0000\u001a5\u0010\f\u001a\u00020\r*\u00020\u00022#\b\u0004\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00060\bH\u0080\bø\u0001\u0000\u001aC\u0010\u000e\u001a\u00020\u0006*\u00020\u00022#\b\u0004\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0080\bø\u0001\u0000\u001aC\u0010\u0011\u001a\u00020\u0006*\u00020\u00022#\b\u0004\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0080\bø\u0001\u0000\u001a\u000e\u0010\u0012\u001a\u0004\u0018\u00010\u0002*\u00020\u0002H\u0002\u001a\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0000\u001a\f\u0010\u0018\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0019\u001a\u00020\u0006*\u00020\u0002H\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001a"}, d2 = {"isActuallyLaidOut", "", "Landroid/view/View;", "(Landroid/view/View;)Z", "isHierarchyLaidOut", "doOnActualLayout", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "doOnEveryDetach", "Lcom/yandex/div/core/Disposable;", "doOnHierarchyLayout", "onEnqueuedAction", "Lkotlin/Function0;", "doOnNextHierarchyLayout", "farthestLayoutCaller", "getIndices", "Lkotlin/ranges/IntProgression;", "start", "", "count", "isLayoutRtl", "makeFocusable", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ViewsKt {
    public static final boolean isActuallyLaidOut(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getWidth() > 0 || view.getHeight() > 0;
    }

    public static final boolean isHierarchyLaidOut(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return farthestLayoutCaller(view) == null;
    }

    public static final boolean isLayoutRtl(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    public static final IntProgression getIndices(View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int i3 = i2 + i;
        return isLayoutRtl(view) ? RangesKt.downTo(i3 - 1, i) : RangesKt.until(i, i3);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.yandex.div.core.util.ViewsKt$doOnEveryDetach$listener$1] */
    public static final Disposable doOnEveryDetach(final View view, final Function1<? super View, Unit> action) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        final ?? r0 = new View.OnAttachStateChangeListener() { // from class: com.yandex.div.core.util.ViewsKt$doOnEveryDetach$listener$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                Intrinsics.checkNotNullParameter(view2, "view");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                Intrinsics.checkNotNullParameter(view2, "view");
                action.invoke(view2);
            }
        };
        view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) r0);
        return new Disposable() { // from class: com.yandex.div.core.util.ViewsKt.doOnEveryDetach.1
            @Override // com.yandex.div.core.Disposable, java.lang.AutoCloseable, java.io.Closeable
            public final void close() {
                view.removeOnAttachStateChangeListener(r0);
            }
        };
    }

    public static final void doOnActualLayout(View view, final Function1<? super View, Unit> action) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        if (isActuallyLaidOut(view) && !view.isLayoutRequested()) {
            action.invoke(view);
        } else {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yandex.div.core.util.ViewsKt$doOnActualLayout$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    view2.removeOnLayoutChangeListener(this);
                    action.invoke(view2);
                }
            });
        }
    }

    public static final void makeFocusable(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            view.setDefaultFocusHighlightEnabled(false);
        }
    }

    public static final void doOnHierarchyLayout(View view, Function1<? super View, Unit> action, Function0<Unit> onEnqueuedAction) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(onEnqueuedAction, "onEnqueuedAction");
        if (!isHierarchyLaidOut(view) || view.isLayoutRequested()) {
            View viewFarthestLayoutCaller = farthestLayoutCaller(view);
            if (viewFarthestLayoutCaller != null) {
                viewFarthestLayoutCaller.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC38661(action));
                Unit unit = Unit.INSTANCE;
            }
            onEnqueuedAction.invoke();
            return;
        }
        action.invoke(view);
    }

    /* JADX INFO: renamed from: com.yandex.div.core.util.ViewsKt$doOnNextHierarchyLayout$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Views.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"com/yandex/div/core/util/ViewsKt$doOnNextHierarchyLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 176)
    public static final class ViewOnLayoutChangeListenerC38661 implements View.OnLayoutChangeListener {
        final /* synthetic */ Function1<View, Unit> $action;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewOnLayoutChangeListenerC38661(Function1<? super View, Unit> function1) {
            this.$action = function1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            Intrinsics.checkNotNullParameter(view, "view");
            view.removeOnLayoutChangeListener(this);
            this.$action.invoke(view);
        }
    }

    public static final void doOnNextHierarchyLayout(View view, Function1<? super View, Unit> action, Function0<Unit> onEnqueuedAction) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(onEnqueuedAction, "onEnqueuedAction");
        View viewFarthestLayoutCaller = farthestLayoutCaller(view);
        if (viewFarthestLayoutCaller != null) {
            viewFarthestLayoutCaller.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC38661(action));
            Unit unit = Unit.INSTANCE;
        }
        onEnqueuedAction.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View farthestLayoutCaller(View view) {
        View view2 = null;
        while (view != null) {
            if (!isActuallyLaidOut(view) || view.isLayoutRequested()) {
                view2 = view;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return view2;
    }
}
