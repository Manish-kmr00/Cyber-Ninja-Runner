package com.yandex.div2;

import com.yandex.div.internal.parser.JsonExpressionParser;
import com.yandex.div.internal.parser.JsonFieldParser;
import com.yandex.div.internal.parser.JsonFieldResolver;
import com.yandex.div.internal.parser.JsonPropertyParser;
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
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivTabsJsonParser.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivTabsTabTitleDelimiterJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivTabsTabTitleDelimiterJsonParser {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final DivFixedSize HEIGHT_DEFAULT_VALUE;

    @Deprecated
    public static final DivFixedSize WIDTH_DEFAULT_VALUE;
    private final JsonParserComponent component;

    public DivTabsTabTitleDelimiterJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivTabsJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivTabsTabTitleDelimiterJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTabs$TabTitleDelimiter;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivTabs.TabTitleDelimiter> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivTabs.TabTitleDelimiter deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            DivFixedSize divFixedSize = (DivFixedSize) JsonPropertyParser.readOptional(context, data, "height", this.component.getDivFixedSizeJsonEntityParser());
            if (divFixedSize == null) {
                divFixedSize = DivTabsTabTitleDelimiterJsonParser.HEIGHT_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(divFixedSize, "JsonPropertyParser.readO…) ?: HEIGHT_DEFAULT_VALUE");
            Expression expression = JsonExpressionParser.readExpression(context, data, "image_url", TypeHelpersKt.TYPE_HELPER_URI, ParsingConvertersKt.ANY_TO_URI);
            Intrinsics.checkNotNullExpressionValue(expression, "readExpression(context, …E_HELPER_URI, ANY_TO_URI)");
            DivFixedSize divFixedSize2 = (DivFixedSize) JsonPropertyParser.readOptional(context, data, "width", this.component.getDivFixedSizeJsonEntityParser());
            if (divFixedSize2 == null) {
                divFixedSize2 = DivTabsTabTitleDelimiterJsonParser.WIDTH_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(divFixedSize2, "JsonPropertyParser.readO…r) ?: WIDTH_DEFAULT_VALUE");
            return new DivTabs.TabTitleDelimiter(divFixedSize, expression, divFixedSize2);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivTabs.TabTitleDelimiter value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonPropertyParser.write(context, jSONObject, "height", value.height, this.component.getDivFixedSizeJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "image_url", value.imageUrl, ParsingConvertersKt.URI_TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "width", value.width, this.component.getDivFixedSizeJsonEntityParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivTabsJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivTabsTabTitleDelimiterJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTabsTemplate$TabTitleDelimiterTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivTabsTemplate.TabTitleDelimiterTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivTabsTemplate.TabTitleDelimiterTemplate deserialize(ParsingContext context, DivTabsTemplate.TabTitleDelimiterTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "height", allowPropertyOverride, parent != null ? parent.height : null, this.component.getDivFixedSizeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex…edSizeJsonTemplateParser)");
            Field fieldWithExpression = JsonFieldParser.readFieldWithExpression(parsingContextRestrictPropertyOverride, data, "image_url", TypeHelpersKt.TYPE_HELPER_URI, allowPropertyOverride, parent != null ? parent.imageUrl : null, ParsingConvertersKt.ANY_TO_URI);
            Intrinsics.checkNotNullExpressionValue(fieldWithExpression, "readFieldWithExpression(…nt?.imageUrl, ANY_TO_URI)");
            Field optionalField2 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "width", allowPropertyOverride, parent != null ? parent.width : null, this.component.getDivFixedSizeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField2, "readOptionalField(contex…edSizeJsonTemplateParser)");
            return new DivTabsTemplate.TabTitleDelimiterTemplate(optionalField, fieldWithExpression, optionalField2);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivTabsTemplate.TabTitleDelimiterTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeField(context, jSONObject, "height", value.height, this.component.getDivFixedSizeJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "image_url", value.imageUrl, ParsingConvertersKt.URI_TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "width", value.width, this.component.getDivFixedSizeJsonTemplateParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivTabsJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivTabsTabTitleDelimiterJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTabsTemplate$TabTitleDelimiterTemplate;", "Lcom/yandex/div2/DivTabs$TabTitleDelimiter;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivTabsTemplate.TabTitleDelimiterTemplate, DivTabs.TabTitleDelimiter> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivTabs.TabTitleDelimiter resolve(ParsingContext context, DivTabsTemplate.TabTitleDelimiterTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            DivFixedSize divFixedSize = (DivFixedSize) JsonFieldResolver.resolveOptional(context, template.height, data, "height", this.component.getDivFixedSizeJsonTemplateResolver(), this.component.getDivFixedSizeJsonEntityParser());
            if (divFixedSize == null) {
                divFixedSize = DivTabsTabTitleDelimiterJsonParser.HEIGHT_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(divFixedSize, "JsonFieldResolver.resolv…) ?: HEIGHT_DEFAULT_VALUE");
            Expression expressionResolveExpression = JsonFieldResolver.resolveExpression(context, template.imageUrl, data, "image_url", TypeHelpersKt.TYPE_HELPER_URI, ParsingConvertersKt.ANY_TO_URI);
            Intrinsics.checkNotNullExpressionValue(expressionResolveExpression, "resolveExpression(contex…E_HELPER_URI, ANY_TO_URI)");
            DivFixedSize divFixedSize2 = (DivFixedSize) JsonFieldResolver.resolveOptional(context, template.width, data, "width", this.component.getDivFixedSizeJsonTemplateResolver(), this.component.getDivFixedSizeJsonEntityParser());
            if (divFixedSize2 == null) {
                divFixedSize2 = DivTabsTabTitleDelimiterJsonParser.WIDTH_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(divFixedSize2, "JsonFieldResolver.resolv…r) ?: WIDTH_DEFAULT_VALUE");
            return new DivTabs.TabTitleDelimiter(divFixedSize, expressionResolveExpression, divFixedSize2);
        }
    }

    /* JADX INFO: compiled from: DivTabsJsonParser.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/yandex/div2/DivTabsTabTitleDelimiterJsonParser$Companion;", "", "()V", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivFixedSize;", "WIDTH_DEFAULT_VALUE", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        int i = 1;
        HEIGHT_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(12L), i, 0 == true ? 1 : 0);
        WIDTH_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(12L), i, 0 == true ? 1 : 0);
    }
}
