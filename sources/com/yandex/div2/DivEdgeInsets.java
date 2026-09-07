package com.yandex.div2;

import com.facebook.appevents.internal.ViewHierarchyConstants;
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

/* JADX INFO: compiled from: DivEdgeInsets.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB{\b\u0007\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\u0010\rJz\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004J \u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yandex/div2/DivEdgeInsets;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "bottom", "Lcom/yandex/div/json/expressions/Expression;", "", "end", "left", "right", "start", ViewHierarchyConstants.DIMENSION_TOP_KEY, "unit", "Lcom/yandex/div2/DivSizeUnit;", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivEdgeInsets implements JSONSerializable, Hashable {
    private Integer _hash;
    public final Expression<Long> bottom;
    public final Expression<Long> end;
    public final Expression<Long> left;
    public final Expression<Long> right;
    public final Expression<Long> start;
    public final Expression<Long> top;
    public final Expression<DivSizeUnit> unit;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Long> BOTTOM_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Expression<Long> LEFT_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Expression<Long> RIGHT_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Expression<Long> TOP_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Expression<DivSizeUnit> UNIT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivSizeUnit.DP);
    private static final Function2<ParsingEnvironment, JSONObject, DivEdgeInsets> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivEdgeInsets>() { // from class: com.yandex.div2.DivEdgeInsets$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivEdgeInsets invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivEdgeInsets.INSTANCE.fromJson(env, it);
        }
    };

    public DivEdgeInsets() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    @JvmStatic
    public static final DivEdgeInsets fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivEdgeInsets(Expression<Long> bottom, Expression<Long> expression, Expression<Long> left, Expression<Long> right, Expression<Long> expression2, Expression<Long> top, Expression<DivSizeUnit> unit) {
        Intrinsics.checkNotNullParameter(bottom, "bottom");
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        Intrinsics.checkNotNullParameter(top, "top");
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.bottom = bottom;
        this.end = expression;
        this.left = left;
        this.right = right;
        this.start = expression2;
        this.top = top;
        this.unit = unit;
    }

    public /* synthetic */ DivEdgeInsets(Expression expression, Expression expression2, Expression expression3, Expression expression4, Expression expression5, Expression expression6, Expression expression7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? BOTTOM_DEFAULT_VALUE : expression, (i & 2) != 0 ? null : expression2, (i & 4) != 0 ? LEFT_DEFAULT_VALUE : expression3, (i & 8) != 0 ? RIGHT_DEFAULT_VALUE : expression4, (i & 16) == 0 ? expression5 : null, (i & 32) != 0 ? TOP_DEFAULT_VALUE : expression6, (i & 64) != 0 ? UNIT_DEFAULT_VALUE : expression7);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.bottom.hashCode();
        Expression<Long> expression = this.end;
        int iHashCode2 = iHashCode + (expression != null ? expression.hashCode() : 0) + this.left.hashCode() + this.right.hashCode();
        Expression<Long> expression2 = this.start;
        int iHashCode3 = iHashCode2 + (expression2 != null ? expression2.hashCode() : 0) + this.top.hashCode() + this.unit.hashCode();
        this._hash = Integer.valueOf(iHashCode3);
        return iHashCode3;
    }

    public final boolean equals(DivEdgeInsets other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null || this.bottom.evaluate(resolver).longValue() != other.bottom.evaluate(otherResolver).longValue()) {
            return false;
        }
        Expression<Long> expression = this.end;
        Long lEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<Long> expression2 = other.end;
        if (!Intrinsics.areEqual(lEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null) || this.left.evaluate(resolver).longValue() != other.left.evaluate(otherResolver).longValue() || this.right.evaluate(resolver).longValue() != other.right.evaluate(otherResolver).longValue()) {
            return false;
        }
        Expression<Long> expression3 = this.start;
        Long lEvaluate2 = expression3 != null ? expression3.evaluate(resolver) : null;
        Expression<Long> expression4 = other.start;
        return Intrinsics.areEqual(lEvaluate2, expression4 != null ? expression4.evaluate(otherResolver) : null) && this.top.evaluate(resolver).longValue() == other.top.evaluate(otherResolver).longValue() && this.unit.evaluate(resolver) == other.unit.evaluate(otherResolver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivEdgeInsets copy$default(DivEdgeInsets divEdgeInsets, Expression expression, Expression expression2, Expression expression3, Expression expression4, Expression expression5, Expression expression6, Expression expression7, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divEdgeInsets.bottom;
        }
        if ((i & 2) != 0) {
            expression2 = divEdgeInsets.end;
        }
        Expression expression8 = expression2;
        if ((i & 4) != 0) {
            expression3 = divEdgeInsets.left;
        }
        Expression expression9 = expression3;
        if ((i & 8) != 0) {
            expression4 = divEdgeInsets.right;
        }
        Expression expression10 = expression4;
        if ((i & 16) != 0) {
            expression5 = divEdgeInsets.start;
        }
        Expression expression11 = expression5;
        if ((i & 32) != 0) {
            expression6 = divEdgeInsets.top;
        }
        Expression expression12 = expression6;
        if ((i & 64) != 0) {
            expression7 = divEdgeInsets.unit;
        }
        return divEdgeInsets.copy(expression, expression8, expression9, expression10, expression11, expression12, expression7);
    }

    public final DivEdgeInsets copy(Expression<Long> bottom, Expression<Long> end, Expression<Long> left, Expression<Long> right, Expression<Long> start, Expression<Long> top, Expression<DivSizeUnit> unit) {
        Intrinsics.checkNotNullParameter(bottom, "bottom");
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        Intrinsics.checkNotNullParameter(top, "top");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return new DivEdgeInsets(bottom, end, left, right, start, top, unit);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivEdgeInsetsJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivEdgeInsets.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u0015R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yandex/div2/DivEdgeInsets$Companion;", "", "()V", "BOTTOM_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivEdgeInsets;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "LEFT_DEFAULT_VALUE", "RIGHT_DEFAULT_VALUE", "TOP_DEFAULT_VALUE", "UNIT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSizeUnit;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivEdgeInsets fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivEdgeInsetsJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivEdgeInsets> getCREATOR() {
            return DivEdgeInsets.CREATOR;
        }
    }
}
