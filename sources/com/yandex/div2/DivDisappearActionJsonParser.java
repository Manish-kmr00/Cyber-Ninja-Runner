package com.yandex.div2;

import com.yandex.div.internal.parser.JsonExpressionParser;
import com.yandex.div.internal.parser.JsonFieldParser;
import com.yandex.div.internal.parser.JsonFieldResolver;
import com.yandex.div.internal.parser.JsonPropertyParser;
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

/* JADX INFO: compiled from: DivDisappearActionJsonParser.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivDisappearActionJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivDisappearActionJsonParser {
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<Long> DISAPPEAR_DURATION_DEFAULT_VALUE = Expression.INSTANCE.constant(800L);

    @Deprecated
    public static final Expression<Boolean> IS_ENABLED_DEFAULT_VALUE = Expression.INSTANCE.constant(true);

    @Deprecated
    public static final Expression<Long> LOG_LIMIT_DEFAULT_VALUE = Expression.INSTANCE.constant(1L);

    @Deprecated
    public static final Expression<Long> VISIBILITY_PERCENTAGE_DEFAULT_VALUE = Expression.INSTANCE.constant(0L);

    @Deprecated
    public static final ValueValidator<Long> DISAPPEAR_DURATION_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivDisappearActionJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivDisappearActionJsonParser.DISAPPEAR_DURATION_VALIDATOR$lambda$0(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> LOG_LIMIT_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivDisappearActionJsonParser$$ExternalSyntheticLambda1
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivDisappearActionJsonParser.LOG_LIMIT_VALIDATOR$lambda$1(((Long) obj).longValue());
        }
    };

    @Deprecated
    public static final ValueValidator<Long> VISIBILITY_PERCENTAGE_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivDisappearActionJsonParser$$ExternalSyntheticLambda2
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivDisappearActionJsonParser.VISIBILITY_PERCENTAGE_VALIDATOR$lambda$2(((Long) obj).longValue());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DISAPPEAR_DURATION_VALIDATOR$lambda$0(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LOG_LIMIT_VALIDATOR$lambda$1(long j) {
        return j >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean VISIBILITY_PERCENTAGE_VALIDATOR$lambda$2(long j) {
        return j >= 0 && j < 100;
    }

    public DivDisappearActionJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivDisappearActionJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivDisappearActionJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivDisappearAction;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivDisappearAction> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivDisappearAction deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression<Long> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, "disappear_duration", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivDisappearActionJsonParser.DISAPPEAR_DURATION_VALIDATOR, DivDisappearActionJsonParser.DISAPPEAR_DURATION_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivDisappearActionJsonParser.DISAPPEAR_DURATION_DEFAULT_VALUE;
            }
            Expression<Long> expression = optionalExpression;
            DivDownloadCallbacks divDownloadCallbacks = (DivDownloadCallbacks) JsonPropertyParser.readOptional(context, data, "download_callbacks", this.component.getDivDownloadCallbacksJsonEntityParser());
            Expression<Boolean> optionalExpression2 = JsonExpressionParser.readOptionalExpression(context, data, "is_enabled", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivDisappearActionJsonParser.IS_ENABLED_DEFAULT_VALUE);
            if (optionalExpression2 == null) {
                optionalExpression2 = DivDisappearActionJsonParser.IS_ENABLED_DEFAULT_VALUE;
            }
            Expression<Boolean> expression2 = optionalExpression2;
            Expression expression3 = JsonExpressionParser.readExpression(context, data, "log_id", TypeHelpersKt.TYPE_HELPER_STRING);
            Intrinsics.checkNotNullExpressionValue(expression3, "readExpression(context, …_id\", TYPE_HELPER_STRING)");
            Expression<Long> optionalExpression3 = JsonExpressionParser.readOptionalExpression(context, data, "log_limit", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivDisappearActionJsonParser.LOG_LIMIT_VALIDATOR, DivDisappearActionJsonParser.LOG_LIMIT_DEFAULT_VALUE);
            if (optionalExpression3 == null) {
                optionalExpression3 = DivDisappearActionJsonParser.LOG_LIMIT_DEFAULT_VALUE;
            }
            Expression<Long> expression4 = optionalExpression3;
            JSONObject jSONObject = (JSONObject) JsonPropertyParser.readOptional(context, data, "payload");
            Expression optionalExpression4 = JsonExpressionParser.readOptionalExpression(context, data, "referer", TypeHelpersKt.TYPE_HELPER_URI, ParsingConvertersKt.ANY_TO_URI);
            String str = (String) JsonPropertyParser.readOptional(context, data, "scope_id");
            DivActionTyped divActionTyped = (DivActionTyped) JsonPropertyParser.readOptional(context, data, "typed", this.component.getDivActionTypedJsonEntityParser());
            Expression optionalExpression5 = JsonExpressionParser.readOptionalExpression(context, data, "url", TypeHelpersKt.TYPE_HELPER_URI, ParsingConvertersKt.ANY_TO_URI);
            Expression<Long> optionalExpression6 = JsonExpressionParser.readOptionalExpression(context, data, "visibility_percentage", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivDisappearActionJsonParser.VISIBILITY_PERCENTAGE_VALIDATOR, DivDisappearActionJsonParser.VISIBILITY_PERCENTAGE_DEFAULT_VALUE);
            if (optionalExpression6 == null) {
                optionalExpression6 = DivDisappearActionJsonParser.VISIBILITY_PERCENTAGE_DEFAULT_VALUE;
            }
            return new DivDisappearAction(expression, divDownloadCallbacks, expression2, expression3, expression4, jSONObject, optionalExpression4, str, divActionTyped, optionalExpression5, optionalExpression6);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivDisappearAction value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonExpressionParser.writeExpression(context, jSONObject, "disappear_duration", value.disappearDuration);
            JsonPropertyParser.write(context, jSONObject, "download_callbacks", value.getDownloadCallbacks(), this.component.getDivDownloadCallbacksJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "is_enabled", value.isEnabled());
            JsonExpressionParser.writeExpression(context, jSONObject, "log_id", value.getLogId());
            JsonExpressionParser.writeExpression(context, jSONObject, "log_limit", value.getLogLimit());
            JsonPropertyParser.write(context, jSONObject, "payload", value.getPayload());
            JsonExpressionParser.writeExpression(context, jSONObject, "referer", value.getReferer(), ParsingConvertersKt.URI_TO_STRING);
            JsonPropertyParser.write(context, jSONObject, "scope_id", value.getScopeId());
            JsonPropertyParser.write(context, jSONObject, "typed", value.getTyped(), this.component.getDivActionTypedJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "url", value.getUrl(), ParsingConvertersKt.URI_TO_STRING);
            JsonExpressionParser.writeExpression(context, jSONObject, "visibility_percentage", value.visibilityPercentage);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivDisappearActionJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivDisappearActionJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivDisappearActionTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivDisappearActionTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivDisappearActionTemplate deserialize(ParsingContext context, DivDisappearActionTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "disappear_duration", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.disappearDuration : null, ParsingConvertersKt.NUMBER_TO_INT, DivDisappearActionJsonParser.DISAPPEAR_DURATION_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…PPEAR_DURATION_VALIDATOR)");
            Field optionalField = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "download_callbacks", allowPropertyOverride, parent != null ? parent.downloadCallbacks : null, this.component.getDivDownloadCallbacksJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField, "readOptionalField(contex…lbacksJsonTemplateParser)");
            Field optionalFieldWithExpression2 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "is_enabled", TypeHelpersKt.TYPE_HELPER_BOOLEAN, allowPropertyOverride, parent != null ? parent.isEnabled : null, ParsingConvertersKt.ANY_TO_BOOLEAN);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression2, "readOptionalFieldWithExp…sEnabled, ANY_TO_BOOLEAN)");
            Field fieldWithExpression = JsonFieldParser.readFieldWithExpression(parsingContextRestrictPropertyOverride, data, "log_id", TypeHelpersKt.TYPE_HELPER_STRING, allowPropertyOverride, parent != null ? parent.logId : null);
            Intrinsics.checkNotNullExpressionValue(fieldWithExpression, "readFieldWithExpression(…wOverride, parent?.logId)");
            Field optionalFieldWithExpression3 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "log_limit", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.logLimit : null, ParsingConvertersKt.NUMBER_TO_INT, DivDisappearActionJsonParser.LOG_LIMIT_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression3, "readOptionalFieldWithExp…INT, LOG_LIMIT_VALIDATOR)");
            Field optionalField2 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "payload", allowPropertyOverride, parent != null ? parent.payload : null);
            Intrinsics.checkNotNullExpressionValue(optionalField2, "readOptionalField(contex…verride, parent?.payload)");
            Field optionalFieldWithExpression4 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "referer", TypeHelpersKt.TYPE_HELPER_URI, allowPropertyOverride, parent != null ? parent.referer : null, ParsingConvertersKt.ANY_TO_URI);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression4, "readOptionalFieldWithExp…ent?.referer, ANY_TO_URI)");
            Field optionalField3 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "scope_id", allowPropertyOverride, parent != null ? parent.scopeId : null);
            Intrinsics.checkNotNullExpressionValue(optionalField3, "readOptionalField(contex…verride, parent?.scopeId)");
            Field optionalField4 = JsonFieldParser.readOptionalField(parsingContextRestrictPropertyOverride, data, "typed", allowPropertyOverride, parent != null ? parent.typed : null, this.component.getDivActionTypedJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalField4, "readOptionalField(contex…nTypedJsonTemplateParser)");
            Field optionalFieldWithExpression5 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "url", TypeHelpersKt.TYPE_HELPER_URI, allowPropertyOverride, parent != null ? parent.url : null, ParsingConvertersKt.ANY_TO_URI);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression5, "readOptionalFieldWithExp… parent?.url, ANY_TO_URI)");
            Field optionalFieldWithExpression6 = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "visibility_percentage", TypeHelpersKt.TYPE_HELPER_INT, allowPropertyOverride, parent != null ? parent.visibilityPercentage : null, ParsingConvertersKt.NUMBER_TO_INT, DivDisappearActionJsonParser.VISIBILITY_PERCENTAGE_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression6, "readOptionalFieldWithExp…ITY_PERCENTAGE_VALIDATOR)");
            return new DivDisappearActionTemplate(optionalFieldWithExpression, optionalField, optionalFieldWithExpression2, fieldWithExpression, optionalFieldWithExpression3, optionalField2, optionalFieldWithExpression4, optionalField3, optionalField4, optionalFieldWithExpression5, optionalFieldWithExpression6);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivDisappearActionTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeExpressionField(context, jSONObject, "disappear_duration", value.disappearDuration);
            JsonFieldParser.writeField(context, jSONObject, "download_callbacks", value.downloadCallbacks, this.component.getDivDownloadCallbacksJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "is_enabled", value.isEnabled);
            JsonFieldParser.writeExpressionField(context, jSONObject, "log_id", value.logId);
            JsonFieldParser.writeExpressionField(context, jSONObject, "log_limit", value.logLimit);
            JsonFieldParser.writeField(context, jSONObject, "payload", value.payload);
            JsonFieldParser.writeExpressionField(context, jSONObject, "referer", value.referer, ParsingConvertersKt.URI_TO_STRING);
            JsonFieldParser.writeField(context, jSONObject, "scope_id", value.scopeId);
            JsonFieldParser.writeField(context, jSONObject, "typed", value.typed, this.component.getDivActionTypedJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "url", value.url, ParsingConvertersKt.URI_TO_STRING);
            JsonFieldParser.writeExpressionField(context, jSONObject, "visibility_percentage", value.visibilityPercentage);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivDisappearActionJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivDisappearActionJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivDisappearActionTemplate;", "Lcom/yandex/div2/DivDisappearAction;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivDisappearActionTemplate, DivDisappearAction> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivDisappearAction resolve(ParsingContext context, DivDisappearActionTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            Expression<Long> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.disappearDuration, data, "disappear_duration", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivDisappearActionJsonParser.DISAPPEAR_DURATION_VALIDATOR, DivDisappearActionJsonParser.DISAPPEAR_DURATION_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivDisappearActionJsonParser.DISAPPEAR_DURATION_DEFAULT_VALUE;
            }
            Expression<Long> expression = expressionResolveOptionalExpression;
            DivDownloadCallbacks divDownloadCallbacks = (DivDownloadCallbacks) JsonFieldResolver.resolveOptional(context, template.downloadCallbacks, data, "download_callbacks", this.component.getDivDownloadCallbacksJsonTemplateResolver(), this.component.getDivDownloadCallbacksJsonEntityParser());
            Expression<Boolean> expressionResolveOptionalExpression2 = JsonFieldResolver.resolveOptionalExpression(context, template.isEnabled, data, "is_enabled", TypeHelpersKt.TYPE_HELPER_BOOLEAN, ParsingConvertersKt.ANY_TO_BOOLEAN, DivDisappearActionJsonParser.IS_ENABLED_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression2 == null) {
                expressionResolveOptionalExpression2 = DivDisappearActionJsonParser.IS_ENABLED_DEFAULT_VALUE;
            }
            Expression<Boolean> expression2 = expressionResolveOptionalExpression2;
            Expression expressionResolveExpression = JsonFieldResolver.resolveExpression(context, template.logId, data, "log_id", TypeHelpersKt.TYPE_HELPER_STRING);
            Intrinsics.checkNotNullExpressionValue(expressionResolveExpression, "resolveExpression(contex…_id\", TYPE_HELPER_STRING)");
            Expression<Long> expressionResolveOptionalExpression3 = JsonFieldResolver.resolveOptionalExpression(context, template.logLimit, data, "log_limit", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivDisappearActionJsonParser.LOG_LIMIT_VALIDATOR, DivDisappearActionJsonParser.LOG_LIMIT_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression3 == null) {
                expressionResolveOptionalExpression3 = DivDisappearActionJsonParser.LOG_LIMIT_DEFAULT_VALUE;
            }
            Expression<Long> expression3 = expressionResolveOptionalExpression3;
            JSONObject jSONObject = (JSONObject) JsonFieldResolver.resolveOptional(context, template.payload, data, "payload");
            Expression expressionResolveOptionalExpression4 = JsonFieldResolver.resolveOptionalExpression(context, template.referer, data, "referer", TypeHelpersKt.TYPE_HELPER_URI, ParsingConvertersKt.ANY_TO_URI);
            String str = (String) JsonFieldResolver.resolveOptional(context, template.scopeId, data, "scope_id");
            DivActionTyped divActionTyped = (DivActionTyped) JsonFieldResolver.resolveOptional(context, template.typed, data, "typed", this.component.getDivActionTypedJsonTemplateResolver(), this.component.getDivActionTypedJsonEntityParser());
            Expression expressionResolveOptionalExpression5 = JsonFieldResolver.resolveOptionalExpression(context, template.url, data, "url", TypeHelpersKt.TYPE_HELPER_URI, ParsingConvertersKt.ANY_TO_URI);
            Expression<Long> expressionResolveOptionalExpression6 = JsonFieldResolver.resolveOptionalExpression(context, template.visibilityPercentage, data, "visibility_percentage", TypeHelpersKt.TYPE_HELPER_INT, ParsingConvertersKt.NUMBER_TO_INT, DivDisappearActionJsonParser.VISIBILITY_PERCENTAGE_VALIDATOR, DivDisappearActionJsonParser.VISIBILITY_PERCENTAGE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression6 == null) {
                expressionResolveOptionalExpression6 = DivDisappearActionJsonParser.VISIBILITY_PERCENTAGE_DEFAULT_VALUE;
            }
            return new DivDisappearAction(expression, divDownloadCallbacks, expression2, expressionResolveExpression, expression3, jSONObject, expressionResolveOptionalExpression4, str, divActionTyped, expressionResolveOptionalExpression5, expressionResolveOptionalExpression6);
        }
    }

    /* JADX INFO: compiled from: DivDisappearActionJsonParser.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivDisappearActionJsonParser$Companion;", "", "()V", "DISAPPEAR_DURATION_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "", "DISAPPEAR_DURATION_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "IS_ENABLED_DEFAULT_VALUE", "", "LOG_LIMIT_DEFAULT_VALUE", "LOG_LIMIT_VALIDATOR", "VISIBILITY_PERCENTAGE_DEFAULT_VALUE", "VISIBILITY_PERCENTAGE_VALIDATOR", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
