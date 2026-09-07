package com.yandex.div.core.expression;

import com.yandex.div.core.Disposable;
import com.yandex.div.core.ObserverList;
import com.yandex.div.core.expression.variables.ConstantsProvider;
import com.yandex.div.core.expression.variables.VariableAndConstantController;
import com.yandex.div.core.expression.variables.VariableController;
import com.yandex.div.core.view2.errors.ErrorCollector;
import com.yandex.div.data.Variable;
import com.yandex.div.evaluable.Evaluable;
import com.yandex.div.evaluable.EvaluableException;
import com.yandex.div.evaluable.EvaluationContext;
import com.yandex.div.evaluable.Evaluator;
import com.yandex.div.evaluable.FunctionProvider;
import com.yandex.div.evaluable.MissingVariableException;
import com.yandex.div.internal.parser.TypeHelper;
import com.yandex.div.internal.parser.ValueValidator;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.ParsingExceptionKt;
import com.yandex.div.json.ParsingExceptionReason;
import com.yandex.div.json.expressions.ExpressionResolver;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ExpressionResolverImpl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001JB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0085\u0001\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001d\"\b\b\u0001\u0010\u001c*\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2*\u0010\"\u001a&\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u0001H\u001c\u0018\u00010#j\u0012\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u0001H\u001c\u0018\u0001`$2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u001c0&2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u001c0(2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0002\u0010+J'\u0010,\u001a\u0002H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0002¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u000200H\u0016J\u0011\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u000203H\u0086\u0002Jm\u00104\u001a\u0004\u0018\u0001H\u001c\"\u0004\b\u0000\u0010\u001d\"\u0004\b\u0001\u0010\u001c2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2*\u0010\"\u001a&\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u0001H\u001c\u0018\u00010#j\u0012\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u0001H\u001c\u0018\u0001`$2\u0006\u00105\u001a\u0002H\u001d2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u001c0(H\u0002¢\u0006\u0002\u00106J9\u00107\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u001c2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u001c0&2\u0006\u00108\u001a\u0002H\u001cH\u0002¢\u0006\u0002\u00109J\r\u0010:\u001a\u00020\u0012H\u0000¢\u0006\u0002\b;J,\u0010<\u001a\u00020=2\u0006\u0010\u001f\u001a\u00020\r2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\r0?2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0012\u0010A\u001a\u0004\u0018\u00010\r2\u0006\u0010/\u001a\u00020BH\u0002J\u0081\u0001\u0010C\u001a\u0002H\u001c\"\b\b\u0000\u0010\u001d*\u00020\u000e\"\b\b\u0001\u0010\u001c*\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2*\u0010\"\u001a&\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u0001H\u001c\u0018\u00010#j\u0012\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u0001H\u001c\u0018\u0001`$2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u001c0&2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u001c0(H\u0002¢\u0006\u0002\u0010DJ\u0018\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020IR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00100\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/yandex/div/core/expression/ExpressionResolverImpl;", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "variableController", "Lcom/yandex/div/core/expression/variables/VariableController;", "evaluator", "Lcom/yandex/div/evaluable/Evaluator;", "errorCollector", "Lcom/yandex/div/core/view2/errors/ErrorCollector;", "onCreateCallback", "Lcom/yandex/div/core/expression/ExpressionResolverImpl$OnCreateCallback;", "(Lcom/yandex/div/core/expression/variables/VariableController;Lcom/yandex/div/evaluable/Evaluator;Lcom/yandex/div/core/view2/errors/ErrorCollector;Lcom/yandex/div/core/expression/ExpressionResolverImpl$OnCreateCallback;)V", "evaluationsCache", "", "", "", "expressionObservers", "Lcom/yandex/div/core/ObserverList;", "Lkotlin/Function0;", "", "suppressMissingVariableException", "", "getSuppressMissingVariableException", "()Z", "setSuppressMissingVariableException", "(Z)V", "varToExpressions", "", "get", "T", "R", "expressionKey", "rawExpression", "evaluable", "Lcom/yandex/div/evaluable/Evaluable;", "converter", "Lkotlin/Function1;", "Lcom/yandex/div/internal/parser/Converter;", "validator", "Lcom/yandex/div/internal/parser/ValueValidator;", "fieldType", "Lcom/yandex/div/internal/parser/TypeHelper;", "logger", "Lcom/yandex/div/json/ParsingErrorLogger;", "(Ljava/lang/String;Ljava/lang/String;Lcom/yandex/div/evaluable/Evaluable;Lkotlin/jvm/functions/Function1;Lcom/yandex/div/internal/parser/ValueValidator;Lcom/yandex/div/internal/parser/TypeHelper;Lcom/yandex/div/json/ParsingErrorLogger;)Ljava/lang/Object;", "getEvaluationResult", "(Ljava/lang/String;Lcom/yandex/div/evaluable/Evaluable;)Ljava/lang/Object;", "notifyResolveFailed", "e", "Lcom/yandex/div/json/ParsingException;", "plus", "constants", "Lcom/yandex/div/core/expression/variables/ConstantsProvider;", "safeConvert", "rawValue", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lcom/yandex/div/internal/parser/TypeHelper;)Ljava/lang/Object;", "safeValidate", "convertedValue", "(Ljava/lang/String;Ljava/lang/String;Lcom/yandex/div/internal/parser/ValueValidator;Ljava/lang/Object;)V", "subscribeOnVariables", "subscribeOnVariables$div_release", "subscribeToExpression", "Lcom/yandex/div/core/Disposable;", "variableNames", "", "callback", "tryGetMissingVariableName", "Lcom/yandex/div/evaluable/EvaluableException;", "tryResolve", "(Ljava/lang/String;Ljava/lang/String;Lcom/yandex/div/evaluable/Evaluable;Lkotlin/jvm/functions/Function1;Lcom/yandex/div/internal/parser/ValueValidator;Lcom/yandex/div/internal/parser/TypeHelper;)Ljava/lang/Object;", "validateItemBuilderDataElement", "Lorg/json/JSONObject;", "element", "index", "", "OnCreateCallback", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ExpressionResolverImpl implements ExpressionResolver {
    private final ErrorCollector errorCollector;
    private final Map<String, Object> evaluationsCache;
    private final Evaluator evaluator;
    private final Map<String, ObserverList<Function0<Unit>>> expressionObservers;
    private final OnCreateCallback onCreateCallback;
    private boolean suppressMissingVariableException;
    private final Map<String, Set<String>> varToExpressions;
    private final VariableController variableController;

    /* JADX INFO: compiled from: ExpressionResolverImpl.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/expression/ExpressionResolverImpl$OnCreateCallback;", "", "onCreate", "", "resolver", "Lcom/yandex/div/core/expression/ExpressionResolverImpl;", "variableController", "Lcom/yandex/div/core/expression/variables/VariableController;", "functionProvider", "Lcom/yandex/div/core/expression/FunctionProviderDecorator;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface OnCreateCallback {
        void onCreate(ExpressionResolverImpl resolver, VariableController variableController, FunctionProviderDecorator functionProvider);
    }

    public ExpressionResolverImpl(VariableController variableController, Evaluator evaluator, ErrorCollector errorCollector, OnCreateCallback onCreateCallback) {
        Intrinsics.checkNotNullParameter(variableController, "variableController");
        Intrinsics.checkNotNullParameter(evaluator, "evaluator");
        Intrinsics.checkNotNullParameter(errorCollector, "errorCollector");
        Intrinsics.checkNotNullParameter(onCreateCallback, "onCreateCallback");
        this.variableController = variableController;
        this.evaluator = evaluator;
        this.errorCollector = errorCollector;
        this.onCreateCallback = onCreateCallback;
        this.evaluationsCache = new LinkedHashMap();
        this.varToExpressions = new LinkedHashMap();
        this.expressionObservers = new LinkedHashMap();
        FunctionProvider functionProvider = evaluator.getEvaluationContext().getFunctionProvider();
        Intrinsics.checkNotNull(functionProvider, "null cannot be cast to non-null type com.yandex.div.core.expression.FunctionProviderDecorator");
        onCreateCallback.onCreate(this, variableController, (FunctionProviderDecorator) functionProvider);
    }

    public final boolean getSuppressMissingVariableException() {
        return this.suppressMissingVariableException;
    }

    public final void setSuppressMissingVariableException(boolean z) {
        this.suppressMissingVariableException = z;
    }

    @Override // com.yandex.div.json.expressions.ExpressionResolver
    public <R, T> T get(String expressionKey, String rawExpression, Evaluable evaluable, Function1<? super R, ? extends T> converter, ValueValidator<T> validator, TypeHelper<T> fieldType, ParsingErrorLogger logger) {
        Intrinsics.checkNotNullParameter(expressionKey, "expressionKey");
        Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
        Intrinsics.checkNotNullParameter(evaluable, "evaluable");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(fieldType, "fieldType");
        Intrinsics.checkNotNullParameter(logger, "logger");
        try {
            return (T) tryResolve(expressionKey, rawExpression, evaluable, converter, validator, fieldType);
        } catch (ParsingException e) {
            if (e.getReason() == ParsingExceptionReason.MISSING_VARIABLE) {
                if (this.suppressMissingVariableException) {
                    throw ParsingExceptionKt.getSILENT_PARSING_EXCEPTION();
                }
                throw e;
            }
            logger.logError(e);
            this.errorCollector.logError(e);
            return (T) tryResolve(expressionKey, rawExpression, evaluable, converter, validator, fieldType);
        }
    }

    private final <R, T> T tryResolve(String expressionKey, String rawExpression, Evaluable evaluable, Function1<? super R, ? extends T> converter, ValueValidator<T> validator, TypeHelper<T> fieldType) {
        try {
            T t = (T) getEvaluationResult(rawExpression, evaluable);
            if (fieldType.isTypeValid(t)) {
                Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of com.yandex.div.core.expression.ExpressionResolverImpl.tryResolve");
            } else {
                Object objSafeConvert = safeConvert(expressionKey, rawExpression, converter, t, fieldType);
                if (objSafeConvert == null) {
                    throw ParsingExceptionKt.invalidValue(expressionKey, rawExpression, t);
                }
                t = (T) objSafeConvert;
            }
            safeValidate(expressionKey, rawExpression, validator, t);
            return t;
        } catch (EvaluableException e) {
            String strTryGetMissingVariableName = tryGetMissingVariableName(e);
            if (strTryGetMissingVariableName != null) {
                throw ParsingExceptionKt.missingVariable(expressionKey, rawExpression, strTryGetMissingVariableName, e);
            }
            throw ParsingExceptionKt.resolveFailed(expressionKey, rawExpression, e);
        }
    }

    private final <R> R getEvaluationResult(String rawExpression, Evaluable evaluable) {
        R r = (R) this.evaluationsCache.get(rawExpression);
        if (r == null) {
            r = (R) this.evaluator.eval(evaluable);
            if (evaluable.getIsCacheable()) {
                for (String str : evaluable.getVariables()) {
                    Map<String, Set<String>> map = this.varToExpressions;
                    LinkedHashSet linkedHashSet = map.get(str);
                    if (linkedHashSet == null) {
                        linkedHashSet = new LinkedHashSet();
                        map.put(str, linkedHashSet);
                    }
                    linkedHashSet.add(rawExpression);
                }
                this.evaluationsCache.put(rawExpression, r);
            }
        }
        return r;
    }

    private final String tryGetMissingVariableName(EvaluableException e) {
        if (e instanceof MissingVariableException) {
            return ((MissingVariableException) e).getVariableName();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    private final <R, T> T safeConvert(String expressionKey, String rawExpression, Function1<? super R, ? extends T> converter, R rawValue, TypeHelper<T> fieldType) {
        ?? Invoke = rawValue;
        if (converter != null) {
            try {
                Invoke = converter.invoke(rawValue);
            } catch (ClassCastException e) {
                throw ParsingExceptionKt.typeMismatch(expressionKey, rawExpression, rawValue, e);
            } catch (Exception e2) {
                throw ParsingExceptionKt.invalidValue(expressionKey, rawExpression, rawValue, e2);
            }
        } else if (rawValue == 0) {
            Invoke = (T) null;
        }
        return safeConvert$fieldAwaitsStringButValueNotConverted(fieldType, (Object) Invoke) ? (T) String.valueOf((Object) Invoke) : (T) Invoke;
    }

    private static final <T> boolean safeConvert$fieldAwaitsStringButValueNotConverted(TypeHelper<T> typeHelper, T t) {
        return (t == null || !(typeHelper.getTypeDefault() instanceof String) || typeHelper.isTypeValid(t)) ? false : true;
    }

    private final <T> void safeValidate(String expressionKey, String rawExpression, ValueValidator<T> validator, T convertedValue) {
        try {
            if (validator.isValid(convertedValue)) {
            } else {
                throw ParsingExceptionKt.invalidValue(rawExpression, convertedValue);
            }
        } catch (ClassCastException e) {
            throw ParsingExceptionKt.typeMismatch(expressionKey, rawExpression, convertedValue, e);
        }
    }

    @Override // com.yandex.div.json.expressions.ExpressionResolver
    public void notifyResolveFailed(ParsingException e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.errorCollector.logError(e);
    }

    @Override // com.yandex.div.json.expressions.ExpressionResolver
    public Disposable subscribeToExpression(final String rawExpression, List<String> variableNames, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
        Intrinsics.checkNotNullParameter(variableNames, "variableNames");
        Intrinsics.checkNotNullParameter(callback, "callback");
        for (String str : variableNames) {
            Map<String, Set<String>> map = this.varToExpressions;
            LinkedHashSet linkedHashSet = map.get(str);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
                map.put(str, linkedHashSet);
            }
            linkedHashSet.add(rawExpression);
        }
        Map<String, ObserverList<Function0<Unit>>> map2 = this.expressionObservers;
        ObserverList<Function0<Unit>> observerList = map2.get(rawExpression);
        if (observerList == null) {
            observerList = new ObserverList<>();
            map2.put(rawExpression, observerList);
        }
        observerList.addObserver(callback);
        return new Disposable() { // from class: com.yandex.div.core.expression.ExpressionResolverImpl$$ExternalSyntheticLambda0
            @Override // com.yandex.div.core.Disposable, java.lang.AutoCloseable, java.io.Closeable
            public final void close() {
                ExpressionResolverImpl.subscribeToExpression$lambda$7(this.f$0, rawExpression, callback);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void subscribeToExpression$lambda$7(ExpressionResolverImpl this$0, String rawExpression, Function0 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rawExpression, "$rawExpression");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ObserverList<Function0<Unit>> observerList = this$0.expressionObservers.get(rawExpression);
        if (observerList != null) {
            observerList.removeObserver(callback);
        }
    }

    public final void subscribeOnVariables$div_release() {
        this.variableController.setOnAnyVariableChangeCallback(new Function1<Variable, Unit>() { // from class: com.yandex.div.core.expression.ExpressionResolverImpl$subscribeOnVariables$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Variable variable) {
                invoke2(variable);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Variable v) {
                Intrinsics.checkNotNullParameter(v, "v");
                Set set = (Set) this.this$0.varToExpressions.get(v.getName());
                List<String> list = set != null ? CollectionsKt.toList(set) : null;
                if (list != null) {
                    ExpressionResolverImpl expressionResolverImpl = this.this$0;
                    for (String str : list) {
                        expressionResolverImpl.evaluationsCache.remove(str);
                        ObserverList observerList = (ObserverList) expressionResolverImpl.expressionObservers.get(str);
                        if (observerList != null) {
                            Iterator<E> it = observerList.iterator();
                            while (it.hasNext()) {
                                ((Function0) it.next()).invoke();
                            }
                        }
                    }
                }
            }
        });
    }

    public final ExpressionResolverImpl plus(ConstantsProvider constants) {
        Intrinsics.checkNotNullParameter(constants, "constants");
        VariableAndConstantController variableAndConstantController = new VariableAndConstantController(this.variableController, constants);
        return new ExpressionResolverImpl(variableAndConstantController, new Evaluator(new EvaluationContext(variableAndConstantController, this.evaluator.getEvaluationContext().getStoredValueProvider(), this.evaluator.getEvaluationContext().getFunctionProvider(), this.evaluator.getEvaluationContext().getWarningSender())), this.errorCollector, this.onCreateCallback);
    }

    public final JSONObject validateItemBuilderDataElement(Object element, int index) {
        Intrinsics.checkNotNullParameter(element, "element");
        JSONObject jSONObject = element instanceof JSONObject ? (JSONObject) element : null;
        if (jSONObject != null) {
            return jSONObject;
        }
        this.errorCollector.logError(ParsingExceptionKt.typeMismatch(index, element));
        return null;
    }
}
