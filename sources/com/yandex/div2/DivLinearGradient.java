package com.yandex.div2;

import com.json.b9;
import com.json.cc;
import com.yandex.div.data.Hashable;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionList;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivLinearGradient.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0002\u0019\u001aB;\b\u0007\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ:\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ \u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/yandex/div2/DivLinearGradient;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "angle", "Lcom/yandex/div/json/expressions/Expression;", "", "colorMap", "", "Lcom/yandex/div2/DivLinearGradient$ColorPoint;", "colors", "Lcom/yandex/div/json/expressions/ExpressionList;", "", "(Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div/json/expressions/ExpressionList;)V", "_hash", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "ColorPoint", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivLinearGradient implements JSONSerializable, Hashable {
    public static final String TYPE = "gradient";
    private Integer _hash;
    public final Expression<Long> angle;
    public final List<ColorPoint> colorMap;
    public final ExpressionList<Integer> colors;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Long> ANGLE_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Function2<ParsingEnvironment, JSONObject, DivLinearGradient> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivLinearGradient>() { // from class: com.yandex.div2.DivLinearGradient$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivLinearGradient invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivLinearGradient.INSTANCE.fromJson(env, it);
        }
    };

    public DivLinearGradient() {
        this(null, null, null, 7, null);
    }

    @JvmStatic
    public static final DivLinearGradient fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivLinearGradient(Expression<Long> angle, List<ColorPoint> list, ExpressionList<Integer> expressionList) {
        Intrinsics.checkNotNullParameter(angle, "angle");
        this.angle = angle;
        this.colorMap = list;
        this.colors = expressionList;
    }

    public /* synthetic */ DivLinearGradient(Expression expression, List list, ExpressionList expressionList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ANGLE_DEFAULT_VALUE : expression, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : expressionList);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        int iHash;
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.angle.hashCode();
        List<ColorPoint> list = this.colorMap;
        if (list != null) {
            Iterator<T> it = list.iterator();
            iHash = 0;
            while (it.hasNext()) {
                iHash += ((ColorPoint) it.next()).hash();
            }
        } else {
            iHash = 0;
        }
        int i = iHashCode + iHash;
        ExpressionList<Integer> expressionList = this.colors;
        int iHashCode2 = i + (expressionList != null ? expressionList.hashCode() : 0);
        this._hash = Integer.valueOf(iHashCode2);
        return iHashCode2;
    }

    public final boolean equals(DivLinearGradient other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        List<Integer> listEvaluate;
        List<Integer> listEvaluate2;
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null || this.angle.evaluate(resolver).longValue() != other.angle.evaluate(otherResolver).longValue()) {
            return false;
        }
        List<ColorPoint> list = this.colorMap;
        if (list != null) {
            List<ColorPoint> list2 = other.colorMap;
            if (list2 == null || list.size() != list2.size()) {
                return false;
            }
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (!((ColorPoint) obj).equals(list2.get(i), resolver, otherResolver)) {
                    return false;
                }
                i = i2;
            }
        } else if (other.colorMap != null) {
            return false;
        }
        ExpressionList<Integer> expressionList = this.colors;
        if (expressionList == null || (listEvaluate = expressionList.evaluate(resolver)) == null) {
            if (other.colors != null) {
                return false;
            }
        } else {
            ExpressionList<Integer> expressionList2 = other.colors;
            if (expressionList2 == null || (listEvaluate2 = expressionList2.evaluate(otherResolver)) == null || listEvaluate.size() != listEvaluate2.size()) {
                return false;
            }
            int i3 = 0;
            for (Object obj2 : listEvaluate) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (((Number) obj2).intValue() != listEvaluate2.get(i3).intValue()) {
                    return false;
                }
                i3 = i4;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivLinearGradient copy$default(DivLinearGradient divLinearGradient, Expression expression, List list, ExpressionList expressionList, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divLinearGradient.angle;
        }
        if ((i & 2) != 0) {
            list = divLinearGradient.colorMap;
        }
        if ((i & 4) != 0) {
            expressionList = divLinearGradient.colors;
        }
        return divLinearGradient.copy(expression, list, expressionList);
    }

    public final DivLinearGradient copy(Expression<Long> angle, List<ColorPoint> colorMap, ExpressionList<Integer> colors) {
        Intrinsics.checkNotNullParameter(angle, "angle");
        return new DivLinearGradient(angle, colorMap, colors);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivLinearGradientJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivLinearGradient.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u0012R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/yandex/div2/DivLinearGradient$Companion;", "", "()V", "ANGLE_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivLinearGradient;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivLinearGradient fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivLinearGradientJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivLinearGradient> getCREATOR() {
            return DivLinearGradient.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivLinearGradient.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B#\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\u0010\bJ&\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004J \u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yandex/div2/DivLinearGradient$ColorPoint;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "color", "Lcom/yandex/div/json/expressions/Expression;", "", b9.h.L, "", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ColorPoint implements JSONSerializable, Hashable {
        private Integer _hash;
        public final Expression<Integer> color;
        public final Expression<Double> position;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Function2<ParsingEnvironment, JSONObject, ColorPoint> CREATOR = new Function2<ParsingEnvironment, JSONObject, ColorPoint>() { // from class: com.yandex.div2.DivLinearGradient$ColorPoint$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivLinearGradient.ColorPoint invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivLinearGradient.ColorPoint.INSTANCE.fromJson(env, it);
            }
        };

        @JvmStatic
        public static final ColorPoint fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
            return INSTANCE.fromJson(parsingEnvironment, jSONObject);
        }

        public ColorPoint(Expression<Integer> color, Expression<Double> position) {
            Intrinsics.checkNotNullParameter(color, "color");
            Intrinsics.checkNotNullParameter(position, "position");
            this.color = color;
            this.position = position;
        }

        @Override // com.yandex.div.data.Hashable
        public int hash() {
            Integer num = this._hash;
            if (num != null) {
                return num.intValue();
            }
            int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.color.hashCode() + this.position.hashCode();
            this._hash = Integer.valueOf(iHashCode);
            return iHashCode;
        }

        public final boolean equals(ColorPoint other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
            return other != null && this.color.evaluate(resolver).intValue() == other.color.evaluate(otherResolver).intValue() && this.position.evaluate(resolver).doubleValue() == other.position.evaluate(otherResolver).doubleValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ColorPoint copy$default(ColorPoint colorPoint, Expression expression, Expression expression2, int i, Object obj) {
            if ((i & 1) != 0) {
                expression = colorPoint.color;
            }
            if ((i & 2) != 0) {
                expression2 = colorPoint.position;
            }
            return colorPoint.copy(expression, expression2);
        }

        public final ColorPoint copy(Expression<Integer> color, Expression<Double> position) {
            Intrinsics.checkNotNullParameter(color, "color");
            Intrinsics.checkNotNullParameter(position, "position");
            return new ColorPoint(color, position);
        }

        @Override // com.yandex.div.json.JSONSerializable
        public JSONObject writeToJSON() {
            return BuiltInParserKt.getBuiltInParserComponent().getDivLinearGradientColorPointJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
        }

        /* JADX INFO: compiled from: DivLinearGradient.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivLinearGradient$ColorPoint$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivLinearGradient$ColorPoint;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final ColorPoint fromJson(ParsingEnvironment env, JSONObject json) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(json, "json");
                return BuiltInParserKt.getBuiltInParserComponent().getDivLinearGradientColorPointJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
            }

            public final Function2<ParsingEnvironment, JSONObject, ColorPoint> getCREATOR() {
                return ColorPoint.CREATOR;
            }
        }
    }
}
