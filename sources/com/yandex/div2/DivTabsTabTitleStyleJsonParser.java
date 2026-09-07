package com.yandex.div2;

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
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivTabsJsonParser.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivTabsTabTitleStyleJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivTabsTabTitleStyleJsonParser {
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<Integer> ACTIVE_BACKGROUND_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(-9120);

    @Deprecated
    public static final Expression<Integer> ACTIVE_TEXT_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(-872415232);

    @Deprecated
    public static final Expression<Long> ANIMATION_DURATION_DEFAULT_VALUE = Expression.INSTANCE.constant(300L);

    @Deprecated
    public static final Expression<DivTabs.TabTitleStyle.AnimationType> ANIMATION_TYPE_DEFAULT_VALUE = Expression.INSTANCE.constant(DivTabs.TabTitleStyle.AnimationType.SLIDE);

    @Deprecated
    public static final Expression<Long> FONT_SIZE_DEFAULT_VALUE = Expression.INSTANCE.constant(12L);

    @Deprecated
    public static final Expression<DivSizeUnit> FONT_SIZE_UNIT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivSizeUnit.SP);

    @Deprecated
    public static final Expression<DivFontWeight> FONT_WEIGHT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivFontWeight.REGULAR);

    @Deprecated
    public static final Expression<Integer> INACTIVE_TEXT_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(Integer.MIN_VALUE);

    @Deprecated
    public static final Expression<Long> ITEM_SPACING_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);

    @Deprecated
    public static final Expression<Double> LETTER_SPACING_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(0.0d));

    @Deprecated
    public static final DivEdgeInsets PADDINGS_DEFAULT_VALUE = new DivEdgeInsets(Expression.INSTANCE.constant(6L), null, Expression.INSTANCE.constant(8L), Expression.INSTANCE.constant(8L), null, Expression.INSTANCE.constant(6L), null, 82, null);

    @Deprecated
    public static final TypeHelper<DivFontWeight> TYPE_HELPER_ACTIVE_FONT_WEIGHT = TypeHelper.INSTANCE.from(ArraysKt.first(DivFontWeight.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTabsTabTitleStyleJsonParser$Companion$TYPE_HELPER_ACTIVE_FONT_WEIGHT$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivFontWeight);
        }
    });

    @Deprecated
    public static final TypeHelper<DivTabs.TabTitleStyle.AnimationType> TYPE_HELPER_ANIMATION_TYPE = TypeHelper.INSTANCE.from(ArraysKt.first(DivTabs.TabTitleStyle.AnimationType.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTabsTabTitleStyleJsonParser$Companion$TYPE_HELPER_ANIMATION_TYPE$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivTabs.TabTitleStyle.AnimationType);
        }
    });

    @Deprecated
    public static final TypeHelper<DivSizeUnit> TYPE_HELPER_FONT_SIZE_UNIT = TypeHelper.INSTANCE.from(ArraysKt.first(DivSizeUnit.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTabsTabTitleStyleJsonParser$Companion$TYPE_HELPER_FONT_SIZE_UNIT$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivSizeUnit);
        }
    });

    @Deprecated
    public static final TypeHelper<DivFontWeight> TYPE_HELPER_FONT_WEIGHT = TypeHelper.INSTANCE.from(ArraysKt.first(DivFontWeight.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTabsTabTitleStyleJsonParser$Companion$TYPE_HELPER_FONT_WEIGHT$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivFontWeight);
        }
    });

    @Deprecated
    public static final TypeHelper<DivFontWeight> TYPE_HELPER_INACTIVE_FONT_WEIGHT = TypeHelper.INSTANCE.from(ArraysKt.first(DivFontWeight.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTabsTabTitleStyleJsonParser$Companion$TYPE_HELPER_INACTIVE_FONT_WEIGHT$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivFontWeight);
        }
    });

    @Deprecated
    public static final ValueValidator<Long> ANIMATION_DURATION_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTabsTabTitleStyleJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivTabsTabTitleStyleJsonParser.ANIMATION_DURATION_VALIDATOR$lambda$0(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> CORNER_RADIUS_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTabsTabTitleStyleJsonParser$$ExternalSyntheticLambda1
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivTabsTabTitleStyleJsonParser.CORNER_RADIUS_VALIDATOR$lambda$1(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> FONT_SIZE_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTabsTabTitleStyleJsonParser$$ExternalSyntheticLambda2
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivTabsTabTitleStyleJsonParser.FONT_SIZE_VALIDATOR$lambda$2(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> ITEM_SPACING_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTabsTabTitleStyleJsonParser$$ExternalSyntheticLambda3
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivTabsTabTitleStyleJsonParser.ITEM_SPACING_VALIDATOR$lambda$3(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> LINE_HEIGHT_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTabsTabTitleStyleJsonParser$$ExternalSyntheticLambda4
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivTabsTabTitleStyleJsonParser.LINE_HEIGHT_VALIDATOR$lambda$4(((Long) obj).longValue());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ANIMATION_DURATION_VALIDATOR$lambda$0(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CORNER_RADIUS_VALIDATOR$lambda$1(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FONT_SIZE_VALIDATOR$lambda$2(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ITEM_SPACING_VALIDATOR$lambda$3(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LINE_HEIGHT_VALIDATOR$lambda$4(long j) {
        return j >= 0;
    }

    public DivTabsTabTitleStyleJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivTabsJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivTabsTabTitleStyleJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTabs$TabTitleStyle;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivTabs.TabTitleStyle> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivTabs.TabTitleStyle deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression<Integer> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "active_background_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT, DivTabsTabTitleStyleJsonParser.ACTIVE_BACKGROUND_COLOR_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivTabsTabTitleStyleJsonParser.ACTIVE_BACKGROUND_COLOR_DEFAULT_VALUE;
            }
            Expression<Integer> expression = optionalExpression;
            Expression optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, "active_font_weight", DivTabsTabTitleStyleJsonParser.TYPE_HELPER_ACTIVE_FONT_WEIGHT, DivFontWeight.FROM_STRING);
            Expression<Integer> optionalExpression3 = JsonExpressionParser.readOptionalExpression(context, data, "active_text_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT, DivTabsTabTitleStyleJsonParser.ACTIVE_TEXT_COLOR_DEFAULT_VALUE);
            if (optionalExpression3 == null) {
                optionalExpression3 = DivTabsTabTitleStyleJsonParser.ACTIVE_TEXT_COLOR_DEFAULT_VALUE;
            }
            Expression<Integer> expression2 = optionalExpression3;
            Expression<Long> optionalExpression4 = JsonExpressionParser.readOptionalExpression(context, data, "animation_duration", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTabsTabTitleStyleJsonParser.ANIMATION_DURATION_VALIDATOR, DivTabsTabTitleStyleJsonParser.ANIMATION_DURATION_DEFAULT_VALUE);
            if (optionalExpression4 == null) {
                optionalExpression4 = DivTabsTabTitleStyleJsonParser.ANIMATION_DURATION_DEFAULT_VALUE;
            }
            Expression<Long> expression3 = optionalExpression4;
            Expression<DivTabs.TabTitleStyle.AnimationType> optionalExpression5 = JsonExpressionParser.readOptionalExpression(context, data, "animation_type", DivTabsTabTitleStyleJsonParser.TYPE_HELPER_ANIMATION_TYPE, DivTabs.TabTitleStyle.AnimationType.FROM_STRING, DivTabsTabTitleStyleJsonParser.ANIMATION_TYPE_DEFAULT_VALUE);
            if (optionalExpression5 == null) {
                optionalExpression5 = DivTabsTabTitleStyleJsonParser.ANIMATION_TYPE_DEFAULT_VALUE;
            }
            Expression<DivTabs.TabTitleStyle.AnimationType> expression4 = optionalExpression5;
            Expression optionalExpression6 = JsonExpressionParser.readOptionalExpression(context, data, "corner_radius", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTabsTabTitleStyleJsonParser.CORNER_RADIUS_VALIDATOR);
            DivCornersRadius divCornersRadius = (DivCornersRadius) JsonPropertyParser.readOptional(context, data, "corners_radius", this.component.getDivCornersRadiusJsonEntityParser());
            Expression<String> optionalExpression7 = JsonExpressionParser.readOptionalExpression(context, data, "font_family", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression<Long> optionalExpression8 = JsonExpressionParser.readOptionalExpression(context, data, ViewHierarchyConstants.TEXT_SIZE, TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTabsTabTitleStyleJsonParser.FONT_SIZE_VALIDATOR, DivTabsTabTitleStyleJsonParser.FONT_SIZE_DEFAULT_VALUE);
            if (optionalExpression8 == null) {
                optionalExpression8 = DivTabsTabTitleStyleJsonParser.FONT_SIZE_DEFAULT_VALUE;
            }
            Expression<Long> expression5 = optionalExpression8;
            Expression<DivSizeUnit> optionalExpression9 = JsonExpressionParser.readOptionalExpression(context, data, "font_size_unit", DivTabsTabTitleStyleJsonParser.TYPE_HELPER_FONT_SIZE_UNIT, DivSizeUnit.FROM_STRING, DivTabsTabTitleStyleJsonParser.FONT_SIZE_UNIT_DEFAULT_VALUE);
            if (optionalExpression9 == null) {
                optionalExpression9 = DivTabsTabTitleStyleJsonParser.FONT_SIZE_UNIT_DEFAULT_VALUE;
            }
            Expression<DivSizeUnit> expression6 = optionalExpression9;
            Expression<DivFontWeight> optionalExpression10 = JsonExpressionParser.readOptionalExpression(context, data, FontsContractCompat.Columns.WEIGHT, DivTabsTabTitleStyleJsonParser.TYPE_HELPER_FONT_WEIGHT, DivFontWeight.FROM_STRING, DivTabsTabTitleStyleJsonParser.FONT_WEIGHT_DEFAULT_VALUE);
            if (optionalExpression10 == null) {
                optionalExpression10 = DivTabsTabTitleStyleJsonParser.FONT_WEIGHT_DEFAULT_VALUE;
            }
            Expression<DivFontWeight> expression7 = optionalExpression10;
            Expression optionalExpression11 = JsonExpressionParser.readOptionalExpression(context, data, "inactive_background_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Expression optionalExpression12 = JsonExpressionParser.readOptionalExpression(context, data, "inactive_font_weight", DivTabsTabTitleStyleJsonParser.TYPE_HELPER_INACTIVE_FONT_WEIGHT, DivFontWeight.FROM_STRING);
            Expression<Integer> optionalExpression13 = JsonExpressionParser.readOptionalExpression(context, data, "inactive_text_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT, DivTabsTabTitleStyleJsonParser.INACTIVE_TEXT_COLOR_DEFAULT_VALUE);
            if (optionalExpression13 == null) {
                optionalExpression13 = DivTabsTabTitleStyleJsonParser.INACTIVE_TEXT_COLOR_DEFAULT_VALUE;
            }
            Expression<Integer> expression8 = optionalExpression13;
            Expression<Long> optionalExpression14 = JsonExpressionParser.readOptionalExpression(context, data, "item_spacing", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTabsTabTitleStyleJsonParser.ITEM_SPACING_VALIDATOR, DivTabsTabTitleStyleJsonParser.ITEM_SPACING_DEFAULT_VALUE);
            if (optionalExpression14 == null) {
                optionalExpression14 = DivTabsTabTitleStyleJsonParser.ITEM_SPACING_DEFAULT_VALUE;
            }
            Expression<Long> expression9 = optionalExpression14;
            Expression<Double> optionalExpression15 = JsonExpressionParser.readOptionalExpression(context, data, "letter_spacing", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivTabsTabTitleStyleJsonParser.LETTER_SPACING_DEFAULT_VALUE);
            if (optionalExpression15 == null) {
                optionalExpression15 = DivTabsTabTitleStyleJsonParser.LETTER_SPACING_DEFAULT_VALUE;
            }
            Expression<Double> expression10 = optionalExpression15;
            Expression optionalExpression16 = JsonExpressionParser.readOptionalExpression(context, data, "line_height", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTabsTabTitleStyleJsonParser.LINE_HEIGHT_VALIDATOR);
            DivEdgeInsets divEdgeInsets = (DivEdgeInsets) JsonPropertyParser.readOptional(context, data, "paddings", this.component.getDivEdgeInsetsJsonEntityParser());
            if (divEdgeInsets == null) {
                divEdgeInsets = DivTabsTabTitleStyleJsonParser.PADDINGS_DEFAULT_VALUE;
            }
            DivEdgeInsets divEdgeInsets2 = divEdgeInsets;
            Intrinsics.checkNotNullExpressionValue(divEdgeInsets2, "JsonPropertyParser.readO…?: PADDINGS_DEFAULT_VALUE");
            return new DivTabs.TabTitleStyle(expression, optionalExpression2, expression2, expression3, expression4, optionalExpression6, divCornersRadius, optionalExpression7, expression5, expression6, expression7, optionalExpression11, optionalExpression12, expression8, expression9, expression10, optionalExpression16, divEdgeInsets2);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivTabs.TabTitleStyle value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonExpressionParser.writeExpression(context, jSONObject, "active_background_color", value.activeBackgroundColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "active_font_weight", value.activeFontWeight, DivFontWeight.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "active_text_color", value.activeTextColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "animation_duration", value.animationDuration);
            JsonExpressionParser.writeExpression(context, jSONObject, "animation_type", value.animationType, DivTabs.TabTitleStyle.AnimationType.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "corner_radius", value.cornerRadius);
            JsonPropertyParser.write(context, jSONObject, "corners_radius", value.cornersRadius, this.component.getDivCornersRadiusJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "font_family", value.fontFamily);
            JsonExpressionParser.writeExpression(context, jSONObject, ViewHierarchyConstants.TEXT_SIZE, value.fontSize);
            JsonExpressionParser.writeExpression(context, jSONObject, "font_size_unit", value.fontSizeUnit, DivSizeUnit.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, FontsContractCompat.Columns.WEIGHT, value.fontWeight, DivFontWeight.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "inactive_background_color", value.inactiveBackgroundColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "inactive_font_weight", value.inactiveFontWeight, DivFontWeight.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "inactive_text_color", value.inactiveTextColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "item_spacing", value.itemSpacing);
            JsonExpressionParser.writeExpression(context, jSONObject, "letter_spacing", value.letterSpacing);
            JsonExpressionParser.writeExpression(context, jSONObject, "line_height", value.lineHeight);
            JsonPropertyParser.write(context, jSONObject, "paddings", value.paddings, this.component.getDivEdgeInsetsJsonEntityParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivTabsJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivTabsTabTitleStyleJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTabsTemplate$TabTitleStyleTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivTabsTemplate.TabTitleStyleTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivTabsTemplate.TabTitleStyleTemplate deserialize(ParsingContext context, DivTabsTemplate.TabTitleStyleTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "active_background_color", TypeHelpersKt.TYPE_HELPER_COLOR, allowPropertyOverride, parent != null ? parent.activeBackgroundColor : null, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…lor, STRING_TO_COLOR_INT)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "active_font_weight", DivTabsTabTitleStyleJsonParser.TYPE_HELPER_ACTIVE_FONT_WEIGHT, allowPropertyOverride, parent != null ? parent.activeFontWeight : null, DivFontWeight.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…ivFontWeight.FROM_STRING)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "active_text_color", TypeHelpersKt.TYPE_HELPER_COLOR, allowPropertyOverride, parent != null ? parent.activeTextColor : null, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…lor, STRING_TO_COLOR_INT)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "animation_duration", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.animationDuration : null, ParsingConvertersKt.NUMBER_TO_INT, DivTabsTabTitleStyleJsonParser.ANIMATION_DURATION_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…ATION_DURATION_VALIDATOR)");
            Field optionalFieldWithExpression5 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "animation_type", DivTabsTabTitleStyleJsonParser.TYPE_HELPER_ANIMATION_TYPE, allowPropertyOverride, parent != null ? parent.animationType : null, DivTabs.TabTitleStyle.AnimationType.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression5, "readOptionalFieldWithExp…nimationType.FROM_STRING)");
            Field optionalFieldWithExpression6 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "corner_radius", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.cornerRadius : null, ParsingConvertersKt.NUMBER_TO_INT, DivTabsTabTitleStyleJsonParser.CORNER_RADIUS_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression6, "readOptionalFieldWithExp… CORNER_RADIUS_VALIDATOR)");
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "corners_radius", allowPropertyOverride, parent != null ? parent.cornersRadius : null, this.component.getDivCornersRadiusJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex…RadiusJsonTemplateParser)");
            Field<Expression<String>> optionalFieldWithExpression7 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "font_family", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.fontFamily : null);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression7, "readOptionalFieldWithExp…ride, parent?.fontFamily)");
            Field optionalFieldWithExpression8 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, ViewHierarchyConstants.TEXT_SIZE, TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.fontSize : null, ParsingConvertersKt.NUMBER_TO_INT, DivTabsTabTitleStyleJsonParser.FONT_SIZE_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression8, "readOptionalFieldWithExp…INT, FONT_SIZE_VALIDATOR)");
            Field optionalFieldWithExpression9 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "font_size_unit", DivTabsTabTitleStyleJsonParser.TYPE_HELPER_FONT_SIZE_UNIT, allowPropertyOverride, parent != null ? parent.fontSizeUnit : null, DivSizeUnit.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression9, "readOptionalFieldWithExp… DivSizeUnit.FROM_STRING)");
            Field optionalFieldWithExpression10 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, FontsContractCompat.Columns.WEIGHT, DivTabsTabTitleStyleJsonParser.TYPE_HELPER_FONT_WEIGHT, allowPropertyOverride, parent != null ? parent.fontWeight : null, DivFontWeight.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression10, "readOptionalFieldWithExp…ivFontWeight.FROM_STRING)");
            Field optionalFieldWithExpression11 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "inactive_background_color", TypeHelpersKt.TYPE_HELPER_COLOR, allowPropertyOverride, parent != null ? parent.inactiveBackgroundColor : null, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression11, "readOptionalFieldWithExp…lor, STRING_TO_COLOR_INT)");
            Field optionalFieldWithExpression12 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "inactive_font_weight", DivTabsTabTitleStyleJsonParser.TYPE_HELPER_INACTIVE_FONT_WEIGHT, allowPropertyOverride, parent != null ? parent.inactiveFontWeight : null, DivFontWeight.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression12, "readOptionalFieldWithExp…ivFontWeight.FROM_STRING)");
            Field optionalFieldWithExpression13 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "inactive_text_color", TypeHelpersKt.TYPE_HELPER_COLOR, allowPropertyOverride, parent != null ? parent.inactiveTextColor : null, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression13, "readOptionalFieldWithExp…lor, STRING_TO_COLOR_INT)");
            Field optionalFieldWithExpression14 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "item_spacing", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.itemSpacing : null, ParsingConvertersKt.NUMBER_TO_INT, DivTabsTabTitleStyleJsonParser.ITEM_SPACING_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression14, "readOptionalFieldWithExp…, ITEM_SPACING_VALIDATOR)");
            Field optionalFieldWithExpression15 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "letter_spacing", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.letterSpacing : null, ParsingConvertersKt.NUMBER_TO_DOUBLE);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression15, "readOptionalFieldWithExp…pacing, NUMBER_TO_DOUBLE)");
            Field optionalFieldWithExpression16 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "line_height", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.lineHeight : null, ParsingConvertersKt.NUMBER_TO_INT, DivTabsTabTitleStyleJsonParser.LINE_HEIGHT_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression16, "readOptionalFieldWithExp…T, LINE_HEIGHT_VALIDATOR)");
            Field optionalField2 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "paddings", allowPropertyOverride, parent != null ? parent.paddings : null, this.component.getDivEdgeInsetsJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField2, "readOptionalField(contex…InsetsJsonTemplateParser)");
            return new DivTabsTemplate.TabTitleStyleTemplate(optionalFieldWithExpression, optionalFieldWithExpression2, optionalFieldWithExpression3, optionalFieldWithExpression4, optionalFieldWithExpression5, optionalFieldWithExpression6, optionalField, optionalFieldWithExpression7, optionalFieldWithExpression8, optionalFieldWithExpression9, optionalFieldWithExpression10, optionalFieldWithExpression11, optionalFieldWithExpression12, optionalFieldWithExpression13, optionalFieldWithExpression14, optionalFieldWithExpression15, optionalFieldWithExpression16, optionalField2);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivTabsTemplate.TabTitleStyleTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeExpressionField(context, jSONObject, "active_background_color", value.activeBackgroundColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "active_font_weight", value.activeFontWeight, DivFontWeight.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "active_text_color", value.activeTextColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "animation_duration", value.animationDuration);
            JsonFieldParser.writeExpressionField(context, jSONObject, "animation_type", value.animationType, DivTabs.TabTitleStyle.AnimationType.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "corner_radius", value.cornerRadius);
            JsonFieldParser.writeField(context, jSONObject, "corners_radius", value.cornersRadius, this.component.getDivCornersRadiusJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "font_family", value.fontFamily);
            JsonFieldParser.writeExpressionField(context, jSONObject, ViewHierarchyConstants.TEXT_SIZE, value.fontSize);
            JsonFieldParser.writeExpressionField(context, jSONObject, "font_size_unit", value.fontSizeUnit, DivSizeUnit.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, FontsContractCompat.Columns.WEIGHT, value.fontWeight, DivFontWeight.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "inactive_background_color", value.inactiveBackgroundColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "inactive_font_weight", value.inactiveFontWeight, DivFontWeight.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "inactive_text_color", value.inactiveTextColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "item_spacing", value.itemSpacing);
            JsonFieldParser.writeExpressionField(context, jSONObject, "letter_spacing", value.letterSpacing);
            JsonFieldParser.writeExpressionField(context, jSONObject, "line_height", value.lineHeight);
            JsonFieldParser.writeField(context, jSONObject, "paddings", value.paddings, this.component.getDivEdgeInsetsJsonTemplateParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivTabsJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivTabsTabTitleStyleJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTabsTemplate$TabTitleStyleTemplate;", "Lcom/yandex/div2/DivTabs$TabTitleStyle;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivTabsTemplate.TabTitleStyleTemplate, DivTabs.TabTitleStyle> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivTabs.TabTitleStyle resolve(ParsingContext context, DivTabsTemplate.TabTitleStyleTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression<Integer> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.activeBackgroundColor, data, "active_background_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT, DivTabsTabTitleStyleJsonParser.ACTIVE_BACKGROUND_COLOR_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivTabsTabTitleStyleJsonParser.ACTIVE_BACKGROUND_COLOR_DEFAULT_VALUE;
            }
            Expression<Integer> expression = expressionResolveOptionalExpression;
            Expression expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.activeFontWeight, data, "active_font_weight", DivTabsTabTitleStyleJsonParser.TYPE_HELPER_ACTIVE_FONT_WEIGHT, DivFontWeight.FROM_STRING);
            Expression<Integer> expressionResolveOptionalExpression3 = JsonFieldResolver.resolveOptionalExpression(context, template.activeTextColor, data, "active_text_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT, DivTabsTabTitleStyleJsonParser.ACTIVE_TEXT_COLOR_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression3 == null) {
                expressionResolveOptionalExpression3 = DivTabsTabTitleStyleJsonParser.ACTIVE_TEXT_COLOR_DEFAULT_VALUE;
            }
            Expression<Integer> expression2 = expressionResolveOptionalExpression3;
            Expression<Long> expressionResolveOptionalExpression4 = JsonFieldResolver.resolveOptionalExpression(context, template.animationDuration, data, "animation_duration", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTabsTabTitleStyleJsonParser.ANIMATION_DURATION_VALIDATOR, DivTabsTabTitleStyleJsonParser.ANIMATION_DURATION_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression4 == null) {
                expressionResolveOptionalExpression4 = DivTabsTabTitleStyleJsonParser.ANIMATION_DURATION_DEFAULT_VALUE;
            }
            Expression<Long> expression3 = expressionResolveOptionalExpression4;
            Expression<DivTabs.TabTitleStyle.AnimationType> expressionResolveOptionalExpression5 = JsonFieldResolver.resolveOptionalExpression(context, template.animationType, data, "animation_type", DivTabsTabTitleStyleJsonParser.TYPE_HELPER_ANIMATION_TYPE, DivTabs.TabTitleStyle.AnimationType.FROM_STRING, DivTabsTabTitleStyleJsonParser.ANIMATION_TYPE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression5 == null) {
                expressionResolveOptionalExpression5 = DivTabsTabTitleStyleJsonParser.ANIMATION_TYPE_DEFAULT_VALUE;
            }
            Expression<DivTabs.TabTitleStyle.AnimationType> expression4 = expressionResolveOptionalExpression5;
            Expression expressionResolveOptionalExpression6 = JsonFieldResolver.resolveOptionalExpression(context, template.cornerRadius, data, "corner_radius", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTabsTabTitleStyleJsonParser.CORNER_RADIUS_VALIDATOR);
            DivCornersRadius divCornersRadius = (DivCornersRadius) JsonFieldResolver.resolveOptional(context, template.cornersRadius, data, "corners_radius", this.component.getDivCornersRadiusJsonTemplateResolver(), this.component.getDivCornersRadiusJsonEntityParser());
            Expression expressionResolveOptionalExpression7 = JsonFieldResolver.resolveOptionalExpression(context, template.fontFamily, data, "font_family", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression<Long> expressionResolveOptionalExpression8 = JsonFieldResolver.resolveOptionalExpression(context, template.fontSize, data, ViewHierarchyConstants.TEXT_SIZE, TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTabsTabTitleStyleJsonParser.FONT_SIZE_VALIDATOR, DivTabsTabTitleStyleJsonParser.FONT_SIZE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression8 == null) {
                expressionResolveOptionalExpression8 = DivTabsTabTitleStyleJsonParser.FONT_SIZE_DEFAULT_VALUE;
            }
            Expression<Long> expression5 = expressionResolveOptionalExpression8;
            Expression<DivSizeUnit> expressionResolveOptionalExpression9 = JsonFieldResolver.resolveOptionalExpression(context, template.fontSizeUnit, data, "font_size_unit", DivTabsTabTitleStyleJsonParser.TYPE_HELPER_FONT_SIZE_UNIT, DivSizeUnit.FROM_STRING, DivTabsTabTitleStyleJsonParser.FONT_SIZE_UNIT_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression9 == null) {
                expressionResolveOptionalExpression9 = DivTabsTabTitleStyleJsonParser.FONT_SIZE_UNIT_DEFAULT_VALUE;
            }
            Expression<DivSizeUnit> expression6 = expressionResolveOptionalExpression9;
            Expression<DivFontWeight> expressionResolveOptionalExpression10 = JsonFieldResolver.resolveOptionalExpression(context, template.fontWeight, data, FontsContractCompat.Columns.WEIGHT, DivTabsTabTitleStyleJsonParser.TYPE_HELPER_FONT_WEIGHT, DivFontWeight.FROM_STRING, DivTabsTabTitleStyleJsonParser.FONT_WEIGHT_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression10 == null) {
                expressionResolveOptionalExpression10 = DivTabsTabTitleStyleJsonParser.FONT_WEIGHT_DEFAULT_VALUE;
            }
            Expression<DivFontWeight> expression7 = expressionResolveOptionalExpression10;
            Expression expressionResolveOptionalExpression11 = JsonFieldResolver.resolveOptionalExpression(context, template.inactiveBackgroundColor, data, "inactive_background_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Expression expressionResolveOptionalExpression12 = JsonFieldResolver.resolveOptionalExpression(context, template.inactiveFontWeight, data, "inactive_font_weight", DivTabsTabTitleStyleJsonParser.TYPE_HELPER_INACTIVE_FONT_WEIGHT, DivFontWeight.FROM_STRING);
            Expression<Integer> expressionResolveOptionalExpression13 = JsonFieldResolver.resolveOptionalExpression(context, template.inactiveTextColor, data, "inactive_text_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT, DivTabsTabTitleStyleJsonParser.INACTIVE_TEXT_COLOR_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression13 == null) {
                expressionResolveOptionalExpression13 = DivTabsTabTitleStyleJsonParser.INACTIVE_TEXT_COLOR_DEFAULT_VALUE;
            }
            Expression<Integer> expression8 = expressionResolveOptionalExpression13;
            Expression<Long> expressionResolveOptionalExpression14 = JsonFieldResolver.resolveOptionalExpression(context, template.itemSpacing, data, "item_spacing", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTabsTabTitleStyleJsonParser.ITEM_SPACING_VALIDATOR, DivTabsTabTitleStyleJsonParser.ITEM_SPACING_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression14 == null) {
                expressionResolveOptionalExpression14 = DivTabsTabTitleStyleJsonParser.ITEM_SPACING_DEFAULT_VALUE;
            }
            Expression<Long> expression9 = expressionResolveOptionalExpression14;
            Expression<Double> expressionResolveOptionalExpression15 = JsonFieldResolver.resolveOptionalExpression(context, template.letterSpacing, data, "letter_spacing", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivTabsTabTitleStyleJsonParser.LETTER_SPACING_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression15 == null) {
                expressionResolveOptionalExpression15 = DivTabsTabTitleStyleJsonParser.LETTER_SPACING_DEFAULT_VALUE;
            }
            Expression<Double> expression10 = expressionResolveOptionalExpression15;
            Expression expressionResolveOptionalExpression16 = JsonFieldResolver.resolveOptionalExpression(context, template.lineHeight, data, "line_height", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTabsTabTitleStyleJsonParser.LINE_HEIGHT_VALIDATOR);
            DivEdgeInsets divEdgeInsets = (DivEdgeInsets) JsonFieldResolver.resolveOptional(context, template.paddings, data, "paddings", this.component.getDivEdgeInsetsJsonTemplateResolver(), this.component.getDivEdgeInsetsJsonEntityParser());
            if (divEdgeInsets == null) {
                divEdgeInsets = DivTabsTabTitleStyleJsonParser.PADDINGS_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(divEdgeInsets, "JsonFieldResolver.resolv…?: PADDINGS_DEFAULT_VALUE");
            return new DivTabs.TabTitleStyle(expression, expressionResolveOptionalExpression2, expression2, expression3, expression4, expressionResolveOptionalExpression6, divCornersRadius, expressionResolveOptionalExpression7, expression5, expression6, expression7, expressionResolveOptionalExpression11, expressionResolveOptionalExpression12, expression8, expression9, expression10, expressionResolveOptionalExpression16, divEdgeInsets);
        }
    }

    /* JADX INFO: compiled from: DivTabsJsonParser.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u001d8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001d8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u001d8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u001d8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u001d8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/yandex/div2/DivTabsTabTitleStyleJsonParser$Companion;", "", "()V", "ACTIVE_BACKGROUND_COLOR_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "ACTIVE_TEXT_COLOR_DEFAULT_VALUE", "ANIMATION_DURATION_DEFAULT_VALUE", "", "ANIMATION_DURATION_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "ANIMATION_TYPE_DEFAULT_VALUE", "Lcom/yandex/div2/DivTabs$TabTitleStyle$AnimationType;", "CORNER_RADIUS_VALIDATOR", "FONT_SIZE_DEFAULT_VALUE", "FONT_SIZE_UNIT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSizeUnit;", "FONT_SIZE_VALIDATOR", "FONT_WEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivFontWeight;", "INACTIVE_TEXT_COLOR_DEFAULT_VALUE", "ITEM_SPACING_DEFAULT_VALUE", "ITEM_SPACING_VALIDATOR", "LETTER_SPACING_DEFAULT_VALUE", "", "LINE_HEIGHT_VALIDATOR", "PADDINGS_DEFAULT_VALUE", "Lcom/yandex/div2/DivEdgeInsets;", "TYPE_HELPER_ACTIVE_FONT_WEIGHT", "Lcom/yandex/div/internal/parser/TypeHelper;", "TYPE_HELPER_ANIMATION_TYPE", "TYPE_HELPER_FONT_SIZE_UNIT", "TYPE_HELPER_FONT_WEIGHT", "TYPE_HELPER_INACTIVE_FONT_WEIGHT", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
