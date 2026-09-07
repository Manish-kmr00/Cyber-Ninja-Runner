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

/* JADX INFO: compiled from: DivInputMaskJsonParser.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0003\u0005\u0006\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yandex/div2/DivInputMaskJsonParser;", "", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "EntityParserImpl", "TemplateParserImpl", "TemplateResolverImpl", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivInputMaskJsonParser {
    private final JsonParserComponent component;

    public DivInputMaskJsonParser(JsonParserComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.component = component;
    }

    /* JADX INFO: compiled from: DivInputMaskJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivInputMaskJsonParser$EntityParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivInputMask;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntityParserImpl implements Parser<JSONObject, DivInputMask> {
        private final JsonParserComponent component;

        public EntityParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivInputMask deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            String string = JsonPropertyParser.readString(context, data, "type");
            Intrinsics.checkNotNullExpressionValue(string, "readString(context, data, \"type\")");
            int iHashCode = string.hashCode();
            if (iHashCode != 106642798) {
                if (iHashCode != 393594385) {
                    if (iHashCode == 575402001 && string.equals("currency")) {
                        return new DivInputMask.Currency(this.component.getDivCurrencyInputMaskJsonEntityParser().getValue().deserialize(context, data));
                    }
                } else if (string.equals("fixed_length")) {
                    return new DivInputMask.FixedLength(this.component.getDivFixedLengthInputMaskJsonEntityParser().getValue().deserialize(context, data));
                }
            } else if (string.equals("phone")) {
                return new DivInputMask.Phone(this.component.getDivPhoneInputMaskJsonEntityParser().getValue().deserialize(context, data));
            }
            EntityTemplate orThrow = context.getTemplates().getOrThrow(string, data);
            DivInputMaskTemplate divInputMaskTemplate = orThrow instanceof DivInputMaskTemplate ? (DivInputMaskTemplate) orThrow : null;
            if (divInputMaskTemplate != null) {
                return this.component.getDivInputMaskJsonTemplateResolver().getValue().resolve(context, divInputMaskTemplate, data);
            }
            throw ParsingExceptionKt.typeMismatch(data, "type", string);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivInputMask value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof DivInputMask.FixedLength) {
                return this.component.getDivFixedLengthInputMaskJsonEntityParser().getValue().serialize(context, ((DivInputMask.FixedLength) value).getValue());
            }
            if (value instanceof DivInputMask.Currency) {
                return this.component.getDivCurrencyInputMaskJsonEntityParser().getValue().serialize(context, ((DivInputMask.Currency) value).getValue());
            }
            if (value instanceof DivInputMask.Phone) {
                return this.component.getDivPhoneInputMaskJsonEntityParser().getValue().serialize(context, ((DivInputMask.Phone) value).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: DivInputMaskJsonParser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivInputMaskJsonParser$TemplateParserImpl;", "Lcom/yandex/div/serialization/Parser;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivInputMaskTemplate;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "deserialize", "context", "Lcom/yandex/div/serialization/ParsingContext;", "data", "serialize", "value", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateParserImpl implements Parser<JSONObject, DivInputMaskTemplate> {
        private final JsonParserComponent component;

        public TemplateParserImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.Deserializer
        public DivInputMaskTemplate deserialize(ParsingContext context, JSONObject data) throws ParsingException {
            String type;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            String string = JsonPropertyParser.readString(context, data, "type");
            Intrinsics.checkNotNullExpressionValue(string, "readString(context, data, \"type\")");
            EntityTemplate entityTemplate = context.getTemplates().get(string);
            DivInputMaskTemplate divInputMaskTemplate = entityTemplate instanceof DivInputMaskTemplate ? (DivInputMaskTemplate) entityTemplate : null;
            if (divInputMaskTemplate != null && (type = divInputMaskTemplate.getType()) != null) {
                string = type;
            }
            int iHashCode = string.hashCode();
            if (iHashCode != 106642798) {
                if (iHashCode != 393594385) {
                    if (iHashCode == 575402001 && string.equals("currency")) {
                        return new DivInputMaskTemplate.Currency(this.component.getDivCurrencyInputMaskJsonTemplateParser().getValue().deserialize(context, (DivCurrencyInputMaskTemplate) (divInputMaskTemplate != null ? divInputMaskTemplate.value() : null), data));
                    }
                } else if (string.equals("fixed_length")) {
                    return new DivInputMaskTemplate.FixedLength(this.component.getDivFixedLengthInputMaskJsonTemplateParser().getValue().deserialize(context, (DivFixedLengthInputMaskTemplate) (divInputMaskTemplate != null ? divInputMaskTemplate.value() : null), data));
                }
            } else if (string.equals("phone")) {
                return new DivInputMaskTemplate.Phone(this.component.getDivPhoneInputMaskJsonTemplateParser().getValue().deserialize(context, (DivPhoneInputMaskTemplate) (divInputMaskTemplate != null ? divInputMaskTemplate.value() : null), data));
            }
            throw ParsingExceptionKt.typeMismatch(data, "type", string);
        }

        @Override // com.yandex.div.serialization.Serializer
        public JSONObject serialize(ParsingContext context, DivInputMaskTemplate value) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof DivInputMaskTemplate.FixedLength) {
                return this.component.getDivFixedLengthInputMaskJsonTemplateParser().getValue().serialize(context, ((DivInputMaskTemplate.FixedLength) value).getValue());
            }
            if (value instanceof DivInputMaskTemplate.Currency) {
                return this.component.getDivCurrencyInputMaskJsonTemplateParser().getValue().serialize(context, ((DivInputMaskTemplate.Currency) value).getValue());
            }
            if (value instanceof DivInputMaskTemplate.Phone) {
                return this.component.getDivPhoneInputMaskJsonTemplateParser().getValue().serialize(context, ((DivInputMaskTemplate.Phone) value).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: DivInputMaskJsonParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div2/DivInputMaskJsonParser$TemplateResolverImpl;", "Lcom/yandex/div/serialization/TemplateResolver;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivInputMaskTemplate;", "Lcom/yandex/div2/DivInputMask;", "component", "Lcom/yandex/div2/JsonParserComponent;", "(Lcom/yandex/div2/JsonParserComponent;)V", "resolve", "context", "Lcom/yandex/div/serialization/ParsingContext;", "template", "data", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TemplateResolverImpl implements TemplateResolver<JSONObject, DivInputMaskTemplate, DivInputMask> {
        private final JsonParserComponent component;

        public TemplateResolverImpl(JsonParserComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }

        @Override // com.yandex.div.serialization.TemplateResolver
        public DivInputMask resolve(ParsingContext context, DivInputMaskTemplate template, JSONObject data) throws ParsingException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(data, "data");
            if (template instanceof DivInputMaskTemplate.FixedLength) {
                return new DivInputMask.FixedLength(this.component.getDivFixedLengthInputMaskJsonTemplateResolver().getValue().resolve(context, ((DivInputMaskTemplate.FixedLength) template).getValue(), data));
            }
            if (template instanceof DivInputMaskTemplate.Currency) {
                return new DivInputMask.Currency(this.component.getDivCurrencyInputMaskJsonTemplateResolver().getValue().resolve(context, ((DivInputMaskTemplate.Currency) template).getValue(), data));
            }
            if (template instanceof DivInputMaskTemplate.Phone) {
                return new DivInputMask.Phone(this.component.getDivPhoneInputMaskJsonTemplateResolver().getValue().resolve(context, ((DivInputMaskTemplate.Phone) template).getValue(), data));
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
