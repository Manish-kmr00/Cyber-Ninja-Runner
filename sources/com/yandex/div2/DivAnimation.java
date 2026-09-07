package com.yandex.div2;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.json.cc;
import com.yandex.div.data.Hashable;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivAnimation.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0002\"#B\u0085\u0001\b\u0007\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004¢\u0006\u0002\u0010\u0012J\u0086\u0001\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004J \u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cJ\b\u0010\u001e\u001a\u00020\u0014H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020!H\u0016R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/yandex/div2/DivAnimation;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "duration", "Lcom/yandex/div/json/expressions/Expression;", "", "endValue", "", "interpolator", "Lcom/yandex/div2/DivAnimationInterpolator;", FirebaseAnalytics.Param.ITEMS, "", "name", "Lcom/yandex/div2/DivAnimation$Name;", "repeat", "Lcom/yandex/div2/DivCount;", "startDelay", "startValue", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivCount;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "_propertiesHash", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "propertiesHash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "Name", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivAnimation implements JSONSerializable, Hashable {
    private Integer _hash;
    private Integer _propertiesHash;
    public final Expression<Long> duration;
    public final Expression<Double> endValue;
    public final Expression<DivAnimationInterpolator> interpolator;
    public final List<DivAnimation> items;
    public final Expression<Name> name;
    public final DivCount repeat;
    public final Expression<Long> startDelay;
    public final Expression<Double> startValue;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Long> DURATION_DEFAULT_VALUE = Expression.INSTANCE.constant(300L);
    private static final Expression<DivAnimationInterpolator> INTERPOLATOR_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAnimationInterpolator.SPRING);
    private static final DivCount.Infinity REPEAT_DEFAULT_VALUE = new DivCount.Infinity(new DivInfinityCount());
    private static final Expression<Long> START_DELAY_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Function2<ParsingEnvironment, JSONObject, DivAnimation> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivAnimation>() { // from class: com.yandex.div2.DivAnimation$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivAnimation invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivAnimation.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivAnimation fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivAnimation(Expression<Long> duration, Expression<Double> expression, Expression<DivAnimationInterpolator> interpolator, List<DivAnimation> list, Expression<Name> name, DivCount repeat, Expression<Long> startDelay, Expression<Double> expression2) {
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(repeat, "repeat");
        Intrinsics.checkNotNullParameter(startDelay, "startDelay");
        this.duration = duration;
        this.endValue = expression;
        this.interpolator = interpolator;
        this.items = list;
        this.name = name;
        this.repeat = repeat;
        this.startDelay = startDelay;
        this.startValue = expression2;
    }

    public /* synthetic */ DivAnimation(Expression expression, Expression expression2, Expression expression3, List list, Expression expression4, DivCount divCount, Expression expression5, Expression expression6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DURATION_DEFAULT_VALUE : expression, (i & 2) != 0 ? null : expression2, (i & 4) != 0 ? INTERPOLATOR_DEFAULT_VALUE : expression3, (i & 8) != 0 ? null : list, expression4, (i & 32) != 0 ? REPEAT_DEFAULT_VALUE : divCount, (i & 64) != 0 ? START_DELAY_DEFAULT_VALUE : expression5, (i & 128) != 0 ? null : expression6);
    }

    @Override // com.yandex.div.data.Hashable
    public int propertiesHash() {
        Integer num = this._propertiesHash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.duration.hashCode();
        Expression<Double> expression = this.endValue;
        int iHashCode2 = iHashCode + (expression != null ? expression.hashCode() : 0) + this.interpolator.hashCode() + this.name.hashCode() + this.repeat.hash() + this.startDelay.hashCode();
        Expression<Double> expression2 = this.startValue;
        int iHashCode3 = iHashCode2 + (expression2 != null ? expression2.hashCode() : 0);
        this._propertiesHash = Integer.valueOf(iHashCode3);
        return iHashCode3;
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iPropertiesHash = propertiesHash();
        List<DivAnimation> list = this.items;
        int iHash = 0;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                iHash += ((DivAnimation) it.next()).hash();
            }
        }
        int i = iPropertiesHash + iHash;
        this._hash = Integer.valueOf(i);
        return i;
    }

    public final boolean equals(DivAnimation other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null || this.duration.evaluate(resolver).longValue() != other.duration.evaluate(otherResolver).longValue()) {
            return false;
        }
        Expression<Double> expression = this.endValue;
        Double dEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<Double> expression2 = other.endValue;
        if (!Intrinsics.areEqual(dEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null) || this.interpolator.evaluate(resolver) != other.interpolator.evaluate(otherResolver)) {
            return false;
        }
        List<DivAnimation> list = this.items;
        if (list != null) {
            List<DivAnimation> list2 = other.items;
            if (list2 == null || list.size() != list2.size()) {
                return false;
            }
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (!((DivAnimation) obj).equals(list2.get(i), resolver, otherResolver)) {
                    return false;
                }
                i = i2;
            }
        } else if (other.items != null) {
            return false;
        }
        if (this.name.evaluate(resolver) != other.name.evaluate(otherResolver) || !this.repeat.equals(other.repeat, resolver, otherResolver) || this.startDelay.evaluate(resolver).longValue() != other.startDelay.evaluate(otherResolver).longValue()) {
            return false;
        }
        Expression<Double> expression3 = this.startValue;
        Double dEvaluate2 = expression3 != null ? expression3.evaluate(resolver) : null;
        Expression<Double> expression4 = other.startValue;
        return Intrinsics.areEqual(dEvaluate2, expression4 != null ? expression4.evaluate(otherResolver) : null);
    }

    public final DivAnimation copy(Expression<Long> duration, Expression<Double> endValue, Expression<DivAnimationInterpolator> interpolator, List<DivAnimation> items, Expression<Name> name, DivCount repeat, Expression<Long> startDelay, Expression<Double> startValue) {
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(repeat, "repeat");
        Intrinsics.checkNotNullParameter(startDelay, "startDelay");
        return new DivAnimation(duration, endValue, interpolator, items, name, repeat, startDelay, startValue);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivAnimationJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivAnimation.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0015R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yandex/div2/DivAnimation$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivAnimation;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "DURATION_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "INTERPOLATOR_DEFAULT_VALUE", "Lcom/yandex/div2/DivAnimationInterpolator;", "REPEAT_DEFAULT_VALUE", "Lcom/yandex/div2/DivCount$Infinity;", "START_DELAY_DEFAULT_VALUE", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivAnimation fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivAnimationJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivAnimation> getCREATOR() {
            return DivAnimation.CREATOR;
        }
    }

    /* JADX INFO: compiled from: DivAnimation.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivAnimation$Name;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "FADE", "TRANSLATE", "SCALE", "NATIVE", "SET", "NO_ANIMATION", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Name {
        FADE("fade"),
        TRANSLATE("translate"),
        SCALE("scale"),
        NATIVE("native"),
        SET("set"),
        NO_ANIMATION("no_animation");

        private final String value;

        /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Function1<Name, String> TO_STRING = new Function1<Name, String>() { // from class: com.yandex.div2.DivAnimation$Name$Converter$TO_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(DivAnimation.Name value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivAnimation.Name.INSTANCE.toString(value);
            }
        };
        public static final Function1<String, Name> FROM_STRING = new Function1<String, Name>() { // from class: com.yandex.div2.DivAnimation$Name$Converter$FROM_STRING$1
            @Override // kotlin.jvm.functions.Function1
            public final DivAnimation.Name invoke(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return DivAnimation.Name.INSTANCE.fromString(value);
            }
        };

        Name(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: com.yandex.div2.DivAnimation$Name$Converter, reason: from kotlin metadata */
        /* JADX INFO: compiled from: DivAnimation.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivAnimation$Name$Converter;", "", "()V", "FROM_STRING", "Lkotlin/Function1;", "", "Lcom/yandex/div2/DivAnimation$Name;", "TO_STRING", "fromString", "value", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String toString(Name obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return obj.value;
            }

            public final Name fromString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(value, Name.FADE.value)) {
                    return Name.FADE;
                }
                if (Intrinsics.areEqual(value, Name.TRANSLATE.value)) {
                    return Name.TRANSLATE;
                }
                if (Intrinsics.areEqual(value, Name.SCALE.value)) {
                    return Name.SCALE;
                }
                if (Intrinsics.areEqual(value, Name.NATIVE.value)) {
                    return Name.NATIVE;
                }
                if (Intrinsics.areEqual(value, Name.SET.value)) {
                    return Name.SET;
                }
                if (Intrinsics.areEqual(value, Name.NO_ANIMATION.value)) {
                    return Name.NO_ANIMATION;
                }
                return null;
            }
        }
    }
}
