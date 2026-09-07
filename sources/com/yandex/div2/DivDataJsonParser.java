package com.yandex.div2;

import com.yandex.div.internal.parser.JsonExpressionParser;
import com.yandex.div.internal.parser.JsonFieldParser;
import com.yandex.div.internal.parser.JsonFieldResolver;
import com.yandex.div.internal.parser.JsonPropertyParser;
import com.yandex.div.internal.parser.ListValidator;
import com.yandex.div.internal.parser.TypeHelper;
import com.yandex.div.internal.template.Field;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.serialization.Parser;
import com.yandex.div.serialization.ParsingContext;
import com.yandex.div.serialization.ParsingContextKt;
import com.yandex.div.serialization.TemplateParser;
import com.yandex.div.serialization.TemplateResolver;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivDataJsonParser.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivDataJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivDataJsonParser {
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<DivTransitionSelector> TRANSITION_ANIMATION_SELECTOR_DEFAULT_VALUE = Expression.INSTANCE.constant(DivTransitionSelector.NONE);

    @Deprecated
    public static final TypeHelper<DivTransitionSelector> TYPE_HELPER_TRANSITION_ANIMATION_SELECTOR = TypeHelper.INSTANCE.from(ArraysKt.first(DivTransitionSelector.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivDataJsonParser$Companion$TYPE_HELPER_TRANSITION_ANIMATION_SELECTOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivTransitionSelector);
        }
    });

    @Deprecated
    public static final ListValidator<DivData.State> STATES_VALIDATOR = new ListValidator() { // from class: com.yandex.div2.DivDataJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ListValidator
        public final boolean isValid(List list) {
            return DivDataJsonParser.STATES_VALIDATOR$lambda$0(list);
        }
    };

    public DivDataJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivDataJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivDataJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivData;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivData> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivData deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            ParsingContext parsingContextCollectingErrors = ParsingContextKt.collectingErrors(context);
            List optionalList = JsonPropertyParser.readOptionalList(parsingContextCollectingErrors, data, "functions", this.component.getDivFunctionJsonEntityParser());
            Object obj = JsonPropertyParser.read(parsingContextCollectingErrors, data, "log_id");
            Intrinsics.checkNotNullExpressionValue(obj, "read(context, data, \"log_id\")");
            String str = (String) obj;
            List list = JsonPropertyParser.readList(parsingContextCollectingErrors, data, "states", this.component.getDivDataStateJsonEntityParser(), DivDataJsonParser.STATES_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(list, "readList(context, data, …Parser, STATES_VALIDATOR)");
            List optionalList2 = JsonPropertyParser.readOptionalList(parsingContextCollectingErrors, data, "timers", this.component.getDivTimerJsonEntityParser());
            Expression<DivTransitionSelector> optionalExpression = JsonExpressionParser.readOptionalExpression(parsingContextCollectingErrors, data, "transition_animation_selector", DivDataJsonParser.TYPE_HELPER_TRANSITION_ANIMATION_SELECTOR, DivTransitionSelector.FROM_STRING, DivDataJsonParser.TRANSITION_ANIMATION_SELECTOR_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivDataJsonParser.TRANSITION_ANIMATION_SELECTOR_DEFAULT_VALUE;
            }
            return new DivData(optionalList, str, list, optionalList2, optionalExpression, JsonPropertyParser.readOptionalList(parsingContextCollectingErrors, data, "variable_triggers", this.component.getDivTriggerJsonEntityParser()), JsonPropertyParser.readOptionalList(parsingContextCollectingErrors, data, "variables", this.component.getDivVariableJsonEntityParser()), ParsingContextKt.getCollectedErrors(parsingContextCollectingErrors));
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivData value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonPropertyParser.writeList(context, jSONObject, "functions", value.functions, this.component.getDivFunctionJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "log_id", value.logId);
            JsonPropertyParser.writeList(context, jSONObject, "states", value.states, this.component.getDivDataStateJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "timers", value.timers, this.component.getDivTimerJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, "transition_animation_selector", value.transitionAnimationSelector, DivTransitionSelector.TO_STRING);
            JsonPropertyParser.writeList(context, jSONObject, "variable_triggers", value.variableTriggers, this.component.getDivTriggerJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "variables", value.variables, this.component.getDivVariableJsonEntityParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivDataJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivDataJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivDataTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivDataTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivDataTemplate deserialize(ParsingContext context, DivDataTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field optionalListField = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "functions", allowPropertyOverride, parent != null ? parent.functions : null, this.component.getDivFunctionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField, "readOptionalListField(co…nctionJsonTemplateParser)");
            Field field = JsonFieldParser.readField(parsingContextRestrictPropertyOverride, data, "log_id", allowPropertyOverride, parent != null ? parent.logId : null);
            Intrinsics.checkNotNullExpressionValue(field, "readField(context, data,…wOverride, parent?.logId)");
            Field<List<DivDataTemplate.StateTemplate>> field2 = parent != null ? parent.states : null;
            Lazy<DivDataStateJsonParser.TemplateParserImpl> divDataStateJsonTemplateParser = this.component.getDivDataStateJsonTemplateParser();
            ListValidator<DivData.State> listValidator = DivDataJsonParser.STATES_VALIDATOR;
            Intrinsics.checkNotNull(listValidator, "null cannot be cast to non-null type com.yandex.div.internal.parser.ListValidator<T of com.yandex.div.internal.parser.ParsingValidatorsKt.cast>");
            Field listField = JsonFieldParser.readListField(parsingContextRestrictPropertyOverride, data, "states", allowPropertyOverride, field2, divDataStateJsonTemplateParser, listValidator);
            Intrinsics.checkNotNullExpressionValue(listField, "readListField(context, d… STATES_VALIDATOR.cast())");
            Field optionalListField2 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "timers", allowPropertyOverride, parent != null ? parent.timers : null, this.component.getDivTimerJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField2, "readOptionalListField(co…vTimerJsonTemplateParser)");
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, "transition_animation_selector", DivDataJsonParser.TYPE_HELPER_TRANSITION_ANIMATION_SELECTOR, allowPropertyOverride, parent != null ? parent.transitionAnimationSelector : null, DivTransitionSelector.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…tionSelector.FROM_STRING)");
            Field optionalListField3 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "variable_triggers", allowPropertyOverride, parent != null ? parent.variableTriggers : null, this.component.getDivTriggerJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField3, "readOptionalListField(co…riggerJsonTemplateParser)");
            Field optionalListField4 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "variables", allowPropertyOverride, parent != null ? parent.variables : null, this.component.getDivVariableJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField4, "readOptionalListField(co…riableJsonTemplateParser)");
            return new DivDataTemplate(optionalListField, field, listField, optionalListField2, optionalFieldWithExpression, optionalListField3, optionalListField4);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivDataTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeListField(context, jSONObject, "functions", value.functions, this.component.getDivFunctionJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "log_id", value.logId);
            JsonFieldParser.writeListField(context, jSONObject, "states", value.states, this.component.getDivDataStateJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "timers", value.timers, this.component.getDivTimerJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, "transition_animation_selector", value.transitionAnimationSelector, DivTransitionSelector.TO_STRING);
            JsonFieldParser.writeListField(context, jSONObject, "variable_triggers", value.variableTriggers, this.component.getDivTriggerJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "variables", value.variables, this.component.getDivVariableJsonTemplateParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivDataJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivDataJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivDataTemplate;", "Lcom/yandex/div2/DivData;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivDataTemplate, DivData> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivData resolve(ParsingContext context, DivDataTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            List listResolveOptionalList = JsonFieldResolver.resolveOptionalList(context, template.functions, data, "functions", this.component.getDivFunctionJsonTemplateResolver(), this.component.getDivFunctionJsonEntityParser());
            Object objResolve = JsonFieldResolver.resolve(context, template.logId, data, "log_id");
            Intrinsics.checkNotNullExpressionValue(objResolve, "resolve(context, template.logId, data, \"log_id\")");
            String str = (String) objResolve;
            List listResolveList = JsonFieldResolver.resolveList(context, template.states, data, "states", this.component.getDivDataStateJsonTemplateResolver(), this.component.getDivDataStateJsonEntityParser(), DivDataJsonParser.STATES_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(listResolveList, "resolveList(context, tem…Parser, STATES_VALIDATOR)");
            List listResolveOptionalList2 = JsonFieldResolver.resolveOptionalList(context, template.timers, data, "timers", this.component.getDivTimerJsonTemplateResolver(), this.component.getDivTimerJsonEntityParser());
            Expression<DivTransitionSelector> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.transitionAnimationSelector, data, "transition_animation_selector", DivDataJsonParser.TYPE_HELPER_TRANSITION_ANIMATION_SELECTOR, DivTransitionSelector.FROM_STRING, DivDataJsonParser.TRANSITION_ANIMATION_SELECTOR_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivDataJsonParser.TRANSITION_ANIMATION_SELECTOR_DEFAULT_VALUE;
            }
            return new DivData(listResolveOptionalList, str, listResolveList, listResolveOptionalList2, expressionResolveOptionalExpression, JsonFieldResolver.resolveOptionalList(context, template.variableTriggers, data, "variable_triggers", this.component.getDivTriggerJsonTemplateResolver(), this.component.getDivTriggerJsonEntityParser()), JsonFieldResolver.resolveOptionalList(context, template.variables, data, "variables", this.component.getDivVariableJsonTemplateResolver(), this.component.getDivVariableJsonEntityParser()), null, 128, null);
        }
    }

    /* JADX INFO: compiled from: DivDataJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/yandex/div2/DivDataJsonParser$Companion;", "", "()V", "STATES_VALIDATOR", "Lcom/yandex/div/internal/parser/ListValidator;", "Lcom/yandex/div2/DivData$State;", "TRANSITION_ANIMATION_SELECTOR_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivTransitionSelector;", "TYPE_HELPER_TRANSITION_ANIMATION_SELECTOR", "Lcom/yandex/div/internal/parser/TypeHelper;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean STATES_VALIDATOR$lambda$0(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.size() >= 1;
    }
}
