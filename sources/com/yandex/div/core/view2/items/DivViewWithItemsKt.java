package com.yandex.div.core.view2.items;

import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div2.DivSizeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: DivViewWithItems.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a'\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0082\b\u001a\u001b\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\u0007*\u00020\u0002*\u0002H\u0007H\u0002¢\u0006\u0002\u0010\u0011\u001a#\u0010\u0012\u001a\u00020\u0001\"\b\b\u0000\u0010\u0007*\u00020\u0002*\u0002H\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010\u0015\u001a#\u0010\u0016\u001a\u00020\u0001\"\b\b\u0000\u0010\u0007*\u00020\u0002*\u0002H\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010\u0015\u001a\u001b\u0010\u0017\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0082\b\u001a\u001b\u0010\u0019\u001a\u00020\u0001\"\b\b\u0000\u0010\u0007*\u00020\u0002*\u0002H\u0007H\u0002¢\u0006\u0002\u0010\u0004\u001a\u001b\u0010\u001a\u001a\u00020\u0001\"\b\b\u0000\u0010\u0007*\u00020\u0002*\u0002H\u0007H\u0002¢\u0006\u0002\u0010\u0004\u001a=\u0010\u001b\u001a\u00020\u000b\"\b\b\u0000\u0010\u0007*\u00020\u0002*\u0002H\u00072\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\"\u001a-\u0010#\u001a\u00020\u000b\"\b\b\u0000\u0010\u0007*\u00020\u0002*\u0002H\u00072\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010$\u001a\u0014\u0010%\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"$\u0010\u0005\u001a\u0004\u0018\u00010\u0006\"\b\b\u0000\u0010\u0007*\u00020\u0002*\u0002H\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006&"}, d2 = {"itemCount", "", "Landroidx/recyclerview/widget/RecyclerView;", "getItemCount", "(Landroidx/recyclerview/widget/RecyclerView;)I", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "T", "getLinearLayoutManager", "(Landroidx/recyclerview/widget/RecyclerView;)Landroidx/recyclerview/widget/LinearLayoutManager;", "checkItem", "", "item", "block", "Lkotlin/Function0;", "canScroll", "", "(Landroidx/recyclerview/widget/RecyclerView;)Z", "completelyVisibleItemPosition", "direction", "Lcom/yandex/div/core/view2/items/Direction;", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/yandex/div/core/view2/items/Direction;)I", "currentItem", "ifNoPosition", POBNativeConstants.NATIVE_FALLBACK_URL, "scrollOffset", "scrollRange", "scrollTo", "value", "sizeUnit", "Lcom/yandex/div2/DivSizeUnit;", "metrics", "Landroid/util/DisplayMetrics;", "animated", "(Landroidx/recyclerview/widget/RecyclerView;ILcom/yandex/div2/DivSizeUnit;Landroid/util/DisplayMetrics;Z)V", "scrollToTheEnd", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/util/DisplayMetrics;Z)V", "visibleItemPosition", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivViewWithItemsKt {

    /* JADX INFO: compiled from: DivViewWithItems.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Direction.values().length];
            try {
                iArr[Direction.PREVIOUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Direction.NEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DivSizeUnit.values().length];
            try {
                iArr2[DivSizeUnit.PX.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[DivSizeUnit.SP.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[DivSizeUnit.DP.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getItemCount(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            return layoutManager.getItemCount();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends RecyclerView> int currentItem(T t, Direction direction) {
        Integer numValueOf = Integer.valueOf(completelyVisibleItemPosition(t, direction));
        if (numValueOf.intValue() == -1) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        LinearLayoutManager linearLayoutManager = getLinearLayoutManager(t);
        return linearLayoutManager != null ? visibleItemPosition(linearLayoutManager, direction) : -1;
    }

    private static final <T extends RecyclerView> int completelyVisibleItemPosition(T t, Direction direction) {
        LinearLayoutManager linearLayoutManager = getLinearLayoutManager(t);
        if (linearLayoutManager == null) {
            return -1;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[direction.ordinal()];
        if (i == 1) {
            return linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (canScroll(t)) {
            return linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        }
        return linearLayoutManager.findLastCompletelyVisibleItemPosition();
    }

    private static final <T extends RecyclerView> boolean canScroll(T t) {
        LinearLayoutManager linearLayoutManager = getLinearLayoutManager(t);
        Integer numValueOf = linearLayoutManager != null ? Integer.valueOf(linearLayoutManager.getOrientation()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            return t.canScrollHorizontally(1);
        }
        if (numValueOf != null && numValueOf.intValue() == 1) {
            return t.canScrollVertically(1);
        }
        return false;
    }

    static /* synthetic */ void scrollTo$default(RecyclerView recyclerView, int i, DivSizeUnit divSizeUnit, DisplayMetrics displayMetrics, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = true;
        }
        scrollTo(recyclerView, i, divSizeUnit, displayMetrics, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends RecyclerView> void scrollTo(T t, int i, DivSizeUnit divSizeUnit, DisplayMetrics displayMetrics, boolean z) {
        int i2 = WhenMappings.$EnumSwitchMapping$1[divSizeUnit.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                i = BaseDivViewExtensionsKt.spToPx(Integer.valueOf(i), displayMetrics);
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                i = BaseDivViewExtensionsKt.dpToPx(Integer.valueOf(i), displayMetrics);
            }
        }
        LinearLayoutManager linearLayoutManager = getLinearLayoutManager(t);
        if (linearLayoutManager == null) {
            return;
        }
        Function2 divViewWithItemsKt$scrollTo$scroll$1 = z ? new DivViewWithItemsKt$scrollTo$scroll$1(t) : new DivViewWithItemsKt$scrollTo$scroll$2(t);
        int orientation = linearLayoutManager.getOrientation();
        if (orientation == 0) {
            divViewWithItemsKt$scrollTo$scroll$1.invoke(Integer.valueOf(i - t.computeHorizontalScrollOffset()), 0);
        } else {
            if (orientation != 1) {
                return;
            }
            divViewWithItemsKt$scrollTo$scroll$1.invoke(0, Integer.valueOf(i - t.computeVerticalScrollOffset()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends RecyclerView> int scrollRange(T t) {
        int iComputeVerticalScrollRange;
        int paddingBottom;
        LinearLayoutManager linearLayoutManager = getLinearLayoutManager(t);
        Integer numValueOf = linearLayoutManager != null ? Integer.valueOf(linearLayoutManager.getOrientation()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            iComputeVerticalScrollRange = (t.computeHorizontalScrollRange() - t.getWidth()) + t.getPaddingLeft();
            paddingBottom = t.getPaddingRight();
        } else {
            iComputeVerticalScrollRange = (t.computeVerticalScrollRange() - t.getHeight()) + t.getPaddingTop();
            paddingBottom = t.getPaddingBottom();
        }
        return iComputeVerticalScrollRange + paddingBottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends RecyclerView> int scrollOffset(T t) {
        LinearLayoutManager linearLayoutManager = getLinearLayoutManager(t);
        Integer numValueOf = linearLayoutManager != null ? Integer.valueOf(linearLayoutManager.getOrientation()) : null;
        return (numValueOf != null && numValueOf.intValue() == 0) ? t.computeHorizontalScrollOffset() : t.computeVerticalScrollOffset();
    }

    static /* synthetic */ void scrollToTheEnd$default(RecyclerView recyclerView, DisplayMetrics displayMetrics, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        scrollToTheEnd(recyclerView, displayMetrics, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends RecyclerView> void scrollToTheEnd(T t, DisplayMetrics displayMetrics, boolean z) {
        scrollTo(t, scrollRange(t), DivSizeUnit.PX, displayMetrics, z);
    }

    private static final int visibleItemPosition(LinearLayoutManager linearLayoutManager, Direction direction) {
        int i = WhenMappings.$EnumSwitchMapping$0[direction.ordinal()];
        if (i == 1) {
            return linearLayoutManager.findLastVisibleItemPosition();
        }
        if (i == 2) {
            return linearLayoutManager.findFirstVisibleItemPosition();
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final <T extends RecyclerView> LinearLayoutManager getLinearLayoutManager(T t) {
        RecyclerView.LayoutManager layoutManager = t.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return (LinearLayoutManager) layoutManager;
        }
        return null;
    }

    private static final int ifNoPosition(int i, Function0<Integer> function0) {
        Integer numValueOf = Integer.valueOf(i);
        if (numValueOf.intValue() == -1) {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : function0.invoke().intValue();
    }

    private static final void checkItem(int i, int i2, Function0<Unit> function0) {
        if (i < 0 || i >= i2) {
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail(i + " is not in range [0, " + i2 + ')');
                return;
            }
            return;
        }
        function0.invoke();
    }
}
