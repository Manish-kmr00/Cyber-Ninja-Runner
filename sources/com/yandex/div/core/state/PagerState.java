package com.yandex.div.core.state;

import kotlin.Metadata;

/* JADX INFO: compiled from: PagerState.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/core/state/PagerState;", "Lcom/yandex/div/core/state/DivViewState$BlockState;", "currentPageIndex", "", "(I)V", "getCurrentPageIndex", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class PagerState implements DivViewState.BlockState {
    private final int currentPageIndex;

    public static /* synthetic */ PagerState copy$default(PagerState pagerState, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = pagerState.currentPageIndex;
        }
        return pagerState.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCurrentPageIndex() {
        return this.currentPageIndex;
    }

    public final PagerState copy(int currentPageIndex) {
        return new PagerState(currentPageIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PagerState) && this.currentPageIndex == ((PagerState) other).currentPageIndex;
    }

    public int hashCode() {
        return Integer.hashCode(this.currentPageIndex);
    }

    public String toString() {
        return "PagerState(currentPageIndex=" + this.currentPageIndex + ')';
    }

    public PagerState(int i) {
        this.currentPageIndex = i;
    }

    public final int getCurrentPageIndex() {
        return this.currentPageIndex;
    }
}
