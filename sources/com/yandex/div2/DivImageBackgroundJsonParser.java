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
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivImageBackgroundJsonParser.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivImageBackgroundJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivImageBackgroundJsonParser {
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<Double> ALPHA_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(1.0d));

    @Deprecated
    public static final Expression<DivAlignmentHorizontal> CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAlignmentHorizontal.CENTER);

    @Deprecated
    public static final Expression<DivAlignmentVertical> CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAlignmentVertical.CENTER);

    @Deprecated
    public static final Expression<Boolean> PRELOAD_REQUIRED_DEFAULT_VALUE = Expression.INSTANCE.constant(false);

    @Deprecated
    public static final Expression<DivImageScale> SCALE_DEFAULT_VALUE = Expression.INSTANCE.constant(DivImageScale.FILL);

    @Deprecated
    public static final TypeHelper<DivAlignmentHorizontal> TYPE_HELPER_CONTENT_ALIGNMENT_HORIZONTAL = TypeHelper.INSTANCE.from(ArraysKt.first(DivAlignmentHorizontal.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivImageBackgroundJsonParser$Companion$TYPE_HELPER_CONTENT_ALIGNMENT_HORIZONTAL$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivAlignmentHorizontal);
        }
    });

    @Deprecated
    public static final TypeHelper<DivAlignmentVertical> TYPE_HELPER_CONTENT_ALIGNMENT_VERTICAL = TypeHelper.INSTANCE.from(ArraysKt.first(DivAlignmentVertical.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivImageBackgroundJsonParser$Companion$TYPE_HELPER_CONTENT_ALIGNMENT_VERTICAL$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivAlignmentVertical);
        }
    });

    @Deprecated
    public static final TypeHelper<DivImageScale> TYPE_HELPER_SCALE = TypeHelper.INSTANCE.from(ArraysKt.first(DivImageScale.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivImageBackgroundJsonParser$Companion$TYPE_HELPER_SCALE$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivImageScale);
        }
    });

    @Deprecated
    public static final ValueValidator<Double> ALPHA_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivImageBackgroundJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivImageBackgroundJsonParser.ALPHA_VALIDATOR$lambda$0(((Double) obj).doubleValue());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ALPHA_VALIDATOR$lambda$0(double d) {
        return d >= 0.0d && d <= 1.0d;
    }

    public DivImageBackgroundJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivImageBackgroundJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivImageBackgroundJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivImageBackground;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivImageBackground> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivImageBackground deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression<Double> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivImageBackgroundJsonParser.ALPHA_VALIDATOR, DivImageBackgroundJsonParser.ALPHA_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivImageBackgroundJsonParser.ALPHA_DEFAULT_VALUE;
            }
            Expression<Double> expression = optionalExpression;
            Expression<DivAlignmentHorizontal> optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, "content_alignment_horizontal", DivImageBackgroundJsonParser.TYPE_HELPER_CONTENT_ALIGNMENT_HORIZONTAL, DivAlignmentHorizontal.FROM_STRING, DivImageBackgroundJsonParser.CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE);
            if (optionalExpression2 == null) {
                optionalExpression2 = DivImageBackgroundJsonParser.CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE;
            }
            Expression<DivAlignmentHorizontal> expression2 = optionalExpression2;
            Expression<DivAlignmentVertical> optionalExpression3 = JsonExpressionParser.readOptionalExpression(context, data, "content_alignment_vertical", DivImageBackgroundJsonParser.TYPE_HELPER_CONTENT_ALIGNMENT_VERTICAL, DivAlignmentVertical.FROM_STRING, DivImageBackgroundJsonParser.CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE);
            if (optionalExpression3 == null) {
                optionalExpression3 = DivImageBackgroundJsonParser.CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE;
            }
            Expression<DivAlignmentVertical> expression3 = optionalExpression3;
            List optionalList = JsonPropertyParser.readOptionalList(context, data, "filters", this.component.getDivFilterJsonEntityParser());
            Expression expression4 = JsonExpressionParser.readExpression(context, data, "image_url", TypeHelpersKt.TYPE_HELPER_URI, ParsingConvertersKt.ANY_TO_URI);
            Intrinsics.checkNotNullExpressionValue(expression4, "readExpression(context, …E_HELPER_URI, ANY_TO_URI)");
            Expression<Boolean> optionalExpression4 = JsonExpressionParser.readOptionalExpression(context, data, "preload_required", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivImageBackgroundJsonParser.PRELOAD_REQUIRED_DEFAULT_VALUE);
            if (optionalExpression4 == null) {
                optionalExpression4 = DivImageBackgroundJsonParser.PRELOAD_REQUIRED_DEFAULT_VALUE;
            }
            Expression<Boolean> expression5 = optionalExpression4;
            Expression<DivImageScale> optionalExpression5 = JsonExpressionParser.readOptionalExpression(context, data, "scale", DivImageBackgroundJsonParser.TYPE_HELPER_SCALE, DivImageScale.FROM_STRING, DivImageBackgroundJsonParser.SCALE_DEFAULT_VALUE);
            if (optionalExpression5 == null) {
                optionalExpression5 = DivImageBackgroundJsonParser.SCALE_DEFAULT_VALUE;
            }
            return new DivImageBackground(expression, expression2, expression3, optionalList, expression4, expression5, optionalExpression5);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivImageBackground value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonExpressionParser.writeExpression(context, jSONObject, "alpha", value.alpha);
            JsonExpressionParser.writeExpression(context, jSONObject, "content_alignment_horizontal", value.contentAlignmentHorizontal, DivAlignmentHorizontal.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "content_alignment_vertical", value.contentAlignmentVertical, DivAlignmentVertical.TO_STRING);
            JsonPropertyParser.writeList(context, jSONObject, "filters", value.filters, this.component.getDivFilterJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "image_url", value.imageUrl, ParsingConvertersKt.URI_TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "preload_required", value.preloadRequired);
            JsonExpressionParser.writeExpression(context, jSONObject, "scale", value.scale, DivImageScale.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "type", "image");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivImageBackgroundJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivImageBackgroundJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivImageBackgroundTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivImageBackgroundTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivImageBackgroundTemplate deserialize(ParsingContext context, DivImageBackgroundTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.alpha : null, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivImageBackgroundJsonParser.ALPHA_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…_DOUBLE, ALPHA_VALIDATOR)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "content_alignment_horizontal", DivImageBackgroundJsonParser.TYPE_HELPER_CONTENT_ALIGNMENT_HORIZONTAL, allowPropertyOverride, parent != null ? parent.contentAlignmentHorizontal : null, DivAlignmentHorizontal.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…ntHorizontal.FROM_STRING)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "content_alignment_vertical", DivImageBackgroundJsonParser.TYPE_HELPER_CONTENT_ALIGNMENT_VERTICAL, allowPropertyOverride, parent != null ? parent.contentAlignmentVertical : null, DivAlignmentVertical.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…mentVertical.FROM_STRING)");
            Field optionalListField = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "filters", allowPropertyOverride, parent != null ? parent.filters : null, this.component.getDivFilterJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField, "readOptionalListField(co…FilterJsonTemplateParser)");
            Field fieldWithExpression = JsonFieldParser.readFieldWithExpression(parsingContextRestrictPropertyOverride, data, "image_url", TypeHelpersKt.TYPE_HELPER_URI, allowPropertyOverride, parent != null ? parent.imageUrl : null, ParsingConvertersKt.ANY_TO_URI);
            Intrinsics.checkNotNullExpressionValue(fieldWithExpression, "readFieldWithExpression(…nt?.imageUrl, ANY_TO_URI)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "preload_required", TypeHelpersKt.TYPE_HELPER_BOOLEAN, allowPropertyOverride, parent != null ? parent.preloadRequired : null, ParsingConvertersKt.ANY_TO_BOOLEAN);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…Required, ANY_TO_BOOLEAN)");
            Field optionalFieldWithExpression5 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "scale", DivImageBackgroundJsonParser.TYPE_HELPER_SCALE, allowPropertyOverride, parent != null ? parent.scale : null, DivImageScale.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression5, "readOptionalFieldWithExp…ivImageScale.FROM_STRING)");
            return new DivImageBackgroundTemplate(optionalFieldWithExpression, optionalFieldWithExpression2, optionalFieldWithExpression3, optionalListField, fieldWithExpression, optionalFieldWithExpression4, optionalFieldWithExpression5);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivImageBackgroundTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeExpressionField(context, jSONObject, "alpha", value.alpha);
            JsonFieldParser.writeExpressionField(context, jSONObject, "content_alignment_horizontal", value.contentAlignmentHorizontal, DivAlignmentHorizontal.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "content_alignment_vertical", value.contentAlignmentVertical, DivAlignmentVertical.TO_STRING);
            JsonFieldParser.writeListField(context, jSONObject, "filters", value.filters, this.component.getDivFilterJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "image_url", value.imageUrl, ParsingConvertersKt.URI_TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "preload_required", value.preloadRequired);
            JsonFieldParser.writeExpressionField(context, jSONObject, "scale", value.scale, DivImageScale.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "type", "image");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivImageBackgroundJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivImageBackgroundJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivImageBackgroundTemplate;", "Lcom/yandex/div2/DivImageBackground;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivImageBackgroundTemplate, DivImageBackground> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivImageBackground resolve(ParsingContext context, DivImageBackgroundTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression<Double> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.alpha, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivImageBackgroundJsonParser.ALPHA_VALIDATOR, DivImageBackgroundJsonParser.ALPHA_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivImageBackgroundJsonParser.ALPHA_DEFAULT_VALUE;
            }
            Expression<Double> expression = expressionResolveOptionalExpression;
            Expression<DivAlignmentHorizontal> expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.contentAlignmentHorizontal, data, "content_alignment_horizontal", DivImageBackgroundJsonParser.TYPE_HELPER_CONTENT_ALIGNMENT_HORIZONTAL, DivAlignmentHorizontal.FROM_STRING, DivImageBackgroundJsonParser.CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression2 == null) {
                expressionResolveOptionalExpression2 = DivImageBackgroundJsonParser.CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE;
            }
            Expression<DivAlignmentHorizontal> expression2 = expressionResolveOptionalExpression2;
            Expression<DivAlignmentVertical> expressionResolveOptionalExpression3 = JsonFieldResolver.resolveOptionalExpression(context, template.contentAlignmentVertical, data, "content_alignment_vertical", DivImageBackgroundJsonParser.TYPE_HELPER_CONTENT_ALIGNMENT_VERTICAL, DivAlignmentVertical.FROM_STRING, DivImageBackgroundJsonParser.CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression3 == null) {
                expressionResolveOptionalExpression3 = DivImageBackgroundJsonParser.CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE;
            }
            Expression<DivAlignmentVertical> expression3 = expressionResolveOptionalExpression3;
            List listResolveOptionalList = JsonFieldResolver.resolveOptionalList(context, template.filters, data, "filters", this.component.getDivFilterJsonTemplateResolver(), this.component.getDivFilterJsonEntityParser());
            Expression expressionResolveExpression = JsonFieldResolver.resolveExpression(context, template.imageUrl, data, "image_url", TypeHelpersKt.TYPE_HELPER_URI, ParsingConvertersKt.ANY_TO_URI);
            Intrinsics.checkNotNullExpressionValue(expressionResolveExpression, "resolveExpression(contex…E_HELPER_URI, ANY_TO_URI)");
            Expression<Boolean> expressionResolveOptionalExpression4 = JsonFieldResolver.resolveOptionalExpression(context, template.preloadRequired, data, "preload_required", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivImageBackgroundJsonParser.PRELOAD_REQUIRED_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression4 == null) {
                expressionResolveOptionalExpression4 = DivImageBackgroundJsonParser.PRELOAD_REQUIRED_DEFAULT_VALUE;
            }
            Expression<Boolean> expression4 = expressionResolveOptionalExpression4;
            Expression<DivImageScale> expressionResolveOptionalExpression5 = JsonFieldResolver.resolveOptionalExpression(context, template.scale, data, "scale", DivImageBackgroundJsonParser.TYPE_HELPER_SCALE, DivImageScale.FROM_STRING, DivImageBackgroundJsonParser.SCALE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression5 == null) {
                expressionResolveOptionalExpression5 = DivImageBackgroundJsonParser.SCALE_DEFAULT_VALUE;
            }
            return new DivImageBackground(expression, expression2, expression3, listResolveOptionalList, expressionResolveExpression, expression4, expressionResolveOptionalExpression5);
        }
    }

    /* JADX INFO: compiled from: DivImageBackgroundJsonParser.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00118\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00118\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00118\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/yandex/div2/DivImageBackgroundJsonParser$Companion;", "", "()V", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "ALPHA_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE", "Lcom/yandex/div2/DivAlignmentHorizontal;", "CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE", "Lcom/yandex/div2/DivAlignmentVertical;", "PRELOAD_REQUIRED_DEFAULT_VALUE", "", "SCALE_DEFAULT_VALUE", "Lcom/yandex/div2/DivImageScale;", "TYPE_HELPER_CONTENT_ALIGNMENT_HORIZONTAL", "Lcom/yandex/div/internal/parser/TypeHelper;", "TYPE_HELPER_CONTENT_ALIGNMENT_VERTICAL", "TYPE_HELPER_SCALE", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
