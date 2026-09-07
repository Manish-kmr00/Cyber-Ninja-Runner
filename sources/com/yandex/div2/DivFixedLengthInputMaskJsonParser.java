package com.yandex.div2;

import com.yandex.div.internal.parser.JsonExpressionParser;
import com.yandex.div.internal.parser.JsonFieldParser;
import com.yandex.div.internal.parser.JsonFieldResolver;
import com.yandex.div.internal.parser.JsonPropertyParser;
import com.yandex.div.internal.parser.ListValidator;
import com.yandex.div.internal.parser.ParsingConvertersKt;
import com.yandex.div.internal.parser.TypeHelpersKt;
import com.yandex.div.internal.template.Field;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.serialization.Parser;
import com.yandex.div.serialization.ParsingContext;
import com.yandex.div.serialization.ParsingContextKt;
import com.yandex.div.serialization.TemplateParser;
import com.yandex.div.serialization.TemplateResolver;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivFixedLengthInputMaskJsonParser.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivFixedLengthInputMaskJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivFixedLengthInputMaskJsonParser {
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<Boolean> ALWAYS_VISIBLE_DEFAULT_VALUE = Expression.INSTANCE.constant(false);

    @Deprecated
    public static final ListValidator<DivFixedLengthInputMask.PatternElement> PATTERN_ELEMENTS_VALIDATOR = new ListValidator() { // from class: com.yandex.div2.DivFixedLengthInputMaskJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ListValidator
        public final boolean isValid(List list) {
            return DivFixedLengthInputMaskJsonParser.PATTERN_ELEMENTS_VALIDATOR$lambda$0(list);
        }
    };

    public DivFixedLengthInputMaskJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivFixedLengthInputMaskJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivFixedLengthInputMaskJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivFixedLengthInputMask;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivFixedLengthInputMask> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivFixedLengthInputMask deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression<Boolean> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "always_visible", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivFixedLengthInputMaskJsonParser.ALWAYS_VISIBLE_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivFixedLengthInputMaskJsonParser.ALWAYS_VISIBLE_DEFAULT_VALUE;
            }
            Expression expression = JsonExpressionParser.readExpression(context, data, "pattern", TypeHelpersKt.TYPE_HELPER_STRING);
            Intrinsics.checkNotNullExpressionValue(expression, "readExpression(context, …ern\", TYPE_HELPER_STRING)");
            List list = JsonPropertyParser.readList(context, data, "pattern_elements", this.component.getDivFixedLengthInputMaskPatternElementJsonEntityParser(), DivFixedLengthInputMaskJsonParser.PATTERN_ELEMENTS_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(list, "readList(context, data, …TTERN_ELEMENTS_VALIDATOR)");
            Object obj = JsonPropertyParser.read(context, data, "raw_text_variable");
            Intrinsics.checkNotNullExpressionValue(obj, "read(context, data, \"raw_text_variable\")");
            return new DivFixedLengthInputMask(optionalExpression, expression, list, (String) obj);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivFixedLengthInputMask value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonExpressionParser.writeExpression(context, jSONObject, "always_visible", value.alwaysVisible);
            JsonExpressionParser.writeExpression(context, jSONObject, "pattern", value.pattern);
            JsonPropertyParser.writeList(context, jSONObject, "pattern_elements", value.patternElements, this.component.getDivFixedLengthInputMaskPatternElementJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "raw_text_variable", value.getRawTextVariable());
            JsonPropertyParser.write(context, jSONObject, "type", "fixed_length");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivFixedLengthInputMaskJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivFixedLengthInputMaskJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivFixedLengthInputMaskTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivFixedLengthInputMaskTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivFixedLengthInputMaskTemplate deserialize(ParsingContext context, DivFixedLengthInputMaskTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "always_visible", TypeHelpersKt.TYPE_HELPER_BOOLEAN, allowPropertyOverride, parent != null ? parent.alwaysVisible : null, ParsingConvertersKt.ANY_TO_BOOLEAN);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…sVisible, ANY_TO_BOOLEAN)");
            Field fieldWithExpression = JsonFieldParser.readFieldWithExpression(parsingContextRestrictPropertyOverride, data, "pattern", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.pattern : null);
            Intrinsics.checkNotNullExpressionValue(fieldWithExpression, "readFieldWithExpression(…verride, parent?.pattern)");
            Field<List<DivFixedLengthInputMaskTemplate.PatternElementTemplate>> field = parent != null ? parent.patternElements : null;
            Lazy<DivFixedLengthInputMaskPatternElementJsonParser.TemplateParserImpl> divFixedLengthInputMaskPatternElementJsonTemplateParser = this.component.getDivFixedLengthInputMaskPatternElementJsonTemplateParser();
            ListValidator<DivFixedLengthInputMask.PatternElement> listValidator = DivFixedLengthInputMaskJsonParser.PATTERN_ELEMENTS_VALIDATOR;
            Intrinsics.checkNotNull(listValidator, "null cannot be cast to non-null type com.yandex.div.internal.parser.ListValidator<T of com.yandex.div.internal.parser.ParsingValidatorsKt.cast>");
            Field listField = JsonFieldParser.readListField(parsingContextRestrictPropertyOverride, data, "pattern_elements", allowPropertyOverride, field, divFixedLengthInputMaskPatternElementJsonTemplateParser, listValidator);
            Intrinsics.checkNotNullExpressionValue(listField, "readListField(context, d…LEMENTS_VALIDATOR.cast())");
            Field field2 = JsonFieldParser.readField(parsingContextRestrictPropertyOverride, data, "raw_text_variable", allowPropertyOverride, parent != null ? parent.rawTextVariable : null);
            Intrinsics.checkNotNullExpressionValue(field2, "readField(context, data,… parent?.rawTextVariable)");
            return new DivFixedLengthInputMaskTemplate((Field<Expression<Boolean>>) optionalFieldWithExpression, (Field<Expression<String>>) fieldWithExpression, (Field<List<DivFixedLengthInputMaskTemplate.PatternElementTemplate>>) listField, (Field<String>) field2);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivFixedLengthInputMaskTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeExpressionField(context, jSONObject, "always_visible", value.alwaysVisible);
            JsonFieldParser.writeExpressionField(context, jSONObject, "pattern", value.pattern);
            JsonFieldParser.writeListField(context, jSONObject, "pattern_elements", value.patternElements, this.component.getDivFixedLengthInputMaskPatternElementJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "raw_text_variable", value.rawTextVariable);
            JsonPropertyParser.write(context, jSONObject, "type", "fixed_length");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivFixedLengthInputMaskJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivFixedLengthInputMaskJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivFixedLengthInputMaskTemplate;", "Lcom/yandex/div2/DivFixedLengthInputMask;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivFixedLengthInputMaskTemplate, DivFixedLengthInputMask> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivFixedLengthInputMask resolve(ParsingContext context, DivFixedLengthInputMaskTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression<Boolean> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.alwaysVisible, data, "always_visible", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivFixedLengthInputMaskJsonParser.ALWAYS_VISIBLE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivFixedLengthInputMaskJsonParser.ALWAYS_VISIBLE_DEFAULT_VALUE;
            }
            Expression expressionResolveExpression = JsonFieldResolver.resolveExpression(context, template.pattern, data, "pattern", TypeHelpersKt.TYPE_HELPER_STRING);
            Intrinsics.checkNotNullExpressionValue(expressionResolveExpression, "resolveExpression(contex…ern\", TYPE_HELPER_STRING)");
            List listResolveList = JsonFieldResolver.resolveList(context, template.patternElements, data, "pattern_elements", this.component.getDivFixedLengthInputMaskPatternElementJsonTemplateResolver(), this.component.getDivFixedLengthInputMaskPatternElementJsonEntityParser(), DivFixedLengthInputMaskJsonParser.PATTERN_ELEMENTS_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(listResolveList, "resolveList(context, tem…TTERN_ELEMENTS_VALIDATOR)");
            Object objResolve = JsonFieldResolver.resolve(context, template.rawTextVariable, data, "raw_text_variable");
            Intrinsics.checkNotNullExpressionValue(objResolve, "resolve(context, templat…ata, \"raw_text_variable\")");
            return new DivFixedLengthInputMask(expressionResolveOptionalExpression, expressionResolveExpression, listResolveList, (String) objResolve);
        }
    }

    /* JADX INFO: compiled from: DivFixedLengthInputMaskJsonParser.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivFixedLengthInputMaskJsonParser$Companion;", "", "()V", "ALWAYS_VISIBLE_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "PATTERN_ELEMENTS_VALIDATOR", "Lcom/yandex/div/internal/parser/ListValidator;", "Lcom/yandex/div2/DivFixedLengthInputMask$PatternElement;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PATTERN_ELEMENTS_VALIDATOR$lambda$0(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.size() >= 1;
    }
}
