package com.yandex.div2;

import androidx.constraintlayout.motion.widget.Key;
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

/* JADX INFO: compiled from: DivTransform.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B-\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ,\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J \u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div2/DivTransform;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "pivotX", "Lcom/yandex/div2/DivPivot;", "pivotY", Key.ROTATION, "Lcom/yandex/div/json/expressions/Expression;", "", "(Lcom/yandex/div2/DivPivot;Lcom/yandex/div2/DivPivot;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivTransform implements JSONSerializable, Hashable {
    private static final Function2<ParsingEnvironment, JSONObject, DivTransform> CREATOR;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DivPivot.Percentage PIVOT_X_DEFAULT_VALUE;
    private static final DivPivot.Percentage PIVOT_Y_DEFAULT_VALUE;
    private Integer _hash;
    public final DivPivot pivotX;
    public final DivPivot pivotY;
    public final Expression<Double> rotation;

    public DivTransform() {
        this(null, null, null, 7, null);
    }

    @JvmStatic
    public static final DivTransform fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivTransform(DivPivot pivotX, DivPivot pivotY, Expression<Double> expression) {
        Intrinsics.checkNotNullParameter(pivotX, "pivotX");
        Intrinsics.checkNotNullParameter(pivotY, "pivotY");
        this.pivotX = pivotX;
        this.pivotY = pivotY;
        this.rotation = expression;
    }

    public /* synthetic */ DivTransform(DivPivot.Percentage percentage, DivPivot.Percentage percentage2, Expression expression, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? PIVOT_X_DEFAULT_VALUE : percentage, (i & 2) != 0 ? PIVOT_Y_DEFAULT_VALUE : percentage2, (i & 4) != 0 ? null : expression);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.pivotX.hash() + this.pivotY.hash();
        Expression<Double> expression = this.rotation;
        int iHashCode2 = iHashCode + (expression != null ? expression.hashCode() : 0);
        this._hash = Integer.valueOf(iHashCode2);
        return iHashCode2;
    }

    public final boolean equals(DivTransform other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null || !this.pivotX.equals(other.pivotX, resolver, otherResolver) || !this.pivotY.equals(other.pivotY, resolver, otherResolver)) {
            return false;
        }
        Expression<Double> expression = this.rotation;
        Double dEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<Double> expression2 = other.rotation;
        return Intrinsics.areEqual(dEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivTransform copy$default(DivTransform divTransform, DivPivot divPivot, DivPivot divPivot2, Expression expression, int i, Object obj) {
        if ((i & 1) != 0) {
            divPivot = divTransform.pivotX;
        }
        if ((i & 2) != 0) {
            divPivot2 = divTransform.pivotY;
        }
        if ((i & 4) != 0) {
            expression = divTransform.rotation;
        }
        return divTransform.copy(divPivot, divPivot2, expression);
    }

    public final DivTransform copy(DivPivot pivotX, DivPivot pivotY, Expression<Double> rotation) {
        Intrinsics.checkNotNullParameter(pivotX, "pivotX");
        Intrinsics.checkNotNullParameter(pivotY, "pivotY");
        return new DivTransform(pivotX, pivotY, rotation);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivTransformJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivTransform.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0010R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div2/DivTransform$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTransform;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "PIVOT_X_DEFAULT_VALUE", "Lcom/yandex/div2/DivPivot$Percentage;", "PIVOT_Y_DEFAULT_VALUE", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivTransform fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivTransformJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivTransform> getCREATOR() {
            return DivTransform.CREATOR;
        }
    }

    static {
        Expression.Companion companion = Expression.INSTANCE;
        Double dValueOf = Double.valueOf(50.0d);
        PIVOT_X_DEFAULT_VALUE = new DivPivot.Percentage(new DivPivotPercentage(companion.constant(dValueOf)));
        PIVOT_Y_DEFAULT_VALUE = new DivPivot.Percentage(new DivPivotPercentage(Expression.INSTANCE.constant(dValueOf)));
        CREATOR = new Function2<ParsingEnvironment, JSONObject, DivTransform>() { // from class: com.yandex.div2.DivTransform$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivTransform invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivTransform.INSTANCE.fromJson(env, it);
            }
        };
    }
}
