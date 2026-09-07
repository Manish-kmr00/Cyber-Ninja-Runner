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

/* JADX INFO: compiled from: DivFadeTransition.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001eBG\b\u0007\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\u0010\fJF\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0005J \u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/yandex/div2/DivFadeTransition;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "Lcom/yandex/div2/DivTransitionBase;", "alpha", "Lcom/yandex/div/json/expressions/Expression;", "", "duration", "", "interpolator", "Lcom/yandex/div2/DivAnimationInterpolator;", "startDelay", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "getDuration", "()Lcom/yandex/div/json/expressions/Expression;", "getInterpolator", "getStartDelay", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivFadeTransition implements JSONSerializable, Hashable, DivTransitionBase {
    public static final String TYPE = "fade";
    private Integer _hash;
    public final Expression<Double> alpha;
    private final Expression<Long> duration;
    private final Expression<DivAnimationInterpolator> interpolator;
    private final Expression<Long> startDelay;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Double> ALPHA_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(0.0d));
    private static final Expression<Long> DURATION_DEFAULT_VALUE = Expression.INSTANCE.constant(200L);
    private static final Expression<DivAnimationInterpolator> INTERPOLATOR_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAnimationInterpolator.EASE_IN_OUT);
    private static final Expression<Long> START_DELAY_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Function2<ParsingEnvironment, JSONObject, DivFadeTransition> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivFadeTransition>() { // from class: com.yandex.div2.DivFadeTransition$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivFadeTransition invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivFadeTransition.INSTANCE.fromJson(env, it);
        }
    };

    public DivFadeTransition() {
        this(null, null, null, null, 15, null);
    }

    @JvmStatic
    public static final DivFadeTransition fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivFadeTransition(Expression<Double> alpha, Expression<Long> duration, Expression<DivAnimationInterpolator> interpolator, Expression<Long> startDelay) {
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(startDelay, "startDelay");
        this.alpha = alpha;
        this.duration = duration;
        this.interpolator = interpolator;
        this.startDelay = startDelay;
    }

    public /* synthetic */ DivFadeTransition(Expression expression, Expression expression2, Expression expression3, Expression expression4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ALPHA_DEFAULT_VALUE : expression, (i & 2) != 0 ? DURATION_DEFAULT_VALUE : expression2, (i & 4) != 0 ? INTERPOLATOR_DEFAULT_VALUE : expression3, (i & 8) != 0 ? START_DELAY_DEFAULT_VALUE : expression4);
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
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.alpha.hashCode() + getDuration().hashCode() + getInterpolator().hashCode() + getStartDelay().hashCode();
        this._hash = Integer.valueOf(iHashCode);
        return iHashCode;
    }

    public final boolean equals(DivFadeTransition other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        return other != null && this.alpha.evaluate(resolver).doubleValue() == other.alpha.evaluate(otherResolver).doubleValue() && getDuration().evaluate(resolver).longValue() == other.getDuration().evaluate(otherResolver).longValue() && getInterpolator().evaluate(resolver) == other.getInterpolator().evaluate(otherResolver) && getStartDelay().evaluate(resolver).longValue() == other.getStartDelay().evaluate(otherResolver).longValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivFadeTransition copy$default(DivFadeTransition divFadeTransition, Expression expression, Expression expression2, Expression expression3, Expression expression4, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divFadeTransition.alpha;
        }
        if ((i & 2) != 0) {
            expression2 = divFadeTransition.getDuration();
        }
        if ((i & 4) != 0) {
            expression3 = divFadeTransition.getInterpolator();
        }
        if ((i & 8) != 0) {
            expression4 = divFadeTransition.getStartDelay();
        }
        return divFadeTransition.copy(expression, expression2, expression3, expression4);
    }

    public final DivFadeTransition copy(Expression<Double> alpha, Expression<Long> duration, Expression<DivAnimationInterpolator> interpolator, Expression<Long> startDelay) {
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(startDelay, "startDelay");
        return new DivFadeTransition(alpha, duration, interpolator, startDelay);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivFadeTransitionJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivFadeTransition.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div2/DivFadeTransition$Companion;", "", "()V", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivFadeTransition;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "DURATION_DEFAULT_VALUE", "", "INTERPOLATOR_DEFAULT_VALUE", "Lcom/yandex/div2/DivAnimationInterpolator;", "START_DELAY_DEFAULT_VALUE", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivFadeTransition fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivFadeTransitionJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivFadeTransition> getCREATOR() {
            return DivFadeTransition.CREATOR;
        }
    }
}
