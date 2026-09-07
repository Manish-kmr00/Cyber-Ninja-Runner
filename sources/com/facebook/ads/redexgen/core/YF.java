package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YF {
    public static String[] A0D = {"", "wScUV", "mKyFJeWmOw5k811irpszoAjpVz7lJJVu", "Jyh6NUhlEMtFWekSXiCXV1fRS8tliN7F", "XUB8B2rrjkftBBGo2gfG2YIZJStOjKV6", "6Kv93mQhESN", "v7QuScM1ODiJM8WtWQIOGshI3ULpOoAP", "l9uo"};
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public final InterfaceC1957Uo A0C;

    public YF(InterfaceC1957Uo interfaceC1957Uo) {
        this.A0C = interfaceC1957Uo;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void A00(int i) {
        if (this.A04 == -9223372036854775807L) {
            return;
        }
        boolean z = this.A0B;
        this.A0C.AI0(this.A04, z ? 1 : 0, (int) (this.A01 - this.A03), i, null);
    }

    public static boolean A01(int i) {
        return (32 <= i && i <= 35) || i == 39;
    }

    public static boolean A02(int i) {
        return i < 32 || i == 40;
    }

    public final void A03() {
        this.A07 = false;
        this.A06 = false;
        this.A05 = false;
        this.A0A = false;
        this.A09 = false;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0076  */
    public final void A04(long j, int i, int i2, long j2, boolean z) {
        boolean z2;
        this.A06 = false;
        this.A05 = false;
        this.A02 = j2;
        this.A00 = 0;
        this.A01 = j;
        if (!A02(i2)) {
            if (this.A0A && !this.A09) {
                if (z) {
                    A00(i);
                }
                this.A0A = false;
            }
            if (A01(i2)) {
                boolean z3 = this.A09;
                if (A0D[1].length() == 15) {
                    throw new RuntimeException();
                }
                A0D[0] = "";
                this.A05 = !z3;
                this.A09 = true;
            }
        }
        if (i2 < 16) {
            z2 = false;
        } else if (A0D[7].length() != 4) {
            A0D[7] = "ZdEW";
            if (i2 <= 21) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            A0D[0] = "";
            if (i2 <= 21) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        this.A08 = z2;
        this.A07 = this.A08 || i2 <= 9;
    }

    public final void A05(long j, int i, boolean z) {
        if (this.A09 && this.A06) {
            this.A0B = this.A08;
            this.A09 = false;
            return;
        }
        boolean z2 = this.A05;
        if (A0D[1].length() == 15) {
            throw new RuntimeException();
        }
        A0D[5] = "9fxAr7PUcEV";
        if (!z2 && !this.A06) {
            return;
        }
        if (z && this.A0A) {
            A00(i + ((int) (j - this.A01)));
        }
        this.A03 = this.A01;
        this.A04 = this.A02;
        this.A0B = this.A08;
        this.A0A = true;
    }

    public final void A06(byte[] bArr, int i, int i2) {
        if (this.A07) {
            int i3 = (i + 2) - this.A00;
            if (i3 < i2) {
                int headerOffset = bArr[i3];
                this.A06 = (headerOffset & 128) != 0;
                this.A07 = false;
                return;
            }
            this.A00 += i2 - i;
        }
    }
}
