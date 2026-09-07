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

/* JADX INFO: compiled from: DivScaleTransition.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001 Bg\b\u0007\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u000eJf\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J \u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ\b\u0010\u001d\u001a\u00020\u0010H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006!"}, d2 = {"Lcom/yandex/div2/DivScaleTransition;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "Lcom/yandex/div2/DivTransitionBase;", "duration", "Lcom/yandex/div/json/expressions/Expression;", "", "interpolator", "Lcom/yandex/div2/DivAnimationInterpolator;", "pivotX", "", "pivotY", "scale", "startDelay", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "getDuration", "()Lcom/yandex/div/json/expressions/Expression;", "getInterpolator", "getStartDelay", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivScaleTransition implements JSONSerializable, Hashable, DivTransitionBase {
    private static final Function2<ParsingEnvironment, JSONObject, DivScaleTransition> CREATOR;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Long> DURATION_DEFAULT_VALUE = Expression.INSTANCE.constant(200L);
    private static final Expression<DivAnimationInterpolator> INTERPOLATOR_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAnimationInterpolator.EASE_IN_OUT);
    private static final Expression<Double> PIVOT_X_DEFAULT_VALUE;
    private static final Expression<Double> PIVOT_Y_DEFAULT_VALUE;
    private static final Expression<Double> SCALE_DEFAULT_VALUE;
    private static final Expression<Long> START_DELAY_DEFAULT_VALUE;
    public static final String TYPE = "scale";
    private Integer _hash;
    private final Expression<Long> duration;
    private final Expression<DivAnimationInterpolator> interpolator;
    public final Expression<Double> pivotX;
    public final Expression<Double> pivotY;
    public final Expression<Double> scale;
    private final Expression<Long> startDelay;

    public DivScaleTransition() {
        this(null, null, null, null, null, null, 63, null);
    }

    @JvmStatic
    public static final DivScaleTransition fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivScaleTransition(Expression<Long> duration, Expression<DivAnimationInterpolator> interpolator, Expression<Double> pivotX, Expression<Double> pivotY, Expression<Double> scale, Expression<Long> startDelay) {
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(pivotX, "pivotX");
        Intrinsics.checkNotNullParameter(pivotY, "pivotY");
        Intrinsics.checkNotNullParameter(scale, "scale");
        Intrinsics.checkNotNullParameter(startDelay, "startDelay");
        this.duration = duration;
        this.interpolator = interpolator;
        this.pivotX = pivotX;
        this.pivotY = pivotY;
        this.scale = scale;
        this.startDelay = startDelay;
    }

    public /* synthetic */ DivScaleTransition(Expression expression, Expression expression2, Expression expression3, Expression expression4, Expression expression5, Expression expression6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DURATION_DEFAULT_VALUE : expression, (i & 2) != 0 ? INTERPOLATOR_DEFAULT_VALUE : expression2, (i & 4) != 0 ? PIVOT_X_DEFAULT_VALUE : expression3, (i & 8) != 0 ? PIVOT_Y_DEFAULT_VALUE : expression4, (i & 16) != 0 ? SCALE_DEFAULT_VALUE : expression5, (i & 32) != 0 ? START_DELAY_DEFAULT_VALUE : expression6);
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
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + getDuration().hashCode() + getInterpolator().hashCode() + this.pivotX.hashCode() + this.pivotY.hashCode() + this.scale.hashCode() + getStartDelay().hashCode();
        this._hash = Integer.valueOf(iHashCode);
        return iHashCode;
    }

    public final boolean equals(DivScaleTransition other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        return other != null && getDuration().evaluate(resolver).longValue() == other.getDuration().evaluate(otherResolver).longValue() && getInterpolator().evaluate(resolver) == other.getInterpolator().evaluate(otherResolver) && this.pivotX.evaluate(resolver).doubleValue() == other.pivotX.evaluate(otherResolver).doubleValue() && this.pivotY.evaluate(resolver).doubleValue() == other.pivotY.evaluate(otherResolver).doubleValue() && this.scale.evaluate(resolver).doubleValue() == other.scale.evaluate(otherResolver).doubleValue() && getStartDelay().evaluate(resolver).longValue() == other.getStartDelay().evaluate(otherResolver).longValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivScaleTransition copy$default(DivScaleTransition divScaleTransition, Expression expression, Expression expression2, Expression expression3, Expression expression4, Expression expression5, Expression expression6, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divScaleTransition.getDuration();
        }
        if ((i & 2) != 0) {
            expression2 = divScaleTransition.getInterpolator();
        }
        Expression expression7 = expression2;
        if ((i & 4) != 0) {
            expression3 = divScaleTransition.pivotX;
        }
        Expression expression8 = expression3;
        if ((i & 8) != 0) {
            expression4 = divScaleTransition.pivotY;
        }
        Expression expression9 = expression4;
        if ((i & 16) != 0) {
            expression5 = divScaleTransition.scale;
        }
        Expression expression10 = expression5;
        if ((i & 32) != 0) {
            expression6 = divScaleTransition.getStartDelay();
        }
        return divScaleTransition.copy(expression, expression7, expression8, expression9, expression10, expression6);
    }

    public final DivScaleTransition copy(Expression<Long> duration, Expression<DivAnimationInterpolator> interpolator, Expression<Double> pivotX, Expression<Double> pivotY, Expression<Double> scale, Expression<Long> startDelay) {
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(pivotX, "pivotX");
        Intrinsics.checkNotNullParameter(pivotY, "pivotY");
        Intrinsics.checkNotNullParameter(scale, "scale");
        Intrinsics.checkNotNullParameter(startDelay, "startDelay");
        return new DivScaleTransition(duration, interpolator, pivotX, pivotY, scale, startDelay);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivScaleTransitionJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivScaleTransition.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0019R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/yandex/div2/DivScaleTransition$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivScaleTransition;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "DURATION_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "INTERPOLATOR_DEFAULT_VALUE", "Lcom/yandex/div2/DivAnimationInterpolator;", "PIVOT_X_DEFAULT_VALUE", "", "PIVOT_Y_DEFAULT_VALUE", "SCALE_DEFAULT_VALUE", "START_DELAY_DEFAULT_VALUE", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivScaleTransition fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivScaleTransitionJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivScaleTransition> getCREATOR() {
            return DivScaleTransition.CREATOR;
        }
    }

    static {
        Expression.Companion companion = Expression.INSTANCE;
        Double dValueOf = Double.valueOf(0.5d);
        PIVOT_X_DEFAULT_VALUE = companion.constant(dValueOf);
        PIVOT_Y_DEFAULT_VALUE = Expression.INSTANCE.constant(dValueOf);
        SCALE_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(0.0d));
        START_DELAY_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
        CREATOR = new Function2<ParsingEnvironment, JSONObject, DivScaleTransition>() { // from class: com.yandex.div2.DivScaleTransition$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivScaleTransition invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivScaleTransition.INSTANCE.fromJson(env, it);
            }
        };
    }
}
