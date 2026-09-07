package com.yandex.div.internal.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.vungle.ads.internal.protos.Sdk;
import com.yandex.div.core.util.ViewsKt;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaddingItemDecoration.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001BM\b\u0007\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0010\u0010\u0005\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/internal/widget/PaddingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "paddingLeft", "", "midItemPadding", "crossItemPadding", "paddingRight", "paddingTop", "paddingBottom", "orientation", "(IIIIIII)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PaddingItemDecoration extends RecyclerView.ItemDecoration {
    private final int crossItemPadding;
    private final int midItemPadding;
    private final int orientation;
    private final int paddingBottom;
    private final int paddingLeft;
    private final int paddingRight;
    private final int paddingTop;

    public PaddingItemDecoration() {
        this(0, 0, 0, 0, 0, 0, 0, 127, null);
    }

    public PaddingItemDecoration(int i) {
        this(i, 0, 0, 0, 0, 0, 0, 126, null);
    }

    public PaddingItemDecoration(int i, int i2) {
        this(i, i2, 0, 0, 0, 0, 0, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, null);
    }

    public PaddingItemDecoration(int i, int i2, int i3) {
        this(i, i2, i3, 0, 0, 0, 0, 120, null);
    }

    public PaddingItemDecoration(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, 0, 0, 0, 112, null);
    }

    public PaddingItemDecoration(int i, int i2, int i3, int i4, int i5) {
        this(i, i2, i3, i4, i5, 0, 0, 96, null);
    }

    public PaddingItemDecoration(int i, int i2, int i3, int i4, int i5, int i6) {
        this(i, i2, i3, i4, i5, i6, 0, 64, null);
    }

    public /* synthetic */ PaddingItemDecoration(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? 0 : i, (i8 & 2) != 0 ? 0 : i2, (i8 & 4) != 0 ? 0 : i3, (i8 & 8) != 0 ? 0 : i4, (i8 & 16) != 0 ? 0 : i5, (i8 & 32) != 0 ? 0 : i6, (i8 & 64) != 0 ? 0 : i7);
    }

    public PaddingItemDecoration(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.paddingLeft = i;
        this.midItemPadding = i2;
        this.crossItemPadding = i3;
        this.paddingRight = i4;
        this.paddingTop = i5;
        this.paddingBottom = i6;
        this.orientation = i7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int spanCount;
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            spanCount = ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        } else {
            if (!(layoutManager instanceof LinearLayoutManager)) {
                KAssert kAssert = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unsupported layoutManger: " + layoutManager);
                }
            }
            spanCount = 1;
        }
        if (spanCount == 1) {
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter != null) {
                int itemCount = adapter.getItemCount();
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                if (childAdapterPosition == -1) {
                    return;
                }
                boolean z = childAdapterPosition == 0;
                int i = itemCount - 1;
                boolean z2 = childAdapterPosition == i;
                int i2 = this.orientation;
                if (i2 == 0) {
                    if (ViewsKt.isLayoutRtl(parent)) {
                        z = childAdapterPosition == i;
                        z2 = childAdapterPosition == 0;
                    }
                    outRect.set(z ? this.paddingLeft : 0, this.paddingTop, z2 ? this.paddingRight : this.midItemPadding, this.paddingBottom);
                    return;
                }
                if (i2 == 1) {
                    outRect.set(this.paddingLeft, z ? this.paddingTop : 0, this.paddingRight, z2 ? this.paddingBottom : this.midItemPadding);
                    return;
                }
                KAssert kAssert2 = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unsupported orientation: " + this.orientation);
                    return;
                }
                return;
            }
            return;
        }
        int i3 = this.midItemPadding / 2;
        int i4 = this.crossItemPadding / 2;
        int i5 = this.orientation;
        if (i5 == 0) {
            outRect.set(i3, i4, i3, i4);
            return;
        }
        if (i5 == 1) {
            outRect.set(i4, i3, i4, i3);
            return;
        }
        KAssert kAssert3 = KAssert.INSTANCE;
        if (Assert.isEnabled()) {
            Assert.fail("Unsupported orientation: " + this.orientation);
        }
    }
}
