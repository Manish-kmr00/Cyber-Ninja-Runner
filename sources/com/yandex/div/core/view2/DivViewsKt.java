package com.yandex.div.core.view2;

import android.view.ViewGroup;
import androidx.core.view.ViewKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: DivViews.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a)\u0010\u0006\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"withCanvasClipping", "T", "Lcom/yandex/div/core/view2/Div2View;", "block", "Lkotlin/Function0;", "(Lcom/yandex/div/core/view2/Div2View;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withDivViewCanvasClipping", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivViewsKt {
    public static final <T> T withCanvasClipping(Div2View div2View, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(div2View, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        Sequence sequenceFilter = SequencesKt.filter(ViewKt.getAllViews(div2View), DivViewsKt$withDivViewCanvasClipping$$inlined$filterIsInstance$1.INSTANCE);
        Intrinsics.checkNotNull(sequenceFilter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        List list = SequencesKt.toList(sequenceFilter);
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ((Div2View) it.next()).setForceCanvasClipping(true);
        }
        try {
            return block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                ((Div2View) it2.next()).setForceCanvasClipping(false);
            }
            InlineMarker.finallyEnd(1);
        }
    }

    public static final <T> T withDivViewCanvasClipping(ViewGroup viewGroup, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        Sequence sequenceFilter = SequencesKt.filter(ViewKt.getAllViews(viewGroup), DivViewsKt$withDivViewCanvasClipping$$inlined$filterIsInstance$1.INSTANCE);
        Intrinsics.checkNotNull(sequenceFilter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        List list = SequencesKt.toList(sequenceFilter);
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ((Div2View) it.next()).setForceCanvasClipping(true);
        }
        try {
            return block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                ((Div2View) it2.next()).setForceCanvasClipping(false);
            }
            InlineMarker.finallyEnd(1);
        }
    }
}
