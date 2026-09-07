package com.yandex.div2;

import com.yandex.div.internal.parser.JsonExpressionParser;
import com.yandex.div.internal.parser.JsonFieldParser;
import com.yandex.div.internal.parser.JsonFieldResolver;
import com.yandex.div.internal.parser.JsonPropertyParser;
import com.yandex.div.internal.parser.ParsingConvertersKt;
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

/* JADX INFO: compiled from: DivStretchIndicatorItemPlacementJsonParser.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivStretchIndicatorItemPlacementJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivStretchIndicatorItemPlacementJsonParser {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final DivFixedSize ITEM_SPACING_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(5L), 1, 0 == true ? 1 : 0);

    @Deprecated
    public static final Expression<Long> MAX_VISIBLE_ITEMS_DEFAULT_VALUE = Expression.INSTANCE.constant(10L);

    @Deprecated
    public static final ValueValidator<Long> MAX_VISIBLE_ITEMS_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivStretchIndicatorItemPlacementJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivStretchIndicatorItemPlacementJsonParser.MAX_VISIBLE_ITEMS_VALIDATOR$lambda$0(((Long) obj).longValue());
        }
    };
    private final JsonParserComponent component;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MAX_VISIBLE_ITEMS_VALIDATOR$lambda$0(long j) {
        return j > 0;
    }

    public DivStretchIndicatorItemPlacementJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivStretchIndicatorItemPlacementJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivStretchIndicatorItemPlacementJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivStretchIndicatorItemPlacement;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivStretchIndicatorItemPlacement> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivStretchIndicatorItemPlacement deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            DivFixedSize divFixedSize = (DivFixedSize) JsonPropertyParser.readOptional(context, data, "item_spacing", this.component.getDivFixedSizeJsonEntityParser());
            if (divFixedSize == null) {
                divFixedSize = DivStretchIndicatorItemPlacementJsonParser.ITEM_SPACING_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(divFixedSize, "JsonPropertyParser.readO…TEM_SPACING_DEFAULT_VALUE");
            Expression<Long> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "max_visible_items", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivStretchIndicatorItemPlacementJsonParser.MAX_VISIBLE_ITEMS_VALIDATOR, DivStretchIndicatorItemPlacementJsonParser.MAX_VISIBLE_ITEMS_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivStretchIndicatorItemPlacementJsonParser.MAX_VISIBLE_ITEMS_DEFAULT_VALUE;
            }
            return new DivStretchIndicatorItemPlacement(divFixedSize, optionalExpression);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivStretchIndicatorItemPlacement value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonPropertyParser.write(context, jSONObject, "item_spacing", value.itemSpacing, this.component.getDivFixedSizeJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "max_visible_items", value.maxVisibleItems);
            JsonPropertyParser.write(context, jSONObject, "type", "stretch");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivStretchIndicatorItemPlacementJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivStretchIndicatorItemPlacementJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivStretchIndicatorItemPlacementTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivStretchIndicatorItemPlacementTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivStretchIndicatorItemPlacementTemplate deserialize(ParsingContext context, DivStretchIndicatorItemPlacementTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "item_spacing", allowPropertyOverride, parent != null ? parent.itemSpacing : null, this.component.getDivFixedSizeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex…edSizeJsonTemplateParser)");
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "max_visible_items", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.maxVisibleItems : null, ParsingConvertersKt.NUMBER_TO_INT, DivStretchIndicatorItemPlacementJsonParser.MAX_VISIBLE_ITEMS_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…_VISIBLE_ITEMS_VALIDATOR)");
            return new DivStretchIndicatorItemPlacementTemplate(optionalField, optionalFieldWithExpression);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivStretchIndicatorItemPlacementTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeField(context, jSONObject, "item_spacing", value.itemSpacing, this.component.getDivFixedSizeJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "max_visible_items", value.maxVisibleItems);
            JsonPropertyParser.write(context, jSONObject, "type", "stretch");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivStretchIndicatorItemPlacementJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivStretchIndicatorItemPlacementJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivStretchIndicatorItemPlacementTemplate;", "Lcom/yandex/div2/DivStretchIndicatorItemPlacement;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivStretchIndicatorItemPlacementTemplate, DivStretchIndicatorItemPlacement> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivStretchIndicatorItemPlacement resolve(ParsingContext context, DivStretchIndicatorItemPlacementTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            DivFixedSize divFixedSize = (DivFixedSize) JsonFieldResolver.resolveOptional(context, template.itemSpacing, data, "item_spacing", this.component.getDivFixedSizeJsonTemplateResolver(), this.component.getDivFixedSizeJsonEntityParser());
            if (divFixedSize == null) {
                divFixedSize = DivStretchIndicatorItemPlacementJsonParser.ITEM_SPACING_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(divFixedSize, "JsonFieldResolver.resolv…TEM_SPACING_DEFAULT_VALUE");
            Expression<Long> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.maxVisibleItems, data, "max_visible_items", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivStretchIndicatorItemPlacementJsonParser.MAX_VISIBLE_ITEMS_VALIDATOR, DivStretchIndicatorItemPlacementJsonParser.MAX_VISIBLE_ITEMS_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivStretchIndicatorItemPlacementJsonParser.MAX_VISIBLE_ITEMS_DEFAULT_VALUE;
            }
            return new DivStretchIndicatorItemPlacement(divFixedSize, expressionResolveOptionalExpression);
        }
    }

    /* JADX INFO: compiled from: DivStretchIndicatorItemPlacementJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/yandex/div2/DivStretchIndicatorItemPlacementJsonParser$Companion;", "", "()V", "ITEM_SPACING_DEFAULT_VALUE", "Lcom/yandex/div2/DivFixedSize;", "MAX_VISIBLE_ITEMS_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "MAX_VISIBLE_ITEMS_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
