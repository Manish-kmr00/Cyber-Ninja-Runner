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
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivStateJsonParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivStateJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivStateJsonParser {
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<Double> ALPHA_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(1.0d));

    @Deprecated
    public static final Expression<Boolean> CLIP_TO_BOUNDS_DEFAULT_VALUE = Expression.INSTANCE.constant(true);

    @Deprecated
    public static final DivSize.WrapContent HEIGHT_DEFAULT_VALUE = new DivSize.WrapContent(new DivWrapContentSize(null, null, null, 7, null));

    @Deprecated
    public static final Expression<DivTransitionSelector> TRANSITION_ANIMATION_SELECTOR_DEFAULT_VALUE = Expression.INSTANCE.constant(DivTransitionSelector.STATE_CHANGE);

    @Deprecated
    public static final Expression<DivVisibility> VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);

    @Deprecated
    public static final DivSize.MatchParent WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0));

    @Deprecated
    public static final TypeHelper<DivAlignmentHorizontal> TYPE_HELPER_ALIGNMENT_HORIZONTAL = TypeHelper.INSTANCE.from(ArraysKt.first(DivAlignmentHorizontal.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivStateJsonParser$Companion$TYPE_HELPER_ALIGNMENT_HORIZONTAL$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivAlignmentHorizontal);
        }
    });

    @Deprecated
    public static final TypeHelper<DivAlignmentVertical> TYPE_HELPER_ALIGNMENT_VERTICAL = TypeHelper.INSTANCE.from(ArraysKt.first(DivAlignmentVertical.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivStateJsonParser$Companion$TYPE_HELPER_ALIGNMENT_VERTICAL$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivAlignmentVertical);
        }
    });

    @Deprecated
    public static final TypeHelper<DivTransitionSelector> TYPE_HELPER_TRANSITION_ANIMATION_SELECTOR = TypeHelper.INSTANCE.from(ArraysKt.first(DivTransitionSelector.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivStateJsonParser$Companion$TYPE_HELPER_TRANSITION_ANIMATION_SELECTOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivTransitionSelector);
        }
    });

    @Deprecated
    public static final TypeHelper<DivVisibility> TYPE_HELPER_VISIBILITY = TypeHelper.INSTANCE.from(ArraysKt.first(DivVisibility.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivStateJsonParser$Companion$TYPE_HELPER_VISIBILITY$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivVisibility);
        }
    });

    @Deprecated
    public static final ValueValidator<Double> ALPHA_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivStateJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivStateJsonParser.ALPHA_VALIDATOR$lambda$0(((Double) obj).doubleValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> COLUMN_SPAN_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivStateJsonParser$$ExternalSyntheticLambda1
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivStateJsonParser.COLUMN_SPAN_VALIDATOR$lambda$1(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> ROW_SPAN_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivStateJsonParser$$ExternalSyntheticLambda2
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivStateJsonParser.ROW_SPAN_VALIDATOR$lambda$2(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ListValidator<DivState.State> STATES_VALIDATOR = new ListValidator() { // from class: com.yandex.div2.DivStateJsonParser$$ExternalSyntheticLambda3
        @Override // com.yandex.div.internal.parser.ListValidator
        public final boolean isValid(List list) {
            return DivStateJsonParser.STATES_VALIDATOR$lambda$3(list);
        }
    };

    @Deprecated
    public static final ListValidator<DivTransitionTrigger> TRANSITION_TRIGGERS_VALIDATOR = new ListValidator() { // from class: com.yandex.div2.DivStateJsonParser$$ExternalSyntheticLambda4
        @Override // com.yandex.div.internal.parser.ListValidator
        public final boolean isValid(List list) {
            return DivStateJsonParser.TRANSITION_TRIGGERS_VALIDATOR$lambda$4(list);
        }
    };

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

    public DivStateJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivStateJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivStateJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivState;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivState> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivState deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            DivAccessibility divAccessibility = (DivAccessibility) JsonPropertyParser.readOptional(context, data, "accessibility", this.component.getDivAccessibilityJsonEntityParser());
            Expression optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "alignment_horizontal", DivStateJsonParser.TYPE_HELPER_ALIGNMENT_HORIZONTAL, DivAlignmentHorizontal.FROM_STRING);
            Expression optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, "alignment_vertical", DivStateJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, DivAlignmentVertical.FROM_STRING);
            Expression<Double> optionalExpression3 = JsonExpressionParser.readOptionalExpression(context, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivStateJsonParser.ALPHA_VALIDATOR, DivStateJsonParser.ALPHA_DEFAULT_VALUE);
            if (optionalExpression3 == null) {
                optionalExpression3 = DivStateJsonParser.ALPHA_DEFAULT_VALUE;
            }
            Expression<Double> expression = optionalExpression3;
            List optionalList = JsonPropertyParser.readOptionalList(context, data, "animators", this.component.getDivAnimatorJsonEntityParser());
            List optionalList2 = JsonPropertyParser.readOptionalList(context, data, J2.g, this.component.getDivBackgroundJsonEntityParser());
            DivBorder divBorder = (DivBorder) JsonPropertyParser.readOptional(context, data, OutlinedTextFieldKt.BorderId, this.component.getDivBorderJsonEntityParser());
            Expression<Boolean> optionalExpression4 = JsonExpressionParser.readOptionalExpression(context, data, "clip_to_bounds", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivStateJsonParser.CLIP_TO_BOUNDS_DEFAULT_VALUE);
            if (optionalExpression4 == null) {
                optionalExpression4 = DivStateJsonParser.CLIP_TO_BOUNDS_DEFAULT_VALUE;
            }
            Expression<Boolean> expression2 = optionalExpression4;
            Expression optionalExpression5 = JsonExpressionParser.readOptionalExpression(context, data, "column_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivStateJsonParser.COLUMN_SPAN_VALIDATOR);
            Expression<String> optionalExpression6 = JsonExpressionParser.readOptionalExpression(context, data, "default_state_id", TypeHelpersKt.TYPE_HELPER_STRING);
            List optionalList3 = JsonPropertyParser.readOptionalList(context, data, "disappear_actions", this.component.getDivDisappearActionJsonEntityParser());
            String str = (String) JsonPropertyParser.readOptional(context, data, "div_id");
            List optionalList4 = JsonPropertyParser.readOptionalList(context, data, "extensions", this.component.getDivExtensionJsonEntityParser());
            DivFocus divFocus = (DivFocus) JsonPropertyParser.readOptional(context, data, "focus", this.component.getDivFocusJsonEntityParser());
            List optionalList5 = JsonPropertyParser.readOptionalList(context, data, "functions", this.component.getDivFunctionJsonEntityParser());
            DivSize.WrapContent wrapContent = (DivSize) JsonPropertyParser.readOptional(context, data, "height", this.component.getDivSizeJsonEntityParser());
            if (wrapContent == null) {
                wrapContent = DivStateJsonParser.HEIGHT_DEFAULT_VALUE;
            }
            DivSize divSize = wrapContent;
            Intrinsics.checkNotNullExpressionValue(divSize, "JsonPropertyParser.readO…) ?: HEIGHT_DEFAULT_VALUE");
            String str2 = (String) JsonPropertyParser.readOptional(context, data, "id");
            DivLayoutProvider divLayoutProvider = (DivLayoutProvider) JsonPropertyParser.readOptional(context, data, "layout_provider", this.component.getDivLayoutProviderJsonEntityParser());
            DivEdgeInsets divEdgeInsets = (DivEdgeInsets) JsonPropertyParser.readOptional(context, data, "margins", this.component.getDivEdgeInsetsJsonEntityParser());
            DivEdgeInsets divEdgeInsets2 = (DivEdgeInsets) JsonPropertyParser.readOptional(context, data, "paddings", this.component.getDivEdgeInsetsJsonEntityParser());
            Expression<String> optionalExpression7 = JsonExpressionParser.readOptionalExpression(context, data, "reuse_id", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression optionalExpression8 = JsonExpressionParser.readOptionalExpression(context, data, "row_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivStateJsonParser.ROW_SPAN_VALIDATOR);
            List optionalList6 = JsonPropertyParser.readOptionalList(context, data, "selected_actions", this.component.getDivActionJsonEntityParser());
            String str3 = (String) JsonPropertyParser.readOptional(context, data, "state_id_variable");
            List list = JsonPropertyParser.readList(context, data, "states", this.component.getDivStateStateJsonEntityParser(), DivStateJsonParser.STATES_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(list, "readList(context, data, …Parser, STATES_VALIDATOR)");
            List optionalList7 = JsonPropertyParser.readOptionalList(context, data, "tooltips", this.component.getDivTooltipJsonEntityParser());
            DivTransform divTransform = (DivTransform) JsonPropertyParser.readOptional(context, data, "transform", this.component.getDivTransformJsonEntityParser());
            Expression<DivTransitionSelector> optionalExpression9 = JsonExpressionParser.readOptionalExpression(context, data, "transition_animation_selector", DivStateJsonParser.TYPE_HELPER_TRANSITION_ANIMATION_SELECTOR, DivTransitionSelector.FROM_STRING, DivStateJsonParser.TRANSITION_ANIMATION_SELECTOR_DEFAULT_VALUE);
            if (optionalExpression9 == null) {
                optionalExpression9 = DivStateJsonParser.TRANSITION_ANIMATION_SELECTOR_DEFAULT_VALUE;
            }
            Expression<DivTransitionSelector> expression3 = optionalExpression9;
            DivChangeTransition divChangeTransition = (DivChangeTransition) JsonPropertyParser.readOptional(context, data, "transition_change", this.component.getDivChangeTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition = (DivAppearanceTransition) JsonPropertyParser.readOptional(context, data, "transition_in", this.component.getDivAppearanceTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition2 = (DivAppearanceTransition) JsonPropertyParser.readOptional(context, data, "transition_out", this.component.getDivAppearanceTransitionJsonEntityParser());
            List optionalList8 = JsonPropertyParser.readOptionalList(context, data, "transition_triggers", DivTransitionTrigger.FROM_STRING, DivStateJsonParser.TRANSITION_TRIGGERS_VALIDATOR);
            List optionalList9 = JsonPropertyParser.readOptionalList(context, data, "variable_triggers", this.component.getDivTriggerJsonEntityParser());
            List optionalList10 = JsonPropertyParser.readOptionalList(context, data, "variables", this.component.getDivVariableJsonEntityParser());
            Expression<DivVisibility> optionalExpression10 = JsonExpressionParser.readOptionalExpression(context, data, "visibility", DivStateJsonParser.TYPE_HELPER_VISIBILITY, DivVisibility.FROM_STRING, DivStateJsonParser.VISIBILITY_DEFAULT_VALUE);
            if (optionalExpression10 == null) {
                optionalExpression10 = DivStateJsonParser.VISIBILITY_DEFAULT_VALUE;
            }
            DivVisibilityAction divVisibilityAction = (DivVisibilityAction) JsonPropertyParser.readOptional(context, data, "visibility_action", this.component.getDivVisibilityActionJsonEntityParser());
            List optionalList11 = JsonPropertyParser.readOptionalList(context, data, "visibility_actions", this.component.getDivVisibilityActionJsonEntityParser());
            DivSize.MatchParent matchParent = (DivSize) JsonPropertyParser.readOptional(context, data, "width", this.component.getDivSizeJsonEntityParser());
            if (matchParent == null) {
                matchParent = DivStateJsonParser.WIDTH_DEFAULT_VALUE;
            }
            DivSize divSize2 = matchParent;
            Intrinsics.checkNotNullExpressionValue(divSize2, "JsonPropertyParser.readO…r) ?: WIDTH_DEFAULT_VALUE");
            return new DivState(divAccessibility, optionalExpression, optionalExpression2, expression, optionalList, optionalList2, divBorder, expression2, optionalExpression5, optionalExpression6, optionalList3, str, optionalList4, divFocus, optionalList5, divSize, str2, divLayoutProvider, divEdgeInsets, divEdgeInsets2, optionalExpression7, optionalExpression8, optionalList6, str3, list, optionalList7, divTransform, expression3, divChangeTransition, divAppearanceTransition, divAppearanceTransition2, optionalList8, optionalList9, optionalList10, optionalExpression10, divVisibilityAction, optionalList11, divSize2);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivState value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonPropertyParser.write(context, jSONObject, "accessibility", value.getAccessibility(), this.component.getDivAccessibilityJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "alignment_horizontal", value.getAlignmentHorizontal(), DivAlignmentHorizontal.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "alignment_vertical", value.getAlignmentVertical(), DivAlignmentVertical.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "alpha", value.getAlpha());
            JsonPropertyParser.writeList(context, jSONObject, "animators", value.getAnimators(), this.component.getDivAnimatorJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, J2.g, value.getBackground(), this.component.getDivBackgroundJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, OutlinedTextFieldKt.BorderId, value.getBorder(), this.component.getDivBorderJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "clip_to_bounds", value.clipToBounds);
            JsonExpressionParser.writeExpression(context, jSONObject, "column_span", value.getColumnSpan());
            JsonExpressionParser.writeExpression(context, jSONObject, "default_state_id", value.defaultStateId);
            JsonPropertyParser.writeList(context, jSONObject, "disappear_actions", value.getDisappearActions(), this.component.getDivDisappearActionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "div_id", value.divId);
            JsonPropertyParser.writeList(context, jSONObject, "extensions", value.getExtensions(), this.component.getDivExtensionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "focus", value.getFocus(), this.component.getDivFocusJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "functions", value.getFunctions(), this.component.getDivFunctionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "height", value.getHeight(), this.component.getDivSizeJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "id", value.getId());
            JsonPropertyParser.write(context, jSONObject, "layout_provider", value.getLayoutProvider(), this.component.getDivLayoutProviderJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "margins", value.getMargins(), this.component.getDivEdgeInsetsJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "paddings", value.getPaddings(), this.component.getDivEdgeInsetsJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "reuse_id", value.getReuseId());
            JsonExpressionParser.writeExpression(context, jSONObject, "row_span", value.getRowSpan());
            JsonPropertyParser.writeList(context, jSONObject, "selected_actions", value.getSelectedActions(), this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "state_id_variable", value.stateIdVariable);
            JsonPropertyParser.writeList(context, jSONObject, "states", value.states, this.component.getDivStateStateJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "tooltips", value.getTooltips(), this.component.getDivTooltipJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transform", value.getTransform(), this.component.getDivTransformJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "transition_animation_selector", value.transitionAnimationSelector, DivTransitionSelector.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "transition_change", value.getTransitionChange(), this.component.getDivChangeTransitionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transition_in", value.getTransitionIn(), this.component.getDivAppearanceTransitionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transition_out", value.getTransitionOut(), this.component.getDivAppearanceTransitionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "transition_triggers", value.getTransitionTriggers(), DivTransitionTrigger.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "type", "state");
            JsonPropertyParser.writeList(context, jSONObject, "variable_triggers", value.getVariableTriggers(), this.component.getDivTriggerJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "variables", value.getVariables(), this.component.getDivVariableJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "visibility", value.getVisibility(), DivVisibility.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "visibility_action", value.getVisibilityAction(), this.component.getDivVisibilityActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "visibility_actions", value.getVisibilityActions(), this.component.getDivVisibilityActionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "width", value.getWidth(), this.component.getDivSizeJsonEntityParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivStateJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivStateJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivStateTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivStateTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivStateTemplate deserialize(ParsingContext context, DivStateTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "accessibility", allowPropertyOverride, parent != null ? parent.accessibility : null, this.component.getDivAccessibilityJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex…bilityJsonTemplateParser)");
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alignment_horizontal", DivStateJsonParser.TYPE_HELPER_ALIGNMENT_HORIZONTAL, allowPropertyOverride, parent != null ? parent.alignmentHorizontal : null, DivAlignmentHorizontal.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…ntHorizontal.FROM_STRING)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alignment_vertical", DivStateJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, allowPropertyOverride, parent != null ? parent.alignmentVertical : null, DivAlignmentVertical.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…mentVertical.FROM_STRING)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.alpha : null, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivStateJsonParser.ALPHA_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…_DOUBLE, ALPHA_VALIDATOR)");
            Field optionalListField = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "animators", allowPropertyOverride, parent != null ? parent.animators : null, this.component.getDivAnimatorJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField, "readOptionalListField(co…imatorJsonTemplateParser)");
            Field optionalListField2 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, J2.g, allowPropertyOverride, parent != null ? parent.background : null, this.component.getDivBackgroundJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField2, "readOptionalListField(co…groundJsonTemplateParser)");
            Field optionalField2 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, OutlinedTextFieldKt.BorderId, allowPropertyOverride, parent != null ? parent.border : null, this.component.getDivBorderJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField2, "readOptionalField(contex…BorderJsonTemplateParser)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "clip_to_bounds", TypeHelpersKt.TYPE_HELPER_BOOLEAN, allowPropertyOverride, parent != null ? parent.clipToBounds : null, ParsingConvertersKt.ANY_TO_BOOLEAN);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…ToBounds, ANY_TO_BOOLEAN)");
            Field optionalFieldWithExpression5 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "column_span", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.columnSpan : null, ParsingConvertersKt.NUMBER_TO_INT, DivStateJsonParser.COLUMN_SPAN_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression5, "readOptionalFieldWithExp…T, COLUMN_SPAN_VALIDATOR)");
            Field<Expression<String>> optionalFieldWithExpression6 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "default_state_id", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.defaultStateId : null);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression6, "readOptionalFieldWithExp…, parent?.defaultStateId)");
            Field optionalListField3 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "disappear_actions", allowPropertyOverride, parent != null ? parent.disappearActions : null, this.component.getDivDisappearActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField3, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalField3 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "div_id", allowPropertyOverride, parent != null ? parent.divId : null);
            Intrinsics.checkNotNullExpressionValue(optionalField3, "readOptionalField(contex…wOverride, parent?.divId)");
            Field optionalListField4 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "extensions", allowPropertyOverride, parent != null ? parent.extensions : null, this.component.getDivExtensionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField4, "readOptionalListField(co…ensionJsonTemplateParser)");
            Field optionalField4 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "focus", allowPropertyOverride, parent != null ? parent.focus : null, this.component.getDivFocusJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField4, "readOptionalField(contex…vFocusJsonTemplateParser)");
            Field optionalListField5 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "functions", allowPropertyOverride, parent != null ? parent.functions : null, this.component.getDivFunctionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField5, "readOptionalListField(co…nctionJsonTemplateParser)");
            Field optionalField5 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "height", allowPropertyOverride, parent != null ? parent.height : null, this.component.getDivSizeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField5, "readOptionalField(contex…ivSizeJsonTemplateParser)");
            Field optionalField6 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "id", allowPropertyOverride, parent != null ? parent.id : null);
            Intrinsics.checkNotNullExpressionValue(optionalField6, "readOptionalField(contex…llowOverride, parent?.id)");
            Field optionalField7 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "layout_provider", allowPropertyOverride, parent != null ? parent.layoutProvider : null, this.component.getDivLayoutProviderJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField7, "readOptionalField(contex…oviderJsonTemplateParser)");
            Field optionalField8 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "margins", allowPropertyOverride, parent != null ? parent.margins : null, this.component.getDivEdgeInsetsJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField8, "readOptionalField(contex…InsetsJsonTemplateParser)");
            Field optionalField9 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "paddings", allowPropertyOverride, parent != null ? parent.paddings : null, this.component.getDivEdgeInsetsJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField9, "readOptionalField(contex…InsetsJsonTemplateParser)");
            Field<Expression<String>> optionalFieldWithExpression7 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "reuse_id", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.reuseId : null);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression7, "readOptionalFieldWithExp…verride, parent?.reuseId)");
            Field optionalFieldWithExpression8 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "row_span", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.rowSpan : null, ParsingConvertersKt.NUMBER_TO_INT, DivStateJsonParser.ROW_SPAN_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression8, "readOptionalFieldWithExp…_INT, ROW_SPAN_VALIDATOR)");
            Field optionalListField6 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "selected_actions", allowPropertyOverride, parent != null ? parent.selectedActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField6, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalField10 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "state_id_variable", allowPropertyOverride, parent != null ? parent.stateIdVariable : null);
            Intrinsics.checkNotNullExpressionValue(optionalField10, "readOptionalField(contex… parent?.stateIdVariable)");
            Field<List<DivStateTemplate.StateTemplate>> field = parent != null ? parent.states : null;
            Lazy<DivStateStateJsonParser.TemplateParserImpl> divStateStateJsonTemplateParser = this.component.getDivStateStateJsonTemplateParser();
            ListValidator<DivState.State> listValidator = DivStateJsonParser.STATES_VALIDATOR;
            Intrinsics.checkNotNull(listValidator, "null cannot be cast to non-null type com.yandex.div.internal.parser.ListValidator<T of com.yandex.div.internal.parser.ParsingValidatorsKt.cast>");
            Field listField = JsonFieldParser.readListField(parsingContextRestrictPropertyOverride, data, "states", allowPropertyOverride, field, divStateStateJsonTemplateParser, listValidator);
            Intrinsics.checkNotNullExpressionValue(listField, "readListField(context, d… STATES_VALIDATOR.cast())");
            Field optionalListField7 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "tooltips", allowPropertyOverride, parent != null ? parent.tooltips : null, this.component.getDivTooltipJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField7, "readOptionalListField(co…ooltipJsonTemplateParser)");
            Field optionalField11 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transform", allowPropertyOverride, parent != null ? parent.transform : null, this.component.getDivTransformJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField11, "readOptionalField(contex…nsformJsonTemplateParser)");
            Field optionalFieldWithExpression9 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "transition_animation_selector", DivStateJsonParser.TYPE_HELPER_TRANSITION_ANIMATION_SELECTOR, allowPropertyOverride, parent != null ? parent.transitionAnimationSelector : null, DivTransitionSelector.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression9, "readOptionalFieldWithExp…tionSelector.FROM_STRING)");
            Field optionalField12 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transition_change", allowPropertyOverride, parent != null ? parent.transitionChange : null, this.component.getDivChangeTransitionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField12, "readOptionalField(contex…sitionJsonTemplateParser)");
            Field optionalField13 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transition_in", allowPropertyOverride, parent != null ? parent.transitionIn : null, this.component.getDivAppearanceTransitionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField13, "readOptionalField(contex…sitionJsonTemplateParser)");
            Field optionalField14 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transition_out", allowPropertyOverride, parent != null ? parent.transitionOut : null, this.component.getDivAppearanceTransitionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField14, "readOptionalField(contex…sitionJsonTemplateParser)");
            Field<List<DivTransitionTrigger>> field2 = parent != null ? parent.transitionTriggers : null;
            Function1<String, DivTransitionTrigger> function1 = DivTransitionTrigger.FROM_STRING;
            ListValidator<DivTransitionTrigger> listValidator2 = DivStateJsonParser.TRANSITION_TRIGGERS_VALIDATOR;
            Intrinsics.checkNotNull(listValidator2, "null cannot be cast to non-null type com.yandex.div.internal.parser.ListValidator<T of com.yandex.div.internal.parser.ParsingValidatorsKt.cast>");
            Field optionalListField8 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "transition_triggers", allowPropertyOverride, field2, function1, listValidator2);
            Intrinsics.checkNotNullExpressionValue(optionalListField8, "readOptionalListField(co…RIGGERS_VALIDATOR.cast())");
            Field optionalListField9 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "variable_triggers", allowPropertyOverride, parent != null ? parent.variableTriggers : null, this.component.getDivTriggerJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField9, "readOptionalListField(co…riggerJsonTemplateParser)");
            Field optionalListField10 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "variables", allowPropertyOverride, parent != null ? parent.variables : null, this.component.getDivVariableJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField10, "readOptionalListField(co…riableJsonTemplateParser)");
            Field optionalFieldWithExpression10 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "visibility", DivStateJsonParser.TYPE_HELPER_VISIBILITY, allowPropertyOverride, parent != null ? parent.visibility : null, DivVisibility.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression10, "readOptionalFieldWithExp…ivVisibility.FROM_STRING)");
            Field optionalField15 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "visibility_action", allowPropertyOverride, parent != null ? parent.visibilityAction : null, this.component.getDivVisibilityActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField15, "readOptionalField(contex…ActionJsonTemplateParser)");
            Field optionalListField11 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "visibility_actions", allowPropertyOverride, parent != null ? parent.visibilityActions : null, this.component.getDivVisibilityActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField11, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalField16 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "width", allowPropertyOverride, parent != null ? parent.width : null, this.component.getDivSizeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField16, "readOptionalField(contex…ivSizeJsonTemplateParser)");
            return new DivStateTemplate(optionalField, optionalFieldWithExpression, optionalFieldWithExpression2, optionalFieldWithExpression3, optionalListField, optionalListField2, optionalField2, optionalFieldWithExpression4, optionalFieldWithExpression5, optionalFieldWithExpression6, optionalListField3, optionalField3, optionalListField4, optionalField4, optionalListField5, optionalField5, optionalField6, optionalField7, optionalField8, optionalField9, optionalFieldWithExpression7, optionalFieldWithExpression8, optionalListField6, optionalField10, listField, optionalListField7, optionalField11, optionalFieldWithExpression9, optionalField12, optionalField13, optionalField14, optionalListField8, optionalListField9, optionalListField10, optionalFieldWithExpression10, optionalField15, optionalListField11, optionalField16);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivStateTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeField(context, jSONObject, "accessibility", value.accessibility, this.component.getDivAccessibilityJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "alignment_horizontal", value.alignmentHorizontal, DivAlignmentHorizontal.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "alignment_vertical", value.alignmentVertical, DivAlignmentVertical.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "alpha", value.alpha);
            JsonFieldParser.writeListField(context, jSONObject, "animators", value.animators, this.component.getDivAnimatorJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, J2.g, value.background, this.component.getDivBackgroundJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, OutlinedTextFieldKt.BorderId, value.border, this.component.getDivBorderJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "clip_to_bounds", value.clipToBounds);
            JsonFieldParser.writeExpressionField(context, jSONObject, "column_span", value.columnSpan);
            JsonFieldParser.writeExpressionField(context, jSONObject, "default_state_id", value.defaultStateId);
            JsonFieldParser.writeListField(context, jSONObject, "disappear_actions", value.disappearActions, this.component.getDivDisappearActionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "div_id", value.divId);
            JsonFieldParser.writeListField(context, jSONObject, "extensions", value.extensions, this.component.getDivExtensionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "focus", value.focus, this.component.getDivFocusJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "functions", value.functions, this.component.getDivFunctionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "height", value.height, this.component.getDivSizeJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "id", value.id);
            JsonFieldParser.writeField(context, jSONObject, "layout_provider", value.layoutProvider, this.component.getDivLayoutProviderJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "margins", value.margins, this.component.getDivEdgeInsetsJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "paddings", value.paddings, this.component.getDivEdgeInsetsJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "reuse_id", value.reuseId);
            JsonFieldParser.writeExpressionField(context, jSONObject, "row_span", value.rowSpan);
            JsonFieldParser.writeListField(context, jSONObject, "selected_actions", value.selectedActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "state_id_variable", value.stateIdVariable);
            JsonFieldParser.writeListField(context, jSONObject, "states", value.states, this.component.getDivStateStateJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "tooltips", value.tooltips, this.component.getDivTooltipJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transform", value.transform, this.component.getDivTransformJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "transition_animation_selector", value.transitionAnimationSelector, DivTransitionSelector.TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "transition_change", value.transitionChange, this.component.getDivChangeTransitionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transition_in", value.transitionIn, this.component.getDivAppearanceTransitionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transition_out", value.transitionOut, this.component.getDivAppearanceTransitionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "transition_triggers", value.transitionTriggers, DivTransitionTrigger.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "type", "state");
            JsonFieldParser.writeListField(context, jSONObject, "variable_triggers", value.variableTriggers, this.component.getDivTriggerJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "variables", value.variables, this.component.getDivVariableJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "visibility", value.visibility, DivVisibility.TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "visibility_action", value.visibilityAction, this.component.getDivVisibilityActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "visibility_actions", value.visibilityActions, this.component.getDivVisibilityActionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "width", value.width, this.component.getDivSizeJsonTemplateParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivStateJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivStateJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivStateTemplate;", "Lcom/yandex/div2/DivState;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivStateTemplate, DivState> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivState resolve(ParsingContext context, DivStateTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            DivAccessibility divAccessibility = (DivAccessibility) JsonFieldResolver.resolveOptional(context, template.accessibility, data, "accessibility", this.component.getDivAccessibilityJsonTemplateResolver(), this.component.getDivAccessibilityJsonEntityParser());
            Expression expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.alignmentHorizontal, data, "alignment_horizontal", DivStateJsonParser.TYPE_HELPER_ALIGNMENT_HORIZONTAL, DivAlignmentHorizontal.FROM_STRING);
            Expression expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.alignmentVertical, data, "alignment_vertical", DivStateJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, DivAlignmentVertical.FROM_STRING);
            Expression<Double> expressionResolveOptionalExpression3 = JsonFieldResolver.resolveOptionalExpression(context, template.alpha, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivStateJsonParser.ALPHA_VALIDATOR, DivStateJsonParser.ALPHA_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression3 == null) {
                expressionResolveOptionalExpression3 = DivStateJsonParser.ALPHA_DEFAULT_VALUE;
            }
            Expression<Double> expression = expressionResolveOptionalExpression3;
            List listResolveOptionalList = JsonFieldResolver.resolveOptionalList(context, template.animators, data, "animators", this.component.getDivAnimatorJsonTemplateResolver(), this.component.getDivAnimatorJsonEntityParser());
            List listResolveOptionalList2 = JsonFieldResolver.resolveOptionalList(context, template.background, data, J2.g, this.component.getDivBackgroundJsonTemplateResolver(), this.component.getDivBackgroundJsonEntityParser());
            DivBorder divBorder = (DivBorder) JsonFieldResolver.resolveOptional(context, template.border, data, OutlinedTextFieldKt.BorderId, this.component.getDivBorderJsonTemplateResolver(), this.component.getDivBorderJsonEntityParser());
            Expression<Boolean> expressionResolveOptionalExpression4 = JsonFieldResolver.resolveOptionalExpression(context, template.clipToBounds, data, "clip_to_bounds", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivStateJsonParser.CLIP_TO_BOUNDS_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression4 == null) {
                expressionResolveOptionalExpression4 = DivStateJsonParser.CLIP_TO_BOUNDS_DEFAULT_VALUE;
            }
            Expression<Boolean> expression2 = expressionResolveOptionalExpression4;
            Expression expressionResolveOptionalExpression5 = JsonFieldResolver.resolveOptionalExpression(context, template.columnSpan, data, "column_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivStateJsonParser.COLUMN_SPAN_VALIDATOR);
            Expression expressionResolveOptionalExpression6 = JsonFieldResolver.resolveOptionalExpression(context, template.defaultStateId, data, "default_state_id", TypeHelpersKt.TYPE_HELPER_STRING);
            List listResolveOptionalList3 = JsonFieldResolver.resolveOptionalList(context, template.disappearActions, data, "disappear_actions", this.component.getDivDisappearActionJsonTemplateResolver(), this.component.getDivDisappearActionJsonEntityParser());
            String str = (String) JsonFieldResolver.resolveOptional(context, template.divId, data, "div_id");
            List listResolveOptionalList4 = JsonFieldResolver.resolveOptionalList(context, template.extensions, data, "extensions", this.component.getDivExtensionJsonTemplateResolver(), this.component.getDivExtensionJsonEntityParser());
            DivFocus divFocus = (DivFocus) JsonFieldResolver.resolveOptional(context, template.focus, data, "focus", this.component.getDivFocusJsonTemplateResolver(), this.component.getDivFocusJsonEntityParser());
            List listResolveOptionalList5 = JsonFieldResolver.resolveOptionalList(context, template.functions, data, "functions", this.component.getDivFunctionJsonTemplateResolver(), this.component.getDivFunctionJsonEntityParser());
            DivSize.WrapContent wrapContent = (DivSize) JsonFieldResolver.resolveOptional(context, template.height, data, "height", this.component.getDivSizeJsonTemplateResolver(), this.component.getDivSizeJsonEntityParser());
            if (wrapContent == null) {
                wrapContent = DivStateJsonParser.HEIGHT_DEFAULT_VALUE;
            }
            DivSize divSize = wrapContent;
            Intrinsics.checkNotNullExpressionValue(divSize, "JsonFieldResolver.resolv…) ?: HEIGHT_DEFAULT_VALUE");
            String str2 = (String) JsonFieldResolver.resolveOptional(context, template.id, data, "id");
            DivLayoutProvider divLayoutProvider = (DivLayoutProvider) JsonFieldResolver.resolveOptional(context, template.layoutProvider, data, "layout_provider", this.component.getDivLayoutProviderJsonTemplateResolver(), this.component.getDivLayoutProviderJsonEntityParser());
            DivEdgeInsets divEdgeInsets = (DivEdgeInsets) JsonFieldResolver.resolveOptional(context, template.margins, data, "margins", this.component.getDivEdgeInsetsJsonTemplateResolver(), this.component.getDivEdgeInsetsJsonEntityParser());
            DivEdgeInsets divEdgeInsets2 = (DivEdgeInsets) JsonFieldResolver.resolveOptional(context, template.paddings, data, "paddings", this.component.getDivEdgeInsetsJsonTemplateResolver(), this.component.getDivEdgeInsetsJsonEntityParser());
            Expression expressionResolveOptionalExpression7 = JsonFieldResolver.resolveOptionalExpression(context, template.reuseId, data, "reuse_id", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression expressionResolveOptionalExpression8 = JsonFieldResolver.resolveOptionalExpression(context, template.rowSpan, data, "row_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivStateJsonParser.ROW_SPAN_VALIDATOR);
            List listResolveOptionalList6 = JsonFieldResolver.resolveOptionalList(context, template.selectedActions, data, "selected_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            String str3 = (String) JsonFieldResolver.resolveOptional(context, template.stateIdVariable, data, "state_id_variable");
            List listResolveList = JsonFieldResolver.resolveList(context, template.states, data, "states", this.component.getDivStateStateJsonTemplateResolver(), this.component.getDivStateStateJsonEntityParser(), DivStateJsonParser.STATES_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(listResolveList, "resolveList(context, tem…Parser, STATES_VALIDATOR)");
            List listResolveOptionalList7 = JsonFieldResolver.resolveOptionalList(context, template.tooltips, data, "tooltips", this.component.getDivTooltipJsonTemplateResolver(), this.component.getDivTooltipJsonEntityParser());
            DivTransform divTransform = (DivTransform) JsonFieldResolver.resolveOptional(context, template.transform, data, "transform", this.component.getDivTransformJsonTemplateResolver(), this.component.getDivTransformJsonEntityParser());
            Expression<DivTransitionSelector> expressionResolveOptionalExpression9 = JsonFieldResolver.resolveOptionalExpression(context, template.transitionAnimationSelector, data, "transition_animation_selector", DivStateJsonParser.TYPE_HELPER_TRANSITION_ANIMATION_SELECTOR, DivTransitionSelector.FROM_STRING, DivStateJsonParser.TRANSITION_ANIMATION_SELECTOR_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression9 == null) {
                expressionResolveOptionalExpression9 = DivStateJsonParser.TRANSITION_ANIMATION_SELECTOR_DEFAULT_VALUE;
            }
            Expression<DivTransitionSelector> expression3 = expressionResolveOptionalExpression9;
            DivChangeTransition divChangeTransition = (DivChangeTransition) JsonFieldResolver.resolveOptional(context, template.transitionChange, data, "transition_change", this.component.getDivChangeTransitionJsonTemplateResolver(), this.component.getDivChangeTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition = (DivAppearanceTransition) JsonFieldResolver.resolveOptional(context, template.transitionIn, data, "transition_in", this.component.getDivAppearanceTransitionJsonTemplateResolver(), this.component.getDivAppearanceTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition2 = (DivAppearanceTransition) JsonFieldResolver.resolveOptional(context, template.transitionOut, data, "transition_out", this.component.getDivAppearanceTransitionJsonTemplateResolver(), this.component.getDivAppearanceTransitionJsonEntityParser());
            List listResolveOptionalList8 = JsonFieldResolver.resolveOptionalList(context, template.transitionTriggers, data, "transition_triggers", DivTransitionTrigger.FROM_STRING, DivStateJsonParser.TRANSITION_TRIGGERS_VALIDATOR);
            List listResolveOptionalList9 = JsonFieldResolver.resolveOptionalList(context, template.variableTriggers, data, "variable_triggers", this.component.getDivTriggerJsonTemplateResolver(), this.component.getDivTriggerJsonEntityParser());
            List listResolveOptionalList10 = JsonFieldResolver.resolveOptionalList(context, template.variables, data, "variables", this.component.getDivVariableJsonTemplateResolver(), this.component.getDivVariableJsonEntityParser());
            Expression<DivVisibility> expressionResolveOptionalExpression10 = JsonFieldResolver.resolveOptionalExpression(context, template.visibility, data, "visibility", DivStateJsonParser.TYPE_HELPER_VISIBILITY, DivVisibility.FROM_STRING, DivStateJsonParser.VISIBILITY_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression10 == null) {
                expressionResolveOptionalExpression10 = DivStateJsonParser.VISIBILITY_DEFAULT_VALUE;
            }
            Expression<DivVisibility> expression4 = expressionResolveOptionalExpression10;
            DivVisibilityAction divVisibilityAction = (DivVisibilityAction) JsonFieldResolver.resolveOptional(context, template.visibilityAction, data, "visibility_action", this.component.getDivVisibilityActionJsonTemplateResolver(), this.component.getDivVisibilityActionJsonEntityParser());
            List listResolveOptionalList11 = JsonFieldResolver.resolveOptionalList(context, template.visibilityActions, data, "visibility_actions", this.component.getDivVisibilityActionJsonTemplateResolver(), this.component.getDivVisibilityActionJsonEntityParser());
            DivSize.MatchParent matchParent = (DivSize) JsonFieldResolver.resolveOptional(context, template.width, data, "width", this.component.getDivSizeJsonTemplateResolver(), this.component.getDivSizeJsonEntityParser());
            if (matchParent == null) {
                matchParent = DivStateJsonParser.WIDTH_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(matchParent, "JsonFieldResolver.resolv…r) ?: WIDTH_DEFAULT_VALUE");
            return new DivState(divAccessibility, expressionResolveOptionalExpression, expressionResolveOptionalExpression2, expression, listResolveOptionalList, listResolveOptionalList2, divBorder, expression2, expressionResolveOptionalExpression5, expressionResolveOptionalExpression6, listResolveOptionalList3, str, listResolveOptionalList4, divFocus, listResolveOptionalList5, divSize, str2, divLayoutProvider, divEdgeInsets, divEdgeInsets2, expressionResolveOptionalExpression7, expressionResolveOptionalExpression8, listResolveOptionalList6, str3, listResolveList, listResolveOptionalList7, divTransform, expression3, divChangeTransition, divAppearanceTransition, divAppearanceTransition2, listResolveOptionalList8, listResolveOptionalList9, listResolveOptionalList10, expression4, divVisibilityAction, listResolveOptionalList11, matchParent);
        }
    }

    /* JADX INFO: compiled from: DivStateJsonParser.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00108\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00178\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u00178\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00178\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/yandex/div2/DivStateJsonParser$Companion;", "", "()V", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "ALPHA_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "CLIP_TO_BOUNDS_DEFAULT_VALUE", "", "COLUMN_SPAN_VALIDATOR", "", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "ROW_SPAN_VALIDATOR", "STATES_VALIDATOR", "Lcom/yandex/div/internal/parser/ListValidator;", "Lcom/yandex/div2/DivState$State;", "TRANSITION_ANIMATION_SELECTOR_DEFAULT_VALUE", "Lcom/yandex/div2/DivTransitionSelector;", "TRANSITION_TRIGGERS_VALIDATOR", "Lcom/yandex/div2/DivTransitionTrigger;", "TYPE_HELPER_ALIGNMENT_HORIZONTAL", "Lcom/yandex/div/internal/parser/TypeHelper;", "Lcom/yandex/div2/DivAlignmentHorizontal;", "TYPE_HELPER_ALIGNMENT_VERTICAL", "Lcom/yandex/div2/DivAlignmentVertical;", "TYPE_HELPER_TRANSITION_ANIMATION_SELECTOR", "TYPE_HELPER_VISIBILITY", "Lcom/yandex/div2/DivVisibility;", "VISIBILITY_DEFAULT_VALUE", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean STATES_VALIDATOR$lambda$3(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.size() >= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TRANSITION_TRIGGERS_VALIDATOR$lambda$4(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.size() >= 1;
    }
}
