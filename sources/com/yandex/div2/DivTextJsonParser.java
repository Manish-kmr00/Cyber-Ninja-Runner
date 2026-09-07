package com.yandex.div2;

import androidx.compose.material.OutlinedTextFieldKt;
import androidx.core.provider.FontsContractCompat;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yandex.div.internal.parser.JsonExpressionParser;
import com.yandex.div.internal.parser.JsonFieldParser;
import com.yandex.div.internal.parser.JsonFieldResolver;
import com.yandex.div.internal.parser.JsonPropertyParser;
import com.yandex.div.internal.parser.ListValidator;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivTextJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivTextJsonParser {

    @Deprecated
    public static final DivAnimation ACTION_ANIMATION_DEFAULT_VALUE;

    @Deprecated
    public static final Expression<Double> ALPHA_DEFAULT_VALUE;

    @Deprecated
    public static final ValueValidator<Double> ALPHA_VALIDATOR;

    @Deprecated
    public static final ValueValidator<Long> COLUMN_SPAN_VALIDATOR;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<Long> FONT_SIZE_DEFAULT_VALUE;

    @Deprecated
    public static final Expression<DivSizeUnit> FONT_SIZE_UNIT_DEFAULT_VALUE;

    @Deprecated
    public static final ValueValidator<Long> FONT_SIZE_VALIDATOR;

    @Deprecated
    public static final Expression<DivFontWeight> FONT_WEIGHT_DEFAULT_VALUE;

    @Deprecated
    public static final ValueValidator<Long> FONT_WEIGHT_VALUE_VALIDATOR;

    @Deprecated
    public static final DivSize.WrapContent HEIGHT_DEFAULT_VALUE;

    @Deprecated
    public static final Expression<Double> LETTER_SPACING_DEFAULT_VALUE;

    @Deprecated
    public static final ValueValidator<Long> LINE_HEIGHT_VALIDATOR;

    @Deprecated
    public static final ValueValidator<Long> MAX_LINES_VALIDATOR;

    @Deprecated
    public static final ValueValidator<Long> MIN_HIDDEN_LINES_VALIDATOR;

    @Deprecated
    public static final ValueValidator<Long> ROW_SPAN_VALIDATOR;

    @Deprecated
    public static final Expression<Boolean> SELECTABLE_DEFAULT_VALUE;

    @Deprecated
    public static final Expression<DivLineStyle> STRIKE_DEFAULT_VALUE;

    @Deprecated
    public static final Expression<DivAlignmentHorizontal> TEXT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE;

    @Deprecated
    public static final Expression<DivAlignmentVertical> TEXT_ALIGNMENT_VERTICAL_DEFAULT_VALUE;

    @Deprecated
    public static final Expression<Integer> TEXT_COLOR_DEFAULT_VALUE;

    @Deprecated
    public static final Expression<Boolean> TIGHTEN_WIDTH_DEFAULT_VALUE;

    @Deprecated
    public static final ListValidator<DivTransitionTrigger> TRANSITION_TRIGGERS_VALIDATOR;

    @Deprecated
    public static final TypeHelper<DivAlignmentHorizontal> TYPE_HELPER_ALIGNMENT_HORIZONTAL;

    @Deprecated
    public static final TypeHelper<DivAlignmentVertical> TYPE_HELPER_ALIGNMENT_VERTICAL;

    @Deprecated
    public static final TypeHelper<DivSizeUnit> TYPE_HELPER_FONT_SIZE_UNIT;

    @Deprecated
    public static final TypeHelper<DivFontWeight> TYPE_HELPER_FONT_WEIGHT;

    @Deprecated
    public static final TypeHelper<DivLineStyle> TYPE_HELPER_STRIKE;

    @Deprecated
    public static final TypeHelper<DivAlignmentHorizontal> TYPE_HELPER_TEXT_ALIGNMENT_HORIZONTAL;

    @Deprecated
    public static final TypeHelper<DivAlignmentVertical> TYPE_HELPER_TEXT_ALIGNMENT_VERTICAL;

    @Deprecated
    public static final TypeHelper<DivLineStyle> TYPE_HELPER_UNDERLINE;

    @Deprecated
    public static final TypeHelper<DivVisibility> TYPE_HELPER_VISIBILITY;

    @Deprecated
    public static final Expression<DivLineStyle> UNDERLINE_DEFAULT_VALUE;

    @Deprecated
    public static final Expression<DivVisibility> VISIBILITY_DEFAULT_VALUE;

    @Deprecated
    public static final DivSize.MatchParent WIDTH_DEFAULT_VALUE;
    private final JsonParserComponent component;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ALPHA_VALIDATOR$lambda$0(double d) {
        return d >= 0.0d && d <= 1.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean COLUMN_SPAN_VALIDATOR$lambda$1(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FONT_SIZE_VALIDATOR$lambda$2(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FONT_WEIGHT_VALUE_VALIDATOR$lambda$3(long j) {
        return j > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LINE_HEIGHT_VALIDATOR$lambda$4(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MAX_LINES_VALIDATOR$lambda$5(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MIN_HIDDEN_LINES_VALIDATOR$lambda$6(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ROW_SPAN_VALIDATOR$lambda$7(long j) {
        return j >= 0;
    }

    public DivTextJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivTextJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivTextJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivText;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivText> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivText deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            DivAccessibility divAccessibility = (DivAccessibility) JsonPropertyParser.readOptional(context, data, "accessibility", this.component.getDivAccessibilityJsonEntityParser());
            DivAction divAction = (DivAction) JsonPropertyParser.readOptional(context, data, "action", this.component.getDivActionJsonEntityParser());
            DivAnimation divAnimation = (DivAnimation) JsonPropertyParser.readOptional(context, data, "action_animation", this.component.getDivAnimationJsonEntityParser());
            if (divAnimation == null) {
                divAnimation = DivTextJsonParser.ACTION_ANIMATION_DEFAULT_VALUE;
            }
            DivAnimation divAnimation2 = divAnimation;
            Intrinsics.checkNotNullExpressionValue(divAnimation2, "JsonPropertyParser.readO…N_ANIMATION_DEFAULT_VALUE");
            List optionalList = JsonPropertyParser.readOptionalList(context, data, "actions", this.component.getDivActionJsonEntityParser());
            Expression optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "alignment_horizontal", DivTextJsonParser.TYPE_HELPER_ALIGNMENT_HORIZONTAL, DivAlignmentHorizontal.FROM_STRING);
            Expression optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, "alignment_vertical", DivTextJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, DivAlignmentVertical.FROM_STRING);
            Expression<Double> optionalExpression3 = JsonExpressionParser.readOptionalExpression(context, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivTextJsonParser.ALPHA_VALIDATOR, DivTextJsonParser.ALPHA_DEFAULT_VALUE);
            if (optionalExpression3 == null) {
                optionalExpression3 = DivTextJsonParser.ALPHA_DEFAULT_VALUE;
            }
            Expression<Double> expression = optionalExpression3;
            List optionalList2 = JsonPropertyParser.readOptionalList(context, data, "animators", this.component.getDivAnimatorJsonEntityParser());
            Expression optionalExpression4 = JsonExpressionParser.readOptionalExpression(context, data, "auto_ellipsize", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN);
            List optionalList3 = JsonPropertyParser.readOptionalList(context, data, J2.g, this.component.getDivBackgroundJsonEntityParser());
            DivBorder divBorder = (DivBorder) JsonPropertyParser.readOptional(context, data, OutlinedTextFieldKt.BorderId, this.component.getDivBorderJsonEntityParser());
            Expression optionalExpression5 = JsonExpressionParser.readOptionalExpression(context, data, "column_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.COLUMN_SPAN_VALIDATOR);
            List optionalList4 = JsonPropertyParser.readOptionalList(context, data, "disappear_actions", this.component.getDivDisappearActionJsonEntityParser());
            List optionalList5 = JsonPropertyParser.readOptionalList(context, data, "doubletap_actions", this.component.getDivActionJsonEntityParser());
            DivText.Ellipsis ellipsis = (DivText.Ellipsis) JsonPropertyParser.readOptional(context, data, "ellipsis", this.component.getDivTextEllipsisJsonEntityParser());
            List optionalList6 = JsonPropertyParser.readOptionalList(context, data, "extensions", this.component.getDivExtensionJsonEntityParser());
            DivFocus divFocus = (DivFocus) JsonPropertyParser.readOptional(context, data, "focus", this.component.getDivFocusJsonEntityParser());
            Expression optionalExpression6 = JsonExpressionParser.readOptionalExpression(context, data, "focused_text_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Expression<String> optionalExpression7 = JsonExpressionParser.readOptionalExpression(context, data, "font_family", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression<String> optionalExpression8 = JsonExpressionParser.readOptionalExpression(context, data, "font_feature_settings", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression<Long> optionalExpression9 = JsonExpressionParser.readOptionalExpression(context, data, ViewHierarchyConstants.TEXT_SIZE, TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.FONT_SIZE_VALIDATOR, DivTextJsonParser.FONT_SIZE_DEFAULT_VALUE);
            if (optionalExpression9 == null) {
                optionalExpression9 = DivTextJsonParser.FONT_SIZE_DEFAULT_VALUE;
            }
            Expression<Long> expression2 = optionalExpression9;
            Expression<DivSizeUnit> optionalExpression10 = JsonExpressionParser.readOptionalExpression(context, data, "font_size_unit", DivTextJsonParser.TYPE_HELPER_FONT_SIZE_UNIT, DivSizeUnit.FROM_STRING, DivTextJsonParser.FONT_SIZE_UNIT_DEFAULT_VALUE);
            if (optionalExpression10 == null) {
                optionalExpression10 = DivTextJsonParser.FONT_SIZE_UNIT_DEFAULT_VALUE;
            }
            Expression<DivSizeUnit> expression3 = optionalExpression10;
            Expression<DivFontWeight> optionalExpression11 = JsonExpressionParser.readOptionalExpression(context, data, FontsContractCompat.Columns.WEIGHT, DivTextJsonParser.TYPE_HELPER_FONT_WEIGHT, DivFontWeight.FROM_STRING, DivTextJsonParser.FONT_WEIGHT_DEFAULT_VALUE);
            if (optionalExpression11 == null) {
                optionalExpression11 = DivTextJsonParser.FONT_WEIGHT_DEFAULT_VALUE;
            }
            Expression<DivFontWeight> expression4 = optionalExpression11;
            Expression optionalExpression12 = JsonExpressionParser.readOptionalExpression(context, data, "font_weight_value", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.FONT_WEIGHT_VALUE_VALIDATOR);
            List optionalList7 = JsonPropertyParser.readOptionalList(context, data, "functions", this.component.getDivFunctionJsonEntityParser());
            DivSize.WrapContent wrapContent = (DivSize) JsonPropertyParser.readOptional(context, data, "height", this.component.getDivSizeJsonEntityParser());
            if (wrapContent == null) {
                wrapContent = DivTextJsonParser.HEIGHT_DEFAULT_VALUE;
            }
            DivSize divSize = wrapContent;
            Intrinsics.checkNotNullExpressionValue(divSize, "JsonPropertyParser.readO…) ?: HEIGHT_DEFAULT_VALUE");
            List optionalList8 = JsonPropertyParser.readOptionalList(context, data, "hover_end_actions", this.component.getDivActionJsonEntityParser());
            List optionalList9 = JsonPropertyParser.readOptionalList(context, data, "hover_start_actions", this.component.getDivActionJsonEntityParser());
            String str = (String) JsonPropertyParser.readOptional(context, data, "id");
            List optionalList10 = JsonPropertyParser.readOptionalList(context, data, "images", this.component.getDivTextImageJsonEntityParser());
            DivLayoutProvider divLayoutProvider = (DivLayoutProvider) JsonPropertyParser.readOptional(context, data, "layout_provider", this.component.getDivLayoutProviderJsonEntityParser());
            Expression<Double> optionalExpression13 = JsonExpressionParser.readOptionalExpression(context, data, "letter_spacing", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivTextJsonParser.LETTER_SPACING_DEFAULT_VALUE);
            if (optionalExpression13 == null) {
                optionalExpression13 = DivTextJsonParser.LETTER_SPACING_DEFAULT_VALUE;
            }
            Expression<Double> expression5 = optionalExpression13;
            Expression optionalExpression14 = JsonExpressionParser.readOptionalExpression(context, data, "line_height", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.LINE_HEIGHT_VALIDATOR);
            List optionalList11 = JsonPropertyParser.readOptionalList(context, data, "longtap_actions", this.component.getDivActionJsonEntityParser());
            DivEdgeInsets divEdgeInsets = (DivEdgeInsets) JsonPropertyParser.readOptional(context, data, "margins", this.component.getDivEdgeInsetsJsonEntityParser());
            Expression optionalExpression15 = JsonExpressionParser.readOptionalExpression(context, data, "max_lines", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.MAX_LINES_VALIDATOR);
            Expression optionalExpression16 = JsonExpressionParser.readOptionalExpression(context, data, "min_hidden_lines", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.MIN_HIDDEN_LINES_VALIDATOR);
            DivEdgeInsets divEdgeInsets2 = (DivEdgeInsets) JsonPropertyParser.readOptional(context, data, "paddings", this.component.getDivEdgeInsetsJsonEntityParser());
            List optionalList12 = JsonPropertyParser.readOptionalList(context, data, "press_end_actions", this.component.getDivActionJsonEntityParser());
            List optionalList13 = JsonPropertyParser.readOptionalList(context, data, "press_start_actions", this.component.getDivActionJsonEntityParser());
            List optionalList14 = JsonPropertyParser.readOptionalList(context, data, "ranges", this.component.getDivTextRangeJsonEntityParser());
            Expression<String> optionalExpression17 = JsonExpressionParser.readOptionalExpression(context, data, "reuse_id", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression optionalExpression18 = JsonExpressionParser.readOptionalExpression(context, data, "row_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.ROW_SPAN_VALIDATOR);
            Expression<Boolean> optionalExpression19 = JsonExpressionParser.readOptionalExpression(context, data, "selectable", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivTextJsonParser.SELECTABLE_DEFAULT_VALUE);
            if (optionalExpression19 == null) {
                optionalExpression19 = DivTextJsonParser.SELECTABLE_DEFAULT_VALUE;
            }
            Expression<Boolean> expression6 = optionalExpression19;
            List optionalList15 = JsonPropertyParser.readOptionalList(context, data, "selected_actions", this.component.getDivActionJsonEntityParser());
            Expression<DivLineStyle> optionalExpression20 = JsonExpressionParser.readOptionalExpression(context, data, "strike", DivTextJsonParser.TYPE_HELPER_STRIKE, DivLineStyle.FROM_STRING, DivTextJsonParser.STRIKE_DEFAULT_VALUE);
            if (optionalExpression20 == null) {
                optionalExpression20 = DivTextJsonParser.STRIKE_DEFAULT_VALUE;
            }
            Expression<DivLineStyle> expression7 = optionalExpression20;
            Expression expression8 = JsonExpressionParser.readExpression(context, data, "text", TypeHelpersKt.TYPE_HELPER_STRING);
            Intrinsics.checkNotNullExpressionValue(expression8, "readExpression(context, …ext\", TYPE_HELPER_STRING)");
            Expression<DivAlignmentHorizontal> optionalExpression21 = JsonExpressionParser.readOptionalExpression(context, data, "text_alignment_horizontal", DivTextJsonParser.TYPE_HELPER_TEXT_ALIGNMENT_HORIZONTAL, DivAlignmentHorizontal.FROM_STRING, DivTextJsonParser.TEXT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE);
            if (optionalExpression21 == null) {
                optionalExpression21 = DivTextJsonParser.TEXT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE;
            }
            Expression<DivAlignmentHorizontal> expression9 = optionalExpression21;
            Expression<DivAlignmentVertical> optionalExpression22 = JsonExpressionParser.readOptionalExpression(context, data, "text_alignment_vertical", DivTextJsonParser.TYPE_HELPER_TEXT_ALIGNMENT_VERTICAL, DivAlignmentVertical.FROM_STRING, DivTextJsonParser.TEXT_ALIGNMENT_VERTICAL_DEFAULT_VALUE);
            if (optionalExpression22 == null) {
                optionalExpression22 = DivTextJsonParser.TEXT_ALIGNMENT_VERTICAL_DEFAULT_VALUE;
            }
            Expression<DivAlignmentVertical> expression10 = optionalExpression22;
            Expression<Integer> optionalExpression23 = JsonExpressionParser.readOptionalExpression(context, data, "text_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT, DivTextJsonParser.TEXT_COLOR_DEFAULT_VALUE);
            if (optionalExpression23 == null) {
                optionalExpression23 = DivTextJsonParser.TEXT_COLOR_DEFAULT_VALUE;
            }
            Expression<Integer> expression11 = optionalExpression23;
            DivTextGradient divTextGradient = (DivTextGradient) JsonPropertyParser.readOptional(context, data, "text_gradient", this.component.getDivTextGradientJsonEntityParser());
            DivShadow divShadow = (DivShadow) JsonPropertyParser.readOptional(context, data, "text_shadow", this.component.getDivShadowJsonEntityParser());
            Expression<Boolean> optionalExpression24 = JsonExpressionParser.readOptionalExpression(context, data, "tighten_width", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivTextJsonParser.TIGHTEN_WIDTH_DEFAULT_VALUE);
            if (optionalExpression24 == null) {
                optionalExpression24 = DivTextJsonParser.TIGHTEN_WIDTH_DEFAULT_VALUE;
            }
            Expression<Boolean> expression12 = optionalExpression24;
            List optionalList16 = JsonPropertyParser.readOptionalList(context, data, "tooltips", this.component.getDivTooltipJsonEntityParser());
            DivTransform divTransform = (DivTransform) JsonPropertyParser.readOptional(context, data, "transform", this.component.getDivTransformJsonEntityParser());
            DivChangeTransition divChangeTransition = (DivChangeTransition) JsonPropertyParser.readOptional(context, data, "transition_change", this.component.getDivChangeTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition = (DivAppearanceTransition) JsonPropertyParser.readOptional(context, data, "transition_in", this.component.getDivAppearanceTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition2 = (DivAppearanceTransition) JsonPropertyParser.readOptional(context, data, "transition_out", this.component.getDivAppearanceTransitionJsonEntityParser());
            List optionalList17 = JsonPropertyParser.readOptionalList(context, data, "transition_triggers", DivTransitionTrigger.FROM_STRING, DivTextJsonParser.TRANSITION_TRIGGERS_VALIDATOR);
            Expression<DivLineStyle> optionalExpression25 = JsonExpressionParser.readOptionalExpression(context, data, "underline", DivTextJsonParser.TYPE_HELPER_UNDERLINE, DivLineStyle.FROM_STRING, DivTextJsonParser.UNDERLINE_DEFAULT_VALUE);
            if (optionalExpression25 == null) {
                optionalExpression25 = DivTextJsonParser.UNDERLINE_DEFAULT_VALUE;
            }
            Expression<DivLineStyle> expression13 = optionalExpression25;
            List optionalList18 = JsonPropertyParser.readOptionalList(context, data, "variable_triggers", this.component.getDivTriggerJsonEntityParser());
            List optionalList19 = JsonPropertyParser.readOptionalList(context, data, "variables", this.component.getDivVariableJsonEntityParser());
            Expression<DivVisibility> optionalExpression26 = JsonExpressionParser.readOptionalExpression(context, data, "visibility", DivTextJsonParser.TYPE_HELPER_VISIBILITY, DivVisibility.FROM_STRING, DivTextJsonParser.VISIBILITY_DEFAULT_VALUE);
            if (optionalExpression26 == null) {
                optionalExpression26 = DivTextJsonParser.VISIBILITY_DEFAULT_VALUE;
            }
            DivVisibilityAction divVisibilityAction = (DivVisibilityAction) JsonPropertyParser.readOptional(context, data, "visibility_action", this.component.getDivVisibilityActionJsonEntityParser());
            List optionalList20 = JsonPropertyParser.readOptionalList(context, data, "visibility_actions", this.component.getDivVisibilityActionJsonEntityParser());
            DivSize.MatchParent matchParent = (DivSize) JsonPropertyParser.readOptional(context, data, "width", this.component.getDivSizeJsonEntityParser());
            if (matchParent == null) {
                matchParent = DivTextJsonParser.WIDTH_DEFAULT_VALUE;
            }
            DivSize divSize2 = matchParent;
            Intrinsics.checkNotNullExpressionValue(divSize2, "JsonPropertyParser.readO…r) ?: WIDTH_DEFAULT_VALUE");
            return new DivText(divAccessibility, divAction, divAnimation2, optionalList, optionalExpression, optionalExpression2, expression, optionalList2, optionalExpression4, optionalList3, divBorder, optionalExpression5, optionalList4, optionalList5, ellipsis, optionalList6, divFocus, optionalExpression6, optionalExpression7, optionalExpression8, expression2, expression3, expression4, optionalExpression12, optionalList7, divSize, optionalList8, optionalList9, str, optionalList10, divLayoutProvider, expression5, optionalExpression14, optionalList11, divEdgeInsets, optionalExpression15, optionalExpression16, divEdgeInsets2, optionalList12, optionalList13, optionalList14, optionalExpression17, optionalExpression18, expression6, optionalList15, expression7, expression8, expression9, expression10, expression11, divTextGradient, divShadow, expression12, optionalList16, divTransform, divChangeTransition, divAppearanceTransition, divAppearanceTransition2, optionalList17, expression13, optionalList18, optionalList19, optionalExpression26, divVisibilityAction, optionalList20, divSize2);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivText value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonPropertyParser.write(context, jSONObject, "accessibility", value.getAccessibility(), this.component.getDivAccessibilityJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "action", value.action, this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "action_animation", value.actionAnimation, this.component.getDivAnimationJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "actions", value.actions, this.component.getDivActionJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "alignment_horizontal", value.getAlignmentHorizontal(), DivAlignmentHorizontal.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "alignment_vertical", value.getAlignmentVertical(), DivAlignmentVertical.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "alpha", value.getAlpha());
            JsonPropertyParser.writeList(context, jSONObject, "animators", value.getAnimators(), this.component.getDivAnimatorJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "auto_ellipsize", value.autoEllipsize);
            JsonPropertyParser.writeList(context, jSONObject, J2.g, value.getBackground(), this.component.getDivBackgroundJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, OutlinedTextFieldKt.BorderId, value.getBorder(), this.component.getDivBorderJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "column_span", value.getColumnSpan());
            JsonPropertyParser.writeList(context, jSONObject, "disappear_actions", value.getDisappearActions(), this.component.getDivDisappearActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "doubletap_actions", value.doubletapActions, this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "ellipsis", value.ellipsis, this.component.getDivTextEllipsisJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "extensions", value.getExtensions(), this.component.getDivExtensionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "focus", value.getFocus(), this.component.getDivFocusJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "focused_text_color", value.focusedTextColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "font_family", value.fontFamily);
            JsonExpressionParser.writeExpression(context, jSONObject, "font_feature_settings", value.fontFeatureSettings);
            JsonExpressionParser.writeExpression(context, jSONObject, ViewHierarchyConstants.TEXT_SIZE, value.fontSize);
            JsonExpressionParser.writeExpression(context, jSONObject, "font_size_unit", value.fontSizeUnit, DivSizeUnit.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, FontsContractCompat.Columns.WEIGHT, value.fontWeight, DivFontWeight.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "font_weight_value", value.fontWeightValue);
            JsonPropertyParser.writeList(context, jSONObject, "functions", value.getFunctions(), this.component.getDivFunctionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "height", value.getHeight(), this.component.getDivSizeJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "hover_end_actions", value.hoverEndActions, this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "hover_start_actions", value.hoverStartActions, this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "id", value.getId());
            JsonPropertyParser.writeList(context, jSONObject, "images", value.images, this.component.getDivTextImageJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "layout_provider", value.getLayoutProvider(), this.component.getDivLayoutProviderJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "letter_spacing", value.letterSpacing);
            JsonExpressionParser.writeExpression(context, jSONObject, "line_height", value.lineHeight);
            JsonPropertyParser.writeList(context, jSONObject, "longtap_actions", value.longtapActions, this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "margins", value.getMargins(), this.component.getDivEdgeInsetsJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "max_lines", value.maxLines);
            JsonExpressionParser.writeExpression(context, jSONObject, "min_hidden_lines", value.minHiddenLines);
            JsonPropertyParser.write(context, jSONObject, "paddings", value.getPaddings(), this.component.getDivEdgeInsetsJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "press_end_actions", value.pressEndActions, this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "press_start_actions", value.pressStartActions, this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "ranges", value.ranges, this.component.getDivTextRangeJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "reuse_id", value.getReuseId());
            JsonExpressionParser.writeExpression(context, jSONObject, "row_span", value.getRowSpan());
            JsonExpressionParser.writeExpression(context, jSONObject, "selectable", value.selectable);
            JsonPropertyParser.writeList(context, jSONObject, "selected_actions", value.getSelectedActions(), this.component.getDivActionJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "strike", value.strike, DivLineStyle.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "text", value.text);
            JsonExpressionParser.writeExpression(context, jSONObject, "text_alignment_horizontal", value.textAlignmentHorizontal, DivAlignmentHorizontal.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "text_alignment_vertical", value.textAlignmentVertical, DivAlignmentVertical.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "text_color", value.textColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "text_gradient", value.textGradient, this.component.getDivTextGradientJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "text_shadow", value.textShadow, this.component.getDivShadowJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "tighten_width", value.tightenWidth);
            JsonPropertyParser.writeList(context, jSONObject, "tooltips", value.getTooltips(), this.component.getDivTooltipJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transform", value.getTransform(), this.component.getDivTransformJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transition_change", value.getTransitionChange(), this.component.getDivChangeTransitionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transition_in", value.getTransitionIn(), this.component.getDivAppearanceTransitionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transition_out", value.getTransitionOut(), this.component.getDivAppearanceTransitionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "transition_triggers", value.getTransitionTriggers(), DivTransitionTrigger.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "type", "text");
            JsonExpressionParser.writeExpression(context, jSONObject, "underline", value.underline, DivLineStyle.TO_STRING);
            JsonPropertyParser.writeList(context, jSONObject, "variable_triggers", value.getVariableTriggers(), this.component.getDivTriggerJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "variables", value.getVariables(), this.component.getDivVariableJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "visibility", value.getVisibility(), DivVisibility.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "visibility_action", value.getVisibilityAction(), this.component.getDivVisibilityActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "visibility_actions", value.getVisibilityActions(), this.component.getDivVisibilityActionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "width", value.getWidth(), this.component.getDivSizeJsonEntityParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivTextJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivTextJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTextTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivTextTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivTextTemplate deserialize(ParsingContext context, DivTextTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "accessibility", allowPropertyOverride, parent != null ? parent.accessibility : null, this.component.getDivAccessibilityJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex…bilityJsonTemplateParser)");
            Field optionalField2 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "action", allowPropertyOverride, parent != null ? parent.action : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField2, "readOptionalField(contex…ActionJsonTemplateParser)");
            Field optionalField3 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "action_animation", allowPropertyOverride, parent != null ? parent.actionAnimation : null, this.component.getDivAnimationJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField3, "readOptionalField(contex…mationJsonTemplateParser)");
            Field optionalListField = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "actions", allowPropertyOverride, parent != null ? parent.actions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alignment_horizontal", DivTextJsonParser.TYPE_HELPER_ALIGNMENT_HORIZONTAL, allowPropertyOverride, parent != null ? parent.alignmentHorizontal : null, DivAlignmentHorizontal.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…ntHorizontal.FROM_STRING)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alignment_vertical", DivTextJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, allowPropertyOverride, parent != null ? parent.alignmentVertical : null, DivAlignmentVertical.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…mentVertical.FROM_STRING)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.alpha : null, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivTextJsonParser.ALPHA_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…_DOUBLE, ALPHA_VALIDATOR)");
            Field optionalListField2 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "animators", allowPropertyOverride, parent != null ? parent.animators : null, this.component.getDivAnimatorJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField2, "readOptionalListField(co…imatorJsonTemplateParser)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "auto_ellipsize", TypeHelpersKt.TYPE_HELPER_BOOLEAN, allowPropertyOverride, parent != null ? parent.autoEllipsize : null, ParsingConvertersKt.ANY_TO_BOOLEAN);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…llipsize, ANY_TO_BOOLEAN)");
            Field optionalListField3 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, J2.g, allowPropertyOverride, parent != null ? parent.background : null, this.component.getDivBackgroundJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField3, "readOptionalListField(co…groundJsonTemplateParser)");
            Field optionalField4 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, OutlinedTextFieldKt.BorderId, allowPropertyOverride, parent != null ? parent.border : null, this.component.getDivBorderJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField4, "readOptionalField(contex…BorderJsonTemplateParser)");
            Field optionalFieldWithExpression5 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "column_span", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.columnSpan : null, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.COLUMN_SPAN_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression5, "readOptionalFieldWithExp…T, COLUMN_SPAN_VALIDATOR)");
            Field optionalListField4 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "disappear_actions", allowPropertyOverride, parent != null ? parent.disappearActions : null, this.component.getDivDisappearActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField4, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalListField5 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "doubletap_actions", allowPropertyOverride, parent != null ? parent.doubletapActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField5, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalField5 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "ellipsis", allowPropertyOverride, parent != null ? parent.ellipsis : null, this.component.getDivTextEllipsisJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField5, "readOptionalField(contex…lipsisJsonTemplateParser)");
            Field optionalListField6 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "extensions", allowPropertyOverride, parent != null ? parent.extensions : null, this.component.getDivExtensionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField6, "readOptionalListField(co…ensionJsonTemplateParser)");
            Field optionalField6 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "focus", allowPropertyOverride, parent != null ? parent.focus : null, this.component.getDivFocusJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField6, "readOptionalField(contex…vFocusJsonTemplateParser)");
            Field optionalFieldWithExpression6 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "focused_text_color", TypeHelpersKt.TYPE_HELPER_COLOR, allowPropertyOverride, parent != null ? parent.focusedTextColor : null, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression6, "readOptionalFieldWithExp…lor, STRING_TO_COLOR_INT)");
            Field<Expression<String>> optionalFieldWithExpression7 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "font_family", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.fontFamily : null);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression7, "readOptionalFieldWithExp…ride, parent?.fontFamily)");
            Field<Expression<String>> optionalFieldWithExpression8 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "font_feature_settings", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.fontFeatureSettings : null);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression8, "readOptionalFieldWithExp…ent?.fontFeatureSettings)");
            Field optionalFieldWithExpression9 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, ViewHierarchyConstants.TEXT_SIZE, TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.fontSize : null, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.FONT_SIZE_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression9, "readOptionalFieldWithExp…INT, FONT_SIZE_VALIDATOR)");
            Field optionalFieldWithExpression10 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "font_size_unit", DivTextJsonParser.TYPE_HELPER_FONT_SIZE_UNIT, allowPropertyOverride, parent != null ? parent.fontSizeUnit : null, DivSizeUnit.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression10, "readOptionalFieldWithExp… DivSizeUnit.FROM_STRING)");
            Field optionalFieldWithExpression11 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, FontsContractCompat.Columns.WEIGHT, DivTextJsonParser.TYPE_HELPER_FONT_WEIGHT, allowPropertyOverride, parent != null ? parent.fontWeight : null, DivFontWeight.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression11, "readOptionalFieldWithExp…ivFontWeight.FROM_STRING)");
            Field optionalFieldWithExpression12 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "font_weight_value", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.fontWeightValue : null, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.FONT_WEIGHT_VALUE_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression12, "readOptionalFieldWithExp…T_WEIGHT_VALUE_VALIDATOR)");
            Field optionalListField7 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "functions", allowPropertyOverride, parent != null ? parent.functions : null, this.component.getDivFunctionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField7, "readOptionalListField(co…nctionJsonTemplateParser)");
            Field optionalField7 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "height", allowPropertyOverride, parent != null ? parent.height : null, this.component.getDivSizeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField7, "readOptionalField(contex…ivSizeJsonTemplateParser)");
            Field optionalListField8 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "hover_end_actions", allowPropertyOverride, parent != null ? parent.hoverEndActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField8, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalListField9 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "hover_start_actions", allowPropertyOverride, parent != null ? parent.hoverStartActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField9, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalField8 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "id", allowPropertyOverride, parent != null ? parent.id : null);
            Intrinsics.checkNotNullExpressionValue(optionalField8, "readOptionalField(contex…llowOverride, parent?.id)");
            Field optionalListField10 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "images", allowPropertyOverride, parent != null ? parent.images : null, this.component.getDivTextImageJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField10, "readOptionalListField(co…tImageJsonTemplateParser)");
            Field optionalField9 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "layout_provider", allowPropertyOverride, parent != null ? parent.layoutProvider : null, this.component.getDivLayoutProviderJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField9, "readOptionalField(contex…oviderJsonTemplateParser)");
            Field optionalFieldWithExpression13 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "letter_spacing", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.letterSpacing : null, ParsingConvertersKt.NUMBER_TO_DOUBLE);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression13, "readOptionalFieldWithExp…pacing, NUMBER_TO_DOUBLE)");
            Field optionalFieldWithExpression14 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "line_height", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.lineHeight : null, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.LINE_HEIGHT_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression14, "readOptionalFieldWithExp…T, LINE_HEIGHT_VALIDATOR)");
            Field optionalListField11 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "longtap_actions", allowPropertyOverride, parent != null ? parent.longtapActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField11, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalField10 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "margins", allowPropertyOverride, parent != null ? parent.margins : null, this.component.getDivEdgeInsetsJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField10, "readOptionalField(contex…InsetsJsonTemplateParser)");
            Field optionalFieldWithExpression15 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "max_lines", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.maxLines : null, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.MAX_LINES_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression15, "readOptionalFieldWithExp…INT, MAX_LINES_VALIDATOR)");
            Field optionalFieldWithExpression16 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "min_hidden_lines", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.minHiddenLines : null, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.MIN_HIDDEN_LINES_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression16, "readOptionalFieldWithExp…N_HIDDEN_LINES_VALIDATOR)");
            Field optionalField11 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "paddings", allowPropertyOverride, parent != null ? parent.paddings : null, this.component.getDivEdgeInsetsJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField11, "readOptionalField(contex…InsetsJsonTemplateParser)");
            Field optionalListField12 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "press_end_actions", allowPropertyOverride, parent != null ? parent.pressEndActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField12, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalListField13 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "press_start_actions", allowPropertyOverride, parent != null ? parent.pressStartActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField13, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalListField14 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "ranges", allowPropertyOverride, parent != null ? parent.ranges : null, this.component.getDivTextRangeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField14, "readOptionalListField(co…tRangeJsonTemplateParser)");
            Field<Expression<String>> optionalFieldWithExpression17 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "reuse_id", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.reuseId : null);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression17, "readOptionalFieldWithExp…verride, parent?.reuseId)");
            Field optionalFieldWithExpression18 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "row_span", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.rowSpan : null, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.ROW_SPAN_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression18, "readOptionalFieldWithExp…_INT, ROW_SPAN_VALIDATOR)");
            Field optionalFieldWithExpression19 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "selectable", TypeHelpersKt.TYPE_HELPER_BOOLEAN, allowPropertyOverride, parent != null ? parent.selectable : null, ParsingConvertersKt.ANY_TO_BOOLEAN);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression19, "readOptionalFieldWithExp…lectable, ANY_TO_BOOLEAN)");
            Field optionalListField15 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "selected_actions", allowPropertyOverride, parent != null ? parent.selectedActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField15, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalFieldWithExpression20 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "strike", DivTextJsonParser.TYPE_HELPER_STRIKE, allowPropertyOverride, parent != null ? parent.strike : null, DivLineStyle.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression20, "readOptionalFieldWithExp…DivLineStyle.FROM_STRING)");
            Field fieldWithExpression = JsonFieldParser.readFieldWithExpression(parsingContextRestrictPropertyOverride, data, "text", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.text : null);
            Intrinsics.checkNotNullExpressionValue(fieldWithExpression, "readFieldWithExpression(…owOverride, parent?.text)");
            Field optionalFieldWithExpression21 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "text_alignment_horizontal", DivTextJsonParser.TYPE_HELPER_TEXT_ALIGNMENT_HORIZONTAL, allowPropertyOverride, parent != null ? parent.textAlignmentHorizontal : null, DivAlignmentHorizontal.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression21, "readOptionalFieldWithExp…ntHorizontal.FROM_STRING)");
            Field optionalFieldWithExpression22 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "text_alignment_vertical", DivTextJsonParser.TYPE_HELPER_TEXT_ALIGNMENT_VERTICAL, allowPropertyOverride, parent != null ? parent.textAlignmentVertical : null, DivAlignmentVertical.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression22, "readOptionalFieldWithExp…mentVertical.FROM_STRING)");
            Field optionalFieldWithExpression23 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "text_color", TypeHelpersKt.TYPE_HELPER_COLOR, allowPropertyOverride, parent != null ? parent.textColor : null, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression23, "readOptionalFieldWithExp…lor, STRING_TO_COLOR_INT)");
            Field optionalField12 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "text_gradient", allowPropertyOverride, parent != null ? parent.textGradient : null, this.component.getDivTextGradientJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField12, "readOptionalField(contex…adientJsonTemplateParser)");
            Field optionalField13 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "text_shadow", allowPropertyOverride, parent != null ? parent.textShadow : null, this.component.getDivShadowJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField13, "readOptionalField(contex…ShadowJsonTemplateParser)");
            Field optionalFieldWithExpression24 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "tighten_width", TypeHelpersKt.TYPE_HELPER_BOOLEAN, allowPropertyOverride, parent != null ? parent.tightenWidth : null, ParsingConvertersKt.ANY_TO_BOOLEAN);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression24, "readOptionalFieldWithExp…tenWidth, ANY_TO_BOOLEAN)");
            Field optionalListField16 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "tooltips", allowPropertyOverride, parent != null ? parent.tooltips : null, this.component.getDivTooltipJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField16, "readOptionalListField(co…ooltipJsonTemplateParser)");
            Field optionalField14 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transform", allowPropertyOverride, parent != null ? parent.transform : null, this.component.getDivTransformJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField14, "readOptionalField(contex…nsformJsonTemplateParser)");
            Field optionalField15 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transition_change", allowPropertyOverride, parent != null ? parent.transitionChange : null, this.component.getDivChangeTransitionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField15, "readOptionalField(contex…sitionJsonTemplateParser)");
            Field optionalField16 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transition_in", allowPropertyOverride, parent != null ? parent.transitionIn : null, this.component.getDivAppearanceTransitionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField16, "readOptionalField(contex…sitionJsonTemplateParser)");
            Field optionalField17 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transition_out", allowPropertyOverride, parent != null ? parent.transitionOut : null, this.component.getDivAppearanceTransitionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField17, "readOptionalField(contex…sitionJsonTemplateParser)");
            Field<List<DivTransitionTrigger>> field = parent != null ? parent.transitionTriggers : null;
            Function1<String, DivTransitionTrigger> function1 = DivTransitionTrigger.FROM_STRING;
            ListValidator<DivTransitionTrigger> listValidator = DivTextJsonParser.TRANSITION_TRIGGERS_VALIDATOR;
            Intrinsics.checkNotNull(listValidator, "null cannot be cast to non-null type com.yandex.div.internal.parser.ListValidator<T of com.yandex.div.internal.parser.ParsingValidatorsKt.cast>");
            Field optionalListField17 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "transition_triggers", allowPropertyOverride, field, function1, listValidator);
            Intrinsics.checkNotNullExpressionValue(optionalListField17, "readOptionalListField(co…RIGGERS_VALIDATOR.cast())");
            Field optionalFieldWithExpression25 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "underline", DivTextJsonParser.TYPE_HELPER_UNDERLINE, allowPropertyOverride, parent != null ? parent.underline : null, DivLineStyle.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression25, "readOptionalFieldWithExp…DivLineStyle.FROM_STRING)");
            Field optionalListField18 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "variable_triggers", allowPropertyOverride, parent != null ? parent.variableTriggers : null, this.component.getDivTriggerJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField18, "readOptionalListField(co…riggerJsonTemplateParser)");
            Field optionalListField19 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "variables", allowPropertyOverride, parent != null ? parent.variables : null, this.component.getDivVariableJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField19, "readOptionalListField(co…riableJsonTemplateParser)");
            Field optionalFieldWithExpression26 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "visibility", DivTextJsonParser.TYPE_HELPER_VISIBILITY, allowPropertyOverride, parent != null ? parent.visibility : null, DivVisibility.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression26, "readOptionalFieldWithExp…ivVisibility.FROM_STRING)");
            Field optionalField18 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "visibility_action", allowPropertyOverride, parent != null ? parent.visibilityAction : null, this.component.getDivVisibilityActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField18, "readOptionalField(contex…ActionJsonTemplateParser)");
            Field optionalListField20 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "visibility_actions", allowPropertyOverride, parent != null ? parent.visibilityActions : null, this.component.getDivVisibilityActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField20, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalField19 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "width", allowPropertyOverride, parent != null ? parent.width : null, this.component.getDivSizeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField19, "readOptionalField(contex…ivSizeJsonTemplateParser)");
            return new DivTextTemplate(optionalField, optionalField2, optionalField3, optionalListField, optionalFieldWithExpression, optionalFieldWithExpression2, optionalFieldWithExpression3, optionalListField2, optionalFieldWithExpression4, optionalListField3, optionalField4, optionalFieldWithExpression5, optionalListField4, optionalListField5, optionalField5, optionalListField6, optionalField6, optionalFieldWithExpression6, optionalFieldWithExpression7, optionalFieldWithExpression8, optionalFieldWithExpression9, optionalFieldWithExpression10, optionalFieldWithExpression11, optionalFieldWithExpression12, optionalListField7, optionalField7, optionalListField8, optionalListField9, optionalField8, optionalListField10, optionalField9, optionalFieldWithExpression13, optionalFieldWithExpression14, optionalListField11, optionalField10, optionalFieldWithExpression15, optionalFieldWithExpression16, optionalField11, optionalListField12, optionalListField13, optionalListField14, optionalFieldWithExpression17, optionalFieldWithExpression18, optionalFieldWithExpression19, optionalListField15, optionalFieldWithExpression20, fieldWithExpression, optionalFieldWithExpression21, optionalFieldWithExpression22, optionalFieldWithExpression23, optionalField12, optionalField13, optionalFieldWithExpression24, optionalListField16, optionalField14, optionalField15, optionalField16, optionalField17, optionalListField17, optionalFieldWithExpression25, optionalListField18, optionalListField19, optionalFieldWithExpression26, optionalField18, optionalListField20, optionalField19);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivTextTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeField(context, jSONObject, "accessibility", value.accessibility, this.component.getDivAccessibilityJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "action", value.action, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "action_animation", value.actionAnimation, this.component.getDivAnimationJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "actions", value.actions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "alignment_horizontal", value.alignmentHorizontal, DivAlignmentHorizontal.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "alignment_vertical", value.alignmentVertical, DivAlignmentVertical.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "alpha", value.alpha);
            JsonFieldParser.writeListField(context, jSONObject, "animators", value.animators, this.component.getDivAnimatorJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "auto_ellipsize", value.autoEllipsize);
            JsonFieldParser.writeListField(context, jSONObject, J2.g, value.background, this.component.getDivBackgroundJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, OutlinedTextFieldKt.BorderId, value.border, this.component.getDivBorderJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "column_span", value.columnSpan);
            JsonFieldParser.writeListField(context, jSONObject, "disappear_actions", value.disappearActions, this.component.getDivDisappearActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "doubletap_actions", value.doubletapActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "ellipsis", value.ellipsis, this.component.getDivTextEllipsisJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "extensions", value.extensions, this.component.getDivExtensionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "focus", value.focus, this.component.getDivFocusJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "focused_text_color", value.focusedTextColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "font_family", value.fontFamily);
            JsonFieldParser.writeExpressionField(context, jSONObject, "font_feature_settings", value.fontFeatureSettings);
            JsonFieldParser.writeExpressionField(context, jSONObject, ViewHierarchyConstants.TEXT_SIZE, value.fontSize);
            JsonFieldParser.writeExpressionField(context, jSONObject, "font_size_unit", value.fontSizeUnit, DivSizeUnit.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, FontsContractCompat.Columns.WEIGHT, value.fontWeight, DivFontWeight.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "font_weight_value", value.fontWeightValue);
            JsonFieldParser.writeListField(context, jSONObject, "functions", value.functions, this.component.getDivFunctionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "height", value.height, this.component.getDivSizeJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "hover_end_actions", value.hoverEndActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "hover_start_actions", value.hoverStartActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "id", value.id);
            JsonFieldParser.writeListField(context, jSONObject, "images", value.images, this.component.getDivTextImageJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "layout_provider", value.layoutProvider, this.component.getDivLayoutProviderJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "letter_spacing", value.letterSpacing);
            JsonFieldParser.writeExpressionField(context, jSONObject, "line_height", value.lineHeight);
            JsonFieldParser.writeListField(context, jSONObject, "longtap_actions", value.longtapActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "margins", value.margins, this.component.getDivEdgeInsetsJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "max_lines", value.maxLines);
            JsonFieldParser.writeExpressionField(context, jSONObject, "min_hidden_lines", value.minHiddenLines);
            JsonFieldParser.writeField(context, jSONObject, "paddings", value.paddings, this.component.getDivEdgeInsetsJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "press_end_actions", value.pressEndActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "press_start_actions", value.pressStartActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "ranges", value.ranges, this.component.getDivTextRangeJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "reuse_id", value.reuseId);
            JsonFieldParser.writeExpressionField(context, jSONObject, "row_span", value.rowSpan);
            JsonFieldParser.writeExpressionField(context, jSONObject, "selectable", value.selectable);
            JsonFieldParser.writeListField(context, jSONObject, "selected_actions", value.selectedActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "strike", value.strike, DivLineStyle.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "text", value.text);
            JsonFieldParser.writeExpressionField(context, jSONObject, "text_alignment_horizontal", value.textAlignmentHorizontal, DivAlignmentHorizontal.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "text_alignment_vertical", value.textAlignmentVertical, DivAlignmentVertical.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "text_color", value.textColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "text_gradient", value.textGradient, this.component.getDivTextGradientJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "text_shadow", value.textShadow, this.component.getDivShadowJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "tighten_width", value.tightenWidth);
            JsonFieldParser.writeListField(context, jSONObject, "tooltips", value.tooltips, this.component.getDivTooltipJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transform", value.transform, this.component.getDivTransformJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transition_change", value.transitionChange, this.component.getDivChangeTransitionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transition_in", value.transitionIn, this.component.getDivAppearanceTransitionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transition_out", value.transitionOut, this.component.getDivAppearanceTransitionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "transition_triggers", value.transitionTriggers, DivTransitionTrigger.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "type", "text");
            JsonFieldParser.writeExpressionField(context, jSONObject, "underline", value.underline, DivLineStyle.TO_STRING);
            JsonFieldParser.writeListField(context, jSONObject, "variable_triggers", value.variableTriggers, this.component.getDivTriggerJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "variables", value.variables, this.component.getDivVariableJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "visibility", value.visibility, DivVisibility.TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "visibility_action", value.visibilityAction, this.component.getDivVisibilityActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "visibility_actions", value.visibilityActions, this.component.getDivVisibilityActionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "width", value.width, this.component.getDivSizeJsonTemplateParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivTextJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivTextJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTextTemplate;", "Lcom/yandex/div2/DivText;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivTextTemplate, DivText> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivText resolve(ParsingContext context, DivTextTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            DivAccessibility divAccessibility = (DivAccessibility) JsonFieldResolver.resolveOptional(context, template.accessibility, data, "accessibility", this.component.getDivAccessibilityJsonTemplateResolver(), this.component.getDivAccessibilityJsonEntityParser());
            DivAction divAction = (DivAction) JsonFieldResolver.resolveOptional(context, template.action, data, "action", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            DivAnimation divAnimation = (DivAnimation) JsonFieldResolver.resolveOptional(context, template.actionAnimation, data, "action_animation", this.component.getDivAnimationJsonTemplateResolver(), this.component.getDivAnimationJsonEntityParser());
            if (divAnimation == null) {
                divAnimation = DivTextJsonParser.ACTION_ANIMATION_DEFAULT_VALUE;
            }
            DivAnimation divAnimation2 = divAnimation;
            Intrinsics.checkNotNullExpressionValue(divAnimation2, "JsonFieldResolver.resolv…N_ANIMATION_DEFAULT_VALUE");
            List listResolveOptionalList = JsonFieldResolver.resolveOptionalList(context, template.actions, data, "actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            Expression expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.alignmentHorizontal, data, "alignment_horizontal", DivTextJsonParser.TYPE_HELPER_ALIGNMENT_HORIZONTAL, DivAlignmentHorizontal.FROM_STRING);
            Expression expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.alignmentVertical, data, "alignment_vertical", DivTextJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, DivAlignmentVertical.FROM_STRING);
            Expression<Double> expressionResolveOptionalExpression3 = JsonFieldResolver.resolveOptionalExpression(context, template.alpha, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivTextJsonParser.ALPHA_VALIDATOR, DivTextJsonParser.ALPHA_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression3 == null) {
                expressionResolveOptionalExpression3 = DivTextJsonParser.ALPHA_DEFAULT_VALUE;
            }
            Expression<Double> expression = expressionResolveOptionalExpression3;
            List listResolveOptionalList2 = JsonFieldResolver.resolveOptionalList(context, template.animators, data, "animators", this.component.getDivAnimatorJsonTemplateResolver(), this.component.getDivAnimatorJsonEntityParser());
            Expression expressionResolveOptionalExpression4 = JsonFieldResolver.resolveOptionalExpression(context, template.autoEllipsize, data, "auto_ellipsize", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN);
            List listResolveOptionalList3 = JsonFieldResolver.resolveOptionalList(context, template.background, data, J2.g, this.component.getDivBackgroundJsonTemplateResolver(), this.component.getDivBackgroundJsonEntityParser());
            DivBorder divBorder = (DivBorder) JsonFieldResolver.resolveOptional(context, template.border, data, OutlinedTextFieldKt.BorderId, this.component.getDivBorderJsonTemplateResolver(), this.component.getDivBorderJsonEntityParser());
            Expression expressionResolveOptionalExpression5 = JsonFieldResolver.resolveOptionalExpression(context, template.columnSpan, data, "column_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.COLUMN_SPAN_VALIDATOR);
            List listResolveOptionalList4 = JsonFieldResolver.resolveOptionalList(context, template.disappearActions, data, "disappear_actions", this.component.getDivDisappearActionJsonTemplateResolver(), this.component.getDivDisappearActionJsonEntityParser());
            List listResolveOptionalList5 = JsonFieldResolver.resolveOptionalList(context, template.doubletapActions, data, "doubletap_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            DivText.Ellipsis ellipsis = (DivText.Ellipsis) JsonFieldResolver.resolveOptional(context, template.ellipsis, data, "ellipsis", this.component.getDivTextEllipsisJsonTemplateResolver(), this.component.getDivTextEllipsisJsonEntityParser());
            List listResolveOptionalList6 = JsonFieldResolver.resolveOptionalList(context, template.extensions, data, "extensions", this.component.getDivExtensionJsonTemplateResolver(), this.component.getDivExtensionJsonEntityParser());
            DivFocus divFocus = (DivFocus) JsonFieldResolver.resolveOptional(context, template.focus, data, "focus", this.component.getDivFocusJsonTemplateResolver(), this.component.getDivFocusJsonEntityParser());
            Expression expressionResolveOptionalExpression6 = JsonFieldResolver.resolveOptionalExpression(context, template.focusedTextColor, data, "focused_text_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Expression expressionResolveOptionalExpression7 = JsonFieldResolver.resolveOptionalExpression(context, template.fontFamily, data, "font_family", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression expressionResolveOptionalExpression8 = JsonFieldResolver.resolveOptionalExpression(context, template.fontFeatureSettings, data, "font_feature_settings", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression<Long> expressionResolveOptionalExpression9 = JsonFieldResolver.resolveOptionalExpression(context, template.fontSize, data, ViewHierarchyConstants.TEXT_SIZE, TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.FONT_SIZE_VALIDATOR, DivTextJsonParser.FONT_SIZE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression9 == null) {
                expressionResolveOptionalExpression9 = DivTextJsonParser.FONT_SIZE_DEFAULT_VALUE;
            }
            Expression<Long> expression2 = expressionResolveOptionalExpression9;
            Expression<DivSizeUnit> expressionResolveOptionalExpression10 = JsonFieldResolver.resolveOptionalExpression(context, template.fontSizeUnit, data, "font_size_unit", DivTextJsonParser.TYPE_HELPER_FONT_SIZE_UNIT, DivSizeUnit.FROM_STRING, DivTextJsonParser.FONT_SIZE_UNIT_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression10 == null) {
                expressionResolveOptionalExpression10 = DivTextJsonParser.FONT_SIZE_UNIT_DEFAULT_VALUE;
            }
            Expression<DivSizeUnit> expression3 = expressionResolveOptionalExpression10;
            Expression<DivFontWeight> expressionResolveOptionalExpression11 = JsonFieldResolver.resolveOptionalExpression(context, template.fontWeight, data, FontsContractCompat.Columns.WEIGHT, DivTextJsonParser.TYPE_HELPER_FONT_WEIGHT, DivFontWeight.FROM_STRING, DivTextJsonParser.FONT_WEIGHT_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression11 == null) {
                expressionResolveOptionalExpression11 = DivTextJsonParser.FONT_WEIGHT_DEFAULT_VALUE;
            }
            Expression<DivFontWeight> expression4 = expressionResolveOptionalExpression11;
            Expression expressionResolveOptionalExpression12 = JsonFieldResolver.resolveOptionalExpression(context, template.fontWeightValue, data, "font_weight_value", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.FONT_WEIGHT_VALUE_VALIDATOR);
            List listResolveOptionalList7 = JsonFieldResolver.resolveOptionalList(context, template.functions, data, "functions", this.component.getDivFunctionJsonTemplateResolver(), this.component.getDivFunctionJsonEntityParser());
            DivSize.WrapContent wrapContent = (DivSize) JsonFieldResolver.resolveOptional(context, template.height, data, "height", this.component.getDivSizeJsonTemplateResolver(), this.component.getDivSizeJsonEntityParser());
            if (wrapContent == null) {
                wrapContent = DivTextJsonParser.HEIGHT_DEFAULT_VALUE;
            }
            DivSize divSize = wrapContent;
            Intrinsics.checkNotNullExpressionValue(divSize, "JsonFieldResolver.resolv…) ?: HEIGHT_DEFAULT_VALUE");
            List listResolveOptionalList8 = JsonFieldResolver.resolveOptionalList(context, template.hoverEndActions, data, "hover_end_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            List listResolveOptionalList9 = JsonFieldResolver.resolveOptionalList(context, template.hoverStartActions, data, "hover_start_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            String str = (String) JsonFieldResolver.resolveOptional(context, template.id, data, "id");
            List listResolveOptionalList10 = JsonFieldResolver.resolveOptionalList(context, template.images, data, "images", this.component.getDivTextImageJsonTemplateResolver(), this.component.getDivTextImageJsonEntityParser());
            DivLayoutProvider divLayoutProvider = (DivLayoutProvider) JsonFieldResolver.resolveOptional(context, template.layoutProvider, data, "layout_provider", this.component.getDivLayoutProviderJsonTemplateResolver(), this.component.getDivLayoutProviderJsonEntityParser());
            Expression<Double> expressionResolveOptionalExpression13 = JsonFieldResolver.resolveOptionalExpression(context, template.letterSpacing, data, "letter_spacing", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivTextJsonParser.LETTER_SPACING_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression13 == null) {
                expressionResolveOptionalExpression13 = DivTextJsonParser.LETTER_SPACING_DEFAULT_VALUE;
            }
            Expression<Double> expression5 = expressionResolveOptionalExpression13;
            Expression expressionResolveOptionalExpression14 = JsonFieldResolver.resolveOptionalExpression(context, template.lineHeight, data, "line_height", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.LINE_HEIGHT_VALIDATOR);
            List listResolveOptionalList11 = JsonFieldResolver.resolveOptionalList(context, template.longtapActions, data, "longtap_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            DivEdgeInsets divEdgeInsets = (DivEdgeInsets) JsonFieldResolver.resolveOptional(context, template.margins, data, "margins", this.component.getDivEdgeInsetsJsonTemplateResolver(), this.component.getDivEdgeInsetsJsonEntityParser());
            Expression expressionResolveOptionalExpression15 = JsonFieldResolver.resolveOptionalExpression(context, template.maxLines, data, "max_lines", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.MAX_LINES_VALIDATOR);
            Expression expressionResolveOptionalExpression16 = JsonFieldResolver.resolveOptionalExpression(context, template.minHiddenLines, data, "min_hidden_lines", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.MIN_HIDDEN_LINES_VALIDATOR);
            DivEdgeInsets divEdgeInsets2 = (DivEdgeInsets) JsonFieldResolver.resolveOptional(context, template.paddings, data, "paddings", this.component.getDivEdgeInsetsJsonTemplateResolver(), this.component.getDivEdgeInsetsJsonEntityParser());
            List listResolveOptionalList12 = JsonFieldResolver.resolveOptionalList(context, template.pressEndActions, data, "press_end_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            List listResolveOptionalList13 = JsonFieldResolver.resolveOptionalList(context, template.pressStartActions, data, "press_start_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            List listResolveOptionalList14 = JsonFieldResolver.resolveOptionalList(context, template.ranges, data, "ranges", this.component.getDivTextRangeJsonTemplateResolver(), this.component.getDivTextRangeJsonEntityParser());
            Expression expressionResolveOptionalExpression17 = JsonFieldResolver.resolveOptionalExpression(context, template.reuseId, data, "reuse_id", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression expressionResolveOptionalExpression18 = JsonFieldResolver.resolveOptionalExpression(context, template.rowSpan, data, "row_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivTextJsonParser.ROW_SPAN_VALIDATOR);
            Expression<Boolean> expressionResolveOptionalExpression19 = JsonFieldResolver.resolveOptionalExpression(context, template.selectable, data, "selectable", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivTextJsonParser.SELECTABLE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression19 == null) {
                expressionResolveOptionalExpression19 = DivTextJsonParser.SELECTABLE_DEFAULT_VALUE;
            }
            Expression<Boolean> expression6 = expressionResolveOptionalExpression19;
            List listResolveOptionalList15 = JsonFieldResolver.resolveOptionalList(context, template.selectedActions, data, "selected_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            Expression<DivLineStyle> expressionResolveOptionalExpression20 = JsonFieldResolver.resolveOptionalExpression(context, template.strike, data, "strike", DivTextJsonParser.TYPE_HELPER_STRIKE, DivLineStyle.FROM_STRING, DivTextJsonParser.STRIKE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression20 == null) {
                expressionResolveOptionalExpression20 = DivTextJsonParser.STRIKE_DEFAULT_VALUE;
            }
            Expression<DivLineStyle> expression7 = expressionResolveOptionalExpression20;
            Expression expressionResolveExpression = JsonFieldResolver.resolveExpression(context, template.text, data, "text", TypeHelpersKt.TYPE_HELPER_STRING);
            Intrinsics.checkNotNullExpressionValue(expressionResolveExpression, "resolveExpression(contex…ext\", TYPE_HELPER_STRING)");
            Expression<DivAlignmentHorizontal> expressionResolveOptionalExpression21 = JsonFieldResolver.resolveOptionalExpression(context, template.textAlignmentHorizontal, data, "text_alignment_horizontal", DivTextJsonParser.TYPE_HELPER_TEXT_ALIGNMENT_HORIZONTAL, DivAlignmentHorizontal.FROM_STRING, DivTextJsonParser.TEXT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression21 == null) {
                expressionResolveOptionalExpression21 = DivTextJsonParser.TEXT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE;
            }
            Expression<DivAlignmentHorizontal> expression8 = expressionResolveOptionalExpression21;
            Expression<DivAlignmentVertical> expressionResolveOptionalExpression22 = JsonFieldResolver.resolveOptionalExpression(context, template.textAlignmentVertical, data, "text_alignment_vertical", DivTextJsonParser.TYPE_HELPER_TEXT_ALIGNMENT_VERTICAL, DivAlignmentVertical.FROM_STRING, DivTextJsonParser.TEXT_ALIGNMENT_VERTICAL_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression22 == null) {
                expressionResolveOptionalExpression22 = DivTextJsonParser.TEXT_ALIGNMENT_VERTICAL_DEFAULT_VALUE;
            }
            Expression<DivAlignmentVertical> expression9 = expressionResolveOptionalExpression22;
            Expression<Integer> expressionResolveOptionalExpression23 = JsonFieldResolver.resolveOptionalExpression(context, template.textColor, data, "text_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT, DivTextJsonParser.TEXT_COLOR_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression23 == null) {
                expressionResolveOptionalExpression23 = DivTextJsonParser.TEXT_COLOR_DEFAULT_VALUE;
            }
            Expression<Integer> expression10 = expressionResolveOptionalExpression23;
            DivTextGradient divTextGradient = (DivTextGradient) JsonFieldResolver.resolveOptional(context, template.textGradient, data, "text_gradient", this.component.getDivTextGradientJsonTemplateResolver(), this.component.getDivTextGradientJsonEntityParser());
            DivShadow divShadow = (DivShadow) JsonFieldResolver.resolveOptional(context, template.textShadow, data, "text_shadow", this.component.getDivShadowJsonTemplateResolver(), this.component.getDivShadowJsonEntityParser());
            Expression<Boolean> expressionResolveOptionalExpression24 = JsonFieldResolver.resolveOptionalExpression(context, template.tightenWidth, data, "tighten_width", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivTextJsonParser.TIGHTEN_WIDTH_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression24 == null) {
                expressionResolveOptionalExpression24 = DivTextJsonParser.TIGHTEN_WIDTH_DEFAULT_VALUE;
            }
            Expression<Boolean> expression11 = expressionResolveOptionalExpression24;
            List listResolveOptionalList16 = JsonFieldResolver.resolveOptionalList(context, template.tooltips, data, "tooltips", this.component.getDivTooltipJsonTemplateResolver(), this.component.getDivTooltipJsonEntityParser());
            DivTransform divTransform = (DivTransform) JsonFieldResolver.resolveOptional(context, template.transform, data, "transform", this.component.getDivTransformJsonTemplateResolver(), this.component.getDivTransformJsonEntityParser());
            DivChangeTransition divChangeTransition = (DivChangeTransition) JsonFieldResolver.resolveOptional(context, template.transitionChange, data, "transition_change", this.component.getDivChangeTransitionJsonTemplateResolver(), this.component.getDivChangeTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition = (DivAppearanceTransition) JsonFieldResolver.resolveOptional(context, template.transitionIn, data, "transition_in", this.component.getDivAppearanceTransitionJsonTemplateResolver(), this.component.getDivAppearanceTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition2 = (DivAppearanceTransition) JsonFieldResolver.resolveOptional(context, template.transitionOut, data, "transition_out", this.component.getDivAppearanceTransitionJsonTemplateResolver(), this.component.getDivAppearanceTransitionJsonEntityParser());
            List listResolveOptionalList17 = JsonFieldResolver.resolveOptionalList(context, template.transitionTriggers, data, "transition_triggers", DivTransitionTrigger.FROM_STRING, DivTextJsonParser.TRANSITION_TRIGGERS_VALIDATOR);
            Expression<DivLineStyle> expressionResolveOptionalExpression25 = JsonFieldResolver.resolveOptionalExpression(context, template.underline, data, "underline", DivTextJsonParser.TYPE_HELPER_UNDERLINE, DivLineStyle.FROM_STRING, DivTextJsonParser.UNDERLINE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression25 == null) {
                expressionResolveOptionalExpression25 = DivTextJsonParser.UNDERLINE_DEFAULT_VALUE;
            }
            Expression<DivLineStyle> expression12 = expressionResolveOptionalExpression25;
            List listResolveOptionalList18 = JsonFieldResolver.resolveOptionalList(context, template.variableTriggers, data, "variable_triggers", this.component.getDivTriggerJsonTemplateResolver(), this.component.getDivTriggerJsonEntityParser());
            List listResolveOptionalList19 = JsonFieldResolver.resolveOptionalList(context, template.variables, data, "variables", this.component.getDivVariableJsonTemplateResolver(), this.component.getDivVariableJsonEntityParser());
            Expression<DivVisibility> expressionResolveOptionalExpression26 = JsonFieldResolver.resolveOptionalExpression(context, template.visibility, data, "visibility", DivTextJsonParser.TYPE_HELPER_VISIBILITY, DivVisibility.FROM_STRING, DivTextJsonParser.VISIBILITY_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression26 == null) {
                expressionResolveOptionalExpression26 = DivTextJsonParser.VISIBILITY_DEFAULT_VALUE;
            }
            Expression<DivVisibility> expression13 = expressionResolveOptionalExpression26;
            DivVisibilityAction divVisibilityAction = (DivVisibilityAction) JsonFieldResolver.resolveOptional(context, template.visibilityAction, data, "visibility_action", this.component.getDivVisibilityActionJsonTemplateResolver(), this.component.getDivVisibilityActionJsonEntityParser());
            List listResolveOptionalList20 = JsonFieldResolver.resolveOptionalList(context, template.visibilityActions, data, "visibility_actions", this.component.getDivVisibilityActionJsonTemplateResolver(), this.component.getDivVisibilityActionJsonEntityParser());
            DivSize.MatchParent matchParent = (DivSize) JsonFieldResolver.resolveOptional(context, template.width, data, "width", this.component.getDivSizeJsonTemplateResolver(), this.component.getDivSizeJsonEntityParser());
            if (matchParent == null) {
                matchParent = DivTextJsonParser.WIDTH_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(matchParent, "JsonFieldResolver.resolv…r) ?: WIDTH_DEFAULT_VALUE");
            return new DivText(divAccessibility, divAction, divAnimation2, listResolveOptionalList, expressionResolveOptionalExpression, expressionResolveOptionalExpression2, expression, listResolveOptionalList2, expressionResolveOptionalExpression4, listResolveOptionalList3, divBorder, expressionResolveOptionalExpression5, listResolveOptionalList4, listResolveOptionalList5, ellipsis, listResolveOptionalList6, divFocus, expressionResolveOptionalExpression6, expressionResolveOptionalExpression7, expressionResolveOptionalExpression8, expression2, expression3, expression4, expressionResolveOptionalExpression12, listResolveOptionalList7, divSize, listResolveOptionalList8, listResolveOptionalList9, str, listResolveOptionalList10, divLayoutProvider, expression5, expressionResolveOptionalExpression14, listResolveOptionalList11, divEdgeInsets, expressionResolveOptionalExpression15, expressionResolveOptionalExpression16, divEdgeInsets2, listResolveOptionalList12, listResolveOptionalList13, listResolveOptionalList14, expressionResolveOptionalExpression17, expressionResolveOptionalExpression18, expression6, listResolveOptionalList15, expression7, expressionResolveExpression, expression8, expression9, expression10, divTextGradient, divShadow, expression11, listResolveOptionalList16, divTransform, divChangeTransition, divAppearanceTransition, divAppearanceTransition2, listResolveOptionalList17, expression12, listResolveOptionalList18, listResolveOptionalList19, expression13, divVisibilityAction, listResolveOptionalList20, matchParent);
        }
    }

    /* JADX INFO: compiled from: DivTextJsonParser.kt */
    @Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001f0)8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020!0)8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0)8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110)8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001d0)8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001f0)8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\b\u0012\u0004\u0012\u00020!0)8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u001d0)8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00101\u001a\b\u0012\u0004\u0012\u0002020)8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\b\u0012\u0004\u0012\u0002020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0002068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/yandex/div2/DivTextJsonParser$Companion;", "", "()V", "ACTION_ANIMATION_DEFAULT_VALUE", "Lcom/yandex/div2/DivAnimation;", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "ALPHA_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "COLUMN_SPAN_VALIDATOR", "", "FONT_SIZE_DEFAULT_VALUE", "FONT_SIZE_UNIT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSizeUnit;", "FONT_SIZE_VALIDATOR", "FONT_WEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivFontWeight;", "FONT_WEIGHT_VALUE_VALIDATOR", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "LETTER_SPACING_DEFAULT_VALUE", "LINE_HEIGHT_VALIDATOR", "MAX_LINES_VALIDATOR", "MIN_HIDDEN_LINES_VALIDATOR", "ROW_SPAN_VALIDATOR", "SELECTABLE_DEFAULT_VALUE", "", "STRIKE_DEFAULT_VALUE", "Lcom/yandex/div2/DivLineStyle;", "TEXT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE", "Lcom/yandex/div2/DivAlignmentHorizontal;", "TEXT_ALIGNMENT_VERTICAL_DEFAULT_VALUE", "Lcom/yandex/div2/DivAlignmentVertical;", "TEXT_COLOR_DEFAULT_VALUE", "", "TIGHTEN_WIDTH_DEFAULT_VALUE", "TRANSITION_TRIGGERS_VALIDATOR", "Lcom/yandex/div/internal/parser/ListValidator;", "Lcom/yandex/div2/DivTransitionTrigger;", "TYPE_HELPER_ALIGNMENT_HORIZONTAL", "Lcom/yandex/div/internal/parser/TypeHelper;", "TYPE_HELPER_ALIGNMENT_VERTICAL", "TYPE_HELPER_FONT_SIZE_UNIT", "TYPE_HELPER_FONT_WEIGHT", "TYPE_HELPER_STRIKE", "TYPE_HELPER_TEXT_ALIGNMENT_HORIZONTAL", "TYPE_HELPER_TEXT_ALIGNMENT_VERTICAL", "TYPE_HELPER_UNDERLINE", "TYPE_HELPER_VISIBILITY", "Lcom/yandex/div2/DivVisibility;", "UNDERLINE_DEFAULT_VALUE", "VISIBILITY_DEFAULT_VALUE", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Expression expressionConstant = Expression.INSTANCE.constant(100L);
        Expression expressionConstant2 = Expression.INSTANCE.constant(Double.valueOf(0.6d));
        Expression expressionConstant3 = Expression.INSTANCE.constant(DivAnimation.Name.FADE);
        Expression.Companion companion = Expression.INSTANCE;
        Double dValueOf = Double.valueOf(1.0d);
        ACTION_ANIMATION_DEFAULT_VALUE = new DivAnimation(expressionConstant, expressionConstant2, null, null, expressionConstant3, null, null, companion.constant(dValueOf), 108, null);
        ALPHA_DEFAULT_VALUE = Expression.INSTANCE.constant(dValueOf);
        FONT_SIZE_DEFAULT_VALUE = Expression.INSTANCE.constant(12L);
        FONT_SIZE_UNIT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivSizeUnit.SP);
        FONT_WEIGHT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivFontWeight.REGULAR);
        HEIGHT_DEFAULT_VALUE = new DivSize.WrapContent(new DivWrapContentSize(null, null, null, 7, null));
        LETTER_SPACING_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(0.0d));
        SELECTABLE_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
        STRIKE_DEFAULT_VALUE = Expression.INSTANCE.constant(DivLineStyle.NONE);
        TEXT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAlignmentHorizontal.START);
        TEXT_ALIGNMENT_VERTICAL_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAlignmentVertical.TOP);
        TEXT_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
        TIGHTEN_WIDTH_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
        UNDERLINE_DEFAULT_VALUE = Expression.INSTANCE.constant(DivLineStyle.NONE);
        VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);
        WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0));
        TYPE_HELPER_ALIGNMENT_HORIZONTAL = TypeHelper.INSTANCE.from(ArraysKt.first(DivAlignmentHorizontal.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTextJsonParser$Companion$TYPE_HELPER_ALIGNMENT_HORIZONTAL$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivAlignmentHorizontal);
            }
        });
        TYPE_HELPER_ALIGNMENT_VERTICAL = TypeHelper.INSTANCE.from(ArraysKt.first(DivAlignmentVertical.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTextJsonParser$Companion$TYPE_HELPER_ALIGNMENT_VERTICAL$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivAlignmentVertical);
            }
        });
        TYPE_HELPER_FONT_SIZE_UNIT = TypeHelper.INSTANCE.from(ArraysKt.first(DivSizeUnit.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTextJsonParser$Companion$TYPE_HELPER_FONT_SIZE_UNIT$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivSizeUnit);
            }
        });
        TYPE_HELPER_FONT_WEIGHT = TypeHelper.INSTANCE.from(ArraysKt.first(DivFontWeight.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTextJsonParser$Companion$TYPE_HELPER_FONT_WEIGHT$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivFontWeight);
            }
        });
        TYPE_HELPER_STRIKE = TypeHelper.INSTANCE.from(ArraysKt.first(DivLineStyle.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTextJsonParser$Companion$TYPE_HELPER_STRIKE$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivLineStyle);
            }
        });
        TYPE_HELPER_TEXT_ALIGNMENT_HORIZONTAL = TypeHelper.INSTANCE.from(ArraysKt.first(DivAlignmentHorizontal.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTextJsonParser$Companion$TYPE_HELPER_TEXT_ALIGNMENT_HORIZONTAL$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivAlignmentHorizontal);
            }
        });
        TYPE_HELPER_TEXT_ALIGNMENT_VERTICAL = TypeHelper.INSTANCE.from(ArraysKt.first(DivAlignmentVertical.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTextJsonParser$Companion$TYPE_HELPER_TEXT_ALIGNMENT_VERTICAL$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivAlignmentVertical);
            }
        });
        TYPE_HELPER_UNDERLINE = TypeHelper.INSTANCE.from(ArraysKt.first(DivLineStyle.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTextJsonParser$Companion$TYPE_HELPER_UNDERLINE$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivLineStyle);
            }
        });
        TYPE_HELPER_VISIBILITY = TypeHelper.INSTANCE.from(ArraysKt.first(DivVisibility.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivTextJsonParser$Companion$TYPE_HELPER_VISIBILITY$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivVisibility);
            }
        });
        ALPHA_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTextJsonParser$$ExternalSyntheticLambda0
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivTextJsonParser.ALPHA_VALIDATOR$lambda$0(((Double) obj).doubleValue());
            }
        };
        COLUMN_SPAN_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTextJsonParser$$ExternalSyntheticLambda1
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivTextJsonParser.COLUMN_SPAN_VALIDATOR$lambda$1(((Long) obj).longValue());
            }
        };
        FONT_SIZE_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTextJsonParser$$ExternalSyntheticLambda2
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivTextJsonParser.FONT_SIZE_VALIDATOR$lambda$2(((Long) obj).longValue());
            }
        };
        FONT_WEIGHT_VALUE_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTextJsonParser$$ExternalSyntheticLambda3
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivTextJsonParser.FONT_WEIGHT_VALUE_VALIDATOR$lambda$3(((Long) obj).longValue());
            }
        };
        LINE_HEIGHT_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTextJsonParser$$ExternalSyntheticLambda4
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivTextJsonParser.LINE_HEIGHT_VALIDATOR$lambda$4(((Long) obj).longValue());
            }
        };
        MAX_LINES_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTextJsonParser$$ExternalSyntheticLambda5
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivTextJsonParser.MAX_LINES_VALIDATOR$lambda$5(((Long) obj).longValue());
            }
        };
        MIN_HIDDEN_LINES_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTextJsonParser$$ExternalSyntheticLambda6
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivTextJsonParser.MIN_HIDDEN_LINES_VALIDATOR$lambda$6(((Long) obj).longValue());
            }
        };
        ROW_SPAN_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivTextJsonParser$$ExternalSyntheticLambda7
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivTextJsonParser.ROW_SPAN_VALIDATOR$lambda$7(((Long) obj).longValue());
            }
        };
        TRANSITION_TRIGGERS_VALIDATOR = new ListValidator() { // from class: com.yandex.div2.DivTextJsonParser$$ExternalSyntheticLambda8
            @Override // com.yandex.div.internal.parser.ListValidator
            public final boolean isValid(List list) {
                return DivTextJsonParser.TRANSITION_TRIGGERS_VALIDATOR$lambda$8(list);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TRANSITION_TRIGGERS_VALIDATOR$lambda$8(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.size() >= 1;
    }
}
