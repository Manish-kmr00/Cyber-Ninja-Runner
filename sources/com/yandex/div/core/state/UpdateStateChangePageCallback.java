package com.yandex.div.core.state;

import androidx.viewpager2.widget.ViewPager2;
import com.json.b9;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdateStateChangePageCallback.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/yandex/div/core/state/UpdateStateChangePageCallback;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "mBlockId", "", "mDivViewState", "Lcom/yandex/div/core/state/DivViewState;", "(Ljava/lang/String;Lcom/yandex/div/core/state/DivViewState;)V", "onPageSelected", "", b9.h.L, "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UpdateStateChangePageCallback extends ViewPager2.OnPageChangeCallback {
    private final String mBlockId;
    private final DivViewState mDivViewState;

    public UpdateStateChangePageCallback(String mBlockId, DivViewState mDivViewState) {
        Intrinsics.checkNotNullParameter(mBlockId, "mBlockId");
        Intrinsics.checkNotNullParameter(mDivViewState, "mDivViewState");
        this.mBlockId = mBlockId;
        this.mDivViewState = mDivViewState;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int position) {
        if (position != -1) {
            this.mDivViewState.putBlockState(this.mBlockId, new PagerState(position));
        }
    }
}
