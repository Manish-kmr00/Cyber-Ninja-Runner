package com.yandex.div2;

import com.json.cc;
import com.yandex.div.data.Hashable;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivRoundedRectangleShape.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019BC\b\u0007\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJB\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ \u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0012\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/yandex/div2/DivRoundedRectangleShape;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "backgroundColor", "Lcom/yandex/div/json/expressions/Expression;", "", "cornerRadius", "Lcom/yandex/div2/DivFixedSize;", "itemHeight", "itemWidth", VastAttributes.STROKE_COLOR, "Lcom/yandex/div2/DivStroke;", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivFixedSize;Lcom/yandex/div2/DivFixedSize;Lcom/yandex/div2/DivFixedSize;Lcom/yandex/div2/DivStroke;)V", "_hash", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivRoundedRectangleShape implements JSONSerializable, Hashable {
    private static final DivFixedSize CORNER_RADIUS_DEFAULT_VALUE;
    private static final DivFixedSize ITEM_HEIGHT_DEFAULT_VALUE;
    private static final DivFixedSize ITEM_WIDTH_DEFAULT_VALUE;
    public static final String TYPE = "rounded_rectangle";
    private Integer _hash;
    public final Expression<Integer> backgroundColor;
    public final DivFixedSize cornerRadius;
    public final DivFixedSize itemHeight;
    public final DivFixedSize itemWidth;
    public final DivStroke stroke;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivRoundedRectangleShape> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivRoundedRectangleShape>() { // from class: com.yandex.div2.DivRoundedRectangleShape$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivRoundedRectangleShape invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivRoundedRectangleShape.INSTANCE.fromJson(env, it);
        }
    };

    public DivRoundedRectangleShape() {
        this(null, null, null, null, null, 31, null);
    }

    @JvmStatic
    public static final DivRoundedRectangleShape fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivRoundedRectangleShape(Expression<Integer> expression, DivFixedSize cornerRadius, DivFixedSize itemHeight, DivFixedSize itemWidth, DivStroke divStroke) {
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        Intrinsics.checkNotNullParameter(itemHeight, "itemHeight");
        Intrinsics.checkNotNullParameter(itemWidth, "itemWidth");
        this.backgroundColor = expression;
        this.cornerRadius = cornerRadius;
        this.itemHeight = itemHeight;
        this.itemWidth = itemWidth;
        this.stroke = divStroke;
    }

    public /* synthetic */ DivRoundedRectangleShape(Expression expression, DivFixedSize divFixedSize, DivFixedSize divFixedSize2, DivFixedSize divFixedSize3, DivStroke divStroke, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : expression, (i & 2) != 0 ? CORNER_RADIUS_DEFAULT_VALUE : divFixedSize, (i & 4) != 0 ? ITEM_HEIGHT_DEFAULT_VALUE : divFixedSize2, (i & 8) != 0 ? ITEM_WIDTH_DEFAULT_VALUE : divFixedSize3, (i & 16) != 0 ? null : divStroke);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        Expression<Integer> expression = this.backgroundColor;
        int iHashCode2 = iHashCode + (expression != null ? expression.hashCode() : 0) + this.cornerRadius.hash() + this.itemHeight.hash() + this.itemWidth.hash();
        DivStroke divStroke = this.stroke;
        int iHash = iHashCode2 + (divStroke != null ? divStroke.hash() : 0);
        this._hash = Integer.valueOf(iHash);
        return iHash;
    }

    public final boolean equals(DivRoundedRectangleShape other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        boolean zEquals;
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        Expression<Integer> expression = this.backgroundColor;
        Integer numEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<Integer> expression2 = other.backgroundColor;
        if (!Intrinsics.areEqual(numEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null) || !this.cornerRadius.equals(other.cornerRadius, resolver, otherResolver) || !this.itemHeight.equals(other.itemHeight, resolver, otherResolver) || !this.itemWidth.equals(other.itemWidth, resolver, otherResolver)) {
            return false;
        }
        DivStroke divStroke = this.stroke;
        DivStroke divStroke2 = other.stroke;
        if (divStroke != null) {
            zEquals = divStroke.equals(divStroke2, resolver, otherResolver);
        } else {
            zEquals = divStroke2 == null;
        }
        return zEquals;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivRoundedRectangleShape copy$default(DivRoundedRectangleShape divRoundedRectangleShape, Expression expression, DivFixedSize divFixedSize, DivFixedSize divFixedSize2, DivFixedSize divFixedSize3, DivStroke divStroke, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divRoundedRectangleShape.backgroundColor;
        }
        if ((i & 2) != 0) {
            divFixedSize = divRoundedRectangleShape.cornerRadius;
        }
        DivFixedSize divFixedSize4 = divFixedSize;
        if ((i & 4) != 0) {
            divFixedSize2 = divRoundedRectangleShape.itemHeight;
        }
        DivFixedSize divFixedSize5 = divFixedSize2;
        if ((i & 8) != 0) {
            divFixedSize3 = divRoundedRectangleShape.itemWidth;
        }
        DivFixedSize divFixedSize6 = divFixedSize3;
        if ((i & 16) != 0) {
            divStroke = divRoundedRectangleShape.stroke;
        }
        return divRoundedRectangleShape.copy(expression, divFixedSize4, divFixedSize5, divFixedSize6, divStroke);
    }

    public final DivRoundedRectangleShape copy(Expression<Integer> backgroundColor, DivFixedSize cornerRadius, DivFixedSize itemHeight, DivFixedSize itemWidth, DivStroke stroke) {
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        Intrinsics.checkNotNullParameter(itemHeight, "itemHeight");
        Intrinsics.checkNotNullParameter(itemWidth, "itemWidth");
        return new DivRoundedRectangleShape(backgroundColor, cornerRadius, itemHeight, itemWidth, stroke);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivRoundedRectangleShapeJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivRoundedRectangleShape.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\bH\u0087\u0002¢\u0006\u0002\b\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/yandex/div2/DivRoundedRectangleShape$Companion;", "", "()V", "CORNER_RADIUS_DEFAULT_VALUE", "Lcom/yandex/div2/DivFixedSize;", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivRoundedRectangleShape;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "ITEM_HEIGHT_DEFAULT_VALUE", "ITEM_WIDTH_DEFAULT_VALUE", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivRoundedRectangleShape fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivRoundedRectangleShapeJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivRoundedRectangleShape> getCREATOR() {
            return DivRoundedRectangleShape.CREATOR;
        }
    }

    static {
        int i = 1;
        CORNER_RADIUS_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(5L), i, 0 == true ? 1 : 0);
        ITEM_HEIGHT_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(10L), i, 0 == true ? 1 : 0);
        ITEM_WIDTH_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(10L), i, 0 == true ? 1 : 0);
    }
}
