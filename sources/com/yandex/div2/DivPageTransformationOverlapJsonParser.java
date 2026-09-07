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

/* JADX INFO: compiled from: DivPageTransformationOverlapJsonParser.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivPageTransformationOverlapJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivPageTransformationOverlapJsonParser {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<DivAnimationInterpolator> INTERPOLATOR_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAnimationInterpolator.EASE_IN_OUT);

    @Deprecated
    public static final Expression<Double> NEXT_PAGE_ALPHA_DEFAULT_VALUE;

    @Deprecated
    public static final ValueValidator<Double> NEXT_PAGE_ALPHA_VALIDATOR;

    @Deprecated
    public static final Expression<Double> NEXT_PAGE_SCALE_DEFAULT_VALUE;

    @Deprecated
    public static final ValueValidator<Double> NEXT_PAGE_SCALE_VALIDATOR;

    @Deprecated
    public static final Expression<Double> PREVIOUS_PAGE_ALPHA_DEFAULT_VALUE;

    @Deprecated
    public static final ValueValidator<Double> PREVIOUS_PAGE_ALPHA_VALIDATOR;

    @Deprecated
    public static final Expression<Double> PREVIOUS_PAGE_SCALE_DEFAULT_VALUE;

    @Deprecated
    public static final ValueValidator<Double> PREVIOUS_PAGE_SCALE_VALIDATOR;

    @Deprecated
    public static final Expression<Boolean> REVERSED_STACKING_ORDER_DEFAULT_VALUE;

    @Deprecated
    public static final TypeHelper<DivAnimationInterpolator> TYPE_HELPER_INTERPOLATOR;
    private final JsonParserComponent component;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean NEXT_PAGE_ALPHA_VALIDATOR$lambda$0(double d) {
        return d >= 0.0d && d <= 1.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean NEXT_PAGE_SCALE_VALIDATOR$lambda$1(double d) {
        return d >= 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PREVIOUS_PAGE_ALPHA_VALIDATOR$lambda$2(double d) {
        return d >= 0.0d && d <= 1.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PREVIOUS_PAGE_SCALE_VALIDATOR$lambda$3(double d) {
        return d >= 0.0d;
    }

    public DivPageTransformationOverlapJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivPageTransformationOverlapJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivPageTransformationOverlapJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivPageTransformationOverlap;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivPageTransformationOverlap> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivPageTransformationOverlap deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression<DivAnimationInterpolator> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "interpolator", DivPageTransformationOverlapJsonParser.TYPE_HELPER_INTERPOLATOR, DivAnimationInterpolator.FROM_STRING, DivPageTransformationOverlapJsonParser.INTERPOLATOR_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivPageTransformationOverlapJsonParser.INTERPOLATOR_DEFAULT_VALUE;
            }
            Expression<DivAnimationInterpolator> expression = optionalExpression;
            Expression<Double> optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, "next_page_alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivPageTransformationOverlapJsonParser.NEXT_PAGE_ALPHA_VALIDATOR, DivPageTransformationOverlapJsonParser.NEXT_PAGE_ALPHA_DEFAULT_VALUE);
            if (optionalExpression2 == null) {
                optionalExpression2 = DivPageTransformationOverlapJsonParser.NEXT_PAGE_ALPHA_DEFAULT_VALUE;
            }
            Expression<Double> expression2 = optionalExpression2;
            Expression<Double> optionalExpression3 = JsonExpressionParser.readOptionalExpression(context, data, "next_page_scale", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivPageTransformationOverlapJsonParser.NEXT_PAGE_SCALE_VALIDATOR, DivPageTransformationOverlapJsonParser.NEXT_PAGE_SCALE_DEFAULT_VALUE);
            if (optionalExpression3 == null) {
                optionalExpression3 = DivPageTransformationOverlapJsonParser.NEXT_PAGE_SCALE_DEFAULT_VALUE;
            }
            Expression<Double> expression3 = optionalExpression3;
            Expression<Double> optionalExpression4 = JsonExpressionParser.readOptionalExpression(context, data, "previous_page_alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivPageTransformationOverlapJsonParser.PREVIOUS_PAGE_ALPHA_VALIDATOR, DivPageTransformationOverlapJsonParser.PREVIOUS_PAGE_ALPHA_DEFAULT_VALUE);
            if (optionalExpression4 == null) {
                optionalExpression4 = DivPageTransformationOverlapJsonParser.PREVIOUS_PAGE_ALPHA_DEFAULT_VALUE;
            }
            Expression<Double> expression4 = optionalExpression4;
            Expression<Double> optionalExpression5 = JsonExpressionParser.readOptionalExpression(context, data, "previous_page_scale", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivPageTransformationOverlapJsonParser.PREVIOUS_PAGE_SCALE_VALIDATOR, DivPageTransformationOverlapJsonParser.PREVIOUS_PAGE_SCALE_DEFAULT_VALUE);
            if (optionalExpression5 == null) {
                optionalExpression5 = DivPageTransformationOverlapJsonParser.PREVIOUS_PAGE_SCALE_DEFAULT_VALUE;
            }
            Expression<Double> expression5 = optionalExpression5;
            Expression<Boolean> optionalExpression6 = JsonExpressionParser.readOptionalExpression(context, data, "reversed_stacking_order", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivPageTransformationOverlapJsonParser.REVERSED_STACKING_ORDER_DEFAULT_VALUE);
            if (optionalExpression6 == null) {
                optionalExpression6 = DivPageTransformationOverlapJsonParser.REVERSED_STACKING_ORDER_DEFAULT_VALUE;
            }
            return new DivPageTransformationOverlap(expression, expression2, expression3, expression4, expression5, optionalExpression6);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivPageTransformationOverlap value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonExpressionParser.writeExpression(context, jSONObject, "interpolator", value.interpolator, DivAnimationInterpolator.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "next_page_alpha", value.nextPageAlpha);
            JsonExpressionParser.writeExpression(context, jSONObject, "next_page_scale", value.nextPageScale);
            JsonExpressionParser.writeExpression(context, jSONObject, "previous_page_alpha", value.previousPageAlpha);
            JsonExpressionParser.writeExpression(context, jSONObject, "previous_page_scale", value.previousPageScale);
            JsonExpressionParser.writeExpression(context, jSONObject, "reversed_stacking_order", value.reversedStackingOrder);
            JsonPropertyParser.write(context, jSONObject, "type", "overlap");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivPageTransformationOverlapJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivPageTransformationOverlapJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivPageTransformationOverlapTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivPageTransformationOverlapTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivPageTransformationOverlapTemplate deserialize(ParsingContext context, DivPageTransformationOverlapTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "interpolator", DivPageTransformationOverlapJsonParser.TYPE_HELPER_INTERPOLATOR, allowPropertyOverride, parent != null ? parent.interpolator : null, DivAnimationInterpolator.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…Interpolator.FROM_STRING)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "next_page_alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.nextPageAlpha : null, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivPageTransformationOverlapJsonParser.NEXT_PAGE_ALPHA_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…EXT_PAGE_ALPHA_VALIDATOR)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "next_page_scale", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.nextPageScale : null, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivPageTransformationOverlapJsonParser.NEXT_PAGE_SCALE_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…EXT_PAGE_SCALE_VALIDATOR)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "previous_page_alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.previousPageAlpha : null, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivPageTransformationOverlapJsonParser.PREVIOUS_PAGE_ALPHA_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…OUS_PAGE_ALPHA_VALIDATOR)");
            Field optionalFieldWithExpression5 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "previous_page_scale", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.previousPageScale : null, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivPageTransformationOverlapJsonParser.PREVIOUS_PAGE_SCALE_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression5, "readOptionalFieldWithExp…OUS_PAGE_SCALE_VALIDATOR)");
            Field optionalFieldWithExpression6 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "reversed_stacking_order", TypeHelpersKt.TYPE_HELPER_BOOLEAN, allowPropertyOverride, parent != null ? parent.reversedStackingOrder : null, ParsingConvertersKt.ANY_TO_BOOLEAN);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression6, "readOptionalFieldWithExp…ingOrder, ANY_TO_BOOLEAN)");
            return new DivPageTransformationOverlapTemplate((Field<Expression<DivAnimationInterpolator>>) optionalFieldWithExpression, (Field<Expression<Double>>) optionalFieldWithExpression2, (Field<Expression<Double>>) optionalFieldWithExpression3, (Field<Expression<Double>>) optionalFieldWithExpression4, (Field<Expression<Double>>) optionalFieldWithExpression5, (Field<Expression<Boolean>>) optionalFieldWithExpression6);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivPageTransformationOverlapTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeExpressionField(context, jSONObject, "interpolator", value.interpolator, DivAnimationInterpolator.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "next_page_alpha", value.nextPageAlpha);
            JsonFieldParser.writeExpressionField(context, jSONObject, "next_page_scale", value.nextPageScale);
            JsonFieldParser.writeExpressionField(context, jSONObject, "previous_page_alpha", value.previousPageAlpha);
            JsonFieldParser.writeExpressionField(context, jSONObject, "previous_page_scale", value.previousPageScale);
            JsonFieldParser.writeExpressionField(context, jSONObject, "reversed_stacking_order", value.reversedStackingOrder);
            JsonPropertyParser.write(context, jSONObject, "type", "overlap");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivPageTransformationOverlapJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivPageTransformationOverlapJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivPageTransformationOverlapTemplate;", "Lcom/yandex/div2/DivPageTransformationOverlap;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivPageTransformationOverlapTemplate, DivPageTransformationOverlap> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivPageTransformationOverlap resolve(ParsingContext context, DivPageTransformationOverlapTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression<DivAnimationInterpolator> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.interpolator, data, "interpolator", DivPageTransformationOverlapJsonParser.TYPE_HELPER_INTERPOLATOR, DivAnimationInterpolator.FROM_STRING, DivPageTransformationOverlapJsonParser.INTERPOLATOR_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivPageTransformationOverlapJsonParser.INTERPOLATOR_DEFAULT_VALUE;
            }
            Expression<DivAnimationInterpolator> expression = expressionResolveOptionalExpression;
            Expression<Double> expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.nextPageAlpha, data, "next_page_alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivPageTransformationOverlapJsonParser.NEXT_PAGE_ALPHA_VALIDATOR, DivPageTransformationOverlapJsonParser.NEXT_PAGE_ALPHA_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression2 == null) {
                expressionResolveOptionalExpression2 = DivPageTransformationOverlapJsonParser.NEXT_PAGE_ALPHA_DEFAULT_VALUE;
            }
            Expression<Double> expression2 = expressionResolveOptionalExpression2;
            Expression<Double> expressionResolveOptionalExpression3 = JsonFieldResolver.resolveOptionalExpression(context, template.nextPageScale, data, "next_page_scale", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivPageTransformationOverlapJsonParser.NEXT_PAGE_SCALE_VALIDATOR, DivPageTransformationOverlapJsonParser.NEXT_PAGE_SCALE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression3 == null) {
                expressionResolveOptionalExpression3 = DivPageTransformationOverlapJsonParser.NEXT_PAGE_SCALE_DEFAULT_VALUE;
            }
            Expression<Double> expression3 = expressionResolveOptionalExpression3;
            Expression<Double> expressionResolveOptionalExpression4 = JsonFieldResolver.resolveOptionalExpression(context, template.previousPageAlpha, data, "previous_page_alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivPageTransformationOverlapJsonParser.PREVIOUS_PAGE_ALPHA_VALIDATOR, DivPageTransformationOverlapJsonParser.PREVIOUS_PAGE_ALPHA_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression4 == null) {
                expressionResolveOptionalExpression4 = DivPageTransformationOverlapJsonParser.PREVIOUS_PAGE_ALPHA_DEFAULT_VALUE;
            }
            Expression<Double> expression4 = expressionResolveOptionalExpression4;
            Expression<Double> expressionResolveOptionalExpression5 = JsonFieldResolver.resolveOptionalExpression(context, template.previousPageScale, data, "previous_page_scale", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivPageTransformationOverlapJsonParser.PREVIOUS_PAGE_SCALE_VALIDATOR, DivPageTransformationOverlapJsonParser.PREVIOUS_PAGE_SCALE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression5 == null) {
                expressionResolveOptionalExpression5 = DivPageTransformationOverlapJsonParser.PREVIOUS_PAGE_SCALE_DEFAULT_VALUE;
            }
            Expression<Double> expression5 = expressionResolveOptionalExpression5;
            Expression<Boolean> expressionResolveOptionalExpression6 = JsonFieldResolver.resolveOptionalExpression(context, template.reversedStackingOrder, data, "reversed_stacking_order", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivPageTransformationOverlapJsonParser.REVERSED_STACKING_ORDER_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression6 == null) {
                expressionResolveOptionalExpression6 = DivPageTransformationOverlapJsonParser.REVERSED_STACKING_ORDER_DEFAULT_VALUE;
            }
            return new DivPageTransformationOverlap(expression, expression2, expression3, expression4, expression5, expressionResolveOptionalExpression6);
        }
    }

    /* JADX INFO: compiled from: DivPageTransformationOverlapJsonParser.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/yandex/div2/DivPageTransformationOverlapJsonParser$Companion;", "", "()V", "INTERPOLATOR_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAnimationInterpolator;", "NEXT_PAGE_ALPHA_DEFAULT_VALUE", "", "NEXT_PAGE_ALPHA_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "NEXT_PAGE_SCALE_DEFAULT_VALUE", "NEXT_PAGE_SCALE_VALIDATOR", "PREVIOUS_PAGE_ALPHA_DEFAULT_VALUE", "PREVIOUS_PAGE_ALPHA_VALIDATOR", "PREVIOUS_PAGE_SCALE_DEFAULT_VALUE", "PREVIOUS_PAGE_SCALE_VALIDATOR", "REVERSED_STACKING_ORDER_DEFAULT_VALUE", "", "TYPE_HELPER_INTERPOLATOR", "Lcom/yandex/div/internal/parser/TypeHelper;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Expression.Companion companion = Expression.INSTANCE;
        Double dValueOf = Double.valueOf(1.0d);
        NEXT_PAGE_ALPHA_DEFAULT_VALUE = companion.constant(dValueOf);
        NEXT_PAGE_SCALE_DEFAULT_VALUE = Expression.INSTANCE.constant(dValueOf);
        PREVIOUS_PAGE_ALPHA_DEFAULT_VALUE = Expression.INSTANCE.constant(dValueOf);
        PREVIOUS_PAGE_SCALE_DEFAULT_VALUE = Expression.INSTANCE.constant(dValueOf);
        REVERSED_STACKING_ORDER_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
        TYPE_HELPER_INTERPOLATOR = TypeHelper.INSTANCE.from(ArraysKt.first(DivAnimationInterpolator.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivPageTransformationOverlapJsonParser$Companion$TYPE_HELPER_INTERPOLATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivAnimationInterpolator);
            }
        });
        NEXT_PAGE_ALPHA_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivPageTransformationOverlapJsonParser$$ExternalSyntheticLambda0
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivPageTransformationOverlapJsonParser.NEXT_PAGE_ALPHA_VALIDATOR$lambda$0(((Double) obj).doubleValue());
            }
        };
        NEXT_PAGE_SCALE_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivPageTransformationOverlapJsonParser$$ExternalSyntheticLambda1
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivPageTransformationOverlapJsonParser.NEXT_PAGE_SCALE_VALIDATOR$lambda$1(((Double) obj).doubleValue());
            }
        };
        PREVIOUS_PAGE_ALPHA_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivPageTransformationOverlapJsonParser$$ExternalSyntheticLambda2
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivPageTransformationOverlapJsonParser.PREVIOUS_PAGE_ALPHA_VALIDATOR$lambda$2(((Double) obj).doubleValue());
            }
        };
        PREVIOUS_PAGE_SCALE_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivPageTransformationOverlapJsonParser$$ExternalSyntheticLambda3
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivPageTransformationOverlapJsonParser.PREVIOUS_PAGE_SCALE_VALIDATOR$lambda$3(((Double) obj).doubleValue());
            }
        };
    }
}
