package com.yandex.div2;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
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

/* JADX INFO: compiled from: DivWrapContentSize.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0002\u0016\u0017B1\b\u0007\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ0\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007J \u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div2/DivWrapContentSize;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "constrained", "Lcom/yandex/div/json/expressions/Expression;", "", SDKConstants.PARAM_CONTEXT_MAX_SIZE, "Lcom/yandex/div2/DivWrapContentSize$ConstraintSize;", SDKConstants.PARAM_CONTEXT_MIN_SIZE, "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivWrapContentSize$ConstraintSize;Lcom/yandex/div2/DivWrapContentSize$ConstraintSize;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "ConstraintSize", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivWrapContentSize implements JSONSerializable, Hashable {
    public static final String TYPE = "wrap_content";
    private Integer _hash;
    public final Expression<Boolean> constrained;
    public final ConstraintSize maxSize;
    public final ConstraintSize minSize;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivWrapContentSize> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivWrapContentSize>() { // from class: com.yandex.div2.DivWrapContentSize$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivWrapContentSize invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivWrapContentSize.INSTANCE.fromJson(env, it);
        }
    };

    public DivWrapContentSize() {
        this(null, null, null, 7, null);
    }

    @JvmStatic
    public static final DivWrapContentSize fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivWrapContentSize(Expression<Boolean> expression, ConstraintSize constraintSize, ConstraintSize constraintSize2) {
        this.constrained = expression;
        this.maxSize = constraintSize;
        this.minSize = constraintSize2;
    }

    public /* synthetic */ DivWrapContentSize(Expression expression, ConstraintSize constraintSize, ConstraintSize constraintSize2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : expression, (i & 2) != 0 ? null : constraintSize, (i & 4) != 0 ? null : constraintSize2);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        Expression<Boolean> expression = this.constrained;
        int iHashCode2 = iHashCode + (expression != null ? expression.hashCode() : 0);
        ConstraintSize constraintSize = this.maxSize;
        int iHash = iHashCode2 + (constraintSize != null ? constraintSize.hash() : 0);
        ConstraintSize constraintSize2 = this.minSize;
        int iHash2 = iHash + (constraintSize2 != null ? constraintSize2.hash() : 0);
        this._hash = Integer.valueOf(iHash2);
        return iHash2;
    }

    public final boolean equals(DivWrapContentSize other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        boolean zEquals;
        boolean zEquals2;
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        Expression<Boolean> expression = this.constrained;
        Boolean boolEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<Boolean> expression2 = other.constrained;
        if (!Intrinsics.areEqual(boolEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null)) {
            return false;
        }
        ConstraintSize constraintSize = this.maxSize;
        if (constraintSize != null) {
            zEquals = constraintSize.equals(other.maxSize, resolver, otherResolver);
        } else {
            zEquals = other.maxSize == null;
        }
        if (!zEquals) {
            return false;
        }
        ConstraintSize constraintSize2 = this.minSize;
        ConstraintSize constraintSize3 = other.minSize;
        if (constraintSize2 != null) {
            zEquals2 = constraintSize2.equals(constraintSize3, resolver, otherResolver);
        } else {
            zEquals2 = constraintSize3 == null;
        }
        return zEquals2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivWrapContentSize copy$default(DivWrapContentSize divWrapContentSize, Expression expression, ConstraintSize constraintSize, ConstraintSize constraintSize2, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divWrapContentSize.constrained;
        }
        if ((i & 2) != 0) {
            constraintSize = divWrapContentSize.maxSize;
        }
        if ((i & 4) != 0) {
            constraintSize2 = divWrapContentSize.minSize;
        }
        return divWrapContentSize.copy(expression, constraintSize, constraintSize2);
    }

    public final DivWrapContentSize copy(Expression<Boolean> constrained, ConstraintSize maxSize, ConstraintSize minSize) {
        return new DivWrapContentSize(constrained, maxSize, minSize);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivWrapContentSizeJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivWrapContentSize.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u000fR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yandex/div2/DivWrapContentSize$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivWrapContentSize;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivWrapContentSize fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivWrapContentSizeJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivWrapContentSize> getCREATOR() {
            return DivWrapContentSize.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivWrapContentSize.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B%\b\u0007\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\u0010\bJ&\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004J \u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/yandex/div2/DivWrapContentSize$ConstraintSize;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "unit", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivSizeUnit;", "value", "", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ConstraintSize implements JSONSerializable, Hashable {
        private Integer _hash;
        public final Expression<DivSizeUnit> unit;
        public final Expression<Long> value;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Expression<DivSizeUnit> UNIT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivSizeUnit.DP);
        private static final Function2<ParsingEnvironment, JSONObject, ConstraintSize> CREATOR = new Function2<ParsingEnvironment, JSONObject, ConstraintSize>() { // from class: com.yandex.div2.DivWrapContentSize$ConstraintSize$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivWrapContentSize.ConstraintSize invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivWrapContentSize.ConstraintSize.INSTANCE.fromJson(env, it);
            }
        };

        @JvmStatic
        public static final ConstraintSize fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
            return INSTANCE.fromJson(parsingEnvironment, jSONObject);
        }

        public ConstraintSize(Expression<DivSizeUnit> unit, Expression<Long> value) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            Intrinsics.checkNotNullParameter(value, "value");
            this.unit = unit;
            this.value = value;
        }

        public /* synthetic */ ConstraintSize(Expression expression, Expression expression2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? UNIT_DEFAULT_VALUE : expression, expression2);
        }

        @Override // com.yandex.div.data.Hashable
        public int hash() {
            Integer num = this._hash;
            if (num != null) {
                return num.intValue();
            }
            int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.unit.hashCode() + this.value.hashCode();
            this._hash = Integer.valueOf(iHashCode);
            return iHashCode;
        }

        public final boolean equals(ConstraintSize other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
            return other != null && this.unit.evaluate(resolver) == other.unit.evaluate(otherResolver) && this.value.evaluate(resolver).longValue() == other.value.evaluate(otherResolver).longValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ConstraintSize copy$default(ConstraintSize constraintSize, Expression expression, Expression expression2, int i, Object obj) {
            if ((i & 1) != 0) {
                expression = constraintSize.unit;
            }
            if ((i & 2) != 0) {
                expression2 = constraintSize.value;
            }
            return constraintSize.copy(expression, expression2);
        }

        public final ConstraintSize copy(Expression<DivSizeUnit> unit, Expression<Long> value) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            Intrinsics.checkNotNullParameter(value, "value");
            return new ConstraintSize(unit, value);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivWrapContentSizeConstraintSizeJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivWrapContentSize.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0010R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div2/DivWrapContentSize$ConstraintSize$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivWrapContentSize$ConstraintSize;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "UNIT_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivSizeUnit;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final ConstraintSize fromJson(ParsingEnvironment env, JSONObject json) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(json, "json");
                return BuiltInParserKt.getBuiltInParserComponent().getDivWrapContentSizeConstraintSizeJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
            }

            public final Function2<ParsingEnvironment, JSONObject, ConstraintSize> getCREATOR() {
                return ConstraintSize.CREATOR;
            }
        }
    }
}
