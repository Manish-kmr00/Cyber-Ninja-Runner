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

/* JADX INFO: compiled from: DivCircleShape.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B/\b\u0007\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ.\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tJ \u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div2/DivCircleShape;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "backgroundColor", "Lcom/yandex/div/json/expressions/Expression;", "", "radius", "Lcom/yandex/div2/DivFixedSize;", VastAttributes.STROKE_COLOR, "Lcom/yandex/div2/DivStroke;", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivFixedSize;Lcom/yandex/div2/DivStroke;)V", "_hash", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivCircleShape implements JSONSerializable, Hashable {
    public static final String TYPE = "circle";
    private Integer _hash;
    public final Expression<Integer> backgroundColor;
    public final DivFixedSize radius;
    public final DivStroke stroke;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DivFixedSize RADIUS_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(10L), 1, 0 == true ? 1 : 0);
    private static final Function2<ParsingEnvironment, JSONObject, DivCircleShape> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivCircleShape>() { // from class: com.yandex.div2.DivCircleShape$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivCircleShape invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivCircleShape.INSTANCE.fromJson(env, it);
        }
    };

    public DivCircleShape() {
        this(null, null, null, 7, null);
    }

    @JvmStatic
    public static final DivCircleShape fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivCircleShape(Expression<Integer> expression, DivFixedSize radius, DivStroke divStroke) {
        Intrinsics.checkNotNullParameter(radius, "radius");
        this.backgroundColor = expression;
        this.radius = radius;
        this.stroke = divStroke;
    }

    public /* synthetic */ DivCircleShape(Expression expression, DivFixedSize divFixedSize, DivStroke divStroke, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : expression, (i & 2) != 0 ? RADIUS_DEFAULT_VALUE : divFixedSize, (i & 4) != 0 ? null : divStroke);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        Expression<Integer> expression = this.backgroundColor;
        int iHashCode2 = iHashCode + (expression != null ? expression.hashCode() : 0) + this.radius.hash();
        DivStroke divStroke = this.stroke;
        int iHash = iHashCode2 + (divStroke != null ? divStroke.hash() : 0);
        this._hash = Integer.valueOf(iHash);
        return iHash;
    }

    public final boolean equals(DivCircleShape other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        boolean zEquals;
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        Expression<Integer> expression = this.backgroundColor;
        Integer numEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<Integer> expression2 = other.backgroundColor;
        if (!Intrinsics.areEqual(numEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null) || !this.radius.equals(other.radius, resolver, otherResolver)) {
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
    public static /* synthetic */ DivCircleShape copy$default(DivCircleShape divCircleShape, Expression expression, DivFixedSize divFixedSize, DivStroke divStroke, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divCircleShape.backgroundColor;
        }
        if ((i & 2) != 0) {
            divFixedSize = divCircleShape.radius;
        }
        if ((i & 4) != 0) {
            divStroke = divCircleShape.stroke;
        }
        return divCircleShape.copy(expression, divFixedSize, divStroke);
    }

    public final DivCircleShape copy(Expression<Integer> backgroundColor, DivFixedSize radius, DivStroke stroke) {
        Intrinsics.checkNotNullParameter(radius, "radius");
        return new DivCircleShape(backgroundColor, radius, stroke);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivCircleShapeJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivCircleShape.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0011R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/yandex/div2/DivCircleShape$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivCircleShape;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "RADIUS_DEFAULT_VALUE", "Lcom/yandex/div2/DivFixedSize;", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivCircleShape fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivCircleShapeJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivCircleShape> getCREATOR() {
            return DivCircleShape.CREATOR;
        }
    }
}
