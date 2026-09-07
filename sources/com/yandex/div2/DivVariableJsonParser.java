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

/* JADX INFO: compiled from: DivVariableJsonParser.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0003\u0005\u0006\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yandex/div2/DivVariableJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivVariableJsonParser {
    private final JsonParserComponent component;

    public DivVariableJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivVariableJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivVariableJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivVariable;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivVariable> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.yandex.div.serialization.Deserializer
        public DivVariable deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            String string = JsonPropertyParser.readString(context, data, "type");
            Intrinsics.checkNotNullExpressionValue(string, "readString(context, data, \"type\")");
            switch (string.hashCode()) {
                case -1034364087:
                    if (string.equals("number")) {
                        return new DivVariable.Number(this.component.getNumberVariableJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case -891985903:
                    if (string.equals("string")) {
                        return new DivVariable.Str(this.component.getStrVariableJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 116079:
                    if (string.equals("url")) {
                        return new DivVariable.Url(this.component.getUrlVariableJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 3083190:
                    if (string.equals("dict")) {
                        return new DivVariable.Dict(this.component.getDictVariableJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 64711720:
                    if (string.equals("boolean")) {
                        return new DivVariable.Bool(this.component.getBoolVariableJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 93090393:
                    if (string.equals("array")) {
                        return new DivVariable.Array(this.component.getArrayVariableJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 94842723:
                    if (string.equals("color")) {
                        return new DivVariable.Color(this.component.getColorVariableJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 1958052158:
                    if (string.equals("integer")) {
                        return new DivVariable.Integer(this.component.getIntegerVariableJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
            }
            EntityTemplate orThrow = context.getTemplates().getOrThrow(string, data);
            DivVariableTemplate divVariableTemplate = orThrow instanceof DivVariableTemplate ? (DivVariableTemplate) orThrow : null;
            if (divVariableTemplate != null) {
                return this.component.getDivVariableJsonTemplateResolver().getValue().resolve(context, divVariableTemplate, data);
            }
            throw ParsingExceptionKt.typeMismatch(data, "type", string);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivVariable value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof DivVariable.Str) {
                return this.component.getStrVariableJsonEntityParser().getValue().serialize(context, ((DivVariable.Str) value).getValue());
            }
            if (value instanceof DivVariable.Number) {
                return this.component.getNumberVariableJsonEntityParser().getValue().serialize(context, ((DivVariable.Number) value).getValue());
            }
            if (value instanceof DivVariable.Integer) {
                return this.component.getIntegerVariableJsonEntityParser().getValue().serialize(context, ((DivVariable.Integer) value).getValue());
            }
            if (value instanceof DivVariable.Bool) {
                return this.component.getBoolVariableJsonEntityParser().getValue().serialize(context, ((DivVariable.Bool) value).getValue());
            }
            if (value instanceof DivVariable.Color) {
                return this.component.getColorVariableJsonEntityParser().getValue().serialize(context, ((DivVariable.Color) value).getValue());
            }
            if (value instanceof DivVariable.Url) {
                return this.component.getUrlVariableJsonEntityParser().getValue().serialize(context, ((DivVariable.Url) value).getValue());
            }
            if (value instanceof DivVariable.Dict) {
                return this.component.getDictVariableJsonEntityParser().getValue().serialize(context, ((DivVariable.Dict) value).getValue());
            }
            if (value instanceof DivVariable.Array) {
                return this.component.getArrayVariableJsonEntityParser().getValue().serialize(context, ((DivVariable.Array) value).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: DivVariableJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivVariableJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivVariableTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements Parser<JSONObject, DivVariableTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.yandex.div.serialization.Deserializer
        public DivVariableTemplate deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            String type;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            String string = JsonPropertyParser.readString(context, data, "type");
            Intrinsics.checkNotNullExpressionValue(string, "readString(context, data, \"type\")");
            EntityTemplate entityTemplate = context.getTemplates().get(string);
            DivVariableTemplate divVariableTemplate = entityTemplate instanceof DivVariableTemplate ? (DivVariableTemplate) entityTemplate : null;
            if (divVariableTemplate != null && (type = divVariableTemplate.getType()) != null) {
                string = type;
            }
            switch (string.hashCode()) {
                case -1034364087:
                    if (string.equals("number")) {
                        return new DivVariableTemplate.Number(this.component.getNumberVariableJsonTemplateParser().getValue().deserialize(context, (NumberVariableTemplate) (divVariableTemplate != null ? divVariableTemplate.value() : null), data));
                    }
                    break;
                case -891985903:
                    if (string.equals("string")) {
                        return new DivVariableTemplate.Str(this.component.getStrVariableJsonTemplateParser().getValue().deserialize(context, (StrVariableTemplate) (divVariableTemplate != null ? divVariableTemplate.value() : null), data));
                    }
                    break;
                case 116079:
                    if (string.equals("url")) {
                        return new DivVariableTemplate.Url(this.component.getUrlVariableJsonTemplateParser().getValue().deserialize(context, (UrlVariableTemplate) (divVariableTemplate != null ? divVariableTemplate.value() : null), data));
                    }
                    break;
                case 3083190:
                    if (string.equals("dict")) {
                        return new DivVariableTemplate.Dict(this.component.getDictVariableJsonTemplateParser().getValue().deserialize(context, (DictVariableTemplate) (divVariableTemplate != null ? divVariableTemplate.value() : null), data));
                    }
                    break;
                case 64711720:
                    if (string.equals("boolean")) {
                        return new DivVariableTemplate.Bool(this.component.getBoolVariableJsonTemplateParser().getValue().deserialize(context, (BoolVariableTemplate) (divVariableTemplate != null ? divVariableTemplate.value() : null), data));
                    }
                    break;
                case 93090393:
                    if (string.equals("array")) {
                        return new DivVariableTemplate.Array(this.component.getArrayVariableJsonTemplateParser().getValue().deserialize(context, (ArrayVariableTemplate) (divVariableTemplate != null ? divVariableTemplate.value() : null), data));
                    }
                    break;
                case 94842723:
                    if (string.equals("color")) {
                        return new DivVariableTemplate.Color(this.component.getColorVariableJsonTemplateParser().getValue().deserialize(context, (ColorVariableTemplate) (divVariableTemplate != null ? divVariableTemplate.value() : null), data));
                    }
                    break;
                case 1958052158:
                    if (string.equals("integer")) {
                        return new DivVariableTemplate.Integer(this.component.getIntegerVariableJsonTemplateParser().getValue().deserialize(context, (IntegerVariableTemplate) (divVariableTemplate != null ? divVariableTemplate.value() : null), data));
                    }
                    break;
            }
            throw ParsingExceptionKt.typeMismatch(data, "type", string);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivVariableTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof DivVariableTemplate.Str) {
                return this.component.getStrVariableJsonTemplateParser().getValue().serialize(context, ((DivVariableTemplate.Str) value).getValue());
            }
            if (value instanceof DivVariableTemplate.Number) {
                return this.component.getNumberVariableJsonTemplateParser().getValue().serialize(context, ((DivVariableTemplate.Number) value).getValue());
            }
            if (value instanceof DivVariableTemplate.Integer) {
                return this.component.getIntegerVariableJsonTemplateParser().getValue().serialize(context, ((DivVariableTemplate.Integer) value).getValue());
            }
            if (value instanceof DivVariableTemplate.Bool) {
                return this.component.getBoolVariableJsonTemplateParser().getValue().serialize(context, ((DivVariableTemplate.Bool) value).getValue());
            }
            if (value instanceof DivVariableTemplate.Color) {
                return this.component.getColorVariableJsonTemplateParser().getValue().serialize(context, ((DivVariableTemplate.Color) value).getValue());
            }
            if (value instanceof DivVariableTemplate.Url) {
                return this.component.getUrlVariableJsonTemplateParser().getValue().serialize(context, ((DivVariableTemplate.Url) value).getValue());
            }
            if (value instanceof DivVariableTemplate.Dict) {
                return this.component.getDictVariableJsonTemplateParser().getValue().serialize(context, ((DivVariableTemplate.Dict) value).getValue());
            }
            if (value instanceof DivVariableTemplate.Array) {
                return this.component.getArrayVariableJsonTemplateParser().getValue().serialize(context, ((DivVariableTemplate.Array) value).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: DivVariableJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivVariableJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivVariableTemplate;", "Lcom/yandex/div2/DivVariable;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivVariableTemplate, DivVariable> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivVariable resolve(ParsingContext context, DivVariableTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            if (template instanceof DivVariableTemplate.Str) {
                return new DivVariable.Str(this.component.getStrVariableJsonTemplateResolver().getValue().resolve(context, ((DivVariableTemplate.Str) template).getValue(), data));
            }
            if (template instanceof DivVariableTemplate.Number) {
                return new DivVariable.Number(this.component.getNumberVariableJsonTemplateResolver().getValue().resolve(context, ((DivVariableTemplate.Number) template).getValue(), data));
            }
            if (template instanceof DivVariableTemplate.Integer) {
                return new DivVariable.Integer(this.component.getIntegerVariableJsonTemplateResolver().getValue().resolve(context, ((DivVariableTemplate.Integer) template).getValue(), data));
            }
            if (template instanceof DivVariableTemplate.Bool) {
                return new DivVariable.Bool(this.component.getBoolVariableJsonTemplateResolver().getValue().resolve(context, ((DivVariableTemplate.Bool) template).getValue(), data));
            }
            if (template instanceof DivVariableTemplate.Color) {
                return new DivVariable.Color(this.component.getColorVariableJsonTemplateResolver().getValue().resolve(context, ((DivVariableTemplate.Color) template).getValue(), data));
            }
            if (template instanceof DivVariableTemplate.Url) {
                return new DivVariable.Url(this.component.getUrlVariableJsonTemplateResolver().getValue().resolve(context, ((DivVariableTemplate.Url) template).getValue(), data));
            }
            if (template instanceof DivVariableTemplate.Dict) {
                return new DivVariable.Dict(this.component.getDictVariableJsonTemplateResolver().getValue().resolve(context, ((DivVariableTemplate.Dict) template).getValue(), data));
            }
            if (template instanceof DivVariableTemplate.Array) {
                return new DivVariable.Array(this.component.getArrayVariableJsonTemplateResolver().getValue().resolve(context, ((DivVariableTemplate.Array) template).getValue(), data));
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
