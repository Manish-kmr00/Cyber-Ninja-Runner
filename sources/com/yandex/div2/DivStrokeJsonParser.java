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

/* JADX INFO: compiled from: DivStrokeJsonParser.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivStrokeJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivStrokeJsonParser {
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final DivStrokeStyle.Solid STYLE_DEFAULT_VALUE = new DivStrokeStyle.Solid(new DivStrokeStyleSolid());

    @Deprecated
    public static final Expression<DivSizeUnit> UNIT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivSizeUnit.DP);

    @Deprecated
    public static final Expression<Double> WIDTH_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(1.0d));

    @Deprecated
    public static final TypeHelper<DivSizeUnit> TYPE_HELPER_UNIT = TypeHelper.INSTANCE.from(ArraysKt.first(DivSizeUnit.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivStrokeJsonParser$Companion$TYPE_HELPER_UNIT$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivSizeUnit);
        }
    });

    @Deprecated
    public static final ValueValidator<Double> WIDTH_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivStrokeJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivStrokeJsonParser.WIDTH_VALIDATOR$lambda$0(((Double) obj).doubleValue());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean WIDTH_VALIDATOR$lambda$0(double d) {
        return d >= 0.0d;
    }

    public DivStrokeJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivStrokeJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivStrokeJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivStroke;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivStroke> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivStroke deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression expression = JsonExpressionParser.readExpression(context, data, "color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(expression, "readExpression(context, …LOR, STRING_TO_COLOR_INT)");
            DivStrokeStyle.Solid solid = (DivStrokeStyle) JsonPropertyParser.readOptional(context, data, "style", this.component.getDivStrokeStyleJsonEntityParser());
            if (solid == null) {
                solid = DivStrokeJsonParser.STYLE_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(solid, "JsonPropertyParser.readO…r) ?: STYLE_DEFAULT_VALUE");
            Expression<DivSizeUnit> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "unit", DivStrokeJsonParser.TYPE_HELPER_UNIT, DivSizeUnit.FROM_STRING, DivStrokeJsonParser.UNIT_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivStrokeJsonParser.UNIT_DEFAULT_VALUE;
            }
            Expression<Double> optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, "width", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivStrokeJsonParser.WIDTH_VALIDATOR, DivStrokeJsonParser.WIDTH_DEFAULT_VALUE);
            if (optionalExpression2 == null) {
                optionalExpression2 = DivStrokeJsonParser.WIDTH_DEFAULT_VALUE;
            }
            return new DivStroke(expression, solid, optionalExpression, optionalExpression2);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivStroke value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonExpressionParser.writeExpression(context, jSONObject, "color", value.color, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "style", value.style, this.component.getDivStrokeStyleJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "unit", value.unit, DivSizeUnit.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "width", value.width);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivStrokeJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivStrokeJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivStrokeTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivStrokeTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivStrokeTemplate deserialize(ParsingContext context, DivStrokeTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field fieldWithExpression = JsonFieldParser.readFieldWithExpression(parsingContextRestrictPropertyOverride, data, "color", TypeHelpersKt.TYPE_HELPER_COLOR, allowPropertyOverride, parent != null ? parent.color : null, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(fieldWithExpression, "readFieldWithExpression(…lor, STRING_TO_COLOR_INT)");
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "style", allowPropertyOverride, parent != null ? parent.style : null, this.component.getDivStrokeStyleJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex…eStyleJsonTemplateParser)");
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "unit", DivStrokeJsonParser.TYPE_HELPER_UNIT, allowPropertyOverride, parent != null ? parent.unit : null, DivSizeUnit.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp… DivSizeUnit.FROM_STRING)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "width", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.width : null, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivStrokeJsonParser.WIDTH_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…_DOUBLE, WIDTH_VALIDATOR)");
            return new DivStrokeTemplate((Field<Expression<Integer>>) fieldWithExpression, (Field<DivStrokeStyleTemplate>) optionalField, (Field<Expression<DivSizeUnit>>) optionalFieldWithExpression, (Field<Expression<Double>>) optionalFieldWithExpression2);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivStrokeTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeExpressionField(context, jSONObject, "color", value.color, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "style", value.style, this.component.getDivStrokeStyleJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "unit", value.unit, DivSizeUnit.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "width", value.width);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivStrokeJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivStrokeJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivStrokeTemplate;", "Lcom/yandex/div2/DivStroke;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivStrokeTemplate, DivStroke> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivStroke resolve(ParsingContext context, DivStrokeTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression expressionResolveExpression = JsonFieldResolver.resolveExpression(context, template.color, data, "color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(expressionResolveExpression, "resolveExpression(contex…LOR, STRING_TO_COLOR_INT)");
            DivStrokeStyle.Solid solid = (DivStrokeStyle) JsonFieldResolver.resolveOptional(context, template.style, data, "style", this.component.getDivStrokeStyleJsonTemplateResolver(), this.component.getDivStrokeStyleJsonEntityParser());
            if (solid == null) {
                solid = DivStrokeJsonParser.STYLE_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(solid, "JsonFieldResolver.resolv…r) ?: STYLE_DEFAULT_VALUE");
            Expression<DivSizeUnit> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.unit, data, "unit", DivStrokeJsonParser.TYPE_HELPER_UNIT, DivSizeUnit.FROM_STRING, DivStrokeJsonParser.UNIT_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivStrokeJsonParser.UNIT_DEFAULT_VALUE;
            }
            Expression<Double> expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.width, data, "width", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivStrokeJsonParser.WIDTH_VALIDATOR, DivStrokeJsonParser.WIDTH_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression2 == null) {
                expressionResolveOptionalExpression2 = DivStrokeJsonParser.WIDTH_DEFAULT_VALUE;
            }
            return new DivStroke(expressionResolveExpression, solid, expressionResolveOptionalExpression, expressionResolveOptionalExpression2);
        }
    }

    /* JADX INFO: compiled from: DivStrokeJsonParser.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivStrokeJsonParser$Companion;", "", "()V", "STYLE_DEFAULT_VALUE", "Lcom/yandex/div2/DivStrokeStyle$Solid;", "TYPE_HELPER_UNIT", "Lcom/yandex/div/internal/parser/TypeHelper;", "Lcom/yandex/div2/DivSizeUnit;", "UNIT_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "WIDTH_DEFAULT_VALUE", "", "WIDTH_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
