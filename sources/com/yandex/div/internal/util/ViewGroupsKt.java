package com.yandex.div.internal.util;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.yandex.div.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewGroups.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0014\u0010\b\u001a\u00020\u0003*\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a$\u0010\f\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a$\u0010\u0010\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"SCROLLABLE_RECYCLER_VIEW_IDS", "", "canScrollMore", "", "Landroidx/recyclerview/widget/RecyclerView;", "scrollDir", "", "Landroidx/viewpager/widget/ViewPager;", "hasScrollableChildUnder", "Landroid/view/ViewGroup;", "event", "Landroid/view/MotionEvent;", "isScrollableRecyclerUnder", "rawX", "", "rawY", "isScrollableViewPagerUnder", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ViewGroupsKt {
    private static final int[] SCROLLABLE_RECYCLER_VIEW_IDS = {R.id.div_gallery};

    public static final boolean hasScrollableChildUnder(ViewGroup viewGroup, MotionEvent event) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        float rawX = event.getRawX();
        float rawY = event.getRawY();
        int i = event.getHistorySize() < 1 ? -1 : event.getHistoricalX(0) < event.getX() ? 4 : 8;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getId() == R.id.div_tabs_block && Views.hitTest(childAt, rawX, rawY)) {
                View viewFindViewAndCast = Views.findViewAndCast(childAt, R.id.div_tabs_pager_container);
                Intrinsics.checkNotNull(viewFindViewAndCast, "null cannot be cast to non-null type androidx.viewpager.widget.ViewPager");
                if (isScrollableViewPagerUnder((ViewPager) viewFindViewAndCast, rawX, rawY, i)) {
                    return true;
                }
            }
            if ((childAt instanceof RecyclerView) && isScrollableRecyclerUnder((RecyclerView) childAt, rawX, rawY, i)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean isScrollableViewPagerUnder(ViewPager viewPager, float f, float f2, int i) {
        if (canScrollMore(viewPager, i)) {
            return true;
        }
        int length = SCROLLABLE_RECYCLER_VIEW_IDS.length;
        for (int i2 = 0; i2 < length; i2++) {
            RecyclerView recyclerView = (RecyclerView) Views.findOptionalViewAndCast(viewPager, SCROLLABLE_RECYCLER_VIEW_IDS[i2]);
            if (recyclerView != null && isScrollableRecyclerUnder(recyclerView, f, f2, i)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean isScrollableRecyclerUnder(RecyclerView recyclerView, float f, float f2, int i) {
        return Views.hitTest(recyclerView, f, f2) && canScrollMore(recyclerView, i);
    }

    private static final boolean canScrollMore(RecyclerView recyclerView, int i) {
        if (i < 0) {
            return true;
        }
        if (i != 4) {
            return i == 8 && recyclerView.computeHorizontalScrollExtent() + recyclerView.computeHorizontalScrollOffset() < recyclerView.computeHorizontalScrollRange();
        }
        return recyclerView.computeHorizontalScrollOffset() > 0;
    }

    private static final boolean canScrollMore(ViewPager viewPager, int i) {
        if (i < 0) {
            return true;
        }
        if (i == 4) {
            return viewPager.canScrollHorizontally(-1);
        }
        if (i != 8) {
            return false;
        }
        return viewPager.canScrollHorizontally(1);
    }
}
