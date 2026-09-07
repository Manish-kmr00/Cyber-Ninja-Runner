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
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivColorAnimatorJsonParser.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivColorAnimatorJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivColorAnimatorJsonParser {
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<DivAnimationDirection> DIRECTION_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAnimationDirection.NORMAL);

    @Deprecated
    public static final Expression<DivAnimationInterpolator> INTERPOLATOR_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAnimationInterpolator.LINEAR);

    @Deprecated
    public static final DivCount.Fixed REPEAT_COUNT_DEFAULT_VALUE = new DivCount.Fixed(new DivFixedCount(Expression.INSTANCE.constant(1L)));

    @Deprecated
    public static final Expression<Long> START_DELAY_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);

    @Deprecated
    public static final TypeHelper<DivAnimationDirection> TYPE_HELPER_DIRECTION = TypeHelper.INSTANCE.from(ArraysKt.first(DivAnimationDirection.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivColorAnimatorJsonParser$Companion$TYPE_HELPER_DIRECTION$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivAnimationDirection);
        }
    });

    @Deprecated
    public static final TypeHelper<DivAnimationInterpolator> TYPE_HELPER_INTERPOLATOR = TypeHelper.INSTANCE.from(ArraysKt.first(DivAnimationInterpolator.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivColorAnimatorJsonParser$Companion$TYPE_HELPER_INTERPOLATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivAnimationInterpolator);
        }
    });

    @Deprecated
    public static final ValueValidator<Long> DURATION_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivColorAnimatorJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivColorAnimatorJsonParser.DURATION_VALIDATOR$lambda$0(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> START_DELAY_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivColorAnimatorJsonParser$$ExternalSyntheticLambda1
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivColorAnimatorJsonParser.START_DELAY_VALIDATOR$lambda$1(((Long) obj).longValue());
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

    public DivColorAnimatorJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivColorAnimatorJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivColorAnimatorJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivColorAnimator;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivColorAnimator> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivColorAnimator deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            List optionalList = JsonPropertyParser.readOptionalList(context, data, "cancel_actions", this.component.getDivActionJsonEntityParser());
            Expression<DivAnimationDirection> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "direction", DivColorAnimatorJsonParser.TYPE_HELPER_DIRECTION, DivAnimationDirection.FROM_STRING, DivColorAnimatorJsonParser.DIRECTION_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivColorAnimatorJsonParser.DIRECTION_DEFAULT_VALUE;
            }
            Expression<DivAnimationDirection> expression = optionalExpression;
            Expression expression2 = JsonExpressionParser.readExpression(context, data, "duration", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivColorAnimatorJsonParser.DURATION_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(expression2, "readExpression(context, …_INT, DURATION_VALIDATOR)");
            List optionalList2 = JsonPropertyParser.readOptionalList(context, data, "end_actions", this.component.getDivActionJsonEntityParser());
            Expression expression3 = JsonExpressionParser.readExpression(context, data, "end_value", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(expression3, "readExpression(context, …LOR, STRING_TO_COLOR_INT)");
            Object obj = JsonPropertyParser.read(context, data, "id");
            Intrinsics.checkNotNullExpressionValue(obj, "read(context, data, \"id\")");
            String str = (String) obj;
            Expression<DivAnimationInterpolator> optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, "interpolator", DivColorAnimatorJsonParser.TYPE_HELPER_INTERPOLATOR, DivAnimationInterpolator.FROM_STRING, DivColorAnimatorJsonParser.INTERPOLATOR_DEFAULT_VALUE);
            if (optionalExpression2 == null) {
                optionalExpression2 = DivColorAnimatorJsonParser.INTERPOLATOR_DEFAULT_VALUE;
            }
            Expression<DivAnimationInterpolator> expression4 = optionalExpression2;
            DivCount.Fixed fixed = (DivCount) JsonPropertyParser.readOptional(context, data, "repeat_count", this.component.getDivCountJsonEntityParser());
            if (fixed == null) {
                fixed = DivColorAnimatorJsonParser.REPEAT_COUNT_DEFAULT_VALUE;
            }
            DivCount divCount = fixed;
            Intrinsics.checkNotNullExpressionValue(divCount, "JsonPropertyParser.readO…EPEAT_COUNT_DEFAULT_VALUE");
            Expression<Long> optionalExpression3 = JsonExpressionParser.readOptionalExpression(context, data, "start_delay", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivColorAnimatorJsonParser.START_DELAY_VALIDATOR, DivColorAnimatorJsonParser.START_DELAY_DEFAULT_VALUE);
            if (optionalExpression3 == null) {
                optionalExpression3 = DivColorAnimatorJsonParser.START_DELAY_DEFAULT_VALUE;
            }
            Expression optionalExpression4 = JsonExpressionParser.readOptionalExpression(context, data, "start_value", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Object obj2 = JsonPropertyParser.read(context, data, "variable_name");
            Intrinsics.checkNotNullExpressionValue(obj2, "read(context, data, \"variable_name\")");
            return new DivColorAnimator(optionalList, expression, expression2, optionalList2, expression3, str, expression4, divCount, optionalExpression3, optionalExpression4, (String) obj2);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivColorAnimator value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonPropertyParser.writeList(context, jSONObject, "cancel_actions", value.getCancelActions(), this.component.getDivActionJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "direction", value.getDirection(), DivAnimationDirection.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "duration", value.getDuration());
            JsonPropertyParser.writeList(context, jSONObject, "end_actions", value.getEndActions(), this.component.getDivActionJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "end_value", value.endValue, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "id", value.getId());
            JsonExpressionParser.writeExpression(context, jSONObject, "interpolator", value.getInterpolator(), DivAnimationInterpolator.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "repeat_count", value.getRepeatCount(), this.component.getDivCountJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "start_delay", value.getStartDelay());
            JsonExpressionParser.writeExpression(context, jSONObject, "start_value", value.startValue, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "type", "color_animator");
            JsonPropertyParser.write(context, jSONObject, "variable_name", value.getVariableName());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivColorAnimatorJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivColorAnimatorJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivColorAnimatorTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivColorAnimatorTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivColorAnimatorTemplate deserialize(ParsingContext context, DivColorAnimatorTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalListField = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "cancel_actions", allowPropertyOverride, parent != null ? parent.cancelActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "direction", DivColorAnimatorJsonParser.TYPE_HELPER_DIRECTION, allowPropertyOverride, parent != null ? parent.direction : null, DivAnimationDirection.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…ionDirection.FROM_STRING)");
            Field fieldWithExpression = JsonFieldParser.readFieldWithExpression(parsingContextRestrictPropertyOverride, data, "duration", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.duration : null, ParsingConvertersKt.NUMBER_TO_INT, DivColorAnimatorJsonParser.DURATION_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(fieldWithExpression, "readFieldWithExpression(…_INT, DURATION_VALIDATOR)");
            Field optionalListField2 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "end_actions", allowPropertyOverride, parent != null ? parent.endActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField2, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field fieldWithExpression2 = JsonFieldParser.readFieldWithExpression(parsingContextRestrictPropertyOverride, data, "end_value", TypeHelpersKt.TYPE_HELPER_COLOR, allowPropertyOverride, parent != null ? parent.endValue : null, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(fieldWithExpression2, "readFieldWithExpression(…lue, STRING_TO_COLOR_INT)");
            Field field = JsonFieldParser.readField(parsingContextRestrictPropertyOverride, data, "id", allowPropertyOverride, parent != null ? parent.id : null);
            Intrinsics.checkNotNullExpressionValue(field, "readField(context, data,…llowOverride, parent?.id)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "interpolator", DivColorAnimatorJsonParser.TYPE_HELPER_INTERPOLATOR, allowPropertyOverride, parent != null ? parent.interpolator : null, DivAnimationInterpolator.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…Interpolator.FROM_STRING)");
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "repeat_count", allowPropertyOverride, parent != null ? parent.repeatCount : null, this.component.getDivCountJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex…vCountJsonTemplateParser)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "start_delay", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.startDelay : null, ParsingConvertersKt.NUMBER_TO_INT, DivColorAnimatorJsonParser.START_DELAY_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…T, START_DELAY_VALIDATOR)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "start_value", TypeHelpersKt.TYPE_HELPER_COLOR, allowPropertyOverride, parent != null ? parent.startValue : null, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…lue, STRING_TO_COLOR_INT)");
            Field field2 = JsonFieldParser.readField(parsingContextRestrictPropertyOverride, data, "variable_name", allowPropertyOverride, parent != null ? parent.variableName : null);
            Intrinsics.checkNotNullExpressionValue(field2, "readField(context, data,…de, parent?.variableName)");
            return new DivColorAnimatorTemplate(optionalListField, optionalFieldWithExpression, fieldWithExpression, optionalListField2, fieldWithExpression2, field, optionalFieldWithExpression2, optionalField, optionalFieldWithExpression3, optionalFieldWithExpression4, field2);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivColorAnimatorTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeListField(context, jSONObject, "cancel_actions", value.cancelActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "direction", value.direction, DivAnimationDirection.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "duration", value.duration);
            JsonFieldParser.writeListField(context, jSONObject, "end_actions", value.endActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "end_value", value.endValue, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "id", value.id);
            JsonFieldParser.writeExpressionField(context, jSONObject, "interpolator", value.interpolator, DivAnimationInterpolator.TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "repeat_count", value.repeatCount, this.component.getDivCountJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "start_delay", value.startDelay);
            JsonFieldParser.writeExpressionField(context, jSONObject, "start_value", value.startValue, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "type", "color_animator");
            JsonFieldParser.writeField(context, jSONObject, "variable_name", value.variableName);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivColorAnimatorJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivColorAnimatorJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivColorAnimatorTemplate;", "Lcom/yandex/div2/DivColorAnimator;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivColorAnimatorTemplate, DivColorAnimator> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivColorAnimator resolve(ParsingContext context, DivColorAnimatorTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            List listResolveOptionalList = JsonFieldResolver.resolveOptionalList(context, template.cancelActions, data, "cancel_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            Expression<DivAnimationDirection> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.direction, data, "direction", DivColorAnimatorJsonParser.TYPE_HELPER_DIRECTION, DivAnimationDirection.FROM_STRING, DivColorAnimatorJsonParser.DIRECTION_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivColorAnimatorJsonParser.DIRECTION_DEFAULT_VALUE;
            }
            Expression<DivAnimationDirection> expression = expressionResolveOptionalExpression;
            Expression expressionResolveExpression = JsonFieldResolver.resolveExpression(context, template.duration, data, "duration", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivColorAnimatorJsonParser.DURATION_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(expressionResolveExpression, "resolveExpression(contex…_INT, DURATION_VALIDATOR)");
            List listResolveOptionalList2 = JsonFieldResolver.resolveOptionalList(context, template.endActions, data, "end_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            Expression expressionResolveExpression2 = JsonFieldResolver.resolveExpression(context, template.endValue, data, "end_value", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(expressionResolveExpression2, "resolveExpression(contex…LOR, STRING_TO_COLOR_INT)");
            Object objResolve = JsonFieldResolver.resolve(context, template.id, data, "id");
            Intrinsics.checkNotNullExpressionValue(objResolve, "resolve(context, template.id, data, \"id\")");
            String str = (String) objResolve;
            Expression<DivAnimationInterpolator> expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.interpolator, data, "interpolator", DivColorAnimatorJsonParser.TYPE_HELPER_INTERPOLATOR, DivAnimationInterpolator.FROM_STRING, DivColorAnimatorJsonParser.INTERPOLATOR_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression2 == null) {
                expressionResolveOptionalExpression2 = DivColorAnimatorJsonParser.INTERPOLATOR_DEFAULT_VALUE;
            }
            Expression<DivAnimationInterpolator> expression2 = expressionResolveOptionalExpression2;
            DivCount.Fixed fixed = (DivCount) JsonFieldResolver.resolveOptional(context, template.repeatCount, data, "repeat_count", this.component.getDivCountJsonTemplateResolver(), this.component.getDivCountJsonEntityParser());
            if (fixed == null) {
                fixed = DivColorAnimatorJsonParser.REPEAT_COUNT_DEFAULT_VALUE;
            }
            DivCount divCount = fixed;
            Intrinsics.checkNotNullExpressionValue(divCount, "JsonFieldResolver.resolv…EPEAT_COUNT_DEFAULT_VALUE");
            Expression<Long> expressionResolveOptionalExpression3 = JsonFieldResolver.resolveOptionalExpression(context, template.startDelay, data, "start_delay", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivColorAnimatorJsonParser.START_DELAY_VALIDATOR, DivColorAnimatorJsonParser.START_DELAY_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression3 == null) {
                expressionResolveOptionalExpression3 = DivColorAnimatorJsonParser.START_DELAY_DEFAULT_VALUE;
            }
            Expression<Long> expression3 = expressionResolveOptionalExpression3;
            Expression expressionResolveOptionalExpression4 = JsonFieldResolver.resolveOptionalExpression(context, template.startValue, data, "start_value", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Object objResolve2 = JsonFieldResolver.resolve(context, template.variableName, data, "variable_name");
            Intrinsics.checkNotNullExpressionValue(objResolve2, "resolve(context, templat…e, data, \"variable_name\")");
            return new DivColorAnimator(listResolveOptionalList, expression, expressionResolveExpression, listResolveOptionalList2, expressionResolveExpression2, str, expression2, divCount, expression3, expressionResolveOptionalExpression4, (String) objResolve2);
        }
    }

    /* JADX INFO: compiled from: DivColorAnimatorJsonParser.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00108\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00108\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/yandex/div2/DivColorAnimatorJsonParser$Companion;", "", "()V", "DIRECTION_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAnimationDirection;", "DURATION_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "", "INTERPOLATOR_DEFAULT_VALUE", "Lcom/yandex/div2/DivAnimationInterpolator;", "REPEAT_COUNT_DEFAULT_VALUE", "Lcom/yandex/div2/DivCount$Fixed;", "START_DELAY_DEFAULT_VALUE", "START_DELAY_VALIDATOR", "TYPE_HELPER_DIRECTION", "Lcom/yandex/div/internal/parser/TypeHelper;", "TYPE_HELPER_INTERPOLATOR", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
