package com.yandex.div.data;

import com.yandex.div.evaluable.types.Color;
import com.yandex.div.evaluable.types.Url;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: StoredValue.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0001R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\b\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/yandex/div/data/StoredValue;", "", "()V", "name", "", "getName", "()Ljava/lang/String;", "getType", "Lcom/yandex/div/data/StoredValue$Type;", "getValue", "ArrayStoredValue", "BooleanStoredValue", "ColorStoredValue", "DictStoredValue", "DoubleStoredValue", "IntegerStoredValue", "StringStoredValue", "Type", "UrlStoredValue", "Lcom/yandex/div/data/StoredValue$ArrayStoredValue;", "Lcom/yandex/div/data/StoredValue$BooleanStoredValue;", "Lcom/yandex/div/data/StoredValue$ColorStoredValue;", "Lcom/yandex/div/data/StoredValue$DictStoredValue;", "Lcom/yandex/div/data/StoredValue$DoubleStoredValue;", "Lcom/yandex/div/data/StoredValue$IntegerStoredValue;", "Lcom/yandex/div/data/StoredValue$StringStoredValue;", "Lcom/yandex/div/data/StoredValue$UrlStoredValue;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class StoredValue {
    public /* synthetic */ StoredValue(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getName();

    private StoredValue() {
    }

    /* JADX INFO: compiled from: StoredValue.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/yandex/div/data/StoredValue$Type;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "STRING", "INTEGER", "BOOLEAN", "NUMBER", "COLOR", "URL", "ARRAY", "DICT", "Converter", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Type {
        STRING("string"),
        INTEGER("integer"),
        BOOLEAN("boolean"),
        NUMBER("number"),
        COLOR("color"),
        URL("url"),
        ARRAY("array"),
        DICT("dict");


        /* JADX INFO: renamed from: Converter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String value;

        Type(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: com.yandex.div.data.StoredValue$Type$Converter, reason: from kotlin metadata */
        /* JADX INFO: compiled from: StoredValue.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004¨\u0006\t"}, d2 = {"Lcom/yandex/div/data/StoredValue$Type$Converter;", "", "()V", "fromString", "Lcom/yandex/div/data/StoredValue$Type;", "string", "", "toString", "obj", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String toString(Type obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                return obj.value;
            }

            public final Type fromString(String string) {
                Intrinsics.checkNotNullParameter(string, "string");
                if (Intrinsics.areEqual(string, Type.STRING.value)) {
                    return Type.STRING;
                }
                if (Intrinsics.areEqual(string, Type.INTEGER.value)) {
                    return Type.INTEGER;
                }
                if (Intrinsics.areEqual(string, Type.BOOLEAN.value)) {
                    return Type.BOOLEAN;
                }
                if (Intrinsics.areEqual(string, Type.NUMBER.value)) {
                    return Type.NUMBER;
                }
                if (Intrinsics.areEqual(string, Type.COLOR.value)) {
                    return Type.COLOR;
                }
                if (Intrinsics.areEqual(string, Type.URL.value)) {
                    return Type.URL;
                }
                if (Intrinsics.areEqual(string, Type.ARRAY.value)) {
                    return Type.ARRAY;
                }
                if (Intrinsics.areEqual(string, Type.DICT.value)) {
                    return Type.DICT;
                }
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: StoredValue.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/yandex/div/data/StoredValue$StringStoredValue;", "Lcom/yandex/div/data/StoredValue;", "name", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getValue", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class StringStoredValue extends StoredValue {
        private final String name;
        private final String value;

        public static /* synthetic */ StringStoredValue copy$default(StringStoredValue stringStoredValue, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stringStoredValue.name;
            }
            if ((i & 2) != 0) {
                str2 = stringStoredValue.value;
            }
            return stringStoredValue.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final StringStoredValue copy(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            return new StringStoredValue(name, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StringStoredValue)) {
                return false;
            }
            StringStoredValue stringStoredValue = (StringStoredValue) other;
            return Intrinsics.areEqual(this.name, stringStoredValue.name) && Intrinsics.areEqual(this.value, stringStoredValue.value);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.value.hashCode();
        }

        public String toString() {
            return "StringStoredValue(name=" + this.name + ", value=" + this.value + ')';
        }

        @Override // com.yandex.div.data.StoredValue
        public String getName() {
            return this.name;
        }

        @Override // com.yandex.div.data.StoredValue
        public final String getValue() {
            return this.value;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StringStoredValue(String name, String value) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.name = name;
            this.value = value;
        }
    }

    /* JADX INFO: compiled from: StoredValue.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/data/StoredValue$IntegerStoredValue;", "Lcom/yandex/div/data/StoredValue;", "name", "", "value", "", "(Ljava/lang/String;J)V", "getName", "()Ljava/lang/String;", "getValue", "()J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class IntegerStoredValue extends StoredValue {
        private final String name;
        private final long value;

        public static /* synthetic */ IntegerStoredValue copy$default(IntegerStoredValue integerStoredValue, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = integerStoredValue.name;
            }
            if ((i & 2) != 0) {
                j = integerStoredValue.value;
            }
            return integerStoredValue.copy(str, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getValue() {
            return this.value;
        }

        public final IntegerStoredValue copy(String name, long value) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new IntegerStoredValue(name, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IntegerStoredValue)) {
                return false;
            }
            IntegerStoredValue integerStoredValue = (IntegerStoredValue) other;
            return Intrinsics.areEqual(this.name, integerStoredValue.name) && this.value == integerStoredValue.value;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + Long.hashCode(this.value);
        }

        public String toString() {
            return "IntegerStoredValue(name=" + this.name + ", value=" + this.value + ')';
        }

        @Override // com.yandex.div.data.StoredValue
        public String getName() {
            return this.name;
        }

        public final long getValue() {
            return this.value;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntegerStoredValue(String name, long j) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.value = j;
        }
    }

    /* JADX INFO: compiled from: StoredValue.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/yandex/div/data/StoredValue$BooleanStoredValue;", "Lcom/yandex/div/data/StoredValue;", "name", "", "value", "", "(Ljava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getValue", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class BooleanStoredValue extends StoredValue {
        private final String name;
        private final boolean value;

        public static /* synthetic */ BooleanStoredValue copy$default(BooleanStoredValue booleanStoredValue, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = booleanStoredValue.name;
            }
            if ((i & 2) != 0) {
                z = booleanStoredValue.value;
            }
            return booleanStoredValue.copy(str, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getValue() {
            return this.value;
        }

        public final BooleanStoredValue copy(String name, boolean value) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new BooleanStoredValue(name, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BooleanStoredValue)) {
                return false;
            }
            BooleanStoredValue booleanStoredValue = (BooleanStoredValue) other;
            return Intrinsics.areEqual(this.name, booleanStoredValue.name) && this.value == booleanStoredValue.value;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            int iHashCode = this.name.hashCode() * 31;
            boolean z = this.value;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public String toString() {
            return "BooleanStoredValue(name=" + this.name + ", value=" + this.value + ')';
        }

        @Override // com.yandex.div.data.StoredValue
        public String getName() {
            return this.name;
        }

        public final boolean getValue() {
            return this.value;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BooleanStoredValue(String name, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.value = z;
        }
    }

    /* JADX INFO: compiled from: StoredValue.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/data/StoredValue$DoubleStoredValue;", "Lcom/yandex/div/data/StoredValue;", "name", "", "value", "", "(Ljava/lang/String;D)V", "getName", "()Ljava/lang/String;", "getValue", "()D", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class DoubleStoredValue extends StoredValue {
        private final String name;
        private final double value;

        public static /* synthetic */ DoubleStoredValue copy$default(DoubleStoredValue doubleStoredValue, String str, double d, int i, Object obj) {
            if ((i & 1) != 0) {
                str = doubleStoredValue.name;
            }
            if ((i & 2) != 0) {
                d = doubleStoredValue.value;
            }
            return doubleStoredValue.copy(str, d);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final double getValue() {
            return this.value;
        }

        public final DoubleStoredValue copy(String name, double value) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new DoubleStoredValue(name, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DoubleStoredValue)) {
                return false;
            }
            DoubleStoredValue doubleStoredValue = (DoubleStoredValue) other;
            return Intrinsics.areEqual(this.name, doubleStoredValue.name) && Double.compare(this.value, doubleStoredValue.value) == 0;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + Double.hashCode(this.value);
        }

        public String toString() {
            return "DoubleStoredValue(name=" + this.name + ", value=" + this.value + ')';
        }

        @Override // com.yandex.div.data.StoredValue
        public String getName() {
            return this.name;
        }

        public final double getValue() {
            return this.value;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DoubleStoredValue(String name, double d) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.value = d;
        }
    }

    /* JADX INFO: compiled from: StoredValue.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\r\u001a\u00020\u0005HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\nJ*\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Lcom/yandex/div/data/StoredValue$ColorStoredValue;", "Lcom/yandex/div/data/StoredValue;", "name", "", "value", "Lcom/yandex/div/evaluable/types/Color;", "(Ljava/lang/String;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getValue-WpymAT4", "()I", "I", "component1", "component2", "component2-WpymAT4", "copy", "copy-IC13cx8", "(Ljava/lang/String;I)Lcom/yandex/div/data/StoredValue$ColorStoredValue;", "equals", "", "other", "", "hashCode", "", "toString", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class ColorStoredValue extends StoredValue {
        private final String name;
        private final int value;

        public /* synthetic */ ColorStoredValue(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        /* JADX INFO: renamed from: copy-IC13cx8$default, reason: not valid java name */
        public static /* synthetic */ ColorStoredValue m6151copyIC13cx8$default(ColorStoredValue colorStoredValue, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = colorStoredValue.name;
            }
            if ((i2 & 2) != 0) {
                i = colorStoredValue.value;
            }
            return colorStoredValue.m6153copyIC13cx8(str, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2-WpymAT4, reason: not valid java name and from getter */
        public final int getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: copy-IC13cx8, reason: not valid java name */
        public final ColorStoredValue m6153copyIC13cx8(String name, int value) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new ColorStoredValue(name, value, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ColorStoredValue)) {
                return false;
            }
            ColorStoredValue colorStoredValue = (ColorStoredValue) other;
            return Intrinsics.areEqual(this.name, colorStoredValue.name) && Color.m6220equalsimpl0(this.value, colorStoredValue.value);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + Color.m6222hashCodeimpl(this.value);
        }

        public String toString() {
            return "ColorStoredValue(name=" + this.name + ", value=" + ((Object) Color.m6224toStringimpl(this.value)) + ')';
        }

        @Override // com.yandex.div.data.StoredValue
        public String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: getValue-WpymAT4, reason: not valid java name */
        public final int m6154getValueWpymAT4() {
            return this.value;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private ColorStoredValue(String name, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.value = i;
        }
    }

    /* JADX INFO: compiled from: StoredValue.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\f\u001a\u00020\u0005HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\bJ*\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\t\u0010\b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Lcom/yandex/div/data/StoredValue$UrlStoredValue;", "Lcom/yandex/div/data/StoredValue;", "name", "", "value", "Lcom/yandex/div/evaluable/types/Url;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getValue-OXPJC6E", "Ljava/lang/String;", "component1", "component2", "component2-OXPJC6E", "copy", "copy-rmspukQ", "(Ljava/lang/String;Ljava/lang/String;)Lcom/yandex/div/data/StoredValue$UrlStoredValue;", "equals", "", "other", "", "hashCode", "", "toString", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class UrlStoredValue extends StoredValue {
        private final String name;
        private final String value;

        public /* synthetic */ UrlStoredValue(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        /* JADX INFO: renamed from: copy-rmspukQ$default, reason: not valid java name */
        public static /* synthetic */ UrlStoredValue m6155copyrmspukQ$default(UrlStoredValue urlStoredValue, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = urlStoredValue.name;
            }
            if ((i & 2) != 0) {
                str2 = urlStoredValue.value;
            }
            return urlStoredValue.m6157copyrmspukQ(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2-OXPJC6E, reason: not valid java name and from getter */
        public final String getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: copy-rmspukQ, reason: not valid java name */
        public final UrlStoredValue m6157copyrmspukQ(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            return new UrlStoredValue(name, value, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UrlStoredValue)) {
                return false;
            }
            UrlStoredValue urlStoredValue = (UrlStoredValue) other;
            return Intrinsics.areEqual(this.name, urlStoredValue.name) && Url.m6232equalsimpl0(this.value, urlStoredValue.value);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + Url.m6233hashCodeimpl(this.value);
        }

        public String toString() {
            return "UrlStoredValue(name=" + this.name + ", value=" + ((Object) Url.m6234toStringimpl(this.value)) + ')';
        }

        @Override // com.yandex.div.data.StoredValue
        public String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: getValue-OXPJC6E, reason: not valid java name */
        public final String m6158getValueOXPJC6E() {
            return this.value;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private UrlStoredValue(String name, String value) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.name = name;
            this.value = value;
        }
    }

    /* JADX INFO: compiled from: StoredValue.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/data/StoredValue$ArrayStoredValue;", "Lcom/yandex/div/data/StoredValue;", "name", "", "value", "Lorg/json/JSONArray;", "(Ljava/lang/String;Lorg/json/JSONArray;)V", "getName", "()Ljava/lang/String;", "getValue", "()Lorg/json/JSONArray;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class ArrayStoredValue extends StoredValue {
        private final String name;
        private final JSONArray value;

        public static /* synthetic */ ArrayStoredValue copy$default(ArrayStoredValue arrayStoredValue, String str, JSONArray jSONArray, int i, Object obj) {
            if ((i & 1) != 0) {
                str = arrayStoredValue.name;
            }
            if ((i & 2) != 0) {
                jSONArray = arrayStoredValue.value;
            }
            return arrayStoredValue.copy(str, jSONArray);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final JSONArray getValue() {
            return this.value;
        }

        public final ArrayStoredValue copy(String name, JSONArray value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            return new ArrayStoredValue(name, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ArrayStoredValue)) {
                return false;
            }
            ArrayStoredValue arrayStoredValue = (ArrayStoredValue) other;
            return Intrinsics.areEqual(this.name, arrayStoredValue.name) && Intrinsics.areEqual(this.value, arrayStoredValue.value);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.value.hashCode();
        }

        public String toString() {
            return "ArrayStoredValue(name=" + this.name + ", value=" + this.value + ')';
        }

        @Override // com.yandex.div.data.StoredValue
        public String getName() {
            return this.name;
        }

        @Override // com.yandex.div.data.StoredValue
        public final JSONArray getValue() {
            return this.value;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArrayStoredValue(String name, JSONArray value) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.name = name;
            this.value = value;
        }
    }

    /* JADX INFO: compiled from: StoredValue.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/data/StoredValue$DictStoredValue;", "Lcom/yandex/div/data/StoredValue;", "name", "", "value", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "getName", "()Ljava/lang/String;", "getValue", "()Lorg/json/JSONObject;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class DictStoredValue extends StoredValue {
        private final String name;
        private final JSONObject value;

        public static /* synthetic */ DictStoredValue copy$default(DictStoredValue dictStoredValue, String str, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dictStoredValue.name;
            }
            if ((i & 2) != 0) {
                jSONObject = dictStoredValue.value;
            }
            return dictStoredValue.copy(str, jSONObject);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final JSONObject getValue() {
            return this.value;
        }

        public final DictStoredValue copy(String name, JSONObject value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            return new DictStoredValue(name, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DictStoredValue)) {
                return false;
            }
            DictStoredValue dictStoredValue = (DictStoredValue) other;
            return Intrinsics.areEqual(this.name, dictStoredValue.name) && Intrinsics.areEqual(this.value, dictStoredValue.value);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.value.hashCode();
        }

        public String toString() {
            return "DictStoredValue(name=" + this.name + ", value=" + this.value + ')';
        }

        @Override // com.yandex.div.data.StoredValue
        public String getName() {
            return this.name;
        }

        @Override // com.yandex.div.data.StoredValue
        public final JSONObject getValue() {
            return this.value;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DictStoredValue(String name, JSONObject value) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.name = name;
            this.value = value;
        }
    }

    public final Object getValue() {
        if (this instanceof StringStoredValue) {
            return ((StringStoredValue) this).getValue();
        }
        if (this instanceof IntegerStoredValue) {
            return Long.valueOf(((IntegerStoredValue) this).getValue());
        }
        if (this instanceof BooleanStoredValue) {
            return Boolean.valueOf(((BooleanStoredValue) this).getValue());
        }
        if (this instanceof DoubleStoredValue) {
            return Double.valueOf(((DoubleStoredValue) this).getValue());
        }
        if (this instanceof ColorStoredValue) {
            return Color.m6217boximpl(((ColorStoredValue) this).m6154getValueWpymAT4());
        }
        if (this instanceof UrlStoredValue) {
            return Url.m6229boximpl(((UrlStoredValue) this).m6158getValueOXPJC6E());
        }
        if (this instanceof ArrayStoredValue) {
            return ((ArrayStoredValue) this).getValue();
        }
        if (this instanceof DictStoredValue) {
            return ((DictStoredValue) this).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Type getType() {
        if (this instanceof StringStoredValue) {
            return Type.STRING;
        }
        if (this instanceof IntegerStoredValue) {
            return Type.INTEGER;
        }
        if (this instanceof BooleanStoredValue) {
            return Type.BOOLEAN;
        }
        if (this instanceof DoubleStoredValue) {
            return Type.NUMBER;
        }
        if (this instanceof ColorStoredValue) {
            return Type.COLOR;
        }
        if (this instanceof UrlStoredValue) {
            return Type.URL;
        }
        if (this instanceof ArrayStoredValue) {
            return Type.ARRAY;
        }
        if (this instanceof DictStoredValue) {
            return Type.DICT;
        }
        throw new NoWhenBranchMatchedException();
    }
}
