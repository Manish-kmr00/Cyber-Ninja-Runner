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

/* JADX INFO: compiled from: DivInputValidatorBase.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B5\b\u0007\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ4\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007J \u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/yandex/div2/DivInputValidatorBase;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "allowEmpty", "Lcom/yandex/div/json/expressions/Expression;", "", "labelId", "", "variable", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/lang/String;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivInputValidatorBase implements JSONSerializable, Hashable {
    private Integer _hash;
    public final Expression<Boolean> allowEmpty;
    public final Expression<String> labelId;
    public final String variable;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Boolean> ALLOW_EMPTY_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
    private static final Function2<ParsingEnvironment, JSONObject, DivInputValidatorBase> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivInputValidatorBase>() { // from class: com.yandex.div2.DivInputValidatorBase$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivInputValidatorBase invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivInputValidatorBase.INSTANCE.fromJson(env, it);
        }
    };

    public DivInputValidatorBase() {
        this(null, null, null, 7, null);
    }

    @JvmStatic
    public static final DivInputValidatorBase fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivInputValidatorBase(Expression<Boolean> allowEmpty, Expression<String> expression, String str) {
        Intrinsics.checkNotNullParameter(allowEmpty, "allowEmpty");
        this.allowEmpty = allowEmpty;
        this.labelId = expression;
        this.variable = str;
    }

    public /* synthetic */ DivInputValidatorBase(Expression expression, Expression expression2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ALLOW_EMPTY_DEFAULT_VALUE : expression, (i & 2) != 0 ? null : expression2, (i & 4) != 0 ? null : str);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.allowEmpty.hashCode();
        Expression<String> expression = this.labelId;
        int iHashCode2 = iHashCode + (expression != null ? expression.hashCode() : 0);
        String str = this.variable;
        int iHashCode3 = iHashCode2 + (str != null ? str.hashCode() : 0);
        this._hash = Integer.valueOf(iHashCode3);
        return iHashCode3;
    }

    public final boolean equals(DivInputValidatorBase other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null || this.allowEmpty.evaluate(resolver).booleanValue() != other.allowEmpty.evaluate(otherResolver).booleanValue()) {
            return false;
        }
        Expression<String> expression = this.labelId;
        String strEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<String> expression2 = other.labelId;
        return Intrinsics.areEqual(strEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null) && Intrinsics.areEqual(this.variable, other.variable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivInputValidatorBase copy$default(DivInputValidatorBase divInputValidatorBase, Expression expression, Expression expression2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divInputValidatorBase.allowEmpty;
        }
        if ((i & 2) != 0) {
            expression2 = divInputValidatorBase.labelId;
        }
        if ((i & 4) != 0) {
            str = divInputValidatorBase.variable;
        }
        return divInputValidatorBase.copy(expression, expression2, str);
    }

    public final DivInputValidatorBase copy(Expression<Boolean> allowEmpty, Expression<String> labelId, String variable) {
        Intrinsics.checkNotNullParameter(allowEmpty, "allowEmpty");
        return new DivInputValidatorBase(allowEmpty, labelId, variable);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivInputValidatorBaseJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivInputValidatorBase.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u0010R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/yandex/div2/DivInputValidatorBase$Companion;", "", "()V", "ALLOW_EMPTY_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivInputValidatorBase;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivInputValidatorBase fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivInputValidatorBaseJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivInputValidatorBase> getCREATOR() {
            return DivInputValidatorBase.CREATOR;
        }
    }
}
