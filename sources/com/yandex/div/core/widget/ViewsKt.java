package com.yandex.div.core.widget;

import android.view.View;
import android.view.ViewGroup;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;

/* JADX INFO: compiled from: Views.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a?\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0006H\u0000¢\u0006\u0002\u0010\u0007\u001a?\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0006H\u0000¢\u0006\u0002\u0010\u0007\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0000\u001a\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0000\u001a\b\u0010\u0011\u001a\u00020\fH\u0000\u001a.\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u0006H\u0080\bø\u0001\u0000\u001a4\u0010\u0017\u001a\u00020\u0013*\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00130\u0018H\u0080\bø\u0001\u0000\u001a\u001e\u0010\u0019\u001a\u00020\u0013*\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u001bH\u0080\bø\u0001\u0000\u001a\u001e\u0010\u001c\u001a\u00020\u0013*\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u001bH\u0080\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"appearanceAffecting", "Lkotlin/properties/ReadWriteProperty;", "Landroid/view/View;", "T", "value", "modifier", "Lkotlin/Function1;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/properties/ReadWriteProperty;", "dimensionAffecting", "isExact", "", "measureSpec", "", "isUnspecified", "makeAtMostSpec", ContentDisposition.Parameters.Size, "makeExactSpec", "makeUnspecifiedSpec", "forEach", "", "Landroid/view/ViewGroup;", "significantOnly", "action", "forEachIndexed", "Lkotlin/Function2;", "invalidateAfter", "block", "Lkotlin/Function0;", "requestLayoutAfter", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ViewsKt {
    public static /* synthetic */ ReadWriteProperty appearanceAffecting$default(Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return appearanceAffecting(obj, function1);
    }

    public static final <T> ReadWriteProperty<View, T> appearanceAffecting(T t, Function1<? super T, ? extends T> function1) {
        return new AppearanceAffectingViewProperty(t, function1);
    }

    public static /* synthetic */ ReadWriteProperty dimensionAffecting$default(Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return dimensionAffecting(obj, function1);
    }

    public static final <T> ReadWriteProperty<View, T> dimensionAffecting(T t, Function1<? super T, ? extends T> function1) {
        return new DimensionAffectingViewProperty(t, function1);
    }

    public static final void invalidateAfter(View view, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke();
        view.invalidate();
    }

    public static final void requestLayoutAfter(View view, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke();
        view.requestLayout();
    }

    public static /* synthetic */ void forEach$default(ViewGroup viewGroup, boolean z, Function1 action, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = viewGroup.getChildAt(i2);
            if (!z || child.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                action.invoke(child);
            }
        }
    }

    public static final void forEach(ViewGroup viewGroup, boolean z, Function1<? super View, Unit> action) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = viewGroup.getChildAt(i);
            if (!z || child.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                action.invoke(child);
            }
        }
    }

    public static /* synthetic */ void forEachIndexed$default(ViewGroup viewGroup, boolean z, Function2 action, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = viewGroup.getChildAt(i2);
            if (!z || child.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                action.invoke(child, Integer.valueOf(i2));
            }
        }
    }

    public static final void forEachIndexed(ViewGroup viewGroup, boolean z, Function2<? super View, ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = viewGroup.getChildAt(i);
            if (!z || child.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                action.invoke(child, Integer.valueOf(i));
            }
        }
    }

    public static final boolean isExact(int i) {
        return View.MeasureSpec.getMode(i) == 1073741824;
    }

    public static final boolean isUnspecified(int i) {
        return View.MeasureSpec.getMode(i) == 0;
    }

    public static final int makeExactSpec(int i) {
        return View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    }

    public static final int makeAtMostSpec(int i) {
        return View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
    }

    public static final int makeUnspecifiedSpec() {
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    }
}
