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

/* JADX INFO: compiled from: DivVariable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\t\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001cB\u0007\b\u0004¢\u0006\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0001\b\u001d\u001e\u001f !\"#$¨\u0006%"}, d2 = {"Lcom/yandex/div2/DivVariable;", "Lcom/yandex/div/json/JSONSerializable;", "Lcom/yandex/div/data/Hashable;", "()V", "_hash", "", "Ljava/lang/Integer;", "_propertiesHash", "equals", "", "other", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "otherResolver", "hash", "propertiesHash", "value", "", "writeToJSON", "Lorg/json/JSONObject;", "Array", "Bool", "Color", "Companion", "Dict", "Integer", "Number", "Str", "Url", "Lcom/yandex/div2/DivVariable$Array;", "Lcom/yandex/div2/DivVariable$Bool;", "Lcom/yandex/div2/DivVariable$Color;", "Lcom/yandex/div2/DivVariable$Dict;", "Lcom/yandex/div2/DivVariable$Integer;", "Lcom/yandex/div2/DivVariable$Number;", "Lcom/yandex/div2/DivVariable$Str;", "Lcom/yandex/div2/DivVariable$Url;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivVariable implements JSONSerializable, Hashable {
    private java.lang.Integer _hash;
    private java.lang.Integer _propertiesHash;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function2<ParsingEnvironment, JSONObject, DivVariable> CREATOR = new Function2<ParsingEnvironment, JSONObject, DivVariable>() { // from class: com.yandex.div2.DivVariable$Companion$CREATOR$1
        @Override // kotlin.jvm.functions.Function2
        public final DivVariable invoke(ParsingEnvironment env, JSONObject it) {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(it, "it");
            return DivVariable.INSTANCE.fromJson(env, it);
        }
    };

    public /* synthetic */ DivVariable(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final DivVariable fromJson(ParsingEnvironment parsingEnvironment, JSONObject jSONObject) throws ParsingException {
        return INSTANCE.fromJson(parsingEnvironment, jSONObject);
    }

    /* JADX INFO: compiled from: DivVariable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivVariable$Str;", "Lcom/yandex/div2/DivVariable;", "value", "Lcom/yandex/div2/StrVariable;", "(Lcom/yandex/div2/StrVariable;)V", "getValue", "()Lcom/yandex/div2/StrVariable;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Str extends DivVariable {
        private final StrVariable value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Str(StrVariable value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final StrVariable getValue() {
            return this.value;
        }
    }

    private DivVariable() {
    }

    /* JADX INFO: compiled from: DivVariable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivVariable$Number;", "Lcom/yandex/div2/DivVariable;", "value", "Lcom/yandex/div2/NumberVariable;", "(Lcom/yandex/div2/NumberVariable;)V", "getValue", "()Lcom/yandex/div2/NumberVariable;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Number extends DivVariable {
        private final NumberVariable value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Number(NumberVariable value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final NumberVariable getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivVariable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivVariable$Integer;", "Lcom/yandex/div2/DivVariable;", "value", "Lcom/yandex/div2/IntegerVariable;", "(Lcom/yandex/div2/IntegerVariable;)V", "getValue", "()Lcom/yandex/div2/IntegerVariable;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Integer extends DivVariable {
        private final IntegerVariable value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Integer(IntegerVariable value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final IntegerVariable getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivVariable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivVariable$Bool;", "Lcom/yandex/div2/DivVariable;", "value", "Lcom/yandex/div2/BoolVariable;", "(Lcom/yandex/div2/BoolVariable;)V", "getValue", "()Lcom/yandex/div2/BoolVariable;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Bool extends DivVariable {
        private final BoolVariable value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Bool(BoolVariable value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final BoolVariable getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivVariable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivVariable$Color;", "Lcom/yandex/div2/DivVariable;", "value", "Lcom/yandex/div2/ColorVariable;", "(Lcom/yandex/div2/ColorVariable;)V", "getValue", "()Lcom/yandex/div2/ColorVariable;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Color extends DivVariable {
        private final ColorVariable value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Color(ColorVariable value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final ColorVariable getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivVariable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivVariable$Url;", "Lcom/yandex/div2/DivVariable;", "value", "Lcom/yandex/div2/UrlVariable;", "(Lcom/yandex/div2/UrlVariable;)V", "getValue", "()Lcom/yandex/div2/UrlVariable;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Url extends DivVariable {
        private final UrlVariable value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Url(UrlVariable value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final UrlVariable getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivVariable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivVariable$Dict;", "Lcom/yandex/div2/DivVariable;", "value", "Lcom/yandex/div2/DictVariable;", "(Lcom/yandex/div2/DictVariable;)V", "getValue", "()Lcom/yandex/div2/DictVariable;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Dict extends DivVariable {
        private final DictVariable value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Dict(DictVariable value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DictVariable getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: DivVariable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div2/DivVariable$Array;", "Lcom/yandex/div2/DivVariable;", "value", "Lcom/yandex/div2/ArrayVariable;", "(Lcom/yandex/div2/ArrayVariable;)V", "getValue", "()Lcom/yandex/div2/ArrayVariable;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Array extends DivVariable {
        private final ArrayVariable value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Array(ArrayVariable value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final ArrayVariable getValue() {
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
        } else if (this instanceof Number) {
            iPropertiesHash = ((Number) this).getValue().propertiesHash();
        } else if (this instanceof Integer) {
            iPropertiesHash = ((Integer) this).getValue().propertiesHash();
        } else if (this instanceof Bool) {
            iPropertiesHash = ((Bool) this).getValue().propertiesHash();
        } else if (this instanceof Color) {
            iPropertiesHash = ((Color) this).getValue().propertiesHash();
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
        } else if (this instanceof Number) {
            iHash = ((Number) this).getValue().hash();
        } else if (this instanceof Integer) {
            iHash = ((Integer) this).getValue().hash();
        } else if (this instanceof Bool) {
            iHash = ((Bool) this).getValue().hash();
        } else if (this instanceof Color) {
            iHash = ((Color) this).getValue().hash();
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

    public final boolean equals(DivVariable other, ExpressionResolver resolver, ExpressionResolver otherResolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(otherResolver, "otherResolver");
        if (other == null) {
            return false;
        }
        if (this instanceof Str) {
            StrVariable value = ((Str) this).getValue();
            Object objValue = other.value();
            return value.equals(objValue instanceof StrVariable ? (StrVariable) objValue : null, resolver, otherResolver);
        }
        if (this instanceof Number) {
            NumberVariable value2 = ((Number) this).getValue();
            Object objValue2 = other.value();
            return value2.equals(objValue2 instanceof NumberVariable ? (NumberVariable) objValue2 : null, resolver, otherResolver);
        }
        if (this instanceof Integer) {
            IntegerVariable value3 = ((Integer) this).getValue();
            Object objValue3 = other.value();
            return value3.equals(objValue3 instanceof IntegerVariable ? (IntegerVariable) objValue3 : null, resolver, otherResolver);
        }
        if (this instanceof Bool) {
            BoolVariable value4 = ((Bool) this).getValue();
            Object objValue4 = other.value();
            return value4.equals(objValue4 instanceof BoolVariable ? (BoolVariable) objValue4 : null, resolver, otherResolver);
        }
        if (this instanceof Color) {
            ColorVariable value5 = ((Color) this).getValue();
            Object objValue5 = other.value();
            return value5.equals(objValue5 instanceof ColorVariable ? (ColorVariable) objValue5 : null, resolver, otherResolver);
        }
        if (this instanceof Url) {
            UrlVariable value6 = ((Url) this).getValue();
            Object objValue6 = other.value();
            return value6.equals(objValue6 instanceof UrlVariable ? (UrlVariable) objValue6 : null, resolver, otherResolver);
        }
        if (this instanceof Dict) {
            DictVariable value7 = ((Dict) this).getValue();
            Object objValue7 = other.value();
            return value7.equals(objValue7 instanceof DictVariable ? (DictVariable) objValue7 : null, resolver, otherResolver);
        }
        if (!(this instanceof Array)) {
            throw new NoWhenBranchMatchedException();
        }
        ArrayVariable value8 = ((Array) this).getValue();
        Object objValue8 = other.value();
        return value8.equals(objValue8 instanceof ArrayVariable ? (ArrayVariable) objValue8 : null, resolver, otherResolver);
    }

    public final Object value() {
        if (this instanceof Str) {
            return ((Str) this).getValue();
        }
        if (this instanceof Number) {
            return ((Number) this).getValue();
        }
        if (this instanceof Integer) {
            return ((Integer) this).getValue();
        }
        if (this instanceof Bool) {
            return ((Bool) this).getValue();
        }
        if (this instanceof Color) {
            return ((Color) this).getValue();
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
        return BuiltInParserKt.getBuiltInParserComponent().getDivVariableJsonEntityParser().getValue().serialize(BuiltInParserKt.getBuiltInParsingContext(), this);
    }

    /* JADX INFO: compiled from: DivVariable.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b\rR#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yandex/div2/DivVariable$Companion;", "", "()V", "CREATOR", "Lkotlin/Function2;", "Lcom/yandex/div/json/ParsingEnvironment;", "Lorg/json/JSONObject;", "Lcom/yandex/div2/DivVariable;", "getCREATOR", "()Lkotlin/jvm/functions/Function2;", "invoke", cc.o, "json", "fromJson", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DivVariable fromJson(ParsingEnvironment env, JSONObject json) throws ParsingException {
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(json, "json");
            return BuiltInParserKt.getBuiltInParserComponent().getDivVariableJsonEntityParser().getValue().deserialize((ParsingContext) env, json);
        }

        public final Function2<ParsingEnvironment, JSONObject, DivVariable> getCREATOR() {
            return DivVariable.CREATOR;
        }
    }
}
