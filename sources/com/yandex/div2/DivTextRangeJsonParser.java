package com.yandex.div2;

import androidx.compose.material.OutlinedTextFieldKt;
import androidx.core.provider.FontsContractCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
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
import io.appmetrica.analytics.impl.J2;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivTextJsonParser.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivTextRangeJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivTextRangeJsonParser {
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<Double> BASELINE_OFFSET_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(0.0d));

    @Deprecated
    public static final Expression<DivSizeUnit> FONT_SIZE_UNIT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivSizeUnit.SP);

    @Deprecated
    public static final Expression<Long> START_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);

    @Deprecated
    public static final TypeHelper<DivTextAlignmentVertical> TYPE_HELPER_ALIGNMENT_VERTICAL = TypeHelper.INSTANCE.from(ArraysKt.first(DivTextAlignmentVertical.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTextRangeJsonParser$Companion$TYPE_HELPER_ALIGNMENT_VERTICAL$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivTextAlignmentVertical);
        }
    });

    @Deprecated
    public static final TypeHelper<DivSizeUnit> TYPE_HELPER_FONT_SIZE_UNIT = TypeHelper.INSTANCE.from(ArraysKt.first(DivSizeUnit.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTextRangeJsonParser$Companion$TYPE_HELPER_FONT_SIZE_UNIT$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivSizeUnit);
        }
    });

    @Deprecated
    public static final TypeHelper<DivFontWeight> TYPE_HELPER_FONT_WEIGHT = TypeHelper.INSTANCE.from(ArraysKt.first(DivFontWeight.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTextRangeJsonParser$Companion$TYPE_HELPER_FONT_WEIGHT$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivFontWeight);
        }
    });

    @Deprecated
    public static final TypeHelper<DivLineStyle> TYPE_HELPER_STRIKE = TypeHelper.INSTANCE.from(ArraysKt.first(DivLineStyle.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTextRangeJsonParser$Companion$TYPE_HELPER_STRIKE$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivLineStyle);
        }
    });

    @Deprecated
    public static final TypeHelper<DivLineStyle> TYPE_HELPER_UNDERLINE = TypeHelper.INSTANCE.from(ArraysKt.first(DivLineStyle.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTextRangeJsonParser$Companion$TYPE_HELPER_UNDERLINE$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivLineStyle);
        }
    });

    @Deprecated
    public static final ValueValidator<Long> END_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTextRangeJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivTextRangeJsonParser.END_VALIDATOR$lambda$0(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> FONT_SIZE_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTextRangeJsonParser$$ExternalSyntheticLambda1
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivTextRangeJsonParser.FONT_SIZE_VALIDATOR$lambda$1(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> FONT_WEIGHT_VALUE_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTextRangeJsonParser$$ExternalSyntheticLambda2
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivTextRangeJsonParser.FONT_WEIGHT_VALUE_VALIDATOR$lambda$2(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> LINE_HEIGHT_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTextRangeJsonParser$$ExternalSyntheticLambda3
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivTextRangeJsonParser.LINE_HEIGHT_VALIDATOR$lambda$3(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> START_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTextRangeJsonParser$$ExternalSyntheticLambda4
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivTextRangeJsonParser.START_VALIDATOR$lambda$4(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> TOP_OFFSET_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTextRangeJsonParser$$ExternalSyntheticLambda5
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivTextRangeJsonParser.TOP_OFFSET_VALIDATOR$lambda$5(((Long) obj).longValue());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean END_VALIDATOR$lambda$0(long j) {
        return j > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FONT_SIZE_VALIDATOR$lambda$1(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FONT_WEIGHT_VALUE_VALIDATOR$lambda$2(long j) {
        return j > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LINE_HEIGHT_VALIDATOR$lambda$3(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean START_VALIDATOR$lambda$4(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TOP_OFFSET_VALIDATOR$lambda$5(long j) {
        return j >= 0;
    }

    public DivTextRangeJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivTextJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivTextRangeJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivText$Range;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivText.Range> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivText.Range deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            List optionalList = JsonPropertyParser.readOptionalList(context, data, "actions", this.component.getDivActionJsonEntityParser());
            Expression optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "alignment_vertical", DivTextRangeJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, DivTextAlignmentVertical.FROM_STRING);
            DivTextRangeBackground divTextRangeBackground = (DivTextRangeBackground) JsonPropertyParser.readOptional(context, data, J2.g, this.component.getDivTextRangeBackgroundJsonEntityParser());
            Expression<Double> optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, "baseline_offset", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivTextRangeJsonParser.BASELINE_OFFSET_DEFAULT_VALUE);
            if (optionalExpression2 == null) {
                optionalExpression2 = DivTextRangeJsonParser.BASELINE_OFFSET_DEFAULT_VALUE;
            }
            Expression<Double> expression = optionalExpression2;
            DivTextRangeBorder divTextRangeBorder = (DivTextRangeBorder) JsonPropertyParser.readOptional(context, data, OutlinedTextFieldKt.BorderId, this.component.getDivTextRangeBorderJsonEntityParser());
            Expression optionalExpression3 = JsonExpressionParser.readOptionalExpression(context, data, "end", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextRangeJsonParser.END_VALIDATOR);
            Expression<String> optionalExpression4 = JsonExpressionParser.readOptionalExpression(context, data, "font_family", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression<String> optionalExpression5 = JsonExpressionParser.readOptionalExpression(context, data, "font_feature_settings", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression optionalExpression6 = JsonExpressionParser.readOptionalExpression(context, data, ViewHierarchyConstants.TEXT_SIZE, TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextRangeJsonParser.FONT_SIZE_VALIDATOR);
            Expression<DivSizeUnit> optionalExpression7 = JsonExpressionParser.readOptionalExpression(context, data, "font_size_unit", DivTextRangeJsonParser.TYPE_HELPER_FONT_SIZE_UNIT, DivSizeUnit.FROM_STRING, DivTextRangeJsonParser.FONT_SIZE_UNIT_DEFAULT_VALUE);
            if (optionalExpression7 == null) {
                optionalExpression7 = DivTextRangeJsonParser.FONT_SIZE_UNIT_DEFAULT_VALUE;
            }
            Expression<DivSizeUnit> expression2 = optionalExpression7;
            Expression optionalExpression8 = JsonExpressionParser.readOptionalExpression(context, data, FontsContractCompat.Columns.WEIGHT, DivTextRangeJsonParser.TYPE_HELPER_FONT_WEIGHT, DivFontWeight.FROM_STRING);
            Expression optionalExpression9 = JsonExpressionParser.readOptionalExpression(context, data, "font_weight_value", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextRangeJsonParser.FONT_WEIGHT_VALUE_VALIDATOR);
            Expression optionalExpression10 = JsonExpressionParser.readOptionalExpression(context, data, "letter_spacing", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE);
            Expression optionalExpression11 = JsonExpressionParser.readOptionalExpression(context, data, "line_height", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextRangeJsonParser.LINE_HEIGHT_VALIDATOR);
            DivTextRangeMask divTextRangeMask = (DivTextRangeMask) JsonPropertyParser.readOptional(context, data, "mask", this.component.getDivTextRangeMaskJsonEntityParser());
            Expression<Long> optionalExpression12 = JsonExpressionParser.readOptionalExpression(context, data, "start", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextRangeJsonParser.START_VALIDATOR, DivTextRangeJsonParser.START_DEFAULT_VALUE);
            if (optionalExpression12 == null) {
                optionalExpression12 = DivTextRangeJsonParser.START_DEFAULT_VALUE;
            }
            return new DivText.Range(optionalList, optionalExpression, divTextRangeBackground, expression, divTextRangeBorder, optionalExpression3, optionalExpression4, optionalExpression5, optionalExpression6, expression2, optionalExpression8, optionalExpression9, optionalExpression10, optionalExpression11, divTextRangeMask, optionalExpression12, JsonExpressionParser.readOptionalExpression(context, data, "strike", DivTextRangeJsonParser.TYPE_HELPER_STRIKE, DivLineStyle.FROM_STRING), JsonExpressionParser.readOptionalExpression(context, data, "text_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT), (DivShadow) JsonPropertyParser.readOptional(context, data, "text_shadow", this.component.getDivShadowJsonEntityParser()), JsonExpressionParser.readOptionalExpression(context, data, "top_offset", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextRangeJsonParser.TOP_OFFSET_VALIDATOR), JsonExpressionParser.readOptionalExpression(context, data, "underline", DivTextRangeJsonParser.TYPE_HELPER_UNDERLINE, DivLineStyle.FROM_STRING));
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivText.Range value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonPropertyParser.writeList(context, jSONObject, "actions", value.actions, this.component.getDivActionJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "alignment_vertical", value.alignmentVertical, DivTextAlignmentVertical.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, J2.g, value.background, this.component.getDivTextRangeBackgroundJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "baseline_offset", value.baselineOffset);
            JsonPropertyParser.write(context, jSONObject, OutlinedTextFieldKt.BorderId, value.border, this.component.getDivTextRangeBorderJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "end", value.end);
            JsonExpressionParser.writeExpression(context, jSONObject, "font_family", value.fontFamily);
            JsonExpressionParser.writeExpression(context, jSONObject, "font_feature_settings", value.fontFeatureSettings);
            JsonExpressionParser.writeExpression(context, jSONObject, ViewHierarchyConstants.TEXT_SIZE, value.fontSize);
            JsonExpressionParser.writeExpression(context, jSONObject, "font_size_unit", value.fontSizeUnit, DivSizeUnit.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, FontsContractCompat.Columns.WEIGHT, value.fontWeight, DivFontWeight.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "font_weight_value", value.fontWeightValue);
            JsonExpressionParser.writeExpression(context, jSONObject, "letter_spacing", value.letterSpacing);
            JsonExpressionParser.writeExpression(context, jSONObject, "line_height", value.lineHeight);
            JsonPropertyParser.write(context, jSONObject, "mask", value.mask, this.component.getDivTextRangeMaskJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "start", value.start);
            JsonExpressionParser.writeExpression(context, jSONObject, "strike", value.strike, DivLineStyle.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "text_color", value.textColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "text_shadow", value.textShadow, this.component.getDivShadowJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "top_offset", value.topOffset);
            JsonExpressionParser.writeExpression(context, jSONObject, "underline", value.underline, DivLineStyle.TO_STRING);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivTextJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivTextRangeJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTextTemplate$RangeTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivTextTemplate.RangeTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivTextTemplate.RangeTemplate deserialize(ParsingContext context, DivTextTemplate.RangeTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalListField = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "actions", allowPropertyOverride, parent != null ? parent.actions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alignment_vertical", DivTextRangeJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, allowPropertyOverride, parent != null ? parent.alignmentVertical : null, DivTextAlignmentVertical.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…mentVertical.FROM_STRING)");
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, J2.g, allowPropertyOverride, parent != null ? parent.background : null, this.component.getDivTextRangeBackgroundJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex…groundJsonTemplateParser)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "baseline_offset", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.baselineOffset : null, ParsingConvertersKt.NUMBER_TO_DOUBLE);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…Offset, NUMBER_TO_DOUBLE)");
            Field optionalField2 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, OutlinedTextFieldKt.BorderId, allowPropertyOverride, parent != null ? parent.border : null, this.component.getDivTextRangeBorderJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField2, "readOptionalField(contex…BorderJsonTemplateParser)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "end", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.end : null, ParsingConvertersKt.NUMBER_TO_INT, DivTextRangeJsonParser.END_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…ER_TO_INT, END_VALIDATOR)");
            Field<Expression<String>> optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "font_family", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.fontFamily : null);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…ride, parent?.fontFamily)");
            Field<Expression<String>> optionalFieldWithExpression5 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "font_feature_settings", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.fontFeatureSettings : null);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression5, "readOptionalFieldWithExp…ent?.fontFeatureSettings)");
            Field optionalFieldWithExpression6 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, ViewHierarchyConstants.TEXT_SIZE, TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.fontSize : null, ParsingConvertersKt.NUMBER_TO_INT, DivTextRangeJsonParser.FONT_SIZE_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression6, "readOptionalFieldWithExp…INT, FONT_SIZE_VALIDATOR)");
            Field optionalFieldWithExpression7 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "font_size_unit", DivTextRangeJsonParser.TYPE_HELPER_FONT_SIZE_UNIT, allowPropertyOverride, parent != null ? parent.fontSizeUnit : null, DivSizeUnit.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression7, "readOptionalFieldWithExp… DivSizeUnit.FROM_STRING)");
            Field optionalFieldWithExpression8 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, FontsContractCompat.Columns.WEIGHT, DivTextRangeJsonParser.TYPE_HELPER_FONT_WEIGHT, allowPropertyOverride, parent != null ? parent.fontWeight : null, DivFontWeight.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression8, "readOptionalFieldWithExp…ivFontWeight.FROM_STRING)");
            Field optionalFieldWithExpression9 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "font_weight_value", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.fontWeightValue : null, ParsingConvertersKt.NUMBER_TO_INT, DivTextRangeJsonParser.FONT_WEIGHT_VALUE_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression9, "readOptionalFieldWithExp…T_WEIGHT_VALUE_VALIDATOR)");
            Field optionalFieldWithExpression10 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "letter_spacing", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.letterSpacing : null, ParsingConvertersKt.NUMBER_TO_DOUBLE);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression10, "readOptionalFieldWithExp…pacing, NUMBER_TO_DOUBLE)");
            Field optionalFieldWithExpression11 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "line_height", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.lineHeight : null, ParsingConvertersKt.NUMBER_TO_INT, DivTextRangeJsonParser.LINE_HEIGHT_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression11, "readOptionalFieldWithExp…T, LINE_HEIGHT_VALIDATOR)");
            Field optionalField3 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "mask", allowPropertyOverride, parent != null ? parent.mask : null, this.component.getDivTextRangeMaskJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField3, "readOptionalField(contex…geMaskJsonTemplateParser)");
            Field optionalFieldWithExpression12 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "start", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.start : null, ParsingConvertersKt.NUMBER_TO_INT, DivTextRangeJsonParser.START_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression12, "readOptionalFieldWithExp…_TO_INT, START_VALIDATOR)");
            Field optionalFieldWithExpression13 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "strike", DivTextRangeJsonParser.TYPE_HELPER_STRIKE, allowPropertyOverride, parent != null ? parent.strike : null, DivLineStyle.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression13, "readOptionalFieldWithExp…DivLineStyle.FROM_STRING)");
            Field optionalFieldWithExpression14 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "text_color", TypeHelpersKt.TYPE_HELPER_COLOR, allowPropertyOverride, parent != null ? parent.textColor : null, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression14, "readOptionalFieldWithExp…lor, STRING_TO_COLOR_INT)");
            Field optionalField4 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "text_shadow", allowPropertyOverride, parent != null ? parent.textShadow : null, this.component.getDivShadowJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField4, "readOptionalField(contex…ShadowJsonTemplateParser)");
            Field optionalFieldWithExpression15 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "top_offset", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.topOffset : null, ParsingConvertersKt.NUMBER_TO_INT, DivTextRangeJsonParser.TOP_OFFSET_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression15, "readOptionalFieldWithExp…NT, TOP_OFFSET_VALIDATOR)");
            Field optionalFieldWithExpression16 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "underline", DivTextRangeJsonParser.TYPE_HELPER_UNDERLINE, allowPropertyOverride, parent != null ? parent.underline : null, DivLineStyle.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression16, "readOptionalFieldWithExp…DivLineStyle.FROM_STRING)");
            return new DivTextTemplate.RangeTemplate(optionalListField, optionalFieldWithExpression, optionalField, optionalFieldWithExpression2, optionalField2, optionalFieldWithExpression3, optionalFieldWithExpression4, optionalFieldWithExpression5, optionalFieldWithExpression6, optionalFieldWithExpression7, optionalFieldWithExpression8, optionalFieldWithExpression9, optionalFieldWithExpression10, optionalFieldWithExpression11, optionalField3, optionalFieldWithExpression12, optionalFieldWithExpression13, optionalFieldWithExpression14, optionalField4, optionalFieldWithExpression15, optionalFieldWithExpression16);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivTextTemplate.RangeTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeListField(context, jSONObject, "actions", value.actions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "alignment_vertical", value.alignmentVertical, DivTextAlignmentVertical.TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, J2.g, value.background, this.component.getDivTextRangeBackgroundJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "baseline_offset", value.baselineOffset);
            JsonFieldParser.writeField(context, jSONObject, OutlinedTextFieldKt.BorderId, value.border, this.component.getDivTextRangeBorderJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "end", value.end);
            JsonFieldParser.writeExpressionField(context, jSONObject, "font_family", value.fontFamily);
            JsonFieldParser.writeExpressionField(context, jSONObject, "font_feature_settings", value.fontFeatureSettings);
            JsonFieldParser.writeExpressionField(context, jSONObject, ViewHierarchyConstants.TEXT_SIZE, value.fontSize);
            JsonFieldParser.writeExpressionField(context, jSONObject, "font_size_unit", value.fontSizeUnit, DivSizeUnit.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, FontsContractCompat.Columns.WEIGHT, value.fontWeight, DivFontWeight.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "font_weight_value", value.fontWeightValue);
            JsonFieldParser.writeExpressionField(context, jSONObject, "letter_spacing", value.letterSpacing);
            JsonFieldParser.writeExpressionField(context, jSONObject, "line_height", value.lineHeight);
            JsonFieldParser.writeField(context, jSONObject, "mask", value.mask, this.component.getDivTextRangeMaskJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "start", value.start);
            JsonFieldParser.writeExpressionField(context, jSONObject, "strike", value.strike, DivLineStyle.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "text_color", value.textColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "text_shadow", value.textShadow, this.component.getDivShadowJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "top_offset", value.topOffset);
            JsonFieldParser.writeExpressionField(context, jSONObject, "underline", value.underline, DivLineStyle.TO_STRING);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivTextJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivTextRangeJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTextTemplate$RangeTemplate;", "Lcom/yandex/div2/DivText$Range;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivTextTemplate.RangeTemplate, DivText.Range> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivText.Range resolve(ParsingContext context, DivTextTemplate.RangeTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            List listResolveOptionalList = JsonFieldResolver.resolveOptionalList(context, template.actions, data, "actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            Expression expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.alignmentVertical, data, "alignment_vertical", DivTextRangeJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, DivTextAlignmentVertical.FROM_STRING);
            DivTextRangeBackground divTextRangeBackground = (DivTextRangeBackground) JsonFieldResolver.resolveOptional(context, template.background, data, J2.g, this.component.getDivTextRangeBackgroundJsonTemplateResolver(), this.component.getDivTextRangeBackgroundJsonEntityParser());
            Expression<Double> expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.baselineOffset, data, "baseline_offset", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivTextRangeJsonParser.BASELINE_OFFSET_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression2 == null) {
                expressionResolveOptionalExpression2 = DivTextRangeJsonParser.BASELINE_OFFSET_DEFAULT_VALUE;
            }
            Expression<Double> expression = expressionResolveOptionalExpression2;
            DivTextRangeBorder divTextRangeBorder = (DivTextRangeBorder) JsonFieldResolver.resolveOptional(context, template.border, data, OutlinedTextFieldKt.BorderId, this.component.getDivTextRangeBorderJsonTemplateResolver(), this.component.getDivTextRangeBorderJsonEntityParser());
            Expression expressionResolveOptionalExpression3 = JsonFieldResolver.resolveOptionalExpression(context, template.end, data, "end", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextRangeJsonParser.END_VALIDATOR);
            Expression expressionResolveOptionalExpression4 = JsonFieldResolver.resolveOptionalExpression(context, template.fontFamily, data, "font_family", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression expressionResolveOptionalExpression5 = JsonFieldResolver.resolveOptionalExpression(context, template.fontFeatureSettings, data, "font_feature_settings", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression expressionResolveOptionalExpression6 = JsonFieldResolver.resolveOptionalExpression(context, template.fontSize, data, ViewHierarchyConstants.TEXT_SIZE, TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextRangeJsonParser.FONT_SIZE_VALIDATOR);
            Expression<DivSizeUnit> expressionResolveOptionalExpression7 = JsonFieldResolver.resolveOptionalExpression(context, template.fontSizeUnit, data, "font_size_unit", DivTextRangeJsonParser.TYPE_HELPER_FONT_SIZE_UNIT, DivSizeUnit.FROM_STRING, DivTextRangeJsonParser.FONT_SIZE_UNIT_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression7 == null) {
                expressionResolveOptionalExpression7 = DivTextRangeJsonParser.FONT_SIZE_UNIT_DEFAULT_VALUE;
            }
            Expression<DivSizeUnit> expression2 = expressionResolveOptionalExpression7;
            Expression expressionResolveOptionalExpression8 = JsonFieldResolver.resolveOptionalExpression(context, template.fontWeight, data, FontsContractCompat.Columns.WEIGHT, DivTextRangeJsonParser.TYPE_HELPER_FONT_WEIGHT, DivFontWeight.FROM_STRING);
            Expression expressionResolveOptionalExpression9 = JsonFieldResolver.resolveOptionalExpression(context, template.fontWeightValue, data, "font_weight_value", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextRangeJsonParser.FONT_WEIGHT_VALUE_VALIDATOR);
            Expression expressionResolveOptionalExpression10 = JsonFieldResolver.resolveOptionalExpression(context, template.letterSpacing, data, "letter_spacing", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE);
            Expression expressionResolveOptionalExpression11 = JsonFieldResolver.resolveOptionalExpression(context, template.lineHeight, data, "line_height", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextRangeJsonParser.LINE_HEIGHT_VALIDATOR);
            DivTextRangeMask divTextRangeMask = (DivTextRangeMask) JsonFieldResolver.resolveOptional(context, template.mask, data, "mask", this.component.getDivTextRangeMaskJsonTemplateResolver(), this.component.getDivTextRangeMaskJsonEntityParser());
            Expression<Long> expressionResolveOptionalExpression12 = JsonFieldResolver.resolveOptionalExpression(context, template.start, data, "start", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextRangeJsonParser.START_VALIDATOR, DivTextRangeJsonParser.START_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression12 == null) {
                expressionResolveOptionalExpression12 = DivTextRangeJsonParser.START_DEFAULT_VALUE;
            }
            return new DivText.Range(listResolveOptionalList, expressionResolveOptionalExpression, divTextRangeBackground, expression, divTextRangeBorder, expressionResolveOptionalExpression3, expressionResolveOptionalExpression4, expressionResolveOptionalExpression5, expressionResolveOptionalExpression6, expression2, expressionResolveOptionalExpression8, expressionResolveOptionalExpression9, expressionResolveOptionalExpression10, expressionResolveOptionalExpression11, divTextRangeMask, expressionResolveOptionalExpression12, JsonFieldResolver.resolveOptionalExpression(context, template.strike, data, "strike", DivTextRangeJsonParser.TYPE_HELPER_STRIKE, DivLineStyle.FROM_STRING), JsonFieldResolver.resolveOptionalExpression(context, template.textColor, data, "text_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT), (DivShadow) JsonFieldResolver.resolveOptional(context, template.textShadow, data, "text_shadow", this.component.getDivShadowJsonTemplateResolver(), this.component.getDivShadowJsonEntityParser()), JsonFieldResolver.resolveOptionalExpression(context, template.topOffset, data, "top_offset", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextRangeJsonParser.TOP_OFFSET_VALIDATOR), JsonFieldResolver.resolveOptionalExpression(context, template.underline, data, "underline", DivTextRangeJsonParser.TYPE_HELPER_UNDERLINE, DivLineStyle.FROM_STRING));
        }
    }

    /* JADX INFO: compiled from: DivTextJsonParser.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00128\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00128\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00128\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00128\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/yandex/div2/DivTextRangeJsonParser$Companion;", "", "()V", "BASELINE_OFFSET_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "END_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "", "FONT_SIZE_UNIT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSizeUnit;", "FONT_SIZE_VALIDATOR", "FONT_WEIGHT_VALUE_VALIDATOR", "LINE_HEIGHT_VALIDATOR", "START_DEFAULT_VALUE", "START_VALIDATOR", "TOP_OFFSET_VALIDATOR", "TYPE_HELPER_ALIGNMENT_VERTICAL", "Lcom/yandex/div/internal/parser/TypeHelper;", "Lcom/yandex/div2/DivTextAlignmentVertical;", "TYPE_HELPER_FONT_SIZE_UNIT", "TYPE_HELPER_FONT_WEIGHT", "Lcom/yandex/div2/DivFontWeight;", "TYPE_HELPER_STRIKE", "Lcom/yandex/div2/DivLineStyle;", "TYPE_HELPER_UNDERLINE", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
