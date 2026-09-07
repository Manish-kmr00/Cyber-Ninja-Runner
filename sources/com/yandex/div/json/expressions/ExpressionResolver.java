package com.yandex.div.json.expressions;

import com.yandex.div.core.Disposable;
import com.yandex.div.evaluable.Evaluable;
import com.yandex.div.internal.parser.TypeHelper;
import com.yandex.div.internal.parser.ValueValidator;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.ParsingException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpressionResolver.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eJ\u0087\u0001\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2*\u0010\n\u001a&\u0012\u0004\u0012\u0002H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0018\u00010\u000bj\u0012\u0012\u0004\u0012\u0002H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0018\u0001`\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00030\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J,\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001dH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/json/expressions/ExpressionResolver;", "", "get", "T", "R", "expressionKey", "", "rawExpression", "evaluable", "Lcom/yandex/div/evaluable/Evaluable;", "converter", "Lkotlin/Function1;", "Lcom/yandex/div/internal/parser/Converter;", "validator", "Lcom/yandex/div/internal/parser/ValueValidator;", "fieldType", "Lcom/yandex/div/internal/parser/TypeHelper;", "logger", "Lcom/yandex/div/json/ParsingErrorLogger;", "(Ljava/lang/String;Ljava/lang/String;Lcom/yandex/div/evaluable/Evaluable;Lkotlin/jvm/functions/Function1;Lcom/yandex/div/internal/parser/ValueValidator;Lcom/yandex/div/internal/parser/TypeHelper;Lcom/yandex/div/json/ParsingErrorLogger;)Ljava/lang/Object;", "notifyResolveFailed", "", "e", "Lcom/yandex/div/json/ParsingException;", "subscribeToExpression", "Lcom/yandex/div/core/Disposable;", "variableNames", "", "callback", "Lkotlin/Function0;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ExpressionResolver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final ExpressionResolver EMPTY = new ExpressionResolver() { // from class: com.yandex.div.json.expressions.ExpressionResolver$Companion$EMPTY$1
        @Override // com.yandex.div.json.expressions.ExpressionResolver
        public <R, T> T get(String expressionKey, String rawExpression, Evaluable evaluable, Function1<? super R, ? extends T> converter, ValueValidator<T> validator, TypeHelper<T> fieldType, ParsingErrorLogger logger) {
            Intrinsics.checkNotNullParameter(expressionKey, "expressionKey");
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            Intrinsics.checkNotNullParameter(evaluable, "evaluable");
            Intrinsics.checkNotNullParameter(validator, "validator");
            Intrinsics.checkNotNullParameter(fieldType, "fieldType");
            Intrinsics.checkNotNullParameter(logger, "logger");
            return null;
        }

        @Override // com.yandex.div.json.expressions.ExpressionResolver
        public Disposable subscribeToExpression(String rawExpression, List<String> variableNames, Function0<Unit> callback) {
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            Intrinsics.checkNotNullParameter(variableNames, "variableNames");
            Intrinsics.checkNotNullParameter(callback, "callback");
            return Disposable.NULL;
        }
    };

    <R, T> T get(String expressionKey, String rawExpression, Evaluable evaluable, Function1<? super R, ? extends T> converter, ValueValidator<T> validator, TypeHelper<T> fieldType, ParsingErrorLogger logger);

    default void notifyResolveFailed(ParsingException e) {
        Intrinsics.checkNotNullParameter(e, "e");
    }

    Disposable subscribeToExpression(String rawExpression, List<String> variableNames, Function0<Unit> callback);

    /* JADX INFO: compiled from: ExpressionResolver.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/json/expressions/ExpressionResolver$Companion;", "", "()V", "EMPTY", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
