package com.yandex.div.core.state;

import com.yandex.div.core.view2.Div2View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivStateChangeListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/state/DivStateChangeListener;", "", "onDivAnimatedStateChanged", "", "divView", "Lcom/yandex/div/core/view2/Div2View;", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivStateChangeListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final DivStateChangeListener STUB = new DivStateChangeListener() { // from class: com.yandex.div.core.state.DivStateChangeListener$Companion$STUB$1
        @Override // com.yandex.div.core.state.DivStateChangeListener
        public void onDivAnimatedStateChanged(Div2View divView) {
            Intrinsics.checkNotNullParameter(divView, "divView");
        }
    };

    void onDivAnimatedStateChanged(Div2View divView);

    /* JADX INFO: compiled from: DivStateChangeListener.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/core/state/DivStateChangeListener$Companion;", "", "()V", "STUB", "Lcom/yandex/div/core/state/DivStateChangeListener;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
