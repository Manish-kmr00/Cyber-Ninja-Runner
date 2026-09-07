package com.yandex.div2;

import com.yandex.div.internal.parser.JsonExpressionParser;
import com.yandex.div.internal.parser.JsonFieldParser;
import com.yandex.div.internal.parser.JsonFieldResolver;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivFixedLengthInputMaskJsonParser.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivFixedLengthInputMaskPatternElementJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivFixedLengthInputMaskPatternElementJsonParser {
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<String> PLACEHOLDER_DEFAULT_VALUE = Expression.INSTANCE.constant("_");

    @Deprecated
    public static final ValueValidator<String> KEY_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivFixedLengthInputMaskPatternElementJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivFixedLengthInputMaskPatternElementJsonParser.KEY_VALIDATOR$lambda$0((String) obj);
        }
    };

    @Deprecated
    public static final ValueValidator<String> PLACEHOLDER_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivFixedLengthInputMaskPatternElementJsonParser$$ExternalSyntheticLambda1
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivFixedLengthInputMaskPatternElementJsonParser.PLACEHOLDER_VALIDATOR$lambda$1((String) obj);
        }
    };

    public DivFixedLengthInputMaskPatternElementJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivFixedLengthInputMaskJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivFixedLengthInputMaskPatternElementJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivFixedLengthInputMask$PatternElement;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivFixedLengthInputMask.PatternElement> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivFixedLengthInputMask.PatternElement deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression expression = JsonExpressionParser.readExpression(context, data, "key", TypeHelpersKt.TYPE_HELPER_STRING, DivFixedLengthInputMaskPatternElementJsonParser.KEY_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(expression, "readExpression(context, …ER_STRING, KEY_VALIDATOR)");
            Expression<String> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "placeholder", TypeHelpersKt.TYPE_HELPER_STRING, DivFixedLengthInputMaskPatternElementJsonParser.PLACEHOLDER_VALIDATOR, DivFixedLengthInputMaskPatternElementJsonParser.PLACEHOLDER_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivFixedLengthInputMaskPatternElementJsonParser.PLACEHOLDER_DEFAULT_VALUE;
            }
            return new DivFixedLengthInputMask.PatternElement(expression, optionalExpression, JsonExpressionParser.readOptionalExpression(context, data, "regex", TypeHelpersKt.TYPE_HELPER_STRING));
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivFixedLengthInputMask.PatternElement value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonExpressionParser.writeExpression(context, jSONObject, "key", value.key);
            JsonExpressionParser.writeExpression(context, jSONObject, "placeholder", value.placeholder);
            JsonExpressionParser.writeExpression(context, jSONObject, "regex", value.regex);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivFixedLengthInputMaskJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivFixedLengthInputMaskPatternElementJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivFixedLengthInputMaskTemplate$PatternElementTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivFixedLengthInputMaskTemplate.PatternElementTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivFixedLengthInputMaskTemplate.PatternElementTemplate deserialize(ParsingContext context, DivFixedLengthInputMaskTemplate.PatternElementTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field fieldWithExpression = JsonFieldParser.readFieldWithExpression(parsingContextRestrictPropertyOverride, data, "key", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.key : null, DivFixedLengthInputMaskPatternElementJsonParser.KEY_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(fieldWithExpression, "readFieldWithExpression(…rent?.key, KEY_VALIDATOR)");
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "placeholder", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.placeholder : null, DivFixedLengthInputMaskPatternElementJsonParser.PLACEHOLDER_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…r, PLACEHOLDER_VALIDATOR)");
            Field<Expression<String>> optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "regex", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.regex : null);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…wOverride, parent?.regex)");
            return new DivFixedLengthInputMaskTemplate.PatternElementTemplate(fieldWithExpression, optionalFieldWithExpression, optionalFieldWithExpression2);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivFixedLengthInputMaskTemplate.PatternElementTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeExpressionField(context, jSONObject, "key", value.key);
            JsonFieldParser.writeExpressionField(context, jSONObject, "placeholder", value.placeholder);
            JsonFieldParser.writeExpressionField(context, jSONObject, "regex", value.regex);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivFixedLengthInputMaskJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivFixedLengthInputMaskPatternElementJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivFixedLengthInputMaskTemplate$PatternElementTemplate;", "Lcom/yandex/div2/DivFixedLengthInputMask$PatternElement;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivFixedLengthInputMaskTemplate.PatternElementTemplate, DivFixedLengthInputMask.PatternElement> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivFixedLengthInputMask.PatternElement resolve(ParsingContext context, DivFixedLengthInputMaskTemplate.PatternElementTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression expressionResolveExpression = JsonFieldResolver.resolveExpression(context, template.key, data, "key", TypeHelpersKt.TYPE_HELPER_STRING, DivFixedLengthInputMaskPatternElementJsonParser.KEY_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(expressionResolveExpression, "resolveExpression(contex…ER_STRING, KEY_VALIDATOR)");
            Expression<String> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.placeholder, data, "placeholder", TypeHelpersKt.TYPE_HELPER_STRING, DivFixedLengthInputMaskPatternElementJsonParser.PLACEHOLDER_VALIDATOR, DivFixedLengthInputMaskPatternElementJsonParser.PLACEHOLDER_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivFixedLengthInputMaskPatternElementJsonParser.PLACEHOLDER_DEFAULT_VALUE;
            }
            return new DivFixedLengthInputMask.PatternElement(expressionResolveExpression, expressionResolveOptionalExpression, JsonFieldResolver.resolveOptionalExpression(context, template.regex, data, "regex", TypeHelpersKt.TYPE_HELPER_STRING));
        }
    }

    /* JADX INFO: compiled from: DivFixedLengthInputMaskJsonParser.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivFixedLengthInputMaskPatternElementJsonParser$Companion;", "", "()V", "KEY_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "", "PLACEHOLDER_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "PLACEHOLDER_VALIDATOR", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean KEY_VALIDATOR$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.length() >= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PLACEHOLDER_VALIDATOR$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.length() >= 1;
    }
}
