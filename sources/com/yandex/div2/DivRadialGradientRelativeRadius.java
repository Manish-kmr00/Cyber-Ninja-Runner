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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivRadialGradientRelativeRadius.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0002\u0014\u0015B\u0015\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J \u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yandex/div2/DivRadialGradientRelativeRadius;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "value", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivRadialGradientRelativeRadius$Value;", "(Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "Value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivRadialGradientRelativeRadius implements JSONSerializable, Hashable {
    public static final String TYPE = "relative";
    private Integer _hash;
    public final Expression<Value> value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivRadialGradientRelativeRadius> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivRadialGradientRelativeRadius>() { // from class: com.yandex.div2.DivRadialGradientRelativeRadius$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivRadialGradientRelativeRadius invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivRadialGradientRelativeRadius.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivRadialGradientRelativeRadius fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivRadialGradientRelativeRadius(Expression<Value> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.value.hashCode();
        this._hash = Integer.valueOf(iHashCode);
        return iHashCode;
    }

    public final boolean equals(DivRadialGradientRelativeRadius other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        return other != null && this.value.evaluate(resolver) == other.value.evaluate(otherResolver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivRadialGradientRelativeRadius copy$default(DivRadialGradientRelativeRadius divRadialGradientRelativeRadius, Expression expression, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divRadialGradientRelativeRadius.value;
        }
        return divRadialGradientRelativeRadius.copy(expression);
    }

    public final DivRadialGradientRelativeRadius copy(Expression<Value> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new DivRadialGradientRelativeRadius(value);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivRadialGradientRelativeRadiusJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivRadialGradientRelativeRadius.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u000fR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yandex/div2/DivRadialGradientRelativeRadius$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivRadialGradientRelativeRadius;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivRadialGradientRelativeRadius fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivRadialGradientRelativeRadiusJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivRadialGradientRelativeRadius> getCREATOR() {
            return DivRadialGradientRelativeRadius.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivRadialGradientRelativeRadius.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/yandex/div2/DivRadialGradientRelativeRadius$Value;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "NEAREST_CORNER", "FARTHEST_CORNER", "NEAREST_SIDE", "FARTHEST_SIDE", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Value {
        NEAREST_CORNER("nearest_corner"),
        FARTHEST_CORNER("farthest_corner"),
        NEAREST_SIDE("nearest_side"),
        FARTHEST_SIDE("farthest_side");

        private final String value;

        /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Function1<Value, String> TO_STRING = new Function1<Value, String>() { // from class: com.yandex.div2.DivRadialGradientRelativeRadius$Value$Converter$TO_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(DivRadialGradientRelativeRadius.Value value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivRadialGradientRelativeRadius.Value.INSTANCE.toString(value);
            }
        };
        public static final Function1<String, Value> FROM_STRING = new Function1<String, Value>() { // from class: com.yandex.div2.DivRadialGradientRelativeRadius$Value$Converter$FROM_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final DivRadialGradientRelativeRadius.Value invoke(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivRadialGradientRelativeRadius.Value.INSTANCE.fromString(value);
            }
        };

        Value(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: com.yandex.div2.DivRadialGradientRelativeRadius$Value$Converter, reason: from kotlin metadata */
        /* JADX INFO: compiled from: DivRadialGradientRelativeRadius.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivRadialGradientRelativeRadius$Value$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivRadialGradientRelativeRadius$Value;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String toString(Value obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return obj.value;
            }

            public final Value fromString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(value, Value.NEAREST_CORNER.value)) {
                    return Value.NEAREST_CORNER;
                }
                if (Intrinsics.areEqual(value, Value.FARTHEST_CORNER.value)) {
                    return Value.FARTHEST_CORNER;
                }
                if (Intrinsics.areEqual(value, Value.NEAREST_SIDE.value)) {
                    return Value.NEAREST_SIDE;
                }
                if (Intrinsics.areEqual(value, Value.FARTHEST_SIDE.value)) {
                    return Value.FARTHEST_SIDE;
                }
                return null;
            }
        }
    }
}
