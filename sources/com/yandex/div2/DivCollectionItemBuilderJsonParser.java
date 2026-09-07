package com.yandex.div2;

import com.yandex.div.internal.parser.JsonExpressionParser;
import com.yandex.div.internal.parser.JsonFieldParser;
import com.yandex.div.internal.parser.JsonFieldResolver;
import com.yandex.div.internal.parser.JsonPropertyParser;
import com.yandex.div.internal.parser.ListValidator;
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

/* JADX INFO: compiled from: DivCollectionItemBuilderJsonParser.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivCollectionItemBuilderJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivCollectionItemBuilderJsonParser {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String DATA_ELEMENT_NAME_DEFAULT_VALUE = "it";

    @Deprecated
    public static final ListValidator<DivCollectionItemBuilder.Prototype> PROTOTYPES_VALIDATOR = new ListValidator() { // from class: com.yandex.div2.DivCollectionItemBuilderJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ListValidator
        public final boolean isValid(List list) {
            return DivCollectionItemBuilderJsonParser.PROTOTYPES_VALIDATOR$lambda$0(list);
        }
    };
    private final JsonParserComponent component;

    public DivCollectionItemBuilderJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivCollectionItemBuilderJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivCollectionItemBuilderJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivCollectionItemBuilder;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivCollectionItemBuilder> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivCollectionItemBuilder deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression expression = JsonExpressionParser.readExpression(context, data, "data", TypeHelpersKt.TYPE_HELPER_JSON_ARRAY);
            Intrinsics.checkNotNullExpressionValue(expression, "readExpression(context, …, TYPE_HELPER_JSON_ARRAY)");
            String str = (String) JsonPropertyParser.readOptional(context, data, "data_element_name");
            if (str == null) {
                str = DivCollectionItemBuilderJsonParser.DATA_ELEMENT_NAME_DEFAULT_VALUE;
            }
            List list = JsonPropertyParser.readList(context, data, "prototypes", this.component.getDivCollectionItemBuilderPrototypeJsonEntityParser(), DivCollectionItemBuilderJsonParser.PROTOTYPES_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(list, "readList(context, data, …er, PROTOTYPES_VALIDATOR)");
            return new DivCollectionItemBuilder(expression, str, list);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivCollectionItemBuilder value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonExpressionParser.writeExpression(context, jSONObject, "data", value.data);
            JsonPropertyParser.write(context, jSONObject, "data_element_name", value.dataElementName);
            JsonPropertyParser.writeList(context, jSONObject, "prototypes", value.prototypes, this.component.getDivCollectionItemBuilderPrototypeJsonEntityParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivCollectionItemBuilderJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivCollectionItemBuilderJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivCollectionItemBuilderTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivCollectionItemBuilderTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivCollectionItemBuilderTemplate deserialize(ParsingContext context, DivCollectionItemBuilderTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field fieldWithExpression = JsonFieldParser.readFieldWithExpression(parsingContextRestrictPropertyOverride, data, "data", TypeHelpersKt.TYPE_HELPER_JSON_ARRAY, allowPropertyOverride, parent != null ? parent.data : null);
            Intrinsics.checkNotNullExpressionValue(fieldWithExpression, "readFieldWithExpression(…owOverride, parent?.data)");
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "data_element_name", allowPropertyOverride, parent != null ? parent.dataElementName : null);
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex… parent?.dataElementName)");
            Field<List<DivCollectionItemBuilderTemplate.PrototypeTemplate>> field = parent != null ? parent.prototypes : null;
            Lazy<DivCollectionItemBuilderPrototypeJsonParser.TemplateParserImpl> divCollectionItemBuilderPrototypeJsonTemplateParser = this.component.getDivCollectionItemBuilderPrototypeJsonTemplateParser();
            ListValidator<DivCollectionItemBuilder.Prototype> listValidator = DivCollectionItemBuilderJsonParser.PROTOTYPES_VALIDATOR;
            Intrinsics.checkNotNull(listValidator, "null cannot be cast to non-null type com.yandex.div.internal.parser.ListValidator<T of com.yandex.div.internal.parser.ParsingValidatorsKt.cast>");
            Field listField = JsonFieldParser.readListField(parsingContextRestrictPropertyOverride, data, "prototypes", allowPropertyOverride, field, divCollectionItemBuilderPrototypeJsonTemplateParser, listValidator);
            Intrinsics.checkNotNullExpressionValue(listField, "readListField(context, d…TOTYPES_VALIDATOR.cast())");
            return new DivCollectionItemBuilderTemplate(fieldWithExpression, optionalField, listField);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivCollectionItemBuilderTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeExpressionField(context, jSONObject, "data", value.data);
            JsonFieldParser.writeField(context, jSONObject, "data_element_name", value.dataElementName);
            JsonFieldParser.writeListField(context, jSONObject, "prototypes", value.prototypes, this.component.getDivCollectionItemBuilderPrototypeJsonTemplateParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivCollectionItemBuilderJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivCollectionItemBuilderJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivCollectionItemBuilderTemplate;", "Lcom/yandex/div2/DivCollectionItemBuilder;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivCollectionItemBuilderTemplate, DivCollectionItemBuilder> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivCollectionItemBuilder resolve(ParsingContext context, DivCollectionItemBuilderTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression expressionResolveExpression = JsonFieldResolver.resolveExpression(context, template.data, data, "data", TypeHelpersKt.TYPE_HELPER_JSON_ARRAY);
            Intrinsics.checkNotNullExpressionValue(expressionResolveExpression, "resolveExpression(contex…, TYPE_HELPER_JSON_ARRAY)");
            String str = (String) JsonFieldResolver.resolveOptional(context, template.dataElementName, data, "data_element_name");
            if (str == null) {
                str = DivCollectionItemBuilderJsonParser.DATA_ELEMENT_NAME_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(str, "JsonFieldResolver.resolv…LEMENT_NAME_DEFAULT_VALUE");
            List listResolveList = JsonFieldResolver.resolveList(context, template.prototypes, data, "prototypes", this.component.getDivCollectionItemBuilderPrototypeJsonTemplateResolver(), this.component.getDivCollectionItemBuilderPrototypeJsonEntityParser(), DivCollectionItemBuilderJsonParser.PROTOTYPES_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(listResolveList, "resolveList(context, tem…er, PROTOTYPES_VALIDATOR)");
            return new DivCollectionItemBuilder(expressionResolveExpression, str, listResolveList);
        }
    }

    /* JADX INFO: compiled from: DivCollectionItemBuilderJsonParser.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yandex/div2/DivCollectionItemBuilderJsonParser$Companion;", "", "()V", "DATA_ELEMENT_NAME_DEFAULT_VALUE", "", "PROTOTYPES_VALIDATOR", "Lcom/yandex/div/internal/parser/ListValidator;", "Lcom/yandex/div2/DivCollectionItemBuilder$Prototype;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PROTOTYPES_VALIDATOR$lambda$0(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.size() >= 1;
    }
}
