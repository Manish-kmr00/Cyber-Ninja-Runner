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

/* JADX INFO: compiled from: DivTextRangeMaskParticles.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019BO\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJP\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\b\u0002\u0010\u000b\u001a\u00020\fJ \u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/yandex/div2/DivTextRangeMaskParticles;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "color", "Lcom/yandex/div/json/expressions/Expression;", "", "density", "", "isAnimated", "", "isEnabled", "particleSize", "Lcom/yandex/div2/DivFixedSize;", "(Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div2/DivFixedSize;)V", "_hash", "Ljava/lang/Integer;", "copy", "equals", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "writeToJSON", "Lorg/json/JSONObject;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivTextRangeMaskParticles implements JSONSerializable, Hashable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<Double> DENSITY_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(0.8d));
    private static final Expression<Boolean> IS_ANIMATED_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
    private static final Expression<Boolean> IS_ENABLED_DEFAULT_VALUE = Expression.INSTANCE.constant(true);
    public static final String TYPE = "particles";
    private Integer _hash;
    public final Expression<Integer> color;
    public final Expression<Double> density;
    public final Expression<Boolean> isAnimated;
    public final Expression<Boolean> isEnabled;
    public final DivFixedSize particleSize;
    private static final DivFixedSize PARTICLE_SIZE_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(1L), 1, 0 == true ? 1 : 0);
    private static final Function2<ParsingEnvironment, JSONObject, DivTextRangeMaskParticles> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivTextRangeMaskParticles>() { // from class: com.yandex.div2.DivTextRangeMaskParticles$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivTextRangeMaskParticles invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivTextRangeMaskParticles.INSTANCE.fromJson(env, it);
        }
    };

    @JvmStatic
    public static final DivTextRangeMaskParticles fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    public DivTextRangeMaskParticles(Expression<Integer> color, Expression<Double> density, Expression<Boolean> isAnimated, Expression<Boolean> isEnabled, DivFixedSize particleSize) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(isAnimated, "isAnimated");
        Intrinsics.checkNotNullParameter(isEnabled, "isEnabled");
        Intrinsics.checkNotNullParameter(particleSize, "particleSize");
        this.color = color;
        this.density = density;
        this.isAnimated = isAnimated;
        this.isEnabled = isEnabled;
        this.particleSize = particleSize;
    }

    public /* synthetic */ DivTextRangeMaskParticles(Expression expression, Expression expression2, Expression expression3, Expression expression4, DivFixedSize divFixedSize, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(expression, (i & 2) != 0 ? DENSITY_DEFAULT_VALUE : expression2, (i & 4) != 0 ? IS_ANIMATED_DEFAULT_VALUE : expression3, (i & 8) != 0 ? IS_ENABLED_DEFAULT_VALUE : expression4, (i & 16) != 0 ? PARTICLE_SIZE_DEFAULT_VALUE : divFixedSize);
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode() + this.color.hashCode() + this.density.hashCode() + this.isAnimated.hashCode() + this.isEnabled.hashCode() + this.particleSize.hash();
        this._hash = Integer.valueOf(iHashCode);
        return iHashCode;
    }

    public final boolean equals(DivTextRangeMaskParticles other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        return other != null && this.color.evaluate(resolver).intValue() == other.color.evaluate(otherResolver).intValue() && this.density.evaluate(resolver).doubleValue() == other.density.evaluate(otherResolver).doubleValue() && this.isAnimated.evaluate(resolver).booleanValue() == other.isAnimated.evaluate(otherResolver).booleanValue() && this.isEnabled.evaluate(resolver).booleanValue() == other.isEnabled.evaluate(otherResolver).booleanValue() && this.particleSize.equals(other.particleSize, resolver, otherResolver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DivTextRangeMaskParticles copy$default(DivTextRangeMaskParticles divTextRangeMaskParticles, Expression expression, Expression expression2, Expression expression3, Expression expression4, DivFixedSize divFixedSize, int i, Object obj) {
        if ((i & 1) != 0) {
            expression = divTextRangeMaskParticles.color;
        }
        if ((i & 2) != 0) {
            expression2 = divTextRangeMaskParticles.density;
        }
        Expression expression5 = expression2;
        if ((i & 4) != 0) {
            expression3 = divTextRangeMaskParticles.isAnimated;
        }
        Expression expression6 = expression3;
        if ((i & 8) != 0) {
            expression4 = divTextRangeMaskParticles.isEnabled;
        }
        Expression expression7 = expression4;
        if ((i & 16) != 0) {
            divFixedSize = divTextRangeMaskParticles.particleSize;
        }
        return divTextRangeMaskParticles.copy(expression, expression5, expression6, expression7, divFixedSize);
    }

    public final DivTextRangeMaskParticles copy(Expression<Integer> color, Expression<Double> density, Expression<Boolean> isAnimated, Expression<Boolean> isEnabled, DivFixedSize particleSize) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(isAnimated, "isAnimated");
        Intrinsics.checkNotNullParameter(isEnabled, "isEnabled");
        Intrinsics.checkNotNullParameter(particleSize, "particleSize");
        return new DivTextRangeMaskParticles(color, density, isAnimated, isEnabled, particleSize);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivTextRangeMaskParticlesJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivTextRangeMaskParticles.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\u0017R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div2/DivTextRangeMaskParticles$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTextRangeMaskParticles;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "DENSITY_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "IS_ANIMATED_DEFAULT_VALUE", "", "IS_ENABLED_DEFAULT_VALUE", "PARTICLE_SIZE_DEFAULT_VALUE", "Lcom/yandex/div2/DivFixedSize;", "TYPE", "", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivTextRangeMaskParticles fromJson(ParsingEnvironment env, JSONObject json) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivTextRangeMaskParticlesJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivTextRangeMaskParticles> getCREATOR() {
            return DivTextRangeMaskParticles.CREATOR;
        }
    }
}
