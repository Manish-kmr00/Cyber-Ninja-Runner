package com.yandex.div.core.util;

import android.view.View;
import androidx.collection.SparseArrayCompat;
import com.yandex.div.R;
import com.yandex.div.core.view2.Releasable;
import com.yandex.div.internal.core.ExpressionSubscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Releasables.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\" \u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"INDEX_EXPRESSION_SUBSCRIBER", "", "expressionSubscriber", "Lcom/yandex/div/internal/core/ExpressionSubscriber;", "Landroid/view/View;", "getExpressionSubscriber", "(Landroid/view/View;)Lcom/yandex/div/internal/core/ExpressionSubscriber;", "releasableList", "", "Lcom/yandex/div/core/view2/Releasable;", "getReleasableList", "(Landroid/view/View;)Ljava/lang/Iterable;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ReleasablesKt {
    private static final int INDEX_EXPRESSION_SUBSCRIBER = 0;

    public static final Iterable<Releasable> getReleasableList(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(R.id.div_releasable_list);
        SparseArrayCompat sparseArrayCompat = tag instanceof SparseArrayCompat ? (SparseArrayCompat) tag : null;
        if (sparseArrayCompat != null) {
            return SparseArraysKt.toIterable(sparseArrayCompat);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ExpressionSubscriber getExpressionSubscriber(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view instanceof ExpressionSubscriber) {
            return (ExpressionSubscriber) view;
        }
        Object tag = view.getTag(R.id.div_releasable_list);
        SparseArrayCompat sparseArrayCompat = tag instanceof SparseArrayCompat ? (SparseArrayCompat) tag : null;
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat();
            view.setTag(R.id.div_releasable_list, sparseArrayCompat);
        }
        Object obj = sparseArrayCompat.get(0);
        ExpressionSubscriber expressionSubscriber = obj instanceof ExpressionSubscriber ? (ExpressionSubscriber) obj : null;
        if (expressionSubscriber != null) {
            return expressionSubscriber;
        }
        ExpressionSubscriberImpl expressionSubscriberImpl = new ExpressionSubscriberImpl();
        sparseArrayCompat.put(0, expressionSubscriberImpl);
        return expressionSubscriberImpl;
    }
}
