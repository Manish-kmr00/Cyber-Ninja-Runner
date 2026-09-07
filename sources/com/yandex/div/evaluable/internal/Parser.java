package com.yandex.div.evaluable.internal;

import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.yandex.div.evaluable.Evaluable;
import com.yandex.div.evaluable.EvaluableException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001c\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001c\u0010\u0010\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\"\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u001d"}, d2 = {"Lcom/yandex/div/evaluable/internal/Parser;", "", "()V", "and", "Lcom/yandex/div/evaluable/Evaluable;", "state", "Lcom/yandex/div/evaluable/internal/Parser$ParsingState;", NotificationCompat.CATEGORY_CALL, "prefix", "comparison", "equal", "exponent", "expression", "factor", "method", "or", "parse", "tokens", "", "Lcom/yandex/div/evaluable/internal/Token;", "rawExpression", "", "parseFunction", "token", "Lcom/yandex/div/evaluable/internal/Token$Function;", "sum", "try", "unary", "ParsingState", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Parser {
    public static final Parser INSTANCE = new Parser();

    private Parser() {
    }

    public final Evaluable parse(List<? extends Token> tokens, String rawExpression) {
        Intrinsics.checkNotNullParameter(tokens, "tokens");
        Intrinsics.checkNotNullParameter(rawExpression, "rawExpression");
        if (tokens.isEmpty()) {
            throw new EvaluableException("Expression expected", null, 2, null);
        }
        ParsingState parsingState = new ParsingState(tokens, rawExpression);
        Evaluable evaluableExpression = expression(parsingState);
        if (parsingState.isNotAtEnd()) {
            throw new EvaluableException("Expression expected", null, 2, null);
        }
        return evaluableExpression;
    }

    private final Evaluable expression(ParsingState state) {
        Evaluable evaluableM6184try = m6184try(state);
        if (!state.isNotAtEnd() || !(state.currentToken() instanceof Token.Operator.TernaryIf)) {
            return evaluableM6184try;
        }
        state.forward();
        Evaluable evaluableExpression = expression(state);
        if (state.isAtEnd() || !(state.currentToken() instanceof Token.Operator.TernaryElse)) {
            throw new EvaluableException("':' expected in ternary-if-else expression", null, 2, null);
        }
        state.forward();
        return new Evaluable.Ternary(Token.Operator.TernaryIfElse.INSTANCE, evaluableM6184try, evaluableExpression, expression(state), state.getRawExpr());
    }

    /* JADX INFO: renamed from: try, reason: not valid java name */
    private final Evaluable m6184try(ParsingState state) {
        Evaluable evaluableOr = or(state);
        if (!state.isNotAtEnd() || !(state.currentToken() instanceof Token.Operator.Try)) {
            return evaluableOr;
        }
        Token next = state.next();
        Evaluable evaluableExpression = expression(state);
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.yandex.div.evaluable.internal.Token.Operator.Try");
        return new Evaluable.Try((Token.Operator.Try) next, evaluableOr, evaluableExpression, state.getRawExpr());
    }

    private final Evaluable or(ParsingState state) {
        Evaluable.Binary binaryAnd = and(state);
        while (state.isNotAtEnd() && (state.currentToken() instanceof Token.Operator.Binary.Logical.Or)) {
            state.forward();
            binaryAnd = new Evaluable.Binary(Token.Operator.Binary.Logical.Or.INSTANCE, binaryAnd, and(state), state.getRawExpr());
        }
        return binaryAnd;
    }

    private final Evaluable and(ParsingState state) {
        Evaluable.Binary binaryEqual = equal(state);
        while (state.isNotAtEnd() && (state.currentToken() instanceof Token.Operator.Binary.Logical.And)) {
            state.forward();
            binaryEqual = new Evaluable.Binary(Token.Operator.Binary.Logical.And.INSTANCE, binaryEqual, equal(state), state.getRawExpr());
        }
        return binaryEqual;
    }

    private final Evaluable equal(ParsingState state) {
        Evaluable.Binary binaryComparison = comparison(state);
        while (state.isNotAtEnd() && (state.currentToken() instanceof Token.Operator.Binary.Equality)) {
            Token next = state.next();
            Evaluable evaluableComparison = comparison(state);
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.yandex.div.evaluable.internal.Token.Operator.Binary");
            binaryComparison = new Evaluable.Binary((Token.Operator.Binary) next, binaryComparison, evaluableComparison, state.getRawExpr());
        }
        return binaryComparison;
    }

    private final Evaluable comparison(ParsingState state) {
        Evaluable.Binary binarySum = sum(state);
        while (state.isNotAtEnd() && (state.currentToken() instanceof Token.Operator.Binary.Comparison)) {
            Token next = state.next();
            Evaluable evaluableSum = sum(state);
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.yandex.div.evaluable.internal.Token.Operator.Binary");
            binarySum = new Evaluable.Binary((Token.Operator.Binary) next, binarySum, evaluableSum, state.getRawExpr());
        }
        return binarySum;
    }

    private final Evaluable sum(ParsingState state) {
        Evaluable.Binary binaryFactor = factor(state);
        while (state.isNotAtEnd() && (state.currentToken() instanceof Token.Operator.Binary.Sum)) {
            Token next = state.next();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.yandex.div.evaluable.internal.Token.Operator.Binary");
            binaryFactor = new Evaluable.Binary((Token.Operator.Binary) next, binaryFactor, factor(state), state.getRawExpr());
        }
        return binaryFactor;
    }

    private final Evaluable factor(ParsingState state) {
        Evaluable.Binary binaryUnary = unary(state);
        while (state.isNotAtEnd() && (state.currentToken() instanceof Token.Operator.Binary.Factor)) {
            Token next = state.next();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.yandex.div.evaluable.internal.Token.Operator.Binary");
            binaryUnary = new Evaluable.Binary((Token.Operator.Binary) next, binaryUnary, unary(state), state.getRawExpr());
        }
        return binaryUnary;
    }

    private final Evaluable unary(ParsingState state) {
        if (state.isNotAtEnd() && (state.currentToken() instanceof Token.Operator.Unary)) {
            Token next = state.next();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.yandex.div.evaluable.internal.Token.Operator");
            return new Evaluable.Unary((Token.Operator) next, unary(state), state.getRawExpr());
        }
        return exponent(state);
    }

    private final Evaluable exponent(ParsingState state) {
        Evaluable evaluableMethod = method(state);
        if (!state.isNotAtEnd() || !(state.currentToken() instanceof Token.Operator.Binary.Power)) {
            return evaluableMethod;
        }
        state.forward();
        return new Evaluable.Binary(Token.Operator.Binary.Power.INSTANCE, evaluableMethod, unary(state), state.getRawExpr());
    }

    private final Evaluable method(ParsingState state) {
        Evaluable evaluableCall$default = call$default(this, state, null, 2, null);
        while (state.isNotAtEnd() && (state.currentToken() instanceof Token.Operator.Dot)) {
            state.forward();
            evaluableCall$default = call(state, evaluableCall$default);
        }
        return evaluableCall$default;
    }

    static /* synthetic */ Evaluable call$default(Parser parser, ParsingState parsingState, Evaluable evaluable, int i, Object obj) {
        if ((i & 2) != 0) {
            evaluable = null;
        }
        return parser.call(parsingState, evaluable);
    }

    private final Evaluable call(ParsingState state, Evaluable prefix) {
        if (state.isAtEnd()) {
            throw new EvaluableException("Expression expected", null, 2, null);
        }
        Token next = state.next();
        if (prefix != null && !(next instanceof Token.Function)) {
            throw new EvaluableException("Method expected after .", null, 2, null);
        }
        if (next instanceof Token.Operand.Literal) {
            return new Evaluable.Value((Token.Operand.Literal) next, state.getRawExpr());
        }
        if (next instanceof Token.Operand.Variable) {
            return new Evaluable.Variable(((Token.Operand.Variable) next).m6212unboximpl(), state.getRawExpr(), null);
        }
        if (next instanceof Token.Function) {
            return parseFunction((Token.Function) next, state, prefix);
        }
        if (next instanceof Token.Bracket.LeftRound) {
            Evaluable evaluableExpression = expression(state);
            if (state.next() instanceof Token.Bracket.RightRound) {
                return evaluableExpression;
            }
            throw new EvaluableException("')' expected after expression", null, 2, null);
        }
        if (next instanceof Token.StringTemplate.Start) {
            ArrayList arrayList = new ArrayList();
            while (state.isNotAtEnd() && !(state.currentToken() instanceof Token.StringTemplate.End)) {
                if ((state.currentToken() instanceof Token.StringTemplate.StartOfExpression) || (state.currentToken() instanceof Token.StringTemplate.EndOfExpression)) {
                    state.forward();
                } else {
                    arrayList.add(expression(state));
                }
            }
            if (!(state.next() instanceof Token.StringTemplate.End)) {
                throw new EvaluableException("expected ''' at end of a string template", null, 2, null);
            }
            return new Evaluable.StringTemplate(arrayList, state.getRawExpr());
        }
        throw new EvaluableException("Expression expected", null, 2, null);
    }

    private final Evaluable parseFunction(Token.Function token, ParsingState state, Evaluable prefix) {
        if (!(state.next() instanceof Token.Bracket.LeftRound)) {
            throw new EvaluableException("'(' expected after function call", null, 2, null);
        }
        ArrayList arrayList = new ArrayList();
        if (prefix != null) {
            arrayList.add(prefix);
        }
        while (!(state.currentToken() instanceof Token.Bracket.RightRound)) {
            arrayList.add(expression(state));
            if (state.currentToken() instanceof Token.Function.ArgumentDelimiter) {
                state.forward();
            }
        }
        if (!(state.next() instanceof Token.Bracket.RightRound)) {
            throw new EvaluableException("expected ')' after a function call", null, 2, null);
        }
        if (prefix == null) {
            return new Evaluable.FunctionCall(token, arrayList, state.getRawExpr());
        }
        return new Evaluable.MethodCall(token, arrayList, state.getRawExpr());
    }

    /* JADX INFO: compiled from: Parser.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÂ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0004J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0017\u001a\u00020\tJ\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\u0015J\u0006\u0010\u001b\u001a\u00020\u0004J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/yandex/div/evaluable/internal/Parser$ParsingState;", "", "tokens", "", "Lcom/yandex/div/evaluable/internal/Token;", "rawExpr", "", "(Ljava/util/List;Ljava/lang/String;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "getRawExpr", "()Ljava/lang/String;", "component1", "component2", "copy", "currentToken", "equals", "", "other", ToolBar.FORWARD, "hashCode", "isAtEnd", "isNotAtEnd", "next", "toString", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final /* data */ class ParsingState {
        private int index;
        private final String rawExpr;
        private final List<Token> tokens;

        private final List<Token> component1() {
            return this.tokens;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ParsingState copy$default(ParsingState parsingState, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = parsingState.tokens;
            }
            if ((i & 2) != 0) {
                str = parsingState.rawExpr;
            }
            return parsingState.copy(list, str);
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getRawExpr() {
            return this.rawExpr;
        }

        public final ParsingState copy(List<? extends Token> tokens, String rawExpr) {
            Intrinsics.checkNotNullParameter(tokens, "tokens");
            Intrinsics.checkNotNullParameter(rawExpr, "rawExpr");
            return new ParsingState(tokens, rawExpr);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParsingState)) {
                return false;
            }
            ParsingState parsingState = (ParsingState) other;
            return Intrinsics.areEqual(this.tokens, parsingState.tokens) && Intrinsics.areEqual(this.rawExpr, parsingState.rawExpr);
        }

        public int hashCode() {
            return (this.tokens.hashCode() * 31) + this.rawExpr.hashCode();
        }

        public String toString() {
            return "ParsingState(tokens=" + this.tokens + ", rawExpr=" + this.rawExpr + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ParsingState(List<? extends Token> tokens, String rawExpr) {
            Intrinsics.checkNotNullParameter(tokens, "tokens");
            Intrinsics.checkNotNullParameter(rawExpr, "rawExpr");
            this.tokens = tokens;
            this.rawExpr = rawExpr;
        }

        public final String getRawExpr() {
            return this.rawExpr;
        }

        public final int getIndex() {
            return this.index;
        }

        public final void setIndex(int i) {
            this.index = i;
        }

        public final Token currentToken() {
            return this.tokens.get(this.index);
        }

        public final Token next() {
            return this.tokens.get(forward());
        }

        public final int forward() {
            int i = this.index;
            this.index = i + 1;
            return i;
        }

        public final boolean isNotAtEnd() {
            return !isAtEnd();
        }

        public final boolean isAtEnd() {
            return this.index >= this.tokens.size();
        }
    }
}
