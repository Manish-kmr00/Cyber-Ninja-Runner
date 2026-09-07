package com.yandex.div.evaluable;

import com.yandex.div.evaluable.internal.Parser;
import com.yandex.div.evaluable.internal.Token;
import com.yandex.div.evaluable.internal.Tokenizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Evaluable.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\b&\u0018\u0000 \u00192\u00020\u0001:\u000b\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u0006J\u0015\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H$J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006#"}, d2 = {"Lcom/yandex/div/evaluable/Evaluable;", "", "rawExpr", "", "(Ljava/lang/String;)V", "evalCalled", "", "isCacheable", "getRawExpr", "()Ljava/lang/String;", "variables", "", "getVariables", "()Ljava/util/List;", "checkIsCacheable", "eval", "evaluator", "Lcom/yandex/div/evaluable/Evaluator;", "eval$div_evaluable", "evalImpl", "updateIsCacheable", "", "value", "updateIsCacheable$div_evaluable", "Binary", "Companion", "FunctionCall", "Lazy", "MethodCall", "StringTemplate", "Ternary", "Try", "Unary", "Value", "Variable", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class Evaluable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean evalCalled;
    private boolean isCacheable;
    private final String rawExpr;

    @JvmStatic
    public static final Evaluable lazy(String str) {
        return INSTANCE.lazy(str);
    }

    @JvmStatic
    public static final Evaluable prepare(String str) {
        return INSTANCE.prepare(str);
    }

    protected abstract Object evalImpl(Evaluator evaluator) throws EvaluableException;

    public abstract List<String> getVariables();

    public Evaluable(String rawExpr) {
        Intrinsics.checkNotNullParameter(rawExpr, "rawExpr");
        this.rawExpr = rawExpr;
        this.isCacheable = true;
    }

    public final String getRawExpr() {
        return this.rawExpr;
    }

    public final void updateIsCacheable$div_evaluable(boolean value) {
        this.isCacheable = this.isCacheable && value;
    }

    /* JADX INFO: renamed from: checkIsCacheable, reason: from getter */
    public final boolean getIsCacheable() {
        return this.isCacheable;
    }

    public final Object eval$div_evaluable(Evaluator evaluator) throws EvaluableException {
        Intrinsics.checkNotNullParameter(evaluator, "evaluator");
        Object objEvalImpl = evalImpl(evaluator);
        this.evalCalled = true;
        return objEvalImpl;
    }

    /* JADX INFO: compiled from: Evaluable.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/evaluable/Evaluable$Lazy;", "Lcom/yandex/div/evaluable/Evaluable;", "expr", "", "(Ljava/lang/String;)V", "expression", "tokens", "", "Lcom/yandex/div/evaluable/internal/Token;", "variables", "getVariables", "()Ljava/util/List;", "evalImpl", "", "evaluator", "Lcom/yandex/div/evaluable/Evaluator;", "toString", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Lazy extends Evaluable {
        private final String expr;
        private Evaluable expression;
        private final List<Token> tokens;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Lazy(String expr) {
            super(expr);
            Intrinsics.checkNotNullParameter(expr, "expr");
            this.expr = expr;
            this.tokens = Tokenizer.INSTANCE.tokenize(expr);
        }

        @Override // com.yandex.div.evaluable.Evaluable
        public List<String> getVariables() {
            Evaluable evaluable = this.expression;
            if (evaluable != null) {
                if (evaluable == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("expression");
                    evaluable = null;
                }
                return evaluable.getVariables();
            }
            List<Token> list = this.tokens;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (obj instanceof Token.Operand.Variable) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(((Token.Operand.Variable) it.next()).m6212unboximpl());
            }
            return arrayList3;
        }

        @Override // com.yandex.div.evaluable.Evaluable
        protected Object evalImpl(Evaluator evaluator) {
            Intrinsics.checkNotNullParameter(evaluator, "evaluator");
            if (this.expression == null) {
                this.expression = Parser.INSTANCE.parse(this.tokens, getRawExpr());
            }
            Evaluable evaluable = this.expression;
            Evaluable evaluable2 = null;
            if (evaluable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expression");
                evaluable = null;
            }
            Object objEval$div_evaluable = evaluable.eval$div_evaluable(evaluator);
            Evaluable evaluable3 = this.expression;
            if (evaluable3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expression");
            } else {
                evaluable2 = evaluable3;
            }
            updateIsCacheable$div_evaluable(evaluable2.isCacheable);
            return objEval$div_evaluable;
        }

        /* JADX INFO: renamed from: toString, reason: from getter */
        public String getExpr() {
            return this.expr;
        }
    }

    /* JADX INFO: compiled from: Evaluable.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\b\u0010\u001f\u001a\u00020\u0006H\u0016R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/yandex/div/evaluable/Evaluable$Unary;", "Lcom/yandex/div/evaluable/Evaluable;", "token", "Lcom/yandex/div/evaluable/internal/Token$Operator;", "expression", "rawExpression", "", "(Lcom/yandex/div/evaluable/internal/Token$Operator;Lcom/yandex/div/evaluable/Evaluable;Ljava/lang/String;)V", "getExpression", "()Lcom/yandex/div/evaluable/Evaluable;", "getRawExpression", "()Ljava/lang/String;", "getToken", "()Lcom/yandex/div/evaluable/internal/Token$Operator;", "variables", "", "getVariables", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "evalImpl", "evaluator", "Lcom/yandex/div/evaluable/Evaluator;", "hashCode", "", "toString", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Unary extends Evaluable {
        private final Evaluable expression;
        private final String rawExpression;
        private final Token.Operator token;
        private final List<String> variables;

        public static /* synthetic */ Unary copy$default(Unary unary, Token.Operator operator, Evaluable evaluable, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                operator = unary.token;
            }
            if ((i & 2) != 0) {
                evaluable = unary.expression;
            }
            if ((i & 4) != 0) {
                str = unary.rawExpression;
            }
            return unary.copy(operator, evaluable, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Token.Operator getToken() {
            return this.token;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Evaluable getExpression() {
            return this.expression;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getRawExpression() {
            return this.rawExpression;
        }

        public final Unary copy(Token.Operator token, Evaluable expression, String rawExpression) {
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(expression, "expression");
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            return new Unary(token, expression, rawExpression);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Unary)) {
                return false;
            }
            Unary unary = (Unary) other;
            return Intrinsics.areEqual(this.token, unary.token) && Intrinsics.areEqual(this.expression, unary.expression) && Intrinsics.areEqual(this.rawExpression, unary.rawExpression);
        }

        public int hashCode() {
            return (((this.token.hashCode() * 31) + this.expression.hashCode()) * 31) + this.rawExpression.hashCode();
        }

        public final Token.Operator getToken() {
            return this.token;
        }

        public final Evaluable getExpression() {
            return this.expression;
        }

        public final String getRawExpression() {
            return this.rawExpression;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Unary(Token.Operator token, Evaluable expression, String rawExpression) {
            super(rawExpression);
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(expression, "expression");
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            this.token = token;
            this.expression = expression;
            this.rawExpression = rawExpression;
            this.variables = expression.getVariables();
        }

        @Override // com.yandex.div.evaluable.Evaluable
        public List<String> getVariables() {
            return this.variables;
        }

        @Override // com.yandex.div.evaluable.Evaluable
        protected Object evalImpl(Evaluator evaluator) {
            Intrinsics.checkNotNullParameter(evaluator, "evaluator");
            return evaluator.evalUnary$div_evaluable(this);
        }

        public String toString() {
            return new StringBuilder().append(this.token).append(this.expression).toString();
        }
    }

    /* JADX INFO: compiled from: Evaluable.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\t\u0010 \u001a\u00020!HÖ\u0001J\b\u0010\"\u001a\u00020\u0007H\u0016R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lcom/yandex/div/evaluable/Evaluable$Binary;", "Lcom/yandex/div/evaluable/Evaluable;", "token", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary;", "left", "right", "rawExpression", "", "(Lcom/yandex/div/evaluable/internal/Token$Operator$Binary;Lcom/yandex/div/evaluable/Evaluable;Lcom/yandex/div/evaluable/Evaluable;Ljava/lang/String;)V", "getLeft", "()Lcom/yandex/div/evaluable/Evaluable;", "getRawExpression", "()Ljava/lang/String;", "getRight", "getToken", "()Lcom/yandex/div/evaluable/internal/Token$Operator$Binary;", "variables", "", "getVariables", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "evalImpl", "evaluator", "Lcom/yandex/div/evaluable/Evaluator;", "hashCode", "", "toString", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Binary extends Evaluable {
        private final Evaluable left;
        private final String rawExpression;
        private final Evaluable right;
        private final Token.Operator.Binary token;
        private final List<String> variables;

        public static /* synthetic */ Binary copy$default(Binary binary, Token.Operator.Binary binary2, Evaluable evaluable, Evaluable evaluable2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                binary2 = binary.token;
            }
            if ((i & 2) != 0) {
                evaluable = binary.left;
            }
            if ((i & 4) != 0) {
                evaluable2 = binary.right;
            }
            if ((i & 8) != 0) {
                str = binary.rawExpression;
            }
            return binary.copy(binary2, evaluable, evaluable2, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Token.Operator.Binary getToken() {
            return this.token;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Evaluable getLeft() {
            return this.left;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Evaluable getRight() {
            return this.right;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getRawExpression() {
            return this.rawExpression;
        }

        public final Binary copy(Token.Operator.Binary token, Evaluable left, Evaluable right, String rawExpression) {
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(left, "left");
            Intrinsics.checkNotNullParameter(right, "right");
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            return new Binary(token, left, right, rawExpression);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Binary)) {
                return false;
            }
            Binary binary = (Binary) other;
            return Intrinsics.areEqual(this.token, binary.token) && Intrinsics.areEqual(this.left, binary.left) && Intrinsics.areEqual(this.right, binary.right) && Intrinsics.areEqual(this.rawExpression, binary.rawExpression);
        }

        public int hashCode() {
            return (((((this.token.hashCode() * 31) + this.left.hashCode()) * 31) + this.right.hashCode()) * 31) + this.rawExpression.hashCode();
        }

        public final Token.Operator.Binary getToken() {
            return this.token;
        }

        public final Evaluable getLeft() {
            return this.left;
        }

        public final Evaluable getRight() {
            return this.right;
        }

        public final String getRawExpression() {
            return this.rawExpression;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Binary(Token.Operator.Binary token, Evaluable left, Evaluable right, String rawExpression) {
            super(rawExpression);
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(left, "left");
            Intrinsics.checkNotNullParameter(right, "right");
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            this.token = token;
            this.left = left;
            this.right = right;
            this.rawExpression = rawExpression;
            this.variables = CollectionsKt.plus((Collection) left.getVariables(), (Iterable) right.getVariables());
        }

        @Override // com.yandex.div.evaluable.Evaluable
        public List<String> getVariables() {
            return this.variables;
        }

        @Override // com.yandex.div.evaluable.Evaluable
        protected Object evalImpl(Evaluator evaluator) {
            Intrinsics.checkNotNullParameter(evaluator, "evaluator");
            return evaluator.evalBinary$div_evaluable(this);
        }

        public String toString() {
            return "(" + this.left + ' ' + this.token + ' ' + this.right + ')';
        }
    }

    /* JADX INFO: compiled from: Evaluable.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0001HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0014J\t\u0010#\u001a\u00020$HÖ\u0001J\b\u0010%\u001a\u00020\bH\u0016R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006&"}, d2 = {"Lcom/yandex/div/evaluable/Evaluable$Ternary;", "Lcom/yandex/div/evaluable/Evaluable;", "token", "Lcom/yandex/div/evaluable/internal/Token$Operator;", "firstExpression", "secondExpression", "thirdExpression", "rawExpression", "", "(Lcom/yandex/div/evaluable/internal/Token$Operator;Lcom/yandex/div/evaluable/Evaluable;Lcom/yandex/div/evaluable/Evaluable;Lcom/yandex/div/evaluable/Evaluable;Ljava/lang/String;)V", "getFirstExpression", "()Lcom/yandex/div/evaluable/Evaluable;", "getRawExpression", "()Ljava/lang/String;", "getSecondExpression", "getThirdExpression", "getToken", "()Lcom/yandex/div/evaluable/internal/Token$Operator;", "variables", "", "getVariables", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "evalImpl", "evaluator", "Lcom/yandex/div/evaluable/Evaluator;", "hashCode", "", "toString", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Ternary extends Evaluable {
        private final Evaluable firstExpression;
        private final String rawExpression;
        private final Evaluable secondExpression;
        private final Evaluable thirdExpression;
        private final Token.Operator token;
        private final List<String> variables;

        public static /* synthetic */ Ternary copy$default(Ternary ternary, Token.Operator operator, Evaluable evaluable, Evaluable evaluable2, Evaluable evaluable3, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                operator = ternary.token;
            }
            if ((i & 2) != 0) {
                evaluable = ternary.firstExpression;
            }
            Evaluable evaluable4 = evaluable;
            if ((i & 4) != 0) {
                evaluable2 = ternary.secondExpression;
            }
            Evaluable evaluable5 = evaluable2;
            if ((i & 8) != 0) {
                evaluable3 = ternary.thirdExpression;
            }
            Evaluable evaluable6 = evaluable3;
            if ((i & 16) != 0) {
                str = ternary.rawExpression;
            }
            return ternary.copy(operator, evaluable4, evaluable5, evaluable6, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Token.Operator getToken() {
            return this.token;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Evaluable getFirstExpression() {
            return this.firstExpression;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Evaluable getSecondExpression() {
            return this.secondExpression;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Evaluable getThirdExpression() {
            return this.thirdExpression;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getRawExpression() {
            return this.rawExpression;
        }

        public final Ternary copy(Token.Operator token, Evaluable firstExpression, Evaluable secondExpression, Evaluable thirdExpression, String rawExpression) {
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(firstExpression, "firstExpression");
            Intrinsics.checkNotNullParameter(secondExpression, "secondExpression");
            Intrinsics.checkNotNullParameter(thirdExpression, "thirdExpression");
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            return new Ternary(token, firstExpression, secondExpression, thirdExpression, rawExpression);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ternary)) {
                return false;
            }
            Ternary ternary = (Ternary) other;
            return Intrinsics.areEqual(this.token, ternary.token) && Intrinsics.areEqual(this.firstExpression, ternary.firstExpression) && Intrinsics.areEqual(this.secondExpression, ternary.secondExpression) && Intrinsics.areEqual(this.thirdExpression, ternary.thirdExpression) && Intrinsics.areEqual(this.rawExpression, ternary.rawExpression);
        }

        public int hashCode() {
            return (((((((this.token.hashCode() * 31) + this.firstExpression.hashCode()) * 31) + this.secondExpression.hashCode()) * 31) + this.thirdExpression.hashCode()) * 31) + this.rawExpression.hashCode();
        }

        public final Token.Operator getToken() {
            return this.token;
        }

        public final Evaluable getFirstExpression() {
            return this.firstExpression;
        }

        public final Evaluable getSecondExpression() {
            return this.secondExpression;
        }

        public final Evaluable getThirdExpression() {
            return this.thirdExpression;
        }

        public final String getRawExpression() {
            return this.rawExpression;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ternary(Token.Operator token, Evaluable firstExpression, Evaluable secondExpression, Evaluable thirdExpression, String rawExpression) {
            super(rawExpression);
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(firstExpression, "firstExpression");
            Intrinsics.checkNotNullParameter(secondExpression, "secondExpression");
            Intrinsics.checkNotNullParameter(thirdExpression, "thirdExpression");
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            this.token = token;
            this.firstExpression = firstExpression;
            this.secondExpression = secondExpression;
            this.thirdExpression = thirdExpression;
            this.rawExpression = rawExpression;
            this.variables = CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) firstExpression.getVariables(), (Iterable) secondExpression.getVariables()), (Iterable) thirdExpression.getVariables());
        }

        @Override // com.yandex.div.evaluable.Evaluable
        public List<String> getVariables() {
            return this.variables;
        }

        @Override // com.yandex.div.evaluable.Evaluable
        protected Object evalImpl(Evaluator evaluator) {
            Intrinsics.checkNotNullParameter(evaluator, "evaluator");
            return evaluator.evalTernary$div_evaluable(this);
        }

        public String toString() {
            return "(" + this.firstExpression + ' ' + Token.Operator.TernaryIf.INSTANCE + ' ' + this.secondExpression + ' ' + Token.Operator.TernaryElse.INSTANCE + ' ' + this.thirdExpression + ')';
        }
    }

    /* JADX INFO: compiled from: Evaluable.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\t\u0010 \u001a\u00020!HÖ\u0001J\b\u0010\"\u001a\u00020\u0007H\u0016R\u0011\u0010\u0005\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lcom/yandex/div/evaluable/Evaluable$Try;", "Lcom/yandex/div/evaluable/Evaluable;", "token", "Lcom/yandex/div/evaluable/internal/Token$Operator$Try;", "tryExpression", "fallbackExpression", "rawExpression", "", "(Lcom/yandex/div/evaluable/internal/Token$Operator$Try;Lcom/yandex/div/evaluable/Evaluable;Lcom/yandex/div/evaluable/Evaluable;Ljava/lang/String;)V", "getFallbackExpression", "()Lcom/yandex/div/evaluable/Evaluable;", "getRawExpression", "()Ljava/lang/String;", "getToken", "()Lcom/yandex/div/evaluable/internal/Token$Operator$Try;", "getTryExpression", "variables", "", "getVariables", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "evalImpl", "evaluator", "Lcom/yandex/div/evaluable/Evaluator;", "hashCode", "", "toString", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Try extends Evaluable {
        private final Evaluable fallbackExpression;
        private final String rawExpression;
        private final Token.Operator.Try token;
        private final Evaluable tryExpression;
        private final List<String> variables;

        public static /* synthetic */ Try copy$default(Try r0, Token.Operator.Try r1, Evaluable evaluable, Evaluable evaluable2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                r1 = r0.token;
            }
            if ((i & 2) != 0) {
                evaluable = r0.tryExpression;
            }
            if ((i & 4) != 0) {
                evaluable2 = r0.fallbackExpression;
            }
            if ((i & 8) != 0) {
                str = r0.rawExpression;
            }
            return r0.copy(r1, evaluable, evaluable2, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Token.Operator.Try getToken() {
            return this.token;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Evaluable getTryExpression() {
            return this.tryExpression;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Evaluable getFallbackExpression() {
            return this.fallbackExpression;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getRawExpression() {
            return this.rawExpression;
        }

        public final Try copy(Token.Operator.Try token, Evaluable tryExpression, Evaluable fallbackExpression, String rawExpression) {
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(tryExpression, "tryExpression");
            Intrinsics.checkNotNullParameter(fallbackExpression, "fallbackExpression");
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            return new Try(token, tryExpression, fallbackExpression, rawExpression);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Try)) {
                return false;
            }
            Try r5 = (Try) other;
            return Intrinsics.areEqual(this.token, r5.token) && Intrinsics.areEqual(this.tryExpression, r5.tryExpression) && Intrinsics.areEqual(this.fallbackExpression, r5.fallbackExpression) && Intrinsics.areEqual(this.rawExpression, r5.rawExpression);
        }

        public int hashCode() {
            return (((((this.token.hashCode() * 31) + this.tryExpression.hashCode()) * 31) + this.fallbackExpression.hashCode()) * 31) + this.rawExpression.hashCode();
        }

        public final Token.Operator.Try getToken() {
            return this.token;
        }

        public final Evaluable getTryExpression() {
            return this.tryExpression;
        }

        public final Evaluable getFallbackExpression() {
            return this.fallbackExpression;
        }

        public final String getRawExpression() {
            return this.rawExpression;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Try(Token.Operator.Try token, Evaluable tryExpression, Evaluable fallbackExpression, String rawExpression) {
            super(rawExpression);
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(tryExpression, "tryExpression");
            Intrinsics.checkNotNullParameter(fallbackExpression, "fallbackExpression");
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            this.token = token;
            this.tryExpression = tryExpression;
            this.fallbackExpression = fallbackExpression;
            this.rawExpression = rawExpression;
            this.variables = CollectionsKt.plus((Collection) tryExpression.getVariables(), (Iterable) fallbackExpression.getVariables());
        }

        @Override // com.yandex.div.evaluable.Evaluable
        public List<String> getVariables() {
            return this.variables;
        }

        @Override // com.yandex.div.evaluable.Evaluable
        protected Object evalImpl(Evaluator evaluator) {
            Intrinsics.checkNotNullParameter(evaluator, "evaluator");
            return evaluator.evalTry$div_evaluable(this);
        }

        public String toString() {
            return "(" + this.tryExpression + ' ' + this.token + ' ' + this.fallbackExpression + ')';
        }
    }

    /* JADX INFO: compiled from: Evaluable.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0007H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/yandex/div/evaluable/Evaluable$MethodCall;", "Lcom/yandex/div/evaluable/Evaluable;", "token", "Lcom/yandex/div/evaluable/internal/Token$Function;", "arguments", "", "rawExpression", "", "(Lcom/yandex/div/evaluable/internal/Token$Function;Ljava/util/List;Ljava/lang/String;)V", "getArguments", "()Ljava/util/List;", "getRawExpression", "()Ljava/lang/String;", "getToken", "()Lcom/yandex/div/evaluable/internal/Token$Function;", "variables", "getVariables", "component1", "component2", "component3", "copy", "equals", "", "other", "", "evalImpl", "evaluator", "Lcom/yandex/div/evaluable/Evaluator;", "hashCode", "", "toString", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class MethodCall extends Evaluable {
        private final List<Evaluable> arguments;
        private final String rawExpression;
        private final Token.Function token;
        private final List<String> variables;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MethodCall copy$default(MethodCall methodCall, Token.Function function, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                function = methodCall.token;
            }
            if ((i & 2) != 0) {
                list = methodCall.arguments;
            }
            if ((i & 4) != 0) {
                str = methodCall.rawExpression;
            }
            return methodCall.copy(function, list, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Token.Function getToken() {
            return this.token;
        }

        public final List<Evaluable> component2() {
            return this.arguments;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getRawExpression() {
            return this.rawExpression;
        }

        public final MethodCall copy(Token.Function token, List<? extends Evaluable> arguments, String rawExpression) {
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(arguments, "arguments");
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            return new MethodCall(token, arguments, rawExpression);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MethodCall)) {
                return false;
            }
            MethodCall methodCall = (MethodCall) other;
            return Intrinsics.areEqual(this.token, methodCall.token) && Intrinsics.areEqual(this.arguments, methodCall.arguments) && Intrinsics.areEqual(this.rawExpression, methodCall.rawExpression);
        }

        public int hashCode() {
            return (((this.token.hashCode() * 31) + this.arguments.hashCode()) * 31) + this.rawExpression.hashCode();
        }

        public final Token.Function getToken() {
            return this.token;
        }

        public final List<Evaluable> getArguments() {
            return this.arguments;
        }

        public final String getRawExpression() {
            return this.rawExpression;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public MethodCall(Token.Function token, List<? extends Evaluable> arguments, String rawExpression) {
            Object obj;
            super(rawExpression);
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(arguments, "arguments");
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            this.token = token;
            this.arguments = arguments;
            this.rawExpression = rawExpression;
            List<? extends Evaluable> list = arguments;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((Evaluable) it.next()).getVariables());
            }
            Iterator it2 = arrayList.iterator();
            if (it2.hasNext()) {
                Object next = it2.next();
                while (it2.hasNext()) {
                    next = CollectionsKt.plus((Collection) next, (Iterable) it2.next());
                }
                obj = next;
            } else {
                obj = null;
            }
            List<String> list2 = (List) obj;
            this.variables = list2 == null ? CollectionsKt.emptyList() : list2;
        }

        @Override // com.yandex.div.evaluable.Evaluable
        public List<String> getVariables() {
            return this.variables;
        }

        @Override // com.yandex.div.evaluable.Evaluable
        protected Object evalImpl(Evaluator evaluator) {
            Intrinsics.checkNotNullParameter(evaluator, "evaluator");
            return evaluator.evalMethodCall$div_evaluable(this);
        }

        public String toString() {
            String strJoinToString$default;
            if (this.arguments.size() > 1) {
                List<Evaluable> list = this.arguments;
                strJoinToString$default = CollectionsKt.joinToString$default(list.subList(1, list.size()), Token.Function.ArgumentDelimiter.INSTANCE.toString(), null, null, 0, null, null, 62, null);
            } else {
                strJoinToString$default = "";
            }
            return CollectionsKt.first((List) this.arguments) + '.' + this.token.getName() + '(' + strJoinToString$default + ')';
        }
    }

    /* JADX INFO: compiled from: Evaluable.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0007H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/yandex/div/evaluable/Evaluable$FunctionCall;", "Lcom/yandex/div/evaluable/Evaluable;", "token", "Lcom/yandex/div/evaluable/internal/Token$Function;", "arguments", "", "rawExpression", "", "(Lcom/yandex/div/evaluable/internal/Token$Function;Ljava/util/List;Ljava/lang/String;)V", "getArguments", "()Ljava/util/List;", "getRawExpression", "()Ljava/lang/String;", "getToken", "()Lcom/yandex/div/evaluable/internal/Token$Function;", "variables", "getVariables", "component1", "component2", "component3", "copy", "equals", "", "other", "", "evalImpl", "evaluator", "Lcom/yandex/div/evaluable/Evaluator;", "hashCode", "", "toString", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class FunctionCall extends Evaluable {
        private final List<Evaluable> arguments;
        private final String rawExpression;
        private final Token.Function token;
        private final List<String> variables;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FunctionCall copy$default(FunctionCall functionCall, Token.Function function, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                function = functionCall.token;
            }
            if ((i & 2) != 0) {
                list = functionCall.arguments;
            }
            if ((i & 4) != 0) {
                str = functionCall.rawExpression;
            }
            return functionCall.copy(function, list, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Token.Function getToken() {
            return this.token;
        }

        public final List<Evaluable> component2() {
            return this.arguments;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getRawExpression() {
            return this.rawExpression;
        }

        public final FunctionCall copy(Token.Function token, List<? extends Evaluable> arguments, String rawExpression) {
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(arguments, "arguments");
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            return new FunctionCall(token, arguments, rawExpression);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FunctionCall)) {
                return false;
            }
            FunctionCall functionCall = (FunctionCall) other;
            return Intrinsics.areEqual(this.token, functionCall.token) && Intrinsics.areEqual(this.arguments, functionCall.arguments) && Intrinsics.areEqual(this.rawExpression, functionCall.rawExpression);
        }

        public int hashCode() {
            return (((this.token.hashCode() * 31) + this.arguments.hashCode()) * 31) + this.rawExpression.hashCode();
        }

        public final Token.Function getToken() {
            return this.token;
        }

        public final List<Evaluable> getArguments() {
            return this.arguments;
        }

        public final String getRawExpression() {
            return this.rawExpression;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public FunctionCall(Token.Function token, List<? extends Evaluable> arguments, String rawExpression) {
            Object obj;
            super(rawExpression);
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(arguments, "arguments");
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            this.token = token;
            this.arguments = arguments;
            this.rawExpression = rawExpression;
            List<? extends Evaluable> list = arguments;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((Evaluable) it.next()).getVariables());
            }
            Iterator it2 = arrayList.iterator();
            if (it2.hasNext()) {
                Object next = it2.next();
                while (it2.hasNext()) {
                    next = CollectionsKt.plus((Collection) next, (Iterable) it2.next());
                }
                obj = next;
            } else {
                obj = null;
            }
            List<String> list2 = (List) obj;
            this.variables = list2 == null ? CollectionsKt.emptyList() : list2;
        }

        @Override // com.yandex.div.evaluable.Evaluable
        public List<String> getVariables() {
            return this.variables;
        }

        @Override // com.yandex.div.evaluable.Evaluable
        protected Object evalImpl(Evaluator evaluator) {
            Intrinsics.checkNotNullParameter(evaluator, "evaluator");
            return evaluator.evalFunctionCall$div_evaluable(this);
        }

        public String toString() {
            return this.token.getName() + '(' + CollectionsKt.joinToString$default(this.arguments, Token.Function.ArgumentDelimiter.INSTANCE.toString(), null, null, 0, null, null, 62, null) + ')';
        }
    }

    /* JADX INFO: compiled from: Evaluable.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\b\u0010\u0019\u001a\u00020\u0005H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/yandex/div/evaluable/Evaluable$StringTemplate;", "Lcom/yandex/div/evaluable/Evaluable;", "arguments", "", "rawExpression", "", "(Ljava/util/List;Ljava/lang/String;)V", "getArguments", "()Ljava/util/List;", "getRawExpression", "()Ljava/lang/String;", "variables", "getVariables", "component1", "component2", "copy", "equals", "", "other", "", "evalImpl", "evaluator", "Lcom/yandex/div/evaluable/Evaluator;", "hashCode", "", "toString", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class StringTemplate extends Evaluable {
        private final List<Evaluable> arguments;
        private final String rawExpression;
        private final List<String> variables;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StringTemplate copy$default(StringTemplate stringTemplate, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = stringTemplate.arguments;
            }
            if ((i & 2) != 0) {
                str = stringTemplate.rawExpression;
            }
            return stringTemplate.copy(list, str);
        }

        public final List<Evaluable> component1() {
            return this.arguments;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getRawExpression() {
            return this.rawExpression;
        }

        public final StringTemplate copy(List<? extends Evaluable> arguments, String rawExpression) {
            Intrinsics.checkNotNullParameter(arguments, "arguments");
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            return new StringTemplate(arguments, rawExpression);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StringTemplate)) {
                return false;
            }
            StringTemplate stringTemplate = (StringTemplate) other;
            return Intrinsics.areEqual(this.arguments, stringTemplate.arguments) && Intrinsics.areEqual(this.rawExpression, stringTemplate.rawExpression);
        }

        public int hashCode() {
            return (this.arguments.hashCode() * 31) + this.rawExpression.hashCode();
        }

        public final List<Evaluable> getArguments() {
            return this.arguments;
        }

        public final String getRawExpression() {
            return this.rawExpression;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public StringTemplate(List<? extends Evaluable> arguments, String rawExpression) {
            super(rawExpression);
            Intrinsics.checkNotNullParameter(arguments, "arguments");
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            this.arguments = arguments;
            this.rawExpression = rawExpression;
            List<? extends Evaluable> list = arguments;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((Evaluable) it.next()).getVariables());
            }
            Iterator it2 = arrayList.iterator();
            if (!it2.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it2.next();
            while (it2.hasNext()) {
                next = CollectionsKt.plus((Collection) next, (Iterable) it2.next());
            }
            this.variables = (List) next;
        }

        @Override // com.yandex.div.evaluable.Evaluable
        public List<String> getVariables() {
            return this.variables;
        }

        @Override // com.yandex.div.evaluable.Evaluable
        protected Object evalImpl(Evaluator evaluator) {
            Intrinsics.checkNotNullParameter(evaluator, "evaluator");
            return evaluator.evalStringTemplate$div_evaluable(this);
        }

        public String toString() {
            return CollectionsKt.joinToString$default(this.arguments, "", null, null, 0, null, null, 62, null);
        }
    }

    /* JADX INFO: compiled from: Evaluable.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u000f\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\bJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J*\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\t\u0010\bR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Lcom/yandex/div/evaluable/Evaluable$Variable;", "Lcom/yandex/div/evaluable/Evaluable;", "token", "Lcom/yandex/div/evaluable/internal/Token$Operand$Variable;", "rawExpression", "", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getRawExpression", "()Ljava/lang/String;", "getToken-A4lXSVo", "Ljava/lang/String;", "variables", "", "getVariables", "()Ljava/util/List;", "component1", "component1-A4lXSVo", "component2", "copy", "copy-VWWhtj0", "(Ljava/lang/String;Ljava/lang/String;)Lcom/yandex/div/evaluable/Evaluable$Variable;", "equals", "", "other", "", "evalImpl", "evaluator", "Lcom/yandex/div/evaluable/Evaluator;", "hashCode", "", "toString", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Variable extends Evaluable {
        private final String rawExpression;
        private final String token;
        private final List<String> variables;

        public /* synthetic */ Variable(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        /* JADX INFO: renamed from: copy-VWWhtj0$default, reason: not valid java name */
        public static /* synthetic */ Variable m6163copyVWWhtj0$default(Variable variable, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = variable.token;
            }
            if ((i & 2) != 0) {
                str2 = variable.rawExpression;
            }
            return variable.m6165copyVWWhtj0(str, str2);
        }

        /* JADX INFO: renamed from: component1-A4lXSVo, reason: not valid java name and from getter */
        public final String getToken() {
            return this.token;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getRawExpression() {
            return this.rawExpression;
        }

        /* JADX INFO: renamed from: copy-VWWhtj0, reason: not valid java name */
        public final Variable m6165copyVWWhtj0(String token, String rawExpression) {
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            return new Variable(token, rawExpression, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Variable)) {
                return false;
            }
            Variable variable = (Variable) other;
            return Token.Operand.Variable.m6209equalsimpl0(this.token, variable.token) && Intrinsics.areEqual(this.rawExpression, variable.rawExpression);
        }

        public int hashCode() {
            return (Token.Operand.Variable.m6210hashCodeimpl(this.token) * 31) + this.rawExpression.hashCode();
        }

        /* JADX INFO: renamed from: getToken-A4lXSVo, reason: not valid java name */
        public final String m6166getTokenA4lXSVo() {
            return this.token;
        }

        public final String getRawExpression() {
            return this.rawExpression;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private Variable(String token, String rawExpression) {
            super(rawExpression);
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            this.token = token;
            this.rawExpression = rawExpression;
            this.variables = CollectionsKt.listOf(token);
        }

        @Override // com.yandex.div.evaluable.Evaluable
        public List<String> getVariables() {
            return this.variables;
        }

        @Override // com.yandex.div.evaluable.Evaluable
        protected Object evalImpl(Evaluator evaluator) {
            Intrinsics.checkNotNullParameter(evaluator, "evaluator");
            return evaluator.evalVariable$div_evaluable(this);
        }

        public String toString() {
            return this.token;
        }
    }

    /* JADX INFO: compiled from: Evaluable.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/yandex/div/evaluable/Evaluable$Value;", "Lcom/yandex/div/evaluable/Evaluable;", "token", "Lcom/yandex/div/evaluable/internal/Token$Operand$Literal;", "rawExpression", "", "(Lcom/yandex/div/evaluable/internal/Token$Operand$Literal;Ljava/lang/String;)V", "getRawExpression", "()Ljava/lang/String;", "getToken", "()Lcom/yandex/div/evaluable/internal/Token$Operand$Literal;", "variables", "", "getVariables", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "evalImpl", "evaluator", "Lcom/yandex/div/evaluable/Evaluator;", "hashCode", "", "toString", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Value extends Evaluable {
        private final String rawExpression;
        private final Token.Operand.Literal token;
        private final List<String> variables;

        public static /* synthetic */ Value copy$default(Value value, Token.Operand.Literal literal, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                literal = value.token;
            }
            if ((i & 2) != 0) {
                str = value.rawExpression;
            }
            return value.copy(literal, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Token.Operand.Literal getToken() {
            return this.token;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getRawExpression() {
            return this.rawExpression;
        }

        public final Value copy(Token.Operand.Literal token, String rawExpression) {
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            return new Value(token, rawExpression);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Value)) {
                return false;
            }
            Value value = (Value) other;
            return Intrinsics.areEqual(this.token, value.token) && Intrinsics.areEqual(this.rawExpression, value.rawExpression);
        }

        public int hashCode() {
            return (this.token.hashCode() * 31) + this.rawExpression.hashCode();
        }

        public final Token.Operand.Literal getToken() {
            return this.token;
        }

        public final String getRawExpression() {
            return this.rawExpression;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Value(Token.Operand.Literal token, String rawExpression) {
            super(rawExpression);
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
            this.token = token;
            this.rawExpression = rawExpression;
            this.variables = CollectionsKt.emptyList();
        }

        @Override // com.yandex.div.evaluable.Evaluable
        public List<String> getVariables() {
            return this.variables;
        }

        @Override // com.yandex.div.evaluable.Evaluable
        protected Object evalImpl(Evaluator evaluator) {
            Intrinsics.checkNotNullParameter(evaluator, "evaluator");
            return evaluator.evalValue$div_evaluable(this);
        }

        public String toString() {
            Token.Operand.Literal literal = this.token;
            if (literal instanceof Token.Operand.Literal.Str) {
                return "'" + ((Token.Operand.Literal.Str) this.token).m6205unboximpl() + '\'';
            }
            if (literal instanceof Token.Operand.Literal.Num) {
                return ((Token.Operand.Literal.Num) literal).m6198unboximpl().toString();
            }
            if (literal instanceof Token.Operand.Literal.Bool) {
                return String.valueOf(((Token.Operand.Literal.Bool) literal).m6191unboximpl());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: Evaluable.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/yandex/div/evaluable/Evaluable$Companion;", "", "()V", "lazy", "Lcom/yandex/div/evaluable/Evaluable;", "expr", "", "prepare", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Evaluable prepare(String expr) {
            Intrinsics.checkNotNullParameter(expr, "expr");
            return Parser.INSTANCE.parse(Tokenizer.INSTANCE.tokenize(expr), expr);
        }

        @JvmStatic
        public final Evaluable lazy(String expr) {
            Intrinsics.checkNotNullParameter(expr, "expr");
            return new Lazy(expr);
        }
    }
}
