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

/* JADX INFO: compiled from: DivChangeBoundsTransition.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001cB7\b\u0007\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\nJ6\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J \u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J\b\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/yandex/div2/DivChangeBoundsTransition;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "Lcom/yandex/div2/DivTransitionBase;", "duration", "Lcom/yandex/div/json/expressions/Expression;", "", "interpolator", "Lcom/yandex/div2/DivAnimationInterpolator;", "startDelay", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "getDuration", "()Lcom/yandex/div/json/expressions/Expression;", "getInterpolator", "getStartDelay", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivChangeBoundsTransition implements JSONSerializable, Hashable, DivTransitionBase {
    public static final String TYPE = "change_bounds";
    private Integer _hash;
    private final Expression<Long> duration;
    private final Expression<DivAnimationInterpolator> interpolator;
    private final Expression<Long> startDelay;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Long> DURATION_DEFAULT_VALUE = Expression.INSTANCE.constant(200L);
    private static final Expression<DivAnimationInterpolator> INTERPOLATOR_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAnimationInterpolator.EASE_IN_OUT);
    private static final Expression<Long> START_DELAY_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Function2<ParsingEnvironment, JSONObject, DivChangeBoundsTransition> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivChangeBoundsTransition>() { // from class: com.yandex.div2.DivChangeBoundsTransition$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivChangeBoundsTransition invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivChangeBoundsTransition.INSTANCE.fromJson(env, it);
        }
    };

    public DivChangeBoundsTransition() {
        this(null, null, null, 7, null);
    }

    @JvmStatic
    public static final DivChangeBoundsTransition fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivChangeBoundsTransition(Expression<Long> duration, Expression<DivAnimationInterpolator> interpolator, Expression<Long> startDelay) {
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(startDelay, "startDelay");
        this.duration = duration;
        this.interpolator = interpolator;
        this.startDelay = startDelay;
    }

    public /* synthetic */ DivChangeBoundsTransition(Expression expression, Expression expression2, Expression expression3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DURATION_DEFAULT_VALUE : expression, (i & 2) != 0 ? INTERPOLATOR_DEFAULT_VALUE : expression2, (i & 4) != 0 ? START_DELAY_DEFAULT_VALUE : expression3);
    }

    @Override // com.yandex.div2.DivTransitionBase
    public Expression<Long> getDuration() {
        return this.duration;
    }

    @Override // com.yandex.div2.DivTransitionBase
    public Expression<DivAnimationInterpolator> getInterpolator() {
        return this.interpolator;
    }

    @Override // com.yandex.div2.DivTransitionBase
    public Expression<Long> getStartDelay() {
        return this.startDelay;
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + getDuration().hashCode() + getInterpolator().hashCode() + getStartDelay().hashCode();
        this._hash = Integer.valueOf(iHashCode);
        return iHashCode;
    }

    public final boolean equals(DivChangeBoundsTransition other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        return other != null && getDuration().evaluate(resolver).longValue() == other.getDuration().evaluate(otherResolver).longValue() && getInterpolator().evaluate(resolver) == other.getInterpolator().evaluate(otherResolver) && getStartDelay().evaluate(resolver).longValue() == other.getStartDelay().evaluate(otherResolver).longValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivChangeBoundsTransition copy$default(DivChangeBoundsTransition divChangeBoundsTransition, Expression expression, Expression expression2, Expression expression3, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divChangeBoundsTransition.getDuration();
        }
        if ((i & 2) != 0) {
            expression2 = divChangeBoundsTransition.getInterpolator();
        }
        if ((i & 4) != 0) {
            expression3 = divChangeBoundsTransition.getStartDelay();
        }
        return divChangeBoundsTransition.copy(expression, expression2, expression3);
    }

    public final DivChangeBoundsTransition copy(Expression<Long> duration, Expression<DivAnimationInterpolator> interpolator, Expression<Long> startDelay) {
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(startDelay, "startDelay");
        return new DivChangeBoundsTransition(duration, interpolator, startDelay);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivChangeBoundsTransitionJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivChangeBoundsTransition.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0015R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yandex/div2/DivChangeBoundsTransition$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivChangeBoundsTransition;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "DURATION_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "INTERPOLATOR_DEFAULT_VALUE", "Lcom/yandex/div2/DivAnimationInterpolator;", "START_DELAY_DEFAULT_VALUE", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivChangeBoundsTransition fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivChangeBoundsTransitionJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivChangeBoundsTransition> getCREATOR() {
            return DivChangeBoundsTransition.CREATOR;
        }
    }
}
