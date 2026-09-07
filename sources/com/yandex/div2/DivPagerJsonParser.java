package com.yandex.div2;

import androidx.compose.material.OutlinedTextFieldKt;
import com.google.firebase.analytics.FirebaseAnalytics;
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

/* JADX INFO: compiled from: DivPagerJsonParser.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivPagerJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivPagerJsonParser {

    @Deprecated
    public static final DivFixedSize ITEM_SPACING_DEFAULT_VALUE;

    @Deprecated
    public static final DivSize.MatchParent WIDTH_DEFAULT_VALUE;
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<Double> ALPHA_DEFAULT_VALUE = Expression.INSTANCE.constant(Double.valueOf(1.0d));

    @Deprecated
    public static final Expression<DivPager.ItemAlignment> CROSS_AXIS_ALIGNMENT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivPager.ItemAlignment.START);

    @Deprecated
    public static final Expression<Long> DEFAULT_ITEM_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);

    @Deprecated
    public static final DivSize.WrapContent HEIGHT_DEFAULT_VALUE = new DivSize.WrapContent(new DivWrapContentSize(null, null, null, 7, null));

    @Deprecated
    public static final Expression<Boolean> INFINITE_SCROLL_DEFAULT_VALUE = Expression.INSTANCE.constant(false);

    @Deprecated
    public static final Expression<DivPager.Orientation> ORIENTATION_DEFAULT_VALUE = Expression.INSTANCE.constant(DivPager.Orientation.HORIZONTAL);

    @Deprecated
    public static final Expression<Boolean> RESTRICT_PARENT_SCROLL_DEFAULT_VALUE = Expression.INSTANCE.constant(false);

    @Deprecated
    public static final Expression<DivPager.ItemAlignment> SCROLL_AXIS_ALIGNMENT_DEFAULT_VALUE = Expression.INSTANCE.constant(DivPager.ItemAlignment.CENTER);

    @Deprecated
    public static final Expression<DivVisibility> VISIBILITY_DEFAULT_VALUE = Expression.INSTANCE.constant(DivVisibility.VISIBLE);

    @Deprecated
    public static final TypeHelper<DivAlignmentHorizontal> TYPE_HELPER_ALIGNMENT_HORIZONTAL = TypeHelper.INSTANCE.from(ArraysKt.first(DivAlignmentHorizontal.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivPagerJsonParser$Companion$TYPE_HELPER_ALIGNMENT_HORIZONTAL$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivAlignmentHorizontal);
        }
    });

    @Deprecated
    public static final TypeHelper<DivAlignmentVertical> TYPE_HELPER_ALIGNMENT_VERTICAL = TypeHelper.INSTANCE.from(ArraysKt.first(DivAlignmentVertical.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivPagerJsonParser$Companion$TYPE_HELPER_ALIGNMENT_VERTICAL$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivAlignmentVertical);
        }
    });

    @Deprecated
    public static final TypeHelper<DivPager.ItemAlignment> TYPE_HELPER_CROSS_AXIS_ALIGNMENT = TypeHelper.INSTANCE.from(ArraysKt.first(DivPager.ItemAlignment.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivPagerJsonParser$Companion$TYPE_HELPER_CROSS_AXIS_ALIGNMENT$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivPager.ItemAlignment);
        }
    });

    @Deprecated
    public static final TypeHelper<DivPager.Orientation> TYPE_HELPER_ORIENTATION = TypeHelper.INSTANCE.from(ArraysKt.first(DivPager.Orientation.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivPagerJsonParser$Companion$TYPE_HELPER_ORIENTATION$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivPager.Orientation);
        }
    });

    @Deprecated
    public static final TypeHelper<DivPager.ItemAlignment> TYPE_HELPER_SCROLL_AXIS_ALIGNMENT = TypeHelper.INSTANCE.from(ArraysKt.first(DivPager.ItemAlignment.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivPagerJsonParser$Companion$TYPE_HELPER_SCROLL_AXIS_ALIGNMENT$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivPager.ItemAlignment);
        }
    });

    @Deprecated
    public static final TypeHelper<DivVisibility> TYPE_HELPER_VISIBILITY = TypeHelper.INSTANCE.from(ArraysKt.first(DivVisibility.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivPagerJsonParser$Companion$TYPE_HELPER_VISIBILITY$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivVisibility);
        }
    });

    @Deprecated
    public static final ValueValidator<Double> ALPHA_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivPagerJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivPagerJsonParser.ALPHA_VALIDATOR$lambda$0(((Double) obj).doubleValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> COLUMN_SPAN_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivPagerJsonParser$$ExternalSyntheticLambda1
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivPagerJsonParser.COLUMN_SPAN_VALIDATOR$lambda$1(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> DEFAULT_ITEM_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivPagerJsonParser$$ExternalSyntheticLambda2
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivPagerJsonParser.DEFAULT_ITEM_VALIDATOR$lambda$2(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> ROW_SPAN_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivPagerJsonParser$$ExternalSyntheticLambda3
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivPagerJsonParser.ROW_SPAN_VALIDATOR$lambda$3(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ListValidator<DivTransitionTrigger> TRANSITION_TRIGGERS_VALIDATOR = new ListValidator() { // from class: com.yandex.div2.DivPagerJsonParser$$ExternalSyntheticLambda4
        @Override // com.yandex.div.internal.parser.ListValidator
        public final boolean isValid(List list) {
            return DivPagerJsonParser.TRANSITION_TRIGGERS_VALIDATOR$lambda$4(list);
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
    public static final boolean DEFAULT_ITEM_VALIDATOR$lambda$2(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ROW_SPAN_VALIDATOR$lambda$3(long j) {
        return j >= 0;
    }

    public DivPagerJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivPagerJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivPagerJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivPager;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivPager> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivPager deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            DivAccessibility divAccessibility = (DivAccessibility) JsonPropertyParser.readOptional(context, data, "accessibility", this.component.getDivAccessibilityJsonEntityParser());
            Expression optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "alignment_horizontal", DivPagerJsonParser.TYPE_HELPER_ALIGNMENT_HORIZONTAL, DivAlignmentHorizontal.FROM_STRING);
            Expression optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, "alignment_vertical", DivPagerJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, DivAlignmentVertical.FROM_STRING);
            Expression<Double> optionalExpression3 = JsonExpressionParser.readOptionalExpression(context, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivPagerJsonParser.ALPHA_VALIDATOR, DivPagerJsonParser.ALPHA_DEFAULT_VALUE);
            if (optionalExpression3 == null) {
                optionalExpression3 = DivPagerJsonParser.ALPHA_DEFAULT_VALUE;
            }
            Expression<Double> expression = optionalExpression3;
            List optionalList = JsonPropertyParser.readOptionalList(context, data, "animators", this.component.getDivAnimatorJsonEntityParser());
            List optionalList2 = JsonPropertyParser.readOptionalList(context, data, J2.g, this.component.getDivBackgroundJsonEntityParser());
            DivBorder divBorder = (DivBorder) JsonPropertyParser.readOptional(context, data, OutlinedTextFieldKt.BorderId, this.component.getDivBorderJsonEntityParser());
            Expression optionalExpression4 = JsonExpressionParser.readOptionalExpression(context, data, "column_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivPagerJsonParser.COLUMN_SPAN_VALIDATOR);
            Expression<DivPager.ItemAlignment> optionalExpression5 = JsonExpressionParser.readOptionalExpression(context, data, "cross_axis_alignment", DivPagerJsonParser.TYPE_HELPER_CROSS_AXIS_ALIGNMENT, DivPager.ItemAlignment.FROM_STRING, DivPagerJsonParser.CROSS_AXIS_ALIGNMENT_DEFAULT_VALUE);
            if (optionalExpression5 == null) {
                optionalExpression5 = DivPagerJsonParser.CROSS_AXIS_ALIGNMENT_DEFAULT_VALUE;
            }
            Expression<DivPager.ItemAlignment> expression2 = optionalExpression5;
            Expression<Long> optionalExpression6 = JsonExpressionParser.readOptionalExpression(context, data, "default_item", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivPagerJsonParser.DEFAULT_ITEM_VALIDATOR, DivPagerJsonParser.DEFAULT_ITEM_DEFAULT_VALUE);
            if (optionalExpression6 == null) {
                optionalExpression6 = DivPagerJsonParser.DEFAULT_ITEM_DEFAULT_VALUE;
            }
            Expression<Long> expression3 = optionalExpression6;
            List optionalList3 = JsonPropertyParser.readOptionalList(context, data, "disappear_actions", this.component.getDivDisappearActionJsonEntityParser());
            List optionalList4 = JsonPropertyParser.readOptionalList(context, data, "extensions", this.component.getDivExtensionJsonEntityParser());
            DivFocus divFocus = (DivFocus) JsonPropertyParser.readOptional(context, data, "focus", this.component.getDivFocusJsonEntityParser());
            List optionalList5 = JsonPropertyParser.readOptionalList(context, data, "functions", this.component.getDivFunctionJsonEntityParser());
            DivSize.WrapContent wrapContent = (DivSize) JsonPropertyParser.readOptional(context, data, "height", this.component.getDivSizeJsonEntityParser());
            if (wrapContent == null) {
                wrapContent = DivPagerJsonParser.HEIGHT_DEFAULT_VALUE;
            }
            DivSize divSize = wrapContent;
            Intrinsics.checkNotNullExpressionValue(divSize, "JsonPropertyParser.readO…) ?: HEIGHT_DEFAULT_VALUE");
            String str = (String) JsonPropertyParser.readOptional(context, data, "id");
            Expression<Boolean> optionalExpression7 = JsonExpressionParser.readOptionalExpression(context, data, "infinite_scroll", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivPagerJsonParser.INFINITE_SCROLL_DEFAULT_VALUE);
            if (optionalExpression7 == null) {
                optionalExpression7 = DivPagerJsonParser.INFINITE_SCROLL_DEFAULT_VALUE;
            }
            Expression<Boolean> expression4 = optionalExpression7;
            DivCollectionItemBuilder divCollectionItemBuilder = (DivCollectionItemBuilder) JsonPropertyParser.readOptional(context, data, "item_builder", this.component.getDivCollectionItemBuilderJsonEntityParser());
            DivFixedSize divFixedSize = (DivFixedSize) JsonPropertyParser.readOptional(context, data, "item_spacing", this.component.getDivFixedSizeJsonEntityParser());
            if (divFixedSize == null) {
                divFixedSize = DivPagerJsonParser.ITEM_SPACING_DEFAULT_VALUE;
            }
            DivFixedSize divFixedSize2 = divFixedSize;
            Intrinsics.checkNotNullExpressionValue(divFixedSize2, "JsonPropertyParser.readO…TEM_SPACING_DEFAULT_VALUE");
            List optionalList6 = JsonPropertyParser.readOptionalList(context, data, FirebaseAnalytics.Param.ITEMS, this.component.getDivJsonEntityParser());
            Object obj = JsonPropertyParser.read(context, data, "layout_mode", this.component.getDivPagerLayoutModeJsonEntityParser());
            Intrinsics.checkNotNullExpressionValue(obj, "read(context, data, \"lay…youtModeJsonEntityParser)");
            DivPagerLayoutMode divPagerLayoutMode = (DivPagerLayoutMode) obj;
            DivLayoutProvider divLayoutProvider = (DivLayoutProvider) JsonPropertyParser.readOptional(context, data, "layout_provider", this.component.getDivLayoutProviderJsonEntityParser());
            DivEdgeInsets divEdgeInsets = (DivEdgeInsets) JsonPropertyParser.readOptional(context, data, "margins", this.component.getDivEdgeInsetsJsonEntityParser());
            Expression<DivPager.Orientation> optionalExpression8 = JsonExpressionParser.readOptionalExpression(context, data, "orientation", DivPagerJsonParser.TYPE_HELPER_ORIENTATION, DivPager.Orientation.FROM_STRING, DivPagerJsonParser.ORIENTATION_DEFAULT_VALUE);
            if (optionalExpression8 == null) {
                optionalExpression8 = DivPagerJsonParser.ORIENTATION_DEFAULT_VALUE;
            }
            Expression<DivPager.Orientation> expression5 = optionalExpression8;
            DivEdgeInsets divEdgeInsets2 = (DivEdgeInsets) JsonPropertyParser.readOptional(context, data, "paddings", this.component.getDivEdgeInsetsJsonEntityParser());
            DivPageTransformation divPageTransformation = (DivPageTransformation) JsonPropertyParser.readOptional(context, data, "page_transformation", this.component.getDivPageTransformationJsonEntityParser());
            Expression<Boolean> optionalExpression9 = JsonExpressionParser.readOptionalExpression(context, data, "restrict_parent_scroll", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivPagerJsonParser.RESTRICT_PARENT_SCROLL_DEFAULT_VALUE);
            if (optionalExpression9 == null) {
                optionalExpression9 = DivPagerJsonParser.RESTRICT_PARENT_SCROLL_DEFAULT_VALUE;
            }
            Expression<Boolean> expression6 = optionalExpression9;
            Expression<String> optionalExpression10 = JsonExpressionParser.readOptionalExpression(context, data, "reuse_id", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression optionalExpression11 = JsonExpressionParser.readOptionalExpression(context, data, "row_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivPagerJsonParser.ROW_SPAN_VALIDATOR);
            Expression<DivPager.ItemAlignment> optionalExpression12 = JsonExpressionParser.readOptionalExpression(context, data, "scroll_axis_alignment", DivPagerJsonParser.TYPE_HELPER_SCROLL_AXIS_ALIGNMENT, DivPager.ItemAlignment.FROM_STRING, DivPagerJsonParser.SCROLL_AXIS_ALIGNMENT_DEFAULT_VALUE);
            if (optionalExpression12 == null) {
                optionalExpression12 = DivPagerJsonParser.SCROLL_AXIS_ALIGNMENT_DEFAULT_VALUE;
            }
            Expression<DivPager.ItemAlignment> expression7 = optionalExpression12;
            List optionalList7 = JsonPropertyParser.readOptionalList(context, data, "selected_actions", this.component.getDivActionJsonEntityParser());
            List optionalList8 = JsonPropertyParser.readOptionalList(context, data, "tooltips", this.component.getDivTooltipJsonEntityParser());
            DivTransform divTransform = (DivTransform) JsonPropertyParser.readOptional(context, data, "transform", this.component.getDivTransformJsonEntityParser());
            DivChangeTransition divChangeTransition = (DivChangeTransition) JsonPropertyParser.readOptional(context, data, "transition_change", this.component.getDivChangeTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition = (DivAppearanceTransition) JsonPropertyParser.readOptional(context, data, "transition_in", this.component.getDivAppearanceTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition2 = (DivAppearanceTransition) JsonPropertyParser.readOptional(context, data, "transition_out", this.component.getDivAppearanceTransitionJsonEntityParser());
            List optionalList9 = JsonPropertyParser.readOptionalList(context, data, "transition_triggers", DivTransitionTrigger.FROM_STRING, DivPagerJsonParser.TRANSITION_TRIGGERS_VALIDATOR);
            List optionalList10 = JsonPropertyParser.readOptionalList(context, data, "variable_triggers", this.component.getDivTriggerJsonEntityParser());
            List optionalList11 = JsonPropertyParser.readOptionalList(context, data, "variables", this.component.getDivVariableJsonEntityParser());
            Expression<DivVisibility> optionalExpression13 = JsonExpressionParser.readOptionalExpression(context, data, "visibility", DivPagerJsonParser.TYPE_HELPER_VISIBILITY, DivVisibility.FROM_STRING, DivPagerJsonParser.VISIBILITY_DEFAULT_VALUE);
            if (optionalExpression13 == null) {
                optionalExpression13 = DivPagerJsonParser.VISIBILITY_DEFAULT_VALUE;
            }
            DivVisibilityAction divVisibilityAction = (DivVisibilityAction) JsonPropertyParser.readOptional(context, data, "visibility_action", this.component.getDivVisibilityActionJsonEntityParser());
            List optionalList12 = JsonPropertyParser.readOptionalList(context, data, "visibility_actions", this.component.getDivVisibilityActionJsonEntityParser());
            DivSize.MatchParent matchParent = (DivSize) JsonPropertyParser.readOptional(context, data, "width", this.component.getDivSizeJsonEntityParser());
            if (matchParent == null) {
                matchParent = DivPagerJsonParser.WIDTH_DEFAULT_VALUE;
            }
            DivSize divSize2 = matchParent;
            Intrinsics.checkNotNullExpressionValue(divSize2, "JsonPropertyParser.readO…r) ?: WIDTH_DEFAULT_VALUE");
            return new DivPager(divAccessibility, optionalExpression, optionalExpression2, expression, optionalList, optionalList2, divBorder, optionalExpression4, expression2, expression3, optionalList3, optionalList4, divFocus, optionalList5, divSize, str, expression4, divCollectionItemBuilder, divFixedSize2, optionalList6, divPagerLayoutMode, divLayoutProvider, divEdgeInsets, expression5, divEdgeInsets2, divPageTransformation, expression6, optionalExpression10, optionalExpression11, expression7, optionalList7, optionalList8, divTransform, divChangeTransition, divAppearanceTransition, divAppearanceTransition2, optionalList9, optionalList10, optionalList11, optionalExpression13, divVisibilityAction, optionalList12, divSize2);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivPager value) throws ParsingException {
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
            JsonExpressionParser.writeExpression(context, jSONObject, "column_span", value.getColumnSpan());
            JsonExpressionParser.writeExpression(context, jSONObject, "cross_axis_alignment", value.crossAxisAlignment, DivPager.ItemAlignment.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "default_item", value.defaultItem);
            JsonPropertyParser.writeList(context, jSONObject, "disappear_actions", value.getDisappearActions(), this.component.getDivDisappearActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "extensions", value.getExtensions(), this.component.getDivExtensionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "focus", value.getFocus(), this.component.getDivFocusJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "functions", value.getFunctions(), this.component.getDivFunctionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "height", value.getHeight(), this.component.getDivSizeJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "id", value.getId());
            JsonExpressionParser.writeExpression(context, jSONObject, "infinite_scroll", value.infiniteScroll);
            JsonPropertyParser.write(context, jSONObject, "item_builder", value.itemBuilder, this.component.getDivCollectionItemBuilderJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "item_spacing", value.itemSpacing, this.component.getDivFixedSizeJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, FirebaseAnalytics.Param.ITEMS, value.items, this.component.getDivJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "layout_mode", value.layoutMode, this.component.getDivPagerLayoutModeJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "layout_provider", value.getLayoutProvider(), this.component.getDivLayoutProviderJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "margins", value.getMargins(), this.component.getDivEdgeInsetsJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "orientation", value.orientation, DivPager.Orientation.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "paddings", value.getPaddings(), this.component.getDivEdgeInsetsJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "page_transformation", value.pageTransformation, this.component.getDivPageTransformationJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "restrict_parent_scroll", value.restrictParentScroll);
            JsonExpressionParser.writeExpression(context, jSONObject, "reuse_id", value.getReuseId());
            JsonExpressionParser.writeExpression(context, jSONObject, "row_span", value.getRowSpan());
            JsonExpressionParser.writeExpression(context, jSONObject, "scroll_axis_alignment", value.scrollAxisAlignment, DivPager.ItemAlignment.TO_STRING);
            JsonPropertyParser.writeList(context, jSONObject, "selected_actions", value.getSelectedActions(), this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "tooltips", value.getTooltips(), this.component.getDivTooltipJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transform", value.getTransform(), this.component.getDivTransformJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transition_change", value.getTransitionChange(), this.component.getDivChangeTransitionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transition_in", value.getTransitionIn(), this.component.getDivAppearanceTransitionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "transition_out", value.getTransitionOut(), this.component.getDivAppearanceTransitionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "transition_triggers", value.getTransitionTriggers(), DivTransitionTrigger.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "type", "pager");
            JsonPropertyParser.writeList(context, jSONObject, "variable_triggers", value.getVariableTriggers(), this.component.getDivTriggerJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "variables", value.getVariables(), this.component.getDivVariableJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "visibility", value.getVisibility(), DivVisibility.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "visibility_action", value.getVisibilityAction(), this.component.getDivVisibilityActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "visibility_actions", value.getVisibilityActions(), this.component.getDivVisibilityActionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "width", value.getWidth(), this.component.getDivSizeJsonEntityParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivPagerJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivPagerJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivPagerTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivPagerTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivPagerTemplate deserialize(ParsingContext context, DivPagerTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "accessibility", allowPropertyOverride, parent != null ? parent.accessibility : null, this.component.getDivAccessibilityJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex…bilityJsonTemplateParser)");
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alignment_horizontal", DivPagerJsonParser.TYPE_HELPER_ALIGNMENT_HORIZONTAL, allowPropertyOverride, parent != null ? parent.alignmentHorizontal : null, DivAlignmentHorizontal.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…ntHorizontal.FROM_STRING)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alignment_vertical", DivPagerJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, allowPropertyOverride, parent != null ? parent.alignmentVertical : null, DivAlignmentVertical.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…mentVertical.FROM_STRING)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, allowPropertyOverride, parent != null ? parent.alpha : null, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivPagerJsonParser.ALPHA_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…_DOUBLE, ALPHA_VALIDATOR)");
            Field optionalListField = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "animators", allowPropertyOverride, parent != null ? parent.animators : null, this.component.getDivAnimatorJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField, "readOptionalListField(co…imatorJsonTemplateParser)");
            Field optionalListField2 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, J2.g, allowPropertyOverride, parent != null ? parent.background : null, this.component.getDivBackgroundJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField2, "readOptionalListField(co…groundJsonTemplateParser)");
            Field optionalField2 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, OutlinedTextFieldKt.BorderId, allowPropertyOverride, parent != null ? parent.border : null, this.component.getDivBorderJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField2, "readOptionalField(contex…BorderJsonTemplateParser)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "column_span", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.columnSpan : null, ParsingConvertersKt.NUMBER_TO_INT, DivPagerJsonParser.COLUMN_SPAN_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…T, COLUMN_SPAN_VALIDATOR)");
            Field optionalFieldWithExpression5 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "cross_axis_alignment", DivPagerJsonParser.TYPE_HELPER_CROSS_AXIS_ALIGNMENT, allowPropertyOverride, parent != null ? parent.crossAxisAlignment : null, DivPager.ItemAlignment.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression5, "readOptionalFieldWithExp…temAlignment.FROM_STRING)");
            Field optionalFieldWithExpression6 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "default_item", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.defaultItem : null, ParsingConvertersKt.NUMBER_TO_INT, DivPagerJsonParser.DEFAULT_ITEM_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression6, "readOptionalFieldWithExp…, DEFAULT_ITEM_VALIDATOR)");
            Field optionalListField3 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "disappear_actions", allowPropertyOverride, parent != null ? parent.disappearActions : null, this.component.getDivDisappearActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField3, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalListField4 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "extensions", allowPropertyOverride, parent != null ? parent.extensions : null, this.component.getDivExtensionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField4, "readOptionalListField(co…ensionJsonTemplateParser)");
            Field optionalField3 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "focus", allowPropertyOverride, parent != null ? parent.focus : null, this.component.getDivFocusJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField3, "readOptionalField(contex…vFocusJsonTemplateParser)");
            Field optionalListField5 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "functions", allowPropertyOverride, parent != null ? parent.functions : null, this.component.getDivFunctionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField5, "readOptionalListField(co…nctionJsonTemplateParser)");
            Field optionalField4 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "height", allowPropertyOverride, parent != null ? parent.height : null, this.component.getDivSizeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField4, "readOptionalField(contex…ivSizeJsonTemplateParser)");
            Field optionalField5 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "id", allowPropertyOverride, parent != null ? parent.id : null);
            Intrinsics.checkNotNullExpressionValue(optionalField5, "readOptionalField(contex…llowOverride, parent?.id)");
            Field optionalFieldWithExpression7 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "infinite_scroll", TypeHelpersKt.TYPE_HELPER_BOOLEAN, allowPropertyOverride, parent != null ? parent.infiniteScroll : null, ParsingConvertersKt.ANY_TO_BOOLEAN);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression7, "readOptionalFieldWithExp…teScroll, ANY_TO_BOOLEAN)");
            Field optionalField6 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "item_builder", allowPropertyOverride, parent != null ? parent.itemBuilder : null, this.component.getDivCollectionItemBuilderJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField6, "readOptionalField(contex…uilderJsonTemplateParser)");
            Field optionalField7 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "item_spacing", allowPropertyOverride, parent != null ? parent.itemSpacing : null, this.component.getDivFixedSizeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField7, "readOptionalField(contex…edSizeJsonTemplateParser)");
            Field optionalListField6 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, FirebaseAnalytics.Param.ITEMS, allowPropertyOverride, parent != null ? parent.items : null, this.component.getDivJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField6, "readOptionalListField(co…nt.divJsonTemplateParser)");
            Field field = JsonFieldParser.readField(parsingContextRestrictPropertyOverride, data, "layout_mode", allowPropertyOverride, parent != null ? parent.layoutMode : null, this.component.getDivPagerLayoutModeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(field, "readField(context, data,…utModeJsonTemplateParser)");
            Field optionalField8 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "layout_provider", allowPropertyOverride, parent != null ? parent.layoutProvider : null, this.component.getDivLayoutProviderJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField8, "readOptionalField(contex…oviderJsonTemplateParser)");
            Field optionalField9 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "margins", allowPropertyOverride, parent != null ? parent.margins : null, this.component.getDivEdgeInsetsJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField9, "readOptionalField(contex…InsetsJsonTemplateParser)");
            Field optionalFieldWithExpression8 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "orientation", DivPagerJsonParser.TYPE_HELPER_ORIENTATION, allowPropertyOverride, parent != null ? parent.orientation : null, DivPager.Orientation.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression8, "readOptionalFieldWithExp….Orientation.FROM_STRING)");
            Field optionalField10 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "paddings", allowPropertyOverride, parent != null ? parent.paddings : null, this.component.getDivEdgeInsetsJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField10, "readOptionalField(contex…InsetsJsonTemplateParser)");
            Field optionalField11 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "page_transformation", allowPropertyOverride, parent != null ? parent.pageTransformation : null, this.component.getDivPageTransformationJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField11, "readOptionalField(contex…mationJsonTemplateParser)");
            Field optionalFieldWithExpression9 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "restrict_parent_scroll", TypeHelpersKt.TYPE_HELPER_BOOLEAN, allowPropertyOverride, parent != null ? parent.restrictParentScroll : null, ParsingConvertersKt.ANY_TO_BOOLEAN);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression9, "readOptionalFieldWithExp…ntScroll, ANY_TO_BOOLEAN)");
            Field<Expression<String>> optionalFieldWithExpression10 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "reuse_id", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.reuseId : null);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression10, "readOptionalFieldWithExp…verride, parent?.reuseId)");
            Field optionalFieldWithExpression11 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "row_span", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.rowSpan : null, ParsingConvertersKt.NUMBER_TO_INT, DivPagerJsonParser.ROW_SPAN_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression11, "readOptionalFieldWithExp…_INT, ROW_SPAN_VALIDATOR)");
            Field optionalFieldWithExpression12 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "scroll_axis_alignment", DivPagerJsonParser.TYPE_HELPER_SCROLL_AXIS_ALIGNMENT, allowPropertyOverride, parent != null ? parent.scrollAxisAlignment : null, DivPager.ItemAlignment.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression12, "readOptionalFieldWithExp…temAlignment.FROM_STRING)");
            Field optionalListField7 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "selected_actions", allowPropertyOverride, parent != null ? parent.selectedActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField7, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalListField8 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "tooltips", allowPropertyOverride, parent != null ? parent.tooltips : null, this.component.getDivTooltipJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField8, "readOptionalListField(co…ooltipJsonTemplateParser)");
            Field optionalField12 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transform", allowPropertyOverride, parent != null ? parent.transform : null, this.component.getDivTransformJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField12, "readOptionalField(contex…nsformJsonTemplateParser)");
            Field optionalField13 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transition_change", allowPropertyOverride, parent != null ? parent.transitionChange : null, this.component.getDivChangeTransitionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField13, "readOptionalField(contex…sitionJsonTemplateParser)");
            Field optionalField14 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transition_in", allowPropertyOverride, parent != null ? parent.transitionIn : null, this.component.getDivAppearanceTransitionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField14, "readOptionalField(contex…sitionJsonTemplateParser)");
            Field optionalField15 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "transition_out", allowPropertyOverride, parent != null ? parent.transitionOut : null, this.component.getDivAppearanceTransitionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField15, "readOptionalField(contex…sitionJsonTemplateParser)");
            Field<List<DivTransitionTrigger>> field2 = parent != null ? parent.transitionTriggers : null;
            Function1<String, DivTransitionTrigger> function1 = DivTransitionTrigger.FROM_STRING;
            ListValidator<DivTransitionTrigger> listValidator = DivPagerJsonParser.TRANSITION_TRIGGERS_VALIDATOR;
            Intrinsics.checkNotNull(listValidator, "null cannot be cast to non-null type com.yandex.div.internal.parser.ListValidator<T of com.yandex.div.internal.parser.ParsingValidatorsKt.cast>");
            Field optionalListField9 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "transition_triggers", allowPropertyOverride, field2, function1, listValidator);
            Intrinsics.checkNotNullExpressionValue(optionalListField9, "readOptionalListField(co…RIGGERS_VALIDATOR.cast())");
            Field optionalListField10 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "variable_triggers", allowPropertyOverride, parent != null ? parent.variableTriggers : null, this.component.getDivTriggerJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField10, "readOptionalListField(co…riggerJsonTemplateParser)");
            Field optionalListField11 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "variables", allowPropertyOverride, parent != null ? parent.variables : null, this.component.getDivVariableJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField11, "readOptionalListField(co…riableJsonTemplateParser)");
            Field optionalFieldWithExpression13 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "visibility", DivPagerJsonParser.TYPE_HELPER_VISIBILITY, allowPropertyOverride, parent != null ? parent.visibility : null, DivVisibility.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression13, "readOptionalFieldWithExp…ivVisibility.FROM_STRING)");
            Field optionalField16 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "visibility_action", allowPropertyOverride, parent != null ? parent.visibilityAction : null, this.component.getDivVisibilityActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField16, "readOptionalField(contex…ActionJsonTemplateParser)");
            Field optionalListField12 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "visibility_actions", allowPropertyOverride, parent != null ? parent.visibilityActions : null, this.component.getDivVisibilityActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField12, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalField17 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "width", allowPropertyOverride, parent != null ? parent.width : null, this.component.getDivSizeJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField17, "readOptionalField(contex…ivSizeJsonTemplateParser)");
            return new DivPagerTemplate(optionalField, optionalFieldWithExpression, optionalFieldWithExpression2, optionalFieldWithExpression3, optionalListField, optionalListField2, optionalField2, optionalFieldWithExpression4, optionalFieldWithExpression5, optionalFieldWithExpression6, optionalListField3, optionalListField4, optionalField3, optionalListField5, optionalField4, optionalField5, optionalFieldWithExpression7, optionalField6, optionalField7, optionalListField6, field, optionalField8, optionalField9, optionalFieldWithExpression8, optionalField10, optionalField11, optionalFieldWithExpression9, optionalFieldWithExpression10, optionalFieldWithExpression11, optionalFieldWithExpression12, optionalListField7, optionalListField8, optionalField12, optionalField13, optionalField14, optionalField15, optionalListField9, optionalListField10, optionalListField11, optionalFieldWithExpression13, optionalField16, optionalListField12, optionalField17);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivPagerTemplate value) throws ParsingException {
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
            JsonFieldParser.writeExpressionField(context, jSONObject, "column_span", value.columnSpan);
            JsonFieldParser.writeExpressionField(context, jSONObject, "cross_axis_alignment", value.crossAxisAlignment, DivPager.ItemAlignment.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "default_item", value.defaultItem);
            JsonFieldParser.writeListField(context, jSONObject, "disappear_actions", value.disappearActions, this.component.getDivDisappearActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "extensions", value.extensions, this.component.getDivExtensionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "focus", value.focus, this.component.getDivFocusJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "functions", value.functions, this.component.getDivFunctionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "height", value.height, this.component.getDivSizeJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "id", value.id);
            JsonFieldParser.writeExpressionField(context, jSONObject, "infinite_scroll", value.infiniteScroll);
            JsonFieldParser.writeField(context, jSONObject, "item_builder", value.itemBuilder, this.component.getDivCollectionItemBuilderJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "item_spacing", value.itemSpacing, this.component.getDivFixedSizeJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, FirebaseAnalytics.Param.ITEMS, value.items, this.component.getDivJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "layout_mode", value.layoutMode, this.component.getDivPagerLayoutModeJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "layout_provider", value.layoutProvider, this.component.getDivLayoutProviderJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "margins", value.margins, this.component.getDivEdgeInsetsJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "orientation", value.orientation, DivPager.Orientation.TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "paddings", value.paddings, this.component.getDivEdgeInsetsJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "page_transformation", value.pageTransformation, this.component.getDivPageTransformationJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "restrict_parent_scroll", value.restrictParentScroll);
            JsonFieldParser.writeExpressionField(context, jSONObject, "reuse_id", value.reuseId);
            JsonFieldParser.writeExpressionField(context, jSONObject, "row_span", value.rowSpan);
            JsonFieldParser.writeExpressionField(context, jSONObject, "scroll_axis_alignment", value.scrollAxisAlignment, DivPager.ItemAlignment.TO_STRING);
            JsonFieldParser.writeListField(context, jSONObject, "selected_actions", value.selectedActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "tooltips", value.tooltips, this.component.getDivTooltipJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transform", value.transform, this.component.getDivTransformJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transition_change", value.transitionChange, this.component.getDivChangeTransitionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transition_in", value.transitionIn, this.component.getDivAppearanceTransitionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "transition_out", value.transitionOut, this.component.getDivAppearanceTransitionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "transition_triggers", value.transitionTriggers, DivTransitionTrigger.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "type", "pager");
            JsonFieldParser.writeListField(context, jSONObject, "variable_triggers", value.variableTriggers, this.component.getDivTriggerJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "variables", value.variables, this.component.getDivVariableJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "visibility", value.visibility, DivVisibility.TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "visibility_action", value.visibilityAction, this.component.getDivVisibilityActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "visibility_actions", value.visibilityActions, this.component.getDivVisibilityActionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "width", value.width, this.component.getDivSizeJsonTemplateParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivPagerJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivPagerJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivPagerTemplate;", "Lcom/yandex/div2/DivPager;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivPagerTemplate, DivPager> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivPager resolve(ParsingContext context, DivPagerTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            DivAccessibility divAccessibility = (DivAccessibility) JsonFieldResolver.resolveOptional(context, template.accessibility, data, "accessibility", this.component.getDivAccessibilityJsonTemplateResolver(), this.component.getDivAccessibilityJsonEntityParser());
            Expression expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.alignmentHorizontal, data, "alignment_horizontal", DivPagerJsonParser.TYPE_HELPER_ALIGNMENT_HORIZONTAL, DivAlignmentHorizontal.FROM_STRING);
            Expression expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.alignmentVertical, data, "alignment_vertical", DivPagerJsonParser.TYPE_HELPER_ALIGNMENT_VERTICAL, DivAlignmentVertical.FROM_STRING);
            Expression<Double> expressionResolveOptionalExpression3 = JsonFieldResolver.resolveOptionalExpression(context, template.alpha, data, "alpha", TypeHelpersKt.TYPE_HELPER_DOUBLE, ParsingConvertersKt.NUMBER_TO_DOUBLE, DivPagerJsonParser.ALPHA_VALIDATOR, DivPagerJsonParser.ALPHA_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression3 == null) {
                expressionResolveOptionalExpression3 = DivPagerJsonParser.ALPHA_DEFAULT_VALUE;
            }
            Expression<Double> expression = expressionResolveOptionalExpression3;
            List listResolveOptionalList = JsonFieldResolver.resolveOptionalList(context, template.animators, data, "animators", this.component.getDivAnimatorJsonTemplateResolver(), this.component.getDivAnimatorJsonEntityParser());
            List listResolveOptionalList2 = JsonFieldResolver.resolveOptionalList(context, template.background, data, J2.g, this.component.getDivBackgroundJsonTemplateResolver(), this.component.getDivBackgroundJsonEntityParser());
            DivBorder divBorder = (DivBorder) JsonFieldResolver.resolveOptional(context, template.border, data, OutlinedTextFieldKt.BorderId, this.component.getDivBorderJsonTemplateResolver(), this.component.getDivBorderJsonEntityParser());
            Expression expressionResolveOptionalExpression4 = JsonFieldResolver.resolveOptionalExpression(context, template.columnSpan, data, "column_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivPagerJsonParser.COLUMN_SPAN_VALIDATOR);
            Expression<DivPager.ItemAlignment> expressionResolveOptionalExpression5 = JsonFieldResolver.resolveOptionalExpression(context, template.crossAxisAlignment, data, "cross_axis_alignment", DivPagerJsonParser.TYPE_HELPER_CROSS_AXIS_ALIGNMENT, DivPager.ItemAlignment.FROM_STRING, DivPagerJsonParser.CROSS_AXIS_ALIGNMENT_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression5 == null) {
                expressionResolveOptionalExpression5 = DivPagerJsonParser.CROSS_AXIS_ALIGNMENT_DEFAULT_VALUE;
            }
            Expression<DivPager.ItemAlignment> expression2 = expressionResolveOptionalExpression5;
            Expression<Long> expressionResolveOptionalExpression6 = JsonFieldResolver.resolveOptionalExpression(context, template.defaultItem, data, "default_item", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivPagerJsonParser.DEFAULT_ITEM_VALIDATOR, DivPagerJsonParser.DEFAULT_ITEM_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression6 == null) {
                expressionResolveOptionalExpression6 = DivPagerJsonParser.DEFAULT_ITEM_DEFAULT_VALUE;
            }
            Expression<Long> expression3 = expressionResolveOptionalExpression6;
            List listResolveOptionalList3 = JsonFieldResolver.resolveOptionalList(context, template.disappearActions, data, "disappear_actions", this.component.getDivDisappearActionJsonTemplateResolver(), this.component.getDivDisappearActionJsonEntityParser());
            List listResolveOptionalList4 = JsonFieldResolver.resolveOptionalList(context, template.extensions, data, "extensions", this.component.getDivExtensionJsonTemplateResolver(), this.component.getDivExtensionJsonEntityParser());
            DivFocus divFocus = (DivFocus) JsonFieldResolver.resolveOptional(context, template.focus, data, "focus", this.component.getDivFocusJsonTemplateResolver(), this.component.getDivFocusJsonEntityParser());
            List listResolveOptionalList5 = JsonFieldResolver.resolveOptionalList(context, template.functions, data, "functions", this.component.getDivFunctionJsonTemplateResolver(), this.component.getDivFunctionJsonEntityParser());
            DivSize.WrapContent wrapContent = (DivSize) JsonFieldResolver.resolveOptional(context, template.height, data, "height", this.component.getDivSizeJsonTemplateResolver(), this.component.getDivSizeJsonEntityParser());
            if (wrapContent == null) {
                wrapContent = DivPagerJsonParser.HEIGHT_DEFAULT_VALUE;
            }
            DivSize divSize = wrapContent;
            Intrinsics.checkNotNullExpressionValue(divSize, "JsonFieldResolver.resolv…) ?: HEIGHT_DEFAULT_VALUE");
            String str = (String) JsonFieldResolver.resolveOptional(context, template.id, data, "id");
            Expression<Boolean> expressionResolveOptionalExpression7 = JsonFieldResolver.resolveOptionalExpression(context, template.infiniteScroll, data, "infinite_scroll", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivPagerJsonParser.INFINITE_SCROLL_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression7 == null) {
                expressionResolveOptionalExpression7 = DivPagerJsonParser.INFINITE_SCROLL_DEFAULT_VALUE;
            }
            Expression<Boolean> expression4 = expressionResolveOptionalExpression7;
            DivCollectionItemBuilder divCollectionItemBuilder = (DivCollectionItemBuilder) JsonFieldResolver.resolveOptional(context, template.itemBuilder, data, "item_builder", this.component.getDivCollectionItemBuilderJsonTemplateResolver(), this.component.getDivCollectionItemBuilderJsonEntityParser());
            DivFixedSize divFixedSize = (DivFixedSize) JsonFieldResolver.resolveOptional(context, template.itemSpacing, data, "item_spacing", this.component.getDivFixedSizeJsonTemplateResolver(), this.component.getDivFixedSizeJsonEntityParser());
            if (divFixedSize == null) {
                divFixedSize = DivPagerJsonParser.ITEM_SPACING_DEFAULT_VALUE;
            }
            DivFixedSize divFixedSize2 = divFixedSize;
            Intrinsics.checkNotNullExpressionValue(divFixedSize2, "JsonFieldResolver.resolv…TEM_SPACING_DEFAULT_VALUE");
            List listResolveOptionalList6 = JsonFieldResolver.resolveOptionalList(context, template.items, data, FirebaseAnalytics.Param.ITEMS, this.component.getDivJsonTemplateResolver(), this.component.getDivJsonEntityParser());
            Object objResolve = JsonFieldResolver.resolve(context, template.layoutMode, data, "layout_mode", this.component.getDivPagerLayoutModeJsonTemplateResolver(), this.component.getDivPagerLayoutModeJsonEntityParser());
            Intrinsics.checkNotNullExpressionValue(objResolve, "resolve(context, templat…youtModeJsonEntityParser)");
            DivPagerLayoutMode divPagerLayoutMode = (DivPagerLayoutMode) objResolve;
            DivLayoutProvider divLayoutProvider = (DivLayoutProvider) JsonFieldResolver.resolveOptional(context, template.layoutProvider, data, "layout_provider", this.component.getDivLayoutProviderJsonTemplateResolver(), this.component.getDivLayoutProviderJsonEntityParser());
            DivEdgeInsets divEdgeInsets = (DivEdgeInsets) JsonFieldResolver.resolveOptional(context, template.margins, data, "margins", this.component.getDivEdgeInsetsJsonTemplateResolver(), this.component.getDivEdgeInsetsJsonEntityParser());
            Expression<DivPager.Orientation> expressionResolveOptionalExpression8 = JsonFieldResolver.resolveOptionalExpression(context, template.orientation, data, "orientation", DivPagerJsonParser.TYPE_HELPER_ORIENTATION, DivPager.Orientation.FROM_STRING, DivPagerJsonParser.ORIENTATION_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression8 == null) {
                expressionResolveOptionalExpression8 = DivPagerJsonParser.ORIENTATION_DEFAULT_VALUE;
            }
            Expression<DivPager.Orientation> expression5 = expressionResolveOptionalExpression8;
            DivEdgeInsets divEdgeInsets2 = (DivEdgeInsets) JsonFieldResolver.resolveOptional(context, template.paddings, data, "paddings", this.component.getDivEdgeInsetsJsonTemplateResolver(), this.component.getDivEdgeInsetsJsonEntityParser());
            DivPageTransformation divPageTransformation = (DivPageTransformation) JsonFieldResolver.resolveOptional(context, template.pageTransformation, data, "page_transformation", this.component.getDivPageTransformationJsonTemplateResolver(), this.component.getDivPageTransformationJsonEntityParser());
            Expression<Boolean> expressionResolveOptionalExpression9 = JsonFieldResolver.resolveOptionalExpression(context, template.restrictParentScroll, data, "restrict_parent_scroll", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivPagerJsonParser.RESTRICT_PARENT_SCROLL_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression9 == null) {
                expressionResolveOptionalExpression9 = DivPagerJsonParser.RESTRICT_PARENT_SCROLL_DEFAULT_VALUE;
            }
            Expression<Boolean> expression6 = expressionResolveOptionalExpression9;
            Expression expressionResolveOptionalExpression10 = JsonFieldResolver.resolveOptionalExpression(context, template.reuseId, data, "reuse_id", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression expressionResolveOptionalExpression11 = JsonFieldResolver.resolveOptionalExpression(context, template.rowSpan, data, "row_span", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivPagerJsonParser.ROW_SPAN_VALIDATOR);
            Expression<DivPager.ItemAlignment> expressionResolveOptionalExpression12 = JsonFieldResolver.resolveOptionalExpression(context, template.scrollAxisAlignment, data, "scroll_axis_alignment", DivPagerJsonParser.TYPE_HELPER_SCROLL_AXIS_ALIGNMENT, DivPager.ItemAlignment.FROM_STRING, DivPagerJsonParser.SCROLL_AXIS_ALIGNMENT_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression12 == null) {
                expressionResolveOptionalExpression12 = DivPagerJsonParser.SCROLL_AXIS_ALIGNMENT_DEFAULT_VALUE;
            }
            Expression<DivPager.ItemAlignment> expression7 = expressionResolveOptionalExpression12;
            List listResolveOptionalList7 = JsonFieldResolver.resolveOptionalList(context, template.selectedActions, data, "selected_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser());
            List listResolveOptionalList8 = JsonFieldResolver.resolveOptionalList(context, template.tooltips, data, "tooltips", this.component.getDivTooltipJsonTemplateResolver(), this.component.getDivTooltipJsonEntityParser());
            DivTransform divTransform = (DivTransform) JsonFieldResolver.resolveOptional(context, template.transform, data, "transform", this.component.getDivTransformJsonTemplateResolver(), this.component.getDivTransformJsonEntityParser());
            DivChangeTransition divChangeTransition = (DivChangeTransition) JsonFieldResolver.resolveOptional(context, template.transitionChange, data, "transition_change", this.component.getDivChangeTransitionJsonTemplateResolver(), this.component.getDivChangeTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition = (DivAppearanceTransition) JsonFieldResolver.resolveOptional(context, template.transitionIn, data, "transition_in", this.component.getDivAppearanceTransitionJsonTemplateResolver(), this.component.getDivAppearanceTransitionJsonEntityParser());
            DivAppearanceTransition divAppearanceTransition2 = (DivAppearanceTransition) JsonFieldResolver.resolveOptional(context, template.transitionOut, data, "transition_out", this.component.getDivAppearanceTransitionJsonTemplateResolver(), this.component.getDivAppearanceTransitionJsonEntityParser());
            List listResolveOptionalList9 = JsonFieldResolver.resolveOptionalList(context, template.transitionTriggers, data, "transition_triggers", DivTransitionTrigger.FROM_STRING, DivPagerJsonParser.TRANSITION_TRIGGERS_VALIDATOR);
            List listResolveOptionalList10 = JsonFieldResolver.resolveOptionalList(context, template.variableTriggers, data, "variable_triggers", this.component.getDivTriggerJsonTemplateResolver(), this.component.getDivTriggerJsonEntityParser());
            List listResolveOptionalList11 = JsonFieldResolver.resolveOptionalList(context, template.variables, data, "variables", this.component.getDivVariableJsonTemplateResolver(), this.component.getDivVariableJsonEntityParser());
            Expression<DivVisibility> expressionResolveOptionalExpression13 = JsonFieldResolver.resolveOptionalExpression(context, template.visibility, data, "visibility", DivPagerJsonParser.TYPE_HELPER_VISIBILITY, DivVisibility.FROM_STRING, DivPagerJsonParser.VISIBILITY_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression13 == null) {
                expressionResolveOptionalExpression13 = DivPagerJsonParser.VISIBILITY_DEFAULT_VALUE;
            }
            Expression<DivVisibility> expression8 = expressionResolveOptionalExpression13;
            DivVisibilityAction divVisibilityAction = (DivVisibilityAction) JsonFieldResolver.resolveOptional(context, template.visibilityAction, data, "visibility_action", this.component.getDivVisibilityActionJsonTemplateResolver(), this.component.getDivVisibilityActionJsonEntityParser());
            List listResolveOptionalList12 = JsonFieldResolver.resolveOptionalList(context, template.visibilityActions, data, "visibility_actions", this.component.getDivVisibilityActionJsonTemplateResolver(), this.component.getDivVisibilityActionJsonEntityParser());
            DivSize.MatchParent matchParent = (DivSize) JsonFieldResolver.resolveOptional(context, template.width, data, "width", this.component.getDivSizeJsonTemplateResolver(), this.component.getDivSizeJsonEntityParser());
            if (matchParent == null) {
                matchParent = DivPagerJsonParser.WIDTH_DEFAULT_VALUE;
            }
            Intrinsics.checkNotNullExpressionValue(matchParent, "JsonFieldResolver.resolv…r) ?: WIDTH_DEFAULT_VALUE");
            return new DivPager(divAccessibility, expressionResolveOptionalExpression, expressionResolveOptionalExpression2, expression, listResolveOptionalList, listResolveOptionalList2, divBorder, expressionResolveOptionalExpression4, expression2, expression3, listResolveOptionalList3, listResolveOptionalList4, divFocus, listResolveOptionalList5, divSize, str, expression4, divCollectionItemBuilder, divFixedSize2, listResolveOptionalList6, divPagerLayoutMode, divLayoutProvider, divEdgeInsets, expression5, divEdgeInsets2, divPageTransformation, expression6, expressionResolveOptionalExpression10, expressionResolveOptionalExpression11, expression7, listResolveOptionalList7, listResolveOptionalList8, divTransform, divChangeTransition, divAppearanceTransition, divAppearanceTransition2, listResolveOptionalList9, listResolveOptionalList10, listResolveOptionalList11, expression8, divVisibilityAction, listResolveOptionalList12, matchParent);
        }
    }

    /* JADX INFO: compiled from: DivPagerJsonParser.kt */
    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001d8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001d8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150\u001d8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001d8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u001d8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020(8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/yandex/div2/DivPagerJsonParser$Companion;", "", "()V", "ALPHA_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "ALPHA_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "COLUMN_SPAN_VALIDATOR", "", "CROSS_AXIS_ALIGNMENT_DEFAULT_VALUE", "Lcom/yandex/div2/DivPager$ItemAlignment;", "DEFAULT_ITEM_DEFAULT_VALUE", "DEFAULT_ITEM_VALIDATOR", "HEIGHT_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$WrapContent;", "INFINITE_SCROLL_DEFAULT_VALUE", "", "ITEM_SPACING_DEFAULT_VALUE", "Lcom/yandex/div2/DivFixedSize;", "ORIENTATION_DEFAULT_VALUE", "Lcom/yandex/div2/DivPager$Orientation;", "RESTRICT_PARENT_SCROLL_DEFAULT_VALUE", "ROW_SPAN_VALIDATOR", "SCROLL_AXIS_ALIGNMENT_DEFAULT_VALUE", "TRANSITION_TRIGGERS_VALIDATOR", "Lcom/yandex/div/internal/parser/ListValidator;", "Lcom/yandex/div2/DivTransitionTrigger;", "TYPE_HELPER_ALIGNMENT_HORIZONTAL", "Lcom/yandex/div/internal/parser/TypeHelper;", "Lcom/yandex/div2/DivAlignmentHorizontal;", "TYPE_HELPER_ALIGNMENT_VERTICAL", "Lcom/yandex/div2/DivAlignmentVertical;", "TYPE_HELPER_CROSS_AXIS_ALIGNMENT", "TYPE_HELPER_ORIENTATION", "TYPE_HELPER_SCROLL_AXIS_ALIGNMENT", "TYPE_HELPER_VISIBILITY", "Lcom/yandex/div2/DivVisibility;", "VISIBILITY_DEFAULT_VALUE", "WIDTH_DEFAULT_VALUE", "Lcom/yandex/div2/DivSize$MatchParent;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        int i = 1;
        ITEM_SPACING_DEFAULT_VALUE = new DivFixedSize(0 == true ? 1 : 0, Expression.INSTANCE.constant(0L), i, 0 == true ? 1 : 0);
        WIDTH_DEFAULT_VALUE = new DivSize.MatchParent(new DivMatchParentSize(0 == true ? 1 : 0, i, 0 == true ? 1 : 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TRANSITION_TRIGGERS_VALIDATOR$lambda$4(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.size() >= 1;
    }
}
