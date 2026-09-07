package com.fyber.inneractive.sdk.protobuf;

/* JADX WARN: Enum visitor error
java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.nodes.MethodNode.getBasicBlocks()" is null
	at jadx.core.dex.visitors.EnumVisitor.searchEnumSuperCtrInsn(EnumVisitor.java:495)
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:473)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes7.dex */
public abstract class P1 {
    private static final /* synthetic */ P1[] $VALUES;
    public static final P1 LAZY;
    public static final P1 LOOSE;
    public static final P1 STRICT;

    static {
        P1 p1 = new P1() { // from class: com.fyber.inneractive.sdk.protobuf.M1
            @Override // com.fyber.inneractive.sdk.protobuf.P1
            public final Object a(AbstractC3229w abstractC3229w) {
                return abstractC3229w.r();
            }
        };
        LOOSE = p1;
        P1 p2 = new P1() { // from class: com.fyber.inneractive.sdk.protobuf.N1
            @Override // com.fyber.inneractive.sdk.protobuf.P1
            public final Object a(AbstractC3229w abstractC3229w) {
                return abstractC3229w.s();
            }
        };
        STRICT = p2;
        P1 p3 = new P1() { // from class: com.fyber.inneractive.sdk.protobuf.O1
            @Override // com.fyber.inneractive.sdk.protobuf.P1
            public final Object a(AbstractC3229w abstractC3229w) {
                return abstractC3229w.e();
            }
        };
        LAZY = p3;
        $VALUES = new P1[]{p1, p2, p3};
    }

    public P1(String str, int i) {
        super(str, i);
    }

    public static P1 valueOf(String str) {
        return (P1) Enum.valueOf(P1.class, str);
    }

    public static P1[] values() {
        return (P1[]) $VALUES.clone();
    }

    public abstract Object a(AbstractC3229w abstractC3229w);
}
