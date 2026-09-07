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

/* JADX INFO: compiled from: DivActionAnimatorStart.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B{\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0012J|\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bJ \u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ\b\u0010\u001d\u001a\u00020\u0014H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/yandex/div2/DivActionAnimatorStart;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "animatorId", "", "direction", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAnimationDirection;", "duration", "", "endValue", "Lcom/yandex/div2/DivTypedValue;", "interpolator", "Lcom/yandex/div2/DivAnimationInterpolator;", "repeatCount", "Lcom/yandex/div2/DivCount;", "startDelay", "startValue", "(Ljava/lang/String;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivTypedValue;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivCount;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivTypedValue;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivActionAnimatorStart implements JSONSerializable, Hashable {
    public static final String TYPE = "animator_start";
    private Integer _hash;
    public final String animatorId;
    public final Expression<DivAnimationDirection> direction;
    public final Expression<Long> duration;
    public final DivTypedValue endValue;
    public final Expression<DivAnimationInterpolator> interpolator;
    public final DivCount repeatCount;
    public final Expression<Long> startDelay;
    public final DivTypedValue startValue;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivActionAnimatorStart> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivActionAnimatorStart>() { // from class: com.yandex.div2.DivActionAnimatorStart$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivActionAnimatorStart invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivActionAnimatorStart.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivActionAnimatorStart fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivActionAnimatorStart(String animatorId, Expression<DivAnimationDirection> expression, Expression<Long> expression2, DivTypedValue divTypedValue, Expression<DivAnimationInterpolator> expression3, DivCount divCount, Expression<Long> expression4, DivTypedValue divTypedValue2) {
        Intrinsics.checkNotNullParameter(animatorId, "animatorId");
        this.animatorId = animatorId;
        this.direction = expression;
        this.duration = expression2;
        this.endValue = divTypedValue;
        this.interpolator = expression3;
        this.repeatCount = divCount;
        this.startDelay = expression4;
        this.startValue = divTypedValue2;
    }

    public /* synthetic */ DivActionAnimatorStart(String str, Expression expression, Expression expression2, DivTypedValue divTypedValue, Expression expression3, DivCount divCount, Expression expression4, DivTypedValue divTypedValue2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : expression, (i & 4) != 0 ? null : expression2, (i & 8) != 0 ? null : divTypedValue, (i & 16) != 0 ? null : expression3, (i & 32) != 0 ? null : divCount, (i & 64) != 0 ? null : expression4, (i & 128) == 0 ? divTypedValue2 : null);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.animatorId.hashCode();
        Expression<DivAnimationDirection> expression = this.direction;
        int iHashCode2 = iHashCode + (expression != null ? expression.hashCode() : 0);
        Expression<Long> expression2 = this.duration;
        int iHashCode3 = iHashCode2 + (expression2 != null ? expression2.hashCode() : 0);
        DivTypedValue divTypedValue = this.endValue;
        int iHash = iHashCode3 + (divTypedValue != null ? divTypedValue.hash() : 0);
        Expression<DivAnimationInterpolator> expression3 = this.interpolator;
        int iHashCode4 = iHash + (expression3 != null ? expression3.hashCode() : 0);
        DivCount divCount = this.repeatCount;
        int iHash2 = iHashCode4 + (divCount != null ? divCount.hash() : 0);
        Expression<Long> expression4 = this.startDelay;
        int iHashCode5 = iHash2 + (expression4 != null ? expression4.hashCode() : 0);
        DivTypedValue divTypedValue2 = this.startValue;
        int iHash3 = iHashCode5 + (divTypedValue2 != null ? divTypedValue2.hash() : 0);
        this._hash = Integer.valueOf(iHash3);
        return iHash3;
    }

    public final boolean equals(DivActionAnimatorStart other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        boolean zEquals;
        boolean zEquals2;
        boolean zEquals3;
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null || !Intrinsics.areEqual(this.animatorId, other.animatorId)) {
            return false;
        }
        Expression<DivAnimationDirection> expression = this.direction;
        DivAnimationDirection divAnimationDirectionEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<DivAnimationDirection> expression2 = other.direction;
        if (divAnimationDirectionEvaluate != (expression2 != null ? expression2.evaluate(otherResolver) : null)) {
            return false;
        }
        Expression<Long> expression3 = this.duration;
        Long lEvaluate = expression3 != null ? expression3.evaluate(resolver) : null;
        Expression<Long> expression4 = other.duration;
        if (!Intrinsics.areEqual(lEvaluate, expression4 != null ? expression4.evaluate(otherResolver) : null)) {
            return false;
        }
        DivTypedValue divTypedValue = this.endValue;
        if (divTypedValue != null) {
            zEquals = divTypedValue.equals(other.endValue, resolver, otherResolver);
        } else {
            zEquals = other.endValue == null;
        }
        if (!zEquals) {
            return false;
        }
        Expression<DivAnimationInterpolator> expression5 = this.interpolator;
        DivAnimationInterpolator divAnimationInterpolatorEvaluate = expression5 != null ? expression5.evaluate(resolver) : null;
        Expression<DivAnimationInterpolator> expression6 = other.interpolator;
        if (divAnimationInterpolatorEvaluate != (expression6 != null ? expression6.evaluate(otherResolver) : null)) {
            return false;
        }
        DivCount divCount = this.repeatCount;
        if (divCount != null) {
            zEquals2 = divCount.equals(other.repeatCount, resolver, otherResolver);
        } else {
            zEquals2 = other.repeatCount == null;
        }
        if (!zEquals2) {
            return false;
        }
        Expression<Long> expression7 = this.startDelay;
        Long lEvaluate2 = expression7 != null ? expression7.evaluate(resolver) : null;
        Expression<Long> expression8 = other.startDelay;
        if (!Intrinsics.areEqual(lEvaluate2, expression8 != null ? expression8.evaluate(otherResolver) : null)) {
            return false;
        }
        DivTypedValue divTypedValue2 = this.startValue;
        DivTypedValue divTypedValue3 = other.startValue;
        if (divTypedValue2 != null) {
            zEquals3 = divTypedValue2.equals(divTypedValue3, resolver, otherResolver);
        } else {
            zEquals3 = divTypedValue3 == null;
        }
        return zEquals3;
    }

    public final DivActionAnimatorStart copy(String animatorId, Expression<DivAnimationDirection> direction, Expression<Long> duration, DivTypedValue endValue, Expression<DivAnimationInterpolator> interpolator, DivCount repeatCount, Expression<Long> startDelay, DivTypedValue startValue) {
        Intrinsics.checkNotNullParameter(animatorId, "animatorId");
        return new DivActionAnimatorStart(animatorId, direction, duration, endValue, interpolator, repeatCount, startDelay, startValue);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivActionAnimatorStartJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivActionAnimatorStart.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u000fR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yandex/div2/DivActionAnimatorStart$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionAnimatorStart;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivActionAnimatorStart fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivActionAnimatorStartJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivActionAnimatorStart> getCREATOR() {
            return DivActionAnimatorStart.CREATOR;
        }
    }
}
