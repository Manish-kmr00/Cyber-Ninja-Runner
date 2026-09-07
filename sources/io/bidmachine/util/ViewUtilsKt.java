package io.bidmachine.util;

import android.graphics.Insets;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import com.json.ug;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewUtils.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\u0012\u0010\b\u001a\u00020\t*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002\u001a\f\u0010\u000b\u001a\u0004\u0018\u00010\u0004*\u00020\u0004\u001a)\u0010\f\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u0004*\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000f¢\u0006\u0002\u0010\u0010\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0004\u001a\f\u0010\u0013\u001a\u00020\u0001*\u0004\u0018\u00010\u0004\u001a\n\u0010\u0014\u001a\u00020\t*\u00020\u0004\u001a\n\u0010\u0015\u001a\u00020\t*\u00020\u0004\u001a\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0001*\u00020\u0004¢\u0006\u0002\u0010\u0017\u001a\u001b\u0010\u0018\u001a\u00020\u0001*\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001b\u001a\u0016\u0010\u001c\u001a\u00020\u0001*\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u001aH\u0007\u001a\f\u0010\u001e\u001a\u00020\u0001*\u0004\u0018\u00010\u0004¨\u0006\u001f"}, d2 = {"addSingleViewSafely", "", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "addViewSafely", "belongTo", "", "parent", "findContentOrRootView", "findViewByClassName", "T", "viewClass", "Ljava/lang/Class;", "(Landroid/view/ViewGroup;Ljava/lang/Class;)Landroid/view/View;", "getLocationInWindow", "Landroid/graphics/Rect;", "hideViewSafely", "isViewTransparent", ug.n, "removeFromParent", "(Landroid/view/View;)Lkotlin/Unit;", "setBackgroundColorSafely", "color", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "setInsetsChanger", "typeInsets", "showViewSafely", "bidmachine-android-util_d_0_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ViewUtilsKt {
    public static final boolean belongTo(View view, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Object parent2 = view.getParent();
        if (parent2 instanceof ViewGroup) {
            return Intrinsics.areEqual(parent2, parent) || belongTo((View) parent2, parent);
        }
        return false;
    }

    public static final void showViewSafely(final View view) {
        if (view == null) {
            return;
        }
        UiUtils.onUiThread(new SafeRunnable() { // from class: io.bidmachine.util.ViewUtilsKt.showViewSafely.1
            @Override // io.bidmachine.util.SafeRunnable
            public void onRun() {
                view.setVisibility(0);
            }
        });
    }

    public static final void hideViewSafely(final View view) {
        if (view == null) {
            return;
        }
        UiUtils.onUiThread(new SafeRunnable() { // from class: io.bidmachine.util.ViewUtilsKt.hideViewSafely.1
            @Override // io.bidmachine.util.SafeRunnable
            public void onRun() {
                view.setVisibility(8);
            }
        });
    }

    public static final Unit removeFromParent(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return null;
        }
        viewGroup.removeView(view);
        return Unit.INSTANCE;
    }

    public static final boolean isViewVisible(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return ViewUtils.isViewVisible(view.getVisibility());
    }

    public static final Rect getLocationInWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new Rect(iArr[0], iArr[1], view.getWidth() + iArr[0], view.getHeight() + iArr[1]);
    }

    public static final boolean isViewTransparent(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getAlpha() == 0.0f;
    }

    public static /* synthetic */ void setInsetsChanger$default(View view, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout();
        }
        setInsetsChanger(view, i);
    }

    public static final void setInsetsChanger(View view, final int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: io.bidmachine.util.ViewUtilsKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                return ViewUtilsKt.setInsetsChanger$lambda$3(i, view2, windowInsets);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets setInsetsChanger$lambda$3(int i, View selfView, WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(selfView, "selfView");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Insets insets = windowInsets.getInsets(i);
        Intrinsics.checkNotNullExpressionValue(insets, "windowInsets.getInsets(typeInsets)");
        selfView.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return windowInsets;
    }

    public static /* synthetic */ void addViewSafely$default(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams, int i, Object obj) {
        if ((i & 2) != 0) {
            layoutParams = null;
        }
        addViewSafely(viewGroup, view, layoutParams);
    }

    public static final void addViewSafely(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            removeFromParent(view);
            if (layoutParams != null) {
                viewGroup.addView(view, layoutParams);
            } else {
                viewGroup.addView(view);
            }
            Unit unit = Unit.INSTANCE;
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ void addSingleViewSafely$default(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams, int i, Object obj) {
        if ((i & 2) != 0) {
            layoutParams = null;
        }
        addSingleViewSafely(viewGroup, view, layoutParams);
    }

    public static final void addSingleViewSafely(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            viewGroup.removeAllViews();
            Unit unit = Unit.INSTANCE;
        } catch (Throwable unused) {
        }
        addViewSafely(viewGroup, view, layoutParams);
    }

    public static final <T extends View> T findViewByClassName(ViewGroup viewGroup, Class<T> viewClass) {
        T t;
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(viewClass, "viewClass");
        try {
            if (Intrinsics.areEqual(viewGroup.getClass(), viewClass)) {
                return viewGroup;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof ViewGroup) && (t = (T) findViewByClassName((ViewGroup) childAt, viewClass)) != null) {
                    return t;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final View findContentOrRootView(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        View view2 = null;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            view2 = (View) parent;
            if (view2.getId() == 16908290) {
                break;
            }
        }
        return view2;
    }

    public static final void setBackgroundColorSafely(View view, Integer num) {
        if (view == null || num == null) {
            return;
        }
        try {
            view.setBackgroundColor(num.intValue());
            Unit unit = Unit.INSTANCE;
        } catch (Throwable unused) {
        }
    }
}
