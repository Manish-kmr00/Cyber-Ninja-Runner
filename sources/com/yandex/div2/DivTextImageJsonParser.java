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

/* JADX INFO: compiled from: DivTextJsonParser.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivTextImageJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivTextImageJsonParser {

    @Deprecated
    public static final DivFixedSize HEIGHT_DEFAULT_VALUE;

    @Deprecated
    public static final DivFixedSize WIDTH_DEFAULT_VALUE;
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<DivTextAlignmentVertical> ALIGNMENT_VERTICAL_DEFAULT_VALUE = Expression.INSTANCE.constant(DivTextAlignmentVertical.CENTER);

    @Deprecated
    public static final Expression<DivText.Image.IndexingDirection> INDEXING_DIRECTION_DEFAULT_VALUE = Expression.INSTANCE.constant(DivText.Image.IndexingDirection.NORMAL);

    @Deprecated
    public static final Expression<Boolean> PRELOAD_REQUIRED_DEFAULT_VALUE = Expression.INSTANCE.constant(false);

    @Deprecated
    public static final Expression<DivBlendMode> TINT_MODE_DEFAULT_VALUE = Expression.INSTANCE.constant(DivBlendMode.SOURCE_IN);

    @Deprecated
    public static final TypeHelper<DivTextAlignmentVertical> TYPE_HELPER_ALIGNMENT_VERTICAL = TypeHelper.INSTANCE.from(ArraysKt.first(DivTextAlignmentVertical.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTextImageJsonParser$Companion$TYPE_HELPER_ALIGNMENT_VERTICAL$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivTextAlignmentVertical);
        }
    });

    @Deprecated
    public static final TypeHelper<DivText.Image.IndexingDirection> TYPE_HELPER_INDEXING_DIRECTION = TypeHelper.INSTANCE.from(ArraysKt.first(DivText.Image.IndexingDirection.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTextImageJsonParser$Companion$TYPE_HELPER_INDEXING_DIRECTION$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivText.Image.IndexingDirection);
        }
    });

    @Deprecated
    public static final TypeHelper<DivBlendMode> TYPE_HELPER_TINT_MODE = TypeHelper.INSTANCE.from(ArraysKt.first(DivBlendMode.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTextImageJsonParser$Companion$TYPE_HELPER_TINT_MODE$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivBlendMode);
        }
    });

    @Deprecated
    public static final ValueValidator<Long> START_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTextImageJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivTextImageJsonParser.START_VALIDATOR$lambda$0(((Long) obj).longValue());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean START_VALIDATOR$lambda$0(long j) {
        return j >= 0;
    }

    public DivTextImageJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivTextJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivTextImageJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivText$Image;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivText.Image> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivText.Image deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            DivText.Image.Accessibility accessibility = (DivText.Image.Accessibility) JsonPropertyParser.readOptional(context, data, "accessibility", this.component.getDivTextImageAccessibilityJsonEntityParser());
            Expression<DivTextAlignmentVertical> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "alignment_vertical", DivTextImageJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, DivTextAlignmentVertical.FROM_STRING, DivTextImageJsonParser.ALIGNMENT_VERTICAL_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivTextImageJsonParser.ALIGNMENT_VERTICAL_DEFAULT_VALUE;
            }
            Expression<DivTextAlignmentVertical> expression = optionalExpression;
            DivFixedSize divFixedSize = (DivFixedSize) JsonPropertyParser.readOptional(context, data, "height", this.component.getDivFixedSizeJsonEntityParser());
            if (divFixedSize == null) {
                divFixedSize = DivTextImageJsonParser.HEIGHT_DEFAULT_VALUE;
            }
            DivFixedSize divFixedSize2 = divFixedSize;
            Intrinsics.checkNotNullExpressionValue(divFixedSize2, "JsonPropertyParser.readO…) ?: HEIGHT_DEFAULT_VALUE");
            Expression<DivText.Image.IndexingDirection> optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, "indexing_direction", DivTextImageJsonParser.TYPE_HELPER_INDEXING_DIRECTION, DivText.Image.IndexingDirection.FROM_STRING, DivTextImageJsonParser.INDEXING_DIRECTION_DEFAULT_VALUE);
            if (optionalExpression2 == null) {
                optionalExpression2 = DivTextImageJsonParser.INDEXING_DIRECTION_DEFAULT_VALUE;
            }
            Expression<DivText.Image.IndexingDirection> expression2 = optionalExpression2;
            Expression<Boolean> optionalExpression3 = JsonExpressionParser.readOptionalExpression(context, data, "preload_required", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivTextImageJsonParser.PRELOAD_REQUIRED_DEFAULT_VALUE);
            if (optionalExpression3 == null) {
                optionalExpression3 = DivTextImageJsonParser.PRELOAD_REQUIRED_DEFAULT_VALUE;
            }
            Expression<Boolean> expression3 = optionalExpression3;
            Expression expression4 = JsonExpressionParser.readExpression(context, data, "start", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextImageJsonParser.START_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(expression4, "readExpression(context, …_TO_INT, START_VALIDATOR)");
            Expression optionalExpression4 = JsonExpressionParser.readOptionalExpression(context, data, "tint_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Expression<DivBlendMode> optionalExpression5 = JsonExpressionParser.readOptionalExpression(context, data, "tint_mode", DivTextImageJsonParser.TYPE_HELPER_TINT_MODE, DivBlendMode.FROM_STRING, DivTextImageJsonParser.TINT_MODE_DEFAULT_VALUE);
            if (optionalExpression5 == null) {
                optionalExpression5 = DivTextImageJsonParser.TINT_MODE_DEFAULT_VALUE;
            }
            Expression expression5 = JsonExpressionParser.readExpression(context, data, "url", TypeHelpersKt.TYPE_HELPER_URI, ParsingConvertersKt.ANY_TO_URI);
            Intrinsics.checkNotNullExpressionValue(expression5, "readExpression(context, …E_HELPER_URI, ANY_TO_URI)");
            DivFixedSize divFixedSize3 = (DivFixedSize) JsonPropertyParser.readOptional(context, data, "width", this.component.getDivFixedSizeJsonEntityParser());
            if (divFixedSize3 == null) {
                divFixedSize3 = DivTextImageJsonParser.WIDTH_DEFAULT_VALUE;
            }
            DivFixedSize divFixedSize4 = divFixedSize3;
            Intrinsics.checkNotNullExpressionValue(divFixedSize4, "JsonPropertyParser.readO…r) ?: WIDTH_DEFAULT_VALUE");
            return new DivText.Image(accessibility, expression, divFixedSize2, expression2, expression3, expression4, optionalExpression4, optionalExpression5, expression5, divFixedSize4);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivText.Image value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonPropertyParser.write(context, jSONObject, "accessibility", value.accessibility, this.component.getDivTextImageAccessibilityJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "alignment_vertical", value.alignmentVertical, DivTextAlignmentVertical.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "height", value.height, this.component.getDivFixedSizeJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "indexing_direction", value.indexingDirection, DivText.Image.IndexingDirection.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "preload_required", value.preloadRequired);
            JsonExpressionParser.writeExpression(context, jSONObject, "start", value.start);
            JsonExpressionParser.writeExpression(context, jSONObject, "tint_color", value.tintColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "tint_mode", value.tintMode, DivBlendMode.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "url", value.url, ParsingConvertersKt.URI_TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "width", value.width, this.component.getDivFixedSizeJsonEntityParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivTextJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivTextImageJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTextTemplate$ImageTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivTextTemplate.ImageTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivTextTemplate.ImageTemplate deserialize(ParsingContext context, DivTextTemplate.ImageTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "accessibility", allowPropertyOverride, parent != null ? parent.accessibility : null, this.component.getDivTextImageAccessibilityJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex…bilityJsonTemplateParser)");
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alignment_vertical", DivTextImageJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, allowPropertyOverride, parent != null ? parent.alignmentVertical : null, DivTextAlignmentVertical.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…mentVertical.FROM_STRING)");
            Field optionalField2 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "height", allowPropertyOverride, parent != null ? parent.height : null, this.component.getDivFixedSizeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField2, "readOptionalField(contex…edSizeJsonTemplateParser)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "indexing_direction", DivTextImageJsonParser.TYPE_HELPER_INDEXING_DIRECTION, allowPropertyOverride, parent != null ? parent.indexingDirection : null, DivText.Image.IndexingDirection.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…ingDirection.FROM_STRING)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "preload_required", TypeHelpersKt.TYPE_HELPER_BOOLEAN, allowPropertyOverride, parent != null ? parent.preloadRequired : null, ParsingConvertersKt.ANY_TO_BOOLEAN);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…Required, ANY_TO_BOOLEAN)");
            Field fieldWithExpression = JsonFieldParser.readFieldWithExpression(parsingContextRestrictPropertyOverride, data, "start", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.start : null, ParsingConvertersKt.NUMBER_TO_INT, DivTextImageJsonParser.START_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(fieldWithExpression, "readFieldWithExpression(…_TO_INT, START_VALIDATOR)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "tint_color", TypeHelpersKt.TYPE_HELPER_COLOR, allowPropertyOverride, parent != null ? parent.tintColor : null, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…lor, STRING_TO_COLOR_INT)");
            Field optionalFieldWithExpression5 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "tint_mode", DivTextImageJsonParser.TYPE_HELPER_TINT_MODE, allowPropertyOverride, parent != null ? parent.tintMode : null, DivBlendMode.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression5, "readOptionalFieldWithExp…DivBlendMode.FROM_STRING)");
            Field fieldWithExpression2 = JsonFieldParser.readFieldWithExpression(parsingContextRestrictPropertyOverride, data, "url", TypeHelpersKt.TYPE_HELPER_URI, allowPropertyOverride, parent != null ? parent.url : null, ParsingConvertersKt.ANY_TO_URI);
            Intrinsics.checkNotNullExpressionValue(fieldWithExpression2, "readFieldWithExpression(… parent?.url, ANY_TO_URI)");
            Field optionalField3 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "width", allowPropertyOverride, parent != null ? parent.width : null, this.component.getDivFixedSizeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField3, "readOptionalField(contex…edSizeJsonTemplateParser)");
            return new DivTextTemplate.ImageTemplate(optionalField, optionalFieldWithExpression, optionalField2, optionalFieldWithExpression2, optionalFieldWithExpression3, fieldWithExpression, optionalFieldWithExpression4, optionalFieldWithExpression5, fieldWithExpression2, optionalField3);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivTextTemplate.ImageTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeField(context, jSONObject, "accessibility", value.accessibility, this.component.getDivTextImageAccessibilityJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "alignment_vertical", value.alignmentVertical, DivTextAlignmentVertical.TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "height", value.height, this.component.getDivFixedSizeJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "indexing_direction", value.indexingDirection, DivText.Image.IndexingDirection.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "preload_required", value.preloadRequired);
            JsonFieldParser.writeExpressionField(context, jSONObject, "start", value.start);
            JsonFieldParser.writeExpressionField(context, jSONObject, "tint_color", value.tintColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "tint_mode", value.tintMode, DivBlendMode.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "url", value.url, ParsingConvertersKt.URI_TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "width", value.width, this.component.getDivFixedSizeJsonTemplateParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivTextJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivTextImageJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTextTemplate$ImageTemplate;", "Lcom/yandex/div2/DivText$Image;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivTextTemplate.ImageTemplate, DivText.Image> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivText.Image resolve(ParsingContext context, DivTextTemplate.ImageTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            DivText.Image.Accessibility accessibility = (DivText.Image.Accessibility) JsonFieldResolver.resolveOptional(context, template.accessibility, data, "accessibility", this.component.getDivTextImageAccessibilityJsonTemplateResolver(), this.component.getDivTextImageAccessibilityJsonEntityParser());
            Expression<DivTextAlignmentVertical> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.alignmentVertical, data, "alignment_vertical", DivTextImageJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, DivTextAlignmentVertical.FROM_STRING, DivTextImageJsonParser.ALIGNMENT_VERTICAL_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivTextImageJsonParser.ALIGNMENT_VERTICAL_DEFAULT_VALUE;
            }
            Expression<DivTextAlignmentVertical> expression = expressionResolveOptionalExpression;
            DivFixedSize divFixedSize = (DivFixedSize) JsonFieldResolver.resolveOptional(context, template.height, data, "height", this.component.getDivFixedSizeJsonTemplateResolver(), this.component.getDivFixedSizeJsonEntityParser());
            if (divFixedSize == null) {
                divFixedSize = DivTextImageJsonParser.HEIGHT_DEFAULT_VALUE;
            }
            DivFixedSize divFixedSize2 = divFixedSize;
            Intrinsics.checkNotNullExpressionValue(divFixedSize2, "JsonFieldResolver.resolv…) ?: HEIGHT_DEFAULT_VALUE");
            Expression<DivText.Image.IndexingDirection> expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.indexingDirection, data, "indexing_direction", DivTextImageJsonParser.TYPE_HELPER_INDEXING_DIRECTION, DivText.Image.IndexingDirection.FROM_STRING, DivTextImageJsonParser.INDEXING_DIRECTION_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression2 == null) {
                expressionResolveOptionalExpression2 = DivTextImageJsonParser.INDEXING_DIRECTION_DEFAULT_VALUE;
            }
            Expression<DivText.Image.IndexingDirection> expression2 = expressionResolveOptionalExpression2;
            Expression<Boolean> expressionResolveOptionalExpression3 = JsonFieldResolver.resolveOptionalExpression(context, template.preloadRequired, data, "preload_required", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivTextImageJsonParser.PRELOAD_REQUIRED_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression3 == null) {
                expressionResolveOptionalExpression3 = DivTextImageJsonParser.PRELOAD_REQUIRED_DEFAULT_VALUE;
            }
            Expression<Boolean> expression3 = expressionResolveOptionalExpression3;
            Expression expressionResolveExpression = JsonFieldResolver.resolveExpression(context, template.start, data, "start", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextImageJsonParser.START_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(expressionResolveExpression, "resolveExpression(contex…_TO_INT, START_VALIDATOR)");
            Expression expressionResolveOptionalExpression4 = JsonFieldResolver.resolveOptionalExpression(context, template.tintColor, data, "tint_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Expression<DivBlendMode> expressionResolveOptionalExpression5 = JsonFieldResolver.resolveOptionalExpression(context, template.tintMode, data, "tint_mode", DivTextImageJsonParser.TYPE_HELPER_TINT_MODE, DivBlendMode.FROM_STRING, DivTextImageJsonParser.TINT_MODE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression5 == null) {
                expressionResolveOptionalExpression5 = DivTextImageJsonParser.TINT_MODE_DEFAULT_VALUE;
            }
            Expression<DivBlendMode> expression4 = expressionResolveOptionalExpression5;
            Expression expressionResolveExpression2 = JsonFieldResolver.resolveExpression(context, template.url, data, "url", TypeHelpersKt.TYPE_HELPER_URI, ParsingConvertersKt.ANY_TO_URI);
            Intrinsics.checkNotNullExpressionValue(expressionResolveExpression2, "resolveExpression(contex…E_HELPER_URI, ANY_TO_URI)");
            DivFixedSize divFixedSize3 = (DivFixedSize) JsonFieldResolver.resolveOptional(context, template.width, data, "width", this.component.getDivFixedSizeJsonTemplateResolver(), this.component.getDivFixedSizeJsonEntityParser());
            if (divFixedSize3 == null) {
                divFixedSize3 = DivTextImageJsonParser.WIDTH_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(divFixedSize3, "JsonFieldResolver.resolv…r) ?: WIDTH_DEFAULT_VALUE");
            return new DivText.Image(accessibility, expression, divFixedSize2, expression2, expression3, expressionResolveExpression, expressionResolveOptionalExpression4, expression4, expressionResolveExpression2, divFixedSize3);
        }
    }

    /* JADX INFO: compiled from: DivTextJsonParser.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00128\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00128\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00128\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yandex/div2/DivTextImageJsonParser$Companion;", "", "()V", "ALIGNMENT_VERTICAL_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivTextAlignmentVertical;", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivFixedSize;", "INDEXING_DIRECTION_DEFAULT_VALUE", "Lcom/yandex/div2/DivText$Image$IndexingDirection;", "PRELOAD_REQUIRED_DEFAULT_VALUE", "", "START_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "", "TINT_MODE_DEFAULT_VALUE", "Lcom/yandex/div2/DivBlendMode;", "TYPE_HELPER_ALIGNMENT_VERTICAL", "Lcom/yandex/div/internal/parser/TypeHelper;", "TYPE_HELPER_INDEXING_DIRECTION", "TYPE_HELPER_TINT_MODE", "WIDTH_DEFAULT_VALUE", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        int i = 1;
        HEIGHT_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(20L), i, 0 == true ? 1 : 0);
        WIDTH_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(20L), i, 0 == true ? 1 : 0);
    }
}
