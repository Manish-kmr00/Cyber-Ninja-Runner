package com.yandex.div2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
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

/* JADX INFO: compiled from: DivActionJsonParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivActionJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivActionJsonParser {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<Boolean> IS_ENABLED_DEFAULT_VALUE = Expression.INSTANCE.constant(true);

    @Deprecated
    public static final TypeHelper<DivAction.Target> TYPE_HELPER_TARGET = TypeHelper.INSTANCE.from(ArraysKt.first(DivAction.Target.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivActionJsonParser$Companion$TYPE_HELPER_TARGET$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivAction.Target);
        }
    });
    private final JsonParserComponent component;

    public DivActionJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivActionJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivActionJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivAction;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivAction> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivAction deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            DivDownloadCallbacks divDownloadCallbacks = (DivDownloadCallbacks) JsonPropertyParser.readOptional(context, data, "download_callbacks", this.component.getDivDownloadCallbacksJsonEntityParser());
            Expression<Boolean> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "is_enabled", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivActionJsonParser.IS_ENABLED_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivActionJsonParser.IS_ENABLED_DEFAULT_VALUE;
            }
            Expression expression = JsonExpressionParser.readExpression(context, data, "log_id", TypeHelpersKt.TYPE_HELPER_STRING);
            Intrinsics.checkNotNullExpressionValue(expression, "readExpression(context, …_id\", TYPE_HELPER_STRING)");
            return new DivAction(divDownloadCallbacks, optionalExpression, expression, JsonExpressionParser.readOptionalExpression(context, data, "log_url", TypeHelpersKt.TYPE_HELPER_URI, ParsingConvertersKt.ANY_TO_URI), JsonPropertyParser.readOptionalList(context, data, "menu_items", this.component.getDivActionMenuItemJsonEntityParser()), (JSONObject) JsonPropertyParser.readOptional(context, data, "payload"), JsonExpressionParser.readOptionalExpression(context, data, "referer", TypeHelpersKt.TYPE_HELPER_URI, ParsingConvertersKt.ANY_TO_URI), (String) JsonPropertyParser.readOptional(context, data, "scope_id"), JsonExpressionParser.readOptionalExpression(context, data, TypedValues.AttributesType.S_TARGET, DivActionJsonParser.TYPE_HELPER_TARGET, DivAction.Target.FROM_STRING), (DivActionTyped) JsonPropertyParser.readOptional(context, data, "typed", this.component.getDivActionTypedJsonEntityParser()), JsonExpressionParser.readOptionalExpression(context, data, "url", TypeHelpersKt.TYPE_HELPER_URI, ParsingConvertersKt.ANY_TO_URI));
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivAction value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonPropertyParser.write(context, jSONObject, "download_callbacks", value.downloadCallbacks, this.component.getDivDownloadCallbacksJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "is_enabled", value.isEnabled);
            JsonExpressionParser.writeExpression(context, jSONObject, "log_id", value.logId);
            JsonExpressionParser.writeExpression(context, jSONObject, "log_url", value.logUrl, ParsingConvertersKt.URI_TO_STRING);
            JsonPropertyParser.writeList(context, jSONObject, "menu_items", value.menuItems, this.component.getDivActionMenuItemJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "payload", value.payload);
            JsonExpressionParser.writeExpression(context, jSONObject, "referer", value.referer, ParsingConvertersKt.URI_TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "scope_id", value.scopeId);
            JsonExpressionParser.writeExpression(context, jSONObject, TypedValues.AttributesType.S_TARGET, value.target, DivAction.Target.TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "typed", value.typed, this.component.getDivActionTypedJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "url", value.url, ParsingConvertersKt.URI_TO_STRING);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivActionJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivActionJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivActionTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivActionTemplate deserialize(ParsingContext context, DivActionTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "download_callbacks", allowPropertyOverride, parent != null ? parent.downloadCallbacks : null, this.component.getDivDownloadCallbacksJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex…lbacksJsonTemplateParser)");
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "is_enabled", TypeHelpersKt.TYPE_HELPER_BOOLEAN, allowPropertyOverride, parent != null ? parent.isEnabled : null, ParsingConvertersKt.ANY_TO_BOOLEAN);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…sEnabled, ANY_TO_BOOLEAN)");
            Field fieldWithExpression = JsonFieldParser.readFieldWithExpression(parsingContextRestrictPropertyOverride, data, "log_id", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.logId : null);
            Intrinsics.checkNotNullExpressionValue(fieldWithExpression, "readFieldWithExpression(…wOverride, parent?.logId)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "log_url", TypeHelpersKt.TYPE_HELPER_URI, allowPropertyOverride, parent != null ? parent.logUrl : null, ParsingConvertersKt.ANY_TO_URI);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…rent?.logUrl, ANY_TO_URI)");
            Field optionalListField = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "menu_items", allowPropertyOverride, parent != null ? parent.menuItems : null, this.component.getDivActionMenuItemJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField, "readOptionalListField(co…nuItemJsonTemplateParser)");
            Field optionalField2 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "payload", allowPropertyOverride, parent != null ? parent.payload : null);
            Intrinsics.checkNotNullExpressionValue(optionalField2, "readOptionalField(contex…verride, parent?.payload)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "referer", TypeHelpersKt.TYPE_HELPER_URI, allowPropertyOverride, parent != null ? parent.referer : null, ParsingConvertersKt.ANY_TO_URI);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…ent?.referer, ANY_TO_URI)");
            Field optionalField3 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "scope_id", allowPropertyOverride, parent != null ? parent.scopeId : null);
            Intrinsics.checkNotNullExpressionValue(optionalField3, "readOptionalField(contex…verride, parent?.scopeId)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, TypedValues.AttributesType.S_TARGET, DivActionJsonParser.TYPE_HELPER_TARGET, allowPropertyOverride, parent != null ? parent.target : null, DivAction.Target.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…ction.Target.FROM_STRING)");
            Field optionalField4 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "typed", allowPropertyOverride, parent != null ? parent.typed : null, this.component.getDivActionTypedJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField4, "readOptionalField(contex…nTypedJsonTemplateParser)");
            Field optionalFieldWithExpression5 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "url", TypeHelpersKt.TYPE_HELPER_URI, allowPropertyOverride, parent != null ? parent.url : null, ParsingConvertersKt.ANY_TO_URI);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression5, "readOptionalFieldWithExp… parent?.url, ANY_TO_URI)");
            return new DivActionTemplate(optionalField, optionalFieldWithExpression, fieldWithExpression, optionalFieldWithExpression2, optionalListField, optionalField2, optionalFieldWithExpression3, optionalField3, optionalFieldWithExpression4, optionalField4, optionalFieldWithExpression5);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivActionTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeField(context, jSONObject, "download_callbacks", value.downloadCallbacks, this.component.getDivDownloadCallbacksJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "is_enabled", value.isEnabled);
            JsonFieldParser.writeExpressionField(context, jSONObject, "log_id", value.logId);
            JsonFieldParser.writeExpressionField(context, jSONObject, "log_url", value.logUrl, ParsingConvertersKt.URI_TO_STRING);
            JsonFieldParser.writeListField(context, jSONObject, "menu_items", value.menuItems, this.component.getDivActionMenuItemJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "payload", value.payload);
            JsonFieldParser.writeExpressionField(context, jSONObject, "referer", value.referer, ParsingConvertersKt.URI_TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "scope_id", value.scopeId);
            JsonFieldParser.writeExpressionField(context, jSONObject, TypedValues.AttributesType.S_TARGET, value.target, DivAction.Target.TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "typed", value.typed, this.component.getDivActionTypedJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "url", value.url, ParsingConvertersKt.URI_TO_STRING);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivActionJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivActionJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionTemplate;", "Lcom/yandex/div2/DivAction;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivActionTemplate, DivAction> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivAction resolve(ParsingContext context, DivActionTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            DivDownloadCallbacks divDownloadCallbacks = (DivDownloadCallbacks) JsonFieldResolver.resolveOptional(context, template.downloadCallbacks, data, "download_callbacks", this.component.getDivDownloadCallbacksJsonTemplateResolver(), this.component.getDivDownloadCallbacksJsonEntityParser());
            Expression<Boolean> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.isEnabled, data, "is_enabled", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivActionJsonParser.IS_ENABLED_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivActionJsonParser.IS_ENABLED_DEFAULT_VALUE;
            }
            Expression<Boolean> expression = expressionResolveOptionalExpression;
            Expression expressionResolveExpression = JsonFieldResolver.resolveExpression(context, template.logId, data, "log_id", TypeHelpersKt.TYPE_HELPER_STRING);
            Intrinsics.checkNotNullExpressionValue(expressionResolveExpression, "resolveExpression(contex…_id\", TYPE_HELPER_STRING)");
            return new DivAction(divDownloadCallbacks, expression, expressionResolveExpression, JsonFieldResolver.resolveOptionalExpression(context, template.logUrl, data, "log_url", TypeHelpersKt.TYPE_HELPER_URI, ParsingConvertersKt.ANY_TO_URI), JsonFieldResolver.resolveOptionalList(context, template.menuItems, data, "menu_items", this.component.getDivActionMenuItemJsonTemplateResolver(), this.component.getDivActionMenuItemJsonEntityParser()), (JSONObject) JsonFieldResolver.resolveOptional(context, template.payload, data, "payload"), JsonFieldResolver.resolveOptionalExpression(context, template.referer, data, "referer", TypeHelpersKt.TYPE_HELPER_URI, ParsingConvertersKt.ANY_TO_URI), (String) JsonFieldResolver.resolveOptional(context, template.scopeId, data, "scope_id"), JsonFieldResolver.resolveOptionalExpression(context, template.target, data, TypedValues.AttributesType.S_TARGET, DivActionJsonParser.TYPE_HELPER_TARGET, DivAction.Target.FROM_STRING), (DivActionTyped) JsonFieldResolver.resolveOptional(context, template.typed, data, "typed", this.component.getDivActionTypedJsonTemplateResolver(), this.component.getDivActionTypedJsonEntityParser()), JsonFieldResolver.resolveOptionalExpression(context, template.url, data, "url", TypeHelpersKt.TYPE_HELPER_URI, ParsingConvertersKt.ANY_TO_URI));
        }
    }

    /* JADX INFO: compiled from: DivActionJsonParser.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivActionJsonParser$Companion;", "", "()V", "IS_ENABLED_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "TYPE_HELPER_TARGET", "Lcom/yandex/div/internal/parser/TypeHelper;", "Lcom/yandex/div2/DivAction$Target;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
