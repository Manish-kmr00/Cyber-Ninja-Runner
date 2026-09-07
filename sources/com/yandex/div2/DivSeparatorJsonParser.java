package com.yandex.div2;

import androidx.compose.material.OutlinedTextFieldKt;
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

/* JADX INFO: compiled from: DivSeparatorJsonParser.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivSeparatorJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivSeparatorJsonParser {

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
    public static final DivSize.WrapContent HEIGHT_DEFAULT_VALUE;

    @Deprecated
    public static final ValueValidator<Long> ROW_SPAN_VALIDATOR;

    @Deprecated
    public static final ListValidator<DivTransitionTrigger> TRANSITION_TRIGGERS_VALIDATOR;

    @Deprecated
    public static final TypeHelper<DivAlignmentHorizontal> TYPE_HELPER_ALIGNMENT_HORIZONTAL;

    @Deprecated
    public static final TypeHelper<DivAlignmentVertical> TYPE_HELPER_ALIGNMENT_VERTICAL;

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

    public DivSeparatorJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivSeparatorJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivSeparatorJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivSeparator;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivSeparator> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivSeparator deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            DivAccessibility divAccessibility = (DivAccessibility) JsonPropertyParser.readOptional(context, data, "accessibility", this.component.getDivAccessibilityJsonEntityParser());
            DivAction divAction = (DivAction) JsonPropertyParser.readOptional(context, data, "action", this.component.getDivActionJsonEntityParser());
            DivAnimation divAnimation = (DivAnimation) JsonPropertyParser.readOptional(context, data, "action_animation", this.component.getDivAnimationJsonEntityParser());
            if (divAnimation == null) {
                divAnimation = DivSeparatorJsonParser.ACTION_ANIMATION_DEFAULT_VALUE;
            }
            DivAnimation divAnimation2 = divAnimation;
            Intrinsics.checkNotNullExpressionValue(divAnimation2, "JsonPropertyParser.readO…N_ANIMATION_DEFAULT_VALUE");
            List optionalList = JsonPropertyParser.readOptionalList(context, data, "actions", this.component.getDivActionJsonEntityParser());
            Expression optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "alignment_horizontal", DivSeparatorJsonParser.TYPE_HELPER_ALIGNMENT_HORIZONTAL, DivAlignmentHorizontal.FROM_STRING);
            Expression optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, "alignment_vertical", DivSeparatorJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, DivAlignmentVertical.FROM_STRING);
            Expression<Double> optionalExpression3 = JsonExpressionParser.readOptionalExpression(context, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivSeparatorJsonParser.ALPHA_VALIDATOR, DivSeparatorJsonParser.ALPHA_DEFAULT_VALUE);
            if (optionalExpression3 == null) {
                optionalExpression3 = DivSeparatorJsonParser.ALPHA_DEFAULT_VALUE;
            }
            Expression<Double> expression = optionalExpression3;
            List optionalList2 = JsonPropertyParser.readOptionalList(context, data, "animators", this.component.getDivAnimatorJsonEntityParser());
            List optionalList3 = JsonPropertyParser.readOptionalList(context, data, J2.g, this.component.getDivBackgroundJsonEntityParser());
            DivBorder divBorder = (DivBorder) JsonPropertyParser.readOptional(context, data, OutlinedTextFieldKt.BorderId, this.component.getDivBorderJsonEntityParser());
            Expression optionalExpression4 = JsonExpressionParser.readOptionalExpression(context, data, "column_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivSeparatorJsonParser.COLUMN_SPAN_VALIDATOR);
            DivSeparator.DelimiterStyle delimiterStyle = (DivSeparator.DelimiterStyle) JsonPropertyParser.readOptional(context, data, "delimiter_style", this.component.getDivSeparatorDelimiterStyleJsonEntityParser());
            List optionalList4 = JsonPropertyParser.readOptionalList(context, data, "disappear_actions", this.component.getDivDisappearActionJsonEntityParser());
            List optionalList5 = JsonPropertyParser.readOptionalList(context, data, "doubletap_actions", this.component.getDivActionJsonEntityParser());
            List optionalList6 = JsonPropertyParser.readOptionalList(context, data, "extensions", this.component.getDivExtensionJsonEntityParser());
            DivFocus divFocus = (DivFocus) JsonPropertyParser.readOptional(context, data, "focus", this.component.getDivFocusJsonEntityParser());
            List optionalList7 = JsonPropertyParser.readOptionalList(context, data, "functions", this.component.getDivFunctionJsonEntityParser());
            DivSize.WrapContent wrapContent = (DivSize) JsonPropertyParser.readOptional(context, data, "height", this.component.getDivSizeJsonEntityParser());
            if (wrapContent == null) {
                wrapContent = DivSeparatorJsonParser.HEIGHT_DEFAULT_VALUE;
            }
            DivSize divSize = wrapContent;
            Intrinsics.checkNotNullExpressionValue(divSize, "JsonPropertyParser.readO…) ?: HEIGHT_DEFAULT_VALUE");
            List optionalList8 = JsonPropertyParser.readOptionalList(context, data, "hover_end_actions", this.component.getDivActionJsonEntityParser());
            List optionalList9 = JsonPropertyParser.readOptionalList(context, data, "hover_start_actions", this.component.getDivActionJsonEntityParser());
            String str = (String) JsonPropertyParser.readOptional(context, data, "id");
            DivLayoutProvider divLayoutProvider = (DivLayoutProvider) JsonPropertyParser.readOptional(context, data, "layout_provider", this.component.getDivLayoutProviderJsonEntityParser());
            List optionalList10 = JsonPropertyParser.readOptionalList(context, data, "longtap_actions", this.component.getDivActionJsonEntityParser());
            DivEdgeInsets divEdgeInsets = (DivEdgeInsets) JsonPropertyParser.readOptional(context, data, "margins", this.component.getDivEdgeInsetsJsonEntityParser());
            DivEdgeInsets divEdgeInsets2 = (DivEdgeInsets) JsonPropertyParser.readOptional(context, data, "paddings", this.component.getDivEdgeInsetsJsonEntityParser());
            List optionalList11 = JsonPropertyParser.readOptionalList(context, data, "press_end_actions", this.component.getDivActionJsonEntityParser());
            List optionalList12 = JsonPropertyParser.readOptionalList(context, data, "press_start_actions", this.component.getDivActionJsonEntityParser());
            Expression<String> optionalExpression5 = JsonExpressionParser.readOptionalExpression(context, data, "reuse_id", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression optionalExpression6 = JsonExpressionParser.readOptionalExpression(context, data, "row_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivSeparatorJsonParser.ROW_SPAN_VALIDATOR);
            List optionalList13 = JsonPropertyParser.readOptionalList(context, data, "selected_actions", this.component.getDivActionJsonEntityParser());
            List optionalList14 = JsonPropertyParser.readOptionalList(context, data, "tooltips", this.component.getDivTooltipJsonEntityParser());
            DivTransform divTransform = (DivTransform) JsonPropertyParser.readOptional(context, data, "transform", this.component.getDivTransformJsonEntityParser());
            DivChangeTransition divChangeTransition = (DivChangeTransition) JsonPropertyParser.readOptional(context, data, "transition_change", this.component.getDivChangeTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition = (DivAppearanceTransition) JsonPropertyParser.readOptional(context, data, "transition_in", this.component.getDivAppearanceTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition2 = (DivAppearanceTransition) JsonPropertyParser.readOptional(context, data, "transition_out", this.component.getDivAppearanceTransitionJsonEntityParser());
            List optionalList15 = JsonPropertyParser.readOptionalList(context, data, "transition_triggers", DivTransitionTrigger.FROM_STRING, DivSeparatorJsonParser.TRANSITION_TRIGGERS_VALIDATOR);
            List optionalList16 = JsonPropertyParser.readOptionalList(context, data, "variable_triggers", this.component.getDivTriggerJsonEntityParser());
            List optionalList17 = JsonPropertyParser.readOptionalList(context, data, "variables", this.component.getDivVariableJsonEntityParser());
            Expression<DivVisibility> optionalExpression7 = JsonExpressionParser.readOptionalExpression(context, data, "visibility", DivSeparatorJsonParser.TYPE_HELPER_VISIBILITY, DivVisibility.FROM_STRING, DivSeparatorJsonParser.VISIBILITY_DEFAULT_VALUE);
            if (optionalExpression7 == null) {
                optionalExpression7 = DivSeparatorJsonParser.VISIBILITY_DEFAULT_VALUE;
            }
            DivVisibilityAction divVisibilityAction = (DivVisibilityAction) JsonPropertyParser.readOptional(context, data, "visibility_action", this.component.getDivVisibilityActionJsonEntityParser());
            List optionalList18 = JsonPropertyParser.readOptionalList(context, data, "visibility_actions", this.component.getDivVisibilityActionJsonEntityParser());
            DivSize.MatchParent matchParent = (DivSize) JsonPropertyParser.readOptional(context, data, "width", this.component.getDivSizeJsonEntityParser());
            if (matchParent == null) {
                matchParent = DivSeparatorJsonParser.WIDTH_DEFAULT_VALUE;
            }
            DivSize divSize2 = matchParent;
            Intrinsics.checkNotNullExpressionValue(divSize2, "JsonPropertyParser.readO…r) ?: WIDTH_DEFAULT_VALUE");
            return new DivSeparator(divAccessibility, divAction, divAnimation2, optionalList, optionalExpression, optionalExpression2, expression, optionalList2, optionalList3, divBorder, optionalExpression4, delimiterStyle, optionalList4, optionalList5, optionalList6, divFocus, optionalList7, divSize, optionalList8, optionalList9, str, divLayoutProvider, optionalList10, divEdgeInsets, divEdgeInsets2, optionalList11, optionalList12, optionalExpression5, optionalExpression6, optionalList13, optionalList14, divTransform, divChangeTransition, divAppearanceTransition, divAppearanceTransition2, optionalList15, optionalList16, optionalList17, optionalExpression7, divVisibilityAction, optionalList18, divSize2);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivSeparator value) throws ParsingException {
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
            JsonPropertyParser.writeList(context, jSONObject, J2.g, value.getBackground(), this.component.getDivBackgroundJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, OutlinedTextFieldKt.BorderId, value.getBorder(), this.component.getDivBorderJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "column_span", value.getColumnSpan());
            JsonPropertyParser.write(context, jSONObject, "delimiter_style", value.delimiterStyle, this.component.getDivSeparatorDelimiterStyleJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "disappear_actions", value.getDisappearActions(), this.component.getDivDisappearActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "doubletap_actions", value.doubletapActions, this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "extensions", value.getExtensions(), this.component.getDivExtensionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "focus", value.getFocus(), this.component.getDivFocusJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "functions", value.getFunctions(), this.component.getDivFunctionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "height", value.getHeight(), this.component.getDivSizeJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "hover_end_actions", value.hoverEndActions, this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "hover_start_actions", value.hoverStartActions, this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "id", value.getId());
            JsonPropertyParser.write(context, jSONObject, "layout_provider", value.getLayoutProvider(), this.component.getDivLayoutProviderJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "longtap_actions", value.longtapActions, this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "margins", value.getMargins(), this.component.getDivEdgeInsetsJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "paddings", value.getPaddings(), this.component.getDivEdgeInsetsJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "press_end_actions", value.pressEndActions, this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "press_start_actions", value.pressStartActions, this.component.getDivActionJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "reuse_id", value.getReuseId());
            JsonExpressionParser.writeExpression(context, jSONObject, "row_span", value.getRowSpan());
            JsonPropertyParser.writeList(context, jSONObject, "selected_actions", value.getSelectedActions(), this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "tooltips", value.getTooltips(), this.component.getDivTooltipJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transform", value.getTransform(), this.component.getDivTransformJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transition_change", value.getTransitionChange(), this.component.getDivChangeTransitionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transition_in", value.getTransitionIn(), this.component.getDivAppearanceTransitionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transition_out", value.getTransitionOut(), this.component.getDivAppearanceTransitionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "transition_triggers", value.getTransitionTriggers(), DivTransitionTrigger.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "type", "separator");
            JsonPropertyParser.writeList(context, jSONObject, "variable_triggers", value.getVariableTriggers(), this.component.getDivTriggerJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "variables", value.getVariables(), this.component.getDivVariableJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "visibility", value.getVisibility(), DivVisibility.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "visibility_action", value.getVisibilityAction(), this.component.getDivVisibilityActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "visibility_actions", value.getVisibilityActions(), this.component.getDivVisibilityActionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "width", value.getWidth(), this.component.getDivSizeJsonEntityParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivSeparatorJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivSeparatorJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivSeparatorTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivSeparatorTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivSeparatorTemplate deserialize(ParsingContext context, DivSeparatorTemplate parent, JSONObject data) throws ParsingException {
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
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alignment_horizontal", DivSeparatorJsonParser.TYPE_HELPER_ALIGNMENT_HORIZONTAL, allowPropertyOverride, parent != null ? parent.alignmentHorizontal : null, DivAlignmentHorizontal.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…ntHorizontal.FROM_STRING)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alignment_vertical", DivSeparatorJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, allowPropertyOverride, parent != null ? parent.alignmentVertical : null, DivAlignmentVertical.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…mentVertical.FROM_STRING)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.alpha : null, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivSeparatorJsonParser.ALPHA_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…_DOUBLE, ALPHA_VALIDATOR)");
            Field optionalListField2 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "animators", allowPropertyOverride, parent != null ? parent.animators : null, this.component.getDivAnimatorJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField2, "readOptionalListField(co…imatorJsonTemplateParser)");
            Field optionalListField3 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, J2.g, allowPropertyOverride, parent != null ? parent.background : null, this.component.getDivBackgroundJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField3, "readOptionalListField(co…groundJsonTemplateParser)");
            Field optionalField4 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, OutlinedTextFieldKt.BorderId, allowPropertyOverride, parent != null ? parent.border : null, this.component.getDivBorderJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField4, "readOptionalField(contex…BorderJsonTemplateParser)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "column_span", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.columnSpan : null, ParsingConvertersKt.NUMBER_TO_INT, DivSeparatorJsonParser.COLUMN_SPAN_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…T, COLUMN_SPAN_VALIDATOR)");
            Field optionalField5 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "delimiter_style", allowPropertyOverride, parent != null ? parent.delimiterStyle : null, this.component.getDivSeparatorDelimiterStyleJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField5, "readOptionalField(contex…rStyleJsonTemplateParser)");
            Field optionalListField4 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "disappear_actions", allowPropertyOverride, parent != null ? parent.disappearActions : null, this.component.getDivDisappearActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField4, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalListField5 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "doubletap_actions", allowPropertyOverride, parent != null ? parent.doubletapActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField5, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalListField6 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "extensions", allowPropertyOverride, parent != null ? parent.extensions : null, this.component.getDivExtensionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField6, "readOptionalListField(co…ensionJsonTemplateParser)");
            Field optionalField6 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "focus", allowPropertyOverride, parent != null ? parent.focus : null, this.component.getDivFocusJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField6, "readOptionalField(contex…vFocusJsonTemplateParser)");
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
            Field optionalField9 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "layout_provider", allowPropertyOverride, parent != null ? parent.layoutProvider : null, this.component.getDivLayoutProviderJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField9, "readOptionalField(contex…oviderJsonTemplateParser)");
            Field optionalListField10 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "longtap_actions", allowPropertyOverride, parent != null ? parent.longtapActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField10, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalField10 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "margins", allowPropertyOverride, parent != null ? parent.margins : null, this.component.getDivEdgeInsetsJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField10, "readOptionalField(contex…InsetsJsonTemplateParser)");
            Field optionalField11 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "paddings", allowPropertyOverride, parent != null ? parent.paddings : null, this.component.getDivEdgeInsetsJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField11, "readOptionalField(contex…InsetsJsonTemplateParser)");
            Field optionalListField11 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "press_end_actions", allowPropertyOverride, parent != null ? parent.pressEndActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField11, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalListField12 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "press_start_actions", allowPropertyOverride, parent != null ? parent.pressStartActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField12, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field<Expression<String>> optionalFieldWithExpression5 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "reuse_id", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.reuseId : null);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression5, "readOptionalFieldWithExp…verride, parent?.reuseId)");
            Field optionalFieldWithExpression6 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "row_span", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.rowSpan : null, ParsingConvertersKt.NUMBER_TO_INT, DivSeparatorJsonParser.ROW_SPAN_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression6, "readOptionalFieldWithExp…_INT, ROW_SPAN_VALIDATOR)");
            Field optionalListField13 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "selected_actions", allowPropertyOverride, parent != null ? parent.selectedActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField13, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalListField14 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "tooltips", allowPropertyOverride, parent != null ? parent.tooltips : null, this.component.getDivTooltipJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField14, "readOptionalListField(co…ooltipJsonTemplateParser)");
            Field optionalField12 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transform", allowPropertyOverride, parent != null ? parent.transform : null, this.component.getDivTransformJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField12, "readOptionalField(contex…nsformJsonTemplateParser)");
            Field optionalField13 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transition_change", allowPropertyOverride, parent != null ? parent.transitionChange : null, this.component.getDivChangeTransitionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField13, "readOptionalField(contex…sitionJsonTemplateParser)");
            Field optionalField14 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transition_in", allowPropertyOverride, parent != null ? parent.transitionIn : null, this.component.getDivAppearanceTransitionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField14, "readOptionalField(contex…sitionJsonTemplateParser)");
            Field optionalField15 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transition_out", allowPropertyOverride, parent != null ? parent.transitionOut : null, this.component.getDivAppearanceTransitionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField15, "readOptionalField(contex…sitionJsonTemplateParser)");
            Field<List<DivTransitionTrigger>> field = parent != null ? parent.transitionTriggers : null;
            Function1<String, DivTransitionTrigger> function1 = DivTransitionTrigger.FROM_STRING;
            ListValidator<DivTransitionTrigger> listValidator = DivSeparatorJsonParser.TRANSITION_TRIGGERS_VALIDATOR;
            Intrinsics.checkNotNull(listValidator, "null cannot be cast to non-null type com.yandex.div.internal.parser.ListValidator<T of com.yandex.div.internal.parser.ParsingValidatorsKt.cast>");
            Field optionalListField15 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "transition_triggers", allowPropertyOverride, field, function1, listValidator);
            Intrinsics.checkNotNullExpressionValue(optionalListField15, "readOptionalListField(co…RIGGERS_VALIDATOR.cast())");
            Field optionalListField16 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "variable_triggers", allowPropertyOverride, parent != null ? parent.variableTriggers : null, this.component.getDivTriggerJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField16, "readOptionalListField(co…riggerJsonTemplateParser)");
            Field optionalListField17 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "variables", allowPropertyOverride, parent != null ? parent.variables : null, this.component.getDivVariableJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField17, "readOptionalListField(co…riableJsonTemplateParser)");
            Field optionalFieldWithExpression7 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "visibility", DivSeparatorJsonParser.TYPE_HELPER_VISIBILITY, allowPropertyOverride, parent != null ? parent.visibility : null, DivVisibility.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression7, "readOptionalFieldWithExp…ivVisibility.FROM_STRING)");
            Field optionalField16 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "visibility_action", allowPropertyOverride, parent != null ? parent.visibilityAction : null, this.component.getDivVisibilityActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField16, "readOptionalField(contex…ActionJsonTemplateParser)");
            Field optionalListField18 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "visibility_actions", allowPropertyOverride, parent != null ? parent.visibilityActions : null, this.component.getDivVisibilityActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField18, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalField17 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "width", allowPropertyOverride, parent != null ? parent.width : null, this.component.getDivSizeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField17, "readOptionalField(contex…ivSizeJsonTemplateParser)");
            return new DivSeparatorTemplate(optionalField, optionalField2, optionalField3, optionalListField, optionalFieldWithExpression, optionalFieldWithExpression2, optionalFieldWithExpression3, optionalListField2, optionalListField3, optionalField4, optionalFieldWithExpression4, optionalField5, optionalListField4, optionalListField5, optionalListField6, optionalField6, optionalListField7, optionalField7, optionalListField8, optionalListField9, optionalField8, optionalField9, optionalListField10, optionalField10, optionalField11, optionalListField11, optionalListField12, optionalFieldWithExpression5, optionalFieldWithExpression6, optionalListField13, optionalListField14, optionalField12, optionalField13, optionalField14, optionalField15, optionalListField15, optionalListField16, optionalListField17, optionalFieldWithExpression7, optionalField16, optionalListField18, optionalField17);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivSeparatorTemplate value) throws ParsingException {
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
            JsonFieldParser.writeListField(context, jSONObject, J2.g, value.background, this.component.getDivBackgroundJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, OutlinedTextFieldKt.BorderId, value.border, this.component.getDivBorderJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "column_span", value.columnSpan);
            JsonFieldParser.writeField(context, jSONObject, "delimiter_style", value.delimiterStyle, this.component.getDivSeparatorDelimiterStyleJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "disappear_actions", value.disappearActions, this.component.getDivDisappearActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "doubletap_actions", value.doubletapActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "extensions", value.extensions, this.component.getDivExtensionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "focus", value.focus, this.component.getDivFocusJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "functions", value.functions, this.component.getDivFunctionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "height", value.height, this.component.getDivSizeJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "hover_end_actions", value.hoverEndActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "hover_start_actions", value.hoverStartActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "id", value.id);
            JsonFieldParser.writeField(context, jSONObject, "layout_provider", value.layoutProvider, this.component.getDivLayoutProviderJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "longtap_actions", value.longtapActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "margins", value.margins, this.component.getDivEdgeInsetsJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "paddings", value.paddings, this.component.getDivEdgeInsetsJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "press_end_actions", value.pressEndActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "press_start_actions", value.pressStartActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "reuse_id", value.reuseId);
            JsonFieldParser.writeExpressionField(context, jSONObject, "row_span", value.rowSpan);
            JsonFieldParser.writeListField(context, jSONObject, "selected_actions", value.selectedActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "tooltips", value.tooltips, this.component.getDivTooltipJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transform", value.transform, this.component.getDivTransformJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transition_change", value.transitionChange, this.component.getDivChangeTransitionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transition_in", value.transitionIn, this.component.getDivAppearanceTransitionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transition_out", value.transitionOut, this.component.getDivAppearanceTransitionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "transition_triggers", value.transitionTriggers, DivTransitionTrigger.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "type", "separator");
            JsonFieldParser.writeListField(context, jSONObject, "variable_triggers", value.variableTriggers, this.component.getDivTriggerJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "variables", value.variables, this.component.getDivVariableJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "visibility", value.visibility, DivVisibility.TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "visibility_action", value.visibilityAction, this.component.getDivVisibilityActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "visibility_actions", value.visibilityActions, this.component.getDivVisibilityActionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "width", value.width, this.component.getDivSizeJsonTemplateParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivSeparatorJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivSeparatorJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivSeparatorTemplate;", "Lcom/yandex/div2/DivSeparator;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivSeparatorTemplate, DivSeparator> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivSeparator resolve(ParsingContext context, DivSeparatorTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            DivAccessibility divAccessibility = (DivAccessibility) JsonFieldResolver.resolveOptional(context, template.accessibility, data, "accessibility", this.component.getDivAccessibilityJsonTemplateResolver(), this.component.getDivAccessibilityJsonEntityParser());
            DivAction divAction = (DivAction) JsonFieldResolver.resolveOptional(context, template.action, data, "action", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            DivAnimation divAnimation = (DivAnimation) JsonFieldResolver.resolveOptional(context, template.actionAnimation, data, "action_animation", this.component.getDivAnimationJsonTemplateResolver(), this.component.getDivAnimationJsonEntityParser());
            if (divAnimation == null) {
                divAnimation = DivSeparatorJsonParser.ACTION_ANIMATION_DEFAULT_VALUE;
            }
            DivAnimation divAnimation2 = divAnimation;
            Intrinsics.checkNotNullExpressionValue(divAnimation2, "JsonFieldResolver.resolv…N_ANIMATION_DEFAULT_VALUE");
            List listResolveOptionalList = JsonFieldResolver.resolveOptionalList(context, template.actions, data, "actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            Expression expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.alignmentHorizontal, data, "alignment_horizontal", DivSeparatorJsonParser.TYPE_HELPER_ALIGNMENT_HORIZONTAL, DivAlignmentHorizontal.FROM_STRING);
            Expression expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.alignmentVertical, data, "alignment_vertical", DivSeparatorJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, DivAlignmentVertical.FROM_STRING);
            Expression<Double> expressionResolveOptionalExpression3 = JsonFieldResolver.resolveOptionalExpression(context, template.alpha, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivSeparatorJsonParser.ALPHA_VALIDATOR, DivSeparatorJsonParser.ALPHA_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression3 == null) {
                expressionResolveOptionalExpression3 = DivSeparatorJsonParser.ALPHA_DEFAULT_VALUE;
            }
            Expression<Double> expression = expressionResolveOptionalExpression3;
            List listResolveOptionalList2 = JsonFieldResolver.resolveOptionalList(context, template.animators, data, "animators", this.component.getDivAnimatorJsonTemplateResolver(), this.component.getDivAnimatorJsonEntityParser());
            List listResolveOptionalList3 = JsonFieldResolver.resolveOptionalList(context, template.background, data, J2.g, this.component.getDivBackgroundJsonTemplateResolver(), this.component.getDivBackgroundJsonEntityParser());
            DivBorder divBorder = (DivBorder) JsonFieldResolver.resolveOptional(context, template.border, data, OutlinedTextFieldKt.BorderId, this.component.getDivBorderJsonTemplateResolver(), this.component.getDivBorderJsonEntityParser());
            Expression expressionResolveOptionalExpression4 = JsonFieldResolver.resolveOptionalExpression(context, template.columnSpan, data, "column_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivSeparatorJsonParser.COLUMN_SPAN_VALIDATOR);
            DivSeparator.DelimiterStyle delimiterStyle = (DivSeparator.DelimiterStyle) JsonFieldResolver.resolveOptional(context, template.delimiterStyle, data, "delimiter_style", this.component.getDivSeparatorDelimiterStyleJsonTemplateResolver(), this.component.getDivSeparatorDelimiterStyleJsonEntityParser());
            List listResolveOptionalList4 = JsonFieldResolver.resolveOptionalList(context, template.disappearActions, data, "disappear_actions", this.component.getDivDisappearActionJsonTemplateResolver(), this.component.getDivDisappearActionJsonEntityParser());
            List listResolveOptionalList5 = JsonFieldResolver.resolveOptionalList(context, template.doubletapActions, data, "doubletap_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            List listResolveOptionalList6 = JsonFieldResolver.resolveOptionalList(context, template.extensions, data, "extensions", this.component.getDivExtensionJsonTemplateResolver(), this.component.getDivExtensionJsonEntityParser());
            DivFocus divFocus = (DivFocus) JsonFieldResolver.resolveOptional(context, template.focus, data, "focus", this.component.getDivFocusJsonTemplateResolver(), this.component.getDivFocusJsonEntityParser());
            List listResolveOptionalList7 = JsonFieldResolver.resolveOptionalList(context, template.functions, data, "functions", this.component.getDivFunctionJsonTemplateResolver(), this.component.getDivFunctionJsonEntityParser());
            DivSize.WrapContent wrapContent = (DivSize) JsonFieldResolver.resolveOptional(context, template.height, data, "height", this.component.getDivSizeJsonTemplateResolver(), this.component.getDivSizeJsonEntityParser());
            if (wrapContent == null) {
                wrapContent = DivSeparatorJsonParser.HEIGHT_DEFAULT_VALUE;
            }
            DivSize divSize = wrapContent;
            Intrinsics.checkNotNullExpressionValue(divSize, "JsonFieldResolver.resolv…) ?: HEIGHT_DEFAULT_VALUE");
            List listResolveOptionalList8 = JsonFieldResolver.resolveOptionalList(context, template.hoverEndActions, data, "hover_end_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            List listResolveOptionalList9 = JsonFieldResolver.resolveOptionalList(context, template.hoverStartActions, data, "hover_start_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            String str = (String) JsonFieldResolver.resolveOptional(context, template.id, data, "id");
            DivLayoutProvider divLayoutProvider = (DivLayoutProvider) JsonFieldResolver.resolveOptional(context, template.layoutProvider, data, "layout_provider", this.component.getDivLayoutProviderJsonTemplateResolver(), this.component.getDivLayoutProviderJsonEntityParser());
            List listResolveOptionalList10 = JsonFieldResolver.resolveOptionalList(context, template.longtapActions, data, "longtap_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            DivEdgeInsets divEdgeInsets = (DivEdgeInsets) JsonFieldResolver.resolveOptional(context, template.margins, data, "margins", this.component.getDivEdgeInsetsJsonTemplateResolver(), this.component.getDivEdgeInsetsJsonEntityParser());
            DivEdgeInsets divEdgeInsets2 = (DivEdgeInsets) JsonFieldResolver.resolveOptional(context, template.paddings, data, "paddings", this.component.getDivEdgeInsetsJsonTemplateResolver(), this.component.getDivEdgeInsetsJsonEntityParser());
            List listResolveOptionalList11 = JsonFieldResolver.resolveOptionalList(context, template.pressEndActions, data, "press_end_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            List listResolveOptionalList12 = JsonFieldResolver.resolveOptionalList(context, template.pressStartActions, data, "press_start_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            Expression expressionResolveOptionalExpression5 = JsonFieldResolver.resolveOptionalExpression(context, template.reuseId, data, "reuse_id", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression expressionResolveOptionalExpression6 = JsonFieldResolver.resolveOptionalExpression(context, template.rowSpan, data, "row_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivSeparatorJsonParser.ROW_SPAN_VALIDATOR);
            List listResolveOptionalList13 = JsonFieldResolver.resolveOptionalList(context, template.selectedActions, data, "selected_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            List listResolveOptionalList14 = JsonFieldResolver.resolveOptionalList(context, template.tooltips, data, "tooltips", this.component.getDivTooltipJsonTemplateResolver(), this.component.getDivTooltipJsonEntityParser());
            DivTransform divTransform = (DivTransform) JsonFieldResolver.resolveOptional(context, template.transform, data, "transform", this.component.getDivTransformJsonTemplateResolver(), this.component.getDivTransformJsonEntityParser());
            DivChangeTransition divChangeTransition = (DivChangeTransition) JsonFieldResolver.resolveOptional(context, template.transitionChange, data, "transition_change", this.component.getDivChangeTransitionJsonTemplateResolver(), this.component.getDivChangeTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition = (DivAppearanceTransition) JsonFieldResolver.resolveOptional(context, template.transitionIn, data, "transition_in", this.component.getDivAppearanceTransitionJsonTemplateResolver(), this.component.getDivAppearanceTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition2 = (DivAppearanceTransition) JsonFieldResolver.resolveOptional(context, template.transitionOut, data, "transition_out", this.component.getDivAppearanceTransitionJsonTemplateResolver(), this.component.getDivAppearanceTransitionJsonEntityParser());
            List listResolveOptionalList15 = JsonFieldResolver.resolveOptionalList(context, template.transitionTriggers, data, "transition_triggers", DivTransitionTrigger.FROM_STRING, DivSeparatorJsonParser.TRANSITION_TRIGGERS_VALIDATOR);
            List listResolveOptionalList16 = JsonFieldResolver.resolveOptionalList(context, template.variableTriggers, data, "variable_triggers", this.component.getDivTriggerJsonTemplateResolver(), this.component.getDivTriggerJsonEntityParser());
            List listResolveOptionalList17 = JsonFieldResolver.resolveOptionalList(context, template.variables, data, "variables", this.component.getDivVariableJsonTemplateResolver(), this.component.getDivVariableJsonEntityParser());
            Expression<DivVisibility> expressionResolveOptionalExpression7 = JsonFieldResolver.resolveOptionalExpression(context, template.visibility, data, "visibility", DivSeparatorJsonParser.TYPE_HELPER_VISIBILITY, DivVisibility.FROM_STRING, DivSeparatorJsonParser.VISIBILITY_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression7 == null) {
                expressionResolveOptionalExpression7 = DivSeparatorJsonParser.VISIBILITY_DEFAULT_VALUE;
            }
            Expression<DivVisibility> expression2 = expressionResolveOptionalExpression7;
            DivVisibilityAction divVisibilityAction = (DivVisibilityAction) JsonFieldResolver.resolveOptional(context, template.visibilityAction, data, "visibility_action", this.component.getDivVisibilityActionJsonTemplateResolver(), this.component.getDivVisibilityActionJsonEntityParser());
            List listResolveOptionalList18 = JsonFieldResolver.resolveOptionalList(context, template.visibilityActions, data, "visibility_actions", this.component.getDivVisibilityActionJsonTemplateResolver(), this.component.getDivVisibilityActionJsonEntityParser());
            DivSize.MatchParent matchParent = (DivSize) JsonFieldResolver.resolveOptional(context, template.width, data, "width", this.component.getDivSizeJsonTemplateResolver(), this.component.getDivSizeJsonEntityParser());
            if (matchParent == null) {
                matchParent = DivSeparatorJsonParser.WIDTH_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(matchParent, "JsonFieldResolver.resolv…r) ?: WIDTH_DEFAULT_VALUE");
            return new DivSeparator(divAccessibility, divAction, divAnimation2, listResolveOptionalList, expressionResolveOptionalExpression, expressionResolveOptionalExpression2, expression, listResolveOptionalList2, listResolveOptionalList3, divBorder, expressionResolveOptionalExpression4, delimiterStyle, listResolveOptionalList4, listResolveOptionalList5, listResolveOptionalList6, divFocus, listResolveOptionalList7, divSize, listResolveOptionalList8, listResolveOptionalList9, str, divLayoutProvider, listResolveOptionalList10, divEdgeInsets, divEdgeInsets2, listResolveOptionalList11, listResolveOptionalList12, expressionResolveOptionalExpression5, expressionResolveOptionalExpression6, listResolveOptionalList13, listResolveOptionalList14, divTransform, divChangeTransition, divAppearanceTransition, divAppearanceTransition2, listResolveOptionalList15, listResolveOptionalList16, listResolveOptionalList17, expression2, divVisibilityAction, listResolveOptionalList18, matchParent);
        }
    }

    /* JADX INFO: compiled from: DivSeparatorJsonParser.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yandex/div2/DivSeparatorJsonParser$Companion;", "", "()V", "ACTION_ANIMATION_DEFAULT_VALUE", "Lcom/yandex/div2/DivAnimation;", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "ALPHA_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "COLUMN_SPAN_VALIDATOR", "", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "ROW_SPAN_VALIDATOR", "TRANSITION_TRIGGERS_VALIDATOR", "Lcom/yandex/div/internal/parser/ListValidator;", "Lcom/yandex/div2/DivTransitionTrigger;", "TYPE_HELPER_ALIGNMENT_HORIZONTAL", "Lcom/yandex/div/internal/parser/TypeHelper;", "Lcom/yandex/div2/DivAlignmentHorizontal;", "TYPE_HELPER_ALIGNMENT_VERTICAL", "Lcom/yandex/div2/DivAlignmentVertical;", "TYPE_HELPER_VISIBILITY", "Lcom/yandex/div2/DivVisibility;", "VISIBILITY_DEFAULT_VALUE", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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
        HEIGHT_DEFAULT_VALUE = new DivSize.WrapContent(new DivWrapContentSize(null, null, null, 7, null));
        VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);
        WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0));
        TYPE_HELPER_ALIGNMENT_HORIZONTAL = TypeHelper.INSTANCE.from(ArraysKt.first(DivAlignmentHorizontal.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivSeparatorJsonParser$Companion$TYPE_HELPER_ALIGNMENT_HORIZONTAL$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivAlignmentHorizontal);
            }
        });
        TYPE_HELPER_ALIGNMENT_VERTICAL = TypeHelper.INSTANCE.from(ArraysKt.first(DivAlignmentVertical.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivSeparatorJsonParser$Companion$TYPE_HELPER_ALIGNMENT_VERTICAL$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivAlignmentVertical);
            }
        });
        TYPE_HELPER_VISIBILITY = TypeHelper.INSTANCE.from(ArraysKt.first(DivVisibility.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivSeparatorJsonParser$Companion$TYPE_HELPER_VISIBILITY$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivVisibility);
            }
        });
        ALPHA_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivSeparatorJsonParser$$ExternalSyntheticLambda0
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivSeparatorJsonParser.ALPHA_VALIDATOR$lambda$0(((Double) obj).doubleValue());
            }
        };
        COLUMN_SPAN_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivSeparatorJsonParser$$ExternalSyntheticLambda1
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivSeparatorJsonParser.COLUMN_SPAN_VALIDATOR$lambda$1(((Long) obj).longValue());
            }
        };
        ROW_SPAN_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivSeparatorJsonParser$$ExternalSyntheticLambda2
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivSeparatorJsonParser.ROW_SPAN_VALIDATOR$lambda$2(((Long) obj).longValue());
            }
        };
        TRANSITION_TRIGGERS_VALIDATOR = new ListValidator() { // from class: com.yandex.div2.DivSeparatorJsonParser$$ExternalSyntheticLambda3
            @Override // com.yandex.div.internal.parser.ListValidator
            public final boolean isValid(List list) {
                return DivSeparatorJsonParser.TRANSITION_TRIGGERS_VALIDATOR$lambda$3(list);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TRANSITION_TRIGGERS_VALIDATOR$lambda$3(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.size() >= 1;
    }
}
