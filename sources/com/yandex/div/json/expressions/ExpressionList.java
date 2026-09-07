package com.yandex.div.json.expressions;

import com.yandex.div.core.Disposable;
import com.yandex.div.json.ParsingException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ExpressionList.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00020\u000b0\nH&J*\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00020\u000b0\nH&\u0082\u0001\u0002\r\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/json/expressions/ExpressionList;", "T", "", "evaluate", "", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "observe", "Lcom/yandex/div/core/Disposable;", "callback", "Lkotlin/Function1;", "", "observeAndGet", "Lcom/yandex/div/json/expressions/ConstantExpressionList;", "Lcom/yandex/div/json/expressions/MutableExpressionList;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ExpressionList<T> {
    List<T> evaluate(ExpressionResolver resolver) throws ParsingException;

    Disposable observe(ExpressionResolver resolver, Function1<? super List<? extends T>, Unit> callback);

    Disposable observeAndGet(ExpressionResolver resolver, Function1<? super List<? extends T>, Unit> callback);
}
