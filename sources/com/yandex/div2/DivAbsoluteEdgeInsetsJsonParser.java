package com.yandex.div2;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yandex.div.internal.parser.JsonExpressionParser;
import com.yandex.div.internal.parser.JsonFieldParser;
import com.yandex.div.internal.parser.JsonFieldResolver;
import com.yandex.div.internal.parser.ParsingConvertersKt;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivAbsoluteEdgeInsetsJsonParser.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivAbsoluteEdgeInsetsJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivAbsoluteEdgeInsetsJsonParser {
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<Long> BOTTOM_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);

    @Deprecated
    public static final Expression<Long> LEFT_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);

    @Deprecated
    public static final Expression<Long> RIGHT_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);

    @Deprecated
    public static final Expression<Long> TOP_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);

    @Deprecated
    public static final ValueValidator<Long> BOTTOM_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivAbsoluteEdgeInsetsJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivAbsoluteEdgeInsetsJsonParser.BOTTOM_VALIDATOR$lambda$0(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> LEFT_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivAbsoluteEdgeInsetsJsonParser$$ExternalSyntheticLambda1
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivAbsoluteEdgeInsetsJsonParser.LEFT_VALIDATOR$lambda$1(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> RIGHT_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivAbsoluteEdgeInsetsJsonParser$$ExternalSyntheticLambda2
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivAbsoluteEdgeInsetsJsonParser.RIGHT_VALIDATOR$lambda$2(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> TOP_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivAbsoluteEdgeInsetsJsonParser$$ExternalSyntheticLambda3
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivAbsoluteEdgeInsetsJsonParser.TOP_VALIDATOR$lambda$3(((Long) obj).longValue());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BOTTOM_VALIDATOR$lambda$0(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LEFT_VALIDATOR$lambda$1(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean RIGHT_VALIDATOR$lambda$2(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TOP_VALIDATOR$lambda$3(long j) {
        return j >= 0;
    }

    public DivAbsoluteEdgeInsetsJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivAbsoluteEdgeInsetsJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivAbsoluteEdgeInsetsJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivAbsoluteEdgeInsets;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivAbsoluteEdgeInsets> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivAbsoluteEdgeInsets deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression<Long> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "bottom", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivAbsoluteEdgeInsetsJsonParser.BOTTOM_VALIDATOR, DivAbsoluteEdgeInsetsJsonParser.BOTTOM_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivAbsoluteEdgeInsetsJsonParser.BOTTOM_DEFAULT_VALUE;
            }
            Expression<Long> optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, "left", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivAbsoluteEdgeInsetsJsonParser.LEFT_VALIDATOR, DivAbsoluteEdgeInsetsJsonParser.LEFT_DEFAULT_VALUE);
            if (optionalExpression2 == null) {
                optionalExpression2 = DivAbsoluteEdgeInsetsJsonParser.LEFT_DEFAULT_VALUE;
            }
            Expression<Long> optionalExpression3 = JsonExpressionParser.readOptionalExpression(context, data, "right", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivAbsoluteEdgeInsetsJsonParser.RIGHT_VALIDATOR, DivAbsoluteEdgeInsetsJsonParser.RIGHT_DEFAULT_VALUE);
            if (optionalExpression3 == null) {
                optionalExpression3 = DivAbsoluteEdgeInsetsJsonParser.RIGHT_DEFAULT_VALUE;
            }
            Expression<Long> optionalExpression4 = JsonExpressionParser.readOptionalExpression(context, data, ViewHierarchyConstants.DIMENSION_TOP_KEY, TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivAbsoluteEdgeInsetsJsonParser.TOP_VALIDATOR, DivAbsoluteEdgeInsetsJsonParser.TOP_DEFAULT_VALUE);
            if (optionalExpression4 == null) {
                optionalExpression4 = DivAbsoluteEdgeInsetsJsonParser.TOP_DEFAULT_VALUE;
            }
            return new DivAbsoluteEdgeInsets(optionalExpression, optionalExpression2, optionalExpression3, optionalExpression4);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivAbsoluteEdgeInsets value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonExpressionParser.writeExpression(context, jSONObject, "bottom", value.bottom);
            JsonExpressionParser.writeExpression(context, jSONObject, "left", value.left);
            JsonExpressionParser.writeExpression(context, jSONObject, "right", value.right);
            JsonExpressionParser.writeExpression(context, jSONObject, ViewHierarchyConstants.DIMENSION_TOP_KEY, value.top);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivAbsoluteEdgeInsetsJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivAbsoluteEdgeInsetsJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivAbsoluteEdgeInsetsTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivAbsoluteEdgeInsetsTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivAbsoluteEdgeInsetsTemplate deserialize(ParsingContext context, DivAbsoluteEdgeInsetsTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "bottom", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.bottom : null, ParsingConvertersKt.NUMBER_TO_INT, DivAbsoluteEdgeInsetsJsonParser.BOTTOM_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…TO_INT, BOTTOM_VALIDATOR)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "left", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.left : null, ParsingConvertersKt.NUMBER_TO_INT, DivAbsoluteEdgeInsetsJsonParser.LEFT_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…R_TO_INT, LEFT_VALIDATOR)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "right", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.right : null, ParsingConvertersKt.NUMBER_TO_INT, DivAbsoluteEdgeInsetsJsonParser.RIGHT_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…_TO_INT, RIGHT_VALIDATOR)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, ViewHierarchyConstants.DIMENSION_TOP_KEY, TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.top : null, ParsingConvertersKt.NUMBER_TO_INT, DivAbsoluteEdgeInsetsJsonParser.TOP_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…ER_TO_INT, TOP_VALIDATOR)");
            return new DivAbsoluteEdgeInsetsTemplate((Field<Expression<Long>>) optionalFieldWithExpression, (Field<Expression<Long>>) optionalFieldWithExpression2, (Field<Expression<Long>>) optionalFieldWithExpression3, (Field<Expression<Long>>) optionalFieldWithExpression4);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivAbsoluteEdgeInsetsTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeExpressionField(context, jSONObject, "bottom", value.bottom);
            JsonFieldParser.writeExpressionField(context, jSONObject, "left", value.left);
            JsonFieldParser.writeExpressionField(context, jSONObject, "right", value.right);
            JsonFieldParser.writeExpressionField(context, jSONObject, ViewHierarchyConstants.DIMENSION_TOP_KEY, value.top);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivAbsoluteEdgeInsetsJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivAbsoluteEdgeInsetsJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivAbsoluteEdgeInsetsTemplate;", "Lcom/yandex/div2/DivAbsoluteEdgeInsets;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivAbsoluteEdgeInsetsTemplate, DivAbsoluteEdgeInsets> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivAbsoluteEdgeInsets resolve(ParsingContext context, DivAbsoluteEdgeInsetsTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression<Long> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.bottom, data, "bottom", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivAbsoluteEdgeInsetsJsonParser.BOTTOM_VALIDATOR, DivAbsoluteEdgeInsetsJsonParser.BOTTOM_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivAbsoluteEdgeInsetsJsonParser.BOTTOM_DEFAULT_VALUE;
            }
            Expression<Long> expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.left, data, "left", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivAbsoluteEdgeInsetsJsonParser.LEFT_VALIDATOR, DivAbsoluteEdgeInsetsJsonParser.LEFT_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression2 == null) {
                expressionResolveOptionalExpression2 = DivAbsoluteEdgeInsetsJsonParser.LEFT_DEFAULT_VALUE;
            }
            Expression<Long> expressionResolveOptionalExpression3 = JsonFieldResolver.resolveOptionalExpression(context, template.right, data, "right", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivAbsoluteEdgeInsetsJsonParser.RIGHT_VALIDATOR, DivAbsoluteEdgeInsetsJsonParser.RIGHT_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression3 == null) {
                expressionResolveOptionalExpression3 = DivAbsoluteEdgeInsetsJsonParser.RIGHT_DEFAULT_VALUE;
            }
            Expression<Long> expressionResolveOptionalExpression4 = JsonFieldResolver.resolveOptionalExpression(context, template.top, data, ViewHierarchyConstants.DIMENSION_TOP_KEY, TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivAbsoluteEdgeInsetsJsonParser.TOP_VALIDATOR, DivAbsoluteEdgeInsetsJsonParser.TOP_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression4 == null) {
                expressionResolveOptionalExpression4 = DivAbsoluteEdgeInsetsJsonParser.TOP_DEFAULT_VALUE;
            }
            return new DivAbsoluteEdgeInsets(expressionResolveOptionalExpression, expressionResolveOptionalExpression2, expressionResolveOptionalExpression3, expressionResolveOptionalExpression4);
        }
    }

    /* JADX INFO: compiled from: DivAbsoluteEdgeInsetsJsonParser.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivAbsoluteEdgeInsetsJsonParser$Companion;", "", "()V", "BOTTOM_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "BOTTOM_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "LEFT_DEFAULT_VALUE", "LEFT_VALIDATOR", "RIGHT_DEFAULT_VALUE", "RIGHT_VALIDATOR", "TOP_DEFAULT_VALUE", "TOP_VALIDATOR", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
