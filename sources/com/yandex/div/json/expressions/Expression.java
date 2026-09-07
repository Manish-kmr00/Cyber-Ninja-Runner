package com.yandex.div.json.expressions;

import com.yandex.div.core.Disposable;
import com.yandex.div.evaluable.Evaluable;
import com.yandex.div.evaluable.EvaluableException;
import com.yandex.div.evaluable.internal.LiteralsEscaper;
import com.yandex.div.internal.parser.TypeHelper;
import com.yandex.div.internal.parser.ValueValidator;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.ParsingExceptionKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Expression.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u0016*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0004\u0016\u0017\u0018\u0019B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0015\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\fH&¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140\u0013H&J$\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140\u0013H\u0016R\u0012\u0010\u0004\u001a\u00020\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/yandex/div/json/expressions/Expression;", "T", "", "()V", "rawValue", "getRawValue", "()Ljava/lang/Object;", "equals", "", "other", "evaluate", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "(Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "hashCode", "", "observe", "Lcom/yandex/div/core/Disposable;", "callback", "Lkotlin/Function1;", "", "observeAndGet", "Companion", "ConstantExpression", "MutableExpression", "StringConstantExpression", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class Expression<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final <T> Expression<T> constant(T t) {
        return INSTANCE.constant(t);
    }

    @JvmStatic
    public static final boolean mayBeExpression(Object obj) {
        return INSTANCE.mayBeExpression(obj);
    }

    public abstract T evaluate(ExpressionResolver resolver);

    public abstract Object getRawValue();

    public abstract Disposable observe(ExpressionResolver resolver, Function1<? super T, Unit> callback);

    public Disposable observeAndGet(ExpressionResolver resolver, Function1<? super T, Unit> callback) {
        T tEvaluate;
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            tEvaluate = evaluate(resolver);
        } catch (ParsingException unused) {
            tEvaluate = null;
        }
        if (tEvaluate != null) {
            callback.invoke(tEvaluate);
        }
        return observe(resolver, callback);
    }

    public boolean equals(Object other) {
        if (other instanceof Expression) {
            return Intrinsics.areEqual(getRawValue(), ((Expression) other).getRawValue());
        }
        return false;
    }

    public int hashCode() {
        return getRawValue().hashCode() * 16;
    }

    /* JADX INFO: compiled from: Expression.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div/json/expressions/Expression$StringConstantExpression;", "Lcom/yandex/div/json/expressions/Expression$ConstantExpression;", "", "value", "defaultValue", "logger", "Lcom/yandex/div/json/ParsingErrorLogger;", "(Ljava/lang/String;Ljava/lang/String;Lcom/yandex/div/json/ParsingErrorLogger;)V", "cachedValue", "evaluate", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class StringConstantExpression extends ConstantExpression<String> {
        private String cachedValue;
        private final String defaultValue;
        private final ParsingErrorLogger logger;
        private final String value;

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ StringConstantExpression(String str, String str2, ParsingErrorLogger LOG, int i, DefaultConstructorMarker defaultConstructorMarker) {
            str2 = (i & 2) != 0 ? "" : str2;
            if ((i & 4) != 0) {
                LOG = ParsingErrorLogger.LOG;
                Intrinsics.checkNotNullExpressionValue(LOG, "LOG");
            }
            this(str, str2, LOG);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StringConstantExpression(String value, String defaultValue, ParsingErrorLogger logger) {
            super(value);
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
            Intrinsics.checkNotNullParameter(logger, "logger");
            this.value = value;
            this.defaultValue = defaultValue;
            this.logger = logger;
        }

        @Override // com.yandex.div.json.expressions.Expression.ConstantExpression, com.yandex.div.json.expressions.Expression
        public String evaluate(ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            String str = this.cachedValue;
            if (str != null) {
                return str;
            }
            try {
                String strProcess$default = LiteralsEscaper.process$default(LiteralsEscaper.INSTANCE, this.value, null, 2, null);
                this.cachedValue = strProcess$default;
                return strProcess$default;
            } catch (EvaluableException e) {
                this.logger.logError(e);
                String str2 = this.defaultValue;
                this.cachedValue = str2;
                return str2;
            }
        }
    }

    /* JADX INFO: compiled from: Expression.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J\u0015\u0010\n\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J$\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u0014\u0010\u0006\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u0004\u001a\u00028\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/yandex/div/json/expressions/Expression$ConstantExpression;", "T", "", "Lcom/yandex/div/json/expressions/Expression;", "value", "(Ljava/lang/Object;)V", "rawValue", "getRawValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "evaluate", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "(Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "observe", "Lcom/yandex/div/core/Disposable;", "callback", "Lkotlin/Function1;", "", "observeAndGet", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class ConstantExpression<T> extends Expression<T> {
        private final T value;

        public ConstantExpression(T value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        @Override // com.yandex.div.json.expressions.Expression
        public Object getRawValue() {
            T t = this.value;
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.Any");
            return t;
        }

        @Override // com.yandex.div.json.expressions.Expression
        public T evaluate(ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            return this.value;
        }

        @Override // com.yandex.div.json.expressions.Expression
        public Disposable observe(ExpressionResolver resolver, Function1<? super T, Unit> callback) {
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(callback, "callback");
            return Disposable.NULL;
        }

        @Override // com.yandex.div.json.expressions.Expression
        public Disposable observeAndGet(ExpressionResolver resolver, Function1<? super T, Unit> callback) {
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(callback, "callback");
            callback.invoke(this.value);
            return Disposable.NULL;
        }
    }

    /* JADX INFO: compiled from: Expression.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\b\b\u0002\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004Bw\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012*\u0010\b\u001a&\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0002\u0018\u00010\tj\u0012\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0002\u0018\u0001`\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004¢\u0006\u0002\u0010\u0012J\u0015\u0010\u001a\u001a\u00028\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0016¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0014H\u0002J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J$\u0010%\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\"0\tH\u0016J\u0015\u0010(\u001a\u00028\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010\u001dJ\u0015\u0010)\u001a\u00028\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010\u001dR2\u0010\b\u001a&\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0002\u0018\u00010\tj\u0012\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0002\u0018\u0001`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00018\u0002X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/yandex/div/json/expressions/Expression$MutableExpression;", "R", "T", "", "Lcom/yandex/div/json/expressions/Expression;", "expressionKey", "", "rawExpression", "converter", "Lkotlin/Function1;", "Lcom/yandex/div/internal/parser/Converter;", "validator", "Lcom/yandex/div/internal/parser/ValueValidator;", "logger", "Lcom/yandex/div/json/ParsingErrorLogger;", "typeHelper", "Lcom/yandex/div/internal/parser/TypeHelper;", "fieldDefaultValue", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lcom/yandex/div/internal/parser/ValueValidator;Lcom/yandex/div/json/ParsingErrorLogger;Lcom/yandex/div/internal/parser/TypeHelper;Lcom/yandex/div/json/expressions/Expression;)V", "evaluable", "Lcom/yandex/div/evaluable/Evaluable;", "lastValidValue", "Ljava/lang/Object;", "rawValue", "getRawValue", "()Ljava/lang/String;", "evaluate", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "(Lcom/yandex/div/json/expressions/ExpressionResolver;)Ljava/lang/Object;", "getEvaluable", "getVariablesName", "", "logError", "", "e", "Lcom/yandex/div/json/ParsingException;", "observe", "Lcom/yandex/div/core/Disposable;", "callback", "tryResolve", "tryResolveOrUseLast", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class MutableExpression<R, T> extends Expression<T> {
        private final Function1<R, T> converter;
        private Evaluable evaluable;
        private final String expressionKey;
        private final Expression<T> fieldDefaultValue;
        private T lastValidValue;
        private final ParsingErrorLogger logger;
        private final String rawExpression;
        private final String rawValue;
        private final TypeHelper<T> typeHelper;
        private final ValueValidator<T> validator;

        public /* synthetic */ MutableExpression(String str, String str2, Function1 function1, ValueValidator valueValidator, ParsingErrorLogger parsingErrorLogger, TypeHelper typeHelper, Expression expression, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, function1, valueValidator, parsingErrorLogger, typeHelper, (i & 64) != 0 ? null : expression);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public MutableExpression(String expressionKey, String rawExpression, Function1<? super R, ? extends T> function1, ValueValidator<T> validator, ParsingErrorLogger logger, TypeHelper<T> typeHelper, Expression<T> expression) {
            Intrinsics.checkNotNullParameter(expressionKey, "expressionKey");
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            Intrinsics.checkNotNullParameter(validator, "validator");
            Intrinsics.checkNotNullParameter(logger, "logger");
            Intrinsics.checkNotNullParameter(typeHelper, "typeHelper");
            this.expressionKey = expressionKey;
            this.rawExpression = rawExpression;
            this.converter = function1;
            this.validator = validator;
            this.logger = logger;
            this.typeHelper = typeHelper;
            this.fieldDefaultValue = expression;
            this.rawValue = rawExpression;
        }

        @Override // com.yandex.div.json.expressions.Expression
        public String getRawValue() {
            return this.rawValue;
        }

        @Override // com.yandex.div.json.expressions.Expression
        public T evaluate(ExpressionResolver resolver) {
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            return tryResolveOrUseLast(resolver);
        }

        @Override // com.yandex.div.json.expressions.Expression
        public Disposable observe(final ExpressionResolver resolver, final Function1<? super T, Unit> callback) {
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(callback, "callback");
            try {
                List<String> variablesName = getVariablesName();
                if (variablesName.isEmpty()) {
                    return Disposable.NULL;
                }
                return resolver.subscribeToExpression(this.rawExpression, variablesName, new Function0<Unit>() { // from class: com.yandex.div.json.expressions.Expression$MutableExpression$observe$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        callback.invoke((T) this.evaluate(resolver));
                    }
                });
            } catch (Exception e) {
                logError(ParsingExceptionKt.resolveFailed(this.expressionKey, this.rawExpression, e), resolver);
                return Disposable.NULL;
            }
        }

        public final List<String> getVariablesName() {
            return getEvaluable().getVariables();
        }

        private final T tryResolveOrUseLast(ExpressionResolver resolver) {
            T tEvaluate;
            try {
                T tTryResolve = tryResolve(resolver);
                this.lastValidValue = tTryResolve;
                return tTryResolve;
            } catch (ParsingException e) {
                String message = e.getMessage();
                if (message != null && message.length() != 0) {
                    logError(e, resolver);
                }
                T t = this.lastValidValue;
                if (t != null) {
                    return t;
                }
                try {
                    Expression<T> expression = this.fieldDefaultValue;
                    if (expression != null && (tEvaluate = expression.evaluate(resolver)) != null) {
                        this.lastValidValue = tEvaluate;
                        return tEvaluate;
                    }
                    return this.typeHelper.getTypeDefault();
                } catch (ParsingException e2) {
                    logError(e2, resolver);
                    throw e2;
                }
            }
        }

        private final void logError(ParsingException e, ExpressionResolver resolver) {
            this.logger.logError(e);
            resolver.notifyResolveFailed(e);
        }

        private final T tryResolve(ExpressionResolver resolver) {
            T t = (T) resolver.get(this.expressionKey, this.rawExpression, getEvaluable(), this.converter, this.validator, this.typeHelper, this.logger);
            if (t == null) {
                throw ParsingExceptionKt.resolveFailed$default(this.expressionKey, this.rawExpression, null, 4, null);
            }
            if (this.typeHelper.isTypeValid(t)) {
                return t;
            }
            throw ParsingExceptionKt.typeMismatch$default(this.expressionKey, this.rawExpression, t, null, 8, null);
        }

        private final Evaluable getEvaluable() {
            Evaluable evaluable = this.evaluable;
            if (evaluable != null) {
                return evaluable;
            }
            try {
                Evaluable evaluableLazy = Evaluable.INSTANCE.lazy(this.rawExpression);
                this.evaluable = evaluableLazy;
                return evaluableLazy;
            } catch (EvaluableException e) {
                throw ParsingExceptionKt.resolveFailed(this.expressionKey, this.rawExpression, e);
            }
        }
    }

    /* JADX INFO: compiled from: Expression.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u0002H\u0005H\u0007¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\n"}, d2 = {"Lcom/yandex/div/json/expressions/Expression$Companion;", "", "()V", "constant", "Lcom/yandex/div/json/expressions/Expression;", "T", "value", "(Ljava/lang/Object;)Lcom/yandex/div/json/expressions/Expression;", "mayBeExpression", "", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final <T> Expression<T> constant(T value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof String) {
                return new StringConstantExpression((String) value, null, null, 6, null);
            }
            return new ConstantExpression(value);
        }

        @JvmStatic
        public final boolean mayBeExpression(Object value) {
            return (value instanceof String) && StringsKt.contains$default((CharSequence) value, (CharSequence) "@{", false, 2, (Object) null);
        }
    }
}
