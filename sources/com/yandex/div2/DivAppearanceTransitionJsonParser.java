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

/* JADX INFO: compiled from: DivAppearanceTransitionJsonParser.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0003\u0005\u0006\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yandex/div2/DivAppearanceTransitionJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivAppearanceTransitionJsonParser {
    private final JsonParserComponent component;

    public DivAppearanceTransitionJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivAppearanceTransitionJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivAppearanceTransitionJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivAppearanceTransition;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivAppearanceTransition> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.yandex.div.serialization.Deserializer
        public DivAppearanceTransition deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            String string = JsonPropertyParser.readString(context, data, "type");
            Intrinsics.checkNotNullExpressionValue(string, "readString(context, data, \"type\")");
            switch (string.hashCode()) {
                case 113762:
                    if (string.equals("set")) {
                        return new DivAppearanceTransition.Set(this.component.getDivAppearanceSetTransitionJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 3135100:
                    if (string.equals("fade")) {
                        return new DivAppearanceTransition.Fade(this.component.getDivFadeTransitionJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 109250890:
                    if (string.equals("scale")) {
                        return new DivAppearanceTransition.Scale(this.component.getDivScaleTransitionJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 109526449:
                    if (string.equals("slide")) {
                        return new DivAppearanceTransition.Slide(this.component.getDivSlideTransitionJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
            }
            EntityTemplate orThrow = context.getTemplates().getOrThrow(string, data);
            DivAppearanceTransitionTemplate divAppearanceTransitionTemplate = orThrow instanceof DivAppearanceTransitionTemplate ? (DivAppearanceTransitionTemplate) orThrow : null;
            if (divAppearanceTransitionTemplate != null) {
                return this.component.getDivAppearanceTransitionJsonTemplateResolver().getValue().resolve(context, divAppearanceTransitionTemplate, data);
            }
            throw ParsingExceptionKt.typeMismatch(data, "type", string);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivAppearanceTransition value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof DivAppearanceTransition.Set) {
                return this.component.getDivAppearanceSetTransitionJsonEntityParser().getValue().serialize(context, ((DivAppearanceTransition.Set) value).getValue());
            }
            if (value instanceof DivAppearanceTransition.Fade) {
                return this.component.getDivFadeTransitionJsonEntityParser().getValue().serialize(context, ((DivAppearanceTransition.Fade) value).getValue());
            }
            if (value instanceof DivAppearanceTransition.Scale) {
                return this.component.getDivScaleTransitionJsonEntityParser().getValue().serialize(context, ((DivAppearanceTransition.Scale) value).getValue());
            }
            if (value instanceof DivAppearanceTransition.Slide) {
                return this.component.getDivSlideTransitionJsonEntityParser().getValue().serialize(context, ((DivAppearanceTransition.Slide) value).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: DivAppearanceTransitionJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivAppearanceTransitionJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivAppearanceTransitionTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements Parser<JSONObject, DivAppearanceTransitionTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.yandex.div.serialization.Deserializer
        public DivAppearanceTransitionTemplate deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            String type;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            String string = JsonPropertyParser.readString(context, data, "type");
            Intrinsics.checkNotNullExpressionValue(string, "readString(context, data, \"type\")");
            EntityTemplate entityTemplate = context.getTemplates().get(string);
            DivAppearanceTransitionTemplate divAppearanceTransitionTemplate = entityTemplate instanceof DivAppearanceTransitionTemplate ? (DivAppearanceTransitionTemplate) entityTemplate : null;
            if (divAppearanceTransitionTemplate != null && (type = divAppearanceTransitionTemplate.getType()) != null) {
                string = type;
            }
            switch (string.hashCode()) {
                case 113762:
                    if (string.equals("set")) {
                        return new DivAppearanceTransitionTemplate.Set(this.component.getDivAppearanceSetTransitionJsonTemplateParser().getValue().deserialize(context, (DivAppearanceSetTransitionTemplate) (divAppearanceTransitionTemplate != null ? divAppearanceTransitionTemplate.value() : null), data));
                    }
                    break;
                case 3135100:
                    if (string.equals("fade")) {
                        return new DivAppearanceTransitionTemplate.Fade(this.component.getDivFadeTransitionJsonTemplateParser().getValue().deserialize(context, (DivFadeTransitionTemplate) (divAppearanceTransitionTemplate != null ? divAppearanceTransitionTemplate.value() : null), data));
                    }
                    break;
                case 109250890:
                    if (string.equals("scale")) {
                        return new DivAppearanceTransitionTemplate.Scale(this.component.getDivScaleTransitionJsonTemplateParser().getValue().deserialize(context, (DivScaleTransitionTemplate) (divAppearanceTransitionTemplate != null ? divAppearanceTransitionTemplate.value() : null), data));
                    }
                    break;
                case 109526449:
                    if (string.equals("slide")) {
                        return new DivAppearanceTransitionTemplate.Slide(this.component.getDivSlideTransitionJsonTemplateParser().getValue().deserialize(context, (DivSlideTransitionTemplate) (divAppearanceTransitionTemplate != null ? divAppearanceTransitionTemplate.value() : null), data));
                    }
                    break;
            }
            throw ParsingExceptionKt.typeMismatch(data, "type", string);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivAppearanceTransitionTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof DivAppearanceTransitionTemplate.Set) {
                return this.component.getDivAppearanceSetTransitionJsonTemplateParser().getValue().serialize(context, ((DivAppearanceTransitionTemplate.Set) value).getValue());
            }
            if (value instanceof DivAppearanceTransitionTemplate.Fade) {
                return this.component.getDivFadeTransitionJsonTemplateParser().getValue().serialize(context, ((DivAppearanceTransitionTemplate.Fade) value).getValue());
            }
            if (value instanceof DivAppearanceTransitionTemplate.Scale) {
                return this.component.getDivScaleTransitionJsonTemplateParser().getValue().serialize(context, ((DivAppearanceTransitionTemplate.Scale) value).getValue());
            }
            if (value instanceof DivAppearanceTransitionTemplate.Slide) {
                return this.component.getDivSlideTransitionJsonTemplateParser().getValue().serialize(context, ((DivAppearanceTransitionTemplate.Slide) value).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: DivAppearanceTransitionJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivAppearanceTransitionJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivAppearanceTransitionTemplate;", "Lcom/yandex/div2/DivAppearanceTransition;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivAppearanceTransitionTemplate, DivAppearanceTransition> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivAppearanceTransition resolve(ParsingContext context, DivAppearanceTransitionTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            if (template instanceof DivAppearanceTransitionTemplate.Set) {
                return new DivAppearanceTransition.Set(this.component.getDivAppearanceSetTransitionJsonTemplateResolver().getValue().resolve(context, ((DivAppearanceTransitionTemplate.Set) template).getValue(), data));
            }
            if (template instanceof DivAppearanceTransitionTemplate.Fade) {
                return new DivAppearanceTransition.Fade(this.component.getDivFadeTransitionJsonTemplateResolver().getValue().resolve(context, ((DivAppearanceTransitionTemplate.Fade) template).getValue(), data));
            }
            if (template instanceof DivAppearanceTransitionTemplate.Scale) {
                return new DivAppearanceTransition.Scale(this.component.getDivScaleTransitionJsonTemplateResolver().getValue().resolve(context, ((DivAppearanceTransitionTemplate.Scale) template).getValue(), data));
            }
            if (template instanceof DivAppearanceTransitionTemplate.Slide) {
                return new DivAppearanceTransition.Slide(this.component.getDivSlideTransitionJsonTemplateResolver().getValue().resolve(context, ((DivAppearanceTransitionTemplate.Slide) template).getValue(), data));
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
