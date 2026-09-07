package com.yandex.div2;

import com.json.cc;
import com.yandex.div.internal.template.Field;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.JsonTemplate;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivColorAnimatorTemplate.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001%BÑ\u0001\b\u0016\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0005\u0012\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\u0005\u0012\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\u0005\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005\u0012\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\t0\u0005\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005\u0012\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\u0005\u0012\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\u0005\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005¢\u0006\u0002\u0010\u0019B-\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u0012\u0006\u0010\u001f\u001a\u00020 ¢\u0006\u0002\u0010!J\u0018\u0010\"\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020 H\u0016J\b\u0010$\u001a\u00020 H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/yandex/div2/DivColorAnimatorTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivColorAnimator;", "cancelActions", "Lcom/yandex/div/internal/template/Field;", "", "Lcom/yandex/div2/DivActionTemplate;", "direction", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAnimationDirection;", "duration", "", "endActions", "endValue", "", "id", "", "interpolator", "Lcom/yandex/div2/DivAnimationInterpolator;", "repeatCount", "Lcom/yandex/div2/DivCountTemplate;", "startDelay", "startValue", "variableName", "(Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;Lcom/yandex/div/internal/template/Field;)V", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "parent", "topLevel", "", "json", "Lorg/json/JSONObject;", "(Lcom/yandex/div/json/ParsingEnvironment;Lcom/yandex/div2/DivColorAnimatorTemplate;ZLorg/json/JSONObject;)V", "resolve", "data", "writeToJSON", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivColorAnimatorTemplate implements JSONSerializable, JsonTemplate<DivColorAnimator> {
    public static final String TYPE = "color_animator";
    public final Field<List<DivActionTemplate>> cancelActions;
    public final Field<Expression<DivAnimationDirection>> direction;
    public final Field<Expression<Long>> duration;
    public final Field<List<DivActionTemplate>> endActions;
    public final Field<Expression<Integer>> endValue;
    public final Field<String> id;
    public final Field<Expression<DivAnimationInterpolator>> interpolator;
    public final Field<DivCountTemplate> repeatCount;
    public final Field<Expression<Long>> startDelay;
    public final Field<Expression<Integer>> startValue;
    public final Field<String> variableName;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Expression<DivAnimationDirection> DIRECTION_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAnimationDirection.NORMAL);
    private static final Expression<DivAnimationInterpolator> INTERPOLATOR_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAnimationInterpolator.LINEAR);
    private static final DivCount.Fixed REPEAT_COUNT_DEFAULT_VALUE = new DivCount.Fixed(new DivFixedCount(Expression.INSTANCE.constant(1L)));
    private static final Expression<Long> START_DELAY_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
    private static final Function2<ParsingEnvironment, JSONObject, DivColorAnimatorTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivColorAnimatorTemplate>() { // from class: com.yandex.div2.DivColorAnimatorTemplate$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivColorAnimatorTemplate invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return new DivColorAnimatorTemplate(env, null, false, it, 6, null);
        }
    };

    public DivColorAnimatorTemplate(Field<List<DivActionTemplate>> cancelActions, Field<Expression<DivAnimationDirection>> direction, Field<Expression<Long>> duration, Field<List<DivActionTemplate>> endActions, Field<Expression<Integer>> endValue, Field<String> id, Field<Expression<DivAnimationInterpolator>> interpolator, Field<DivCountTemplate> repeatCount, Field<Expression<Long>> startDelay, Field<Expression<Integer>> startValue, Field<String> variableName) {
        Intrinsics.checkNotNullParameter(cancelActions, "cancelActions");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(endActions, "endActions");
        Intrinsics.checkNotNullParameter(endValue, "endValue");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(repeatCount, "repeatCount");
        Intrinsics.checkNotNullParameter(startDelay, "startDelay");
        Intrinsics.checkNotNullParameter(startValue, "startValue");
        Intrinsics.checkNotNullParameter(variableName, "variableName");
        this.cancelActions = cancelActions;
        this.direction = direction;
        this.duration = duration;
        this.endActions = endActions;
        this.endValue = endValue;
        this.id = id;
        this.interpolator = interpolator;
        this.repeatCount = repeatCount;
        this.startDelay = startDelay;
        this.startValue = startValue;
        this.variableName = variableName;
    }

    public /* synthetic */ DivColorAnimatorTemplate(ParsingEnvironment parsingEnvironment, DivColorAnimatorTemplate divColorAnimatorTemplate, boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(parsingEnvironment, (i & 2) != 0 ? null : divColorAnimatorTemplate, (i & 4) != 0 ? false : z, jSONObject);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivColorAnimatorTemplate(ParsingEnvironment env, DivColorAnimatorTemplate divColorAnimatorTemplate, boolean z, JSONObject json) {
        this(Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false), Field.INSTANCE.nullField(false));
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(json, "json");
        throw new UnsupportedOperationException("Do not use this constructor directly.");
    }

    @Override // com.yandex.div.json.JsonTemplate
    public DivColorAnimator resolve(ParsingEnvironment env, JSONObject data) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        return BuiltInParserKt.getBuiltInParserComponent().getDivColorAnimatorJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivColorAnimatorJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivColorAnimatorTemplate.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div2/DivColorAnimatorTemplate$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivColorAnimatorTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "DIRECTION_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAnimationDirection;", "INTERPOLATOR_DEFAULT_VALUE", "Lcom/yandex/div2/DivAnimationInterpolator;", "REPEAT_COUNT_DEFAULT_VALUE", "Lcom/yandex/div2/DivCount$Fixed;", "START_DELAY_DEFAULT_VALUE", "", "TYPE", "", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function2<ParsingEnvironment, JSONObject, DivColorAnimatorTemplate> getCREATOR() {
            return DivColorAnimatorTemplate.CREATOR;
        }
    }
}
