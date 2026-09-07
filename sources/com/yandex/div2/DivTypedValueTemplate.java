package com.yandex.div2;

import com.json.cc;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.JsonTemplate;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.ParsingException;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivTypedValueTemplate.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\t\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\b\u001a\u001b\u001c\u001d\u001e\u001f !¨\u0006\""}, d2 = {"Lcom/yandex/div2/DivTypedValueTemplate;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div2/DivTypedValue;", "()V", "type", "", "getType", "()Ljava/lang/String;", "resolve", cc.o, "Lcom/yandex/div/json/ParsingEnvironment;", "data", "Lorg/json/JSONObject;", "value", "", "writeToJSON", "Array", "Bool", "Color", "Companion", "Dict", "Integer", "Number", "Str", "Url", "Lcom/yandex/div2/DivTypedValueTemplate$Array;", "Lcom/yandex/div2/DivTypedValueTemplate$Bool;", "Lcom/yandex/div2/DivTypedValueTemplate$Color;", "Lcom/yandex/div2/DivTypedValueTemplate$Dict;", "Lcom/yandex/div2/DivTypedValueTemplate$Integer;", "Lcom/yandex/div2/DivTypedValueTemplate$Number;", "Lcom/yandex/div2/DivTypedValueTemplate$Str;", "Lcom/yandex/div2/DivTypedValueTemplate$Url;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivTypedValueTemplate implements JSONSerializable, JsonTemplate<DivTypedValue> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivTypedValueTemplate> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivTypedValueTemplate>() { // from class: com.yandex.div2.DivTypedValueTemplate$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivTypedValueTemplate invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivTypedValueTemplate.Companion.invoke$default(DivTypedValueTemplate.INSTANCE, env, false, it, 2, null);
        }
    };

    public /* synthetic */ DivTypedValueTemplate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: DivTypedValueTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTypedValueTemplate$Str;", "Lcom/yandex/div2/DivTypedValueTemplate;", "value", "Lcom/yandex/div2/StrValueTemplate;", "(Lcom/yandex/div2/StrValueTemplate;)V", "getValue", "()Lcom/yandex/div2/StrValueTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Str extends DivTypedValueTemplate {
        private final StrValueTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Str(StrValueTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final StrValueTemplate getValue() {
            return this.value;
        }
    }

    private DivTypedValueTemplate() {
    }

    /* JADX INFO: compiled from: DivTypedValueTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTypedValueTemplate$Integer;", "Lcom/yandex/div2/DivTypedValueTemplate;", "value", "Lcom/yandex/div2/IntegerValueTemplate;", "(Lcom/yandex/div2/IntegerValueTemplate;)V", "getValue", "()Lcom/yandex/div2/IntegerValueTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Integer extends DivTypedValueTemplate {
        private final IntegerValueTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Integer(IntegerValueTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final IntegerValueTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTypedValueTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTypedValueTemplate$Number;", "Lcom/yandex/div2/DivTypedValueTemplate;", "value", "Lcom/yandex/div2/NumberValueTemplate;", "(Lcom/yandex/div2/NumberValueTemplate;)V", "getValue", "()Lcom/yandex/div2/NumberValueTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Number extends DivTypedValueTemplate {
        private final NumberValueTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Number(NumberValueTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final NumberValueTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTypedValueTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTypedValueTemplate$Color;", "Lcom/yandex/div2/DivTypedValueTemplate;", "value", "Lcom/yandex/div2/ColorValueTemplate;", "(Lcom/yandex/div2/ColorValueTemplate;)V", "getValue", "()Lcom/yandex/div2/ColorValueTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Color extends DivTypedValueTemplate {
        private final ColorValueTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Color(ColorValueTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final ColorValueTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTypedValueTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTypedValueTemplate$Bool;", "Lcom/yandex/div2/DivTypedValueTemplate;", "value", "Lcom/yandex/div2/BoolValueTemplate;", "(Lcom/yandex/div2/BoolValueTemplate;)V", "getValue", "()Lcom/yandex/div2/BoolValueTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Bool extends DivTypedValueTemplate {
        private final BoolValueTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Bool(BoolValueTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final BoolValueTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTypedValueTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTypedValueTemplate$Url;", "Lcom/yandex/div2/DivTypedValueTemplate;", "value", "Lcom/yandex/div2/UrlValueTemplate;", "(Lcom/yandex/div2/UrlValueTemplate;)V", "getValue", "()Lcom/yandex/div2/UrlValueTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Url extends DivTypedValueTemplate {
        private final UrlValueTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Url(UrlValueTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final UrlValueTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTypedValueTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTypedValueTemplate$Dict;", "Lcom/yandex/div2/DivTypedValueTemplate;", "value", "Lcom/yandex/div2/DictValueTemplate;", "(Lcom/yandex/div2/DictValueTemplate;)V", "getValue", "()Lcom/yandex/div2/DictValueTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Dict extends DivTypedValueTemplate {
        private final DictValueTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Dict(DictValueTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DictValueTemplate getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTypedValueTemplate.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTypedValueTemplate$Array;", "Lcom/yandex/div2/DivTypedValueTemplate;", "value", "Lcom/yandex/div2/ArrayValueTemplate;", "(Lcom/yandex/div2/ArrayValueTemplate;)V", "getValue", "()Lcom/yandex/div2/ArrayValueTemplate;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Array extends DivTypedValueTemplate {
        private final ArrayValueTemplate value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Array(ArrayValueTemplate value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final ArrayValueTemplate getValue() {
            return this.value;
        }
    }

    public final Object value() {
        if (this instanceof Str) {
            return ((Str) this).getValue();
        }
        if (this instanceof Integer) {
            return ((Integer) this).getValue();
        }
        if (this instanceof Number) {
            return ((Number) this).getValue();
        }
        if (this instanceof Color) {
            return ((Color) this).getValue();
        }
        if (this instanceof Bool) {
            return ((Bool) this).getValue();
        }
        if (this instanceof Url) {
            return ((Url) this).getValue();
        }
        if (this instanceof Dict) {
            return ((Dict) this).getValue();
        }
        if (this instanceof Array) {
            return ((Array) this).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.yandex.div.json.JSONSerializable
    public JSONObject writeToJSON() {
        return BuiltInParserKt.getBuiltInParserComponent().getDivTypedValueJsonTemplateParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    @Override // com.yandex.div.json.JsonTemplate
    public DivTypedValue resolve(ParsingEnvironment env, JSONObject data) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        return BuiltInParserKt.getBuiltInParserComponent().getDivTypedValueJsonTemplateResolver().getValue().resolve((ParsingContext) env, this, data);
    }

    public final String getType() {
        if (this instanceof Str) {
            return "string";
        }
        if (this instanceof Integer) {
            return "integer";
        }
        if (this instanceof Number) {
            return "number";
        }
        if (this instanceof Color) {
            return "color";
        }
        if (this instanceof Bool) {
            return "boolean";
        }
        if (this instanceof Url) {
            return "url";
        }
        if (this instanceof Dict) {
            return "dict";
        }
        if (this instanceof Array) {
            return "array";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: compiled from: DivTypedValueTemplate.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0086\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/yandex/div2/DivTypedValueTemplate$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTypedValueTemplate;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "topLevel", "", "json", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DivTypedValueTemplate invoke$default(Companion companion, ParsingEnvironment parsingEnvironment, boolean z, JSONObject jSONObject, int i, Object obj) throws ParsingException {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.invoke(parsingEnvironment, z, jSONObject);
        }

        public final DivTypedValueTemplate invoke(ParsingEnvironment env, boolean topLevel, JSONObject json) throws ParsingException {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivTypedValueJsonTemplateParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivTypedValueTemplate> getCREATOR() {
            return DivTypedValueTemplate.CREATOR;
        }
    }
}
