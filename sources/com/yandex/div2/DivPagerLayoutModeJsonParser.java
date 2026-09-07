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

/* JADX INFO: compiled from: DivPagerLayoutModeJsonParser.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0003\u0005\u0006\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yandex/div2/DivPagerLayoutModeJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivPagerLayoutModeJsonParser {
    private final JsonParserComponent component;

    public DivPagerLayoutModeJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivPagerLayoutModeJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivPagerLayoutModeJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivPagerLayoutMode;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivPagerLayoutMode> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivPagerLayoutMode deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            String string = JsonPropertyParser.readString(context, data, "type");
            Intrinsics.checkNotNullExpressionValue(string, "readString(context, data, \"type\")");
            int iHashCode = string.hashCode();
            if (iHashCode != -921832806) {
                if (iHashCode != 97445748) {
                    if (iHashCode == 343327108 && string.equals("wrap_content")) {
                        return new DivPagerLayoutMode.PageContentSize(this.component.getDivPageContentSizeJsonEntityParser().getValue().deserialize(context, data));
                    }
                } else if (string.equals("fixed")) {
                    return new DivPagerLayoutMode.NeighbourPageSize(this.component.getDivNeighbourPageSizeJsonEntityParser().getValue().deserialize(context, data));
                }
            } else if (string.equals("percentage")) {
                return new DivPagerLayoutMode.PageSize(this.component.getDivPageSizeJsonEntityParser().getValue().deserialize(context, data));
            }
            EntityTemplate orThrow = context.getTemplates().getOrThrow(string, data);
            DivPagerLayoutModeTemplate divPagerLayoutModeTemplate = orThrow instanceof DivPagerLayoutModeTemplate ? (DivPagerLayoutModeTemplate) orThrow : null;
            if (divPagerLayoutModeTemplate != null) {
                return this.component.getDivPagerLayoutModeJsonTemplateResolver().getValue().resolve(context, divPagerLayoutModeTemplate, data);
            }
            throw ParsingExceptionKt.typeMismatch(data, "type", string);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivPagerLayoutMode value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof DivPagerLayoutMode.PageSize) {
                return this.component.getDivPageSizeJsonEntityParser().getValue().serialize(context, ((DivPagerLayoutMode.PageSize) value).getValue());
            }
            if (value instanceof DivPagerLayoutMode.NeighbourPageSize) {
                return this.component.getDivNeighbourPageSizeJsonEntityParser().getValue().serialize(context, ((DivPagerLayoutMode.NeighbourPageSize) value).getValue());
            }
            if (value instanceof DivPagerLayoutMode.PageContentSize) {
                return this.component.getDivPageContentSizeJsonEntityParser().getValue().serialize(context, ((DivPagerLayoutMode.PageContentSize) value).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: DivPagerLayoutModeJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivPagerLayoutModeJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivPagerLayoutModeTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements Parser<JSONObject, DivPagerLayoutModeTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivPagerLayoutModeTemplate deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            String type;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            String string = JsonPropertyParser.readString(context, data, "type");
            Intrinsics.checkNotNullExpressionValue(string, "readString(context, data, \"type\")");
            EntityTemplate entityTemplate = context.getTemplates().get(string);
            DivPagerLayoutModeTemplate divPagerLayoutModeTemplate = entityTemplate instanceof DivPagerLayoutModeTemplate ? (DivPagerLayoutModeTemplate) entityTemplate : null;
            if (divPagerLayoutModeTemplate != null && (type = divPagerLayoutModeTemplate.getType()) != null) {
                string = type;
            }
            int iHashCode = string.hashCode();
            if (iHashCode != -921832806) {
                if (iHashCode != 97445748) {
                    if (iHashCode == 343327108 && string.equals("wrap_content")) {
                        return new DivPagerLayoutModeTemplate.PageContentSize(this.component.getDivPageContentSizeJsonTemplateParser().getValue().deserialize(context, (DivPageContentSizeTemplate) (divPagerLayoutModeTemplate != null ? divPagerLayoutModeTemplate.value() : null), data));
                    }
                } else if (string.equals("fixed")) {
                    return new DivPagerLayoutModeTemplate.NeighbourPageSize(this.component.getDivNeighbourPageSizeJsonTemplateParser().getValue().deserialize(context, (DivNeighbourPageSizeTemplate) (divPagerLayoutModeTemplate != null ? divPagerLayoutModeTemplate.value() : null), data));
                }
            } else if (string.equals("percentage")) {
                return new DivPagerLayoutModeTemplate.PageSize(this.component.getDivPageSizeJsonTemplateParser().getValue().deserialize(context, (DivPageSizeTemplate) (divPagerLayoutModeTemplate != null ? divPagerLayoutModeTemplate.value() : null), data));
            }
            throw ParsingExceptionKt.typeMismatch(data, "type", string);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivPagerLayoutModeTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof DivPagerLayoutModeTemplate.PageSize) {
                return this.component.getDivPageSizeJsonTemplateParser().getValue().serialize(context, ((DivPagerLayoutModeTemplate.PageSize) value).getValue());
            }
            if (value instanceof DivPagerLayoutModeTemplate.NeighbourPageSize) {
                return this.component.getDivNeighbourPageSizeJsonTemplateParser().getValue().serialize(context, ((DivPagerLayoutModeTemplate.NeighbourPageSize) value).getValue());
            }
            if (value instanceof DivPagerLayoutModeTemplate.PageContentSize) {
                return this.component.getDivPageContentSizeJsonTemplateParser().getValue().serialize(context, ((DivPagerLayoutModeTemplate.PageContentSize) value).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: DivPagerLayoutModeJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivPagerLayoutModeJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivPagerLayoutModeTemplate;", "Lcom/yandex/div2/DivPagerLayoutMode;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivPagerLayoutModeTemplate, DivPagerLayoutMode> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivPagerLayoutMode resolve(ParsingContext context, DivPagerLayoutModeTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            if (template instanceof DivPagerLayoutModeTemplate.PageSize) {
                return new DivPagerLayoutMode.PageSize(this.component.getDivPageSizeJsonTemplateResolver().getValue().resolve(context, ((DivPagerLayoutModeTemplate.PageSize) template).getValue(), data));
            }
            if (template instanceof DivPagerLayoutModeTemplate.NeighbourPageSize) {
                return new DivPagerLayoutMode.NeighbourPageSize(this.component.getDivNeighbourPageSizeJsonTemplateResolver().getValue().resolve(context, ((DivPagerLayoutModeTemplate.NeighbourPageSize) template).getValue(), data));
            }
            if (template instanceof DivPagerLayoutModeTemplate.PageContentSize) {
                return new DivPagerLayoutMode.PageContentSize(this.component.getDivPageContentSizeJsonTemplateResolver().getValue().resolve(context, ((DivPagerLayoutModeTemplate.PageContentSize) template).getValue(), data));
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
