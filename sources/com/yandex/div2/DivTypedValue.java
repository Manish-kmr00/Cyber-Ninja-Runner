package com.yandex.div2;

import com.json.cc;
import com.yandex.div.data.Hashable;
import com.yandex.div.json.JSONSerializable;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.serialization.BuiltInParserKt;
import com.yandex.div.serialization.ParsingContext;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivTypedValue.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\t\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001cB\u0007\b\u0004¢\u0006\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0001\b\u001d\u001e\u001f !\"#$¨\u0006%"}, d2 = {"Lcom/yandex/div2/DivTypedValue;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "()V", "_hash", "", "Ljava/lang/Integer;", "_propertiesHash", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "propertiesHash", "value", "", "writeToJSON", "Lorg/json/JSONObject;", "Array", "Bool", "Color", "Companion", "Dict", "Integer", "Number", "Str", "Url", "Lcom/yandex/div2/DivTypedValue$Array;", "Lcom/yandex/div2/DivTypedValue$Bool;", "Lcom/yandex/div2/DivTypedValue$Color;", "Lcom/yandex/div2/DivTypedValue$Dict;", "Lcom/yandex/div2/DivTypedValue$Integer;", "Lcom/yandex/div2/DivTypedValue$Number;", "Lcom/yandex/div2/DivTypedValue$Str;", "Lcom/yandex/div2/DivTypedValue$Url;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivTypedValue implements JSONSerializable, Hashable {
    private java.lang.Integer _hash;
    private java.lang.Integer _propertiesHash;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivTypedValue> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivTypedValue>() { // from class: com.yandex.div2.DivTypedValue$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivTypedValue invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivTypedValue.INSTANCE.fromJson(env, it);
        }
    };

    public /* synthetic */ DivTypedValue(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final DivTypedValue fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) throws ParsingException {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX INFO: compiled from: DivTypedValue.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTypedValue$Str;", "Lcom/yandex/div2/DivTypedValue;", "value", "Lcom/yandex/div2/StrValue;", "(Lcom/yandex/div2/StrValue;)V", "getValue", "()Lcom/yandex/div2/StrValue;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Str extends DivTypedValue {
        private final StrValue value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Str(StrValue value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final StrValue getValue() {
            return this.value;
        }
    }

    private DivTypedValue() {
    }

    /* JADX INFO: compiled from: DivTypedValue.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTypedValue$Integer;", "Lcom/yandex/div2/DivTypedValue;", "value", "Lcom/yandex/div2/IntegerValue;", "(Lcom/yandex/div2/IntegerValue;)V", "getValue", "()Lcom/yandex/div2/IntegerValue;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Integer extends DivTypedValue {
        private final IntegerValue value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Integer(IntegerValue value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final IntegerValue getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTypedValue.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTypedValue$Number;", "Lcom/yandex/div2/DivTypedValue;", "value", "Lcom/yandex/div2/NumberValue;", "(Lcom/yandex/div2/NumberValue;)V", "getValue", "()Lcom/yandex/div2/NumberValue;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Number extends DivTypedValue {
        private final NumberValue value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Number(NumberValue value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final NumberValue getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTypedValue.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTypedValue$Color;", "Lcom/yandex/div2/DivTypedValue;", "value", "Lcom/yandex/div2/ColorValue;", "(Lcom/yandex/div2/ColorValue;)V", "getValue", "()Lcom/yandex/div2/ColorValue;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Color extends DivTypedValue {
        private final ColorValue value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Color(ColorValue value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final ColorValue getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTypedValue.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTypedValue$Bool;", "Lcom/yandex/div2/DivTypedValue;", "value", "Lcom/yandex/div2/BoolValue;", "(Lcom/yandex/div2/BoolValue;)V", "getValue", "()Lcom/yandex/div2/BoolValue;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Bool extends DivTypedValue {
        private final BoolValue value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Bool(BoolValue value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final BoolValue getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTypedValue.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTypedValue$Url;", "Lcom/yandex/div2/DivTypedValue;", "value", "Lcom/yandex/div2/UrlValue;", "(Lcom/yandex/div2/UrlValue;)V", "getValue", "()Lcom/yandex/div2/UrlValue;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Url extends DivTypedValue {
        private final UrlValue value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Url(UrlValue value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final UrlValue getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTypedValue.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTypedValue$Dict;", "Lcom/yandex/div2/DivTypedValue;", "value", "Lcom/yandex/div2/DictValue;", "(Lcom/yandex/div2/DictValue;)V", "getValue", "()Lcom/yandex/div2/DictValue;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Dict extends DivTypedValue {
        private final DictValue value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Dict(DictValue value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DictValue getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivTypedValue.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivTypedValue$Array;", "Lcom/yandex/div2/DivTypedValue;", "value", "Lcom/yandex/div2/ArrayValue;", "(Lcom/yandex/div2/ArrayValue;)V", "getValue", "()Lcom/yandex/div2/ArrayValue;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Array extends DivTypedValue {
        private final ArrayValue value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Array(ArrayValue value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final ArrayValue getValue() {
            return this.value;
        }
    }

    @Override // com.yandex.div.data.Hashable
    public int propertiesHash() {
        int iPropertiesHash;
        java.lang.Integer num = this._propertiesHash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        if (this instanceof Str) {
            iPropertiesHash = ((Str) this).getValue().propertiesHash();
        } else if (this instanceof Integer) {
            iPropertiesHash = ((Integer) this).getValue().propertiesHash();
        } else if (this instanceof Number) {
            iPropertiesHash = ((Number) this).getValue().propertiesHash();
        } else if (this instanceof Color) {
            iPropertiesHash = ((Color) this).getValue().propertiesHash();
        } else if (this instanceof Bool) {
            iPropertiesHash = ((Bool) this).getValue().propertiesHash();
        } else if (this instanceof Url) {
            iPropertiesHash = ((Url) this).getValue().propertiesHash();
        } else if (this instanceof Dict) {
            iPropertiesHash = ((Dict) this).getValue().propertiesHash();
        } else {
            if (!(this instanceof Array)) {
                throw new NoWhenBranchMatchedException();
            }
            iPropertiesHash = ((Array) this).getValue().propertiesHash();
        }
        int i = iHashCode + iPropertiesHash;
        this._propertiesHash = java.lang.Integer.valueOf(i);
        return i;
    }

    @Override // com.yandex.div.data.Hashable
    public int hash() {
        int iHash;
        java.lang.Integer num = this._hash;
        if (num != null) {
            return num.intValue();
        }
        int iHashCode = Reflection.getOrCreateKotlinClass(getClass()).hashCode();
        if (this instanceof Str) {
            iHash = ((Str) this).getValue().hash();
        } else if (this instanceof Integer) {
            iHash = ((Integer) this).getValue().hash();
        } else if (this instanceof Number) {
            iHash = ((Number) this).getValue().hash();
        } else if (this instanceof Color) {
            iHash = ((Color) this).getValue().hash();
        } else if (this instanceof Bool) {
            iHash = ((Bool) this).getValue().hash();
        } else if (this instanceof Url) {
            iHash = ((Url) this).getValue().hash();
        } else if (this instanceof Dict) {
            iHash = ((Dict) this).getValue().hash();
        } else {
            if (!(this instanceof Array)) {
                throw new NoWhenBranchMatchedException();
            }
            iHash = ((Array) this).getValue().hash();
        }
        int i = iHashCode + iHash;
        this._hash = java.lang.Integer.valueOf(i);
        return i;
    }

    public final boolean equals(DivTypedValue other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        if (this instanceof Str) {
            StrValue value = ((Str) this).getValue();
            Object objValue = other.value();
            return value.equals(objValue instanceof StrValue ? (StrValue) objValue : null, resolver, otherResolver);
        }
        if (this instanceof Integer) {
            IntegerValue value2 = ((Integer) this).getValue();
            Object objValue2 = other.value();
            return value2.equals(objValue2 instanceof IntegerValue ? (IntegerValue) objValue2 : null, resolver, otherResolver);
        }
        if (this instanceof Number) {
            NumberValue value3 = ((Number) this).getValue();
            Object objValue3 = other.value();
            return value3.equals(objValue3 instanceof NumberValue ? (NumberValue) objValue3 : null, resolver, otherResolver);
        }
        if (this instanceof Color) {
            ColorValue value4 = ((Color) this).getValue();
            Object objValue4 = other.value();
            return value4.equals(objValue4 instanceof ColorValue ? (ColorValue) objValue4 : null, resolver, otherResolver);
        }
        if (this instanceof Bool) {
            BoolValue value5 = ((Bool) this).getValue();
            Object objValue5 = other.value();
            return value5.equals(objValue5 instanceof BoolValue ? (BoolValue) objValue5 : null, resolver, otherResolver);
        }
        if (this instanceof Url) {
            UrlValue value6 = ((Url) this).getValue();
            Object objValue6 = other.value();
            return value6.equals(objValue6 instanceof UrlValue ? (UrlValue) objValue6 : null, resolver, otherResolver);
        }
        if (this instanceof Dict) {
            DictValue value7 = ((Dict) this).getValue();
            Object objValue7 = other.value();
            return value7.equals(objValue7 instanceof DictValue ? (DictValue) objValue7 : null, resolver, otherResolver);
        }
        if (!(this instanceof Array)) {
            throw new NoWhenBranchMatchedException();
        }
        ArrayValue value8 = ((Array) this).getValue();
        Object objValue8 = other.value();
        return value8.equals(objValue8 instanceof ArrayValue ? (ArrayValue) objValue8 : null, resolver, otherResolver);
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
        return BuiltInParserKt.getBuiltInParserComponent().getDivTypedValueJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivTypedValue.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivTypedValue$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivTypedValue;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivTypedValue fromJson(ParsingEnvironment env, JSONObject json) throws ParsingException {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivTypedValueJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivTypedValue> getCREATOR() {
            return DivTypedValue.CREATOR;
        }
    }
}
