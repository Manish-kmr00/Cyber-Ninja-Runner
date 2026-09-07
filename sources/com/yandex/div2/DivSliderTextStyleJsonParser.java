package com.yandex.div2;

import androidx.core.provider.FontsContractCompat;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
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

/* JADX INFO: compiled from: DivSliderJsonParser.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivSliderTextStyleJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivSliderTextStyleJsonParser {
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<DivSizeUnit> FONT_SIZE_UNIT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivSizeUnit.SP);

    @Deprecated
    public static final Expression<DivFontWeight> FONT_WEIGHT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivFontWeight.REGULAR);

    @Deprecated
    public static final Expression<Integer> TEXT_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));

    @Deprecated
    public static final TypeHelper<DivSizeUnit> TYPE_HELPER_FONT_SIZE_UNIT = TypeHelper.INSTANCE.from(ArraysKt.first(DivSizeUnit.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivSliderTextStyleJsonParser$Companion$TYPE_HELPER_FONT_SIZE_UNIT$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivSizeUnit);
        }
    });

    @Deprecated
    public static final TypeHelper<DivFontWeight> TYPE_HELPER_FONT_WEIGHT = TypeHelper.INSTANCE.from(ArraysKt.first(DivFontWeight.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivSliderTextStyleJsonParser$Companion$TYPE_HELPER_FONT_WEIGHT$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivFontWeight);
        }
    });

    @Deprecated
    public static final ValueValidator<Long> FONT_SIZE_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivSliderTextStyleJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivSliderTextStyleJsonParser.FONT_SIZE_VALIDATOR$lambda$0(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> FONT_WEIGHT_VALUE_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivSliderTextStyleJsonParser$$ExternalSyntheticLambda1
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivSliderTextStyleJsonParser.FONT_WEIGHT_VALUE_VALIDATOR$lambda$1(((Long) obj).longValue());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FONT_SIZE_VALIDATOR$lambda$0(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FONT_WEIGHT_VALUE_VALIDATOR$lambda$1(long j) {
        return j > 0;
    }

    public DivSliderTextStyleJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivSliderJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivSliderTextStyleJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivSlider$TextStyle;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivSlider.TextStyle> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivSlider.TextStyle deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression expression = JsonExpressionParser.readExpression(context, data, ViewHierarchyConstants.TEXT_SIZE, TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivSliderTextStyleJsonParser.FONT_SIZE_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(expression, "readExpression(context, …INT, FONT_SIZE_VALIDATOR)");
            Expression<DivSizeUnit> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "font_size_unit", DivSliderTextStyleJsonParser.TYPE_HELPER_FONT_SIZE_UNIT, DivSizeUnit.FROM_STRING, DivSliderTextStyleJsonParser.FONT_SIZE_UNIT_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivSliderTextStyleJsonParser.FONT_SIZE_UNIT_DEFAULT_VALUE;
            }
            Expression<DivSizeUnit> expression2 = optionalExpression;
            Expression<DivFontWeight> optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, FontsContractCompat.Columns.WEIGHT, DivSliderTextStyleJsonParser.TYPE_HELPER_FONT_WEIGHT, DivFontWeight.FROM_STRING, DivSliderTextStyleJsonParser.FONT_WEIGHT_DEFAULT_VALUE);
            if (optionalExpression2 == null) {
                optionalExpression2 = DivSliderTextStyleJsonParser.FONT_WEIGHT_DEFAULT_VALUE;
            }
            Expression<DivFontWeight> expression3 = optionalExpression2;
            Expression optionalExpression3 = JsonExpressionParser.readOptionalExpression(context, data, "font_weight_value", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivSliderTextStyleJsonParser.FONT_WEIGHT_VALUE_VALIDATOR);
            DivPoint divPoint = (DivPoint) JsonPropertyParser.readOptional(context, data, "offset", this.component.getDivPointJsonEntityParser());
            Expression<Integer> optionalExpression4 = JsonExpressionParser.readOptionalExpression(context, data, "text_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT, DivSliderTextStyleJsonParser.TEXT_COLOR_DEFAULT_VALUE);
            if (optionalExpression4 == null) {
                optionalExpression4 = DivSliderTextStyleJsonParser.TEXT_COLOR_DEFAULT_VALUE;
            }
            return new DivSlider.TextStyle(expression, expression2, expression3, optionalExpression3, divPoint, optionalExpression4);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivSlider.TextStyle value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonExpressionParser.writeExpression(context, jSONObject, ViewHierarchyConstants.TEXT_SIZE, value.fontSize);
            JsonExpressionParser.writeExpression(context, jSONObject, "font_size_unit", value.fontSizeUnit, DivSizeUnit.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, FontsContractCompat.Columns.WEIGHT, value.fontWeight, DivFontWeight.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "font_weight_value", value.fontWeightValue);
            JsonPropertyParser.write(context, jSONObject, "offset", value.offset, this.component.getDivPointJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "text_color", value.textColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivSliderJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivSliderTextStyleJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivSliderTemplate$TextStyleTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivSliderTemplate.TextStyleTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivSliderTemplate.TextStyleTemplate deserialize(ParsingContext context, DivSliderTemplate.TextStyleTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field fieldWithExpression = JsonFieldParser.readFieldWithExpression(parsingContextRestrictPropertyOverride, data, ViewHierarchyConstants.TEXT_SIZE, TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.fontSize : null, ParsingConvertersKt.NUMBER_TO_INT, DivSliderTextStyleJsonParser.FONT_SIZE_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(fieldWithExpression, "readFieldWithExpression(…INT, FONT_SIZE_VALIDATOR)");
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "font_size_unit", DivSliderTextStyleJsonParser.TYPE_HELPER_FONT_SIZE_UNIT, allowPropertyOverride, parent != null ? parent.fontSizeUnit : null, DivSizeUnit.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp… DivSizeUnit.FROM_STRING)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, FontsContractCompat.Columns.WEIGHT, DivSliderTextStyleJsonParser.TYPE_HELPER_FONT_WEIGHT, allowPropertyOverride, parent != null ? parent.fontWeight : null, DivFontWeight.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…ivFontWeight.FROM_STRING)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "font_weight_value", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.fontWeightValue : null, ParsingConvertersKt.NUMBER_TO_INT, DivSliderTextStyleJsonParser.FONT_WEIGHT_VALUE_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…T_WEIGHT_VALUE_VALIDATOR)");
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "offset", allowPropertyOverride, parent != null ? parent.offset : null, this.component.getDivPointJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex…vPointJsonTemplateParser)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "text_color", TypeHelpersKt.TYPE_HELPER_COLOR, allowPropertyOverride, parent != null ? parent.textColor : null, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…lor, STRING_TO_COLOR_INT)");
            return new DivSliderTemplate.TextStyleTemplate((Field<Expression<Long>>) fieldWithExpression, (Field<Expression<DivSizeUnit>>) optionalFieldWithExpression, (Field<Expression<DivFontWeight>>) optionalFieldWithExpression2, (Field<Expression<Long>>) optionalFieldWithExpression3, (Field<DivPointTemplate>) optionalField, (Field<Expression<Integer>>) optionalFieldWithExpression4);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivSliderTemplate.TextStyleTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeExpressionField(context, jSONObject, ViewHierarchyConstants.TEXT_SIZE, value.fontSize);
            JsonFieldParser.writeExpressionField(context, jSONObject, "font_size_unit", value.fontSizeUnit, DivSizeUnit.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, FontsContractCompat.Columns.WEIGHT, value.fontWeight, DivFontWeight.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "font_weight_value", value.fontWeightValue);
            JsonFieldParser.writeField(context, jSONObject, "offset", value.offset, this.component.getDivPointJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "text_color", value.textColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivSliderJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivSliderTextStyleJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivSliderTemplate$TextStyleTemplate;", "Lcom/yandex/div2/DivSlider$TextStyle;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivSliderTemplate.TextStyleTemplate, DivSlider.TextStyle> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivSlider.TextStyle resolve(ParsingContext context, DivSliderTemplate.TextStyleTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression expressionResolveExpression = JsonFieldResolver.resolveExpression(context, template.fontSize, data, ViewHierarchyConstants.TEXT_SIZE, TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivSliderTextStyleJsonParser.FONT_SIZE_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(expressionResolveExpression, "resolveExpression(contex…INT, FONT_SIZE_VALIDATOR)");
            Expression<DivSizeUnit> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.fontSizeUnit, data, "font_size_unit", DivSliderTextStyleJsonParser.TYPE_HELPER_FONT_SIZE_UNIT, DivSizeUnit.FROM_STRING, DivSliderTextStyleJsonParser.FONT_SIZE_UNIT_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivSliderTextStyleJsonParser.FONT_SIZE_UNIT_DEFAULT_VALUE;
            }
            Expression<DivSizeUnit> expression = expressionResolveOptionalExpression;
            Expression<DivFontWeight> expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.fontWeight, data, FontsContractCompat.Columns.WEIGHT, DivSliderTextStyleJsonParser.TYPE_HELPER_FONT_WEIGHT, DivFontWeight.FROM_STRING, DivSliderTextStyleJsonParser.FONT_WEIGHT_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression2 == null) {
                expressionResolveOptionalExpression2 = DivSliderTextStyleJsonParser.FONT_WEIGHT_DEFAULT_VALUE;
            }
            Expression<DivFontWeight> expression2 = expressionResolveOptionalExpression2;
            Expression expressionResolveOptionalExpression3 = JsonFieldResolver.resolveOptionalExpression(context, template.fontWeightValue, data, "font_weight_value", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivSliderTextStyleJsonParser.FONT_WEIGHT_VALUE_VALIDATOR);
            DivPoint divPoint = (DivPoint) JsonFieldResolver.resolveOptional(context, template.offset, data, "offset", this.component.getDivPointJsonTemplateResolver(), this.component.getDivPointJsonEntityParser());
            Expression<Integer> expressionResolveOptionalExpression4 = JsonFieldResolver.resolveOptionalExpression(context, template.textColor, data, "text_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT, DivSliderTextStyleJsonParser.TEXT_COLOR_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression4 == null) {
                expressionResolveOptionalExpression4 = DivSliderTextStyleJsonParser.TEXT_COLOR_DEFAULT_VALUE;
            }
            return new DivSlider.TextStyle(expressionResolveExpression, expression, expression2, expressionResolveOptionalExpression3, divPoint, expressionResolveOptionalExpression4);
        }
    }

    /* JADX INFO: compiled from: DivSliderJsonParser.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div2/DivSliderTextStyleJsonParser$Companion;", "", "()V", "FONT_SIZE_UNIT_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivSizeUnit;", "FONT_SIZE_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "", "FONT_WEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivFontWeight;", "FONT_WEIGHT_VALUE_VALIDATOR", "TEXT_COLOR_DEFAULT_VALUE", "", "TYPE_HELPER_FONT_SIZE_UNIT", "Lcom/yandex/div/internal/parser/TypeHelper;", "TYPE_HELPER_FONT_WEIGHT", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
