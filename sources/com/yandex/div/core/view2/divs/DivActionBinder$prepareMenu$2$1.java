package com.yandex.div.core.view2.divs;

import com.yandex.div.internal.widget.menu.OverflowMenuSubscriber;
import com.yandex.div.internal.widget.menu.OverflowMenuWrapper;
import kotlin.Metadata;

/* JADX INFO: compiled from: DivActionBinder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "dismiss"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class DivActionBinder$prepareMenu$2$1 implements OverflowMenuSubscriber.Listener {
    final /* synthetic */ OverflowMenuWrapper $overflowMenuWrapper;

    public DivActionBinder$prepareMenu$2$1(OverflowMenuWrapper overflowMenuWrapper) {
        this.$overflowMenuWrapper = overflowMenuWrapper;
    }

    @Override // com.yandex.div.internal.widget.menu.OverflowMenuSubscriber.Listener
    public final void dismiss() {
        this.$overflowMenuWrapper.dismiss();
    }
}
