package com.fyber.inneractive.sdk.protobuf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'INT64' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes7.dex */
public class K1 {
    private static final /* synthetic */ K1[] $VALUES;
    public static final K1 BOOL;
    public static final K1 BYTES;
    public static final K1 DOUBLE;
    public static final K1 ENUM;
    public static final K1 FIXED32;
    public static final K1 FIXED64;
    public static final K1 FLOAT;
    public static final K1 GROUP;
    public static final K1 INT32;
    public static final K1 INT64;
    public static final K1 MESSAGE;
    public static final K1 SFIXED32;
    public static final K1 SFIXED64;
    public static final K1 SINT32;
    public static final K1 SINT64;
    public static final K1 STRING;
    public static final K1 UINT32;
    public static final K1 UINT64;
    private final L1 javaType;
    private final int wireType;

    static {
        K1 k1 = new K1("DOUBLE", 0, L1.DOUBLE, 1);
        DOUBLE = k1;
        K1 k2 = new K1("FLOAT", 1, L1.FLOAT, 5);
        FLOAT = k2;
        L1 l1 = L1.LONG;
        K1 k3 = new K1("INT64", 2, l1, 0);
        INT64 = k3;
        K1 k4 = new K1("UINT64", 3, l1, 0);
        UINT64 = k4;
        L1 l2 = L1.INT;
        K1 k5 = new K1("INT32", 4, l2, 0);
        INT32 = k5;
        K1 k6 = new K1("FIXED64", 5, l1, 1);
        FIXED64 = k6;
        K1 k7 = new K1("FIXED32", 6, l2, 5);
        FIXED32 = k7;
        K1 k8 = new K1("BOOL", 7, L1.BOOLEAN, 0);
        BOOL = k8;
        G1 g1 = new G1(L1.STRING);
        STRING = g1;
        final L1 l3 = L1.MESSAGE;
        K1 k9 = new K1(l3) { // from class: com.fyber.inneractive.sdk.protobuf.H1
            @Override // com.fyber.inneractive.sdk.protobuf.K1
            public final boolean c() {
                return false;
            }
        };
        GROUP = k9;
        K1 k10 = new K1(l3) { // from class: com.fyber.inneractive.sdk.protobuf.I1
            @Override // com.fyber.inneractive.sdk.protobuf.K1
            public final boolean c() {
                return false;
            }
        };
        MESSAGE = k10;
        final L1 l4 = L1.BYTE_STRING;
        K1 k11 = new K1(l4) { // from class: com.fyber.inneractive.sdk.protobuf.J1
            @Override // com.fyber.inneractive.sdk.protobuf.K1
            public final boolean c() {
                return false;
            }
        };
        BYTES = k11;
        K1 k12 = new K1("UINT32", 12, l2, 0);
        UINT32 = k12;
        K1 k13 = new K1("ENUM", 13, L1.ENUM, 0);
        ENUM = k13;
        K1 k14 = new K1("SFIXED32", 14, l2, 5);
        SFIXED32 = k14;
        K1 k15 = new K1("SFIXED64", 15, l1, 1);
        SFIXED64 = k15;
        K1 k16 = new K1("SINT32", 16, l2, 0);
        SINT32 = k16;
        K1 k17 = new K1("SINT64", 17, l1, 0);
        SINT64 = k17;
        $VALUES = new K1[]{k1, k2, k3, k4, k5, k6, k7, k8, g1, k9, k10, k11, k12, k13, k14, k15, k16, k17};
    }

    public K1(String str, int i, L1 l1, int i2) {
        super(str, i);
        this.javaType = l1;
        this.wireType = i2;
    }

    public static K1 valueOf(String str) {
        return (K1) Enum.valueOf(K1.class, str);
    }

    public static K1[] values() {
        return (K1[]) $VALUES.clone();
    }

    public final L1 a() {
        return this.javaType;
    }

    public final int b() {
        return this.wireType;
    }

    public boolean c() {
        return !(this instanceof G1);
    }

    public K1(String str, int i, L1 l1, int i2, int i3) {
        super(str, i);
        this.javaType = l1;
        this.wireType = i2;
    }
}
