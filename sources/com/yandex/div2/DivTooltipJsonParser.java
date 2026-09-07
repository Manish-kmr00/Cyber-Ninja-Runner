package com.yandex.div2;

import com.json.b9;
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

/* JADX INFO: compiled from: DivTooltipJsonParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivTooltipJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivTooltipJsonParser {
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<Boolean> CLOSE_BY_TAP_OUTSIDE_DEFAULT_VALUE = Expression.INSTANCE.constant(true);

    @Deprecated
    public static final Expression<Long> DURATION_DEFAULT_VALUE = Expression.INSTANCE.constant(5000L);

    @Deprecated
    public static final DivTooltipMode.Modal MODE_DEFAULT_VALUE = new DivTooltipMode.Modal(new DivTooltipModeModal());

    @Deprecated
    public static final TypeHelper<DivTooltip.Position> TYPE_HELPER_POSITION = TypeHelper.INSTANCE.from(ArraysKt.first(DivTooltip.Position.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTooltipJsonParser$Companion$TYPE_HELPER_POSITION$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivTooltip.Position);
        }
    });

    @Deprecated
    public static final ValueValidator<Long> DURATION_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTooltipJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivTooltipJsonParser.DURATION_VALIDATOR$lambda$0(((Long) obj).longValue());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DURATION_VALIDATOR$lambda$0(long j) {
        return j >= 0;
    }

    public DivTooltipJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivTooltipJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivTooltipJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTooltip;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivTooltip> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivTooltip deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            DivAnimation divAnimation = (DivAnimation) JsonPropertyParser.readOptional(context, data, "animation_in", this.component.getDivAnimationJsonEntityParser());
            DivAnimation divAnimation2 = (DivAnimation) JsonPropertyParser.readOptional(context, data, "animation_out", this.component.getDivAnimationJsonEntityParser());
            Expression<Boolean> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "close_by_tap_outside", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivTooltipJsonParser.CLOSE_BY_TAP_OUTSIDE_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivTooltipJsonParser.CLOSE_BY_TAP_OUTSIDE_DEFAULT_VALUE;
            }
            Expression<Boolean> expression = optionalExpression;
            Object obj = JsonPropertyParser.read(context, data, "div", this.component.getDivJsonEntityParser());
            Intrinsics.checkNotNullExpressionValue(obj, "read(context, data, \"div…nent.divJsonEntityParser)");
            Div div = (Div) obj;
            Expression<Long> optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, "duration", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTooltipJsonParser.DURATION_VALIDATOR, DivTooltipJsonParser.DURATION_DEFAULT_VALUE);
            if (optionalExpression2 == null) {
                optionalExpression2 = DivTooltipJsonParser.DURATION_DEFAULT_VALUE;
            }
            Expression<Long> expression2 = optionalExpression2;
            Object obj2 = JsonPropertyParser.read(context, data, "id");
            Intrinsics.checkNotNullExpressionValue(obj2, "read(context, data, \"id\")");
            String str = (String) obj2;
            DivTooltipMode.Modal modal = (DivTooltipMode) JsonPropertyParser.readOptional(context, data, b9.a.t, this.component.getDivTooltipModeJsonEntityParser());
            if (modal == null) {
                modal = DivTooltipJsonParser.MODE_DEFAULT_VALUE;
            }
            DivTooltipMode divTooltipMode = modal;
            Intrinsics.checkNotNullExpressionValue(divTooltipMode, "JsonPropertyParser.readO…er) ?: MODE_DEFAULT_VALUE");
            DivPoint divPoint = (DivPoint) JsonPropertyParser.readOptional(context, data, "offset", this.component.getDivPointJsonEntityParser());
            Expression expression3 = JsonExpressionParser.readExpression(context, data, b9.h.L, DivTooltipJsonParser.TYPE_HELPER_POSITION, DivTooltip.Position.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(expression3, "readExpression(context, …tip.Position.FROM_STRING)");
            return new DivTooltip(divAnimation, divAnimation2, expression, div, expression2, str, divTooltipMode, divPoint, expression3, JsonPropertyParser.readOptionalList(context, data, "tap_outside_actions", this.component.getDivActionJsonEntityParser()));
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivTooltip value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonPropertyParser.write(context, jSONObject, "animation_in", value.animationIn, this.component.getDivAnimationJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "animation_out", value.animationOut, this.component.getDivAnimationJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "close_by_tap_outside", value.closeByTapOutside);
            JsonPropertyParser.write(context, jSONObject, "div", value.div, this.component.getDivJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "duration", value.duration);
            JsonPropertyParser.write(context, jSONObject, "id", value.id);
            JsonPropertyParser.write(context, jSONObject, b9.a.t, value.mode, this.component.getDivTooltipModeJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "offset", value.offset, this.component.getDivPointJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, b9.h.L, value.position, DivTooltip.Position.TO_STRING);
            JsonPropertyParser.writeList(context, jSONObject, "tap_outside_actions", value.tapOutsideActions, this.component.getDivActionJsonEntityParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivTooltipJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivTooltipJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTooltipTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivTooltipTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivTooltipTemplate deserialize(ParsingContext context, DivTooltipTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "animation_in", allowPropertyOverride, parent != null ? parent.animationIn : null, this.component.getDivAnimationJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex…mationJsonTemplateParser)");
            Field optionalField2 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "animation_out", allowPropertyOverride, parent != null ? parent.animationOut : null, this.component.getDivAnimationJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField2, "readOptionalField(contex…mationJsonTemplateParser)");
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "close_by_tap_outside", TypeHelpersKt.TYPE_HELPER_BOOLEAN, allowPropertyOverride, parent != null ? parent.closeByTapOutside : null, ParsingConvertersKt.ANY_TO_BOOLEAN);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…pOutside, ANY_TO_BOOLEAN)");
            Field field = JsonFieldParser.readField(parsingContextRestrictPropertyOverride, data, "div", allowPropertyOverride, parent != null ? parent.div : null, this.component.getDivJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(field, "readField(context, data,…nt.divJsonTemplateParser)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "duration", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.duration : null, ParsingConvertersKt.NUMBER_TO_INT, DivTooltipJsonParser.DURATION_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…_INT, DURATION_VALIDATOR)");
            Field field2 = JsonFieldParser.readField(parsingContextRestrictPropertyOverride, data, "id", allowPropertyOverride, parent != null ? parent.id : null);
            Intrinsics.checkNotNullExpressionValue(field2, "readField(context, data,…llowOverride, parent?.id)");
            Field optionalField3 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, b9.a.t, allowPropertyOverride, parent != null ? parent.mode : null, this.component.getDivTooltipModeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField3, "readOptionalField(contex…ipModeJsonTemplateParser)");
            Field optionalField4 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "offset", allowPropertyOverride, parent != null ? parent.offset : null, this.component.getDivPointJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField4, "readOptionalField(contex…vPointJsonTemplateParser)");
            Field fieldWithExpression = JsonFieldParser.readFieldWithExpression(parsingContextRestrictPropertyOverride, data, b9.h.L, DivTooltipJsonParser.TYPE_HELPER_POSITION, allowPropertyOverride, parent != null ? parent.position : null, DivTooltip.Position.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(fieldWithExpression, "readFieldWithExpression(…tip.Position.FROM_STRING)");
            Field optionalListField = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "tap_outside_actions", allowPropertyOverride, parent != null ? parent.tapOutsideActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField, "readOptionalListField(co…ActionJsonTemplateParser)");
            return new DivTooltipTemplate(optionalField, optionalField2, optionalFieldWithExpression, field, optionalFieldWithExpression2, field2, optionalField3, optionalField4, fieldWithExpression, optionalListField);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivTooltipTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeField(context, jSONObject, "animation_in", value.animationIn, this.component.getDivAnimationJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "animation_out", value.animationOut, this.component.getDivAnimationJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "close_by_tap_outside", value.closeByTapOutside);
            JsonFieldParser.writeField(context, jSONObject, "div", value.div, this.component.getDivJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "duration", value.duration);
            JsonFieldParser.writeField(context, jSONObject, "id", value.id);
            JsonFieldParser.writeField(context, jSONObject, b9.a.t, value.mode, this.component.getDivTooltipModeJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "offset", value.offset, this.component.getDivPointJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, b9.h.L, value.position, DivTooltip.Position.TO_STRING);
            JsonFieldParser.writeListField(context, jSONObject, "tap_outside_actions", value.tapOutsideActions, this.component.getDivActionJsonTemplateParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivTooltipJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivTooltipJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTooltipTemplate;", "Lcom/yandex/div2/DivTooltip;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivTooltipTemplate, DivTooltip> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivTooltip resolve(ParsingContext context, DivTooltipTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            DivAnimation divAnimation = (DivAnimation) JsonFieldResolver.resolveOptional(context, template.animationIn, data, "animation_in", this.component.getDivAnimationJsonTemplateResolver(), this.component.getDivAnimationJsonEntityParser());
            DivAnimation divAnimation2 = (DivAnimation) JsonFieldResolver.resolveOptional(context, template.animationOut, data, "animation_out", this.component.getDivAnimationJsonTemplateResolver(), this.component.getDivAnimationJsonEntityParser());
            Expression<Boolean> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.closeByTapOutside, data, "close_by_tap_outside", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivTooltipJsonParser.CLOSE_BY_TAP_OUTSIDE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivTooltipJsonParser.CLOSE_BY_TAP_OUTSIDE_DEFAULT_VALUE;
            }
            Expression<Boolean> expression = expressionResolveOptionalExpression;
            Object objResolve = JsonFieldResolver.resolve(context, template.div, data, "div", this.component.getDivJsonTemplateResolver(), this.component.getDivJsonEntityParser());
            Intrinsics.checkNotNullExpressionValue(objResolve, "resolve(context, templat…nent.divJsonEntityParser)");
            Div div = (Div) objResolve;
            Expression<Long> expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.duration, data, "duration", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTooltipJsonParser.DURATION_VALIDATOR, DivTooltipJsonParser.DURATION_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression2 == null) {
                expressionResolveOptionalExpression2 = DivTooltipJsonParser.DURATION_DEFAULT_VALUE;
            }
            Expression<Long> expression2 = expressionResolveOptionalExpression2;
            Object objResolve2 = JsonFieldResolver.resolve(context, template.id, data, "id");
            Intrinsics.checkNotNullExpressionValue(objResolve2, "resolve(context, template.id, data, \"id\")");
            String str = (String) objResolve2;
            DivTooltipMode.Modal modal = (DivTooltipMode) JsonFieldResolver.resolveOptional(context, template.mode, data, b9.a.t, this.component.getDivTooltipModeJsonTemplateResolver(), this.component.getDivTooltipModeJsonEntityParser());
            if (modal == null) {
                modal = DivTooltipJsonParser.MODE_DEFAULT_VALUE;
            }
            DivTooltipMode divTooltipMode = modal;
            Intrinsics.checkNotNullExpressionValue(divTooltipMode, "JsonFieldResolver.resolv…er) ?: MODE_DEFAULT_VALUE");
            DivPoint divPoint = (DivPoint) JsonFieldResolver.resolveOptional(context, template.offset, data, "offset", this.component.getDivPointJsonTemplateResolver(), this.component.getDivPointJsonEntityParser());
            Expression expressionResolveExpression = JsonFieldResolver.resolveExpression(context, template.position, data, b9.h.L, DivTooltipJsonParser.TYPE_HELPER_POSITION, DivTooltip.Position.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(expressionResolveExpression, "resolveExpression(contex…tip.Position.FROM_STRING)");
            return new DivTooltip(divAnimation, divAnimation2, expression, div, expression2, str, divTooltipMode, divPoint, expressionResolveExpression, JsonFieldResolver.resolveOptionalList(context, template.tapOutsideActions, data, "tap_outside_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser()));
        }
    }

    /* JADX INFO: compiled from: DivTooltipJsonParser.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/yandex/div2/DivTooltipJsonParser$Companion;", "", "()V", "CLOSE_BY_TAP_OUTSIDE_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "DURATION_DEFAULT_VALUE", "", "DURATION_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "MODE_DEFAULT_VALUE", "Lcom/yandex/div2/DivTooltipMode$Modal;", "TYPE_HELPER_POSITION", "Lcom/yandex/div/internal/parser/TypeHelper;", "Lcom/yandex/div2/DivTooltip$Position;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
