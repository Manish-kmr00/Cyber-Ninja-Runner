package com.yandex.div2;

import com.yandex.div.internal.parser.JsonExpressionParser;
import com.yandex.div.internal.parser.JsonFieldParser;
import com.yandex.div.internal.parser.JsonFieldResolver;
import com.yandex.div.internal.parser.JsonPropertyParser;
import com.yandex.div.internal.parser.ParsingConvertersKt;
import com.yandex.div.internal.parser.TypeHelper;
import com.yandex.div.internal.parser.TypeHelpersKt;
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

/* JADX INFO: compiled from: DivActionScrollByJsonParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivActionScrollByJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivActionScrollByJsonParser {
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<Boolean> ANIMATED_DEFAULT_VALUE = Expression.INSTANCE.constant(true);

    @Deprecated
    public static final Expression<Long> ITEM_COUNT_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);

    @Deprecated
    public static final Expression<Long> OFFSET_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);

    @Deprecated
    public static final Expression<DivActionScrollBy.Overflow> OVERFLOW_DEFAULT_VALUE = Expression.INSTANCE.constant(DivActionScrollBy.Overflow.CLAMP);

    @Deprecated
    public static final TypeHelper<DivActionScrollBy.Overflow> TYPE_HELPER_OVERFLOW = TypeHelper.INSTANCE.from(ArraysKt.first(DivActionScrollBy.Overflow.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivActionScrollByJsonParser$Companion$TYPE_HELPER_OVERFLOW$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivActionScrollBy.Overflow);
        }
    });

    public DivActionScrollByJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivActionScrollByJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivActionScrollByJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionScrollBy;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivActionScrollBy> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivActionScrollBy deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression<Boolean> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "animated", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivActionScrollByJsonParser.ANIMATED_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivActionScrollByJsonParser.ANIMATED_DEFAULT_VALUE;
            }
            Expression<Boolean> expression = optionalExpression;
            Expression expression2 = JsonExpressionParser.readExpression(context, data, "id", TypeHelpersKt.TYPE_HELPER_STRING);
            Intrinsics.checkNotNullExpressionValue(expression2, "readExpression(context, …\"id\", TYPE_HELPER_STRING)");
            Expression<Long> optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, "item_count", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivActionScrollByJsonParser.ITEM_COUNT_DEFAULT_VALUE);
            if (optionalExpression2 == null) {
                optionalExpression2 = DivActionScrollByJsonParser.ITEM_COUNT_DEFAULT_VALUE;
            }
            Expression<Long> expression3 = optionalExpression2;
            Expression<Long> optionalExpression3 = JsonExpressionParser.readOptionalExpression(context, data, "offset", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivActionScrollByJsonParser.OFFSET_DEFAULT_VALUE);
            if (optionalExpression3 == null) {
                optionalExpression3 = DivActionScrollByJsonParser.OFFSET_DEFAULT_VALUE;
            }
            Expression<Long> expression4 = optionalExpression3;
            Expression<DivActionScrollBy.Overflow> optionalExpression4 = JsonExpressionParser.readOptionalExpression(context, data, "overflow", DivActionScrollByJsonParser.TYPE_HELPER_OVERFLOW, DivActionScrollBy.Overflow.FROM_STRING, DivActionScrollByJsonParser.OVERFLOW_DEFAULT_VALUE);
            if (optionalExpression4 == null) {
                optionalExpression4 = DivActionScrollByJsonParser.OVERFLOW_DEFAULT_VALUE;
            }
            return new DivActionScrollBy(expression, expression2, expression3, expression4, optionalExpression4);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivActionScrollBy value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonExpressionParser.writeExpression(context, jSONObject, "animated", value.animated);
            JsonExpressionParser.writeExpression(context, jSONObject, "id", value.id);
            JsonExpressionParser.writeExpression(context, jSONObject, "item_count", value.itemCount);
            JsonExpressionParser.writeExpression(context, jSONObject, "offset", value.offset);
            JsonExpressionParser.writeExpression(context, jSONObject, "overflow", value.overflow, DivActionScrollBy.Overflow.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "type", "scroll_by");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivActionScrollByJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivActionScrollByJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionScrollByTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivActionScrollByTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivActionScrollByTemplate deserialize(ParsingContext context, DivActionScrollByTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "animated", TypeHelpersKt.TYPE_HELPER_BOOLEAN, allowPropertyOverride, parent != null ? parent.animated : null, ParsingConvertersKt.ANY_TO_BOOLEAN);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…animated, ANY_TO_BOOLEAN)");
            Field fieldWithExpression = JsonFieldParser.readFieldWithExpression(parsingContextRestrictPropertyOverride, data, "id", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.id : null);
            Intrinsics.checkNotNullExpressionValue(fieldWithExpression, "readFieldWithExpression(…llowOverride, parent?.id)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "item_count", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.itemCount : null, ParsingConvertersKt.NUMBER_TO_INT);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…itemCount, NUMBER_TO_INT)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "offset", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.offset : null, ParsingConvertersKt.NUMBER_TO_INT);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…t?.offset, NUMBER_TO_INT)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "overflow", DivActionScrollByJsonParser.TYPE_HELPER_OVERFLOW, allowPropertyOverride, parent != null ? parent.overflow : null, DivActionScrollBy.Overflow.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…lBy.Overflow.FROM_STRING)");
            return new DivActionScrollByTemplate(optionalFieldWithExpression, fieldWithExpression, optionalFieldWithExpression2, optionalFieldWithExpression3, optionalFieldWithExpression4);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivActionScrollByTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeExpressionField(context, jSONObject, "animated", value.animated);
            JsonFieldParser.writeExpressionField(context, jSONObject, "id", value.id);
            JsonFieldParser.writeExpressionField(context, jSONObject, "item_count", value.itemCount);
            JsonFieldParser.writeExpressionField(context, jSONObject, "offset", value.offset);
            JsonFieldParser.writeExpressionField(context, jSONObject, "overflow", value.overflow, DivActionScrollBy.Overflow.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "type", "scroll_by");
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivActionScrollByJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivActionScrollByJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionScrollByTemplate;", "Lcom/yandex/div2/DivActionScrollBy;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivActionScrollByTemplate, DivActionScrollBy> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivActionScrollBy resolve(ParsingContext context, DivActionScrollByTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression<Boolean> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.animated, data, "animated", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivActionScrollByJsonParser.ANIMATED_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivActionScrollByJsonParser.ANIMATED_DEFAULT_VALUE;
            }
            Expression<Boolean> expression = expressionResolveOptionalExpression;
            Expression expressionResolveExpression = JsonFieldResolver.resolveExpression(context, template.id, data, "id", TypeHelpersKt.TYPE_HELPER_STRING);
            Intrinsics.checkNotNullExpressionValue(expressionResolveExpression, "resolveExpression(contex…\"id\", TYPE_HELPER_STRING)");
            Expression<Long> expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.itemCount, data, "item_count", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivActionScrollByJsonParser.ITEM_COUNT_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression2 == null) {
                expressionResolveOptionalExpression2 = DivActionScrollByJsonParser.ITEM_COUNT_DEFAULT_VALUE;
            }
            Expression<Long> expression2 = expressionResolveOptionalExpression2;
            Expression<Long> expressionResolveOptionalExpression3 = JsonFieldResolver.resolveOptionalExpression(context, template.offset, data, "offset", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivActionScrollByJsonParser.OFFSET_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression3 == null) {
                expressionResolveOptionalExpression3 = DivActionScrollByJsonParser.OFFSET_DEFAULT_VALUE;
            }
            Expression<Long> expression3 = expressionResolveOptionalExpression3;
            Expression<DivActionScrollBy.Overflow> expressionResolveOptionalExpression4 = JsonFieldResolver.resolveOptionalExpression(context, template.overflow, data, "overflow", DivActionScrollByJsonParser.TYPE_HELPER_OVERFLOW, DivActionScrollBy.Overflow.FROM_STRING, DivActionScrollByJsonParser.OVERFLOW_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression4 == null) {
                expressionResolveOptionalExpression4 = DivActionScrollByJsonParser.OVERFLOW_DEFAULT_VALUE;
            }
            return new DivActionScrollBy(expression, expressionResolveExpression, expression2, expression3, expressionResolveOptionalExpression4);
        }
    }

    /* JADX INFO: compiled from: DivActionScrollByJsonParser.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivActionScrollByJsonParser$Companion;", "", "()V", "ANIMATED_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "ITEM_COUNT_DEFAULT_VALUE", "", "OFFSET_DEFAULT_VALUE", "OVERFLOW_DEFAULT_VALUE", "Lcom/yandex/div2/DivActionScrollBy$Overflow;", "TYPE_HELPER_OVERFLOW", "Lcom/yandex/div/internal/parser/TypeHelper;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
