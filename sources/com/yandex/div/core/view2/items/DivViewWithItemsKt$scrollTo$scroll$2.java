package com.yandex.div.core.view2.items;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: DivViewWithItems.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* synthetic */ class DivViewWithItemsKt$scrollTo$scroll$2 extends FunctionReferenceImpl implements Function2<Integer, Integer, Unit> {
    DivViewWithItemsKt$scrollTo$scroll$2(Object obj) {
        super(2, obj, RecyclerView.class, "scrollBy", "scrollBy(II)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, int i2) {
        ((RecyclerView) this.receiver).scrollBy(i, i2);
    }
}
