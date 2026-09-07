package com.yandex.div.core.view2.divs.gallery;

import android.view.View;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import com.yandex.div.core.ScrollDirection;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivVisibilityActionTracker;
import com.yandex.div.core.view2.divs.widgets.DivRecyclerView;
import com.yandex.div2.Div;
import com.yandex.div2.DivGallery;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: DivGalleryScrollListener.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J \u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0016H\u0016J\b\u0010 \u001a\u00020\u0019H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/yandex/div/core/view2/divs/gallery/DivGalleryScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "recycler", "Lcom/yandex/div/core/view2/divs/widgets/DivRecyclerView;", "galleryItemHelper", "Lcom/yandex/div/core/view2/divs/gallery/DivGalleryItemHelper;", "galleryDiv", "Lcom/yandex/div2/DivGallery;", "(Lcom/yandex/div/core/view2/BindingContext;Lcom/yandex/div/core/view2/divs/widgets/DivRecyclerView;Lcom/yandex/div/core/view2/divs/gallery/DivGalleryItemHelper;Lcom/yandex/div2/DivGallery;)V", "alreadyLogged", "", "direction", "", "getDirection", "()Ljava/lang/String;", "setDirection", "(Ljava/lang/String;)V", "divView", "Lcom/yandex/div/core/view2/Div2View;", "minimumSignificantDx", "", "totalDelta", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "trackViews", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivGalleryScrollListener extends RecyclerView.OnScrollListener {
    private boolean alreadyLogged;
    private final BindingContext bindingContext;
    private String direction;
    private final Div2View divView;
    private final DivGallery galleryDiv;
    private final DivGalleryItemHelper galleryItemHelper;
    private final int minimumSignificantDx;
    private final DivRecyclerView recycler;
    private int totalDelta;

    public DivGalleryScrollListener(BindingContext bindingContext, DivRecyclerView recycler, DivGalleryItemHelper galleryItemHelper, DivGallery galleryDiv) {
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(galleryItemHelper, "galleryItemHelper");
        Intrinsics.checkNotNullParameter(galleryDiv, "galleryDiv");
        this.bindingContext = bindingContext;
        this.recycler = recycler;
        this.galleryItemHelper = galleryItemHelper;
        this.galleryDiv = galleryDiv;
        Div2View divView = bindingContext.getDivView();
        this.divView = divView;
        this.minimumSignificantDx = divView.getConfig().getLogCardScrollSignificantThreshold();
        this.direction = "next";
    }

    public final String getDirection() {
        return this.direction;
    }

    public final void setDirection(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.direction = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == 1) {
            this.alreadyLogged = false;
        }
        if (newState == 0) {
            this.divView.getDiv2Component().getDiv2Logger().logGalleryCompleteScroll(this.divView, this.bindingContext.getExpressionResolver(), this.galleryDiv, this.galleryItemHelper.firstVisibleItemPosition(), this.galleryItemHelper.lastVisibleItemPosition(), this.direction);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        int iWidth = this.minimumSignificantDx;
        if (iWidth <= 0) {
            iWidth = this.galleryItemHelper.width() / 20;
        }
        int iAbs = this.totalDelta + Math.abs(dx) + Math.abs(dy);
        this.totalDelta = iAbs;
        if (iAbs > iWidth) {
            this.totalDelta = 0;
            if (!this.alreadyLogged) {
                this.alreadyLogged = true;
                this.divView.getDiv2Component().getDiv2Logger().logGalleryScroll(this.divView);
                this.direction = (dx > 0 || dy > 0) ? "next" : ScrollDirection.BACK;
            }
            trackViews();
        }
    }

    private final void trackViews() {
        DivVisibilityActionTracker visibilityActionTracker = this.divView.getDiv2Component().getVisibilityActionTracker();
        Intrinsics.checkNotNullExpressionValue(visibilityActionTracker, "divView.div2Component.visibilityActionTracker");
        visibilityActionTracker.updateVisibleViews(SequencesKt.toList(ViewGroupKt.getChildren(this.recycler)));
        for (View view : ViewGroupKt.getChildren(this.recycler)) {
            int childAdapterPosition = this.recycler.getChildAdapterPosition(view);
            if (childAdapterPosition != -1) {
                RecyclerView.Adapter adapter = this.recycler.getAdapter();
                Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.gallery.DivGalleryAdapter");
                visibilityActionTracker.startTrackingViewsHierarchy(this.bindingContext, view, ((DivGalleryAdapter) adapter).getVisibleItems().get(childAdapterPosition).getDiv());
            }
        }
        Map<View, Div> divWithWaitingDisappearActions = visibilityActionTracker.getDivWithWaitingDisappearActions();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<View, Div> entry : divWithWaitingDisappearActions.entrySet()) {
            if (!SequencesKt.contains(ViewGroupKt.getChildren(this.recycler), entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            visibilityActionTracker.trackDetachedView(this.bindingContext, (View) entry2.getKey(), (Div) entry2.getValue());
        }
    }
}
