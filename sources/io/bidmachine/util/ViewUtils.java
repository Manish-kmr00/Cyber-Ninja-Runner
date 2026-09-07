package io.bidmachine.util;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.json.ug;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewUtils.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J$\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\bH\u0007J/\u0010\u0011\u001a\u0004\u0018\u0001H\u0012\"\b\b\u0000\u0010\u0012*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014H\u0007¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0017H\u0007J\u0017\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u001fJ!\u0010 \u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010!\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001a\u0010#\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\u0017H\u0007J\u0012\u0010%\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010&\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\u0017H\u0007¨\u0006("}, d2 = {"Lio/bidmachine/util/ViewUtils;", "", "()V", "addSingleViewSafely", "", "container", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "addViewSafely", "belongTo", "", "child", "parent", "findContentOrRootView", "findViewByClassName", "T", "viewClass", "Ljava/lang/Class;", "(Landroid/view/ViewGroup;Ljava/lang/Class;)Landroid/view/View;", "generateViewId", "", "getLocationInWindow", "Landroid/graphics/Rect;", "hideViewSafely", "isViewTransparent", ug.n, "visibility", "removeFromParent", "(Landroid/view/View;)Lkotlin/Unit;", "setBackgroundColorSafely", "color", "(Landroid/view/View;Ljava/lang/Integer;)V", "setInsetsChanger", "typeInsets", "showViewSafely", "visibilityToString", "", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ViewUtils {
    public static final ViewUtils INSTANCE = new ViewUtils();

    @JvmStatic
    public static final boolean isViewVisible(int visibility) {
        return visibility == 0;
    }

    private ViewUtils() {
    }

    @JvmStatic
    public static final int generateViewId() {
        return View.generateViewId();
    }

    @JvmStatic
    public static final boolean belongTo(View child, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(parent, "parent");
        return ViewUtilsKt.belongTo(child, parent);
    }

    @JvmStatic
    public static final void showViewSafely(View view) {
        ViewUtilsKt.showViewSafely(view);
    }

    @JvmStatic
    public static final void hideViewSafely(View view) {
        ViewUtilsKt.hideViewSafely(view);
    }

    @JvmStatic
    public static final void setBackgroundColorSafely(View view, Integer color) {
        ViewUtilsKt.setBackgroundColorSafely(view, color);
    }

    @JvmStatic
    public static final Unit removeFromParent(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return ViewUtilsKt.removeFromParent(view);
    }

    @JvmStatic
    public static final boolean isViewVisible(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return ViewUtilsKt.isViewVisible(view);
    }

    @JvmStatic
    public static final String visibilityToString(int visibility) {
        if (visibility == 0) {
            return "VISIBLE";
        }
        if (visibility == 4) {
            return "INVISIBLE";
        }
        if (visibility == 8) {
            return "GONE";
        }
        return "unknown";
    }

    @JvmStatic
    public static final Rect getLocationInWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return ViewUtilsKt.getLocationInWindow(view);
    }

    @JvmStatic
    public static final boolean isViewTransparent(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return ViewUtilsKt.isViewTransparent(view);
    }

    @JvmStatic
    public static final void setInsetsChanger(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        setInsetsChanger(view, WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout());
    }

    public static /* synthetic */ void setInsetsChanger$default(View view, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout();
        }
        setInsetsChanger(view, i);
    }

    @JvmStatic
    public static final void setInsetsChanger(View view, int typeInsets) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewUtilsKt.setInsetsChanger(view, typeInsets);
    }

    @JvmStatic
    public static final void addViewSafely(ViewGroup container, View view) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(view, "view");
        addViewSafely(container, view, null);
    }

    public static /* synthetic */ void addViewSafely$default(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams, int i, Object obj) {
        if ((i & 4) != 0) {
            layoutParams = null;
        }
        addViewSafely(viewGroup, view, layoutParams);
    }

    @JvmStatic
    public static final void addViewSafely(ViewGroup container, View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(view, "view");
        ViewUtilsKt.addViewSafely(container, view, layoutParams);
    }

    @JvmStatic
    public static final void addSingleViewSafely(ViewGroup container, View view) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(view, "view");
        addSingleViewSafely(container, view, null);
    }

    public static /* synthetic */ void addSingleViewSafely$default(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams, int i, Object obj) {
        if ((i & 4) != 0) {
            layoutParams = null;
        }
        addSingleViewSafely(viewGroup, view, layoutParams);
    }

    @JvmStatic
    public static final void addSingleViewSafely(ViewGroup container, View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(view, "view");
        ViewUtilsKt.addSingleViewSafely(container, view, layoutParams);
    }

    @JvmStatic
    public static final <T extends View> T findViewByClassName(ViewGroup parent, Class<T> viewClass) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(viewClass, "viewClass");
        return (T) ViewUtilsKt.findViewByClassName(parent, viewClass);
    }

    @JvmStatic
    public static final View findContentOrRootView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return ViewUtilsKt.findContentOrRootView(view);
    }
}
