package com.yandex.div.evaluable;

import com.yandex.div.evaluable.types.Color;
import com.yandex.div.evaluable.types.DateTime;
import com.yandex.div.evaluable.types.Url;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Function.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u0005¢\u0006\u0002\u0010\u0002J3\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H$ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ4\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001cJ\u001b\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004H\u0000¢\u0006\u0002\b\"JN\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\u000426\u0010#\u001a2\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b%\u0012\b\b\r\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b%\u0012\b\b\r\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\t0$H\u0002J\u001b\u0010(\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004H\u0000¢\u0006\u0002\b)J\b\u0010*\u001a\u00020\u000eH\u0016J\u0014\u0010+\u001a\u00020\t*\u00020\u00122\u0006\u0010&\u001a\u00020\u0012H\u0002R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000bR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006."}, d2 = {"Lcom/yandex/div/evaluable/Function;", "", "()V", "declaredArgs", "", "Lcom/yandex/div/evaluable/FunctionArgument;", "getDeclaredArgs", "()Ljava/util/List;", "hasVarArg", "", "getHasVarArg$div_evaluable", "()Z", "isPure", "name", "", "getName", "()Ljava/lang/String;", "resultType", "Lcom/yandex/div/evaluable/EvaluableType;", "getResultType", "()Lcom/yandex/div/evaluable/EvaluableType;", "evaluate", "evaluationContext", "Lcom/yandex/div/evaluable/EvaluationContext;", "expressionContext", "Lcom/yandex/div/evaluable/ExpressionContext;", "args", "evaluate-ex6DHhM", "(Lcom/yandex/div/evaluable/EvaluationContext;Lcom/yandex/div/evaluable/Evaluable;Ljava/util/List;)Ljava/lang/Object;", "invoke", "invoke-ex6DHhM", "matchesArguments", "Lcom/yandex/div/evaluable/Function$MatchResult;", "argTypes", "matchesArguments$div_evaluable", "matches", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "type", "declaredType", "matchesArgumentsWithCast", "matchesArgumentsWithCast$div_evaluable", "toString", "canCastTo", "Companion", "MatchResult", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class Function {
    public static final Function STUB = new Function() { // from class: com.yandex.div.evaluable.Function$Companion$STUB$1
        private final String name = "stub";
        private final List<FunctionArgument> declaredArgs = CollectionsKt.emptyList();
        private final EvaluableType resultType = EvaluableType.BOOLEAN;
        private final boolean isPure = true;

        @Override // com.yandex.div.evaluable.Function
        public String getName() {
            return this.name;
        }

        @Override // com.yandex.div.evaluable.Function
        public List<FunctionArgument> getDeclaredArgs() {
            return this.declaredArgs;
        }

        @Override // com.yandex.div.evaluable.Function
        public EvaluableType getResultType() {
            return this.resultType;
        }

        @Override // com.yandex.div.evaluable.Function
        /* JADX INFO: renamed from: isPure, reason: from getter */
        public boolean getIsPure() {
            return this.isPure;
        }

        @Override // com.yandex.div.evaluable.Function
        /* JADX INFO: renamed from: evaluate-ex6DHhM */
        protected Object mo6115evaluateex6DHhM(EvaluationContext evaluationContext, Evaluable expressionContext, List<? extends Object> args) {
            Intrinsics.checkNotNullParameter(evaluationContext, "evaluationContext");
            Intrinsics.checkNotNullParameter(expressionContext, "expressionContext");
            Intrinsics.checkNotNullParameter(args, "args");
            return true;
        }
    };

    /* JADX INFO: compiled from: Function.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EvaluableType.values().length];
            try {
                iArr[EvaluableType.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: evaluate-ex6DHhM */
    protected abstract Object mo6115evaluateex6DHhM(EvaluationContext evaluationContext, Evaluable expressionContext, List<? extends Object> args);

    public abstract List<FunctionArgument> getDeclaredArgs();

    public abstract String getName();

    public abstract EvaluableType getResultType();

    /* JADX INFO: renamed from: isPure */
    public abstract boolean getIsPure();

    /* JADX INFO: renamed from: invoke-ex6DHhM, reason: not valid java name */
    public final Object m6174invokeex6DHhM(EvaluationContext evaluationContext, Evaluable expressionContext, List<? extends Object> args) {
        EvaluableType evaluableType;
        EvaluableType evaluableType2;
        Intrinsics.checkNotNullParameter(evaluationContext, "evaluationContext");
        Intrinsics.checkNotNullParameter(expressionContext, "expressionContext");
        Intrinsics.checkNotNullParameter(args, "args");
        Object objMo6115evaluateex6DHhM = mo6115evaluateex6DHhM(evaluationContext, expressionContext, args);
        EvaluableType.Companion companion = EvaluableType.INSTANCE;
        boolean z = objMo6115evaluateex6DHhM instanceof Long;
        if (z) {
            evaluableType = EvaluableType.INTEGER;
        } else if (objMo6115evaluateex6DHhM instanceof Double) {
            evaluableType = EvaluableType.NUMBER;
        } else if (objMo6115evaluateex6DHhM instanceof Boolean) {
            evaluableType = EvaluableType.BOOLEAN;
        } else if (objMo6115evaluateex6DHhM instanceof String) {
            evaluableType = EvaluableType.STRING;
        } else if (objMo6115evaluateex6DHhM instanceof DateTime) {
            evaluableType = EvaluableType.DATETIME;
        } else if (objMo6115evaluateex6DHhM instanceof Color) {
            evaluableType = EvaluableType.COLOR;
        } else if (objMo6115evaluateex6DHhM instanceof Url) {
            evaluableType = EvaluableType.URL;
        } else if (objMo6115evaluateex6DHhM instanceof JSONObject) {
            evaluableType = EvaluableType.DICT;
        } else {
            if (!(objMo6115evaluateex6DHhM instanceof JSONArray)) {
                if (objMo6115evaluateex6DHhM == null) {
                    throw new EvaluableException("Unable to find type for null", null, 2, null);
                }
                StringBuilder sb = new StringBuilder("Unable to find type for ");
                Intrinsics.checkNotNull(objMo6115evaluateex6DHhM);
                throw new EvaluableException(sb.append(objMo6115evaluateex6DHhM.getClass().getName()).toString(), null, 2, null);
            }
            evaluableType = EvaluableType.ARRAY;
        }
        if (evaluableType == getResultType()) {
            return objMo6115evaluateex6DHhM;
        }
        StringBuilder sbAppend = new StringBuilder("Function ").append(this).append(" returned ");
        EvaluableType.Companion companion2 = EvaluableType.INSTANCE;
        if (z) {
            evaluableType2 = EvaluableType.INTEGER;
        } else if (objMo6115evaluateex6DHhM instanceof Double) {
            evaluableType2 = EvaluableType.NUMBER;
        } else if (objMo6115evaluateex6DHhM instanceof Boolean) {
            evaluableType2 = EvaluableType.BOOLEAN;
        } else if (objMo6115evaluateex6DHhM instanceof String) {
            evaluableType2 = EvaluableType.STRING;
        } else if (objMo6115evaluateex6DHhM instanceof DateTime) {
            evaluableType2 = EvaluableType.DATETIME;
        } else if (objMo6115evaluateex6DHhM instanceof Color) {
            evaluableType2 = EvaluableType.COLOR;
        } else if (objMo6115evaluateex6DHhM instanceof Url) {
            evaluableType2 = EvaluableType.URL;
        } else if (objMo6115evaluateex6DHhM instanceof JSONObject) {
            evaluableType2 = EvaluableType.DICT;
        } else {
            if (!(objMo6115evaluateex6DHhM instanceof JSONArray)) {
                if (objMo6115evaluateex6DHhM == null) {
                    throw new EvaluableException("Unable to find type for null", null, 2, null);
                }
                StringBuilder sb2 = new StringBuilder("Unable to find type for ");
                Intrinsics.checkNotNull(objMo6115evaluateex6DHhM);
                throw new EvaluableException(sb2.append(objMo6115evaluateex6DHhM.getClass().getName()).toString(), null, 2, null);
            }
            evaluableType2 = EvaluableType.ARRAY;
        }
        throw new EvaluableException(sbAppend.append(evaluableType2).append(", but ").append(getResultType()).append(" was expected.").toString(), null, 2, null);
    }

    public final MatchResult matchesArguments$div_evaluable(List<? extends EvaluableType> argTypes) {
        Intrinsics.checkNotNullParameter(argTypes, "argTypes");
        return matchesArguments(argTypes, new Function2<EvaluableType, EvaluableType, Boolean>() { // from class: com.yandex.div.evaluable.Function.matchesArguments.1
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(EvaluableType type, EvaluableType declaredType) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(declaredType, "declaredType");
                return Boolean.valueOf(type == declaredType);
            }
        });
    }

    public final MatchResult matchesArgumentsWithCast$div_evaluable(List<? extends EvaluableType> argTypes) {
        Intrinsics.checkNotNullParameter(argTypes, "argTypes");
        return matchesArguments(argTypes, new Function2<EvaluableType, EvaluableType, Boolean>() { // from class: com.yandex.div.evaluable.Function$matchesArgumentsWithCast$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(EvaluableType type, EvaluableType declaredType) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(declaredType, "declaredType");
                return Boolean.valueOf(type == declaredType || this.this$0.canCastTo(type, declaredType));
            }
        });
    }

    private final MatchResult matchesArguments(List<? extends EvaluableType> argTypes, Function2<? super EvaluableType, ? super EvaluableType, Boolean> matches) {
        int size = getDeclaredArgs().size();
        int size2 = getHasVarArg$div_evaluable() ? Integer.MAX_VALUE : getDeclaredArgs().size();
        if (argTypes.size() < size || argTypes.size() > size2) {
            return new MatchResult.ArgCountMismatch(size);
        }
        int size3 = argTypes.size();
        for (int i = 0; i < size3; i++) {
            EvaluableType type = getDeclaredArgs().get(RangesKt.coerceAtMost(i, CollectionsKt.getLastIndex(getDeclaredArgs()))).getType();
            if (!matches.invoke(argTypes.get(i), type).booleanValue()) {
                return new MatchResult.ArgTypeMismatch(type, argTypes.get(i));
            }
        }
        return MatchResult.Ok.INSTANCE;
    }

    public final boolean getHasVarArg$div_evaluable() {
        FunctionArgument functionArgument = (FunctionArgument) CollectionsKt.lastOrNull((List) getDeclaredArgs());
        if (functionArgument != null) {
            return functionArgument.isVariadic();
        }
        return false;
    }

    public String toString() {
        return CollectionsKt.joinToString$default(getDeclaredArgs(), null, getName() + '(', ")", 0, null, new Function1<FunctionArgument, CharSequence>() { // from class: com.yandex.div.evaluable.Function.toString.1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(FunctionArgument arg) {
                Intrinsics.checkNotNullParameter(arg, "arg");
                return arg.isVariadic() ? "vararg " + arg.getType() : arg.getType().toString();
            }
        }, 25, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canCastTo(EvaluableType evaluableType, EvaluableType evaluableType2) {
        return evaluableType == EvaluableType.INTEGER && WhenMappings.$EnumSwitchMapping$0[evaluableType2.ordinal()] == 1;
    }

    /* JADX INFO: compiled from: Function.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/yandex/div/evaluable/Function$MatchResult;", "", "()V", "ArgCountMismatch", "ArgTypeMismatch", "Ok", "Lcom/yandex/div/evaluable/Function$MatchResult$ArgCountMismatch;", "Lcom/yandex/div/evaluable/Function$MatchResult$ArgTypeMismatch;", "Lcom/yandex/div/evaluable/Function$MatchResult$Ok;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class MatchResult {
        public /* synthetic */ MatchResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: Function.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yandex/div/evaluable/Function$MatchResult$Ok;", "Lcom/yandex/div/evaluable/Function$MatchResult;", "()V", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Ok extends MatchResult {
            public static final Ok INSTANCE = new Ok();

            private Ok() {
                super(null);
            }
        }

        private MatchResult() {
        }

        /* JADX INFO: compiled from: Function.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/evaluable/Function$MatchResult$ArgCountMismatch;", "Lcom/yandex/div/evaluable/Function$MatchResult;", "expected", "", "(I)V", "getExpected", "()I", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class ArgCountMismatch extends MatchResult {
            private final int expected;

            public ArgCountMismatch(int i) {
                super(null);
                this.expected = i;
            }

            public final int getExpected() {
                return this.expected;
            }
        }

        /* JADX INFO: compiled from: Function.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/yandex/div/evaluable/Function$MatchResult$ArgTypeMismatch;", "Lcom/yandex/div/evaluable/Function$MatchResult;", "expected", "Lcom/yandex/div/evaluable/EvaluableType;", "actual", "(Lcom/yandex/div/evaluable/EvaluableType;Lcom/yandex/div/evaluable/EvaluableType;)V", "getActual", "()Lcom/yandex/div/evaluable/EvaluableType;", "getExpected", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class ArgTypeMismatch extends MatchResult {
            private final EvaluableType actual;
            private final EvaluableType expected;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ArgTypeMismatch(EvaluableType expected, EvaluableType actual) {
                super(null);
                Intrinsics.checkNotNullParameter(expected, "expected");
                Intrinsics.checkNotNullParameter(actual, "actual");
                this.expected = expected;
                this.actual = actual;
            }

            public final EvaluableType getActual() {
                return this.actual;
            }

            public final EvaluableType getExpected() {
                return this.expected;
            }
        }
    }
}
