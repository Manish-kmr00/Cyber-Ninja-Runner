package com.yandex.div.json.expressions;

import com.yandex.div.core.CompositeDisposable;
import com.yandex.div.core.Disposable;
import com.yandex.div.internal.parser.ListValidator;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.ParsingExceptionKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpressionList.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0019\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007H\u0001¢\u0006\u0002\b\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J*\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0018\u0010\u001b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J*\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0018\u0010\u001b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/yandex/div/json/expressions/MutableExpressionList;", "T", "", "Lcom/yandex/div/json/expressions/ExpressionList;", "key", "", "expressions", "", "Lcom/yandex/div/json/expressions/Expression;", "listValidator", "Lcom/yandex/div/internal/parser/ListValidator;", "logger", "Lcom/yandex/div/json/ParsingErrorLogger;", "(Ljava/lang/String;Ljava/util/List;Lcom/yandex/div/internal/parser/ListValidator;Lcom/yandex/div/json/ParsingErrorLogger;)V", "lastValidValuesList", "equals", "", "other", "evaluate", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "getExpressions", "getExpressionsInternal", "hashCode", "", "observe", "Lcom/yandex/div/core/Disposable;", "callback", "Lkotlin/Function1;", "", "observeAndGet", "tryResolve", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MutableExpressionList<T> implements ExpressionList<T> {
    private final List<Expression<T>> expressions;
    private final String key;
    private List<? extends T> lastValidValuesList;
    private final ListValidator<T> listValidator;
    private final ParsingErrorLogger logger;

    /* JADX WARN: Multi-variable type inference failed */
    public MutableExpressionList(String key, List<? extends Expression<T>> expressions, ListValidator<T> listValidator, ParsingErrorLogger logger) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(expressions, "expressions");
        Intrinsics.checkNotNullParameter(listValidator, "listValidator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.key = key;
        this.expressions = expressions;
        this.listValidator = listValidator;
        this.logger = logger;
    }

    @Override // com.yandex.div.json.expressions.ExpressionList
    public List<T> evaluate(ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        try {
            List<T> listTryResolve = tryResolve(resolver);
            this.lastValidValuesList = listTryResolve;
            return listTryResolve;
        } catch (ParsingException e) {
            this.logger.logError(e);
            List<? extends T> list = this.lastValidValuesList;
            if (list != null) {
                return list;
            }
            throw e;
        }
    }

    private final List<T> tryResolve(ExpressionResolver resolver) {
        List<Expression<T>> list = this.expressions;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Expression) it.next()).evaluate(resolver));
        }
        ArrayList arrayList2 = arrayList;
        if (this.listValidator.isValid(arrayList2)) {
            return arrayList2;
        }
        throw ParsingExceptionKt.invalidValue(this.key, arrayList2);
    }

    @Override // com.yandex.div.json.expressions.ExpressionList
    public Disposable observe(final ExpressionResolver resolver, final Function1<? super List<? extends T>, Unit> callback) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Function1<T, Unit> function1 = new Function1<T, Unit>() { // from class: com.yandex.div.json.expressions.MutableExpressionList$observe$itemCallback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(T t) {
                Intrinsics.checkNotNullParameter(t, "<anonymous parameter 0>");
                callback.invoke(this.evaluate(resolver));
            }
        };
        if (this.expressions.size() == 1) {
            return ((Expression) CollectionsKt.first((List) this.expressions)).observe(resolver, function1);
        }
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Iterator<T> it = this.expressions.iterator();
        while (it.hasNext()) {
            compositeDisposable.add(((Expression) it.next()).observe(resolver, function1));
        }
        return compositeDisposable;
    }

    @Override // com.yandex.div.json.expressions.ExpressionList
    public Disposable observeAndGet(ExpressionResolver resolver, Function1<? super List<? extends T>, Unit> callback) {
        List<T> listEvaluate;
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Disposable disposableObserve = observe(resolver, callback);
        try {
            listEvaluate = evaluate(resolver);
        } catch (ParsingException e) {
            this.logger.logError(e);
            listEvaluate = null;
        }
        if (listEvaluate != null) {
            callback.invoke(listEvaluate);
        }
        return disposableObserve;
    }

    public int hashCode() {
        return this.expressions.hashCode() * 16;
    }

    public boolean equals(Object other) {
        return (other instanceof MutableExpressionList) && Intrinsics.areEqual(this.expressions, ((MutableExpressionList) other).expressions);
    }

    public final List<Expression<T>> getExpressionsInternal() {
        return this.expressions;
    }
}
