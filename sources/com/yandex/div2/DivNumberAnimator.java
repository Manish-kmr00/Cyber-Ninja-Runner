package com.yandex.div2;

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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivNumberAnimator.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 32\u00020\u00012\u00020\u00022\u00020\u0003:\u00013B£\u0001\b\u0007\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b\u0012\u0006\u0010\u0017\u001a\u00020\u0010¢\u0006\u0002\u0010\u0018Jª\u0001\u0010)\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b2\b\b\u0002\u0010\u0017\u001a\u00020\u0010J \u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.J\b\u00100\u001a\u00020\u001aH\u0016J\b\u00101\u001a\u000202H\u0016R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0018\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#¨\u00064"}, d2 = {"Lcom/yandex/div2/DivNumberAnimator;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "Lcom/yandex/div2/DivAnimatorBase;", "cancelActions", "", "Lcom/yandex/div2/DivAction;", "direction", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAnimationDirection;", "duration", "", "endActions", "endValue", "", "id", "", "interpolator", "Lcom/yandex/div2/DivAnimationInterpolator;", "repeatCount", "Lcom/yandex/div2/DivCount;", "startDelay", "startValue", "variableName", "(Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/util/List;Lcom/yandex/div/json/expressions/Expression;Ljava/lang/String;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivCount;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Ljava/lang/String;)V", "_hash", "", "Ljava/lang/Integer;", "getCancelActions", "()Ljava/util/List;", "getDirection", "()Lcom/yandex/div/json/expressions/Expression;", "getDuration", "getEndActions", "getId", "()Ljava/lang/String;", "getInterpolator", "getRepeatCount", "()Lcom/yandex/div2/DivCount;", "getStartDelay", "getVariableName", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivNumberAnimator implements JSONSerializable, Hashable, DivAnimatorBase {
    public static final String TYPE = "number_animator";
    private Integer _hash;
    private final List<DivAction> cancelActions;
    private final Expression<DivAnimationDirection> direction;
    private final Expression<Long> duration;
    private final List<DivAction> endActions;
    public final Expression<Double> endValue;
    private final String id;
    private final Expression<DivAnimationInterpolator> interpolator;
    private final DivCount repeatCount;
    private final Expression<Long> startDelay;
    public final Expression<Double> startValue;
    private final String variableName;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<DivAnimationDirection> DIRECTION_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAnimationDirection.NORMAL);
    private static final Expression<DivAnimationInterpolator> INTERPOLATOR_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAnimationInterpolator.LINEAR);
    private static final DivCount.Fixed REPEAT_COUNT_DEFAULT_VALUE = new DivCount.Fixed(new DivFixedCount(Expression.INSTANCE.constant(1L)));
    private static final Expression<Long> START_DELAY_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Function2<ParsingEnvironment, JSONObject, DivNumberAnimator> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivNumberAnimator>() { // from class: com.yandex.div2.DivNumberAnimator$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivNumberAnimator invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivNumberAnimator.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivNumberAnimator fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivNumberAnimator(List<DivAction> list, Expression<DivAnimationDirection> direction, Expression<Long> duration, List<DivAction> list2, Expression<Double> endValue, String id, Expression<DivAnimationInterpolator> interpolator, DivCount repeatCount, Expression<Long> startDelay, Expression<Double> expression, String variableName) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(endValue, "endValue");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(repeatCount, "repeatCount");
        Intrinsics.checkNotNullParameter(startDelay, "startDelay");
        Intrinsics.checkNotNullParameter(variableName, "variableName");
        this.cancelActions = list;
        this.direction = direction;
        this.duration = duration;
        this.endActions = list2;
        this.endValue = endValue;
        this.id = id;
        this.interpolator = interpolator;
        this.repeatCount = repeatCount;
        this.startDelay = startDelay;
        this.startValue = expression;
        this.variableName = variableName;
    }

    @Override // com.yandex.div2.DivAnimatorBase
    public List<DivAction> getCancelActions() {
        return this.cancelActions;
    }

    public /* synthetic */ DivNumberAnimator(List list, Expression expression, Expression expression2, List list2, Expression expression3, String str, Expression expression4, DivCount divCount, Expression expression5, Expression expression6, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? DIRECTION_DEFAULT_VALUE : expression, expression2, (i & 8) != 0 ? null : list2, expression3, str, (i & 64) != 0 ? INTERPOLATOR_DEFAULT_VALUE : expression4, (i & 128) != 0 ? REPEAT_COUNT_DEFAULT_VALUE : divCount, (i & 256) != 0 ? START_DELAY_DEFAULT_VALUE : expression5, (i & 512) != 0 ? null : expression6, str2);
    }

    @Override // com.yandex.div2.DivAnimatorBase
    public Expression<DivAnimationDirection> getDirection() {
        return this.direction;
    }

    @Override // com.yandex.div2.DivAnimatorBase
    public Expression<Long> getDuration() {
        return this.duration;
    }

    @Override // com.yandex.div2.DivAnimatorBase
    public List<DivAction> getEndActions() {
        return this.endActions;
    }

    @Override // com.yandex.div2.DivAnimatorBase
    public String getId() {
        return this.id;
    }

    @Override // com.yandex.div2.DivAnimatorBase
    public Expression<DivAnimationInterpolator> getInterpolator() {
        return this.interpolator;
    }

    @Override // com.yandex.div2.DivAnimatorBase
    public DivCount getRepeatCount() {
        return this.repeatCount;
    }

    @Override // com.yandex.div2.DivAnimatorBase
    public Expression<Long> getStartDelay() {
        return this.startDelay;
    }

    @Override // com.yandex.div2.DivAnimatorBase
    public String getVariableName() {
        return this.variableName;
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        int iHash;
        int iHash2;
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        List<DivAction> cancelActions = getCancelActions();
        if (cancelActions != null) {
            Iterator<T> it = cancelActions.iterator();
            iHash = 0;
            while (it.hasNext()) {
                iHash += ((DivAction) it.next()).hash();
            }
        } else {
            iHash = 0;
        }
        int iHashCode2 = iHashCode + iHash + getDirection().hashCode() + getDuration().hashCode();
        List<DivAction> endActions = getEndActions();
        if (endActions != null) {
            Iterator<T> it2 = endActions.iterator();
            iHash2 = 0;
            while (it2.hasNext()) {
                iHash2 += ((DivAction) it2.next()).hash();
            }
        } else {
            iHash2 = 0;
        }
        int iHashCode3 = iHashCode2 + iHash2 + this.endValue.hashCode() + getId().hashCode() + getInterpolator().hashCode() + getRepeatCount().hash() + getStartDelay().hashCode();
        Expression<Double> expression = this.startValue;
        int iHashCode4 = iHashCode3 + (expression != null ? expression.hashCode() : 0) + getVariableName().hashCode();
        this._hash = Integer.valueOf(iHashCode4);
        return iHashCode4;
    }

    public final boolean equals(DivNumberAnimator other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        List<DivAction> cancelActions = getCancelActions();
        if (cancelActions != null) {
            List<DivAction> cancelActions2 = other.getCancelActions();
            if (cancelActions2 == null || cancelActions.size() != cancelActions2.size()) {
                return false;
            }
            int i = 0;
            for (Object obj : cancelActions) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (!((DivAction) obj).equals(cancelActions2.get(i), resolver, otherResolver)) {
                    return false;
                }
                i = i2;
            }
        } else if (other.getCancelActions() != null) {
            return false;
        }
        if (getDirection().evaluate(resolver) != other.getDirection().evaluate(otherResolver) || getDuration().evaluate(resolver).longValue() != other.getDuration().evaluate(otherResolver).longValue()) {
            return false;
        }
        List<DivAction> endActions = getEndActions();
        if (endActions != null) {
            List<DivAction> endActions2 = other.getEndActions();
            if (endActions2 == null || endActions.size() != endActions2.size()) {
                return false;
            }
            int i3 = 0;
            for (Object obj2 : endActions) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (!((DivAction) obj2).equals(endActions2.get(i3), resolver, otherResolver)) {
                    return false;
                }
                i3 = i4;
            }
        } else if (other.getEndActions() != null) {
            return false;
        }
        if (this.endValue.evaluate(resolver).doubleValue() != other.endValue.evaluate(otherResolver).doubleValue() || !Intrinsics.areEqual(getId(), other.getId()) || getInterpolator().evaluate(resolver) != other.getInterpolator().evaluate(otherResolver) || !getRepeatCount().equals(other.getRepeatCount(), resolver, otherResolver) || getStartDelay().evaluate(resolver).longValue() != other.getStartDelay().evaluate(otherResolver).longValue()) {
            return false;
        }
        Expression<Double> expression = this.startValue;
        Double dEvaluate = expression != null ? expression.evaluate(resolver) : null;
        Expression<Double> expression2 = other.startValue;
        return Intrinsics.areEqual(dEvaluate, expression2 != null ? expression2.evaluate(otherResolver) : null) && Intrinsics.areEqual(getVariableName(), other.getVariableName());
    }

    public final DivNumberAnimator copy(List<DivAction> cancelActions, Expression<DivAnimationDirection> direction, Expression<Long> duration, List<DivAction> endActions, Expression<Double> endValue, String id, Expression<DivAnimationInterpolator> interpolator, DivCount repeatCount, Expression<Long> startDelay, Expression<Double> startValue, String variableName) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(endValue, "endValue");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(repeatCount, "repeatCount");
        Intrinsics.checkNotNullParameter(startDelay, "startDelay");
        Intrinsics.checkNotNullParameter(variableName, "variableName");
        return new DivNumberAnimator(cancelActions, direction, duration, endActions, endValue, id, interpolator, repeatCount, startDelay, startValue, variableName);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivNumberAnimatorJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivNumberAnimator.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0018R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/yandex/div2/DivNumberAnimator$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivNumberAnimator;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "DIRECTION_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAnimationDirection;", "INTERPOLATOR_DEFAULT_VALUE", "Lcom/yandex/div2/DivAnimationInterpolator;", "REPEAT_COUNT_DEFAULT_VALUE", "Lcom/yandex/div2/DivCount$Fixed;", "START_DELAY_DEFAULT_VALUE", "", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivNumberAnimator fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivNumberAnimatorJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivNumberAnimator> getCREATOR() {
            return DivNumberAnimator.CREATOR;
        }
    }
}
