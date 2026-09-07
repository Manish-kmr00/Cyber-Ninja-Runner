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

/* JADX INFO: compiled from: DivCornersRadius.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017BO\b\u0007\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\tJN\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J \u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div2/DivCornersRadius;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "bottomLeft", "Lcom/yandex/div/json/expressions/Expression;", "", "bottomRight", "topLeft", "topRight", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivCornersRadius implements JSONSerializable, Hashable {
    private Integer _hash;
    public final Expression<Long> bottomLeft;
    public final Expression<Long> bottomRight;
    public final Expression<Long> topLeft;
    public final Expression<Long> topRight;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivCornersRadius> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivCornersRadius>() { // from class: com.yandex.div2.DivCornersRadius$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivCornersRadius invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivCornersRadius.INSTANCE.fromJson(env, it);
        }
    };

    public DivCornersRadius() {
        this(null, null, null, null, 15, null);
    }

    @JvmStatic
    public static final DivCornersRadius fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivCornersRadius(Expression<Long> expression, Expression<Long> expression2, Expression<Long> expression3, Expression<Long> expression4) {
        this.bottomLeft = expression;
        this.bottomRight = expression2;
        this.topLeft = expression3;
        this.topRight = expression4;
    }

    public /* synthetic */ DivCornersRadius(Expression expression, Expression expression2, Expression expression3, Expression expression4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : expression, (i & 2) != 0 ? null : expression2, (i & 4) != 0 ? null : expression3, (i & 8) != 0 ? null : expression4);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        Expression<Long> expression = this.bottomLeft;
        int iHashCode2 = iHashCode + (expression != null ? expression.hashCode() : 0);
        Expression<Long> expression2 = this.bottomRight;
        int iHashCode3 = iHashCode2 + (expression2 != null ? expression2.hashCode() : 0);
        Expression<Long> expression3 = this.topLeft;
        int iHashCode4 = iHashCode3 + (expression3 != null ? expression3.hashCode() : 0);
        Expression<Long> expression4 = this.topRight;
        int iHashCode5 = iHashCode4 + (expression4 != null ? expression4.hashCode() : 0);
        this._hash = Integer.valueOf(iHashCode5);
        return iHashCode5;
    }

    public final boolean equals(DivCornersRadius other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        Expression<Long> expression = this.bottomLeft;
        Long lEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<Long> expression2 = other.bottomLeft;
        if (!Intrinsics.areEqual(lEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null)) {
            return false;
        }
        Expression<Long> expression3 = this.bottomRight;
        Long lEvaluate2 = expression3 != null ? expression3.evaluate(resolver) : null;
        Expression<Long> expression4 = other.bottomRight;
        if (!Intrinsics.areEqual(lEvaluate2, expression4 != null ? expression4.evaluate(otherResolver) : null)) {
            return false;
        }
        Expression<Long> expression5 = this.topLeft;
        Long lEvaluate3 = expression5 != null ? expression5.evaluate(resolver) : null;
        Expression<Long> expression6 = other.topLeft;
        if (!Intrinsics.areEqual(lEvaluate3, expression6 != null ? expression6.evaluate(otherResolver) : null)) {
            return false;
        }
        Expression<Long> expression7 = this.topRight;
        Long lEvaluate4 = expression7 != null ? expression7.evaluate(resolver) : null;
        Expression<Long> expression8 = other.topRight;
        return Intrinsics.areEqual(lEvaluate4, expression8 != null ? expression8.evaluate(otherResolver) : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivCornersRadius copy$default(DivCornersRadius divCornersRadius, Expression expression, Expression expression2, Expression expression3, Expression expression4, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divCornersRadius.bottomLeft;
        }
        if ((i & 2) != 0) {
            expression2 = divCornersRadius.bottomRight;
        }
        if ((i & 4) != 0) {
            expression3 = divCornersRadius.topLeft;
        }
        if ((i & 8) != 0) {
            expression4 = divCornersRadius.topRight;
        }
        return divCornersRadius.copy(expression, expression2, expression3, expression4);
    }

    public final DivCornersRadius copy(Expression<Long> bottomLeft, Expression<Long> bottomRight, Expression<Long> topLeft, Expression<Long> topRight) {
        return new DivCornersRadius(bottomLeft, bottomRight, topLeft, topRight);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivCornersRadiusJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivCornersRadius.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivCornersRadius$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivCornersRadius;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivCornersRadius fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivCornersRadiusJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivCornersRadius> getCREATOR() {
            return DivCornersRadius.CREATOR;
        }
    }
}
