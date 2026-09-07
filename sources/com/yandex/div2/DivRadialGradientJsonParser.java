package com.yandex.div2;

import com.yandex.div.internal.parser.JsonExpressionParser;
import com.yandex.div.internal.parser.JsonFieldParser;
import com.yandex.div.internal.parser.JsonFieldResolver;
import com.yandex.div.internal.parser.JsonPropertyParser;
import com.yandex.div.internal.parser.ListValidator;
import com.yandex.div.internal.parser.ParsingConvertersKt;
import com.yandex.div.internal.parser.TypeHelper;
import com.yandex.div.internal.parser.TypeHelpersKt;
import com.yandex.div.internal.template.Field;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionList;
import com.yandex.div.serialization.Parser;
import com.yandex.div.serialization.ParsingContext;
import com.yandex.div.serialization.ParsingContextKt;
import com.yandex.div.serialization.TemplateParser;
import com.yandex.div.serialization.TemplateResolver;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivRadialGradientJsonParser.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivRadialGradientJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivRadialGradientJsonParser {

    @Deprecated
    public static final DivRadialGradientCenter.Relative CENTER_X_DEFAULT_VALUE;

    @Deprecated
    public static final DivRadialGradientCenter.Relative CENTER_Y_DEFAULT_VALUE;

    @Deprecated
    public static final ListValidator<Integer> COLORS_VALIDATOR;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final DivRadialGradientRadius.Relative RADIUS_DEFAULT_VALUE;
    private final JsonParserComponent component;

    public DivRadialGradientJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivRadialGradientJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivRadialGradientJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivRadialGradient;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivRadialGradient> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivRadialGradient deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            DivRadialGradientCenter.Relative relative = (DivRadialGradientCenter) JsonPropertyParser.readOptional(context, data, "center_x", this.component.getDivRadialGradientCenterJsonEntityParser());
            if (relative == null) {
                relative = DivRadialGradientJsonParser.CENTER_X_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(relative, "JsonPropertyParser.readO…?: CENTER_X_DEFAULT_VALUE");
            DivRadialGradientCenter.Relative relative2 = (DivRadialGradientCenter) JsonPropertyParser.readOptional(context, data, "center_y", this.component.getDivRadialGradientCenterJsonEntityParser());
            if (relative2 == null) {
                relative2 = DivRadialGradientJsonParser.CENTER_Y_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(relative2, "JsonPropertyParser.readO…?: CENTER_Y_DEFAULT_VALUE");
            ExpressionList expressionList = JsonExpressionParser.readExpressionList(context, data, "colors", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT, DivRadialGradientJsonParser.COLORS_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(expressionList, "readExpressionList(conte…OR_INT, COLORS_VALIDATOR)");
            DivRadialGradientRadius.Relative relative3 = (DivRadialGradientRadius) JsonPropertyParser.readOptional(context, data, "radius", this.component.getDivRadialGradientRadiusJsonEntityParser());
            if (relative3 == null) {
                relative3 = DivRadialGradientJsonParser.RADIUS_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(relative3, "JsonPropertyParser.readO…) ?: RADIUS_DEFAULT_VALUE");
            return new DivRadialGradient(relative, relative2, expressionList, relative3);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivRadialGradient value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonPropertyParser.write(context, jSONObject, "center_x", value.centerX, this.component.getDivRadialGradientCenterJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "center_y", value.centerY, this.component.getDivRadialGradientCenterJsonEntityParser());
            JsonExpressionParser.writeExpressionList(context, jSONObject, "colors", value.colors, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "radius", value.radius, this.component.getDivRadialGradientRadiusJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "type", "radial_gradient");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivRadialGradientJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivRadialGradientJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivRadialGradientTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivRadialGradientTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivRadialGradientTemplate deserialize(ParsingContext context, DivRadialGradientTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "center_x", allowPropertyOverride, parent != null ? parent.centerX : null, this.component.getDivRadialGradientCenterJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex…CenterJsonTemplateParser)");
            Field optionalField2 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "center_y", allowPropertyOverride, parent != null ? parent.centerY : null, this.component.getDivRadialGradientCenterJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField2, "readOptionalField(contex…CenterJsonTemplateParser)");
            TypeHelper<Integer> typeHelper = TypeHelpersKt.TYPE_HELPER_COLOR;
            Field<ExpressionList<Integer>> field = parent != null ? parent.colors : null;
            Function1<Object, Integer> function1 = ParsingConvertersKt.STRING_TO_COLOR_INT;
            ListValidator<Integer> listValidator = DivRadialGradientJsonParser.COLORS_VALIDATOR;
            Intrinsics.checkNotNull(listValidator, "null cannot be cast to non-null type com.yandex.div.internal.parser.ListValidator<T of com.yandex.div.internal.parser.ParsingValidatorsKt.cast>");
            Field expressionListField = JsonFieldParser.readExpressionListField(parsingContextRestrictPropertyOverride, data, "colors", typeHelper, allowPropertyOverride, field, function1, listValidator);
            Intrinsics.checkNotNullExpressionValue(expressionListField, "readExpressionListField(… COLORS_VALIDATOR.cast())");
            Field optionalField3 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "radius", allowPropertyOverride, parent != null ? parent.radius : null, this.component.getDivRadialGradientRadiusJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField3, "readOptionalField(contex…RadiusJsonTemplateParser)");
            return new DivRadialGradientTemplate((Field<DivRadialGradientCenterTemplate>) optionalField, (Field<DivRadialGradientCenterTemplate>) optionalField2, (Field<ExpressionList<Integer>>) expressionListField, (Field<DivRadialGradientRadiusTemplate>) optionalField3);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivRadialGradientTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeField(context, jSONObject, "center_x", value.centerX, this.component.getDivRadialGradientCenterJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "center_y", value.centerY, this.component.getDivRadialGradientCenterJsonTemplateParser());
            JsonFieldParser.writeExpressionListField(context, jSONObject, "colors", value.colors, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "radius", value.radius, this.component.getDivRadialGradientRadiusJsonTemplateParser());
            JsonPropertyParser.write(context, jSONObject, "type", "radial_gradient");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivRadialGradientJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivRadialGradientJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivRadialGradientTemplate;", "Lcom/yandex/div2/DivRadialGradient;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivRadialGradientTemplate, DivRadialGradient> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivRadialGradient resolve(ParsingContext context, DivRadialGradientTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            DivRadialGradientCenter.Relative relative = (DivRadialGradientCenter) JsonFieldResolver.resolveOptional(context, template.centerX, data, "center_x", this.component.getDivRadialGradientCenterJsonTemplateResolver(), this.component.getDivRadialGradientCenterJsonEntityParser());
            if (relative == null) {
                relative = DivRadialGradientJsonParser.CENTER_X_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(relative, "JsonFieldResolver.resolv…?: CENTER_X_DEFAULT_VALUE");
            DivRadialGradientCenter.Relative relative2 = (DivRadialGradientCenter) JsonFieldResolver.resolveOptional(context, template.centerY, data, "center_y", this.component.getDivRadialGradientCenterJsonTemplateResolver(), this.component.getDivRadialGradientCenterJsonEntityParser());
            if (relative2 == null) {
                relative2 = DivRadialGradientJsonParser.CENTER_Y_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(relative2, "JsonFieldResolver.resolv…?: CENTER_Y_DEFAULT_VALUE");
            ExpressionList expressionListResolveExpressionList = JsonFieldResolver.resolveExpressionList(context, template.colors, data, "colors", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT, DivRadialGradientJsonParser.COLORS_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(expressionListResolveExpressionList, "resolveExpressionList(co…OR_INT, COLORS_VALIDATOR)");
            DivRadialGradientRadius.Relative relative3 = (DivRadialGradientRadius) JsonFieldResolver.resolveOptional(context, template.radius, data, "radius", this.component.getDivRadialGradientRadiusJsonTemplateResolver(), this.component.getDivRadialGradientRadiusJsonEntityParser());
            if (relative3 == null) {
                relative3 = DivRadialGradientJsonParser.RADIUS_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(relative3, "JsonFieldResolver.resolv…) ?: RADIUS_DEFAULT_VALUE");
            return new DivRadialGradient(relative, relative2, expressionListResolveExpressionList, relative3);
        }
    }

    /* JADX INFO: compiled from: DivRadialGradientJsonParser.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/yandex/div2/DivRadialGradientJsonParser$Companion;", "", "()V", "CENTER_X_DEFAULT_VALUE", "Lcom/yandex/div2/DivRadialGradientCenter$Relative;", "CENTER_Y_DEFAULT_VALUE", "COLORS_VALIDATOR", "Lcom/yandex/div/internal/parser/ListValidator;", "", "RADIUS_DEFAULT_VALUE", "Lcom/yandex/div2/DivRadialGradientRadius$Relative;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Expression.Companion companion = Expression.INSTANCE;
        Double dValueOf = Double.valueOf(0.5d);
        CENTER_X_DEFAULT_VALUE = new DivRadialGradientCenter.Relative(new DivRadialGradientRelativeCenter(companion.constant(dValueOf)));
        CENTER_Y_DEFAULT_VALUE = new DivRadialGradientCenter.Relative(new DivRadialGradientRelativeCenter(Expression.INSTANCE.constant(dValueOf)));
        RADIUS_DEFAULT_VALUE = new DivRadialGradientRadius.Relative(new DivRadialGradientRelativeRadius(Expression.INSTANCE.constant(DivRadialGradientRelativeRadius.Value.FARTHEST_CORNER)));
        COLORS_VALIDATOR = new ListValidator() { // from class: com.yandex.div2.DivRadialGradientJsonParser$$ExternalSyntheticLambda0
            @Override // com.yandex.div.internal.parser.ListValidator
            public final boolean isValid(List list) {
                return DivRadialGradientJsonParser.COLORS_VALIDATOR$lambda$0(list);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean COLORS_VALIDATOR$lambda$0(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.size() >= 2;
    }
}
