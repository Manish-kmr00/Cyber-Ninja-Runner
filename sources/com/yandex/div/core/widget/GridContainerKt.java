package com.yandex.div.core.widget;

import com.yandex.div.internal.widget.DivLayoutParams;
import kotlin.Metadata;

/* JADX INFO: compiled from: GridContainer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"columnWeight", "", "Lcom/yandex/div/internal/widget/DivLayoutParams;", "getColumnWeight", "(Lcom/yandex/div/internal/widget/DivLayoutParams;)F", "rowWeight", "getRowWeight", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class GridContainerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final float getRowWeight(DivLayoutParams divLayoutParams) {
        return divLayoutParams.getVerticalWeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float getColumnWeight(DivLayoutParams divLayoutParams) {
        return divLayoutParams.getHorizontalWeight();
    }
}
