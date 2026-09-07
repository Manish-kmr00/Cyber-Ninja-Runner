package com.yandex.div2;

import com.json.cc;
import com.yandex.div.data.Hashable;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivInputValidatorExpression.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B;\b\u0007\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ@\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\b\b\u0002\u0010\t\u001a\u00020\bJ \u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div2/DivInputValidatorExpression;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "allowEmpty", "Lcom/yandex/div/json/expressions/Expression;", "", "condition", "labelId", "", "variable", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/lang/String;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivInputValidatorExpression implements JSONSerializable, Hashable {
    public static final String TYPE = "expression";
    private Integer _hash;
    public final Expression<Boolean> allowEmpty;
    public final Expression<Boolean> condition;
    public final Expression<String> labelId;
    public final String variable;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Boolean> ALLOW_EMPTY_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
    private static final Function2<ParsingEnvironment, JSONObject, DivInputValidatorExpression> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivInputValidatorExpression>() { // from class: com.yandex.div2.DivInputValidatorExpression$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivInputValidatorExpression invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivInputValidatorExpression.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivInputValidatorExpression fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivInputValidatorExpression(Expression<Boolean> allowEmpty, Expression<Boolean> condition, Expression<String> labelId, String variable) {
        Intrinsics.checkNotNullParameter(allowEmpty, "allowEmpty");
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(labelId, "labelId");
        Intrinsics.checkNotNullParameter(variable, "variable");
        this.allowEmpty = allowEmpty;
        this.condition = condition;
        this.labelId = labelId;
        this.variable = variable;
    }

    public /* synthetic */ DivInputValidatorExpression(Expression expression, Expression expression2, Expression expression3, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ALLOW_EMPTY_DEFAULT_VALUE : expression, expression2, expression3, str);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.allowEmpty.hashCode() + this.condition.hashCode() + this.labelId.hashCode() + this.variable.hashCode();
        this._hash = Integer.valueOf(iHashCode);
        return iHashCode;
    }

    public final boolean equals(DivInputValidatorExpression other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        return other != null && this.allowEmpty.evaluate(resolver).booleanValue() == other.allowEmpty.evaluate(otherResolver).booleanValue() && this.condition.evaluate(resolver).booleanValue() == other.condition.evaluate(otherResolver).booleanValue() && Intrinsics.areEqual(this.labelId.evaluate(resolver), other.labelId.evaluate(otherResolver)) && Intrinsics.areEqual(this.variable, other.variable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivInputValidatorExpression copy$default(DivInputValidatorExpression divInputValidatorExpression, Expression expression, Expression expression2, Expression expression3, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divInputValidatorExpression.allowEmpty;
        }
        if ((i & 2) != 0) {
            expression2 = divInputValidatorExpression.condition;
        }
        if ((i & 4) != 0) {
            expression3 = divInputValidatorExpression.labelId;
        }
        if ((i & 8) != 0) {
            str = divInputValidatorExpression.variable;
        }
        return divInputValidatorExpression.copy(expression, expression2, expression3, str);
    }

    public final DivInputValidatorExpression copy(Expression<Boolean> allowEmpty, Expression<Boolean> condition, Expression<String> labelId, String variable) {
        Intrinsics.checkNotNullParameter(allowEmpty, "allowEmpty");
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(labelId, "labelId");
        Intrinsics.checkNotNullParameter(variable, "variable");
        return new DivInputValidatorExpression(allowEmpty, condition, labelId, variable);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivInputValidatorExpressionJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivInputValidatorExpression.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u0012R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/yandex/div2/DivInputValidatorExpression$Companion;", "", "()V", "ALLOW_EMPTY_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivInputValidatorExpression;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivInputValidatorExpression fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivInputValidatorExpressionJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivInputValidatorExpression> getCREATOR() {
            return DivInputValidatorExpression.CREATOR;
        }
    }
}
