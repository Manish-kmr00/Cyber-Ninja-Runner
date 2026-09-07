package com.yandex.div2;

import com.json.b9;
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

/* JADX INFO: compiled from: DivPatchJsonParser.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivPatchJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivPatchJsonParser {
    private final JsonParserComponent component;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final Expression<DivPatch.Mode> MODE_DEFAULT_VALUE = Expression.INSTANCE.constant(DivPatch.Mode.PARTIAL);

    @Deprecated
    public static final TypeHelper<DivPatch.Mode> TYPE_HELPER_MODE = TypeHelper.INSTANCE.from(ArraysKt.first(DivPatch.Mode.values()), new Function1<Object, Boolean>() { // from class: com.yandex.div2.DivPatchJsonParser$Companion$TYPE_HELPER_MODE$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(it instanceof DivPatch.Mode);
        }
    });

    @Deprecated
    public static final ListValidator<DivPatch.Change> CHANGES_VALIDATOR = new ListValidator() { // from class: com.yandex.div2.DivPatchJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ListValidator
        public final boolean isValid(List list) {
            return DivPatchJsonParser.CHANGES_VALIDATOR$lambda$0(list);
        }
    };

    public DivPatchJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivPatchJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivPatchJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivPatch;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivPatch> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivPatch deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            List list = JsonPropertyParser.readList(context, data, "changes", this.component.getDivPatchChangeJsonEntityParser(), DivPatchJsonParser.CHANGES_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(list, "readList(context, data, …arser, CHANGES_VALIDATOR)");
            Expression<DivPatch.Mode> optionalExpression = JsonExpressionParser.readOptionalExpression(context, data, b9.a.t, DivPatchJsonParser.TYPE_HELPER_MODE, DivPatch.Mode.FROM_STRING, DivPatchJsonParser.MODE_DEFAULT_VALUE);
            if (optionalExpression == null) {
                optionalExpression = DivPatchJsonParser.MODE_DEFAULT_VALUE;
            }
            return new DivPatch(list, optionalExpression, JsonPropertyParser.readOptionalList(context, data, "on_applied_actions", this.component.getDivActionJsonEntityParser()), JsonPropertyParser.readOptionalList(context, data, "on_failed_actions", this.component.getDivActionJsonEntityParser()));
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivPatch value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonPropertyParser.writeList(context, jSONObject, "changes", value.changes, this.component.getDivPatchChangeJsonEntityParser());
            JsonExpressionParser.writeExpression(context, jSONObject, b9.a.t, value.mode, DivPatch.Mode.TO_STRING);
            JsonPropertyParser.writeList(context, jSONObject, "on_applied_actions", value.onAppliedActions, this.component.getDivActionJsonEntityParser());
            JsonPropertyParser.writeList(context, jSONObject, "on_failed_actions", value.onFailedActions, this.component.getDivActionJsonEntityParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivPatchJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivPatchJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivPatchTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivPatchTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivPatchTemplate deserialize(ParsingContext context, DivPatchTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field<List<DivPatchTemplate.ChangeTemplate>> field = parent != null ? parent.changes : null;
            Lazy<DivPatchChangeJsonParser.TemplateParserImpl> divPatchChangeJsonTemplateParser = this.component.getDivPatchChangeJsonTemplateParser();
            ListValidator<DivPatch.Change> listValidator = DivPatchJsonParser.CHANGES_VALIDATOR;
            Intrinsics.checkNotNull(listValidator, "null cannot be cast to non-null type com.yandex.div.internal.parser.ListValidator<T of com.yandex.div.internal.parser.ParsingValidatorsKt.cast>");
            Field listField = JsonFieldParser.readListField(parsingContextRestrictPropertyOverride, data, "changes", allowPropertyOverride, field, divPatchChangeJsonTemplateParser, listValidator);
            Intrinsics.checkNotNullExpressionValue(listField, "readListField(context, d…CHANGES_VALIDATOR.cast())");
            Field optionalFieldWithExpression = JsonFieldParser.readOptionalFieldWithExpression(parsingContextRestrictPropertyOverride, data, b9.a.t, DivPatchJsonParser.TYPE_HELPER_MODE, allowPropertyOverride, parent != null ? parent.mode : null, DivPatch.Mode.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(optionalFieldWithExpression, "readOptionalFieldWithExp…ivPatch.Mode.FROM_STRING)");
            Field optionalListField = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "on_applied_actions", allowPropertyOverride, parent != null ? parent.onAppliedActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField, "readOptionalListField(co…ActionJsonTemplateParser)");
            Field optionalListField2 = JsonFieldParser.readOptionalListField(parsingContextRestrictPropertyOverride, data, "on_failed_actions", allowPropertyOverride, parent != null ? parent.onFailedActions : null, this.component.getDivActionJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(optionalListField2, "readOptionalListField(co…ActionJsonTemplateParser)");
            return new DivPatchTemplate((Field<List<DivPatchTemplate.ChangeTemplate>>) listField, (Field<Expression<DivPatch.Mode>>) optionalFieldWithExpression, (Field<List<DivActionTemplate>>) optionalListField, (Field<List<DivActionTemplate>>) optionalListField2);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivPatchTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeListField(context, jSONObject, "changes", value.changes, this.component.getDivPatchChangeJsonTemplateParser());
            JsonFieldParser.writeExpressionField(context, jSONObject, b9.a.t, value.mode, DivPatch.Mode.TO_STRING);
            JsonFieldParser.writeListField(context, jSONObject, "on_applied_actions", value.onAppliedActions, this.component.getDivActionJsonTemplateParser());
            JsonFieldParser.writeListField(context, jSONObject, "on_failed_actions", value.onFailedActions, this.component.getDivActionJsonTemplateParser());
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivPatchJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivPatchJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivPatchTemplate;", "Lcom/yandex/div2/DivPatch;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivPatchTemplate, DivPatch> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivPatch resolve(ParsingContext context, DivPatchTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            List listResolveList = JsonFieldResolver.resolveList(context, template.changes, data, "changes", this.component.getDivPatchChangeJsonTemplateResolver(), this.component.getDivPatchChangeJsonEntityParser(), DivPatchJsonParser.CHANGES_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(listResolveList, "resolveList(context, tem…arser, CHANGES_VALIDATOR)");
            Expression<DivPatch.Mode> expressionResolveOptionalExpression = JsonFieldResolver.resolveOptionalExpression(context, template.mode, data, b9.a.t, DivPatchJsonParser.TYPE_HELPER_MODE, DivPatch.Mode.FROM_STRING, DivPatchJsonParser.MODE_DEFAULT_VALUE);
            if (expressionResolveOptionalExpression == null) {
                expressionResolveOptionalExpression = DivPatchJsonParser.MODE_DEFAULT_VALUE;
            }
            return new DivPatch(listResolveList, expressionResolveOptionalExpression, JsonFieldResolver.resolveOptionalList(context, template.onAppliedActions, data, "on_applied_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser()), JsonFieldResolver.resolveOptionalList(context, template.onFailedActions, data, "on_failed_actions", this.component.getDivActionJsonTemplateResolver(), this.component.getDivActionJsonEntityParser()));
        }
    }

    /* JADX INFO: compiled from: DivPatchJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/yandex/div2/DivPatchJsonParser$Companion;", "", "()V", "CHANGES_VALIDATOR", "Lcom/yandex/div/internal/parser/ListValidator;", "Lcom/yandex/div2/DivPatch$Change;", "MODE_DEFAULT_VALUE", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivPatch$Mode;", "TYPE_HELPER_MODE", "Lcom/yandex/div/internal/parser/TypeHelper;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CHANGES_VALIDATOR$lambda$0(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.size() >= 1;
    }
}
