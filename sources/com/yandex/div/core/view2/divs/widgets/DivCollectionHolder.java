package com.yandex.div.core.view2.divs.widgets;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.yandex.div.internal.core.DivItemBuilderResult;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: DivCollectionHolder.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001R \u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivCollectionHolder;", "", FirebaseAnalytics.Param.ITEMS, "", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivCollectionHolder {
    List<DivItemBuilderResult> getItems();

    void setItems(List<DivItemBuilderResult> list);
}
