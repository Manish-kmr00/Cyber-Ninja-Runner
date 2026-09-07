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

/* JADX INFO: compiled from: DivBackgroundJsonParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0003\u0005\u0006\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yandex/div2/DivBackgroundJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivBackgroundJsonParser {
    private final JsonParserComponent component;

    public DivBackgroundJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivBackgroundJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivBackgroundJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivBackground;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivBackground> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.yandex.div.serialization.Deserializer
        public DivBackground deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            String string = JsonPropertyParser.readString(context, data, "type");
            Intrinsics.checkNotNullExpressionValue(string, "readString(context, data, \"type\")");
            switch (string.hashCode()) {
                case -30518633:
                    if (string.equals("nine_patch_image")) {
                        return new DivBackground.NinePatch(this.component.getDivNinePatchBackgroundJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 89650992:
                    if (string.equals("gradient")) {
                        return new DivBackground.LinearGradient(this.component.getDivLinearGradientJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 100313435:
                    if (string.equals("image")) {
                        return new DivBackground.Image(this.component.getDivImageBackgroundJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 109618859:
                    if (string.equals("solid")) {
                        return new DivBackground.Solid(this.component.getDivSolidBackgroundJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 1881846096:
                    if (string.equals("radial_gradient")) {
                        return new DivBackground.RadialGradient(this.component.getDivRadialGradientJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
            }
            EntityTemplate orThrow = context.getTemplates().getOrThrow(string, data);
            DivBackgroundTemplate divBackgroundTemplate = orThrow instanceof DivBackgroundTemplate ? (DivBackgroundTemplate) orThrow : null;
            if (divBackgroundTemplate != null) {
                return this.component.getDivBackgroundJsonTemplateResolver().getValue().resolve(context, divBackgroundTemplate, data);
            }
            throw ParsingExceptionKt.typeMismatch(data, "type", string);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivBackground value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof DivBackground.LinearGradient) {
                return this.component.getDivLinearGradientJsonEntityParser().getValue().serialize(context, ((DivBackground.LinearGradient) value).getValue());
            }
            if (value instanceof DivBackground.RadialGradient) {
                return this.component.getDivRadialGradientJsonEntityParser().getValue().serialize(context, ((DivBackground.RadialGradient) value).getValue());
            }
            if (value instanceof DivBackground.Image) {
                return this.component.getDivImageBackgroundJsonEntityParser().getValue().serialize(context, ((DivBackground.Image) value).getValue());
            }
            if (value instanceof DivBackground.Solid) {
                return this.component.getDivSolidBackgroundJsonEntityParser().getValue().serialize(context, ((DivBackground.Solid) value).getValue());
            }
            if (value instanceof DivBackground.NinePatch) {
                return this.component.getDivNinePatchBackgroundJsonEntityParser().getValue().serialize(context, ((DivBackground.NinePatch) value).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: DivBackgroundJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivBackgroundJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivBackgroundTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements Parser<JSONObject, DivBackgroundTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.yandex.div.serialization.Deserializer
        public DivBackgroundTemplate deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            String type;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            String string = JsonPropertyParser.readString(context, data, "type");
            Intrinsics.checkNotNullExpressionValue(string, "readString(context, data, \"type\")");
            EntityTemplate entityTemplate = context.getTemplates().get(string);
            DivBackgroundTemplate divBackgroundTemplate = entityTemplate instanceof DivBackgroundTemplate ? (DivBackgroundTemplate) entityTemplate : null;
            if (divBackgroundTemplate != null && (type = divBackgroundTemplate.getType()) != null) {
                string = type;
            }
            switch (string.hashCode()) {
                case -30518633:
                    if (string.equals("nine_patch_image")) {
                        return new DivBackgroundTemplate.NinePatch(this.component.getDivNinePatchBackgroundJsonTemplateParser().getValue().deserialize(context, (DivNinePatchBackgroundTemplate) (divBackgroundTemplate != null ? divBackgroundTemplate.value() : null), data));
                    }
                    break;
                case 89650992:
                    if (string.equals("gradient")) {
                        return new DivBackgroundTemplate.LinearGradient(this.component.getDivLinearGradientJsonTemplateParser().getValue().deserialize(context, (DivLinearGradientTemplate) (divBackgroundTemplate != null ? divBackgroundTemplate.value() : null), data));
                    }
                    break;
                case 100313435:
                    if (string.equals("image")) {
                        return new DivBackgroundTemplate.Image(this.component.getDivImageBackgroundJsonTemplateParser().getValue().deserialize(context, (DivImageBackgroundTemplate) (divBackgroundTemplate != null ? divBackgroundTemplate.value() : null), data));
                    }
                    break;
                case 109618859:
                    if (string.equals("solid")) {
                        return new DivBackgroundTemplate.Solid(this.component.getDivSolidBackgroundJsonTemplateParser().getValue().deserialize(context, (DivSolidBackgroundTemplate) (divBackgroundTemplate != null ? divBackgroundTemplate.value() : null), data));
                    }
                    break;
                case 1881846096:
                    if (string.equals("radial_gradient")) {
                        return new DivBackgroundTemplate.RadialGradient(this.component.getDivRadialGradientJsonTemplateParser().getValue().deserialize(context, (DivRadialGradientTemplate) (divBackgroundTemplate != null ? divBackgroundTemplate.value() : null), data));
                    }
                    break;
            }
            throw ParsingExceptionKt.typeMismatch(data, "type", string);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivBackgroundTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof DivBackgroundTemplate.LinearGradient) {
                return this.component.getDivLinearGradientJsonTemplateParser().getValue().serialize(context, ((DivBackgroundTemplate.LinearGradient) value).getValue());
            }
            if (value instanceof DivBackgroundTemplate.RadialGradient) {
                return this.component.getDivRadialGradientJsonTemplateParser().getValue().serialize(context, ((DivBackgroundTemplate.RadialGradient) value).getValue());
            }
            if (value instanceof DivBackgroundTemplate.Image) {
                return this.component.getDivImageBackgroundJsonTemplateParser().getValue().serialize(context, ((DivBackgroundTemplate.Image) value).getValue());
            }
            if (value instanceof DivBackgroundTemplate.Solid) {
                return this.component.getDivSolidBackgroundJsonTemplateParser().getValue().serialize(context, ((DivBackgroundTemplate.Solid) value).getValue());
            }
            if (value instanceof DivBackgroundTemplate.NinePatch) {
                return this.component.getDivNinePatchBackgroundJsonTemplateParser().getValue().serialize(context, ((DivBackgroundTemplate.NinePatch) value).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: DivBackgroundJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivBackgroundJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivBackgroundTemplate;", "Lcom/yandex/div2/DivBackground;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivBackgroundTemplate, DivBackground> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivBackground resolve(ParsingContext context, DivBackgroundTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            if (template instanceof DivBackgroundTemplate.LinearGradient) {
                return new DivBackground.LinearGradient(this.component.getDivLinearGradientJsonTemplateResolver().getValue().resolve(context, ((DivBackgroundTemplate.LinearGradient) template).getValue(), data));
            }
            if (template instanceof DivBackgroundTemplate.RadialGradient) {
                return new DivBackground.RadialGradient(this.component.getDivRadialGradientJsonTemplateResolver().getValue().resolve(context, ((DivBackgroundTemplate.RadialGradient) template).getValue(), data));
            }
            if (template instanceof DivBackgroundTemplate.Image) {
                return new DivBackground.Image(this.component.getDivImageBackgroundJsonTemplateResolver().getValue().resolve(context, ((DivBackgroundTemplate.Image) template).getValue(), data));
            }
            if (template instanceof DivBackgroundTemplate.Solid) {
                return new DivBackground.Solid(this.component.getDivSolidBackgroundJsonTemplateResolver().getValue().resolve(context, ((DivBackgroundTemplate.Solid) template).getValue(), data));
            }
            if (template instanceof DivBackgroundTemplate.NinePatch) {
                return new DivBackground.NinePatch(this.component.getDivNinePatchBackgroundJsonTemplateResolver().getValue().resolve(context, ((DivBackgroundTemplate.NinePatch) template).getValue(), data));
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
