package com.yandex.div.core.view2.divs.widgets;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivViewVisitor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0082\b\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0000¨\u0006\f"}, d2 = {"visitChild", "", "Landroid/view/ViewGroup;", "func", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "childView", "visitViewTree", "Lcom/yandex/div/core/view2/divs/widgets/DivViewVisitor;", "view", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivViewVisitorKt {
    public static final void visitViewTree(DivViewVisitor divViewVisitor, View view) {
        Intrinsics.checkNotNullParameter(divViewVisitor, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof DivWrapLayout)) {
            if (!(view instanceof DivFrameLayout)) {
                if (!(view instanceof DivGridLayout)) {
                    if (!(view instanceof DivLinearLayout)) {
                        if (!(view instanceof DivPagerView)) {
                            if (!(view instanceof DivRecyclerView)) {
                                if (!(view instanceof DivStateLayout)) {
                                    if (!(view instanceof DivTabsLayout)) {
                                        if (!(view instanceof DivCustomWrapper)) {
                                            if (view instanceof DivSeparatorView) {
                                                divViewVisitor.visit((DivSeparatorView) view);
                                                return;
                                            }
                                            if (view instanceof DivGifImageView) {
                                                divViewVisitor.visit((DivGifImageView) view);
                                                return;
                                            }
                                            if (view instanceof DivImageView) {
                                                divViewVisitor.visit((DivImageView) view);
                                                return;
                                            }
                                            if (view instanceof DivLineHeightTextView) {
                                                divViewVisitor.visit((DivLineHeightTextView) view);
                                                return;
                                            }
                                            if (view instanceof DivPagerIndicatorView) {
                                                divViewVisitor.visit((DivPagerIndicatorView) view);
                                                return;
                                            }
                                            if (view instanceof DivSliderView) {
                                                divViewVisitor.visit((DivSliderView) view);
                                                return;
                                            }
                                            if (view instanceof DivSelectView) {
                                                divViewVisitor.visit((DivSelectView) view);
                                                return;
                                            }
                                            if (view instanceof DivVideoView) {
                                                divViewVisitor.visit((DivVideoView) view);
                                                return;
                                            }
                                            if (view instanceof DivSwitchView) {
                                                divViewVisitor.visit((DivSwitchView) view);
                                                return;
                                            }
                                            if (view instanceof ViewGroup) {
                                                Iterator<View> it = ViewGroupKt.getChildren((ViewGroup) view).iterator();
                                                while (it.hasNext()) {
                                                    visitViewTree(divViewVisitor, it.next());
                                                }
                                            }
                                            divViewVisitor.visit(view);
                                            return;
                                        }
                                        Iterator<View> it2 = ViewGroupKt.getChildren((ViewGroup) view).iterator();
                                        while (it2.hasNext()) {
                                            visitViewTree(divViewVisitor, it2.next());
                                        }
                                        divViewVisitor.visit((DivCustomWrapper) view);
                                        return;
                                    }
                                    Iterator<View> it3 = ViewGroupKt.getChildren((ViewGroup) view).iterator();
                                    while (it3.hasNext()) {
                                        visitViewTree(divViewVisitor, it3.next());
                                    }
                                    divViewVisitor.visit((DivTabsLayout) view);
                                    return;
                                }
                                Iterator<View> it4 = ViewGroupKt.getChildren((ViewGroup) view).iterator();
                                while (it4.hasNext()) {
                                    visitViewTree(divViewVisitor, it4.next());
                                }
                                divViewVisitor.visit((DivStateLayout) view);
                                return;
                            }
                            Iterator<View> it5 = ViewGroupKt.getChildren((ViewGroup) view).iterator();
                            while (it5.hasNext()) {
                                visitViewTree(divViewVisitor, it5.next());
                            }
                            divViewVisitor.visit((DivRecyclerView) view);
                            return;
                        }
                        Iterator<View> it6 = ViewGroupKt.getChildren((ViewGroup) view).iterator();
                        while (it6.hasNext()) {
                            visitViewTree(divViewVisitor, it6.next());
                        }
                        divViewVisitor.visit((DivPagerView) view);
                        return;
                    }
                    Iterator<View> it7 = ViewGroupKt.getChildren((ViewGroup) view).iterator();
                    while (it7.hasNext()) {
                        visitViewTree(divViewVisitor, it7.next());
                    }
                    divViewVisitor.visit((DivLinearLayout) view);
                    return;
                }
                Iterator<View> it8 = ViewGroupKt.getChildren((ViewGroup) view).iterator();
                while (it8.hasNext()) {
                    visitViewTree(divViewVisitor, it8.next());
                }
                divViewVisitor.visit((DivGridLayout) view);
                return;
            }
            Iterator<View> it9 = ViewGroupKt.getChildren((ViewGroup) view).iterator();
            while (it9.hasNext()) {
                visitViewTree(divViewVisitor, it9.next());
            }
            divViewVisitor.visit((DivFrameLayout) view);
            return;
        }
        Iterator<View> it10 = ViewGroupKt.getChildren((ViewGroup) view).iterator();
        while (it10.hasNext()) {
            visitViewTree(divViewVisitor, it10.next());
        }
        divViewVisitor.visit((DivWrapLayout) view);
    }

    private static final void visitChild(ViewGroup viewGroup, Function1<? super View, Unit> function1) {
        Iterator<View> it = ViewGroupKt.getChildren(viewGroup).iterator();
        while (it.hasNext()) {
            function1.invoke(it.next());
        }
    }
}
