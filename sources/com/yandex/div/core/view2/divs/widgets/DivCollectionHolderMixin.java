package com.yandex.div.core.view2.divs.widgets;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.yandex.div.internal.core.DivItemBuilderResult;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: DivCollectionHolder.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivCollectionHolderMixin;", "Lcom/yandex/div/core/view2/divs/widgets/DivCollectionHolder;", "()V", FirebaseAnalytics.Param.ITEMS, "", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivCollectionHolderMixin implements DivCollectionHolder {
    private List<DivItemBuilderResult> items;

    @Override // com.yandex.div.core.view2.divs.widgets.DivCollectionHolder
    public List<DivItemBuilderResult> getItems() {
        return this.items;
    }

    @Override // com.yandex.div.core.view2.divs.widgets.DivCollectionHolder
    public void setItems(List<DivItemBuilderResult> list) {
        this.items = list;
    }
}
