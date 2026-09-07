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
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivRoundedRectangleShapeJsonParser.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivRoundedRectangleShapeJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivRoundedRectangleShapeJsonParser {

    @Deprecated
    public static final DivFixedSize CORNER_RADIUS_DEFAULT_VALUE;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final DivFixedSize ITEM_HEIGHT_DEFAULT_VALUE;

    @Deprecated
    public static final DivFixedSize ITEM_WIDTH_DEFAULT_VALUE;
    private final JsonParserComponent component;

    public DivRoundedRectangleShapeJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivRoundedRectangleShapeJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivRoundedRectangleShapeJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivRoundedRectangleShape;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivRoundedRectangleShape> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivRoundedRectangleShape deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "background_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT);
            DivFixedSize divFixedSize = (DivFixedSize) JsonPropertyParser.readOptional(context, data, "corner_radius", this.component.getDivFixedSizeJsonEntityParser());
            if (divFixedSize == null) {
                divFixedSize = DivRoundedRectangleShapeJsonParser.CORNER_RADIUS_DEFAULT_VALUE;
            }
            DivFixedSize divFixedSize2 = divFixedSize;
            Intrinsics.checkNotNullExpressionValue(divFixedSize2, "JsonPropertyParser.readO…RNER_RADIUS_DEFAULT_VALUE");
            DivFixedSize divFixedSize3 = (DivFixedSize) JsonPropertyParser.readOptional(context, data, "item_height", this.component.getDivFixedSizeJsonEntityParser());
            if (divFixedSize3 == null) {
                divFixedSize3 = DivRoundedRectangleShapeJsonParser.ITEM_HEIGHT_DEFAULT_VALUE;
            }
            DivFixedSize divFixedSize4 = divFixedSize3;
            Intrinsics.checkNotNullExpressionValue(divFixedSize4, "JsonPropertyParser.readO…ITEM_HEIGHT_DEFAULT_VALUE");
            DivFixedSize divFixedSize5 = (DivFixedSize) JsonPropertyParser.readOptional(context, data, "item_width", this.component.getDivFixedSizeJsonEntityParser());
            if (divFixedSize5 == null) {
                divFixedSize5 = DivRoundedRectangleShapeJsonParser.ITEM_WIDTH_DEFAULT_VALUE;
            }
            DivFixedSize divFixedSize6 = divFixedSize5;
            Intrinsics.checkNotNullExpressionValue(divFixedSize6, "JsonPropertyParser.readO… ITEM_WIDTH_DEFAULT_VALUE");
            return new DivRoundedRectangleShape(optionalExpression, divFixedSize2, divFixedSize4, divFixedSize6, (DivStroke) JsonPropertyParser.readOptional(context, data, VastAttributes.STROKE_COLOR, this.component.getDivStrokeJsonEntityParser()));
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivRoundedRectangleShape value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonExpressionParser.writeExpression(context, jSONObject, "background_color", value.backgroundColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "corner_radius", value.cornerRadius, this.component.getDivFixedSizeJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "item_height", value.itemHeight, this.component.getDivFixedSizeJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "item_width", value.itemWidth, this.component.getDivFixedSizeJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, VastAttributes.STROKE_COLOR, value.stroke, this.component.getDivStrokeJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "type", "rounded_rectangle");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivRoundedRectangleShapeJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivRoundedRectangleShapeJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivRoundedRectangleShapeTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivRoundedRectangleShapeTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivRoundedRectangleShapeTemplate deserialize(ParsingContext context, DivRoundedRectangleShapeTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "background_color", TypeHelpersKt.TYPE_HELPER_COLOR, allowPropertyOverride, parent != null ? parent.backgroundColor : null, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…lor, STRING_TO_COLOR_INT)");
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "corner_radius", allowPropertyOverride, parent != null ? parent.cornerRadius : null, this.component.getDivFixedSizeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex…edSizeJsonTemplateParser)");
            Field optionalField2 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "item_height", allowPropertyOverride, parent != null ? parent.itemHeight : null, this.component.getDivFixedSizeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField2, "readOptionalField(contex…edSizeJsonTemplateParser)");
            Field optionalField3 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "item_width", allowPropertyOverride, parent != null ? parent.itemWidth : null, this.component.getDivFixedSizeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField3, "readOptionalField(contex…edSizeJsonTemplateParser)");
            Field optionalField4 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, VastAttributes.STROKE_COLOR, allowPropertyOverride, parent != null ? parent.stroke : null, this.component.getDivStrokeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField4, "readOptionalField(contex…StrokeJsonTemplateParser)");
            return new DivRoundedRectangleShapeTemplate(optionalFieldWithExpression, optionalField, optionalField2, optionalField3, optionalField4);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivRoundedRectangleShapeTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeExpressionField(context, jSONObject, "background_color", value.backgroundColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "corner_radius", value.cornerRadius, this.component.getDivFixedSizeJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "item_height", value.itemHeight, this.component.getDivFixedSizeJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "item_width", value.itemWidth, this.component.getDivFixedSizeJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, VastAttributes.STROKE_COLOR, value.stroke, this.component.getDivStrokeJsonTemplateParser());
            JsonPropertyParser.write(context, jSONObject, "type", "rounded_rectangle");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivRoundedRectangleShapeJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivRoundedRectangleShapeJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivRoundedRectangleShapeTemplate;", "Lcom/yandex/div2/DivRoundedRectangleShape;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivRoundedRectangleShapeTemplate, DivRoundedRectangleShape> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivRoundedRectangleShape resolve(ParsingContext context, DivRoundedRectangleShapeTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.backgroundColor, data, "background_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT);
            DivFixedSize divFixedSize = (DivFixedSize) JsonFieldResolver.resolveOptional(context, template.cornerRadius, data, "corner_radius", this.component.getDivFixedSizeJsonTemplateResolver(), this.component.getDivFixedSizeJsonEntityParser());
            if (divFixedSize == null) {
                divFixedSize = DivRoundedRectangleShapeJsonParser.CORNER_RADIUS_DEFAULT_VALUE;
            }
            DivFixedSize divFixedSize2 = divFixedSize;
            Intrinsics.checkNotNullExpressionValue(divFixedSize2, "JsonFieldResolver.resolv…RNER_RADIUS_DEFAULT_VALUE");
            DivFixedSize divFixedSize3 = (DivFixedSize) JsonFieldResolver.resolveOptional(context, template.itemHeight, data, "item_height", this.component.getDivFixedSizeJsonTemplateResolver(), this.component.getDivFixedSizeJsonEntityParser());
            if (divFixedSize3 == null) {
                divFixedSize3 = DivRoundedRectangleShapeJsonParser.ITEM_HEIGHT_DEFAULT_VALUE;
            }
            DivFixedSize divFixedSize4 = divFixedSize3;
            Intrinsics.checkNotNullExpressionValue(divFixedSize4, "JsonFieldResolver.resolv…ITEM_HEIGHT_DEFAULT_VALUE");
            DivFixedSize divFixedSize5 = (DivFixedSize) JsonFieldResolver.resolveOptional(context, template.itemWidth, data, "item_width", this.component.getDivFixedSizeJsonTemplateResolver(), this.component.getDivFixedSizeJsonEntityParser());
            if (divFixedSize5 == null) {
                divFixedSize5 = DivRoundedRectangleShapeJsonParser.ITEM_WIDTH_DEFAULT_VALUE;
            }
            DivFixedSize divFixedSize6 = divFixedSize5;
            Intrinsics.checkNotNullExpressionValue(divFixedSize6, "JsonFieldResolver.resolv… ITEM_WIDTH_DEFAULT_VALUE");
            return new DivRoundedRectangleShape(expressionResolveOptionalExpression, divFixedSize2, divFixedSize4, divFixedSize6, (DivStroke) JsonFieldResolver.resolveOptional(context, template.stroke, data, VastAttributes.STROKE_COLOR, this.component.getDivStrokeJsonTemplateResolver(), this.component.getDivStrokeJsonEntityParser()));
        }
    }

    /* JADX INFO: compiled from: DivRoundedRectangleShapeJsonParser.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivRoundedRectangleShapeJsonParser$Companion;", "", "()V", "CORNER_RADIUS_DEFAULT_VALUE", "Lcom/yandex/div2/DivFixedSize;", "ITEM_HEIGHT_DEFAULT_VALUE", "ITEM_WIDTH_DEFAULT_VALUE", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        int i = 1;
        CORNER_RADIUS_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(5L), i, 0 == true ? 1 : 0);
        ITEM_HEIGHT_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(10L), i, 0 == true ? 1 : 0);
        ITEM_WIDTH_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(10L), i, 0 == true ? 1 : 0);
    }
}
