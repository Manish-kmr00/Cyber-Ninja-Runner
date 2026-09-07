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

/* JADX INFO: compiled from: DivActionScrollDestinationJsonParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0003\u0005\u0006\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yandex/div2/DivActionScrollDestinationJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivActionScrollDestinationJsonParser {
    private final JsonParserComponent component;

    public DivActionScrollDestinationJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivActionScrollDestinationJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivActionScrollDestinationJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionScrollDestination;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivActionScrollDestination> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.yandex.div.serialization.Deserializer
        public DivActionScrollDestination deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            String string = JsonPropertyParser.readString(context, data, "type");
            Intrinsics.checkNotNullExpressionValue(string, "readString(context, data, \"type\")");
            switch (string.hashCode()) {
                case -1019779949:
                    if (string.equals("offset")) {
                        return new DivActionScrollDestination.Offset(this.component.getOffsetDestinationJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 100571:
                    if (string.equals("end")) {
                        return new DivActionScrollDestination.End(this.component.getEndDestinationJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 100346066:
                    if (string.equals("index")) {
                        return new DivActionScrollDestination.Index(this.component.getIndexDestinationJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 109757538:
                    if (string.equals("start")) {
                        return new DivActionScrollDestination.Start(this.component.getStartDestinationJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
            }
            EntityTemplate orThrow = context.getTemplates().getOrThrow(string, data);
            DivActionScrollDestinationTemplate divActionScrollDestinationTemplate = orThrow instanceof DivActionScrollDestinationTemplate ? (DivActionScrollDestinationTemplate) orThrow : null;
            if (divActionScrollDestinationTemplate != null) {
                return this.component.getDivActionScrollDestinationJsonTemplateResolver().getValue().resolve(context, divActionScrollDestinationTemplate, data);
            }
            throw ParsingExceptionKt.typeMismatch(data, "type", string);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivActionScrollDestination value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof DivActionScrollDestination.Offset) {
                return this.component.getOffsetDestinationJsonEntityParser().getValue().serialize(context, ((DivActionScrollDestination.Offset) value).getValue());
            }
            if (value instanceof DivActionScrollDestination.Index) {
                return this.component.getIndexDestinationJsonEntityParser().getValue().serialize(context, ((DivActionScrollDestination.Index) value).getValue());
            }
            if (value instanceof DivActionScrollDestination.Start) {
                return this.component.getStartDestinationJsonEntityParser().getValue().serialize(context, ((DivActionScrollDestination.Start) value).getValue());
            }
            if (value instanceof DivActionScrollDestination.End) {
                return this.component.getEndDestinationJsonEntityParser().getValue().serialize(context, ((DivActionScrollDestination.End) value).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: DivActionScrollDestinationJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivActionScrollDestinationJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionScrollDestinationTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements Parser<JSONObject, DivActionScrollDestinationTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.yandex.div.serialization.Deserializer
        public DivActionScrollDestinationTemplate deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            String type;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            String string = JsonPropertyParser.readString(context, data, "type");
            Intrinsics.checkNotNullExpressionValue(string, "readString(context, data, \"type\")");
            EntityTemplate entityTemplate = context.getTemplates().get(string);
            DivActionScrollDestinationTemplate divActionScrollDestinationTemplate = entityTemplate instanceof DivActionScrollDestinationTemplate ? (DivActionScrollDestinationTemplate) entityTemplate : null;
            if (divActionScrollDestinationTemplate != null && (type = divActionScrollDestinationTemplate.getType()) != null) {
                string = type;
            }
            switch (string.hashCode()) {
                case -1019779949:
                    if (string.equals("offset")) {
                        return new DivActionScrollDestinationTemplate.Offset(this.component.getOffsetDestinationJsonTemplateParser().getValue().deserialize(context, (OffsetDestinationTemplate) (divActionScrollDestinationTemplate != null ? divActionScrollDestinationTemplate.value() : null), data));
                    }
                    break;
                case 100571:
                    if (string.equals("end")) {
                        return new DivActionScrollDestinationTemplate.End(this.component.getEndDestinationJsonTemplateParser().getValue().deserialize(context, (EndDestinationTemplate) (divActionScrollDestinationTemplate != null ? divActionScrollDestinationTemplate.value() : null), data));
                    }
                    break;
                case 100346066:
                    if (string.equals("index")) {
                        return new DivActionScrollDestinationTemplate.Index(this.component.getIndexDestinationJsonTemplateParser().getValue().deserialize(context, (IndexDestinationTemplate) (divActionScrollDestinationTemplate != null ? divActionScrollDestinationTemplate.value() : null), data));
                    }
                    break;
                case 109757538:
                    if (string.equals("start")) {
                        return new DivActionScrollDestinationTemplate.Start(this.component.getStartDestinationJsonTemplateParser().getValue().deserialize(context, (StartDestinationTemplate) (divActionScrollDestinationTemplate != null ? divActionScrollDestinationTemplate.value() : null), data));
                    }
                    break;
            }
            throw ParsingExceptionKt.typeMismatch(data, "type", string);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivActionScrollDestinationTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof DivActionScrollDestinationTemplate.Offset) {
                return this.component.getOffsetDestinationJsonTemplateParser().getValue().serialize(context, ((DivActionScrollDestinationTemplate.Offset) value).getValue());
            }
            if (value instanceof DivActionScrollDestinationTemplate.Index) {
                return this.component.getIndexDestinationJsonTemplateParser().getValue().serialize(context, ((DivActionScrollDestinationTemplate.Index) value).getValue());
            }
            if (value instanceof DivActionScrollDestinationTemplate.Start) {
                return this.component.getStartDestinationJsonTemplateParser().getValue().serialize(context, ((DivActionScrollDestinationTemplate.Start) value).getValue());
            }
            if (value instanceof DivActionScrollDestinationTemplate.End) {
                return this.component.getEndDestinationJsonTemplateParser().getValue().serialize(context, ((DivActionScrollDestinationTemplate.End) value).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: DivActionScrollDestinationJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivActionScrollDestinationJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivActionScrollDestinationTemplate;", "Lcom/yandex/div2/DivActionScrollDestination;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivActionScrollDestinationTemplate, DivActionScrollDestination> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivActionScrollDestination resolve(ParsingContext context, DivActionScrollDestinationTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            if (template instanceof DivActionScrollDestinationTemplate.Offset) {
                return new DivActionScrollDestination.Offset(this.component.getOffsetDestinationJsonTemplateResolver().getValue().resolve(context, ((DivActionScrollDestinationTemplate.Offset) template).getValue(), data));
            }
            if (template instanceof DivActionScrollDestinationTemplate.Index) {
                return new DivActionScrollDestination.Index(this.component.getIndexDestinationJsonTemplateResolver().getValue().resolve(context, ((DivActionScrollDestinationTemplate.Index) template).getValue(), data));
            }
            if (template instanceof DivActionScrollDestinationTemplate.Start) {
                return new DivActionScrollDestination.Start(this.component.getStartDestinationJsonTemplateResolver().getValue().resolve(context, ((DivActionScrollDestinationTemplate.Start) template).getValue(), data));
            }
            if (template instanceof DivActionScrollDestinationTemplate.End) {
                return new DivActionScrollDestination.End(this.component.getEndDestinationJsonTemplateResolver().getValue().resolve(context, ((DivActionScrollDestinationTemplate.End) template).getValue(), data));
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
