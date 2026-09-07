package com.yandex.div2;

import com.json.cc;
import com.yandex.div.data.Hashable;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionList;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivRadialGradient.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B3\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ4\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nJ \u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0012\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/yandex/div2/DivRadialGradient;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "centerX", "Lcom/yandex/div2/DivRadialGradientCenter;", "centerY", "colors", "Lcom/yandex/div/json/expressions/ExpressionList;", "", "radius", "Lcom/yandex/div2/DivRadialGradientRadius;", "(Lcom/yandex/div2/DivRadialGradientCenter;Lcom/yandex/div2/DivRadialGradientCenter;Lcom/yandex/div/json/expressions/ExpressionList;Lcom/yandex/div2/DivRadialGradientRadius;)V", "_hash", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivRadialGradient implements JSONSerializable, Hashable {
    private static final DivRadialGradientCenter.Relative CENTER_X_DEFAULT_VALUE;
    private static final DivRadialGradientCenter.Relative CENTER_Y_DEFAULT_VALUE;
    private static final Function2<ParsingEnvironment, JSONObject, DivRadialGradient> CREATOR;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DivRadialGradientRadius.Relative RADIUS_DEFAULT_VALUE;
    public static final String TYPE = "radial_gradient";
    private Integer _hash;
    public final DivRadialGradientCenter centerX;
    public final DivRadialGradientCenter centerY;
    public final ExpressionList<Integer> colors;
    public final DivRadialGradientRadius radius;

    @JvmStatic
    public static final DivRadialGradient fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivRadialGradient(DivRadialGradientCenter centerX, DivRadialGradientCenter centerY, ExpressionList<Integer> colors, DivRadialGradientRadius radius) {
        Intrinsics.checkNotNullParameter(centerX, "centerX");
        Intrinsics.checkNotNullParameter(centerY, "centerY");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(radius, "radius");
        this.centerX = centerX;
        this.centerY = centerY;
        this.colors = colors;
        this.radius = radius;
    }

    public /* synthetic */ DivRadialGradient(DivRadialGradientCenter.Relative relative, DivRadialGradientCenter.Relative relative2, ExpressionList expressionList, DivRadialGradientRadius.Relative relative3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CENTER_X_DEFAULT_VALUE : relative, (i & 2) != 0 ? CENTER_Y_DEFAULT_VALUE : relative2, expressionList, (i & 8) != 0 ? RADIUS_DEFAULT_VALUE : relative3);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.centerX.hash() + this.centerY.hash() + this.colors.hashCode() + this.radius.hash();
        this._hash = Integer.valueOf(iHashCode);
        return iHashCode;
    }

    public final boolean equals(DivRadialGradient other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null || !this.centerX.equals(other.centerX, resolver, otherResolver) || !this.centerY.equals(other.centerY, resolver, otherResolver)) {
            return false;
        }
        List<Integer> listEvaluate = this.colors.evaluate(resolver);
        List<Integer> listEvaluate2 = other.colors.evaluate(otherResolver);
        if (listEvaluate.size() != listEvaluate2.size()) {
            return false;
        }
        int i = 0;
        for (Object obj : listEvaluate) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (((Number) obj).intValue() != listEvaluate2.get(i).intValue()) {
                return false;
            }
            i = i2;
        }
        return this.radius.equals(other.radius, resolver, otherResolver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivRadialGradient copy$default(DivRadialGradient divRadialGradient, DivRadialGradientCenter divRadialGradientCenter, DivRadialGradientCenter divRadialGradientCenter2, ExpressionList expressionList, DivRadialGradientRadius divRadialGradientRadius, int i, Object obj) {
        if ((i & 1) != 0) {
            divRadialGradientCenter = divRadialGradient.centerX;
        }
        if ((i & 2) != 0) {
            divRadialGradientCenter2 = divRadialGradient.centerY;
        }
        if ((i & 4) != 0) {
            expressionList = divRadialGradient.colors;
        }
        if ((i & 8) != 0) {
            divRadialGradientRadius = divRadialGradient.radius;
        }
        return divRadialGradient.copy(divRadialGradientCenter, divRadialGradientCenter2, expressionList, divRadialGradientRadius);
    }

    public final DivRadialGradient copy(DivRadialGradientCenter centerX, DivRadialGradientCenter centerY, ExpressionList<Integer> colors, DivRadialGradientRadius radius) {
        Intrinsics.checkNotNullParameter(centerX, "centerX");
        Intrinsics.checkNotNullParameter(centerY, "centerY");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(radius, "radius");
        return new DivRadialGradient(centerX, centerY, colors, radius);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivRadialGradientJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivRadialGradient.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div2/DivRadialGradient$Companion;", "", "()V", "CENTER_X_DEFAULT_VALUE", "Lcom/yandex/div2/DivRadialGradientCenter$Relative;", "CENTER_Y_DEFAULT_VALUE", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivRadialGradient;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "RADIUS_DEFAULT_VALUE", "Lcom/yandex/div2/DivRadialGradientRadius$Relative;", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivRadialGradient fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivRadialGradientJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivRadialGradient> getCREATOR() {
            return DivRadialGradient.CREATOR;
        }
    }

    static {
        Expression.Companion companion = Expression.INSTANCE;
        Double dValueOf = Double.valueOf(0.5d);
        CENTER_X_DEFAULT_VALUE = new DivRadialGradientCenter.Relative(new DivRadialGradientRelativeCenter(companion.constant(dValueOf)));
        CENTER_Y_DEFAULT_VALUE = new DivRadialGradientCenter.Relative(new DivRadialGradientRelativeCenter(Expression.INSTANCE.constant(dValueOf)));
        RADIUS_DEFAULT_VALUE = new DivRadialGradientRadius.Relative(new DivRadialGradientRelativeRadius(Expression.INSTANCE.constant(DivRadialGradientRelativeRadius.Value.FARTHEST_CORNER)));
        CREATOR = new Function2<ParsingEnvironment, JSONObject, DivRadialGradient>() { // from class: com.yandex.div2.DivRadialGradient$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivRadialGradient invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivRadialGradient.INSTANCE.fromJson(env, it);
            }
        };
    }
}
