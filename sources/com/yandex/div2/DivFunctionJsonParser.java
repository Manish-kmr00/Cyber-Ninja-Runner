package com.yandex.div2;

import com.yandex.div.internal.parser.JsonFieldParser;
import com.yandex.div.internal.parser.JsonFieldResolver;
import com.yandex.div.internal.parser.JsonPropertyParser;
import com.yandex.div.internal.parser.ParsingValidatorsKt;
import com.yandex.div.internal.parser.ValueValidator;
import com.yandex.div.internal.template.Field;
import com.yandex.div.json.ParsingException;
import com.yandex.div.serialization.Parser;
import com.yandex.div.serialization.ParsingContext;
import com.yandex.div.serialization.ParsingContextKt;
import com.yandex.div.serialization.TemplateParser;
import com.yandex.div.serialization.TemplateResolver;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivFunctionJsonParser.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0004\u0005\u0006\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div2/DivFunctionJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "Companion", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivFunctionJsonParser {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final ValueValidator<String> NAME_VALIDATOR = new ValueValidator() { // from class: com.yandex.div2.DivFunctionJsonParser$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.parser.ValueValidator
        public final boolean isValid(Object obj) {
            return DivFunctionJsonParser.NAME_VALIDATOR$lambda$0((String) obj);
        }
    };
    private final JsonParserComponent component;

    public DivFunctionJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivFunctionJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivFunctionJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivFunction;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivFunction> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivFunction deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            List list = JsonPropertyParser.readList(context, data, "arguments", this.component.getDivFunctionArgumentJsonEntityParser());
            Intrinsics.checkNotNullExpressionValue(list, "readList(context, data, …ArgumentJsonEntityParser)");
            Object obj = JsonPropertyParser.read(context, data, "body");
            Intrinsics.checkNotNullExpressionValue(obj, "read(context, data, \"body\")");
            Object obj2 = JsonPropertyParser.read(context, data, "name", DivFunctionJsonParser.NAME_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(obj2, "read(context, data, \"name\", NAME_VALIDATOR)");
            Object obj3 = JsonPropertyParser.read(context, data, "return_type", (Function1<R, Object>) DivEvaluableType.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(obj3, "read(context, data, \"ret…valuableType.FROM_STRING)");
            return new DivFunction(list, (String) obj, (String) obj2, (DivEvaluableType) obj3);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivFunction value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonPropertyParser.writeList(context, jSONObject, "arguments", value.arguments, this.component.getDivFunctionArgumentJsonEntityParser());
            JsonPropertyParser.write(context, jSONObject, "body", value.body);
            JsonPropertyParser.write(context, jSONObject, "name", value.name);
            JsonPropertyParser.write(context, jSONObject, "return_type", value.returnType, (Function1<DivEvaluableType, R>) DivEvaluableType.TO_STRING);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivFunctionJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivFunctionJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/TemplateParser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivFunctionTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "parent", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements TemplateParser<JSONObject, DivFunctionTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateDeserializer
        public DivFunctionTemplate deserialize(ParsingContext context, DivFunctionTemplate parent, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean allowPropertyOverride = context.getAllowPropertyOverride();
            ParsingContext parsingContextRestrictPropertyOverride = ParsingContextKt.restrictPropertyOverride(context);
            Field listField = JsonFieldParser.readListField(parsingContextRestrictPropertyOverride, data, "arguments", allowPropertyOverride, parent != null ? parent.arguments : null, this.component.getDivFunctionArgumentJsonTemplateParser());
            Intrinsics.checkNotNullExpressionValue(listField, "readListField(context, d…gumentJsonTemplateParser)");
            Field field = JsonFieldParser.readField(parsingContextRestrictPropertyOverride, data, "body", allowPropertyOverride, parent != null ? parent.body : null);
            Intrinsics.checkNotNullExpressionValue(field, "readField(context, data,…owOverride, parent?.body)");
            Field field2 = JsonFieldParser.readField(parsingContextRestrictPropertyOverride, data, "name", allowPropertyOverride, parent != null ? parent.name : null, DivFunctionJsonParser.NAME_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(field2, "readField(context, data,…nt?.name, NAME_VALIDATOR)");
            Field field3 = JsonFieldParser.readField(parsingContextRestrictPropertyOverride, data, "return_type", allowPropertyOverride, parent != null ? parent.returnType : null, DivEvaluableType.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(field3, "readField(context, data,…valuableType.FROM_STRING)");
            return new DivFunctionTemplate((Field<List<DivFunctionArgumentTemplate>>) listField, (Field<String>) field, (Field<String>) field2, (Field<DivEvaluableType>) field3);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivFunctionTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            JsonFieldParser.writeListField(context, jSONObject, "arguments", value.arguments, this.component.getDivFunctionArgumentJsonTemplateParser());
            JsonFieldParser.writeField(context, jSONObject, "body", value.body);
            JsonFieldParser.writeField(context, jSONObject, "name", value.name);
            JsonFieldParser.writeField(context, jSONObject, "return_type", value.returnType, DivEvaluableType.TO_STRING);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: DivFunctionJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivFunctionJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivFunctionTemplate;", "Lcom/yandex/div2/DivFunction;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivFunctionTemplate, DivFunction> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivFunction resolve(ParsingContext context, DivFunctionTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            List listResolveList = JsonFieldResolver.resolveList(context, template.arguments, data, "arguments", this.component.getDivFunctionArgumentJsonTemplateResolver(), this.component.getDivFunctionArgumentJsonEntityParser());
            Intrinsics.checkNotNullExpressionValue(listResolveList, "resolveList(context, tem…ArgumentJsonEntityParser)");
            Object objResolve = JsonFieldResolver.resolve(context, template.body, data, "body");
            Intrinsics.checkNotNullExpressionValue(objResolve, "resolve(context, template.body, data, \"body\")");
            Object objResolve2 = JsonFieldResolver.resolve(context, template.name, data, "name", DivFunctionJsonParser.NAME_VALIDATOR);
            Intrinsics.checkNotNullExpressionValue(objResolve2, "resolve(context, templat…, \"name\", NAME_VALIDATOR)");
            Object objResolve3 = JsonFieldResolver.resolve(context, (Field<Object>) template.returnType, data, "return_type", (Function1<R, Object>) DivEvaluableType.FROM_STRING);
            Intrinsics.checkNotNullExpressionValue(objResolve3, "resolve(context, templat…valuableType.FROM_STRING)");
            return new DivFunction(listResolveList, (String) objResolve, (String) objResolve2, (DivEvaluableType) objResolve3);
        }
    }

    /* JADX INFO: compiled from: DivFunctionJsonParser.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/yandex/div2/DivFunctionJsonParser$Companion;", "", "()V", "NAME_VALIDATOR", "Lcom/yandex/div/internal/parser/ValueValidator;", "", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean NAME_VALIDATOR$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ParsingValidatorsKt.doesMatch(it, "^[a-zA-Z_][a-zA-Z0-9_]*$");
    }
}
