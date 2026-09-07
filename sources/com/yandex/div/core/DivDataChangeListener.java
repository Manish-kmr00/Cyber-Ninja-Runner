package com.yandex.div.core;

import com.yandex.div.core.view2.Div2View;
import com.yandex.div2.DivData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivDataChangeListener.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/DivDataChangeListener;", "", "afterAnimatedDataChange", "", "divView", "Lcom/yandex/div/core/view2/Div2View;", "data", "Lcom/yandex/div2/DivData;", "beforeAnimatedDataChange", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivDataChangeListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final DivDataChangeListener STUB = new DivDataChangeListener() { // from class: com.yandex.div.core.DivDataChangeListener$Companion$STUB$1
        @Override // com.yandex.div.core.DivDataChangeListener
        public void afterAnimatedDataChange(Div2View divView, DivData data) {
            Intrinsics.checkNotNullParameter(divView, "divView");
            Intrinsics.checkNotNullParameter(data, "data");
        }

        @Override // com.yandex.div.core.DivDataChangeListener
        public void beforeAnimatedDataChange(Div2View divView, DivData data) {
            Intrinsics.checkNotNullParameter(divView, "divView");
            Intrinsics.checkNotNullParameter(data, "data");
        }
    };

    void afterAnimatedDataChange(Div2View divView, DivData data);

    void beforeAnimatedDataChange(Div2View divView, DivData data);

    /* JADX INFO: compiled from: DivDataChangeListener.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/core/DivDataChangeListener$Companion;", "", "()V", "STUB", "Lcom/yandex/div/core/DivDataChangeListener;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
