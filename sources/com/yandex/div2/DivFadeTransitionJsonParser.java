package com.yandex.div2;

import com.yandex.div.internal.parser.JsonExpressionParser;
import com.yandex.div.internal.parser.JsonFieldParser;
import com.yandex.div.internal.parser.JsonFieldResolver;
import com.yandex.div.internal.parser.JsonPropertyParser;
import com.yandex.div.internal.parser.ParsingConvertersKt;
import com.yandex.div.internal.parser.TypeHelper;
import com.yandex.div.internal.parser.TypeHelpersKt;
import com.yandex.div.internal.parser.ValueValidator;
import com.yandex.div.internal.template.Field;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.serialization.Parser;
import com.yandex.div.serialization.ParsingContext;
import com.yandex.div.serialization.ParsingContextKt;
import com.yandex.div.serialization.TemplateParser;
import com.yandex.div.serialization.TemplateResolver;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivFadeTransitionJsonParser.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivFadeTransitionJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivFadeTransitionJsonParser {
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<Double> ALPHA_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(0.0d));

    @Deprecated
    public static final Expression<Long> DURATION_DEFAULT_VALUE = Expression.INSTANCE.constant(200L);

    @Deprecated
    public static final Expression<DivAnimationInterpolator> INTERPOLATOR_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAnimationInterpolator.EASE_IN_OUT);

    @Deprecated
    public static final Expression<Long> START_DELAY_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);

    @Deprecated
    public static final TypeHelper<DivAnimationInterpolator> TYPE_HELPER_INTERPOLATOR = TypeHelper.INSTANCE.from(ArraysKt.first(DivAnimationInterpolator.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivFadeTransitionJsonParser$Companion$TYPE_HELPER_INTERPOLATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivAnimationInterpolator);
        }
    });

    @Deprecated
    public static final ValueValidator<Double> ALPHA_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivFadeTransitionJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivFadeTransitionJsonParser.ALPHA_VALIDATOR$lambda$0(((Double) obj).doubleValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> DURATION_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivFadeTransitionJsonParser$$ExternalSyntheticLambda1
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivFadeTransitionJsonParser.DURATION_VALIDATOR$lambda$1(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> START_DELAY_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivFadeTransitionJsonParser$$ExternalSyntheticLambda2
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivFadeTransitionJsonParser.START_DELAY_VALIDATOR$lambda$2(((Long) obj).longValue());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ALPHA_VALIDATOR$lambda$0(double d) {
        return d >= 0.0d && d <= 1.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DURATION_VALIDATOR$lambda$1(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean START_DELAY_VALIDATOR$lambda$2(long j) {
        return j >= 0;
    }

    public DivFadeTransitionJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivFadeTransitionJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivFadeTransitionJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivFadeTransition;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivFadeTransition> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivFadeTransition deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression<Double> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivFadeTransitionJsonParser.ALPHA_VALIDATOR, DivFadeTransitionJsonParser.ALPHA_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivFadeTransitionJsonParser.ALPHA_DEFAULT_VALUE;
            }
            Expression<Long> optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, "duration", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivFadeTransitionJsonParser.DURATION_VALIDATOR, DivFadeTransitionJsonParser.DURATION_DEFAULT_VALUE);
            if (optionalExpression2 == null) {
                optionalExpression2 = DivFadeTransitionJsonParser.DURATION_DEFAULT_VALUE;
            }
            Expression<DivAnimationInterpolator> optionalExpression3 = JsonExpressionParser.readOptionalExpression(context, data, "interpolator", DivFadeTransitionJsonParser.TYPE_HELPER_INTERPOLATOR, DivAnimationInterpolator.FROM_STRING, DivFadeTransitionJsonParser.INTERPOLATOR_DEFAULT_VALUE);
            if (optionalExpression3 == null) {
                optionalExpression3 = DivFadeTransitionJsonParser.INTERPOLATOR_DEFAULT_VALUE;
            }
            Expression<Long> optionalExpression4 = JsonExpressionParser.readOptionalExpression(context, data, "start_delay", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivFadeTransitionJsonParser.START_DELAY_VALIDATOR, DivFadeTransitionJsonParser.START_DELAY_DEFAULT_VALUE);
            if (optionalExpression4 == null) {
                optionalExpression4 = DivFadeTransitionJsonParser.START_DELAY_DEFAULT_VALUE;
            }
            return new DivFadeTransition(optionalExpression, optionalExpression2, optionalExpression3, optionalExpression4);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivFadeTransition value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonExpressionParser.writeExpression(context, jSONObject, "alpha", value.alpha);
            JsonExpressionParser.writeExpression(context, jSONObject, "duration", value.getDuration());
            JsonExpressionParser.writeExpression(context, jSONObject, "interpolator", value.getInterpolator(), DivAnimationInterpolator.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "start_delay", value.getStartDelay());
            JsonPropertyParser.write(context, jSONObject, "type", "fade");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivFadeTransitionJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivFadeTransitionJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivFadeTransitionTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivFadeTransitionTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivFadeTransitionTemplate deserialize(ParsingContext context, DivFadeTransitionTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.alpha : null, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivFadeTransitionJsonParser.ALPHA_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…_DOUBLE, ALPHA_VALIDATOR)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "duration", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.duration : null, ParsingConvertersKt.NUMBER_TO_INT, DivFadeTransitionJsonParser.DURATION_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…_INT, DURATION_VALIDATOR)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "interpolator", DivFadeTransitionJsonParser.TYPE_HELPER_INTERPOLATOR, allowPropertyOverride, parent != null ? parent.interpolator : null, DivAnimationInterpolator.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…Interpolator.FROM_STRING)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "start_delay", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.startDelay : null, ParsingConvertersKt.NUMBER_TO_INT, DivFadeTransitionJsonParser.START_DELAY_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…T, START_DELAY_VALIDATOR)");
            return new DivFadeTransitionTemplate((Field<Expression<Double>>) optionalFieldWithExpression, (Field<Expression<Long>>) optionalFieldWithExpression2, (Field<Expression<DivAnimationInterpolator>>) optionalFieldWithExpression3, (Field<Expression<Long>>) optionalFieldWithExpression4);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivFadeTransitionTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeExpressionField(context, jSONObject, "alpha", value.alpha);
            JsonFieldParser.writeExpressionField(context, jSONObject, "duration", value.duration);
            JsonFieldParser.writeExpressionField(context, jSONObject, "interpolator", value.interpolator, DivAnimationInterpolator.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "start_delay", value.startDelay);
            JsonPropertyParser.write(context, jSONObject, "type", "fade");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivFadeTransitionJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivFadeTransitionJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivFadeTransitionTemplate;", "Lcom/yandex/div2/DivFadeTransition;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivFadeTransitionTemplate, DivFadeTransition> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivFadeTransition resolve(ParsingContext context, DivFadeTransitionTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression<Double> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.alpha, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivFadeTransitionJsonParser.ALPHA_VALIDATOR, DivFadeTransitionJsonParser.ALPHA_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivFadeTransitionJsonParser.ALPHA_DEFAULT_VALUE;
            }
            Expression<Long> expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.duration, data, "duration", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivFadeTransitionJsonParser.DURATION_VALIDATOR, DivFadeTransitionJsonParser.DURATION_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression2 == null) {
                expressionResolveOptionalExpression2 = DivFadeTransitionJsonParser.DURATION_DEFAULT_VALUE;
            }
            Expression<DivAnimationInterpolator> expressionResolveOptionalExpression3 = JsonFieldResolver.resolveOptionalExpression(context, template.interpolator, data, "interpolator", DivFadeTransitionJsonParser.TYPE_HELPER_INTERPOLATOR, DivAnimationInterpolator.FROM_STRING, DivFadeTransitionJsonParser.INTERPOLATOR_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression3 == null) {
                expressionResolveOptionalExpression3 = DivFadeTransitionJsonParser.INTERPOLATOR_DEFAULT_VALUE;
            }
            Expression<Long> expressionResolveOptionalExpression4 = JsonFieldResolver.resolveOptionalExpression(context, template.startDelay, data, "start_delay", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivFadeTransitionJsonParser.START_DELAY_VALIDATOR, DivFadeTransitionJsonParser.START_DELAY_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression4 == null) {
                expressionResolveOptionalExpression4 = DivFadeTransitionJsonParser.START_DELAY_DEFAULT_VALUE;
            }
            return new DivFadeTransition(expressionResolveOptionalExpression, expressionResolveOptionalExpression2, expressionResolveOptionalExpression3, expressionResolveOptionalExpression4);
        }
    }

    /* JADX INFO: compiled from: DivFadeTransitionJsonParser.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00108\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div2/DivFadeTransitionJsonParser$Companion;", "", "()V", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "ALPHA_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "DURATION_DEFAULT_VALUE", "", "DURATION_VALIDATOR", "INTERPOLATOR_DEFAULT_VALUE", "Lcom/yandex/div2/DivAnimationInterpolator;", "START_DELAY_DEFAULT_VALUE", "START_DELAY_VALIDATOR", "TYPE_HELPER_INTERPOLATOR", "Lcom/yandex/div/internal/parser/TypeHelper;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
