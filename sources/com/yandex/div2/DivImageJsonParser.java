package com.yandex.div2;

import androidx.compose.material.OutlinedTextFieldKt;
import com.yandex.div.core.view2.divs.widgets.DivSeparatorView;
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

/* JADX INFO: compiled from: DivImageJsonParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivImageJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivImageJsonParser {

    @Deprecated
    public static final DivAnimation ACTION_ANIMATION_DEFAULT_VALUE;

    @Deprecated
    public static final Expression<Double> ALPHA_DEFAULT_VALUE;

    @Deprecated
    public static final ValueValidator<Double> ALPHA_VALIDATOR;

    @Deprecated
    public static final ValueValidator<Long> COLUMN_SPAN_VALIDATOR;

    @Deprecated
    public static final Expression<DivAlignmentHorizontal> CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE;

    @Deprecated
    public static final Expression<DivAlignmentVertical> CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final DivSize.WrapContent HEIGHT_DEFAULT_VALUE;

    @Deprecated
    public static final Expression<Boolean> HIGH_PRIORITY_PREVIEW_SHOW_DEFAULT_VALUE;

    @Deprecated
    public static final Expression<Integer> PLACEHOLDER_COLOR_DEFAULT_VALUE;

    @Deprecated
    public static final Expression<Boolean> PRELOAD_REQUIRED_DEFAULT_VALUE;

    @Deprecated
    public static final ValueValidator<Long> ROW_SPAN_VALIDATOR;

    @Deprecated
    public static final Expression<DivImageScale> SCALE_DEFAULT_VALUE;

    @Deprecated
    public static final Expression<DivBlendMode> TINT_MODE_DEFAULT_VALUE;

    @Deprecated
    public static final ListValidator<DivTransitionTrigger> TRANSITION_TRIGGERS_VALIDATOR;

    @Deprecated
    public static final TypeHelper<DivAlignmentHorizontal> TYPE_HELPER_ALIGNMENT_HORIZONTAL;

    @Deprecated
    public static final TypeHelper<DivAlignmentVertical> TYPE_HELPER_ALIGNMENT_VERTICAL;

    @Deprecated
    public static final TypeHelper<DivAlignmentHorizontal> TYPE_HELPER_CONTENT_ALIGNMENT_HORIZONTAL;

    @Deprecated
    public static final TypeHelper<DivAlignmentVertical> TYPE_HELPER_CONTENT_ALIGNMENT_VERTICAL;

    @Deprecated
    public static final TypeHelper<DivImageScale> TYPE_HELPER_SCALE;

    @Deprecated
    public static final TypeHelper<DivBlendMode> TYPE_HELPER_TINT_MODE;

    @Deprecated
    public static final TypeHelper<DivVisibility> TYPE_HELPER_VISIBILITY;

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
    public static final boolean ROW_SPAN_VALIDATOR$lambda$2(long j) {
        return j >= 0;
    }

    public DivImageJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivImageJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivImageJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivImage;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivImage> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivImage deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            DivAccessibility divAccessibility = (DivAccessibility) JsonPropertyParser.readOptional(context, data, "accessibility", this.component.getDivAccessibilityJsonEntityParser());
            DivAction divAction = (DivAction) JsonPropertyParser.readOptional(context, data, "action", this.component.getDivActionJsonEntityParser());
            DivAnimation divAnimation = (DivAnimation) JsonPropertyParser.readOptional(context, data, "action_animation", this.component.getDivAnimationJsonEntityParser());
            if (divAnimation == null) {
                divAnimation = DivImageJsonParser.ACTION_ANIMATION_DEFAULT_VALUE;
            }
            DivAnimation divAnimation2 = divAnimation;
            Intrinsics.checkNotNullExpressionValue(divAnimation2, "JsonPropertyParser.readO…N_ANIMATION_DEFAULT_VALUE");
            List optionalList = JsonPropertyParser.readOptionalList(context, data, "actions", this.component.getDivActionJsonEntityParser());
            Expression optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "alignment_horizontal", DivImageJsonParser.TYPE_HELPER_ALIGNMENT_HORIZONTAL, DivAlignmentHorizontal.FROM_STRING);
            Expression optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, "alignment_vertical", DivImageJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, DivAlignmentVertical.FROM_STRING);
            Expression<Double> optionalExpression3 = JsonExpressionParser.readOptionalExpression(context, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivImageJsonParser.ALPHA_VALIDATOR, DivImageJsonParser.ALPHA_DEFAULT_VALUE);
            if (optionalExpression3 == null) {
                optionalExpression3 = DivImageJsonParser.ALPHA_DEFAULT_VALUE;
            }
            Expression<Double> expression = optionalExpression3;
            List optionalList2 = JsonPropertyParser.readOptionalList(context, data, "animators", this.component.getDivAnimatorJsonEntityParser());
            DivFadeTransition divFadeTransition = (DivFadeTransition) JsonPropertyParser.readOptional(context, data, "appearance_animation", this.component.getDivFadeTransitionJsonEntityParser());
            DivAspect divAspect = (DivAspect) JsonPropertyParser.readOptional(context, data, "aspect", this.component.getDivAspectJsonEntityParser());
            List optionalList3 = JsonPropertyParser.readOptionalList(context, data, J2.g, this.component.getDivBackgroundJsonEntityParser());
            DivBorder divBorder = (DivBorder) JsonPropertyParser.readOptional(context, data, OutlinedTextFieldKt.BorderId, this.component.getDivBorderJsonEntityParser());
            Expression optionalExpression4 = JsonExpressionParser.readOptionalExpression(context, data, "column_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivImageJsonParser.COLUMN_SPAN_VALIDATOR);
            Expression<DivAlignmentHorizontal> optionalExpression5 = JsonExpressionParser.readOptionalExpression(context, data, "content_alignment_horizontal", DivImageJsonParser.TYPE_HELPER_CONTENT_ALIGNMENT_HORIZONTAL, DivAlignmentHorizontal.FROM_STRING, DivImageJsonParser.CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE);
            if (optionalExpression5 == null) {
                optionalExpression5 = DivImageJsonParser.CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE;
            }
            Expression<DivAlignmentHorizontal> expression2 = optionalExpression5;
            Expression<DivAlignmentVertical> optionalExpression6 = JsonExpressionParser.readOptionalExpression(context, data, "content_alignment_vertical", DivImageJsonParser.TYPE_HELPER_CONTENT_ALIGNMENT_VERTICAL, DivAlignmentVertical.FROM_STRING, DivImageJsonParser.CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE);
            if (optionalExpression6 == null) {
                optionalExpression6 = DivImageJsonParser.CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE;
            }
            Expression<DivAlignmentVertical> expression3 = optionalExpression6;
            List optionalList4 = JsonPropertyParser.readOptionalList(context, data, "disappear_actions", this.component.getDivDisappearActionJsonEntityParser());
            List optionalList5 = JsonPropertyParser.readOptionalList(context, data, "doubletap_actions", this.component.getDivActionJsonEntityParser());
            List optionalList6 = JsonPropertyParser.readOptionalList(context, data, "extensions", this.component.getDivExtensionJsonEntityParser());
            List optionalList7 = JsonPropertyParser.readOptionalList(context, data, "filters", this.component.getDivFilterJsonEntityParser());
            DivFocus divFocus = (DivFocus) JsonPropertyParser.readOptional(context, data, "focus", this.component.getDivFocusJsonEntityParser());
            List optionalList8 = JsonPropertyParser.readOptionalList(context, data, "functions", this.component.getDivFunctionJsonEntityParser());
            DivSize.WrapContent wrapContent = (DivSize) JsonPropertyParser.readOptional(context, data, "height", this.component.getDivSizeJsonEntityParser());
            if (wrapContent == null) {
                wrapContent = DivImageJsonParser.HEIGHT_DEFAULT_VALUE;
            }
            DivSize divSize = wrapContent;
            Intrinsics.checkNotNullExpressionValue(divSize, "JsonPropertyParser.readO…) ?: HEIGHT_DEFAULT_VALUE");
            Expression<Boolean> optionalExpression7 = JsonExpressionParser.readOptionalExpression(context, data, "high_priority_preview_show", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivImageJsonParser.HIGH_PRIORITY_PREVIEW_SHOW_DEFAULT_VALUE);
            if (optionalExpression7 == null) {
                optionalExpression7 = DivImageJsonParser.HIGH_PRIORITY_PREVIEW_SHOW_DEFAULT_VALUE;
            }
            Expression<Boolean> expression4 = optionalExpression7;
            List optionalList9 = JsonPropertyParser.readOptionalList(context, data, "hover_end_actions", this.component.getDivActionJsonEntityParser());
            List optionalList10 = JsonPropertyParser.readOptionalList(context, data, "hover_start_actions", this.component.getDivActionJsonEntityParser());
            String str = (String) JsonPropertyParser.readOptional(context, data, "id");
            Expression expression5 = JsonExpressionParser.readExpression(context, data, "image_url", TypeHelpersKt.TYPE_HELPER_URI, ParsingConvertersKt.ANY_TO_URI);
            Intrinsics.checkNotNullExpressionValue(expression5, "readExpression(context, …E_HELPER_URI, ANY_TO_URI)");
            DivLayoutProvider divLayoutProvider = (DivLayoutProvider) JsonPropertyParser.readOptional(context, data, "layout_provider", this.component.getDivLayoutProviderJsonEntityParser());
            List optionalList11 = JsonPropertyParser.readOptionalList(context, data, "longtap_actions", this.component.getDivActionJsonEntityParser());
            DivEdgeInsets divEdgeInsets = (DivEdgeInsets) JsonPropertyParser.readOptional(context, data, "margins", this.component.getDivEdgeInsetsJsonEntityParser());
            DivEdgeInsets divEdgeInsets2 = (DivEdgeInsets) JsonPropertyParser.readOptional(context, data, "paddings", this.component.getDivEdgeInsetsJsonEntityParser());
            Expression<Integer> optionalExpression8 = JsonExpressionParser.readOptionalExpression(context, data, "placeholder_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT, DivImageJsonParser.PLACEHOLDER_COLOR_DEFAULT_VALUE);
            if (optionalExpression8 == null) {
                optionalExpression8 = DivImageJsonParser.PLACEHOLDER_COLOR_DEFAULT_VALUE;
            }
            Expression<Integer> expression6 = optionalExpression8;
            Expression<Boolean> optionalExpression9 = JsonExpressionParser.readOptionalExpression(context, data, "preload_required", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivImageJsonParser.PRELOAD_REQUIRED_DEFAULT_VALUE);
            if (optionalExpression9 == null) {
                optionalExpression9 = DivImageJsonParser.PRELOAD_REQUIRED_DEFAULT_VALUE;
            }
            Expression<Boolean> expression7 = optionalExpression9;
            List optionalList12 = JsonPropertyParser.readOptionalList(context, data, "press_end_actions", this.component.getDivActionJsonEntityParser());
            List optionalList13 = JsonPropertyParser.readOptionalList(context, data, "press_start_actions", this.component.getDivActionJsonEntityParser());
            Expression<String> optionalExpression10 = JsonExpressionParser.readOptionalExpression(context, data, "preview", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression<String> optionalExpression11 = JsonExpressionParser.readOptionalExpression(context, data, "reuse_id", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression optionalExpression12 = JsonExpressionParser.readOptionalExpression(context, data, "row_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivImageJsonParser.ROW_SPAN_VALIDATOR);
            Expression<DivImageScale> optionalExpression13 = JsonExpressionParser.readOptionalExpression(context, data, "scale", DivImageJsonParser.TYPE_HELPER_SCALE, DivImageScale.FROM_STRING, DivImageJsonParser.SCALE_DEFAULT_VALUE);
            if (optionalExpression13 == null) {
                optionalExpression13 = DivImageJsonParser.SCALE_DEFAULT_VALUE;
            }
            Expression<DivImageScale> expression8 = optionalExpression13;
            List optionalList14 = JsonPropertyParser.readOptionalList(context, data, "selected_actions", this.component.getDivActionJsonEntityParser());
            Expression optionalExpression14 = JsonExpressionParser.readOptionalExpression(context, data, "tint_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Expression<DivBlendMode> optionalExpression15 = JsonExpressionParser.readOptionalExpression(context, data, "tint_mode", DivImageJsonParser.TYPE_HELPER_TINT_MODE, DivBlendMode.FROM_STRING, DivImageJsonParser.TINT_MODE_DEFAULT_VALUE);
            if (optionalExpression15 == null) {
                optionalExpression15 = DivImageJsonParser.TINT_MODE_DEFAULT_VALUE;
            }
            Expression<DivBlendMode> expression9 = optionalExpression15;
            List optionalList15 = JsonPropertyParser.readOptionalList(context, data, "tooltips", this.component.getDivTooltipJsonEntityParser());
            DivTransform divTransform = (DivTransform) JsonPropertyParser.readOptional(context, data, "transform", this.component.getDivTransformJsonEntityParser());
            DivChangeTransition divChangeTransition = (DivChangeTransition) JsonPropertyParser.readOptional(context, data, "transition_change", this.component.getDivChangeTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition = (DivAppearanceTransition) JsonPropertyParser.readOptional(context, data, "transition_in", this.component.getDivAppearanceTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition2 = (DivAppearanceTransition) JsonPropertyParser.readOptional(context, data, "transition_out", this.component.getDivAppearanceTransitionJsonEntityParser());
            List optionalList16 = JsonPropertyParser.readOptionalList(context, data, "transition_triggers", DivTransitionTrigger.FROM_STRING, DivImageJsonParser.TRANSITION_TRIGGERS_VALIDATOR);
            List optionalList17 = JsonPropertyParser.readOptionalList(context, data, "variable_triggers", this.component.getDivTriggerJsonEntityParser());
            List optionalList18 = JsonPropertyParser.readOptionalList(context, data, "variables", this.component.getDivVariableJsonEntityParser());
            Expression<DivVisibility> optionalExpression16 = JsonExpressionParser.readOptionalExpression(context, data, "visibility", DivImageJsonParser.TYPE_HELPER_VISIBILITY, DivVisibility.FROM_STRING, DivImageJsonParser.VISIBILITY_DEFAULT_VALUE);
            if (optionalExpression16 == null) {
                optionalExpression16 = DivImageJsonParser.VISIBILITY_DEFAULT_VALUE;
            }
            DivVisibilityAction divVisibilityAction = (DivVisibilityAction) JsonPropertyParser.readOptional(context, data, "visibility_action", this.component.getDivVisibilityActionJsonEntityParser());
            List optionalList19 = JsonPropertyParser.readOptionalList(context, data, "visibility_actions", this.component.getDivVisibilityActionJsonEntityParser());
            DivSize.MatchParent matchParent = (DivSize) JsonPropertyParser.readOptional(context, data, "width", this.component.getDivSizeJsonEntityParser());
            if (matchParent == null) {
                matchParent = DivImageJsonParser.WIDTH_DEFAULT_VALUE;
            }
            DivSize divSize2 = matchParent;
            Intrinsics.checkNotNullExpressionValue(divSize2, "JsonPropertyParser.readO…r) ?: WIDTH_DEFAULT_VALUE");
            return new DivImage(divAccessibility, divAction, divAnimation2, optionalList, optionalExpression, optionalExpression2, expression, optionalList2, divFadeTransition, divAspect, optionalList3, divBorder, optionalExpression4, expression2, expression3, optionalList4, optionalList5, optionalList6, optionalList7, divFocus, optionalList8, divSize, expression4, optionalList9, optionalList10, str, expression5, divLayoutProvider, optionalList11, divEdgeInsets, divEdgeInsets2, expression6, expression7, optionalList12, optionalList13, optionalExpression10, optionalExpression11, optionalExpression12, expression8, optionalList14, optionalExpression14, expression9, optionalList15, divTransform, divChangeTransition, divAppearanceTransition, divAppearanceTransition2, optionalList16, optionalList17, optionalList18, optionalExpression16, divVisibilityAction, optionalList19, divSize2);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivImage value) throws ParsingException {
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
            JsonPropertyParser.write(context, jSONObject, "appearance_animation", value.appearanceAnimation, this.component.getDivFadeTransitionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "aspect", value.aspect, this.component.getDivAspectJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, J2.g, value.getBackground(), this.component.getDivBackgroundJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, OutlinedTextFieldKt.BorderId, value.getBorder(), this.component.getDivBorderJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "column_span", value.getColumnSpan());
            JsonExpressionParser.writeExpression(context, jSONObject, "content_alignment_horizontal", value.contentAlignmentHorizontal, DivAlignmentHorizontal.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "content_alignment_vertical", value.contentAlignmentVertical, DivAlignmentVertical.TO_STRING);
            JsonPropertyParser.writeList(context, jSONObject, "disappear_actions", value.getDisappearActions(), this.component.getDivDisappearActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "doubletap_actions", value.doubletapActions, this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "extensions", value.getExtensions(), this.component.getDivExtensionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "filters", value.filters, this.component.getDivFilterJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "focus", value.getFocus(), this.component.getDivFocusJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "functions", value.getFunctions(), this.component.getDivFunctionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "height", value.getHeight(), this.component.getDivSizeJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "high_priority_preview_show", value.highPriorityPreviewShow);
            JsonPropertyParser.writeList(context, jSONObject, "hover_end_actions", value.hoverEndActions, this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "hover_start_actions", value.hoverStartActions, this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "id", value.getId());
            JsonExpressionParser.writeExpression(context, jSONObject, "image_url", value.imageUrl, ParsingConvertersKt.URI_TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "layout_provider", value.getLayoutProvider(), this.component.getDivLayoutProviderJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "longtap_actions", value.longtapActions, this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "margins", value.getMargins(), this.component.getDivEdgeInsetsJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "paddings", value.getPaddings(), this.component.getDivEdgeInsetsJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "placeholder_color", value.placeholderColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "preload_required", value.preloadRequired);
            JsonPropertyParser.writeList(context, jSONObject, "press_end_actions", value.pressEndActions, this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "press_start_actions", value.pressStartActions, this.component.getDivActionJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "preview", value.preview);
            JsonExpressionParser.writeExpression(context, jSONObject, "reuse_id", value.getReuseId());
            JsonExpressionParser.writeExpression(context, jSONObject, "row_span", value.getRowSpan());
            JsonExpressionParser.writeExpression(context, jSONObject, "scale", value.scale, DivImageScale.TO_STRING);
            JsonPropertyParser.writeList(context, jSONObject, "selected_actions", value.getSelectedActions(), this.component.getDivActionJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "tint_color", value.tintColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "tint_mode", value.tintMode, DivBlendMode.TO_STRING);
            JsonPropertyParser.writeList(context, jSONObject, "tooltips", value.getTooltips(), this.component.getDivTooltipJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transform", value.getTransform(), this.component.getDivTransformJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transition_change", value.getTransitionChange(), this.component.getDivChangeTransitionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transition_in", value.getTransitionIn(), this.component.getDivAppearanceTransitionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transition_out", value.getTransitionOut(), this.component.getDivAppearanceTransitionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "transition_triggers", value.getTransitionTriggers(), DivTransitionTrigger.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "type", "image");
            JsonPropertyParser.writeList(context, jSONObject, "variable_triggers", value.getVariableTriggers(), this.component.getDivTriggerJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "variables", value.getVariables(), this.component.getDivVariableJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "visibility", value.getVisibility(), DivVisibility.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "visibility_action", value.getVisibilityAction(), this.component.getDivVisibilityActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "visibility_actions", value.getVisibilityActions(), this.component.getDivVisibilityActionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "width", value.getWidth(), this.component.getDivSizeJsonEntityParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivImageJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivImageJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivImageTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivImageTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivImageTemplate deserialize(ParsingContext context, DivImageTemplate parent, JSONObject data) throws ParsingException {
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
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alignment_horizontal", DivImageJsonParser.TYPE_HELPER_ALIGNMENT_HORIZONTAL, allowPropertyOverride, parent != null ? parent.alignmentHorizontal : null, DivAlignmentHorizontal.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…ntHorizontal.FROM_STRING)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alignment_vertical", DivImageJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, allowPropertyOverride, parent != null ? parent.alignmentVertical : null, DivAlignmentVertical.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…mentVertical.FROM_STRING)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.alpha : null, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivImageJsonParser.ALPHA_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…_DOUBLE, ALPHA_VALIDATOR)");
            Field optionalListField2 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "animators", allowPropertyOverride, parent != null ? parent.animators : null, this.component.getDivAnimatorJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField2, "readOptionalListField(co…imatorJsonTemplateParser)");
            Field optionalField4 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "appearance_animation", allowPropertyOverride, parent != null ? parent.appearanceAnimation : null, this.component.getDivFadeTransitionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField4, "readOptionalField(contex…sitionJsonTemplateParser)");
            Field optionalField5 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "aspect", allowPropertyOverride, parent != null ? parent.aspect : null, this.component.getDivAspectJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField5, "readOptionalField(contex…AspectJsonTemplateParser)");
            Field optionalListField3 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, J2.g, allowPropertyOverride, parent != null ? parent.background : null, this.component.getDivBackgroundJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField3, "readOptionalListField(co…groundJsonTemplateParser)");
            Field optionalField6 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, OutlinedTextFieldKt.BorderId, allowPropertyOverride, parent != null ? parent.border : null, this.component.getDivBorderJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField6, "readOptionalField(contex…BorderJsonTemplateParser)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "column_span", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.columnSpan : null, ParsingConvertersKt.NUMBER_TO_INT, DivImageJsonParser.COLUMN_SPAN_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…T, COLUMN_SPAN_VALIDATOR)");
            Field optionalFieldWithExpression5 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "content_alignment_horizontal", DivImageJsonParser.TYPE_HELPER_CONTENT_ALIGNMENT_HORIZONTAL, allowPropertyOverride, parent != null ? parent.contentAlignmentHorizontal : null, DivAlignmentHorizontal.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression5, "readOptionalFieldWithExp…ntHorizontal.FROM_STRING)");
            Field optionalFieldWithExpression6 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "content_alignment_vertical", DivImageJsonParser.TYPE_HELPER_CONTENT_ALIGNMENT_VERTICAL, allowPropertyOverride, parent != null ? parent.contentAlignmentVertical : null, DivAlignmentVertical.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression6, "readOptionalFieldWithExp…mentVertical.FROM_STRING)");
            Field optionalListField4 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "disappear_actions", allowPropertyOverride, parent != null ? parent.disappearActions : null, this.component.getDivDisappearActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField4, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalListField5 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "doubletap_actions", allowPropertyOverride, parent != null ? parent.doubletapActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField5, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalListField6 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "extensions", allowPropertyOverride, parent != null ? parent.extensions : null, this.component.getDivExtensionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField6, "readOptionalListField(co…ensionJsonTemplateParser)");
            Field optionalListField7 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "filters", allowPropertyOverride, parent != null ? parent.filters : null, this.component.getDivFilterJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField7, "readOptionalListField(co…FilterJsonTemplateParser)");
            Field optionalField7 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "focus", allowPropertyOverride, parent != null ? parent.focus : null, this.component.getDivFocusJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField7, "readOptionalField(contex…vFocusJsonTemplateParser)");
            Field optionalListField8 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "functions", allowPropertyOverride, parent != null ? parent.functions : null, this.component.getDivFunctionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField8, "readOptionalListField(co…nctionJsonTemplateParser)");
            Field optionalField8 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "height", allowPropertyOverride, parent != null ? parent.height : null, this.component.getDivSizeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField8, "readOptionalField(contex…ivSizeJsonTemplateParser)");
            Field optionalFieldWithExpression7 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "high_priority_preview_show", TypeHelpersKt.TYPE_HELPER_BOOLEAN, allowPropertyOverride, parent != null ? parent.highPriorityPreviewShow : null, ParsingConvertersKt.ANY_TO_BOOLEAN);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression7, "readOptionalFieldWithExp…viewShow, ANY_TO_BOOLEAN)");
            Field optionalListField9 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "hover_end_actions", allowPropertyOverride, parent != null ? parent.hoverEndActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField9, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalListField10 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "hover_start_actions", allowPropertyOverride, parent != null ? parent.hoverStartActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField10, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalField9 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "id", allowPropertyOverride, parent != null ? parent.id : null);
            Intrinsics.checkNotNullExpressionValue(optionalField9, "readOptionalField(contex…llowOverride, parent?.id)");
            Field fieldWithExpression = JsonFieldParser.readFieldWithExpression(parsingContextRestrictPropertyOverride, data, "image_url", TypeHelpersKt.TYPE_HELPER_URI, allowPropertyOverride, parent != null ? parent.imageUrl : null, ParsingConvertersKt.ANY_TO_URI);
            Intrinsics.checkNotNullExpressionValue(fieldWithExpression, "readFieldWithExpression(…nt?.imageUrl, ANY_TO_URI)");
            Field optionalField10 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "layout_provider", allowPropertyOverride, parent != null ? parent.layoutProvider : null, this.component.getDivLayoutProviderJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField10, "readOptionalField(contex…oviderJsonTemplateParser)");
            Field optionalListField11 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "longtap_actions", allowPropertyOverride, parent != null ? parent.longtapActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField11, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalField11 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "margins", allowPropertyOverride, parent != null ? parent.margins : null, this.component.getDivEdgeInsetsJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField11, "readOptionalField(contex…InsetsJsonTemplateParser)");
            Field optionalField12 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "paddings", allowPropertyOverride, parent != null ? parent.paddings : null, this.component.getDivEdgeInsetsJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField12, "readOptionalField(contex…InsetsJsonTemplateParser)");
            Field optionalFieldWithExpression8 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "placeholder_color", TypeHelpersKt.TYPE_HELPER_COLOR, allowPropertyOverride, parent != null ? parent.placeholderColor : null, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression8, "readOptionalFieldWithExp…lor, STRING_TO_COLOR_INT)");
            Field optionalFieldWithExpression9 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "preload_required", TypeHelpersKt.TYPE_HELPER_BOOLEAN, allowPropertyOverride, parent != null ? parent.preloadRequired : null, ParsingConvertersKt.ANY_TO_BOOLEAN);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression9, "readOptionalFieldWithExp…Required, ANY_TO_BOOLEAN)");
            Field optionalListField12 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "press_end_actions", allowPropertyOverride, parent != null ? parent.pressEndActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField12, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalListField13 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "press_start_actions", allowPropertyOverride, parent != null ? parent.pressStartActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField13, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field<Expression<String>> optionalFieldWithExpression10 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "preview", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.preview : null);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression10, "readOptionalFieldWithExp…verride, parent?.preview)");
            Field<Expression<String>> optionalFieldWithExpression11 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "reuse_id", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.reuseId : null);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression11, "readOptionalFieldWithExp…verride, parent?.reuseId)");
            Field optionalFieldWithExpression12 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "row_span", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.rowSpan : null, ParsingConvertersKt.NUMBER_TO_INT, DivImageJsonParser.ROW_SPAN_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression12, "readOptionalFieldWithExp…_INT, ROW_SPAN_VALIDATOR)");
            Field optionalFieldWithExpression13 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "scale", DivImageJsonParser.TYPE_HELPER_SCALE, allowPropertyOverride, parent != null ? parent.scale : null, DivImageScale.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression13, "readOptionalFieldWithExp…ivImageScale.FROM_STRING)");
            Field optionalListField14 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "selected_actions", allowPropertyOverride, parent != null ? parent.selectedActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField14, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalFieldWithExpression14 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "tint_color", TypeHelpersKt.TYPE_HELPER_COLOR, allowPropertyOverride, parent != null ? parent.tintColor : null, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression14, "readOptionalFieldWithExp…lor, STRING_TO_COLOR_INT)");
            Field optionalFieldWithExpression15 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "tint_mode", DivImageJsonParser.TYPE_HELPER_TINT_MODE, allowPropertyOverride, parent != null ? parent.tintMode : null, DivBlendMode.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression15, "readOptionalFieldWithExp…DivBlendMode.FROM_STRING)");
            Field optionalListField15 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "tooltips", allowPropertyOverride, parent != null ? parent.tooltips : null, this.component.getDivTooltipJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField15, "readOptionalListField(co…ooltipJsonTemplateParser)");
            Field optionalField13 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transform", allowPropertyOverride, parent != null ? parent.transform : null, this.component.getDivTransformJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField13, "readOptionalField(contex…nsformJsonTemplateParser)");
            Field optionalField14 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transition_change", allowPropertyOverride, parent != null ? parent.transitionChange : null, this.component.getDivChangeTransitionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField14, "readOptionalField(contex…sitionJsonTemplateParser)");
            Field optionalField15 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transition_in", allowPropertyOverride, parent != null ? parent.transitionIn : null, this.component.getDivAppearanceTransitionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField15, "readOptionalField(contex…sitionJsonTemplateParser)");
            Field optionalField16 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transition_out", allowPropertyOverride, parent != null ? parent.transitionOut : null, this.component.getDivAppearanceTransitionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField16, "readOptionalField(contex…sitionJsonTemplateParser)");
            Field<List<DivTransitionTrigger>> field = parent != null ? parent.transitionTriggers : null;
            Function1<String, DivTransitionTrigger> function1 = DivTransitionTrigger.FROM_STRING;
            ListValidator<DivTransitionTrigger> listValidator = DivImageJsonParser.TRANSITION_TRIGGERS_VALIDATOR;
            Intrinsics.checkNotNull(listValidator, "null cannot be cast to non-null type com.yandex.div.internal.parser.ListValidator<T of com.yandex.div.internal.parser.ParsingValidatorsKt.cast>");
            Field optionalListField16 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "transition_triggers", allowPropertyOverride, field, function1, listValidator);
            Intrinsics.checkNotNullExpressionValue(optionalListField16, "readOptionalListField(co…RIGGERS_VALIDATOR.cast())");
            Field optionalListField17 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "variable_triggers", allowPropertyOverride, parent != null ? parent.variableTriggers : null, this.component.getDivTriggerJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField17, "readOptionalListField(co…riggerJsonTemplateParser)");
            Field optionalListField18 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "variables", allowPropertyOverride, parent != null ? parent.variables : null, this.component.getDivVariableJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField18, "readOptionalListField(co…riableJsonTemplateParser)");
            Field optionalFieldWithExpression16 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "visibility", DivImageJsonParser.TYPE_HELPER_VISIBILITY, allowPropertyOverride, parent != null ? parent.visibility : null, DivVisibility.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression16, "readOptionalFieldWithExp…ivVisibility.FROM_STRING)");
            Field optionalField17 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "visibility_action", allowPropertyOverride, parent != null ? parent.visibilityAction : null, this.component.getDivVisibilityActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField17, "readOptionalField(contex…ActionJsonTemplateParser)");
            Field optionalListField19 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "visibility_actions", allowPropertyOverride, parent != null ? parent.visibilityActions : null, this.component.getDivVisibilityActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField19, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalField18 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "width", allowPropertyOverride, parent != null ? parent.width : null, this.component.getDivSizeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField18, "readOptionalField(contex…ivSizeJsonTemplateParser)");
            return new DivImageTemplate(optionalField, optionalField2, optionalField3, optionalListField, optionalFieldWithExpression, optionalFieldWithExpression2, optionalFieldWithExpression3, optionalListField2, optionalField4, optionalField5, optionalListField3, optionalField6, optionalFieldWithExpression4, optionalFieldWithExpression5, optionalFieldWithExpression6, optionalListField4, optionalListField5, optionalListField6, optionalListField7, optionalField7, optionalListField8, optionalField8, optionalFieldWithExpression7, optionalListField9, optionalListField10, optionalField9, fieldWithExpression, optionalField10, optionalListField11, optionalField11, optionalField12, optionalFieldWithExpression8, optionalFieldWithExpression9, optionalListField12, optionalListField13, optionalFieldWithExpression10, optionalFieldWithExpression11, optionalFieldWithExpression12, optionalFieldWithExpression13, optionalListField14, optionalFieldWithExpression14, optionalFieldWithExpression15, optionalListField15, optionalField13, optionalField14, optionalField15, optionalField16, optionalListField16, optionalListField17, optionalListField18, optionalFieldWithExpression16, optionalField17, optionalListField19, optionalField18);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivImageTemplate value) throws ParsingException {
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
            JsonFieldParser.writeField(context, jSONObject, "appearance_animation", value.appearanceAnimation, this.component.getDivFadeTransitionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "aspect", value.aspect, this.component.getDivAspectJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, J2.g, value.background, this.component.getDivBackgroundJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, OutlinedTextFieldKt.BorderId, value.border, this.component.getDivBorderJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "column_span", value.columnSpan);
            JsonFieldParser.writeExpressionField(context, jSONObject, "content_alignment_horizontal", value.contentAlignmentHorizontal, DivAlignmentHorizontal.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "content_alignment_vertical", value.contentAlignmentVertical, DivAlignmentVertical.TO_STRING);
            JsonFieldParser.writeListField(context, jSONObject, "disappear_actions", value.disappearActions, this.component.getDivDisappearActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "doubletap_actions", value.doubletapActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "extensions", value.extensions, this.component.getDivExtensionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "filters", value.filters, this.component.getDivFilterJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "focus", value.focus, this.component.getDivFocusJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "functions", value.functions, this.component.getDivFunctionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "height", value.height, this.component.getDivSizeJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "high_priority_preview_show", value.highPriorityPreviewShow);
            JsonFieldParser.writeListField(context, jSONObject, "hover_end_actions", value.hoverEndActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "hover_start_actions", value.hoverStartActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "id", value.id);
            JsonFieldParser.writeExpressionField(context, jSONObject, "image_url", value.imageUrl, ParsingConvertersKt.URI_TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "layout_provider", value.layoutProvider, this.component.getDivLayoutProviderJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "longtap_actions", value.longtapActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "margins", value.margins, this.component.getDivEdgeInsetsJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "paddings", value.paddings, this.component.getDivEdgeInsetsJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "placeholder_color", value.placeholderColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "preload_required", value.preloadRequired);
            JsonFieldParser.writeListField(context, jSONObject, "press_end_actions", value.pressEndActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "press_start_actions", value.pressStartActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "preview", value.preview);
            JsonFieldParser.writeExpressionField(context, jSONObject, "reuse_id", value.reuseId);
            JsonFieldParser.writeExpressionField(context, jSONObject, "row_span", value.rowSpan);
            JsonFieldParser.writeExpressionField(context, jSONObject, "scale", value.scale, DivImageScale.TO_STRING);
            JsonFieldParser.writeListField(context, jSONObject, "selected_actions", value.selectedActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "tint_color", value.tintColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "tint_mode", value.tintMode, DivBlendMode.TO_STRING);
            JsonFieldParser.writeListField(context, jSONObject, "tooltips", value.tooltips, this.component.getDivTooltipJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transform", value.transform, this.component.getDivTransformJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transition_change", value.transitionChange, this.component.getDivChangeTransitionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transition_in", value.transitionIn, this.component.getDivAppearanceTransitionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transition_out", value.transitionOut, this.component.getDivAppearanceTransitionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "transition_triggers", value.transitionTriggers, DivTransitionTrigger.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "type", "image");
            JsonFieldParser.writeListField(context, jSONObject, "variable_triggers", value.variableTriggers, this.component.getDivTriggerJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "variables", value.variables, this.component.getDivVariableJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "visibility", value.visibility, DivVisibility.TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "visibility_action", value.visibilityAction, this.component.getDivVisibilityActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "visibility_actions", value.visibilityActions, this.component.getDivVisibilityActionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "width", value.width, this.component.getDivSizeJsonTemplateParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivImageJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivImageJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivImageTemplate;", "Lcom/yandex/div2/DivImage;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivImageTemplate, DivImage> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivImage resolve(ParsingContext context, DivImageTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            DivAccessibility divAccessibility = (DivAccessibility) JsonFieldResolver.resolveOptional(context, template.accessibility, data, "accessibility", this.component.getDivAccessibilityJsonTemplateResolver(), this.component.getDivAccessibilityJsonEntityParser());
            DivAction divAction = (DivAction) JsonFieldResolver.resolveOptional(context, template.action, data, "action", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            DivAnimation divAnimation = (DivAnimation) JsonFieldResolver.resolveOptional(context, template.actionAnimation, data, "action_animation", this.component.getDivAnimationJsonTemplateResolver(), this.component.getDivAnimationJsonEntityParser());
            if (divAnimation == null) {
                divAnimation = DivImageJsonParser.ACTION_ANIMATION_DEFAULT_VALUE;
            }
            DivAnimation divAnimation2 = divAnimation;
            Intrinsics.checkNotNullExpressionValue(divAnimation2, "JsonFieldResolver.resolv…N_ANIMATION_DEFAULT_VALUE");
            List listResolveOptionalList = JsonFieldResolver.resolveOptionalList(context, template.actions, data, "actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            Expression expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.alignmentHorizontal, data, "alignment_horizontal", DivImageJsonParser.TYPE_HELPER_ALIGNMENT_HORIZONTAL, DivAlignmentHorizontal.FROM_STRING);
            Expression expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.alignmentVertical, data, "alignment_vertical", DivImageJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, DivAlignmentVertical.FROM_STRING);
            Expression<Double> expressionResolveOptionalExpression3 = JsonFieldResolver.resolveOptionalExpression(context, template.alpha, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivImageJsonParser.ALPHA_VALIDATOR, DivImageJsonParser.ALPHA_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression3 == null) {
                expressionResolveOptionalExpression3 = DivImageJsonParser.ALPHA_DEFAULT_VALUE;
            }
            Expression<Double> expression = expressionResolveOptionalExpression3;
            List listResolveOptionalList2 = JsonFieldResolver.resolveOptionalList(context, template.animators, data, "animators", this.component.getDivAnimatorJsonTemplateResolver(), this.component.getDivAnimatorJsonEntityParser());
            DivFadeTransition divFadeTransition = (DivFadeTransition) JsonFieldResolver.resolveOptional(context, template.appearanceAnimation, data, "appearance_animation", this.component.getDivFadeTransitionJsonTemplateResolver(), this.component.getDivFadeTransitionJsonEntityParser());
            DivAspect divAspect = (DivAspect) JsonFieldResolver.resolveOptional(context, template.aspect, data, "aspect", this.component.getDivAspectJsonTemplateResolver(), this.component.getDivAspectJsonEntityParser());
            List listResolveOptionalList3 = JsonFieldResolver.resolveOptionalList(context, template.background, data, J2.g, this.component.getDivBackgroundJsonTemplateResolver(), this.component.getDivBackgroundJsonEntityParser());
            DivBorder divBorder = (DivBorder) JsonFieldResolver.resolveOptional(context, template.border, data, OutlinedTextFieldKt.BorderId, this.component.getDivBorderJsonTemplateResolver(), this.component.getDivBorderJsonEntityParser());
            Expression expressionResolveOptionalExpression4 = JsonFieldResolver.resolveOptionalExpression(context, template.columnSpan, data, "column_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivImageJsonParser.COLUMN_SPAN_VALIDATOR);
            Expression<DivAlignmentHorizontal> expressionResolveOptionalExpression5 = JsonFieldResolver.resolveOptionalExpression(context, template.contentAlignmentHorizontal, data, "content_alignment_horizontal", DivImageJsonParser.TYPE_HELPER_CONTENT_ALIGNMENT_HORIZONTAL, DivAlignmentHorizontal.FROM_STRING, DivImageJsonParser.CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression5 == null) {
                expressionResolveOptionalExpression5 = DivImageJsonParser.CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE;
            }
            Expression<DivAlignmentHorizontal> expression2 = expressionResolveOptionalExpression5;
            Expression<DivAlignmentVertical> expressionResolveOptionalExpression6 = JsonFieldResolver.resolveOptionalExpression(context, template.contentAlignmentVertical, data, "content_alignment_vertical", DivImageJsonParser.TYPE_HELPER_CONTENT_ALIGNMENT_VERTICAL, DivAlignmentVertical.FROM_STRING, DivImageJsonParser.CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression6 == null) {
                expressionResolveOptionalExpression6 = DivImageJsonParser.CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE;
            }
            Expression<DivAlignmentVertical> expression3 = expressionResolveOptionalExpression6;
            List listResolveOptionalList4 = JsonFieldResolver.resolveOptionalList(context, template.disappearActions, data, "disappear_actions", this.component.getDivDisappearActionJsonTemplateResolver(), this.component.getDivDisappearActionJsonEntityParser());
            List listResolveOptionalList5 = JsonFieldResolver.resolveOptionalList(context, template.doubletapActions, data, "doubletap_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            List listResolveOptionalList6 = JsonFieldResolver.resolveOptionalList(context, template.extensions, data, "extensions", this.component.getDivExtensionJsonTemplateResolver(), this.component.getDivExtensionJsonEntityParser());
            List listResolveOptionalList7 = JsonFieldResolver.resolveOptionalList(context, template.filters, data, "filters", this.component.getDivFilterJsonTemplateResolver(), this.component.getDivFilterJsonEntityParser());
            DivFocus divFocus = (DivFocus) JsonFieldResolver.resolveOptional(context, template.focus, data, "focus", this.component.getDivFocusJsonTemplateResolver(), this.component.getDivFocusJsonEntityParser());
            List listResolveOptionalList8 = JsonFieldResolver.resolveOptionalList(context, template.functions, data, "functions", this.component.getDivFunctionJsonTemplateResolver(), this.component.getDivFunctionJsonEntityParser());
            DivSize.WrapContent wrapContent = (DivSize) JsonFieldResolver.resolveOptional(context, template.height, data, "height", this.component.getDivSizeJsonTemplateResolver(), this.component.getDivSizeJsonEntityParser());
            if (wrapContent == null) {
                wrapContent = DivImageJsonParser.HEIGHT_DEFAULT_VALUE;
            }
            DivSize divSize = wrapContent;
            Intrinsics.checkNotNullExpressionValue(divSize, "JsonFieldResolver.resolv…) ?: HEIGHT_DEFAULT_VALUE");
            Expression<Boolean> expressionResolveOptionalExpression7 = JsonFieldResolver.resolveOptionalExpression(context, template.highPriorityPreviewShow, data, "high_priority_preview_show", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivImageJsonParser.HIGH_PRIORITY_PREVIEW_SHOW_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression7 == null) {
                expressionResolveOptionalExpression7 = DivImageJsonParser.HIGH_PRIORITY_PREVIEW_SHOW_DEFAULT_VALUE;
            }
            Expression<Boolean> expression4 = expressionResolveOptionalExpression7;
            List listResolveOptionalList9 = JsonFieldResolver.resolveOptionalList(context, template.hoverEndActions, data, "hover_end_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            List listResolveOptionalList10 = JsonFieldResolver.resolveOptionalList(context, template.hoverStartActions, data, "hover_start_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            String str = (String) JsonFieldResolver.resolveOptional(context, template.id, data, "id");
            Expression expressionResolveExpression = JsonFieldResolver.resolveExpression(context, template.imageUrl, data, "image_url", TypeHelpersKt.TYPE_HELPER_URI, ParsingConvertersKt.ANY_TO_URI);
            Intrinsics.checkNotNullExpressionValue(expressionResolveExpression, "resolveExpression(contex…E_HELPER_URI, ANY_TO_URI)");
            DivLayoutProvider divLayoutProvider = (DivLayoutProvider) JsonFieldResolver.resolveOptional(context, template.layoutProvider, data, "layout_provider", this.component.getDivLayoutProviderJsonTemplateResolver(), this.component.getDivLayoutProviderJsonEntityParser());
            List listResolveOptionalList11 = JsonFieldResolver.resolveOptionalList(context, template.longtapActions, data, "longtap_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            DivEdgeInsets divEdgeInsets = (DivEdgeInsets) JsonFieldResolver.resolveOptional(context, template.margins, data, "margins", this.component.getDivEdgeInsetsJsonTemplateResolver(), this.component.getDivEdgeInsetsJsonEntityParser());
            DivEdgeInsets divEdgeInsets2 = (DivEdgeInsets) JsonFieldResolver.resolveOptional(context, template.paddings, data, "paddings", this.component.getDivEdgeInsetsJsonTemplateResolver(), this.component.getDivEdgeInsetsJsonEntityParser());
            Expression<Integer> expressionResolveOptionalExpression8 = JsonFieldResolver.resolveOptionalExpression(context, template.placeholderColor, data, "placeholder_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT, DivImageJsonParser.PLACEHOLDER_COLOR_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression8 == null) {
                expressionResolveOptionalExpression8 = DivImageJsonParser.PLACEHOLDER_COLOR_DEFAULT_VALUE;
            }
            Expression<Integer> expression5 = expressionResolveOptionalExpression8;
            Expression<Boolean> expressionResolveOptionalExpression9 = JsonFieldResolver.resolveOptionalExpression(context, template.preloadRequired, data, "preload_required", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivImageJsonParser.PRELOAD_REQUIRED_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression9 == null) {
                expressionResolveOptionalExpression9 = DivImageJsonParser.PRELOAD_REQUIRED_DEFAULT_VALUE;
            }
            Expression<Boolean> expression6 = expressionResolveOptionalExpression9;
            List listResolveOptionalList12 = JsonFieldResolver.resolveOptionalList(context, template.pressEndActions, data, "press_end_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            List listResolveOptionalList13 = JsonFieldResolver.resolveOptionalList(context, template.pressStartActions, data, "press_start_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            Expression expressionResolveOptionalExpression10 = JsonFieldResolver.resolveOptionalExpression(context, template.preview, data, "preview", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression expressionResolveOptionalExpression11 = JsonFieldResolver.resolveOptionalExpression(context, template.reuseId, data, "reuse_id", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression expressionResolveOptionalExpression12 = JsonFieldResolver.resolveOptionalExpression(context, template.rowSpan, data, "row_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivImageJsonParser.ROW_SPAN_VALIDATOR);
            Expression<DivImageScale> expressionResolveOptionalExpression13 = JsonFieldResolver.resolveOptionalExpression(context, template.scale, data, "scale", DivImageJsonParser.TYPE_HELPER_SCALE, DivImageScale.FROM_STRING, DivImageJsonParser.SCALE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression13 == null) {
                expressionResolveOptionalExpression13 = DivImageJsonParser.SCALE_DEFAULT_VALUE;
            }
            Expression<DivImageScale> expression7 = expressionResolveOptionalExpression13;
            List listResolveOptionalList14 = JsonFieldResolver.resolveOptionalList(context, template.selectedActions, data, "selected_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            Expression expressionResolveOptionalExpression14 = JsonFieldResolver.resolveOptionalExpression(context, template.tintColor, data, "tint_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Expression<DivBlendMode> expressionResolveOptionalExpression15 = JsonFieldResolver.resolveOptionalExpression(context, template.tintMode, data, "tint_mode", DivImageJsonParser.TYPE_HELPER_TINT_MODE, DivBlendMode.FROM_STRING, DivImageJsonParser.TINT_MODE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression15 == null) {
                expressionResolveOptionalExpression15 = DivImageJsonParser.TINT_MODE_DEFAULT_VALUE;
            }
            Expression<DivBlendMode> expression8 = expressionResolveOptionalExpression15;
            List listResolveOptionalList15 = JsonFieldResolver.resolveOptionalList(context, template.tooltips, data, "tooltips", this.component.getDivTooltipJsonTemplateResolver(), this.component.getDivTooltipJsonEntityParser());
            DivTransform divTransform = (DivTransform) JsonFieldResolver.resolveOptional(context, template.transform, data, "transform", this.component.getDivTransformJsonTemplateResolver(), this.component.getDivTransformJsonEntityParser());
            DivChangeTransition divChangeTransition = (DivChangeTransition) JsonFieldResolver.resolveOptional(context, template.transitionChange, data, "transition_change", this.component.getDivChangeTransitionJsonTemplateResolver(), this.component.getDivChangeTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition = (DivAppearanceTransition) JsonFieldResolver.resolveOptional(context, template.transitionIn, data, "transition_in", this.component.getDivAppearanceTransitionJsonTemplateResolver(), this.component.getDivAppearanceTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition2 = (DivAppearanceTransition) JsonFieldResolver.resolveOptional(context, template.transitionOut, data, "transition_out", this.component.getDivAppearanceTransitionJsonTemplateResolver(), this.component.getDivAppearanceTransitionJsonEntityParser());
            List listResolveOptionalList16 = JsonFieldResolver.resolveOptionalList(context, template.transitionTriggers, data, "transition_triggers", DivTransitionTrigger.FROM_STRING, DivImageJsonParser.TRANSITION_TRIGGERS_VALIDATOR);
            List listResolveOptionalList17 = JsonFieldResolver.resolveOptionalList(context, template.variableTriggers, data, "variable_triggers", this.component.getDivTriggerJsonTemplateResolver(), this.component.getDivTriggerJsonEntityParser());
            List listResolveOptionalList18 = JsonFieldResolver.resolveOptionalList(context, template.variables, data, "variables", this.component.getDivVariableJsonTemplateResolver(), this.component.getDivVariableJsonEntityParser());
            Expression<DivVisibility> expressionResolveOptionalExpression16 = JsonFieldResolver.resolveOptionalExpression(context, template.visibility, data, "visibility", DivImageJsonParser.TYPE_HELPER_VISIBILITY, DivVisibility.FROM_STRING, DivImageJsonParser.VISIBILITY_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression16 == null) {
                expressionResolveOptionalExpression16 = DivImageJsonParser.VISIBILITY_DEFAULT_VALUE;
            }
            Expression<DivVisibility> expression9 = expressionResolveOptionalExpression16;
            DivVisibilityAction divVisibilityAction = (DivVisibilityAction) JsonFieldResolver.resolveOptional(context, template.visibilityAction, data, "visibility_action", this.component.getDivVisibilityActionJsonTemplateResolver(), this.component.getDivVisibilityActionJsonEntityParser());
            List listResolveOptionalList19 = JsonFieldResolver.resolveOptionalList(context, template.visibilityActions, data, "visibility_actions", this.component.getDivVisibilityActionJsonTemplateResolver(), this.component.getDivVisibilityActionJsonEntityParser());
            DivSize.MatchParent matchParent = (DivSize) JsonFieldResolver.resolveOptional(context, template.width, data, "width", this.component.getDivSizeJsonTemplateResolver(), this.component.getDivSizeJsonEntityParser());
            if (matchParent == null) {
                matchParent = DivImageJsonParser.WIDTH_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(matchParent, "JsonFieldResolver.resolv…r) ?: WIDTH_DEFAULT_VALUE");
            return new DivImage(divAccessibility, divAction, divAnimation2, listResolveOptionalList, expressionResolveOptionalExpression, expressionResolveOptionalExpression2, expression, listResolveOptionalList2, divFadeTransition, divAspect, listResolveOptionalList3, divBorder, expressionResolveOptionalExpression4, expression2, expression3, listResolveOptionalList4, listResolveOptionalList5, listResolveOptionalList6, listResolveOptionalList7, divFocus, listResolveOptionalList8, divSize, expression4, listResolveOptionalList9, listResolveOptionalList10, str, expressionResolveExpression, divLayoutProvider, listResolveOptionalList11, divEdgeInsets, divEdgeInsets2, expression5, expression6, listResolveOptionalList12, listResolveOptionalList13, expressionResolveOptionalExpression10, expressionResolveOptionalExpression11, expressionResolveOptionalExpression12, expression7, listResolveOptionalList14, expressionResolveOptionalExpression14, expression8, listResolveOptionalList15, divTransform, divChangeTransition, divAppearanceTransition, divAppearanceTransition2, listResolveOptionalList16, listResolveOptionalList17, listResolveOptionalList18, expression9, divVisibilityAction, listResolveOptionalList19, matchParent);
        }
    }

    /* JADX INFO: compiled from: DivImageJsonParser.kt */
    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0 8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0 8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0 8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0 8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190 8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0 8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020'0 8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020*8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/yandex/div2/DivImageJsonParser$Companion;", "", "()V", "ACTION_ANIMATION_DEFAULT_VALUE", "Lcom/yandex/div2/DivAnimation;", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "ALPHA_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "COLUMN_SPAN_VALIDATOR", "", "CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE", "Lcom/yandex/div2/DivAlignmentHorizontal;", "CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE", "Lcom/yandex/div2/DivAlignmentVertical;", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "HIGH_PRIORITY_PREVIEW_SHOW_DEFAULT_VALUE", "", "PLACEHOLDER_COLOR_DEFAULT_VALUE", "", "PRELOAD_REQUIRED_DEFAULT_VALUE", "ROW_SPAN_VALIDATOR", "SCALE_DEFAULT_VALUE", "Lcom/yandex/div2/DivImageScale;", "TINT_MODE_DEFAULT_VALUE", "Lcom/yandex/div2/DivBlendMode;", "TRANSITION_TRIGGERS_VALIDATOR", "Lcom/yandex/div/internal/parser/ListValidator;", "Lcom/yandex/div2/DivTransitionTrigger;", "TYPE_HELPER_ALIGNMENT_HORIZONTAL", "Lcom/yandex/div/internal/parser/TypeHelper;", "TYPE_HELPER_ALIGNMENT_VERTICAL", "TYPE_HELPER_CONTENT_ALIGNMENT_HORIZONTAL", "TYPE_HELPER_CONTENT_ALIGNMENT_VERTICAL", "TYPE_HELPER_SCALE", "TYPE_HELPER_TINT_MODE", "TYPE_HELPER_VISIBILITY", "Lcom/yandex/div2/DivVisibility;", "VISIBILITY_DEFAULT_VALUE", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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
        CONTENT_ALIGNMENT_HORIZONTAL_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAlignmentHorizontal.CENTER);
        CONTENT_ALIGNMENT_VERTICAL_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAlignmentVertical.CENTER);
        HEIGHT_DEFAULT_VALUE = new DivSize.WrapContent(new DivWrapContentSize(null, null, null, 7, null));
        HIGH_PRIORITY_PREVIEW_SHOW_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
        PLACEHOLDER_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(Integer.valueOf(DivSeparatorView.DEFAULT_DIVIDER_COLOR));
        PRELOAD_REQUIRED_DEFAULT_VALUE = Expression.INSTANCE.constant(false);
        SCALE_DEFAULT_VALUE = Expression.INSTANCE.constant(DivImageScale.FILL);
        TINT_MODE_DEFAULT_VALUE = Expression.INSTANCE.constant(DivBlendMode.SOURCE_IN);
        VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);
        WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0));
        TYPE_HELPER_ALIGNMENT_HORIZONTAL = TypeHelper.INSTANCE.from(ArraysKt.first(DivAlignmentHorizontal.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivImageJsonParser$Companion$TYPE_HELPER_ALIGNMENT_HORIZONTAL$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivAlignmentHorizontal);
            }
        });
        TYPE_HELPER_ALIGNMENT_VERTICAL = TypeHelper.INSTANCE.from(ArraysKt.first(DivAlignmentVertical.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivImageJsonParser$Companion$TYPE_HELPER_ALIGNMENT_VERTICAL$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivAlignmentVertical);
            }
        });
        TYPE_HELPER_CONTENT_ALIGNMENT_HORIZONTAL = TypeHelper.INSTANCE.from(ArraysKt.first(DivAlignmentHorizontal.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivImageJsonParser$Companion$TYPE_HELPER_CONTENT_ALIGNMENT_HORIZONTAL$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivAlignmentHorizontal);
            }
        });
        TYPE_HELPER_CONTENT_ALIGNMENT_VERTICAL = TypeHelper.INSTANCE.from(ArraysKt.first(DivAlignmentVertical.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivImageJsonParser$Companion$TYPE_HELPER_CONTENT_ALIGNMENT_VERTICAL$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivAlignmentVertical);
            }
        });
        TYPE_HELPER_SCALE = TypeHelper.INSTANCE.from(ArraysKt.first(DivImageScale.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivImageJsonParser$Companion$TYPE_HELPER_SCALE$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivImageScale);
            }
        });
        TYPE_HELPER_TINT_MODE = TypeHelper.INSTANCE.from(ArraysKt.first(DivBlendMode.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivImageJsonParser$Companion$TYPE_HELPER_TINT_MODE$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivBlendMode);
            }
        });
        TYPE_HELPER_VISIBILITY = TypeHelper.INSTANCE.from(ArraysKt.first(DivVisibility.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivImageJsonParser$Companion$TYPE_HELPER_VISIBILITY$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivVisibility);
            }
        });
        ALPHA_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivImageJsonParser$$ExternalSyntheticLambda0
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivImageJsonParser.ALPHA_VALIDATOR$lambda$0(((Double) obj).doubleValue());
            }
        };
        COLUMN_SPAN_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivImageJsonParser$$ExternalSyntheticLambda1
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivImageJsonParser.COLUMN_SPAN_VALIDATOR$lambda$1(((Long) obj).longValue());
            }
        };
        ROW_SPAN_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivImageJsonParser$$ExternalSyntheticLambda2
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivImageJsonParser.ROW_SPAN_VALIDATOR$lambda$2(((Long) obj).longValue());
            }
        };
        TRANSITION_TRIGGERS_VALIDATOR = new ListValidator() { // from class: com.yandex.div2.DivImageJsonParser$$ExternalSyntheticLambda3
            @Override // com.yandex.div.internal.parser.ListValidator
            public final boolean isValid(List list) {
                return DivImageJsonParser.TRANSITION_TRIGGERS_VALIDATOR$lambda$3(list);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TRANSITION_TRIGGERS_VALIDATOR$lambda$3(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.size() >= 1;
    }
}
