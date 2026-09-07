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

/* JADX INFO: compiled from: DivJsonParser.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0003\u0005\u0006\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yandex/div2/DivJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivJsonParser {
    private final JsonParserComponent component;

    public DivJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/Div;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, Div> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.yandex.div.serialization.Deserializer
        public Div deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            String string = JsonPropertyParser.readString(context, data, "type");
            Intrinsics.checkNotNullExpressionValue(string, "readString(context, data, \"type\")");
            switch (string.hashCode()) {
                case -1349088399:
                    if (string.equals("custom")) {
                        return new Div.Custom(this.component.getDivCustomJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case -906021636:
                    if (string.equals("select")) {
                        return new Div.Select(this.component.getDivSelectJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case -899647263:
                    if (string.equals("slider")) {
                        return new Div.Slider(this.component.getDivSliderJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case -889473228:
                    if (string.equals("switch")) {
                        return new Div.Switch(this.component.getDivSwitchJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case -711999985:
                    if (string.equals("indicator")) {
                        return new Div.Indicator(this.component.getDivIndicatorJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case -410956671:
                    if (string.equals("container")) {
                        return new Div.Container(this.component.getDivContainerJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case -196315310:
                    if (string.equals("gallery")) {
                        return new Div.Gallery(this.component.getDivGalleryJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 102340:
                    if (string.equals("gif")) {
                        return new Div.GifImage(this.component.getDivGifImageJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 3181382:
                    if (string.equals("grid")) {
                        return new Div.Grid(this.component.getDivGridJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 3552126:
                    if (string.equals("tabs")) {
                        return new Div.Tabs(this.component.getDivTabsJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 3556653:
                    if (string.equals("text")) {
                        return new Div.Text(this.component.getDivTextJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 100313435:
                    if (string.equals("image")) {
                        return new Div.Image(this.component.getDivImageJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 100358090:
                    if (string.equals("input")) {
                        return new Div.Input(this.component.getDivInputJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 106426307:
                    if (string.equals("pager")) {
                        return new Div.Pager(this.component.getDivPagerJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 109757585:
                    if (string.equals("state")) {
                        return new Div.State(this.component.getDivStateJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 112202875:
                    if (string.equals("video")) {
                        return new Div.Video(this.component.getDivVideoJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
                case 1732829925:
                    if (string.equals("separator")) {
                        return new Div.Separator(this.component.getDivSeparatorJsonEntityParser().getValue().deserialize(context, data));
                    }
                    break;
            }
            EntityTemplate orThrow = context.getTemplates().getOrThrow(string, data);
            DivTemplate divTemplate = orThrow instanceof DivTemplate ? (DivTemplate) orThrow : null;
            if (divTemplate != null) {
                return this.component.getDivJsonTemplateResolver().getValue().resolve(context, divTemplate, data);
            }
            throw ParsingExceptionKt.typeMismatch(data, "type", string);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, Div value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof Div.Image) {
                return this.component.getDivImageJsonEntityParser().getValue().serialize(context, ((Div.Image) value).getValue());
            }
            if (value instanceof Div.GifImage) {
                return this.component.getDivGifImageJsonEntityParser().getValue().serialize(context, ((Div.GifImage) value).getValue());
            }
            if (value instanceof Div.Text) {
                return this.component.getDivTextJsonEntityParser().getValue().serialize(context, ((Div.Text) value).getValue());
            }
            if (value instanceof Div.Separator) {
                return this.component.getDivSeparatorJsonEntityParser().getValue().serialize(context, ((Div.Separator) value).getValue());
            }
            if (value instanceof Div.Container) {
                return this.component.getDivContainerJsonEntityParser().getValue().serialize(context, ((Div.Container) value).getValue());
            }
            if (value instanceof Div.Grid) {
                return this.component.getDivGridJsonEntityParser().getValue().serialize(context, ((Div.Grid) value).getValue());
            }
            if (value instanceof Div.Gallery) {
                return this.component.getDivGalleryJsonEntityParser().getValue().serialize(context, ((Div.Gallery) value).getValue());
            }
            if (value instanceof Div.Pager) {
                return this.component.getDivPagerJsonEntityParser().getValue().serialize(context, ((Div.Pager) value).getValue());
            }
            if (value instanceof Div.Tabs) {
                return this.component.getDivTabsJsonEntityParser().getValue().serialize(context, ((Div.Tabs) value).getValue());
            }
            if (value instanceof Div.State) {
                return this.component.getDivStateJsonEntityParser().getValue().serialize(context, ((Div.State) value).getValue());
            }
            if (value instanceof Div.Custom) {
                return this.component.getDivCustomJsonEntityParser().getValue().serialize(context, ((Div.Custom) value).getValue());
            }
            if (value instanceof Div.Indicator) {
                return this.component.getDivIndicatorJsonEntityParser().getValue().serialize(context, ((Div.Indicator) value).getValue());
            }
            if (value instanceof Div.Slider) {
                return this.component.getDivSliderJsonEntityParser().getValue().serialize(context, ((Div.Slider) value).getValue());
            }
            if (value instanceof Div.Switch) {
                return this.component.getDivSwitchJsonEntityParser().getValue().serialize(context, ((Div.Switch) value).getValue());
            }
            if (value instanceof Div.Input) {
                return this.component.getDivInputJsonEntityParser().getValue().serialize(context, ((Div.Input) value).getValue());
            }
            if (value instanceof Div.Select) {
                return this.component.getDivSelectJsonEntityParser().getValue().serialize(context, ((Div.Select) value).getValue());
            }
            if (value instanceof Div.Video) {
                return this.component.getDivVideoJsonEntityParser().getValue().serialize(context, ((Div.Video) value).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: DivJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements Parser<JSONObject, DivTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.yandex.div.serialization.Deserializer
        public DivTemplate deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            String type;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            String string = JsonPropertyParser.readString(context, data, "type");
            Intrinsics.checkNotNullExpressionValue(string, "readString(context, data, \"type\")");
            EntityTemplate entityTemplate = context.getTemplates().get(string);
            DivTemplate divTemplate = entityTemplate instanceof DivTemplate ? (DivTemplate) entityTemplate : null;
            if (divTemplate != null && (type = divTemplate.getType()) != null) {
                string = type;
            }
            switch (string.hashCode()) {
                case -1349088399:
                    if (string.equals("custom")) {
                        return new DivTemplate.Custom(this.component.getDivCustomJsonTemplateParser().getValue().deserialize(context, (DivCustomTemplate) (divTemplate != null ? divTemplate.value() : null), data));
                    }
                    break;
                case -906021636:
                    if (string.equals("select")) {
                        return new DivTemplate.Select(this.component.getDivSelectJsonTemplateParser().getValue().deserialize(context, (DivSelectTemplate) (divTemplate != null ? divTemplate.value() : null), data));
                    }
                    break;
                case -899647263:
                    if (string.equals("slider")) {
                        return new DivTemplate.Slider(this.component.getDivSliderJsonTemplateParser().getValue().deserialize(context, (DivSliderTemplate) (divTemplate != null ? divTemplate.value() : null), data));
                    }
                    break;
                case -889473228:
                    if (string.equals("switch")) {
                        return new DivTemplate.Switch(this.component.getDivSwitchJsonTemplateParser().getValue().deserialize(context, (DivSwitchTemplate) (divTemplate != null ? divTemplate.value() : null), data));
                    }
                    break;
                case -711999985:
                    if (string.equals("indicator")) {
                        return new DivTemplate.Indicator(this.component.getDivIndicatorJsonTemplateParser().getValue().deserialize(context, (DivIndicatorTemplate) (divTemplate != null ? divTemplate.value() : null), data));
                    }
                    break;
                case -410956671:
                    if (string.equals("container")) {
                        return new DivTemplate.Container(this.component.getDivContainerJsonTemplateParser().getValue().deserialize(context, (DivContainerTemplate) (divTemplate != null ? divTemplate.value() : null), data));
                    }
                    break;
                case -196315310:
                    if (string.equals("gallery")) {
                        return new DivTemplate.Gallery(this.component.getDivGalleryJsonTemplateParser().getValue().deserialize(context, (DivGalleryTemplate) (divTemplate != null ? divTemplate.value() : null), data));
                    }
                    break;
                case 102340:
                    if (string.equals("gif")) {
                        return new DivTemplate.GifImage(this.component.getDivGifImageJsonTemplateParser().getValue().deserialize(context, (DivGifImageTemplate) (divTemplate != null ? divTemplate.value() : null), data));
                    }
                    break;
                case 3181382:
                    if (string.equals("grid")) {
                        return new DivTemplate.Grid(this.component.getDivGridJsonTemplateParser().getValue().deserialize(context, (DivGridTemplate) (divTemplate != null ? divTemplate.value() : null), data));
                    }
                    break;
                case 3552126:
                    if (string.equals("tabs")) {
                        return new DivTemplate.Tabs(this.component.getDivTabsJsonTemplateParser().getValue().deserialize(context, (DivTabsTemplate) (divTemplate != null ? divTemplate.value() : null), data));
                    }
                    break;
                case 3556653:
                    if (string.equals("text")) {
                        return new DivTemplate.Text(this.component.getDivTextJsonTemplateParser().getValue().deserialize(context, (DivTextTemplate) (divTemplate != null ? divTemplate.value() : null), data));
                    }
                    break;
                case 100313435:
                    if (string.equals("image")) {
                        return new DivTemplate.Image(this.component.getDivImageJsonTemplateParser().getValue().deserialize(context, (DivImageTemplate) (divTemplate != null ? divTemplate.value() : null), data));
                    }
                    break;
                case 100358090:
                    if (string.equals("input")) {
                        return new DivTemplate.Input(this.component.getDivInputJsonTemplateParser().getValue().deserialize(context, (DivInputTemplate) (divTemplate != null ? divTemplate.value() : null), data));
                    }
                    break;
                case 106426307:
                    if (string.equals("pager")) {
                        return new DivTemplate.Pager(this.component.getDivPagerJsonTemplateParser().getValue().deserialize(context, (DivPagerTemplate) (divTemplate != null ? divTemplate.value() : null), data));
                    }
                    break;
                case 109757585:
                    if (string.equals("state")) {
                        return new DivTemplate.State(this.component.getDivStateJsonTemplateParser().getValue().deserialize(context, (DivStateTemplate) (divTemplate != null ? divTemplate.value() : null), data));
                    }
                    break;
                case 112202875:
                    if (string.equals("video")) {
                        return new DivTemplate.Video(this.component.getDivVideoJsonTemplateParser().getValue().deserialize(context, (DivVideoTemplate) (divTemplate != null ? divTemplate.value() : null), data));
                    }
                    break;
                case 1732829925:
                    if (string.equals("separator")) {
                        return new DivTemplate.Separator(this.component.getDivSeparatorJsonTemplateParser().getValue().deserialize(context, (DivSeparatorTemplate) (divTemplate != null ? divTemplate.value() : null), data));
                    }
                    break;
            }
            throw ParsingExceptionKt.typeMismatch(data, "type", string);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof DivTemplate.Image) {
                return this.component.getDivImageJsonTemplateParser().getValue().serialize(context, ((DivTemplate.Image) value).getValue());
            }
            if (value instanceof DivTemplate.GifImage) {
                return this.component.getDivGifImageJsonTemplateParser().getValue().serialize(context, ((DivTemplate.GifImage) value).getValue());
            }
            if (value instanceof DivTemplate.Text) {
                return this.component.getDivTextJsonTemplateParser().getValue().serialize(context, ((DivTemplate.Text) value).getValue());
            }
            if (value instanceof DivTemplate.Separator) {
                return this.component.getDivSeparatorJsonTemplateParser().getValue().serialize(context, ((DivTemplate.Separator) value).getValue());
            }
            if (value instanceof DivTemplate.Container) {
                return this.component.getDivContainerJsonTemplateParser().getValue().serialize(context, ((DivTemplate.Container) value).getValue());
            }
            if (value instanceof DivTemplate.Grid) {
                return this.component.getDivGridJsonTemplateParser().getValue().serialize(context, ((DivTemplate.Grid) value).getValue());
            }
            if (value instanceof DivTemplate.Gallery) {
                return this.component.getDivGalleryJsonTemplateParser().getValue().serialize(context, ((DivTemplate.Gallery) value).getValue());
            }
            if (value instanceof DivTemplate.Pager) {
                return this.component.getDivPagerJsonTemplateParser().getValue().serialize(context, ((DivTemplate.Pager) value).getValue());
            }
            if (value instanceof DivTemplate.Tabs) {
                return this.component.getDivTabsJsonTemplateParser().getValue().serialize(context, ((DivTemplate.Tabs) value).getValue());
            }
            if (value instanceof DivTemplate.State) {
                return this.component.getDivStateJsonTemplateParser().getValue().serialize(context, ((DivTemplate.State) value).getValue());
            }
            if (value instanceof DivTemplate.Custom) {
                return this.component.getDivCustomJsonTemplateParser().getValue().serialize(context, ((DivTemplate.Custom) value).getValue());
            }
            if (value instanceof DivTemplate.Indicator) {
                return this.component.getDivIndicatorJsonTemplateParser().getValue().serialize(context, ((DivTemplate.Indicator) value).getValue());
            }
            if (value instanceof DivTemplate.Slider) {
                return this.component.getDivSliderJsonTemplateParser().getValue().serialize(context, ((DivTemplate.Slider) value).getValue());
            }
            if (value instanceof DivTemplate.Switch) {
                return this.component.getDivSwitchJsonTemplateParser().getValue().serialize(context, ((DivTemplate.Switch) value).getValue());
            }
            if (value instanceof DivTemplate.Input) {
                return this.component.getDivInputJsonTemplateParser().getValue().serialize(context, ((DivTemplate.Input) value).getValue());
            }
            if (value instanceof DivTemplate.Select) {
                return this.component.getDivSelectJsonTemplateParser().getValue().serialize(context, ((DivTemplate.Select) value).getValue());
            }
            if (value instanceof DivTemplate.Video) {
                return this.component.getDivVideoJsonTemplateParser().getValue().serialize(context, ((DivTemplate.Video) value).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: DivJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTemplate;", "Lcom/yandex/div2/Div;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivTemplate, Div> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public Div resolve(ParsingContext context, DivTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            if (template instanceof DivTemplate.Image) {
                return new Div.Image(this.component.getDivImageJsonTemplateResolver().getValue().resolve(context, ((DivTemplate.Image) template).getValue(), data));
            }
            if (template instanceof DivTemplate.GifImage) {
                return new Div.GifImage(this.component.getDivGifImageJsonTemplateResolver().getValue().resolve(context, ((DivTemplate.GifImage) template).getValue(), data));
            }
            if (template instanceof DivTemplate.Text) {
                return new Div.Text(this.component.getDivTextJsonTemplateResolver().getValue().resolve(context, ((DivTemplate.Text) template).getValue(), data));
            }
            if (template instanceof DivTemplate.Separator) {
                return new Div.Separator(this.component.getDivSeparatorJsonTemplateResolver().getValue().resolve(context, ((DivTemplate.Separator) template).getValue(), data));
            }
            if (template instanceof DivTemplate.Container) {
                return new Div.Container(this.component.getDivContainerJsonTemplateResolver().getValue().resolve(context, ((DivTemplate.Container) template).getValue(), data));
            }
            if (template instanceof DivTemplate.Grid) {
                return new Div.Grid(this.component.getDivGridJsonTemplateResolver().getValue().resolve(context, ((DivTemplate.Grid) template).getValue(), data));
            }
            if (template instanceof DivTemplate.Gallery) {
                return new Div.Gallery(this.component.getDivGalleryJsonTemplateResolver().getValue().resolve(context, ((DivTemplate.Gallery) template).getValue(), data));
            }
            if (template instanceof DivTemplate.Pager) {
                return new Div.Pager(this.component.getDivPagerJsonTemplateResolver().getValue().resolve(context, ((DivTemplate.Pager) template).getValue(), data));
            }
            if (template instanceof DivTemplate.Tabs) {
                return new Div.Tabs(this.component.getDivTabsJsonTemplateResolver().getValue().resolve(context, ((DivTemplate.Tabs) template).getValue(), data));
            }
            if (template instanceof DivTemplate.State) {
                return new Div.State(this.component.getDivStateJsonTemplateResolver().getValue().resolve(context, ((DivTemplate.State) template).getValue(), data));
            }
            if (template instanceof DivTemplate.Custom) {
                return new Div.Custom(this.component.getDivCustomJsonTemplateResolver().getValue().resolve(context, ((DivTemplate.Custom) template).getValue(), data));
            }
            if (template instanceof DivTemplate.Indicator) {
                return new Div.Indicator(this.component.getDivIndicatorJsonTemplateResolver().getValue().resolve(context, ((DivTemplate.Indicator) template).getValue(), data));
            }
            if (template instanceof DivTemplate.Slider) {
                return new Div.Slider(this.component.getDivSliderJsonTemplateResolver().getValue().resolve(context, ((DivTemplate.Slider) template).getValue(), data));
            }
            if (template instanceof DivTemplate.Switch) {
                return new Div.Switch(this.component.getDivSwitchJsonTemplateResolver().getValue().resolve(context, ((DivTemplate.Switch) template).getValue(), data));
            }
            if (template instanceof DivTemplate.Input) {
                return new Div.Input(this.component.getDivInputJsonTemplateResolver().getValue().resolve(context, ((DivTemplate.Input) template).getValue(), data));
            }
            if (template instanceof DivTemplate.Select) {
                return new Div.Select(this.component.getDivSelectJsonTemplateResolver().getValue().resolve(context, ((DivTemplate.Select) template).getValue(), data));
            }
            if (template instanceof DivTemplate.Video) {
                return new Div.Video(this.component.getDivVideoJsonTemplateResolver().getValue().resolve(context, ((DivTemplate.Video) template).getValue(), data));
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
