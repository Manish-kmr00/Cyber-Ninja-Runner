package com.yandex.div.json.expressions;

import com.yandex.div.core.Disposable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpressionList.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0018\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J*\u0010\u0016\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0018\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u00150\u0014H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/yandex/div/json/expressions/ConstantExpressionList;", "T", "", "Lcom/yandex/div/json/expressions/ExpressionList;", "values", "", "(Ljava/util/List;)V", "getValues$div_data_release", "()Ljava/util/List;", "equals", "", "other", "evaluate", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "hashCode", "", "observe", "Lcom/yandex/div/core/Disposable;", "callback", "Lkotlin/Function1;", "", "observeAndGet", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ConstantExpressionList<T> implements ExpressionList<T> {
    private final List<T> values;

    /* JADX WARN: Multi-variable type inference failed */
    public ConstantExpressionList(List<? extends T> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        this.values = values;
    }

    public final List<T> getValues$div_data_release() {
        return this.values;
    }

    @Override // com.yandex.div.json.expressions.ExpressionList
    public List<T> evaluate(ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return this.values;
    }

    @Override // com.yandex.div.json.expressions.ExpressionList
    public Disposable observe(ExpressionResolver resolver, Function1<? super List<? extends T>, Unit> callback) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return Disposable.NULL;
    }

    @Override // com.yandex.div.json.expressions.ExpressionList
    public Disposable observeAndGet(ExpressionResolver resolver, Function1<? super List<? extends T>, Unit> callback) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.invoke(this.values);
        return Disposable.NULL;
    }

    public int hashCode() {
        return this.values.hashCode() * 16;
    }

    public boolean equals(Object other) {
        return (other instanceof ConstantExpressionList) && Intrinsics.areEqual(this.values, ((ConstantExpressionList) other).values);
    }
}
