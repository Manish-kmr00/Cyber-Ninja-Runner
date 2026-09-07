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

/* JADX INFO: compiled from: DivScaleTransitionJsonParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivScaleTransitionJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivScaleTransitionJsonParser {

    @Deprecated
    public static final ValueValidator<Long> DURATION_VALIDATOR;

    @Deprecated
    public static final Expression<Double> PIVOT_X_DEFAULT_VALUE;

    @Deprecated
    public static final ValueValidator<Double> PIVOT_X_VALIDATOR;

    @Deprecated
    public static final Expression<Double> PIVOT_Y_DEFAULT_VALUE;

    @Deprecated
    public static final ValueValidator<Double> PIVOT_Y_VALIDATOR;

    @Deprecated
    public static final Expression<Double> SCALE_DEFAULT_VALUE;

    @Deprecated
    public static final ValueValidator<Double> SCALE_VALIDATOR;

    @Deprecated
    public static final Expression<Long> START_DELAY_DEFAULT_VALUE;

    @Deprecated
    public static final ValueValidator<Long> START_DELAY_VALIDATOR;

    @Deprecated
    public static final TypeHelper<DivAnimationInterpolator> TYPE_HELPER_INTERPOLATOR;
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<Long> DURATION_DEFAULT_VALUE = Expression.INSTANCE.constant(200L);

    @Deprecated
    public static final Expression<DivAnimationInterpolator> INTERPOLATOR_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAnimationInterpolator.EASE_IN_OUT);

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DURATION_VALIDATOR$lambda$0(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PIVOT_X_VALIDATOR$lambda$1(double d) {
        return d >= 0.0d && d <= 1.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PIVOT_Y_VALIDATOR$lambda$2(double d) {
        return d >= 0.0d && d <= 1.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SCALE_VALIDATOR$lambda$3(double d) {
        return d >= 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean START_DELAY_VALIDATOR$lambda$4(long j) {
        return j >= 0;
    }

    public DivScaleTransitionJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivScaleTransitionJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivScaleTransitionJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivScaleTransition;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivScaleTransition> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivScaleTransition deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression<Long> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "duration", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivScaleTransitionJsonParser.DURATION_VALIDATOR, DivScaleTransitionJsonParser.DURATION_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivScaleTransitionJsonParser.DURATION_DEFAULT_VALUE;
            }
            Expression<Long> expression = optionalExpression;
            Expression<DivAnimationInterpolator> optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, "interpolator", DivScaleTransitionJsonParser.TYPE_HELPER_INTERPOLATOR, DivAnimationInterpolator.FROM_STRING, DivScaleTransitionJsonParser.INTERPOLATOR_DEFAULT_VALUE);
            if (optionalExpression2 == null) {
                optionalExpression2 = DivScaleTransitionJsonParser.INTERPOLATOR_DEFAULT_VALUE;
            }
            Expression<DivAnimationInterpolator> expression2 = optionalExpression2;
            Expression<Double> optionalExpression3 = JsonExpressionParser.readOptionalExpression(context, data, "pivot_x", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivScaleTransitionJsonParser.PIVOT_X_VALIDATOR, DivScaleTransitionJsonParser.PIVOT_X_DEFAULT_VALUE);
            if (optionalExpression3 == null) {
                optionalExpression3 = DivScaleTransitionJsonParser.PIVOT_X_DEFAULT_VALUE;
            }
            Expression<Double> expression3 = optionalExpression3;
            Expression<Double> optionalExpression4 = JsonExpressionParser.readOptionalExpression(context, data, "pivot_y", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivScaleTransitionJsonParser.PIVOT_Y_VALIDATOR, DivScaleTransitionJsonParser.PIVOT_Y_DEFAULT_VALUE);
            if (optionalExpression4 == null) {
                optionalExpression4 = DivScaleTransitionJsonParser.PIVOT_Y_DEFAULT_VALUE;
            }
            Expression<Double> expression4 = optionalExpression4;
            Expression<Double> optionalExpression5 = JsonExpressionParser.readOptionalExpression(context, data, "scale", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivScaleTransitionJsonParser.SCALE_VALIDATOR, DivScaleTransitionJsonParser.SCALE_DEFAULT_VALUE);
            if (optionalExpression5 == null) {
                optionalExpression5 = DivScaleTransitionJsonParser.SCALE_DEFAULT_VALUE;
            }
            Expression<Double> expression5 = optionalExpression5;
            Expression<Long> optionalExpression6 = JsonExpressionParser.readOptionalExpression(context, data, "start_delay", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivScaleTransitionJsonParser.START_DELAY_VALIDATOR, DivScaleTransitionJsonParser.START_DELAY_DEFAULT_VALUE);
            if (optionalExpression6 == null) {
                optionalExpression6 = DivScaleTransitionJsonParser.START_DELAY_DEFAULT_VALUE;
            }
            return new DivScaleTransition(expression, expression2, expression3, expression4, expression5, optionalExpression6);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivScaleTransition value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonExpressionParser.writeExpression(context, jSONObject, "duration", value.getDuration());
            JsonExpressionParser.writeExpression(context, jSONObject, "interpolator", value.getInterpolator(), DivAnimationInterpolator.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "pivot_x", value.pivotX);
            JsonExpressionParser.writeExpression(context, jSONObject, "pivot_y", value.pivotY);
            JsonExpressionParser.writeExpression(context, jSONObject, "scale", value.scale);
            JsonExpressionParser.writeExpression(context, jSONObject, "start_delay", value.getStartDelay());
            JsonPropertyParser.write(context, jSONObject, "type", "scale");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivScaleTransitionJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivScaleTransitionJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivScaleTransitionTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivScaleTransitionTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivScaleTransitionTemplate deserialize(ParsingContext context, DivScaleTransitionTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "duration", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.duration : null, ParsingConvertersKt.NUMBER_TO_INT, DivScaleTransitionJsonParser.DURATION_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…_INT, DURATION_VALIDATOR)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "interpolator", DivScaleTransitionJsonParser.TYPE_HELPER_INTERPOLATOR, allowPropertyOverride, parent != null ? parent.interpolator : null, DivAnimationInterpolator.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…Interpolator.FROM_STRING)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "pivot_x", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.pivotX : null, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivScaleTransitionJsonParser.PIVOT_X_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…OUBLE, PIVOT_X_VALIDATOR)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "pivot_y", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.pivotY : null, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivScaleTransitionJsonParser.PIVOT_Y_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…OUBLE, PIVOT_Y_VALIDATOR)");
            Field optionalFieldWithExpression5 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "scale", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.scale : null, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivScaleTransitionJsonParser.SCALE_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression5, "readOptionalFieldWithExp…_DOUBLE, SCALE_VALIDATOR)");
            Field optionalFieldWithExpression6 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "start_delay", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.startDelay : null, ParsingConvertersKt.NUMBER_TO_INT, DivScaleTransitionJsonParser.START_DELAY_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression6, "readOptionalFieldWithExp…T, START_DELAY_VALIDATOR)");
            return new DivScaleTransitionTemplate((Field<Expression<Long>>) optionalFieldWithExpression, (Field<Expression<DivAnimationInterpolator>>) optionalFieldWithExpression2, (Field<Expression<Double>>) optionalFieldWithExpression3, (Field<Expression<Double>>) optionalFieldWithExpression4, (Field<Expression<Double>>) optionalFieldWithExpression5, (Field<Expression<Long>>) optionalFieldWithExpression6);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivScaleTransitionTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeExpressionField(context, jSONObject, "duration", value.duration);
            JsonFieldParser.writeExpressionField(context, jSONObject, "interpolator", value.interpolator, DivAnimationInterpolator.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "pivot_x", value.pivotX);
            JsonFieldParser.writeExpressionField(context, jSONObject, "pivot_y", value.pivotY);
            JsonFieldParser.writeExpressionField(context, jSONObject, "scale", value.scale);
            JsonFieldParser.writeExpressionField(context, jSONObject, "start_delay", value.startDelay);
            JsonPropertyParser.write(context, jSONObject, "type", "scale");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivScaleTransitionJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivScaleTransitionJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivScaleTransitionTemplate;", "Lcom/yandex/div2/DivScaleTransition;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivScaleTransitionTemplate, DivScaleTransition> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivScaleTransition resolve(ParsingContext context, DivScaleTransitionTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression<Long> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.duration, data, "duration", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivScaleTransitionJsonParser.DURATION_VALIDATOR, DivScaleTransitionJsonParser.DURATION_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivScaleTransitionJsonParser.DURATION_DEFAULT_VALUE;
            }
            Expression<Long> expression = expressionResolveOptionalExpression;
            Expression<DivAnimationInterpolator> expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.interpolator, data, "interpolator", DivScaleTransitionJsonParser.TYPE_HELPER_INTERPOLATOR, DivAnimationInterpolator.FROM_STRING, DivScaleTransitionJsonParser.INTERPOLATOR_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression2 == null) {
                expressionResolveOptionalExpression2 = DivScaleTransitionJsonParser.INTERPOLATOR_DEFAULT_VALUE;
            }
            Expression<DivAnimationInterpolator> expression2 = expressionResolveOptionalExpression2;
            Expression<Double> expressionResolveOptionalExpression3 = JsonFieldResolver.resolveOptionalExpression(context, template.pivotX, data, "pivot_x", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivScaleTransitionJsonParser.PIVOT_X_VALIDATOR, DivScaleTransitionJsonParser.PIVOT_X_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression3 == null) {
                expressionResolveOptionalExpression3 = DivScaleTransitionJsonParser.PIVOT_X_DEFAULT_VALUE;
            }
            Expression<Double> expression3 = expressionResolveOptionalExpression3;
            Expression<Double> expressionResolveOptionalExpression4 = JsonFieldResolver.resolveOptionalExpression(context, template.pivotY, data, "pivot_y", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivScaleTransitionJsonParser.PIVOT_Y_VALIDATOR, DivScaleTransitionJsonParser.PIVOT_Y_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression4 == null) {
                expressionResolveOptionalExpression4 = DivScaleTransitionJsonParser.PIVOT_Y_DEFAULT_VALUE;
            }
            Expression<Double> expression4 = expressionResolveOptionalExpression4;
            Expression<Double> expressionResolveOptionalExpression5 = JsonFieldResolver.resolveOptionalExpression(context, template.scale, data, "scale", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivScaleTransitionJsonParser.SCALE_VALIDATOR, DivScaleTransitionJsonParser.SCALE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression5 == null) {
                expressionResolveOptionalExpression5 = DivScaleTransitionJsonParser.SCALE_DEFAULT_VALUE;
            }
            Expression<Double> expression5 = expressionResolveOptionalExpression5;
            Expression<Long> expressionResolveOptionalExpression6 = JsonFieldResolver.resolveOptionalExpression(context, template.startDelay, data, "start_delay", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivScaleTransitionJsonParser.START_DELAY_VALIDATOR, DivScaleTransitionJsonParser.START_DELAY_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression6 == null) {
                expressionResolveOptionalExpression6 = DivScaleTransitionJsonParser.START_DELAY_DEFAULT_VALUE;
            }
            return new DivScaleTransition(expression, expression2, expression3, expression4, expression5, expressionResolveOptionalExpression6);
        }
    }

    /* JADX INFO: compiled from: DivScaleTransitionJsonParser.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00148\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div2/DivScaleTransitionJsonParser$Companion;", "", "()V", "DURATION_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "DURATION_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "INTERPOLATOR_DEFAULT_VALUE", "Lcom/yandex/div2/DivAnimationInterpolator;", "PIVOT_X_DEFAULT_VALUE", "", "PIVOT_X_VALIDATOR", "PIVOT_Y_DEFAULT_VALUE", "PIVOT_Y_VALIDATOR", "SCALE_DEFAULT_VALUE", "SCALE_VALIDATOR", "START_DELAY_DEFAULT_VALUE", "START_DELAY_VALIDATOR", "TYPE_HELPER_INTERPOLATOR", "Lcom/yandex/div/internal/parser/TypeHelper;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Expression.Companion companion = Expression.INSTANCE;
        Double dValueOf = Double.valueOf(0.5d);
        PIVOT_X_DEFAULT_VALUE = companion.constant(dValueOf);
        PIVOT_Y_DEFAULT_VALUE = Expression.INSTANCE.constant(dValueOf);
        SCALE_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(0.0d));
        START_DELAY_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);
        TYPE_HELPER_INTERPOLATOR = TypeHelper.INSTANCE.from(ArraysKt.first(DivAnimationInterpolator.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivScaleTransitionJsonParser$Companion$TYPE_HELPER_INTERPOLATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivAnimationInterpolator);
            }
        });
        DURATION_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivScaleTransitionJsonParser$$ExternalSyntheticLambda0
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivScaleTransitionJsonParser.DURATION_VALIDATOR$lambda$0(((Long) obj).longValue());
            }
        };
        PIVOT_X_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivScaleTransitionJsonParser$$ExternalSyntheticLambda1
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivScaleTransitionJsonParser.PIVOT_X_VALIDATOR$lambda$1(((Double) obj).doubleValue());
            }
        };
        PIVOT_Y_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivScaleTransitionJsonParser$$ExternalSyntheticLambda2
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivScaleTransitionJsonParser.PIVOT_Y_VALIDATOR$lambda$2(((Double) obj).doubleValue());
            }
        };
        SCALE_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivScaleTransitionJsonParser$$ExternalSyntheticLambda3
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivScaleTransitionJsonParser.SCALE_VALIDATOR$lambda$3(((Double) obj).doubleValue());
            }
        };
        START_DELAY_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivScaleTransitionJsonParser$$ExternalSyntheticLambda4
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivScaleTransitionJsonParser.START_DELAY_VALIDATOR$lambda$4(((Long) obj).longValue());
            }
        };
    }
}
