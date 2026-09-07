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

/* JADX INFO: compiled from: DivSlideTransitionJsonParser.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivSlideTransitionJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivSlideTransitionJsonParser {
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<Long> DURATION_DEFAULT_VALUE = Expression.INSTANCE.constant(200L);

    @Deprecated
    public static final Expression<DivSlideTransition.Edge> EDGE_DEFAULT_VALUE = Expression.INSTANCE.constant(DivSlideTransition.Edge.BOTTOM);

    @Deprecated
    public static final Expression<DivAnimationInterpolator> INTERPOLATOR_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAnimationInterpolator.EASE_IN_OUT);

    @Deprecated
    public static final Expression<Long> START_DELAY_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);

    @Deprecated
    public static final TypeHelper<DivSlideTransition.Edge> TYPE_HELPER_EDGE = TypeHelper.INSTANCE.from(ArraysKt.first(DivSlideTransition.Edge.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivSlideTransitionJsonParser$Companion$TYPE_HELPER_EDGE$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivSlideTransition.Edge);
        }
    });

    @Deprecated
    public static final TypeHelper<DivAnimationInterpolator> TYPE_HELPER_INTERPOLATOR = TypeHelper.INSTANCE.from(ArraysKt.first(DivAnimationInterpolator.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivSlideTransitionJsonParser$Companion$TYPE_HELPER_INTERPOLATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivAnimationInterpolator);
        }
    });

    @Deprecated
    public static final ValueValidator<Long> DURATION_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivSlideTransitionJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivSlideTransitionJsonParser.DURATION_VALIDATOR$lambda$0(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> START_DELAY_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivSlideTransitionJsonParser$$ExternalSyntheticLambda1
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivSlideTransitionJsonParser.START_DELAY_VALIDATOR$lambda$1(((Long) obj).longValue());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DURATION_VALIDATOR$lambda$0(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean START_DELAY_VALIDATOR$lambda$1(long j) {
        return j >= 0;
    }

    public DivSlideTransitionJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivSlideTransitionJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivSlideTransitionJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivSlideTransition;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivSlideTransition> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivSlideTransition deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            DivDimension divDimension = (DivDimension) JsonPropertyParser.readOptional(context, data, "distance", this.component.getDivDimensionJsonEntityParser());
            Expression<Long> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "duration", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivSlideTransitionJsonParser.DURATION_VALIDATOR, DivSlideTransitionJsonParser.DURATION_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivSlideTransitionJsonParser.DURATION_DEFAULT_VALUE;
            }
            Expression<Long> expression = optionalExpression;
            Expression<DivSlideTransition.Edge> optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, "edge", DivSlideTransitionJsonParser.TYPE_HELPER_EDGE, DivSlideTransition.Edge.FROM_STRING, DivSlideTransitionJsonParser.EDGE_DEFAULT_VALUE);
            if (optionalExpression2 == null) {
                optionalExpression2 = DivSlideTransitionJsonParser.EDGE_DEFAULT_VALUE;
            }
            Expression<DivSlideTransition.Edge> expression2 = optionalExpression2;
            Expression<DivAnimationInterpolator> optionalExpression3 = JsonExpressionParser.readOptionalExpression(context, data, "interpolator", DivSlideTransitionJsonParser.TYPE_HELPER_INTERPOLATOR, DivAnimationInterpolator.FROM_STRING, DivSlideTransitionJsonParser.INTERPOLATOR_DEFAULT_VALUE);
            if (optionalExpression3 == null) {
                optionalExpression3 = DivSlideTransitionJsonParser.INTERPOLATOR_DEFAULT_VALUE;
            }
            Expression<DivAnimationInterpolator> expression3 = optionalExpression3;
            Expression<Long> optionalExpression4 = JsonExpressionParser.readOptionalExpression(context, data, "start_delay", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivSlideTransitionJsonParser.START_DELAY_VALIDATOR, DivSlideTransitionJsonParser.START_DELAY_DEFAULT_VALUE);
            if (optionalExpression4 == null) {
                optionalExpression4 = DivSlideTransitionJsonParser.START_DELAY_DEFAULT_VALUE;
            }
            return new DivSlideTransition(divDimension, expression, expression2, expression3, optionalExpression4);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivSlideTransition value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonPropertyParser.write(context, jSONObject, "distance", value.distance, this.component.getDivDimensionJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "duration", value.getDuration());
            JsonExpressionParser.writeExpression(context, jSONObject, "edge", value.edge, DivSlideTransition.Edge.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "interpolator", value.getInterpolator(), DivAnimationInterpolator.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "start_delay", value.getStartDelay());
            JsonPropertyParser.write(context, jSONObject, "type", "slide");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivSlideTransitionJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivSlideTransitionJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivSlideTransitionTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivSlideTransitionTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivSlideTransitionTemplate deserialize(ParsingContext context, DivSlideTransitionTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "distance", allowPropertyOverride, parent != null ? parent.distance : null, this.component.getDivDimensionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex…ensionJsonTemplateParser)");
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "duration", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.duration : null, ParsingConvertersKt.NUMBER_TO_INT, DivSlideTransitionJsonParser.DURATION_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…_INT, DURATION_VALIDATOR)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "edge", DivSlideTransitionJsonParser.TYPE_HELPER_EDGE, allowPropertyOverride, parent != null ? parent.edge : null, DivSlideTransition.Edge.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…nsition.Edge.FROM_STRING)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "interpolator", DivSlideTransitionJsonParser.TYPE_HELPER_INTERPOLATOR, allowPropertyOverride, parent != null ? parent.interpolator : null, DivAnimationInterpolator.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…Interpolator.FROM_STRING)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "start_delay", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.startDelay : null, ParsingConvertersKt.NUMBER_TO_INT, DivSlideTransitionJsonParser.START_DELAY_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…T, START_DELAY_VALIDATOR)");
            return new DivSlideTransitionTemplate(optionalField, optionalFieldWithExpression, optionalFieldWithExpression2, optionalFieldWithExpression3, optionalFieldWithExpression4);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivSlideTransitionTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeField(context, jSONObject, "distance", value.distance, this.component.getDivDimensionJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "duration", value.duration);
            JsonFieldParser.writeExpressionField(context, jSONObject, "edge", value.edge, DivSlideTransition.Edge.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "interpolator", value.interpolator, DivAnimationInterpolator.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "start_delay", value.startDelay);
            JsonPropertyParser.write(context, jSONObject, "type", "slide");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivSlideTransitionJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivSlideTransitionJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivSlideTransitionTemplate;", "Lcom/yandex/div2/DivSlideTransition;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivSlideTransitionTemplate, DivSlideTransition> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivSlideTransition resolve(ParsingContext context, DivSlideTransitionTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            DivDimension divDimension = (DivDimension) JsonFieldResolver.resolveOptional(context, template.distance, data, "distance", this.component.getDivDimensionJsonTemplateResolver(), this.component.getDivDimensionJsonEntityParser());
            Expression<Long> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.duration, data, "duration", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivSlideTransitionJsonParser.DURATION_VALIDATOR, DivSlideTransitionJsonParser.DURATION_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivSlideTransitionJsonParser.DURATION_DEFAULT_VALUE;
            }
            Expression<Long> expression = expressionResolveOptionalExpression;
            Expression<DivSlideTransition.Edge> expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.edge, data, "edge", DivSlideTransitionJsonParser.TYPE_HELPER_EDGE, DivSlideTransition.Edge.FROM_STRING, DivSlideTransitionJsonParser.EDGE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression2 == null) {
                expressionResolveOptionalExpression2 = DivSlideTransitionJsonParser.EDGE_DEFAULT_VALUE;
            }
            Expression<DivSlideTransition.Edge> expression2 = expressionResolveOptionalExpression2;
            Expression<DivAnimationInterpolator> expressionResolveOptionalExpression3 = JsonFieldResolver.resolveOptionalExpression(context, template.interpolator, data, "interpolator", DivSlideTransitionJsonParser.TYPE_HELPER_INTERPOLATOR, DivAnimationInterpolator.FROM_STRING, DivSlideTransitionJsonParser.INTERPOLATOR_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression3 == null) {
                expressionResolveOptionalExpression3 = DivSlideTransitionJsonParser.INTERPOLATOR_DEFAULT_VALUE;
            }
            Expression<DivAnimationInterpolator> expression3 = expressionResolveOptionalExpression3;
            Expression<Long> expressionResolveOptionalExpression4 = JsonFieldResolver.resolveOptionalExpression(context, template.startDelay, data, "start_delay", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivSlideTransitionJsonParser.START_DELAY_VALIDATOR, DivSlideTransitionJsonParser.START_DELAY_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression4 == null) {
                expressionResolveOptionalExpression4 = DivSlideTransitionJsonParser.START_DELAY_DEFAULT_VALUE;
            }
            return new DivSlideTransition(divDimension, expression, expression2, expression3, expressionResolveOptionalExpression4);
        }
    }

    /* JADX INFO: compiled from: DivSlideTransitionJsonParser.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div2/DivSlideTransitionJsonParser$Companion;", "", "()V", "DURATION_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "DURATION_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "EDGE_DEFAULT_VALUE", "Lcom/yandex/div2/DivSlideTransition$Edge;", "INTERPOLATOR_DEFAULT_VALUE", "Lcom/yandex/div2/DivAnimationInterpolator;", "START_DELAY_DEFAULT_VALUE", "START_DELAY_VALIDATOR", "TYPE_HELPER_EDGE", "Lcom/yandex/div/internal/parser/TypeHelper;", "TYPE_HELPER_INTERPOLATOR", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
