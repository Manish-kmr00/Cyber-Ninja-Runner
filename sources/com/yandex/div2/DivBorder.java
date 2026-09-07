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

/* JADX INFO: compiled from: DivBorder.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bBM\b\u0007\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJL\u0010\u0012\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ \u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yandex/div2/DivBorder;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "cornerRadius", "Lcom/yandex/div/json/expressions/Expression;", "", "cornersRadius", "Lcom/yandex/div2/DivCornersRadius;", "hasShadow", "", "shadow", "Lcom/yandex/div2/DivShadow;", VastAttributes.STROKE_COLOR, "Lcom/yandex/div2/DivStroke;", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivCornersRadius;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivShadow;Lcom/yandex/div2/DivStroke;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivBorder implements JSONSerializable, Hashable {
    private Integer _hash;
    public final Expression<Long> cornerRadius;
    public final DivCornersRadius cornersRadius;
    public final Expression<Boolean> hasShadow;
    public final DivShadow shadow;
    public final DivStroke stroke;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Boolean> HAS_SHADOW_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
    private static final Function2<ParsingEnvironment, JSONObject, DivBorder> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivBorder>() { // from class: com.yandex.div2.DivBorder$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivBorder invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivBorder.INSTANCE.fromJson(env, it);
        }
    };

    public DivBorder() {
        this(null, null, null, null, null, 31, null);
    }

    @JvmStatic
    public static final DivBorder fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivBorder(Expression<Long> expression, DivCornersRadius divCornersRadius, Expression<Boolean> hasShadow, DivShadow divShadow, DivStroke divStroke) {
        Intrinsics.checkNotNullParameter(hasShadow, "hasShadow");
        this.cornerRadius = expression;
        this.cornersRadius = divCornersRadius;
        this.hasShadow = hasShadow;
        this.shadow = divShadow;
        this.stroke = divStroke;
    }

    public /* synthetic */ DivBorder(Expression expression, DivCornersRadius divCornersRadius, Expression expression2, DivShadow divShadow, DivStroke divStroke, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : expression, (i & 2) != 0 ? null : divCornersRadius, (i & 4) != 0 ? HAS_SHADOW_DEFAULT_VALUE : expression2, (i & 8) != 0 ? null : divShadow, (i & 16) != 0 ? null : divStroke);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        Expression<Long> expression = this.cornerRadius;
        int iHashCode2 = iHashCode + (expression != null ? expression.hashCode() : 0);
        DivCornersRadius divCornersRadius = this.cornersRadius;
        int iHash = iHashCode2 + (divCornersRadius != null ? divCornersRadius.hash() : 0) + this.hasShadow.hashCode();
        DivShadow divShadow = this.shadow;
        int iHash2 = iHash + (divShadow != null ? divShadow.hash() : 0);
        DivStroke divStroke = this.stroke;
        int iHash3 = iHash2 + (divStroke != null ? divStroke.hash() : 0);
        this._hash = Integer.valueOf(iHash3);
        return iHash3;
    }

    public final boolean equals(DivBorder other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        boolean zEquals;
        boolean zEquals2;
        boolean zEquals3;
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        Expression<Long> expression = this.cornerRadius;
        Long lEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<Long> expression2 = other.cornerRadius;
        if (!Intrinsics.areEqual(lEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null)) {
            return false;
        }
        DivCornersRadius divCornersRadius = this.cornersRadius;
        if (divCornersRadius != null) {
            zEquals = divCornersRadius.equals(other.cornersRadius, resolver, otherResolver);
        } else {
            zEquals = other.cornersRadius == null;
        }
        if (!zEquals || this.hasShadow.evaluate(resolver).booleanValue() != other.hasShadow.evaluate(otherResolver).booleanValue()) {
            return false;
        }
        DivShadow divShadow = this.shadow;
        if (divShadow != null) {
            zEquals2 = divShadow.equals(other.shadow, resolver, otherResolver);
        } else {
            zEquals2 = other.shadow == null;
        }
        if (!zEquals2) {
            return false;
        }
        DivStroke divStroke = this.stroke;
        DivStroke divStroke2 = other.stroke;
        if (divStroke != null) {
            zEquals3 = divStroke.equals(divStroke2, resolver, otherResolver);
        } else {
            zEquals3 = divStroke2 == null;
        }
        return zEquals3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivBorder copy$default(DivBorder divBorder, Expression expression, DivCornersRadius divCornersRadius, Expression expression2, DivShadow divShadow, DivStroke divStroke, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divBorder.cornerRadius;
        }
        if ((i & 2) != 0) {
            divCornersRadius = divBorder.cornersRadius;
        }
        DivCornersRadius divCornersRadius2 = divCornersRadius;
        if ((i & 4) != 0) {
            expression2 = divBorder.hasShadow;
        }
        Expression expression3 = expression2;
        if ((i & 8) != 0) {
            divShadow = divBorder.shadow;
        }
        DivShadow divShadow2 = divShadow;
        if ((i & 16) != 0) {
            divStroke = divBorder.stroke;
        }
        return divBorder.copy(expression, divCornersRadius2, expression3, divShadow2, divStroke);
    }

    public final DivBorder copy(Expression<Long> cornerRadius, DivCornersRadius cornersRadius, Expression<Boolean> hasShadow, DivShadow shadow, DivStroke stroke) {
        Intrinsics.checkNotNullParameter(hasShadow, "hasShadow");
        return new DivBorder(cornerRadius, cornersRadius, hasShadow, shadow, stroke);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivBorderJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivBorder.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0010R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div2/DivBorder$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivBorder;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "HAS_SHADOW_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivBorder fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivBorderJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivBorder> getCREATOR() {
            return DivBorder.CREATOR;
        }
    }
}
