package com.yandex.div.core.state;

import androidx.recyclerview.widget.RecyclerView;
import com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdateStateScrollListener.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/core/state/UpdateStateScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "blockId", "", "divViewState", "Lcom/yandex/div/core/state/DivViewState;", "layoutManager", "Lcom/yandex/div/core/view2/divs/gallery/DivGalleryItemHelper;", "(Ljava/lang/String;Lcom/yandex/div/core/state/DivViewState;Lcom/yandex/div/core/view2/divs/gallery/DivGalleryItemHelper;)V", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UpdateStateScrollListener extends RecyclerView.OnScrollListener {
    private final String blockId;
    private final DivViewState divViewState;
    private final DivGalleryItemHelper layoutManager;

    public UpdateStateScrollListener(String blockId, DivViewState divViewState, DivGalleryItemHelper layoutManager) {
        Intrinsics.checkNotNullParameter(blockId, "blockId");
        Intrinsics.checkNotNullParameter(divViewState, "divViewState");
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        this.blockId = blockId;
        this.divViewState = divViewState;
        this.layoutManager = layoutManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        int i;
        int left;
        int paddingLeft;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        int iFirstVisibleItemPosition = this.layoutManager.firstVisibleItemPosition();
        RecyclerView.ViewHolder viewHolderFindViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(iFirstVisibleItemPosition);
        if (viewHolderFindViewHolderForLayoutPosition != null) {
            if (this.layoutManager.getLayoutManagerOrientation() == 1) {
                left = viewHolderFindViewHolderForLayoutPosition.itemView.getTop();
                paddingLeft = this.layoutManager.getView().getPaddingTop();
            } else {
                left = viewHolderFindViewHolderForLayoutPosition.itemView.getLeft();
                paddingLeft = this.layoutManager.getView().getPaddingLeft();
            }
            i = left - paddingLeft;
        } else {
            i = 0;
        }
        this.divViewState.putBlockState(this.blockId, new GalleryState(iFirstVisibleItemPosition, i));
    }
}
