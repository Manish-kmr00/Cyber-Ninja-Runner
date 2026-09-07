package com.yandex.div.core.state;

import kotlin.Metadata;

/* JADX INFO: compiled from: GalleryState.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/yandex/div/core/state/GalleryState;", "Lcom/yandex/div/core/state/DivViewState$BlockState;", "visibleItemIndex", "", "scrollOffset", "(II)V", "getScrollOffset", "()I", "getVisibleItemIndex", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class GalleryState implements DivViewState.BlockState {
    private final int scrollOffset;
    private final int visibleItemIndex;

    public static /* synthetic */ GalleryState copy$default(GalleryState galleryState, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = galleryState.visibleItemIndex;
        }
        if ((i3 & 2) != 0) {
            i2 = galleryState.scrollOffset;
        }
        return galleryState.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getVisibleItemIndex() {
        return this.visibleItemIndex;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getScrollOffset() {
        return this.scrollOffset;
    }

    public final GalleryState copy(int visibleItemIndex, int scrollOffset) {
        return new GalleryState(visibleItemIndex, scrollOffset);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GalleryState)) {
            return false;
        }
        GalleryState galleryState = (GalleryState) other;
        return this.visibleItemIndex == galleryState.visibleItemIndex && this.scrollOffset == galleryState.scrollOffset;
    }

    public int hashCode() {
        return (Integer.hashCode(this.visibleItemIndex) * 31) + Integer.hashCode(this.scrollOffset);
    }

    public String toString() {
        return "GalleryState(visibleItemIndex=" + this.visibleItemIndex + ", scrollOffset=" + this.scrollOffset + ')';
    }

    public GalleryState(int i, int i2) {
        this.visibleItemIndex = i;
        this.scrollOffset = i2;
    }

    public final int getVisibleItemIndex() {
        return this.visibleItemIndex;
    }

    public final int getScrollOffset() {
        return this.scrollOffset;
    }
}
