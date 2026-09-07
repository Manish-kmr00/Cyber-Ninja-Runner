package com.yandex.div2;

import com.yandex.div.data.EntityTemplate;
import com.yandex.div.internal.parser.JsonPropertyParser;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.ParsingExceptionKt;
import com.yandex.div.serialization.Parser;
import com.yandex.div.serialization.ParsingContext;
import com.yandex.div.serialization.TemplateResolver;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivTypedValueJsonParser.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0003\u0005\u0006\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yandex/div2/DivTypedValueJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivTypedValueJsonParser {
    private final JsonParserComponent component;

    public DivTypedValueJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivTypedValueJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivTypedValueJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTypedValue;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivTypedValue> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.yandex.div.serialization.Deserializer
        public DivTypedValue deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            String string = JsonPropertyParser.readString(context, data, "type");
            Intrinsics.checkNotNullExpressionValue(string, "readString(context, data, \"type\")");
            switch (string.hashCode()) {
                case -1034364087:
                    if (string.equals("number")) {
                        return new DivTypedValue.Number(this.component.getNumberValueJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case -891985903:
                    if (string.equals("string")) {
                        return new DivTypedValue.Str(this.component.getStrValueJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 116079:
                    if (string.equals("url")) {
                        return new DivTypedValue.Url(this.component.getUrlValueJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 3083190:
                    if (string.equals("dict")) {
                        return new DivTypedValue.Dict(this.component.getDictValueJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 64711720:
                    if (string.equals("boolean")) {
                        return new DivTypedValue.Bool(this.component.getBoolValueJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 93090393:
                    if (string.equals("array")) {
                        return new DivTypedValue.Array(this.component.getArrayValueJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 94842723:
                    if (string.equals("color")) {
                        return new DivTypedValue.Color(this.component.getColorValueJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 1958052158:
                    if (string.equals("integer")) {
                        return new DivTypedValue.Integer(this.component.getIntegerValueJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
            }
            EntityTemplate orThrow = context.getTemplates().getOrThrow(string, data);
            DivTypedValueTemplate divTypedValueTemplate = orThrow instanceof DivTypedValueTemplate ? (DivTypedValueTemplate) orThrow : null;
            if (divTypedValueTemplate != null) {
                return this.component.getDivTypedValueJsonTemplateResolver().getValue().resolve(context, divTypedValueTemplate, data);
            }
            throw ParsingExceptionKt.typeMismatch(data, "type", string);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivTypedValue value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof DivTypedValue.Str) {
                return this.component.getStrValueJsonEntityParser().getValue().serialize(context, ((DivTypedValue.Str) value).getValue());
            }
            if (value instanceof DivTypedValue.Integer) {
                return this.component.getIntegerValueJsonEntityParser().getValue().serialize(context, ((DivTypedValue.Integer) value).getValue());
            }
            if (value instanceof DivTypedValue.Number) {
                return this.component.getNumberValueJsonEntityParser().getValue().serialize(context, ((DivTypedValue.Number) value).getValue());
            }
            if (value instanceof DivTypedValue.Color) {
                return this.component.getColorValueJsonEntityParser().getValue().serialize(context, ((DivTypedValue.Color) value).getValue());
            }
            if (value instanceof DivTypedValue.Bool) {
                return this.component.getBoolValueJsonEntityParser().getValue().serialize(context, ((DivTypedValue.Bool) value).getValue());
            }
            if (value instanceof DivTypedValue.Url) {
                return this.component.getUrlValueJsonEntityParser().getValue().serialize(context, ((DivTypedValue.Url) value).getValue());
            }
            if (value instanceof DivTypedValue.Dict) {
                return this.component.getDictValueJsonEntityParser().getValue().serialize(context, ((DivTypedValue.Dict) value).getValue());
            }
            if (value instanceof DivTypedValue.Array) {
                return this.component.getArrayValueJsonEntityParser().getValue().serialize(context, ((DivTypedValue.Array) value).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: DivTypedValueJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivTypedValueJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTypedValueTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements Parser<JSONObject, DivTypedValueTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.yandex.div.serialization.Deserializer
        public DivTypedValueTemplate deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            String type;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            String string = JsonPropertyParser.readString(context, data, "type");
            Intrinsics.checkNotNullExpressionValue(string, "readString(context, data, \"type\")");
            EntityTemplate entityTemplate = context.getTemplates().get(string);
            DivTypedValueTemplate divTypedValueTemplate = entityTemplate instanceof DivTypedValueTemplate ? (DivTypedValueTemplate) entityTemplate : null;
            if (divTypedValueTemplate != null && (type = divTypedValueTemplate.getType()) != null) {
                string = type;
            }
            switch (string.hashCode()) {
                case -1034364087:
                    if (string.equals("number")) {
                        return new DivTypedValueTemplate.Number(this.component.getNumberValueJsonTemplateParser().getValue().deserialize(context, (NumberValueTemplate) (divTypedValueTemplate != null ? divTypedValueTemplate.value() : null), data));
                    }
                    break;
                case -891985903:
                    if (string.equals("string")) {
                        return new DivTypedValueTemplate.Str(this.component.getStrValueJsonTemplateParser().getValue().deserialize(context, (StrValueTemplate) (divTypedValueTemplate != null ? divTypedValueTemplate.value() : null), data));
                    }
                    break;
                case 116079:
                    if (string.equals("url")) {
                        return new DivTypedValueTemplate.Url(this.component.getUrlValueJsonTemplateParser().getValue().deserialize(context, (UrlValueTemplate) (divTypedValueTemplate != null ? divTypedValueTemplate.value() : null), data));
                    }
                    break;
                case 3083190:
                    if (string.equals("dict")) {
                        return new DivTypedValueTemplate.Dict(this.component.getDictValueJsonTemplateParser().getValue().deserialize(context, (DictValueTemplate) (divTypedValueTemplate != null ? divTypedValueTemplate.value() : null), data));
                    }
                    break;
                case 64711720:
                    if (string.equals("boolean")) {
                        return new DivTypedValueTemplate.Bool(this.component.getBoolValueJsonTemplateParser().getValue().deserialize(context, (BoolValueTemplate) (divTypedValueTemplate != null ? divTypedValueTemplate.value() : null), data));
                    }
                    break;
                case 93090393:
                    if (string.equals("array")) {
                        return new DivTypedValueTemplate.Array(this.component.getArrayValueJsonTemplateParser().getValue().deserialize(context, (ArrayValueTemplate) (divTypedValueTemplate != null ? divTypedValueTemplate.value() : null), data));
                    }
                    break;
                case 94842723:
                    if (string.equals("color")) {
                        return new DivTypedValueTemplate.Color(this.component.getColorValueJsonTemplateParser().getValue().deserialize(context, (ColorValueTemplate) (divTypedValueTemplate != null ? divTypedValueTemplate.value() : null), data));
                    }
                    break;
                case 1958052158:
                    if (string.equals("integer")) {
                        return new DivTypedValueTemplate.Integer(this.component.getIntegerValueJsonTemplateParser().getValue().deserialize(context, (IntegerValueTemplate) (divTypedValueTemplate != null ? divTypedValueTemplate.value() : null), data));
                    }
                    break;
            }
            throw ParsingExceptionKt.typeMismatch(data, "type", string);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivTypedValueTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof DivTypedValueTemplate.Str) {
                return this.component.getStrValueJsonTemplateParser().getValue().serialize(context, ((DivTypedValueTemplate.Str) value).getValue());
            }
            if (value instanceof DivTypedValueTemplate.Integer) {
                return this.component.getIntegerValueJsonTemplateParser().getValue().serialize(context, ((DivTypedValueTemplate.Integer) value).getValue());
            }
            if (value instanceof DivTypedValueTemplate.Number) {
                return this.component.getNumberValueJsonTemplateParser().getValue().serialize(context, ((DivTypedValueTemplate.Number) value).getValue());
            }
            if (value instanceof DivTypedValueTemplate.Color) {
                return this.component.getColorValueJsonTemplateParser().getValue().serialize(context, ((DivTypedValueTemplate.Color) value).getValue());
            }
            if (value instanceof DivTypedValueTemplate.Bool) {
                return this.component.getBoolValueJsonTemplateParser().getValue().serialize(context, ((DivTypedValueTemplate.Bool) value).getValue());
            }
            if (value instanceof DivTypedValueTemplate.Url) {
                return this.component.getUrlValueJsonTemplateParser().getValue().serialize(context, ((DivTypedValueTemplate.Url) value).getValue());
            }
            if (value instanceof DivTypedValueTemplate.Dict) {
                return this.component.getDictValueJsonTemplateParser().getValue().serialize(context, ((DivTypedValueTemplate.Dict) value).getValue());
            }
            if (value instanceof DivTypedValueTemplate.Array) {
                return this.component.getArrayValueJsonTemplateParser().getValue().serialize(context, ((DivTypedValueTemplate.Array) value).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: DivTypedValueJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivTypedValueJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTypedValueTemplate;", "Lcom/yandex/div2/DivTypedValue;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivTypedValueTemplate, DivTypedValue> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivTypedValue resolve(ParsingContext context, DivTypedValueTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            if (template instanceof DivTypedValueTemplate.Str) {
                return new DivTypedValue.Str(this.component.getStrValueJsonTemplateResolver().getValue().resolve(context, ((DivTypedValueTemplate.Str) template).getValue(), data));
            }
            if (template instanceof DivTypedValueTemplate.Integer) {
                return new DivTypedValue.Integer(this.component.getIntegerValueJsonTemplateResolver().getValue().resolve(context, ((DivTypedValueTemplate.Integer) template).getValue(), data));
            }
            if (template instanceof DivTypedValueTemplate.Number) {
                return new DivTypedValue.Number(this.component.getNumberValueJsonTemplateResolver().getValue().resolve(context, ((DivTypedValueTemplate.Number) template).getValue(), data));
            }
            if (template instanceof DivTypedValueTemplate.Color) {
                return new DivTypedValue.Color(this.component.getColorValueJsonTemplateResolver().getValue().resolve(context, ((DivTypedValueTemplate.Color) template).getValue(), data));
            }
            if (template instanceof DivTypedValueTemplate.Bool) {
                return new DivTypedValue.Bool(this.component.getBoolValueJsonTemplateResolver().getValue().resolve(context, ((DivTypedValueTemplate.Bool) template).getValue(), data));
            }
            if (template instanceof DivTypedValueTemplate.Url) {
                return new DivTypedValue.Url(this.component.getUrlValueJsonTemplateResolver().getValue().resolve(context, ((DivTypedValueTemplate.Url) template).getValue(), data));
            }
            if (template instanceof DivTypedValueTemplate.Dict) {
                return new DivTypedValue.Dict(this.component.getDictValueJsonTemplateResolver().getValue().resolve(context, ((DivTypedValueTemplate.Dict) template).getValue(), data));
            }
            if (template instanceof DivTypedValueTemplate.Array) {
                return new DivTypedValue.Array(this.component.getArrayValueJsonTemplateResolver().getValue().resolve(context, ((DivTypedValueTemplate.Array) template).getValue(), data));
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
