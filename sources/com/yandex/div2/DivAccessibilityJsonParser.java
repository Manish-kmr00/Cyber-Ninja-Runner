package com.yandex.div2;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.json.b9;
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

/* JADX INFO: compiled from: DivAccessibilityJsonParser.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivAccessibilityJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivAccessibilityJsonParser {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<DivAccessibility.Mode> MODE_DEFAULT_VALUE = Expression.INSTANCE.constant(DivAccessibility.Mode.DEFAULT);

    @Deprecated
    public static final Expression<Boolean> MUTE_AFTER_ACTION_DEFAULT_VALUE = Expression.INSTANCE.constant(false);

    @Deprecated
    public static final DivAccessibility.Type TYPE_DEFAULT_VALUE = DivAccessibility.Type.AUTO;

    @Deprecated
    public static final TypeHelper<DivAccessibility.Mode> TYPE_HELPER_MODE = TypeHelper.INSTANCE.from(ArraysKt.first(DivAccessibility.Mode.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivAccessibilityJsonParser$Companion$TYPE_HELPER_MODE$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivAccessibility.Mode);
        }
    });
    private final JsonParserComponent component;

    public DivAccessibilityJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivAccessibilityJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivAccessibilityJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivAccessibility;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivAccessibility> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivAccessibility deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression<String> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "description", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression<String> optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, ViewHierarchyConstants.HINT_KEY, TypeHelpersKt.TYPE_HELPER_STRING);
            Expression optionalExpression3 = JsonExpressionParser.readOptionalExpression(context, data, "is_checked", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN);
            Expression<DivAccessibility.Mode> optionalExpression4 = JsonExpressionParser.readOptionalExpression(context, data, b9.a.t, DivAccessibilityJsonParser.TYPE_HELPER_MODE, DivAccessibility.Mode.FROM_STRING, DivAccessibilityJsonParser.MODE_DEFAULT_VALUE);
            if (optionalExpression4 == null) {
                optionalExpression4 = DivAccessibilityJsonParser.MODE_DEFAULT_VALUE;
            }
            Expression<DivAccessibility.Mode> expression = optionalExpression4;
            Expression<Boolean> optionalExpression5 = JsonExpressionParser.readOptionalExpression(context, data, "mute_after_action", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivAccessibilityJsonParser.MUTE_AFTER_ACTION_DEFAULT_VALUE);
            if (optionalExpression5 == null) {
                optionalExpression5 = DivAccessibilityJsonParser.MUTE_AFTER_ACTION_DEFAULT_VALUE;
            }
            Expression<Boolean> expression2 = optionalExpression5;
            Expression<String> optionalExpression6 = JsonExpressionParser.readOptionalExpression(context, data, "state_description", TypeHelpersKt.TYPE_HELPER_STRING);
            DivAccessibility.Type type = (DivAccessibility.Type) JsonPropertyParser.readOptional(context, data, "type", DivAccessibility.Type.FROM_STRING);
            if (type == null) {
                type = DivAccessibilityJsonParser.TYPE_DEFAULT_VALUE;
            }
            DivAccessibility.Type type2 = type;
            Intrinsics.checkNotNullExpressionValue(type2, "JsonPropertyParser.readO…NG) ?: TYPE_DEFAULT_VALUE");
            return new DivAccessibility(optionalExpression, optionalExpression2, optionalExpression3, expression, expression2, optionalExpression6, type2);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivAccessibility value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonExpressionParser.writeExpression(context, jSONObject, "description", value.description);
            JsonExpressionParser.writeExpression(context, jSONObject, ViewHierarchyConstants.HINT_KEY, value.hint);
            JsonExpressionParser.writeExpression(context, jSONObject, "is_checked", value.isChecked);
            JsonExpressionParser.writeExpression(context, jSONObject, b9.a.t, value.mode, DivAccessibility.Mode.TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "mute_after_action", value.muteAfterAction);
            JsonExpressionParser.writeExpression(context, jSONObject, "state_description", value.stateDescription);
            JsonPropertyParser.write(context, jSONObject, "type", value.type, (Function1<DivAccessibility.Type, R>) DivAccessibility.Type.TO_STRING);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivAccessibilityJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivAccessibilityJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivAccessibilityTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivAccessibilityTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivAccessibilityTemplate deserialize(ParsingContext context, DivAccessibilityTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field<Expression<String>> optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "description", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.description : null);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…ide, parent?.description)");
            Field<Expression<String>> optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, ViewHierarchyConstants.HINT_KEY, TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.hint : null);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…owOverride, parent?.hint)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "is_checked", TypeHelpersKt.TYPE_HELPER_BOOLEAN, allowPropertyOverride, parent != null ? parent.isChecked : null, ParsingConvertersKt.ANY_TO_BOOLEAN);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…sChecked, ANY_TO_BOOLEAN)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, b9.a.t, DivAccessibilityJsonParser.TYPE_HELPER_MODE, allowPropertyOverride, parent != null ? parent.mode : null, DivAccessibility.Mode.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…ibility.Mode.FROM_STRING)");
            Field optionalFieldWithExpression5 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "mute_after_action", TypeHelpersKt.TYPE_HELPER_BOOLEAN, allowPropertyOverride, parent != null ? parent.muteAfterAction : null, ParsingConvertersKt.ANY_TO_BOOLEAN);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression5, "readOptionalFieldWithExp…erAction, ANY_TO_BOOLEAN)");
            Field<Expression<String>> optionalFieldWithExpression6 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "state_description", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.stateDescription : null);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression6, "readOptionalFieldWithExp…parent?.stateDescription)");
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "type", allowPropertyOverride, parent != null ? parent.type : null, DivAccessibility.Type.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex…ibility.Type.FROM_STRING)");
            return new DivAccessibilityTemplate(optionalFieldWithExpression, optionalFieldWithExpression2, optionalFieldWithExpression3, optionalFieldWithExpression4, optionalFieldWithExpression5, optionalFieldWithExpression6, optionalField);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivAccessibilityTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeExpressionField(context, jSONObject, "description", value.description);
            JsonFieldParser.writeExpressionField(context, jSONObject, ViewHierarchyConstants.HINT_KEY, value.hint);
            JsonFieldParser.writeExpressionField(context, jSONObject, "is_checked", value.isChecked);
            JsonFieldParser.writeExpressionField(context, jSONObject, b9.a.t, value.mode, DivAccessibility.Mode.TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "mute_after_action", value.muteAfterAction);
            JsonFieldParser.writeExpressionField(context, jSONObject, "state_description", value.stateDescription);
            JsonFieldParser.writeField(context, jSONObject, "type", value.type, DivAccessibility.Type.TO_STRING);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivAccessibilityJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivAccessibilityJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivAccessibilityTemplate;", "Lcom/yandex/div2/DivAccessibility;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivAccessibilityTemplate, DivAccessibility> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivAccessibility resolve(ParsingContext context, DivAccessibilityTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.description, data, "description", TypeHelpersKt.TYPE_HELPER_STRING);
            Expression expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.hint, data, ViewHierarchyConstants.HINT_KEY, TypeHelpersKt.TYPE_HELPER_STRING);
            Expression expressionResolveOptionalExpression3 = JsonFieldResolver.resolveOptionalExpression(context, template.isChecked, data, "is_checked", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN);
            Expression<DivAccessibility.Mode> expressionResolveOptionalExpression4 = JsonFieldResolver.resolveOptionalExpression(context, template.mode, data, b9.a.t, DivAccessibilityJsonParser.TYPE_HELPER_MODE, DivAccessibility.Mode.FROM_STRING, DivAccessibilityJsonParser.MODE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression4 == null) {
                expressionResolveOptionalExpression4 = DivAccessibilityJsonParser.MODE_DEFAULT_VALUE;
            }
            Expression<DivAccessibility.Mode> expression = expressionResolveOptionalExpression4;
            Expression<Boolean> expressionResolveOptionalExpression5 = JsonFieldResolver.resolveOptionalExpression(context, template.muteAfterAction, data, "mute_after_action", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivAccessibilityJsonParser.MUTE_AFTER_ACTION_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression5 == null) {
                expressionResolveOptionalExpression5 = DivAccessibilityJsonParser.MUTE_AFTER_ACTION_DEFAULT_VALUE;
            }
            Expression<Boolean> expression2 = expressionResolveOptionalExpression5;
            Expression expressionResolveOptionalExpression6 = JsonFieldResolver.resolveOptionalExpression(context, template.stateDescription, data, "state_description", TypeHelpersKt.TYPE_HELPER_STRING);
            DivAccessibility.Type type = (DivAccessibility.Type) JsonFieldResolver.resolveOptional(context, template.type, data, "type", DivAccessibility.Type.FROM_STRING);
            if (type == null) {
                type = DivAccessibilityJsonParser.TYPE_DEFAULT_VALUE;
            }
            DivAccessibility.Type type2 = type;
            Intrinsics.checkNotNullExpressionValue(type2, "JsonFieldResolver.resolv…NG) ?: TYPE_DEFAULT_VALUE");
            return new DivAccessibility(expressionResolveOptionalExpression, expressionResolveOptionalExpression2, expressionResolveOptionalExpression3, expression, expression2, expressionResolveOptionalExpression6, type2);
        }
    }

    /* JADX INFO: compiled from: DivAccessibilityJsonParser.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div2/DivAccessibilityJsonParser$Companion;", "", "()V", "MODE_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAccessibility$Mode;", "MUTE_AFTER_ACTION_DEFAULT_VALUE", "", "TYPE_DEFAULT_VALUE", "Lcom/yandex/div2/DivAccessibility$Type;", "TYPE_HELPER_MODE", "Lcom/yandex/div/internal/parser/TypeHelper;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
