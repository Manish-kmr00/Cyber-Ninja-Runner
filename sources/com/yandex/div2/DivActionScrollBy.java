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

/* JADX INFO: compiled from: DivActionScrollBy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0002\u001a\u001bBU\b\u0007\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\u0010\rJV\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004J \u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yandex/div2/DivActionScrollBy;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "animated", "Lcom/yandex/div/json/expressions/Expression;", "", "id", "", "itemCount", "", "offset", "overflow", "Lcom/yandex/div2/DivActionScrollBy$Overflow;", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "Overflow", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivActionScrollBy implements JSONSerializable, Hashable {
    public static final String TYPE = "scroll_by";
    private Integer _hash;
    public final Expression<Boolean> animated;
    public final Expression<String> id;
    public final Expression<Long> itemCount;
    public final Expression<Long> offset;
    public final Expression<Overflow> overflow;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Boolean> ANIMATED_DEFAULT_VALUE = Expression.INSTANCE.constant(true);
    private static final Expression<Long> ITEM_COUNT_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Expression<Long> OFFSET_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Expression<Overflow> OVERFLOW_DEFAULT_VALUE = Expression.INSTANCE.constant(Overflow.CLAMP);
    private static final Function2<ParsingEnvironment, JSONObject, DivActionScrollBy> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivActionScrollBy>() { // from class: com.yandex.div2.DivActionScrollBy$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivActionScrollBy invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivActionScrollBy.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivActionScrollBy fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivActionScrollBy(Expression<Boolean> animated, Expression<String> id, Expression<Long> itemCount, Expression<Long> offset, Expression<Overflow> overflow) {
        Intrinsics.checkNotNullParameter(animated, "animated");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(itemCount, "itemCount");
        Intrinsics.checkNotNullParameter(offset, "offset");
        Intrinsics.checkNotNullParameter(overflow, "overflow");
        this.animated = animated;
        this.id = id;
        this.itemCount = itemCount;
        this.offset = offset;
        this.overflow = overflow;
    }

    public /* synthetic */ DivActionScrollBy(Expression expression, Expression expression2, Expression expression3, Expression expression4, Expression expression5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ANIMATED_DEFAULT_VALUE : expression, expression2, (i & 4) != 0 ? ITEM_COUNT_DEFAULT_VALUE : expression3, (i & 8) != 0 ? OFFSET_DEFAULT_VALUE : expression4, (i & 16) != 0 ? OVERFLOW_DEFAULT_VALUE : expression5);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.animated.hashCode() + this.id.hashCode() + this.itemCount.hashCode() + this.offset.hashCode() + this.overflow.hashCode();
        this._hash = Integer.valueOf(iHashCode);
        return iHashCode;
    }

    public final boolean equals(DivActionScrollBy other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        return other != null && this.animated.evaluate(resolver).booleanValue() == other.animated.evaluate(otherResolver).booleanValue() && Intrinsics.areEqual(this.id.evaluate(resolver), other.id.evaluate(otherResolver)) && this.itemCount.evaluate(resolver).longValue() == other.itemCount.evaluate(otherResolver).longValue() && this.offset.evaluate(resolver).longValue() == other.offset.evaluate(otherResolver).longValue() && this.overflow.evaluate(resolver) == other.overflow.evaluate(otherResolver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivActionScrollBy copy$default(DivActionScrollBy divActionScrollBy, Expression expression, Expression expression2, Expression expression3, Expression expression4, Expression expression5, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divActionScrollBy.animated;
        }
        if ((i & 2) != 0) {
            expression2 = divActionScrollBy.id;
        }
        Expression expression6 = expression2;
        if ((i & 4) != 0) {
            expression3 = divActionScrollBy.itemCount;
        }
        Expression expression7 = expression3;
        if ((i & 8) != 0) {
            expression4 = divActionScrollBy.offset;
        }
        Expression expression8 = expression4;
        if ((i & 16) != 0) {
            expression5 = divActionScrollBy.overflow;
        }
        return divActionScrollBy.copy(expression, expression6, expression7, expression8, expression5);
    }

    public final DivActionScrollBy copy(Expression<Boolean> animated, Expression<String> id, Expression<Long> itemCount, Expression<Long> offset, Expression<Overflow> overflow) {
        Intrinsics.checkNotNullParameter(animated, "animated");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(itemCount, "itemCount");
        Intrinsics.checkNotNullParameter(offset, "offset");
        Intrinsics.checkNotNullParameter(overflow, "overflow");
        return new DivActionScrollBy(animated, id, itemCount, offset, overflow);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivActionScrollByJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivActionScrollBy.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div2/DivActionScrollBy$Companion;", "", "()V", "ANIMATED_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionScrollBy;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "ITEM_COUNT_DEFAULT_VALUE", "", "OFFSET_DEFAULT_VALUE", "OVERFLOW_DEFAULT_VALUE", "Lcom/yandex/div2/DivActionScrollBy$Overflow;", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivActionScrollBy fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivActionScrollByJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivActionScrollBy> getCREATOR() {
            return DivActionScrollBy.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivActionScrollBy.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/yandex/div2/DivActionScrollBy$Overflow;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "CLAMP", "RING", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Overflow {
        CLAMP("clamp"),
        RING("ring");

        private final String value;

        /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Function1<Overflow, String> TO_STRING = new Function1<Overflow, String>() { // from class: com.yandex.div2.DivActionScrollBy$Overflow$Converter$TO_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(DivActionScrollBy.Overflow value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivActionScrollBy.Overflow.INSTANCE.toString(value);
            }
        };
        public static final Function1<String, Overflow> FROM_STRING = new Function1<String, Overflow>() { // from class: com.yandex.div2.DivActionScrollBy$Overflow$Converter$FROM_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final DivActionScrollBy.Overflow invoke(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivActionScrollBy.Overflow.INSTANCE.fromString(value);
            }
        };

        Overflow(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: com.yandex.div2.DivActionScrollBy$Overflow$Converter, reason: from kotlin metadata */
        /* JADX INFO: compiled from: DivActionScrollBy.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivActionScrollBy$Overflow$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivActionScrollBy$Overflow;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String toString(Overflow obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return obj.value;
            }

            public final Overflow fromString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(value, Overflow.CLAMP.value)) {
                    return Overflow.CLAMP;
                }
                if (Intrinsics.areEqual(value, Overflow.RING.value)) {
                    return Overflow.RING;
                }
                return null;
            }
        }
    }
}
