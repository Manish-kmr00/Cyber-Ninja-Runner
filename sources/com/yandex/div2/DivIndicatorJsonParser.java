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

/* JADX INFO: compiled from: DivIndicatorJsonParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivIndicatorJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivIndicatorJsonParser {

    @Deprecated
    public static final ValueValidator<Double> ACTIVE_ITEM_SIZE_VALIDATOR;

    @Deprecated
    public static final ValueValidator<Double> ALPHA_VALIDATOR;

    @Deprecated
    public static final ValueValidator<Long> COLUMN_SPAN_VALIDATOR;

    @Deprecated
    public static final ValueValidator<Double> MINIMUM_ITEM_SIZE_VALIDATOR;

    @Deprecated
    public static final ValueValidator<Long> ROW_SPAN_VALIDATOR;

    @Deprecated
    public static final DivShape.RoundedRectangle SHAPE_DEFAULT_VALUE;

    @Deprecated
    public static final DivFixedSize SPACE_BETWEEN_CENTERS_DEFAULT_VALUE;

    @Deprecated
    public static final ListValidator<DivTransitionTrigger> TRANSITION_TRIGGERS_VALIDATOR;

    @Deprecated
    public static final TypeHelper<DivAlignmentHorizontal> TYPE_HELPER_ALIGNMENT_HORIZONTAL;

    @Deprecated
    public static final TypeHelper<DivAlignmentVertical> TYPE_HELPER_ALIGNMENT_VERTICAL;

    @Deprecated
    public static final TypeHelper<DivIndicator.Animation> TYPE_HELPER_ANIMATION;

    @Deprecated
    public static final TypeHelper<DivVisibility> TYPE_HELPER_VISIBILITY;

    @Deprecated
    public static final Expression<DivVisibility> VISIBILITY_DEFAULT_VALUE;

    @Deprecated
    public static final DivSize.MatchParent WIDTH_DEFAULT_VALUE;
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<Integer> ACTIVE_ITEM_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(16768096);

    @Deprecated
    public static final Expression<Double> ACTIVE_ITEM_SIZE_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(1.3d));

    @Deprecated
    public static final Expression<Double> ALPHA_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(1.0d));

    @Deprecated
    public static final Expression<DivIndicator.Animation> ANIMATION_DEFAULT_VALUE = Expression.INSTANCE.constant(DivIndicator.Animation.SCALE);

    @Deprecated
    public static final DivSize.WrapContent HEIGHT_DEFAULT_VALUE = new DivSize.WrapContent(new DivWrapContentSize(null, null, null, 7, null));

    @Deprecated
    public static final Expression<Integer> INACTIVE_ITEM_COLOR_DEFAULT_VALUE = Expression.INSTANCE.constant(865180853);

    @Deprecated
    public static final Expression<Double> MINIMUM_ITEM_SIZE_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(0.5d));

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ACTIVE_ITEM_SIZE_VALIDATOR$lambda$0(double d) {
        return d > 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ALPHA_VALIDATOR$lambda$1(double d) {
        return d >= 0.0d && d <= 1.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean COLUMN_SPAN_VALIDATOR$lambda$2(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MINIMUM_ITEM_SIZE_VALIDATOR$lambda$3(double d) {
        return d > 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ROW_SPAN_VALIDATOR$lambda$4(long j) {
        return j >= 0;
    }

    public DivIndicatorJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivIndicatorJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivIndicatorJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivIndicator;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivIndicator> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivIndicator deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            DivAccessibility divAccessibility = (DivAccessibility) JsonPropertyParser.readOptional(context, data, "accessibility", this.component.getDivAccessibilityJsonEntityParser());
            Expression<Integer> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "active_item_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT, DivIndicatorJsonParser.ACTIVE_ITEM_COLOR_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivIndicatorJsonParser.ACTIVE_ITEM_COLOR_DEFAULT_VALUE;
            }
            Expression<Integer> expression = optionalExpression;
            Expression<Double> optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, "active_item_size", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivIndicatorJsonParser.ACTIVE_ITEM_SIZE_VALIDATOR, DivIndicatorJsonParser.ACTIVE_ITEM_SIZE_DEFAULT_VALUE);
            if (optionalExpression2 == null) {
                optionalExpression2 = DivIndicatorJsonParser.ACTIVE_ITEM_SIZE_DEFAULT_VALUE;
            }
            Expression<Double> expression2 = optionalExpression2;
            DivRoundedRectangleShape divRoundedRectangleShape = (DivRoundedRectangleShape) JsonPropertyParser.readOptional(context, data, "active_shape", this.component.getDivRoundedRectangleShapeJsonEntityParser());
            Expression optionalExpression3 = JsonExpressionParser.readOptionalExpression(context, data, "alignment_horizontal", DivIndicatorJsonParser.TYPE_HELPER_ALIGNMENT_HORIZONTAL, DivAlignmentHorizontal.FROM_STRING);
            Expression optionalExpression4 = JsonExpressionParser.readOptionalExpression(context, data, "alignment_vertical", DivIndicatorJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, DivAlignmentVertical.FROM_STRING);
            Expression<Double> optionalExpression5 = JsonExpressionParser.readOptionalExpression(context, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivIndicatorJsonParser.ALPHA_VALIDATOR, DivIndicatorJsonParser.ALPHA_DEFAULT_VALUE);
            if (optionalExpression5 == null) {
                optionalExpression5 = DivIndicatorJsonParser.ALPHA_DEFAULT_VALUE;
            }
            Expression<Double> expression3 = optionalExpression5;
            Expression<DivIndicator.Animation> optionalExpression6 = JsonExpressionParser.readOptionalExpression(context, data, "animation", DivIndicatorJsonParser.TYPE_HELPER_ANIMATION, DivIndicator.Animation.FROM_STRING, DivIndicatorJsonParser.ANIMATION_DEFAULT_VALUE);
            if (optionalExpression6 == null) {
                optionalExpression6 = DivIndicatorJsonParser.ANIMATION_DEFAULT_VALUE;
            }
            Expression<DivIndicator.Animation> expression4 = optionalExpression6;
            List optionalList = JsonPropertyParser.readOptionalList(context, data, "animators", this.component.getDivAnimatorJsonEntityParser());
            List optionalList2 = JsonPropertyParser.readOptionalList(context, data, J2.g, this.component.getDivBackgroundJsonEntityParser());
            DivBorder divBorder = (DivBorder) JsonPropertyParser.readOptional(context, data, OutlinedTextFieldKt.BorderId, this.component.getDivBorderJsonEntityParser());
            Expression optionalExpression7 = JsonExpressionParser.readOptionalExpression(context, data, "column_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivIndicatorJsonParser.COLUMN_SPAN_VALIDATOR);
            List optionalList3 = JsonPropertyParser.readOptionalList(context, data, "disappear_actions", this.component.getDivDisappearActionJsonEntityParser());
            List optionalList4 = JsonPropertyParser.readOptionalList(context, data, "extensions", this.component.getDivExtensionJsonEntityParser());
            DivFocus divFocus = (DivFocus) JsonPropertyParser.readOptional(context, data, "focus", this.component.getDivFocusJsonEntityParser());
            List optionalList5 = JsonPropertyParser.readOptionalList(context, data, "functions", this.component.getDivFunctionJsonEntityParser());
            DivSize.WrapContent wrapContent = (DivSize) JsonPropertyParser.readOptional(context, data, "height", this.component.getDivSizeJsonEntityParser());
            if (wrapContent == null) {
                wrapContent = DivIndicatorJsonParser.HEIGHT_DEFAULT_VALUE;
            }
            DivSize divSize = wrapContent;
            Intrinsics.checkNotNullExpressionValue(divSize, "JsonPropertyParser.readO…) ?: HEIGHT_DEFAULT_VALUE");
            String str = (String) JsonPropertyParser.readOptional(context, data, "id");
            Expression<Integer> optionalExpression8 = JsonExpressionParser.readOptionalExpression(context, data, "inactive_item_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT, DivIndicatorJsonParser.INACTIVE_ITEM_COLOR_DEFAULT_VALUE);
            if (optionalExpression8 == null) {
                optionalExpression8 = DivIndicatorJsonParser.INACTIVE_ITEM_COLOR_DEFAULT_VALUE;
            }
            Expression<Integer> expression5 = optionalExpression8;
            DivRoundedRectangleShape divRoundedRectangleShape2 = (DivRoundedRectangleShape) JsonPropertyParser.readOptional(context, data, "inactive_minimum_shape", this.component.getDivRoundedRectangleShapeJsonEntityParser());
            DivRoundedRectangleShape divRoundedRectangleShape3 = (DivRoundedRectangleShape) JsonPropertyParser.readOptional(context, data, "inactive_shape", this.component.getDivRoundedRectangleShapeJsonEntityParser());
            DivIndicatorItemPlacement divIndicatorItemPlacement = (DivIndicatorItemPlacement) JsonPropertyParser.readOptional(context, data, "items_placement", this.component.getDivIndicatorItemPlacementJsonEntityParser());
            DivLayoutProvider divLayoutProvider = (DivLayoutProvider) JsonPropertyParser.readOptional(context, data, "layout_provider", this.component.getDivLayoutProviderJsonEntityParser());
            DivEdgeInsets divEdgeInsets = (DivEdgeInsets) JsonPropertyParser.readOptional(context, data, "margins", this.component.getDivEdgeInsetsJsonEntityParser());
            Expression<Double> optionalExpression9 = JsonExpressionParser.readOptionalExpression(context, data, "minimum_item_size", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivIndicatorJsonParser.MINIMUM_ITEM_SIZE_VALIDATOR, DivIndicatorJsonParser.MINIMUM_ITEM_SIZE_DEFAULT_VALUE);
            if (optionalExpression9 == null) {
                optionalExpression9 = DivIndicatorJsonParser.MINIMUM_ITEM_SIZE_DEFAULT_VALUE;
            }
            Expression<Double> expression6 = optionalExpression9;
            DivEdgeInsets divEdgeInsets2 = (DivEdgeInsets) JsonPropertyParser.readOptional(context, data, "paddings", this.component.getDivEdgeInsetsJsonEntityParser());
            String str2 = (String) JsonPropertyParser.readOptional(context, data, "pager_id");
            Expression<String> optionalExpression10 = JsonExpressionParser.readOptionalExpression(context, data, "reuse_id", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression optionalExpression11 = JsonExpressionParser.readOptionalExpression(context, data, "row_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivIndicatorJsonParser.ROW_SPAN_VALIDATOR);
            List optionalList6 = JsonPropertyParser.readOptionalList(context, data, "selected_actions", this.component.getDivActionJsonEntityParser());
            DivShape.RoundedRectangle roundedRectangle = (DivShape) JsonPropertyParser.readOptional(context, data, "shape", this.component.getDivShapeJsonEntityParser());
            if (roundedRectangle == null) {
                roundedRectangle = DivIndicatorJsonParser.SHAPE_DEFAULT_VALUE;
            }
            DivShape divShape = roundedRectangle;
            Intrinsics.checkNotNullExpressionValue(divShape, "JsonPropertyParser.readO…r) ?: SHAPE_DEFAULT_VALUE");
            DivFixedSize divFixedSize = (DivFixedSize) JsonPropertyParser.readOptional(context, data, "space_between_centers", this.component.getDivFixedSizeJsonEntityParser());
            if (divFixedSize == null) {
                divFixedSize = DivIndicatorJsonParser.SPACE_BETWEEN_CENTERS_DEFAULT_VALUE;
            }
            DivFixedSize divFixedSize2 = divFixedSize;
            Intrinsics.checkNotNullExpressionValue(divFixedSize2, "JsonPropertyParser.readO…EEN_CENTERS_DEFAULT_VALUE");
            List optionalList7 = JsonPropertyParser.readOptionalList(context, data, "tooltips", this.component.getDivTooltipJsonEntityParser());
            DivTransform divTransform = (DivTransform) JsonPropertyParser.readOptional(context, data, "transform", this.component.getDivTransformJsonEntityParser());
            DivChangeTransition divChangeTransition = (DivChangeTransition) JsonPropertyParser.readOptional(context, data, "transition_change", this.component.getDivChangeTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition = (DivAppearanceTransition) JsonPropertyParser.readOptional(context, data, "transition_in", this.component.getDivAppearanceTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition2 = (DivAppearanceTransition) JsonPropertyParser.readOptional(context, data, "transition_out", this.component.getDivAppearanceTransitionJsonEntityParser());
            List optionalList8 = JsonPropertyParser.readOptionalList(context, data, "transition_triggers", DivTransitionTrigger.FROM_STRING, DivIndicatorJsonParser.TRANSITION_TRIGGERS_VALIDATOR);
            List optionalList9 = JsonPropertyParser.readOptionalList(context, data, "variable_triggers", this.component.getDivTriggerJsonEntityParser());
            List optionalList10 = JsonPropertyParser.readOptionalList(context, data, "variables", this.component.getDivVariableJsonEntityParser());
            Expression<DivVisibility> optionalExpression12 = JsonExpressionParser.readOptionalExpression(context, data, "visibility", DivIndicatorJsonParser.TYPE_HELPER_VISIBILITY, DivVisibility.FROM_STRING, DivIndicatorJsonParser.VISIBILITY_DEFAULT_VALUE);
            if (optionalExpression12 == null) {
                optionalExpression12 = DivIndicatorJsonParser.VISIBILITY_DEFAULT_VALUE;
            }
            DivVisibilityAction divVisibilityAction = (DivVisibilityAction) JsonPropertyParser.readOptional(context, data, "visibility_action", this.component.getDivVisibilityActionJsonEntityParser());
            List optionalList11 = JsonPropertyParser.readOptionalList(context, data, "visibility_actions", this.component.getDivVisibilityActionJsonEntityParser());
            DivSize.MatchParent matchParent = (DivSize) JsonPropertyParser.readOptional(context, data, "width", this.component.getDivSizeJsonEntityParser());
            if (matchParent == null) {
                matchParent = DivIndicatorJsonParser.WIDTH_DEFAULT_VALUE;
            }
            DivSize divSize2 = matchParent;
            Intrinsics.checkNotNullExpressionValue(divSize2, "JsonPropertyParser.readO…r) ?: WIDTH_DEFAULT_VALUE");
            return new DivIndicator(divAccessibility, expression, expression2, divRoundedRectangleShape, optionalExpression3, optionalExpression4, expression3, expression4, optionalList, optionalList2, divBorder, optionalExpression7, optionalList3, optionalList4, divFocus, optionalList5, divSize, str, expression5, divRoundedRectangleShape2, divRoundedRectangleShape3, divIndicatorItemPlacement, divLayoutProvider, divEdgeInsets, expression6, divEdgeInsets2, str2, optionalExpression10, optionalExpression11, optionalList6, divShape, divFixedSize2, optionalList7, divTransform, divChangeTransition, divAppearanceTransition, divAppearanceTransition2, optionalList8, optionalList9, optionalList10, optionalExpression12, divVisibilityAction, optionalList11, divSize2);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivIndicator value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonPropertyParser.write(context, jSONObject, "accessibility", value.getAccessibility(), this.component.getDivAccessibilityJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "active_item_color", value.activeItemColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "active_item_size", value.activeItemSize);
            JsonPropertyParser.write(context, jSONObject, "active_shape", value.activeShape, this.component.getDivRoundedRectangleShapeJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "alignment_horizontal", value.getAlignmentHorizontal(), DivAlignmentHorizontal.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "alignment_vertical", value.getAlignmentVertical(), DivAlignmentVertical.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "alpha", value.getAlpha());
            JsonExpressionParser.writeExpression(context, jSONObject, "animation", value.animation, DivIndicator.Animation.TO_STRING);
            JsonPropertyParser.writeList(context, jSONObject, "animators", value.getAnimators(), this.component.getDivAnimatorJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, J2.g, value.getBackground(), this.component.getDivBackgroundJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, OutlinedTextFieldKt.BorderId, value.getBorder(), this.component.getDivBorderJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "column_span", value.getColumnSpan());
            JsonPropertyParser.writeList(context, jSONObject, "disappear_actions", value.getDisappearActions(), this.component.getDivDisappearActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "extensions", value.getExtensions(), this.component.getDivExtensionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "focus", value.getFocus(), this.component.getDivFocusJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "functions", value.getFunctions(), this.component.getDivFunctionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "height", value.getHeight(), this.component.getDivSizeJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "id", value.getId());
            JsonExpressionParser.writeExpression(context, jSONObject, "inactive_item_color", value.inactiveItemColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "inactive_minimum_shape", value.inactiveMinimumShape, this.component.getDivRoundedRectangleShapeJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "inactive_shape", value.inactiveShape, this.component.getDivRoundedRectangleShapeJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "items_placement", value.itemsPlacement, this.component.getDivIndicatorItemPlacementJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "layout_provider", value.getLayoutProvider(), this.component.getDivLayoutProviderJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "margins", value.getMargins(), this.component.getDivEdgeInsetsJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "minimum_item_size", value.minimumItemSize);
            JsonPropertyParser.write(context, jSONObject, "paddings", value.getPaddings(), this.component.getDivEdgeInsetsJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "pager_id", value.pagerId);
            JsonExpressionParser.writeExpression(context, jSONObject, "reuse_id", value.getReuseId());
            JsonExpressionParser.writeExpression(context, jSONObject, "row_span", value.getRowSpan());
            JsonPropertyParser.writeList(context, jSONObject, "selected_actions", value.getSelectedActions(), this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "shape", value.shape, this.component.getDivShapeJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "space_between_centers", value.spaceBetweenCenters, this.component.getDivFixedSizeJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "tooltips", value.getTooltips(), this.component.getDivTooltipJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transform", value.getTransform(), this.component.getDivTransformJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transition_change", value.getTransitionChange(), this.component.getDivChangeTransitionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transition_in", value.getTransitionIn(), this.component.getDivAppearanceTransitionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transition_out", value.getTransitionOut(), this.component.getDivAppearanceTransitionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "transition_triggers", value.getTransitionTriggers(), DivTransitionTrigger.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "type", "indicator");
            JsonPropertyParser.writeList(context, jSONObject, "variable_triggers", value.getVariableTriggers(), this.component.getDivTriggerJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "variables", value.getVariables(), this.component.getDivVariableJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "visibility", value.getVisibility(), DivVisibility.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "visibility_action", value.getVisibilityAction(), this.component.getDivVisibilityActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "visibility_actions", value.getVisibilityActions(), this.component.getDivVisibilityActionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "width", value.getWidth(), this.component.getDivSizeJsonEntityParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivIndicatorJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivIndicatorJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivIndicatorTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivIndicatorTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivIndicatorTemplate deserialize(ParsingContext context, DivIndicatorTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "accessibility", allowPropertyOverride, parent != null ? parent.accessibility : null, this.component.getDivAccessibilityJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex…bilityJsonTemplateParser)");
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "active_item_color", TypeHelpersKt.TYPE_HELPER_COLOR, allowPropertyOverride, parent != null ? parent.activeItemColor : null, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…lor, STRING_TO_COLOR_INT)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "active_item_size", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.activeItemSize : null, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivIndicatorJsonParser.ACTIVE_ITEM_SIZE_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…TIVE_ITEM_SIZE_VALIDATOR)");
            Field optionalField2 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "active_shape", allowPropertyOverride, parent != null ? parent.activeShape : null, this.component.getDivRoundedRectangleShapeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField2, "readOptionalField(contex…eShapeJsonTemplateParser)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alignment_horizontal", DivIndicatorJsonParser.TYPE_HELPER_ALIGNMENT_HORIZONTAL, allowPropertyOverride, parent != null ? parent.alignmentHorizontal : null, DivAlignmentHorizontal.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…ntHorizontal.FROM_STRING)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alignment_vertical", DivIndicatorJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, allowPropertyOverride, parent != null ? parent.alignmentVertical : null, DivAlignmentVertical.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…mentVertical.FROM_STRING)");
            Field optionalFieldWithExpression5 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.alpha : null, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivIndicatorJsonParser.ALPHA_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression5, "readOptionalFieldWithExp…_DOUBLE, ALPHA_VALIDATOR)");
            Field optionalFieldWithExpression6 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "animation", DivIndicatorJsonParser.TYPE_HELPER_ANIMATION, allowPropertyOverride, parent != null ? parent.animation : null, DivIndicator.Animation.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression6, "readOptionalFieldWithExp…or.Animation.FROM_STRING)");
            Field optionalListField = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "animators", allowPropertyOverride, parent != null ? parent.animators : null, this.component.getDivAnimatorJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField, "readOptionalListField(co…imatorJsonTemplateParser)");
            Field optionalListField2 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, J2.g, allowPropertyOverride, parent != null ? parent.background : null, this.component.getDivBackgroundJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField2, "readOptionalListField(co…groundJsonTemplateParser)");
            Field optionalField3 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, OutlinedTextFieldKt.BorderId, allowPropertyOverride, parent != null ? parent.border : null, this.component.getDivBorderJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField3, "readOptionalField(contex…BorderJsonTemplateParser)");
            Field optionalFieldWithExpression7 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "column_span", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.columnSpan : null, ParsingConvertersKt.NUMBER_TO_INT, DivIndicatorJsonParser.COLUMN_SPAN_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression7, "readOptionalFieldWithExp…T, COLUMN_SPAN_VALIDATOR)");
            Field optionalListField3 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "disappear_actions", allowPropertyOverride, parent != null ? parent.disappearActions : null, this.component.getDivDisappearActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField3, "readOptionalListField(co…ActionJsonTemplateParser)");
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
            Field optionalFieldWithExpression8 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "inactive_item_color", TypeHelpersKt.TYPE_HELPER_COLOR, allowPropertyOverride, parent != null ? parent.inactiveItemColor : null, ParsingConvertersKt.STRING_TO_COLOR_INT);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression8, "readOptionalFieldWithExp…lor, STRING_TO_COLOR_INT)");
            Field optionalField7 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "inactive_minimum_shape", allowPropertyOverride, parent != null ? parent.inactiveMinimumShape : null, this.component.getDivRoundedRectangleShapeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField7, "readOptionalField(contex…eShapeJsonTemplateParser)");
            Field optionalField8 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "inactive_shape", allowPropertyOverride, parent != null ? parent.inactiveShape : null, this.component.getDivRoundedRectangleShapeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField8, "readOptionalField(contex…eShapeJsonTemplateParser)");
            Field optionalField9 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "items_placement", allowPropertyOverride, parent != null ? parent.itemsPlacement : null, this.component.getDivIndicatorItemPlacementJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField9, "readOptionalField(contex…cementJsonTemplateParser)");
            Field optionalField10 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "layout_provider", allowPropertyOverride, parent != null ? parent.layoutProvider : null, this.component.getDivLayoutProviderJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField10, "readOptionalField(contex…oviderJsonTemplateParser)");
            Field optionalField11 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "margins", allowPropertyOverride, parent != null ? parent.margins : null, this.component.getDivEdgeInsetsJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField11, "readOptionalField(contex…InsetsJsonTemplateParser)");
            Field optionalFieldWithExpression9 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "minimum_item_size", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.minimumItemSize : null, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivIndicatorJsonParser.MINIMUM_ITEM_SIZE_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression9, "readOptionalFieldWithExp…IMUM_ITEM_SIZE_VALIDATOR)");
            Field optionalField12 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "paddings", allowPropertyOverride, parent != null ? parent.paddings : null, this.component.getDivEdgeInsetsJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField12, "readOptionalField(contex…InsetsJsonTemplateParser)");
            Field optionalField13 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "pager_id", allowPropertyOverride, parent != null ? parent.pagerId : null);
            Intrinsics.checkNotNullExpressionValue(optionalField13, "readOptionalField(contex…verride, parent?.pagerId)");
            Field<Expression<String>> optionalFieldWithExpression10 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "reuse_id", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.reuseId : null);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression10, "readOptionalFieldWithExp…verride, parent?.reuseId)");
            Field optionalFieldWithExpression11 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "row_span", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.rowSpan : null, ParsingConvertersKt.NUMBER_TO_INT, DivIndicatorJsonParser.ROW_SPAN_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression11, "readOptionalFieldWithExp…_INT, ROW_SPAN_VALIDATOR)");
            Field optionalListField6 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "selected_actions", allowPropertyOverride, parent != null ? parent.selectedActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField6, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalField14 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "shape", allowPropertyOverride, parent != null ? parent.shape : null, this.component.getDivShapeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField14, "readOptionalField(contex…vShapeJsonTemplateParser)");
            Field optionalField15 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "space_between_centers", allowPropertyOverride, parent != null ? parent.spaceBetweenCenters : null, this.component.getDivFixedSizeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField15, "readOptionalField(contex…edSizeJsonTemplateParser)");
            Field optionalListField7 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "tooltips", allowPropertyOverride, parent != null ? parent.tooltips : null, this.component.getDivTooltipJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField7, "readOptionalListField(co…ooltipJsonTemplateParser)");
            Field optionalField16 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transform", allowPropertyOverride, parent != null ? parent.transform : null, this.component.getDivTransformJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField16, "readOptionalField(contex…nsformJsonTemplateParser)");
            Field optionalField17 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transition_change", allowPropertyOverride, parent != null ? parent.transitionChange : null, this.component.getDivChangeTransitionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField17, "readOptionalField(contex…sitionJsonTemplateParser)");
            Field optionalField18 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transition_in", allowPropertyOverride, parent != null ? parent.transitionIn : null, this.component.getDivAppearanceTransitionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField18, "readOptionalField(contex…sitionJsonTemplateParser)");
            Field optionalField19 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transition_out", allowPropertyOverride, parent != null ? parent.transitionOut : null, this.component.getDivAppearanceTransitionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField19, "readOptionalField(contex…sitionJsonTemplateParser)");
            Field<List<DivTransitionTrigger>> field = parent != null ? parent.transitionTriggers : null;
            Function1<String, DivTransitionTrigger> function1 = DivTransitionTrigger.FROM_STRING;
            ListValidator<DivTransitionTrigger> listValidator = DivIndicatorJsonParser.TRANSITION_TRIGGERS_VALIDATOR;
            Intrinsics.checkNotNull(listValidator, "null cannot be cast to non-null type com.yandex.div.internal.parser.ListValidator<T of com.yandex.div.internal.parser.ParsingValidatorsKt.cast>");
            Field optionalListField8 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "transition_triggers", allowPropertyOverride, field, function1, listValidator);
            Intrinsics.checkNotNullExpressionValue(optionalListField8, "readOptionalListField(co…RIGGERS_VALIDATOR.cast())");
            Field optionalListField9 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "variable_triggers", allowPropertyOverride, parent != null ? parent.variableTriggers : null, this.component.getDivTriggerJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField9, "readOptionalListField(co…riggerJsonTemplateParser)");
            Field optionalListField10 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "variables", allowPropertyOverride, parent != null ? parent.variables : null, this.component.getDivVariableJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField10, "readOptionalListField(co…riableJsonTemplateParser)");
            Field optionalFieldWithExpression12 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "visibility", DivIndicatorJsonParser.TYPE_HELPER_VISIBILITY, allowPropertyOverride, parent != null ? parent.visibility : null, DivVisibility.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression12, "readOptionalFieldWithExp…ivVisibility.FROM_STRING)");
            Field optionalField20 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "visibility_action", allowPropertyOverride, parent != null ? parent.visibilityAction : null, this.component.getDivVisibilityActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField20, "readOptionalField(contex…ActionJsonTemplateParser)");
            Field optionalListField11 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "visibility_actions", allowPropertyOverride, parent != null ? parent.visibilityActions : null, this.component.getDivVisibilityActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField11, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalField21 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "width", allowPropertyOverride, parent != null ? parent.width : null, this.component.getDivSizeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField21, "readOptionalField(contex…ivSizeJsonTemplateParser)");
            return new DivIndicatorTemplate(optionalField, optionalFieldWithExpression, optionalFieldWithExpression2, optionalField2, optionalFieldWithExpression3, optionalFieldWithExpression4, optionalFieldWithExpression5, optionalFieldWithExpression6, optionalListField, optionalListField2, optionalField3, optionalFieldWithExpression7, optionalListField3, optionalListField4, optionalField4, optionalListField5, optionalField5, optionalField6, optionalFieldWithExpression8, optionalField7, optionalField8, optionalField9, optionalField10, optionalField11, optionalFieldWithExpression9, optionalField12, optionalField13, optionalFieldWithExpression10, optionalFieldWithExpression11, optionalListField6, optionalField14, optionalField15, optionalListField7, optionalField16, optionalField17, optionalField18, optionalField19, optionalListField8, optionalListField9, optionalListField10, optionalFieldWithExpression12, optionalField20, optionalListField11, optionalField21);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivIndicatorTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeField(context, jSONObject, "accessibility", value.accessibility, this.component.getDivAccessibilityJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "active_item_color", value.activeItemColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "active_item_size", value.activeItemSize);
            JsonFieldParser.writeField(context, jSONObject, "active_shape", value.activeShape, this.component.getDivRoundedRectangleShapeJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "alignment_horizontal", value.alignmentHorizontal, DivAlignmentHorizontal.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "alignment_vertical", value.alignmentVertical, DivAlignmentVertical.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "alpha", value.alpha);
            JsonFieldParser.writeExpressionField(context, jSONObject, "animation", value.animation, DivIndicator.Animation.TO_STRING);
            JsonFieldParser.writeListField(context, jSONObject, "animators", value.animators, this.component.getDivAnimatorJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, J2.g, value.background, this.component.getDivBackgroundJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, OutlinedTextFieldKt.BorderId, value.border, this.component.getDivBorderJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "column_span", value.columnSpan);
            JsonFieldParser.writeListField(context, jSONObject, "disappear_actions", value.disappearActions, this.component.getDivDisappearActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "extensions", value.extensions, this.component.getDivExtensionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "focus", value.focus, this.component.getDivFocusJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "functions", value.functions, this.component.getDivFunctionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "height", value.height, this.component.getDivSizeJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "id", value.id);
            JsonFieldParser.writeExpressionField(context, jSONObject, "inactive_item_color", value.inactiveItemColor, ParsingConvertersKt.COLOR_INT_TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "inactive_minimum_shape", value.inactiveMinimumShape, this.component.getDivRoundedRectangleShapeJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "inactive_shape", value.inactiveShape, this.component.getDivRoundedRectangleShapeJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "items_placement", value.itemsPlacement, this.component.getDivIndicatorItemPlacementJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "layout_provider", value.layoutProvider, this.component.getDivLayoutProviderJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "margins", value.margins, this.component.getDivEdgeInsetsJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "minimum_item_size", value.minimumItemSize);
            JsonFieldParser.writeField(context, jSONObject, "paddings", value.paddings, this.component.getDivEdgeInsetsJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "pager_id", value.pagerId);
            JsonFieldParser.writeExpressionField(context, jSONObject, "reuse_id", value.reuseId);
            JsonFieldParser.writeExpressionField(context, jSONObject, "row_span", value.rowSpan);
            JsonFieldParser.writeListField(context, jSONObject, "selected_actions", value.selectedActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "shape", value.shape, this.component.getDivShapeJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "space_between_centers", value.spaceBetweenCenters, this.component.getDivFixedSizeJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "tooltips", value.tooltips, this.component.getDivTooltipJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transform", value.transform, this.component.getDivTransformJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transition_change", value.transitionChange, this.component.getDivChangeTransitionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transition_in", value.transitionIn, this.component.getDivAppearanceTransitionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transition_out", value.transitionOut, this.component.getDivAppearanceTransitionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "transition_triggers", value.transitionTriggers, DivTransitionTrigger.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "type", "indicator");
            JsonFieldParser.writeListField(context, jSONObject, "variable_triggers", value.variableTriggers, this.component.getDivTriggerJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "variables", value.variables, this.component.getDivVariableJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "visibility", value.visibility, DivVisibility.TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "visibility_action", value.visibilityAction, this.component.getDivVisibilityActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "visibility_actions", value.visibilityActions, this.component.getDivVisibilityActionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "width", value.width, this.component.getDivSizeJsonTemplateParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivIndicatorJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivIndicatorJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivIndicatorTemplate;", "Lcom/yandex/div2/DivIndicator;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivIndicatorTemplate, DivIndicator> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivIndicator resolve(ParsingContext context, DivIndicatorTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            DivAccessibility divAccessibility = (DivAccessibility) JsonFieldResolver.resolveOptional(context, template.accessibility, data, "accessibility", this.component.getDivAccessibilityJsonTemplateResolver(), this.component.getDivAccessibilityJsonEntityParser());
            Expression<Integer> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.activeItemColor, data, "active_item_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT, DivIndicatorJsonParser.ACTIVE_ITEM_COLOR_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivIndicatorJsonParser.ACTIVE_ITEM_COLOR_DEFAULT_VALUE;
            }
            Expression<Integer> expression = expressionResolveOptionalExpression;
            Expression<Double> expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.activeItemSize, data, "active_item_size", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivIndicatorJsonParser.ACTIVE_ITEM_SIZE_VALIDATOR, DivIndicatorJsonParser.ACTIVE_ITEM_SIZE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression2 == null) {
                expressionResolveOptionalExpression2 = DivIndicatorJsonParser.ACTIVE_ITEM_SIZE_DEFAULT_VALUE;
            }
            Expression<Double> expression2 = expressionResolveOptionalExpression2;
            DivRoundedRectangleShape divRoundedRectangleShape = (DivRoundedRectangleShape) JsonFieldResolver.resolveOptional(context, template.activeShape, data, "active_shape", this.component.getDivRoundedRectangleShapeJsonTemplateResolver(), this.component.getDivRoundedRectangleShapeJsonEntityParser());
            Expression expressionResolveOptionalExpression3 = JsonFieldResolver.resolveOptionalExpression(context, template.alignmentHorizontal, data, "alignment_horizontal", DivIndicatorJsonParser.TYPE_HELPER_ALIGNMENT_HORIZONTAL, DivAlignmentHorizontal.FROM_STRING);
            Expression expressionResolveOptionalExpression4 = JsonFieldResolver.resolveOptionalExpression(context, template.alignmentVertical, data, "alignment_vertical", DivIndicatorJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, DivAlignmentVertical.FROM_STRING);
            Expression<Double> expressionResolveOptionalExpression5 = JsonFieldResolver.resolveOptionalExpression(context, template.alpha, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivIndicatorJsonParser.ALPHA_VALIDATOR, DivIndicatorJsonParser.ALPHA_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression5 == null) {
                expressionResolveOptionalExpression5 = DivIndicatorJsonParser.ALPHA_DEFAULT_VALUE;
            }
            Expression<Double> expression3 = expressionResolveOptionalExpression5;
            Expression<DivIndicator.Animation> expressionResolveOptionalExpression6 = JsonFieldResolver.resolveOptionalExpression(context, template.animation, data, "animation", DivIndicatorJsonParser.TYPE_HELPER_ANIMATION, DivIndicator.Animation.FROM_STRING, DivIndicatorJsonParser.ANIMATION_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression6 == null) {
                expressionResolveOptionalExpression6 = DivIndicatorJsonParser.ANIMATION_DEFAULT_VALUE;
            }
            Expression<DivIndicator.Animation> expression4 = expressionResolveOptionalExpression6;
            List listResolveOptionalList = JsonFieldResolver.resolveOptionalList(context, template.animators, data, "animators", this.component.getDivAnimatorJsonTemplateResolver(), this.component.getDivAnimatorJsonEntityParser());
            List listResolveOptionalList2 = JsonFieldResolver.resolveOptionalList(context, template.background, data, J2.g, this.component.getDivBackgroundJsonTemplateResolver(), this.component.getDivBackgroundJsonEntityParser());
            DivBorder divBorder = (DivBorder) JsonFieldResolver.resolveOptional(context, template.border, data, OutlinedTextFieldKt.BorderId, this.component.getDivBorderJsonTemplateResolver(), this.component.getDivBorderJsonEntityParser());
            Expression expressionResolveOptionalExpression7 = JsonFieldResolver.resolveOptionalExpression(context, template.columnSpan, data, "column_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivIndicatorJsonParser.COLUMN_SPAN_VALIDATOR);
            List listResolveOptionalList3 = JsonFieldResolver.resolveOptionalList(context, template.disappearActions, data, "disappear_actions", this.component.getDivDisappearActionJsonTemplateResolver(), this.component.getDivDisappearActionJsonEntityParser());
            List listResolveOptionalList4 = JsonFieldResolver.resolveOptionalList(context, template.extensions, data, "extensions", this.component.getDivExtensionJsonTemplateResolver(), this.component.getDivExtensionJsonEntityParser());
            DivFocus divFocus = (DivFocus) JsonFieldResolver.resolveOptional(context, template.focus, data, "focus", this.component.getDivFocusJsonTemplateResolver(), this.component.getDivFocusJsonEntityParser());
            List listResolveOptionalList5 = JsonFieldResolver.resolveOptionalList(context, template.functions, data, "functions", this.component.getDivFunctionJsonTemplateResolver(), this.component.getDivFunctionJsonEntityParser());
            DivSize.WrapContent wrapContent = (DivSize) JsonFieldResolver.resolveOptional(context, template.height, data, "height", this.component.getDivSizeJsonTemplateResolver(), this.component.getDivSizeJsonEntityParser());
            if (wrapContent == null) {
                wrapContent = DivIndicatorJsonParser.HEIGHT_DEFAULT_VALUE;
            }
            DivSize divSize = wrapContent;
            Intrinsics.checkNotNullExpressionValue(divSize, "JsonFieldResolver.resolv…) ?: HEIGHT_DEFAULT_VALUE");
            String str = (String) JsonFieldResolver.resolveOptional(context, template.id, data, "id");
            Expression<Integer> expressionResolveOptionalExpression8 = JsonFieldResolver.resolveOptionalExpression(context, template.inactiveItemColor, data, "inactive_item_color", TypeHelpersKt.TYPE_HELPER_COLOR, ParsingConvertersKt.STRING_TO_COLOR_INT, DivIndicatorJsonParser.INACTIVE_ITEM_COLOR_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression8 == null) {
                expressionResolveOptionalExpression8 = DivIndicatorJsonParser.INACTIVE_ITEM_COLOR_DEFAULT_VALUE;
            }
            Expression<Integer> expression5 = expressionResolveOptionalExpression8;
            DivRoundedRectangleShape divRoundedRectangleShape2 = (DivRoundedRectangleShape) JsonFieldResolver.resolveOptional(context, template.inactiveMinimumShape, data, "inactive_minimum_shape", this.component.getDivRoundedRectangleShapeJsonTemplateResolver(), this.component.getDivRoundedRectangleShapeJsonEntityParser());
            DivRoundedRectangleShape divRoundedRectangleShape3 = (DivRoundedRectangleShape) JsonFieldResolver.resolveOptional(context, template.inactiveShape, data, "inactive_shape", this.component.getDivRoundedRectangleShapeJsonTemplateResolver(), this.component.getDivRoundedRectangleShapeJsonEntityParser());
            DivIndicatorItemPlacement divIndicatorItemPlacement = (DivIndicatorItemPlacement) JsonFieldResolver.resolveOptional(context, template.itemsPlacement, data, "items_placement", this.component.getDivIndicatorItemPlacementJsonTemplateResolver(), this.component.getDivIndicatorItemPlacementJsonEntityParser());
            DivLayoutProvider divLayoutProvider = (DivLayoutProvider) JsonFieldResolver.resolveOptional(context, template.layoutProvider, data, "layout_provider", this.component.getDivLayoutProviderJsonTemplateResolver(), this.component.getDivLayoutProviderJsonEntityParser());
            DivEdgeInsets divEdgeInsets = (DivEdgeInsets) JsonFieldResolver.resolveOptional(context, template.margins, data, "margins", this.component.getDivEdgeInsetsJsonTemplateResolver(), this.component.getDivEdgeInsetsJsonEntityParser());
            Expression<Double> expressionResolveOptionalExpression9 = JsonFieldResolver.resolveOptionalExpression(context, template.minimumItemSize, data, "minimum_item_size", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivIndicatorJsonParser.MINIMUM_ITEM_SIZE_VALIDATOR, DivIndicatorJsonParser.MINIMUM_ITEM_SIZE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression9 == null) {
                expressionResolveOptionalExpression9 = DivIndicatorJsonParser.MINIMUM_ITEM_SIZE_DEFAULT_VALUE;
            }
            Expression<Double> expression6 = expressionResolveOptionalExpression9;
            DivEdgeInsets divEdgeInsets2 = (DivEdgeInsets) JsonFieldResolver.resolveOptional(context, template.paddings, data, "paddings", this.component.getDivEdgeInsetsJsonTemplateResolver(), this.component.getDivEdgeInsetsJsonEntityParser());
            String str2 = (String) JsonFieldResolver.resolveOptional(context, template.pagerId, data, "pager_id");
            Expression expressionResolveOptionalExpression10 = JsonFieldResolver.resolveOptionalExpression(context, template.reuseId, data, "reuse_id", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression expressionResolveOptionalExpression11 = JsonFieldResolver.resolveOptionalExpression(context, template.rowSpan, data, "row_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivIndicatorJsonParser.ROW_SPAN_VALIDATOR);
            List listResolveOptionalList6 = JsonFieldResolver.resolveOptionalList(context, template.selectedActions, data, "selected_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            DivShape.RoundedRectangle roundedRectangle = (DivShape) JsonFieldResolver.resolveOptional(context, template.shape, data, "shape", this.component.getDivShapeJsonTemplateResolver(), this.component.getDivShapeJsonEntityParser());
            if (roundedRectangle == null) {
                roundedRectangle = DivIndicatorJsonParser.SHAPE_DEFAULT_VALUE;
            }
            DivShape divShape = roundedRectangle;
            Intrinsics.checkNotNullExpressionValue(divShape, "JsonFieldResolver.resolv…r) ?: SHAPE_DEFAULT_VALUE");
            DivFixedSize divFixedSize = (DivFixedSize) JsonFieldResolver.resolveOptional(context, template.spaceBetweenCenters, data, "space_between_centers", this.component.getDivFixedSizeJsonTemplateResolver(), this.component.getDivFixedSizeJsonEntityParser());
            if (divFixedSize == null) {
                divFixedSize = DivIndicatorJsonParser.SPACE_BETWEEN_CENTERS_DEFAULT_VALUE;
            }
            DivFixedSize divFixedSize2 = divFixedSize;
            Intrinsics.checkNotNullExpressionValue(divFixedSize2, "JsonFieldResolver.resolv…EEN_CENTERS_DEFAULT_VALUE");
            List listResolveOptionalList7 = JsonFieldResolver.resolveOptionalList(context, template.tooltips, data, "tooltips", this.component.getDivTooltipJsonTemplateResolver(), this.component.getDivTooltipJsonEntityParser());
            DivTransform divTransform = (DivTransform) JsonFieldResolver.resolveOptional(context, template.transform, data, "transform", this.component.getDivTransformJsonTemplateResolver(), this.component.getDivTransformJsonEntityParser());
            DivChangeTransition divChangeTransition = (DivChangeTransition) JsonFieldResolver.resolveOptional(context, template.transitionChange, data, "transition_change", this.component.getDivChangeTransitionJsonTemplateResolver(), this.component.getDivChangeTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition = (DivAppearanceTransition) JsonFieldResolver.resolveOptional(context, template.transitionIn, data, "transition_in", this.component.getDivAppearanceTransitionJsonTemplateResolver(), this.component.getDivAppearanceTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition2 = (DivAppearanceTransition) JsonFieldResolver.resolveOptional(context, template.transitionOut, data, "transition_out", this.component.getDivAppearanceTransitionJsonTemplateResolver(), this.component.getDivAppearanceTransitionJsonEntityParser());
            List listResolveOptionalList8 = JsonFieldResolver.resolveOptionalList(context, template.transitionTriggers, data, "transition_triggers", DivTransitionTrigger.FROM_STRING, DivIndicatorJsonParser.TRANSITION_TRIGGERS_VALIDATOR);
            List listResolveOptionalList9 = JsonFieldResolver.resolveOptionalList(context, template.variableTriggers, data, "variable_triggers", this.component.getDivTriggerJsonTemplateResolver(), this.component.getDivTriggerJsonEntityParser());
            List listResolveOptionalList10 = JsonFieldResolver.resolveOptionalList(context, template.variables, data, "variables", this.component.getDivVariableJsonTemplateResolver(), this.component.getDivVariableJsonEntityParser());
            Expression<DivVisibility> expressionResolveOptionalExpression12 = JsonFieldResolver.resolveOptionalExpression(context, template.visibility, data, "visibility", DivIndicatorJsonParser.TYPE_HELPER_VISIBILITY, DivVisibility.FROM_STRING, DivIndicatorJsonParser.VISIBILITY_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression12 == null) {
                expressionResolveOptionalExpression12 = DivIndicatorJsonParser.VISIBILITY_DEFAULT_VALUE;
            }
            Expression<DivVisibility> expression7 = expressionResolveOptionalExpression12;
            DivVisibilityAction divVisibilityAction = (DivVisibilityAction) JsonFieldResolver.resolveOptional(context, template.visibilityAction, data, "visibility_action", this.component.getDivVisibilityActionJsonTemplateResolver(), this.component.getDivVisibilityActionJsonEntityParser());
            List listResolveOptionalList11 = JsonFieldResolver.resolveOptionalList(context, template.visibilityActions, data, "visibility_actions", this.component.getDivVisibilityActionJsonTemplateResolver(), this.component.getDivVisibilityActionJsonEntityParser());
            DivSize.MatchParent matchParent = (DivSize) JsonFieldResolver.resolveOptional(context, template.width, data, "width", this.component.getDivSizeJsonTemplateResolver(), this.component.getDivSizeJsonEntityParser());
            if (matchParent == null) {
                matchParent = DivIndicatorJsonParser.WIDTH_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(matchParent, "JsonFieldResolver.resolv…r) ?: WIDTH_DEFAULT_VALUE");
            return new DivIndicator(divAccessibility, expression, expression2, divRoundedRectangleShape, expressionResolveOptionalExpression3, expressionResolveOptionalExpression4, expression3, expression4, listResolveOptionalList, listResolveOptionalList2, divBorder, expressionResolveOptionalExpression7, listResolveOptionalList3, listResolveOptionalList4, divFocus, listResolveOptionalList5, divSize, str, expression5, divRoundedRectangleShape2, divRoundedRectangleShape3, divIndicatorItemPlacement, divLayoutProvider, divEdgeInsets, expression6, divEdgeInsets2, str2, expressionResolveOptionalExpression10, expressionResolveOptionalExpression11, listResolveOptionalList6, divShape, divFixedSize2, listResolveOptionalList7, divTransform, divChangeTransition, divAppearanceTransition, divAppearanceTransition2, listResolveOptionalList8, listResolveOptionalList9, listResolveOptionalList10, expression7, divVisibilityAction, listResolveOptionalList11, matchParent);
        }
    }

    /* JADX INFO: compiled from: DivIndicatorJsonParser.kt */
    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u00198\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\u001e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/yandex/div2/DivIndicatorJsonParser$Companion;", "", "()V", "ACTIVE_ITEM_COLOR_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "ACTIVE_ITEM_SIZE_DEFAULT_VALUE", "", "ACTIVE_ITEM_SIZE_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "ALPHA_DEFAULT_VALUE", "ALPHA_VALIDATOR", "ANIMATION_DEFAULT_VALUE", "Lcom/yandex/div2/DivIndicator$Animation;", "COLUMN_SPAN_VALIDATOR", "", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "INACTIVE_ITEM_COLOR_DEFAULT_VALUE", "MINIMUM_ITEM_SIZE_DEFAULT_VALUE", "MINIMUM_ITEM_SIZE_VALIDATOR", "ROW_SPAN_VALIDATOR", "SHAPE_DEFAULT_VALUE", "Lcom/yandex/div2/DivShape$RoundedRectangle;", "SPACE_BETWEEN_CENTERS_DEFAULT_VALUE", "Lcom/yandex/div2/DivFixedSize;", "TRANSITION_TRIGGERS_VALIDATOR", "Lcom/yandex/div/internal/parser/ListValidator;", "Lcom/yandex/div2/DivTransitionTrigger;", "TYPE_HELPER_ALIGNMENT_HORIZONTAL", "Lcom/yandex/div/internal/parser/TypeHelper;", "Lcom/yandex/div2/DivAlignmentHorizontal;", "TYPE_HELPER_ALIGNMENT_VERTICAL", "Lcom/yandex/div2/DivAlignmentVertical;", "TYPE_HELPER_ANIMATION", "TYPE_HELPER_VISIBILITY", "Lcom/yandex/div2/DivVisibility;", "VISIBILITY_DEFAULT_VALUE", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        byte b = 0 == true ? 1 : 0;
        SHAPE_DEFAULT_VALUE = new DivShape.RoundedRectangle(new DivRoundedRectangleShape(null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, b, 31, null));
        int i = 1;
        SPACE_BETWEEN_CENTERS_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(15L), i, 0 == true ? 1 : 0);
        VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);
        WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, i, 0 == true ? 1 : 0));
        TYPE_HELPER_ALIGNMENT_HORIZONTAL = TypeHelper.INSTANCE.from(ArraysKt.first(DivAlignmentHorizontal.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivIndicatorJsonParser$Companion$TYPE_HELPER_ALIGNMENT_HORIZONTAL$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivAlignmentHorizontal);
            }
        });
        TYPE_HELPER_ALIGNMENT_VERTICAL = TypeHelper.INSTANCE.from(ArraysKt.first(DivAlignmentVertical.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivIndicatorJsonParser$Companion$TYPE_HELPER_ALIGNMENT_VERTICAL$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivAlignmentVertical);
            }
        });
        TYPE_HELPER_ANIMATION = TypeHelper.INSTANCE.from(ArraysKt.first(DivIndicator.Animation.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivIndicatorJsonParser$Companion$TYPE_HELPER_ANIMATION$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivIndicator.Animation);
            }
        });
        TYPE_HELPER_VISIBILITY = TypeHelper.INSTANCE.from(ArraysKt.first(DivVisibility.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivIndicatorJsonParser$Companion$TYPE_HELPER_VISIBILITY$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof DivVisibility);
            }
        });
        ACTIVE_ITEM_SIZE_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivIndicatorJsonParser$$ExternalSyntheticLambda0
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivIndicatorJsonParser.ACTIVE_ITEM_SIZE_VALIDATOR$lambda$0(((Double) obj).doubleValue());
            }
        };
        ALPHA_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivIndicatorJsonParser$$ExternalSyntheticLambda1
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivIndicatorJsonParser.ALPHA_VALIDATOR$lambda$1(((Double) obj).doubleValue());
            }
        };
        COLUMN_SPAN_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivIndicatorJsonParser$$ExternalSyntheticLambda2
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivIndicatorJsonParser.COLUMN_SPAN_VALIDATOR$lambda$2(((Long) obj).longValue());
            }
        };
        MINIMUM_ITEM_SIZE_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivIndicatorJsonParser$$ExternalSyntheticLambda3
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivIndicatorJsonParser.MINIMUM_ITEM_SIZE_VALIDATOR$lambda$3(((Double) obj).doubleValue());
            }
        };
        ROW_SPAN_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivIndicatorJsonParser$$ExternalSyntheticLambda4
            @Override // com.yandex.div.internal.parser.ValueValidator
            public final boolean isValid(Object obj) {
                return DivIndicatorJsonParser.ROW_SPAN_VALIDATOR$lambda$4(((Long) obj).longValue());
            }
        };
        TRANSITION_TRIGGERS_VALIDATOR = new ListValidator() { // from class: com.yandex.div2.DivIndicatorJsonParser$$ExternalSyntheticLambda5
            @Override // com.yandex.div.internal.parser.ListValidator
            public final boolean isValid(List list) {
                return DivIndicatorJsonParser.TRANSITION_TRIGGERS_VALIDATOR$lambda$5(list);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TRANSITION_TRIGGERS_VALIDATOR$lambda$5(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.size() >= 1;
    }
}
