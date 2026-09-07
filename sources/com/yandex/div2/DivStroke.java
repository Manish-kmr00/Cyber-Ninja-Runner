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

/* JADX INFO: compiled from: DivStroke.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B?\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0002\u0010\fJ@\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004J \u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0012\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/yandex/div2/DivStroke;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "color", "Lcom/yandex/div/json/expressions/Expression;", "", "style", "Lcom/yandex/div2/DivStrokeStyle;", "unit", "Lcom/yandex/div2/DivSizeUnit;", "width", "", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivStrokeStyle;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivStroke implements JSONSerializable, Hashable {
    private Integer _hash;
    public final Expression<Integer> color;
    public final DivStrokeStyle style;
    public final Expression<DivSizeUnit> unit;
    public final Expression<Double> width;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DivStrokeStyle.Solid STYLE_DEFAULT_VALUE = new DivStrokeStyle.Solid(new DivStrokeStyleSolid());
    private static final Expression<DivSizeUnit> UNIT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivSizeUnit.DP);
    private static final Expression<Double> WIDTH_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(1.0d));
    private static final Function2<ParsingEnvironment, JSONObject, DivStroke> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivStroke>() { // from class: com.yandex.div2.DivStroke$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivStroke invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivStroke.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivStroke fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivStroke(Expression<Integer> color, DivStrokeStyle style, Expression<DivSizeUnit> unit, Expression<Double> width) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(width, "width");
        this.color = color;
        this.style = style;
        this.unit = unit;
        this.width = width;
    }

    public /* synthetic */ DivStroke(Expression expression, DivStrokeStyle.Solid solid, Expression expression2, Expression expression3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(expression, (i & 2) != 0 ? STYLE_DEFAULT_VALUE : solid, (i & 4) != 0 ? UNIT_DEFAULT_VALUE : expression2, (i & 8) != 0 ? WIDTH_DEFAULT_VALUE : expression3);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.color.hashCode() + this.style.hash() + this.unit.hashCode() + this.width.hashCode();
        this._hash = Integer.valueOf(iHashCode);
        return iHashCode;
    }

    public final boolean equals(DivStroke other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        return other != null && this.color.evaluate(resolver).intValue() == other.color.evaluate(otherResolver).intValue() && this.style.equals(other.style, resolver, otherResolver) && this.unit.evaluate(resolver) == other.unit.evaluate(otherResolver) && this.width.evaluate(resolver).doubleValue() == other.width.evaluate(otherResolver).doubleValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivStroke copy$default(DivStroke divStroke, Expression expression, DivStrokeStyle divStrokeStyle, Expression expression2, Expression expression3, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divStroke.color;
        }
        if ((i & 2) != 0) {
            divStrokeStyle = divStroke.style;
        }
        if ((i & 4) != 0) {
            expression2 = divStroke.unit;
        }
        if ((i & 8) != 0) {
            expression3 = divStroke.width;
        }
        return divStroke.copy(expression, divStrokeStyle, expression2, expression3);
    }

    public final DivStroke copy(Expression<Integer> color, DivStrokeStyle style, Expression<DivSizeUnit> unit, Expression<Double> width) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(width, "width");
        return new DivStroke(color, style, unit, width);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivStrokeJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivStroke.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0014R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div2/DivStroke$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivStroke;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "STYLE_DEFAULT_VALUE", "Lcom/yandex/div2/DivStrokeStyle$Solid;", "UNIT_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivSizeUnit;", "WIDTH_DEFAULT_VALUE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivStroke fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivStrokeJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivStroke> getCREATOR() {
            return DivStroke.CREATOR;
        }
    }
}
