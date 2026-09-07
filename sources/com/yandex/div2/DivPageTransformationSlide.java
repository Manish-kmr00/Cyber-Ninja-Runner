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

/* JADX INFO: compiled from: DivPageTransformationSlide.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019BW\b\u0007\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\u0010\u000bJV\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004J \u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/yandex/div2/DivPageTransformationSlide;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "interpolator", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAnimationInterpolator;", "nextPageAlpha", "", "nextPageScale", "previousPageAlpha", "previousPageScale", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;)V", "_hash", "", "Ljava/lang/Integer;", "copy", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivPageTransformationSlide implements JSONSerializable, Hashable {
    private static final Function2<ParsingEnvironment, JSONObject, DivPageTransformationSlide> CREATOR;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<DivAnimationInterpolator> INTERPOLATOR_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAnimationInterpolator.EASE_IN_OUT);
    private static final Expression<Double> NEXT_PAGE_ALPHA_DEFAULT_VALUE;
    private static final Expression<Double> NEXT_PAGE_SCALE_DEFAULT_VALUE;
    private static final Expression<Double> PREVIOUS_PAGE_ALPHA_DEFAULT_VALUE;
    private static final Expression<Double> PREVIOUS_PAGE_SCALE_DEFAULT_VALUE;
    public static final String TYPE = "slide";
    private Integer _hash;
    public final Expression<DivAnimationInterpolator> interpolator;
    public final Expression<Double> nextPageAlpha;
    public final Expression<Double> nextPageScale;
    public final Expression<Double> previousPageAlpha;
    public final Expression<Double> previousPageScale;

    public DivPageTransformationSlide() {
        this(null, null, null, null, null, 31, null);
    }

    @JvmStatic
    public static final DivPageTransformationSlide fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivPageTransformationSlide(Expression<DivAnimationInterpolator> interpolator, Expression<Double> nextPageAlpha, Expression<Double> nextPageScale, Expression<Double> previousPageAlpha, Expression<Double> previousPageScale) {
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(nextPageAlpha, "nextPageAlpha");
        Intrinsics.checkNotNullParameter(nextPageScale, "nextPageScale");
        Intrinsics.checkNotNullParameter(previousPageAlpha, "previousPageAlpha");
        Intrinsics.checkNotNullParameter(previousPageScale, "previousPageScale");
        this.interpolator = interpolator;
        this.nextPageAlpha = nextPageAlpha;
        this.nextPageScale = nextPageScale;
        this.previousPageAlpha = previousPageAlpha;
        this.previousPageScale = previousPageScale;
    }

    public /* synthetic */ DivPageTransformationSlide(Expression expression, Expression expression2, Expression expression3, Expression expression4, Expression expression5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? INTERPOLATOR_DEFAULT_VALUE : expression, (i & 2) != 0 ? NEXT_PAGE_ALPHA_DEFAULT_VALUE : expression2, (i & 4) != 0 ? NEXT_PAGE_SCALE_DEFAULT_VALUE : expression3, (i & 8) != 0 ? PREVIOUS_PAGE_ALPHA_DEFAULT_VALUE : expression4, (i & 16) != 0 ? PREVIOUS_PAGE_SCALE_DEFAULT_VALUE : expression5);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.interpolator.hashCode() + this.nextPageAlpha.hashCode() + this.nextPageScale.hashCode() + this.previousPageAlpha.hashCode() + this.previousPageScale.hashCode();
        this._hash = Integer.valueOf(iHashCode);
        return iHashCode;
    }

    public final boolean equals(DivPageTransformationSlide other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        return other != null && this.interpolator.evaluate(resolver) == other.interpolator.evaluate(otherResolver) && this.nextPageAlpha.evaluate(resolver).doubleValue() == other.nextPageAlpha.evaluate(otherResolver).doubleValue() && this.nextPageScale.evaluate(resolver).doubleValue() == other.nextPageScale.evaluate(otherResolver).doubleValue() && this.previousPageAlpha.evaluate(resolver).doubleValue() == other.previousPageAlpha.evaluate(otherResolver).doubleValue() && this.previousPageScale.evaluate(resolver).doubleValue() == other.previousPageScale.evaluate(otherResolver).doubleValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivPageTransformationSlide copy$default(DivPageTransformationSlide divPageTransformationSlide, Expression expression, Expression expression2, Expression expression3, Expression expression4, Expression expression5, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divPageTransformationSlide.interpolator;
        }
        if ((i & 2) != 0) {
            expression2 = divPageTransformationSlide.nextPageAlpha;
        }
        Expression expression6 = expression2;
        if ((i & 4) != 0) {
            expression3 = divPageTransformationSlide.nextPageScale;
        }
        Expression expression7 = expression3;
        if ((i & 8) != 0) {
            expression4 = divPageTransformationSlide.previousPageAlpha;
        }
        Expression expression8 = expression4;
        if ((i & 16) != 0) {
            expression5 = divPageTransformationSlide.previousPageScale;
        }
        return divPageTransformationSlide.copy(expression, expression6, expression7, expression8, expression5);
    }

    public final DivPageTransformationSlide copy(Expression<DivAnimationInterpolator> interpolator, Expression<Double> nextPageAlpha, Expression<Double> nextPageScale, Expression<Double> previousPageAlpha, Expression<Double> previousPageScale) {
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(nextPageAlpha, "nextPageAlpha");
        Intrinsics.checkNotNullParameter(nextPageScale, "nextPageScale");
        Intrinsics.checkNotNullParameter(previousPageAlpha, "previousPageAlpha");
        Intrinsics.checkNotNullParameter(previousPageScale, "previousPageScale");
        return new DivPageTransformationSlide(interpolator, nextPageAlpha, nextPageScale, previousPageAlpha, previousPageScale);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivPageTransformationSlideJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivPageTransformationSlide.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0017R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div2/DivPageTransformationSlide$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivPageTransformationSlide;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "INTERPOLATOR_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAnimationInterpolator;", "NEXT_PAGE_ALPHA_DEFAULT_VALUE", "", "NEXT_PAGE_SCALE_DEFAULT_VALUE", "PREVIOUS_PAGE_ALPHA_DEFAULT_VALUE", "PREVIOUS_PAGE_SCALE_DEFAULT_VALUE", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivPageTransformationSlide fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivPageTransformationSlideJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivPageTransformationSlide> getCREATOR() {
            return DivPageTransformationSlide.CREATOR;
        }
    }

    static {
        Expression.Companion companion = Expression.INSTANCE;
        Double dValueOf = Double.valueOf(1.0d);
        NEXT_PAGE_ALPHA_DEFAULT_VALUE = companion.constant(dValueOf);
        NEXT_PAGE_SCALE_DEFAULT_VALUE = Expression.INSTANCE.constant(dValueOf);
        PREVIOUS_PAGE_ALPHA_DEFAULT_VALUE = Expression.INSTANCE.constant(dValueOf);
        PREVIOUS_PAGE_SCALE_DEFAULT_VALUE = Expression.INSTANCE.constant(dValueOf);
        CREATOR = new Function2<ParsingEnvironment, JSONObject, DivPageTransformationSlide>() { // from class: com.yandex.div2.DivPageTransformationSlide$Companion$CREATOR$1
            @Override // kotlin.jvm.functions.Function2
            public final DivPageTransformationSlide invoke(ParsingEnvironment env, JSONObject it) {
                Intrinsics.checkNotNullParameter(env, "env");
                Intrinsics.checkNotNullParameter(it, "it");
                return DivPageTransformationSlide.INSTANCE.fromJson(env, it);
            }
        };
    }
}
